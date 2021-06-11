package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f2 extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f68751e;

    /* renamed from: f  reason: collision with root package name */
    public final i f68752f;

    public f2(Context context, i iVar) {
        super(true, false);
        this.f68751e = context;
        this.f68752f = iVar;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f68752f.i())) {
            jSONObject.put("ab_client", this.f68752f.i());
        }
        if (!TextUtils.isEmpty(this.f68752f.P())) {
            if (r0.f68823b) {
                r0.a("init config has abversion:" + this.f68752f.P(), null);
            }
            jSONObject.put("ab_version", this.f68752f.P());
        }
        if (!TextUtils.isEmpty(this.f68752f.j())) {
            jSONObject.put("ab_group", this.f68752f.j());
        }
        if (TextUtils.isEmpty(this.f68752f.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f68752f.k());
        return true;
    }
}
