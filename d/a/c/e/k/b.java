package d.a.c.e.k;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f44250a;

    /* renamed from: b  reason: collision with root package name */
    public int f44251b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<T> f44252c;

    /* renamed from: d  reason: collision with root package name */
    public c<T> f44253d;

    public b(c<T> cVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44250a = 10;
        this.f44251b = 0;
        this.f44252c = null;
        this.f44253d = null;
        if (cVar != null && i2 > 0 && i3 <= i2) {
            this.f44253d = cVar;
            this.f44250a = i2;
            this.f44251b = i3;
            this.f44252c = new LinkedList<>();
            a(this.f44251b);
            return;
        }
        throw new InvalidParameterException("invalid params");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.util.LinkedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            synchronized (this) {
                for (int i3 = 0; i3 < i2; i3++) {
                    Object obj = null;
                    try {
                        obj = this.f44253d.a(this.f44253d.d());
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    if (obj != null) {
                        this.f44252c.offer(obj);
                    }
                }
            }
        }
    }

    public T b() {
        InterceptResult invokeV;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                t = null;
                try {
                    if (this.f44252c.size() > 0) {
                        t = this.f44253d.a(this.f44252c.poll());
                    } else {
                        t = this.f44253d.a(this.f44253d.d());
                    }
                    a(this.f44251b - this.f44252c.size());
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f44252c.clear();
            }
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (this) {
                for (int i3 = 0; i3 < i2; i3++) {
                    try {
                        this.f44253d.b(this.f44252c.poll());
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        }
    }

    public void e(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
            synchronized (this) {
                if (this.f44252c.size() < this.f44250a) {
                    T t2 = null;
                    try {
                        t2 = this.f44253d.c(t);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    if (t2 != null) {
                        this.f44252c.offer(t2);
                    }
                } else {
                    this.f44253d.b(t);
                }
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            synchronized (this) {
                if (i2 < this.f44251b) {
                    i2 = this.f44251b;
                }
                if (i2 <= 0) {
                    i2 = 1;
                }
                this.f44250a = i2;
                d(this.f44252c.size() - this.f44250a);
            }
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            synchronized (this) {
                if (i2 > this.f44250a) {
                    i2 = this.f44250a;
                }
                this.f44251b = i2;
                a(i2 - this.f44252c.size());
            }
        }
    }
}
