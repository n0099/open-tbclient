package d.g.c.d;

import com.google.common.hash.Funnel;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class c implements f {
    @Override // d.g.c.d.f, d.g.c.d.j
    public /* bridge */ /* synthetic */ j c(CharSequence charSequence) {
        c(charSequence);
        return this;
    }

    @Override // d.g.c.d.f
    public <T> f g(T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }

    @Override // d.g.c.d.f
    public abstract f h(byte[] bArr, int i2, int i3);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.d.j
    /* renamed from: j */
    public f f(byte[] bArr) {
        return h(bArr, 0, bArr.length);
    }

    public abstract f k(char c2);

    @Override // d.g.c.d.f, d.g.c.d.j
    public f c(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            k(charSequence.charAt(i2));
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.d.f, d.g.c.d.j
    public f d(CharSequence charSequence, Charset charset) {
        return f(charSequence.toString().getBytes(charset));
    }
}
