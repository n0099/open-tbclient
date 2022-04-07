package com.kwad.sdk.reward.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.Observable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a extends Observable implements com.kwad.sdk.core.b, b {
    public String a;
    public boolean b = false;

    public void a() {
        if (this.b) {
            return;
        }
        this.b = true;
        f();
    }

    public void b() {
        if (this.b) {
            this.b = false;
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
        return this.b;
    }

    public void f() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.b));
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.b = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "selfCompleted", this.b);
        return jSONObject;
    }
}
