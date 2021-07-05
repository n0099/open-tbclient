package d.a.s0.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f64288a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f64289b;

    /* renamed from: c  reason: collision with root package name */
    public c f64290c;

    public a(c cVar, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64289b = arrayList;
        this.f64290c = cVar;
        this.f64288a = new HashMap<>();
    }

    public int a(String str, int i2) {
        InterceptResult invokeLI;
        ArrayList<Integer> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (this.f64288a == null || k.isEmpty(str) || (arrayList = this.f64289b) == null || !arrayList.contains(Integer.valueOf(i2))) {
                return 0;
            }
            if (!this.f64288a.containsKey(str)) {
                b(str);
            }
            b bVar = this.f64288a.get(str);
            if (bVar == null) {
                return 0;
            }
            return bVar.a(i2);
        }
        return invokeLI.intValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f64288a == null || k.isEmpty(str) || this.f64290c == null) {
            return;
        }
        if (this.f64288a.containsKey(str)) {
            b bVar = this.f64288a.get(str);
            this.f64290c.b(this.f64289b, bVar);
            this.f64288a.put(str, bVar);
            return;
        }
        b bVar2 = new b();
        this.f64290c.b(this.f64289b, bVar2);
        this.f64288a.put(str, bVar2);
    }
}
