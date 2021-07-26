package d.a.q0.i1.w;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f59314e;

    /* renamed from: f  reason: collision with root package name */
    public String f59315f;

    /* renamed from: g  reason: collision with root package name */
    public String f59316g;

    public a(String str, String str2, String str3) {
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
        this.f59314e = null;
        this.f59315f = null;
        this.f59316g = null;
        this.f59314e = str;
        this.f59315f = str2;
        this.f59316g = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.run();
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                return;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            netWork.addPostData("obj", this.f59314e);
            netWork.addPostData("obj_tp", this.f59315f);
            netWork.addPostData("group_id", this.f59316g);
            netWork.postNetData();
        }
    }
}
