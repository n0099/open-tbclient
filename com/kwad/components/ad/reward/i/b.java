package com.kwad.components.ad.reward.i;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.r;
import java.util.Observable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {
    public boolean tX = false;
    public String tY;
    public String tZ;

    private boolean ix() {
        return this.tX;
    }

    private void iy() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.tX));
    }

    public boolean isCompleted() {
        return ix();
    }

    public final void it() {
        if (this.tX) {
            return;
        }
        this.tX = true;
        iy();
    }

    public final void iu() {
        if (this.tX) {
            this.tX = false;
            iy();
        }
    }

    @Override // com.kwad.components.ad.reward.i.c
    public final String iv() {
        return this.tY;
    }

    @Override // com.kwad.components.ad.reward.i.c
    public final String iw() {
        return this.tZ;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.tX = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "selfCompleted", this.tX);
        return jSONObject;
    }
}
