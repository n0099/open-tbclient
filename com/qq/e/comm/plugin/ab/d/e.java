package com.qq.e.comm.plugin.ab.d;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.bi;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f12057a;

    /* renamed from: b  reason: collision with root package name */
    private Context f12058b;
    private boolean c;

    public e(Context context, JSONObject jSONObject) {
        this(context, jSONObject, false);
    }

    public e(Context context, JSONObject jSONObject, boolean z) {
        this.f12058b = context;
        this.f12057a = jSONObject;
        this.c = z;
    }

    public a a() {
        a hVar = (GDTADManager.getInstance().getSM().getInteger("innerWebViewX5On", 1) == 1 && bi.a()) ? new h(this.f12058b, this.f12057a) : new c(this.f12058b, this.f12057a);
        if (this.c) {
            hVar.f();
        }
        return hVar;
    }
}
