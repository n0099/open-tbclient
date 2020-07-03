package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class e {
    private final com.facebook.common.memory.a mIW;
    private boolean mUA;
    private int mUw = 0;
    private int mUv = 0;
    private int mUx = 0;
    private int mUz = 0;
    private int mUy = 0;
    private int mUu = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.mIW = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.mUu != 6 && eVar.getSize() > this.mUw) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.mIW.get(16384), this.mIW);
            try {
                com.facebook.common.util.c.a(fVar, this.mUw);
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
        int i = this.mUy;
        while (this.mUu != 6 && (read = inputStream.read()) != -1) {
            try {
                this.mUw++;
                if (this.mUA) {
                    this.mUu = 6;
                    this.mUA = false;
                    return false;
                }
                switch (this.mUu) {
                    case 0:
                        if (read == 255) {
                            this.mUu = 1;
                            break;
                        } else {
                            this.mUu = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.mUu = 2;
                            break;
                        } else {
                            this.mUu = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.mUu = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.mUu = 3;
                            break;
                        } else if (read == 0) {
                            this.mUu = 2;
                            break;
                        } else if (read == 217) {
                            this.mUA = true;
                            IN(this.mUw - 2);
                            this.mUu = 2;
                            break;
                        } else {
                            if (read == 218) {
                                IN(this.mUw - 2);
                            }
                            if (IM(read)) {
                                this.mUu = 4;
                                break;
                            } else {
                                this.mUu = 2;
                                break;
                            }
                        }
                    case 4:
                        this.mUu = 5;
                        break;
                    case 5:
                        int i2 = ((this.mUv << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.mUw = i2 + this.mUw;
                        this.mUu = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.mUv = read;
            } catch (IOException e) {
                l.y(e);
            }
        }
        if (this.mUu == 6 || this.mUy == i) {
            z = false;
        }
        return z;
    }

    private static boolean IM(int i) {
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

    private void IN(int i) {
        if (this.mUx > 0) {
            this.mUz = i;
        }
        int i2 = this.mUx;
        this.mUx = i2 + 1;
        this.mUy = i2;
    }

    public int dEN() {
        return this.mUz;
    }

    public int dEO() {
        return this.mUy;
    }

    public boolean dEP() {
        return this.mUA;
    }
}
