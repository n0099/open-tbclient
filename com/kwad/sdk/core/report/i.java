package com.kwad.sdk.core.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class i extends d<q, h> {
    public static volatile boolean Ri;
    public static volatile i avy;
    public static u<q, h> avz;

    public static i Dx() {
        if (avy == null) {
            synchronized (i.class) {
                if (avy == null) {
                    avy = new i();
                }
            }
        }
        avy.checkInit();
        return avy;
    }

    public static boolean S(long j) {
        v vVar = (v) ServiceProvider.get(v.class);
        if (vVar != null && vVar.S(j)) {
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(@NonNull q qVar) {
        a(qVar, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* renamed from: b */
    public h a(q qVar) {
        u<q, h> uVar = avz;
        if (uVar != null) {
            return uVar.DG();
        }
        return (h) super.a((i) qVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* renamed from: w */
    public h u(List<q> list) {
        u<q, h> uVar = avz;
        if (uVar != null) {
            return uVar.DH();
        }
        String x = x(list);
        if (!TextUtils.isEmpty(x)) {
            return new h(x);
        }
        return new h(list);
    }

    public static void a(@NonNull q qVar, boolean z) {
        Dx().b(qVar, z);
    }

    private void b(final q qVar, boolean z) {
        if (qVar != null && Ri) {
            if (!z && !S(qVar.actionType)) {
                avy.a(new n<q>() { // from class: com.kwad.sdk.core.report.i.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.report.n
                    /* renamed from: Dy */
                    public q Dt() {
                        return qVar.DC();
                    }
                });
            } else {
                avy.b(new n<q>() { // from class: com.kwad.sdk.core.report.i.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.report.n
                    /* renamed from: Dy */
                    public q Dt() {
                        return qVar.DC();
                    }
                });
            }
        }
    }

    private synchronized void checkInit() {
        if (Ri) {
            return;
        }
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            return;
        }
        Context context = fVar.getContext();
        if (context == null) {
            return;
        }
        int as = hVar.as(context);
        i(context, as);
        w.init(context);
        w.DI();
        com.kwad.sdk.core.e.c.d("BatchReporter", "cache type = " + as);
        if (as == 2) {
            a(t.bf(context));
        }
        Ri = true;
    }

    public static String x(List<q> list) {
        if (list.get(0) != null && !TextUtils.isEmpty(list.get(0).awP)) {
            StringBuilder sb = new StringBuilder(",\"actionList\":[");
            for (q qVar : list) {
                sb.append(qVar.awP);
                sb.append(',');
            }
            int length = sb.length();
            sb.replace(length - 1, length, PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return "";
    }

    @Override // com.kwad.sdk.core.report.d
    public final Runnable a(Context context, o<q> oVar, AtomicInteger atomicInteger) {
        z<q, h> DF;
        u<q, h> uVar = avz;
        if (uVar != null && (DF = uVar.DF()) != null) {
            return DF;
        }
        return super.a(context, oVar, atomicInteger);
    }
}
