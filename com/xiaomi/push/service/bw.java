package com.xiaomi.push.service;

import com.xiaomi.push.du;
import com.xiaomi.push.fm;
import com.xiaomi.push.fp;
import java.util.Map;
/* loaded from: classes7.dex */
public class bw extends fm {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41800a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(XMPushService xMPushService, Map map, int i2, String str, fp fpVar) {
        super(map, i2, str, fpVar);
        this.f41800a = xMPushService;
    }

    @Override // com.xiaomi.push.fm
    /* renamed from: a */
    public byte[] mo314a() {
        try {
            du.b bVar = new du.b();
            bVar.a(bi.a().m601a());
            return bVar.m267a();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m56a("getOBBString err: " + e2.toString());
            return null;
        }
    }
}
