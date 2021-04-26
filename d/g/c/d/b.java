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

    public HashCode hashInt(int i2) {
        return newHasher(4).a(i2).e();
    }

    public HashCode hashLong(long j) {
        return newHasher(8).b(j).e();
    }

    @Override // d.g.c.d.e
    public <T> HashCode hashObject(T t, Funnel<? super T> funnel) {
        f newHasher = newHasher();
        newHasher.g(t, funnel);
        return newHasher.e();
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().d(charSequence, charset).e();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        f newHasher = newHasher(charSequence.length() * 2);
        newHasher.c(charSequence);
        return newHasher.e();
    }

    public f newHasher(int i2) {
        n.f(i2 >= 0, "expectedInputSize must be >= 0 but was %s", i2);
        return newHasher();
    }

    public HashCode hashBytes(byte[] bArr, int i2, int i3) {
        n.v(i2, i2 + i3, bArr.length);
        return newHasher(i3).h(bArr, i2, i3).e();
    }

    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).i(byteBuffer).e();
    }
}
