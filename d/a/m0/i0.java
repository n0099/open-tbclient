package d.a.m0;

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
public class i0 {
    public static final boolean j = AppConfig.isDebug();

    /* renamed from: g  reason: collision with root package name */
    public boolean f63961g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f63962h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f63963i = 614400;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f63955a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f63956b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f63957c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f63958d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f63959e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f63960f = "0";

    public final void a(JSONObject jSONObject) {
        this.f63955a.put(jSONObject);
    }

    public boolean b(int i2) {
        return this.f63955a.toString().getBytes().length >= i2;
    }

    public void c() {
        this.f63956b.clear();
        this.f63957c.clear();
        this.f63955a = null;
    }

    public JSONArray d() {
        return this.f63955a;
    }

    public final ArrayList e() {
        return this.f63957c;
    }

    public final SparseArray<Integer> f() {
        return this.f63956b;
    }

    public long g() {
        return this.f63959e;
    }

    public long h() {
        return this.f63958d;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.f63955a);
            if (this.f63958d == 0 || this.f63959e == 0) {
                this.f63958d = this.f63959e;
            }
            jSONObject2.put("mintime", Long.toString(this.f63958d));
            jSONObject2.put("maxtime", Long.toString(this.f63959e));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(PackageTable.MD5, g0.b(this.f63955a.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.f63960f);
            jSONObject.put(Constant.IS_REAL, this.f63961g ? "1" : "0");
        } catch (JSONException unused) {
            if (j) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public boolean j() {
        return this.f63955a.length() == 0;
    }

    public boolean k() {
        return this.f63962h >= this.f63963i;
    }

    public boolean l() {
        return this.f63961g;
    }

    public void m(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f63962h += i2;
    }

    public final void n(String str) {
        if (this.f63957c.contains(str)) {
            return;
        }
        this.f63957c.add(str);
    }

    public final void o(int i2, int i3) {
        this.f63956b.put(i2, Integer.valueOf(i3));
    }

    public final void p(long j2, long j3) {
        long j4 = this.f63958d;
        if ((j2 < j4 || j4 == 0) && j2 != 0) {
            this.f63958d = j2;
        }
        if (j3 > this.f63959e) {
            this.f63959e = j3;
        }
    }

    public void q(String str) {
        this.f63960f = str;
    }

    public void r(boolean z) {
        this.f63961g = z;
    }

    public void s(int i2) {
        if (i2 < 0) {
            return;
        }
        this.f63963i = i2;
    }
}
