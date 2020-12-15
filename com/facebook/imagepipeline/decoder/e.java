package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes15.dex */
public class e {
    private final com.facebook.common.memory.a pcj;
    private boolean pnh;
    private int pnd = 0;
    private int pnc = 0;
    private int pne = 0;
    private int png = 0;
    private int pnf = 0;
    private int pnb = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.pcj = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.e eVar) {
        if (this.pnb != 6 && eVar.getSize() > this.pnd) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.pcj.get(16384), this.pcj);
            try {
                com.facebook.common.util.c.a(fVar, this.pnd);
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
        int i = this.pnf;
        while (this.pnb != 6 && (read = inputStream.read()) != -1) {
            try {
                this.pnd++;
                if (this.pnh) {
                    this.pnb = 6;
                    this.pnh = false;
                    return false;
                }
                switch (this.pnb) {
                    case 0:
                        if (read == 255) {
                            this.pnb = 1;
                            break;
                        } else {
                            this.pnb = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.pnb = 2;
                            break;
                        } else {
                            this.pnb = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.pnb = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.pnb = 3;
                            break;
                        } else if (read == 0) {
                            this.pnb = 2;
                            break;
                        } else if (read == 217) {
                            this.pnh = true;
                            QI(this.pnd - 2);
                            this.pnb = 2;
                            break;
                        } else {
                            if (read == 218) {
                                QI(this.pnd - 2);
                            }
                            if (QH(read)) {
                                this.pnb = 4;
                                break;
                            } else {
                                this.pnb = 2;
                                break;
                            }
                        }
                    case 4:
                        this.pnb = 5;
                        break;
                    case 5:
                        int i2 = ((this.pnc << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.pnd = i2 + this.pnd;
                        this.pnb = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.pnc = read;
            } catch (IOException e) {
                l.v(e);
            }
        }
        if (this.pnb == 6 || this.pnf == i) {
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
        if (this.pne > 0) {
            this.png = i;
        }
        int i2 = this.pne;
        this.pne = i2 + 1;
        this.pnf = i2;
    }

    public int evo() {
        return this.png;
    }

    public int evp() {
        return this.pnf;
    }

    public boolean evq() {
        return this.pnh;
    }
}
