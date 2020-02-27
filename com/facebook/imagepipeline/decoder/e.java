package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class e {
    private final com.facebook.common.memory.a lID;
    private boolean lTK;
    private int lTG = 0;
    private int lTF = 0;
    private int lTH = 0;
    private int lTJ = 0;
    private int lTI = 0;
    private int lTE = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.lID = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.lTE != 6 && eVar.getSize() > this.lTG) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.lID.get(16384), this.lID);
            try {
                com.facebook.common.util.c.a(fVar, this.lTG);
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
        int i = this.lTI;
        while (this.lTE != 6 && (read = inputStream.read()) != -1) {
            try {
                this.lTG++;
                if (this.lTK) {
                    this.lTE = 6;
                    this.lTK = false;
                    return false;
                }
                switch (this.lTE) {
                    case 0:
                        if (read == 255) {
                            this.lTE = 1;
                            break;
                        } else {
                            this.lTE = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.lTE = 2;
                            break;
                        } else {
                            this.lTE = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.lTE = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.lTE = 3;
                            break;
                        } else if (read == 0) {
                            this.lTE = 2;
                            break;
                        } else if (read == 217) {
                            this.lTK = true;
                            Ik(this.lTG - 2);
                            this.lTE = 2;
                            break;
                        } else {
                            if (read == 218) {
                                Ik(this.lTG - 2);
                            }
                            if (Ij(read)) {
                                this.lTE = 4;
                                break;
                            } else {
                                this.lTE = 2;
                                break;
                            }
                        }
                    case 4:
                        this.lTE = 5;
                        break;
                    case 5:
                        int i2 = ((this.lTF << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.lTG = i2 + this.lTG;
                        this.lTE = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.lTF = read;
            } catch (IOException e) {
                l.t(e);
            }
        }
        if (this.lTE == 6 || this.lTI == i) {
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
        if (this.lTH > 0) {
            this.lTJ = i;
        }
        int i2 = this.lTH;
        this.lTH = i2 + 1;
        this.lTI = i2;
    }

    public int dqj() {
        return this.lTJ;
    }

    public int dqk() {
        return this.lTI;
    }

    public boolean dql() {
        return this.lTK;
    }
}
