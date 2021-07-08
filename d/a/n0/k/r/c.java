package d.a.n0.k.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<T> f50588a;

    /* renamed from: b  reason: collision with root package name */
    public final int f50589b;

    public c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50588a = new ArrayList<>();
        this.f50589b = i2;
    }

    public synchronized T a() {
        InterceptResult invokeV;
        T remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                do {
                    if (this.f50588a.size() <= 0) {
                        return null;
                    }
                    remove = this.f50588a.remove(this.f50588a.size() - 1);
                } while (remove == null);
                return remove;
            }
        }
        return (T) invokeV.objValue;
    }

    public synchronized void b(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            synchronized (this) {
                if (t != null) {
                    if (this.f50588a.size() >= this.f50589b) {
                        this.f50588a.remove(this.f50588a.size() - 1);
                    }
                    this.f50588a.add(t);
                }
            }
        }
    }
}
