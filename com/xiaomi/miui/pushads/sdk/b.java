package com.xiaomi.miui.pushads.sdk;

import android.content.Context;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes8.dex */
class b {
    public static int a(Context context, File file, String str, h hVar) {
        int i;
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        InputStream inputStream3 = null;
        String str2 = file.getAbsolutePath() + "/" + m117a(str);
        try {
            try {
                if (new File(str2).exists()) {
                    i = 0;
                    inputStream2 = null;
                } else {
                    d.a("从sever 下载文件 debug 模式");
                    InputStream a = a(str);
                    try {
                        i = a(context, str2, a);
                        inputStream2 = a;
                    } catch (Throwable th2) {
                        inputStream = a;
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
        } catch (Exception e3) {
            if (0 != 0) {
                try {
                    inputStream3.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    i = -1;
                }
            }
            i = -1;
        }
        if (i == 0) {
            hVar.a(str2);
        }
        return i;
    }

    private static int a(Context context, String str, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        File file;
        int read;
        File file2 = null;
        int i = -1;
        if (inputStream != null) {
            try {
                file = new File(str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis());
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e) {
                    fileOutputStream = null;
                    file2 = file;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[i.a];
                    boolean m119a = f.m119a(context);
                    while (true) {
                        read = inputStream.read(bArr);
                        if (read == -1 || !m119a) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        m119a = f.m119a(context);
                    }
                    fileOutputStream.flush();
                    if (read == -1) {
                        file.renameTo(new File(str));
                        i = 0;
                    } else if (!m119a) {
                    }
                    try {
                        fileOutputStream.close();
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    file2 = file;
                    try {
                        fileOutputStream.close();
                        if (file2.exists()) {
                            file2.delete();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        fileOutputStream.close();
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                file = null;
            }
        }
        return i;
    }

    private static InputStream a(String str) {
        try {
            return ((HttpURLConnection) new URL(str).openConnection()).getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m117a(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        return str.substring(lastIndexOf < 0 ? 0 : lastIndexOf + 1);
    }
}
