package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes18.dex */
public class e {
    private final com.facebook.common.memory.a oLv;
    private boolean oWN;
    private int oWJ = 0;
    private int oWI = 0;
    private int oWK = 0;
    private int oWM = 0;
    private int oWL = 0;
    private int oWH = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.oLv = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.oWH != 6 && eVar.getSize() > this.oWJ) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.oLv.get(16384), this.oLv);
            try {
                com.facebook.common.util.c.a(fVar, this.oWJ);
                return v(fVar);
            } catch (IOException e) {
                l.v(e);
                return false;
            } finally {
                com.facebook.common.internal.b.q(fVar);
            }
        }
        return false;
    }

    private boolean v(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.oWL;
        while (this.oWH != 6 && (read = inputStream.read()) != -1) {
            try {
                this.oWJ++;
                if (this.oWN) {
                    this.oWH = 6;
                    this.oWN = false;
                    return false;
                }
                switch (this.oWH) {
                    case 0:
                        if (read == 255) {
                            this.oWH = 1;
                            break;
                        } else {
                            this.oWH = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.oWH = 2;
                            break;
                        } else {
                            this.oWH = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.oWH = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.oWH = 3;
                            break;
                        } else if (read == 0) {
                            this.oWH = 2;
                            break;
                        } else if (read == 217) {
                            this.oWN = true;
                            Pj(this.oWJ - 2);
                            this.oWH = 2;
                            break;
                        } else {
                            if (read == 218) {
                                Pj(this.oWJ - 2);
                            }
                            if (Pi(read)) {
                                this.oWH = 4;
                                break;
                            } else {
                                this.oWH = 2;
                                break;
                            }
                        }
                    case 4:
                        this.oWH = 5;
                        break;
                    case 5:
                        int i2 = ((this.oWI << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.oWJ = i2 + this.oWJ;
                        this.oWH = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.oWI = read;
            } catch (IOException e) {
                l.v(e);
            }
        }
        if (this.oWH == 6 || this.oWL == i) {
            z = false;
        }
        return z;
    }

    private static boolean Pi(int i) {
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

    private void Pj(int i) {
        if (this.oWK > 0) {
            this.oWM = i;
        }
        int i2 = this.oWK;
        this.oWK = i2 + 1;
        this.oWL = i2;
    }

    public int epK() {
        return this.oWM;
    }

    public int epL() {
        return this.oWL;
    }

    public boolean epM() {
        return this.oWN;
    }
}
