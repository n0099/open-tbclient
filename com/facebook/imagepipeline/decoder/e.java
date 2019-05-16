package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a jSq;
    private int kaN = 0;
    private int kaM = 0;
    private int kaO = 0;
    private int kaQ = 0;
    private int kaP = 0;
    private int kaL = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.jSq = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.kaL != 6 && dVar.getSize() > this.kaN) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.jSq.get(16384), this.jSq);
            try {
                com.facebook.common.util.c.a(fVar, this.kaN);
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
        int i = this.kaP;
        while (this.kaL != 6 && (read = inputStream.read()) != -1) {
            try {
                this.kaN++;
                switch (this.kaL) {
                    case 0:
                        if (read == 255) {
                            this.kaL = 1;
                            break;
                        } else {
                            this.kaL = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.kaL = 2;
                            break;
                        } else {
                            this.kaL = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.kaL = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.kaL = 3;
                            break;
                        } else if (read == 0) {
                            this.kaL = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                Dk(this.kaN - 2);
                            }
                            if (Dj(read)) {
                                this.kaL = 4;
                                break;
                            } else {
                                this.kaL = 2;
                                break;
                            }
                        }
                    case 4:
                        this.kaL = 5;
                        break;
                    case 5:
                        int i2 = ((this.kaM << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.kaN = i2 + this.kaN;
                        this.kaL = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.kaM = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.kaL == 6 || this.kaP == i) ? false : true;
    }

    private static boolean Dj(int i) {
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

    private void Dk(int i) {
        if (this.kaO > 0) {
            this.kaQ = i;
        }
        int i2 = this.kaO;
        this.kaO = i2 + 1;
        this.kaP = i2;
    }

    public int cGv() {
        return this.kaQ;
    }

    public int cGw() {
        return this.kaP;
    }
}
