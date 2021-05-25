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
import d.b.c.b.d.g;
import d.b.c.b.d.k;
import d.b.c.b.d.o;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends Request<d> {
    public static final Object k = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final Object f29242c;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: d  reason: collision with root package name */
    public a f29243d;

    /* renamed from: e  reason: collision with root package name */
    public final Bitmap.Config f29244e;

    /* renamed from: f  reason: collision with root package name */
    public final int f29245f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29246g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView.ScaleType f29247h;

    /* renamed from: i  reason: collision with root package name */
    public r f29248i;
    public long j;

    /* loaded from: classes6.dex */
    public interface a extends o.a<d> {
        void a();

        @Override // d.b.c.b.d.o.a
        /* synthetic */ void a(o<T> oVar);

        void a(String str, d dVar);

        @Override // d.b.c.b.d.o.a
        /* synthetic */ void b(o<T> oVar);
    }

    public c(String str, a aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        this.f29242c = new Object();
        setRetryPolicy(new g(1000, 2, 2.0f));
        this.f29243d = aVar;
        this.f29244e = config;
        this.f29245f = i2;
        this.f29246g = i3;
        this.f29247h = scaleType;
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
        final byte[] bArr = kVar.f65793b;
        f();
        String a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(getUrl(), this.f29245f, this.f29246g, this.f29247h);
        if (bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            try {
                com.bytedance.sdk.openadsdk.i.a.a.a().a(a2, bArr);
                if (this.f29243d != null) {
                    this.f26897b.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.f29243d != null) {
                                d dVar = new d(bArr);
                                dVar.a(kVar.f65795d);
                                dVar.a(kVar.f65794c);
                                c.this.f29243d.a(c.this.getUrl(), dVar);
                            }
                        }
                    });
                }
                d dVar = new d(bArr);
                dVar.a(kVar.f65795d);
                dVar.a(kVar.f65794c);
                return o.c(dVar, d.b.c.b.e.c.b(kVar));
            } catch (Exception unused) {
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f29245f == 0 && this.f29246g == 0) {
            options.inPreferredConfig = this.f29244e;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a3 = a(this.f29245f, this.f29246g, i2, i3, this.f29247h);
            int a4 = a(this.f29246g, this.f29245f, i3, i2, this.f29247h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a3, a4);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > a3 || decodeByteArray.getHeight() > a4)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a3, a4, true);
                decodeByteArray.recycle();
                bitmap = createScaledBitmap;
                if (bitmap != null) {
                    return o.b(new e(kVar));
                }
                if (this.f29243d != null) {
                    this.f26897b.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.f29243d != null) {
                                d dVar2 = new d(bitmap);
                                dVar2.a(kVar.f65795d);
                                dVar2.a(kVar.f65794c);
                                c.this.f29243d.a(c.this.getUrl(), dVar2);
                            }
                        }
                    });
                }
                byte[] b2 = f.b(bitmap);
                com.bytedance.sdk.openadsdk.i.a.a.a().a(a2, b2);
                if (this.f29243d != null) {
                    a(this.j, b2, bitmap, kVar.f65794c);
                    this.f29243d.a();
                }
                d dVar2 = new d(b2);
                dVar2.a(kVar.f65795d);
                dVar2.a(kVar.f65794c);
                return o.c(dVar2, d.b.c.b.e.c.b(kVar));
            }
        }
        bitmap = decodeByteArray;
        if (bitmap != null) {
        }
    }

    private void f() {
        r rVar = this.f29248i;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.j = currentTimeMillis;
            this.f29248i.p(currentTimeMillis);
            r rVar2 = this.f29248i;
            rVar2.i(this.j - rVar2.v());
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f29242c) {
            this.f29243d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    public static int a(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i2 == 0 ? i4 : i2;
        } else if (i2 == 0) {
            return (int) (i4 * (i3 / i5));
        } else if (i3 == 0) {
            return i2;
        } else {
            double d2 = i5 / i4;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d3 = i3;
                return ((double) i2) * d2 < d3 ? (int) (d3 / d2) : i2;
            }
            double d4 = i3;
            return ((double) i2) * d2 > d4 ? (int) (d4 / d2) : i2;
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
        synchronized (this.f29242c) {
            aVar = this.f29243d;
        }
        if (aVar != null) {
            aVar.a(oVar);
        }
    }

    public void a(r rVar) {
        this.f29248i = rVar;
    }

    private void a(long j, byte[] bArr, Bitmap bitmap, Map<String, String> map) {
        r rVar = this.f29248i;
        if (rVar != null && rVar.z()) {
            if (bArr != null && this.f29248i.i() == 0.0d) {
                this.f29248i.a(bArr.length / 1024.0f);
            }
            if (bitmap != null && TextUtils.isEmpty(this.f29248i.j())) {
                this.f29248i.b(bitmap.getWidth() + "X" + bitmap.getHeight());
            }
            if (map != null && map.size() > 0 && this.f29248i.k() == null) {
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
                this.f29248i.a(jSONObject);
            }
            this.f29248i.j(System.currentTimeMillis() - j);
            this.f29248i.b(System.currentTimeMillis() - this.f29248i.t());
        }
    }

    @VisibleForTesting
    public static int a(int i2, int i3, int i4, int i5) {
        double min = Math.min(i2 / i4, i3 / i5);
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
