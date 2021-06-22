package com.bytedance.sdk.openadsdk.i;

import android.content.Context;
import android.location.Address;
import com.bytedance.sdk.openadsdk.core.k;
import java.util.Map;
/* loaded from: classes6.dex */
public class d implements d.b.c.b.c.b {

    /* renamed from: a  reason: collision with root package name */
    public String f29446a = "sp_multi_ttadnet_config";

    /* renamed from: b  reason: collision with root package name */
    public Context f29447b;

    public d(Context context) {
        this.f29447b = context;
    }

    @Override // d.b.c.b.c.b
    public int a() {
        return Integer.parseInt("1371");
    }

    @Override // d.b.c.b.c.b
    public Address a(Context context) {
        return null;
    }

    @Override // d.b.c.b.c.b
    public String b() {
        return "openadsdk";
    }

    @Override // d.b.c.b.c.b
    public String c() {
        return "android";
    }

    @Override // d.b.c.b.c.b
    public int d() {
        return 3455;
    }

    @Override // d.b.c.b.c.b
    public String e() {
        return k.a(this.f29447b);
    }

    @Override // d.b.c.b.c.b
    public String[] f() {
        return new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm.pstatp.com"};
    }

    @Override // d.b.c.b.c.b
    public String a(Context context, String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.d.a.b(this.f29446a, str, str2);
    }

    @Override // d.b.c.b.c.b
    public void a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f29446a, entry.getKey(), (Integer) value);
                    } else if (value instanceof Long) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f29446a, entry.getKey(), (Long) value);
                    } else if (value instanceof Float) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f29446a, entry.getKey(), (Float) value);
                    } else if (value instanceof Boolean) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f29446a, entry.getKey(), (Boolean) value);
                    } else if (value instanceof String) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f29446a, entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
