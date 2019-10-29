package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a kbk;
    private int kjN = 0;
    private int kjM = 0;
    private int kjO = 0;
    private int kjQ = 0;
    private int kjP = 0;
    private int kjL = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.kbk = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.kjL != 6 && dVar.getSize() > this.kjN) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.kbk.get(16384), this.kbk);
            try {
                com.facebook.common.util.c.a(fVar, this.kjN);
                return s(fVar);
            } catch (IOException e) {
                k.q(e);
                return false;
            } finally {
                com.facebook.common.internal.b.n(fVar);
            }
        }
        return false;
    }

    private boolean s(InputStream inputStream) {
        int read;
        int i = this.kjP;
        while (this.kjL != 6 && (read = inputStream.read()) != -1) {
            try {
                this.kjN++;
                switch (this.kjL) {
                    case 0:
                        if (read == 255) {
                            this.kjL = 1;
                            break;
                        } else {
                            this.kjL = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.kjL = 2;
                            break;
                        } else {
                            this.kjL = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.kjL = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.kjL = 3;
                            break;
                        } else if (read == 0) {
                            this.kjL = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                Ct(this.kjN - 2);
                            }
                            if (Cs(read)) {
                                this.kjL = 4;
                                break;
                            } else {
                                this.kjL = 2;
                                break;
                            }
                        }
                    case 4:
                        this.kjL = 5;
                        break;
                    case 5:
                        int i2 = ((this.kjM << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.kjN = i2 + this.kjN;
                        this.kjL = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.kjM = read;
            } catch (IOException e) {
                k.q(e);
            }
        }
        return (this.kjL == 6 || this.kjP == i) ? false : true;
    }

    private static boolean Cs(int i) {
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

    private void Ct(int i) {
        if (this.kjO > 0) {
            this.kjQ = i;
        }
        int i2 = this.kjO;
        this.kjO = i2 + 1;
        this.kjP = i2;
    }

    public int cHF() {
        return this.kjQ;
    }

    public int cHG() {
        return this.kjP;
    }
}
