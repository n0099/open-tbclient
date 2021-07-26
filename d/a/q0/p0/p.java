package d.a.q0.p0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.x.p.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class p extends d.a.p0.x.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static p f61868f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.p0.x.p.c> f61869e;

    public p() {
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
        this.f61869e = new LinkedList<>();
    }

    public static p e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f61868f == null) {
                synchronized (p.class) {
                    if (f61868f == null) {
                        f61868f = new p();
                    }
                }
            }
            return f61868f;
        }
        return (p) invokeV.objValue;
    }

    @Override // d.a.p0.x.p.a
    public void b(a.InterfaceC1248a interfaceC1248a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, interfaceC1248a) == null) && FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f61869e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f61869e.add(cVar);
                        if (interfaceC1248a != null) {
                            interfaceC1248a.a(cVar);
                        }
                    }
                }
            }
        }
    }

    @Override // d.a.p0.x.p.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.x.p.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
