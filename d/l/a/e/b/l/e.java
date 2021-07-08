package d.l.a.e.b.l;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f71911a;

    /* renamed from: b  reason: collision with root package name */
    public b f71912b;

    /* renamed from: c  reason: collision with root package name */
    public int f71913c;

    /* renamed from: d  reason: collision with root package name */
    public int f71914d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f71915a;

        /* renamed from: b  reason: collision with root package name */
        public long f71916b;

        /* renamed from: c  reason: collision with root package name */
        public b f71917c;

        /* renamed from: d  reason: collision with root package name */
        public b f71918d;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public e() {
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
        this.f71914d = 10;
    }

    public final b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f71913c >= this.f71914d && (bVar = this.f71912b) != null) {
                b bVar2 = bVar.f71918d;
                bVar.f71918d = null;
                this.f71912b = bVar2;
                if (bVar2 != null) {
                    bVar2.f71917c = null;
                }
                return bVar;
            }
            this.f71913c++;
            return new b(null);
        }
        return (b) invokeV.objValue;
    }

    public final b b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            b bVar = this.f71911a;
            b bVar2 = null;
            while (bVar != null && bVar.f71916b > j) {
                bVar2 = bVar;
                bVar = bVar.f71917c;
            }
            return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f71916b >= bVar2.f71916b - j) ? bVar2 : bVar;
        }
        return (b) invokeJ.objValue;
    }

    public boolean c(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                b bVar = this.f71911a;
                if (bVar != null) {
                    if (j >= bVar.f71915a && j2 >= bVar.f71916b) {
                        b bVar2 = bVar.f71917c;
                        if (bVar2 != null && j2 - bVar2.f71916b < 1000) {
                            bVar.f71915a = j;
                            bVar.f71916b = j2;
                            return true;
                        }
                    }
                    return false;
                }
                b a2 = a();
                a2.f71915a = j;
                a2.f71916b = j2;
                if (bVar != null) {
                    a2.f71917c = bVar;
                    bVar.f71918d = a2;
                }
                this.f71911a = a2;
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public long d(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                b bVar = this.f71911a;
                if (bVar == null) {
                    return -1L;
                }
                b b2 = b(j);
                if (b2 == null) {
                    return -1L;
                }
                long j3 = bVar.f71915a - b2.f71915a;
                long j4 = j2 - b2.f71916b;
                if (j3 < 0 || j4 <= 0) {
                    return -1L;
                }
                return j3 / j4;
            }
        }
        return invokeCommon.longValue;
    }
}
