package d.a.r0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f67338b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67339a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-458396379, "Ld/a/r0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-458396379, "Ld/a/r0/b;");
                return;
            }
        }
        f67338b = AppConfig.isDebug();
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67339a = context;
    }

    public final boolean a(i0 i0Var) {
        InterceptResult invokeL;
        File[] listFiles;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i0Var)) == null) {
            File file = new File(this.f67339a.getFilesDir() + File.separator + "ubcdir", "proc");
            if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
                return false;
            }
            for (File file2 : listFiles) {
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                        long j = Long.MAX_VALUE;
                        int i2 = 0;
                        long j2 = 0;
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                                if (jSONObject.has("abtest")) {
                                    i0Var.q("1");
                                }
                                long j3 = jSONObject.getLong("timestamp");
                                if (j3 > 0) {
                                    if (j3 < j) {
                                        j = j3;
                                    }
                                    if (j3 > j2) {
                                        j2 = j3;
                                    }
                                }
                                if (f67338b) {
                                    Log.d("UBCFileData", jSONObject.toString());
                                }
                                i0Var.a(jSONObject);
                                i2++;
                                if (i2 >= 10) {
                                    break;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                        i0Var.p(j, j2);
                        if (f67338b) {
                            Log.d("UBCFileData", "line num " + i2 + " delete file ");
                        }
                        try {
                            bufferedReader2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final File b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            File file = new File(this.f67339a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!TextUtils.isEmpty(str)) {
                File file2 = new File(file, "proc");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                return new File(file2, str);
            }
            return new File(file, z ? "filereal" : "filedata");
        }
        return (File) invokeLZ.objValue;
    }

    public void c(boolean z) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            File file = new File(this.f67339a.getFilesDir(), "ubcdir");
            if (file.exists()) {
                File file2 = new File(file, z ? "filereal" : "filedata");
                if (file2.exists()) {
                    file2.delete();
                }
                File file3 = new File(file, "proc");
                if (!file3.exists() || !file3.isDirectory() || (listFiles = file3.listFiles()) == null || listFiles.length == 0) {
                    return;
                }
                for (File file4 : listFiles) {
                    if (file4.isFile()) {
                        file4.delete();
                    }
                }
            }
        }
    }

    public void d(o oVar, File file) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, oVar, file) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", oVar.g());
                jSONObject.put("timestamp", oVar.k());
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(oVar.b())) {
                    jSONObject.put("content", oVar.b());
                } else if (oVar.h() != null) {
                    jSONObject.put("content", oVar.h().toString());
                }
                if (!TextUtils.isEmpty(oVar.c())) {
                    jSONObject.put("abtest", oVar.c());
                }
                if (!TextUtils.isEmpty(oVar.a())) {
                    jSONObject.put("c", oVar.a());
                }
                if (oVar.l()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put(Constant.ID_TYPE, g.m().r(oVar.g()));
            } catch (JSONException e2) {
                if (f67338b) {
                    Log.d("UBCFileData", e2.getMessage());
                }
            }
            if (f67338b) {
                Log.d("UBCFileData", "saveEvent:" + jSONObject.toString());
            }
            byte[] encode = Base64.encode(jSONObject.toString().getBytes(), 2);
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file, true);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(encode);
                fileOutputStream.write("\n".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e5) {
                e = e5;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
        if (r5.exists() != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
        r5.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c8, code lost:
        if (r5.exists() != false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, i0Var)) == null) {
            File file = new File(this.f67339a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "filequality");
            boolean z = false;
            if (file2.exists()) {
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                        long j = Long.MAX_VALUE;
                        long j2 = 0;
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                                if (jSONObject.has("abtest")) {
                                    i0Var.q("1");
                                }
                                long j3 = jSONObject.getLong("timestamp");
                                if (j3 > 0) {
                                    if (j3 < j) {
                                        j = j3;
                                    }
                                    if (j3 > j2) {
                                        j2 = j3;
                                    }
                                }
                                i0Var.a(jSONObject);
                                z = true;
                            } catch (Exception e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                if (f67338b) {
                                    Log.d("UBCFileData", "getExceptionList read fail:", e);
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e3) {
                                        if (f67338b) {
                                            Log.d("UBCFileData", "getExceptionList close fail:", e3);
                                        }
                                    }
                                }
                                if (z) {
                                }
                                return z;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                Throwable th2 = th;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e4) {
                                        if (f67338b) {
                                            Log.d("UBCFileData", "getExceptionList close fail:", e4);
                                        }
                                    }
                                }
                                if (z && file2.exists()) {
                                    file2.delete();
                                }
                                throw th2;
                            }
                        }
                        i0Var.p(j, j2);
                        try {
                            bufferedReader2.close();
                        } catch (Exception e5) {
                            if (f67338b) {
                                Log.d("UBCFileData", "getExceptionList close fail:", e5);
                            }
                        }
                        if (z) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e6) {
                    e = e6;
                }
                return z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        if (d.a.r0.b.f67338b == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
        android.util.Log.d("UBCFileData", "getExceptionList close fail:", r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0099, code lost:
        if (d.a.r0.b.f67338b == false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(i0 i0Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, i0Var, z)) == null) {
            boolean a2 = !z ? a(i0Var) : false;
            File b2 = b("", z);
            if (b2.exists()) {
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(b2));
                        long j = Long.MAX_VALUE;
                        long j2 = 0;
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                                if (jSONObject.has("abtest")) {
                                    i0Var.q("1");
                                }
                                long j3 = jSONObject.getLong("timestamp");
                                if (j3 > 0) {
                                    if (j3 < j) {
                                        j = j3;
                                    }
                                    if (j3 > j2) {
                                        j2 = j3;
                                    }
                                }
                                i0Var.a(jSONObject);
                                a2 = true;
                            } catch (Exception e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                if (f67338b) {
                                    Log.d("UBCFileData", "getExceptionList read fail:", e);
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e3) {
                                        e = e3;
                                    }
                                }
                                return a2;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e4) {
                                        if (f67338b) {
                                            Log.d("UBCFileData", "getExceptionList close fail:", e4);
                                        }
                                    }
                                }
                                throw th;
                            }
                        }
                        i0Var.p(j, j2);
                        try {
                            bufferedReader2.close();
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e6) {
                    e = e6;
                }
            }
            return a2;
        }
        return invokeLZ.booleanValue;
    }

    public void g(o oVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, oVar, z) == null) {
            d(oVar, b(oVar.d(), z));
        }
    }

    public void h(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, exc) == null) {
            b0.a().g(Log.getStackTraceString(exc));
        }
    }

    public void i(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oVar) == null) {
            File file = new File(this.f67339a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "filequality");
            if (file2.length() > g.m().n()) {
                if (!file2.delete()) {
                    return;
                }
                file2 = new File(file, "filequality");
            }
            d(oVar, file2);
        }
    }
}
