package com.qq.e.comm.plugin.ab.d;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.bi;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f12058a;

    /* renamed from: b  reason: collision with root package name */
    private Context f12059b;
    private boolean c;

    public e(Context context, JSONObject jSONObject) {
        this(context, jSONObject, false);
    }

    public e(Context context, JSONObject jSONObject, boolean z) {
        this.f12059b = context;
        this.f12058a = jSONObject;
        this.c = z;
    }

    public a a() {
        a hVar = (GDTADManager.getInstance().getSM().getInteger("innerWebViewX5On", 1) == 1 && bi.a()) ? new h(this.f12059b, this.f12058a) : new c(this.f12059b, this.f12058a);
        if (this.c) {
            hVar.f();
        }
        return hVar;
    }
}
