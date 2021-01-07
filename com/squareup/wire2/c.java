package com.squareup.wire2;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSource;
import okio.ByteString;
/* loaded from: classes6.dex */
public final class c {
    private FieldEncoding pUQ;
    private int recursionDepth;
    private final BufferedSource source;
    private long pos = 0;
    private long limit = Long.MAX_VALUE;
    private int state = 2;
    private int tag = -1;
    private long pUP = -1;

    public c(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public long eFg() throws IOException {
        if (this.state != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i = this.recursionDepth + 1;
        this.recursionDepth = i;
        if (i > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j = this.pUP;
        this.pUP = -1L;
        this.state = 6;
        return j;
    }

    public void iS(long j) throws IOException {
        if (this.state != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i = this.recursionDepth - 1;
        this.recursionDepth = i;
        if (i < 0 || this.pUP != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.pos != this.limit && this.recursionDepth != 0) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        }
        this.limit = j;
    }

    public int eFh() throws IOException {
        if (this.state == 7) {
            this.state = 2;
            return this.tag;
        } else if (this.state != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        } else {
            while (this.pos < this.limit && !this.source.exhausted()) {
                int eFk = eFk();
                if (eFk == 0) {
                    throw new ProtocolException("Unexpected tag 0");
                }
                this.tag = eFk >> 3;
                int i = eFk & 7;
                switch (i) {
                    case 0:
                        this.pUQ = FieldEncoding.VARINT;
                        this.state = 0;
                        return this.tag;
                    case 1:
                        this.pUQ = FieldEncoding.FIXED64;
                        this.state = 1;
                        return this.tag;
                    case 2:
                        this.pUQ = FieldEncoding.LENGTH_DELIMITED;
                        this.state = 2;
                        int eFk2 = eFk();
                        if (eFk2 < 0) {
                            throw new ProtocolException("Negative length: " + eFk2);
                        }
                        if (this.pUP != -1) {
                            throw new IllegalStateException();
                        }
                        this.pUP = this.limit;
                        this.limit = eFk2 + this.pos;
                        if (this.limit > this.pUP) {
                            throw new EOFException();
                        }
                        return this.tag;
                    case 3:
                        RU(this.tag);
                    case 4:
                        throw new ProtocolException("Unexpected end group");
                    case 5:
                        this.pUQ = FieldEncoding.FIXED32;
                        this.state = 5;
                        return this.tag;
                    default:
                        throw new ProtocolException("Unexpected field encoding: " + i);
                }
            }
            return -1;
        }
    }

    public FieldEncoding eFi() {
        return this.pUQ;
    }

    private void RU(int i) throws IOException {
        while (this.pos < this.limit && !this.source.exhausted()) {
            int eFk = eFk();
            if (eFk == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = eFk >> 3;
            int i3 = eFk & 7;
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
                    int eFk2 = eFk();
                    this.pos += eFk2;
                    this.source.skip(eFk2);
                    break;
                case 3:
                    RU(i2);
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

    public ByteString eFj() throws IOException {
        return this.source.readByteString(eFl());
    }

    public String readString() throws IOException {
        return this.source.readUtf8(eFl());
    }

    public int readVarint32() throws IOException {
        if (this.state != 0 && this.state != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        int eFk = eFk();
        RV(0);
        return eFk;
    }

    private int eFk() throws IOException {
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
                RV(0);
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
        RV(5);
        return readIntLe;
    }

    public long readFixed64() throws IOException {
        if (this.state != 1 && this.state != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(8L);
        this.pos += 8;
        long readLongLe = this.source.readLongLe();
        RV(1);
        return readLongLe;
    }

    private void RV(int i) throws IOException {
        if (this.state == i) {
            this.state = 6;
        } else if (this.pos > this.limit) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        } else {
            if (this.pos == this.limit) {
                this.limit = this.pUP;
                this.pUP = -1L;
                this.state = 6;
                return;
            }
            this.state = 7;
        }
    }

    private long eFl() throws IOException {
        if (this.state != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
        }
        long j = this.limit - this.pos;
        this.source.require(j);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.pUP;
        this.pUP = -1L;
        return j;
    }
}
