package org.msgpack.packer;

import com.baidu.zeus.bouncycastle.DERTags;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import org.msgpack.MessageTypeException;
import org.msgpack.io.g;
/* loaded from: classes.dex */
public class MessagePackPacker extends AbstractPacker {
    protected final g b;
    private b c;

    /* JADX INFO: Access modifiers changed from: protected */
    public MessagePackPacker(org.msgpack.a aVar, g gVar) {
        super(aVar);
        this.c = new b();
        this.b = gVar;
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(byte b) {
        if (b < -32) {
            this.b.a((byte) -48, b);
        } else {
            this.b.a(b);
        }
        this.c.b();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(short s) {
        if (s < -32) {
            if (s < -128) {
                this.b.a((byte) -47, s);
            } else {
                this.b.a((byte) -48, (byte) s);
            }
        } else if (s < 128) {
            this.b.a((byte) s);
        } else if (s < 256) {
            this.b.a((byte) -52, (byte) s);
        } else {
            this.b.a((byte) -51, s);
        }
        this.c.b();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(int i) {
        if (i < -32) {
            if (i < -32768) {
                this.b.a((byte) -46, i);
            } else if (i < -128) {
                this.b.a((byte) -47, (short) i);
            } else {
                this.b.a((byte) -48, (byte) i);
            }
        } else if (i < 128) {
            this.b.a((byte) i);
        } else if (i < 256) {
            this.b.a((byte) -52, (byte) i);
        } else if (i < 65536) {
            this.b.a((byte) -51, (short) i);
        } else {
            this.b.a((byte) -50, i);
        }
        this.c.b();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(long j) {
        if (j < -32) {
            if (j < -32768) {
                if (j < -2147483648L) {
                    this.b.a((byte) -45, j);
                } else {
                    this.b.a((byte) -46, (int) j);
                }
            } else if (j < -128) {
                this.b.a((byte) -47, (short) j);
            } else {
                this.b.a((byte) -48, (byte) j);
            }
        } else if (j < 128) {
            this.b.a((byte) j);
        } else if (j < 65536) {
            if (j < 256) {
                this.b.a((byte) -52, (byte) j);
            } else {
                this.b.a((byte) -51, (short) j);
            }
        } else if (j < 4294967296L) {
            this.b.a((byte) -50, (int) j);
        } else {
            this.b.a((byte) -49, j);
        }
        this.c.b();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            b(bigInteger.longValue());
            this.c.b();
        } else if (bigInteger.bitLength() == 64 && bigInteger.signum() == 1) {
            this.b.a((byte) -49, bigInteger.longValue());
            this.c.b();
        } else {
            throw new MessageTypeException("MessagePack can't serialize BigInteger larger than (2^64)-1");
        }
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(float f) {
        this.b.a((byte) -54, f);
        this.c.b();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(double d) {
        this.b.a((byte) -53, d);
        this.c.b();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(boolean z) {
        if (z) {
            this.b.a((byte) -61);
        } else {
            this.b.a((byte) -62);
        }
        this.c.b();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void a(byte[] bArr, int i, int i2) {
        if (i2 < 32) {
            this.b.a((byte) (i2 | 160));
        } else if (i2 < 65536) {
            this.b.a((byte) -38, (short) i2);
        } else {
            this.b.a((byte) -37, i2);
        }
        this.b.a(bArr, i, i2);
        this.c.b();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining < 32) {
            this.b.a((byte) (remaining | 160));
        } else if (remaining < 65536) {
            this.b.a((byte) -38, (short) remaining);
        } else {
            this.b.a((byte) -37, remaining);
        }
        int position = byteBuffer.position();
        try {
            this.b.a(byteBuffer);
            byteBuffer.position(position);
            this.c.b();
        } catch (Throwable th) {
            byteBuffer.position(position);
            throw th;
        }
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
            this.c.b();
        } catch (UnsupportedEncodingException e) {
            throw new MessageTypeException(e);
        }
    }

    @Override // org.msgpack.packer.a
    public a d() {
        this.b.a((byte) -64);
        this.c.b();
        return this;
    }

    @Override // org.msgpack.packer.a
    public a c(int i) {
        if (i < 16) {
            this.b.a((byte) (i | 144));
        } else if (i < 65536) {
            this.b.a((byte) -36, (short) i);
        } else {
            this.b.a((byte) -35, i);
        }
        this.c.b();
        this.c.a(i);
        return this;
    }

    @Override // org.msgpack.packer.a
    public a c(boolean z) {
        if (!this.c.f()) {
            throw new MessageTypeException("writeArrayEnd() is called but writeArrayBegin() is not called");
        }
        int e = this.c.e();
        if (e > 0) {
            if (z) {
                throw new MessageTypeException("writeArrayEnd(check=true) is called but the array is not end: " + e);
            }
            for (int i = 0; i < e; i++) {
                d();
            }
        }
        this.c.c();
        return this;
    }

    @Override // org.msgpack.packer.a
    public a d(int i) {
        if (i < 16) {
            this.b.a((byte) (i | DERTags.TAGGED));
        } else if (i < 65536) {
            this.b.a((byte) -34, (short) i);
        } else {
            this.b.a((byte) -33, i);
        }
        this.c.b();
        this.c.b(i);
        return this;
    }

    @Override // org.msgpack.packer.a
    public a d(boolean z) {
        if (!this.c.g()) {
            throw new MessageTypeException("writeMapEnd() is called but writeMapBegin() is not called");
        }
        int e = this.c.e();
        if (e > 0) {
            if (z) {
                throw new MessageTypeException("writeMapEnd(check=true) is called but the map is not end: " + e);
            }
            for (int i = 0; i < e; i++) {
                d();
            }
        }
        this.c.c();
        return this;
    }

    @Override // java.io.Flushable
    public void flush() {
        this.b.flush();
    }

    @Override // org.msgpack.packer.AbstractPacker, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }
}
