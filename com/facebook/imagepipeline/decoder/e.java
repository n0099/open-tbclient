package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a jZy;
    private int khX = 0;
    private int khW = 0;
    private int khY = 0;
    private int kia = 0;
    private int khZ = 0;
    private int khV = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.jZy = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.khV != 6 && dVar.getSize() > this.khX) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.jZy.get(16384), this.jZy);
            try {
                com.facebook.common.util.c.a(fVar, this.khX);
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
        int i = this.khZ;
        while (this.khV != 6 && (read = inputStream.read()) != -1) {
            try {
                this.khX++;
                switch (this.khV) {
                    case 0:
                        if (read == 255) {
                            this.khV = 1;
                            break;
                        } else {
                            this.khV = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.khV = 2;
                            break;
                        } else {
                            this.khV = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.khV = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.khV = 3;
                            break;
                        } else if (read == 0) {
                            this.khV = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                DR(this.khX - 2);
                            }
                            if (DQ(read)) {
                                this.khV = 4;
                                break;
                            } else {
                                this.khV = 2;
                                break;
                            }
                        }
                    case 4:
                        this.khV = 5;
                        break;
                    case 5:
                        int i2 = ((this.khW << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.khX = i2 + this.khX;
                        this.khV = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.khW = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.khV == 6 || this.khZ == i) ? false : true;
    }

    private static boolean DQ(int i) {
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

    private void DR(int i) {
        if (this.khY > 0) {
            this.kia = i;
        }
        int i2 = this.khY;
        this.khY = i2 + 1;
        this.khZ = i2;
    }

    public int cJz() {
        return this.kia;
    }

    public int cJA() {
        return this.khZ;
    }
}
