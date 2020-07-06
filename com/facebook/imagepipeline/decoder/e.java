package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class e {
    private final com.facebook.common.memory.a mIZ;
    private boolean mUD;
    private int mUz = 0;
    private int mUy = 0;
    private int mUA = 0;
    private int mUC = 0;
    private int mUB = 0;
    private int mUx = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.mIZ = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.g.e eVar) {
        if (this.mUx != 6 && eVar.getSize() > this.mUz) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(eVar.getInputStream(), this.mIZ.get(16384), this.mIZ);
            try {
                com.facebook.common.util.c.a(fVar, this.mUz);
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
        int i = this.mUB;
        while (this.mUx != 6 && (read = inputStream.read()) != -1) {
            try {
                this.mUz++;
                if (this.mUD) {
                    this.mUx = 6;
                    this.mUD = false;
                    return false;
                }
                switch (this.mUx) {
                    case 0:
                        if (read == 255) {
                            this.mUx = 1;
                            break;
                        } else {
                            this.mUx = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.mUx = 2;
                            break;
                        } else {
                            this.mUx = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.mUx = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.mUx = 3;
                            break;
                        } else if (read == 0) {
                            this.mUx = 2;
                            break;
                        } else if (read == 217) {
                            this.mUD = true;
                            IN(this.mUz - 2);
                            this.mUx = 2;
                            break;
                        } else {
                            if (read == 218) {
                                IN(this.mUz - 2);
                            }
                            if (IM(read)) {
                                this.mUx = 4;
                                break;
                            } else {
                                this.mUx = 2;
                                break;
                            }
                        }
                    case 4:
                        this.mUx = 5;
                        break;
                    case 5:
                        int i2 = ((this.mUy << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.mUz = i2 + this.mUz;
                        this.mUx = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.mUy = read;
            } catch (IOException e) {
                l.y(e);
            }
        }
        if (this.mUx == 6 || this.mUB == i) {
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
        if (this.mUA > 0) {
            this.mUC = i;
        }
        int i2 = this.mUA;
        this.mUA = i2 + 1;
        this.mUB = i2;
    }

    public int dER() {
        return this.mUC;
    }

    public int dES() {
        return this.mUB;
    }

    public boolean dET() {
        return this.mUD;
    }
}
