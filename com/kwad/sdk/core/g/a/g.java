package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes5.dex */
public class g extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f9466a;

    /* renamed from: b  reason: collision with root package name */
    public String f9467b;

    public static g a() {
        SdkConfigData.TemplateConfig a2 = com.kwad.sdk.core.config.c.a();
        if (a2 != null) {
            g gVar = new g();
            if (a2.h5Url != null) {
                gVar.f9467b = a2.h5Url;
            }
            if (a2.h5Version != null) {
                gVar.f9466a = a2.h5Version;
            }
            if (gVar.f9467b != null || gVar.f9466a != null) {
                return gVar;
            }
        }
        return null;
    }
}
