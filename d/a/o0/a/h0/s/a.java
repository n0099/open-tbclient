package d.a.o0.a.h0.s;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.a.o0.a.h2.f;
import d.a.o0.a.k;
import d.a.o0.a.k2.g.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45690a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f45691b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f45692c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f45693d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447609254, "Ld/a/o0/a/h0/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447609254, "Ld/a/o0/a/h0/s/a;");
                return;
            }
        }
        f45690a = k.f46335a;
        f45691b = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + ZeusWebViewPreloadClass.ZEUS_FILE_DIR + File.separator + "libs";
        StringBuilder sb = new StringBuilder();
        sb.append(AppRuntime.getAppContext().getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append("libs");
        f45692c = sb.toString();
        f45693d = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        FileLock fileLock;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65537, null) != null) {
            return;
        }
        if (f45690a) {
            Log.d("SwanSailorHelper", "fixSoLoadCrash: start");
        }
        File file = new File(f45691b + File.separator + GlobalConstants.LIB_ZEUS_V8);
        if (file.exists() && file.length() > 0) {
            File file2 = new File(f45692c);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, GlobalConstants.LIB_ZEUS_V8);
            long j = h.a().getLong("zeus_v8_modified_time", -1L);
            if (file.lastModified() == j && file.length() == file3.length()) {
                if (f45690a) {
                    Log.d("SwanSailorHelper", "fixSoLoadCrash: srcModifiedTime=" + file.lastModified() + ";savedModifiedTime=" + j + ";srcFileLength=" + file.length() + ";destFileLength=" + file3.length());
                    return;
                }
                return;
            }
            if (f45690a) {
                Log.d("SwanSailorHelper", "fixSoLoadCrash: start copy");
            }
            FileInputStream fileInputStream = null;
            try {
                File file4 = new File(file2, "libzeusv8.so.lock");
                if (!file4.exists()) {
                    try {
                        file4.createNewFile();
                    } catch (IOException unused) {
                    }
                }
                FileChannel channel = new RandomAccessFile(file4, "rw").getChannel();
                try {
                    fileLock = channel.lock();
                    if (fileLock != null) {
                        try {
                            if (fileLock.isValid()) {
                                long lastModified = file.lastModified();
                                FileInputStream fileInputStream2 = new FileInputStream(file);
                                try {
                                    fileOutputStream = new FileOutputStream(file3);
                                    try {
                                        byte[] bArr = new byte[8192];
                                        while (true) {
                                            int read = fileInputStream2.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                        fileOutputStream.flush();
                                        h.a().putLong("zeus_v8_modified_time", lastModified);
                                        fileInputStream = fileInputStream2;
                                        d.a.o0.t.d.d(fileInputStream);
                                        d.a.o0.t.d.d(fileOutputStream);
                                        if (fileLock != null) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                        d.a.o0.t.d.d(channel);
                                    } catch (Exception e3) {
                                        fileChannel = channel;
                                        e = e3;
                                        fileInputStream = fileInputStream2;
                                        try {
                                            e.printStackTrace();
                                            d.a.o0.t.d.d(fileInputStream);
                                            d.a.o0.t.d.d(fileOutputStream);
                                            if (fileLock != null) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e4) {
                                                    e4.printStackTrace();
                                                }
                                            }
                                            d.a.o0.t.d.d(fileChannel);
                                            return;
                                        } catch (Throwable th) {
                                            th = th;
                                            d.a.o0.t.d.d(fileInputStream);
                                            d.a.o0.t.d.d(fileOutputStream);
                                            if (fileLock != null) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e5) {
                                                    e5.printStackTrace();
                                                }
                                            }
                                            d.a.o0.t.d.d(fileChannel);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        fileChannel = channel;
                                        th = th2;
                                        fileInputStream = fileInputStream2;
                                        d.a.o0.t.d.d(fileInputStream);
                                        d.a.o0.t.d.d(fileOutputStream);
                                        if (fileLock != null) {
                                        }
                                        d.a.o0.t.d.d(fileChannel);
                                        throw th;
                                    }
                                } catch (Exception e6) {
                                    fileChannel = channel;
                                    e = e6;
                                    fileOutputStream = null;
                                } catch (Throwable th3) {
                                    fileChannel = channel;
                                    th = th3;
                                    fileOutputStream = null;
                                }
                            }
                        } catch (Exception e7) {
                            fileChannel = channel;
                            e = e7;
                            fileOutputStream = null;
                        } catch (Throwable th4) {
                            fileChannel = channel;
                            th = th4;
                            fileOutputStream = null;
                        }
                    }
                    fileOutputStream = null;
                    d.a.o0.t.d.d(fileInputStream);
                    d.a.o0.t.d.d(fileOutputStream);
                    if (fileLock != null) {
                    }
                    d.a.o0.t.d.d(channel);
                } catch (Exception e8) {
                    fileChannel = channel;
                    fileOutputStream = null;
                    e = e8;
                    fileLock = null;
                } catch (Throwable th5) {
                    fileChannel = channel;
                    fileOutputStream = null;
                    th = th5;
                    fileLock = null;
                }
            } catch (Exception e9) {
                e = e9;
                fileLock = null;
                fileOutputStream = null;
                fileChannel = null;
            } catch (Throwable th6) {
                th = th6;
                fileLock = null;
                fileOutputStream = null;
                fileChannel = null;
            }
        } else if (f45690a) {
            Log.d("SwanSailorHelper", "fixSoLoadCrash: srcFile is not exist");
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true) : invokeV.booleanValue;
    }

    public static f c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            if (z) {
                return f.c(SoLoader.load(AppRuntime.getAppContext(), "v8.engine"));
            }
            boolean z2 = true;
            if (b()) {
                a();
                d.g(AppRuntime.getAppContext(), f45691b);
                boolean h2 = d.h("zeusv8", f45692c, true);
                if (new File(f45691b + File.separator + "libv8.engine.so").exists()) {
                    if (!d.h("arcore_sdk_c", f45691b, false) || !d.h("arcore_sdk_jni", f45691b, false) || !d.h("c++_shared", f45691b, false) || !d.h("v8.engine", f45691b, false)) {
                        z2 = false;
                    }
                } else {
                    z2 = SoLoader.load(AppRuntime.getAppContext(), "v8.engine");
                }
                return f.d(h2, z2);
            }
            d.h("zeusv8", f45693d, true);
            return f.c(d.h("v8.engine", f45693d, true));
        }
        return (f) invokeZ.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            h.a().putLong("zeus_v8_modified_time", -1L);
            if (f45690a) {
                Log.d("SwanSailorHelper", "fixSoLoadCrash: resetZeusV8ModifiedTime");
            }
        }
    }
}
