package d.r.b.a.a.f.g;

import android.content.Context;
import com.yy.mobile.framework.revenuesdk.baseapi.router.RouterInfo;
import d.r.b.a.a.f.d.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f67034a;

    public static a a() {
        if (f67034a == null) {
            f67034a = new a();
        }
        return f67034a;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00b7: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:28:0x00b7 */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RouterInfo b(Context context, int i2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        RouterInfo routerInfo;
        String property;
        FileInputStream fileInputStream3 = null;
        if (context != null && context.getCacheDir() != null) {
            File file = new File(context.getCacheDir().getAbsolutePath() + File.separator + "revenuesdk_router.info");
            if (file.exists() && file.canRead()) {
                Properties properties = new Properties();
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            properties.load(fileInputStream);
                            routerInfo = new RouterInfo();
                            property = properties.getProperty(i2 + "");
                        } catch (Exception e2) {
                            e = e2;
                            d.e("RouterConfigCache", "read routerinfo fail err: %s", e.getMessage());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    d.e("RouterConfigCache", "close purchase fail err: %s", e3.getMessage());
                                }
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream3 = fileInputStream2;
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException e4) {
                                d.e("RouterConfigCache", "close purchase fail err: %s", e4.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream3 != null) {
                    }
                    throw th;
                }
                if (property != null) {
                    routerInfo.serviceName = property;
                    routerInfo.functionName = "im";
                    long j = i2;
                    routerInfo.cmd = j;
                    d.g("RouterConfigCache", "read routerinfo success serviceName=%s,functionName=%s,cmd=%s", property, "im", Long.valueOf(j));
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        d.e("RouterConfigCache", "close purchase fail err: %s", e6.getMessage());
                    }
                    return routerInfo;
                }
                d.e("RouterConfigCache", "read routerinfo fail!: cmd=%s serviceName == null", Integer.valueOf(i2));
                try {
                    fileInputStream.close();
                } catch (IOException e7) {
                    d.e("RouterConfigCache", "close purchase fail err: %s", e7.getMessage());
                }
                return null;
            }
            d.e("RouterConfigCache", "read revenuesdk_router fail file exist or file can't read", new Object[0]);
        }
        return null;
    }
}
