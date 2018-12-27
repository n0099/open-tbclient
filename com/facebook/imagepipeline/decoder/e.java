package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a ijk;
    private int irD = 0;
    private int irC = 0;
    private int irE = 0;
    private int irG = 0;
    private int irF = 0;
    private int irB = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.ijk = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.irB != 6 && dVar.getSize() > this.irD) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.ijk.get(16384), this.ijk);
            try {
                com.facebook.common.util.c.a(fVar, this.irD);
                return t(fVar);
            } catch (IOException e) {
                k.r(e);
                return false;
            } finally {
                com.facebook.common.internal.b.o(fVar);
            }
        }
        return false;
    }

    private boolean t(InputStream inputStream) {
        int read;
        int i = this.irF;
        while (this.irB != 6 && (read = inputStream.read()) != -1) {
            try {
                this.irD++;
                switch (this.irB) {
                    case 0:
                        if (read == 255) {
                            this.irB = 1;
                            break;
                        } else {
                            this.irB = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.irB = 2;
                            break;
                        } else {
                            this.irB = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.irB = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.irB = 3;
                            break;
                        } else if (read == 0) {
                            this.irB = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                yB(this.irD - 2);
                            }
                            if (yA(read)) {
                                this.irB = 4;
                                break;
                            } else {
                                this.irB = 2;
                                break;
                            }
                        }
                    case 4:
                        this.irB = 5;
                        break;
                    case 5:
                        int i2 = ((this.irC << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.irD = i2 + this.irD;
                        this.irB = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.irC = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.irB == 6 || this.irF == i) ? false : true;
    }

    private static boolean yA(int i) {
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

    private void yB(int i) {
        if (this.irE > 0) {
            this.irG = i;
        }
        int i2 = this.irE;
        this.irE = i2 + 1;
        this.irF = i2;
    }

    public int bYG() {
        return this.irG;
    }

    public int bYH() {
        return this.irF;
    }
}
