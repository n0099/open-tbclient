package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hf;
import com.xiaomi.push.hs;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class k extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f78568a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f964a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ List f965a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f78569b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, int i2, String str, List list, String str2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, Integer.valueOf(i2), str, list, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f78568a = jVar;
        this.f964a = str;
        this.f965a = list;
        this.f78569b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Send tiny data." : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        String a2;
        XMPushService xMPushService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a2 = this.f78568a.a(this.f964a);
            ArrayList<ie> a3 = bm.a(this.f965a, this.f964a, a2, 32768);
            if (a3 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
                return;
            }
            Iterator<ie> it = a3.iterator();
            while (it.hasNext()) {
                ie next = it.next();
                next.a("uploadWay", "longXMPushService");
                ib a4 = y.a(this.f964a, a2, next, hf.f78124i);
                if (!TextUtils.isEmpty(this.f78569b) && !TextUtils.equals(this.f964a, this.f78569b)) {
                    if (a4.m453a() == null) {
                        hs hsVar = new hs();
                        hsVar.a("-1");
                        a4.a(hsVar);
                    }
                    a4.m453a().b("ext_traffic_source_pkg", this.f78569b);
                }
                byte[] a5 = ip.a(a4);
                xMPushService = this.f78568a.f78567a;
                xMPushService.a(this.f964a, a5, true);
            }
        }
    }
}
