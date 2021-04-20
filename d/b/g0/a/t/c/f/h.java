package d.b.g0.a.t.c.f;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.b.g0.a.i2.k0;
import d.b.g0.a.q1.b.f.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends d.b.g0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46443e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46444f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46445g;

        public a(String str, int i, boolean z) {
            this.f46443e = str;
            this.f46444f = i;
            this.f46445g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.I(hVar.h(), this.f46443e, this.f46444f, this.f46445g);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46447e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46448f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f46449g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f46450h;

        public b(String str, int i, Drawable drawable, boolean z) {
            this.f46447e = str;
            this.f46448f = i;
            this.f46449g = drawable;
            this.f46450h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.G(hVar.h(), this.f46447e, this.f46448f, this.f46449g, this.f46450h);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46452f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46453g;

        public c(String str, int i, boolean z) {
            this.f46451e = str;
            this.f46452f = i;
            this.f46453g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.H(hVar.h(), this.f46451e, this.f46452f, this.f46453g);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46455e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46456f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46457g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46458h;

        public d(String str, int i, String str2, String str3) {
            this.f46455e = str;
            this.f46456f = i;
            this.f46457g = str2;
            this.f46458h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.F(hVar.h(), this.f46455e, this.f46456f, this.f46457g, this.f46458h);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e(h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.q1.b.f.d.a();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46459a;

        public f(String str) {
            this.f46459a = str;
        }

        @Override // d.b.g0.a.q1.b.f.d.a
        public void a() {
            if (TextUtils.isEmpty(this.f46459a)) {
                return;
            }
            h.this.c(this.f46459a, new d.b.g0.a.t.e.b(0));
        }
    }

    public h(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public static String A(String str, int i) {
        return B(str, i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
        r0.append(com.baidu.tbadk.core.util.StringHelper.STRING_MORE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String B(String str, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.trim().toCharArray();
        int i2 = z ? i : i - 2;
        int i3 = z ? i : i - 1;
        int length = charArray.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 < length) {
                char c2 = charArray[i4];
                int i6 = c2 > 161 ? 2 : 1;
                int i7 = i6 + i5;
                if (i7 == i && i4 == length - 1) {
                    stringBuffer.append(c2);
                    break;
                } else if ((i6 != 2 || i5 < i2) && (i6 != 1 || i5 < i3)) {
                    stringBuffer.append(c2);
                    i4++;
                    i5 = i7;
                }
            } else {
                break;
            }
        }
        return stringBuffer.toString();
    }

    public static Drawable E(Context context, String str, d.b.g0.a.r1.e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null && context != null) {
            if (d.b.g0.a.t.b.d.f46321c) {
                Log.e("Api-ToastApi", "imagePath = " + str);
            }
            ExifInterface z = z(str);
            if (z == null) {
                if (d.b.g0.a.t.b.d.f46321c) {
                    Log.e("Api-ToastApi", "exifInterface is null");
                }
                return null;
            }
            int intValue = Integer.valueOf(z.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH)).intValue();
            int intValue2 = Integer.valueOf(z.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH)).intValue();
            if (d.b.g0.a.t.b.d.f46321c) {
                Log.e("Api-ToastApi", "width = " + intValue + "， height = " + intValue2);
            }
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(new FileInputStream(file)));
                } catch (FileNotFoundException e2) {
                    if (d.b.g0.a.t.b.d.f46321c) {
                        Log.e("Api-ToastApi", "FileNotFoundException");
                        e2.printStackTrace();
                        return null;
                    }
                    return null;
                }
            } else if (d.b.g0.a.t.b.d.f46321c) {
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
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.w("Api-ToastApi", "the toast type is unknown");
        }
    }

    public d.b.g0.a.t.e.b D() {
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-ToastApi", "handle");
        }
        if (d.b.g0.a.r1.e.O() == null) {
            return new d.b.g0.a.t.e.b(1001, "SwanApp is null");
        }
        k0.X(new e(this));
        return new d.b.g0.a.t.e.b(0);
    }

    public final void F(Context context, @NonNull String str, int i, @NonNull String str2, String str3) {
        d.b.g0.a.q1.b.f.d d2 = d.b.g0.a.q1.b.f.d.d(context);
        d2.p(str);
        d2.j(str2);
        d2.k(i);
        d2.s(new f(str3));
        d2.t();
    }

    public final void G(Context context, @NonNull String str, int i, Drawable drawable, boolean z) {
        d.b.g0.a.q1.b.f.d f2 = d.b.g0.a.q1.b.f.d.f(context, A(str, 14));
        f2.m(drawable);
        f2.k(i);
        f2.q(z);
        f2.x();
    }

    public final void H(Context context, @NonNull String str, int i, boolean z) {
        d.b.g0.a.q1.b.f.d f2 = d.b.g0.a.q1.b.f.d.f(context, A(str, 14));
        f2.k(i);
        f2.q(z);
        f2.v();
    }

    public final void I(Context context, @NonNull String str, int i, boolean z) {
        d.b.g0.a.q1.b.f.d f2 = d.b.g0.a.q1.b.f.d.f(context, str);
        f2.k(i);
        f2.q(z);
        f2.o(2);
        f2.C();
    }

    public d.b.g0.a.t.e.b J(String str) {
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-ToastApi", "handle: " + str);
        }
        if (k()) {
            d.b.g0.a.c0.c.b("Api-ToastApi", "Api-ToastApi does not supported when app is invisible.");
            return new d.b.g0.a.t.e.b(1001, "Api-ToastApi does not supported when app is invisible.");
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            return new d.b.g0.a.t.e.b(1001, "SwanApp is null");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-ToastApi", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f46321c) {
                d.b.g0.a.c0.c.b("Api-ToastApi", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("type", "1");
        int y = y(jSONObject);
        String optString2 = jSONObject.optString("message");
        if (TextUtils.isEmpty(optString2)) {
            d.b.g0.a.c0.c.b("Api-ToastApi", "message is null");
            return new d.b.g0.a.t.e.b(202, "message is null");
        }
        boolean optBoolean = jSONObject.optBoolean("mask");
        String optString3 = jSONObject.optString("image", "-1");
        Drawable E = E(h(), optString3, O);
        if (d.b.g0.a.t.b.d.f46321c) {
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
            return new d.b.g0.a.t.e.b(302, "the toast type is unknown");
        } else {
            k0.X(new d(optString2, y, optString5, optString4));
        }
        return new d.b.g0.a.t.e.b(0);
    }
}
