package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.IDevices;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes6.dex */
public class li {
    public static /* synthetic */ Interceptable $ic;
    public static li a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public StringBuilder c;
        public mi d;
        public boolean e;
        public final /* synthetic */ li f;

        public a(li liVar, String str, String str2, StringBuilder sb, mi miVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liVar, str, str2, sb, miVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = liVar;
            this.a = str;
            this.b = str2;
            this.c = sb;
            this.d = miVar;
            this.e = false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                boolean g = this.f.g(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.a, this.c);
                this.e = g;
                if (g) {
                    return null;
                }
                this.f.c(this.b, "".getBytes(), this.c);
                return null;
            }
            return invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                super.onPostExecute(obj);
                if (this.c.length() > 0) {
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    bdStatisticsManager.error("so", "load_" + this.a + ".so", "", -9101, this.c.toString(), new Object[0]);
                }
                mi miVar = this.d;
                if (miVar != null) {
                    miVar.a(this.e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964034520, "Lcom/repackage/li;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964034520, "Lcom/repackage/li;");
        }
    }

    public li() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static li d() {
        InterceptResult invokeV;
        li liVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            li liVar2 = a;
            if (liVar2 == null) {
                synchronized (li.class) {
                    if (a == null) {
                        a = new li();
                    }
                    liVar = a;
                }
                return liVar;
            }
            return liVar2;
        }
        return (li) invokeV.objValue;
    }

    public final void c(String str, byte[] bArr, StringBuilder sb) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bArr, sb) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(str));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(bArr);
                mg.d(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                sb.append("-Error4:");
                sb.append(e.getClass().getName() + "-" + e.getMessage());
                sb.append("-");
                mg.d(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                mg.d(fileOutputStream2);
                throw th;
            }
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "lib" + File.separator + "lib" + str + ".so";
        }
        return (String) invokeL.objValue;
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "files" + File.separator + "lib" + str + ".so";
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0125 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.InputStream] */
    public final boolean g(String str, String str2, StringBuilder sb) {
        InterceptResult invokeLLL;
        Throwable th;
        ZipInputStream zipInputStream;
        IOException e;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, sb)) == null) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("lib");
            sb2.append(File.separator);
            sb2.append("x86");
            sb2.append(File.separator);
            sb2.append("lib");
            sb2.append(str2);
            ?? r4 = ".so";
            sb2.append(".so");
            arrayList.add(sb2.toString());
            arrayList.add("lib" + File.separator + IDevices.ABI_MIPS + File.separator + "lib" + str2 + ".so");
            arrayList.add("lib" + File.separator + "armeabi" + File.separator + "lib" + str2 + ".so");
            File file = new File(str);
            boolean z = false;
            if (file.exists()) {
                try {
                    try {
                        zipInputStream = new ZipInputStream(new FileInputStream(file));
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                ZipEntry nextEntry = zipInputStream.getNextEntry();
                                if (nextEntry == null) {
                                    break;
                                } else if (arrayList.contains(nextEntry.getName())) {
                                    try {
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        while (true) {
                                            try {
                                                int read = zipInputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr, 0, read);
                                            } catch (Exception unused) {
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                mg.d(byteArrayOutputStream);
                                                throw th2;
                                            }
                                        }
                                        byteArrayOutputStream.flush();
                                        String f = f(str2);
                                        c(f, byteArrayOutputStream.toByteArray(), sb);
                                        if (k(f, sb)) {
                                            sb.append("-Succ5-");
                                            z = true;
                                            mg.d(byteArrayOutputStream);
                                            break;
                                        }
                                    } catch (Exception unused2) {
                                        byteArrayOutputStream = null;
                                    } catch (Throwable th4) {
                                        byteArrayOutputStream = null;
                                        th2 = th4;
                                    }
                                    mg.d(byteArrayOutputStream);
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            sb.append("-Error5:");
                            sb.append(e.getClass().getName() + "-" + e.getMessage());
                            sb.append("-");
                            mg.c(zipInputStream);
                            return z;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        mg.c(r4);
                        throw th;
                    }
                } catch (IOException e3) {
                    zipInputStream = null;
                    e = e3;
                } catch (Throwable th6) {
                    r4 = 0;
                    th = th6;
                    mg.c(r4);
                    throw th;
                }
                mg.c(zipInputStream);
                return z;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public boolean h(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            StringBuilder sb = new StringBuilder();
            if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
                return false;
            }
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z = j(str, sb);
                if (z) {
                    break;
                }
            }
            if (!z) {
                String f = f(str);
                File file = new File(f);
                if (file.exists()) {
                    if (file.length() > 0) {
                        z = k(f, sb);
                        if (z) {
                            sb.append("-Succ2-");
                        } else {
                            sb.append("-Error7-");
                        }
                    } else {
                        sb.append("-Error6:soSize1-");
                    }
                }
            }
            if (sb.length() > 0) {
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                bdStatisticsManager.error("so", "load_" + str + ".so", "", -9101, sb.toString(), new Object[0]);
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    public boolean i(String str, int i, mi miVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, str, i, miVar)) == null) {
            StringBuilder sb = new StringBuilder();
            if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
                return false;
            }
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z = j(str, sb);
                if (z) {
                    break;
                }
            }
            if (!z) {
                String f = f(str);
                File file = new File(f);
                if (file.exists()) {
                    if (file.length() > 0) {
                        z = k(f, sb);
                        if (z) {
                            sb.append("-Succ2-");
                        } else {
                            sb.append("-Error7-");
                        }
                    } else {
                        sb.append("-Error6:soSize1-");
                    }
                } else {
                    a aVar = new a(this, str, f, sb, miVar);
                    aVar.setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen()));
                    aVar.execute(new Object[0]);
                    return false;
                }
            }
            if (sb.length() > 0) {
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                bdStatisticsManager.error("so", "load_" + str + ".so", "", -9101, sb.toString(), new Object[0]);
            }
            return z;
        }
        return invokeLIL.booleanValue;
    }

    public final boolean j(String str, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, sb)) == null) {
            boolean k = k(e(str), sb);
            if (k) {
                return k;
            }
            try {
                System.loadLibrary(str);
                sb.append("-Succ3-");
                return true;
            } catch (Throwable th) {
                sb.append("-Error3:");
                sb.append(th.getClass().getName() + "-" + th.getMessage());
                sb.append("-");
                return k;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean k(String str, StringBuilder sb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, sb)) == null) {
            if (!new File(str).exists()) {
                sb.append("-Error1:");
                sb.append(str);
                sb.append("_FileNotFound-");
            } else {
                try {
                    System.load(str);
                    return true;
                } catch (Throwable th) {
                    sb.append("-Error2:");
                    sb.append(th.getClass().getName() + "-" + th.getMessage());
                    sb.append("-");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
