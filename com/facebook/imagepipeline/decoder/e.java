package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class e {
    private final com.facebook.common.memory.a poU;
    private boolean pzR;
    private int pzN = 0;
    private int pzM = 0;
    private int pzO = 0;
    private int pzQ = 0;
    private int pzP = 0;
    private int pzL = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.poU = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.e eVar) {
        if (this.pzL != 6 && eVar.getSize() > this.pzN) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.poU.get(16384), this.poU);
            try {
                com.facebook.common.util.c.b(fVar, this.pzN);
                return z(fVar);
            } catch (IOException e) {
                l.t(e);
                return false;
            } finally {
                com.facebook.common.internal.b.u(fVar);
            }
        }
        return false;
    }

    private boolean z(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.pzP;
        while (this.pzL != 6 && (read = inputStream.read()) != -1) {
            try {
                this.pzN++;
                if (this.pzR) {
                    this.pzL = 6;
                    this.pzR = false;
                    return false;
                }
                switch (this.pzL) {
                    case 0:
                        if (read == 255) {
                            this.pzL = 1;
                            break;
                        } else {
                            this.pzL = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.pzL = 2;
                            break;
                        } else {
                            this.pzL = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.pzL = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.pzL = 3;
                            break;
                        } else if (read == 0) {
                            this.pzL = 2;
                            break;
                        } else if (read == 217) {
                            this.pzR = true;
                            Pp(this.pzN - 2);
                            this.pzL = 2;
                            break;
                        } else {
                            if (read == 218) {
                                Pp(this.pzN - 2);
                            }
                            if (Po(read)) {
                                this.pzL = 4;
                                break;
                            } else {
                                this.pzL = 2;
                                break;
                            }
                        }
                    case 4:
                        this.pzL = 5;
                        break;
                    case 5:
                        int i2 = ((this.pzM << 8) + read) - 2;
                        com.facebook.common.util.c.b(inputStream, i2);
                        this.pzN = i2 + this.pzN;
                        this.pzL = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.pzM = read;
            } catch (IOException e) {
                l.t(e);
            }
        }
        if (this.pzL == 6 || this.pzP == i) {
            z = false;
        }
        return z;
    }

    private static boolean Po(int i) {
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

    private void Pp(int i) {
        if (this.pzO > 0) {
            this.pzQ = i;
        }
        int i2 = this.pzO;
        this.pzO = i2 + 1;
        this.pzP = i2;
    }

    public int evH() {
        return this.pzQ;
    }

    public int evI() {
        return this.pzP;
    }

    public boolean evJ() {
        return this.pzR;
    }
}
