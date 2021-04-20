package d.c.c.b.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.c.c.b.b.d;
import d.c.c.b.d.k;
import d.c.c.b.d.o;
import d.c.c.b.d.q;
/* loaded from: classes5.dex */
public class e extends Request<Bitmap> {
    public static final Object A = new Object();
    public final Object x;
    public final d.j y;
    @Nullable
    @GuardedBy("mLock")
    public o.a<Bitmap> z;

    public e(String str, o.a<Bitmap> aVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        this.x = new Object();
        setRetryPolicy(new d.c.c.b.d.g(1000, 2, 2.0f));
        this.z = aVar;
        this.y = new d.c.c.b.e.a(i, i2, scaleType, config);
        setShouldCache(false);
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public o<Bitmap> a(k kVar) {
        o<Bitmap> b2;
        synchronized (A) {
            try {
                try {
                    b2 = b(kVar);
                } catch (OutOfMemoryError e2) {
                    q.d("Caught OOM for %d byte image, url=%s", Integer.valueOf(kVar.f66569b.length), getUrl());
                    return o.b(new com.bytedance.sdk.adnet.err.e(e2, VAdError.IMAGE_OOM_FAIL_CODE));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b2;
    }

    public final o<Bitmap> b(k kVar) {
        Bitmap f2 = f(kVar.f66569b);
        if (f2 == null) {
            return o.b(new com.bytedance.sdk.adnet.err.e(kVar));
        }
        return o.c(f2, d.c.c.b.e.c.b(kVar));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.x) {
            this.z = null;
        }
    }

    public Bitmap f(byte[] bArr) {
        return this.y.a(bArr);
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(o<Bitmap> oVar) {
        o.a<Bitmap> aVar;
        synchronized (this.x) {
            aVar = this.z;
        }
        if (aVar != null) {
            aVar.a(oVar);
        }
    }
}
