package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class e {
    private final com.facebook.common.memory.a lEt;
    private boolean lPm;
    private int lPi = 0;
    private int lPh = 0;
    private int lPj = 0;
    private int lPl = 0;
    private int lPk = 0;
    private int lPg = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.lEt = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.lPg != 6 && eVar.getSize() > this.lPi) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.lEt.get(16384), this.lEt);
            try {
                com.facebook.common.util.c.a(fVar, this.lPi);
                return w(fVar);
            } catch (IOException e) {
                l.u(e);
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
        int i = this.lPk;
        while (this.lPg != 6 && (read = inputStream.read()) != -1) {
            try {
                this.lPi++;
                if (this.lPm) {
                    this.lPg = 6;
                    this.lPm = false;
                    return false;
                }
                switch (this.lPg) {
                    case 0:
                        if (read == 255) {
                            this.lPg = 1;
                            break;
                        } else {
                            this.lPg = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.lPg = 2;
                            break;
                        } else {
                            this.lPg = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.lPg = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.lPg = 3;
                            break;
                        } else if (read == 0) {
                            this.lPg = 2;
                            break;
                        } else if (read == 217) {
                            this.lPm = true;
                            HW(this.lPi - 2);
                            this.lPg = 2;
                            break;
                        } else {
                            if (read == 218) {
                                HW(this.lPi - 2);
                            }
                            if (HV(read)) {
                                this.lPg = 4;
                                break;
                            } else {
                                this.lPg = 2;
                                break;
                            }
                        }
                    case 4:
                        this.lPg = 5;
                        break;
                    case 5:
                        int i2 = ((this.lPh << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.lPi = i2 + this.lPi;
                        this.lPg = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.lPh = read;
            } catch (IOException e) {
                l.u(e);
            }
        }
        if (this.lPg == 6 || this.lPk == i) {
            z = false;
        }
        return z;
    }

    private static boolean HV(int i) {
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

    private void HW(int i) {
        if (this.lPj > 0) {
            this.lPl = i;
        }
        int i2 = this.lPj;
        this.lPj = i2 + 1;
        this.lPk = i2;
    }

    public int dnP() {
        return this.lPl;
    }

    public int dnQ() {
        return this.lPk;
    }

    public boolean dnR() {
        return this.lPm;
    }
}
