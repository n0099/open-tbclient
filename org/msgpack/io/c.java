package org.msgpack.io;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
abstract class c implements g {

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f2847a;
    protected int b;
    protected final int c;
    protected ByteBuffer d;

    protected abstract boolean b(byte[] bArr, int i, int i2);

    public c(int i) {
        this.c = i < 9 ? 9 : i;
    }

    private void a() {
        this.f2847a = new byte[this.c];
        this.d = ByteBuffer.wrap(this.f2847a);
    }

    private void a(int i) {
        if (this.f2847a == null) {
            a();
        } else if (this.c - this.b < i) {
            if (!b(this.f2847a, 0, this.b)) {
                this.f2847a = new byte[this.c];
                this.d = ByteBuffer.wrap(this.f2847a);
            }
            this.b = 0;
        }
    }

    @Override // org.msgpack.io.g
    public void a(byte[] bArr, int i, int i2) {
        if (this.f2847a == null) {
            if (this.c < i2) {
                b(bArr, i, i2);
                return;
            }
            a();
        }
        if (i2 <= this.c - this.b) {
            System.arraycopy(bArr, i, this.f2847a, this.b, i2);
            this.b += i2;
        } else if (i2 <= this.c) {
            if (!b(this.f2847a, 0, this.b)) {
                a();
            }
            this.b = 0;
            System.arraycopy(bArr, i, this.f2847a, 0, i2);
            this.b = i2;
        } else {
            flush();
            b(bArr, i, i2);
        }
    }

    @Override // org.msgpack.io.g
    public void a(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (this.f2847a == null) {
            if (this.c < remaining) {
                b(byteBuffer);
                return;
            }
            a();
        }
        if (remaining <= this.c - this.b) {
            byteBuffer.get(this.f2847a, this.b, remaining);
            this.b = remaining + this.b;
        } else if (remaining <= this.c) {
            if (!b(this.f2847a, 0, this.b)) {
                a();
            }
            this.b = 0;
            byteBuffer.get(this.f2847a, 0, remaining);
            this.b = remaining;
        } else {
            flush();
            b(byteBuffer);
        }
    }

    @Override // org.msgpack.io.g
    public void a(byte b) {
        a(1);
        byte[] bArr = this.f2847a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    @Override // org.msgpack.io.g
    public void a(byte b, byte b2) {
        a(2);
        byte[] bArr = this.f2847a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
        byte[] bArr2 = this.f2847a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr2[i2] = b2;
    }

    @Override // org.msgpack.io.g
    public void a(byte b, short s) {
        a(3);
        byte[] bArr = this.f2847a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
        this.d.putShort(this.b, s);
        this.b += 2;
    }

    @Override // org.msgpack.io.g
    public void a(byte b, int i) {
        a(5);
        byte[] bArr = this.f2847a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = b;
        this.d.putInt(this.b, i);
        this.b += 4;
    }

    @Override // org.msgpack.io.g
    public void a(byte b, long j) {
        a(9);
        byte[] bArr = this.f2847a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
        this.d.putLong(this.b, j);
        this.b += 8;
    }

    @Override // org.msgpack.io.g
    public void a(byte b, float f) {
        a(5);
        byte[] bArr = this.f2847a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
        this.d.putFloat(this.b, f);
        this.b += 4;
    }

    @Override // org.msgpack.io.g
    public void a(byte b, double d) {
        a(9);
        byte[] bArr = this.f2847a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
        this.d.putDouble(this.b, d);
        this.b += 8;
    }

    public void flush() {
        if (this.b > 0) {
            if (!b(this.f2847a, 0, this.b)) {
                this.f2847a = null;
            }
            this.b = 0;
        }
    }

    protected void b(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            b(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        b(bArr, 0, bArr.length);
    }
}
