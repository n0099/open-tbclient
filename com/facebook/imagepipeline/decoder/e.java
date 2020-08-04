package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class e {
    private final com.facebook.common.memory.a mRe;
    private boolean ncG;
    private int ncC = 0;
    private int ncB = 0;
    private int ncD = 0;
    private int ncF = 0;
    private int ncE = 0;
    private int ncA = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.mRe = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.ncA != 6 && eVar.getSize() > this.ncC) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.mRe.get(16384), this.mRe);
            try {
                com.facebook.common.util.c.a(fVar, this.ncC);
                return t(fVar);
            } catch (IOException e) {
                l.x(e);
                return false;
            } finally {
                com.facebook.common.internal.b.o(fVar);
            }
        }
        return false;
    }

    private boolean t(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.ncE;
        while (this.ncA != 6 && (read = inputStream.read()) != -1) {
            try {
                this.ncC++;
                if (this.ncG) {
                    this.ncA = 6;
                    this.ncG = false;
                    return false;
                }
                switch (this.ncA) {
                    case 0:
                        if (read == 255) {
                            this.ncA = 1;
                            break;
                        } else {
                            this.ncA = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.ncA = 2;
                            break;
                        } else {
                            this.ncA = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.ncA = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.ncA = 3;
                            break;
                        } else if (read == 0) {
                            this.ncA = 2;
                            break;
                        } else if (read == 217) {
                            this.ncG = true;
                            Ji(this.ncC - 2);
                            this.ncA = 2;
                            break;
                        } else {
                            if (read == 218) {
                                Ji(this.ncC - 2);
                            }
                            if (Jh(read)) {
                                this.ncA = 4;
                                break;
                            } else {
                                this.ncA = 2;
                                break;
                            }
                        }
                    case 4:
                        this.ncA = 5;
                        break;
                    case 5:
                        int i2 = ((this.ncB << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.ncC = i2 + this.ncC;
                        this.ncA = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.ncB = read;
            } catch (IOException e) {
                l.x(e);
            }
        }
        if (this.ncA == 6 || this.ncE == i) {
            z = false;
        }
        return z;
    }

    private static boolean Jh(int i) {
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

    private void Ji(int i) {
        if (this.ncD > 0) {
            this.ncF = i;
        }
        int i2 = this.ncD;
        this.ncD = i2 + 1;
        this.ncE = i2;
    }

    public int dIe() {
        return this.ncF;
    }

    public int dIf() {
        return this.ncE;
    }

    public boolean dIg() {
        return this.ncG;
    }
}
