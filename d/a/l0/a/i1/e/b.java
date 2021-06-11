package d.a.l0.a.i1.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.davemorrissey.labs.subscaleview.ImageSource;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f46572i = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f46573a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f46574b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f46575c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46576d;

    /* renamed from: e  reason: collision with root package name */
    public int f46577e;

    /* renamed from: f  reason: collision with root package name */
    public int f46578f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f46579g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46580h;

    public b(Bitmap bitmap, boolean z) {
        this.f46574b = bitmap;
        this.f46573a = null;
        this.f46575c = null;
        this.f46576d = false;
        this.f46577e = bitmap.getWidth();
        this.f46578f = bitmap.getHeight();
        this.f46580h = z;
    }

    public static b a(String str) {
        if (str == null) {
            if (!f46572i) {
                d.h("ImageSource", "asset name is null");
                return null;
            }
            throw new NullPointerException("Asset name must not be null");
        }
        return o("file:///android_asset/" + str);
    }

    public static b b(Bitmap bitmap) {
        if (bitmap == null) {
            if (!f46572i) {
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
            if (!f46572i) {
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
        return this.f46574b;
    }

    public final Integer d() {
        return this.f46575c;
    }

    public final int e() {
        return this.f46578f;
    }

    public final Rect f() {
        return this.f46579g;
    }

    public final int g() {
        return this.f46577e;
    }

    public final boolean h() {
        return this.f46576d;
    }

    public final Uri i() {
        return this.f46573a;
    }

    public final boolean j() {
        return this.f46580h;
    }

    public b l(boolean z) {
        this.f46576d = z;
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
        this.f46574b = null;
        this.f46573a = uri;
        this.f46575c = null;
        this.f46576d = true;
    }

    public b(int i2) {
        this.f46574b = null;
        this.f46573a = null;
        this.f46575c = Integer.valueOf(i2);
        this.f46576d = true;
    }
}
