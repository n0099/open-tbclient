package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a hYN;
    private int ihh = 0;
    private int ihg = 0;
    private int ihi = 0;
    private int ihk = 0;
    private int ihj = 0;
    private int ihf = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.hYN = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.ihf != 6 && dVar.getSize() > this.ihh) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.hYN.get(16384), this.hYN);
            try {
                com.facebook.common.util.c.a(fVar, this.ihh);
                return s(fVar);
            } catch (IOException e) {
                k.r(e);
                return false;
            } finally {
                com.facebook.common.internal.b.n(fVar);
            }
        }
        return false;
    }

    private boolean s(InputStream inputStream) {
        int read;
        int i = this.ihj;
        while (this.ihf != 6 && (read = inputStream.read()) != -1) {
            try {
                this.ihh++;
                switch (this.ihf) {
                    case 0:
                        if (read == 255) {
                            this.ihf = 1;
                            break;
                        } else {
                            this.ihf = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.ihf = 2;
                            break;
                        } else {
                            this.ihf = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.ihf = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.ihf = 3;
                            break;
                        } else if (read == 0) {
                            this.ihf = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                xR(this.ihh - 2);
                            }
                            if (xQ(read)) {
                                this.ihf = 4;
                                break;
                            } else {
                                this.ihf = 2;
                                break;
                            }
                        }
                    case 4:
                        this.ihf = 5;
                        break;
                    case 5:
                        int i2 = ((this.ihg << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.ihh = i2 + this.ihh;
                        this.ihf = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.ihg = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.ihf == 6 || this.ihj == i) ? false : true;
    }

    private static boolean xQ(int i) {
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

    private void xR(int i) {
        if (this.ihi > 0) {
            this.ihk = i;
        }
        int i2 = this.ihi;
        this.ihi = i2 + 1;
        this.ihj = i2;
    }

    public int bVK() {
        return this.ihk;
    }

    public int bVL() {
        return this.ihj;
    }
}
