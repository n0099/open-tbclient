package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ec3;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class s73 extends k03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static int f;
    public static int g;
    public static int h;
    public transient /* synthetic */ FieldHolder $fh;
    public w83 a;
    public final String b;
    public final String c;
    public final ec3.a<Long> d;

    /* loaded from: classes7.dex */
    public class a implements ec3.a<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s73 a;

        public a(s73 s73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s73Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.ec3.a
        public Long update() throws IllegalStateException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Long.valueOf(this.a.e()) : (Long) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755367678, "Lcom/repackage/s73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755367678, "Lcom/repackage/s73;");
                return;
            }
        }
        e = tg1.a;
        f = 1024;
        g = -1;
        h = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s73(j03 j03Var) {
        super(j03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((j03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.b = r73.t(j03Var);
        this.c = "aiapp_" + this.b;
        fc3.h.b(this.d);
    }

    public static boolean b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.getBytes(StandardCharsets.UTF_8).length > 512 : invokeL.booleanValue;
    }

    public static boolean c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str.getBytes(StandardCharsets.UTF_8).length > 3145728 : invokeL.booleanValue;
    }

    public int a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                return file.length() > Config.FULL_TRACE_LOG_LIMIT ? 2002 : 2000;
            }
            return 2001;
        }
        return invokeL.intValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                g().edit().clear().commit();
            } else {
                g().edit().clear().apply();
            }
            ng4.k(r73.x(j03.f0()));
            ng4.k(r73.v(j03.f0()));
            fc3.h.update();
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (e) {
                File file = g().getFile();
                Log.i("SwanAppStorage", this.b + " exists = " + file.exists() + " isFile = " + file.isFile() + " path = " + file.getPath() + " size = " + file.length());
            }
            return g().c();
        }
        return invokeV.longValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.endsWith(File.separator)) {
                int lastIndexOf = str.lastIndexOf(File.separator);
                int length = str.length();
                if (lastIndexOf != g && length > lastIndexOf) {
                    return str.substring(lastIndexOf + h, length);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public w83 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                this.a = new w83(this.c, false);
            }
            return this.a;
        }
        return (w83) invokeV.objValue;
    }

    public q73 h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            File file = new File(str);
            if (file.isFile()) {
                q73 q73Var = new q73();
                q73Var.f(file.length());
                q73Var.d(file.lastModified());
                return q73Var;
            }
            return null;
        }
        return (q73) invokeL.objValue;
    }

    public List<q73> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String v = r73.v(j03.f0());
            if (TextUtils.isEmpty(v)) {
                return null;
            }
            return k(v);
        }
        return (List) invokeV.objValue;
    }

    public List<q73> j(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            if (e) {
                Log.d("SwanAppStorage", "——> getSavedFileList: " + file.getAbsolutePath());
            }
            q73 q73Var = new q73();
            ArrayList arrayList = new ArrayList();
            if (file.isFile()) {
                q73Var.e(file.getAbsolutePath());
                q73Var.f(file.length());
                q73Var.d(file.lastModified());
                arrayList.add(q73Var);
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return null;
                }
                for (File file2 : listFiles) {
                    List<q73> j = j(file2);
                    if (j != null) {
                        arrayList.addAll(arrayList.size(), j);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<q73> k(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (e) {
                Log.d("SwanAppStorage", "——> getSavedFileList:  dir " + str);
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return j(file);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final File l(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(str, str2);
        }
        return (File) invokeLL.objValue;
    }

    public boolean m(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) ? (e() - ((long) g().getString(str, "").length())) + ((long) str2.length()) > n() : invokeLL.booleanValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Config.FULL_TRACE_LOG_LIMIT : invokeV.longValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0048 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x004a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x004c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0077 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0016 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v7 */
    public String o(String str) {
        InterceptResult invokeL;
        Object obj;
        Object obj2;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            String v = r73.v(j03.f0());
            String str2 = "";
            if (TextUtils.isEmpty(v)) {
                return "";
            }
            FileInputStream fileInputStream = null;
            try {
                try {
                    File l = l(v, f(str));
                    FileInputStream fileInputStream2 = new FileInputStream(new File((String) str));
                    try {
                        str = new FileOutputStream(l);
                        try {
                            byte[] bArr = new byte[f];
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                str.write(bArr, 0, read);
                                str.flush();
                            }
                            str2 = l.getAbsolutePath();
                            ng4.d(fileInputStream2);
                            closeable = str;
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            obj2 = str;
                            str = obj2;
                            if (e) {
                                e.printStackTrace();
                                str = obj2;
                            }
                            ng4.d(fileInputStream);
                            closeable = str;
                            ng4.d(closeable);
                            return str2;
                        } catch (IOException e3) {
                            e = e3;
                            fileInputStream = fileInputStream2;
                            obj = str;
                            str = obj;
                            if (e) {
                                e.printStackTrace();
                                str = obj;
                            }
                            ng4.d(fileInputStream);
                            closeable = str;
                            ng4.d(closeable);
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            ng4.d(fileInputStream);
                            ng4.d(str);
                            throw th;
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        str = 0;
                    } catch (IOException e5) {
                        e = e5;
                        str = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        str = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                obj2 = null;
            } catch (IOException e7) {
                e = e7;
                obj = null;
            } catch (Throwable th4) {
                th = th4;
                str = 0;
            }
            ng4.d(closeable);
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
