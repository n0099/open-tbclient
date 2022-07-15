package com.kuaishou.weapon.p0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼⁱ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class RunnableC0343<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public String f137;

    /* renamed from: ʼ  reason: contains not printable characters */
    public JSONObject f138;

    /* renamed from: ʽ  reason: contains not printable characters */
    public InterfaceC0353 f139;

    /* renamed from: com.kuaishou.weapon.p0.ʼⁱ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class C0344 implements InterfaceC0353 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ RunnableC0343 f140;

        public C0344(RunnableC0343 runnableC0343) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnableC0343};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f140 = runnableC0343;
        }

        @Override // com.kuaishou.weapon.p0.InterfaceC0353
        /* renamed from: ʻ */
        public void mo239(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f140.f139 == null) {
                return;
            }
            this.f140.f139.mo239(str);
        }

        @Override // com.kuaishou.weapon.p0.InterfaceC0353
        /* renamed from: ʼ */
        public void mo240(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f140.f139 == null) {
                return;
            }
            this.f140.f139.mo240(str);
        }
    }

    public RunnableC0343(String str, JSONObject jSONObject, InterfaceC0353 interfaceC0353) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject, interfaceC0353};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f137 = str;
        this.f138 = jSONObject;
        this.f139 = interfaceC0353;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                C0346.m302().mo312(new C0348(this.f137, this.f138), new C0344(this));
            } catch (Throwable unused) {
            }
        }
    }
}
