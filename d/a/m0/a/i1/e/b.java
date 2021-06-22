package d.a.m0.a.i1.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.davemorrissey.labs.subscaleview.ImageSource;
import d.a.m0.a.e0.d;
import d.a.m0.a.k;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f46680i = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f46681a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f46682b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f46683c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46684d;

    /* renamed from: e  reason: collision with root package name */
    public int f46685e;

    /* renamed from: f  reason: collision with root package name */
    public int f46686f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f46687g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46688h;

    public b(Bitmap bitmap, boolean z) {
        this.f46682b = bitmap;
        this.f46681a = null;
        this.f46683c = null;
        this.f46684d = false;
        this.f46685e = bitmap.getWidth();
        this.f46686f = bitmap.getHeight();
        this.f46688h = z;
    }

    public static b a(String str) {
        if (str == null) {
            if (!f46680i) {
                d.h("ImageSource", "asset name is null");
                return null;
            }
            throw new NullPointerException("Asset name must not be null");
        }
        return o("file:///android_asset/" + str);
    }

    public static b b(Bitmap bitmap) {
        if (bitmap == null) {
            if (!f46680i) {
                d.h("ImageSource", "bitmap is null");
                return null;
            }
            throw new NullPointerException("Bitmap must not be null");
        }
        return new b(bitmap, true);
    }

    public static b k(int i2) {
        return new b(i2);
    }

    public static b o(String str) {
        if (str == null) {
            if (!f46680i) {
                d.h("ImageSource", "uri is null");
                return null;
            }
            throw new NullPointerException("Uri must not be null");
        }
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = ImageSource.FILE_SCHEME + str;
        }
        return new b(Uri.parse(str));
    }

    public final Bitmap c() {
        return this.f46682b;
    }

    public final Integer d() {
        return this.f46683c;
    }

    public final int e() {
        return this.f46686f;
    }

    public final Rect f() {
        return this.f46687g;
    }

    public final int g() {
        return this.f46685e;
    }

    public final boolean h() {
        return this.f46684d;
    }

    public final Uri i() {
        return this.f46681a;
    }

    public final boolean j() {
        return this.f46688h;
    }

    public b l(boolean z) {
        this.f46684d = z;
        return this;
    }

    public b m() {
        l(false);
        return this;
    }

    public b n() {
        l(true);
        return this;
    }

    public b(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith(ImageSource.FILE_SCHEME) && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.f46682b = null;
        this.f46681a = uri;
        this.f46683c = null;
        this.f46684d = true;
    }

    public b(int i2) {
        this.f46682b = null;
        this.f46681a = null;
        this.f46683c = Integer.valueOf(i2);
        this.f46684d = true;
    }
}
