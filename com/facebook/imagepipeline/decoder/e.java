package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class e {
    private final com.facebook.common.memory.a mmW;
    private boolean myt;
    private int myp = 0;
    private int myo = 0;
    private int myq = 0;
    private int mys = 0;
    private int myr = 0;
    private int myn = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.mmW = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.myn != 6 && eVar.getSize() > this.myp) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.mmW.get(16384), this.mmW);
            try {
                com.facebook.common.util.c.a(fVar, this.myp);
                return u(fVar);
            } catch (IOException e) {
                l.y(e);
                return false;
            } finally {
                com.facebook.common.internal.b.p(fVar);
            }
        }
        return false;
    }

    private boolean u(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.myr;
        while (this.myn != 6 && (read = inputStream.read()) != -1) {
            try {
                this.myp++;
                if (this.myt) {
                    this.myn = 6;
                    this.myt = false;
                    return false;
                }
                switch (this.myn) {
                    case 0:
                        if (read == 255) {
                            this.myn = 1;
                            break;
                        } else {
                            this.myn = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.myn = 2;
                            break;
                        } else {
                            this.myn = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.myn = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.myn = 3;
                            break;
                        } else if (read == 0) {
                            this.myn = 2;
                            break;
                        } else if (read == 217) {
                            this.myt = true;
                            HG(this.myp - 2);
                            this.myn = 2;
                            break;
                        } else {
                            if (read == 218) {
                                HG(this.myp - 2);
                            }
                            if (HF(read)) {
                                this.myn = 4;
                                break;
                            } else {
                                this.myn = 2;
                                break;
                            }
                        }
                    case 4:
                        this.myn = 5;
                        break;
                    case 5:
                        int i2 = ((this.myo << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.myp = i2 + this.myp;
                        this.myn = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.myo = read;
            } catch (IOException e) {
                l.y(e);
            }
        }
        if (this.myn == 6 || this.myr == i) {
            z = false;
        }
        return z;
    }

    private static boolean HF(int i) {
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

    private void HG(int i) {
        if (this.myq > 0) {
            this.mys = i;
        }
        int i2 = this.myq;
        this.myq = i2 + 1;
        this.myr = i2;
    }

    public int dAl() {
        return this.mys;
    }

    public int dAm() {
        return this.myr;
    }

    public boolean dAn() {
        return this.myt;
    }
}
