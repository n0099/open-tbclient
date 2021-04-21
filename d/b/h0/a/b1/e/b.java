package d.b.h0.a.b1.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.davemorrissey.labs.subscaleview.ImageSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f44175a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f44176b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f44177c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44178d;

    /* renamed from: e  reason: collision with root package name */
    public int f44179e;

    /* renamed from: f  reason: collision with root package name */
    public int f44180f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f44181g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44182h;

    public b(Bitmap bitmap, boolean z) {
        this.f44176b = bitmap;
        this.f44175a = null;
        this.f44177c = null;
        this.f44178d = false;
        this.f44179e = bitmap.getWidth();
        this.f44180f = bitmap.getHeight();
        this.f44182h = z;
    }

    public static b a(String str) {
        if (str != null) {
            return o("file:///android_asset/" + str);
        }
        throw new NullPointerException("Asset name must not be null");
    }

    public static b b(Bitmap bitmap) {
        if (bitmap != null) {
            return new b(bitmap, true);
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    public static b k(int i) {
        return new b(i);
    }

    public static b o(String str) {
        if (str != null) {
            if (!str.contains("://")) {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                str = ImageSource.FILE_SCHEME + str;
            }
            return new b(Uri.parse(str));
        }
        throw new NullPointerException("Uri must not be null");
    }

    public final Bitmap c() {
        return this.f44176b;
    }

    public final Integer d() {
        return this.f44177c;
    }

    public final int e() {
        return this.f44180f;
    }

    public final Rect f() {
        return this.f44181g;
    }

    public final int g() {
        return this.f44179e;
    }

    public final boolean h() {
        return this.f44178d;
    }

    public final Uri i() {
        return this.f44175a;
    }

    public final boolean j() {
        return this.f44182h;
    }

    public b l(boolean z) {
        this.f44178d = z;
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
        this.f44176b = null;
        this.f44175a = uri;
        this.f44177c = null;
        this.f44178d = true;
    }

    public b(int i) {
        this.f44176b = null;
        this.f44175a = null;
        this.f44177c = Integer.valueOf(i);
        this.f44178d = true;
    }
}
