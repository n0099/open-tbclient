package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f2 extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f64291e;

    /* renamed from: f  reason: collision with root package name */
    public final i f64292f;

    public f2(Context context, i iVar) {
        super(true, false);
        this.f64291e = context;
        this.f64292f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f64292f.i())) {
            jSONObject.put("ab_client", this.f64292f.i());
        }
        if (!TextUtils.isEmpty(this.f64292f.P())) {
            if (r0.f64363b) {
                r0.a("init config has abversion:" + this.f64292f.P(), null);
            }
            jSONObject.put("ab_version", this.f64292f.P());
        }
        if (!TextUtils.isEmpty(this.f64292f.j())) {
            jSONObject.put("ab_group", this.f64292f.j());
        }
        if (TextUtils.isEmpty(this.f64292f.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f64292f.k());
        return true;
    }
}
