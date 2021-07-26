package d.a.o0.e.s;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class c<ContenT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c<ContenT>.a> f49752a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f49753e;

        /* renamed from: f  reason: collision with root package name */
        public final ContenT f49754f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f49755g;

        public a(c cVar, String str, ContenT content) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, content};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49755g = cVar;
            this.f49753e = str;
            this.f49754f = content;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49755g.d(this.f49753e);
            }
        }
    }

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
        this.f49752a = new HashMap();
    }

    public synchronized ContenT a(String str, ContenT content, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, content, Long.valueOf(j)})) == null) {
            synchronized (this) {
                d(str);
                if (content == null) {
                    return null;
                }
                c<ContenT>.a aVar = new a(this, str, content);
                this.f49752a.put(str, aVar);
                if (j > 0) {
                    d.i().postDelayed(aVar, j);
                }
                return content;
            }
        }
        return (ContenT) invokeCommon.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (c<ContenT>.a aVar : this.f49752a.values()) {
                    if (aVar != null) {
                        d.i().removeCallbacks(aVar);
                    }
                }
                this.f49752a.clear();
            }
        }
    }

    public ContenT c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            c<ContenT>.a aVar = this.f49752a.get(str);
            if (aVar == null) {
                return null;
            }
            return aVar.f49754f;
        }
        return (ContenT) invokeL.objValue;
    }

    public synchronized ContenT d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                c<ContenT>.a remove = this.f49752a.remove(str);
                if (remove != null) {
                    d.i().removeCallbacks(remove);
                    return remove.f49754f;
                }
                return null;
            }
        }
        return (ContenT) invokeL.objValue;
    }
}
