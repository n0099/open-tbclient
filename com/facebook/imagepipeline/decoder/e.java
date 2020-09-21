package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes25.dex */
public class e {
    private boolean nGL;
    private final com.facebook.common.memory.a nvq;
    private int nGH = 0;
    private int nGG = 0;
    private int nGI = 0;
    private int nGK = 0;
    private int nGJ = 0;
    private int nGF = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.nvq = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.nGF != 6 && eVar.getSize() > this.nGH) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.nvq.get(16384), this.nvq);
            try {
                com.facebook.common.util.c.a(fVar, this.nGH);
                return u(fVar);
            } catch (IOException e) {
                l.v(e);
                return false;
            } finally {
                com.facebook.common.internal.b.p(fVar);
            }
        }
        return false;
    }

    private boolean u(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.nGJ;
        while (this.nGF != 6 && (read = inputStream.read()) != -1) {
            try {
                this.nGH++;
                if (this.nGL) {
                    this.nGF = 6;
                    this.nGL = false;
                    return false;
                }
                switch (this.nGF) {
                    case 0:
                        if (read == 255) {
                            this.nGF = 1;
                            break;
                        } else {
                            this.nGF = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.nGF = 2;
                            break;
                        } else {
                            this.nGF = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.nGF = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.nGF = 3;
                            break;
                        } else if (read == 0) {
                            this.nGF = 2;
                            break;
                        } else if (read == 217) {
                            this.nGL = true;
                            Mr(this.nGH - 2);
                            this.nGF = 2;
                            break;
                        } else {
                            if (read == 218) {
                                Mr(this.nGH - 2);
                            }
                            if (Mq(read)) {
                                this.nGF = 4;
                                break;
                            } else {
                                this.nGF = 2;
                                break;
                            }
                        }
                    case 4:
                        this.nGF = 5;
                        break;
                    case 5:
                        int i2 = ((this.nGG << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.nGH = i2 + this.nGH;
                        this.nGF = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.nGG = read;
            } catch (IOException e) {
                l.v(e);
            }
        }
        if (this.nGF == 6 || this.nGJ == i) {
            z = false;
        }
        return z;
    }

    private static boolean Mq(int i) {
        boolean z = true;
        if (i == 1) {
            return false;
        }
        if (i < 208 || i > 215) {
            if (i == 217 || i == 216) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private void Mr(int i) {
        if (this.nGI > 0) {
            this.nGK = i;
        }
        int i2 = this.nGI;
        this.nGI = i2 + 1;
        this.nGJ = i2;
    }

    public int dYk() {
        return this.nGK;
    }

    public int dYl() {
        return this.nGJ;
    }

    public boolean dYm() {
        return this.nGL;
    }
}
