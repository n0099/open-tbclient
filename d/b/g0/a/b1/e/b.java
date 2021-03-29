package d.b.g0.a.b1.e;

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
    public final Uri f43454a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f43455b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f43456c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43457d;

    /* renamed from: e  reason: collision with root package name */
    public int f43458e;

    /* renamed from: f  reason: collision with root package name */
    public int f43459f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f43460g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43461h;

    public b(Bitmap bitmap, boolean z) {
        this.f43455b = bitmap;
        this.f43454a = null;
        this.f43456c = null;
        this.f43457d = false;
        this.f43458e = bitmap.getWidth();
        this.f43459f = bitmap.getHeight();
        this.f43461h = z;
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
        return this.f43455b;
    }

    public final Integer d() {
        return this.f43456c;
    }

    public final int e() {
        return this.f43459f;
    }

    public final Rect f() {
        return this.f43460g;
    }

    public final int g() {
        return this.f43458e;
    }

    public final boolean h() {
        return this.f43457d;
    }

    public final Uri i() {
        return this.f43454a;
    }

    public final boolean j() {
        return this.f43461h;
    }

    public b l(boolean z) {
        this.f43457d = z;
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
        this.f43455b = null;
        this.f43454a = uri;
        this.f43456c = null;
        this.f43457d = true;
    }

    public b(int i) {
        this.f43455b = null;
        this.f43454a = null;
        this.f43456c = Integer.valueOf(i);
        this.f43457d = true;
    }
}
