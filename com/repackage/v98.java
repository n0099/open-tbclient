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
/* loaded from: classes7.dex */
public class v98 implements ch5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public hh5 b;
    public ia8 c;
    public ho d;
    public ho e;
    public ho f;
    public ho g;
    public ho h;

    public v98() {
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

    @Override // com.repackage.ch5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.repackage.ch5
    public List<Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.z.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.w.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.A.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.B.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.C.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.ch5
    public void d(List<bh5> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || jd7.e(list)) {
            return;
        }
        Set<uo> a = xc8.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (bh5 bh5Var : list) {
            if (bh5Var != null) {
                Object a2 = bh5Var.a();
                for (uo uoVar : a) {
                    if (a2 != null && bh5Var.c() == 3 && (a2 instanceof AdvertAppInfo) && uoVar != null && (uoVar instanceof AdvertAppInfo) && a2.hashCode() == uoVar.hashCode()) {
                        ((AdvertAppInfo) a2).j = ((AdvertAppInfo) uoVar).j;
                    }
                }
                if (a2 != null && bh5Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.j == null) {
                        un4 un4Var = new un4();
                        advertAppInfo.j = un4Var;
                        un4Var.a = "FRS";
                        un4Var.c = String.valueOf(z);
                        un4 un4Var2 = advertAppInfo.j;
                        un4Var2.b = i;
                        un4Var2.d = str;
                        un4Var2.e = str2;
                        un4Var2.f = str3;
                        un4Var2.g = str4;
                        un4Var2.h = advertAppInfo.h;
                        un4Var2.i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        xc8.b("FRS", a);
    }

    @Override // com.repackage.ch5
    public TypeAdapter.ViewHolder e(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        ho hoVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, obj)) == null) {
            if (obj instanceof AdvertAppInfo) {
                BdUniqueId type = ((AdvertAppInfo) obj).getType();
                if (type == AdvertAppInfo.z) {
                    hoVar = this.e;
                } else if (type == AdvertAppInfo.w) {
                    hoVar = this.d;
                } else if (type == AdvertAppInfo.A) {
                    hoVar = this.f;
                } else if (type == AdvertAppInfo.B) {
                    hoVar = this.g;
                } else {
                    hoVar = type == AdvertAppInfo.C ? this.h : null;
                }
                if (hoVar != null) {
                    return hoVar.N(viewGroup, obj);
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.ch5
    public void g(List<bh5> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, list, i) == null) || jd7.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                jd7.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<bh5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = jd7.k(list);
        int i2 = 0;
        int i3 = 0;
        for (bh5 bh5Var : list) {
            if (bh5Var.c() == 1) {
                i3++;
            }
        }
        int k2 = jd7.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i4 = k - i3;
        HashSet hashSet = new HashSet();
        int i5 = 0;
        while (i5 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) jd7.d(arrayList, i5);
            advertAppInfo.k = "FRS";
            int q = advertAppInfo.q();
            if (q != 0) {
                ad8.i(advertAppInfo, i, q);
                if (q != 28 && q != 31) {
                    advertAppInfo.c = -1001;
                }
                i5++;
                i2 = 0;
            }
            if (advertAppInfo.getType() == null) {
                ad8.i(advertAppInfo, i, 100);
            } else {
                int e = (mg.e(advertAppInfo.g, i2) + i3) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    ad8.i(advertAppInfo, i, 29);
                } else if (e < 0) {
                    ad8.i(advertAppInfo, i, 33);
                } else if (e >= k && i4 > 3) {
                    ad8.j(advertAppInfo, i, 2, e, k);
                } else {
                    bh5 bh5Var2 = new bh5();
                    bh5Var2.d(advertAppInfo);
                    bh5Var2.e(advertAppInfo.getType().getId());
                    bh5Var2.f(3);
                    if (advertAppInfo.i()) {
                        if (na8.r(advertAppInfo.s) && rg5.h().F()) {
                            ad8.i(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.s) && !TextUtils.isEmpty(advertAppInfo.n)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < k) {
                                jd7.b(list, bh5Var2, e);
                            } else if (e == k) {
                                jd7.a(list, bh5Var2);
                            }
                        }
                    } else if (advertAppInfo.m()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < k) {
                            jd7.b(list, bh5Var2, e);
                        } else if (e == k) {
                            jd7.a(list, bh5Var2);
                        }
                    } else {
                        ad8.i(advertAppInfo, i, 21);
                    }
                }
            }
            i5++;
            i2 = 0;
        }
    }

    @Override // com.repackage.ch5
    public void i(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.repackage.ch5
    public View k(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        ho hoVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (obj instanceof AdvertAppInfo) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                BdUniqueId type = advertAppInfo.getType();
                if (type == AdvertAppInfo.z) {
                    hoVar = this.e;
                } else if (type == AdvertAppInfo.w) {
                    hoVar = this.d;
                } else if (type == AdvertAppInfo.A) {
                    hoVar = this.f;
                } else if (type == AdvertAppInfo.B) {
                    hoVar = this.g;
                } else {
                    hoVar = type == AdvertAppInfo.C ? this.h : null;
                }
                if (hoVar != null) {
                    return hoVar.E(i, view2, viewGroup, advertAppInfo);
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.ch5
    public void l(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) == null) && (obj instanceof AdvertAppInfo)) {
            ho hoVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.z) {
                hoVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                hoVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                hoVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                hoVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                hoVar = this.h;
            }
            if (hoVar != null) {
                hoVar.T(i, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // com.repackage.ch5
    public void m(List<bh5> list, List<bh5> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || jd7.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                jd7.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<bh5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = jd7.k(list);
        int i4 = 0;
        int i5 = 0;
        for (bh5 bh5Var : list) {
            if (bh5Var.c() == 1) {
                i5++;
            }
        }
        int k2 = jd7.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i6 = 9;
        if (jd7.k(arrayList2) > 1 && (e = (mg.e(((AdvertAppInfo) jd7.d(arrayList2, 1)).g, 0) - mg.e(((AdvertAppInfo) jd7.d(arrayList2, 0)).g, 0)) - 1) > 0) {
            i6 = e;
        }
        int e2 = mg.e(((AdvertAppInfo) jd7.d(arrayList2, 0)).g, 0) - 1;
        int i7 = k - i5;
        HashSet hashSet = new HashSet();
        int i8 = 0;
        while (i8 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) jd7.d(arrayList2, i8);
            advertAppInfo.k = "SMART_FRS";
            int q = advertAppInfo.q();
            if (q != 0) {
                ad8.i(advertAppInfo, i, q);
                if (q != 28 && q != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i8++;
                arrayList2 = arrayList;
                i4 = 0;
            }
            if (advertAppInfo.getType() == null) {
                ad8.i(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i8++;
                arrayList2 = arrayList;
                i4 = 0;
            } else {
                int e3 = mg.e(advertAppInfo.g, i4);
                int i9 = (e3 + i5) - 1;
                if (i9 < 0 || hashSet.contains(Integer.valueOf(i9)) || i9 > k) {
                    arrayList = arrayList2;
                    if (i9 > k) {
                        ad8.j(advertAppInfo, i, 2, i9, k);
                        i8++;
                        arrayList2 = arrayList;
                        i4 = 0;
                    } else {
                        i2 = i9 < 0 ? 33 : 29;
                    }
                } else {
                    if (e3 <= (i7 - i6) + e2 || !z) {
                        arrayList = arrayList2;
                    } else if (!jd7.e(list2)) {
                        int k3 = jd7.k(list2);
                        int i10 = (i6 - ((i7 - e3) + 1)) - 1;
                        int i11 = 0;
                        while (i11 < k3 && i11 < i10) {
                            arrayList = arrayList2;
                            if (((bh5) jd7.d(list2, i11)).a() instanceof AdvertAppInfo) {
                                i3 = 0;
                                break;
                            } else {
                                i11++;
                                arrayList2 = arrayList;
                            }
                        }
                        arrayList = arrayList2;
                        i3 = 1;
                        i2 = i3 ^ 1;
                    } else {
                        arrayList = arrayList2;
                        if (rg5.h().E()) {
                            i2 = 36;
                        }
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    ad8.i(advertAppInfo, i, i2);
                    i8++;
                    arrayList2 = arrayList;
                    i4 = 0;
                } else {
                    bh5 bh5Var2 = new bh5();
                    bh5Var2.d(advertAppInfo);
                    bh5Var2.e(advertAppInfo.getType().getId());
                    bh5Var2.f(3);
                    if (advertAppInfo.i()) {
                        if (na8.r(advertAppInfo.s) && rg5.h().F()) {
                            ad8.i(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.s) && !TextUtils.isEmpty(advertAppInfo.n)) {
                            hashSet.add(Integer.valueOf(i9));
                            if (i9 < k) {
                                jd7.b(list, bh5Var2, i9);
                            } else if (i9 == k) {
                                jd7.a(list, bh5Var2);
                            }
                        }
                    } else if (advertAppInfo.m()) {
                        hashSet.add(Integer.valueOf(i9));
                        if (i9 < k) {
                            jd7.b(list, bh5Var2, i9);
                        } else if (i9 == k) {
                            jd7.a(list, bh5Var2);
                        }
                    }
                    i8++;
                    arrayList2 = arrayList;
                    i4 = 0;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fh5
    /* renamed from: o */
    public void n(hh5 hh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hh5Var) == null) {
            this.b = hh5Var;
            if (hh5Var == null || !(hh5Var.a() instanceof ia8)) {
                return;
            }
            this.c = (ia8) this.b.a();
            this.d = new ta8(this.c, AdvertAppInfo.w);
            this.e = new ua8(this.c, AdvertAppInfo.z);
            this.f = new ua8(this.c, AdvertAppInfo.A);
            this.g = new ua8(this.c, AdvertAppInfo.B);
            this.h = new ua8(this.c, AdvertAppInfo.C);
        }
    }

    @Override // com.repackage.fh5
    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, map) == null) {
        }
    }
}
