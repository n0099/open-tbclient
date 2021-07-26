package d.a.p0.o0;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.utils.LaunchNativeUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f52861a;

    /* renamed from: b  reason: collision with root package name */
    public long f52862b;

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52861a = -1L;
        this.f52862b = -1L;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f52861a = SystemClock.elapsedRealtime();
            Process.getElapsedCpuTime();
        }
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00b5: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:44:0x00b5 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        BufferedReader bufferedReader;
        NumberFormatException e2;
        IOException e3;
        FileNotFoundException e4;
        Closeable closeable;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l.b().d();
            Closeable closeable2 = null;
            long j2 = -1;
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/stat")), 1000);
                    try {
                        String[] split = bufferedReader.readLine().split(" ");
                        if (split.length > 21 && split[0].equals(String.valueOf(Process.myPid()))) {
                            String str = split[21];
                            try {
                                SoLoader.load(AppRuntime.getAppContext(), "launch_native");
                                j = LaunchNativeUtils.getClkTck();
                            } catch (UnsatisfiedLinkError e5) {
                                Log.e("ZygoteSpeedStats", "load so failed, UnsatisfiedLinkError", e5);
                                j = 0;
                            }
                            Log.d("ZygoteSpeedStats", "_SC_CLK_TCK " + j);
                            if (j <= 0) {
                                j = 100;
                            }
                            j2 = (Long.parseLong(str) * 1000) / j;
                        }
                    } catch (FileNotFoundException e6) {
                        e4 = e6;
                        Log.e("ZygoteSpeedStats", "can't read process status file", e4);
                        Closeables.closeSafely(bufferedReader);
                        if (j2 <= 0) {
                        }
                    } catch (IOException e7) {
                        e3 = e7;
                        Log.e("ZygoteSpeedStats", "read process status failed", e3);
                        Closeables.closeSafely(bufferedReader);
                        if (j2 <= 0) {
                        }
                    } catch (NumberFormatException e8) {
                        e2 = e8;
                        Log.e("ZygoteSpeedStats", "parse status file failed", e2);
                        Closeables.closeSafely(bufferedReader);
                        if (j2 <= 0) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    Closeables.closeSafely(closeable2);
                    throw th;
                }
            } catch (FileNotFoundException e9) {
                bufferedReader = null;
                e4 = e9;
            } catch (IOException e10) {
                bufferedReader = null;
                e3 = e10;
            } catch (NumberFormatException e11) {
                bufferedReader = null;
                e2 = e11;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(closeable2);
                throw th;
            }
            Closeables.closeSafely(bufferedReader);
            if (j2 <= 0) {
                this.f52862b = this.f52861a - j2;
            }
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f52862b == -1) {
                b();
            }
            return this.f52862b;
        }
        return invokeV.longValue;
    }
}
