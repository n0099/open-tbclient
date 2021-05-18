package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f2 extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f64977e;

    /* renamed from: f  reason: collision with root package name */
    public final i f64978f;

    public f2(Context context, i iVar) {
        super(true, false);
        this.f64977e = context;
        this.f64978f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f64978f.i())) {
            jSONObject.put("ab_client", this.f64978f.i());
        }
        if (!TextUtils.isEmpty(this.f64978f.P())) {
            if (r0.f65049b) {
                r0.a("init config has abversion:" + this.f64978f.P(), null);
            }
            jSONObject.put("ab_version", this.f64978f.P());
        }
        if (!TextUtils.isEmpty(this.f64978f.j())) {
            jSONObject.put("ab_group", this.f64978f.j());
        }
        if (TextUtils.isEmpty(this.f64978f.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f64978f.k());
        return true;
    }
}
