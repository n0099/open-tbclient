package d.b.c.b.b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Request;
import d.b.c.b.d.k;
import d.b.c.b.d.o;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public class j extends Request<String> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f69444c;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: d  reason: collision with root package name */
    public o.a<String> f69445d;

    public j(int i2, String str, @Nullable o.a<String> aVar) {
        super(i2, str, aVar);
        this.f69444c = new Object();
        this.f69445d = aVar;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(o<String> oVar) {
        o.a<String> aVar;
        synchronized (this.f69444c) {
            aVar = this.f69445d;
        }
        if (aVar != null) {
            aVar.a(oVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f69444c) {
            this.f69445d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public o<String> a(k kVar) {
        String str;
        try {
            str = new String(kVar.f69524b, d.b.c.b.e.c.d(kVar.f69525c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(kVar.f69524b);
        }
        return o.c(str, d.b.c.b.e.c.b(kVar));
    }
}
