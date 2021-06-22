package d.b.b;

import android.annotation.SuppressLint;
import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f68911e;

    public o(Context context) {
        super(true, true);
        this.f68911e = context;
    }

    @Override // d.b.b.h2
    @SuppressLint({"MissingPermission"})
    public boolean b(JSONObject jSONObject) {
        j.f(jSONObject, "access", o0.b(this.f68911e));
        return true;
    }
}
