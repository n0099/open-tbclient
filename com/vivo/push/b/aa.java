package com.vivo.push.b;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class aa extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f40204a;

    /* renamed from: b  reason: collision with root package name */
    public long f40205b;

    public aa() {
        super(IMConstants.IM_MSG_TYPE_SHIELD_ME);
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f40204a = hashMap;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.f40204a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f40205b);
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f40204a = (HashMap) aVar.c("ReporterCommand.EXTRA_PARAMS");
        this.f40205b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f40205b);
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "ReporterCommand（" + this.f40205b + SmallTailInfo.EMOTION_SUFFIX;
    }

    public aa(long j) {
        this();
        this.f40205b = j;
    }
}
