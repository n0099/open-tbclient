package d.a.s0.w2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class h implements d.a.s0.e.b.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<Object> f69195a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.e.e.c f69196b;

    /* renamed from: c  reason: collision with root package name */
    public t f69197c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.k.e.a f69198d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.k.e.a f69199e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.k.e.a f69200f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.k.e.a f69201g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.k.e.a f69202h;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.s0.e.b.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // d.a.s0.e.e.a
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    @Override // d.a.s0.e.b.d
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.i4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.f4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.j4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.k4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.l4.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.s0.e.b.d
    public void e(List<d.a.s0.e.b.c> list, String str, String str2, String str3, String str4, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || d.a.s0.n1.o.k.a.e(list)) {
            return;
        }
        Set<d.a.c.k.e.n> a2 = d.a.s0.w2.i0.a.a("FRS");
        if (a2 == null) {
            a2 = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (d.a.s0.e.b.c cVar : list) {
            if (cVar != null) {
                Object a3 = cVar.a();
                for (d.a.c.k.e.n nVar : a2) {
                    if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a3.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a3).U3 = ((AdvertAppInfo) nVar).U3;
                    }
                }
                if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a3;
                    if (advertAppInfo.U3 == null) {
                        d.a.r0.r.q.e eVar = new d.a.r0.r.q.e();
                        advertAppInfo.U3 = eVar;
                        eVar.f55917a = "FRS";
                        eVar.f55919c = String.valueOf(z);
                        d.a.r0.r.q.e eVar2 = advertAppInfo.U3;
                        eVar2.f55918b = i2;
                        eVar2.f55920d = str;
                        eVar2.f55921e = str2;
                        eVar2.f55922f = str3;
                        eVar2.f55923g = str4;
                        eVar2.f55924h = advertAppInfo.S3;
                        eVar2.f55925i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a2.addAll(hashSet);
        d.a.s0.w2.i0.a.b("FRS", a2);
    }

    @Override // d.a.s0.e.b.d
    public TypeAdapter.ViewHolder f(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        d.a.c.k.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, viewGroup, obj)) == null) {
            if (obj instanceof AdvertAppInfo) {
                BdUniqueId type = ((AdvertAppInfo) obj).getType();
                if (type == AdvertAppInfo.i4) {
                    aVar = this.f69199e;
                } else if (type == AdvertAppInfo.f4) {
                    aVar = this.f69198d;
                } else if (type == AdvertAppInfo.j4) {
                    aVar = this.f69200f;
                } else if (type == AdvertAppInfo.k4) {
                    aVar = this.f69201g;
                } else {
                    aVar = type == AdvertAppInfo.l4 ? this.f69202h : null;
                }
                if (aVar != null) {
                    return aVar.R(viewGroup, obj);
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // d.a.s0.e.b.d
    public void h(List<d.a.s0.e.b.c> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, list, i2) == null) || d.a.s0.n1.o.k.a.e(this.f69195a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f69195a) {
            if (obj instanceof AdvertAppInfo) {
                d.a.s0.n1.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.a.s0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.a.s0.n1.o.k.a.k(list);
        int i3 = 0;
        int i4 = 0;
        for (d.a.s0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i4++;
            }
        }
        int k2 = d.a.s0.n1.o.k.a.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i5 = k - i4;
        HashSet hashSet = new HashSet();
        int i6 = 0;
        while (i6 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.a.s0.n1.o.k.a.d(arrayList, i6);
            advertAppInfo.V3 = "FRS";
            int w4 = advertAppInfo.w4();
            if (w4 != 0) {
                d.a.s0.w2.i0.d.g(advertAppInfo, i2, w4);
                if (w4 != 28 && w4 != 31) {
                    advertAppInfo.N3 = -1001;
                }
                i6++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.a.s0.w2.i0.d.g(advertAppInfo, i2, 100);
            } else {
                int d2 = (d.a.c.e.m.b.d(advertAppInfo.R3, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(d2))) {
                    d.a.s0.w2.i0.d.g(advertAppInfo, i2, 29);
                } else if (d2 < 0) {
                    d.a.s0.w2.i0.d.g(advertAppInfo, i2, 33);
                } else if (d2 >= k && i5 > 3) {
                    d.a.s0.w2.i0.d.h(advertAppInfo, i2, 2, d2, k);
                } else {
                    d.a.s0.e.b.c cVar2 = new d.a.s0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.t4()) {
                        if (x.q(advertAppInfo.d4) && d.a.s0.a.h().z()) {
                            d.a.s0.w2.i0.d.g(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.d4) && !TextUtils.isEmpty(advertAppInfo.Y3)) {
                            hashSet.add(Integer.valueOf(d2));
                            if (d2 < k) {
                                d.a.s0.n1.o.k.a.b(list, cVar2, d2);
                            } else if (d2 == k) {
                                d.a.s0.n1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.v4()) {
                        hashSet.add(Integer.valueOf(d2));
                        if (d2 < k) {
                            d.a.s0.n1.o.k.a.b(list, cVar2, d2);
                        } else if (d2 == k) {
                            d.a.s0.n1.o.k.a.a(list, cVar2);
                        }
                    } else {
                        d.a.s0.w2.i0.d.g(advertAppInfo, i2, 21);
                    }
                }
            }
            i6++;
            i3 = 0;
        }
    }

    @Override // d.a.s0.e.b.d
    public void j(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f69195a = list;
        }
    }

    @Override // d.a.s0.e.b.d
    public View l(int i2, View view, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        d.a.c.k.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, obj})) == null) {
            if (obj instanceof AdvertAppInfo) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                BdUniqueId type = advertAppInfo.getType();
                if (type == AdvertAppInfo.i4) {
                    aVar = this.f69199e;
                } else if (type == AdvertAppInfo.f4) {
                    aVar = this.f69198d;
                } else if (type == AdvertAppInfo.j4) {
                    aVar = this.f69200f;
                } else if (type == AdvertAppInfo.k4) {
                    aVar = this.f69201g;
                } else {
                    aVar = type == AdvertAppInfo.l4 ? this.f69202h : null;
                }
                if (aVar != null) {
                    return aVar.I(i2, view, viewGroup, advertAppInfo);
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.s0.e.b.d
    public void m(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), viewGroup, viewHolder, obj}) == null) && (obj instanceof AdvertAppInfo)) {
            d.a.c.k.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.i4) {
                aVar = this.f69199e;
            } else if (type == AdvertAppInfo.f4) {
                aVar = this.f69198d;
            } else if (type == AdvertAppInfo.j4) {
                aVar = this.f69200f;
            } else if (type == AdvertAppInfo.k4) {
                aVar = this.f69201g;
            } else if (type == AdvertAppInfo.l4) {
                aVar = this.f69202h;
            }
            if (aVar != null) {
                aVar.Y(i2, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // d.a.s0.e.b.d
    public void n(List<d.a.s0.e.b.c> list, List<d.a.s0.e.b.c> list2, boolean z, int i2) {
        ArrayList arrayList;
        int i3;
        int i4;
        int d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || d.a.s0.n1.o.k.a.e(this.f69195a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.f69195a) {
            if (obj instanceof AdvertAppInfo) {
                d.a.s0.n1.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.a.s0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.a.s0.n1.o.k.a.k(list);
        int i5 = 0;
        int i6 = 0;
        for (d.a.s0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i6++;
            }
        }
        int k2 = d.a.s0.n1.o.k.a.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i7 = 9;
        if (d.a.s0.n1.o.k.a.k(arrayList2) > 1 && (d2 = (d.a.c.e.m.b.d(((AdvertAppInfo) d.a.s0.n1.o.k.a.d(arrayList2, 1)).R3, 0) - d.a.c.e.m.b.d(((AdvertAppInfo) d.a.s0.n1.o.k.a.d(arrayList2, 0)).R3, 0)) - 1) > 0) {
            i7 = d2;
        }
        int d3 = d.a.c.e.m.b.d(((AdvertAppInfo) d.a.s0.n1.o.k.a.d(arrayList2, 0)).R3, 0) - 1;
        int i8 = k - i6;
        HashSet hashSet = new HashSet();
        int i9 = 0;
        while (i9 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.a.s0.n1.o.k.a.d(arrayList2, i9);
            advertAppInfo.V3 = "SMART_FRS";
            int w4 = advertAppInfo.w4();
            if (w4 != 0) {
                d.a.s0.w2.i0.d.g(advertAppInfo, i2, w4);
                if (w4 != 28 && w4 != 31) {
                    advertAppInfo.N3 = -1001;
                }
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.a.s0.w2.i0.d.g(advertAppInfo, i2, 100);
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int d4 = d.a.c.e.m.b.d(advertAppInfo.R3, i5);
                int i10 = (d4 + i6) - 1;
                if (i10 < 0 || hashSet.contains(Integer.valueOf(i10)) || i10 > k) {
                    arrayList = arrayList2;
                    if (i10 > k) {
                        d.a.s0.w2.i0.d.h(advertAppInfo, i2, 2, i10, k);
                        i9++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i3 = i10 < 0 ? 33 : 29;
                    }
                } else {
                    if (d4 <= (i8 - i7) + d3 || !z) {
                        arrayList = arrayList2;
                    } else if (!d.a.s0.n1.o.k.a.e(list2)) {
                        int k3 = d.a.s0.n1.o.k.a.k(list2);
                        int i11 = (i7 - ((i8 - d4) + 1)) - 1;
                        int i12 = 0;
                        while (i12 < k3 && i12 < i11) {
                            arrayList = arrayList2;
                            if (((d.a.s0.e.b.c) d.a.s0.n1.o.k.a.d(list2, i12)).a() instanceof AdvertAppInfo) {
                                i4 = 0;
                                break;
                            } else {
                                i12++;
                                arrayList2 = arrayList;
                            }
                        }
                        arrayList = arrayList2;
                        i4 = 1;
                        i3 = i4 ^ 1;
                    } else {
                        arrayList = arrayList2;
                        if (d.a.s0.a.h().y()) {
                            i3 = 36;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    d.a.s0.w2.i0.d.g(advertAppInfo, i2, i3);
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    d.a.s0.e.b.c cVar2 = new d.a.s0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.t4()) {
                        if (x.q(advertAppInfo.d4) && d.a.s0.a.h().z()) {
                            d.a.s0.w2.i0.d.g(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.d4) && !TextUtils.isEmpty(advertAppInfo.Y3)) {
                            hashSet.add(Integer.valueOf(i10));
                            if (i10 < k) {
                                d.a.s0.n1.o.k.a.b(list, cVar2, i10);
                            } else if (i10 == k) {
                                d.a.s0.n1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.v4()) {
                        hashSet.add(Integer.valueOf(i10));
                        if (i10 < k) {
                            d.a.s0.n1.o.k.a.b(list, cVar2, i10);
                        } else if (i10 == k) {
                            d.a.s0.n1.o.k.a.a(list, cVar2);
                        }
                    }
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.e.e.a
    /* renamed from: p */
    public void o(d.a.s0.e.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f69196b = cVar;
            if (cVar == null || !(cVar.a() instanceof t)) {
                return;
            }
            this.f69197c = (t) this.f69196b.a();
            this.f69198d = new d.a.s0.w2.a0.c(this.f69197c, AdvertAppInfo.f4);
            this.f69199e = new d.a.s0.w2.a0.d(this.f69197c, AdvertAppInfo.i4);
            this.f69200f = new d.a.s0.w2.a0.d(this.f69197c, AdvertAppInfo.j4);
            this.f69201g = new d.a.s0.w2.a0.d(this.f69197c, AdvertAppInfo.k4);
            this.f69202h = new d.a.s0.w2.a0.d(this.f69197c, AdvertAppInfo.l4);
        }
    }
}
