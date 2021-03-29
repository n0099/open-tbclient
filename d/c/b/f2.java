package d.c.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f2 extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f64993e;

    /* renamed from: f  reason: collision with root package name */
    public final i f64994f;

    public f2(Context context, i iVar) {
        super(true, false);
        this.f64993e = context;
        this.f64994f = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f64994f.i())) {
            jSONObject.put("ab_client", this.f64994f.i());
        }
        if (!TextUtils.isEmpty(this.f64994f.P())) {
            if (r0.f65064b) {
                r0.a("init config has abversion:" + this.f64994f.P(), null);
            }
            jSONObject.put("ab_version", this.f64994f.P());
        }
        if (!TextUtils.isEmpty(this.f64994f.j())) {
            jSONObject.put("ab_group", this.f64994f.j());
        }
        if (TextUtils.isEmpty(this.f64994f.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f64994f.k());
        return true;
    }
}
