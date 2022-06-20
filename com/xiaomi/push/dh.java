package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ao;
import com.xiaomi.push.df;
/* loaded from: classes8.dex */
public class dh extends ao.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ao.b a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ df f212a;

    public dh(df dfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dfVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f212a = dfVar;
    }

    @Override // com.xiaomi.push.ao.b
    public void b() {
        df.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = (df.b) this.f212a.f200a.peek()) != null && bVar.a()) {
            if (this.f212a.f200a.remove(bVar)) {
                this.a = bVar;
            }
            ao.b bVar2 = this.a;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    @Override // com.xiaomi.push.ao.b
    /* renamed from: c */
    public void mo260c() {
        ao.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.mo260c();
    }
}
