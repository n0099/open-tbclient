package d.a.l0;

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
    public boolean f63237g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f63238h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f63239i = 614400;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f63231a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f63232b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f63233c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f63234d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f63235e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f63236f = "0";

    public final void a(JSONObject jSONObject) {
        this.f63231a.put(jSONObject);
    }

    public boolean b(int i2) {
        return this.f63231a.toString().getBytes().length >= i2;
    }

    public void c() {
        this.f63232b.clear();
        this.f63233c.clear();
        this.f63231a = null;
    }

    public JSONArray d() {
        return this.f63231a;
    }

    public final ArrayList e() {
        return this.f63233c;
    }

    public final SparseArray<Integer> f() {
        return this.f63232b;
    }

    public long g() {
        return this.f63235e;
    }

    public long h() {
        return this.f63234d;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.f63231a);
            if (this.f63234d == 0 || this.f63235e == 0) {
                this.f63234d = this.f63235e;
            }
            jSONObject2.put("mintime", Long.toString(this.f63234d));
            jSONObject2.put("maxtime", Long.toString(this.f63235e));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(PackageTable.MD5, g0.b(this.f63231a.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.f63236f);
            jSONObject.put(Constant.IS_REAL, this.f63237g ? "1" : "0");
        } catch (JSONException unused) {
            if (j) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public boolean j() {
        return this.f63231a.length() == 0;
    }

    public boolean k() {
        return this.f63238h >= this.f63239i;
    }

    public boolean l() {
        return this.f63237g;
    }

    public void m(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f63238h += i2;
    }

    public final void n(String str) {
        if (this.f63233c.contains(str)) {
            return;
        }
        this.f63233c.add(str);
    }

    public final void o(int i2, int i3) {
        this.f63232b.put(i2, Integer.valueOf(i3));
    }

    public final void p(long j2, long j3) {
        long j4 = this.f63234d;
        if ((j2 < j4 || j4 == 0) && j2 != 0) {
            this.f63234d = j2;
        }
        if (j3 > this.f63235e) {
            this.f63235e = j3;
        }
    }

    public void q(String str) {
        this.f63236f = str;
    }

    public void r(boolean z) {
        this.f63237g = z;
    }

    public void s(int i2) {
        if (i2 < 0) {
            return;
        }
        this.f63239i = i2;
    }
}
