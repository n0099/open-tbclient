package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class e {
    private final com.facebook.common.memory.a nlq;
    private boolean nwO;
    private int nwK = 0;
    private int nwJ = 0;
    private int nwL = 0;
    private int nwN = 0;
    private int nwM = 0;
    private int nwI = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.nlq = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.nwI != 6 && eVar.getSize() > this.nwK) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.nlq.get(16384), this.nlq);
            try {
                com.facebook.common.util.c.a(fVar, this.nwK);
                return u(fVar);
            } catch (IOException e) {
                l.v(e);
                return false;
            } finally {
                com.facebook.common.internal.b.p(fVar);
            }
        }
        return false;
    }

    private boolean u(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.nwM;
        while (this.nwI != 6 && (read = inputStream.read()) != -1) {
            try {
                this.nwK++;
                if (this.nwO) {
                    this.nwI = 6;
                    this.nwO = false;
                    return false;
                }
                switch (this.nwI) {
                    case 0:
                        if (read == 255) {
                            this.nwI = 1;
                            break;
                        } else {
                            this.nwI = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.nwI = 2;
                            break;
                        } else {
                            this.nwI = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.nwI = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.nwI = 3;
                            break;
                        } else if (read == 0) {
                            this.nwI = 2;
                            break;
                        } else if (read == 217) {
                            this.nwO = true;
                            LM(this.nwK - 2);
                            this.nwI = 2;
                            break;
                        } else {
                            if (read == 218) {
                                LM(this.nwK - 2);
                            }
                            if (LL(read)) {
                                this.nwI = 4;
                                break;
                            } else {
                                this.nwI = 2;
                                break;
                            }
                        }
                    case 4:
                        this.nwI = 5;
                        break;
                    case 5:
                        int i2 = ((this.nwJ << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.nwK = i2 + this.nwK;
                        this.nwI = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.nwJ = read;
            } catch (IOException e) {
                l.v(e);
            }
        }
        if (this.nwI == 6 || this.nwM == i) {
            z = false;
        }
        return z;
    }

    private static boolean LL(int i) {
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

    private void LM(int i) {
        if (this.nwL > 0) {
            this.nwN = i;
        }
        int i2 = this.nwL;
        this.nwL = i2 + 1;
        this.nwM = i2;
    }

    public int dUm() {
        return this.nwN;
    }

    public int dUn() {
        return this.nwM;
    }

    public boolean dUo() {
        return this.nwO;
    }
}
