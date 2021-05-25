package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f2 extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65020e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65021f;

    public f2(Context context, i iVar) {
        super(true, false);
        this.f65020e = context;
        this.f65021f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f65021f.i())) {
            jSONObject.put("ab_client", this.f65021f.i());
        }
        if (!TextUtils.isEmpty(this.f65021f.P())) {
            if (r0.f65092b) {
                r0.a("init config has abversion:" + this.f65021f.P(), null);
            }
            jSONObject.put("ab_version", this.f65021f.P());
        }
        if (!TextUtils.isEmpty(this.f65021f.j())) {
            jSONObject.put("ab_group", this.f65021f.j());
        }
        if (TextUtils.isEmpty(this.f65021f.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f65021f.k());
        return true;
    }
}
