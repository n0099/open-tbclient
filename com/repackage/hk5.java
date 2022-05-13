package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class hk5 {
    public static /* synthetic */ Interceptable $ic;
    public static hk5 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> a;
    public List<wy4> b;

    /* loaded from: classes6.dex */
    public interface a {
        void j(List<wy4> list);
    }

    public hk5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public static synchronized hk5 d() {
        InterceptResult invokeV;
        hk5 hk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (hk5.class) {
                if (c == null) {
                    c = new hk5();
                }
                hk5Var = c;
            }
            return hk5Var;
        }
        return (hk5) invokeV.objValue;
    }

    public void a(wy4 wy4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, wy4Var) == null) || this.b == null || wy4Var == null) {
            return;
        }
        String a2 = wy4Var.a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "#";
            wy4Var.k("#");
        }
        String f = wy4Var.f();
        if (f == null) {
            f = "";
        }
        boolean z = false;
        boolean z2 = false;
        for (wy4 wy4Var2 : this.b) {
            if (f.equals(wy4Var2.f())) {
                z = true;
            }
            if (a2.equals(wy4Var2.a())) {
                z2 = true;
            }
        }
        if (z) {
            return;
        }
        if (!z2) {
            wy4 wy4Var3 = new wy4();
            wy4Var3.k(a2);
            this.b.add(wy4Var3);
        }
        this.b.add(wy4Var);
        Collections.sort(this.b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<wy4> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (list = this.b) == null) {
            return;
        }
        String str = null;
        Iterator<wy4> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            wy4 next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (wy4 wy4Var : this.b) {
                if (str.equals(wy4Var.a())) {
                    arrayList.add(wy4Var);
                }
            }
            if (arrayList.size() <= 1) {
                this.b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<wy4> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a aVar : this.a) {
                aVar.j(this.b);
            }
        }
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || this.a.contains(aVar)) {
            return;
        }
        this.a.add(aVar);
    }

    public void g(List<wy4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b = list;
            if (list != null) {
                Collections.sort(list, new ContactComparator());
            }
            e();
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a.remove(aVar);
    }
}
