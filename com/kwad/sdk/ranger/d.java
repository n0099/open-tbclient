package com.kwad.sdk.ranger;

import com.ksad.json.annotation.KsJson;
import java.util.List;
@KsJson
/* loaded from: classes10.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public List<String> aLC;
    public List<a> aLD;
    public List<com.kwad.sdk.ranger.a.a> aLE;
    public long funcSwitch;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String aLF;
        public String aLG;
    }

    public final boolean IZ() {
        if ((this.funcSwitch & 1) == 0) {
            return true;
        }
        return false;
    }

    public final boolean Ja() {
        return dz(2);
    }

    public final boolean Jb() {
        return dz(4);
    }

    public final boolean Jc() {
        return dz(16);
    }

    private boolean dz(int i) {
        if (IZ() || (this.funcSwitch & i) == 0) {
            return false;
        }
        return true;
    }
}
