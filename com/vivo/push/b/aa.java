package com.vivo.push.b;

import com.baidu.android.imsdk.IMConstants;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class aa extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f13566a;

    /* renamed from: b  reason: collision with root package name */
    private long f13567b;

    public aa() {
        super(IMConstants.IM_MSG_TYPE_SHIELD_ME);
    }

    public aa(long j) {
        this();
        this.f13567b = j;
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f13566a = hashMap;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.f13566a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f13567b);
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f13566a = (HashMap) aVar.c("ReporterCommand.EXTRA_PARAMS");
        this.f13567b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f13567b);
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "ReporterCommand（" + this.f13567b + ")";
    }
}
