package d.a.s0.v.d.c.g;

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
import d.a.s0.v.d.c.e.e;
import d.a.s0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67618a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f67619b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f67620c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f67621d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67622e;

    /* renamed from: f  reason: collision with root package name */
    public String f67623f;

    /* renamed from: g  reason: collision with root package name */
    public String f67624g;

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
        this.f67618a = false;
        this.f67622e = false;
        this.f67619b = new ArrayList();
        this.f67620c = new ArrayList();
        this.f67621d = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f67622e = true;
        }
        this.f67623f = str;
        this.f67624g = str2;
        a(jVar);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar.f67535b);
            this.f67618a = jVar.f67534a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f67618a = false;
            List<String> list = this.f67619b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f67620c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f67621d;
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
                d.a.s0.v.d.a.a aVar = new d.a.s0.v.d.a.a();
                aVar.f67428e = list.get(i2);
                aVar.j = true;
                aVar.f67429f = this.f67622e;
                aVar.f67430g = this.f67623f;
                aVar.f67431h = this.f67624g;
                int i3 = i2 + 1;
                aVar.f67432i = i3;
                eVar.f67523e = aVar;
                if (i3 < size) {
                    d.a.s0.v.d.a.a aVar2 = new d.a.s0.v.d.a.a();
                    aVar2.f67428e = list.get(i3);
                    aVar2.f67429f = this.f67622e;
                    aVar2.f67430g = this.f67623f;
                    aVar2.f67431h = this.f67624g;
                    aVar2.f67432i = i2 + 2;
                    eVar.f67524f = aVar2;
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
            if (!ListUtils.isEmpty(this.f67621d)) {
                arrayList.addAll(this.f67621d);
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
                    if (!this.f67619b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.f67619b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.f67620c.addAll(arrayList);
            ArrayList<n> c2 = c(this.f67620c);
            this.f67621d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67618a : invokeV.booleanValue;
    }
}
