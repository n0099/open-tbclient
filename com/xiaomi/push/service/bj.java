package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.al;
import com.xiaomi.push.cw;
import com.xiaomi.push.dt;
import com.xiaomi.push.service.bi;
import java.util.List;
/* loaded from: classes7.dex */
public class bj extends al.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bi f41890a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f930a = false;

    public bj(bi biVar) {
        this.f41890a = biVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039 A[Catch: Exception -> 0x0047, TRY_LEAVE, TryCatch #0 {Exception -> 0x0047, blocks: (B:2:0x0000, B:4:0x0012, B:9:0x0024, B:11:0x0039), top: B:16:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.xiaomi.push.al.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        String str;
        dt.a a2;
        try {
            String a3 = a.a(com.xiaomi.push.t.m622a()).a();
            if (!TextUtils.isEmpty(a3) && !com.xiaomi.push.o.China.name().equals(a3)) {
                str = "https://resolver.msg.global.xiaomi.net/psc/?t=a";
                a2 = dt.a.a(Base64.decode(cw.a(com.xiaomi.push.t.m622a(), str, (List<com.xiaomi.push.bf>) null), 10));
                if (a2 == null) {
                    this.f41890a.f928a = a2;
                    this.f930a = true;
                    this.f41890a.e();
                    return;
                }
                return;
            }
            str = "https://resolver.msg.xiaomi.net/psc/?t=a";
            a2 = dt.a.a(Base64.decode(cw.a(com.xiaomi.push.t.m622a(), str, (List<com.xiaomi.push.bf>) null), 10));
            if (a2 == null) {
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m56a("fetch config failure: " + e2.getMessage());
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo228c() {
        List list;
        List list2;
        bi.a[] aVarArr;
        dt.a aVar;
        this.f41890a.f927a = null;
        if (this.f930a) {
            synchronized (this.f41890a) {
                list = this.f41890a.f929a;
                list2 = this.f41890a.f929a;
                aVarArr = (bi.a[]) list.toArray(new bi.a[list2.size()]);
            }
            for (bi.a aVar2 : aVarArr) {
                aVar = this.f41890a.f928a;
                aVar2.a(aVar);
            }
        }
    }
}
