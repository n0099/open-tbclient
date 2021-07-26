package d.a.s.g.d;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.g.b.b;
import d.a.s.g.c.a.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67915a;

    /* renamed from: b  reason: collision with root package name */
    public C1904a f67916b;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67915a = context;
        c().mkdirs();
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, file) == null) {
            file.mkdirs();
        }
    }

    public static String e(File file, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{file, str, str2, Boolean.valueOf(z)})) != null) {
            return (String) invokeCommon.objValue;
        }
        a(file);
        File file2 = new File(file, str);
        FileInputStream fileInputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (z) {
                        byteArray = new b().a(byteArray);
                    }
                    String str3 = new String(byteArray, str2);
                    c.b(fileInputStream);
                    c.b(byteArrayOutputStream);
                    return str3;
                } catch (Exception unused) {
                    fileInputStream2 = fileInputStream;
                    c.b(fileInputStream2);
                    c.b(byteArrayOutputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    c.b(fileInputStream);
                    c.b(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        } catch (Exception unused3) {
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static boolean f(File file, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{file, str, str2, str3, Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        a(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                if (z) {
                    fileOutputStream.write(new b().b(str2.getBytes(str3)));
                } else {
                    fileOutputStream.write(str2.getBytes(str3));
                }
                c.b(fileOutputStream);
                return true;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                c.b(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                c.b(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(this.f67915a.getApplicationInfo().dataDir) : (File) invokeV.objValue;
    }

    public final File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new File(b(), ".helios") : (File) invokeV.objValue;
    }

    public synchronized C1904a d() {
        InterceptResult invokeV;
        C1904a c1904a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.f67916b == null) {
                    this.f67916b = new C1904a(this, ".helios", null);
                }
                c1904a = this.f67916b;
            }
            return c1904a;
        }
        return (C1904a) invokeV.objValue;
    }

    /* renamed from: d.a.s.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C1904a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public File f67917a;

        /* renamed from: b  reason: collision with root package name */
        public String f67918b;

        /* renamed from: c  reason: collision with root package name */
        public C1904a f67919c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67920d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67921e;

        public C1904a(a aVar, String str, C1904a c1904a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, c1904a};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f67921e = aVar;
            this.f67920d = false;
            this.f67918b = str;
            this.f67919c = c1904a;
            this.f67920d = false;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b().mkdirs();
            }
        }

        public File b() {
            InterceptResult invokeV;
            File file;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                File file2 = this.f67917a;
                if (file2 != null) {
                    return file2;
                }
                if (this.f67919c == null) {
                    file = new File(this.f67921e.b(), this.f67918b);
                } else {
                    file = new File(this.f67919c.b(), this.f67918b);
                }
                this.f67917a = file;
                return file;
            }
            return (File) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67918b : (String) invokeV.objValue;
        }

        public File d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? new File(this.f67917a, str) : (File) invokeL.objValue;
        }

        public C1904a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67919c : (C1904a) invokeV.objValue;
        }

        public C1904a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? new C1904a(this.f67921e, str, this) : (C1904a) invokeL.objValue;
        }

        public String g(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) ? a.e(b(), str, "UTF-8", z) : (String) invokeLZ.objValue;
        }

        public C1904a h(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
                if (!this.f67920d) {
                    ArrayList arrayList = new ArrayList();
                    C1904a c1904a = this;
                    do {
                        arrayList.add(c1904a.c());
                        c1904a = c1904a.e();
                    } while (c1904a != null);
                    int size = arrayList.size() - 1;
                    while (size >= 0) {
                        size--;
                        file = new File(file, (String) arrayList.get(size));
                    }
                    return new C1904a(this.f67921e, file);
                }
                throw new IllegalStateException("isolate session is not support");
            }
            return (C1904a) invokeL.objValue;
        }

        public boolean i(String str, String str2, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, z)) == null) ? a.f(b(), str, str2, "UTF-8", z) : invokeLLZ.booleanValue;
        }

        public C1904a(a aVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67921e = aVar;
            this.f67920d = false;
            this.f67920d = true;
            this.f67917a = file;
            this.f67918b = file.getName();
        }
    }
}
