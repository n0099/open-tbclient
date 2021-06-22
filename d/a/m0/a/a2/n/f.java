package d.a.m0.a.a2.n;

import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
/* loaded from: classes3.dex */
public abstract class f<T> implements d.a.m0.a.b1.b<byte[], T> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.b1.b
    /* renamed from: a */
    public final byte[] call(T t) throws Exception {
        if (t == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d.a.m0.a.b1.d dVar = new d.a.m0.a.b1.d(byteArrayOutputStream);
        b(t, dVar);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        dVar.close();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public abstract void b(@NonNull T t, @NonNull d.a.m0.a.b1.d dVar) throws Exception;
}
