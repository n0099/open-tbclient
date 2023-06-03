package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes10.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;
    public final File b;
    public String c;
    public int d;
    public String e;

    public g(File file, File file2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, file2};
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
        this.b = file2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x003e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.BufferedReader] */
    private String a(File file) throws IOException {
        InterceptResult invokeL;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, file)) == null) {
            ?? r1 = 0;
            if (file != null) {
                try {
                    if (file.exists()) {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                            try {
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                }
                                String sb2 = sb.toString();
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                    GDTLogger.d("Exception while close bufferreader");
                                }
                                return sb2;
                            } catch (IOException e) {
                                throw e;
                            }
                        } catch (IOException e2) {
                            throw e2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (r1 != 0) {
                                try {
                                    r1.close();
                                } catch (Exception unused2) {
                                    GDTLogger.d("Exception while close bufferreader");
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    r1 = file;
                    th = th3;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public boolean a(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, file2)) == null) ? (file.equals(this.a) || h.a(this.a, file)) && (file2.equals(this.b) || h.a(this.b, file2)) : invokeLL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.b.exists() && this.a.exists()) {
                    String a = a(this.b);
                    this.e = a;
                    if (TextUtils.isEmpty(a)) {
                        return false;
                    }
                    String[] split = this.e.split("#####");
                    if (split.length == 2) {
                        String str = split[1];
                        try {
                            i = Integer.parseInt(split[0]);
                        } catch (Throwable unused) {
                            i = 0;
                        }
                        if (c.b.a.a(str, this.a)) {
                            this.c = str;
                            this.d = i;
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable unused2) {
                GDTLogger.d("Exception while checking plugin");
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
