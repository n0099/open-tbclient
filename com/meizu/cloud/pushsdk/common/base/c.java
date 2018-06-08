package com.meizu.cloud.pushsdk.common.base;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.util.SystemInfoUtil;
import com.meizu.cloud.pushsdk.common.util.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
public class c implements Logger.Callback {
    private String a;
    private BufferedWriter b;
    private b c = new b("lo");

    public c(String str) {
        this.a = str;
    }

    private synchronized void a() throws IOException {
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(this.a)) {
                File file = new File(this.a);
                if (!file.exists() && !file.mkdirs()) {
                    Log.e("EncryptLogger", "create dir " + this.a + " failed!");
                } else {
                    File file2 = new File(file, "logs_v2.txt");
                    if (!file2.exists() && !file2.createNewFile()) {
                        Log.e("EncryptLogger", "create new file logs_v2.txt failed!");
                    } else {
                        if (file2 != null && file2.length() >= 31457280) {
                            String parent = file2.getParent();
                            File file3 = new File(parent, "logs_v2_old.txt");
                            if (!file3.exists()) {
                                this.b = new BufferedWriter(new FileWriter(file2, z));
                            } else {
                                this.b = new BufferedWriter(new FileWriter(file2, z));
                            }
                        }
                        z = true;
                        this.b = new BufferedWriter(new FileWriter(file2, z));
                    }
                }
            }
        }
    }

    private synchronized void b() {
        if (this.b != null) {
            try {
                this.b.close();
            } catch (IOException e) {
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.common.util.Logger.Callback
    public void a(Logger.Callback.Level level, String str, String str2) {
        String str3;
        try {
            a();
            if (this.b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("/");
                if (level == Logger.Callback.Level.DEBUG) {
                    str3 = "D";
                } else {
                    str3 = level == Logger.Callback.Level.INFO ? "I" : level == Logger.Callback.Level.WARN ? "W" : "E";
                }
                sb.append(str3);
                sb.append(": ");
                sb.append(str2);
                this.b.append((CharSequence) this.c.a(sb.toString().getBytes(Charset.forName("UTF-8"))));
                this.b.append((CharSequence) SystemInfoUtil.LINE_END);
                this.b.flush();
            }
        } catch (Exception e) {
        } finally {
            b();
        }
    }
}
