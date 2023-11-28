package com.kwad.sdk.commercial.i;

import com.ksad.json.annotation.KsJson;
import java.net.URL;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.commercial.d.a {
    public String anF;
    public String anM;
    public String aob;
    public String aoc;
    public int status;
    public String url;

    public static b zZ() {
        return new b();
    }

    public final b ch(int i) {
        this.status = i;
        return this;
    }

    public final b cw(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.anF = url.getHost();
            this.anM = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cx(String str) {
        this.aob = str;
        return this;
    }

    public final b cy(String str) {
        this.aoc = str;
        return this;
    }
}
