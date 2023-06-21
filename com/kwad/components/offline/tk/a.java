package com.kwad.components.offline.tk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.k.e;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes9.dex */
public final class a extends com.kwad.components.core.offline.init.a {

    /* renamed from: com.kwad.components.offline.tk.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C0657a {
        public static final a Ql = new a((byte) 0);
    }

    public a() {
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.init.b.class, methodId = "initOC")
    public static void aC(Context context) {
        qy().init(context);
    }

    public static a qy() {
        return C0657a.Ql;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(final Context context, ClassLoader classLoader) {
        ITkOfflineCompo iTkOfflineCompo = (ITkOfflineCompo) a(classLoader, ITkOfflineCompo.IMPL);
        if (iTkOfflineCompo == null) {
            com.kwad.sdk.core.e.b.d("TkInitModule", "onPluginLoaded components is null");
            return false;
        }
        String tag = getTag();
        com.kwad.sdk.core.e.b.d(tag, "onOfflineComponentsLoaded components classLoader: " + iTkOfflineCompo.getClass().getClassLoader());
        final TkCompoImpl tkCompoImpl = new TkCompoImpl(iTkOfflineCompo);
        c.a(com.kwad.components.core.offline.api.kwai.a.class, tkCompoImpl);
        iTkOfflineCompo.initReal(context, KsAdSDKImpl.get().getSdkConfig(), new b());
        SdkConfigData rZ = d.rZ();
        if (rZ != null) {
            tkCompoImpl.onConfigRefresh(context, rZ.toJson());
        }
        e.a(new e.a() { // from class: com.kwad.components.offline.tk.a.1
            @Override // com.kwad.components.core.k.e.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                tkCompoImpl.onConfigRefresh(context, sdkConfigData.toJson());
            }

            @Override // com.kwad.components.core.k.e.a
            public final void no() {
            }
        });
        return true;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        return d.isCanUseTk();
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nk() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nl() {
        return "3.3.26.1";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nm() {
        return "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.26.1.apk";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nn() {
        return "daf5b23731d40988bcb92485d3adf70a";
    }
}
