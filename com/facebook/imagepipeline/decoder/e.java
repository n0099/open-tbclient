package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes18.dex */
public class e {
    private final com.facebook.common.memory.a oCc;
    private boolean oNu;
    private int oNq = 0;
    private int oNp = 0;
    private int oNr = 0;
    private int oNt = 0;
    private int oNs = 0;
    private int oNo = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.oCc = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.oNo != 6 && eVar.getSize() > this.oNq) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.oCc.get(16384), this.oCc);
            try {
                com.facebook.common.util.c.a(fVar, this.oNq);
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
        int i = this.oNs;
        while (this.oNo != 6 && (read = inputStream.read()) != -1) {
            try {
                this.oNq++;
                if (this.oNu) {
                    this.oNo = 6;
                    this.oNu = false;
                    return false;
                }
                switch (this.oNo) {
                    case 0:
                        if (read == 255) {
                            this.oNo = 1;
                            break;
                        } else {
                            this.oNo = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.oNo = 2;
                            break;
                        } else {
                            this.oNo = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.oNo = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.oNo = 3;
                            break;
                        } else if (read == 0) {
                            this.oNo = 2;
                            break;
                        } else if (read == 217) {
                            this.oNu = true;
                            OO(this.oNq - 2);
                            this.oNo = 2;
                            break;
                        } else {
                            if (read == 218) {
                                OO(this.oNq - 2);
                            }
                            if (ON(read)) {
                                this.oNo = 4;
                                break;
                            } else {
                                this.oNo = 2;
                                break;
                            }
                        }
                    case 4:
                        this.oNo = 5;
                        break;
                    case 5:
                        int i2 = ((this.oNp << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.oNq = i2 + this.oNq;
                        this.oNo = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.oNp = read;
            } catch (IOException e) {
                l.v(e);
            }
        }
        if (this.oNo == 6 || this.oNs == i) {
            z = false;
        }
        return z;
    }

    private static boolean ON(int i) {
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

    private void OO(int i) {
        if (this.oNr > 0) {
            this.oNt = i;
        }
        int i2 = this.oNr;
        this.oNr = i2 + 1;
        this.oNs = i2;
    }

    public int elT() {
        return this.oNt;
    }

    public int elU() {
        return this.oNs;
    }

    public boolean elV() {
        return this.oNu;
    }
}
