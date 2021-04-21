package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.err.e;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.utils.f;
import com.bytedance.sdk.openadsdk.utils.u;
import d.c.c.b.d.g;
import d.c.c.b.d.k;
import d.c.c.b.d.o;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends Request<d> {
    public static final Object k = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final Object f29174c;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: d  reason: collision with root package name */
    public a f29175d;

    /* renamed from: e  reason: collision with root package name */
    public final Bitmap.Config f29176e;

    /* renamed from: f  reason: collision with root package name */
    public final int f29177f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29178g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView.ScaleType f29179h;
    public r i;
    public long j;

    /* loaded from: classes5.dex */
    public interface a extends o.a<d> {
        void a();

        @Override // d.c.c.b.d.o.a
        /* synthetic */ void a(o<T> oVar);

        void a(String str, d dVar);

        @Override // d.c.c.b.d.o.a
        /* synthetic */ void b(o<T> oVar);
    }

    public c(String str, a aVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        this.f29174c = new Object();
        setRetryPolicy(new g(1000, 2, 2.0f));
        this.f29175d = aVar;
        this.f29176e = config;
        this.f29177f = i;
        this.f29178g = i2;
        this.f29179h = scaleType;
        setShouldCache(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private o<d> b(final k kVar) {
        Bitmap decodeByteArray;
        final Bitmap bitmap;
        final byte[] bArr = kVar.f66664b;
        f();
        String a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(getUrl(), this.f29177f, this.f29178g, this.f29179h);
        if (bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            try {
                com.bytedance.sdk.openadsdk.i.a.a.a().a(a2, bArr);
                if (this.f29175d != null) {
                    this.f26908b.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.f29175d != null) {
                                d dVar = new d(bArr);
                                dVar.a(kVar.f66666d);
                                dVar.a(kVar.f66665c);
                                c.this.f29175d.a(c.this.getUrl(), dVar);
                            }
                        }
                    });
                }
                d dVar = new d(bArr);
                dVar.a(kVar.f66666d);
                dVar.a(kVar.f66665c);
                return o.c(dVar, d.c.c.b.e.c.b(kVar));
            } catch (Exception unused) {
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f29177f == 0 && this.f29178g == 0) {
            options.inPreferredConfig = this.f29176e;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int a3 = a(this.f29177f, this.f29178g, i, i2, this.f29179h);
            int a4 = a(this.f29178g, this.f29177f, i2, i, this.f29179h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i, i2, a3, a4);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > a3 || decodeByteArray.getHeight() > a4)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a3, a4, true);
                decodeByteArray.recycle();
                bitmap = createScaledBitmap;
                if (bitmap != null) {
                    return o.b(new e(kVar));
                }
                if (this.f29175d != null) {
                    this.f26908b.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.f29175d != null) {
                                d dVar2 = new d(bitmap);
                                dVar2.a(kVar.f66666d);
                                dVar2.a(kVar.f66665c);
                                c.this.f29175d.a(c.this.getUrl(), dVar2);
                            }
                        }
                    });
                }
                byte[] b2 = f.b(bitmap);
                com.bytedance.sdk.openadsdk.i.a.a.a().a(a2, b2);
                if (this.f29175d != null) {
                    a(this.j, b2, bitmap, kVar.f66665c);
                    this.f29175d.a();
                }
                d dVar2 = new d(b2);
                dVar2.a(kVar.f66666d);
                dVar2.a(kVar.f66665c);
                return o.c(dVar2, d.c.c.b.e.c.b(kVar));
            }
        }
        bitmap = decodeByteArray;
        if (bitmap != null) {
        }
    }

    private void f() {
        r rVar = this.i;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.j = currentTimeMillis;
            this.i.p(currentTimeMillis);
            r rVar2 = this.i;
            rVar2.i(this.j - rVar2.v());
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f29174c) {
            this.f29175d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    public static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        } else if (i == 0) {
            return (int) (i3 * (i2 / i4));
        } else if (i2 == 0) {
            return i;
        } else {
            double d2 = i4 / i3;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d3 = i2;
                return ((double) i) * d2 < d3 ? (int) (d3 / d2) : i;
            }
            double d4 = i2;
            return ((double) i) * d2 > d4 ? (int) (d4 / d2) : i;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public o<d> a(k kVar) {
        o<d> b2;
        synchronized (k) {
            try {
                try {
                    b2 = b(kVar);
                } catch (OutOfMemoryError e2) {
                    u.c("GifRequest", "Caught OOM for byte image", e2);
                    return o.b(new e(e2, VAdError.IMAGE_OOM_FAIL_CODE));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b2;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(o<d> oVar) {
        a aVar;
        synchronized (this.f29174c) {
            aVar = this.f29175d;
        }
        if (aVar != null) {
            aVar.a(oVar);
        }
    }

    public void a(r rVar) {
        this.i = rVar;
    }

    private void a(long j, byte[] bArr, Bitmap bitmap, Map<String, String> map) {
        r rVar = this.i;
        if (rVar != null && rVar.z()) {
            if (bArr != null && this.i.i() == 0.0d) {
                this.i.a(bArr.length / 1024.0f);
            }
            if (bitmap != null && TextUtils.isEmpty(this.i.j())) {
                this.i.b(bitmap.getWidth() + "X" + bitmap.getHeight());
            }
            if (map != null && map.size() > 0 && this.i.k() == null) {
                JSONObject jSONObject = new JSONObject();
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            jSONObject.put(str, map.get(str));
                        } catch (Exception e2) {
                            u.f("GifRequest", e2.getMessage());
                        }
                    }
                }
                this.i.a(jSONObject);
            }
            this.i.j(System.currentTimeMillis() - j);
            this.i.b(System.currentTimeMillis() - this.i.t());
        }
    }

    @VisibleForTesting
    public static int a(int i, int i2, int i3, int i4) {
        double min = Math.min(i / i3, i2 / i4);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (f3 > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }
}
