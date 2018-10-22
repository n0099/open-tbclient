package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a hXd;
    private int ifx = 0;
    private int ifw = 0;
    private int ify = 0;
    private int ifA = 0;
    private int ifz = 0;
    private int ifv = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.hXd = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.ifv != 6 && dVar.getSize() > this.ifx) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.hXd.get(16384), this.hXd);
            try {
                com.facebook.common.util.c.a(fVar, this.ifx);
                return s(fVar);
            } catch (IOException e) {
                k.r(e);
                return false;
            } finally {
                com.facebook.common.internal.b.n(fVar);
            }
        }
        return false;
    }

    private boolean s(InputStream inputStream) {
        int read;
        int i = this.ifz;
        while (this.ifv != 6 && (read = inputStream.read()) != -1) {
            try {
                this.ifx++;
                switch (this.ifv) {
                    case 0:
                        if (read == 255) {
                            this.ifv = 1;
                            break;
                        } else {
                            this.ifv = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.ifv = 2;
                            break;
                        } else {
                            this.ifv = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.ifv = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.ifv = 3;
                            break;
                        } else if (read == 0) {
                            this.ifv = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                xy(this.ifx - 2);
                            }
                            if (xx(read)) {
                                this.ifv = 4;
                                break;
                            } else {
                                this.ifv = 2;
                                break;
                            }
                        }
                    case 4:
                        this.ifv = 5;
                        break;
                    case 5:
                        int i2 = ((this.ifw << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.ifx = i2 + this.ifx;
                        this.ifv = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.ifw = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.ifv == 6 || this.ifz == i) ? false : true;
    }

    private static boolean xx(int i) {
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

    private void xy(int i) {
        if (this.ify > 0) {
            this.ifA = i;
        }
        int i2 = this.ify;
        this.ify = i2 + 1;
        this.ifz = i2;
    }

    public int bWp() {
        return this.ifA;
    }

    public int bWq() {
        return this.ifz;
    }
}
