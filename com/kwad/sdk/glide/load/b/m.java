package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
/* loaded from: classes7.dex */
public class m<A, B> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.g<a<A>, B> f37872a;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class a<A> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Queue<a<?>> f37874a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public int f37875b;

        /* renamed from: c  reason: collision with root package name */
        public int f37876c;

        /* renamed from: d  reason: collision with root package name */
        public A f37877d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(427084162, "Lcom/kwad/sdk/glide/load/b/m$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(427084162, "Lcom/kwad/sdk/glide/load/b/m$a;");
                    return;
                }
            }
            f37874a = com.kwad.sdk.glide.g.k.a(0);
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static <A> a<A> a(A a2, int i2, int i3) {
            InterceptResult invokeLII;
            a<A> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, a2, i2, i3)) == null) {
                synchronized (f37874a) {
                    aVar = (a<A>) f37874a.poll();
                }
                if (aVar == null) {
                    aVar = new a<>();
                }
                aVar.b(a2, i2, i3);
                return aVar;
            }
            return (a) invokeLII.objValue;
        }

        private void b(A a2, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(65539, this, a2, i2, i3) == null) {
                this.f37877d = a2;
                this.f37876c = i2;
                this.f37875b = i3;
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (f37874a) {
                    f37874a.offer(this);
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return this.f37876c == aVar.f37876c && this.f37875b == aVar.f37875b && this.f37877d.equals(aVar.f37877d);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (((this.f37875b * 31) + this.f37876c) * 31) + this.f37877d.hashCode() : invokeV.intValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m() {
        this(250L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37872a = new com.kwad.sdk.glide.g.g<a<A>, B>(this, j) { // from class: com.kwad.sdk.glide.load.b.m.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ m f37873a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Long.valueOf(j)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Long) newInitContext2.callArgs[0]).longValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37873a = this;
            }

            public void a(@NonNull a<A> aVar, @Nullable B b2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar, b2) == null) {
                    aVar.a();
                }
            }

            @Override // com.kwad.sdk.glide.g.g
            public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable Object obj2) {
                a((a) ((a) obj), (a<A>) obj2);
            }
        };
    }

    @Nullable
    public B a(A a2, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, a2, i2, i3)) == null) {
            a<A> a3 = a.a(a2, i2, i3);
            B b2 = this.f37872a.b(a3);
            a3.a();
            return b2;
        }
        return (B) invokeLII.objValue;
    }

    public void a(A a2, int i2, int i3, B b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{a2, Integer.valueOf(i2), Integer.valueOf(i3), b2}) == null) {
            this.f37872a.b(a.a(a2, i2, i3), b2);
        }
    }
}
