package d.a.r.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import d.a.r.a.b.a;
import d.a.r.a.b.d;
import d.a.r.a.e.b;
import d.a.r.a.e.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f68060e;

    /* renamed from: a  reason: collision with root package name */
    public int f68061a;

    /* renamed from: b  reason: collision with root package name */
    public String f68062b = "";

    /* renamed from: c  reason: collision with root package name */
    public Context f68063c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68064d;

    public static a d() {
        if (f68060e == null) {
            synchronized (a.class) {
                if (f68060e == null) {
                    f68060e = new a();
                }
            }
        }
        return f68060e;
    }

    public String a() {
        return this.f68062b;
    }

    public boolean b() {
        return this.f68064d;
    }

    public int c() {
        return this.f68061a;
    }

    public void e(Context context, String str, int i2, boolean z) {
        this.f68062b = str;
        if (context != null) {
            this.f68063c = context.getApplicationContext();
        }
        this.f68061a = i2;
        this.f68064d = z;
    }

    public void f(JSONArray jSONArray, boolean z, boolean z2, boolean z3) {
        byte[] a2;
        if (TextUtils.isEmpty(this.f68062b) || this.f68063c == null || jSONArray == null || jSONArray.length() == 0) {
            c.a("IMLiteUBC", "cuid is empty or context null or upload json is null");
            return;
        }
        Context context = this.f68063c;
        if (jSONArray == null || jSONArray.length() == 0) {
            c.a("UBCUploader", "upload json is null");
            return;
        }
        c.a("UBCUploader", "uploadjson:" + jSONArray.toString() + ", isReal:" + z + ", isSave:" + z2);
        if (z2) {
            c.a("UBCUploader", "save ubcdata");
            return;
        }
        JSONObject a3 = new d.a.r.a.d.a(z, jSONArray).a();
        if (a3 == null) {
            c.a("UBCUploader", "uploadJsonData is null");
            return;
        }
        String jSONObject = a3.toString();
        if (TextUtils.isEmpty(jSONObject)) {
            a2 = null;
        } else {
            a2 = b.a(jSONObject.getBytes());
            if (a2 != null && a2.length > 2) {
                a2[0] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                a2[1] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
            }
        }
        byte[] bArr = a2;
        if (bArr == null || bArr.length < 3) {
            c.a("UBCUploader", "uploadGzip is null or uploadGzip length<3");
            return;
        }
        c.a("UBCUploader", "gzip success, length:" + bArr.length);
        c.a("UBCUploader", "start execute http upload data");
        d dVar = new d(context);
        d.a.r.a.b.a a4 = d.a.r.a.b.a.a(context);
        if (context == null || TextUtils.isEmpty(dVar.a())) {
            dVar.b(d.a.r.a.b.a.f68066d, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes());
        } else if (z3) {
            d.a.r.a.c.a.a().b(new a.RunnableC1857a(dVar, bArr, dVar));
        } else {
            a4.e(dVar.b(), dVar.a(), bArr, dVar.d(), dVar.c(), dVar);
        }
    }
}
