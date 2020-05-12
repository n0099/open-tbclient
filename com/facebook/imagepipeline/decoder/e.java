package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class e {
    private final com.facebook.common.memory.a lRU;
    private boolean mds;
    private int mdo = 0;
    private int mdn = 0;
    private int mdp = 0;
    private int mdr = 0;
    private int mdq = 0;
    private int mdm = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.lRU = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.mdm != 6 && eVar.getSize() > this.mdo) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.lRU.get(16384), this.lRU);
            try {
                com.facebook.common.util.c.a(fVar, this.mdo);
                return t(fVar);
            } catch (IOException e) {
                l.y(e);
                return false;
            } finally {
                com.facebook.common.internal.b.o(fVar);
            }
        }
        return false;
    }

    private boolean t(InputStream inputStream) {
        int read;
        boolean z = true;
        int i = this.mdq;
        while (this.mdm != 6 && (read = inputStream.read()) != -1) {
            try {
                this.mdo++;
                if (this.mds) {
                    this.mdm = 6;
                    this.mds = false;
                    return false;
                }
                switch (this.mdm) {
                    case 0:
                        if (read == 255) {
                            this.mdm = 1;
                            break;
                        } else {
                            this.mdm = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.mdm = 2;
                            break;
                        } else {
                            this.mdm = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.mdm = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.mdm = 3;
                            break;
                        } else if (read == 0) {
                            this.mdm = 2;
                            break;
                        } else if (read == 217) {
                            this.mds = true;
                            GS(this.mdo - 2);
                            this.mdm = 2;
                            break;
                        } else {
                            if (read == 218) {
                                GS(this.mdo - 2);
                            }
                            if (GR(read)) {
                                this.mdm = 4;
                                break;
                            } else {
                                this.mdm = 2;
                                break;
                            }
                        }
                    case 4:
                        this.mdm = 5;
                        break;
                    case 5:
                        int i2 = ((this.mdn << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.mdo = i2 + this.mdo;
                        this.mdm = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.mdn = read;
            } catch (IOException e) {
                l.y(e);
            }
        }
        if (this.mdm == 6 || this.mdq == i) {
            z = false;
        }
        return z;
    }

    private static boolean GR(int i) {
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

    private void GS(int i) {
        if (this.mdp > 0) {
            this.mdr = i;
        }
        int i2 = this.mdp;
        this.mdp = i2 + 1;
        this.mdq = i2;
    }

    public int dsF() {
        return this.mdr;
    }

    public int dsG() {
        return this.mdq;
    }

    public boolean dsH() {
        return this.mds;
    }
}
