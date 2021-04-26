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
    public final BufferedSource f65786a;

    /* renamed from: d  reason: collision with root package name */
    public int f65789d;

    /* renamed from: h  reason: collision with root package name */
    public FieldEncoding f65793h;

    /* renamed from: b  reason: collision with root package name */
    public long f65787b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f65788c = Long.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f65790e = 2;

    /* renamed from: f  reason: collision with root package name */
    public int f65791f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f65792g = -1;

    public c(BufferedSource bufferedSource) {
        this.f65786a = bufferedSource;
    }

    public final void a(int i2) throws IOException {
        if (this.f65790e == i2) {
            this.f65790e = 6;
            return;
        }
        long j = this.f65787b;
        long j2 = this.f65788c;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.f65788c + " but was " + this.f65787b);
        } else if (j == j2) {
            this.f65788c = this.f65792g;
            this.f65792g = -1L;
            this.f65790e = 6;
        } else {
            this.f65790e = 7;
        }
    }

    public final long b() throws IOException {
        if (this.f65790e == 2) {
            long j = this.f65788c - this.f65787b;
            this.f65786a.require(j);
            this.f65790e = 6;
            this.f65787b = this.f65788c;
            this.f65788c = this.f65792g;
            this.f65792g = -1L;
            return j;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f65790e);
    }

    public long c() throws IOException {
        if (this.f65790e == 2) {
            int i2 = this.f65789d + 1;
            this.f65789d = i2;
            if (i2 <= 65) {
                long j = this.f65792g;
                this.f65792g = -1L;
                this.f65790e = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void d(long j) throws IOException {
        if (this.f65790e == 6) {
            int i2 = this.f65789d - 1;
            this.f65789d = i2;
            if (i2 >= 0 && this.f65792g == -1) {
                if (this.f65787b != this.f65788c && i2 != 0) {
                    throw new IOException("Expected to end at " + this.f65788c + " but was " + this.f65787b);
                }
                this.f65788c = j;
                return;
            }
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public final int e() throws IOException {
        int i2;
        this.f65787b++;
        byte readByte = this.f65786a.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i3 = readByte & ByteCompanionObject.MAX_VALUE;
        this.f65787b++;
        byte readByte2 = this.f65786a.readByte();
        if (readByte2 >= 0) {
            i2 = readByte2 << 7;
        } else {
            i3 |= (readByte2 & ByteCompanionObject.MAX_VALUE) << 7;
            this.f65787b++;
            byte readByte3 = this.f65786a.readByte();
            if (readByte3 >= 0) {
                i2 = readByte3 << 14;
            } else {
                i3 |= (readByte3 & ByteCompanionObject.MAX_VALUE) << 14;
                this.f65787b++;
                byte readByte4 = this.f65786a.readByte();
                if (readByte4 < 0) {
                    int i4 = i3 | ((readByte4 & ByteCompanionObject.MAX_VALUE) << 21);
                    this.f65787b++;
                    byte readByte5 = this.f65786a.readByte();
                    int i5 = i4 | (readByte5 << 28);
                    if (readByte5 < 0) {
                        for (int i6 = 0; i6 < 5; i6++) {
                            this.f65787b++;
                            if (this.f65786a.readByte() >= 0) {
                                return i5;
                            }
                        }
                        throw new ProtocolException("Malformed VARINT");
                    }
                    return i5;
                }
                i2 = readByte4 << 21;
            }
        }
        return i3 | i2;
    }

    public int f() throws IOException {
        int i2 = this.f65790e;
        if (i2 == 7) {
            this.f65790e = 2;
            return this.f65791f;
        } else if (i2 == 6) {
            while (this.f65787b < this.f65788c && !this.f65786a.exhausted()) {
                int e2 = e();
                if (e2 != 0) {
                    int i3 = e2 >> 3;
                    this.f65791f = i3;
                    int i4 = e2 & 7;
                    if (i4 == 0) {
                        this.f65793h = FieldEncoding.VARINT;
                        this.f65790e = 0;
                        return i3;
                    } else if (i4 == 1) {
                        this.f65793h = FieldEncoding.FIXED64;
                        this.f65790e = 1;
                        return i3;
                    } else if (i4 == 2) {
                        this.f65793h = FieldEncoding.LENGTH_DELIMITED;
                        this.f65790e = 2;
                        int e3 = e();
                        if (e3 >= 0) {
                            if (this.f65792g == -1) {
                                long j = this.f65788c;
                                this.f65792g = j;
                                long j2 = this.f65787b + e3;
                                this.f65788c = j2;
                                if (j2 <= j) {
                                    return this.f65791f;
                                }
                                throw new EOFException();
                            }
                            throw new IllegalStateException();
                        }
                        throw new ProtocolException("Negative length: " + e3);
                    } else if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5) {
                                this.f65793h = FieldEncoding.FIXED32;
                                this.f65790e = 5;
                                return i3;
                            }
                            throw new ProtocolException("Unexpected field encoding: " + i4);
                        }
                        throw new ProtocolException("Unexpected end group");
                    } else {
                        n(i3);
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
        return this.f65793h;
    }

    public ByteString h() throws IOException {
        return this.f65786a.readByteString(b());
    }

    public int i() throws IOException {
        int i2 = this.f65790e;
        if (i2 != 5 && i2 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f65790e);
        }
        this.f65786a.require(4L);
        this.f65787b += 4;
        int readIntLe = this.f65786a.readIntLe();
        a(5);
        return readIntLe;
    }

    public long j() throws IOException {
        int i2 = this.f65790e;
        if (i2 != 1 && i2 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f65790e);
        }
        this.f65786a.require(8L);
        this.f65787b += 8;
        long readLongLe = this.f65786a.readLongLe();
        a(1);
        return readLongLe;
    }

    public String k() throws IOException {
        return this.f65786a.readUtf8(b());
    }

    public int l() throws IOException {
        int i2 = this.f65790e;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f65790e);
        }
        int e2 = e();
        a(0);
        return e2;
    }

    public long m() throws IOException {
        byte readByte;
        int i2 = this.f65790e;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f65790e);
        }
        long j = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            this.f65787b++;
            j |= (readByte & ByteCompanionObject.MAX_VALUE) << i3;
            if ((this.f65786a.readByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                a(0);
                return j;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public final void n(int i2) throws IOException {
        while (this.f65787b < this.f65788c && !this.f65786a.exhausted()) {
            int e2 = e();
            if (e2 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i3 = e2 >> 3;
            int i4 = e2 & 7;
            if (i4 == 0) {
                this.f65790e = 0;
                m();
            } else if (i4 == 1) {
                this.f65790e = 1;
                j();
            } else if (i4 == 2) {
                long e3 = e();
                this.f65787b += e3;
                this.f65786a.skip(e3);
            } else if (i4 == 3) {
                n(i3);
            } else if (i4 == 4) {
                if (i3 != i2) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i4 == 5) {
                this.f65790e = 5;
                i();
            } else {
                throw new ProtocolException("Unexpected field encoding: " + i4);
            }
        }
        throw new EOFException();
    }
}
