package d.a.s.f.a;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class d<T> implements d.a.s.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f67826a;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f67827b;

    /* renamed from: c  reason: collision with root package name */
    public b<T> f67828c;

    /* renamed from: d  reason: collision with root package name */
    public a f67829d;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Bundle f67830a;

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
    }

    /* loaded from: classes8.dex */
    public static class b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public T f67831a;

        /* renamed from: b  reason: collision with root package name */
        public Bundle f67832b;

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
    }

    public d() {
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
        this.f67826a = false;
        this.f67827b = new CountDownLatch(1);
        this.f67828c = null;
        this.f67829d = null;
    }

    @Override // d.a.s.c
    public void a(T t, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, t, bundle) == null) {
            b<T> bVar = new b<>();
            this.f67828c = bVar;
            bVar.f67831a = t;
            bVar.f67832b = bundle;
            this.f67826a = true;
            this.f67827b.countDown();
        }
    }

    @Override // d.a.s.c
    public void b(int i2, Throwable th, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, th, bundle) == null) {
            a aVar = new a();
            this.f67829d = aVar;
            aVar.f67830a = bundle;
            this.f67826a = false;
            this.f67827b.countDown();
        }
    }

    public b<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67828c : (b) invokeV.objValue;
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            try {
                this.f67827b.await(i2, TimeUnit.MILLISECONDS);
                if (this.f67829d == null) {
                    this.f67829d = new a();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            return this.f67826a;
        }
        return invokeI.booleanValue;
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67829d : (a) invokeV.objValue;
    }
}
