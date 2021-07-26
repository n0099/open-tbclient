package d.a.q0.v.d.c.f.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.q0.v.d.a.c;
import d.a.q0.v.d.c.e.k;
import d.a.q0.v.d.f.c.e;
import d.a.q0.v.d.f.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static long f64988f = 604800000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64989a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f64990b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f64991c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f64992d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f64993e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(324029641, "Ld/a/q0/v/d/c/f/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(324029641, "Ld/a/q0/v/d/c/f/c/b;");
        }
    }

    public b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64989a = tbPageContext;
        this.f64990b = new ArrayList();
        this.f64991c = new ArrayList();
        this.f64992d = new ArrayList();
        this.f64993e = new ArrayList();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<n> list = this.f64991c;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f64992d;
            if (list2 != null) {
                list2.clear();
            }
            List<n> list3 = this.f64993e;
            if (list3 != null) {
                list3.clear();
            }
            List<n> list4 = this.f64990b;
            if (list4 != null) {
                list4.clear();
            }
        }
    }

    public final List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaLiveTabMyConcernResponse)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse != null && alaLiveTabMyConcernResponse.followStatus != 1) {
                if (!ListUtils.isEmpty(this.f64992d) && k(alaLiveTabMyConcernResponse)) {
                    arrayList.add(new d.a.q0.v.d.c.f.b.a());
                }
                if (!ListUtils.isEmpty(this.f64992d)) {
                    g gVar = new g();
                    gVar.f65175f = this.f64989a.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                    arrayList.add(gVar);
                }
                if (!ListUtils.isEmpty(this.f64992d)) {
                    for (n nVar : this.f64992d) {
                        arrayList.add(nVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<n> c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse == null) {
                return arrayList;
            }
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.f65175f = this.f64989a.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!ListUtils.isEmpty(this.f64991c)) {
                arrayList.addAll(f());
            } else if (z) {
                e eVar = new e();
                eVar.f65168e = alaLiveTabMyConcernResponse.followStatus;
                arrayList.add(eVar);
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public final List<n> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.f64993e)) {
                g gVar = new g();
                gVar.f65175f = this.f64989a.getResources().getString(R.string.live_tab_recommend_title_txt);
                arrayList.add(gVar);
                arrayList.addAll(g(this.f64993e));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void e(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, alaLiveTabMyConcernResponse, z) == null) || alaLiveTabMyConcernResponse == null) {
            return;
        }
        if (z) {
            this.f64990b.clear();
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.followList)) {
            this.f64991c.addAll(alaLiveTabMyConcernResponse.followList);
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
            this.f64992d.addAll(alaLiveTabMyConcernResponse.followCloseList);
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
            this.f64993e.addAll(alaLiveTabMyConcernResponse.recommendList);
        }
        this.f64990b = i(alaLiveTabMyConcernResponse, z);
    }

    public final List<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.f64991c)) {
                int size = this.f64991c.size();
                for (int i2 = 0; i2 < size; i2 += 2) {
                    k kVar = new k();
                    c cVar = new c();
                    cVar.f64863h = (b2) this.f64991c.get(i2);
                    cVar.j = true;
                    kVar.f64964e = cVar;
                    int i3 = i2 + 1;
                    if (i3 < size) {
                        c cVar2 = new c();
                        cVar2.f64863h = (b2) this.f64991c.get(i3);
                        kVar.f64965f = cVar2;
                        cVar2.k = true;
                    } else {
                        cVar.j = false;
                        cVar.l = true;
                    }
                    int i4 = size % 2;
                    if ((i4 == 0 && i2 == size - 2) || (i4 != 0 && i2 == size - 1)) {
                        kVar.f64966g = true;
                    }
                    arrayList.add(kVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<n> g(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2 += 3) {
                    d.a.q0.v.d.c.f.b.c cVar = new d.a.q0.v.d.c.f.b.c();
                    c cVar2 = new c();
                    cVar2.f64863h = (b2) list.get(i2);
                    cVar.f64985e = cVar2;
                    int i3 = i2 + 1;
                    if (i3 < size) {
                        c cVar3 = new c();
                        cVar3.f64863h = (b2) list.get(i3);
                        cVar.f64986f = cVar3;
                    }
                    int i4 = i2 + 2;
                    if (i4 < size) {
                        c cVar4 = new c();
                        cVar4.f64863h = (b2) list.get(i4);
                        cVar.f64987g = cVar4;
                    }
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<n> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64990b : (List) invokeV.objValue;
    }

    public final List<n> i(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            List<n> c2 = c(alaLiveTabMyConcernResponse, z);
            if (!ListUtils.isEmpty(c2)) {
                arrayList.addAll(c2);
            }
            List<n> b2 = b(alaLiveTabMyConcernResponse);
            if (!ListUtils.isEmpty(b2)) {
                arrayList.addAll(b2);
            }
            List<n> d2 = d();
            if (!ListUtils.isEmpty(d2)) {
                arrayList.addAll(d2);
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public void j(Class<? extends BaseCardInfo> cls) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cls) == null) || ListUtils.isEmpty(this.f64990b)) {
            return;
        }
        for (int size = this.f64990b.size() - 1; size >= 0; size--) {
            n nVar = (n) ListUtils.getItem(this.f64990b, size);
            if (nVar != null && nVar.getClass().equals(cls)) {
                this.f64990b.remove(size);
            }
        }
    }

    public final boolean k(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, alaLiveTabMyConcernResponse)) == null) {
            if (alaLiveTabMyConcernResponse == null) {
                return false;
            }
            return (alaLiveTabMyConcernResponse.followStatus == 1 || a.a(this.f64989a) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > f64988f ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == f64988f ? 0 : -1)) > 0)) ? false : true;
        }
        return invokeL.booleanValue;
    }
}
