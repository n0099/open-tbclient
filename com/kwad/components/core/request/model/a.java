package com.kwad.components.core.request.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.i;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;
/* loaded from: classes10.dex */
public final class a {
    @NonNull
    public final ImpInfo Mp;
    @NonNull
    public final com.kwad.components.core.request.c Rl;
    @Nullable
    public i Rm;
    @Nullable
    public List<String> Rn;
    public boolean Ro;
    public boolean Rp;
    @Nullable
    public c Rq;

    /* renamed from: com.kwad.components.core.request.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0661a {
        public ImpInfo Mp;
        public com.kwad.components.core.request.c Rl;
        public boolean Ro;
        public boolean Rp;
        public i Rr;

        public final a ql() {
            if (com.kwad.components.ad.e.a.mc.booleanValue() && (this.Mp == null || this.Rl == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }

        public final C0661a a(@NonNull com.kwad.components.core.request.c cVar) {
            this.Rl = cVar;
            return this;
        }

        public final C0661a aH(boolean z) {
            this.Ro = true;
            return this;
        }

        public final C0661a aI(boolean z) {
            this.Rp = z;
            return this;
        }

        public final C0661a e(ImpInfo impInfo) {
            this.Mp = impInfo;
            return this;
        }

        public final C0661a a(i iVar) {
            this.Rr = iVar;
            return this;
        }
    }

    public a(C0661a c0661a) {
        this.Mp = c0661a.Mp;
        this.Rl = c0661a.Rl;
        this.Ro = c0661a.Ro;
        this.Rp = c0661a.Rp;
        this.Rm = c0661a.Rr;
    }

    public /* synthetic */ a(C0661a c0661a, byte b) {
        this(c0661a);
    }

    public static void a(@NonNull a aVar, int i, String str, boolean z) {
        aVar.Rl.a(i, str, z);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z) {
        String str;
        if (adResultData.isAdResultDataEmpty()) {
            com.kwad.components.core.request.c cVar = aVar.Rl;
            int i = e.ats.errorCode;
            if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                str = e.ats.msg;
            } else {
                str = adResultData.testErrorMsg;
            }
            cVar.a(i, str, z);
            return;
        }
        aVar.Rl.a(adResultData, z);
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.Mp.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.Mp.adScene;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.Mp.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }

    @Nullable
    public final i qk() {
        return this.Rm;
    }
}
