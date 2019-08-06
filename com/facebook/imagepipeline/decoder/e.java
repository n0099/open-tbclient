package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a kaE;
    private int kje = 0;
    private int kjd = 0;
    private int kjf = 0;
    private int kjh = 0;
    private int kjg = 0;
    private int kjc = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.kaE = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.kjc != 6 && dVar.getSize() > this.kje) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.kaE.get(16384), this.kaE);
            try {
                com.facebook.common.util.c.a(fVar, this.kje);
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
        int i = this.kjg;
        while (this.kjc != 6 && (read = inputStream.read()) != -1) {
            try {
                this.kje++;
                switch (this.kjc) {
                    case 0:
                        if (read == 255) {
                            this.kjc = 1;
                            break;
                        } else {
                            this.kjc = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.kjc = 2;
                            break;
                        } else {
                            this.kjc = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.kjc = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.kjc = 3;
                            break;
                        } else if (read == 0) {
                            this.kjc = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                DT(this.kje - 2);
                            }
                            if (DS(read)) {
                                this.kjc = 4;
                                break;
                            } else {
                                this.kjc = 2;
                                break;
                            }
                        }
                    case 4:
                        this.kjc = 5;
                        break;
                    case 5:
                        int i2 = ((this.kjd << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.kje = i2 + this.kje;
                        this.kjc = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.kjd = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.kjc == 6 || this.kjg == i) ? false : true;
    }

    private static boolean DS(int i) {
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

    private void DT(int i) {
        if (this.kjf > 0) {
            this.kjh = i;
        }
        int i2 = this.kjf;
        this.kjf = i2 + 1;
        this.kjg = i2;
    }

    public int cJU() {
        return this.kjh;
    }

    public int cJV() {
        return this.kjg;
    }
}
