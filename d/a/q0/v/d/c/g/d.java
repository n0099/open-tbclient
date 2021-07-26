package d.a.q0.v.d.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.q0.v.d.c.e.e;
import d.a.q0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65052a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f65053b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f65054c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f65055d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65056e;

    /* renamed from: f  reason: collision with root package name */
    public String f65057f;

    /* renamed from: g  reason: collision with root package name */
    public String f65058g;

    public d(j jVar, String str, String str2) {
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
        this.f65052a = false;
        this.f65056e = false;
        this.f65053b = new ArrayList();
        this.f65054c = new ArrayList();
        this.f65055d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f65056e = true;
        }
        this.f65057f = str;
        this.f65058g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f64962b);
            this.f65052a = jVar.f64961a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f65052a = false;
            List<String> list = this.f65053b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f65054c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f65055d;
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
                d.a.q0.v.d.a.a aVar = new d.a.q0.v.d.a.a();
                aVar.f64855e = list.get(i2);
                aVar.j = true;
                aVar.f64856f = this.f65056e;
                aVar.f64857g = this.f65057f;
                aVar.f64858h = this.f65058g;
                int i3 = i2 + 1;
                aVar.f64859i = i3;
                eVar.f64950e = aVar;
                if (i3 < size) {
                    d.a.q0.v.d.a.a aVar2 = new d.a.q0.v.d.a.a();
                    aVar2.f64855e = list.get(i3);
                    aVar2.f64856f = this.f65056e;
                    aVar2.f64857g = this.f65057f;
                    aVar2.f64858h = this.f65058g;
                    aVar2.f64859i = i2 + 2;
                    eVar.f64951f = aVar2;
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
            if (!ListUtils.isEmpty(this.f65055d)) {
                arrayList.addAll(this.f65055d);
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
                    if (!this.f65053b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f65053b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f65054c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f65054c);
            this.f65055d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f65052a : invokeV.booleanValue;
    }
}
