package com.qq.e.ads.hybrid;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public HybridADListener f59015f;

    /* renamed from: g  reason: collision with root package name */
    public CountDownLatch f59016g;

    /* renamed from: h  reason: collision with root package name */
    public HybridADSetting f59017h;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hybridADSetting, hybridADListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59016g = new CountDownLatch(1);
        this.f59017h = hybridADSetting;
        this.f59015f = hybridADListener;
        a(context, "NO_POS_ID");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public HybridAD(Context context, String str, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this(context, hybridADSetting, hybridADListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, hybridADSetting, hybridADListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (HybridADSetting) objArr2[1], (HybridADListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }

    public HADI a(POFactory pOFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pOFactory)) == null) ? pOFactory.getHybridAD(this.f59017h, this.f59015f) : (HADI) invokeL.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(pOFactory);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(HADI hadi) {
        d();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            HybridADListener hybridADListener = this.f59015f;
            if (hybridADListener != null) {
                hybridADListener.onError(AdErrorConvertor.formatErrorCode(i2));
            }
            this.f59016g.countDown();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f59016g.countDown();
        }
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && a()) {
            if (!b()) {
                new Thread(new Runnable(this, str) { // from class: com.qq.e.ads.hybrid.HybridAD.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ HybridAD f59018b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59018b = this;
                        this.a = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f59018b.f59016g.await(30L, TimeUnit.SECONDS);
                                if (!this.f59018b.b() || this.f59018b.a == null) {
                                    GDTLogger.e("初始化错误：广告实例未被初始化");
                                    this.f59018b.a(2001);
                                } else {
                                    ((HADI) this.f59018b.a).loadUrl(this.a);
                                }
                            } catch (InterruptedException unused) {
                                GDTLogger.e("初始化错误：广告实例未被初始化");
                                this.f59018b.a(2001);
                            }
                        }
                    }
                }).start();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((HADI) t).loadUrl(str);
            } else {
                a("loadUrl");
            }
        }
    }
}
