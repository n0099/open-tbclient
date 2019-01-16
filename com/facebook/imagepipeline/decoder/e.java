package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a ikr;
    private int isK = 0;
    private int isJ = 0;
    private int isL = 0;
    private int isN = 0;
    private int isM = 0;
    private int isI = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.ikr = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.isI != 6 && dVar.getSize() > this.isK) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.ikr.get(16384), this.ikr);
            try {
                com.facebook.common.util.c.a(fVar, this.isK);
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
        int i = this.isM;
        while (this.isI != 6 && (read = inputStream.read()) != -1) {
            try {
                this.isK++;
                switch (this.isI) {
                    case 0:
                        if (read == 255) {
                            this.isI = 1;
                            break;
                        } else {
                            this.isI = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.isI = 2;
                            break;
                        } else {
                            this.isI = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.isI = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.isI = 3;
                            break;
                        } else if (read == 0) {
                            this.isI = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                yD(this.isK - 2);
                            }
                            if (yC(read)) {
                                this.isI = 4;
                                break;
                            } else {
                                this.isI = 2;
                                break;
                            }
                        }
                    case 4:
                        this.isI = 5;
                        break;
                    case 5:
                        int i2 = ((this.isJ << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.isK = i2 + this.isK;
                        this.isI = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.isJ = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.isI == 6 || this.isM == i) ? false : true;
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
        if (this.isL > 0) {
            this.isN = i;
        }
        int i2 = this.isL;
        this.isL = i2 + 1;
        this.isM = i2;
    }

    public int bZo() {
        return this.isN;
    }

    public int bZp() {
        return this.isM;
    }
}
