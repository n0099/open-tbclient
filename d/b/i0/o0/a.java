package d.b.i0.o0;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.provider.Settings;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import d.b.c.e.p.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f51116a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f51117b = "";

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x00db */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0043 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static String a(File file) {
        if (f51116a) {
            return "hasSend_" + f51117b;
        }
        String str = TbConfig.SERVER_ADDRESS + TbConfig.DEBUG_UPLOAD;
        if (file.length() > 3145728 || !TbadkCoreApplication.isLogin()) {
            return "notLogin";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream((File) file);
                    try {
                        byte[] bArr = new byte[(int) file.length()];
                        fileInputStream2.read(bArr);
                        fileInputStream2.close();
                        NetWork netWork = new NetWork(str + "?fn=" + file.getName());
                        netWork.addPostData("debugfile", bArr);
                        netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                        netWork.addPostData("type", "android");
                        String postMultiNetData = netWork.postMultiNetData();
                        if (postMultiNetData != null && !postMultiNetData.isEmpty()) {
                            String string = new JSONObject(postMultiNetData).getString("url");
                            f51117b = string;
                            f51116a = true;
                            try {
                                fileInputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return string;
                        }
                        file = postMultiNetData;
                        fileInputStream = fileInputStream2;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        try {
                            file = "uploadfail_" + th;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                file = file;
                            }
                            return file;
                        } catch (Throwable th2) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                } else {
                    file = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
                file = file;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return file;
    }

    public static boolean b() {
        try {
            return Settings.Secure.getInt(ContentResolverProxy.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String c(Context context) {
        int port;
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                str = System.getProperty("http.proxyHost");
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    property = "-1";
                }
                port = Integer.parseInt(property);
            } else {
                String host = Proxy.getHost(context);
                port = Proxy.getPort(context);
                str = host;
            }
            if (k.isEmpty(str) || port == -1) {
                return null;
            }
            return str + ":" + port;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(File file, File file2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            try {
                if (!file.exists()) {
                    return false;
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr2 = new byte[1024];
                    if (bArr != null && bArr.length > 0 && bArr.length < file.length()) {
                        byte[] bArr3 = new byte[bArr.length];
                        fileInputStream2.read(bArr3, 0, bArr.length);
                        int i = 0;
                        while (true) {
                            if (i >= bArr.length) {
                                break;
                            } else if (bArr[i] != bArr3[i]) {
                                fileOutputStream.write(bArr3, 0, bArr.length);
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    while (true) {
                        int read = fileInputStream2.read(bArr2);
                        if (read > 0) {
                            fileOutputStream.write(bArr2, 0, read);
                        } else {
                            fileOutputStream.flush();
                            fileInputStream2.close();
                            try {
                                fileOutputStream.close();
                                return true;
                            } catch (Exception e3) {
                                e = e3;
                                BdLog.e(e.toString());
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e4) {
                                        BdLog.e(e4.toString());
                                    }
                                }
                                if (fileOutputStream == null) {
                                    try {
                                        fileOutputStream.close();
                                        return false;
                                    } catch (Exception e5) {
                                        BdLog.e(e5.toString());
                                        return false;
                                    }
                                }
                                return false;
                            }
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileInputStream = fileInputStream2;
                    BdLog.e(e.toString());
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                            BdLog.e(e7.toString());
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e8) {
                            BdLog.e(e8.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e9) {
            e = e9;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }
}
