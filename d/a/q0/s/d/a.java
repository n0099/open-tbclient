package d.a.q0.s.d;

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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f62567c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1626a> f62568a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.p0.t.f.a> f62569b;

    /* renamed from: d.a.q0.s.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1626a {
        void e(List<d.a.p0.t.f.a> list);
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
        this.f62568a = new ArrayList();
    }

    public static synchronized a d() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f62567c == null) {
                    f62567c = new a();
                }
                aVar = f62567c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public void a(d.a.p0.t.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f62569b == null || aVar == null) {
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
        for (d.a.p0.t.f.a aVar2 : this.f62569b) {
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
            d.a.p0.t.f.a aVar3 = new d.a.p0.t.f.a();
            aVar3.k(a2);
            this.f62569b.add(aVar3);
        }
        this.f62569b.add(aVar);
        Collections.sort(this.f62569b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.a.p0.t.f.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (list = this.f62569b) == null) {
            return;
        }
        String str = null;
        Iterator<d.a.p0.t.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.p0.t.f.a next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.f62569b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.a.p0.t.f.a aVar : this.f62569b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f62569b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.a.p0.t.f.a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62569b : (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (InterfaceC1626a interfaceC1626a : this.f62568a) {
                interfaceC1626a.e(this.f62569b);
            }
        }
    }

    public void f(InterfaceC1626a interfaceC1626a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, interfaceC1626a) == null) || interfaceC1626a == null || this.f62568a.contains(interfaceC1626a)) {
            return;
        }
        this.f62568a.add(interfaceC1626a);
    }

    public void g(List<d.a.p0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f62569b = list;
            if (list != null) {
                Collections.sort(list, new ContactComparator());
            }
            e();
        }
    }

    public void h(InterfaceC1626a interfaceC1626a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, interfaceC1626a) == null) || interfaceC1626a == null) {
            return;
        }
        this.f62568a.remove(interfaceC1626a);
    }
}
