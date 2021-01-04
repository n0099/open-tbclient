package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class e {
    private boolean pCK;
    private final com.facebook.common.memory.a pto;
    private int pCG = 0;
    private int pCF = 0;
    private int pCH = 0;
    private int pCJ = 0;
    private int pCI = 0;
    private int pCE = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.pto = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.e eVar) {
        if (this.pCE != 6 && eVar.getSize() > this.pCG) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.pto.get(16384), this.pto);
            try {
                com.facebook.common.util.c.b(fVar, this.pCG);
                return z(fVar);
            } catch (IOException e) {
                l.t(e);
                return false;
            } finally {
                com.facebook.common.internal.b.u(fVar);
            }
        }
        return false;
    }

    private boolean z(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.pCI;
        while (this.pCE != 6 && (read = inputStream.read()) != -1) {
            try {
                this.pCG++;
                if (this.pCK) {
                    this.pCE = 6;
                    this.pCK = false;
                    return false;
                }
                switch (this.pCE) {
                    case 0:
                        if (read == 255) {
                            this.pCE = 1;
                            break;
                        } else {
                            this.pCE = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.pCE = 2;
                            break;
                        } else {
                            this.pCE = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.pCE = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.pCE = 3;
                            break;
                        } else if (read == 0) {
                            this.pCE = 2;
                            break;
                        } else if (read == 217) {
                            this.pCK = true;
                            QF(this.pCG - 2);
                            this.pCE = 2;
                            break;
                        } else {
                            if (read == 218) {
                                QF(this.pCG - 2);
                            }
                            if (QE(read)) {
                                this.pCE = 4;
                                break;
                            } else {
                                this.pCE = 2;
                                break;
                            }
                        }
                    case 4:
                        this.pCE = 5;
                        break;
                    case 5:
                        int i2 = ((this.pCF << 8) + read) - 2;
                        com.facebook.common.util.c.b(inputStream, i2);
                        this.pCG = i2 + this.pCG;
                        this.pCE = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.pCF = read;
            } catch (IOException e) {
                l.t(e);
            }
        }
        if (this.pCE == 6 || this.pCI == i) {
            z = false;
        }
        return z;
    }

    private static boolean QE(int i) {
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

    private void QF(int i) {
        if (this.pCH > 0) {
            this.pCJ = i;
        }
        int i2 = this.pCH;
        this.pCH = i2 + 1;
        this.pCI = i2;
    }

    public int eyX() {
        return this.pCJ;
    }

    public int eyY() {
        return this.pCI;
    }

    public boolean eyZ() {
        return this.pCK;
    }
}
