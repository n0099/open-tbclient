package d.a.w0.e;

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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f68417c = "UnionIDHelper";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f68418d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f68419e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f68420f;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f68421g;

    /* renamed from: h  reason: collision with root package name */
    public static e f68422h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile d.a.w0.e.f.c f68423a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f68424b;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f68425e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f68426f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f68427g;

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
            this.f68427g = eVar;
            this.f68425e = context;
            this.f68426f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e.f68418d) {
                    Log.d(e.f68417c, "asyncRequest, Thread runn！");
                }
                d.a.w0.e.f.a m = this.f68427g.m(this.f68425e);
                if (e.f68418d) {
                    String str = e.f68417c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("asyncRequest, cachedBean == null ？");
                    sb.append(m == null);
                    Log.d(str, sb.toString());
                }
                if (m == null || this.f68427g.q(m)) {
                    if (e.f68418d) {
                        Log.d(e.f68417c, "asyncRequest, requestFromManufacturer");
                    }
                    this.f68427g.r();
                    if (e.f68418d) {
                        Log.d(e.f68417c, "asyncRequest, trySaveFiles！");
                    }
                    this.f68427g.f68424b.set(this.f68427g.t(this.f68425e));
                    if (e.f68418d) {
                        Log.d(e.f68417c, "asyncRequest, trySaveFiles done");
                    }
                }
                if (e.f68418d) {
                    Log.d(e.f68417c, "asyncRequest, send  innerHandler message");
                }
                this.f68426f.obtainMessage(100, this.f68427g.f68423a).sendToTarget();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.w0.e.f.b f68428a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, d.a.w0.e.f.b bVar) {
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
            this.f68428a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                d.a.w0.e.f.c cVar = (d.a.w0.e.f.c) message.obj;
                if (e.f68418d) {
                    String str = e.f68417c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("handleMessage ，what：");
                    sb.append(cVar == null ? "" : cVar.getOAID());
                    Log.d(str, sb.toString());
                }
                d.a.w0.e.f.b bVar = this.f68428a;
                if (bVar != null) {
                    bVar.a(cVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2005343409, "Ld/a/w0/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2005343409, "Ld/a/w0/e/e;");
                return;
            }
        }
        f68418d = d.a.w0.e.a.e();
        f68419e = j(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
        f68420f = j(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
        f68421g = new Object();
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
        this.f68424b = new AtomicBoolean(false);
    }

    public static String j(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr2 : bArr) {
                sb.append(new String(d.a.w0.e.h.c.a(bArr2)));
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
                return new String(d.a.w0.e.h.a.a(f68419e, f68420f, d.a.w0.e.h.c.a(str.getBytes())));
            } catch (Exception e2) {
                if (f68418d) {
                    String str2 = f68417c;
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
                return d.a.w0.e.h.c.c(d.a.w0.e.h.a.b(f68419e, f68420f, str.getBytes()), "utf-8");
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
            if (f68422h == null) {
                synchronized (e.class) {
                    if (f68422h == null) {
                        f68422h = new e();
                    }
                }
            }
            return f68422h;
        }
        return (e) invokeV.objValue;
    }

    public synchronized void i(Context context, @NonNull Looper looper, @Nullable d.a.w0.e.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, looper, bVar) == null) {
            synchronized (this) {
                if (looper != null) {
                    b bVar2 = new b(looper, bVar);
                    if (p()) {
                        bVar2.obtainMessage(100, null).sendToTarget();
                        return;
                    }
                    if (this.f68423a != null && this.f68424b.get()) {
                        if (f68418d) {
                            String str = f68417c;
                            Log.d(str, "asyncRequest, mIUnionId.getOAID：" + this.f68423a.getOAID());
                            String str2 = f68417c;
                            Log.d(str2, "asyncRequest, mIUnionId.isTrackLimited：" + this.f68423a.c());
                            String str3 = f68417c;
                            Log.d(str3, "asyncRequest, mIUnionId.getStatusCode：" + this.f68423a.getStatusCode());
                        }
                        bVar2.obtainMessage(100, this.f68423a).sendToTarget();
                    } else {
                        if (!this.f68424b.get()) {
                            this.f68423a = new c(context).f68413a;
                        }
                        new Thread(new a(this, context, bVar2)).start();
                    }
                    return;
                }
                throw new NullPointerException("param looper not null");
            }
        }
    }

    public final d.a.w0.e.f.a m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
            if (!file.exists()) {
                if (f68418d) {
                    Log.d(f68417c, "getCacheObject dir 不存在 , 首次需要创建");
                }
                return null;
            }
            File file2 = new File(file, ".bd_un_info.so");
            if (!file2.exists()) {
                if (f68418d) {
                    Log.d(f68417c, "getCacheObject  file 不存在, 首次需要创建");
                }
                return null;
            }
            String a2 = d.a.w0.e.h.e.a(file2, f68421g);
            if (f68418d) {
                String str = f68417c;
                Log.d(str, "getCacheObject ，content：" + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String k = k(a2);
            if (f68418d) {
                String str2 = f68417c;
                Log.d(str2, "getCacheObject ，json：" + k);
            }
            try {
                JSONObject jSONObject = new JSONObject(k);
                d.a.w0.e.f.a aVar = new d.a.w0.e.f.a();
                s(aVar, jSONObject);
                return aVar;
            } catch (Exception e2) {
                if (f68418d) {
                    String str3 = f68417c;
                    Log.d(str3, "getCacheObject , " + e2.getMessage());
                }
                return null;
            }
        }
        return (d.a.w0.e.f.a) invokeL.objValue;
    }

    public final long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.w0.e.a.a(d.a.w0.e.b.a()) * 60 * 1000 : invokeV.longValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.w0.e.a.d(d.a.w0.e.b.a()) : invokeV.booleanValue;
    }

    public final boolean q(@NonNull d.a.w0.e.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (Math.abs(System.currentTimeMillis() - aVar.f68429a) > n()) {
                if (f68418d) {
                    Log.d(f68417c, "isExpireTime ：超过缓存有效期");
                    return true;
                }
                return true;
            } else if (f68418d) {
                Log.d(f68417c, "isExpireTime ：没有超过缓存有效期");
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
            this.f68423a = this.f68423a.d();
            if (f68418d) {
                String str = f68417c;
                Log.d(str, "asyncRequest, requestFromManufacturer done :" + this.f68423a.getOAID());
            }
        }
    }

    public final boolean s(d.a.w0.e.f.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, aVar, jSONObject)) == null) {
            try {
                long optLong = jSONObject.optLong(new String(d.a.w0.e.h.c.a("dGltZQ==".getBytes())));
                aVar.f68429a = optLong;
                if (f68418d) {
                    String str = f68417c;
                    Log.d(str, "tryParseCacheJsonObject ，time：" + optLong);
                    String str2 = f68417c;
                    Log.d(str2, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
                }
                String str3 = new String(d.a.w0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
                if (f68418d) {
                    String str4 = f68417c;
                    Log.d(str4, "tryParseCacheJsonObject objKey：" + str3);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                if (f68418d) {
                    String str5 = f68417c;
                    Log.d(str5, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
                }
                if (optJSONObject != null) {
                    String str6 = new String(d.a.w0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str7 = new String(d.a.w0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                    String str8 = new String(d.a.w0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str9 = new String(d.a.w0.e.h.c.a("b2FpZA==".getBytes()));
                    String str10 = new String(d.a.w0.e.h.c.a("YWFpZA==".getBytes()));
                    String str11 = new String(d.a.w0.e.h.c.a("dmFpZA==".getBytes()));
                    boolean optBoolean = optJSONObject.optBoolean(str6);
                    boolean optBoolean2 = optJSONObject.optBoolean(str7);
                    int optInt = optJSONObject.optInt(str8);
                    String optString = optJSONObject.optString(str9);
                    String optString2 = optJSONObject.optString(str10);
                    String optString3 = optJSONObject.optString(str11);
                    this.f68423a.i(optBoolean);
                    this.f68423a.e(optBoolean2);
                    this.f68423a.a(optInt);
                    this.f68423a.g(optString);
                    this.f68423a.f(optString2);
                    this.f68423a.b(optString3);
                    aVar.f68430b = this.f68423a;
                    return true;
                }
                aVar.f68430b = null;
                if (f68418d) {
                    Log.d(f68417c, "tryParseCacheJsonObject return cause null：");
                }
                return false;
            } catch (Exception e2) {
                if (f68418d) {
                    String str12 = f68417c;
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
                if (this.f68423a != null && !TextUtils.isEmpty(this.f68423a.getOAID())) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, ".bd_un_info.so");
                    String str = new String(d.a.w0.e.h.c.a("dGltZQ==".getBytes()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, System.currentTimeMillis());
                    String str2 = new String(d.a.w0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    String str3 = new String(d.a.w0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str4 = new String(d.a.w0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                    String str5 = new String(d.a.w0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str6 = new String(d.a.w0.e.h.c.a("b2FpZA==".getBytes()));
                    String str7 = new String(d.a.w0.e.h.c.a("YWFpZA==".getBytes()));
                    String str8 = new String(d.a.w0.e.h.c.a("dmFpZA==".getBytes()));
                    optJSONObject.put(str3, this.f68423a.c());
                    optJSONObject.put(str4, this.f68423a.h());
                    optJSONObject.put(str5, this.f68423a.getStatusCode());
                    optJSONObject.put(str6, this.f68423a.getOAID());
                    optJSONObject.put(str7, this.f68423a.getAAID());
                    optJSONObject.put(str8, this.f68423a.getVAID());
                    jSONObject.put(str2, optJSONObject);
                    d.a.w0.e.h.e.b(l(jSONObject.toString()), file2, false, f68421g);
                    if (f68418d) {
                        String str9 = f68417c;
                        Log.d(str9, "trySaveFiles, app: " + jSONObject.toString());
                        return true;
                    }
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (f68418d) {
                    String str10 = f68417c;
                    Log.d(str10, "trySaveFiles, error " + e2.getMessage());
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
