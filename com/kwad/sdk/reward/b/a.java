package com.kwad.sdk.reward.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.Observable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a extends Observable implements com.kwad.sdk.core.b, b {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57212b = false;

    public void a() {
        if (this.f57212b) {
            return;
        }
        this.f57212b = true;
        f();
    }

    public void b() {
        if (this.f57212b) {
            this.f57212b = false;
            f();
        }
    }

    @Override // com.kwad.sdk.reward.b.b
    public String c() {
        return this.a;
    }

    @Override // com.kwad.sdk.reward.b.b
    public boolean d() {
        return e();
    }

    public boolean e() {
        return this.f57212b;
    }

    public void f() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.f57212b));
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f57212b = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "selfCompleted", this.f57212b);
        return jSONObject;
    }
}
