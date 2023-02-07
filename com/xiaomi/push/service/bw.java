package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ao;
import com.xiaomi.push.cz;
import com.xiaomi.push.dw;
import com.xiaomi.push.service.bv;
import java.util.List;
/* loaded from: classes8.dex */
public class bw extends ao.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bv a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f978a;

    public bw(bv bvVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bvVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bvVar;
        this.f978a = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d A[Catch: Exception -> 0x004b, TRY_LEAVE, TryCatch #0 {Exception -> 0x004b, blocks: (B:4:0x0004, B:6:0x0016, B:11:0x0028, B:13:0x003d), top: B:21:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.xiaomi.push.ao.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        String str;
        dw.a a;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        try {
            String a2 = a.a(com.xiaomi.push.v.m763a()).a();
            if (!TextUtils.isEmpty(a2) && !com.xiaomi.push.q.a.name().equals(a2)) {
                str = "https://resolver.msg.global.xiaomi.net/psc/?t=a";
                a = dw.a.a(Base64.decode(cz.a(com.xiaomi.push.v.m763a(), str, (List<com.xiaomi.push.bi>) null), 10));
                if (a == null) {
                    this.a.f976a = a;
                    this.f978a = true;
                    this.a.e();
                    return;
                }
                return;
            }
            str = "https://resolver.msg.xiaomi.net/psc/?t=a";
            a = dw.a.a(Base64.decode(cz.a(com.xiaomi.push.v.m763a(), str, (List<com.xiaomi.push.bi>) null), 10));
            if (a == null) {
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m105a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.push.ao.b
    /* renamed from: c */
    public void mo283c() {
        List list;
        List list2;
        bv.a[] aVarArr;
        dw.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.f975a = null;
            if (this.f978a) {
                synchronized (this.a) {
                    list = this.a.f977a;
                    list2 = this.a.f977a;
                    aVarArr = (bv.a[]) list.toArray(new bv.a[list2.size()]);
                }
                for (bv.a aVar2 : aVarArr) {
                    aVar = this.a.f976a;
                    aVar2.a(aVar);
                }
            }
        }
    }
}
