package com.vivo.push.b;

import java.util.HashMap;
/* loaded from: classes3.dex */
public final class aa extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f13865a;

    /* renamed from: b  reason: collision with root package name */
    private long f13866b;

    public aa() {
        super(2012);
    }

    public aa(long j) {
        this();
        this.f13866b = j;
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f13865a = hashMap;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.f13865a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f13866b);
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f13865a = (HashMap) aVar.c("ReporterCommand.EXTRA_PARAMS");
        this.f13866b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f13866b);
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "ReporterCommand（" + this.f13866b + ")";
    }
}
