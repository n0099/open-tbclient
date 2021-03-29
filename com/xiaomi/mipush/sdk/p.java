package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ai;
import com.xiaomi.push.hf;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
/* loaded from: classes7.dex */
public final class p extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40204a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ie f92a;

    public p(ie ieVar, Context context) {
        this.f92a = ieVar;
        this.f40204a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo165a() {
        return com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE;
    }

    @Override // java.lang.Runnable
    public void run() {
        ie ieVar = this.f92a;
        if (ieVar != null) {
            ieVar.a(com.xiaomi.push.service.at.a());
            an.a(this.f40204a.getApplicationContext()).a((an) this.f92a, hf.Notification, true, (hs) null, true);
        }
    }
}
