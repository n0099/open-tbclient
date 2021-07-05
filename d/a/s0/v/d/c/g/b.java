package d.a.s0.v.d.c.g;

import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.s0.v.d.c.e.e;
import d.a.s0.v.d.c.e.f;
import d.a.s0.v.d.c.e.g;
import d.a.s0.v.d.c.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67609a;

    /* renamed from: b  reason: collision with root package name */
    public g f67610b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.v.d.c.e.a f67611c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.v.d.c.e.d f67612d;

    /* renamed from: e  reason: collision with root package name */
    public j f67613e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f67614f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f67615g;

    /* renamed from: h  reason: collision with root package name */
    public List<SdkLiveInfoData> f67616h;

    /* renamed from: i  reason: collision with root package name */
    public List<n> f67617i;

    public b(AlaTabLiveResponsedMessage alaTabLiveResponsedMessage) {
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
        this.f67609a = false;
        this.f67610b = alaTabLiveResponsedMessage.stageLiveInfo;
        this.f67611c = alaTabLiveResponsedMessage.hotLiveInfo;
        this.f67612d = alaTabLiveResponsedMessage.officialRecommendLiveInfo;
        this.f67613e = alaTabLiveResponsedMessage.tabAllLiveInfo;
        this.f67616h = new ArrayList();
        this.f67617i = new ArrayList();
        e();
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            if (jVar == null) {
                return false;
            }
            boolean g2 = g(jVar);
            this.f67609a = jVar.f67534a;
            return g2;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f67610b = null;
            this.f67611c = null;
            this.f67612d = null;
            this.f67609a = false;
            List<n> list = this.f67614f;
            if (list != null) {
                list.clear();
            }
            List<n> list2 = this.f67615g;
            if (list2 != null) {
                list2.clear();
            }
            List<SdkLiveInfoData> list3 = this.f67616h;
            if (list3 != null) {
                list3.clear();
            }
            List<n> list4 = this.f67617i;
            if (list4 != null) {
                list4.clear();
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
            if (!ListUtils.isEmpty(this.f67615g)) {
                arrayList.addAll(this.f67615g);
            }
            if (!ListUtils.isEmpty(this.f67617i)) {
                arrayList.addAll(this.f67617i);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f67614f = new ArrayList();
            g gVar = this.f67610b;
            if (gVar != null && gVar.a()) {
                f fVar = new f();
                fVar.f67526e = this.f67610b;
                this.f67614f.add(fVar);
            }
            if (this.f67611c != null) {
                ArrayList<n> f2 = f();
                if (!ListUtils.isEmpty(f2)) {
                    this.f67614f.addAll(f2);
                }
            }
            d.a.s0.v.d.c.e.d dVar = this.f67612d;
            if (dVar != null && !ListUtils.isEmpty(dVar.f67520a)) {
                d.a.s0.v.d.c.e.c cVar = new d.a.s0.v.d.c.e.c();
                cVar.f67519e = this.f67612d;
                this.f67614f.add(cVar);
            }
            this.f67615g = new ArrayList(this.f67614f);
            a(this.f67613e);
        }
    }

    public final ArrayList<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<SdkLiveInfoData> arrayList = this.f67611c.f67514a;
            if (arrayList == null || arrayList.size() < 2) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (SdkLiveInfoData sdkLiveInfoData : arrayList) {
                if (sdkLiveInfoData != null) {
                    arrayList2.add(sdkLiveInfoData);
                }
            }
            if (arrayList2.size() < 2) {
                return null;
            }
            return c(arrayList2);
        }
        return (ArrayList) invokeV.objValue;
    }

    public final boolean g(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jVar)) == null) {
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
                if (next != null && (!StringHelper.equals(next.source, "jiaoyoufang") || d.a.s0.v.d.c.c.c(next))) {
                    arrayList2.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList2)) {
                return false;
            }
            this.f67616h.addAll(arrayList2);
            ArrayList<n> c2 = c(this.f67616h);
            this.f67617i = c2;
            return !ListUtils.isEmpty(c2);
        }
        return invokeL.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f67609a : invokeV.booleanValue;
    }
}
