package d.a.x0.e;

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
    public static String f69095c = "UnionIDHelper";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f69096d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f69097e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f69098f;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f69099g;

    /* renamed from: h  reason: collision with root package name */
    public static e f69100h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile d.a.x0.e.f.c f69101a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f69102b;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f69103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f69104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f69105g;

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
            this.f69105g = eVar;
            this.f69103e = context;
            this.f69104f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e.f69096d) {
                    Log.d(e.f69095c, "asyncRequest, Thread runn！");
                }
                d.a.x0.e.f.a m = this.f69105g.m(this.f69103e);
                if (e.f69096d) {
                    String str = e.f69095c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("asyncRequest, cachedBean == null ？");
                    sb.append(m == null);
                    Log.d(str, sb.toString());
                }
                if (m == null || this.f69105g.q(m)) {
                    if (e.f69096d) {
                        Log.d(e.f69095c, "asyncRequest, requestFromManufacturer");
                    }
                    this.f69105g.r();
                    if (e.f69096d) {
                        Log.d(e.f69095c, "asyncRequest, trySaveFiles！");
                    }
                    this.f69105g.f69102b.set(this.f69105g.t(this.f69103e));
                    if (e.f69096d) {
                        Log.d(e.f69095c, "asyncRequest, trySaveFiles done");
                    }
                }
                if (e.f69096d) {
                    Log.d(e.f69095c, "asyncRequest, send  innerHandler message");
                }
                this.f69104f.obtainMessage(100, this.f69105g.f69101a).sendToTarget();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.x0.e.f.b f69106a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, d.a.x0.e.f.b bVar) {
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
            this.f69106a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                d.a.x0.e.f.c cVar = (d.a.x0.e.f.c) message.obj;
                if (e.f69096d) {
                    String str = e.f69095c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("handleMessage ，what：");
                    sb.append(cVar == null ? "" : cVar.getOAID());
                    Log.d(str, sb.toString());
                }
                d.a.x0.e.f.b bVar = this.f69106a;
                if (bVar != null) {
                    bVar.a(cVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1402120206, "Ld/a/x0/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1402120206, "Ld/a/x0/e/e;");
                return;
            }
        }
        f69096d = d.a.x0.e.a.e();
        f69097e = j(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
        f69098f = j(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
        f69099g = new Object();
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
        this.f69102b = new AtomicBoolean(false);
    }

    public static String j(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr2 : bArr) {
                sb.append(new String(d.a.x0.e.h.c.a(bArr2)));
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
                return new String(d.a.x0.e.h.a.a(f69097e, f69098f, d.a.x0.e.h.c.a(str.getBytes())));
            } catch (Exception e2) {
                if (f69096d) {
                    String str2 = f69095c;
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
                return d.a.x0.e.h.c.c(d.a.x0.e.h.a.b(f69097e, f69098f, str.getBytes()), "utf-8");
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
            if (f69100h == null) {
                synchronized (e.class) {
                    if (f69100h == null) {
                        f69100h = new e();
                    }
                }
            }
            return f69100h;
        }
        return (e) invokeV.objValue;
    }

    public synchronized void i(Context context, @NonNull Looper looper, @Nullable d.a.x0.e.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, looper, bVar) == null) {
            synchronized (this) {
                if (looper != null) {
                    b bVar2 = new b(looper, bVar);
                    if (p()) {
                        bVar2.obtainMessage(100, null).sendToTarget();
                        return;
                    }
                    if (this.f69101a != null && this.f69102b.get()) {
                        if (f69096d) {
                            String str = f69095c;
                            Log.d(str, "asyncRequest, mIUnionId.getOAID：" + this.f69101a.getOAID());
                            String str2 = f69095c;
                            Log.d(str2, "asyncRequest, mIUnionId.isTrackLimited：" + this.f69101a.c());
                            String str3 = f69095c;
                            Log.d(str3, "asyncRequest, mIUnionId.getStatusCode：" + this.f69101a.getStatusCode());
                        }
                        bVar2.obtainMessage(100, this.f69101a).sendToTarget();
                    } else {
                        if (!this.f69102b.get()) {
                            this.f69101a = new c(context).f69091a;
                        }
                        new Thread(new a(this, context, bVar2)).start();
                    }
                    return;
                }
                throw new NullPointerException("param looper not null");
            }
        }
    }

    public final d.a.x0.e.f.a m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
            if (!file.exists()) {
                if (f69096d) {
                    Log.d(f69095c, "getCacheObject dir 不存在 , 首次需要创建");
                }
                return null;
            }
            File file2 = new File(file, ".bd_un_info.so");
            if (!file2.exists()) {
                if (f69096d) {
                    Log.d(f69095c, "getCacheObject  file 不存在, 首次需要创建");
                }
                return null;
            }
            String a2 = d.a.x0.e.h.e.a(file2, f69099g);
            if (f69096d) {
                String str = f69095c;
                Log.d(str, "getCacheObject ，content：" + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String k = k(a2);
            if (f69096d) {
                String str2 = f69095c;
                Log.d(str2, "getCacheObject ，json：" + k);
            }
            try {
                JSONObject jSONObject = new JSONObject(k);
                d.a.x0.e.f.a aVar = new d.a.x0.e.f.a();
                s(aVar, jSONObject);
                return aVar;
            } catch (Exception e2) {
                if (f69096d) {
                    String str3 = f69095c;
                    Log.d(str3, "getCacheObject , " + e2.getMessage());
                }
                return null;
            }
        }
        return (d.a.x0.e.f.a) invokeL.objValue;
    }

    public final long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.x0.e.a.a(d.a.x0.e.b.a()) * 60 * 1000 : invokeV.longValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.x0.e.a.d(d.a.x0.e.b.a()) : invokeV.booleanValue;
    }

    public final boolean q(@NonNull d.a.x0.e.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (Math.abs(System.currentTimeMillis() - aVar.f69107a) > n()) {
                if (f69096d) {
                    Log.d(f69095c, "isExpireTime ：超过缓存有效期");
                    return true;
                }
                return true;
            } else if (f69096d) {
                Log.d(f69095c, "isExpireTime ：没有超过缓存有效期");
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
            this.f69101a = this.f69101a.d();
            if (f69096d) {
                String str = f69095c;
                Log.d(str, "asyncRequest, requestFromManufacturer done :" + this.f69101a.getOAID());
            }
        }
    }

    public final boolean s(d.a.x0.e.f.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, aVar, jSONObject)) == null) {
            try {
                long optLong = jSONObject.optLong(new String(d.a.x0.e.h.c.a("dGltZQ==".getBytes())));
                aVar.f69107a = optLong;
                if (f69096d) {
                    String str = f69095c;
                    Log.d(str, "tryParseCacheJsonObject ，time：" + optLong);
                    String str2 = f69095c;
                    Log.d(str2, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
                }
                String str3 = new String(d.a.x0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
                if (f69096d) {
                    String str4 = f69095c;
                    Log.d(str4, "tryParseCacheJsonObject objKey：" + str3);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                if (f69096d) {
                    String str5 = f69095c;
                    Log.d(str5, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
                }
                if (optJSONObject != null) {
                    String str6 = new String(d.a.x0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str7 = new String(d.a.x0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                    String str8 = new String(d.a.x0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str9 = new String(d.a.x0.e.h.c.a("b2FpZA==".getBytes()));
                    String str10 = new String(d.a.x0.e.h.c.a("YWFpZA==".getBytes()));
                    String str11 = new String(d.a.x0.e.h.c.a("dmFpZA==".getBytes()));
                    boolean optBoolean = optJSONObject.optBoolean(str6);
                    boolean optBoolean2 = optJSONObject.optBoolean(str7);
                    int optInt = optJSONObject.optInt(str8);
                    String optString = optJSONObject.optString(str9);
                    String optString2 = optJSONObject.optString(str10);
                    String optString3 = optJSONObject.optString(str11);
                    this.f69101a.i(optBoolean);
                    this.f69101a.e(optBoolean2);
                    this.f69101a.a(optInt);
                    this.f69101a.g(optString);
                    this.f69101a.f(optString2);
                    this.f69101a.b(optString3);
                    aVar.f69108b = this.f69101a;
                    return true;
                }
                aVar.f69108b = null;
                if (f69096d) {
                    Log.d(f69095c, "tryParseCacheJsonObject return cause null：");
                }
                return false;
            } catch (Exception e2) {
                if (f69096d) {
                    String str12 = f69095c;
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
                if (this.f69101a != null && !TextUtils.isEmpty(this.f69101a.getOAID())) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, ".bd_un_info.so");
                    String str = new String(d.a.x0.e.h.c.a("dGltZQ==".getBytes()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, System.currentTimeMillis());
                    String str2 = new String(d.a.x0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    String str3 = new String(d.a.x0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str4 = new String(d.a.x0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                    String str5 = new String(d.a.x0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str6 = new String(d.a.x0.e.h.c.a("b2FpZA==".getBytes()));
                    String str7 = new String(d.a.x0.e.h.c.a("YWFpZA==".getBytes()));
                    String str8 = new String(d.a.x0.e.h.c.a("dmFpZA==".getBytes()));
                    optJSONObject.put(str3, this.f69101a.c());
                    optJSONObject.put(str4, this.f69101a.h());
                    optJSONObject.put(str5, this.f69101a.getStatusCode());
                    optJSONObject.put(str6, this.f69101a.getOAID());
                    optJSONObject.put(str7, this.f69101a.getAAID());
                    optJSONObject.put(str8, this.f69101a.getVAID());
                    jSONObject.put(str2, optJSONObject);
                    d.a.x0.e.h.e.b(l(jSONObject.toString()), file2, false, f69099g);
                    if (f69096d) {
                        String str9 = f69095c;
                        Log.d(str9, "trySaveFiles, app: " + jSONObject.toString());
                        return true;
                    }
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (f69096d) {
                    String str10 = f69095c;
                    Log.d(str10, "trySaveFiles, error " + e2.getMessage());
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
