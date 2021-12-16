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
/* loaded from: classes4.dex */
public class k extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ j a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f965a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ List f966a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f63859b;

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
        this.a = jVar;
        this.f965a = str;
        this.f966a = list;
        this.f63859b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Send tiny data." : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        String a;
        XMPushService xMPushService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a = this.a.a(this.f965a);
            ArrayList<ie> a2 = bm.a(this.f966a, this.f965a, a, 32768);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
                return;
            }
            Iterator<ie> it = a2.iterator();
            while (it.hasNext()) {
                ie next = it.next();
                next.a("uploadWay", "longXMPushService");
                ib a3 = y.a(this.f965a, a, next, hf.f63556i);
                if (!TextUtils.isEmpty(this.f63859b) && !TextUtils.equals(this.f965a, this.f63859b)) {
                    if (a3.m502a() == null) {
                        hs hsVar = new hs();
                        hsVar.a("-1");
                        a3.a(hsVar);
                    }
                    a3.m502a().b("ext_traffic_source_pkg", this.f63859b);
                }
                byte[] a4 = ip.a(a3);
                xMPushService = this.a.a;
                xMPushService.a(this.f965a, a4, true);
            }
        }
    }
}
