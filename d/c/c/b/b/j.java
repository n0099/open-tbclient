package d.c.c.b.b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Request;
import d.c.c.b.d.k;
import d.c.c.b.d.o;
import java.io.UnsupportedEncodingException;
/* loaded from: classes5.dex */
public class j extends Request<String> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f66588c;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: d  reason: collision with root package name */
    public o.a<String> f66589d;

    public j(int i, String str, @Nullable o.a<String> aVar) {
        super(i, str, aVar);
        this.f66588c = new Object();
        this.f66589d = aVar;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(o<String> oVar) {
        o.a<String> aVar;
        synchronized (this.f66588c) {
            aVar = this.f66589d;
        }
        if (aVar != null) {
            aVar.a(oVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f66588c) {
            this.f66589d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public o<String> a(k kVar) {
        String str;
        try {
            str = new String(kVar.f66664b, d.c.c.b.e.c.d(kVar.f66665c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(kVar.f66664b);
        }
        return o.c(str, d.c.c.b.e.c.b(kVar));
    }
}
