package com.qq.e.comm.plugin.i;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.f;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.a.n;
import com.qq.e.comm.plugin.a.p;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.at;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private ai.a f12089a = null;

    /* renamed from: b  reason: collision with root package name */
    private Context f12090b = GDTADManager.getInstance().getAppContext();

    /* loaded from: classes15.dex */
    private interface a extends f.a {
    }

    private void a(final IGDTApkListener iGDTApkListener, final int i, final String str) {
        if (iGDTApkListener != null) {
            w.a(new Runnable() { // from class: com.qq.e.comm.plugin.i.b.3
                @Override // java.lang.Runnable
                public void run() {
                    iGDTApkListener.onError(new AdError(i, str));
                }
            });
        }
    }

    private void a(final IGDTApkListener iGDTApkListener, final com.qq.e.comm.plugin.i.a aVar) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.i.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (iGDTApkListener != null) {
                    iGDTApkListener.onApkLoad(aVar);
                }
            }
        });
    }

    public void a(Context context, GDTApk gDTApk, IGDTApkListener iGDTApkListener) {
        if (context == null || gDTApk == null || iGDTApkListener == null) {
            GDTLogger.e("传入参数为 null");
            return;
        }
        final com.qq.e.comm.plugin.a.c a2 = gDTApk instanceof com.qq.e.comm.plugin.i.a ? ((com.qq.e.comm.plugin.i.a) gDTApk).a() : null;
        if (a2 == null) {
            GDTLogger.e("传入的 GDTApk 为 null");
            return;
        }
        u.a(100422, 1, new com.qq.e.comm.plugin.y.c().b(a2.l()));
        if (!com.qq.e.comm.plugin.a.e.a.a(a2)) {
            a(iGDTApkListener, 5043, "调用安装器时，Apk 文件不存在");
        } else if (d.a(at.b("downloaded_not_installed_apk", System.currentTimeMillis()), System.currentTimeMillis(), a2)) {
            a(iGDTApkListener, 5042, "接口调用时间间隔过长!");
        } else {
            p pVar = new p(context, a2);
            pVar.a(new a() { // from class: com.qq.e.comm.plugin.i.b.1
                @Override // com.qq.e.comm.plugin.a.f.a
                public void a(int i, String str, boolean z) {
                    if (i == 0) {
                        JSONObject s = a2.s();
                        if (s != null) {
                            try {
                                String optString = s.optJSONObject("reportUrl").optString(String.valueOf(2));
                                if (TextUtils.isEmpty(optString)) {
                                    com.qq.e.comm.plugin.a.b.a(a2, true);
                                } else {
                                    af.a(optString + "&tips_install=1", true, null);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                com.qq.e.comm.plugin.a.b.a(a2, true);
                            }
                        } else {
                            com.qq.e.comm.plugin.a.b.a(a2, true);
                        }
                        n.a(a2);
                        ai.a("ApkInstallWorker.SUCCESS", b.this.f12089a);
                    }
                }

                @Override // com.qq.e.comm.plugin.a.f.a
                public boolean a() {
                    return true;
                }
            });
            pVar.a(d.c(a2));
        }
    }

    public void a(IGDTApkListener iGDTApkListener) {
        if (GDTADManager.getInstance().getSM().getInteger("apk_downloaded_task", 0) == 0) {
            a(iGDTApkListener, 5045, "接口功能未开启");
        } else if (d.a()) {
            a(iGDTApkListener, 5041, "调用接口短时间内过于频繁，请稍后再试!");
        } else {
            List<com.qq.e.comm.plugin.a.c> e = l.a().e();
            if (d.a(e)) {
                a(iGDTApkListener, 5044, "不存在有效的 Apk 文件");
            } else if (e.size() == 1) {
                com.qq.e.comm.plugin.a.c cVar = e.get(0);
                if (!d.a(cVar) && !com.qq.e.comm.plugin.a.e.a.a(GDTADManager.getInstance().getAppContext(), cVar.h())) {
                    cVar.a(true);
                    l.a().b(cVar);
                    ai.a(cVar.toString() + " , , time=" + (1.0f * ((float) (System.currentTimeMillis() - cVar.d()))) + "ms", this.f12089a);
                    at.a("downloaded_not_installed_apk", System.currentTimeMillis());
                    u.a(100412, 1, new com.qq.e.comm.plugin.y.c().b(cVar.l()));
                    if (com.qq.e.comm.plugin.a.e.a.a(cVar) && com.qq.e.comm.plugin.a.e.a.a(d.c(cVar), cVar.h(), this.f12090b)) {
                        a(iGDTApkListener, d.b(cVar));
                        return;
                    }
                }
                a(iGDTApkListener, 5044, "不存在有效的 Apk 文件");
            } else {
                Iterator<com.qq.e.comm.plugin.a.c> it = e.iterator();
                while (it.hasNext()) {
                    com.qq.e.comm.plugin.a.c next = it.next();
                    if (d.a(next) || com.qq.e.comm.plugin.a.e.a.a(GDTADManager.getInstance().getAppContext(), next.h()) || !com.qq.e.comm.plugin.a.e.a.a(next) || !com.qq.e.comm.plugin.a.e.a.a(d.c(next), next.h(), this.f12090b)) {
                        it.remove();
                    }
                }
                if (d.a(e)) {
                    a(iGDTApkListener, 5044, "不存在有效的 Apk 文件");
                    return;
                }
                d.b(e);
                com.qq.e.comm.plugin.a.c cVar2 = e.get(0);
                for (int i = 1; i < e.size(); i++) {
                    com.qq.e.comm.plugin.a.c cVar3 = e.get(i);
                    if ((!cVar3.c() && cVar2.d() > cVar3.d()) || cVar2.c()) {
                        cVar2 = cVar3;
                    }
                }
                cVar2.a(true);
                l.a().b(cVar2);
                at.a("downloaded_not_installed_apk", System.currentTimeMillis());
                u.a(100412, 1, new com.qq.e.comm.plugin.y.c().b(cVar2.l()));
                a(iGDTApkListener, d.b(cVar2));
            }
        }
    }
}
