package com.kwad.components.core.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media2.session.MediaConstants;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.config.item.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class m {
    public static final String Je = "com.kwad.components.core.m.m";
    public static volatile m Jf = null;
    public static final String TAG = "m";
    public boolean Jg = false;
    public n.a Jh;

    public static boolean a(List<String> list, Class cls) {
        int i = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            for (String str : list) {
                if (cls.getName().contains(str)) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i++;
            if (i >= 4) {
                break;
            }
        }
        return false;
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.e.b.d(TAG, "checkBySuper begin:" + elapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && ax(className) && ay(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            q(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            q(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            q(elapsedRealtime);
        }
        return false;
    }

    public static boolean ax(String str) {
        return (str.startsWith("android") || str.startsWith(ExceptionHandlerImpl.EXCEPTION_TYPE_JAVA) || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(Je) || !str.startsWith(MediaConstants.MEDIA_URI_SCHEME)) ? false : true;
    }

    public static boolean ay(String str) {
        return !str.startsWith("com.kwad");
    }

    public static boolean az(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Class.forName(str) != null;
    }

    private boolean c(List<String> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className != null) {
                for (String str : list) {
                    if (className.contains(str)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return a(list2, stackTrace);
    }

    public static m oF() {
        if (Jf == null) {
            synchronized (m.class) {
                if (Jf == null) {
                    Jf = new m();
                }
            }
        }
        return Jf;
    }

    private void oH() {
        n.a aVar = this.Jh;
        if (aVar == null) {
            return;
        }
        if (!this.Jg && aVar.VL.size() > 0) {
            for (String str : this.Jh.VL) {
                boolean az = az(str);
                this.Jg = az;
                if (az) {
                    break;
                }
            }
        }
        if (this.Jg) {
            ArrayList arrayList = new ArrayList();
            if (this.Jh.VI.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.Jh.VI.entrySet()) {
                    if (az(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            n.a aVar2 = this.Jh;
            com.kwad.components.core.j.a.og().a(c(aVar2.VJ, aVar2.VK), arrayList);
        }
    }

    public static void q(long j) {
        String str = TAG;
        com.kwad.sdk.core.e.b.d(str, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
    }

    public final boolean a(KsScene ksScene, String str) {
        boolean z;
        if (this.Jg) {
            n.a aVar = this.Jh;
            z = c(aVar.VJ, aVar.VK);
        } else {
            z = false;
        }
        com.kwad.components.core.j.a.og().a(ksScene, z, str);
        return z;
    }

    public final void init(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
            if (sharedPreferences != null) {
                com.kwad.sdk.core.config.c.Uj.a(sharedPreferences);
                this.Jh = com.kwad.sdk.core.config.c.Uj.getValue();
            }
            if (this.Jh != null) {
                oH();
            }
        }
    }

    public final int oG() {
        n.a aVar = this.Jh;
        if (aVar != null) {
            return aVar.VM;
        }
        return 0;
    }
}
