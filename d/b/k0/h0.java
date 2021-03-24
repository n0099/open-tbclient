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
    public boolean f63950g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f63951h = 0;
    public int i = 614400;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f63944a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f63945b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f63946c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f63947d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f63948e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f63949f = "0";

    public final void a(JSONObject jSONObject) {
        this.f63944a.put(jSONObject);
    }

    public boolean b(int i) {
        return this.f63944a.toString().getBytes().length >= i;
    }

    public void c() {
        this.f63945b.clear();
        this.f63946c.clear();
        this.f63944a = null;
    }

    public JSONArray d() {
        return this.f63944a;
    }

    public final ArrayList e() {
        return this.f63946c;
    }

    public final SparseArray<Integer> f() {
        return this.f63945b;
    }

    public long g() {
        return this.f63948e;
    }

    public long h() {
        return this.f63947d;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.f63944a);
            if (this.f63947d == 0 || this.f63948e == 0) {
                this.f63947d = this.f63948e;
            }
            jSONObject2.put("mintime", Long.toString(this.f63947d));
            jSONObject2.put("maxtime", Long.toString(this.f63948e));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(PackageTable.MD5, f0.b(this.f63944a.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.f63949f);
            jSONObject.put(Constant.IS_REAL, this.f63950g ? "1" : "0");
        } catch (JSONException unused) {
            if (j) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public boolean j() {
        return this.f63944a.length() == 0;
    }

    public boolean k() {
        return this.f63951h >= this.i;
    }

    public boolean l() {
        return this.f63950g;
    }

    public void m(int i) {
        if (i <= 0) {
            return;
        }
        this.f63951h += i;
    }

    public final void n(String str) {
        if (this.f63946c.contains(str)) {
            return;
        }
        this.f63946c.add(str);
    }

    public final void o(int i, int i2) {
        this.f63945b.put(i, Integer.valueOf(i2));
    }

    public final void p(long j2, long j3) {
        long j4 = this.f63947d;
        if ((j2 < j4 || j4 == 0) && j2 != 0) {
            this.f63947d = j2;
        }
        if (j3 > this.f63948e) {
            this.f63948e = j3;
        }
    }

    public void q(String str) {
        this.f63949f = str;
    }

    public void r(boolean z) {
        this.f63950g = z;
    }

    public void s(int i) {
        if (i < 0) {
            return;
        }
        this.i = i;
    }
}
