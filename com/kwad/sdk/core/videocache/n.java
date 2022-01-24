package com.kwad.sdk.core.videocache;

import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class n {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f56352b;

    /* renamed from: c  reason: collision with root package name */
    public final String f56353c;

    public n(String str, long j2, String str2) {
        this.a = str;
        this.f56352b = j2;
        this.f56353c = str2;
    }

    public String toString() {
        return "SourceInfo{url='" + this.a + ExtendedMessageFormat.QUOTE + ", length=" + this.f56352b + ", mime='" + this.f56353c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
