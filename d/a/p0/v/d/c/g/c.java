package d.a.p0.v.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.p0.v.d.c.e.e;
import d.a.p0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64400a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f64401b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f64402c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f64403d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64404e;

    /* renamed from: f  reason: collision with root package name */
    public String f64405f;

    /* renamed from: g  reason: collision with root package name */
    public String f64406g;

    public c(j jVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64400a = false;
        this.f64404e = false;
        this.f64401b = new ArrayList();
        this.f64402c = new ArrayList();
        this.f64403d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f64404e = true;
        }
        this.f64405f = str;
        this.f64406g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f64317b);
            this.f64400a = jVar.f64316a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f64400a = false;
            List<String> list = this.f64401b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f64402c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f64403d;
            if (list3 != null) {
                list3.clear();
            }
        }
    }

    public final ArrayList<n> c(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList<n> arrayList = new ArrayList<>();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                e eVar = new e();
                d.a.p0.v.d.a.a aVar = new d.a.p0.v.d.a.a();
                aVar.f64210e = list.get(i2);
                aVar.j = true;
                aVar.f64211f = this.f64404e;
                aVar.f64212g = this.f64405f;
                aVar.f64213h = this.f64406g;
                int i3 = i2 + 1;
                aVar.f64214i = i3;
                eVar.f64305e = aVar;
                if (i3 < size) {
                    d.a.p0.v.d.a.a aVar2 = new d.a.p0.v.d.a.a();
                    aVar2.f64210e = list.get(i3);
                    aVar2.f64211f = this.f64404e;
                    aVar2.f64212g = this.f64405f;
                    aVar2.f64213h = this.f64406g;
                    aVar2.f64214i = i2 + 2;
                    eVar.f64306f = aVar2;
                    aVar2.k = true;
                } else {
                    aVar.j = false;
                    aVar.l = true;
                }
                arrayList.add(eVar);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public List<n> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.f64403d)) {
                arrayList.addAll(this.f64403d);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean e(List<SdkLiveInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (SdkLiveInfoData sdkLiveInfoData : list) {
                if (sdkLiveInfoData != null) {
                    String str = sdkLiveInfoData.liveId;
                    if (!this.f64401b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f64401b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f64402c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f64402c);
            this.f64403d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64400a : invokeV.booleanValue;
    }
}
