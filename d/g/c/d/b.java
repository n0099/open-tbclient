package d.g.c.d;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import d.g.c.a.n;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class b implements e {
    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    public HashCode hashInt(int i) {
        return newHasher(4).b(i).g();
    }

    public HashCode hashLong(long j) {
        return newHasher(8).d(j).g();
    }

    @Override // d.g.c.d.e
    public <T> HashCode hashObject(T t, Funnel<? super T> funnel) {
        f newHasher = newHasher();
        newHasher.f(t, funnel);
        return newHasher.g();
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().c(charSequence, charset).g();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        f newHasher = newHasher(charSequence.length() * 2);
        newHasher.a(charSequence);
        return newHasher.g();
    }

    public f newHasher(int i) {
        n.f(i >= 0, "expectedInputSize must be >= 0 but was %s", i);
        return newHasher();
    }

    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        n.v(i, i + i2, bArr.length);
        return newHasher(i2).h(bArr, i, i2).g();
    }

    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).i(byteBuffer).g();
    }
}
