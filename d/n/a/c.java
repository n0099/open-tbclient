package d.n.a;

import com.squareup.wire2.FieldEncoding;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.BufferedSource;
import okio.ByteString;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final BufferedSource f66315a;

    /* renamed from: d  reason: collision with root package name */
    public int f66318d;

    /* renamed from: h  reason: collision with root package name */
    public FieldEncoding f66322h;

    /* renamed from: b  reason: collision with root package name */
    public long f66316b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f66317c = Long.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f66319e = 2;

    /* renamed from: f  reason: collision with root package name */
    public int f66320f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f66321g = -1;

    public c(BufferedSource bufferedSource) {
        this.f66315a = bufferedSource;
    }

    public final void a(int i) throws IOException {
        if (this.f66319e == i) {
            this.f66319e = 6;
            return;
        }
        long j = this.f66316b;
        long j2 = this.f66317c;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.f66317c + " but was " + this.f66316b);
        } else if (j == j2) {
            this.f66317c = this.f66321g;
            this.f66321g = -1L;
            this.f66319e = 6;
        } else {
            this.f66319e = 7;
        }
    }

    public final long b() throws IOException {
        if (this.f66319e == 2) {
            long j = this.f66317c - this.f66316b;
            this.f66315a.require(j);
            this.f66319e = 6;
            this.f66316b = this.f66317c;
            this.f66317c = this.f66321g;
            this.f66321g = -1L;
            return j;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f66319e);
    }

    public long c() throws IOException {
        if (this.f66319e == 2) {
            int i = this.f66318d + 1;
            this.f66318d = i;
            if (i <= 65) {
                long j = this.f66321g;
                this.f66321g = -1L;
                this.f66319e = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void d(long j) throws IOException {
        if (this.f66319e == 6) {
            int i = this.f66318d - 1;
            this.f66318d = i;
            if (i >= 0 && this.f66321g == -1) {
                if (this.f66316b != this.f66317c && i != 0) {
                    throw new IOException("Expected to end at " + this.f66317c + " but was " + this.f66316b);
                }
                this.f66317c = j;
                return;
            }
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public final int e() throws IOException {
        int i;
        this.f66316b++;
        byte readByte = this.f66315a.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i2 = readByte & ByteCompanionObject.MAX_VALUE;
        this.f66316b++;
        byte readByte2 = this.f66315a.readByte();
        if (readByte2 >= 0) {
            i = readByte2 << 7;
        } else {
            i2 |= (readByte2 & ByteCompanionObject.MAX_VALUE) << 7;
            this.f66316b++;
            byte readByte3 = this.f66315a.readByte();
            if (readByte3 >= 0) {
                i = readByte3 << 14;
            } else {
                i2 |= (readByte3 & ByteCompanionObject.MAX_VALUE) << 14;
                this.f66316b++;
                byte readByte4 = this.f66315a.readByte();
                if (readByte4 < 0) {
                    int i3 = i2 | ((readByte4 & ByteCompanionObject.MAX_VALUE) << 21);
                    this.f66316b++;
                    byte readByte5 = this.f66315a.readByte();
                    int i4 = i3 | (readByte5 << 28);
                    if (readByte5 < 0) {
                        for (int i5 = 0; i5 < 5; i5++) {
                            this.f66316b++;
                            if (this.f66315a.readByte() >= 0) {
                                return i4;
                            }
                        }
                        throw new ProtocolException("Malformed VARINT");
                    }
                    return i4;
                }
                i = readByte4 << 21;
            }
        }
        return i2 | i;
    }

    public int f() throws IOException {
        int i = this.f66319e;
        if (i == 7) {
            this.f66319e = 2;
            return this.f66320f;
        } else if (i == 6) {
            while (this.f66316b < this.f66317c && !this.f66315a.exhausted()) {
                int e2 = e();
                if (e2 != 0) {
                    int i2 = e2 >> 3;
                    this.f66320f = i2;
                    int i3 = e2 & 7;
                    if (i3 == 0) {
                        this.f66322h = FieldEncoding.VARINT;
                        this.f66319e = 0;
                        return i2;
                    } else if (i3 == 1) {
                        this.f66322h = FieldEncoding.FIXED64;
                        this.f66319e = 1;
                        return i2;
                    } else if (i3 == 2) {
                        this.f66322h = FieldEncoding.LENGTH_DELIMITED;
                        this.f66319e = 2;
                        int e3 = e();
                        if (e3 >= 0) {
                            if (this.f66321g == -1) {
                                long j = this.f66317c;
                                this.f66321g = j;
                                long j2 = this.f66316b + e3;
                                this.f66317c = j2;
                                if (j2 <= j) {
                                    return this.f66320f;
                                }
                                throw new EOFException();
                            }
                            throw new IllegalStateException();
                        }
                        throw new ProtocolException("Negative length: " + e3);
                    } else if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                this.f66322h = FieldEncoding.FIXED32;
                                this.f66319e = 5;
                                return i2;
                            }
                            throw new ProtocolException("Unexpected field encoding: " + i3);
                        }
                        throw new ProtocolException("Unexpected end group");
                    } else {
                        n(i2);
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    public FieldEncoding g() {
        return this.f66322h;
    }

    public ByteString h() throws IOException {
        return this.f66315a.readByteString(b());
    }

    public int i() throws IOException {
        int i = this.f66319e;
        if (i != 5 && i != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f66319e);
        }
        this.f66315a.require(4L);
        this.f66316b += 4;
        int readIntLe = this.f66315a.readIntLe();
        a(5);
        return readIntLe;
    }

    public long j() throws IOException {
        int i = this.f66319e;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f66319e);
        }
        this.f66315a.require(8L);
        this.f66316b += 8;
        long readLongLe = this.f66315a.readLongLe();
        a(1);
        return readLongLe;
    }

    public String k() throws IOException {
        return this.f66315a.readUtf8(b());
    }

    public int l() throws IOException {
        int i = this.f66319e;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f66319e);
        }
        int e2 = e();
        a(0);
        return e2;
    }

    public long m() throws IOException {
        byte readByte;
        int i = this.f66319e;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f66319e);
        }
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            this.f66316b++;
            j |= (readByte & ByteCompanionObject.MAX_VALUE) << i2;
            if ((this.f66315a.readByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                a(0);
                return j;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public final void n(int i) throws IOException {
        while (this.f66316b < this.f66317c && !this.f66315a.exhausted()) {
            int e2 = e();
            if (e2 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = e2 >> 3;
            int i3 = e2 & 7;
            if (i3 == 0) {
                this.f66319e = 0;
                m();
            } else if (i3 == 1) {
                this.f66319e = 1;
                j();
            } else if (i3 == 2) {
                long e3 = e();
                this.f66316b += e3;
                this.f66315a.skip(e3);
            } else if (i3 == 3) {
                n(i2);
            } else if (i3 == 4) {
                if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i3 == 5) {
                this.f66319e = 5;
                i();
            } else {
                throw new ProtocolException("Unexpected field encoding: " + i3);
            }
        }
        throw new EOFException();
    }
}
