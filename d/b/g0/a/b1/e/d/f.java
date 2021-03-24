package d.b.g0.a.b1.e.d;

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
    public BitmapRegionDecoder f43462a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f43463b = new Object();

    @Override // d.b.g0.a.b1.e.d.d
    public Point a(Context context, Bitmap bitmap) throws Exception {
        InputStream inputStream;
        try {
            inputStream = b(bitmap);
            try {
                this.f43462a = BitmapRegionDecoder.newInstance(inputStream, false);
                d.b.g0.p.d.a(inputStream);
                return new Point(this.f43462a.getWidth(), this.f43462a.getHeight());
            } catch (Throwable th) {
                th = th;
                d.b.g0.p.d.a(inputStream);
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

    @Override // d.b.g0.a.b1.e.d.d
    public Bitmap decodeRegion(Rect rect, int i) {
        Bitmap decodeRegion;
        synchronized (this.f43463b) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            decodeRegion = this.f43462a.decodeRegion(rect, options);
            if (decodeRegion == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
        }
        return decodeRegion;
    }

    @Override // d.b.g0.a.b1.e.d.d
    public Point init(Context context, Uri uri) throws Exception {
        Resources resourcesForApplication;
        int i;
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
                i = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                i = 0;
            }
            this.f43462a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.f43462a = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.f43462a = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            InputStream inputStream = null;
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                this.f43462a = BitmapRegionDecoder.newInstance(inputStream, false);
            } finally {
                d.b.g0.p.d.a(inputStream);
            }
        }
        return new Point(this.f43462a.getWidth(), this.f43462a.getHeight());
    }

    @Override // d.b.g0.a.b1.e.d.d
    public boolean isReady() {
        BitmapRegionDecoder bitmapRegionDecoder = this.f43462a;
        return (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) ? false : true;
    }

    @Override // d.b.g0.a.b1.e.d.d
    public void recycle() {
        this.f43462a.recycle();
    }
}
