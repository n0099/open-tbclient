package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.du;
import com.xiaomi.push.fm;
import com.xiaomi.push.fp;
import java.util.Map;
/* loaded from: classes7.dex */
public class bw extends fm {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ XMPushService a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(XMPushService xMPushService, Map map, int i, String str, fp fpVar) {
        super(map, i, str, fpVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, map, Integer.valueOf(i), str, fpVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Map) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (fp) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.fm
    /* renamed from: a */
    public byte[] mo370a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                du.b bVar = new du.b();
                bVar.a(bi.a().m657a());
                return bVar.m323a();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m112a("getOBBString err: " + e2.toString());
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }
}
