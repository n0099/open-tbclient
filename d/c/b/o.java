package d.c.b;

import android.annotation.SuppressLint;
import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65049e;

    public o(Context context) {
        super(true, true);
        this.f65049e = context;
    }

    @Override // d.c.b.h2
    @SuppressLint({"MissingPermission"})
    public boolean b(JSONObject jSONObject) {
        j.f(jSONObject, "access", o0.b(this.f65049e));
        return true;
    }
}
