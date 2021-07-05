package d.a.s0.h3.n0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f61361a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f61362b;

    /* renamed from: c  reason: collision with root package name */
    public volatile HashMap<Long, Integer> f61363c;

    public d(int i2) {
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
        this.f61363c = new HashMap<>();
        this.f61361a = 0;
        this.f61362b = i2;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                synchronized (this) {
                    if (this.f61363c.size() >= this.f61362b) {
                        c();
                    }
                    this.f61361a++;
                    this.f61363c.put(valueOf, Integer.valueOf(this.f61361a));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return this.f61363c.containsKey(Long.valueOf(Long.parseLong(str)));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Long l = null;
                int i2 = 134217727;
                for (Map.Entry<Long, Integer> entry : this.f61363c.entrySet()) {
                    if (entry.getValue().intValue() < i2) {
                        int intValue = entry.getValue().intValue();
                        i2 = intValue;
                        l = entry.getKey();
                    }
                }
                if (l != null) {
                    this.f61363c.remove(l);
                } else {
                    this.f61363c.clear();
                }
            }
        }
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                synchronized (this) {
                    return this.f61363c.get(valueOf) != null;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
