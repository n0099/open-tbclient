package d.e.b.a;

import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes10.dex */
public class i extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f72070f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f72071d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f72072e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(893340270, "Ld/e/b/a/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(893340270, "Ld/e/b/a/i;");
                return;
            }
        }
        f72070f = new LinkedHashMap<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Thread thread, long j) {
        this(thread, 100, j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {thread, Long.valueOf(j)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Thread) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // d.e.b.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : this.f72072e.getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append(Part.CRLF);
            }
            synchronized (f72070f) {
                if (f72070f.size() == this.f72071d && this.f72071d > 0) {
                    f72070f.remove(f72070f.keySet().iterator().next());
                }
                f72070f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
            }
        }
    }

    public ArrayList<String> e(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            synchronized (f72070f) {
                for (Long l : f72070f.keySet()) {
                    if (j < l.longValue() && l.longValue() < j2) {
                        arrayList.add(d.e.b.a.j.a.x.format(l) + Part.CRLF + Part.CRLF + f72070f.get(l));
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Thread thread, int i2, long j) {
        super(j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {thread, Integer.valueOf(i2), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72071d = 100;
        this.f72072e = thread;
        this.f72071d = i2;
    }
}
