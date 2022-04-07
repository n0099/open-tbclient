package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.core.config.item.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ap {
    public static volatile ap a;
    public boolean b = false;
    public p.a c;

    public static ap a() {
        if (a == null) {
            synchronized (ap.class) {
                if (a == null) {
                    a = new ap();
                }
            }
        }
        return a;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Class.forName(str) != null;
    }

    private boolean a(List<String> list) {
        if (list != null && list.size() >= 1) {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
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
        }
        return false;
    }

    private void c() {
        p.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        if (!this.b && aVar.c.size() > 0) {
            for (String str : this.c.c) {
                boolean a2 = a(str);
                this.b = a2;
                if (a2) {
                    break;
                }
            }
        }
        if (this.b) {
            ArrayList arrayList = new ArrayList();
            if (this.c.a.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.c.a.entrySet()) {
                    if (a(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            com.kwad.sdk.core.report.d.a(a(this.c.b), arrayList);
        }
    }

    public void a(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
            if (sharedPreferences != null) {
                b.a.aX.a(sharedPreferences);
                this.c = b.a.aX.a();
            }
            if (this.c != null) {
                c();
            }
        }
    }

    public boolean a(KsScene ksScene, String str) {
        boolean a2 = this.b ? a(this.c.b) : false;
        com.kwad.sdk.core.report.d.a(ksScene, a2, str);
        return a2;
    }

    public int b() {
        p.a aVar = this.c;
        if (aVar != null) {
            return aVar.d;
        }
        return 0;
    }
}
