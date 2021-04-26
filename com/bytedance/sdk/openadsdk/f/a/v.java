package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public final Collection<String> f29959a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, u> f29960b;

    /* renamed from: c  reason: collision with root package name */
    public final k f29961c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f29962d;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public u a(@NonNull String str) {
        if (!this.f29959a.contains(str) && !TextUtils.equals(str, "host")) {
            throw new IllegalArgumentException("Namespace: " + str + " not registered.");
        }
        return a(str, null);
    }

    public void a(a aVar) {
        this.f29962d.add(aVar);
    }

    private u a(String str, @Nullable JSONObject jSONObject) {
        u uVar = this.f29960b.get(str);
        if (uVar == null) {
            u uVar2 = new u(str, this.f29961c.c(), this.f29961c.a(), this.f29961c.b(), jSONObject);
            this.f29960b.put(str, uVar2);
            return uVar2;
        } else if (jSONObject != null) {
            uVar.a(jSONObject);
            return uVar;
        } else {
            return uVar;
        }
    }
}
