package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes18.dex */
public class e {
    private final com.facebook.common.memory.a nKJ;
    private boolean nWc;
    private int nVY = 0;
    private int nVX = 0;
    private int nVZ = 0;
    private int nWb = 0;
    private int nWa = 0;
    private int nVW = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.nKJ = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.nVW != 6 && eVar.getSize() > this.nVY) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.nKJ.get(16384), this.nKJ);
            try {
                com.facebook.common.util.c.a(fVar, this.nVY);
                return v(fVar);
            } catch (IOException e) {
                l.v(e);
                return false;
            } finally {
                com.facebook.common.internal.b.q(fVar);
            }
        }
        return false;
    }

    private boolean v(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.nWa;
        while (this.nVW != 6 && (read = inputStream.read()) != -1) {
            try {
                this.nVY++;
                if (this.nWc) {
                    this.nVW = 6;
                    this.nWc = false;
                    return false;
                }
                switch (this.nVW) {
                    case 0:
                        if (read == 255) {
                            this.nVW = 1;
                            break;
                        } else {
                            this.nVW = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.nVW = 2;
                            break;
                        } else {
                            this.nVW = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.nVW = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.nVW = 3;
                            break;
                        } else if (read == 0) {
                            this.nVW = 2;
                            break;
                        } else if (read == 217) {
                            this.nWc = true;
                            MX(this.nVY - 2);
                            this.nVW = 2;
                            break;
                        } else {
                            if (read == 218) {
                                MX(this.nVY - 2);
                            }
                            if (MW(read)) {
                                this.nVW = 4;
                                break;
                            } else {
                                this.nVW = 2;
                                break;
                            }
                        }
                    case 4:
                        this.nVW = 5;
                        break;
                    case 5:
                        int i2 = ((this.nVX << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.nVY = i2 + this.nVY;
                        this.nVW = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.nVX = read;
            } catch (IOException e) {
                l.v(e);
            }
        }
        if (this.nVW == 6 || this.nWa == i) {
            z = false;
        }
        return z;
    }

    private static boolean MW(int i) {
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

    private void MX(int i) {
        if (this.nVZ > 0) {
            this.nWb = i;
        }
        int i2 = this.nVZ;
        this.nVZ = i2 + 1;
        this.nWa = i2;
    }

    public int ebV() {
        return this.nWb;
    }

    public int ebW() {
        return this.nWa;
    }

    public boolean ebX() {
        return this.nWc;
    }
}
