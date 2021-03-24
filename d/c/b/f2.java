package d.c.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f2 extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f64992e;

    /* renamed from: f  reason: collision with root package name */
    public final i f64993f;

    public f2(Context context, i iVar) {
        super(true, false);
        this.f64992e = context;
        this.f64993f = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f64993f.i())) {
            jSONObject.put("ab_client", this.f64993f.i());
        }
        if (!TextUtils.isEmpty(this.f64993f.P())) {
            if (r0.f65063b) {
                r0.a("init config has abversion:" + this.f64993f.P(), null);
            }
            jSONObject.put("ab_version", this.f64993f.P());
        }
        if (!TextUtils.isEmpty(this.f64993f.j())) {
            jSONObject.put("ab_group", this.f64993f.j());
        }
        if (TextUtils.isEmpty(this.f64993f.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f64993f.k());
        return true;
    }
}
