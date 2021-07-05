package d.a.z0.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f71614c = "UnionIDHelper";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f71615d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f71616e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f71617f;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f71618g;

    /* renamed from: h  reason: collision with root package name */
    public static e f71619h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile d.a.z0.e.f.c f71620a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f71621b;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f71622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f71623f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f71624g;

        public a(e eVar, Context context, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71624g = eVar;
            this.f71622e = context;
            this.f71623f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e.f71615d) {
                    Log.d(e.f71614c, "asyncRequest, Thread runn！");
                }
                d.a.z0.e.f.a m = this.f71624g.m(this.f71622e);
                if (e.f71615d) {
                    String str = e.f71614c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("asyncRequest, cachedBean == null ？");
                    sb.append(m == null);
                    Log.d(str, sb.toString());
                }
                if (m == null || this.f71624g.q(m)) {
                    if (e.f71615d) {
                        Log.d(e.f71614c, "asyncRequest, requestFromManufacturer");
                    }
                    this.f71624g.r();
                    if (e.f71615d) {
                        Log.d(e.f71614c, "asyncRequest, trySaveFiles！");
                    }
                    this.f71624g.f71621b.set(this.f71624g.t(this.f71622e));
                    if (e.f71615d) {
                        Log.d(e.f71614c, "asyncRequest, trySaveFiles done");
                    }
                }
                if (e.f71615d) {
                    Log.d(e.f71614c, "asyncRequest, send  innerHandler message");
                }
                this.f71623f.obtainMessage(100, this.f71624g.f71620a).sendToTarget();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.z0.e.f.b f71625a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, d.a.z0.e.f.b bVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, bVar};
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
            this.f71625a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                d.a.z0.e.f.c cVar = (d.a.z0.e.f.c) message.obj;
                if (e.f71615d) {
                    String str = e.f71614c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("handleMessage ，what：");
                    sb.append(cVar == null ? "" : cVar.getOAID());
                    Log.d(str, sb.toString());
                }
                d.a.z0.e.f.b bVar = this.f71625a;
                if (bVar != null) {
                    bVar.a(cVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(372887156, "Ld/a/z0/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(372887156, "Ld/a/z0/e/e;");
                return;
            }
        }
        f71615d = d.a.z0.e.a.e();
        f71616e = j(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
        f71617f = j(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
        f71618g = new Object();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new AtomicBoolean(false);
        this.f71621b = new AtomicBoolean(false);
    }

    public static String j(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr2 : bArr) {
                sb.append(new String(d.a.z0.e.h.c.a(bArr2)));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(d.a.z0.e.h.a.a(f71616e, f71617f, d.a.z0.e.h.c.a(str.getBytes())));
            } catch (Exception e2) {
                if (f71615d) {
                    String str2 = f71614c;
                    Log.d(str2, "getCacheObject ，decryptUnionID：" + e2.getMessage());
                    return "";
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return d.a.z0.e.h.c.c(d.a.z0.e.h.a.b(f71616e, f71617f, str.getBytes()), "utf-8");
            } catch (UnsupportedEncodingException | Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static e o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f71619h == null) {
                synchronized (e.class) {
                    if (f71619h == null) {
                        f71619h = new e();
                    }
                }
            }
            return f71619h;
        }
        return (e) invokeV.objValue;
    }

    public synchronized void i(Context context, @NonNull Looper looper, @Nullable d.a.z0.e.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, looper, bVar) == null) {
            synchronized (this) {
                if (looper != null) {
                    b bVar2 = new b(looper, bVar);
                    if (p()) {
                        bVar2.obtainMessage(100, null).sendToTarget();
                        return;
                    }
                    if (this.f71620a != null && this.f71621b.get()) {
                        if (f71615d) {
                            String str = f71614c;
                            Log.d(str, "asyncRequest, mIUnionId.getOAID：" + this.f71620a.getOAID());
                            String str2 = f71614c;
                            Log.d(str2, "asyncRequest, mIUnionId.isTrackLimited：" + this.f71620a.c());
                            String str3 = f71614c;
                            Log.d(str3, "asyncRequest, mIUnionId.getStatusCode：" + this.f71620a.getStatusCode());
                        }
                        bVar2.obtainMessage(100, this.f71620a).sendToTarget();
                    } else {
                        if (!this.f71621b.get()) {
                            this.f71620a = new c(context).f71610a;
                        }
                        new Thread(new a(this, context, bVar2)).start();
                    }
                    return;
                }
                throw new NullPointerException("param looper not null");
            }
        }
    }

    public final d.a.z0.e.f.a m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
            if (!file.exists()) {
                if (f71615d) {
                    Log.d(f71614c, "getCacheObject dir 不存在 , 首次需要创建");
                }
                return null;
            }
            File file2 = new File(file, ".bd_un_info.so");
            if (!file2.exists()) {
                if (f71615d) {
                    Log.d(f71614c, "getCacheObject  file 不存在, 首次需要创建");
                }
                return null;
            }
            String a2 = d.a.z0.e.h.e.a(file2, f71618g);
            if (f71615d) {
                String str = f71614c;
                Log.d(str, "getCacheObject ，content：" + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String k = k(a2);
            if (f71615d) {
                String str2 = f71614c;
                Log.d(str2, "getCacheObject ，json：" + k);
            }
            try {
                JSONObject jSONObject = new JSONObject(k);
                d.a.z0.e.f.a aVar = new d.a.z0.e.f.a();
                s(aVar, jSONObject);
                return aVar;
            } catch (Exception e2) {
                if (f71615d) {
                    String str3 = f71614c;
                    Log.d(str3, "getCacheObject , " + e2.getMessage());
                }
                return null;
            }
        }
        return (d.a.z0.e.f.a) invokeL.objValue;
    }

    public final long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.z0.e.a.a(d.a.z0.e.b.a()) * 60 * 1000 : invokeV.longValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.z0.e.a.d(d.a.z0.e.b.a()) : invokeV.booleanValue;
    }

    public final boolean q(@NonNull d.a.z0.e.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (Math.abs(System.currentTimeMillis() - aVar.f71626a) > n()) {
                if (f71615d) {
                    Log.d(f71614c, "isExpireTime ：超过缓存有效期");
                    return true;
                }
                return true;
            } else if (f71615d) {
                Log.d(f71614c, "isExpireTime ：没有超过缓存有效期");
                return false;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f71620a = this.f71620a.d();
            if (f71615d) {
                String str = f71614c;
                Log.d(str, "asyncRequest, requestFromManufacturer done :" + this.f71620a.getOAID());
            }
        }
    }

    public final boolean s(d.a.z0.e.f.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, aVar, jSONObject)) == null) {
            try {
                long optLong = jSONObject.optLong(new String(d.a.z0.e.h.c.a("dGltZQ==".getBytes())));
                aVar.f71626a = optLong;
                if (f71615d) {
                    String str = f71614c;
                    Log.d(str, "tryParseCacheJsonObject ，time：" + optLong);
                    String str2 = f71614c;
                    Log.d(str2, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
                }
                String str3 = new String(d.a.z0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
                if (f71615d) {
                    String str4 = f71614c;
                    Log.d(str4, "tryParseCacheJsonObject objKey：" + str3);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                if (f71615d) {
                    String str5 = f71614c;
                    Log.d(str5, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
                }
                if (optJSONObject != null) {
                    String str6 = new String(d.a.z0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str7 = new String(d.a.z0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                    String str8 = new String(d.a.z0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str9 = new String(d.a.z0.e.h.c.a("b2FpZA==".getBytes()));
                    String str10 = new String(d.a.z0.e.h.c.a("YWFpZA==".getBytes()));
                    String str11 = new String(d.a.z0.e.h.c.a("dmFpZA==".getBytes()));
                    boolean optBoolean = optJSONObject.optBoolean(str6);
                    boolean optBoolean2 = optJSONObject.optBoolean(str7);
                    int optInt = optJSONObject.optInt(str8);
                    String optString = optJSONObject.optString(str9);
                    String optString2 = optJSONObject.optString(str10);
                    String optString3 = optJSONObject.optString(str11);
                    this.f71620a.i(optBoolean);
                    this.f71620a.e(optBoolean2);
                    this.f71620a.a(optInt);
                    this.f71620a.g(optString);
                    this.f71620a.f(optString2);
                    this.f71620a.b(optString3);
                    aVar.f71627b = this.f71620a;
                    return true;
                }
                aVar.f71627b = null;
                if (f71615d) {
                    Log.d(f71614c, "tryParseCacheJsonObject return cause null：");
                }
                return false;
            } catch (Exception e2) {
                if (f71615d) {
                    String str12 = f71614c;
                    Log.d(str12, "tryParseCacheJsonObject ：" + e2.getMessage());
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            try {
                if (this.f71620a != null && !TextUtils.isEmpty(this.f71620a.getOAID())) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, ".bd_un_info.so");
                    String str = new String(d.a.z0.e.h.c.a("dGltZQ==".getBytes()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, System.currentTimeMillis());
                    String str2 = new String(d.a.z0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    String str3 = new String(d.a.z0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str4 = new String(d.a.z0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                    String str5 = new String(d.a.z0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str6 = new String(d.a.z0.e.h.c.a("b2FpZA==".getBytes()));
                    String str7 = new String(d.a.z0.e.h.c.a("YWFpZA==".getBytes()));
                    String str8 = new String(d.a.z0.e.h.c.a("dmFpZA==".getBytes()));
                    optJSONObject.put(str3, this.f71620a.c());
                    optJSONObject.put(str4, this.f71620a.h());
                    optJSONObject.put(str5, this.f71620a.getStatusCode());
                    optJSONObject.put(str6, this.f71620a.getOAID());
                    optJSONObject.put(str7, this.f71620a.getAAID());
                    optJSONObject.put(str8, this.f71620a.getVAID());
                    jSONObject.put(str2, optJSONObject);
                    d.a.z0.e.h.e.b(l(jSONObject.toString()), file2, false, f71618g);
                    if (f71615d) {
                        String str9 = f71614c;
                        Log.d(str9, "trySaveFiles, app: " + jSONObject.toString());
                        return true;
                    }
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (f71615d) {
                    String str10 = f71614c;
                    Log.d(str10, "trySaveFiles, error " + e2.getMessage());
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
