package com.vivo.push.b;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class aa extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f39748a;

    /* renamed from: b  reason: collision with root package name */
    public long f39749b;

    public aa() {
        super(IMConstants.IM_MSG_TYPE_SHIELD_ME);
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f39748a = hashMap;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.f39748a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f39749b);
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f39748a = (HashMap) aVar.c("ReporterCommand.EXTRA_PARAMS");
        this.f39749b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f39749b);
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "ReporterCommand（" + this.f39749b + SmallTailInfo.EMOTION_SUFFIX;
    }

    public aa(long j) {
        this();
        this.f39749b = j;
    }
}
