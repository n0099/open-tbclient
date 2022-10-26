package com.kwad.sdk.internal.api;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public int acZ;
    public int ada;
    public String adb;
    public String agM;
    public String aiA;
    public String aiB;
    public long aiC;
    public String aiz;

    public final boolean xp() {
        return this.acZ == 0 && this.ada == 0 && TextUtils.isEmpty(this.adb);
    }

    public final boolean xq() {
        return TextUtils.isEmpty(this.aiz) && TextUtils.isEmpty(this.aiA) && TextUtils.isEmpty(this.agM) && TextUtils.isEmpty(this.aiB);
    }
}
