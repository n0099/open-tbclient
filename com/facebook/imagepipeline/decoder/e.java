package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes15.dex */
public class e {
    private final com.facebook.common.memory.a oMZ;
    private boolean oYq;
    private int oYm = 0;
    private int oYl = 0;
    private int oYn = 0;
    private int oYp = 0;
    private int oYo = 0;
    private int oYk = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.oMZ = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.oYk != 6 && eVar.getSize() > this.oYm) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.oMZ.get(16384), this.oMZ);
            try {
                com.facebook.common.util.c.a(fVar, this.oYm);
                return v(fVar);
            } catch (IOException e) {
                l.v(e);
                return false;
            } finally {
                com.facebook.common.internal.b.q(fVar);
            }
        }
        return false;
    }

    private boolean v(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.oYo;
        while (this.oYk != 6 && (read = inputStream.read()) != -1) {
            try {
                this.oYm++;
                if (this.oYq) {
                    this.oYk = 6;
                    this.oYq = false;
                    return false;
                }
                switch (this.oYk) {
                    case 0:
                        if (read == 255) {
                            this.oYk = 1;
                            break;
                        } else {
                            this.oYk = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.oYk = 2;
                            break;
                        } else {
                            this.oYk = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.oYk = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.oYk = 3;
                            break;
                        } else if (read == 0) {
                            this.oYk = 2;
                            break;
                        } else if (read == 217) {
                            this.oYq = true;
                            PM(this.oYm - 2);
                            this.oYk = 2;
                            break;
                        } else {
                            if (read == 218) {
                                PM(this.oYm - 2);
                            }
                            if (PL(read)) {
                                this.oYk = 4;
                                break;
                            } else {
                                this.oYk = 2;
                                break;
                            }
                        }
                    case 4:
                        this.oYk = 5;
                        break;
                    case 5:
                        int i2 = ((this.oYl << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.oYm = i2 + this.oYm;
                        this.oYk = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.oYl = read;
            } catch (IOException e) {
                l.v(e);
            }
        }
        if (this.oYk == 6 || this.oYo == i) {
            z = false;
        }
        return z;
    }

    private static boolean PL(int i) {
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

    private void PM(int i) {
        if (this.oYn > 0) {
            this.oYp = i;
        }
        int i2 = this.oYn;
        this.oYn = i2 + 1;
        this.oYo = i2;
    }

    public int epI() {
        return this.oYp;
    }

    public int epJ() {
        return this.oYo;
    }

    public boolean epK() {
        return this.oYq;
    }
}
