package d.a.i0.a.u.e.g;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.i0.a.v2.q0;
import d.a.i0.a.z1.b.f.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends d.a.i0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44805f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44806g;

        public a(String str, int i2, boolean z) {
            this.f44804e = str;
            this.f44805f = i2;
            this.f44806g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.J(hVar.i(), this.f44804e, this.f44805f, this.f44806g);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44808e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44809f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f44810g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f44811h;

        public b(String str, int i2, Drawable drawable, boolean z) {
            this.f44808e = str;
            this.f44809f = i2;
            this.f44810g = drawable;
            this.f44811h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.H(hVar.i(), this.f44808e, this.f44809f, this.f44810g, this.f44811h);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44813e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44814f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44815g;

        public c(String str, int i2, boolean z) {
            this.f44813e = str;
            this.f44814f = i2;
            this.f44815g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.I(hVar.i(), this.f44813e, this.f44814f, this.f44815g);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44817e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44818f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44819g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44820h;

        public d(String str, int i2, String str2, String str3) {
            this.f44817e = str;
            this.f44818f = i2;
            this.f44819g = str2;
            this.f44820h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.G(hVar.i(), this.f44817e, this.f44818f, this.f44819g, this.f44820h);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e(h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.z1.b.f.e.a();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44822a;

        public f(String str) {
            this.f44822a = str;
        }

        @Override // d.a.i0.a.z1.b.f.e.c
        public void a() {
            if (TextUtils.isEmpty(this.f44822a)) {
                return;
            }
            h.this.d(this.f44822a, new d.a.i0.a.u.h.b(0));
        }
    }

    public h(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public static ExifInterface A(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ExifInterface(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String B(String str, int i2) {
        return C(str, i2, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
        r0.append(com.baidu.tbadk.core.util.StringHelper.STRING_MORE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String C(String str, int i2, boolean z) {
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

    public static Drawable F(Context context, String str, d.a.i0.a.a2.e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null && context != null) {
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.e("Api-ToastApi", "imagePath = " + str);
            }
            ExifInterface A = A(str);
            if (A == null) {
                if (d.a.i0.a.u.c.d.f44636c) {
                    Log.e("Api-ToastApi", "exifInterface is null");
                }
                return null;
            }
            int intValue = Integer.valueOf(A.getAttribute("ImageWidth")).intValue();
            int intValue2 = Integer.valueOf(A.getAttribute("ImageLength")).intValue();
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.e("Api-ToastApi", "width = " + intValue + "， height = " + intValue2);
            }
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(new FileInputStream(file)));
                } catch (FileNotFoundException e2) {
                    if (d.a.i0.a.u.c.d.f44636c) {
                        Log.e("Api-ToastApi", "FileNotFoundException");
                        e2.printStackTrace();
                        return null;
                    }
                    return null;
                }
            } else if (d.a.i0.a.u.c.d.f44636c) {
                Log.e("Api-ToastApi", "image file not exists");
            }
        }
        return null;
    }

    public static int L(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int z(JSONObject jSONObject) {
        int L = L(jSONObject.optString("time")) / 1000;
        if (L < 1) {
            return 2;
        }
        return L;
    }

    public final void D() {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.w("Api-ToastApi", "the toast type is unknown");
        }
    }

    public d.a.i0.a.u.h.b E() {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-ToastApi", "handle");
        }
        if (d.a.i0.a.a2.e.Q() == null) {
            return new d.a.i0.a.u.h.b(1001, "SwanApp is null");
        }
        q0.b0(new e(this));
        return new d.a.i0.a.u.h.b(0);
    }

    public final void G(Context context, @NonNull String str, int i2, @NonNull String str2, String str3) {
        d.a.i0.a.z1.b.f.e e2 = d.a.i0.a.z1.b.f.e.e(context);
        e2.q(str);
        e2.k(str2);
        e2.l(i2);
        e2.t(new f(str3));
        e2.v();
    }

    public final void H(Context context, @NonNull String str, int i2, Drawable drawable, boolean z) {
        d.a.i0.a.z1.b.f.e g2 = d.a.i0.a.z1.b.f.e.g(context, B(str, 14));
        g2.n(drawable);
        g2.l(i2);
        g2.r(z);
        g2.A();
    }

    public final void I(Context context, @NonNull String str, int i2, boolean z) {
        d.a.i0.a.z1.b.f.e g2 = d.a.i0.a.z1.b.f.e.g(context, B(str, 14));
        g2.l(i2);
        g2.r(z);
        g2.y();
    }

    public final void J(Context context, @NonNull String str, int i2, boolean z) {
        d.a.i0.a.z1.b.f.e g2 = d.a.i0.a.z1.b.f.e.g(context, str);
        g2.l(i2);
        g2.r(z);
        g2.p(2);
        g2.F();
    }

    public d.a.i0.a.u.h.b K(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-ToastApi", "handle: " + str);
        }
        if (l()) {
            d.a.i0.a.e0.d.b("Api-ToastApi", "Api-ToastApi does not supported when app is invisible.");
            return new d.a.i0.a.u.h.b(1001, "Api-ToastApi does not supported when app is invisible.");
        }
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            return new d.a.i0.a.u.h.b(1001, "SwanApp is null");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-ToastApi", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-ToastApi", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("type", "1");
        int z = z(jSONObject);
        String optString2 = jSONObject.optString("message");
        if (TextUtils.isEmpty(optString2)) {
            d.a.i0.a.e0.d.b("Api-ToastApi", "message is null");
            return new d.a.i0.a.u.h.b(202, "message is null");
        }
        boolean optBoolean = jSONObject.optBoolean("mask");
        String optString3 = jSONObject.optString("image", "-1");
        if (!TextUtils.equals(optString3, "-1") && !optString3.startsWith(q0.x(Q).getPath())) {
            optString3 = q0.w(Q, optString3);
        }
        Drawable F = F(i(), optString3, Q);
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.e("Api-ToastApi", "imagepath = " + optString3);
        }
        if (!TextUtils.equals(optString3, "-1") && F == null && TextUtils.equals(optString, "2")) {
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
            q0.b0(new a(optString2, z, optBoolean));
        } else if (c2 == 1) {
            q0.b0(new b(optString2, z, F, optBoolean));
        } else if (c2 == 2) {
            q0.b0(new c(optString2, z, optBoolean));
        } else if (c2 != 3) {
            D();
            return new d.a.i0.a.u.h.b(302, "the toast type is unknown");
        } else {
            q0.b0(new d(optString2, z, optString5, optString4));
        }
        return new d.a.i0.a.u.h.b(0);
    }
}
