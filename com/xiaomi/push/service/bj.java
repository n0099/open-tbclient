package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.al;
import com.xiaomi.push.cw;
import com.xiaomi.push.dt;
import com.xiaomi.push.service.bi;
import java.util.List;
/* loaded from: classes10.dex */
public class bj extends al.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bi f77996a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f937a;

    public bj(bi biVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {biVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77996a = biVar;
        this.f937a = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d A[Catch: Exception -> 0x004b, TRY_LEAVE, TryCatch #0 {Exception -> 0x004b, blocks: (B:4:0x0004, B:6:0x0016, B:11:0x0028, B:13:0x003d), top: B:21:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.xiaomi.push.al.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        String str;
        dt.a a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        try {
            String a3 = a.a(com.xiaomi.push.t.m639a()).a();
            if (!TextUtils.isEmpty(a3) && !com.xiaomi.push.o.f77880a.name().equals(a3)) {
                str = "https://resolver.msg.global.xiaomi.net/psc/?t=a";
                a2 = dt.a.a(Base64.decode(cw.a(com.xiaomi.push.t.m639a(), str, (List<com.xiaomi.push.bf>) null), 10));
                if (a2 == null) {
                    this.f77996a.f935a = a2;
                    this.f937a = true;
                    this.f77996a.e();
                    return;
                }
                return;
            }
            str = "https://resolver.msg.xiaomi.net/psc/?t=a";
            a2 = dt.a.a(Base64.decode(cw.a(com.xiaomi.push.t.m639a(), str, (List<com.xiaomi.push.bf>) null), 10));
            if (a2 == null) {
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m73a("fetch config failure: " + e2.getMessage());
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo245c() {
        List list;
        List list2;
        bi.a[] aVarArr;
        dt.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f77996a.f934a = null;
            if (this.f937a) {
                synchronized (this.f77996a) {
                    list = this.f77996a.f936a;
                    list2 = this.f77996a.f936a;
                    aVarArr = (bi.a[]) list.toArray(new bi.a[list2.size()]);
                }
                for (bi.a aVar2 : aVarArr) {
                    aVar = this.f77996a.f935a;
                    aVar2.a(aVar);
                }
            }
        }
    }
}
