package com.kwad.sdk.kgeo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.b;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.kgeo.c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static String aHJ;
    public static KGeoInfo aHK;
    public static final AtomicBoolean aHL = new AtomicBoolean();

    @Nullable
    public static KGeoInfo HJ() {
        return aHK;
    }

    public static void HK() {
        try {
            if (aHL.getAndSet(true)) {
                return;
            }
            c.a(ServiceProvider.Jn(), new c.a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.c.a
                public final void Gf() {
                    a.HL();
                }

                @Override // com.kwad.sdk.kgeo.c.a
                public final void onSuccess(String str) {
                    String unused = a.aHJ = str;
                    a.HL();
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void HL() {
        try {
            new l<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public final f createRequest() {
                    return new b();
                }

                @NonNull
                public static KGeoResultData fq(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ KGeoResultData parseData(String str) {
                    return fq(str);
                }
            }.request(new o<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                public static void a(@NonNull KGeoResultData kGeoResultData) {
                    KGeoInfo unused = a.aHK = kGeoResultData.kGeoInfo;
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                    a((KGeoResultData) baseResultData);
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public static String yh() {
        return aHJ;
    }

    public static void de(int i) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            HK();
        } else if (i == 2) {
            com.kwad.components.core.request.b.qc().a(new b.a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.b.a
                public final void qe() {
                    com.kwad.components.core.request.b.qc().b(this);
                    a.HK();
                }
            });
        }
    }
}
