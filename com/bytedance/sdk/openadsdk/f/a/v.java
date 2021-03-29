package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public final Collection<String> f29374a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, u> f29375b;

    /* renamed from: c  reason: collision with root package name */
    public final k f29376c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f29377d;

    /* loaded from: classes6.dex */
    public interface a {
    }

    public u a(@NonNull String str) {
        if (!this.f29374a.contains(str) && !TextUtils.equals(str, "host")) {
            throw new IllegalArgumentException("Namespace: " + str + " not registered.");
        }
        return a(str, null);
    }

    public void a(a aVar) {
        this.f29377d.add(aVar);
    }

    private u a(String str, @Nullable JSONObject jSONObject) {
        u uVar = this.f29375b.get(str);
        if (uVar == null) {
            u uVar2 = new u(str, this.f29376c.c(), this.f29376c.a(), this.f29376c.b(), jSONObject);
            this.f29375b.put(str, uVar2);
            return uVar2;
        } else if (jSONObject != null) {
            uVar.a(jSONObject);
            return uVar;
        } else {
            return uVar;
        }
    }
}
