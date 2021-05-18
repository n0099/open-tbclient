package d.a.i0.n.i.i.f;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes3.dex */
public class a implements e {

    /* renamed from: e  reason: collision with root package name */
    public final Response f47868e;

    public a(@NonNull Response response) {
        this.f47868e = response;
    }

    @Override // d.a.i0.n.i.i.f.e
    @Nullable
    public d body() {
        ResponseBody body = this.f47868e.body();
        if (body == null) {
            return null;
        }
        return new b(body);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f47868e.close();
    }

    @Override // d.a.i0.n.i.i.f.e
    public int code() {
        return this.f47868e.code();
    }
}
