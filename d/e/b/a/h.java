package d.e.b.a;

import android.os.Process;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes8.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public StringBuffer f69169d;

    /* renamed from: e  reason: collision with root package name */
    public int f69170e;

    /* renamed from: f  reason: collision with root package name */
    public long f69171f;

    /* renamed from: g  reason: collision with root package name */
    public long f69172g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(long j) {
        super(j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69169d = new StringBuffer();
        this.f69170e = 0;
        this.f69171f = 0L;
        this.f69172g = 0L;
    }

    @Override // d.e.b.a.a
    public void b() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String readLine;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f69169d.setLength(0);
            BufferedReader bufferedReader3 = null;
            try {
                try {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
                    try {
                        readLine = bufferedReader2.readLine();
                        str = "";
                        if (readLine == null) {
                            readLine = "";
                        }
                        if (this.f69170e == 0) {
                            this.f69170e = Process.myPid();
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + this.f69170e + "/stat")), 1000);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                try {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 != null) {
                        str = readLine2;
                    }
                    f(readLine, str);
                    bufferedReader2.close();
                    bufferedReader.close();
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader3 = bufferedReader2;
                    try {
                        Log.e("SampleCpuSampler", "doSample: ", th);
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Throwable th4) {
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e2) {
                                Log.e("SampleCpuSampler", "doSample: ", e2);
                                throw th4;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th4;
                    }
                }
            } catch (IOException e3) {
                Log.e("SampleCpuSampler", "doSample: ", e3);
            }
        }
    }

    @Override // d.e.b.a.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            g();
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69169d.toString() : (String) invokeV.objValue;
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            String[] split = str.split(" ");
            if (split.length < 9) {
                return;
            }
            long parseLong = Long.parseLong(split[2]);
            long parseLong2 = Long.parseLong(split[3]);
            long parseLong3 = Long.parseLong(split[4]);
            long parseLong4 = Long.parseLong(split[5]);
            long parseLong5 = parseLong + parseLong2 + parseLong3 + parseLong4 + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            if (str2.split(" ").length < 17) {
                return;
            }
            if (parseLong5 != 0) {
                long j = parseLong5 - this.f69172g;
                this.f69169d.append(((j - (parseLong4 - this.f69171f)) * 100) / j);
            }
            this.f69171f = parseLong4;
            this.f69172g = parseLong5;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f69171f = 0L;
            this.f69172g = 0L;
        }
    }
}
