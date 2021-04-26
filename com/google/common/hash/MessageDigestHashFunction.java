package com.google.common.hash;

import d.g.c.a.n;
import d.g.c.d.f;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class MessageDigestHashFunction extends d.g.c.d.b implements Serializable {
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

        public SerializedForm(String str, int i2, String str2) {
            this.algorithmName = str;
            this.bytes = i2;
            this.toString = str2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends d.g.c.d.a {

        /* renamed from: b  reason: collision with root package name */
        public final MessageDigest f32172b;

        /* renamed from: c  reason: collision with root package name */
        public final int f32173c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f32174d;

        @Override // d.g.c.d.f
        public HashCode e() {
            q();
            this.f32174d = true;
            if (this.f32173c == this.f32172b.getDigestLength()) {
                return HashCode.fromBytesNoCopy(this.f32172b.digest());
            }
            return HashCode.fromBytesNoCopy(Arrays.copyOf(this.f32172b.digest(), this.f32173c));
        }

        @Override // d.g.c.d.a
        public void m(byte b2) {
            q();
            this.f32172b.update(b2);
        }

        @Override // d.g.c.d.a
        public void n(ByteBuffer byteBuffer) {
            q();
            this.f32172b.update(byteBuffer);
        }

        @Override // d.g.c.d.a
        public void p(byte[] bArr, int i2, int i3) {
            q();
            this.f32172b.update(bArr, i2, i3);
        }

        public final void q() {
            n.x(!this.f32174d, "Cannot re-use a Hasher after calling hash() on it");
        }

        public b(MessageDigest messageDigest, int i2) {
            this.f32172b = messageDigest;
            this.f32173c = i2;
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

    @Override // d.g.c.d.e
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

    public MessageDigestHashFunction(String str, int i2, String str2) {
        n.p(str2);
        this.toString = str2;
        MessageDigest a2 = a(str);
        this.prototype = a2;
        int digestLength = a2.getDigestLength();
        n.g(i2 >= 4 && i2 <= digestLength, "bytes (%s) must be >= 4 and < %s", i2, digestLength);
        this.bytes = i2;
        this.supportsClone = b(this.prototype);
    }
}
