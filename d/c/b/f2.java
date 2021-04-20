package d.c.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f2 extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65838e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65839f;

    public f2(Context context, i iVar) {
        super(true, false);
        this.f65838e = context;
        this.f65839f = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f65839f.i())) {
            jSONObject.put("ab_client", this.f65839f.i());
        }
        if (!TextUtils.isEmpty(this.f65839f.P())) {
            if (r0.f65909b) {
                r0.a("init config has abversion:" + this.f65839f.P(), null);
            }
            jSONObject.put("ab_version", this.f65839f.P());
        }
        if (!TextUtils.isEmpty(this.f65839f.j())) {
            jSONObject.put("ab_group", this.f65839f.j());
        }
        if (TextUtils.isEmpty(this.f65839f.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f65839f.k());
        return true;
    }
}
