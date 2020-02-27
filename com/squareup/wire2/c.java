package com.squareup.wire2;

import com.google.android.exoplayer2.Format;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSource;
import okio.ByteString;
/* loaded from: classes.dex */
public final class c {
    private FieldEncoding npg;
    private int recursionDepth;
    private final BufferedSource source;
    private long pos = 0;
    private long limit = Format.OFFSET_SAMPLE_RELATIVE;
    private int state = 2;
    private int tag = -1;
    private long npf = -1;

    public c(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public long dGm() throws IOException {
        if (this.state != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i = this.recursionDepth + 1;
        this.recursionDepth = i;
        if (i > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j = this.npf;
        this.npf = -1L;
        this.state = 6;
        return j;
    }

    public void gZ(long j) throws IOException {
        if (this.state != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i = this.recursionDepth - 1;
        this.recursionDepth = i;
        if (i < 0 || this.npf != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.pos != this.limit && this.recursionDepth != 0) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        }
        this.limit = j;
    }

    public int dGn() throws IOException {
        if (this.state == 7) {
            this.state = 2;
            return this.tag;
        } else if (this.state != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        } else {
            while (this.pos < this.limit && !this.source.exhausted()) {
                int dGq = dGq();
                if (dGq == 0) {
                    throw new ProtocolException("Unexpected tag 0");
                }
                this.tag = dGq >> 3;
                int i = dGq & 7;
                switch (i) {
                    case 0:
                        this.npg = FieldEncoding.VARINT;
                        this.state = 0;
                        return this.tag;
                    case 1:
                        this.npg = FieldEncoding.FIXED64;
                        this.state = 1;
                        return this.tag;
                    case 2:
                        this.npg = FieldEncoding.LENGTH_DELIMITED;
                        this.state = 2;
                        int dGq2 = dGq();
                        if (dGq2 < 0) {
                            throw new ProtocolException("Negative length: " + dGq2);
                        }
                        if (this.npf != -1) {
                            throw new IllegalStateException();
                        }
                        this.npf = this.limit;
                        this.limit = dGq2 + this.pos;
                        if (this.limit > this.npf) {
                            throw new EOFException();
                        }
                        return this.tag;
                    case 3:
                        Nq(this.tag);
                    case 4:
                        throw new ProtocolException("Unexpected end group");
                    case 5:
                        this.npg = FieldEncoding.FIXED32;
                        this.state = 5;
                        return this.tag;
                    default:
                        throw new ProtocolException("Unexpected field encoding: " + i);
                }
            }
            return -1;
        }
    }

    public FieldEncoding dGo() {
        return this.npg;
    }

    private void Nq(int i) throws IOException {
        while (this.pos < this.limit && !this.source.exhausted()) {
            int dGq = dGq();
            if (dGq == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = dGq >> 3;
            int i3 = dGq & 7;
            switch (i3) {
                case 0:
                    this.state = 0;
                    readVarint64();
                    break;
                case 1:
                    this.state = 1;
                    readFixed64();
                    break;
                case 2:
                    int dGq2 = dGq();
                    this.pos += dGq2;
                    this.source.skip(dGq2);
                    break;
                case 3:
                    Nq(i2);
                    break;
                case 4:
                    if (i2 != i) {
                        throw new ProtocolException("Unexpected end group");
                    }
                    return;
                case 5:
                    this.state = 5;
                    readFixed32();
                    break;
                default:
                    throw new ProtocolException("Unexpected field encoding: " + i3);
            }
        }
        throw new EOFException();
    }

    public ByteString dGp() throws IOException {
        return this.source.readByteString(dGr());
    }

    public String readString() throws IOException {
        return this.source.readUtf8(dGr());
    }

    public int readVarint32() throws IOException {
        if (this.state != 0 && this.state != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        int dGq = dGq();
        Nr(0);
        return dGq;
    }

    private int dGq() throws IOException {
        this.pos++;
        byte readByte = this.source.readByte();
        if (readByte < 0) {
            int i = readByte & Byte.MAX_VALUE;
            this.pos++;
            byte readByte2 = this.source.readByte();
            if (readByte2 >= 0) {
                return i | (readByte2 << 7);
            }
            int i2 = i | ((readByte2 & Byte.MAX_VALUE) << 7);
            this.pos++;
            byte readByte3 = this.source.readByte();
            if (readByte3 >= 0) {
                return i2 | (readByte3 << 14);
            }
            int i3 = i2 | ((readByte3 & Byte.MAX_VALUE) << 14);
            this.pos++;
            byte readByte4 = this.source.readByte();
            if (readByte4 >= 0) {
                return i3 | (readByte4 << 21);
            }
            int i4 = i3 | ((readByte4 & Byte.MAX_VALUE) << 21);
            this.pos++;
            byte readByte5 = this.source.readByte();
            int i5 = i4 | (readByte5 << 28);
            if (readByte5 < 0) {
                for (int i6 = 0; i6 < 5; i6++) {
                    this.pos++;
                    if (this.source.readByte() >= 0) {
                        return i5;
                    }
                }
                throw new ProtocolException("Malformed VARINT");
            }
            return i5;
        }
        return readByte;
    }

    public long readVarint64() throws IOException {
        byte readByte;
        if (this.state != 0 && this.state != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            this.pos++;
            j |= (readByte & Byte.MAX_VALUE) << i;
            if ((this.source.readByte() & 128) == 0) {
                Nr(0);
                return j;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public int readFixed32() throws IOException {
        if (this.state != 5 && this.state != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(4L);
        this.pos += 4;
        int readIntLe = this.source.readIntLe();
        Nr(5);
        return readIntLe;
    }

    public long readFixed64() throws IOException {
        if (this.state != 1 && this.state != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(8L);
        this.pos += 8;
        long readLongLe = this.source.readLongLe();
        Nr(1);
        return readLongLe;
    }

    private void Nr(int i) throws IOException {
        if (this.state == i) {
            this.state = 6;
        } else if (this.pos > this.limit) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        } else {
            if (this.pos == this.limit) {
                this.limit = this.npf;
                this.npf = -1L;
                this.state = 6;
                return;
            }
            this.state = 7;
        }
    }

    private long dGr() throws IOException {
        if (this.state != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
        }
        long j = this.limit - this.pos;
        this.source.require(j);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.npf;
        this.npf = -1L;
        return j;
    }
}
