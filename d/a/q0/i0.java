package d.a.q0;

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
    public boolean f68106g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f68107h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f68108i = 614400;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f68100a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f68101b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f68102c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f68103d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f68104e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f68105f = "0";

    public final void a(JSONObject jSONObject) {
        this.f68100a.put(jSONObject);
    }

    public boolean b(int i2) {
        return this.f68100a.toString().getBytes().length >= i2;
    }

    public void c() {
        this.f68101b.clear();
        this.f68102c.clear();
        this.f68100a = null;
    }

    public JSONArray d() {
        return this.f68100a;
    }

    public final ArrayList e() {
        return this.f68102c;
    }

    public final SparseArray<Integer> f() {
        return this.f68101b;
    }

    public long g() {
        return this.f68104e;
    }

    public long h() {
        return this.f68103d;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.f68100a);
            if (this.f68103d == 0 || this.f68104e == 0) {
                this.f68103d = this.f68104e;
            }
            jSONObject2.put("mintime", Long.toString(this.f68103d));
            jSONObject2.put("maxtime", Long.toString(this.f68104e));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(PackageTable.MD5, g0.b(this.f68100a.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.f68105f);
            jSONObject.put(Constant.IS_REAL, this.f68106g ? "1" : "0");
        } catch (JSONException unused) {
            if (j) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public boolean j() {
        return this.f68100a.length() == 0;
    }

    public boolean k() {
        return this.f68107h >= this.f68108i;
    }

    public boolean l() {
        return this.f68106g;
    }

    public void m(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f68107h += i2;
    }

    public final void n(String str) {
        if (this.f68102c.contains(str)) {
            return;
        }
        this.f68102c.add(str);
    }

    public final void o(int i2, int i3) {
        this.f68101b.put(i2, Integer.valueOf(i3));
    }

    public final void p(long j2, long j3) {
        long j4 = this.f68103d;
        if ((j2 < j4 || j4 == 0) && j2 != 0) {
            this.f68103d = j2;
        }
        if (j3 > this.f68104e) {
            this.f68104e = j3;
        }
    }

    public void q(String str) {
        this.f68105f = str;
    }

    public void r(boolean z) {
        this.f68106g = z;
    }

    public void s(int i2) {
        if (i2 < 0) {
            return;
        }
        this.f68108i = i2;
    }
}
