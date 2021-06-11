package d.a.p0;

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
    public boolean f67692g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f67693h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f67694i = 614400;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f67686a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f67687b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f67688c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f67689d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f67690e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f67691f = "0";

    public final void a(JSONObject jSONObject) {
        this.f67686a.put(jSONObject);
    }

    public boolean b(int i2) {
        return this.f67686a.toString().getBytes().length >= i2;
    }

    public void c() {
        this.f67687b.clear();
        this.f67688c.clear();
        this.f67686a = null;
    }

    public JSONArray d() {
        return this.f67686a;
    }

    public final ArrayList e() {
        return this.f67688c;
    }

    public final SparseArray<Integer> f() {
        return this.f67687b;
    }

    public long g() {
        return this.f67690e;
    }

    public long h() {
        return this.f67689d;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.f67686a);
            if (this.f67689d == 0 || this.f67690e == 0) {
                this.f67689d = this.f67690e;
            }
            jSONObject2.put("mintime", Long.toString(this.f67689d));
            jSONObject2.put("maxtime", Long.toString(this.f67690e));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(PackageTable.MD5, g0.b(this.f67686a.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.f67691f);
            jSONObject.put(Constant.IS_REAL, this.f67692g ? "1" : "0");
        } catch (JSONException unused) {
            if (j) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public boolean j() {
        return this.f67686a.length() == 0;
    }

    public boolean k() {
        return this.f67693h >= this.f67694i;
    }

    public boolean l() {
        return this.f67692g;
    }

    public void m(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f67693h += i2;
    }

    public final void n(String str) {
        if (this.f67688c.contains(str)) {
            return;
        }
        this.f67688c.add(str);
    }

    public final void o(int i2, int i3) {
        this.f67687b.put(i2, Integer.valueOf(i3));
    }

    public final void p(long j2, long j3) {
        long j4 = this.f67689d;
        if ((j2 < j4 || j4 == 0) && j2 != 0) {
            this.f67689d = j2;
        }
        if (j3 > this.f67690e) {
            this.f67690e = j3;
        }
    }

    public void q(String str) {
        this.f67691f = str;
    }

    public void r(boolean z) {
        this.f67692g = z;
    }

    public void s(int i2) {
        if (i2 < 0) {
            return;
        }
        this.f67694i = i2;
    }
}
