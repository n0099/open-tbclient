package d.a.r.h.f;

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
import d.a.r.g.d.a;
import d.a.r.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1899a f67277d;

    /* renamed from: e  reason: collision with root package name */
    public e f67278e;

    /* renamed from: f  reason: collision with root package name */
    public d f67279f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f67280g;

    /* renamed from: d.a.r.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC1903a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f67281a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f67282b;

        /* renamed from: d.a.r.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1904a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC1903a f67283e;

            public RunnableC1904a(HandlerC1903a handlerC1903a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC1903a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67283e = handlerC1903a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67283e.f67281a.f67302c.get()) {
                    return;
                }
                this.f67283e.f67282b.f67278e.d(64L, 124L);
                this.f67283e.f67282b.f67278e.m();
                this.f67283e.f67282b.i();
                this.f67283e.f67281a.f67302c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1903a(a aVar, Looper looper, d dVar) {
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
            this.f67282b = aVar;
            this.f67281a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f67282b.f67245b.f67252d.submit(new RunnableC1904a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f67284e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f67285f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f67286g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f67287h;

        /* renamed from: d.a.r.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1905a extends f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67288a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f67289b;

            /* renamed from: d.a.r.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC1906a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f67290e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f67291f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f67292g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ C1905a f67293h;

                public RunnableC1906a(C1905a c1905a, long j, boolean z, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1905a, Long.valueOf(j), Boolean.valueOf(z), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67293h = c1905a;
                    this.f67290e = j;
                    this.f67291f = z;
                    this.f67292g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f67293h.f67289b.f67287h.f67278e.i(this.f67290e - this.f67293h.f67288a);
                        this.f67293h.f67289b.f67287h.f67278e.d(this.f67291f ? 1L : 2L, 3L);
                        this.f67293h.f67289b.f67287h.f67278e.d(16L, 124L);
                        this.f67293h.f67289b.f67287h.f67278e.h(this.f67292g);
                        if (!TextUtils.isEmpty(this.f67292g)) {
                            try {
                                String b2 = d.a.r.h.a.b("A10", new d.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f67292g.getBytes("UTF-8")));
                                this.f67293h.f67289b.f67287h.f67278e.e(b2);
                                this.f67293h.f67289b.f67287h.f67278e.l(b2);
                                this.f67293h.f67289b.f67287h.f67278e.d(32L, 124L);
                            } catch (Exception unused) {
                            }
                        }
                        this.f67293h.f67289b.f67287h.f67278e.m();
                        if (this.f67293h.f67289b.f67286g.f67302c.get()) {
                            return;
                        }
                        this.f67293h.f67289b.f67287h.i();
                        this.f67293h.f67289b.f67286g.f67302c.set(true);
                    }
                }
            }

            public C1905a(b bVar, long j) {
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
                this.f67289b = bVar;
                this.f67288a = j;
            }

            @Override // d.a.r.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                    String oaid = idSupplier.getOAID();
                    this.f67289b.f67284e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f67289b;
                    bVar.f67286g.f67301b = bVar.f67287h.f67245b.f67252d.submit(new RunnableC1906a(this, elapsedRealtime, z, oaid));
                }
            }
        }

        /* renamed from: d.a.r.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1907b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f67294e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f67295f;

            public RunnableC1907b(b bVar, int i2) {
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
                this.f67295f = bVar;
                this.f67294e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f67294e;
                    if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                        if (!this.f67295f.f67286g.f67302c.get()) {
                            this.f67295f.f67286g.f67302c.set(true);
                            this.f67295f.f67287h.i();
                        }
                        this.f67295f.f67284e.removeMessages(0);
                    }
                    this.f67295f.f67287h.f67278e.c(this.f67294e);
                    this.f67295f.f67287h.f67278e.d(8L, 124L);
                    this.f67295f.f67287h.f67278e.m();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f67296e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f67297f;

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
                this.f67297f = bVar;
                this.f67296e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f67297f.f67284e.removeMessages(0);
                    this.f67297f.f67287h.f67278e.j(Log.getStackTraceString(this.f67296e));
                    this.f67297f.f67287h.f67278e.m();
                    if (this.f67297f.f67286g.f67302c.get()) {
                        return;
                    }
                    this.f67297f.f67286g.f67302c.set(true);
                    this.f67297f.f67287h.i();
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
            this.f67287h = aVar;
            this.f67284e = handler;
            this.f67285f = context;
            this.f67286g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67284e.sendEmptyMessageDelayed(0, 50000L);
                try {
                    int InitSdk = new MdidSdk().InitSdk(this.f67285f, new C1905a(this, SystemClock.elapsedRealtime()));
                    this.f67286g.f67300a = this.f67287h.f67245b.f67252d.submit(new RunnableC1907b(this, InitSdk));
                } catch (Throwable th) {
                    this.f67287h.f67245b.f67252d.submit(new c(this, th));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f67298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67299f;

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
            this.f67299f = aVar;
            this.f67298e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67299f.f67279f.f67302c.get()) {
                    this.f67299f.j(this.f67298e);
                } else {
                    this.f67299f.f67280g.add(this.f67298e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f67300a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f67301b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f67302c;

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
            this.f67302c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes8.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f67303a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67304b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.r.g.c.a.e f67305c;

        /* renamed from: d  reason: collision with root package name */
        public String f67306d;

        /* renamed from: e  reason: collision with root package name */
        public int f67307e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f67308f;

        /* renamed from: g  reason: collision with root package name */
        public long f67309g;

        /* renamed from: h  reason: collision with root package name */
        public String f67310h;

        /* renamed from: i  reason: collision with root package name */
        public String f67311i;
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
            this.f67304b = true;
            this.f67305c = new d.a.r.g.c.a.e();
            this.f67308f = new ArrayList<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67306d : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f67307e == i2) {
                return;
            }
            this.f67307e = i2;
            this.f67304b = true;
        }

        public void d(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f67305c.c(j, j2)) {
                this.f67304b = true;
            }
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f67306d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67306d = str;
                this.f67304b = true;
            }
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67303a : invokeV.longValue;
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || this.f67303a == j) {
                return;
            }
            this.f67303a = j;
            this.f67304b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f67310h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67310h = str;
                this.f67304b = true;
            }
        }

        public void i(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048583, this, j) == null) || this.f67309g == j) {
                return;
            }
            this.f67309g = j;
            this.f67304b = true;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f67311i == str) {
                return;
            }
            if (str == null || !str.equals(this.f67310h)) {
                this.f67311i = str;
                this.f67304b = true;
            }
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String g2 = this.j.f67277d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f67306d = jSONObject.optString("form_id");
                        this.f67303a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f67305c.b(jSONObject.getLong("flags"));
                        this.f67307e = jSONObject.optInt("init_res");
                        this.f67309g = jSONObject.optLong("acquire_ts_cost");
                        this.f67310h = jSONObject.optString("oid");
                        this.f67308f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f67308f.clear();
                                    return false;
                                }
                                this.f67308f.add(string);
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
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f67308f.contains(str)) {
                return;
            }
            this.f67308f.add(str);
            this.f67304b = true;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f67304b) {
                    try {
                        this.j.f67277d.i("cache.dat", n().toString(), true);
                        this.f67304b = false;
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
                    jSONObject.put("form_id", this.f67306d);
                    jSONObject.put("lst_fe_ts", this.f67303a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f67305c.d());
                    jSONObject.put("init_res", this.f67307e);
                    jSONObject.put("acquire_ts_cost", this.f67309g);
                    jSONObject.put("oid", this.f67310h);
                    int size = this.f67308f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f67308f.get((size - min) + i2));
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
        this.f67278e = new e(this);
        this.f67280g = new ArrayList();
    }

    @Override // d.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67278e.b() : (String) invokeV.objValue;
    }

    @Override // d.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f67277d = this.f67244a.f(e());
            Context context = this.f67245b.f67249a;
            d dVar = new d(this);
            this.f67279f = dVar;
            this.f67278e.k();
            long currentTimeMillis = System.currentTimeMillis();
            if (!cVar.f67254a && Math.abs(currentTimeMillis - this.f67278e.f()) <= 604800000) {
                dVar.f67302c.set(true);
                return;
            }
            this.f67278e.g(currentTimeMillis);
            this.f67278e.d(4L, 124L);
            this.f67278e.i(0L);
            this.f67278e.m();
            this.f67245b.f67253e.submit(new b(this, new HandlerC1903a(this, Looper.getMainLooper(), dVar), context, dVar));
        }
    }

    @Override // d.a.r.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f67245b.f67252d.submit(new c(this, dVar));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f67280g) {
                j(dVar);
            }
            this.f67280g.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f67278e.b())) {
                dVar.b(this.f67278e.f67307e, null, bundle);
            } else {
                dVar.a(this.f67278e.b(), bundle);
            }
        }
    }
}
