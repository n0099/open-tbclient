package d.a.l0.r;

import android.util.SparseIntArray;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: g  reason: collision with root package name */
    public boolean f48487g = false;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f48481a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseIntArray f48482b = new SparseIntArray();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f48483c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public long f48484d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f48485e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f48486f = "0";

    public final void a(JSONObject jSONObject) {
        this.f48481a.put(jSONObject);
    }

    public boolean b(int i2) {
        return this.f48481a.toString().getBytes().length >= i2;
    }

    public void c() {
        this.f48482b.clear();
        this.f48483c.clear();
        this.f48481a = null;
    }

    public boolean d() {
        return this.f48481a.length() == 0;
    }

    public final void e(String str) {
        if (this.f48483c.contains(str)) {
            return;
        }
        this.f48483c.add(str);
    }

    public final void f(int i2, int i3) {
        this.f48482b.put(i2, i3);
    }

    public final void g(long j, long j2) {
        long j3 = this.f48484d;
        if ((j < j3 || j3 == 0) && j != 0) {
            this.f48484d = j;
        }
        if (j2 > this.f48485e) {
            this.f48485e = j2;
        }
    }
}
