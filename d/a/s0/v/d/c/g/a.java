package d.a.s0.v.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.s0.v.d.c.e.e;
import d.a.s0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67605a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f67606b;

    /* renamed from: c  reason: collision with root package name */
    public List<SdkLiveInfoData> f67607c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f67608d;

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
        this.f67605a = false;
        this.f67606b = new ArrayList();
        this.f67607c = new ArrayList();
        this.f67608d = new ArrayList();
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
            this.f67605a = jVar.f67534a;
            return e2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f67605a = false;
            List<String> list = this.f67606b;
            if (list != null) {
                list.clear();
            }
            List<SdkLiveInfoData> list2 = this.f67607c;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f67608d;
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
                eVar.f67523e = aVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    d.a.s0.v.d.a.a aVar2 = new d.a.s0.v.d.a.a();
                    aVar2.f67428e = list.get(i3);
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
            if (!ListUtils.isEmpty(this.f67608d)) {
                arrayList.addAll(this.f67608d);
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
            ArrayList<SdkLiveInfoData> arrayList = jVar.f67535b;
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<SdkLiveInfoData> it = arrayList.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData next = it.next();
                if (next != null && d.a.s0.v.d.c.c.c(next)) {
                    String str = next.liveId;
                    if (!this.f67606b.contains(str)) {
                        arrayList2.add(next);
                        this.f67606b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.f67607c.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f67607c);
            this.f67608d = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67605a : invokeV.booleanValue;
    }
}
