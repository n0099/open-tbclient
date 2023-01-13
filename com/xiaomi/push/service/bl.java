package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.cv;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.ez;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fw;
import com.xiaomi.push.gy;
import com.xiaomi.push.service.bv;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class bl extends bv.a implements cv.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f966a;

    /* loaded from: classes8.dex */
    public static class a implements cv.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.xiaomi.push.cv.b
        public String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(BaseStatisContent.SDKVER, String.valueOf(48));
                buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
                buildUpon.appendQueryParameter("os", gy.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
                buildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.push.v.a()));
                String builder = buildUpon.toString();
                com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
                URL url = new URL(builder);
                int port = url.getPort() == -1 ? 80 : url.getPort();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String a = com.xiaomi.push.bj.a(com.xiaomi.push.v.m761a(), url);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    fj.a(url.getHost() + ":" + port, (int) currentTimeMillis2, null);
                    return a;
                } catch (IOException e) {
                    fj.a(url.getHost() + ":" + port, -1, e);
                    throw e;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends cv {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, com.xiaomi.push.cu cuVar, cv.b bVar, String str) {
            super(context, cuVar, bVar, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, cuVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (com.xiaomi.push.cu) objArr2[1], (cv.b) objArr2[2], (String) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.xiaomi.push.cv
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{arrayList, str, str2, Boolean.valueOf(z)})) == null) {
                try {
                    if (fh.m397a().m402a()) {
                        str2 = bv.m722a();
                    }
                    return super.a(arrayList, str, str2, z);
                } catch (IOException e) {
                    fj.a(0, ez.u.a(), 1, null, com.xiaomi.push.bj.c(cv.a) ? 1 : 0);
                    throw e;
                }
            }
            return (String) invokeCommon.objValue;
        }
    }

    public bl(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f966a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, xMPushService) == null) {
            bl blVar = new bl(xMPushService);
            bv.a().a(blVar);
            synchronized (cv.class) {
                cv.a(blVar);
                cv.a(xMPushService, null, new a(), "0", "push", "2.2");
            }
        }
    }

    @Override // com.xiaomi.push.cv.a
    public cv a(Context context, com.xiaomi.push.cu cuVar, cv.b bVar, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, cuVar, bVar, str)) == null) ? new b(context, cuVar, bVar, str) : (cv) invokeLLLL.objValue;
    }

    @Override // com.xiaomi.push.service.bv.a
    public void a(dw.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
        }
    }

    @Override // com.xiaomi.push.service.bv.a
    public void a(dx.b bVar) {
        com.xiaomi.push.cr b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) && bVar.m312b() && bVar.m311a() && System.currentTimeMillis() - this.a > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.m103a("fetch bucket :" + bVar.m311a());
            this.a = System.currentTimeMillis();
            cv a2 = cv.a();
            a2.m269a();
            a2.m272b();
            fw m663a = this.f966a.m663a();
            if (m663a == null || (b2 = a2.b(m663a.m425a().c())) == null) {
                return;
            }
            ArrayList<String> m257a = b2.m257a();
            boolean z = true;
            Iterator<String> it = m257a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m663a.mo426a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m257a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m103a("bucket changed, force reconnect");
            this.f966a.a(0, (Exception) null);
            this.f966a.a(false);
        }
    }
}
