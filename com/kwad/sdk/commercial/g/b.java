package com.kwad.sdk.commercial.g;

import com.ksad.json.annotation.KsJson;
import java.net.URL;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.commercial.d.a {
    public String anF;
    public String anM;
    public int status;
    public String url;

    public static b zX() {
        return new b();
    }

    public final b ce(int i) {
        this.status = i;
        return this;
    }

    public final b cu(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.anF = url.getHost();
            this.anM = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }
}
