package org.msgpack.unpacker;

import com.tencent.mm.sdk.platformtools.Util;
import java.io.EOFException;
import java.io.IOException;
import org.msgpack.packer.Unconverter;
/* loaded from: classes.dex */
public class MessagePackUnpacker extends AbstractUnpacker {
    protected final org.msgpack.io.e e;
    private final m f;
    private byte g;
    private byte[] h;
    private int i;
    private final f j;
    private final g k;
    private final c l;
    private final e m;
    private final d n;
    private final j o;
    private final b p;
    private final h q;
    private final n r;
    private final i s;

    /* JADX INFO: Access modifiers changed from: protected */
    public MessagePackUnpacker(org.msgpack.a aVar, org.msgpack.io.e eVar) {
        super(aVar);
        this.f = new m();
        this.g = (byte) -58;
        this.j = new f();
        this.k = new g();
        this.l = new c();
        this.m = new e();
        this.n = new d();
        this.o = new j();
        this.p = new b();
        this.q = new h();
        this.r = new n();
        this.s = new i();
        this.e = eVar;
    }

    private byte c() {
        byte b = this.g;
        if (b == -58) {
            byte b2 = this.e.b();
            this.g = b2;
            return b2;
        }
        return b;
    }

    final void a(a aVar) {
        this.f.a();
        if (b(aVar)) {
            this.f.b();
        }
    }

    final boolean b(a aVar) {
        if (this.h != null) {
            d();
            aVar.a(this.h);
            this.h = null;
            this.g = (byte) -58;
            return true;
        }
        byte c = c();
        if ((c & 128) == 0) {
            aVar.a((int) c);
            this.g = (byte) -58;
            return true;
        } else if ((c & 224) == 224) {
            aVar.a((int) c);
            this.g = (byte) -58;
            return true;
        } else if ((c & 224) == 160) {
            int i = c & 31;
            if (i == 0) {
                aVar.a();
                this.g = (byte) -58;
                return true;
            }
            if (!a((org.msgpack.io.b) aVar, i)) {
                a(i);
                aVar.a(this.h);
                this.h = null;
            }
            this.g = (byte) -58;
            return true;
        } else if ((c & 240) == 144) {
            int i2 = c & 15;
            aVar.c(i2);
            this.f.b();
            this.f.a(i2);
            this.g = (byte) -58;
            return false;
        } else if ((c & 240) == 128) {
            int i3 = c & 15;
            aVar.d(i3);
            this.f.b();
            this.f.b(i3);
            this.g = (byte) -58;
            return false;
        } else {
            return a(aVar, (int) c);
        }
    }

