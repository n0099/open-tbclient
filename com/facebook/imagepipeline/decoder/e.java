package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class e {
    private final com.facebook.common.memory.a lIQ;
    private boolean lTX;
    private int lTT = 0;
    private int lTS = 0;
    private int lTU = 0;
    private int lTW = 0;
    private int lTV = 0;
    private int lTR = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.lIQ = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.lTR != 6 && eVar.getSize() > this.lTT) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.lIQ.get(16384), this.lIQ);
            try {
                com.facebook.common.util.c.a(fVar, this.lTT);
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
        int i = this.lTV;
        while (this.lTR != 6 && (read = inputStream.read()) != -1) {
            try {
                this.lTT++;
                if (this.lTX) {
                    this.lTR = 6;
                    this.lTX = false;
                    return false;
                }
                switch (this.lTR) {
                    case 0:
                        if (read == 255) {
                            this.lTR = 1;
                            break;
                        } else {
                            this.lTR = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.lTR = 2;
                            break;
                        } else {
                            this.lTR = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.lTR = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.lTR = 3;
                            break;
                        } else if (read == 0) {
                            this.lTR = 2;
                            break;
                        } else if (read == 217) {
                            this.lTX = true;
                            Ik(this.lTT - 2);
                            this.lTR = 2;
                            break;
                        } else {
                            if (read == 218) {
                                Ik(this.lTT - 2);
                            }
                            if (Ij(read)) {
                                this.lTR = 4;
                                break;
                            } else {
                                this.lTR = 2;
                                break;
                            }
                        }
                    case 4:
                        this.lTR = 5;
                        break;
                    case 5:
                        int i2 = ((this.lTS << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.lTT = i2 + this.lTT;
                        this.lTR = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.lTS = read;
            } catch (IOException e) {
                l.t(e);
            }
        }
        if (this.lTR == 6 || this.lTV == i) {
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
        if (this.lTU > 0) {
            this.lTW = i;
        }
        int i2 = this.lTU;
        this.lTU = i2 + 1;
        this.lTV = i2;
    }

    public int dqm() {
        return this.lTW;
    }

    public int dqn() {
        return this.lTV;
    }

    public boolean dqo() {
        return this.lTX;
    }
}
