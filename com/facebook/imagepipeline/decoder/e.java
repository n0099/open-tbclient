package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public class e {
    private final com.facebook.common.memory.a lHR;
    private boolean lSY;
    private int lSU = 0;
    private int lST = 0;
    private int lSV = 0;
    private int lSX = 0;
    private int lSW = 0;
    private int lSS = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.lHR = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.lSS != 6 && eVar.getSize() > this.lSU) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.lHR.get(16384), this.lHR);
            try {
                com.facebook.common.util.c.a(fVar, this.lSU);
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
        int i = this.lSW;
        while (this.lSS != 6 && (read = inputStream.read()) != -1) {
            try {
                this.lSU++;
                if (this.lSY) {
                    this.lSS = 6;
                    this.lSY = false;
                    return false;
                }
                switch (this.lSS) {
                    case 0:
                        if (read == 255) {
                            this.lSS = 1;
                            break;
                        } else {
                            this.lSS = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.lSS = 2;
                            break;
                        } else {
                            this.lSS = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.lSS = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.lSS = 3;
                            break;
                        } else if (read == 0) {
                            this.lSS = 2;
                            break;
                        } else if (read == 217) {
                            this.lSY = true;
                            If(this.lSU - 2);
                            this.lSS = 2;
                            break;
                        } else {
                            if (read == 218) {
                                If(this.lSU - 2);
                            }
                            if (Ie(read)) {
                                this.lSS = 4;
                                break;
                            } else {
                                this.lSS = 2;
                                break;
                            }
                        }
                    case 4:
                        this.lSS = 5;
                        break;
                    case 5:
                        int i2 = ((this.lST << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.lSU = i2 + this.lSU;
                        this.lSS = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.lST = read;
            } catch (IOException e) {
                l.u(e);
            }
        }
        if (this.lSS == 6 || this.lSW == i) {
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
        if (this.lSV > 0) {
            this.lSX = i;
        }
        int i2 = this.lSV;
        this.lSV = i2 + 1;
        this.lSW = i2;
    }

    public int doV() {
        return this.lSX;
    }

    public int doW() {
        return this.lSW;
    }

    public boolean doX() {
        return this.lSY;
    }
}
