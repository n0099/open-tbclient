package com.vivo.push.b;

import java.util.HashMap;
/* loaded from: classes15.dex */
public final class aa extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f4634a;
    private long b;

    public aa() {
        super(2012);
    }

    public aa(long j) {
        this();
        this.b = j;
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f4634a = hashMap;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.f4634a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f4634a = (HashMap) aVar.c("ReporterCommand.EXTRA_PARAMS");
        this.b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "ReporterCommand（" + this.b + ")";
    }
}
