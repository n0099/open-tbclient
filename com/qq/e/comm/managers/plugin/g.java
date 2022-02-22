package com.qq.e.comm.managers.plugin;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;

    /* renamed from: b  reason: collision with root package name */
    public final File f59296b;

    /* renamed from: c  reason: collision with root package name */
    public String f59297c;

    /* renamed from: d  reason: collision with root package name */
    public int f59298d;

    public g(File file, File file2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, file2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = file;
        this.f59296b = file2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:5:0x0005, B:7:0x000d, B:9:0x0015, B:11:0x0025, B:14:0x0038, B:17:0x003f, B:20:0x004b, B:24:0x0052), top: B:32:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.f59296b.exists() && this.a.exists()) {
                    String[] split = StringUtil.readAll(this.f59296b).split("#####");
                    if (split.length == 2) {
                        String str = split[1];
                        int parseInteger = StringUtil.parseInteger(split[0], 0);
                        com.qq.e.comm.util.a a = com.qq.e.comm.util.a.a();
                        File file = this.a;
                        if (a != null) {
                            if (file != null && file.exists()) {
                                z = a.a(str, Md5Util.encode(file));
                                if (z) {
                                    return false;
                                }
                                this.f59297c = str;
                                this.f59298d = parseInteger;
                                return true;
                            }
                            z = false;
                            if (z) {
                            }
                        } else {
                            throw null;
                        }
                    }
                }
                return false;
            } catch (Throwable unused) {
                GDTLogger.d("Exception while checking plugin");
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean a(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, file2)) == null) ? (file.equals(this.a) || FileUtil.renameTo(this.a, file)) && (file2.equals(this.f59296b) || FileUtil.renameTo(this.f59296b, file2)) : invokeLL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59297c : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59298d : invokeV.intValue;
    }
}
