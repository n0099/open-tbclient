package d.a.o0.h.c.i;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.h.c.f;
import d.a.o0.t.d;
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
    public static final boolean f50339e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.h.y.b f50340a;

    /* renamed from: b  reason: collision with root package name */
    public String f50341b;

    /* renamed from: c  reason: collision with root package name */
    public String f50342c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.h.c.i.a f50343d;

    /* loaded from: classes7.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f50344a;

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
            this.f50344a = cVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (c.f50339e) {
                    Log.e("AudioDownloader", this.f50344a.f50341b + " load failed");
                    iOException.printStackTrace();
                }
                if (this.f50344a.f50343d != null) {
                    this.f50344a.f50343d.fail(-1, this.f50344a.f50341b);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            File file;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                byte[] bArr = new byte[2048];
                InputStream inputStream = null;
                try {
                    InputStream byteStream = response.body().byteStream();
                    try {
                        try {
                            String d2 = f.d(this.f50344a.f50341b);
                            String str = this.f50344a.f50342c + d2.substring(0, d2.lastIndexOf("/"));
                            File file2 = new File(str);
                            if (!file2.exists() || !file2.isDirectory()) {
                                file2.mkdirs();
                            }
                            String substring = d2.substring(d2.lastIndexOf("/") + 1);
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
                                    } catch (Exception e2) {
                                        e = e2;
                                        inputStream = byteStream;
                                        try {
                                            if (c.f50339e) {
                                                Log.e("AudioDownloader", this.f50344a.f50341b + " load failed", e);
                                            }
                                            if (file != null) {
                                                file.delete();
                                            }
                                            if (this.f50344a.f50343d != null) {
                                                this.f50344a.f50343d.fail(-1, this.f50344a.f50341b);
                                            }
                                            d.d(inputStream);
                                            d.d(fileOutputStream);
                                            d.d(response);
                                        } catch (Throwable th) {
                                            th = th;
                                            d.d(inputStream);
                                            d.d(fileOutputStream);
                                            d.d(response);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = byteStream;
                                        d.d(inputStream);
                                        d.d(fileOutputStream);
                                        d.d(response);
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
                                    if (c.f50339e) {
                                        Log.e("AudioDownloader", this.f50344a.f50341b + " load rename success path = " + absolutePath);
                                    }
                                    if (this.f50344a.f50343d != null) {
                                        this.f50344a.f50343d.a(this.f50344a.f50341b, absolutePath);
                                    }
                                } else {
                                    if (c.f50339e) {
                                        Log.e("AudioDownloader", this.f50344a.f50341b + " load rename error path = " + absolutePath);
                                    }
                                    file.delete();
                                    if (this.f50344a.f50343d != null) {
                                        this.f50344a.f50343d.fail(-1, absolutePath);
                                    }
                                }
                                d.d(byteStream);
                            } catch (Exception e3) {
                                e = e3;
                                fileOutputStream = null;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            file = null;
                            fileOutputStream = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    file = null;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
                d.d(fileOutputStream);
                d.d(response);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2096298266, "Ld/a/o0/h/c/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2096298266, "Ld/a/o0/h/c/i/c;");
                return;
            }
        }
        f50339e = k.f46335a;
    }

    public c(d.a.o0.h.y.b bVar, String str, String str2, d.a.o0.h.c.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, str, str2, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50341b = "";
        this.f50342c = "";
        this.f50340a = bVar;
        this.f50342c = str;
        this.f50341b = str2;
        this.f50343d = aVar;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f50340a.b(new Request.Builder().url(this.f50341b).build(), new a(this));
        }
    }
}
