package com.repackage;

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
/* loaded from: classes6.dex */
public class i88 implements mh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public rh5 b;
    public u88 c;
    public an d;
    public an e;
    public an f;
    public an g;
    public an h;

    public i88() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.mh5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.repackage.mh5
    public List<Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.w.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.t.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.x.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.y.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.z.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.mh5
    public void d(List<lh5> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || oc7.e(list)) {
            return;
        }
        Set<nn> a = ha8.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (lh5 lh5Var : list) {
            if (lh5Var != null) {
                Object a2 = lh5Var.a();
                for (nn nnVar : a) {
                    if (a2 != null && lh5Var.c() == 3 && (a2 instanceof AdvertAppInfo) && nnVar != null && (nnVar instanceof AdvertAppInfo) && a2.hashCode() == nnVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) nnVar).i;
                    }
                }
                if (a2 != null && lh5Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        dn4 dn4Var = new dn4();
                        advertAppInfo.i = dn4Var;
                        dn4Var.a = "FRS";
                        String.valueOf(z);
                        dn4 dn4Var2 = advertAppInfo.i;
                        dn4Var2.b = i;
                        dn4Var2.c = str;
                        dn4Var2.d = str2;
                        dn4Var2.e = str3;
                        dn4Var2.f = str4;
                        dn4Var2.g = advertAppInfo.g;
                        dn4Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        ha8.b("FRS", a);
    }

    @Override // com.repackage.mh5
    public TypeAdapter.ViewHolder e(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        an anVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, obj)) == null) {
            if (obj instanceof AdvertAppInfo) {
                BdUniqueId type = ((AdvertAppInfo) obj).getType();
                if (type == AdvertAppInfo.w) {
                    anVar = this.e;
                } else if (type == AdvertAppInfo.t) {
                    anVar = this.d;
                } else if (type == AdvertAppInfo.x) {
                    anVar = this.f;
                } else if (type == AdvertAppInfo.y) {
                    anVar = this.g;
                } else {
                    anVar = type == AdvertAppInfo.z ? this.h : null;
                }
                if (anVar != null) {
                    return anVar.N(viewGroup, obj);
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.mh5
    public void g(List<lh5> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, list, i) == null) || oc7.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                oc7.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<lh5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = oc7.i(list);
        int i3 = 0;
        int i4 = 0;
        for (lh5 lh5Var : list) {
            if (lh5Var.c() == 1) {
                i4++;
            }
        }
        int i5 = oc7.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) oc7.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int n = advertAppInfo.n();
            if (n != 0) {
                ja8.h(advertAppInfo, i, n);
                if (n != 28 && n != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                ja8.h(advertAppInfo, i, 100);
            } else {
                int e = (ng.e(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    ja8.h(advertAppInfo, i, 29);
                } else if (e < 0) {
                    ja8.h(advertAppInfo, i, 33);
                } else if (e >= i2 && i6 > 3) {
                    ja8.i(advertAppInfo, i, 2, e, i2);
                } else {
                    lh5 lh5Var2 = new lh5();
                    lh5Var2.d(advertAppInfo);
                    lh5Var2.e(advertAppInfo.getType().getId());
                    lh5Var2.f(3);
                    if (advertAppInfo.h()) {
                        if (y88.i(advertAppInfo.p) && ah5.a().p()) {
                            ja8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < i2) {
                                oc7.b(list, lh5Var2, e);
                            } else if (e == i2) {
                                oc7.a(list, lh5Var2);
                            }
                        }
                    } else if (advertAppInfo.l()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < i2) {
                            oc7.b(list, lh5Var2, e);
                        } else if (e == i2) {
                            oc7.a(list, lh5Var2);
                        }
                    } else {
                        ja8.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.repackage.mh5
    public void i(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.repackage.mh5
    public View k(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        an anVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (obj instanceof AdvertAppInfo) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                BdUniqueId type = advertAppInfo.getType();
                if (type == AdvertAppInfo.w) {
                    anVar = this.e;
                } else if (type == AdvertAppInfo.t) {
                    anVar = this.d;
                } else if (type == AdvertAppInfo.x) {
                    anVar = this.f;
                } else if (type == AdvertAppInfo.y) {
                    anVar = this.g;
                } else {
                    anVar = type == AdvertAppInfo.z ? this.h : null;
                }
                if (anVar != null) {
                    return anVar.D(i, view2, viewGroup, advertAppInfo);
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.mh5
    public void l(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) == null) && (obj instanceof AdvertAppInfo)) {
            an anVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.w) {
                anVar = this.e;
            } else if (type == AdvertAppInfo.t) {
                anVar = this.d;
            } else if (type == AdvertAppInfo.x) {
                anVar = this.f;
            } else if (type == AdvertAppInfo.y) {
                anVar = this.g;
            } else if (type == AdvertAppInfo.z) {
                anVar = this.h;
            }
            if (anVar != null) {
                anVar.T(i, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // com.repackage.mh5
    public void m(List<lh5> list, List<lh5> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || oc7.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                oc7.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<lh5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i4 = oc7.i(list);
        int i5 = 0;
        int i6 = 0;
        for (lh5 lh5Var : list) {
            if (lh5Var.c() == 1) {
                i6++;
            }
        }
        int i7 = oc7.i(arrayList2);
        if (i7 < 1) {
            return;
        }
        int i8 = 9;
        if (oc7.i(arrayList2) > 1 && (e = (ng.e(((AdvertAppInfo) oc7.d(arrayList2, 1)).f, 0) - ng.e(((AdvertAppInfo) oc7.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i8 = e;
        }
        int e2 = ng.e(((AdvertAppInfo) oc7.d(arrayList2, 0)).f, 0) - 1;
        int i9 = i4 - i6;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < i7) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) oc7.d(arrayList2, i10);
            advertAppInfo.j = "SMART_FRS";
            int n = advertAppInfo.n();
            if (n != 0) {
                ja8.h(advertAppInfo, i, n);
                if (n != 28 && n != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                ja8.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e3 = ng.e(advertAppInfo.f, i5);
                int i11 = (e3 + i6) - 1;
                if (i11 < 0 || hashSet.contains(Integer.valueOf(i11)) || i11 > i4) {
                    arrayList = arrayList2;
                    if (i11 > i4) {
                        ja8.i(advertAppInfo, i, 2, i11, i4);
                        i10++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i2 = i11 < 0 ? 33 : 29;
                    }
                } else {
                    if (e3 <= (i9 - i8) + e2 || !z) {
                        arrayList = arrayList2;
                    } else if (!oc7.e(list2)) {
                        int i12 = oc7.i(list2);
                        int i13 = (i8 - ((i9 - e3) + 1)) - 1;
                        int i14 = 0;
                        while (i14 < i12 && i14 < i13) {
                            arrayList = arrayList2;
                            if (((lh5) oc7.d(list2, i14)).a() instanceof AdvertAppInfo) {
                                i3 = 0;
                                break;
                            } else {
                                i14++;
                                arrayList2 = arrayList;
                            }
                        }
                        arrayList = arrayList2;
                        i3 = 1;
                        i2 = i3 ^ 1;
                    } else {
                        arrayList = arrayList2;
                        if (ah5.a().o()) {
                            i2 = 36;
                        }
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    ja8.h(advertAppInfo, i, i2);
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    lh5 lh5Var2 = new lh5();
                    lh5Var2.d(advertAppInfo);
                    lh5Var2.e(advertAppInfo.getType().getId());
                    lh5Var2.f(3);
                    if (advertAppInfo.h()) {
                        if (y88.i(advertAppInfo.p) && ah5.a().p()) {
                            ja8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(i11));
                            if (i11 < i4) {
                                oc7.b(list, lh5Var2, i11);
                            } else if (i11 == i4) {
                                oc7.a(list, lh5Var2);
                            }
                        }
                    } else if (advertAppInfo.l()) {
                        hashSet.add(Integer.valueOf(i11));
                        if (i11 < i4) {
                            oc7.b(list, lh5Var2, i11);
                        } else if (i11 == i4) {
                            oc7.a(list, lh5Var2);
                        }
                    }
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ph5
    /* renamed from: o */
    public void n(rh5 rh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rh5Var) == null) {
            this.b = rh5Var;
            if (rh5Var == null || !(rh5Var.a() instanceof u88)) {
                return;
            }
            this.c = (u88) this.b.a();
            this.d = new c98(this.c, AdvertAppInfo.t);
            this.e = new d98(this.c, AdvertAppInfo.w);
            this.f = new d98(this.c, AdvertAppInfo.x);
            this.g = new d98(this.c, AdvertAppInfo.y);
            this.h = new d98(this.c, AdvertAppInfo.z);
        }
    }

    @Override // com.repackage.ph5
    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, map) == null) {
        }
    }
}
