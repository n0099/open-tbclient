package d.o.b.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.open.activity.AssistActivity;
import com.yy.open.activity.BridgeActivity;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<c> f72669a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f72670b;

    /* renamed from: c  reason: collision with root package name */
    public Context f72671c;

    /* renamed from: d  reason: collision with root package name */
    public String f72672d;

    /* renamed from: e  reason: collision with root package name */
    public d.o.b.g.a f72673e;

    /* renamed from: d.o.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC2051a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f72674e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.b.b f72675f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Intent f72676g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f72677h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f72678i;

        public RunnableC2051a(a aVar, int i2, d.o.b.b bVar, Intent intent, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), bVar, intent, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72678i = aVar;
            this.f72674e = i2;
            this.f72675f = bVar;
            this.f72676g = intent;
            this.f72677h = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f72674e == 0) {
                        this.f72675f.onCancel();
                        return;
                    }
                    String stringExtra = this.f72676g.getStringExtra("resjson");
                    this.f72678i.f72673e.a(stringExtra);
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    if (jSONObject.has("resCode") && jSONObject.has("resMsg")) {
                        String optString = jSONObject.optString("resMsg");
                        int optInt = jSONObject.optInt("resCode");
                        if (optInt != 1000006 && optInt != 1290001) {
                            optInt = this.f72674e;
                            this.f72678i.f(this.f72676g, this.f72675f, this.f72677h, optInt, optString);
                            return;
                        }
                        Log.e("chenqiang", "resCode:" + optInt);
                        this.f72678i.f(this.f72676g, this.f72675f, this.f72677h, optInt, optString);
                        return;
                    }
                    Log.e("chenqiang", "please update yy new version！");
                    if (jSONObject.has("openid") && jSONObject.has("access_code")) {
                        i2 = this.f72674e;
                        str = "success";
                    } else {
                        str = "handleAuthLoginResult--default error!";
                        i2 = 444222199;
                    }
                    this.f72678i.f(this.f72676g, this.f72675f, this.f72677h, i2, str);
                } catch (Exception unused) {
                    this.f72675f.onError(new d.o.b.d(444222105, d.h(444222105)));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.o.b.b f72679e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.b.d f72680f;

        public b(a aVar, d.o.b.b bVar, d.o.b.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72679e = bVar;
            this.f72680f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72679e.onError(this.f72680f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.o.b.b f72681a;

        /* renamed from: b  reason: collision with root package name */
        public long f72682b;

        public c(a aVar, d.o.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72681a = bVar;
            this.f72682b = System.currentTimeMillis();
        }
    }

    public a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72673e = d.o.b.g.a.b();
        this.f72671c = context;
        this.f72672d = str;
        this.f72669a = new SparseArray<>();
        this.f72670b = new Handler(Looper.getMainLooper());
    }

    public final void c(Activity activity, String str, d.o.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, bVar) == null) {
            if (d.o.b.f.c.d(activity, BridgeActivity.class) && d.o.b.f.c.d(activity, AssistActivity.class)) {
                int a2 = d.a(activity);
                if (a2 != 0) {
                    try {
                        this.f72669a.put(62345, new c(this, bVar));
                        String c2 = d.c(this.f72671c, this.f72672d, str, true);
                        Intent intent = new Intent(activity, AssistActivity.class);
                        intent.putExtra("type", AssistActivity.TYPE_WEB);
                        intent.putExtra("url", c2);
                        activity.startActivityForResult(intent, 62345);
                        return;
                    } catch (Exception unused) {
                        g(new d.o.b.d(a2), bVar);
                        return;
                    }
                }
                Intent e2 = d.e(activity);
                this.f72669a.put(62345, new c(this, bVar));
                Bundle d2 = d.d(activity, this.f72672d);
                e2.putExtra("action", "action_login");
                e2.putExtra("bundle", d2);
                i(activity, e2, 62345);
                return;
            }
            g(new d.o.b.d(3), bVar);
        }
    }

    public final boolean d(int i2, int i3, Intent intent, d.o.b.b bVar) {
        InterceptResult invokeCommon;
        long currentTimeMillis;
        d.o.b.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent, bVar})) == null) {
            if (i2 == 62345 || i2 == 62347) {
                c cVar = this.f72669a.get(i2);
                if (cVar != null) {
                    currentTimeMillis = cVar.f72682b;
                    bVar2 = cVar.f72681a;
                    this.f72669a.remove(i2);
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                    bVar2 = bVar;
                }
                if (i2 == 62345) {
                    e(i3, intent, bVar2, currentTimeMillis);
                    return true;
                } else if (i2 == 62347) {
                    h(i3, intent, bVar2, currentTimeMillis);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void e(int i2, Intent intent, d.o.b.b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), intent, bVar, Long.valueOf(j)}) == null) {
            this.f72670b.postDelayed(new RunnableC2051a(this, i2, bVar, intent, j), 10L);
        }
    }

    public final void f(Intent intent, d.o.b.b bVar, long j, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{intent, bVar, Long.valueOf(j), Integer.valueOf(i2), str}) == null) {
            switch (i2) {
                case 1000006:
                    bVar.onError(new d.o.b.d(1000006, str));
                    return;
                case 1290001:
                    bVar.onError(new d.o.b.d(1290001, str));
                    return;
                case 444111001:
                    try {
                        String stringExtra = intent.getStringExtra("resjson");
                        this.f72673e.a(stringExtra);
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        jSONObject.optString("openid");
                        jSONObject.optString("uid");
                        jSONObject.optString("access_code");
                        bVar.onComplete(jSONObject);
                        return;
                    } catch (Exception unused) {
                        bVar.onError(new d.o.b.d(444222105, d.h(444222105)));
                        return;
                    }
                case 444111002:
                    bVar.onCancel();
                    return;
                case 444111003:
                    try {
                        JSONObject jSONObject2 = new JSONObject(intent.getStringExtra("resjson"));
                        if ("1".equals(jSONObject2.optString("appType"))) {
                            jSONObject2.optString("uid");
                        } else {
                            jSONObject2.optString("openid");
                        }
                        bVar.onComplete(jSONObject2);
                        return;
                    } catch (Exception unused2) {
                        bVar.onError(new d.o.b.d(444222105, d.h(444222105)));
                        return;
                    }
                case 444222000:
                    bVar.onError(new d.o.b.d(444222000, str));
                    return;
                case 444222001:
                    bVar.onError(new d.o.b.d(444222001, str));
                    return;
                case 444222002:
                    bVar.onError(new d.o.b.d(444222002, str));
                    return;
                case 444222003:
                    bVar.onError(new d.o.b.d(444222003, str));
                    return;
                case 444222104:
                    bVar.onError(new d.o.b.d(444222104, str));
                    return;
                case 444222105:
                    bVar.onError(new d.o.b.d(444222105, str));
                    return;
                case 444222106:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        bVar.onError(new d.o.b.d(444222106, str));
                        return;
                    } catch (Exception unused3) {
                        bVar.onError(new d.o.b.d(444222105, d.h(444222105)));
                        return;
                    }
                case 444222108:
                    try {
                        bVar.onComplete(new JSONObject(intent.getStringExtra("resjson")));
                        return;
                    } catch (Exception unused4) {
                        bVar.onError(new d.o.b.d(444222105, d.h(444222105)));
                        return;
                    }
                case 444222110:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        bVar.onError(new d.o.b.d(444222110, str));
                        return;
                    } catch (Exception unused5) {
                        bVar.onError(new d.o.b.d(444222105, d.h(444222105)));
                        return;
                    }
                default:
                    Log.e("chenqiang", "default  error");
                    bVar.onError(new d.o.b.d(i2, d.h(i2)));
                    return;
            }
        }
    }

    public final void g(d.o.b.d dVar, d.o.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, bVar) == null) || bVar == null) {
            return;
        }
        this.f72670b.postDelayed(new b(this, bVar, dVar), 50L);
    }

    public final void h(int i2, Intent intent, d.o.b.b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), intent, bVar, Long.valueOf(j)}) == null) {
        }
    }

    public final void i(Activity activity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, activity, intent, i2) == null) {
            intent.putExtra("request_code", i2);
            Intent intent2 = new Intent(activity.getApplicationContext(), BridgeActivity.class);
            intent2.putExtra("intent", intent);
            activity.startActivityForResult(intent2, i2);
        }
    }
}
