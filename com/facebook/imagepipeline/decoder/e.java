package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class e {
    private boolean pJZ;
    private final com.facebook.common.memory.a pze;
    private int pJV = 0;
    private int pJU = 0;
    private int pJW = 0;
    private int pJY = 0;
    private int pJX = 0;
    private int pJT = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.pze = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.e eVar) {
        if (this.pJT != 6 && eVar.getSize() > this.pJV) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.pze.get(16384), this.pze);
            try {
                com.facebook.common.util.c.b(fVar, this.pJV);
                return w(fVar);
            } catch (IOException e) {
                l.s(e);
                return false;
            } finally {
                com.facebook.common.internal.b.r(fVar);
            }
        }
        return false;
    }

    private boolean w(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.pJX;
        while (this.pJT != 6 && (read = inputStream.read()) != -1) {
            try {
                this.pJV++;
                if (this.pJZ) {
                    this.pJT = 6;
                    this.pJZ = false;
                    return false;
                }
                switch (this.pJT) {
                    case 0:
                        if (read == 255) {
                            this.pJT = 1;
                            break;
                        } else {
                            this.pJT = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.pJT = 2;
                            break;
                        } else {
                            this.pJT = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.pJT = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.pJT = 3;
                            break;
                        } else if (read == 0) {
                            this.pJT = 2;
                            break;
                        } else if (read == 217) {
                            this.pJZ = true;
                            PK(this.pJV - 2);
                            this.pJT = 2;
                            break;
                        } else {
                            if (read == 218) {
                                PK(this.pJV - 2);
                            }
                            if (PJ(read)) {
                                this.pJT = 4;
                                break;
                            } else {
                                this.pJT = 2;
                                break;
                            }
                        }
                    case 4:
                        this.pJT = 5;
                        break;
                    case 5:
                        int i2 = ((this.pJU << 8) + read) - 2;
                        com.facebook.common.util.c.b(inputStream, i2);
                        this.pJV = i2 + this.pJV;
                        this.pJT = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.pJU = read;
            } catch (IOException e) {
                l.s(e);
            }
        }
        if (this.pJT == 6 || this.pJX == i) {
            z = false;
        }
        return z;
    }

    private static boolean PJ(int i) {
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

    private void PK(int i) {
        if (this.pJW > 0) {
            this.pJY = i;
        }
        int i2 = this.pJW;
        this.pJW = i2 + 1;
        this.pJX = i2;
    }

    public int eya() {
        return this.pJY;
    }

    public int eyb() {
        return this.pJX;
    }

    public boolean eyc() {
        return this.pJZ;
    }
}
