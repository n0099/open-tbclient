package d.a.l0.a.i1.e.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import d.a.l0.a.k;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42906a = k.f43199a;

    @Override // d.a.l0.a.i1.e.d.c
    public Bitmap decode(Context context, Uri uri) throws Exception {
        Bitmap bitmap;
        Resources resourcesForApplication;
        String uri2 = uri.toString();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (uri2.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resourcesForApplication = context.getResources();
            } else {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            int i2 = 0;
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    i2 = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            bitmap = BitmapFactory.decodeResource(context.getResources(), i2, options);
        } else {
            InputStream inputStream = null;
            if (uri2.startsWith("file:///android_asset/")) {
                bitmap = BitmapFactory.decodeStream(context.getAssets().open(uri2.substring(22)), null, options);
            } else if (uri2.startsWith("file://")) {
                bitmap = BitmapFactory.decodeFile(uri2.substring(7), options);
            } else {
                try {
                    InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
                        d.a.l0.t.d.d(openInputStream);
                        bitmap = decodeStream;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = openInputStream;
                        d.a.l0.t.d.d(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        if (bitmap == null) {
            if (!f42906a) {
                d.a.l0.a.e0.d.h("SkiaImageDecoder", "bitmap is null");
            } else {
                throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
            }
        }
        return bitmap;
    }
}
