package com.bytedance.sdk.openadsdk.i;

import android.content.Context;
import android.location.Address;
import com.baidu.ar.constants.HttpConstants;
import com.bytedance.sdk.openadsdk.core.k;
import java.util.Map;
/* loaded from: classes6.dex */
public class c implements com.bytedance.sdk.adnet.c.b {

    /* renamed from: a  reason: collision with root package name */
    String f7212a = "sp_multi_ttadnet_config";

    /* renamed from: b  reason: collision with root package name */
    private Context f7213b;

    public c(Context context) {
        this.f7213b = context;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public Address a(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public int a() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String b() {
        return "openadsdk";
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String c() {
        return HttpConstants.OS_TYPE_VALUE;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public int d() {
        return 3251;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String e() {
        return k.a(this.f7213b);
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String a(Context context, String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.d.a.b(this.f7212a, str, str2);
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public void a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f7212a, entry.getKey(), (Integer) value);
                    } else if (value instanceof Long) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f7212a, entry.getKey(), (Long) value);
                    } else if (value instanceof Float) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f7212a, entry.getKey(), (Float) value);
                    } else if (value instanceof Boolean) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f7212a, entry.getKey(), (Boolean) value);
                    } else if (value instanceof String) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f7212a, entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String[] f() {
        return new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm.pstatp.com"};
    }
}
