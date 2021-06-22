package d.b.c.b.b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Request;
import d.b.c.b.d.k;
import d.b.c.b.d.o;
import d.b.c.b.d.q;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public abstract class g<T> extends Request<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final String f69541c = String.format("application/json; charset=%s", "utf-8");

    /* renamed from: d  reason: collision with root package name */
    public final Object f69542d;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    public o.a<T> f69543e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final String f69544f;

    public g(int i2, String str, @Nullable String str2, @Nullable o.a<T> aVar) {
        super(i2, str, aVar);
        this.f69542d = new Object();
        this.f69543e = aVar;
        this.f69544f = str2;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public abstract o<T> a(k kVar);

    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(o<T> oVar) {
        o.a<T> aVar;
        synchronized (this.f69542d) {
            aVar = this.f69543e;
        }
        if (aVar != null) {
            aVar.a(oVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f69542d) {
            this.f69543e = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public byte[] getBody() {
        try {
            if (this.f69544f == null) {
                return null;
            }
            return this.f69544f.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            q.e("Unsupported Encoding while trying to get the bytes of %s using %s", this.f69544f, "utf-8");
            return null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public String getBodyContentType() {
        return f69541c;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }
}
