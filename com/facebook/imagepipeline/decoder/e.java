package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a kdb;
    private int klB = 0;
    private int klA = 0;
    private int klC = 0;
    private int klE = 0;
    private int klD = 0;
    private int klz = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.kdb = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.klz != 6 && dVar.getSize() > this.klB) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.kdb.get(16384), this.kdb);
            try {
                com.facebook.common.util.c.a(fVar, this.klB);
                return v(fVar);
            } catch (IOException e) {
                k.r(e);
                return false;
            } finally {
                com.facebook.common.internal.b.q(fVar);
            }
        }
        return false;
    }

    private boolean v(InputStream inputStream) {
        int read;
        int i = this.klD;
        while (this.klz != 6 && (read = inputStream.read()) != -1) {
            try {
                this.klB++;
                switch (this.klz) {
                    case 0:
                        if (read == 255) {
                            this.klz = 1;
                            break;
                        } else {
                            this.klz = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.klz = 2;
                            break;
                        } else {
                            this.klz = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.klz = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.klz = 3;
                            break;
                        } else if (read == 0) {
                            this.klz = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                DX(this.klB - 2);
                            }
                            if (DW(read)) {
                                this.klz = 4;
                                break;
                            } else {
                                this.klz = 2;
                                break;
                            }
                        }
                    case 4:
                        this.klz = 5;
                        break;
                    case 5:
                        int i2 = ((this.klA << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.klB = i2 + this.klB;
                        this.klz = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.klA = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.klz == 6 || this.klD == i) ? false : true;
    }

    private static boolean DW(int i) {
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

    private void DX(int i) {
        if (this.klC > 0) {
            this.klE = i;
        }
        int i2 = this.klC;
        this.klC = i2 + 1;
        this.klD = i2;
    }

    public int cKI() {
        return this.klE;
    }

    public int cKJ() {
        return this.klD;
    }
}
