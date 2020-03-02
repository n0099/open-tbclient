package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class e {
    private final com.facebook.common.memory.a lIF;
    private boolean lTM;
    private int lTI = 0;
    private int lTH = 0;
    private int lTJ = 0;
    private int lTL = 0;
    private int lTK = 0;
    private int lTG = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.lIF = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.lTG != 6 && eVar.getSize() > this.lTI) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.lIF.get(16384), this.lIF);
            try {
                com.facebook.common.util.c.a(fVar, this.lTI);
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
        int i = this.lTK;
        while (this.lTG != 6 && (read = inputStream.read()) != -1) {
            try {
                this.lTI++;
                if (this.lTM) {
                    this.lTG = 6;
                    this.lTM = false;
                    return false;
                }
                switch (this.lTG) {
                    case 0:
                        if (read == 255) {
                            this.lTG = 1;
                            break;
                        } else {
                            this.lTG = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.lTG = 2;
                            break;
                        } else {
                            this.lTG = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.lTG = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.lTG = 3;
                            break;
                        } else if (read == 0) {
                            this.lTG = 2;
                            break;
                        } else if (read == 217) {
                            this.lTM = true;
                            Ik(this.lTI - 2);
                            this.lTG = 2;
                            break;
                        } else {
                            if (read == 218) {
                                Ik(this.lTI - 2);
                            }
                            if (Ij(read)) {
                                this.lTG = 4;
                                break;
                            } else {
                                this.lTG = 2;
                                break;
                            }
                        }
                    case 4:
                        this.lTG = 5;
                        break;
                    case 5:
                        int i2 = ((this.lTH << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.lTI = i2 + this.lTI;
                        this.lTG = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.lTH = read;
            } catch (IOException e) {
                l.t(e);
            }
        }
        if (this.lTG == 6 || this.lTK == i) {
            z = false;
        }
        return z;
    }

    private static boolean Ij(int i) {
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

    private void Ik(int i) {
        if (this.lTJ > 0) {
            this.lTL = i;
        }
        int i2 = this.lTJ;
        this.lTJ = i2 + 1;
        this.lTK = i2;
    }

    public int dql() {
        return this.lTL;
    }

    public int dqm() {
        return this.lTK;
    }

    public boolean dqn() {
        return this.lTM;
    }
}
