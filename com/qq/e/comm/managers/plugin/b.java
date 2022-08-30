package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, File file, File file2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65536, null, context, file, file2)) != null) {
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
            StringUtil.writeTo("1292#####" + str2, file2);
            if (StringUtil.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                return FileUtil.copyTo(assets.open(str), file);
            }
            InputStream open = assets.open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
            byte[] bArr = new byte[1024];
            int length = bytes.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
                int i3 = 0;
                while (i3 < read) {
                    int i4 = i2 + 1;
                    if (i2 >= 64) {
                        bArr[i3] = (byte) (bytes[i % length] ^ bArr[i3]);
                        i++;
                    }
                    i3++;
                    i2 = i4;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            GDTLogger.e("插件加载失败", th);
            a.a(th, th.getMessage());
            return false;
        }
    }
}
