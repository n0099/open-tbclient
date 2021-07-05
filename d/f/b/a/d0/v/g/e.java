package d.f.b.a.d0.v.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f72864a;

    /* renamed from: b  reason: collision with root package name */
    public final long f72865b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f72866c;

    public e(String str, long j, List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72864a = str;
        this.f72865b = j;
        this.f72866c = Collections.unmodifiableList(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int size = this.f72866c.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f72866c.get(i3).f72837b == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }
}
