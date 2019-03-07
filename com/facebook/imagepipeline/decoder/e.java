package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a jzU;
    private int jIu = 0;
    private int jIt = 0;
    private int jIv = 0;
    private int jIx = 0;
    private int jIw = 0;
    private int jIs = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.jzU = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.jIs != 6 && dVar.getSize() > this.jIu) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.jzU.get(16384), this.jzU);
            try {
                com.facebook.common.util.c.a(fVar, this.jIu);
                return v(fVar);
            } catch (IOException e) {
                k.s(e);
                return false;
            } finally {
                com.facebook.common.internal.b.q(fVar);
            }
        }
        return false;
    }

    private boolean v(InputStream inputStream) {
        int read;
        int i = this.jIw;
        while (this.jIs != 6 && (read = inputStream.read()) != -1) {
            try {
                this.jIu++;
                switch (this.jIs) {
                    case 0:
                        if (read == 255) {
                            this.jIs = 1;
                            break;
                        } else {
                            this.jIs = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.jIs = 2;
                            break;
                        } else {
                            this.jIs = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.jIs = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.jIs = 3;
                            break;
                        } else if (read == 0) {
                            this.jIs = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                Cp(this.jIu - 2);
                            }
                            if (Co(read)) {
                                this.jIs = 4;
                                break;
                            } else {
                                this.jIs = 2;
                                break;
                            }
                        }
                    case 4:
                        this.jIs = 5;
                        break;
                    case 5:
                        int i2 = ((this.jIt << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.jIu = i2 + this.jIu;
                        this.jIs = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.jIt = read;
            } catch (IOException e) {
                k.s(e);
            }
        }
        return (this.jIs == 6 || this.jIw == i) ? false : true;
    }

    private static boolean Co(int i) {
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

    private void Cp(int i) {
        if (this.jIv > 0) {
            this.jIx = i;
        }
        int i2 = this.jIv;
        this.jIv = i2 + 1;
        this.jIw = i2;
    }

    public int cyt() {
        return this.jIx;
    }

    public int cyu() {
        return this.jIw;
    }
}
