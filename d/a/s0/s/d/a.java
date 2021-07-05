package d.a.s0.s.d;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f65175c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1663a> f65176a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.r0.s.f.a> f65177b;

    /* renamed from: d.a.s0.s.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1663a {
        void e(List<d.a.r0.s.f.a> list);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65176a = new ArrayList();
    }

    public static synchronized a d() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f65175c == null) {
                    f65175c = new a();
                }
                aVar = f65175c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public void a(d.a.r0.s.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f65177b == null || aVar == null) {
            return;
        }
        String a2 = aVar.a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "#";
            aVar.k("#");
        }
        String f2 = aVar.f();
        if (f2 == null) {
            f2 = "";
        }
        boolean z = false;
        boolean z2 = false;
        for (d.a.r0.s.f.a aVar2 : this.f65177b) {
            if (f2.equals(aVar2.f())) {
                z = true;
            }
            if (a2.equals(aVar2.a())) {
                z2 = true;
            }
        }
        if (z) {
            return;
        }
        if (!z2) {
            d.a.r0.s.f.a aVar3 = new d.a.r0.s.f.a();
            aVar3.k(a2);
            this.f65177b.add(aVar3);
        }
        this.f65177b.add(aVar);
        Collections.sort(this.f65177b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.a.r0.s.f.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (list = this.f65177b) == null) {
            return;
        }
        String str = null;
        Iterator<d.a.r0.s.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.r0.s.f.a next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.f65177b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.a.r0.s.f.a aVar : this.f65177b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f65177b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.a.r0.s.f.a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65177b : (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (InterfaceC1663a interfaceC1663a : this.f65176a) {
                interfaceC1663a.e(this.f65177b);
            }
        }
    }

    public void f(InterfaceC1663a interfaceC1663a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, interfaceC1663a) == null) || interfaceC1663a == null || this.f65176a.contains(interfaceC1663a)) {
            return;
        }
        this.f65176a.add(interfaceC1663a);
    }

    public void g(List<d.a.r0.s.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f65177b = list;
            if (list != null) {
                Collections.sort(list, new ContactComparator());
            }
            e();
        }
    }

    public void h(InterfaceC1663a interfaceC1663a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, interfaceC1663a) == null) || interfaceC1663a == null) {
            return;
        }
        this.f65176a.remove(interfaceC1663a);
    }
}
