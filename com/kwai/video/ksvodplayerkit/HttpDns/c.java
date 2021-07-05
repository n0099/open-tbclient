package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.aegon.httpdns.HttpDnsResolver;
import com.kuaishou.aegon.httpdns.ResolveFinishedInfo;
import com.kuaishou.aegon.httpdns.ResolvedIP;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HttpDnsResolver.setLogger(new HttpDnsResolver.a(this) { // from class: com.kwai.video.ksvodplayerkit.HttpDns.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f39830a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f39830a = this;
            }

            @Override // com.kuaishou.aegon.httpdns.HttpDnsResolver.a
            public void onResolveFinish(ResolveFinishedInfo resolveFinishedInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, resolveFinishedInfo) == null) {
                }
            }
        });
    }

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        HttpDnsResolver.updateConfig(str);
    }

    @Override // com.kwai.video.ksvodplayerkit.HttpDns.b
    @NonNull
    public List<f> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str) || com.kwai.video.ksvodplayerkit.c.a.a(str)) {
                return new ArrayList();
            }
            List<ResolvedIP> resolve = HttpDnsResolver.resolve(str);
            ArrayList arrayList = new ArrayList();
            if (resolve != null && !resolve.isEmpty()) {
                for (ResolvedIP resolvedIP : resolve) {
                    if (resolvedIP != null) {
                        f fVar = new f(resolvedIP.mHost, resolvedIP.mIP, ResolverType.HTTP, resolvedIP.mTtl);
                        fVar.f39845d = resolvedIP.mResolver;
                        arrayList.add(fVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
