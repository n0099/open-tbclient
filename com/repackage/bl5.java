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
/* loaded from: classes5.dex */
public class bl5 {
    public static /* synthetic */ Interceptable $ic;
    public static bl5 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> a;
    public List<bz4> b;

    /* loaded from: classes5.dex */
    public interface a {
        void p(List<bz4> list);
    }

    public bl5() {
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

    public static synchronized bl5 d() {
        InterceptResult invokeV;
        bl5 bl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (bl5.class) {
                if (c == null) {
                    c = new bl5();
                }
                bl5Var = c;
            }
            return bl5Var;
        }
        return (bl5) invokeV.objValue;
    }

    public void a(bz4 bz4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bz4Var) == null) || this.b == null || bz4Var == null) {
            return;
        }
        String a2 = bz4Var.a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "#";
            bz4Var.j("#");
        }
        String e = bz4Var.e();
        if (e == null) {
            e = "";
        }
        boolean z = false;
        boolean z2 = false;
        for (bz4 bz4Var2 : this.b) {
            if (e.equals(bz4Var2.e())) {
                z = true;
            }
            if (a2.equals(bz4Var2.a())) {
                z2 = true;
            }
        }
        if (z) {
            return;
        }
        if (!z2) {
            bz4 bz4Var3 = new bz4();
            bz4Var3.j(a2);
            this.b.add(bz4Var3);
        }
        this.b.add(bz4Var);
        Collections.sort(this.b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<bz4> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (list = this.b) == null) {
            return;
        }
        String str = null;
        Iterator<bz4> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            bz4 next = it.next();
            if (next.d() == j) {
                str = next.a();
                this.b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (bz4 bz4Var : this.b) {
                if (str.equals(bz4Var.a())) {
                    arrayList.add(bz4Var);
                }
            }
            if (arrayList.size() <= 1) {
                this.b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<bz4> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a aVar : this.a) {
                aVar.p(this.b);
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

    public void g(List<bz4> list) {
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
