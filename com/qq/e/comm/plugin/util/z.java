package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes15.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12603a = z.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private String[] f12604b;
    private String[] c;
    private CopyOnWriteArrayList<String> d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static z f12608a = new z();
    }

    private z() {
        d();
    }

    public static z a() {
        return a.f12608a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        com.qq.e.comm.plugin.y.c cVar = new com.qq.e.comm.plugin.y.c();
        cVar.a(str3);
        com.qq.e.comm.plugin.y.u.a(1130004, 0, cVar, new com.qq.e.comm.plugin.y.d().a("package", str).a(Config.TRACE_PART, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.qq.e.comm.plugin.y.u.a(1130003, 0, null, new com.qq.e.comm.plugin.y.d().a("adapter", str));
    }

    private void d() {
        String string = GDTADManager.getInstance().getSM().getString("mcClaNa");
        if (!TextUtils.isEmpty(string)) {
            this.f12604b = string.split(",");
        }
        String string2 = GDTADManager.getInstance().getSM().getString("mcPackNa");
        if (!TextUtils.isEmpty(string2)) {
            this.c = string2.split(",");
        }
        this.e = GDTADManager.getInstance().getSM().getInteger("mcena", 0) == 1;
        this.d = new CopyOnWriteArrayList<>();
        GDTLogger.d(f12603a + "mIsEnableCheck: " + this.e + " mClassNames: " + this.f12604b + " mPackages: " + this.c);
    }

    public void a(final String str) {
        if (!this.e || this.d.contains(str) || this.c == null || this.c.length == 0) {
            return;
        }
        if (this.d.size() >= 10) {
            this.d.remove(0);
        }
        this.d.add(str);
        final StackTraceElement[] stackTrace = new Exception().getStackTrace();
        s.f12591a.execute(new Runnable() { // from class: com.qq.e.comm.plugin.util.z.2
            @Override // java.lang.Runnable
            public void run() {
                StackTraceElement[] stackTraceElementArr;
                StringBuilder sb = new StringBuilder("checkPackage:");
                String[] strArr = z.this.c;
                int length = strArr.length;
                int i = 0;
                boolean z = false;
                int i2 = 0;
                while (i2 < length) {
                    String str2 = strArr[i2];
                    int i3 = i + 1;
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        if (stackTraceElement != null) {
                            String className = stackTraceElement.getClassName();
                            if (!TextUtils.isEmpty(className)) {
                                if (i3 == 1) {
                                    sb.append("\t").append(stackTraceElement.toString());
                                }
                                if (!TextUtils.isEmpty(str2) && className.contains(str2)) {
                                    GDTLogger.d(z.f12603a + "调用栈中：" + className + " 存在包名：" + str2);
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        z.this.a(str2, sb.toString(), str);
                        return;
                    } else {
                        i2++;
                        i = i3;
                    }
                }
            }
        });
    }

    public void b() {
        if (!this.e || this.f12604b == null || this.f12604b.length == 0) {
            return;
        }
        s.f12591a.execute(new Runnable() { // from class: com.qq.e.comm.plugin.util.z.1
            @Override // java.lang.Runnable
            public void run() {
                String[] strArr;
                for (String str : z.this.f12604b) {
                    try {
                        Class.forName(str);
                        GDTLogger.d(z.f12603a + "宿主APP中存在三方聚合 SDK 类：" + str);
                        z.this.b(str);
                    } catch (ClassNotFoundException e) {
                        GDTLogger.d(z.f12603a + "第三方聚合 SDK 类：" + str + " 不存在");
                    }
                }
            }
        });
    }
}
