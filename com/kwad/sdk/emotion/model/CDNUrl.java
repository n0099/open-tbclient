package com.kwad.sdk.emotion.model;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class CDNUrl extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 5258518266352388651L;
    public String cdn;
    public String ip;
    public String url;
    public String urlPattern;

    public String getUrl() {
        return this.url;
    }
}
