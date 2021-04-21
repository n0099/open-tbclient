package d.h.c.d;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public interface f extends j {
    @Override // d.h.c.d.j
    f a(CharSequence charSequence);

    @Override // d.h.c.d.j
    f b(int i);

    @Override // d.h.c.d.j
    f c(CharSequence charSequence, Charset charset);

    @Override // d.h.c.d.j
    f d(long j);

    <T> f f(T t, Funnel<? super T> funnel);

    HashCode g();

    f h(byte[] bArr, int i, int i2);

    f i(ByteBuffer byteBuffer);
}
