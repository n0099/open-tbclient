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
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
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
/* loaded from: classes4.dex */
public class ba extends bi.a implements cs.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f927a;

    /* loaded from: classes4.dex */
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
                buildUpon.appendQueryParameter(UrlOcrConfig.IdCardKey.OS, gn.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
                buildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.push.t.a()));
                String builder = buildUpon.toString();
                com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
                URL url = new URL(builder);
                int port = url.getPort() == -1 ? 80 : url.getPort();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String a = com.xiaomi.push.bg.a(com.xiaomi.push.t.m688a(), url);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    gz.a(url.getHost() + ":" + port, (int) currentTimeMillis2, null);
                    return a;
                } catch (IOException e2) {
                    gz.a(url.getHost() + ":" + port, -1, e2);
                    throw e2;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                    if (gx.m415a().m420a()) {
                        str2 = bi.m664a();
                    }
                    return super.a(arrayList, str, str2, z);
                } catch (IOException e2) {
                    gz.a(0, ew.u.a(), 1, null, com.xiaomi.push.bg.c(cs.a) ? 1 : 0);
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
        this.f927a = xMPushService;
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
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) && bVar.b() && bVar.a() && System.currentTimeMillis() - this.a > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.m122a("fetch bucket :" + bVar.a());
            this.a = System.currentTimeMillis();
            cs a2 = cs.a();
            a2.m283a();
            a2.m286b();
            fl m612a = this.f927a.m612a();
            if (m612a == null || (b2 = a2.b(m612a.m372a().c())) == null) {
                return;
            }
            ArrayList<String> m271a = b2.m271a();
            boolean z = true;
            Iterator<String> it = m271a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m612a.m373a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m271a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m122a("bucket changed, force reconnect");
            this.f927a.a(0, (Exception) null);
            this.f927a.a(false);
        }
    }
}
