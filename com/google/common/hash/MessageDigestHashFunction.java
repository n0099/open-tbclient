package com.google.common.hash;

import d.h.c.a.n;
import d.h.c.d.f;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class MessageDigestHashFunction extends d.h.c.d.b implements Serializable {
    public final int bytes;
    public final MessageDigest prototype;
    public final boolean supportsClone;
    public final String toString;

    /* loaded from: classes6.dex */
    public static final class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final String algorithmName;
        public final int bytes;
        public final String toString;

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }

        public SerializedForm(String str, int i, String str2) {
            this.algorithmName = str;
            this.bytes = i;
            this.toString = str2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends d.h.c.d.a {

        /* renamed from: b  reason: collision with root package name */
        public final MessageDigest f31194b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31195c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f31196d;

        @Override // d.h.c.d.f
        public HashCode g() {
            q();
            this.f31196d = true;
            if (this.f31195c == this.f31194b.getDigestLength()) {
                return HashCode.fromBytesNoCopy(this.f31194b.digest());
            }
            return HashCode.fromBytesNoCopy(Arrays.copyOf(this.f31194b.digest(), this.f31195c));
        }

        @Override // d.h.c.d.a
        public void m(byte b2) {
            q();
            this.f31194b.update(b2);
        }

        @Override // d.h.c.d.a
        public void n(ByteBuffer byteBuffer) {
            q();
            this.f31194b.update(byteBuffer);
        }

        @Override // d.h.c.d.a
        public void p(byte[] bArr, int i, int i2) {
            q();
            this.f31194b.update(bArr, i, i2);
        }

        public final void q() {
            n.x(!this.f31196d, "Cannot re-use a Hasher after calling hash() on it");
        }

        public b(MessageDigest messageDigest, int i) {
            this.f31194b = messageDigest;
            this.f31195c = i;
        }
    }

    public MessageDigestHashFunction(String str, String str2) {
        MessageDigest a2 = a(str);
        this.prototype = a2;
        this.bytes = a2.getDigestLength();
        n.p(str2);
        this.toString = str2;
        this.supportsClone = b(this.prototype);
    }

    public static MessageDigest a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static boolean b(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    public int bits() {
        return this.bytes * 8;
    }

    @Override // d.h.c.d.e
    public f newHasher() {
        if (this.supportsClone) {
            try {
                return new b((MessageDigest) this.prototype.clone(), this.bytes);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(a(this.prototype.getAlgorithm()), this.bytes);
    }

    public String toString() {
        return this.toString;
    }

    public Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString);
    }

    public MessageDigestHashFunction(String str, int i, String str2) {
        n.p(str2);
        this.toString = str2;
        MessageDigest a2 = a(str);
        this.prototype = a2;
        int digestLength = a2.getDigestLength();
        n.g(i >= 4 && i <= digestLength, "bytes (%s) must be >= 4 and < %s", i, digestLength);
        this.bytes = i;
        this.supportsClone = b(this.prototype);
    }
}
