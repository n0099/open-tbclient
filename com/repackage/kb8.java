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
public class kb8 implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public hk5 b;
    public wb8 c;
    public bn d;
    public bn e;
    public bn f;
    public bn g;
    public bn h;

    public kb8() {
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

    @Override // com.repackage.ck5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.repackage.fk5
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    @Override // com.repackage.ck5
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    @Override // com.repackage.ck5
    public void e(List<bk5> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || bf7.e(list)) {
            return;
        }
        Set<on> a = kd8.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (bk5 bk5Var : list) {
            if (bk5Var != null) {
                Object a2 = bk5Var.a();
                for (on onVar : a) {
                    if (a2 != null && bk5Var.c() == 3 && (a2 instanceof AdvertAppInfo) && onVar != null && (onVar instanceof AdvertAppInfo) && a2.hashCode() == onVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) onVar).i;
                    }
                }
                if (a2 != null && bk5Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        ko4 ko4Var = new ko4();
                        advertAppInfo.i = ko4Var;
                        ko4Var.a = "FRS";
                        String.valueOf(z);
                        ko4 ko4Var2 = advertAppInfo.i;
                        ko4Var2.b = i;
                        ko4Var2.c = str;
                        ko4Var2.d = str2;
                        ko4Var2.e = str3;
                        ko4Var2.f = str4;
                        ko4Var2.g = advertAppInfo.g;
                        ko4Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        kd8.b("FRS", a);
    }

    @Override // com.repackage.ck5
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        bn bnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (obj instanceof AdvertAppInfo) {
                BdUniqueId type = ((AdvertAppInfo) obj).getType();
                if (type == AdvertAppInfo.z) {
                    bnVar = this.e;
                } else if (type == AdvertAppInfo.w) {
                    bnVar = this.d;
                } else if (type == AdvertAppInfo.A) {
                    bnVar = this.f;
                } else if (type == AdvertAppInfo.B) {
                    bnVar = this.g;
                } else {
                    bnVar = type == AdvertAppInfo.C ? this.h : null;
                }
                if (bnVar != null) {
                    return bnVar.onCreateViewHolder(viewGroup, obj);
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.ck5
    public void i(List<bk5> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, list, i) == null) || bf7.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                bf7.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<bk5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = bf7.i(list);
        int i3 = 0;
        int i4 = 0;
        for (bk5 bk5Var : list) {
            if (bk5Var.c() == 1) {
                i4++;
            }
        }
        int i5 = bf7.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) bf7.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int n = advertAppInfo.n();
            if (n != 0) {
                md8.h(advertAppInfo, i, n);
                if (n != 28 && n != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                md8.h(advertAppInfo, i, 100);
            } else {
                int e = (og.e(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    md8.h(advertAppInfo, i, 29);
                } else if (e < 0) {
                    md8.h(advertAppInfo, i, 33);
                } else if (e >= i2 && i6 > 3) {
                    md8.i(advertAppInfo, i, 2, e, i2);
                } else {
                    bk5 bk5Var2 = new bk5();
                    bk5Var2.d(advertAppInfo);
                    bk5Var2.e(advertAppInfo.getType().getId());
                    bk5Var2.f(3);
                    if (advertAppInfo.h()) {
                        if (ac8.i(advertAppInfo.p) && rj5.a().p()) {
                            md8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < i2) {
                                bf7.b(list, bk5Var2, e);
                            } else if (e == i2) {
                                bf7.a(list, bk5Var2);
                            }
                        }
                    } else if (advertAppInfo.l()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < i2) {
                            bf7.b(list, bk5Var2, e);
                        } else if (e == i2) {
                            bf7.a(list, bk5Var2);
                        }
                    } else {
                        md8.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.repackage.ck5
    public void k(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.repackage.ck5
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        bn bnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (obj instanceof AdvertAppInfo) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                BdUniqueId type = advertAppInfo.getType();
                if (type == AdvertAppInfo.z) {
                    bnVar = this.e;
                } else if (type == AdvertAppInfo.w) {
                    bnVar = this.d;
                } else if (type == AdvertAppInfo.A) {
                    bnVar = this.f;
                } else if (type == AdvertAppInfo.B) {
                    bnVar = this.g;
                } else {
                    bnVar = type == AdvertAppInfo.C ? this.h : null;
                }
                if (bnVar != null) {
                    return bnVar.getView(i, view2, viewGroup, advertAppInfo);
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.ck5
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) == null) && (obj instanceof AdvertAppInfo)) {
            bn bnVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.z) {
                bnVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                bnVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                bnVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                bnVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                bnVar = this.h;
            }
            if (bnVar != null) {
                bnVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // com.repackage.ck5
    public void o(List<bk5> list, List<bk5> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || bf7.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                bf7.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<bk5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i4 = bf7.i(list);
        int i5 = 0;
        int i6 = 0;
        for (bk5 bk5Var : list) {
            if (bk5Var.c() == 1) {
                i6++;
            }
        }
        int i7 = bf7.i(arrayList2);
        if (i7 < 1) {
            return;
        }
        int i8 = 9;
        if (bf7.i(arrayList2) > 1 && (e = (og.e(((AdvertAppInfo) bf7.d(arrayList2, 1)).f, 0) - og.e(((AdvertAppInfo) bf7.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i8 = e;
        }
        int e2 = og.e(((AdvertAppInfo) bf7.d(arrayList2, 0)).f, 0) - 1;
        int i9 = i4 - i6;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < i7) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) bf7.d(arrayList2, i10);
            advertAppInfo.j = "SMART_FRS";
            int n = advertAppInfo.n();
            if (n != 0) {
                md8.h(advertAppInfo, i, n);
                if (n != 28 && n != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                md8.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e3 = og.e(advertAppInfo.f, i5);
                int i11 = (e3 + i6) - 1;
                if (i11 < 0 || hashSet.contains(Integer.valueOf(i11)) || i11 > i4) {
                    arrayList = arrayList2;
                    if (i11 > i4) {
                        md8.i(advertAppInfo, i, 2, i11, i4);
                        i10++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i2 = i11 < 0 ? 33 : 29;
                    }
                } else {
                    if (e3 <= (i9 - i8) + e2 || !z) {
                        arrayList = arrayList2;
                    } else if (!bf7.e(list2)) {
                        int i12 = bf7.i(list2);
                        int i13 = (i8 - ((i9 - e3) + 1)) - 1;
                        int i14 = 0;
                        while (i14 < i12 && i14 < i13) {
                            arrayList = arrayList2;
                            if (((bk5) bf7.d(list2, i14)).a() instanceof AdvertAppInfo) {
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
                        if (rj5.a().o()) {
                            i2 = 36;
                        }
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    md8.h(advertAppInfo, i, i2);
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    bk5 bk5Var2 = new bk5();
                    bk5Var2.d(advertAppInfo);
                    bk5Var2.e(advertAppInfo.getType().getId());
                    bk5Var2.f(3);
                    if (advertAppInfo.h()) {
                        if (ac8.i(advertAppInfo.p) && rj5.a().p()) {
                            md8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(i11));
                            if (i11 < i4) {
                                bf7.b(list, bk5Var2, i11);
                            } else if (i11 == i4) {
                                bf7.a(list, bk5Var2);
                            }
                        }
                    } else if (advertAppInfo.l()) {
                        hashSet.add(Integer.valueOf(i11));
                        if (i11 < i4) {
                            bf7.b(list, bk5Var2, i11);
                        } else if (i11 == i4) {
                            bf7.a(list, bk5Var2);
                        }
                    }
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    @Override // com.repackage.ck5
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            bn bnVar = this.e;
            if (bnVar instanceof fc8) {
                ((fc8) bnVar).K(str);
            }
            bn bnVar2 = this.f;
            if (bnVar2 instanceof fc8) {
                ((fc8) bnVar2).K(str);
            }
            bn bnVar3 = this.g;
            if (bnVar3 instanceof fc8) {
                ((fc8) bnVar3).K(str);
            }
            bn bnVar4 = this.h;
            if (bnVar4 instanceof fc8) {
                ((fc8) bnVar4).K(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fk5
    /* renamed from: q */
    public void f(hk5 hk5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, hk5Var, str) == null) {
            this.b = hk5Var;
            if (hk5Var == null || !(hk5Var.a() instanceof wb8)) {
                return;
            }
            this.c = (wb8) this.b.a();
            this.d = new ec8(this.c, AdvertAppInfo.w);
            this.e = new fc8(this.c, AdvertAppInfo.z, str);
            this.f = new fc8(this.c, AdvertAppInfo.A, str);
            this.g = new fc8(this.c, AdvertAppInfo.B, str);
            this.h = new fc8(this.c, AdvertAppInfo.C, str);
        }
    }
}
