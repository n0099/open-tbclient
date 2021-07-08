package d.a.n0.h.b;

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
import d.a.n0.a.k;
import d.a.n0.h.b.a;
import d.a.n0.h.b.e;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f49757i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f49758a;

    /* renamed from: b  reason: collision with root package name */
    public e f49759b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.h.b.b f49760c;

    /* renamed from: d  reason: collision with root package name */
    public long f49761d;

    /* renamed from: e  reason: collision with root package name */
    public int f49762e;

    /* renamed from: f  reason: collision with root package name */
    public long f49763f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.h.b.c f49764g;

    /* renamed from: h  reason: collision with root package name */
    public e.c f49765h;

    /* loaded from: classes7.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f49766a;

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
            this.f49766a = dVar;
        }

        @Override // d.a.n0.h.b.a.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && k.f45831a) {
                Log.e("AntiAddictionManager", "handleLoginAndRealName: " + str);
            }
        }

        @Override // d.a.n0.h.b.a.d
        public void onSuccess() {
            Activity o;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (o = this.f49766a.o()) == null) {
                return;
            }
            d.a.n0.a.z1.b.f.e.f(o, d.a.n0.f.g.aiapps_anti_addiction_success).F();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49767a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f49768b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f49769c;

        /* loaded from: classes7.dex */
        public class a implements e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f49770a;

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
                this.f49770a = bVar;
            }

            @Override // d.a.n0.h.b.e.c
            public void onFail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f49770a.f49768b.onFail(str);
                }
            }

            @Override // d.a.n0.h.b.e.c
            public void onSuccess(Object obj) {
                Activity o;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    f fVar = (f) obj;
                    if (k.f45831a) {
                        Log.d("AntiAddictionManager", fVar.toString());
                    }
                    int i2 = fVar.f49776a;
                    if (i2 == 0) {
                        this.f49770a.f49768b.onSuccess();
                    } else if (1 == i2) {
                        this.f49770a.f49768b.onFail(fVar.f49777b);
                    } else {
                        this.f49770a.f49768b.onFail(fVar.f49777b);
                        if (TextUtils.isEmpty(fVar.f49777b) || (o = this.f49770a.f49769c.o()) == null) {
                            return;
                        }
                        this.f49770a.f49769c.f49764g.f(o, fVar.f49777b, o.getString(d.a.n0.f.g.aiapps_anti_addiction_dialog_ok), true, null);
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
            this.f49769c = dVar;
            this.f49767a = str;
            this.f49768b = dVar2;
        }

        @Override // d.a.n0.h.b.a.d
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f49768b.onFail(str);
            }
        }

        @Override // d.a.n0.h.b.a.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.n0.h.b.e.c(this.f49767a, new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f49771e;

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
            this.f49771e = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f49771e.r();
            }
        }
    }

    /* renamed from: d.a.n0.h.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1078d implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f49772a;

        public C1078d(d dVar) {
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
            this.f49772a = dVar;
        }

        @Override // d.a.n0.h.b.e.c
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && k.f45831a) {
                Log.e("AntiAddictionManager", str);
            }
        }

        @Override // d.a.n0.h.b.e.c
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                g gVar = (g) obj;
                if (k.f45831a) {
                    Log.d("AntiAddictionManager", gVar.toString());
                }
                this.f49772a.f49761d = System.currentTimeMillis();
                if (this.f49772a.t(gVar.f49780c)) {
                    this.f49772a.s(gVar.f49781d * 1000);
                    this.f49772a.q(gVar.f49778a, gVar.f49779b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f49773a;

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
            this.f49773a = dVar;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || 1 == this.f49773a.f49762e) {
                return;
            }
            sendEmptyMessageDelayed(1, this.f49773a.f49763f);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && message.what == 1) {
                this.f49773a.z(false);
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
        this.f49762e = 0;
        this.f49763f = 300000L;
        this.f49765h = new C1078d(this);
        k();
    }

    public static d p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f49757i == null) {
                synchronized (d.class) {
                    if (f49757i == null) {
                        f49757i = new d();
                    }
                }
            }
            return f49757i;
        }
        return (d) invokeV.objValue;
    }

    public static synchronized void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            synchronized (d.class) {
                if (f49757i != null) {
                    f49757i.m();
                    f49757i = null;
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
                d.a.n0.h.b.a.b(new b(this, str, dVar));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            z(true);
            y();
            this.f49764g = new d.a.n0.h.b.c();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f49758a == null) {
            HandlerThread handlerThread = new HandlerThread("anti_addiction_monitor");
            this.f49758a = handlerThread;
            handlerThread.start();
            this.f49759b = new e(this, this.f49758a.getLooper());
        }
    }

    public final synchronized void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f49759b.a();
                if (this.f49758a != null) {
                    this.f49758a.quitSafely();
                    this.f49758a = null;
                }
                if (this.f49764g != null) {
                    this.f49764g.e();
                    this.f49764g = null;
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
                this.f49759b.a();
            }
        }
    }

    public final Activity o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
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
                if (k.f45831a) {
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
                this.f49764g.f(o, o.getString(d.a.n0.f.g.aiapps_anti_addiction_dialog_message), o.getString(d.a.n0.f.g.aiapps_anti_addiction_dialog_auth), true, new c(this));
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.n0.h.b.a.c(new a(this));
        }
    }

    public final void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            if (300000 < j) {
                this.f49763f = j;
            } else {
                this.f49763f = 300000L;
            }
        }
    }

    public final boolean t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.f49762e = i2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f49762e == 0 : invokeV.booleanValue;
    }

    public final void v(int i2, String str) {
        d.a.n0.h.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) || (bVar = this.f49760c) == null) {
            return;
        }
        try {
            bVar.y(i2, str);
        } catch (JSONException e2) {
            if (k.f45831a) {
                e2.printStackTrace();
            }
        }
    }

    public void x(d.a.n0.h.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f49760c = bVar;
        }
    }

    public synchronized void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (u() && !this.f49759b.b()) {
                    this.f49761d = System.currentTimeMillis();
                    this.f49759b.c();
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
                j = System.currentTimeMillis() - this.f49761d;
                if (180000 > j) {
                    return;
                }
            }
            if (k.f45831a) {
                Log.d("AntiAddictionManager", "Request upUseTime");
            }
            d.a.n0.h.b.e.d(j, this.f49765h);
        }
    }
}
