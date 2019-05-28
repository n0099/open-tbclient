package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a jSr;
    private int kaO = 0;
    private int kaN = 0;
    private int kaP = 0;
    private int kaR = 0;
    private int kaQ = 0;
    private int kaM = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.jSr = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.kaM != 6 && dVar.getSize() > this.kaO) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.jSr.get(16384), this.jSr);
            try {
                com.facebook.common.util.c.a(fVar, this.kaO);
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
        int i = this.kaQ;
        while (this.kaM != 6 && (read = inputStream.read()) != -1) {
            try {
                this.kaO++;
                switch (this.kaM) {
                    case 0:
                        if (read == 255) {
                            this.kaM = 1;
                            break;
                        } else {
                            this.kaM = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.kaM = 2;
                            break;
                        } else {
                            this.kaM = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.kaM = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.kaM = 3;
                            break;
                        } else if (read == 0) {
                            this.kaM = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                Dk(this.kaO - 2);
                            }
                            if (Dj(read)) {
                                this.kaM = 4;
                                break;
                            } else {
                                this.kaM = 2;
                                break;
                            }
                        }
                    case 4:
                        this.kaM = 5;
                        break;
                    case 5:
                        int i2 = ((this.kaN << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.kaO = i2 + this.kaO;
                        this.kaM = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.kaN = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.kaM == 6 || this.kaQ == i) ? false : true;
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
        if (this.kaP > 0) {
            this.kaR = i;
        }
        int i2 = this.kaP;
        this.kaP = i2 + 1;
        this.kaQ = i2;
    }

    public int cGx() {
        return this.kaR;
    }

    public int cGy() {
        return this.kaQ;
    }
}
