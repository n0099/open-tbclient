package d.a.q0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.h.b.a;
import d.a.q0.h.b.e;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f53059i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f53060a;

    /* renamed from: b  reason: collision with root package name */
    public e f53061b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.h.b.b f53062c;

    /* renamed from: d  reason: collision with root package name */
    public long f53063d;

    /* renamed from: e  reason: collision with root package name */
    public int f53064e;

    /* renamed from: f  reason: collision with root package name */
    public long f53065f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.h.b.c f53066g;

    /* renamed from: h  reason: collision with root package name */
    public e.c f53067h;

    /* loaded from: classes8.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f53068a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53068a = dVar;
        }

        @Override // d.a.q0.h.b.a.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && k.f49133a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // d.a.q0.h.b.a.d
        public void onSuccess() {
            Activity o;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (o = this.f53068a.o()) == null) {
                return;
            }
            d.a.q0.a.z1.b.f.e.f(o, d.a.q0.f.g.aiapps_anti_addiction_success).F();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f53069a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f53070b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f53071c;

        /* loaded from: classes8.dex */
        public class a implements e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f53072a;

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
                this.f53072a = bVar;
            }

            @Override // d.a.q0.h.b.e.c
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f53072a.f53070b.onFail(str);
                }
            }

            @Override // d.a.q0.h.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    f fVar = (f) obj;
                    if (k.f49133a) {
                        Log.d("AntiAddictionManager", fVar.toString());
                    }
                    int i2 = fVar.f53078a;
                    if (i2 == 0) {
                        this.f53072a.f53070b.onSuccess();
                    } else if (1 == i2) {
                        this.f53072a.f53070b.onFail(fVar.f53079b);
                    } else {
                        this.f53072a.f53070b.onFail(fVar.f53079b);
                        if (TextUtils.isEmpty(fVar.f53079b) || (o = this.f53072a.f53071c.o()) == null) {
                            return;
                        }
                        this.f53072a.f53071c.f53066g.f(o, fVar.f53079b, o.getString(d.a.q0.f.g.aiapps_anti_addiction_dialog_ok), true, null);
                    }
                }
            }
        }

        public b(d dVar, String str, a.d dVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53071c = dVar;
            this.f53069a = str;
            this.f53070b = dVar2;
        }

        @Override // d.a.q0.h.b.a.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f53070b.onFail(str);
            }
        }

        @Override // d.a.q0.h.b.a.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.q0.h.b.e.c(this.f53069a, new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f53073e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53073e = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f53073e.r();
            }
        }
    }

    /* renamed from: d.a.q0.h.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1129d implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f53074a;

        public C1129d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53074a = dVar;
        }

        @Override // d.a.q0.h.b.e.c
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && k.f49133a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // d.a.q0.h.b.e.c
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                g gVar = (g) obj;
                if (k.f49133a) {
                    Log.d("AntiAddictionManager", gVar.toString());
                }
                this.f53074a.f53063d = System.currentTimeMillis();
                if (this.f53074a.t(gVar.f53082c)) {
                    this.f53074a.s(gVar.f53083d * 1000);
                    this.f53074a.q(gVar.f53080a, gVar.f53081b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f53075a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53075a = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                removeCallbacksAndMessages(null);
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? hasMessages(1) : invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || 1 == this.f53075a.f53064e) {
                return;
            }
            sendEmptyMessageDelayed(1, this.f53075a.f53065f);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && message.what == 1) {
                this.f53075a.z(false);
                c();
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
        this.f53064e = 0;
        this.f53065f = 300000L;
        this.f53067h = new C1129d(this);
        k();
    }

    public static d p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f53059i == null) {
                synchronized (d.class) {
                    if (f53059i == null) {
                        f53059i = new d();
                    }
                }
            }
            return f53059i;
        }
        return (d) invokeV.objValue;
    }

    public static synchronized void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            synchronized (d.class) {
                if (f53059i != null) {
                    f53059i.m();
                    f53059i = null;
                }
            }
        }
    }

    public void j(String str, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            if (TextUtils.isEmpty(str)) {
                dVar.onFail("orderInfo is null");
            } else if (!u()) {
                dVar.onSuccess();
            } else {
                d.a.q0.h.b.a.b(new b(this, str, dVar));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            z(true);
            y();
            this.f53066g = new d.a.q0.h.b.c();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f53060a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f53060a = handlerThread;
            handlerThread.start();
            this.f53061b = new e(this, this.f53060a.getLooper());
        }
    }

    public final synchronized void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f53061b.a();
                if (this.f53060a != null) {
                    this.f53060a.quitSafely();
                    this.f53060a = null;
                }
                if (this.f53066g != null) {
                    this.f53066g.e();
                    this.f53066g = null;
                }
            }
        }
    }

    public synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (u()) {
                    z(false);
                }
                this.f53061b.a();
            }
        }
    }

    public final Activity o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q == null || Q.x() == null) {
                return null;
            }
            return Q.x();
        }
        return (Activity) invokeV.objValue;
    }

    public final void q(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
            if (i2 < 0) {
                if (k.f49133a) {
                    Log.e("AntiAddictionManager", "server AntiAddiction state error = " + i2 + " msg = " + str);
                }
            } else if (i2 != 0) {
                if (i2 != 1) {
                    v(i2, str);
                    return;
                }
                Activity o = o();
                if (o == null) {
                    return;
                }
                this.f53066g.f(o, o.getString(d.a.q0.f.g.aiapps_anti_addiction_dialog_message), o.getString(d.a.q0.f.g.aiapps_anti_addiction_dialog_auth), true, new c(this));
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.q0.h.b.a.c(new a(this));
        }
    }

    public final void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            if (300000 < j) {
                this.f53065f = j;
            } else {
                this.f53065f = 300000L;
            }
        }
    }

    public final boolean t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.f53064e = i2;
            if (1 == i2) {
                n();
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f53064e == 0 : invokeV.booleanValue;
    }

    public final void v(int i2, String str) {
        d.a.q0.h.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) || (bVar = this.f53062c) == null) {
            return;
        }
        try {
            bVar.y(i2, str);
        } catch (JSONException e2) {
            if (k.f49133a) {
                e2.printStackTrace();
            }
        }
    }

    public void x(d.a.q0.h.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f53062c = bVar;
        }
    }

    public synchronized void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (u() && !this.f53061b.b()) {
                    this.f53063d = System.currentTimeMillis();
                    this.f53061b.c();
                }
            }
        }
    }

    public final void z(boolean z) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                j = 0;
            } else {
                j = System.currentTimeMillis() - this.f53063d;
                if (180000 > j) {
                    return;
                }
            }
            if (k.f49133a) {
                Log.d("AntiAddictionManager", "Request upUseTime");
            }
            d.a.q0.h.b.e.d(j, this.f53067h);
        }
    }
}
