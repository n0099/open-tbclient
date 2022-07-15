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
/* loaded from: classes5.dex */
public class d98 implements pi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public ui5 b;
    public p98 c;
    public an d;
    public an e;
    public an f;
    public an g;
    public an h;

    public d98() {
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

    @Override // com.repackage.pi5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.repackage.si5
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    @Override // com.repackage.pi5
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    @Override // com.repackage.pi5
    public void e(List<oi5> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || gd7.e(list)) {
            return;
        }
        Set<nn> a = cb8.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (oi5 oi5Var : list) {
            if (oi5Var != null) {
                Object a2 = oi5Var.a();
                for (nn nnVar : a) {
                    if (a2 != null && oi5Var.c() == 3 && (a2 instanceof AdvertAppInfo) && nnVar != null && (nnVar instanceof AdvertAppInfo) && a2.hashCode() == nnVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) nnVar).i;
                    }
                }
                if (a2 != null && oi5Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        sn4 sn4Var = new sn4();
                        advertAppInfo.i = sn4Var;
                        sn4Var.a = "FRS";
                        String.valueOf(z);
                        sn4 sn4Var2 = advertAppInfo.i;
                        sn4Var2.b = i;
                        sn4Var2.c = str;
                        sn4Var2.d = str2;
                        sn4Var2.e = str3;
                        sn4Var2.f = str4;
                        sn4Var2.g = advertAppInfo.g;
                        sn4Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        cb8.b("FRS", a);
    }

    @Override // com.repackage.pi5
    public TypeAdapter.ViewHolder f(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        an anVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, viewGroup, obj)) == null) {
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

    @Override // com.repackage.pi5
    public void h(List<oi5> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, list, i) == null) || gd7.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                gd7.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<oi5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = gd7.i(list);
        int i3 = 0;
        int i4 = 0;
        for (oi5 oi5Var : list) {
            if (oi5Var.c() == 1) {
                i4++;
            }
        }
        int i5 = gd7.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) gd7.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int m = advertAppInfo.m();
            if (m != 0) {
                eb8.h(advertAppInfo, i, m);
                if (m != 28 && m != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                eb8.h(advertAppInfo, i, 100);
            } else {
                int e = (ng.e(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    eb8.h(advertAppInfo, i, 29);
                } else if (e < 0) {
                    eb8.h(advertAppInfo, i, 33);
                } else if (e >= i2 && i6 > 3) {
                    eb8.i(advertAppInfo, i, 2, e, i2);
                } else {
                    oi5 oi5Var2 = new oi5();
                    oi5Var2.d(advertAppInfo);
                    oi5Var2.e(advertAppInfo.getType().getId());
                    oi5Var2.f(3);
                    if (advertAppInfo.g()) {
                        if (t98.i(advertAppInfo.p) && di5.a().p()) {
                            eb8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < i2) {
                                gd7.b(list, oi5Var2, e);
                            } else if (e == i2) {
                                gd7.a(list, oi5Var2);
                            }
                        }
                    } else if (advertAppInfo.k()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < i2) {
                            gd7.b(list, oi5Var2, e);
                        } else if (e == i2) {
                            gd7.a(list, oi5Var2);
                        }
                    } else {
                        eb8.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.repackage.pi5
    public void j(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.repackage.pi5
    public View l(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        an anVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
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

    @Override // com.repackage.pi5
    public void m(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) == null) && (obj instanceof AdvertAppInfo)) {
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

    @Override // com.repackage.pi5
    public void n(List<oi5> list, List<oi5> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || gd7.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                gd7.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<oi5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i4 = gd7.i(list);
        int i5 = 0;
        int i6 = 0;
        for (oi5 oi5Var : list) {
            if (oi5Var.c() == 1) {
                i6++;
            }
        }
        int i7 = gd7.i(arrayList2);
        if (i7 < 1) {
            return;
        }
        int i8 = 9;
        if (gd7.i(arrayList2) > 1 && (e = (ng.e(((AdvertAppInfo) gd7.d(arrayList2, 1)).f, 0) - ng.e(((AdvertAppInfo) gd7.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i8 = e;
        }
        int e2 = ng.e(((AdvertAppInfo) gd7.d(arrayList2, 0)).f, 0) - 1;
        int i9 = i4 - i6;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < i7) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) gd7.d(arrayList2, i10);
            advertAppInfo.j = "SMART_FRS";
            int m = advertAppInfo.m();
            if (m != 0) {
                eb8.h(advertAppInfo, i, m);
                if (m != 28 && m != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                eb8.h(advertAppInfo, i, 100);
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
                        eb8.i(advertAppInfo, i, 2, i11, i4);
                        i10++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i2 = i11 < 0 ? 33 : 29;
                    }
                } else {
                    if (e3 <= (i9 - i8) + e2 || !z) {
                        arrayList = arrayList2;
                    } else if (!gd7.e(list2)) {
                        int i12 = gd7.i(list2);
                        int i13 = (i8 - ((i9 - e3) + 1)) - 1;
                        int i14 = 0;
                        while (i14 < i12 && i14 < i13) {
                            arrayList = arrayList2;
                            if (((oi5) gd7.d(list2, i14)).a() instanceof AdvertAppInfo) {
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
                        if (di5.a().o()) {
                            i2 = 36;
                        }
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    eb8.h(advertAppInfo, i, i2);
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    oi5 oi5Var2 = new oi5();
                    oi5Var2.d(advertAppInfo);
                    oi5Var2.e(advertAppInfo.getType().getId());
                    oi5Var2.f(3);
                    if (advertAppInfo.g()) {
                        if (t98.i(advertAppInfo.p) && di5.a().p()) {
                            eb8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(i11));
                            if (i11 < i4) {
                                gd7.b(list, oi5Var2, i11);
                            } else if (i11 == i4) {
                                gd7.a(list, oi5Var2);
                            }
                        }
                    } else if (advertAppInfo.k()) {
                        hashSet.add(Integer.valueOf(i11));
                        if (i11 < i4) {
                            gd7.b(list, oi5Var2, i11);
                        } else if (i11 == i4) {
                            gd7.a(list, oi5Var2);
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
    @Override // com.repackage.si5
    /* renamed from: p */
    public void o(ui5 ui5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ui5Var) == null) {
            this.b = ui5Var;
            if (ui5Var == null || !(ui5Var.a() instanceof p98)) {
                return;
            }
            this.c = (p98) this.b.a();
            this.d = new x98(this.c, AdvertAppInfo.t);
            this.e = new y98(this.c, AdvertAppInfo.w);
            this.f = new y98(this.c, AdvertAppInfo.x);
            this.g = new y98(this.c, AdvertAppInfo.y);
            this.h = new y98(this.c, AdvertAppInfo.z);
        }
    }
}
