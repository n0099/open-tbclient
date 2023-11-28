package com.kwad.sdk.commercial.c;

import com.ksad.json.annotation.KsJson;
import java.net.URL;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.commercial.d.a {
    public String anF;
    public String anM;
    public String anN;
    public int anO;
    public int anP;
    public int status;
    public String url;

    public static b zS() {
        return new b();
    }

    public final b ca(int i) {
        this.status = i;
        return this;
    }

    public final b cb(int i) {
        this.anO = i;
        return this;
    }

    public final b cc(int i) {
        this.anP = i;
        return this;
    }

    public final b co(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.anF = url.getHost();
            this.anM = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cp(String str) {
        this.anN = str;
        return this;
    }
}
