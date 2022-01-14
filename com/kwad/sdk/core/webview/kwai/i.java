package com.kwad.sdk.core.webview.kwai;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class i extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f56483b;

    /* renamed from: c  reason: collision with root package name */
    public String f56484c;

    public long a() {
        try {
            return new JSONObject(this.f56484c).optLong("creativeId", -1L);
        } catch (Exception unused) {
            return -1L;
        }
    }
}
