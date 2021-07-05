package d.a.t.h.f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.core.MdidSdk;
import com.bun.miitmdid.supplier.IdSupplier;
import d.a.t.g.d.a;
import d.a.t.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d.a.t.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1937a f70419d;

    /* renamed from: e  reason: collision with root package name */
    public e f70420e;

    /* renamed from: f  reason: collision with root package name */
    public d f70421f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f70422g;

    /* renamed from: d.a.t.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class HandlerC1941a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f70423a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f70424b;

        /* renamed from: d.a.t.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1942a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC1941a f70425e;

            public RunnableC1942a(HandlerC1941a handlerC1941a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC1941a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70425e = handlerC1941a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f70425e.f70423a.f70444c.get()) {
                    return;
                }
                this.f70425e.f70424b.f70420e.d(64L, 124L);
                this.f70425e.f70424b.f70420e.m();
                this.f70425e.f70424b.i();
                this.f70425e.f70423a.f70444c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1941a(a aVar, Looper looper, d dVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper, dVar};
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
            this.f70424b = aVar;
            this.f70423a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f70424b.f70387b.f70394d.submit(new RunnableC1942a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f70426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f70427f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f70428g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f70429h;

        /* renamed from: d.a.t.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1943a extends f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f70430a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f70431b;

            /* renamed from: d.a.t.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class RunnableC1944a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f70432e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f70433f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f70434g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ C1943a f70435h;

                public RunnableC1944a(C1943a c1943a, long j, boolean z, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1943a, Long.valueOf(j), Boolean.valueOf(z), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f70435h = c1943a;
                    this.f70432e = j;
                    this.f70433f = z;
                    this.f70434g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f70435h.f70431b.f70429h.f70420e.i(this.f70432e - this.f70435h.f70430a);
                        this.f70435h.f70431b.f70429h.f70420e.d(this.f70433f ? 1L : 2L, 3L);
                        this.f70435h.f70431b.f70429h.f70420e.d(16L, 124L);
                        this.f70435h.f70431b.f70429h.f70420e.h(this.f70434g);
                        if (!TextUtils.isEmpty(this.f70434g)) {
                            try {
                                String b2 = d.a.t.h.a.b("A10", new d.a.t.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f70434g.getBytes("UTF-8")));
                                this.f70435h.f70431b.f70429h.f70420e.e(b2);
                                this.f70435h.f70431b.f70429h.f70420e.l(b2);
                                this.f70435h.f70431b.f70429h.f70420e.d(32L, 124L);
                            } catch (Exception unused) {
                            }
                        }
                        this.f70435h.f70431b.f70429h.f70420e.m();
                        if (this.f70435h.f70431b.f70428g.f70444c.get()) {
                            return;
                        }
                        this.f70435h.f70431b.f70429h.i();
                        this.f70435h.f70431b.f70428g.f70444c.set(true);
                    }
                }
            }

            public C1943a(b bVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70431b = bVar;
                this.f70430a = j;
            }

            @Override // d.a.t.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                    String oaid = idSupplier.getOAID();
                    this.f70431b.f70426e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f70431b;
                    bVar.f70428g.f70443b = bVar.f70429h.f70387b.f70394d.submit(new RunnableC1944a(this, elapsedRealtime, z, oaid));
                }
            }
        }

        /* renamed from: d.a.t.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1945b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f70436e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f70437f;

            public RunnableC1945b(b bVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70437f = bVar;
                this.f70436e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f70436e;
                    if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                        if (!this.f70437f.f70428g.f70444c.get()) {
                            this.f70437f.f70428g.f70444c.set(true);
                            this.f70437f.f70429h.i();
                        }
                        this.f70437f.f70426e.removeMessages(0);
                    }
                    this.f70437f.f70429h.f70420e.c(this.f70436e);
                    this.f70437f.f70429h.f70420e.d(8L, 124L);
                    this.f70437f.f70429h.f70420e.m();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f70438e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f70439f;

            public c(b bVar, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70439f = bVar;
                this.f70438e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f70439f.f70426e.removeMessages(0);
                    this.f70439f.f70429h.f70420e.j(Log.getStackTraceString(this.f70438e));
                    this.f70439f.f70429h.f70420e.m();
                    if (this.f70439f.f70428g.f70444c.get()) {
                        return;
                    }
                    this.f70439f.f70428g.f70444c.set(true);
                    this.f70439f.f70429h.i();
                }
            }
        }

        public b(a aVar, Handler handler, Context context, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, handler, context, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70429h = aVar;
            this.f70426e = handler;
            this.f70427f = context;
            this.f70428g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70426e.sendEmptyMessageDelayed(0, 50000L);
                try {
                    int InitSdk = new MdidSdk().InitSdk(this.f70427f, new C1943a(this, SystemClock.elapsedRealtime()));
                    this.f70428g.f70442a = this.f70429h.f70387b.f70394d.submit(new RunnableC1945b(this, InitSdk));
                } catch (Throwable th) {
                    this.f70429h.f70387b.f70394d.submit(new c(this, th));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f70440e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f70441f;

        public c(a aVar, a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70441f = aVar;
            this.f70440e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70441f.f70421f.f70444c.get()) {
                    this.f70441f.j(this.f70440e);
                } else {
                    this.f70441f.f70422g.add(this.f70440e);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f70442a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f70443b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f70444c;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70444c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes9.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f70445a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f70446b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.t.g.c.a.e f70447c;

        /* renamed from: d  reason: collision with root package name */
        public String f70448d;

        /* renamed from: e  reason: collision with root package name */
        public int f70449e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f70450f;

        /* renamed from: g  reason: collision with root package name */
        public long f70451g;

        /* renamed from: h  reason: collision with root package name */
        public String f70452h;

        /* renamed from: i  reason: collision with root package name */
        public String f70453i;
        public final /* synthetic */ a j;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = aVar;
            this.f70446b = true;
            this.f70447c = new d.a.t.g.c.a.e();
            this.f70450f = new ArrayList<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70448d : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f70449e == i2) {
                return;
            }
            this.f70449e = i2;
            this.f70446b = true;
        }

        public void d(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f70447c.c(j, j2)) {
                this.f70446b = true;
            }
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f70448d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f70448d = str;
                this.f70446b = true;
            }
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f70445a : invokeV.longValue;
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || this.f70445a == j) {
                return;
            }
            this.f70445a = j;
            this.f70446b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f70452h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f70452h = str;
                this.f70446b = true;
            }
        }

        public void i(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048583, this, j) == null) || this.f70451g == j) {
                return;
            }
            this.f70451g = j;
            this.f70446b = true;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f70453i == str) {
                return;
            }
            if (str == null || !str.equals(this.f70452h)) {
                this.f70453i = str;
                this.f70446b = true;
            }
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String g2 = this.j.f70419d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f70448d = jSONObject.optString("form_id");
                        this.f70445a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f70447c.b(jSONObject.getLong("flags"));
                        this.f70449e = jSONObject.optInt("init_res");
                        this.f70451g = jSONObject.optLong("acquire_ts_cost");
                        this.f70452h = jSONObject.optString("oid");
                        this.f70450f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f70450f.clear();
                                    return false;
                                }
                                this.f70450f.add(string);
                            }
                        }
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void l(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f70450f.contains(str)) {
                return;
            }
            this.f70450f.add(str);
            this.f70446b = true;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f70446b) {
                    try {
                        this.j.f70419d.i("cache.dat", n().toString(), true);
                        this.f70446b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final JSONObject n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("form_id", this.f70448d);
                    jSONObject.put("lst_fe_ts", this.f70445a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f70447c.d());
                    jSONObject.put("init_res", this.f70449e);
                    jSONObject.put("acquire_ts_cost", this.f70451g);
                    jSONObject.put("oid", this.f70452h);
                    int size = this.f70450f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f70450f.get((size - min) + i2));
                        }
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class f implements IIdentifierListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        @Override // com.bun.miitmdid.core.IIdentifierListener
        public void OnSupport(boolean z, IdSupplier idSupplier) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                a(z, idSupplier);
            }
        }

        public abstract void a(boolean z, IdSupplier idSupplier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("oid");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70420e = new e(this);
        this.f70422g = new ArrayList();
    }

    @Override // d.a.t.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70420e.b() : (String) invokeV.objValue;
    }

    @Override // d.a.t.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f70419d = this.f70386a.f(e());
            Context context = this.f70387b.f70391a;
            d dVar = new d(this);
            this.f70421f = dVar;
            this.f70420e.k();
            long currentTimeMillis = System.currentTimeMillis();
            if (!cVar.f70396a && Math.abs(currentTimeMillis - this.f70420e.f()) <= 604800000) {
                dVar.f70444c.set(true);
                return;
            }
            this.f70420e.g(currentTimeMillis);
            this.f70420e.d(4L, 124L);
            this.f70420e.i(0L);
            this.f70420e.m();
            this.f70387b.f70395e.submit(new b(this, new HandlerC1941a(this, Looper.getMainLooper(), dVar), context, dVar));
        }
    }

    @Override // d.a.t.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f70387b.f70394d.submit(new c(this, dVar));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f70422g) {
                j(dVar);
            }
            this.f70422g.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f70420e.b())) {
                dVar.b(this.f70420e.f70449e, null, bundle);
            } else {
                dVar.a(this.f70420e.b(), bundle);
            }
        }
    }
}
