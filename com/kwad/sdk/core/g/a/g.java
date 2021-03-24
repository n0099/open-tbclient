package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes6.dex */
public class g extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f33653a;

    /* renamed from: b  reason: collision with root package name */
    public String f33654b;

    public static g a() {
        SdkConfigData.TemplateConfig a2 = com.kwad.sdk.core.config.c.a();
        if (a2 != null) {
            g gVar = new g();
            String str = a2.h5Url;
            if (str != null) {
                gVar.f33654b = str;
            }
            String str2 = a2.h5Version;
            if (str2 != null) {
                gVar.f33653a = str2;
            }
            if (gVar.f33654b == null && gVar.f33653a == null) {
                return null;
            }
            return gVar;
        }
        return null;
    }
}
