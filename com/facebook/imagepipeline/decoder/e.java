package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a jzz;
    private int jHZ = 0;
    private int jHY = 0;
    private int jIa = 0;
    private int jIc = 0;
    private int jIb = 0;
    private int jHX = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.jzz = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.jHX != 6 && dVar.getSize() > this.jHZ) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.jzz.get(16384), this.jzz);
            try {
                com.facebook.common.util.c.a(fVar, this.jHZ);
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
        int i = this.jIb;
        while (this.jHX != 6 && (read = inputStream.read()) != -1) {
            try {
                this.jHZ++;
                switch (this.jHX) {
                    case 0:
                        if (read == 255) {
                            this.jHX = 1;
                            break;
                        } else {
                            this.jHX = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.jHX = 2;
                            break;
                        } else {
                            this.jHX = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.jHX = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.jHX = 3;
                            break;
                        } else if (read == 0) {
                            this.jHX = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                Cg(this.jHZ - 2);
                            }
                            if (Cf(read)) {
                                this.jHX = 4;
                                break;
                            } else {
                                this.jHX = 2;
                                break;
                            }
                        }
                    case 4:
                        this.jHX = 5;
                        break;
                    case 5:
                        int i2 = ((this.jHY << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.jHZ = i2 + this.jHZ;
                        this.jHX = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.jHY = read;
            } catch (IOException e) {
                k.s(e);
            }
        }
        return (this.jHX == 6 || this.jIb == i) ? false : true;
    }

    private static boolean Cf(int i) {
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

    private void Cg(int i) {
        if (this.jIa > 0) {
            this.jIc = i;
        }
        int i2 = this.jIa;
        this.jIa = i2 + 1;
        this.jIb = i2;
    }

    public int cyz() {
        return this.jIc;
    }

    public int cyA() {
        return this.jIb;
    }
}
