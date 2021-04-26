package d.a.h0.a.t.c.f;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.h0.a.i2.k0;
import d.a.h0.a.q1.b.f.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends d.a.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44152e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44153f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44154g;

        public a(String str, int i2, boolean z) {
            this.f44152e = str;
            this.f44153f = i2;
            this.f44154g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.I(hVar.h(), this.f44152e, this.f44153f, this.f44154g);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44156e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44157f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f44158g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f44159h;

        public b(String str, int i2, Drawable drawable, boolean z) {
            this.f44156e = str;
            this.f44157f = i2;
            this.f44158g = drawable;
            this.f44159h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.G(hVar.h(), this.f44156e, this.f44157f, this.f44158g, this.f44159h);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44161e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44162f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44163g;

        public c(String str, int i2, boolean z) {
            this.f44161e = str;
            this.f44162f = i2;
            this.f44163g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.H(hVar.h(), this.f44161e, this.f44162f, this.f44163g);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44165e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44166f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44167g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44168h;

        public d(String str, int i2, String str2, String str3) {
            this.f44165e = str;
            this.f44166f = i2;
            this.f44167g = str2;
            this.f44168h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.F(hVar.h(), this.f44165e, this.f44166f, this.f44167g, this.f44168h);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e(h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.q1.b.f.d.a();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44170a;

        public f(String str) {
            this.f44170a = str;
        }

        @Override // d.a.h0.a.q1.b.f.d.a
        public void a() {
            if (TextUtils.isEmpty(this.f44170a)) {
                return;
            }
            h.this.c(this.f44170a, new d.a.h0.a.t.e.b(0));
        }
    }

    public h(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public static String A(String str, int i2) {
        return B(str, i2, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
        r0.append(com.baidu.tbadk.core.util.StringHelper.STRING_MORE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String B(String str, int i2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.trim().toCharArray();
        int i3 = z ? i2 : i2 - 2;
        int i4 = z ? i2 : i2 - 1;
        int length = charArray.length;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 < length) {
                char c2 = charArray[i5];
                int i7 = c2 > 161 ? 2 : 1;
                int i8 = i7 + i6;
                if (i8 == i2 && i5 == length - 1) {
                    stringBuffer.append(c2);
                    break;
                } else if ((i7 != 2 || i6 < i3) && (i7 != 1 || i6 < i4)) {
                    stringBuffer.append(c2);
                    i5++;
                    i6 = i8;
                }
            } else {
                break;
            }
        }
        return stringBuffer.toString();
    }

    public static Drawable E(Context context, String str, d.a.h0.a.r1.e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null && context != null) {
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.e("Api-ToastApi", "imagePath = " + str);
            }
            ExifInterface z = z(str);
            if (z == null) {
                if (d.a.h0.a.t.b.d.f44021c) {
                    Log.e("Api-ToastApi", "exifInterface is null");
                }
                return null;
            }
            int intValue = Integer.valueOf(z.getAttribute("ImageWidth")).intValue();
            int intValue2 = Integer.valueOf(z.getAttribute("ImageLength")).intValue();
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.e("Api-ToastApi", "width = " + intValue + "， height = " + intValue2);
            }
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(new FileInputStream(file)));
                } catch (FileNotFoundException e2) {
                    if (d.a.h0.a.t.b.d.f44021c) {
                        Log.e("Api-ToastApi", "FileNotFoundException");
                        e2.printStackTrace();
                        return null;
                    }
                    return null;
                }
            } else if (d.a.h0.a.t.b.d.f44021c) {
                Log.e("Api-ToastApi", "image file not exists");
            }
        }
        return null;
    }

    public static int K(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int y(JSONObject jSONObject) {
        int K = K(jSONObject.optString("time")) / 1000;
        if (K <= 0) {
            return 2;
        }
        return K;
    }

    public static ExifInterface z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ExifInterface(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void C() {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.w("Api-ToastApi", "the toast type is unknown");
        }
    }

    public d.a.h0.a.t.e.b D() {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-ToastApi", "handle");
        }
        if (d.a.h0.a.r1.e.O() == null) {
            return new d.a.h0.a.t.e.b(1001, "SwanApp is null");
        }
        k0.X(new e(this));
        return new d.a.h0.a.t.e.b(0);
    }

    public final void F(Context context, @NonNull String str, int i2, @NonNull String str2, String str3) {
        d.a.h0.a.q1.b.f.d d2 = d.a.h0.a.q1.b.f.d.d(context);
        d2.p(str);
        d2.j(str2);
        d2.k(i2);
        d2.s(new f(str3));
        d2.t();
    }

    public final void G(Context context, @NonNull String str, int i2, Drawable drawable, boolean z) {
        d.a.h0.a.q1.b.f.d f2 = d.a.h0.a.q1.b.f.d.f(context, A(str, 14));
        f2.m(drawable);
        f2.k(i2);
        f2.q(z);
        f2.x();
    }

    public final void H(Context context, @NonNull String str, int i2, boolean z) {
        d.a.h0.a.q1.b.f.d f2 = d.a.h0.a.q1.b.f.d.f(context, A(str, 14));
        f2.k(i2);
        f2.q(z);
        f2.v();
    }

    public final void I(Context context, @NonNull String str, int i2, boolean z) {
        d.a.h0.a.q1.b.f.d f2 = d.a.h0.a.q1.b.f.d.f(context, str);
        f2.k(i2);
        f2.q(z);
        f2.o(2);
        f2.C();
    }

    public d.a.h0.a.t.e.b J(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-ToastApi", "handle: " + str);
        }
        if (k()) {
            d.a.h0.a.c0.c.b("Api-ToastApi", "Api-ToastApi does not supported when app is invisible.");
            return new d.a.h0.a.t.e.b(1001, "Api-ToastApi does not supported when app is invisible.");
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            return new d.a.h0.a.t.e.b(1001, "SwanApp is null");
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-ToastApi", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-ToastApi", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("type", "1");
        int y = y(jSONObject);
        String optString2 = jSONObject.optString("message");
        if (TextUtils.isEmpty(optString2)) {
            d.a.h0.a.c0.c.b("Api-ToastApi", "message is null");
            return new d.a.h0.a.t.e.b(202, "message is null");
        }
        boolean optBoolean = jSONObject.optBoolean("mask");
        String optString3 = jSONObject.optString("image", "-1");
        Drawable E = E(h(), optString3, O);
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.e("Api-ToastApi", "imagepath = " + optString3);
        }
        if (!TextUtils.equals(optString3, "-1") && E == null && TextUtils.equals(optString, "2")) {
            optString = "1";
        }
        String optString4 = jSONObject.optString("cb");
        String optString5 = jSONObject.optString("buttonText");
        char c2 = 65535;
        switch (optString.hashCode()) {
            case 49:
                if (optString.equals("1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 50:
                if (optString.equals("2")) {
                    c2 = 1;
                    break;
                }
                break;
            case 51:
                if (optString.equals("3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 52:
                if (optString.equals("4")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            k0.X(new a(optString2, y, optBoolean));
        } else if (c2 == 1) {
            k0.X(new b(optString2, y, E, optBoolean));
        } else if (c2 == 2) {
            k0.X(new c(optString2, y, optBoolean));
        } else if (c2 != 3) {
            C();
            return new d.a.h0.a.t.e.b(302, "the toast type is unknown");
        } else {
            k0.X(new d(optString2, y, optString5, optString4));
        }
        return new d.a.h0.a.t.e.b(0);
    }
}
