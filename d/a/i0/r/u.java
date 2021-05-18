package d.a.i0.r;

import android.util.SparseIntArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: g  reason: collision with root package name */
    public boolean f48311g = false;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f48305a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseIntArray f48306b = new SparseIntArray();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f48307c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f48308d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f48309e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f48310f = "0";

    public final void a(JSONObject jSONObject) {
        this.f48305a.put(jSONObject);
    }

    public boolean b(int i2) {
        return this.f48305a.toString().getBytes().length >= i2;
    }

    public void c() {
        this.f48306b.clear();
        this.f48307c.clear();
        this.f48305a = null;
    }

    public boolean d() {
        return this.f48305a.length() == 0;
    }

    public final void e(String str) {
        if (this.f48307c.contains(str)) {
            return;
        }
        this.f48307c.add(str);
    }

    public final void f(int i2, int i3) {
        this.f48306b.put(i2, i3);
    }

    public final void g(long j, long j2) {
        long j3 = this.f48308d;
        if ((j < j3 || j3 == 0) && j != 0) {
            this.f48308d = j;
        }
        if (j2 > this.f48309e) {
            this.f48309e = j2;
        }
    }
}
