package d.a.s0.h2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class d extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f60440e;

    /* renamed from: f  reason: collision with root package name */
    public final String f60441f;

    /* renamed from: g  reason: collision with root package name */
    public final String f60442g;

    public d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60440e = str;
        this.f60441f = str2;
        this.f60442g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.run();
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/clientcall");
            netWork.addPostData("tid", this.f60440e);
            netWork.addPostData("phonenum", this.f60441f);
            netWork.addPostData("optype", this.f60442g);
            netWork.postNetData();
        }
    }
}
