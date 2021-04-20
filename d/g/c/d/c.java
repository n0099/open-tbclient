package d.g.c.d;

import com.google.common.hash.Funnel;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class c implements f {
    @Override // d.g.c.d.f, d.g.c.d.j
    public /* bridge */ /* synthetic */ j a(CharSequence charSequence) {
        a(charSequence);
        return this;
    }

    @Override // d.g.c.d.f
    public <T> f f(T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }

    @Override // d.g.c.d.f
    public abstract f h(byte[] bArr, int i, int i2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.d.j
    /* renamed from: j */
    public f e(byte[] bArr) {
        return h(bArr, 0, bArr.length);
    }

    public abstract f k(char c2);

    @Override // d.g.c.d.f, d.g.c.d.j
    public f a(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            k(charSequence.charAt(i));
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.d.f, d.g.c.d.j
    public f c(CharSequence charSequence, Charset charset) {
        return e(charSequence.toString().getBytes(charset));
    }
}
