package com.kwad.sdk.reward.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.Observable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a extends Observable implements com.kwad.sdk.core.b, b {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57257b = false;

    public void a() {
        if (this.f57257b) {
            return;
        }
        this.f57257b = true;
        f();
    }

    public void b() {
        if (this.f57257b) {
            this.f57257b = false;
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
        return this.f57257b;
    }

    public void f() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.f57257b));
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f57257b = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "selfCompleted", this.f57257b);
        return jSONObject;
    }
}
