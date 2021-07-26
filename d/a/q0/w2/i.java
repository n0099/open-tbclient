package d.a.q0.w2;

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
/* loaded from: classes8.dex */
public class i implements d.a.q0.e.b.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<Object> f66669a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.e.e.c f66670b;

    /* renamed from: c  reason: collision with root package name */
    public t f66671c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.d.k.e.a f66672d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.d.k.e.a f66673e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.k.e.a f66674f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.d.k.e.a f66675g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.d.k.e.a f66676h;

    public i() {
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

    @Override // d.a.q0.e.b.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // d.a.q0.e.e.a
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    @Override // d.a.q0.e.b.d
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.o4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.l4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.p4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.q4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.r4.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.q0.e.b.d
    public void e(List<d.a.q0.e.b.c> list, String str, String str2, String str3, String str4, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || d.a.q0.n1.o.k.a.e(list)) {
            return;
        }
        Set<d.a.d.k.e.n> a2 = d.a.q0.w2.i0.a.a("FRS");
        if (a2 == null) {
            a2 = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (d.a.q0.e.b.c cVar : list) {
            if (cVar != null) {
                Object a3 = cVar.a();
                for (d.a.d.k.e.n nVar : a2) {
                    if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a3.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a3).a4 = ((AdvertAppInfo) nVar).a4;
                    }
                }
                if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a3;
                    if (advertAppInfo.a4 == null) {
                        d.a.p0.s.q.e eVar = new d.a.p0.s.q.e();
                        advertAppInfo.a4 = eVar;
                        eVar.f53296a = "FRS";
                        eVar.f53298c = String.valueOf(z);
                        d.a.p0.s.q.e eVar2 = advertAppInfo.a4;
                        eVar2.f53297b = i2;
                        eVar2.f53299d = str;
                        eVar2.f53300e = str2;
                        eVar2.f53301f = str3;
                        eVar2.f53302g = str4;
                        eVar2.f53303h = advertAppInfo.Y3;
                        eVar2.f53304i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a2.addAll(hashSet);
        d.a.q0.w2.i0.a.b("FRS", a2);
    }

    @Override // d.a.q0.e.b.d
    public TypeAdapter.ViewHolder f(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        d.a.d.k.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, viewGroup, obj)) == null) {
            if (obj instanceof AdvertAppInfo) {
                BdUniqueId type = ((AdvertAppInfo) obj).getType();
                if (type == AdvertAppInfo.o4) {
                    aVar = this.f66673e;
                } else if (type == AdvertAppInfo.l4) {
                    aVar = this.f66672d;
                } else if (type == AdvertAppInfo.p4) {
                    aVar = this.f66674f;
                } else if (type == AdvertAppInfo.q4) {
                    aVar = this.f66675g;
                } else {
                    aVar = type == AdvertAppInfo.r4 ? this.f66676h : null;
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

    @Override // d.a.q0.e.b.d
    public void h(List<d.a.q0.e.b.c> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, list, i2) == null) || d.a.q0.n1.o.k.a.e(this.f66669a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f66669a) {
            if (obj instanceof AdvertAppInfo) {
                d.a.q0.n1.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.a.q0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.a.q0.n1.o.k.a.k(list);
        int i3 = 0;
        int i4 = 0;
        for (d.a.q0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i4++;
            }
        }
        int k2 = d.a.q0.n1.o.k.a.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i5 = k - i4;
        HashSet hashSet = new HashSet();
        int i6 = 0;
        while (i6 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.a.q0.n1.o.k.a.d(arrayList, i6);
            advertAppInfo.b4 = "FRS";
            int z4 = advertAppInfo.z4();
            if (z4 != 0) {
                d.a.q0.w2.i0.d.h(advertAppInfo, i2, z4);
                if (z4 != 28 && z4 != 31) {
                    advertAppInfo.T3 = -1001;
                }
                i6++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.a.q0.w2.i0.d.h(advertAppInfo, i2, 100);
            } else {
                int d2 = (d.a.d.e.m.b.d(advertAppInfo.X3, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(d2))) {
                    d.a.q0.w2.i0.d.h(advertAppInfo, i2, 29);
                } else if (d2 < 0) {
                    d.a.q0.w2.i0.d.h(advertAppInfo, i2, 33);
                } else if (d2 >= k && i5 > 3) {
                    d.a.q0.w2.i0.d.i(advertAppInfo, i2, 2, d2, k);
                } else {
                    d.a.q0.e.b.c cVar2 = new d.a.q0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.w4()) {
                        if (x.q(advertAppInfo.j4) && d.a.q0.a.h().A()) {
                            d.a.q0.w2.i0.d.h(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.j4) && !TextUtils.isEmpty(advertAppInfo.e4)) {
                            hashSet.add(Integer.valueOf(d2));
                            if (d2 < k) {
                                d.a.q0.n1.o.k.a.b(list, cVar2, d2);
                            } else if (d2 == k) {
                                d.a.q0.n1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.y4()) {
                        hashSet.add(Integer.valueOf(d2));
                        if (d2 < k) {
                            d.a.q0.n1.o.k.a.b(list, cVar2, d2);
                        } else if (d2 == k) {
                            d.a.q0.n1.o.k.a.a(list, cVar2);
                        }
                    } else {
                        d.a.q0.w2.i0.d.h(advertAppInfo, i2, 21);
                    }
                }
            }
            i6++;
            i3 = 0;
        }
    }

    @Override // d.a.q0.e.b.d
    public void j(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f66669a = list;
        }
    }

    @Override // d.a.q0.e.b.d
    public View l(int i2, View view, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        d.a.d.k.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, obj})) == null) {
            if (obj instanceof AdvertAppInfo) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                BdUniqueId type = advertAppInfo.getType();
                if (type == AdvertAppInfo.o4) {
                    aVar = this.f66673e;
                } else if (type == AdvertAppInfo.l4) {
                    aVar = this.f66672d;
                } else if (type == AdvertAppInfo.p4) {
                    aVar = this.f66674f;
                } else if (type == AdvertAppInfo.q4) {
                    aVar = this.f66675g;
                } else {
                    aVar = type == AdvertAppInfo.r4 ? this.f66676h : null;
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

    @Override // d.a.q0.e.b.d
    public void m(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), viewGroup, viewHolder, obj}) == null) && (obj instanceof AdvertAppInfo)) {
            d.a.d.k.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.o4) {
                aVar = this.f66673e;
            } else if (type == AdvertAppInfo.l4) {
                aVar = this.f66672d;
            } else if (type == AdvertAppInfo.p4) {
                aVar = this.f66674f;
            } else if (type == AdvertAppInfo.q4) {
                aVar = this.f66675g;
            } else if (type == AdvertAppInfo.r4) {
                aVar = this.f66676h;
            }
            if (aVar != null) {
                aVar.Y(i2, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // d.a.q0.e.b.d
    public void n(List<d.a.q0.e.b.c> list, List<d.a.q0.e.b.c> list2, boolean z, int i2) {
        ArrayList arrayList;
        int i3;
        int i4;
        int d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || d.a.q0.n1.o.k.a.e(this.f66669a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.f66669a) {
            if (obj instanceof AdvertAppInfo) {
                d.a.q0.n1.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<d.a.q0.e.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = d.a.q0.n1.o.k.a.k(list);
        int i5 = 0;
        int i6 = 0;
        for (d.a.q0.e.b.c cVar : list) {
            if (cVar.c() == 1) {
                i6++;
            }
        }
        int k2 = d.a.q0.n1.o.k.a.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i7 = 9;
        if (d.a.q0.n1.o.k.a.k(arrayList2) > 1 && (d2 = (d.a.d.e.m.b.d(((AdvertAppInfo) d.a.q0.n1.o.k.a.d(arrayList2, 1)).X3, 0) - d.a.d.e.m.b.d(((AdvertAppInfo) d.a.q0.n1.o.k.a.d(arrayList2, 0)).X3, 0)) - 1) > 0) {
            i7 = d2;
        }
        int d3 = d.a.d.e.m.b.d(((AdvertAppInfo) d.a.q0.n1.o.k.a.d(arrayList2, 0)).X3, 0) - 1;
        int i8 = k - i6;
        HashSet hashSet = new HashSet();
        int i9 = 0;
        while (i9 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) d.a.q0.n1.o.k.a.d(arrayList2, i9);
            advertAppInfo.b4 = "SMART_FRS";
            int z4 = advertAppInfo.z4();
            if (z4 != 0) {
                d.a.q0.w2.i0.d.h(advertAppInfo, i2, z4);
                if (z4 != 28 && z4 != 31) {
                    advertAppInfo.T3 = -1001;
                }
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                d.a.q0.w2.i0.d.h(advertAppInfo, i2, 100);
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int d4 = d.a.d.e.m.b.d(advertAppInfo.X3, i5);
                int i10 = (d4 + i6) - 1;
                if (i10 < 0 || hashSet.contains(Integer.valueOf(i10)) || i10 > k) {
                    arrayList = arrayList2;
                    if (i10 > k) {
                        d.a.q0.w2.i0.d.i(advertAppInfo, i2, 2, i10, k);
                        i9++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i3 = i10 < 0 ? 33 : 29;
                    }
                } else {
                    if (d4 <= (i8 - i7) + d3 || !z) {
                        arrayList = arrayList2;
                    } else if (!d.a.q0.n1.o.k.a.e(list2)) {
                        int k3 = d.a.q0.n1.o.k.a.k(list2);
                        int i11 = (i7 - ((i8 - d4) + 1)) - 1;
                        int i12 = 0;
                        while (i12 < k3 && i12 < i11) {
                            arrayList = arrayList2;
                            if (((d.a.q0.e.b.c) d.a.q0.n1.o.k.a.d(list2, i12)).a() instanceof AdvertAppInfo) {
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
                        if (d.a.q0.a.h().z()) {
                            i3 = 36;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    d.a.q0.w2.i0.d.h(advertAppInfo, i2, i3);
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    d.a.q0.e.b.c cVar2 = new d.a.q0.e.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.w4()) {
                        if (x.q(advertAppInfo.j4) && d.a.q0.a.h().A()) {
                            d.a.q0.w2.i0.d.h(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.j4) && !TextUtils.isEmpty(advertAppInfo.e4)) {
                            hashSet.add(Integer.valueOf(i10));
                            if (i10 < k) {
                                d.a.q0.n1.o.k.a.b(list, cVar2, i10);
                            } else if (i10 == k) {
                                d.a.q0.n1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.y4()) {
                        hashSet.add(Integer.valueOf(i10));
                        if (i10 < k) {
                            d.a.q0.n1.o.k.a.b(list, cVar2, i10);
                        } else if (i10 == k) {
                            d.a.q0.n1.o.k.a.a(list, cVar2);
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
    @Override // d.a.q0.e.e.a
    /* renamed from: p */
    public void o(d.a.q0.e.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f66670b = cVar;
            if (cVar == null || !(cVar.a() instanceof t)) {
                return;
            }
            this.f66671c = (t) this.f66670b.a();
            this.f66672d = new d.a.q0.w2.a0.c(this.f66671c, AdvertAppInfo.l4);
            this.f66673e = new d.a.q0.w2.a0.d(this.f66671c, AdvertAppInfo.o4);
            this.f66674f = new d.a.q0.w2.a0.d(this.f66671c, AdvertAppInfo.p4);
            this.f66675g = new d.a.q0.w2.a0.d(this.f66671c, AdvertAppInfo.q4);
            this.f66676h = new d.a.q0.w2.a0.d(this.f66671c, AdvertAppInfo.r4);
        }
    }
}
