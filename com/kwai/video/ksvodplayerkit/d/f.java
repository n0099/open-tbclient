package com.kwai.video.ksvodplayerkit.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.MediaPreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        a(arrayList, str2, i2);
    }

    private void a(List<String> list, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, this, list, str, i2) == null) {
            this.f39924a = new com.kwai.video.ksvodplayerkit.HttpDns.d(list);
            this.f39929f = i.a().t();
            String str2 = list.get(0);
            this.f39927d = str2;
            this.f39926c = i2;
            this.f39930g = str;
            String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str2);
            if (this.f39924a.b() != null && !TextUtils.isEmpty(this.f39924a.b().f39826b)) {
                this.f39927d = this.f39924a.b().f39826b;
                b2 = this.f39924a.d();
            }
            this.f39926c = i2;
            String str3 = this.f39927d;
            this.f39928e = MediaPreloadPriorityTask.newTaskWithHttpDns(str3, b2, com.kwai.video.ksvodplayerkit.c.c.c(str3));
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f39924a.a(false);
            if (this.f39924a.f() <= 0 || this.f39924a.e() || this.f39925b.get() >= i.a().e() || !this.f39924a.a()) {
                return null;
            }
            if (this.f39924a.b() != null && !TextUtils.isEmpty(this.f39924a.b().f39826b)) {
                this.f39927d = this.f39924a.b().f39826b;
                String d2 = this.f39924a.d();
                String str = this.f39927d;
                this.f39928e = MediaPreloadPriorityTask.newTaskWithHttpDns(str, d2, com.kwai.video.ksvodplayerkit.c.c.c(str));
            }
            return this.f39928e;
        }
        return (AbstractHodorPreloadTask) invokeV.objValue;
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f39928e == null) {
                String d2 = this.f39924a.d() != null ? this.f39924a.d() : com.kwai.video.ksvodplayerkit.c.a.b(this.f39927d);
                String str = this.f39927d;
                this.f39928e = MediaPreloadPriorityTask.newTaskWithHttpDns(str, d2, com.kwai.video.ksvodplayerkit.c.c.c(str));
            }
            return this.f39928e;
        }
        return (AbstractHodorPreloadTask) invokeV.objValue;
    }
}
