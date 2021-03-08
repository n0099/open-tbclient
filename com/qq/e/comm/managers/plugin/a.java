package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.res.AssetManager;
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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final File f7566a;
    private final File b;
    private String c;
    private int d;

    public a(File file, File file2) {
        this.f7566a = file;
        this.b = file2;
    }

    public static boolean a(Context context, File file, File file2) {
        int i;
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
            StringUtil.writeTo("1180#####" + str2, file2);
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
                int i5 = i2;
                while (i4 < read) {
                    int i6 = i5 + 1;
                    if (i5 >= 64) {
                        i = i3 + 1;
                        bArr[i4] = (byte) (bytes[i3 % length] ^ bArr[i4]);
                    } else {
                        i = i3;
                    }
                    i4++;
                    i5 = i6;
                    i3 = i;
                }
                fileOutputStream.write(bArr, 0, read);
                i2 = i5;
            }
        } catch (Throwable th) {
            GDTLogger.report("Exception while init default plugin manager", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        try {
            if (this.b.exists() && this.f7566a.exists()) {
                String[] split = StringUtil.readAll(this.b).split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    int parseInteger = StringUtil.parseInteger(split[0], 0);
                    com.qq.e.comm.util.a a2 = com.qq.e.comm.util.a.a();
                    File file = this.f7566a;
                    if ((file == null || !file.exists()) ? false : a2.b(str, Md5Util.encode(file))) {
                        this.c = str;
                        this.d = parseInteger;
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.report("Exception while checking plugin", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        if (file.equals(this.f7566a) || FileUtil.renameTo(this.f7566a, file)) {
            return file2.equals(this.b) || FileUtil.renameTo(this.b, file2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.c;
    }
}
