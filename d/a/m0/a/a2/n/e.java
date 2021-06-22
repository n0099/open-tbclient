package d.a.m0.a.a2.n;

import androidx.annotation.NonNull;
import java.io.ByteArrayInputStream;
/* loaded from: classes3.dex */
public abstract class e<T> implements d.a.m0.a.b1.b<T, byte[]> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.b1.b
    /* renamed from: a */
    public final T call(byte[] bArr) throws Exception {
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        d.a.m0.a.b1.c cVar = new d.a.m0.a.b1.c(byteArrayInputStream);
        T b2 = b(cVar);
        cVar.close();
        byteArrayInputStream.close();
        return b2;
    }

    public abstract T b(@NonNull d.a.m0.a.b1.c cVar) throws Exception;
}
