package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes15.dex */
public class e {
    private final com.facebook.common.memory.a pch;
    private boolean pnf;
    private int pnb = 0;
    private int pna = 0;
    private int pnc = 0;
    private int pne = 0;
    private int pnd = 0;
    private int pmZ = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.pch = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.e eVar) {
        if (this.pmZ != 6 && eVar.getSize() > this.pnb) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.pch.get(16384), this.pch);
            try {
                com.facebook.common.util.c.a(fVar, this.pnb);
                return w(fVar);
            } catch (IOException e) {
                l.v(e);
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
        int i = this.pnd;
        while (this.pmZ != 6 && (read = inputStream.read()) != -1) {
            try {
                this.pnb++;
                if (this.pnf) {
                    this.pmZ = 6;
                    this.pnf = false;
                    return false;
                }
                switch (this.pmZ) {
                    case 0:
                        if (read == 255) {
                            this.pmZ = 1;
                            break;
                        } else {
                            this.pmZ = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.pmZ = 2;
                            break;
                        } else {
                            this.pmZ = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.pmZ = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.pmZ = 3;
                            break;
                        } else if (read == 0) {
                            this.pmZ = 2;
                            break;
                        } else if (read == 217) {
                            this.pnf = true;
                            QI(this.pnb - 2);
                            this.pmZ = 2;
                            break;
                        } else {
                            if (read == 218) {
                                QI(this.pnb - 2);
                            }
                            if (QH(read)) {
                                this.pmZ = 4;
                                break;
                            } else {
                                this.pmZ = 2;
                                break;
                            }
                        }
                    case 4:
                        this.pmZ = 5;
                        break;
                    case 5:
                        int i2 = ((this.pna << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.pnb = i2 + this.pnb;
                        this.pmZ = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.pna = read;
            } catch (IOException e) {
                l.v(e);
            }
        }
        if (this.pmZ == 6 || this.pnd == i) {
            z = false;
        }
        return z;
    }

    private static boolean QH(int i) {
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

    private void QI(int i) {
        if (this.pnc > 0) {
            this.pne = i;
        }
        int i2 = this.pnc;
        this.pnc = i2 + 1;
        this.pnd = i2;
    }

    public int evn() {
        return this.pne;
    }

    public int evo() {
        return this.pnd;
    }

    public boolean evp() {
        return this.pnf;
    }
}
