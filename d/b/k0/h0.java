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
    public boolean f63951g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f63952h = 0;
    public int i = 614400;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f63945a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f63946b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f63947c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f63948d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f63949e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f63950f = "0";

    public final void a(JSONObject jSONObject) {
        this.f63945a.put(jSONObject);
    }

    public boolean b(int i) {
        return this.f63945a.toString().getBytes().length >= i;
    }

    public void c() {
        this.f63946b.clear();
        this.f63947c.clear();
        this.f63945a = null;
    }

    public JSONArray d() {
        return this.f63945a;
    }

    public final ArrayList e() {
        return this.f63947c;
    }

    public final SparseArray<Integer> f() {
        return this.f63946b;
    }

    public long g() {
        return this.f63949e;
    }

    public long h() {
        return this.f63948d;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.f63945a);
            if (this.f63948d == 0 || this.f63949e == 0) {
                this.f63948d = this.f63949e;
            }
            jSONObject2.put("mintime", Long.toString(this.f63948d));
            jSONObject2.put("maxtime", Long.toString(this.f63949e));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(PackageTable.MD5, f0.b(this.f63945a.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.f63950f);
            jSONObject.put(Constant.IS_REAL, this.f63951g ? "1" : "0");
        } catch (JSONException unused) {
            if (j) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public boolean j() {
        return this.f63945a.length() == 0;
    }

    public boolean k() {
        return this.f63952h >= this.i;
    }

    public boolean l() {
        return this.f63951g;
    }

    public void m(int i) {
        if (i <= 0) {
            return;
        }
        this.f63952h += i;
    }

    public final void n(String str) {
        if (this.f63947c.contains(str)) {
            return;
        }
        this.f63947c.add(str);
    }

    public final void o(int i, int i2) {
        this.f63946b.put(i, Integer.valueOf(i2));
    }

    public final void p(long j2, long j3) {
        long j4 = this.f63948d;
        if ((j2 < j4 || j4 == 0) && j2 != 0) {
            this.f63948d = j2;
        }
        if (j3 > this.f63949e) {
            this.f63949e = j3;
        }
    }

    public void q(String str) {
        this.f63950f = str;
    }

    public void r(boolean z) {
        this.f63951g = z;
    }

    public void s(int i) {
        if (i < 0) {
            return;
        }
        this.i = i;
    }
}
