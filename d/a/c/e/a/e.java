package d.a.c.e.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.a.b f41012a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f41013b;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f41014c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41015a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-42037214, "Ld/a/c/e/a/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-42037214, "Ld/a/c/e/a/e$a;");
                    return;
                }
            }
            int[] iArr = new int[DiskFileOperate.Action.values().length];
            f41015a = iArr;
            try {
                iArr[DiskFileOperate.Action.WRITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41015a[DiskFileOperate.Action.WRITE_FORCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41015a[DiskFileOperate.Action.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41015a[DiskFileOperate.Action.DELETE_FILES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41015a[DiskFileOperate.Action.APPEND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41015a[DiskFileOperate.Action.APPEND_MORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41015a[DiskFileOperate.Action.INFO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41015a[DiskFileOperate.Action.RENAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41015a[DiskFileOperate.Action.READ.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41015a[DiskFileOperate.Action.CUSTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a(e eVar, DiskFileOperate diskFileOperate, d.a.c.e.a.b bVar);
    }

    public e(d.a.c.e.a.b bVar, DiskFileOperate diskFileOperate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, diskFileOperate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41012a = null;
        this.f41013b = null;
        this.f41014c = null;
        if (bVar != null && diskFileOperate != null && diskFileOperate.getAction() != null) {
            this.f41013b = new AtomicBoolean(false);
            this.f41012a = bVar;
            this.f41014c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskWorker Parameter is null");
    }

    public boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            OutputStream outputStream = this.f41014c.getOutputStream();
            File fileInfo = this.f41014c.getFileInfo();
            try {
                if (outputStream == null) {
                    try {
                        fileInfo = this.f41012a.c(this.f41014c.buildPath(), this.f41014c.getName(), true, this.f41014c.isSdCard(), this.f41014c.isSavedCache());
                        if (fileInfo != null && !this.f41013b.get()) {
                            outputStream = new FileOutputStream(fileInfo, true);
                        }
                        this.f41014c.unLock();
                        return false;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        if (!z) {
                            d.a.c.e.m.a.d(outputStream);
                        }
                        this.f41014c.unLock();
                        return false;
                    }
                }
                byte[] buildFormatData = this.f41014c.buildFormatData();
                byte[] data = this.f41014c.getData();
                if ((buildFormatData == null && data == null) || this.f41013b.get()) {
                    if (!z) {
                        d.a.c.e.m.a.d(outputStream);
                    }
                    this.f41014c.unLock();
                    return false;
                }
                if (buildFormatData != null) {
                    outputStream.write(buildFormatData);
                }
                if (data != null) {
                    outputStream.write(data);
                }
                outputStream.flush();
                this.f41014c.setFileInfo(fileInfo);
                this.f41014c.setSuccess(true);
                if (!z) {
                    d.a.c.e.m.a.d(outputStream);
                } else {
                    this.f41014c.setOutputStream(outputStream);
                }
                this.f41014c.unLock();
                return true;
            } catch (Throwable th) {
                if (!z) {
                    d.a.c.e.m.a.d(outputStream);
                }
                this.f41014c.unLock();
                throw th;
            }
        }
        return invokeZ.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            switch (a.f41015a[this.f41014c.getAction().ordinal()]) {
                case 1:
                    return k(false);
                case 2:
                    return k(true);
                case 3:
                    return e();
                case 4:
                    return g();
                case 5:
                    return a(false);
                case 6:
                    return a(true);
                case 7:
                    return h();
                case 8:
                    return j();
                case 9:
                    return i();
                case 10:
                    return d();
                default:
                    return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f41013b.set(true);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                try {
                    r0 = this.f41014c.getCustomOperate() != null ? this.f41014c.getCustomOperate().a(this, this.f41014c, this.f41012a) : false;
                    if (r0) {
                        this.f41014c.setSuccess(true);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                return r0;
            } finally {
                this.f41014c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        File c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                try {
                    c2 = this.f41012a.c(this.f41014c.buildPath(), this.f41014c.getName(), false, this.f41014c.isSdCard(), this.f41014c.isSavedCache());
                } catch (Exception e2) {
                    e2.getMessage();
                }
                if (c2 != null && !this.f41013b.get()) {
                    r0 = c2.exists() ? c2.delete() : false;
                    if (r0) {
                        this.f41014c.setFileInfo(c2);
                        this.f41014c.setSuccess(true);
                    }
                    return r0;
                }
                return false;
            } finally {
                this.f41014c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean f(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, file)) == null) {
            if (file != null) {
                DiskFileOperate diskFileOperate = this.f41014c;
                if (diskFileOperate instanceof d.a.c.e.a.a) {
                    d.a.c.e.a.a aVar = (d.a.c.e.a.a) diskFileOperate;
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            for (int i2 = 0; i2 < listFiles.length && !this.f41013b.get(); i2++) {
                                if (listFiles[i2].isDirectory()) {
                                    f(listFiles[i2]);
                                } else if (aVar.compare(listFiles[i2])) {
                                    listFiles[i2].delete();
                                }
                            }
                        }
                        file.delete();
                    } else if (aVar.compare(file)) {
                        file.delete();
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            boolean z = false;
            try {
                try {
                    File d2 = this.f41012a.d(this.f41014c.getPath(), false, this.f41014c.isSdCard(), this.f41014c.isSavedCache());
                    z = f(d2);
                    if (z) {
                        this.f41014c.setFileInfo(d2);
                        this.f41014c.setSuccess(true);
                    }
                } catch (Exception e2) {
                    e2.getMessage();
                }
                return z;
            } finally {
                this.f41014c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        File d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f41014c.getName() != null) {
                d2 = this.f41012a.c(this.f41014c.buildPath(), this.f41014c.getName(), false, this.f41014c.isSdCard(), this.f41014c.isSavedCache());
            } else {
                d2 = this.f41012a.d(this.f41014c.buildPath(), false, this.f41014c.isSdCard(), this.f41014c.isSavedCache());
            }
            if (d2 != null && d2.exists()) {
                this.f41014c.setFileInfo(d2);
                this.f41014c.setSuccess(true);
                this.f41014c.unLock();
                return true;
            }
            this.f41014c.unLock();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        Exception e2;
        Throwable th;
        File c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.f41014c.startLog();
            boolean z = false;
            try {
                c2 = this.f41012a.c(this.f41014c.buildPath(), this.f41014c.getName(), false, this.f41014c.isSdCard(), this.f41014c.isSavedCache());
            } catch (Exception e3) {
                fileInputStream = null;
                e2 = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                fileInputStream = null;
            }
            if (c2 != null && c2.exists() && !this.f41013b.get()) {
                fileInputStream = new FileInputStream(c2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr, 0, 1024);
                                if (read == -1 || this.f41013b.get()) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            if (!this.f41013b.get()) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (!this.f41014c.isFormatData() || this.f41014c.formatData(byteArray)) {
                                    this.f41014c.setData(byteArray);
                                    z = true;
                                }
                            }
                            d.a.c.e.m.a.c(fileInputStream);
                            d.a.c.e.m.a.d(byteArrayOutputStream);
                            if (z) {
                                this.f41014c.setSuccess(true);
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            BdLog.e(e2.getMessage());
                            d.a.c.e.m.a.c(fileInputStream);
                            d.a.c.e.m.a.d(byteArrayOutputStream);
                            this.f41014c.unLock();
                            this.f41014c.endLog();
                            return z;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        d.a.c.e.m.a.c(fileInputStream);
                        d.a.c.e.m.a.d(byteArrayOutputStream);
                        this.f41014c.unLock();
                        throw th;
                    }
                } catch (Exception e5) {
                    byteArrayOutputStream = null;
                    e2 = e5;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    th = th;
                    d.a.c.e.m.a.c(fileInputStream);
                    d.a.c.e.m.a.d(byteArrayOutputStream);
                    this.f41014c.unLock();
                    throw th;
                }
                this.f41014c.unLock();
                this.f41014c.endLog();
                return z;
            }
            d.a.c.e.m.a.c(null);
            d.a.c.e.m.a.d(null);
            this.f41014c.unLock();
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            boolean z = false;
            try {
                try {
                    File c2 = this.f41012a.c(this.f41014c.buildPath(), this.f41014c.getName(), false, this.f41014c.isSdCard(), this.f41014c.isSavedCache());
                    File c3 = this.f41012a.c(this.f41014c.buildDesPath(), this.f41014c.getDesName(), true, this.f41014c.isSdCard(), this.f41014c.isSavedCache());
                    if (c2 != null) {
                        if (c3 != null) {
                            c3.delete();
                        }
                        z = c2.renameTo(c3);
                    }
                    if (z) {
                        this.f41014c.setSuccess(true);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                return z;
            } finally {
                this.f41014c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeZ = interceptable.invokeZ(1048586, this, z)) != null) {
            return invokeZ.booleanValue;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File c2 = this.f41012a.c(this.f41014c.buildPath(), this.f41014c.getName(), true, this.f41014c.isSdCard(), this.f41014c.isSavedCache());
                if (c2 != null && !this.f41013b.get()) {
                    if (c2.exists()) {
                        if (z) {
                            c2.delete();
                        } else {
                            d.a.c.e.m.a.d(null);
                            this.f41014c.unLock();
                            return true;
                        }
                    }
                    byte[] buildFormatData = this.f41014c.buildFormatData();
                    byte[] data = this.f41014c.getData();
                    if ((buildFormatData != null || data != null) && !this.f41013b.get()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(c2);
                        if (buildFormatData != null) {
                            try {
                                fileOutputStream2.write(buildFormatData);
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                BdLog.e(e.getMessage());
                                d.a.c.e.m.a.d(fileOutputStream);
                                this.f41014c.unLock();
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                d.a.c.e.m.a.d(fileOutputStream);
                                this.f41014c.unLock();
                                throw th;
                            }
                        }
                        if (data != null) {
                            fileOutputStream2.write(data);
                        }
                        fileOutputStream2.flush();
                        d.a.c.e.m.a.d(fileOutputStream2);
                        this.f41014c.setFileInfo(c2);
                        this.f41014c.setSuccess(true);
                        this.f41014c.unLock();
                        return true;
                    }
                }
                d.a.c.e.m.a.d(null);
                this.f41014c.unLock();
                return false;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}
