package d.a.h0.a.b1.e;

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
    public final Uri f41452a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f41453b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f41454c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41455d;

    /* renamed from: e  reason: collision with root package name */
    public int f41456e;

    /* renamed from: f  reason: collision with root package name */
    public int f41457f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f41458g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41459h;

    public b(Bitmap bitmap, boolean z) {
        this.f41453b = bitmap;
        this.f41452a = null;
        this.f41454c = null;
        this.f41455d = false;
        this.f41456e = bitmap.getWidth();
        this.f41457f = bitmap.getHeight();
        this.f41459h = z;
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

    public static b k(int i2) {
        return new b(i2);
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
        return this.f41453b;
    }

    public final Integer d() {
        return this.f41454c;
    }

    public final int e() {
        return this.f41457f;
    }

    public final Rect f() {
        return this.f41458g;
    }

    public final int g() {
        return this.f41456e;
    }

    public final boolean h() {
        return this.f41455d;
    }

    public final Uri i() {
        return this.f41452a;
    }

    public final boolean j() {
        return this.f41459h;
    }

    public b l(boolean z) {
        this.f41455d = z;
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
        this.f41453b = null;
        this.f41452a = uri;
        this.f41454c = null;
        this.f41455d = true;
    }

    public b(int i2) {
        this.f41453b = null;
        this.f41452a = null;
        this.f41454c = Integer.valueOf(i2);
        this.f41455d = true;
    }
}
