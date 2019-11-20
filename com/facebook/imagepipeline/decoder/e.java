package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a kat;
    private int kiW = 0;
    private int kiV = 0;
    private int kiX = 0;
    private int kiZ = 0;
    private int kiY = 0;
    private int kiU = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.kat = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.kiU != 6 && dVar.getSize() > this.kiW) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.kat.get(16384), this.kat);
            try {
                com.facebook.common.util.c.a(fVar, this.kiW);
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
        int i = this.kiY;
        while (this.kiU != 6 && (read = inputStream.read()) != -1) {
            try {
                this.kiW++;
                switch (this.kiU) {
                    case 0:
                        if (read == 255) {
                            this.kiU = 1;
                            break;
                        } else {
                            this.kiU = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.kiU = 2;
                            break;
                        } else {
                            this.kiU = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.kiU = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.kiU = 3;
                            break;
                        } else if (read == 0) {
                            this.kiU = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                Cs(this.kiW - 2);
                            }
                            if (Cr(read)) {
                                this.kiU = 4;
                                break;
                            } else {
                                this.kiU = 2;
                                break;
                            }
                        }
                    case 4:
                        this.kiU = 5;
                        break;
                    case 5:
                        int i2 = ((this.kiV << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.kiW = i2 + this.kiW;
                        this.kiU = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.kiV = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.kiU == 6 || this.kiY == i) ? false : true;
    }

    private static boolean Cr(int i) {
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

    private void Cs(int i) {
        if (this.kiX > 0) {
            this.kiZ = i;
        }
        int i2 = this.kiX;
        this.kiX = i2 + 1;
        this.kiY = i2;
    }

    public int cHD() {
        return this.kiZ;
    }

    public int cHE() {
        return this.kiY;
    }
}
