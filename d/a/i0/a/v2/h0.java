package d.a.i0.a.v2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class h0 {
    public static BitmapFactory.Options a(Uri uri) {
        InputStream openInputStream;
        Context appContext = AppRuntime.getAppContext();
        InputStream inputStream = null;
        if (appContext == null || uri == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            try {
                openInputStream = appContext.getContentResolver().openInputStream(uri);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
            d.a.i0.t.d.d(openInputStream);
        } catch (FileNotFoundException e3) {
            e = e3;
            inputStream = openInputStream;
            e.printStackTrace();
            d.a.i0.t.d.d(inputStream);
            return options;
        } catch (Throwable th2) {
            th = th2;
            inputStream = openInputStream;
            d.a.i0.t.d.d(inputStream);
            throw th;
        }
        return options;
    }

    public static boolean b(Uri uri) {
        BitmapFactory.Options a2 = a(uri);
        if (a2 != null) {
            String str = a2.outMimeType;
            return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("image/gif");
        }
        return false;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return b(o0.p(str));
    }

    public static boolean d(int i2, int i3, boolean z) {
        if (z) {
            return false;
        }
        float f2 = i2;
        if (f2 > 100.0f) {
            float f3 = i3;
            if (f3 > 100.0f) {
                float f4 = f2 / f3;
                return f4 > 2.5f || 1.0f / f4 > 2.5f;
            }
            return false;
        }
        return false;
    }

    public static boolean e(Uri uri) {
        BitmapFactory.Options a2 = a(uri);
        return a2 != null && d(a2.outWidth, a2.outHeight, b(uri));
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return e(o0.p(str));
    }
}
