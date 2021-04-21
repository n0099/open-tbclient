package d.b.b0.d.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.service.network.Request;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class h {

    /* loaded from: classes2.dex */
    public static class a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.b0.a.b.a f42201a;

        public a(d.b.b0.a.b.a aVar) {
            this.f42201a = aVar;
        }

        @Override // d.b.b0.d.a.k
        public void a(Throwable th) {
            if (this.f42201a.D()) {
                Log.e("ParallelCharge", "als on error response", th);
            }
        }

        @Override // d.b.b0.d.a.k
        public void b(long j, InputStream inputStream) {
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.b0.a.b.a aVar = d.b.b0.a.b.a.f42106a.get();
        Request.c cVar = new Request.c(aVar.y(), str);
        cVar.k("User-Agent", aVar.l());
        cVar.l().d(new a(aVar));
    }
}