    private boolean a(a aVar, int i) {
        switch (i & Util.MASK_8BIT) {
            case 192:
                aVar.b();
                this.g = (byte) -58;
                return true;
            case 193:
            case 196:
            case 197:
            case 198:
            case 199:
            case 200:
            case 201:
            case 212:
            case 213:
            case 214:
            case 215:
            case 216:
            case 217:
            default:
                this.g = (byte) -58;
                throw new IOException("Invalid byte: " + i);
            case 194:
                aVar.a(false);
                this.g = (byte) -58;
                return true;
            case 195:
                aVar.a(true);
                this.g = (byte) -58;
                return true;
            case 202:
                aVar.a(this.e.h());
                this.e.c();
                this.g = (byte) -58;
                return true;
            case 203:
                aVar.a(this.e.i());
                this.e.c();
                this.g = (byte) -58;
                return true;
            case 204:
                aVar.b(this.e.d());
                this.e.c();
                this.g = (byte) -58;
                return true;
            case 205:
                aVar.b(this.e.e());
                this.e.c();
                this.g = (byte) -58;
                return true;
            case 206:
                aVar.b(this.e.f());
                this.e.c();
                this.g = (byte) -58;
                return true;
            case 207:
                aVar.b(this.e.g());
                this.e.c();
                this.g = (byte) -58;
                return true;
            case 208:
                aVar.a(this.e.d());
                this.e.c();
                this.g = (byte) -58;
                return true;
            case 209:
                aVar.a(this.e.e());
                this.e.c();
                this.g = (byte) -58;
                return true;
            case 210:
                aVar.a(this.e.f());
                this.e.c();
                this.g = (byte) -58;
                return true;
            case 211:
                aVar.a(this.e.g());
                this.e.c();
                this.g = (byte) -58;
                return true;
            case 218:
                int e = this.e.e() & 65535;
                if (e == 0) {
                    aVar.a();
                    this.e.c();
                    this.g = (byte) -58;
                    return true;
                } else if (e >= this.b) {
                    throw new SizeLimitException(String.format("Size of raw (%d) over limit at %d", Integer.valueOf(e), Integer.valueOf(this.b)));
                } else {
                    this.e.c();
                    if (!a((org.msgpack.io.b) aVar, e)) {
                        a(e);
                        aVar.a(this.h);
                        this.h = null;
                    }
                    this.g = (byte) -58;
                    return true;
                }
            case 219:
                int f = this.e.f();
                if (f == 0) {
                    aVar.a();
                    this.e.c();
                    this.g = (byte) -58;
                    return true;
                } else if (f < 0 || f >= this.b) {
                    throw new SizeLimitException(String.format("Size of raw (%d) over limit at %d", Integer.valueOf(f), Integer.valueOf(this.b)));
                } else {
                    this.e.c();
                    if (!a((org.msgpack.io.b) aVar, f)) {
                        a(f);
                        aVar.a(this.h);
                        this.h = null;
                    }
                    this.g = (byte) -58;
                    return true;
                }
            case 220:
                int e2 = this.e.e() & 65535;
                if (e2 >= this.c) {
                    throw new SizeLimitException(String.format("Size of array (%d) over limit at %d", Integer.valueOf(e2), Integer.valueOf(this.c)));
                }
                aVar.c(e2);
                this.f.b();
                this.f.a(e2);
                this.e.c();
                this.g = (byte) -58;
                return false;
            case 221:
                int f2 = this.e.f();
                if (f2 < 0 || f2 >= this.c) {
                    throw new SizeLimitException(String.format("Size of array (%d) over limit at %d", Integer.valueOf(f2), Integer.valueOf(this.c)));
                }
                aVar.c(f2);
                this.f.b();
                this.f.a(f2);
                this.e.c();
                this.g = (byte) -58;
                return false;
            case 222:
                int e3 = this.e.e() & 65535;
                if (e3 >= this.d) {
                    throw new SizeLimitException(String.format("Size of map (%d) over limit at %d", Integer.valueOf(e3), Integer.valueOf(this.d)));
                }
                aVar.d(e3);
                this.f.b();
                this.f.b(e3);
                this.e.c();
                this.g = (byte) -58;
                return false;
            case 223:
                int f3 = this.e.f();
                if (f3 < 0 || f3 >= this.d) {
                    throw new SizeLimitException(String.format("Size of map (%d) over limit at %d", Integer.valueOf(f3), Integer.valueOf(this.d)));
                }
                aVar.d(f3);
                this.f.b();
                this.f.b(f3);
                this.e.c();
                this.g = (byte) -58;
                return false;
        }
    }

    private boolean a(org.msgpack.io.b bVar, int i) {
        return this.e.a(bVar, i);
    }

    private void a(int i) {
        this.h = new byte[i];
        this.i = 0;
        d();
    }

    private void d() {
        this.i = this.e.a(this.h, this.i, this.h.length - this.i) + this.i;
        if (this.i < this.h.length) {
            throw new EOFException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.msgpack.unpacker.AbstractUnpacker
    public void a(Unconverter unconverter) {
        if (unconverter.c() != null) {
            unconverter.e();
        }
        this.r.a(unconverter);
        this.f.a();
        if (b(this.r)) {
            this.f.b();
            if (unconverter.c() != null) {
                return;
            }
        }
        while (true) {
            if (this.f.e() == 0) {
                if (this.f.f()) {
                    unconverter.c(true);
                    this.f.c();
                } else if (this.f.g()) {
                    unconverter.d(true);
                    this.f.c();
                } else {
                    throw new RuntimeException("invalid stack");
                }
                if (unconverter.c() != null) {
                    return;
                }
            } else {
                a(this.r);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e.close();
    }
}
