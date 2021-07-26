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
    public b f72365a;

    /* renamed from: b  reason: collision with root package name */
    public b f72366b;

    /* renamed from: c  reason: collision with root package name */
    public int f72367c;

    /* renamed from: d  reason: collision with root package name */
    public int f72368d;

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
        public long f72369a;

        /* renamed from: b  reason: collision with root package name */
        public long f72370b;

        /* renamed from: c  reason: collision with root package name */
        public b f72371c;

        /* renamed from: d  reason: collision with root package name */
        public b f72372d;

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
        this.f72368d = 10;
    }

    public final b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f72367c >= this.f72368d && (bVar = this.f72366b) != null) {
                b bVar2 = bVar.f72372d;
                bVar.f72372d = null;
                this.f72366b = bVar2;
                if (bVar2 != null) {
                    bVar2.f72371c = null;
                }
                return bVar;
            }
            this.f72367c++;
            return new b(null);
        }
        return (b) invokeV.objValue;
    }

    public final b b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            b bVar = this.f72365a;
            b bVar2 = null;
            while (bVar != null && bVar.f72370b > j) {
                bVar2 = bVar;
                bVar = bVar.f72371c;
            }
            return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f72370b >= bVar2.f72370b - j) ? bVar2 : bVar;
        }
        return (b) invokeJ.objValue;
    }

    public boolean c(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                b bVar = this.f72365a;
                if (bVar != null) {
                    if (j >= bVar.f72369a && j2 >= bVar.f72370b) {
                        b bVar2 = bVar.f72371c;
                        if (bVar2 != null && j2 - bVar2.f72370b < 1000) {
                            bVar.f72369a = j;
                            bVar.f72370b = j2;
                            return true;
                        }
                    }
                    return false;
                }
                b a2 = a();
                a2.f72369a = j;
                a2.f72370b = j2;
                if (bVar != null) {
                    a2.f72371c = bVar;
                    bVar.f72372d = a2;
                }
                this.f72365a = a2;
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
                b bVar = this.f72365a;
                if (bVar == null) {
                    return -1L;
                }
                b b2 = b(j);
                if (b2 == null) {
                    return -1L;
                }
                long j3 = bVar.f72369a - b2.f72369a;
                long j4 = j2 - b2.f72370b;
                if (j3 < 0 || j4 <= 0) {
                    return -1L;
                }
                return j3 / j4;
            }
        }
        return invokeCommon.longValue;
    }
}
