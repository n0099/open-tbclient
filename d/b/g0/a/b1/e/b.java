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
    public final Uri f43846a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f43847b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f43848c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43849d;

    /* renamed from: e  reason: collision with root package name */
    public int f43850e;

    /* renamed from: f  reason: collision with root package name */
    public int f43851f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f43852g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43853h;

    public b(Bitmap bitmap, boolean z) {
        this.f43847b = bitmap;
        this.f43846a = null;
        this.f43848c = null;
        this.f43849d = false;
        this.f43850e = bitmap.getWidth();
        this.f43851f = bitmap.getHeight();
        this.f43853h = z;
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
        return this.f43847b;
    }

    public final Integer d() {
        return this.f43848c;
    }

    public final int e() {
        return this.f43851f;
    }

    public final Rect f() {
        return this.f43852g;
    }

    public final int g() {
        return this.f43850e;
    }

    public final boolean h() {
        return this.f43849d;
    }

    public final Uri i() {
        return this.f43846a;
    }

    public final boolean j() {
        return this.f43853h;
    }

    public b l(boolean z) {
        this.f43849d = z;
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
        this.f43847b = null;
        this.f43846a = uri;
        this.f43848c = null;
        this.f43849d = true;
    }

    public b(int i) {
        this.f43847b = null;
        this.f43846a = null;
        this.f43848c = Integer.valueOf(i);
        this.f43849d = true;
    }
}
