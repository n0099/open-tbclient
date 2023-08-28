package com.kwad.components.core.k.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;
/* loaded from: classes10.dex */
public final class a {
    @NonNull
    public final b EI;
    @NonNull
    public final com.kwad.components.core.k.b HN;
    @Nullable
    public List<String> HO;
    public boolean HP;
    public boolean HQ;
    @Nullable
    public d HR;

    /* renamed from: com.kwad.components.core.k.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0653a {
        public b EI;
        public com.kwad.components.core.k.b HN;
        public boolean HP;
        public boolean HQ;

        public final C0653a a(@NonNull com.kwad.components.core.k.b bVar) {
            this.HN = bVar;
            return this;
        }

        public final C0653a aw(boolean z) {
            this.HP = true;
            return this;
        }

        public final C0653a ax(boolean z) {
            this.HQ = z;
            return this;
        }

        public final C0653a c(b bVar) {
            this.EI = bVar;
            return this;
        }

        public final a oo() {
            if (com.kwad.components.ad.d.a.aw.booleanValue() && (this.EI == null || this.HN == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }
    }

    public a(C0653a c0653a) {
        this.EI = c0653a.EI;
        this.HN = c0653a.HN;
        this.HP = c0653a.HP;
        this.HQ = c0653a.HQ;
    }

    public /* synthetic */ a(C0653a c0653a, byte b) {
        this(c0653a);
    }

    public static void a(@NonNull a aVar, int i, String str, boolean z) {
        aVar.HN.a(i, str, z);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z) {
        boolean isAdResultDataEmpty = adResultData.isAdResultDataEmpty();
        com.kwad.components.core.k.b bVar = aVar.HN;
        if (!isAdResultDataEmpty) {
            bVar.a(adResultData, z);
            return;
        }
        f fVar = f.Yd;
        bVar.a(fVar.errorCode, fVar.Qd, z);
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.EI.HS;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.EI.HS;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.EI.HS;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }
}
