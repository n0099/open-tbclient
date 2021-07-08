package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.co;
import com.xiaomi.push.cr;
import com.xiaomi.push.cs;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.ew;
import com.xiaomi.push.fl;
import com.xiaomi.push.gn;
import com.xiaomi.push.gx;
import com.xiaomi.push.gz;
import com.xiaomi.push.service.bi;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ba extends bi.a implements cs.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f40632a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f922a;

    /* loaded from: classes6.dex */
    public static class a implements cs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.xiaomi.push.cs.b
        public String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(BaseStatisContent.SDKVER, String.valueOf(43));
                buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
                buildUpon.appendQueryParameter(IAdRequestParam.OS, gn.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
                buildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.push.t.a()));
                String builder = buildUpon.toString();
                com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
                URL url = new URL(builder);
                int port = url.getPort() == -1 ? 80 : url.getPort();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = com.xiaomi.push.bg.a(com.xiaomi.push.t.m636a(), url);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    gz.a(url.getHost() + ":" + port, (int) currentTimeMillis2, null);
                    return a2;
                } catch (IOException e2) {
                    gz.a(url.getHost() + ":" + port, -1, e2);
                    throw e2;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends cs {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, cr crVar, cs.b bVar, String str) {
            super(context, crVar, bVar, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, crVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (cr) objArr2[1], (cs.b) objArr2[2], (String) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.xiaomi.push.cs
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{arrayList, str, str2, Boolean.valueOf(z)})) == null) {
                try {
                    if (gx.m363a().m368a()) {
                        str2 = bi.m612a();
                    }
                    return super.a(arrayList, str, str2, z);
                } catch (IOException e2) {
                    gz.a(0, ew.u.a(), 1, null, com.xiaomi.push.bg.c(cs.f39949a) ? 1 : 0);
                    throw e2;
                }
            }
            return (String) invokeCommon.objValue;
        }
    }

    public ba(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f922a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, xMPushService) == null) {
            ba baVar = new ba(xMPushService);
            bi.a().a(baVar);
            synchronized (cs.class) {
                cs.a(baVar);
                cs.a(xMPushService, null, new a(), "0", "push", "2.2");
            }
        }
    }

    @Override // com.xiaomi.push.cs.a
    public cs a(Context context, cr crVar, cs.b bVar, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, crVar, bVar, str)) == null) ? new b(context, crVar, bVar, str) : (cs) invokeLLLL.objValue;
    }

    @Override // com.xiaomi.push.service.bi.a
    public void a(dt.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
        }
    }

    @Override // com.xiaomi.push.service.bi.a
    public void a(du.b bVar) {
        co b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) && bVar.b() && bVar.a() && System.currentTimeMillis() - this.f40632a > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.m70a("fetch bucket :" + bVar.a());
            this.f40632a = System.currentTimeMillis();
            cs a2 = cs.a();
            a2.m231a();
            a2.m234b();
            fl m560a = this.f922a.m560a();
            if (m560a == null || (b2 = a2.b(m560a.m320a().c())) == null) {
                return;
            }
            ArrayList<String> m219a = b2.m219a();
            boolean z = true;
            Iterator<String> it = m219a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m560a.m321a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m219a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m70a("bucket changed, force reconnect");
            this.f922a.a(0, (Exception) null);
            this.f922a.a(false);
        }
    }
}
