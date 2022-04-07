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
    public List<jy4> b;

    /* loaded from: classes6.dex */
    public interface a {
        void j(List<jy4> list);
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

    public void a(jy4 jy4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jy4Var) == null) || this.b == null || jy4Var == null) {
            return;
        }
        String a2 = jy4Var.a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "#";
            jy4Var.k("#");
        }
        String f = jy4Var.f();
        if (f == null) {
            f = "";
        }
        boolean z = false;
        boolean z2 = false;
        for (jy4 jy4Var2 : this.b) {
            if (f.equals(jy4Var2.f())) {
                z = true;
            }
            if (a2.equals(jy4Var2.a())) {
                z2 = true;
            }
        }
        if (z) {
            return;
        }
        if (!z2) {
            jy4 jy4Var3 = new jy4();
            jy4Var3.k(a2);
            this.b.add(jy4Var3);
        }
        this.b.add(jy4Var);
        Collections.sort(this.b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<jy4> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (list = this.b) == null) {
            return;
        }
        String str = null;
        Iterator<jy4> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            jy4 next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (jy4 jy4Var : this.b) {
                if (str.equals(jy4Var.a())) {
                    arrayList.add(jy4Var);
                }
            }
            if (arrayList.size() <= 1) {
                this.b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<jy4> c() {
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

    public void g(List<jy4> list) {
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
