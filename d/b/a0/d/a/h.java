package d.b.a0.d.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.service.network.Request;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class h {

    /* loaded from: classes2.dex */
    public static class a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.a0.a.b.a f41912a;

        public a(d.b.a0.a.b.a aVar) {
            this.f41912a = aVar;
        }

        @Override // d.b.a0.d.a.k
        public void a(Throwable th) {
            if (this.f41912a.D()) {
                Log.e("ParallelCharge", "als on error response", th);
            }
        }

        @Override // d.b.a0.d.a.k
        public void b(long j, InputStream inputStream) {
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.a0.a.b.a aVar = d.b.a0.a.b.a.f41817a.get();
        Request.c cVar = new Request.c(aVar.y(), str);
        cVar.k("User-Agent", aVar.l());
        cVar.l().d(new a(aVar));
    }
}
