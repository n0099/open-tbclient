package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a jAn;
    private int jIN = 0;
    private int jIM = 0;
    private int jIO = 0;
    private int jIQ = 0;
    private int jIP = 0;
    private int jIL = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.jAn = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.jIL != 6 && dVar.getSize() > this.jIN) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.jAn.get(16384), this.jAn);
            try {
                com.facebook.common.util.c.a(fVar, this.jIN);
                return v(fVar);
            } catch (IOException e) {
                k.s(e);
                return false;
            } finally {
                com.facebook.common.internal.b.q(fVar);
            }
        }
        return false;
    }

    private boolean v(InputStream inputStream) {
        int read;
        int i = this.jIP;
        while (this.jIL != 6 && (read = inputStream.read()) != -1) {
            try {
                this.jIN++;
                switch (this.jIL) {
                    case 0:
                        if (read == 255) {
                            this.jIL = 1;
                            break;
                        } else {
                            this.jIL = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.jIL = 2;
                            break;
                        } else {
                            this.jIL = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.jIL = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.jIL = 3;
                            break;
                        } else if (read == 0) {
                            this.jIL = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                Cq(this.jIN - 2);
                            }
                            if (Cp(read)) {
                                this.jIL = 4;
                                break;
                            } else {
                                this.jIL = 2;
                                break;
                            }
                        }
                    case 4:
                        this.jIL = 5;
                        break;
                    case 5:
                        int i2 = ((this.jIM << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.jIN = i2 + this.jIN;
                        this.jIL = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.jIM = read;
            } catch (IOException e) {
                k.s(e);
            }
        }
        return (this.jIL == 6 || this.jIP == i) ? false : true;
    }

    private static boolean Cp(int i) {
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

    private void Cq(int i) {
        if (this.jIO > 0) {
            this.jIQ = i;
        }
        int i2 = this.jIO;
        this.jIO = i2 + 1;
        this.jIP = i2;
    }

    public int cyD() {
        return this.jIQ;
    }

    public int cyE() {
        return this.jIP;
    }
}
