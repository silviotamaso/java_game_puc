// ainda não testado. Apenas decompilei e guardei.

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class puc extends Applet implements Runnable {
  protected Thread mt;
  
  protected Graphics gr;
  
  protected Image simg;
  
  protected int dr;
  
  protected int largura;
  
  protected int altura;
  
  protected int m = 100;
  
  protected Dimension di;
  
  protected int st = 2;
  
  protected int hor2;
  
  protected int hor3;
  
  protected int pontos;
  
  protected int a;
  
  protected int camisa = 1;
  
  protected int apa;
  
  protected short ve;
  
  protected short hor;
  
  protected short k;
  
  protected String dados;
  
  private Image i1;
  
  private Image i2;
  
  private Image i3;
  
  private Image i4;
  
  private Image i5;
  
  private Image i6;
  
  private Image i7;
  
  protected boolean inicio = true;
  
  public void init() {
    this.i1 = getImage(getCodeBase(), "cam1.gif");
    this.i2 = getImage(getCodeBase(), "cam2.gif");
    this.i3 = getImage(getCodeBase(), "cam3.gif");
    this.i4 = getImage(getCodeBase(), "bg.gif");
    this.i5 = getImage(getCodeBase(), "ces.gif");
    this.i6 = getImage(getCodeBase(), "mac1.gif");
    this.i7 = getImage(getCodeBase(), "mac2.gif");
    this.di = size();
    this.largura = this.di.width;
    this.altura = this.di.height;
    resize(this.largura, this.altura);
    this.simg = createImage(this.largura, this.altura);
    this.gr = this.simg.getGraphics();
    this.dr = 65;
    this.m = 100;
    this.pontos = 0;
    this.a = 5;
    this.hor3 = 200;
    this.apa = 1;
  }
  
  public void update(Graphics g) {
    this.gr.drawImage(this.i4, -500, -500, this);
    this.gr.drawImage(this.i6, -500, -500, this);
    this.gr.drawImage(this.i7, -500, -500, this);
    this.gr.drawImage(this.i1, -500, -500, this);
    this.gr.drawImage(this.i2, -500, -500, this);
    this.gr.drawImage(this.i3, -500, -500, this);
    this.gr.drawImage(this.i5, -500, -500, this);
    if (this.st == 1) {
      if (this.m == 75) {
        this.camisa = (int)(Math.random() * 3.0D);
        this.hor2 = (int)(Math.random() * 190.0D);
        this.hor3 = this.hor2 + 70;
        this.a++;
      } 
      this.m += this.a;
      if (this.m >= 280) {
        if (this.hor3 - this.hor <= 30 && this.hor3 - this.hor >= -30) {
          this.pontos++;
        } else {
          this.st = 2;
        } 
        this.m = 75;
      } 
      if (this.m < 125) {
        this.gr.drawImage(this.i6, this.hor3, 26, this);
      } else {
        this.gr.drawImage(this.i7, this.hor3, 26, this);
      } 
      if (this.camisa == 0)
        this.gr.drawImage(this.i1, this.hor3, this.m, this); 
      if (this.camisa == 1)
        this.gr.drawImage(this.i2, this.hor3, this.m, this); 
      if (this.camisa == 2)
        this.gr.drawImage(this.i3, this.hor3, this.m, this); 
      this.gr.drawImage(this.i5, this.hor - 20, 281, this);
    } 
    if (this.st == 2) {
      this.dr = 250;
      this.hor2 = (int)(Math.random() * 190.0D);
      this.hor3 = this.hor2 + 70;
      this.gr.drawImage(this.i6, this.hor3, 26, this);
      if (this.inicio) {
        this.gr.drawString("Tente pegar as camisetas que o macaquinho est\u00E1", 42, 160);
        this.gr.drawString("jogando movendo a cestinha da PUC com seu mouse.", 32, 180);
        this.gr.drawString("Boa sorte!", 157, 220);
      } else {
        this.gr.drawString("Voc\u00EA pegou " + this.pontos + " camiseta(s).", 115, 180);
        this.gr.drawString("Jogue de novo e veja se consegue pegar mais!", 55, 200);
      } 
      if (this.apa == 1) {
        this.gr.setColor(Color.red);
        this.gr.drawString("CLIQUE AQUI PARA JOGAR", 110, 270);
        this.apa = 0;
      } else {
        this.apa = 1;
      } 
    } 
    this.gr.setFont(new Font("Arial", 0, 12));
    this.gr.setColor(Color.blue);
    this.gr.drawString("camisetas: " + this.pontos, 65, 20);
    this.gr.setFont(new Font("Arial", 0, 8));
    Color x = new Color(230,230,23);
    this.gr.setColor(Color.lightGray);
    this.gr.drawString("s t a t o s . c o m", 1, 298);
    this.gr.setFont(new Font("Arial", 0, 12));
    this.gr.setColor(Color.blue);
    g.drawImage(this.simg, 0, 0, this);
    this.gr.drawImage(this.simg, 0, 0, null);
    this.gr.drawImage(this.i4, 0, 0, this);
  }
  
  public boolean handleEvent(Event evt) {
    switch (evt.id) {
      case 504:
        showStatus(getAppletInfo());
        return true;
      case 505:
        showStatus("");
        return true;
    } 
    return super.handleEvent(evt);
  }
  
  public boolean mouseDown(Event evt, int x, int y) {
    if (this.hor <= 220 && this.hor >= 170 && this.ve <= 290 && this.ve >= 250) {
      this.inicio = false;
      this.st = 1;
      init();
    } 
    return true;
  }
  
  public void run() {
    while (this.mt != null) {
      repaint();
      try {
        Thread.sleep(this.dr);
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  public void paint(Graphics g) {
    update(g);
  }
  
  public void stop() {
    if (this.mt != null) {
      this.mt.stop();
      this.mt = null;
    } 
  }
  
  public void start() {
    if (this.mt == null) {
      this.mt = new Thread(this);
      this.mt.start();
    } 
  }
  
  public String getAppletInfo() {
    return "Statos.com";
  }
  
  public boolean mouseMove(Event evt, int x, int y) {
    this.ve = (short)y;
    this.hor = (short)x;
    return true;
  }
}
