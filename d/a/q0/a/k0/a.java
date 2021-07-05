package d.a.q0.a.k0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a1.e;
import d.a.q0.a.v2.q0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0845a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e.c f49135a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f49136b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f49137c;

        public C0845a(a aVar, e.c cVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49137c = aVar;
            this.f49135a = cVar;
            this.f49136b = file;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f49137c.c(this.f49135a, 1, 0);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f49137c.d(response, this.f49135a, this.f49136b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f49138e;

        public b(a aVar, e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49138e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49138e.onSuccess();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f49139e;

        public c(a aVar, e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49139e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49139e.onFailed();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f49140e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49141f;

        public d(a aVar, e.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49140e = cVar;
            this.f49141f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49140e.a(this.f49141f);
            }
        }
    }

    public a() {
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

    public final void c(e.c cVar, int i2, int i3) {
        Runnable bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048576, this, cVar, i2, i3) == null) || cVar == null) {
            return;
        }
        if (i2 == 0) {
            bVar = new b(this, cVar);
        } else if (i2 != 2) {
            bVar = new c(this, cVar);
        } else {
            bVar = new d(this, cVar, i3);
        }
        q0.b0(bVar);
    }

    public final void d(Response response, e.c cVar, File file) throws IOException {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, cVar, file) == null) {
            ResponseBody body = response.body();
            if (body == null) {
                c(cVar, 1, 0);
                return;
            }
            byte[] bArr = new byte[2048];
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            InputStream inputStream = null;
            try {
                InputStream byteStream = body.byteStream();
                try {
                    long contentLength = body.contentLength();
                    fileOutputStream = new FileOutputStream(file);
                    long j = 0;
                    while (true) {
                        try {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            j += read;
                            c(cVar, 2, contentLength <= 0 ? 0 : (int) (((((float) j) * 1.0f) / ((float) contentLength)) * 100.0f));
                        } catch (Exception unused) {
                            inputStream = byteStream;
                            try {
                                c(cVar, 1, 0);
                                d.a.q0.t.d.d(inputStream);
                                d.a.q0.t.d.d(fileOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                d.a.q0.t.d.d(inputStream);
                                d.a.q0.t.d.d(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = byteStream;
                            d.a.q0.t.d.d(inputStream);
                            d.a.q0.t.d.d(fileOutputStream);
                            throw th;
                        }
                    }
                    fileOutputStream.flush();
                    c(cVar, 0, 100);
                    d.a.q0.t.d.d(byteStream);
                } catch (Exception unused2) {
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception unused3) {
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            d.a.q0.t.d.d(fileOutputStream);
        }
    }

    public void e(e.d dVar, String str, e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, str, cVar) == null) {
            d.a.q0.m.d.a aVar = new d.a.q0.m.d.a(dVar.f46624a, new C0845a(this, cVar, new File(str)));
            aVar.f53900f = false;
            aVar.f53901g = false;
            aVar.f53902h = false;
            d.a.q0.m.e.a.g().d(aVar);
        }
    }
}
