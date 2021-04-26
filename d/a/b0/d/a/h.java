package d.a.b0.d.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.service.network.Request;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class h {

    /* loaded from: classes2.dex */
    public static class a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.b0.a.b.a f39386a;

        public a(d.a.b0.a.b.a aVar) {
            this.f39386a = aVar;
        }

        @Override // d.a.b0.d.a.k
        public void a(Throwable th) {
            if (this.f39386a.s()) {
                Log.e("ParallelCharge", "als on error response", th);
            }
        }

        @Override // d.a.b0.d.a.k
        public void b(long j, InputStream inputStream) {
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.b0.a.b.a aVar = d.a.b0.a.b.a.f39288a.get();
        Request.c cVar = new Request.c(aVar.o(), str);
        cVar.k("User-Agent", aVar.h());
        cVar.l().d(new a(aVar));
    }
}
