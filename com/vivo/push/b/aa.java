package com.vivo.push.b;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class aa extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f13866a;

    /* renamed from: b  reason: collision with root package name */
    private long f13867b;

    public aa() {
        super(2012);
    }

    public aa(long j) {
        this();
        this.f13867b = j;
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f13866a = hashMap;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.f13866a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f13867b);
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f13866a = (HashMap) aVar.c("ReporterCommand.EXTRA_PARAMS");
        this.f13867b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f13867b);
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "ReporterCommand（" + this.f13867b + ")";
    }
}
