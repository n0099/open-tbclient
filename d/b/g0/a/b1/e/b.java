package d.b.g0.a.b1.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.davemorrissey.labs.subscaleview.ImageSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f43453a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f43454b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f43455c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43456d;

    /* renamed from: e  reason: collision with root package name */
    public int f43457e;

    /* renamed from: f  reason: collision with root package name */
    public int f43458f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f43459g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43460h;

    public b(Bitmap bitmap, boolean z) {
        this.f43454b = bitmap;
        this.f43453a = null;
        this.f43455c = null;
        this.f43456d = false;
        this.f43457e = bitmap.getWidth();
        this.f43458f = bitmap.getHeight();
        this.f43460h = z;
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
        return this.f43454b;
    }

    public final Integer d() {
        return this.f43455c;
    }

    public final int e() {
        return this.f43458f;
    }

    public final Rect f() {
        return this.f43459g;
    }

    public final int g() {
        return this.f43457e;
    }

    public final boolean h() {
        return this.f43456d;
    }

    public final Uri i() {
        return this.f43453a;
    }

    public final boolean j() {
        return this.f43460h;
    }

    public b l(boolean z) {
        this.f43456d = z;
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
        this.f43454b = null;
        this.f43453a = uri;
        this.f43455c = null;
        this.f43456d = true;
    }

    public b(int i) {
        this.f43454b = null;
        this.f43453a = null;
        this.f43455c = Integer.valueOf(i);
        this.f43456d = true;
    }
}
