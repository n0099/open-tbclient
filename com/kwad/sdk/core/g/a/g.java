package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes3.dex */
public class g extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f6101a;
    public String b;

    public static g a() {
        SdkConfigData.TemplateConfig a2 = com.kwad.sdk.core.config.c.a();
        if (a2 != null) {
            g gVar = new g();
            if (a2.h5Url != null) {
                gVar.b = a2.h5Url;
            }
            if (a2.h5Version != null) {
                gVar.f6101a = a2.h5Version;
            }
            if (gVar.b != null || gVar.f6101a != null) {
                return gVar;
            }
        }
        return null;
    }
}
