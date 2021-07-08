package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f37978a;

    /* renamed from: b  reason: collision with root package name */
    public final File f37979b;

    /* renamed from: c  reason: collision with root package name */
    public final File f37980c;

    /* renamed from: d  reason: collision with root package name */
    public String f37981d;

    /* renamed from: e  reason: collision with root package name */
    public int f37982e;

    public a(File file, File file2) {
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
        this.f37979b = file;
        this.f37980c = file2;
    }

    public static boolean a(Context context, File file, File file2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65537, null, context, file, file2)) != null) {
            return invokeLLL.booleanValue;
        }
        AssetManager assets = context.getAssets();
        try {
            if (Arrays.binarySearch(assets.list(CustomPkgConstants.getAssetPluginDir()), CustomPkgConstants.getAssetPluginName()) < 0) {
                return false;
            }
            String str = CustomPkgConstants.getAssetPluginDir() + File.separator + CustomPkgConstants.getAssetPluginName();
            String str2 = Sig.ASSET_PLUGIN_SIG;
            if (str2 == null) {
                str2 = "";
            }
            StringUtil.writeTo("1232#####" + str2, file2);
            if (StringUtil.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                return FileUtil.copyTo(assets.open(str), file);
            }
            InputStream open = assets.open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
            byte[] bArr = new byte[1024];
            int length = bytes.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
                int i4 = 0;
                while (i4 < read) {
                    int i5 = i2 + 1;
                    if (i2 >= 64) {
                        bArr[i4] = (byte) (bArr[i4] ^ bytes[i3 % length]);
                        i3++;
                    }
                    i4++;
                    i2 = i5;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            GDTLogger.report("Exception while init default plugin manager", th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:5:0x0005, B:7:0x000d, B:9:0x0015, B:11:0x0027, B:13:0x0038, B:16:0x003f, B:19:0x004b), top: B:29:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.f37980c.exists() && this.f37979b.exists()) {
                    String readAll = StringUtil.readAll(this.f37980c);
                    this.f37978a = readAll;
                    String[] split = readAll.split("#####");
                    if (split.length == 2) {
                        String str = split[1];
                        int parseInteger = StringUtil.parseInteger(split[0], 0);
                        com.qq.e.comm.util.a a2 = com.qq.e.comm.util.a.a();
                        File file = this.f37979b;
                        if (file != null && file.exists()) {
                            z = a2.b(str, Md5Util.encode(file));
                            if (z) {
                                this.f37981d = str;
                                this.f37982e = parseInteger;
                                return true;
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                GDTLogger.report("Exception while checking plugin", th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean a(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file, file2)) == null) {
            if (file == null || file2 == null) {
                return false;
            }
            return (file.equals(this.f37979b) || FileUtil.renameTo(this.f37979b, file)) && (file2.equals(this.f37980c) || FileUtil.renameTo(this.f37980c, file2));
        }
        return invokeLL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37982e : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37981d : (String) invokeV.objValue;
    }
}
