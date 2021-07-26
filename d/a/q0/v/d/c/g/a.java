package d.a.q0.v.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.q0.v.d.c.e.e;
import d.a.q0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65032a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f65033b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f65034c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f65035d;

    public a(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alaTabLiveResponsedMessage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65032a = false;
        this.f65033b = new ArrayList();
        this.f65034c = new ArrayList();
        this.f65035d = new ArrayList();
        a(alaTabLiveResponsedMessage.tabAllLiveInfo);
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean e2 = e(jVar);
            this.f65032a = jVar.f64961a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f65032a = false;
            List<String> list = this.f65033b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f65034c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f65035d;
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
                eVar.f64950e = aVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    d.a.q0.v.d.a.a aVar2 = new d.a.q0.v.d.a.a();
                    aVar2.f64855e = list.get(i3);
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
            if (!ListUtils.isEmpty(this.f65035d)) {
                arrayList.addAll(this.f65035d);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean e(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            ArrayList<SdkLiveInfoData> arrayList = jVar.f64962b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && d.a.q0.v.d.c.c.c(next)) {
                    String str = next.liveId;
                    if (!this.f65033b.contains(str)) {
                        arrayList2.add(next);
                        this.f65033b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.f65034c.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f65034c);
            this.f65035d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f65032a : invokeV.booleanValue;
    }
}
