package d.a.q0.v.i.a.c;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.q0.a.a2.e;
import d.a.q0.a.e2.c.d;
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.y0.k.g.a;
import d.a.q0.v.j.a.a;
/* loaded from: classes8.dex */
public class b extends d.a.q0.v.i.a.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public d.a.q0.v.j.a.a z;

    /* loaded from: classes8.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f54464a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54464a = bVar;
        }

        @Override // d.a.q0.v.j.a.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f54464a.y0();
            }
        }
    }

    /* renamed from: d.a.q0.v.i.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1208b implements d.a.q0.a.v2.e1.b<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f54465e;

        public C1208b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54465e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 2) {
                    if (d.a.q0.v.i.a.c.a.x) {
                        Log.d("SwanInlineLiveWidget", this.f54465e.f54448f + "-" + hashCode() + " authorize deny => onError 0");
                    }
                    a.InterfaceC1039a interfaceC1039a = this.f54465e.f54451i;
                    if (interfaceC1039a != null) {
                        interfaceC1039a.onError(0);
                        return;
                    }
                    return;
                }
                if (d.a.q0.v.i.a.c.a.x) {
                    Log.d("SwanInlineLiveWidget", this.f54465e.f54448f + "-" + hashCode() + " real do prepareAsync");
                }
                b.super.prepareAsync();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f54466e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f54467f;

        public c(b bVar, d.a.q0.a.v2.e1.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54467f = bVar;
            this.f54466e = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean h2 = d.h(iVar);
                if (d.a.q0.v.i.a.c.a.x) {
                    Log.d("SwanInlineLiveWidget", this.f54467f.f54448f + "-" + hashCode() + " authorize: " + h2);
                }
                this.f54467f.A = h2 ? 1 : 2;
                this.f54466e.onCallback(Integer.valueOf(this.f54467f.A));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ZeusPluginFactory.Invoker) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = 0;
        d.a.q0.v.j.a.a aVar = new d.a.q0.v.j.a.a();
        this.z = aVar;
        aVar.e(this.f54445c);
        this.z.f(new a(this));
    }

    @Override // d.a.q0.v.i.a.c.a
    public void B0(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
        }
    }

    @Override // d.a.q0.v.i.a.c.a
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void L0(@NonNull Context context, @NonNull d.a.q0.a.v2.e1.b<Integer> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) {
            if (d.a.q0.v.i.a.c.a.x) {
                Log.d("SwanInlineLiveWidget", this.f54448f + "-" + hashCode() + " start authorize");
            }
            e Q = e.Q();
            if (Q == null) {
                if (!d.a.q0.v.i.a.c.a.x) {
                    bVar.onCallback(0);
                    return;
                }
                throw new RuntimeException("inline live authorize: swan app is null");
            } else if (d.a.q0.a.u1.a.a.r()) {
                this.A = 1;
                if (d.a.q0.v.i.a.c.a.x) {
                    Log.d("SwanInlineLiveWidget", this.f54448f + "-" + hashCode() + " authorize debug: true");
                }
                bVar.onCallback(Integer.valueOf(this.A));
            } else {
                Q.T().g(context, "mapp_i_live_player", new c(this, bVar));
            }
        }
    }

    @Override // d.a.q0.a.y0.k.g.a
    public void N(ZeusPluginFactory.Invoker invoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, invoker) == null) {
        }
    }

    @Override // d.a.q0.a.y0.k.g.a
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // d.a.q0.v.i.a.c.a, d.a.q0.a.y0.k.g.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.A : invokeV.intValue;
    }

    @Override // d.a.q0.v.i.a.c.a, d.a.q0.a.y0.k.g.a
    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // d.a.q0.a.y0.k.g.a
    public ZeusPluginFactory.Invoker f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ZeusPluginFactory.Invoker) invokeV.objValue;
    }

    @Override // d.a.q0.v.i.a.c.a, d.a.q0.a.y0.k.g.a
    public boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (d.a.q0.v.i.a.c.a.x) {
                Log.d("SwanInlineLiveWidget", this.f54448f + "-" + hashCode() + " start prepareAsync");
            }
            L0(this.f54445c, new C1208b(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.v.i.a.c.a, d.a.q0.a.y0.k.g.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            d.a.q0.v.j.a.a aVar = this.z;
            if (aVar != null) {
                aVar.g();
                this.z = null;
            }
        }
    }
}
