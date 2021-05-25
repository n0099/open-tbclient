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
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final File f35432a;

    /* renamed from: b  reason: collision with root package name */
    public final File f35433b;

    /* renamed from: c  reason: collision with root package name */
    public String f35434c;

    /* renamed from: d  reason: collision with root package name */
    public int f35435d;

    public a(File file, File file2) {
        this.f35432a = file;
        this.f35433b = file2;
    }

    public static boolean a(Context context, File file, File file2) {
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
            StringUtil.writeTo("1203#####" + str2, file2);
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #0 {all -> 0x004b, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x0011, B:9:0x0021, B:11:0x0032, B:14:0x0039, B:17:0x0045), top: B:23:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a() {
        boolean z;
        try {
            if (this.f35433b.exists() && this.f35432a.exists()) {
                String[] split = StringUtil.readAll(this.f35433b).split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    int parseInteger = StringUtil.parseInteger(split[0], 0);
                    com.qq.e.comm.util.a a2 = com.qq.e.comm.util.a.a();
                    File file = this.f35432a;
                    if (file != null && file.exists()) {
                        z = a2.b(str, Md5Util.encode(file));
                        if (z) {
                            this.f35434c = str;
                            this.f35435d = parseInteger;
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

    public boolean a(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        return (file.equals(this.f35432a) || FileUtil.renameTo(this.f35432a, file)) && (file2.equals(this.f35433b) || FileUtil.renameTo(this.f35433b, file2));
    }

    public int b() {
        return this.f35435d;
    }

    public String c() {
        return this.f35434c;
    }
}
