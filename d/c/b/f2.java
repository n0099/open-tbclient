package d.c.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f2 extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65933e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65934f;

    public f2(Context context, i iVar) {
        super(true, false);
        this.f65933e = context;
        this.f65934f = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f65934f.i())) {
            jSONObject.put("ab_client", this.f65934f.i());
        }
        if (!TextUtils.isEmpty(this.f65934f.P())) {
            if (r0.f66004b) {
                r0.a("init config has abversion:" + this.f65934f.P(), null);
            }
            jSONObject.put("ab_version", this.f65934f.P());
        }
        if (!TextUtils.isEmpty(this.f65934f.j())) {
            jSONObject.put("ab_group", this.f65934f.j());
        }
        if (TextUtils.isEmpty(this.f65934f.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f65934f.k());
        return true;
    }
}
