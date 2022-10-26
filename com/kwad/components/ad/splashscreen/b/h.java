package com.kwad.components.ad.splashscreen.b;

import android.content.Context;
import android.os.Vibrator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
/* loaded from: classes7.dex */
public abstract class h extends e {
    public static /* synthetic */ Interceptable $ic = null;
    public static long gO = 400;
    public transient /* synthetic */ FieldHolder $fh;
    public Vibrator eO;
    public com.kwad.components.ad.splashscreen.d.a yM;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-78998621, "Lcom/kwad/components/ad/splashscreen/b/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-78998621, "Lcom/kwad/components/ad/splashscreen/b/h;");
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void km() {
        com.kwad.components.ad.splashscreen.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (hVar = this.yF) == null) {
            return;
        }
        com.kwad.components.ad.splashscreen.d.a aVar = this.yM;
        if (aVar == null) {
            this.yM = new com.kwad.components.ad.splashscreen.d.a(this, getContext(), this.yF.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ h yN;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (AdTemplate) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.yN = this;
                }

                @Override // com.kwad.components.ad.splashscreen.d.a
                public final void Z(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        this.yN.Y(str);
                    }
                }
            };
        } else {
            aVar.setAdTemplate(hVar.mAdTemplate);
        }
        com.kwad.components.core.c.a.c cVar = this.yF.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.yM);
        }
    }

    public abstract void Y(String str);

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            if (this.yF == null) {
                return;
            }
            kl();
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
            ki();
            kf();
            if (com.kwad.sdk.core.response.a.a.am(bQ)) {
                km();
            }
            kg();
            kj();
            kk();
            kh();
        }
    }

    public abstract void initView();

    public abstract void kf();

    public abstract void kg();

    public abstract void kh();

    public abstract void ki();

    public abstract void kj();

    public abstract void kk();

    public abstract void kl();

    public final void kn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Context context = getContext();
            if (context != null) {
                this.eO = (Vibrator) context.getSystemService("vibrator");
            }
            bd.a(getContext(), this.eO);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onCreate();
            initView();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onUnbind();
            bd.b(getContext(), this.eO);
        }
    }
}
