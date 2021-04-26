package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.item.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ad f34839a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34840b = false;

    /* renamed from: c  reason: collision with root package name */
    public k.a f34841c;

    public static ad a() {
        if (f34839a == null) {
            synchronized (ad.class) {
                if (f34839a == null) {
                    f34839a = new ad();
                }
            }
        }
        return f34839a;
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

    private void b() {
        k.a aVar = this.f34841c;
        if (aVar == null) {
            return;
        }
        if (!this.f34840b && aVar.f32865c.size() > 0) {
            for (String str : this.f34841c.f32865c) {
                boolean a2 = a(str);
                this.f34840b = a2;
                if (a2) {
                    break;
                }
            }
        }
        if (this.f34840b) {
            ArrayList arrayList = new ArrayList();
            if (this.f34841c.f32863a.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.f34841c.f32863a.entrySet()) {
                    if (a(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            com.kwad.sdk.core.report.e.a(a(this.f34841c.f32864b), arrayList);
        }
    }

    public void a(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
            if (sharedPreferences != null) {
                c.a.ao.a(sharedPreferences);
                this.f34841c = c.a.ao.b();
            }
            if (this.f34841c != null) {
                b();
            }
        }
    }

    public void a(KsScene ksScene, String str) {
        com.kwad.sdk.core.report.e.a(ksScene, this.f34840b ? a(this.f34841c.f32864b) : false, str);
    }
}
