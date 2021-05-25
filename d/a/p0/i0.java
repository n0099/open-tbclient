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
    public boolean f63974g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f63975h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f63976i = 614400;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f63968a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f63969b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f63970c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f63971d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f63972e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f63973f = "0";

    public final void a(JSONObject jSONObject) {
        this.f63968a.put(jSONObject);
    }

    public boolean b(int i2) {
        return this.f63968a.toString().getBytes().length >= i2;
    }

    public void c() {
        this.f63969b.clear();
        this.f63970c.clear();
        this.f63968a = null;
    }

    public JSONArray d() {
        return this.f63968a;
    }

    public final ArrayList e() {
        return this.f63970c;
    }

    public final SparseArray<Integer> f() {
        return this.f63969b;
    }

    public long g() {
        return this.f63972e;
    }

    public long h() {
        return this.f63971d;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("data", this.f63968a);
            if (this.f63971d == 0 || this.f63972e == 0) {
                this.f63971d = this.f63972e;
            }
            jSONObject2.put("mintime", Long.toString(this.f63971d));
            jSONObject2.put("maxtime", Long.toString(this.f63972e));
            jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
            jSONObject2.put(PackageTable.MD5, g0.b(this.f63968a.toString().getBytes(), true));
            jSONObject.put("metadata", jSONObject2);
            jSONObject.put("isAbtest", this.f63973f);
            jSONObject.put(Constant.IS_REAL, this.f63974g ? "1" : "0");
        } catch (JSONException unused) {
            if (j) {
                Log.d("UBCUploadData", "json exception:");
            }
        }
        return jSONObject;
    }

    public boolean j() {
        return this.f63968a.length() == 0;
    }

    public boolean k() {
        return this.f63975h >= this.f63976i;
    }

    public boolean l() {
        return this.f63974g;
    }

    public void m(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f63975h += i2;
    }

    public final void n(String str) {
        if (this.f63970c.contains(str)) {
            return;
        }
        this.f63970c.add(str);
    }

    public final void o(int i2, int i3) {
        this.f63969b.put(i2, Integer.valueOf(i3));
    }

    public final void p(long j2, long j3) {
        long j4 = this.f63971d;
        if ((j2 < j4 || j4 == 0) && j2 != 0) {
            this.f63971d = j2;
        }
        if (j3 > this.f63972e) {
            this.f63972e = j3;
        }
    }

    public void q(String str) {
        this.f63973f = str;
    }

    public void r(boolean z) {
        this.f63974g = z;
    }

    public void s(int i2) {
        if (i2 < 0) {
            return;
        }
        this.f63976i = i2;
    }
}
