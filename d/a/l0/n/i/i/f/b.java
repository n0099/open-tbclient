package d.a.l0.n.i.i.f;

import androidx.annotation.NonNull;
import java.nio.channels.ReadableByteChannel;
import okhttp3.ResponseBody;
/* loaded from: classes3.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final ResponseBody f48045a;

    public b(@NonNull ResponseBody responseBody) {
        this.f48045a = responseBody;
    }

    @Override // d.a.l0.n.i.i.f.d
    public long a() {
        return this.f48045a.contentLength();
    }

    @Override // d.a.l0.n.i.i.f.d
    public ReadableByteChannel source() {
        return this.f48045a.source();
    }
}
