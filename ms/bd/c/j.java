package ms.bd.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import ms.bd.c.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class j extends b.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static j f79636a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f79637a;

        /* renamed from: b  reason: collision with root package name */
        public long f79638b;

        /* renamed from: c  reason: collision with root package name */
        public String f79639c;

        /* renamed from: d  reason: collision with root package name */
        public String f79640d;

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
                }
            }
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f79639c = str;
                this.f79640d = null;
                this.f79637a = System.currentTimeMillis();
            }
        }

        public void b(String str, int i2) {
            j c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) || (c2 = j.c()) == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f79637a;
            long j3 = currentTimeMillis - j2;
            this.f79638b = j3;
            c2.d(j3, j2, this.f79639c, this.f79640d, str, i2, null);
        }

        public void c(String str, int i2) {
            j c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) || (c2 = j.c()) == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f79637a;
            long j3 = currentTimeMillis - j2;
            this.f79638b = j3;
            c2.h(j3, j2, this.f79639c, this.f79640d, str, i2, null);
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized j c() {
        InterceptResult invokeV;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (j.class) {
                jVar = f79636a;
            }
            return jVar;
        }
        return (j) invokeV.objValue;
    }

    public static synchronized void f(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jVar) == null) {
            synchronized (j.class) {
                f79636a = jVar;
            }
        }
    }

    @Override // ms.bd.c.b.a
    public Object a(int i2, int i3, long j2, String str, Object obj) throws Throwable {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), str, obj})) == null) {
            if (i2 == 131073) {
                if (str == null || !g(str)) {
                    return null;
                }
                return (String) h.a(16777217, 0, 0L, "f56f73", new byte[]{88, 28});
            }
            if (i2 == 131074) {
                String[] strArr = (String[]) obj;
                if (str != null && strArr != null && strArr.length != 0) {
                    e(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
                }
            }
            return null;
        }
        return invokeCommon.objValue;
    }

    public abstract void d(long j2, long j3, String str, String str2, String str3, int i2, JSONObject jSONObject);

    public abstract void e(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean g(String str);

    public abstract void h(long j2, long j3, String str, String str2, String str3, int i2, JSONObject jSONObject);
}
