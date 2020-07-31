package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class e {
    private final com.facebook.common.memory.a mRb;
    private boolean ncE;
    private int ncA = 0;
    private int ncz = 0;
    private int ncB = 0;
    private int ncD = 0;
    private int ncC = 0;
    private int ncy = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.mRb = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.ncy != 6 && eVar.getSize() > this.ncA) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.mRb.get(16384), this.mRb);
            try {
                com.facebook.common.util.c.a(fVar, this.ncA);
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
        int i = this.ncC;
        while (this.ncy != 6 && (read = inputStream.read()) != -1) {
            try {
                this.ncA++;
                if (this.ncE) {
                    this.ncy = 6;
                    this.ncE = false;
                    return false;
                }
                switch (this.ncy) {
                    case 0:
                        if (read == 255) {
                            this.ncy = 1;
                            break;
                        } else {
                            this.ncy = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.ncy = 2;
                            break;
                        } else {
                            this.ncy = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.ncy = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.ncy = 3;
                            break;
                        } else if (read == 0) {
                            this.ncy = 2;
                            break;
                        } else if (read == 217) {
                            this.ncE = true;
                            Ji(this.ncA - 2);
                            this.ncy = 2;
                            break;
                        } else {
                            if (read == 218) {
                                Ji(this.ncA - 2);
                            }
                            if (Jh(read)) {
                                this.ncy = 4;
                                break;
                            } else {
                                this.ncy = 2;
                                break;
                            }
                        }
                    case 4:
                        this.ncy = 5;
                        break;
                    case 5:
                        int i2 = ((this.ncz << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.ncA = i2 + this.ncA;
                        this.ncy = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.ncz = read;
            } catch (IOException e) {
                l.x(e);
            }
        }
        if (this.ncy == 6 || this.ncC == i) {
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
        if (this.ncB > 0) {
            this.ncD = i;
        }
        int i2 = this.ncB;
        this.ncB = i2 + 1;
        this.ncC = i2;
    }

    public int dId() {
        return this.ncD;
    }

    public int dIe() {
        return this.ncC;
    }

    public boolean dIf() {
        return this.ncE;
    }
}
