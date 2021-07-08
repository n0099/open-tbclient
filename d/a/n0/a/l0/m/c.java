package d.a.n0.a.l0.m;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45962e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HttpManager f45963a;

    /* renamed from: b  reason: collision with root package name */
    public String f45964b;

    /* renamed from: c  reason: collision with root package name */
    public String f45965c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.a.l0.m.a f45966d;

    /* loaded from: classes7.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f45967a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45967a = cVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (c.f45962e) {
                    Log.e("ImageDownloader", this.f45967a.f45964b + " load failed");
                    iOException.printStackTrace();
                }
                if (this.f45967a.f45966d != null) {
                    this.f45967a.f45966d.fail(-1, this.f45967a.f45964b);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            File file;
            InputStream byteStream;
            String c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (TextUtils.isEmpty(this.f45967a.f45965c)) {
                    if (k.f45831a) {
                        Log.e("SwanGameRuntime", "非手百环境依赖注入接口未实现，直接返回");
                        return;
                    }
                    return;
                }
                byte[] bArr = new byte[2048];
                InputStream inputStream = null;
                try {
                    byteStream = response.body().byteStream();
                    try {
                        try {
                            c2 = d.a.n0.a.c1.b.f().c(this.f45967a.f45964b);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        file = null;
                        fileOutputStream = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    file = null;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
                if (TextUtils.isEmpty(c2)) {
                    if (k.f45831a) {
                        Log.e("SwanGameRuntime", "非手百环境依赖注入接口convertSrc()未实现，直接返回");
                    }
                    d.a.n0.t.d.d(byteStream);
                    d.a.n0.t.d.d(null);
                    d.a.n0.t.d.d(response);
                    return;
                }
                String str = this.f45967a.f45965c + c2.substring(0, c2.lastIndexOf("/"));
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    file2.mkdirs();
                }
                String substring = c2.substring(c2.lastIndexOf("/") + 1);
                file = new File(str, substring + ".bddownload");
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (Exception e4) {
                            e = e4;
                            inputStream = byteStream;
                            try {
                                if (c.f45962e) {
                                    Log.e("ImageDownloader", this.f45967a.f45964b + " load failed", e);
                                }
                                if (file != null) {
                                    file.delete();
                                }
                                if (this.f45967a.f45966d != null) {
                                    this.f45967a.f45966d.fail(-1, this.f45967a.f45964b);
                                }
                                d.a.n0.t.d.d(inputStream);
                                d.a.n0.t.d.d(fileOutputStream);
                                d.a.n0.t.d.d(response);
                            } catch (Throwable th3) {
                                th = th3;
                                d.a.n0.t.d.d(inputStream);
                                d.a.n0.t.d.d(fileOutputStream);
                                d.a.n0.t.d.d(response);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = byteStream;
                            d.a.n0.t.d.d(inputStream);
                            d.a.n0.t.d.d(fileOutputStream);
                            d.a.n0.t.d.d(response);
                            throw th;
                        }
                    }
                    fileOutputStream.flush();
                    File file3 = new File(str, substring);
                    if (file3.exists() && !file3.isDirectory()) {
                        file3.delete();
                    }
                    String absolutePath = file3.getAbsolutePath();
                    if (file.renameTo(file3)) {
                        if (c.f45962e) {
                            Log.e("ImageDownloader", this.f45967a.f45964b + " load rename success path = " + absolutePath);
                        }
                        if (this.f45967a.f45966d != null) {
                            this.f45967a.f45966d.a(this.f45967a.f45964b, absolutePath);
                        }
                    } else {
                        if (c.f45962e) {
                            Log.e("ImageDownloader", this.f45967a.f45964b + " load rename error path = " + absolutePath);
                        }
                        file.delete();
                        if (this.f45967a.f45966d != null) {
                            this.f45967a.f45966d.fail(-1, absolutePath);
                        }
                    }
                    d.a.n0.t.d.d(byteStream);
                } catch (Exception e5) {
                    e = e5;
                    fileOutputStream = null;
                }
                d.a.n0.t.d.d(fileOutputStream);
                d.a.n0.t.d.d(response);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-426604721, "Ld/a/n0/a/l0/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-426604721, "Ld/a/n0/a/l0/m/c;");
                return;
            }
        }
        f45962e = k.f45831a;
    }

    public c(HttpManager httpManager, String str, String str2, d.a.n0.a.l0.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpManager, str, str2, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45964b = "";
        this.f45965c = "";
        this.f45963a = httpManager;
        this.f45965c = str;
        this.f45964b = str2;
        this.f45966d = aVar;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.n0.a.c1.b.l().a(this.f45963a, new Request.Builder().url(this.f45964b).build(), new a(this));
        }
    }
}
