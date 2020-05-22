package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class e {
    private final com.facebook.common.memory.a mlM;
    private boolean mxj;
    private int mxf = 0;
    private int mxe = 0;
    private int mxg = 0;
    private int mxi = 0;
    private int mxh = 0;
    private int mxd = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.mlM = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.mxd != 6 && eVar.getSize() > this.mxf) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.mlM.get(16384), this.mlM);
            try {
                com.facebook.common.util.c.a(fVar, this.mxf);
                return u(fVar);
            } catch (IOException e) {
                l.y(e);
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
        int i = this.mxh;
        while (this.mxd != 6 && (read = inputStream.read()) != -1) {
            try {
                this.mxf++;
                if (this.mxj) {
                    this.mxd = 6;
                    this.mxj = false;
                    return false;
                }
                switch (this.mxd) {
                    case 0:
                        if (read == 255) {
                            this.mxd = 1;
                            break;
                        } else {
                            this.mxd = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.mxd = 2;
                            break;
                        } else {
                            this.mxd = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.mxd = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.mxd = 3;
                            break;
                        } else if (read == 0) {
                            this.mxd = 2;
                            break;
                        } else if (read == 217) {
                            this.mxj = true;
                            HE(this.mxf - 2);
                            this.mxd = 2;
                            break;
                        } else {
                            if (read == 218) {
                                HE(this.mxf - 2);
                            }
                            if (HD(read)) {
                                this.mxd = 4;
                                break;
                            } else {
                                this.mxd = 2;
                                break;
                            }
                        }
                    case 4:
                        this.mxd = 5;
                        break;
                    case 5:
                        int i2 = ((this.mxe << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.mxf = i2 + this.mxf;
                        this.mxd = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.mxe = read;
            } catch (IOException e) {
                l.y(e);
            }
        }
        if (this.mxd == 6 || this.mxh == i) {
            z = false;
        }
        return z;
    }

    private static boolean HD(int i) {
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

    private void HE(int i) {
        if (this.mxg > 0) {
            this.mxi = i;
        }
        int i2 = this.mxg;
        this.mxg = i2 + 1;
        this.mxh = i2;
    }

    public int dzX() {
        return this.mxi;
    }

    public int dzY() {
        return this.mxh;
    }

    public boolean dzZ() {
        return this.mxj;
    }
}
