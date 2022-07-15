package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class s extends XMPushService.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ r a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f1722a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ List f1723a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i, String str, List list, String str2) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVar, Integer.valueOf(i), str, list, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rVar;
        this.f1722a = str;
        this.f1723a = list;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Send tiny data." : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        String a;
        XMPushService xMPushService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a = this.a.a(this.f1722a);
            ArrayList<ii> a2 = bz.a(this.f1723a, this.f1722a, a, 32768);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
                return;
            }
            Iterator<ii> it = a2.iterator();
            while (it.hasNext()) {
                ii next = it.next();
                next.a("uploadWay", "longXMPushService");
                Cif a3 = ah.a(this.f1722a, a, next, hj.i);
                if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f1722a, this.b)) {
                    if (a3.m1403a() == null) {
                        hw hwVar = new hw();
                        hwVar.a("-1");
                        a3.a(hwVar);
                    }
                    a3.m1403a().b("ext_traffic_source_pkg", this.b);
                }
                byte[] a4 = it.a(a3);
                xMPushService = this.a.a;
                xMPushService.a(this.f1722a, a4, true);
            }
        }
    }
}
