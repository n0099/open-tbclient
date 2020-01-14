package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public class e {
    private final com.facebook.common.memory.a lHW;
    private boolean lTd;
    private int lSZ = 0;
    private int lSY = 0;
    private int lTa = 0;
    private int lTc = 0;
    private int lTb = 0;
    private int lSX = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.lHW = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.lSX != 6 && eVar.getSize() > this.lSZ) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.lHW.get(16384), this.lHW);
            try {
                com.facebook.common.util.c.a(fVar, this.lSZ);
                return w(fVar);
            } catch (IOException e) {
                l.u(e);
                return false;
            } finally {
                com.facebook.common.internal.b.r(fVar);
            }
        }
        return false;
    }

    private boolean w(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.lTb;
        while (this.lSX != 6 && (read = inputStream.read()) != -1) {
            try {
                this.lSZ++;
                if (this.lTd) {
                    this.lSX = 6;
                    this.lTd = false;
                    return false;
                }
                switch (this.lSX) {
                    case 0:
                        if (read == 255) {
                            this.lSX = 1;
                            break;
                        } else {
                            this.lSX = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.lSX = 2;
                            break;
                        } else {
                            this.lSX = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.lSX = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.lSX = 3;
                            break;
                        } else if (read == 0) {
                            this.lSX = 2;
                            break;
                        } else if (read == 217) {
                            this.lTd = true;
                            If(this.lSZ - 2);
                            this.lSX = 2;
                            break;
                        } else {
                            if (read == 218) {
                                If(this.lSZ - 2);
                            }
                            if (Ie(read)) {
                                this.lSX = 4;
                                break;
                            } else {
                                this.lSX = 2;
                                break;
                            }
                        }
                    case 4:
                        this.lSX = 5;
                        break;
                    case 5:
                        int i2 = ((this.lSY << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.lSZ = i2 + this.lSZ;
                        this.lSX = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.lSY = read;
            } catch (IOException e) {
                l.u(e);
            }
        }
        if (this.lSX == 6 || this.lTb == i) {
            z = false;
        }
        return z;
    }

    private static boolean Ie(int i) {
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

    private void If(int i) {
        if (this.lTa > 0) {
            this.lTc = i;
        }
        int i2 = this.lTa;
        this.lTa = i2 + 1;
        this.lTb = i2;
    }

    public int doX() {
        return this.lTc;
    }

    public int doY() {
        return this.lTb;
    }

    public boolean doZ() {
        return this.lTd;
    }
}
