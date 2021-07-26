package d.a.l.g;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.l.d.b.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f43353a;

    /* renamed from: b  reason: collision with root package name */
    public C0625a f43354b;

    /* renamed from: d.a.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C0625a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public File f43355a;

        /* renamed from: b  reason: collision with root package name */
        public String f43356b;

        /* renamed from: c  reason: collision with root package name */
        public C0625a f43357c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f43358d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f43359e;

        public C0625a(a aVar, File file) {
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
            this.f43359e = aVar;
            this.f43358d = false;
            this.f43358d = true;
            this.f43355a = file;
            this.f43356b = file.getName();
        }

        public C0625a(a aVar, String str, C0625a c0625a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, c0625a};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f43359e = aVar;
            this.f43358d = false;
            this.f43356b = str;
            this.f43357c = c0625a;
            this.f43358d = false;
        }

        public C0625a a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                if (this.f43358d) {
                    throw new IllegalStateException("isolate session is not support");
                }
                ArrayList arrayList = new ArrayList();
                C0625a c0625a = this;
                do {
                    arrayList.add(c0625a.h());
                    c0625a = c0625a.i();
                } while (c0625a != null);
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    size--;
                    file = new File(file, (String) arrayList.get(size));
                }
                return new C0625a(this.f43359e, file);
            }
            return (C0625a) invokeL.objValue;
        }

        public C0625a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? new C0625a(this.f43359e, str, this) : (C0625a) invokeL.objValue;
        }

        public String c(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) ? a.b(f(), str, "UTF-8", z) : (String) invokeLZ.objValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                f().mkdirs();
            }
        }

        public boolean e(String str, String str2, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, str, str2, z)) == null) ? a.d(f(), str, str2, "UTF-8", z) : invokeLLZ.booleanValue;
        }

        public File f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                File file = this.f43355a;
                if (file != null) {
                    return file;
                }
                File file2 = this.f43357c == null ? new File(this.f43359e.a(), this.f43356b) : new File(this.f43357c.f(), this.f43356b);
                this.f43355a = file2;
                return file2;
            }
            return (File) invokeV.objValue;
        }

        public File g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? new File(this.f43355a, str) : (File) invokeL.objValue;
        }

        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43356b : (String) invokeV.objValue;
        }

        public C0625a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f43357c : (C0625a) invokeV.objValue;
        }
    }

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
        this.f43353a = context;
        f().mkdirs();
    }

    public static String b(File file, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{file, str, str2, Boolean.valueOf(z)})) != null) {
            return (String) invokeCommon.objValue;
        }
        c(file);
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
                        byteArray = new c().b(byteArray);
                    }
                    String str3 = new String(byteArray, str2);
                    d.a.l.i.c.b(fileInputStream);
                    d.a.l.i.c.b(byteArrayOutputStream);
                    return str3;
                } catch (Exception unused) {
                    fileInputStream2 = fileInputStream;
                    d.a.l.i.c.b(fileInputStream2);
                    d.a.l.i.c.b(byteArrayOutputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    d.a.l.i.c.b(fileInputStream);
                    d.a.l.i.c.b(byteArrayOutputStream);
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

    public static void c(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            file.mkdirs();
        }
    }

    public static boolean d(File file, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{file, str, str2, str3, Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        c(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                if (z) {
                    fileOutputStream.write(new c().a(str2.getBytes()));
                } else {
                    fileOutputStream.write(str2.getBytes(str3));
                }
                d.a.l.i.c.b(fileOutputStream);
                return true;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                d.a.l.i.c.b(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                d.a.l.i.c.b(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(this.f43353a.getApplicationInfo().dataDir) : (File) invokeV.objValue;
    }

    public synchronized C0625a e() {
        InterceptResult invokeV;
        C0625a c0625a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (this.f43354b == null) {
                    this.f43354b = new C0625a(this, ".cesium", null);
                }
                c0625a = this.f43354b;
            }
            return c0625a;
        }
        return (C0625a) invokeV.objValue;
    }

    public final File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new File(a(), ".cesium") : (File) invokeV.objValue;
    }
}
