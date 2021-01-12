package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class e {
    private final com.facebook.common.memory.a poT;
    private boolean pzQ;
    private int pzM = 0;
    private int pzL = 0;
    private int pzN = 0;
    private int pzP = 0;
    private int pzO = 0;
    private int pzK = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.poT = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.e eVar) {
        if (this.pzK != 6 && eVar.getSize() > this.pzM) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.poT.get(16384), this.poT);
            try {
                com.facebook.common.util.c.b(fVar, this.pzM);
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
        int i = this.pzO;
        while (this.pzK != 6 && (read = inputStream.read()) != -1) {
            try {
                this.pzM++;
                if (this.pzQ) {
                    this.pzK = 6;
                    this.pzQ = false;
                    return false;
                }
                switch (this.pzK) {
                    case 0:
                        if (read == 255) {
                            this.pzK = 1;
                            break;
                        } else {
                            this.pzK = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.pzK = 2;
                            break;
                        } else {
                            this.pzK = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.pzK = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.pzK = 3;
                            break;
                        } else if (read == 0) {
                            this.pzK = 2;
                            break;
                        } else if (read == 217) {
                            this.pzQ = true;
                            Pp(this.pzM - 2);
                            this.pzK = 2;
                            break;
                        } else {
                            if (read == 218) {
                                Pp(this.pzM - 2);
                            }
                            if (Po(read)) {
                                this.pzK = 4;
                                break;
                            } else {
                                this.pzK = 2;
                                break;
                            }
                        }
                    case 4:
                        this.pzK = 5;
                        break;
                    case 5:
                        int i2 = ((this.pzL << 8) + read) - 2;
                        com.facebook.common.util.c.b(inputStream, i2);
                        this.pzM = i2 + this.pzM;
                        this.pzK = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.pzL = read;
            } catch (IOException e) {
                l.t(e);
            }
        }
        if (this.pzK == 6 || this.pzO == i) {
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
        if (this.pzN > 0) {
            this.pzP = i;
        }
        int i2 = this.pzN;
        this.pzN = i2 + 1;
        this.pzO = i2;
    }

    public int evH() {
        return this.pzP;
    }

    public int evI() {
        return this.pzO;
    }

    public boolean evJ() {
        return this.pzQ;
    }
}
