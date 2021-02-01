package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes6.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private FileReader f7550a;

    /* renamed from: b  reason: collision with root package name */
    private BufferedReader f7551b;

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [39=4, 40=4, 42=4, 43=4, 45=4, 46=4] */
    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File("data/data/com.union_test.toutiao/" + str);
                if (!file.exists()) {
                    try {
                        if (this.f7550a != null) {
                            this.f7550a.close();
                        }
                        if (this.f7551b != null) {
                            this.f7551b.close();
                            return null;
                        }
                        return null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                this.f7550a = new FileReader(file);
                this.f7551b = new BufferedReader(this.f7550a);
                while (true) {
                    String readLine = this.f7551b.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                try {
                    if (this.f7550a != null) {
                        this.f7550a.close();
                    }
                    if (this.f7551b != null) {
                        this.f7551b.close();
                        return sb2;
                    }
                    return sb2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return sb2;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                try {
                    if (this.f7550a != null) {
                        this.f7550a.close();
                    }
                    if (this.f7551b != null) {
                        this.f7551b.close();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return sb.toString();
            }
        } catch (Throwable th) {
            try {
                if (this.f7550a != null) {
                    this.f7550a.close();
                }
                if (this.f7551b != null) {
                    this.f7551b.close();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public boolean a(Context context) {
        String d = aj.d();
        if (!"5001121".equals(com.bytedance.sdk.openadsdk.core.i.c().e()) || !"com.union_test.toutiao".equals(d) || !u.c()) {
            return false;
        }
        return true;
    }

    public String a(String str, String str2) {
        if (str.contains("https://pangolin.snssdk.com")) {
            return str.replace("https://pangolin.snssdk.com", str2);
        }
        if (str.contains("https://is.snssdk.com")) {
            return str.replace("https://is.snssdk.com", str2);
        }
        if (str.contains("https://pangolin16.snssdk.com")) {
            return str.replace("https://pangolin16.snssdk.com", str2);
        }
        return str;
    }
}
