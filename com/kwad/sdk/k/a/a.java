package com.kwad.sdk.k.a;

import android.content.Context;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a implements c {
    public List<c> aLh;
    public boolean enabled;

    public boolean bB(Context context) {
        return false;
    }

    public a() {
        this.enabled = true;
    }

    private List<c> getChildren() {
        return this.aLh;
    }

    public a(boolean z) {
        this.enabled = z;
    }

    @Override // com.kwad.sdk.k.a.c
    public final boolean bA(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children != null && children.size() > 0) {
            for (c cVar : children) {
                if (cVar.bA(context)) {
                    return true;
                }
            }
            return false;
        }
        try {
            return bB(context);
        } catch (Throwable unused) {
            return false;
        }
    }
}
