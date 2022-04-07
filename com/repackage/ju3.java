package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class ju3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public qy3 a;
    public String b;
    public String c;
    public hu3 d;

    /* loaded from: classes6.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju3 a;

        public a(ju3 ju3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju3Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (ju3.e) {
                    Log.e("AudioDownloader", this.a.b + " load failed");
                    iOException.printStackTrace();
                }
                if (this.a.d != null) {
                    this.a.d.fail(-1, this.a.b);
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
                            String d = eu3.d(this.a.b);
                            String str = this.a.c + d.substring(0, d.lastIndexOf("/"));
                            File file2 = new File(str);
                            if (!file2.exists() || !file2.isDirectory()) {
                                file2.mkdirs();
                            }
                            String substring = d.substring(d.lastIndexOf("/") + 1);
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
                                    } catch (Exception e) {
                                        e = e;
                                        inputStream = byteStream;
                                        try {
                                            if (ju3.e) {
                                                Log.e("AudioDownloader", this.a.b + " load failed", e);
                                            }
                                            if (file != null) {
                                                file.delete();
                                            }
                                            if (this.a.d != null) {
                                                this.a.d.fail(-1, this.a.b);
                                            }
                                            ng4.d(inputStream);
                                            ng4.d(fileOutputStream);
                                            ng4.d(response);
                                        } catch (Throwable th) {
                                            th = th;
                                            ng4.d(inputStream);
                                            ng4.d(fileOutputStream);
                                            ng4.d(response);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = byteStream;
                                        ng4.d(inputStream);
                                        ng4.d(fileOutputStream);
                                        ng4.d(response);
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
                                    if (ju3.e) {
                                        Log.e("AudioDownloader", this.a.b + " load rename success path = " + absolutePath);
                                    }
                                    if (this.a.d != null) {
                                        this.a.d.a(this.a.b, absolutePath);
                                    }
                                } else {
                                    if (ju3.e) {
                                        Log.e("AudioDownloader", this.a.b + " load rename error path = " + absolutePath);
                                    }
                                    file.delete();
                                    if (this.a.d != null) {
                                        this.a.d.fail(-1, absolutePath);
                                    }
                                }
                                ng4.d(byteStream);
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = null;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            file = null;
                            fileOutputStream = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    file = null;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
                ng4.d(fileOutputStream);
                ng4.d(response);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755576215, "Lcom/repackage/ju3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755576215, "Lcom/repackage/ju3;");
                return;
            }
        }
        e = tg1.a;
    }

    public ju3(qy3 qy3Var, String str, String str2, hu3 hu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qy3Var, str, str2, hu3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "";
        this.c = "";
        this.a = qy3Var;
        this.c = str;
        this.b = str2;
        this.d = hu3Var;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.call(new Request.Builder().url(this.b).build(), new a(this));
        }
    }
}
