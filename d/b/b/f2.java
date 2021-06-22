package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f2 extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f68855e;

    /* renamed from: f  reason: collision with root package name */
    public final i f68856f;

    public f2(Context context, i iVar) {
        super(true, false);
        this.f68855e = context;
        this.f68856f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f68856f.i())) {
            jSONObject.put("ab_client", this.f68856f.i());
        }
        if (!TextUtils.isEmpty(this.f68856f.P())) {
            if (r0.f68927b) {
                r0.a("init config has abversion:" + this.f68856f.P(), null);
            }
            jSONObject.put("ab_version", this.f68856f.P());
        }
        if (!TextUtils.isEmpty(this.f68856f.j())) {
            jSONObject.put("ab_group", this.f68856f.j());
        }
        if (TextUtils.isEmpty(this.f68856f.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f68856f.k());
        return true;
    }
}
