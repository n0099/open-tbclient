package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class e {
    private boolean pKz;
    private final com.facebook.common.memory.a pzE;
    private int pKv = 0;
    private int pKu = 0;
    private int pKw = 0;
    private int pKy = 0;
    private int pKx = 0;
    private int pKt = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.pzE = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.e eVar) {
        if (this.pKt != 6 && eVar.getSize() > this.pKv) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.pzE.get(16384), this.pzE);
            try {
                com.facebook.common.util.c.b(fVar, this.pKv);
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
        int i = this.pKx;
        while (this.pKt != 6 && (read = inputStream.read()) != -1) {
            try {
                this.pKv++;
                if (this.pKz) {
                    this.pKt = 6;
                    this.pKz = false;
                    return false;
                }
                switch (this.pKt) {
                    case 0:
                        if (read == 255) {
                            this.pKt = 1;
                            break;
                        } else {
                            this.pKt = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.pKt = 2;
                            break;
                        } else {
                            this.pKt = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.pKt = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.pKt = 3;
                            break;
                        } else if (read == 0) {
                            this.pKt = 2;
                            break;
                        } else if (read == 217) {
                            this.pKz = true;
                            PL(this.pKv - 2);
                            this.pKt = 2;
                            break;
                        } else {
                            if (read == 218) {
                                PL(this.pKv - 2);
                            }
                            if (PK(read)) {
                                this.pKt = 4;
                                break;
                            } else {
                                this.pKt = 2;
                                break;
                            }
                        }
                    case 4:
                        this.pKt = 5;
                        break;
                    case 5:
                        int i2 = ((this.pKu << 8) + read) - 2;
                        com.facebook.common.util.c.b(inputStream, i2);
                        this.pKv = i2 + this.pKv;
                        this.pKt = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.pKu = read;
            } catch (IOException e) {
                l.s(e);
            }
        }
        if (this.pKt == 6 || this.pKx == i) {
            z = false;
        }
        return z;
    }

    private static boolean PK(int i) {
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

    private void PL(int i) {
        if (this.pKw > 0) {
            this.pKy = i;
        }
        int i2 = this.pKw;
        this.pKw = i2 + 1;
        this.pKx = i2;
    }

    public int eyi() {
        return this.pKy;
    }

    public int eyj() {
        return this.pKx;
    }

    public boolean eyk() {
        return this.pKz;
    }
}
