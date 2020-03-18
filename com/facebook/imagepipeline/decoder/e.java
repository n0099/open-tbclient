package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class e {
    private final com.facebook.common.memory.a lKw;
    private boolean lVD;
    private int lVz = 0;
    private int lVy = 0;
    private int lVA = 0;
    private int lVC = 0;
    private int lVB = 0;
    private int lVx = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.lKw = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.lVx != 6 && eVar.getSize() > this.lVz) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.lKw.get(16384), this.lKw);
            try {
                com.facebook.common.util.c.a(fVar, this.lVz);
                return w(fVar);
            } catch (IOException e) {
                l.t(e);
                return false;
            } finally {
                com.facebook.common.internal.b.r(fVar);
            }
        }
        return false;
    }

    private boolean w(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.lVB;
        while (this.lVx != 6 && (read = inputStream.read()) != -1) {
            try {
                this.lVz++;
                if (this.lVD) {
                    this.lVx = 6;
                    this.lVD = false;
                    return false;
                }
                switch (this.lVx) {
                    case 0:
                        if (read == 255) {
                            this.lVx = 1;
                            break;
                        } else {
                            this.lVx = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.lVx = 2;
                            break;
                        } else {
                            this.lVx = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.lVx = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.lVx = 3;
                            break;
                        } else if (read == 0) {
                            this.lVx = 2;
                            break;
                        } else if (read == 217) {
                            this.lVD = true;
                            Iq(this.lVz - 2);
                            this.lVx = 2;
                            break;
                        } else {
                            if (read == 218) {
                                Iq(this.lVz - 2);
                            }
                            if (Ip(read)) {
                                this.lVx = 4;
                                break;
                            } else {
                                this.lVx = 2;
                                break;
                            }
                        }
                    case 4:
                        this.lVx = 5;
                        break;
                    case 5:
                        int i2 = ((this.lVy << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.lVz = i2 + this.lVz;
                        this.lVx = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.lVy = read;
            } catch (IOException e) {
                l.t(e);
            }
        }
        if (this.lVx == 6 || this.lVB == i) {
            z = false;
        }
        return z;
    }

    private static boolean Ip(int i) {
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

    private void Iq(int i) {
        if (this.lVA > 0) {
            this.lVC = i;
        }
        int i2 = this.lVA;
        this.lVA = i2 + 1;
        this.lVB = i2;
    }

    public int dqJ() {
        return this.lVC;
    }

    public int dqK() {
        return this.lVB;
    }

    public boolean dqL() {
        return this.lVD;
    }
}
