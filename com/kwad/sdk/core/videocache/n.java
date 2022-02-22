package com.kwad.sdk.core.videocache;

import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class n {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final long f56519b;

    /* renamed from: c  reason: collision with root package name */
    public final String f56520c;

    public n(String str, long j2, String str2) {
        this.a = str;
        this.f56519b = j2;
        this.f56520c = str2;
    }

    public String toString() {
        return "SourceInfo{url='" + this.a + ExtendedMessageFormat.QUOTE + ", length=" + this.f56519b + ", mime='" + this.f56520c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
