package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class e {
    private final com.facebook.common.memory.a jAf;
    private int jIF = 0;
    private int jIE = 0;
    private int jIG = 0;
    private int jII = 0;
    private int jIH = 0;
    private int jID = 0;

    public e(com.facebook.common.memory.a aVar) {
        this.jAf = (com.facebook.common.memory.a) g.checkNotNull(aVar);
    }

    public boolean a(com.facebook.imagepipeline.f.d dVar) {
        if (this.jID != 6 && dVar.getSize() > this.jIF) {
            com.facebook.common.memory.f fVar = new com.facebook.common.memory.f(dVar.getInputStream(), this.jAf.get(16384), this.jAf);
            try {
                com.facebook.common.util.c.a(fVar, this.jIF);
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
        int i = this.jIH;
        while (this.jID != 6 && (read = inputStream.read()) != -1) {
            try {
                this.jIF++;
                switch (this.jID) {
                    case 0:
                        if (read == 255) {
                            this.jID = 1;
                            break;
                        } else {
                            this.jID = 6;
                            break;
                        }
                    case 1:
                        if (read == 216) {
                            this.jID = 2;
                            break;
                        } else {
                            this.jID = 6;
                            break;
                        }
                    case 2:
                        if (read != 255) {
                            break;
                        } else {
                            this.jID = 3;
                            break;
                        }
                    case 3:
                        if (read == 255) {
                            this.jID = 3;
                            break;
                        } else if (read == 0) {
                            this.jID = 2;
                            break;
                        } else {
                            if (read == 218 || read == 217) {
                                Cq(this.jIF - 2);
                            }
                            if (Cp(read)) {
                                this.jID = 4;
                                break;
                            } else {
                                this.jID = 2;
                                break;
                            }
                        }
                    case 4:
                        this.jID = 5;
                        break;
                    case 5:
                        int i2 = ((this.jIE << 8) + read) - 2;
                        com.facebook.common.util.c.a(inputStream, i2);
                        this.jIF = i2 + this.jIF;
                        this.jID = 2;
                        break;
                    default:
                        g.checkState(false);
                        break;
                }
                this.jIE = read;
            } catch (IOException e) {
                k.s(e);
            }
        }
        return (this.jID == 6 || this.jIH == i) ? false : true;
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
        if (this.jIG > 0) {
            this.jII = i;
        }
        int i2 = this.jIG;
        this.jIG = i2 + 1;
        this.jIH = i2;
    }

    public int cyG() {
        return this.jII;
    }

    public int cyH() {
        return this.jIH;
    }
}
