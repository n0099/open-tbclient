package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a jSu;
    private int kaR = 0;
    private int kaQ = 0;
    private int kaS = 0;
    private int kaU = 0;
    private int kaT = 0;
    private int kaP = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.jSu = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.kaP != 6 && dVar.getSize() > this.kaR) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.jSu.get(16384), this.jSu);
            try {
                com.facebook.common.util.c.a(fVar, this.kaR);
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
        int i = this.kaT;
        while (this.kaP != 6 && (read = inputStream.read()) != -1) {
            try {
                this.kaR++;
                switch (this.kaP) {
                    case 0:
                        if (read == 255) {
                            this.kaP = 1;
                            break;
                        } else {
                            this.kaP = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.kaP = 2;
                            break;
                        } else {
                            this.kaP = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.kaP = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.kaP = 3;
                            break;
                        } else if (read == 0) {
                            this.kaP = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                Dk(this.kaR - 2);
                            }
                            if (Dj(read)) {
                                this.kaP = 4;
                                break;
                            } else {
                                this.kaP = 2;
                                break;
                            }
                        }
                    case 4:
                        this.kaP = 5;
                        break;
                    case 5:
                        int i2 = ((this.kaQ << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.kaR = i2 + this.kaR;
                        this.kaP = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.kaQ = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.kaP == 6 || this.kaT == i) ? false : true;
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
        if (this.kaS > 0) {
            this.kaU = i;
        }
        int i2 = this.kaS;
        this.kaS = i2 + 1;
        this.kaT = i2;
    }

    public int cGw() {
        return this.kaU;
    }

    public int cGx() {
        return this.kaT;
    }
}
