package d.a.q0.a.n0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a1.e;
/* loaded from: classes8.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String[] f49553a;

    public c() {
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
        this.f49553a = new String[]{d.a.q0.a.a1.e.i(), d.a.q0.a.a1.e.l(), d.a.q0.a.a1.e.r(), e.b.f(), d.a.q0.a.e0.f.f.b.f(), d.a.q0.a.e0.f.f.b.d(), d.a.q0.a.e0.f.c.a.c(), e.f.f(), e.f.d(), d.a.q0.a.x0.a.d.a.f51679d};
    }

    @Override // d.a.q0.a.n0.j.d.a
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.f49553a) {
                String J = d.a.q0.t.d.J(str);
                if (!TextUtils.isEmpty(J)) {
                    arraySet.add(J);
                }
            }
            d.a.q0.a.e0.d.h("SwanSandboxFileCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }
}
