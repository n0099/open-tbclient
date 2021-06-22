package d.n.a;

import com.squareup.wire2.FieldEncoding;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.BufferedSource;
import okio.ByteString;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final BufferedSource f70405a;

    /* renamed from: d  reason: collision with root package name */
    public int f70408d;

    /* renamed from: h  reason: collision with root package name */
    public FieldEncoding f70412h;

    /* renamed from: b  reason: collision with root package name */
    public long f70406b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f70407c = Long.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f70409e = 2;

    /* renamed from: f  reason: collision with root package name */
    public int f70410f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f70411g = -1;

    public c(BufferedSource bufferedSource) {
        this.f70405a = bufferedSource;
    }

    public final void a(int i2) throws IOException {
        if (this.f70409e == i2) {
            this.f70409e = 6;
            return;
        }
        long j = this.f70406b;
        long j2 = this.f70407c;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.f70407c + " but was " + this.f70406b);
        } else if (j == j2) {
            this.f70407c = this.f70411g;
            this.f70411g = -1L;
            this.f70409e = 6;
        } else {
            this.f70409e = 7;
        }
    }

    public final long b() throws IOException {
        if (this.f70409e == 2) {
            long j = this.f70407c - this.f70406b;
            this.f70405a.require(j);
            this.f70409e = 6;
            this.f70406b = this.f70407c;
            this.f70407c = this.f70411g;
            this.f70411g = -1L;
            return j;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f70409e);
    }

    public long c() throws IOException {
        if (this.f70409e == 2) {
            int i2 = this.f70408d + 1;
            this.f70408d = i2;
            if (i2 <= 65) {
                long j = this.f70411g;
                this.f70411g = -1L;
                this.f70409e = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void d(long j) throws IOException {
        if (this.f70409e == 6) {
            int i2 = this.f70408d - 1;
            this.f70408d = i2;
            if (i2 >= 0 && this.f70411g == -1) {
                if (this.f70406b != this.f70407c && i2 != 0) {
                    throw new IOException("Expected to end at " + this.f70407c + " but was " + this.f70406b);
                }
                this.f70407c = j;
                return;
            }
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public final int e() throws IOException {
        int i2;
        this.f70406b++;
        byte readByte = this.f70405a.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i3 = readByte & ByteCompanionObject.MAX_VALUE;
        this.f70406b++;
        byte readByte2 = this.f70405a.readByte();
        if (readByte2 >= 0) {
            i2 = readByte2 << 7;
        } else {
            i3 |= (readByte2 & ByteCompanionObject.MAX_VALUE) << 7;
            this.f70406b++;
            byte readByte3 = this.f70405a.readByte();
            if (readByte3 >= 0) {
                i2 = readByte3 << 14;
            } else {
                i3 |= (readByte3 & ByteCompanionObject.MAX_VALUE) << 14;
                this.f70406b++;
                byte readByte4 = this.f70405a.readByte();
                if (readByte4 < 0) {
                    int i4 = i3 | ((readByte4 & ByteCompanionObject.MAX_VALUE) << 21);
                    this.f70406b++;
                    byte readByte5 = this.f70405a.readByte();
                    int i5 = i4 | (readByte5 << 28);
                    if (readByte5 < 0) {
                        for (int i6 = 0; i6 < 5; i6++) {
                            this.f70406b++;
                            if (this.f70405a.readByte() >= 0) {
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
        int i2 = this.f70409e;
        if (i2 == 7) {
            this.f70409e = 2;
            return this.f70410f;
        } else if (i2 == 6) {
            while (this.f70406b < this.f70407c && !this.f70405a.exhausted()) {
                int e2 = e();
                if (e2 != 0) {
                    int i3 = e2 >> 3;
                    this.f70410f = i3;
                    int i4 = e2 & 7;
                    if (i4 == 0) {
                        this.f70412h = FieldEncoding.VARINT;
                        this.f70409e = 0;
                        return i3;
                    } else if (i4 == 1) {
                        this.f70412h = FieldEncoding.FIXED64;
                        this.f70409e = 1;
                        return i3;
                    } else if (i4 == 2) {
                        this.f70412h = FieldEncoding.LENGTH_DELIMITED;
                        this.f70409e = 2;
                        int e3 = e();
                        if (e3 >= 0) {
                            if (this.f70411g == -1) {
                                long j = this.f70407c;
                                this.f70411g = j;
                                long j2 = this.f70406b + e3;
                                this.f70407c = j2;
                                if (j2 <= j) {
                                    return this.f70410f;
                                }
                                throw new EOFException();
                            }
                            throw new IllegalStateException();
                        }
                        throw new ProtocolException("Negative length: " + e3);
                    } else if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5) {
                                this.f70412h = FieldEncoding.FIXED32;
                                this.f70409e = 5;
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
        return this.f70412h;
    }

    public ByteString h() throws IOException {
        return this.f70405a.readByteString(b());
    }

    public int i() throws IOException {
        int i2 = this.f70409e;
        if (i2 != 5 && i2 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f70409e);
        }
        this.f70405a.require(4L);
        this.f70406b += 4;
        int readIntLe = this.f70405a.readIntLe();
        a(5);
        return readIntLe;
    }

    public long j() throws IOException {
        int i2 = this.f70409e;
        if (i2 != 1 && i2 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f70409e);
        }
        this.f70405a.require(8L);
        this.f70406b += 8;
        long readLongLe = this.f70405a.readLongLe();
        a(1);
        return readLongLe;
    }

    public String k() throws IOException {
        return this.f70405a.readUtf8(b());
    }

    public int l() throws IOException {
        int i2 = this.f70409e;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f70409e);
        }
        int e2 = e();
        a(0);
        return e2;
    }

    public long m() throws IOException {
        byte readByte;
        int i2 = this.f70409e;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f70409e);
        }
        long j = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            this.f70406b++;
            j |= (readByte & ByteCompanionObject.MAX_VALUE) << i3;
            if ((this.f70405a.readByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                a(0);
                return j;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public final void n(int i2) throws IOException {
        while (this.f70406b < this.f70407c && !this.f70405a.exhausted()) {
            int e2 = e();
            if (e2 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i3 = e2 >> 3;
            int i4 = e2 & 7;
            if (i4 == 0) {
                this.f70409e = 0;
                m();
            } else if (i4 == 1) {
                this.f70409e = 1;
                j();
            } else if (i4 == 2) {
                long e3 = e();
                this.f70406b += e3;
                this.f70405a.skip(e3);
            } else if (i4 == 3) {
                n(i3);
            } else if (i4 == 4) {
                if (i3 != i2) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i4 == 5) {
                this.f70409e = 5;
                i();
            } else {
                throw new ProtocolException("Unexpected field encoding: " + i4);
            }
        }
        throw new EOFException();
    }
}
