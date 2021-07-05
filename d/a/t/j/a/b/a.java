package d.a.t.j.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.t.g.c.a.c;
import d.a.t.g.c.a.d;
import d.a.t.g.c.a.f;
import d.a.t.g.d.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f70464f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f70465a;

    /* renamed from: b  reason: collision with root package name */
    public Context f70466b;

    /* renamed from: c  reason: collision with root package name */
    public a.C1937a f70467c;

    /* renamed from: d  reason: collision with root package name */
    public ZipFile f70468d;

    /* renamed from: e  reason: collision with root package name */
    public PackageManager f70469e;

    /* renamed from: d.a.t.j.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1947a implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1947a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? str.endsWith(".cfgtmp") : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f70470a;

        public b() {
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

        public static b a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
                try {
                    String b2 = aVar.b("info");
                    if (TextUtils.isEmpty(b2)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(b2);
                    b bVar = new b();
                    bVar.f70470a = jSONObject.getLong("version");
                    return bVar;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1036238778, "Ld/a/t/j/a/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1036238778, "Ld/a/t/j/a/b/a;");
                return;
            }
        }
        f70464f = new String[]{"f0fb772cce0da4ed791213b800defea286494ab98d00e1101cbf78a35e70ec4b"};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                Bundle bundle = this.f70469e.getPackageInfo(this.f70465a, 128).applicationInfo.metaData;
                if (bundle != null) {
                    String string = bundle.getString("com.baidu.helios.tc.qver");
                    if (TextUtils.isEmpty(string) || !string.startsWith("v")) {
                        return -1L;
                    }
                    return Long.valueOf(string.substring(1)).longValue();
                }
                return -1L;
            } catch (Throwable unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = e(str);
                    return d.b(inputStream, "UTF-8");
                } catch (IOException e2) {
                    throw new TrustSubject.ConfigNotFoundException(e2);
                }
            } finally {
                c.b(inputStream);
            }
        }
        return (String) invokeL.objValue;
    }

    public void c(String str, Context context, a.C1937a c1937a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, context, c1937a) == null) {
            this.f70465a = str;
            this.f70466b = context;
            this.f70467c = c1937a;
            this.f70469e = context.getPackageManager();
        }
    }

    public int d() {
        File file;
        FileOutputStream fileOutputStream;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return invokeV.intValue;
        }
        try {
            AssetManager assets = this.f70466b.createPackageContext(this.f70465a, 0).getAssets();
            this.f70467c.a();
            File k = k();
            InputStream inputStream = null;
            try {
                k.delete();
                file = File.createTempFile("cfg", ".cfgtmp", k.getParentFile());
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        try {
                            inputStream = assets.open("com.baidu.helios/c.dat");
                            d.a(inputStream, fileOutputStream, 16384);
                            try {
                                X509Certificate[][] s = com.baidu.helios.trusts.zone.verifier.b.s(file);
                                if (s.length == 0) {
                                    c.b(inputStream);
                                    c.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    return 3;
                                }
                                HashSet hashSet = new HashSet();
                                for (X509Certificate[] x509CertificateArr : s) {
                                    if (x509CertificateArr != null) {
                                        for (X509Certificate x509Certificate : x509CertificateArr) {
                                            if (x509Certificate != null) {
                                                hashSet.add(f.c(x509Certificate.getSignature()));
                                            }
                                        }
                                    }
                                }
                                HashSet hashSet2 = new HashSet();
                                Collections.addAll(hashSet2, f70464f);
                                if (!hashSet2.equals(hashSet)) {
                                    c.b(inputStream);
                                    c.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    return 3;
                                }
                                file.renameTo(k);
                                c.b(inputStream);
                                c.b(fileOutputStream);
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Exception unused3) {
                                    }
                                }
                                return 0;
                            } catch (Exception unused4) {
                                c.b(inputStream);
                                c.b(fileOutputStream);
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Exception unused5) {
                                    }
                                }
                                return 3;
                            }
                        } catch (Throwable th) {
                            th = th;
                            c.b(inputStream);
                            c.b(fileOutputStream);
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Exception unused6) {
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused7) {
                        c.b(inputStream);
                        c.b(fileOutputStream);
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Exception unused8) {
                            }
                        }
                        return 5;
                    } catch (IOException unused9) {
                        c.b(inputStream);
                        c.b(fileOutputStream);
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Exception unused10) {
                            }
                        }
                        return 2;
                    } catch (Exception unused11) {
                        c.b(inputStream);
                        c.b(fileOutputStream);
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Exception unused12) {
                            }
                        }
                        return 4;
                    }
                } catch (FileNotFoundException unused13) {
                    fileOutputStream = null;
                } catch (IOException unused14) {
                    fileOutputStream = null;
                } catch (Exception unused15) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (FileNotFoundException unused16) {
                file = null;
                fileOutputStream = null;
            } catch (IOException unused17) {
                file = null;
                fileOutputStream = null;
            } catch (Exception unused18) {
                file = null;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                file = null;
                fileOutputStream = null;
            }
        } catch (Exception unused19) {
            return 1;
        }
    }

    public final InputStream e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return this.f70468d.getInputStream(new ZipEntry(str));
            } catch (Exception e2) {
                throw new TrustSubject.ConfigNotFoundException(e2);
            }
        }
        return (InputStream) invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k().delete() : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            File[] listFiles = this.f70467c.b().listFiles(new C1947a(this));
            int i2 = 0;
            if (listFiles != null) {
                int length = listFiles.length;
                boolean z = false;
                while (i2 < length) {
                    listFiles[i2].delete();
                    i2++;
                    z = true;
                }
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f70468d != null) {
                return true;
            }
            File k = k();
            if (k.exists()) {
                try {
                    this.f70468d = new ZipFile(k);
                    return true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ZipFile zipFile = this.f70468d;
            if (zipFile != null) {
                c.d(zipFile);
                this.f70468d = null;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b a2 = b.a(this);
            if (a2 != null) {
                return a2.f70470a;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f70467c.d("c.dat") : (File) invokeV.objValue;
    }
}
