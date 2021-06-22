package d.a.d0.d.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.service.network.Request;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class h {

    /* loaded from: classes2.dex */
    public static class a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.a.b.a f43484a;

        public a(d.a.d0.a.b.a aVar) {
            this.f43484a = aVar;
        }

        @Override // d.a.d0.d.a.k
        public void a(Throwable th) {
            if (this.f43484a.s()) {
                Log.e("ParallelCharge", "als on error response", th);
            }
        }

        @Override // d.a.d0.d.a.k
        public void b(long j, InputStream inputStream) {
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.d0.a.b.a aVar = d.a.d0.a.b.a.f43374a.get();
        Request.c cVar = new Request.c(aVar.o(), str);
        cVar.k("User-Agent", aVar.h());
        cVar.l().d(new a(aVar));
    }
}
