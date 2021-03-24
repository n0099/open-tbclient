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
    public static final String f65640c = String.format("application/json; charset=%s", "utf-8");

    /* renamed from: d  reason: collision with root package name */
    public final Object f65641d;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    public o.a<T> f65642e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final String f65643f;

    public g(int i, String str, @Nullable String str2, @Nullable o.a<T> aVar) {
        super(i, str, aVar);
        this.f65641d = new Object();
        this.f65642e = aVar;
        this.f65643f = str2;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public abstract o<T> a(k kVar);

    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(o<T> oVar) {
        o.a<T> aVar;
        synchronized (this.f65641d) {
            aVar = this.f65642e;
        }
        if (aVar != null) {
            aVar.a(oVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f65641d) {
            this.f65642e = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public byte[] getBody() {
        try {
            if (this.f65643f == null) {
                return null;
            }
            return this.f65643f.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            q.e("Unsupported Encoding while trying to get the bytes of %s using %s", this.f65643f, "utf-8");
            return null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public String getBodyContentType() {
        return f65640c;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }
}
