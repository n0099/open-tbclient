package d.l.a.e.b.l;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f74859a;

    /* renamed from: b  reason: collision with root package name */
    public b f74860b;

    /* renamed from: c  reason: collision with root package name */
    public int f74861c;

    /* renamed from: d  reason: collision with root package name */
    public int f74862d;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f74863a;

        /* renamed from: b  reason: collision with root package name */
        public long f74864b;

        /* renamed from: c  reason: collision with root package name */
        public b f74865c;

        /* renamed from: d  reason: collision with root package name */
        public b f74866d;

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
        this.f74862d = 10;
    }

    public final b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f74861c >= this.f74862d && (bVar = this.f74860b) != null) {
                b bVar2 = bVar.f74866d;
                bVar.f74866d = null;
                this.f74860b = bVar2;
                if (bVar2 != null) {
                    bVar2.f74865c = null;
                }
                return bVar;
            }
            this.f74861c++;
            return new b(null);
        }
        return (b) invokeV.objValue;
    }

    public final b b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            b bVar = this.f74859a;
            b bVar2 = null;
            while (bVar != null && bVar.f74864b > j) {
                bVar2 = bVar;
                bVar = bVar.f74865c;
            }
            return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f74864b >= bVar2.f74864b - j) ? bVar2 : bVar;
        }
        return (b) invokeJ.objValue;
    }

    public boolean c(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                b bVar = this.f74859a;
                if (bVar != null) {
                    if (j >= bVar.f74863a && j2 >= bVar.f74864b) {
                        b bVar2 = bVar.f74865c;
                        if (bVar2 != null && j2 - bVar2.f74864b < 1000) {
                            bVar.f74863a = j;
                            bVar.f74864b = j2;
                            return true;
                        }
                    }
                    return false;
                }
                b a2 = a();
                a2.f74863a = j;
                a2.f74864b = j2;
                if (bVar != null) {
                    a2.f74865c = bVar;
                    bVar.f74866d = a2;
                }
                this.f74859a = a2;
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
                b bVar = this.f74859a;
                if (bVar == null) {
                    return -1L;
                }
                b b2 = b(j);
                if (b2 == null) {
                    return -1L;
                }
                long j3 = bVar.f74863a - b2.f74863a;
                long j4 = j2 - b2.f74864b;
                if (j3 < 0 || j4 <= 0) {
                    return -1L;
                }
                return j3 / j4;
            }
        }
        return invokeCommon.longValue;
    }
}
