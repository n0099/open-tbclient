package com.kwad.components.ad.reward.l;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.Observable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {
    public boolean xB = false;
    public String xC;
    public String xD;

    private boolean ju() {
        return this.xB;
    }

    private void jv() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.xB));
    }

    public boolean isCompleted() {
        return ju();
    }

    public final void jq() {
        if (!this.xB) {
            this.xB = true;
            jv();
        }
    }

    public final void jr() {
        if (this.xB) {
            this.xB = false;
            jv();
        }
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String js() {
        return this.xC;
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String jt() {
        return this.xD;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "selfCompleted", this.xB);
        return jSONObject;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xB = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }
}
