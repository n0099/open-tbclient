package com.kwad.sdk.internal.api;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public long h;

    public boolean a() {
        return this.a == 0 && this.b == 0 && TextUtils.isEmpty(this.c);
    }

    public boolean b() {
        return TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.e) && TextUtils.isEmpty(this.g) && TextUtils.isEmpty(this.f);
    }
}
