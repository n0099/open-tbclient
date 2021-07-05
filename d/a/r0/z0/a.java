package d.a.r0.z0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f56901c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.r0.s.c.a f56902a;

    /* renamed from: b  reason: collision with root package name */
    public ABTestExtraData f56903b;

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

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f56901c == null) {
                synchronized (a.class) {
                    if (f56901c == null) {
                        f56901c = new a();
                    }
                }
            }
            return f56901c;
        }
        return (a) invokeV.objValue;
    }

    public final void a(d.a.r0.s.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            boolean z = aVar == null || this.f56902a == null || aVar.a() != this.f56902a.a();
            this.f56902a = aVar;
            if (z) {
                b("zan_or_cai_smallflow");
            }
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f56903b == null) {
                ABTestExtraData aBTestExtraData = new ABTestExtraData();
                this.f56903b = aBTestExtraData;
                aBTestExtraData.parserABTestExtraFormSharedPref();
            }
            return this.f56903b.getABTestResult();
        }
        return (String) invokeV.objValue;
    }

    public void e(d.a.r0.s.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            a(aVar);
        }
    }

    public void f(ABTestExtraData aBTestExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aBTestExtraData) == null) {
            this.f56903b = aBTestExtraData;
        }
    }
}
