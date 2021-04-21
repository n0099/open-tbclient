package d.c.c.b.b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Request;
import d.c.c.b.d.k;
import d.c.c.b.d.o;
import d.c.c.b.d.q;
import java.io.UnsupportedEncodingException;
/* loaded from: classes5.dex */
public abstract class g<T> extends Request<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final String f66581c = String.format("application/json; charset=%s", "utf-8");

    /* renamed from: d  reason: collision with root package name */
    public final Object f66582d;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    public o.a<T> f66583e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final String f66584f;

    public g(int i, String str, @Nullable String str2, @Nullable o.a<T> aVar) {
        super(i, str, aVar);
        this.f66582d = new Object();
        this.f66583e = aVar;
        this.f66584f = str2;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public abstract o<T> a(k kVar);

    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(o<T> oVar) {
        o.a<T> aVar;
        synchronized (this.f66582d) {
            aVar = this.f66583e;
        }
        if (aVar != null) {
            aVar.a(oVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f66582d) {
            this.f66583e = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public byte[] getBody() {
        try {
            if (this.f66584f == null) {
                return null;
            }
            return this.f66584f.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            q.e("Unsupported Encoding while trying to get the bytes of %s using %s", this.f66584f, "utf-8");
            return null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public String getBodyContentType() {
        return f66581c;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }
}
