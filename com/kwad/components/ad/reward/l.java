package com.kwad.components.ad.reward;

import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class l {
    public static void a(final int i, final g gVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.e, RewardCallBackRespInfo> lVar = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.l.1
            @NonNull
            public static RewardCallBackRespInfo C(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return C(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: gj */
            public com.kwad.components.core.request.e createRequest() {
                return new com.kwad.components.core.request.e(i, gVar.mAdTemplate);
            }
        };
        if (i == 1) {
            lVar.request(i(gVar));
        } else if (i == 2) {
            lVar.request(j(gVar));
        }
    }

    public static void a(g gVar, long j, long j2, long j3) {
        long j4;
        boolean k = k(gVar);
        if (k) {
            j4 = com.kwad.sdk.core.response.b.a.cV(com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate));
        } else {
            j4 = 0;
        }
        if (!gVar.pg && k && gVar.mCheckExposureResult && j > ((j2 - 800) - j3) - j4 && j4 > 0) {
            if (com.kwad.sdk.core.response.b.a.cW(com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate))) {
                gVar.pf = 1;
                a(2, gVar);
            } else {
                gVar.oH.onRewardVerify();
            }
            gVar.pg = true;
        }
    }

    public static com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo> i(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.l.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.request.e eVar) {
                eVar.Rh = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.request.e eVar, int i, String str) {
                super.onError(eVar, i, str);
                bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.l.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.mCheckExposureResult = false;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - eVar.Rh, i, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.request.e eVar, @NonNull final RewardCallBackRespInfo rewardCallBackRespInfo) {
                bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.l.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        g gVar2 = g.this;
                        boolean z = true;
                        if (rewardCallBackRespInfo.result != 1) {
                            z = false;
                        }
                        gVar2.mCheckExposureResult = z;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - eVar.Rh, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }
        };
    }

    public static com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo> j(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.l.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.request.e eVar) {
                eVar.Rh = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.request.e eVar, int i, String str) {
                super.onError(eVar, i, str);
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.l.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.pf = 2;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - eVar.Rh, i, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.request.e eVar, @NonNull final RewardCallBackRespInfo rewardCallBackRespInfo) {
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.l.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (rewardCallBackRespInfo.result == 1) {
                            g.this.pf = 1;
                        } else {
                            g.this.pf = 2;
                        }
                        g.this.oH.onRewardVerify();
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - eVar.Rh, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }
        };
    }

    public static boolean k(g gVar) {
        if (gVar.pg || !com.kwad.sdk.core.response.b.a.cX(com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate))) {
            return false;
        }
        return true;
    }
}
