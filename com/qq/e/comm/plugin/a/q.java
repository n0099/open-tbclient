package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.d;
import com.qq.e.comm.plugin.a.f;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
class q implements d.a, f.a {

    /* renamed from: a  reason: collision with root package name */
    private final f f11646a;

    /* renamed from: b  reason: collision with root package name */
    private final d f11647b;
    private final c c;

    public q(d dVar, f fVar, c cVar) {
        this.f11646a = fVar;
        this.f11647b = dVar;
        this.c = cVar;
        dVar.a(this);
        fVar.a(this);
    }

    private void a(Context context, Intent intent, c cVar) {
        context.startActivity(intent);
        if (!a(cVar) || b(4)) {
            return;
        }
        com.qq.e.comm.plugin.w.a.b(cVar.k());
    }

    private void a(Context context, c cVar) {
        Intent a2 = n.a(context, cVar);
        if (a2 != null) {
            try {
                a(context, a2, cVar);
            } catch (Throwable th) {
                try {
                    a(context, com.qq.e.comm.plugin.w.a.c.a(context, cVar.h(), (Uri) null), cVar);
                } catch (Throwable th2) {
                    GDTLogger.e("FailToLaunchAPPWithPackageName");
                }
            }
        }
    }

    private boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return az.b(cVar.t());
    }

    private boolean b(int i) {
        String a2 = this.c.a(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        if (a2 == null) {
            return false;
        }
        try {
            Object remove = new JSONObject(a2).optJSONObject("reportUrl").remove(String.valueOf(i));
            if (remove != null) {
                af.a(remove.toString());
                return true;
            }
            return false;
        } catch (JSONException e) {
            ai.a(e.getMessage(), e);
            return false;
        }
    }

    @Override // com.qq.e.comm.plugin.a.d.a
    public void a(int i) {
        if (i == 3) {
            b(0);
        }
    }

    public void a(int i, String str) {
    }

    @Override // com.qq.e.comm.plugin.a.d.a
    public void a(int i, String str, File file) {
        if (i == 0) {
            b(1);
        }
        if (i == 9 || (i == 0 && this.c.d("autoInstall"))) {
            this.f11646a.a(file);
        }
        a(i, str);
    }

    @Override // com.qq.e.comm.plugin.a.f.a
    public void a(int i, String str, boolean z) {
        if (i == 0) {
            if (!z) {
                b(2);
            }
            if (a(this.c)) {
                b(3);
            }
            a(GDTADManager.getInstance().getAppContext(), this.c);
        }
        a(i, str);
    }

    @Override // com.qq.e.comm.plugin.a.d.a
    public void a(long j, long j2) {
    }

    @Override // com.qq.e.comm.plugin.a.f.a
    public boolean a() {
        return false;
    }

    public void b() {
        com.qq.e.comm.plugin.util.s.f12591a.submit(this.f11647b);
    }
}
