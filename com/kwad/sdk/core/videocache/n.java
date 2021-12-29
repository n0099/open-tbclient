package com.kwad.sdk.core.videocache;

import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class n {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f58515b;

    /* renamed from: c  reason: collision with root package name */
    public final String f58516c;

    public n(String str, long j2, String str2) {
        this.a = str;
        this.f58515b = j2;
        this.f58516c = str2;
    }

    public String toString() {
        return "SourceInfo{url='" + this.a + ExtendedMessageFormat.QUOTE + ", length=" + this.f58515b + ", mime='" + this.f58516c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
