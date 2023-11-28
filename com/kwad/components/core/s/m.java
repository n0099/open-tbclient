package com.kwad.components.core.s;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media2.session.MediaConstants;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class m {
    public static final String TAG = "m";
    public static final String Tb = "com.kwad.components.core.s.m";
    public static volatile m Tc;
    public boolean Td = false;
    public o.a Te;

    public static m qR() {
        if (Tc == null) {
            synchronized (m.class) {
                if (Tc == null) {
                    Tc = new m();
                }
            }
        }
        return Tc;
    }

    public final void init() {
        o.a aVar = (o.a) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.apf);
        this.Te = aVar;
        if (aVar != null) {
            qT();
        }
    }

    public final int qS() {
        o.a aVar = this.Te;
        if (aVar != null) {
            return aVar.ars;
        }
        return 0;
    }

    public static void E(long j) {
        String str = TAG;
        com.kwad.sdk.core.e.c.d(str, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
    }

    public static boolean at(String str) {
        if (!str.startsWith("com.kwad")) {
            return true;
        }
        return false;
    }

    public static boolean au(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (Class.forName(str) == null) {
            return false;
        }
        return true;
    }

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

    private boolean a(List<String> list, List<String> list2) {
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

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.e.c.d(TAG, "checkBySuper begin:" + elapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && as(className) && at(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            E(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            E(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            E(elapsedRealtime);
        }
        return false;
    }

    public static boolean as(String str) {
        if (!str.startsWith("android") && !str.startsWith(ExceptionHandlerImpl.EXCEPTION_TYPE_JAVA) && !str.startsWith("dalvik") && !str.startsWith("com.android") && !str.contains(Tb) && str.startsWith(MediaConstants.MEDIA_URI_SCHEME)) {
            return true;
        }
        return false;
    }

    private void qT() {
        o.a aVar = this.Te;
        if (aVar == null) {
            return;
        }
        if (!this.Td && aVar.arr.size() > 0) {
            for (String str : this.Te.arr) {
                boolean au = au(str);
                this.Td = au;
                if (au) {
                    break;
                }
            }
        }
        if (!this.Td) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.Te.aro.size() > 0) {
            for (Map.Entry<Integer, String> entry : this.Te.aro.entrySet()) {
                if (au(entry.getValue())) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        o.a aVar2 = this.Te;
        com.kwad.components.core.o.a.pX().a(a(aVar2.arp, aVar2.arq), arrayList);
    }

    public final boolean a(SceneImpl sceneImpl, String str) {
        boolean z;
        if (this.Td) {
            o.a aVar = this.Te;
            z = a(aVar.arp, aVar.arq);
        } else {
            z = false;
        }
        com.kwad.components.core.o.a.pX().a(sceneImpl, z, str);
        return z;
    }
}
