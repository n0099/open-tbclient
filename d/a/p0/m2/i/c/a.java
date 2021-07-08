package d.a.p0.m2.i.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.k.e.n;
import d.a.o0.r.q.b2;
import d.a.p0.a0.e0.b;
import d.a.p0.a0.e0.e;
import d.a.p0.a0.e0.f;
import d.a.p0.a0.e0.l;
import d.a.p0.m2.e.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f60340a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f60341b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f60342c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-416146004, "Ld/a/p0/m2/i/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-416146004, "Ld/a/p0/m2/i/c/a;");
                return;
            }
        }
        f60340a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        f60341b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
        f60342c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
    }

    public static List<n> a(List<b2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                b2 b2Var = (b2) ListUtils.getItem(list, i2);
                if (b2Var != null) {
                    d.a.o0.b.f.a.e(b2Var);
                    b d2 = d(b2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            d.a.o0.b.f.a.d(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(List<b2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                k kVar = new k();
                kVar.f60270h = f60342c;
                kVar.f60269g = f60341b;
                kVar.f60268f = f60340a;
                kVar.f60267e = R.string.person_center_tab_main_list_title;
                arrayList.add(kVar);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    b2 b2Var = list.get(i2);
                    if (b2Var != null) {
                        d.a.o0.b.f.a.e(b2Var);
                        b d2 = d(b2Var);
                        if (d2 != null) {
                            arrayList.add(d2);
                        }
                    }
                }
                d.a.o0.b.f.a.d(arrayList);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> c(List<n> list) {
        InterceptResult invokeL;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                n nVar = (n) ListUtils.getItem(list, i2);
                if ((nVar instanceof CardPersonDynamicThreadData) && (b2Var = ((CardPersonDynamicThreadData) nVar).r) != null) {
                    d.a.o0.b.f.a.e(b2Var);
                    b d2 = d(b2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            d.a.o0.b.f.a.d(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static b d(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, b2Var)) == null) {
            b bVar = null;
            if (b2Var == null) {
                return null;
            }
            b2Var.a2 = true;
            b2Var.z1();
            if (b2Var.v1) {
                bVar = new d.a.p0.a0.e0.k();
                bVar.f53795e = b2Var;
            } else if (e.W(b2Var)) {
                bVar = new e(b2Var);
            } else if (f.Z(b2Var)) {
                bVar = new f(b2Var);
            } else if (!d.a.p0.a0.e0.k.W(b2Var) && !d.a.p0.a0.e0.k.X(b2Var)) {
                if (l.R(b2Var)) {
                    bVar = new l(b2Var);
                }
            } else {
                bVar = new d.a.p0.a0.e0.k();
                if (!b2Var.V1() && !b2Var.j2()) {
                    b2Var.Q1();
                }
                bVar.f53795e = b2Var;
            }
            if (bVar != null) {
                d.a.o0.b.f.a.e(bVar);
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static b2 e(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, nVar)) == null) {
            if (nVar != null && (nVar instanceof d.a.o0.r.q.a)) {
                b2 threadData = ((d.a.o0.r.q.a) nVar).getThreadData();
                threadData.a2 = true;
                d.a.o0.b.f.a.e(threadData);
                return threadData;
            }
            return null;
        }
        return (b2) invokeL.objValue;
    }
}
