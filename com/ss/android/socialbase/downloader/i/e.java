package com.ss.android.socialbase.downloader.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f69429a;

    /* renamed from: b  reason: collision with root package name */
    public a f69430b;

    /* renamed from: c  reason: collision with root package name */
    public int f69431c;

    /* renamed from: d  reason: collision with root package name */
    public int f69432d;

    /* renamed from: com.ss.android.socialbase.downloader.i.e$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f69433a;

        /* renamed from: b  reason: collision with root package name */
        public long f69434b;

        /* renamed from: c  reason: collision with root package name */
        public a f69435c;

        /* renamed from: d  reason: collision with root package name */
        public a f69436d;

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

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
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
        this.f69432d = 10;
    }

    public boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                a aVar = this.f69429a;
                if (aVar != null) {
                    if (j >= aVar.f69433a && j2 >= aVar.f69434b) {
                        a aVar2 = aVar.f69435c;
                        if (aVar2 != null && j2 - aVar2.f69434b < 1000) {
                            aVar.f69433a = j;
                            aVar.f69434b = j2;
                            return true;
                        }
                    }
                    return false;
                }
                a a2 = a();
                a2.f69433a = j;
                a2.f69434b = j2;
                if (aVar != null) {
                    a2.f69435c = aVar;
                    aVar.f69436d = a2;
                }
                this.f69429a = a2;
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public long b(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                a aVar = this.f69429a;
                if (aVar == null) {
                    return -1L;
                }
                a a2 = a(j);
                if (a2 == null) {
                    return -1L;
                }
                long j3 = aVar.f69433a - a2.f69433a;
                long j4 = j2 - a2.f69434b;
                if (j3 < 0 || j4 <= 0) {
                    return -1L;
                }
                return j3 / j4;
            }
        }
        return invokeCommon.longValue;
    }

    private a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.f69431c >= this.f69432d && (aVar = this.f69430b) != null) {
                a aVar2 = aVar.f69436d;
                aVar.f69436d = null;
                this.f69430b = aVar2;
                if (aVar2 != null) {
                    aVar2.f69435c = null;
                }
                return aVar;
            }
            this.f69431c++;
            return new a(null);
        }
        return (a) invokeV.objValue;
    }

    private a a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j)) == null) {
            a aVar = this.f69429a;
            a aVar2 = null;
            while (aVar != null && aVar.f69434b > j) {
                aVar2 = aVar;
                aVar = aVar.f69435c;
            }
            return (aVar == null || aVar2 == null || aVar == aVar2 || j - aVar.f69434b >= aVar2.f69434b - j) ? aVar2 : aVar;
        }
        return (a) invokeJ.objValue;
    }
}
