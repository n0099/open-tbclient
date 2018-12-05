package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a iga;
    private int iot = 0;
    private int ios = 0;
    private int iou = 0;
    private int iow = 0;
    private int iov = 0;
    private int ior = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.iga = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.ior != 6 && dVar.getSize() > this.iot) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.iga.get(16384), this.iga);
            try {
                com.facebook.common.util.c.a(fVar, this.iot);
                return t(fVar);
            } catch (IOException e) {
                k.r(e);
                return false;
            } finally {
                com.facebook.common.internal.b.o(fVar);
            }
        }
        return false;
    }

    private boolean t(InputStream inputStream) {
        int read;
        int i = this.iov;
        while (this.ior != 6 && (read = inputStream.read()) != -1) {
            try {
                this.iot++;
                switch (this.ior) {
                    case 0:
                        if (read == 255) {
                            this.ior = 1;
                            break;
                        } else {
                            this.ior = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.ior = 2;
                            break;
                        } else {
                            this.ior = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.ior = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.ior = 3;
                            break;
                        } else if (read == 0) {
                            this.ior = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                yo(this.iot - 2);
                            }
                            if (yn(read)) {
                                this.ior = 4;
                                break;
                            } else {
                                this.ior = 2;
                                break;
                            }
                        }
                    case 4:
                        this.ior = 5;
                        break;
                    case 5:
                        int i2 = ((this.ios << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.iot = i2 + this.iot;
                        this.ior = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.ios = read;
            } catch (IOException e) {
                k.r(e);
            }
        }
        return (this.ior == 6 || this.iov == i) ? false : true;
    }

    private static boolean yn(int i) {
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

    private void yo(int i) {
        if (this.iou > 0) {
            this.iow = i;
        }
        int i2 = this.iou;
        this.iou = i2 + 1;
        this.iov = i2;
    }

    public int bXQ() {
        return this.iow;
    }

    public int bXR() {
        return this.iov;
    }
}
