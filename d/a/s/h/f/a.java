package d.a.s.h.f;

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
import d.a.s.g.d.a;
import d.a.s.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.s.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1904a f67955d;

    /* renamed from: e  reason: collision with root package name */
    public e f67956e;

    /* renamed from: f  reason: collision with root package name */
    public d f67957f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f67958g;

    /* renamed from: d.a.s.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC1908a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f67959a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f67960b;

        /* renamed from: d.a.s.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1909a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC1908a f67961e;

            public RunnableC1909a(HandlerC1908a handlerC1908a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC1908a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67961e = handlerC1908a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67961e.f67959a.f67980c.get()) {
                    return;
                }
                this.f67961e.f67960b.f67956e.d(64L, 124L);
                this.f67961e.f67960b.f67956e.m();
                this.f67961e.f67960b.i();
                this.f67961e.f67959a.f67980c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1908a(a aVar, Looper looper, d dVar) {
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
            this.f67960b = aVar;
            this.f67959a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f67960b.f67923b.f67930d.submit(new RunnableC1909a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f67962e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f67963f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f67964g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f67965h;

        /* renamed from: d.a.s.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1910a extends f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67966a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f67967b;

            /* renamed from: d.a.s.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC1911a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f67968e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f67969f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f67970g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ C1910a f67971h;

                public RunnableC1911a(C1910a c1910a, long j, boolean z, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1910a, Long.valueOf(j), Boolean.valueOf(z), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67971h = c1910a;
                    this.f67968e = j;
                    this.f67969f = z;
                    this.f67970g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f67971h.f67967b.f67965h.f67956e.i(this.f67968e - this.f67971h.f67966a);
                        this.f67971h.f67967b.f67965h.f67956e.d(this.f67969f ? 1L : 2L, 3L);
                        this.f67971h.f67967b.f67965h.f67956e.d(16L, 124L);
                        this.f67971h.f67967b.f67965h.f67956e.h(this.f67970g);
                        if (!TextUtils.isEmpty(this.f67970g)) {
                            try {
                                String b2 = d.a.s.h.a.b("A10", new d.a.s.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f67970g.getBytes("UTF-8")));
                                this.f67971h.f67967b.f67965h.f67956e.e(b2);
                                this.f67971h.f67967b.f67965h.f67956e.l(b2);
                                this.f67971h.f67967b.f67965h.f67956e.d(32L, 124L);
                            } catch (Exception unused) {
                            }
                        }
                        this.f67971h.f67967b.f67965h.f67956e.m();
                        if (this.f67971h.f67967b.f67964g.f67980c.get()) {
                            return;
                        }
                        this.f67971h.f67967b.f67965h.i();
                        this.f67971h.f67967b.f67964g.f67980c.set(true);
                    }
                }
            }

            public C1910a(b bVar, long j) {
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
                this.f67967b = bVar;
                this.f67966a = j;
            }

            @Override // d.a.s.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                    String oaid = idSupplier.getOAID();
                    this.f67967b.f67962e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f67967b;
                    bVar.f67964g.f67979b = bVar.f67965h.f67923b.f67930d.submit(new RunnableC1911a(this, elapsedRealtime, z, oaid));
                }
            }
        }

        /* renamed from: d.a.s.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1912b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f67972e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f67973f;

            public RunnableC1912b(b bVar, int i2) {
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
                this.f67973f = bVar;
                this.f67972e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f67972e;
                    if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                        if (!this.f67973f.f67964g.f67980c.get()) {
                            this.f67973f.f67964g.f67980c.set(true);
                            this.f67973f.f67965h.i();
                        }
                        this.f67973f.f67962e.removeMessages(0);
                    }
                    this.f67973f.f67965h.f67956e.c(this.f67972e);
                    this.f67973f.f67965h.f67956e.d(8L, 124L);
                    this.f67973f.f67965h.f67956e.m();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f67974e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f67975f;

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
                this.f67975f = bVar;
                this.f67974e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f67975f.f67962e.removeMessages(0);
                    this.f67975f.f67965h.f67956e.j(Log.getStackTraceString(this.f67974e));
                    this.f67975f.f67965h.f67956e.m();
                    if (this.f67975f.f67964g.f67980c.get()) {
                        return;
                    }
                    this.f67975f.f67964g.f67980c.set(true);
                    this.f67975f.f67965h.i();
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
            this.f67965h = aVar;
            this.f67962e = handler;
            this.f67963f = context;
            this.f67964g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67962e.sendEmptyMessageDelayed(0, 50000L);
                try {
                    int InitSdk = new MdidSdk().InitSdk(this.f67963f, new C1910a(this, SystemClock.elapsedRealtime()));
                    this.f67964g.f67978a = this.f67965h.f67923b.f67930d.submit(new RunnableC1912b(this, InitSdk));
                } catch (Throwable th) {
                    this.f67965h.f67923b.f67930d.submit(new c(this, th));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f67976e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67977f;

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
            this.f67977f = aVar;
            this.f67976e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67977f.f67957f.f67980c.get()) {
                    this.f67977f.j(this.f67976e);
                } else {
                    this.f67977f.f67958g.add(this.f67976e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f67978a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f67979b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f67980c;

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
            this.f67980c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes8.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f67981a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67982b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.s.g.c.a.e f67983c;

        /* renamed from: d  reason: collision with root package name */
        public String f67984d;

        /* renamed from: e  reason: collision with root package name */
        public int f67985e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f67986f;

        /* renamed from: g  reason: collision with root package name */
        public long f67987g;

        /* renamed from: h  reason: collision with root package name */
        public String f67988h;

        /* renamed from: i  reason: collision with root package name */
        public String f67989i;
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
            this.f67982b = true;
            this.f67983c = new d.a.s.g.c.a.e();
            this.f67986f = new ArrayList<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67984d : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f67985e == i2) {
                return;
            }
            this.f67985e = i2;
            this.f67982b = true;
        }

        public void d(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f67983c.c(j, j2)) {
                this.f67982b = true;
            }
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f67984d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67984d = str;
                this.f67982b = true;
            }
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67981a : invokeV.longValue;
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || this.f67981a == j) {
                return;
            }
            this.f67981a = j;
            this.f67982b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f67988h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67988h = str;
                this.f67982b = true;
            }
        }

        public void i(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048583, this, j) == null) || this.f67987g == j) {
                return;
            }
            this.f67987g = j;
            this.f67982b = true;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f67989i == str) {
                return;
            }
            if (str == null || !str.equals(this.f67988h)) {
                this.f67989i = str;
                this.f67982b = true;
            }
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String g2 = this.j.f67955d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f67984d = jSONObject.optString("form_id");
                        this.f67981a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f67983c.b(jSONObject.getLong("flags"));
                        this.f67985e = jSONObject.optInt("init_res");
                        this.f67987g = jSONObject.optLong("acquire_ts_cost");
                        this.f67988h = jSONObject.optString("oid");
                        this.f67986f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f67986f.clear();
                                    return false;
                                }
                                this.f67986f.add(string);
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
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f67986f.contains(str)) {
                return;
            }
            this.f67986f.add(str);
            this.f67982b = true;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f67982b) {
                    try {
                        this.j.f67955d.i("cache.dat", n().toString(), true);
                        this.f67982b = false;
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
                    jSONObject.put("form_id", this.f67984d);
                    jSONObject.put("lst_fe_ts", this.f67981a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f67983c.d());
                    jSONObject.put("init_res", this.f67985e);
                    jSONObject.put("acquire_ts_cost", this.f67987g);
                    jSONObject.put("oid", this.f67988h);
                    int size = this.f67986f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f67986f.get((size - min) + i2));
                        }
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
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
        this.f67956e = new e(this);
        this.f67958g = new ArrayList();
    }

    @Override // d.a.s.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67956e.b() : (String) invokeV.objValue;
    }

    @Override // d.a.s.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f67955d = this.f67922a.f(e());
            Context context = this.f67923b.f67927a;
            d dVar = new d(this);
            this.f67957f = dVar;
            this.f67956e.k();
            long currentTimeMillis = System.currentTimeMillis();
            if (!cVar.f67932a && Math.abs(currentTimeMillis - this.f67956e.f()) <= 604800000) {
                dVar.f67980c.set(true);
                return;
            }
            this.f67956e.g(currentTimeMillis);
            this.f67956e.d(4L, 124L);
            this.f67956e.i(0L);
            this.f67956e.m();
            this.f67923b.f67931e.submit(new b(this, new HandlerC1908a(this, Looper.getMainLooper(), dVar), context, dVar));
        }
    }

    @Override // d.a.s.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f67923b.f67930d.submit(new c(this, dVar));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f67958g) {
                j(dVar);
            }
            this.f67958g.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f67956e.b())) {
                dVar.b(this.f67956e.f67985e, null, bundle);
            } else {
                dVar.a(this.f67956e.b(), bundle);
            }
        }
    }
}
