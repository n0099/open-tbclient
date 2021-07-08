package d.a.p0.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f61054a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f61055b;

    /* renamed from: c  reason: collision with root package name */
    public c f61056c;

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
        this.f61055b = arrayList;
        this.f61056c = cVar;
        this.f61054a = new HashMap<>();
    }

    public int a(String str, int i2) {
        InterceptResult invokeLI;
        ArrayList<Integer> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (this.f61054a == null || k.isEmpty(str) || (arrayList = this.f61055b) == null || !arrayList.contains(Integer.valueOf(i2))) {
                return 0;
            }
            if (!this.f61054a.containsKey(str)) {
                b(str);
            }
            b bVar = this.f61054a.get(str);
            if (bVar == null) {
                return 0;
            }
            return bVar.a(i2);
        }
        return invokeLI.intValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f61054a == null || k.isEmpty(str) || this.f61056c == null) {
            return;
        }
        if (this.f61054a.containsKey(str)) {
            b bVar = this.f61054a.get(str);
            this.f61056c.b(this.f61055b, bVar);
            this.f61054a.put(str, bVar);
            return;
        }
        b bVar2 = new b();
        this.f61056c.b(this.f61055b, bVar2);
        this.f61054a.put(str, bVar2);
    }
}
