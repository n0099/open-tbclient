package d.b.l0;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.searchbox.pms.db.PackageTable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h0 {
    public static final boolean j = AppConfig.isDebug();

    /* renamed from: g  reason: collision with root package name */
    public boolean f64932g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f64933h = 0;
    public int i = 614400;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f64926a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f64927b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f64928c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f64929d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f64930e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f64931f = "0";

    public final void a(JSONObject jSONObject) {
        this.f64926a.put(jSONObject);
    }

    public boolean b(int i) {
        return this.f64926a.toString().getBytes().length >= i;
    }

    public void c() {
        this.f64927b.clear();
        this.f64928c.clear();
        this.f64926a = null;
    }

    public JSONArray d() {
        return this.f64926a;
    }

    public final ArrayList e() {
        return this.f64928c;
    }

    public final SparseArray<Integer> f() {
        return this.f64927b;
    }

    public long g() {
        return this.f64930e;
    }

    public long h() {
        return this.f64929d;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.f64926a);
            if (this.f64929d == 0 || this.f64930e == 0) {
                this.f64929d = this.f64930e;
            }
            jSONObject2.put("mintime", Long.toString(this.f64929d));
            jSONObject2.put("maxtime", Long.toString(this.f64930e));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(PackageTable.MD5, f0.b(this.f64926a.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.f64931f);
            jSONObject.put(Constant.IS_REAL, this.f64932g ? "1" : "0");
        } catch (JSONException unused) {
            if (j) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public boolean j() {
        return this.f64926a.length() == 0;
    }

    public boolean k() {
        return this.f64933h >= this.i;
    }

    public boolean l() {
        return this.f64932g;
    }

    public void m(int i) {
        if (i <= 0) {
            return;
        }
        this.f64933h += i;
    }

    public final void n(String str) {
        if (this.f64928c.contains(str)) {
            return;
        }
        this.f64928c.add(str);
    }

    public final void o(int i, int i2) {
        this.f64927b.put(i, Integer.valueOf(i2));
    }

    public final void p(long j2, long j3) {
        long j4 = this.f64929d;
        if ((j2 < j4 || j4 == 0) && j2 != 0) {
            this.f64929d = j2;
        }
        if (j3 > this.f64930e) {
            this.f64930e = j3;
        }
    }

    public void q(String str) {
        this.f64931f = str;
    }

    public void r(boolean z) {
        this.f64932g = z;
    }

    public void s(int i) {
        if (i < 0) {
            return;
        }
        this.i = i;
    }
}
