package com.kwad.sdk.core.videocache;

import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes8.dex */
public class n {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f54869b;

    /* renamed from: c  reason: collision with root package name */
    public final String f54870c;

    public n(String str, long j2, String str2) {
        this.a = str;
        this.f54869b = j2;
        this.f54870c = str2;
    }

    public String toString() {
        return "SourceInfo{url='" + this.a + ExtendedMessageFormat.QUOTE + ", length=" + this.f54869b + ", mime='" + this.f54870c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
