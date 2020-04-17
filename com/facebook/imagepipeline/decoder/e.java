package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class e {
    private final com.facebook.common.memory.a lRQ;
    private boolean mdo;
    private int mdk = 0;
    private int mdj = 0;
    private int mdl = 0;
    private int mdn = 0;
    private int mdm = 0;
    private int mdi = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.lRQ = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.mdi != 6 && eVar.getSize() > this.mdk) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.lRQ.get(16384), this.lRQ);
            try {
                com.facebook.common.util.c.a(fVar, this.mdk);
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
        int i = this.mdm;
        while (this.mdi != 6 && (read = inputStream.read()) != -1) {
            try {
                this.mdk++;
                if (this.mdo) {
                    this.mdi = 6;
                    this.mdo = false;
                    return false;
                }
                switch (this.mdi) {
                    case 0:
                        if (read == 255) {
                            this.mdi = 1;
                            break;
                        } else {
                            this.mdi = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.mdi = 2;
                            break;
                        } else {
                            this.mdi = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.mdi = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.mdi = 3;
                            break;
                        } else if (read == 0) {
                            this.mdi = 2;
                            break;
                        } else if (read == 217) {
                            this.mdo = true;
                            GS(this.mdk - 2);
                            this.mdi = 2;
                            break;
                        } else {
                            if (read == 218) {
                                GS(this.mdk - 2);
                            }
                            if (GR(read)) {
                                this.mdi = 4;
                                break;
                            } else {
                                this.mdi = 2;
                                break;
                            }
                        }
                    case 4:
                        this.mdi = 5;
                        break;
                    case 5:
                        int i2 = ((this.mdj << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.mdk = i2 + this.mdk;
                        this.mdi = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.mdj = read;
            } catch (IOException e) {
                l.y(e);
            }
        }
        if (this.mdi == 6 || this.mdm == i) {
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
        if (this.mdl > 0) {
            this.mdn = i;
        }
        int i2 = this.mdl;
        this.mdl = i2 + 1;
        this.mdm = i2;
    }

    public int dsH() {
        return this.mdn;
    }

    public int dsI() {
        return this.mdm;
    }

    public boolean dsJ() {
        return this.mdo;
    }
}
