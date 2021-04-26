package d.a.h0.a.b1.e.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public BitmapRegionDecoder f41461a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f41462b = new Object();

    @Override // d.a.h0.a.b1.e.d.d
    public Point a(Context context, Bitmap bitmap) throws Exception {
        InputStream inputStream;
        try {
            inputStream = b(bitmap);
            try {
                this.f41461a = BitmapRegionDecoder.newInstance(inputStream, false);
                d.a.h0.p.d.a(inputStream);
                return new Point(this.f41461a.getWidth(), this.f41461a.getHeight());
            } catch (Throwable th) {
                th = th;
                d.a.h0.p.d.a(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public InputStream b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        if (bitmap.hasAlpha()) {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override // d.a.h0.a.b1.e.d.d
    public Bitmap decodeRegion(Rect rect, int i2) {
        Bitmap decodeRegion;
        synchronized (this.f41462b) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i2;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            decodeRegion = this.f41461a.decodeRegion(rect, options);
            if (decodeRegion == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
        }
        return decodeRegion;
    }

    @Override // d.a.h0.a.b1.e.d.d
    public Point init(Context context, Uri uri) throws Exception {
        Resources resourcesForApplication;
        int i2;
        String uri2 = uri.toString();
        if (uri2.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resourcesForApplication = context.getResources();
            } else {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i2 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                i2 = 0;
            }
            this.f41461a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i2), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.f41461a = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.f41461a = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            InputStream inputStream = null;
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                this.f41461a = BitmapRegionDecoder.newInstance(inputStream, false);
            } finally {
                d.a.h0.p.d.a(inputStream);
            }
        }
        return new Point(this.f41461a.getWidth(), this.f41461a.getHeight());
    }

    @Override // d.a.h0.a.b1.e.d.d
    public boolean isReady() {
        BitmapRegionDecoder bitmapRegionDecoder = this.f41461a;
        return (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) ? false : true;
    }

    @Override // d.a.h0.a.b1.e.d.d
    public void recycle() {
        this.f41461a.recycle();
    }
}
