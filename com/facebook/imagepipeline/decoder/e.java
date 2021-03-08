package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class e {
    private final com.facebook.common.memory.a pBJ;
    private boolean pME;
    private int pMA = 0;
    private int pMz = 0;
    private int pMB = 0;
    private int pMD = 0;
    private int pMC = 0;
    private int pMy = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.pBJ = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.e eVar) {
        if (this.pMy != 6 && eVar.getSize() > this.pMA) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.pBJ.get(16384), this.pBJ);
            try {
                com.facebook.common.util.c.b(fVar, this.pMA);
                return w(fVar);
            } catch (IOException e) {
                l.s(e);
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
        int i = this.pMC;
        while (this.pMy != 6 && (read = inputStream.read()) != -1) {
            try {
                this.pMA++;
                if (this.pME) {
                    this.pMy = 6;
                    this.pME = false;
                    return false;
                }
                switch (this.pMy) {
                    case 0:
                        if (read == 255) {
                            this.pMy = 1;
                            break;
                        } else {
                            this.pMy = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.pMy = 2;
                            break;
                        } else {
                            this.pMy = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.pMy = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.pMy = 3;
                            break;
                        } else if (read == 0) {
                            this.pMy = 2;
                            break;
                        } else if (read == 217) {
                            this.pME = true;
                            PP(this.pMA - 2);
                            this.pMy = 2;
                            break;
                        } else {
                            if (read == 218) {
                                PP(this.pMA - 2);
                            }
                            if (PO(read)) {
                                this.pMy = 4;
                                break;
                            } else {
                                this.pMy = 2;
                                break;
                            }
                        }
                    case 4:
                        this.pMy = 5;
                        break;
                    case 5:
                        int i2 = ((this.pMz << 8) + read) - 2;
                        com.facebook.common.util.c.b(inputStream, i2);
                        this.pMA = i2 + this.pMA;
                        this.pMy = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.pMz = read;
            } catch (IOException e) {
                l.s(e);
            }
        }
        if (this.pMy == 6 || this.pMC == i) {
            z = false;
        }
        return z;
    }

    private static boolean PO(int i) {
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

    private void PP(int i) {
        if (this.pMB > 0) {
            this.pMD = i;
        }
        int i2 = this.pMB;
        this.pMB = i2 + 1;
        this.pMC = i2;
    }

    public int eyr() {
        return this.pMD;
    }

    public int eys() {
        return this.pMC;
    }

    public boolean eyt() {
        return this.pME;
    }
}
