package d.b.k0;

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
    public boolean f64651g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f64652h = 0;
    public int i = 614400;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f64645a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f64646b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f64647c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f64648d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f64649e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f64650f = "0";

    public final void a(JSONObject jSONObject) {
        this.f64645a.put(jSONObject);
    }

    public boolean b(int i) {
        return this.f64645a.toString().getBytes().length >= i;
    }

    public void c() {
        this.f64646b.clear();
        this.f64647c.clear();
        this.f64645a = null;
    }

    public JSONArray d() {
        return this.f64645a;
    }

    public final ArrayList e() {
        return this.f64647c;
    }

    public final SparseArray<Integer> f() {
        return this.f64646b;
    }

    public long g() {
        return this.f64649e;
    }

    public long h() {
        return this.f64648d;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.f64645a);
            if (this.f64648d == 0 || this.f64649e == 0) {
                this.f64648d = this.f64649e;
            }
            jSONObject2.put("mintime", Long.toString(this.f64648d));
            jSONObject2.put("maxtime", Long.toString(this.f64649e));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(PackageTable.MD5, f0.b(this.f64645a.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.f64650f);
            jSONObject.put(Constant.IS_REAL, this.f64651g ? "1" : "0");
        } catch (JSONException unused) {
            if (j) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public boolean j() {
        return this.f64645a.length() == 0;
    }

    public boolean k() {
        return this.f64652h >= this.i;
    }

    public boolean l() {
        return this.f64651g;
    }

    public void m(int i) {
        if (i <= 0) {
            return;
        }
        this.f64652h += i;
    }

    public final void n(String str) {
        if (this.f64647c.contains(str)) {
            return;
        }
        this.f64647c.add(str);
    }

    public final void o(int i, int i2) {
        this.f64646b.put(i, Integer.valueOf(i2));
    }

    public final void p(long j2, long j3) {
        long j4 = this.f64648d;
        if ((j2 < j4 || j4 == 0) && j2 != 0) {
            this.f64648d = j2;
        }
        if (j3 > this.f64649e) {
            this.f64649e = j3;
        }
    }

    public void q(String str) {
        this.f64650f = str;
    }

    public void r(boolean z) {
        this.f64651g = z;
    }

    public void s(int i) {
        if (i < 0) {
            return;
        }
        this.i = i;
    }
}
