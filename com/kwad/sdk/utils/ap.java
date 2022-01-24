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
/* loaded from: classes3.dex */
public class ap {
    public static volatile ap a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57943b = false;

    /* renamed from: c  reason: collision with root package name */
    public p.a f57944c;

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
        p.a aVar = this.f57944c;
        if (aVar == null) {
            return;
        }
        if (!this.f57943b && aVar.f55694c.size() > 0) {
            for (String str : this.f57944c.f55694c) {
                boolean a2 = a(str);
                this.f57943b = a2;
                if (a2) {
                    break;
                }
            }
        }
        if (this.f57943b) {
            ArrayList arrayList = new ArrayList();
            if (this.f57944c.a.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.f57944c.a.entrySet()) {
                    if (a(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            com.kwad.sdk.core.report.d.a(a(this.f57944c.f55693b), arrayList);
        }
    }

    public void a(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
            if (sharedPreferences != null) {
                b.a.aX.a(sharedPreferences);
                this.f57944c = b.a.aX.a();
            }
            if (this.f57944c != null) {
                c();
            }
        }
    }

    public boolean a(KsScene ksScene, String str) {
        boolean a2 = this.f57943b ? a(this.f57944c.f55693b) : false;
        com.kwad.sdk.core.report.d.a(ksScene, a2, str);
        return a2;
    }

    public int b() {
        p.a aVar = this.f57944c;
        if (aVar != null) {
            return aVar.f55695d;
        }
        return 0;
    }
}
