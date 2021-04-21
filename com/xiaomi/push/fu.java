package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class fu extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fs f40916a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Exception f411a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f40917b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fu(fs fsVar, int i, int i2, Exception exc) {
        super(i);
        this.f40916a = fsVar;
        this.f40917b = i2;
        this.f411a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "shutdown the connection. " + this.f40917b + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f411a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.f40916a.f40909b.a(this.f40917b, this.f411a);
    }
}
