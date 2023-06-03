package com.kwad.sdk.f.kwai;

import android.content.Context;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a implements c {
    public List<c> ams;
    public boolean enabled;

    public a() {
        this.enabled = true;
    }

    public a(boolean z) {
        this.enabled = z;
    }

    private List<c> getChildren() {
        return this.ams;
    }

    @Override // com.kwad.sdk.f.kwai.c
    public final boolean bM(Context context) {
        if (this.enabled) {
            List<c> children = getChildren();
            if (children == null || children.size() <= 0) {
                try {
                    return bN(context);
                } catch (Throwable unused) {
                    return false;
                }
            }
            for (c cVar : children) {
                if (cVar.bM(context)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean bN(Context context) {
        return false;
    }
}
