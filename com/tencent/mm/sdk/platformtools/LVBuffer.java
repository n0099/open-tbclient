package com.tencent.mm.sdk.platformtools;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class LVBuffer {
    public static final int LENGTH_ALLOC_PER_NEW = 4096;
    public static final int MAX_STRING_LENGTH = 2048;
    private ByteBuffer ap;
    private boolean aq;

    private int a(int i) {
        if (this.ap.limit() - this.ap.position() <= i) {
            ByteBuffer allocate = ByteBuffer.allocate(this.ap.limit() + LENGTH_ALLOC_PER_NEW);
            allocate.put(this.ap.array(), 0, this.ap.position());
            this.ap = allocate;
        }
        return 0;
    }

    public byte[] buildFinish() {
        if (this.aq) {
            a(1);
            this.ap.put((byte) 125);
            byte[] bArr = new byte[this.ap.position()];
            System.arraycopy(this.ap.array(), 0, bArr, 0, bArr.length);
            return bArr;
        }
        throw new Exception("Buffer For Parse");
    }

    public boolean checkGetFinish() {
        return this.ap.limit() - this.ap.position() <= 1;
    }

    public int getInt() {
        if (this.aq) {
            throw new Exception("Buffer For Build");
        }
        return this.ap.getInt();
    }

    public long getLong() {
        if (this.aq) {
            throw new Exception("Buffer For Build");
        }
        return this.ap.getLong();
    }

    public String getString() {
        if (this.aq) {
            throw new Exception("Buffer For Build");
        }
        int i = this.ap.getShort();
        if (i > 2048) {
            this.ap = null;
            throw new Exception("Buffer String Length Error");
        } else if (i == 0) {
            return "";
        } else {
            byte[] bArr = new byte[i];
            this.ap.get(bArr, 0, i);
            return new String(bArr);
        }
    }

    public int initBuild() {
        this.ap = ByteBuffer.allocate(LENGTH_ALLOC_PER_NEW);
        this.ap.put((byte) 123);
        this.aq = true;
        return 0;
    }

    public int initParse(byte[] bArr) {
        int i = (bArr == null || bArr.length == 0) ? -1 : bArr[0] != 123 ? -2 : bArr[bArr.length + (-1)] != 125 ? -3 : 0;
        if (i != 0) {
            this.ap = null;
            throw new Exception("Parse Buffer Check Failed :" + i);
        }
        this.ap = ByteBuffer.wrap(bArr);
        this.ap.position(1);
        this.aq = false;
        return 0;
    }

    public int putInt(int i) {
        if (this.aq) {
            a(4);
            this.ap.putInt(i);
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public int putLong(long j) {
        if (this.aq) {
            a(8);
            this.ap.putLong(j);
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public int putString(String str) {
        if (this.aq) {
            byte[] bytes = str != null ? str.getBytes() : null;
            if (bytes == null) {
                bytes = new byte[0];
            }
            if (bytes.length > 2048) {
                throw new Exception("Buffer String Length Error");
            }
            a(bytes.length + 2);
            this.ap.putShort((short) bytes.length);
            if (bytes.length > 0) {
                this.ap.put(bytes);
            }
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }
}
