package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a jzA;
    private int jIa = 0;
    private int jHZ = 0;
    private int jIb = 0;
    private int jId = 0;
    private int jIc = 0;
    private int jHY = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.jzA = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.jHY != 6 && dVar.getSize() > this.jIa) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.jzA.get(16384), this.jzA);
            try {
                com.facebook.common.util.c.a(fVar, this.jIa);
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
        int i = this.jIc;
        while (this.jHY != 6 && (read = inputStream.read()) != -1) {
            try {
                this.jIa++;
                switch (this.jHY) {
                    case 0:
                        if (read == 255) {
                            this.jHY = 1;
                            break;
                        } else {
                            this.jHY = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.jHY = 2;
                            break;
                        } else {
                            this.jHY = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.jHY = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.jHY = 3;
                            break;
                        } else if (read == 0) {
                            this.jHY = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                Cg(this.jIa - 2);
                            }
                            if (Cf(read)) {
                                this.jHY = 4;
                                break;
                            } else {
                                this.jHY = 2;
                                break;
                            }
                        }
                    case 4:
                        this.jHY = 5;
                        break;
                    case 5:
                        int i2 = ((this.jHZ << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.jIa = i2 + this.jIa;
                        this.jHY = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.jHZ = read;
            } catch (IOException e) {
                k.s(e);
            }
        }
        return (this.jHY == 6 || this.jIc == i) ? false : true;
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
        if (this.jIb > 0) {
            this.jId = i;
        }
        int i2 = this.jIb;
        this.jIb = i2 + 1;
        this.jIc = i2;
    }

    public int cyz() {
        return this.jId;
    }

    public int cyA() {
        return this.jIc;
    }
}
