package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a hXc;
    private int ifw = 0;
    private int ifv = 0;
    private int ifx = 0;
    private int ifz = 0;
    private int ify = 0;
    private int ifu = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.hXc = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.ifu != 6 && dVar.getSize() > this.ifw) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.hXc.get(16384), this.hXc);
            try {
                com.facebook.common.util.c.a(fVar, this.ifw);
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
        int i = this.ify;
        while (this.ifu != 6 && (read = inputStream.read()) != -1) {
            try {
                this.ifw++;
                switch (this.ifu) {
                    case 0:
                        if (read == 255) {
                            this.ifu = 1;
                            break;
                        } else {
                            this.ifu = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.ifu = 2;
                            break;
                        } else {
                            this.ifu = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.ifu = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.ifu = 3;
                            break;
                        } else if (read == 0) {
                            this.ifu = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                xy(this.ifw - 2);
                            }
                            if (xx(read)) {
                                this.ifu = 4;
                                break;
                            } else {
                                this.ifu = 2;
                                break;
                            }
                        }
                    case 4:
                        this.ifu = 5;
                        break;
                    case 5:
                        int i2 = ((this.ifv << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.ifw = i2 + this.ifw;
                        this.ifu = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.ifv = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.ifu == 6 || this.ify == i) ? false : true;
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
        if (this.ifx > 0) {
            this.ifz = i;
        }
        int i2 = this.ifx;
        this.ifx = i2 + 1;
        this.ify = i2;
    }

    public int bWp() {
        return this.ifz;
    }

    public int bWq() {
        return this.ify;
    }
}
