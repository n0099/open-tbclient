package d.a.i0.n.i.i.f;

import androidx.annotation.NonNull;
import java.nio.channels.ReadableByteChannel;
import okhttp3.ResponseBody;
/* loaded from: classes3.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final ResponseBody f47869a;

    public b(@NonNull ResponseBody responseBody) {
        this.f47869a = responseBody;
    }

    @Override // d.a.i0.n.i.i.f.d
    public long a() {
        return this.f47869a.contentLength();
    }

    @Override // d.a.i0.n.i.i.f.d
    public ReadableByteChannel source() {
        return this.f47869a.source();
    }
}
