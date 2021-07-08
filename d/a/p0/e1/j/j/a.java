package d.a.p0.e1.j.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.p0.e1.j.h.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<b2> f55733a;

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
                return;
            }
        }
        this.f55733a = new ArrayList();
    }

    public c a(boolean z, d.a.p0.e1.j.h.a aVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, aVar)) == null) {
            c cVar = new c();
            cVar.f55727c = aVar.i();
            cVar.f55729e = aVar.a();
            cVar.f55730f = aVar.c();
            ArrayList<b2> h2 = aVar.h();
            if (z) {
                if (!ListUtils.isEmpty(h2)) {
                    this.f55733a.clear();
                    this.f55733a.addAll(h2);
                }
            } else if (!ListUtils.isEmpty(h2)) {
                this.f55733a.addAll(h2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f55733a);
            d.a.p0.e1.j.a.c(true, arrayList, aVar.e());
            d.a.p0.e1.j.a.c(true, arrayList, aVar.f());
            d.a.p0.e1.j.a.c(true, arrayList, aVar.d());
            d.a.p0.e1.j.a.c(true, arrayList, aVar.g());
            cVar.f55725a = d.a.p0.e1.j.a.a(arrayList);
            return cVar;
        }
        return (c) invokeZL.objValue;
    }

    public List<b2> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55733a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<b2> list = this.f55733a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
