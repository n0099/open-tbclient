package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class e {
    private boolean pEr;
    private final com.facebook.common.memory.a ptw;
    private int pEn = 0;
    private int pEm = 0;
    private int pEo = 0;
    private int pEq = 0;
    private int pEp = 0;
    private int pEl = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.ptw = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.e eVar) {
        if (this.pEl != 6 && eVar.getSize() > this.pEn) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.ptw.get(16384), this.ptw);
            try {
                com.facebook.common.util.c.b(fVar, this.pEn);
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
        int i = this.pEp;
        while (this.pEl != 6 && (read = inputStream.read()) != -1) {
            try {
                this.pEn++;
                if (this.pEr) {
                    this.pEl = 6;
                    this.pEr = false;
                    return false;
                }
                switch (this.pEl) {
                    case 0:
                        if (read == 255) {
                            this.pEl = 1;
                            break;
                        } else {
                            this.pEl = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.pEl = 2;
                            break;
                        } else {
                            this.pEl = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.pEl = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.pEl = 3;
                            break;
                        } else if (read == 0) {
                            this.pEl = 2;
                            break;
                        } else if (read == 217) {
                            this.pEr = true;
                            QW(this.pEn - 2);
                            this.pEl = 2;
                            break;
                        } else {
                            if (read == 218) {
                                QW(this.pEn - 2);
                            }
                            if (QV(read)) {
                                this.pEl = 4;
                                break;
                            } else {
                                this.pEl = 2;
                                break;
                            }
                        }
                    case 4:
                        this.pEl = 5;
                        break;
                    case 5:
                        int i2 = ((this.pEm << 8) + read) - 2;
                        com.facebook.common.util.c.b(inputStream, i2);
                        this.pEn = i2 + this.pEn;
                        this.pEl = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.pEm = read;
            } catch (IOException e) {
                l.t(e);
            }
        }
        if (this.pEl == 6 || this.pEp == i) {
            z = false;
        }
        return z;
    }

    private static boolean QV(int i) {
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

    private void QW(int i) {
        if (this.pEo > 0) {
            this.pEq = i;
        }
        int i2 = this.pEo;
        this.pEo = i2 + 1;
        this.pEp = i2;
    }

    public int ezz() {
        return this.pEq;
    }

    public int ezA() {
        return this.pEp;
    }

    public boolean ezB() {
        return this.pEr;
    }
}
