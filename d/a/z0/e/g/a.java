package d.a.z0.e.g;

import android.content.Context;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.z0.e.f.d;
import d.i.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.z0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C1990a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f71635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f71636b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f71637c;

        public C1990a(a aVar, AtomicBoolean atomicBoolean, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, atomicBoolean, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71637c = aVar;
            this.f71635a = atomicBoolean;
            this.f71636b = obj;
        }

        @Override // d.i.a.a.c
        public void a(int i2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, exc) == null) {
                this.f71637c.f71634g = i2;
                this.f71635a.set(true);
                synchronized (this.f71636b) {
                    this.f71636b.notifyAll();
                }
            }
        }

        @Override // d.i.a.a.c
        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
                this.f71637c.f71631d = str;
                this.f71637c.f71629b = z;
                this.f71637c.f71630c = true;
                this.f71637c.f71634g = 0;
                this.f71635a.set(true);
                synchronized (this.f71636b) {
                    this.f71636b.notifyAll();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71631d = "";
        this.f71629b = false;
        this.f71630c = false;
        this.f71634g = -200;
    }

    @Override // d.a.z0.e.f.c
    public d.a.z0.e.f.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o();
            return this;
        }
        return (d.a.z0.e.f.c) invokeV.objValue;
    }

    public d.a.z0.e.f.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = new Object();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            d.i.a.a.d(this.f71628a, new C1990a(this, atomicBoolean, obj));
            synchronized (obj) {
                if (!atomicBoolean.get()) {
                    try {
                        obj.wait(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            return this;
        }
        return (d.a.z0.e.f.c) invokeV.objValue;
    }
}
