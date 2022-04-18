package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSResponseEntity;
import com.baidu.searchbox.aperf.bosuploader.BOSUploader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.le9;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wd9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile wd9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public File b;
    public ExecutorService c;

    /* loaded from: classes7.dex */
    public class a implements xd9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ zd9 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ String f;

        public a(wd9 wd9Var, File file, zd9 zd9Var, String str, String str2, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd9Var, file, zd9Var, str, str2, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.b = zd9Var;
            this.c = str;
            this.d = str2;
            this.e = jSONObject;
            this.f = str3;
        }

        @Override // com.repackage.xd9
        public void a(ae9 ae9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ae9Var) == null) {
                if (ae9Var != null && ae9Var.c()) {
                    if (wd9.d) {
                        Log.d("VoyagerFileManager", "bos upload success");
                    }
                    if (this.a.exists()) {
                        this.a.delete();
                    }
                    zd9 zd9Var = this.b;
                    if (zd9Var != null) {
                        zd9Var.d(this.c, this.d, this.e);
                    }
                } else if (ae9Var != null) {
                    int a = ae9Var.a();
                    String b = ae9Var.b();
                    if (wd9.d) {
                        Log.d("VoyagerFileManager", "bos upload fail: error code = " + a + ", error message: " + b);
                    }
                    zd9 zd9Var2 = this.b;
                    if (zd9Var2 != null) {
                        zd9Var2.c(this.f, a, b, this.e);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ xd9 d;
        public final /* synthetic */ wd9 e;

        public b(wd9 wd9Var, String str, String str2, File file, xd9 xd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd9Var, str, str2, file, xd9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wd9Var;
            this.a = str;
            this.b = str2;
            this.c = file;
            this.d = xd9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.m(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755205083, "Lcom/repackage/wd9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755205083, "Lcom/repackage/wd9;");
                return;
            }
        }
        d = AppConfig.isDebug();
    }

    public wd9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j();
        this.c = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static wd9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (wd9.class) {
                    if (e == null) {
                        e = new wd9();
                    }
                }
            }
            return e;
        }
        return (wd9) invokeV.objValue;
    }

    public void c(ee9 ee9Var, zd9 zd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, ee9Var, zd9Var) == null) {
            String j = ee9Var.j();
            String a2 = ee9Var.a();
            if (TextUtils.isEmpty(j) || TextUtils.isEmpty(a2)) {
                return;
            }
            File file = new File(this.a, j);
            JSONObject c = ee9Var.c();
            if (file.exists()) {
                if (d) {
                    Log.d("VoyagerFileManager", "retry: " + j + " exists and upload");
                }
                k(j, a2, file, c, zd9Var);
                return;
            }
            d(ee9Var, zd9Var);
        }
    }

    public void d(ee9 ee9Var, zd9 zd9Var) {
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ee9Var, zd9Var) == null) {
            String j = ee9Var.j();
            String a2 = ee9Var.a();
            if (TextUtils.isEmpty(j) || TextUtils.isEmpty(a2)) {
                return;
            }
            ArrayList<String> g = ee9Var.g();
            JSONObject c = ee9Var.c();
            if (c == null) {
                c = new JSONObject();
                ee9Var.n(c);
            }
            JSONObject jSONObject = c;
            if (g != null && g.size() != 0) {
                if (!ee9Var.l() && g.size() == 1) {
                    String str = g.get(0);
                    if (TextUtils.isEmpty(str)) {
                        zd9Var.a(j, jSONObject);
                        return;
                    }
                    File file = new File(str);
                    if (!file.exists()) {
                        zd9Var.a(j, jSONObject);
                        return;
                    } else {
                        i = new File(this.a, j);
                        ne9.a(file, i);
                    }
                } else {
                    long e2 = ee9Var.e();
                    if (e2 == 0) {
                        e2 = ud9.f().d(a2);
                    }
                    i = i(j, g, e2, jSONObject);
                }
                File file2 = i;
                if (file2 != null && file2.exists()) {
                    k(j, a2, file2, jSONObject, zd9Var);
                    return;
                } else {
                    zd9Var.b(j, jSONObject);
                    return;
                }
            }
            zd9Var.a(j, jSONObject);
        }
    }

    public void e(String str, String str2, String str3, File file, String str4, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, file, str4, Boolean.valueOf(z), jSONObject}) == null) {
            try {
                JSONObject b2 = me9.b(file, str4, str2, str3, z);
                jSONObject.put(str, b2);
                if (d) {
                    Log.d("VoyagerFileManager", "generateMetaInfo path " + str + " fileMeta ：" + b2);
                }
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public ArrayList<File> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<File> arrayList = new ArrayList<>();
            File[] listFiles = this.a.listFiles();
            return (listFiles == null || listFiles.length <= 0) ? arrayList : new ArrayList<>(Arrays.asList(listFiles));
        }
        return (ArrayList) invokeV.objValue;
    }

    public File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (File) invokeV.objValue;
    }

    public File i(String str, ArrayList<String> arrayList, long j, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        String str2;
        File file;
        String str3;
        Iterator<String> it;
        File file2;
        String str4;
        boolean z;
        String str5;
        File file3;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, arrayList, Long.valueOf(j), jSONObject})) == null) {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
            Iterator<String> it2 = arrayList.iterator();
            long j2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    str2 = "VoyagerFileManager";
                    file = null;
                    str3 = " not exist";
                    break;
                }
                String next = it2.next();
                if (!TextUtils.isEmpty(next)) {
                    if (next.startsWith("external:")) {
                        next = next.replace("external:", AppRuntime.getAppContext().getExternalFilesDir(null).getParent() + File.separatorChar);
                    } else if (next.startsWith("internal:")) {
                        next = next.replace("internal:", AppRuntime.getAppContext().getApplicationInfo().dataDir + File.separator);
                    }
                    String str8 = next;
                    if (str8.contains("../")) {
                        e(str8, "4", str8 + " error", null, null, true, jSONObject2);
                    } else {
                        File file4 = new File(str8);
                        if (!file4.exists()) {
                            e(str8, "1", str8 + " not exist", null, null, true, jSONObject2);
                        } else {
                            if (d) {
                                Log.d("VoyagerFileManager", "path: " + str8);
                            }
                            if (file4.isFile()) {
                                long length = file4.length() + j2;
                                if (d) {
                                    Log.d("VoyagerFileManager", "total file size: " + length);
                                    Log.d("VoyagerFileManager", "max file size: " + j);
                                }
                                if (length > j) {
                                    file = null;
                                    e(str8, "3", str8 + " size exceed maxFileSize ", null, null, true, jSONObject2);
                                    str3 = " not exist";
                                    str2 = "VoyagerFileManager";
                                    break;
                                }
                                file = null;
                                StringBuilder sb = new StringBuilder(oe9.c(file4.getAbsolutePath().getBytes(), true));
                                sb.append("_");
                                sb.append(file4.getName());
                                arrayList2.add(new le9.a(file4, sb.toString()));
                                file2 = file4;
                                str4 = str8;
                                it = it2;
                                z = true;
                                str3 = " not exist";
                                e(str8, "0", str8 + " success", file2, sb.toString(), true, jSONObject2);
                                if (d) {
                                    Log.d("VoyagerFileManager", "zip name: " + ((Object) sb));
                                }
                                str5 = "VoyagerFileManager";
                                j2 = length;
                            } else {
                                it = it2;
                                file2 = file4;
                                str4 = str8;
                                file = null;
                                str3 = " not exist";
                                z = true;
                                str5 = "VoyagerFileManager";
                            }
                            if (file2.isDirectory()) {
                                ArrayList arrayList3 = new ArrayList();
                                File file5 = file2;
                                ne9.e(file5, arrayList3);
                                if (arrayList3.size() != 0) {
                                    boolean z2 = false;
                                    Iterator it3 = arrayList3.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            file3 = file5;
                                            str6 = str5;
                                            break;
                                        }
                                        String str9 = (String) it3.next();
                                        if (!TextUtils.isEmpty(str9)) {
                                            File file6 = new File(str9);
                                            if (file6.exists()) {
                                                j2 += file6.length();
                                                if (j2 > j) {
                                                    file3 = file5;
                                                    str6 = str5;
                                                    e(str4, "3", file5.getPath() + "size exceed maxFileSize ", null, null, true, jSONObject2);
                                                    z2 = true;
                                                    break;
                                                }
                                            }
                                            file5 = file5;
                                            str5 = str5;
                                        }
                                    }
                                    if (z2) {
                                        str2 = str6;
                                        break;
                                    }
                                    File file7 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "/store/");
                                    String c = oe9.c(file3.getAbsolutePath().getBytes(), z);
                                    File file8 = new File(file7, c + ".zip");
                                    if (d) {
                                        str7 = str6;
                                        Log.d(str7, "inner path: " + file7.getAbsolutePath());
                                        Log.d(str7, "inner path md5: " + c);
                                        Log.d(str7, "inner zip out file: " + file8.getAbsolutePath());
                                    } else {
                                        str7 = str6;
                                    }
                                    if (!file7.exists()) {
                                        file7.mkdir();
                                    }
                                    if (file8.exists()) {
                                        file8.delete();
                                    }
                                    if (ne9.h(file3, file8.getAbsolutePath())) {
                                        if (d) {
                                            Log.d(str7, "inner zip out file: " + file8.getName());
                                        }
                                        arrayList2.add(new le9.a(file8, file8.getName(), z));
                                        e(str4, "0", "success", file8, file8.getPath(), false, jSONObject2);
                                    } else {
                                        StringBuilder sb2 = new StringBuilder();
                                        String str10 = str4;
                                        sb2.append(str10);
                                        sb2.append("copy error");
                                        e(str10, "2", sb2.toString(), null, null, false, jSONObject2);
                                    }
                                }
                            }
                            it2 = it;
                        }
                    }
                }
            }
            File file9 = new File(this.b, "filemeta_" + str + ".log");
            try {
                file9.createNewFile();
                ne9.g(jSONObject2.toString(), file9);
            } catch (IOException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            if (file9.exists()) {
                arrayList2.add(new le9.a(file9, file9.getName(), true));
            }
            if (d) {
                Log.d(str2, "start generate out zip file");
            }
            File file10 = new File(this.a, str);
            try {
                if (file10.exists()) {
                    file10.delete();
                }
                file10.createNewFile();
            } catch (IOException e3) {
                if (d) {
                    e3.printStackTrace();
                }
            }
            if (arrayList2.size() > 0) {
                le9.a(file10, arrayList2);
                File file11 = new File(file10.getAbsolutePath());
                if (d) {
                    Log.d(str2, "out put File: " + file11.getAbsolutePath());
                }
                return file11;
            }
            e(file10.getAbsolutePath(), "1", file10.getPath() + str3, null, null, true, jSONObject2);
            return file;
        }
        return (File) invokeCommon.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String str = AppRuntime.getAppContext().getApplicationInfo().dataDir + "/.voyager";
            File file = new File(str, "/upload/");
            this.a = file;
            if (!file.exists()) {
                this.a.mkdirs();
            }
            File file2 = new File(str, "/store/");
            this.b = file2;
            if (file2.exists()) {
                return;
            }
            this.b.mkdirs();
        }
    }

    public final void k(String str, String str2, File file, JSONObject jSONObject, zd9 zd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, file, jSONObject, zd9Var) == null) {
            String str3 = str + ".zip";
            String createObjectKey = BOSUploader.getInstance().createObjectKey(str2, str3);
            if (d) {
                Log.d("VoyagerFileManager", "bos object key is : " + createObjectKey);
            }
            l(str2, str3, file, new a(this, file, zd9Var, str3, createObjectKey, jSONObject, str));
        }
    }

    public final void l(String str, String str2, File file, xd9 xd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, file, xd9Var) == null) {
            this.c.execute(new b(this, str, str2, file, xd9Var));
        }
    }

    public final void m(@NonNull String str, @NonNull String str2, @NonNull File file, xd9 xd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, str, str2, file, xd9Var) == null) {
            BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync(str, str2, file);
            ae9 ae9Var = new ae9(uploadFileSync.isSuccess(), uploadFileSync.getErrorCode(), uploadFileSync.getMessage());
            if (xd9Var != null) {
                xd9Var.a(ae9Var);
            }
        }
    }
}
