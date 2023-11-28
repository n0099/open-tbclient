package com.kwad.sdk.commercial.h;

import com.ksad.json.annotation.KsJson;
import java.net.URL;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.commercial.d.a {
    public int Od;
    public String anF;
    public String anM;
    public int status;
    public String url;

    public static b zY() {
        return new b();
    }

    public final b cf(int i) {
        this.status = i;
        return this;
    }

    public final b cg(int i) {
        this.Od = i;
        return this;
    }

    public final b cv(String str) {
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
