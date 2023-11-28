package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class ge extends XMPushService.j {
    public final /* synthetic */ gc a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Exception f427a;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge(gc gcVar, int i, int i2, Exception exc) {
        super(i);
        this.a = gcVar;
        this.b = i2;
        this.f427a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo765a() {
        return "shutdown the connection. " + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f427a;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo482a() {
        this.a.b.a(this.b, this.f427a);
    }
}
