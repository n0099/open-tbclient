package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.g;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.err.e;
import com.bytedance.sdk.openadsdk.utils.f;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes4.dex */
public class c extends Request<byte[]> {
    private static final Object i = new Object();
    private final Object c;
    @Nullable
    @GuardedBy("mLock")
    private a d;
    private final Bitmap.Config e;
    private final int f;
    private final int g;
    private final ImageView.ScaleType h;

    /* loaded from: classes4.dex */
    public interface a extends p.a<byte[]> {
        void a(String str, byte[] bArr);
    }

    public c(String str, a aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        this.c = new Object();
        setRetryPolicy(new g(1000, 2, 2.0f));
        this.d = aVar;
        this.e = config;
        this.f = i2;
        this.g = i3;
        this.h = scaleType;
        setShouldCache(false);
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    private static int a(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i2 == 0 ? i4 : i2;
        } else if (i2 == 0) {
            return (int) ((i3 / i5) * i4);
        } else {
            if (i3 != 0) {
                double d = i5 / i4;
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    if (i2 * d < i3) {
                        return (int) (i3 / d);
                    }
                    return i2;
                } else if (i2 * d > i3) {
                    return (int) (i3 / d);
                } else {
                    return i2;
                }
            }
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public p<byte[]> a(l lVar) {
        p<byte[]> c;
        synchronized (i) {
            try {
                c = b(lVar);
            } catch (OutOfMemoryError e) {
                u.c("GifRequest", "Caught OOM for byte image", e);
                c = p.c(new e(e));
            }
        }
        return c;
    }

    private p<byte[]> b(l lVar) {
        Bitmap bitmap;
        final byte[] bArr = lVar.f6341b;
        String a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(getUrl(), this.f, this.g, this.h);
        if (bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            try {
                com.bytedance.sdk.openadsdk.i.a.a.a().a(a2, bArr);
                if (this.d != null) {
                    this.f6310b.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.d != null) {
                                c.this.d.a(c.this.getUrl(), bArr);
                            }
                        }
                    });
                }
                return p.a(bArr, com.bytedance.sdk.adnet.d.c.c(lVar));
            } catch (Exception e) {
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f == 0 && this.g == 0) {
            options.inPreferredConfig = this.e;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a3 = a(this.f, this.g, i2, i3, this.h);
            int a4 = a(this.g, this.f, i3, i2, this.h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a3, a4);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray == null || (decodeByteArray.getWidth() <= a3 && decodeByteArray.getHeight() <= a4)) {
                bitmap = decodeByteArray;
            } else {
                bitmap = Bitmap.createScaledBitmap(decodeByteArray, a3, a4, true);
                decodeByteArray.recycle();
            }
        }
        if (bitmap == null) {
            return p.c(new e(lVar));
        }
        final byte[] b2 = f.b(bitmap);
        com.bytedance.sdk.openadsdk.i.a.a.a().a(a2, b2);
        if (this.d != null) {
            this.f6310b.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.d != null) {
                        c.this.d.a(c.this.getUrl(), b2);
                    }
                }
            });
        }
        return p.a(b2, com.bytedance.sdk.adnet.d.c.c(lVar));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.c) {
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(p<byte[]> pVar) {
        a aVar;
        synchronized (this.c) {
            aVar = this.d;
        }
        if (aVar != null) {
            aVar.a(pVar);
        }
    }

    @VisibleForTesting
    static int a(int i2, int i3, int i4, int i5) {
        float f = 1.0f;
        while (f * 2.0f <= Math.min(i2 / i4, i3 / i5)) {
            f *= 2.0f;
        }
        return (int) f;
    }
}
