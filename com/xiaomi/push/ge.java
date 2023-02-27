package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public class ge extends XMPushService.j {
    public final /* synthetic */ gc a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Exception f431a;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge(gc gcVar, int i, int i2, Exception exc) {
        super(i);
        this.a = gcVar;
        this.b = i2;
        this.f431a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo672a() {
        return "shutdown the connection. " + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f431a;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo389a() {
        this.a.b.a(this.b, this.f431a);
    }
}
