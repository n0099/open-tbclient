package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class e {
    private final com.facebook.common.memory.a nkY;
    private boolean nww;
    private int nws = 0;
    private int nwr = 0;
    private int nwt = 0;
    private int nwv = 0;
    private int nwu = 0;
    private int nwq = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.nkY = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.nwq != 6 && eVar.getSize() > this.nws) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.nkY.get(16384), this.nkY);
            try {
                com.facebook.common.util.c.a(fVar, this.nws);
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
        int i = this.nwu;
        while (this.nwq != 6 && (read = inputStream.read()) != -1) {
            try {
                this.nws++;
                if (this.nww) {
                    this.nwq = 6;
                    this.nww = false;
                    return false;
                }
                switch (this.nwq) {
                    case 0:
                        if (read == 255) {
                            this.nwq = 1;
                            break;
                        } else {
                            this.nwq = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.nwq = 2;
                            break;
                        } else {
                            this.nwq = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.nwq = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.nwq = 3;
                            break;
                        } else if (read == 0) {
                            this.nwq = 2;
                            break;
                        } else if (read == 217) {
                            this.nww = true;
                            LM(this.nws - 2);
                            this.nwq = 2;
                            break;
                        } else {
                            if (read == 218) {
                                LM(this.nws - 2);
                            }
                            if (LL(read)) {
                                this.nwq = 4;
                                break;
                            } else {
                                this.nwq = 2;
                                break;
                            }
                        }
                    case 4:
                        this.nwq = 5;
                        break;
                    case 5:
                        int i2 = ((this.nwr << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.nws = i2 + this.nws;
                        this.nwq = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.nwr = read;
            } catch (IOException e) {
                l.v(e);
            }
        }
        if (this.nwq == 6 || this.nwu == i) {
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
        if (this.nwt > 0) {
            this.nwv = i;
        }
        int i2 = this.nwt;
        this.nwt = i2 + 1;
        this.nwu = i2;
    }

    public int dUd() {
        return this.nwv;
    }

    public int dUe() {
        return this.nwu;
    }

    public boolean dUf() {
        return this.nww;
    }
}
