package d.a.l0.n.i.i.f;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes3.dex */
public class a implements e {

    /* renamed from: e  reason: collision with root package name */
    public final Response f48044e;

    public a(@NonNull Response response) {
        this.f48044e = response;
    }

    @Override // d.a.l0.n.i.i.f.e
    @Nullable
    public d body() {
        ResponseBody body = this.f48044e.body();
        if (body == null) {
            return null;
        }
        return new b(body);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f48044e.close();
    }

    @Override // d.a.l0.n.i.i.f.e
    public int code() {
        return this.f48044e.code();
    }
}
