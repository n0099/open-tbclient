package d.a.i0.a.i1.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.davemorrissey.labs.subscaleview.ImageSource;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f42722i = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f42723a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f42724b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f42725c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42726d;

    /* renamed from: e  reason: collision with root package name */
    public int f42727e;

    /* renamed from: f  reason: collision with root package name */
    public int f42728f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f42729g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42730h;

    public b(Bitmap bitmap, boolean z) {
        this.f42724b = bitmap;
        this.f42723a = null;
        this.f42725c = null;
        this.f42726d = false;
        this.f42727e = bitmap.getWidth();
        this.f42728f = bitmap.getHeight();
        this.f42730h = z;
    }

    public static b a(String str) {
        if (str == null) {
            if (!f42722i) {
                d.h("ImageSource", "asset name is null");
                return null;
            }
            throw new NullPointerException("Asset name must not be null");
        }
        return o("file:///android_asset/" + str);
    }

    public static b b(Bitmap bitmap) {
        if (bitmap == null) {
            if (!f42722i) {
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
            if (!f42722i) {
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
        return this.f42724b;
    }

    public final Integer d() {
        return this.f42725c;
    }

    public final int e() {
        return this.f42728f;
    }

    public final Rect f() {
        return this.f42729g;
    }

    public final int g() {
        return this.f42727e;
    }

    public final boolean h() {
        return this.f42726d;
    }

    public final Uri i() {
        return this.f42723a;
    }

    public final boolean j() {
        return this.f42730h;
    }

    public b l(boolean z) {
        this.f42726d = z;
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
        this.f42724b = null;
        this.f42723a = uri;
        this.f42725c = null;
        this.f42726d = true;
    }

    public b(int i2) {
        this.f42724b = null;
        this.f42723a = null;
        this.f42725c = Integer.valueOf(i2);
        this.f42726d = true;
    }
}
