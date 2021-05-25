package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class fu extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fs f37612a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Exception f411a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f37613b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fu(fs fsVar, int i2, int i3, Exception exc) {
        super(i2);
        this.f37612a = fsVar;
        this.f37613b = i3;
        this.f411a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "shutdown the connection. " + this.f37613b + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f411a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.f37612a.f37605b.a(this.f37613b, this.f411a);
    }
}
