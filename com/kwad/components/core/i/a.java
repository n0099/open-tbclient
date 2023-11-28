package com.kwad.components.core.i;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class a {
    public static int LO = 12;
    public static int LP = 4;
    public static int LQ = 1;

    /* renamed from: com.kwad.components.core.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0649a {
        void e(@Nullable List<c> list);

        void onError(int i, String str);

        void onRequestResult(int i);
    }

    public static void a(int i, int i2, @NonNull SceneImpl sceneImpl, final int i3, final InterfaceC0649a interfaceC0649a) {
        SceneImpl m185clone = sceneImpl.m185clone();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        m185clone.setAdStyle(i);
        m185clone.setAdNum(i2);
        a(new ImpInfo(m185clone), null, false, true, new j() { // from class: com.kwad.components.core.i.a.1
            @Override // com.kwad.components.core.request.k
            public final void a(@NonNull final AdResultData adResultData) {
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.i.a.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            InterfaceC0649a.this.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                });
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.i.a.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC0649a.this.e(a.b(adResultData.getAdTemplateList(), i3));
                        a.a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.request.k
            public final void onError(final int i4, final String str) {
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.i.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.c.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                        InterfaceC0649a.this.onError(i4, str);
                    }
                });
            }
        }, false);
    }

    public static void a(final ImpInfo impInfo, List<String> list, boolean z, boolean z2, @NonNull final j jVar, boolean z3) {
        new com.kwad.components.core.m.a(impInfo) { // from class: com.kwad.components.core.i.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: mt */
            public final com.kwad.components.core.request.a createRequest() {
                com.kwad.components.core.request.a aVar = new com.kwad.components.core.request.a(impInfo, r3, r4, null);
                aVar.aB(r5 ? 1 : 0);
                return aVar;
            }
        }.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.i.a.3
            private void h(int i, String str) {
                jVar.onError(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdResultData) baseResultData);
            }

            private void c(@NonNull AdResultData adResultData) {
                String str;
                if (adResultData.isAdResultDataEmpty() && !r1) {
                    j jVar2 = jVar;
                    int i = com.kwad.sdk.core.network.e.ats.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.ats.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    jVar2.onError(i, str);
                    return;
                }
                jVar.a(adResultData);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
                h(i, str);
            }
        });
    }

    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() > 0 && (adTemplate = adResultData.getAdTemplateList().get(0)) != null) {
            com.kwad.components.core.o.a.pX().g(adTemplate, elapsedRealtime - j);
        }
    }

    public static List<c> b(List<AdTemplate> list, int i) {
        ArrayList arrayList = new ArrayList();
        for (AdTemplate adTemplate : list) {
            arrayList.add(new c(adTemplate, i));
        }
        return arrayList;
    }

    public static void a(@NonNull SceneImpl sceneImpl, InterfaceC0649a interfaceC0649a) {
        a(15, LP, sceneImpl, e.AGGREGATION, interfaceC0649a);
    }

    public static void b(@NonNull SceneImpl sceneImpl, InterfaceC0649a interfaceC0649a) {
        a(17, LQ, sceneImpl, e.Ma, interfaceC0649a);
    }
}
