package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a iks;
    private int isL = 0;
    private int isK = 0;
    private int isM = 0;
    private int isO = 0;
    private int isN = 0;
    private int isJ = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.iks = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.isJ != 6 && dVar.getSize() > this.isL) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.iks.get(16384), this.iks);
            try {
                com.facebook.common.util.c.a(fVar, this.isL);
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
        int i = this.isN;
        while (this.isJ != 6 && (read = inputStream.read()) != -1) {
            try {
                this.isL++;
                switch (this.isJ) {
                    case 0:
                        if (read == 255) {
                            this.isJ = 1;
                            break;
                        } else {
                            this.isJ = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.isJ = 2;
                            break;
                        } else {
                            this.isJ = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.isJ = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.isJ = 3;
                            break;
                        } else if (read == 0) {
                            this.isJ = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                yD(this.isL - 2);
                            }
                            if (yC(read)) {
                                this.isJ = 4;
                                break;
                            } else {
                                this.isJ = 2;
                                break;
                            }
                        }
                    case 4:
                        this.isJ = 5;
                        break;
                    case 5:
                        int i2 = ((this.isK << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.isL = i2 + this.isL;
                        this.isJ = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.isK = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.isJ == 6 || this.isN == i) ? false : true;
    }

    private static boolean yC(int i) {
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

    private void yD(int i) {
        if (this.isM > 0) {
            this.isO = i;
        }
        int i2 = this.isM;
        this.isM = i2 + 1;
        this.isN = i2;
    }

    public int bZo() {
        return this.isO;
    }

    public int bZp() {
        return this.isN;
    }
}
