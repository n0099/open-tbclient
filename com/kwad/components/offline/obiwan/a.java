package com.kwad.components.offline.obiwan;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.k.e;
import com.kwad.components.core.offline.api.obiwan.ObiwanComponents;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.core.offline.init.a {

    /* renamed from: com.kwad.components.offline.obiwan.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0621a {
        public static final a Qh = new a((byte) 0);
    }

    public a() {
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.init.b.class, methodId = "initOC")
    public static void aC(Context context) {
        qw().init(context);
    }

    public static a qw() {
        return C0621a.Qh;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(Context context, ClassLoader classLoader) {
        IObiwanOfflineCompo iObiwanOfflineCompo = (IObiwanOfflineCompo) a(classLoader, IObiwanOfflineCompo.IMPL);
        if (iObiwanOfflineCompo == null) {
            return false;
        }
        final ObiwanComponentsImpl obiwanComponentsImpl = new ObiwanComponentsImpl(iObiwanOfflineCompo);
        com.kwad.sdk.components.c.a(ObiwanComponents.class, obiwanComponentsImpl);
        iObiwanOfflineCompo.initReal(context, KsAdSDKImpl.get().getSdkConfig(), new c());
        com.kwad.sdk.core.e.b.a(new b(obiwanComponentsImpl.getLog()));
        e.a(new e.a() { // from class: com.kwad.components.offline.obiwan.a.1
            private void updateConfigs() {
                com.kwad.sdk.core.e.b.a(d.isLogObiwanEnableNow() ? new b(obiwanComponentsImpl.getLog()) : null);
                obiwanComponentsImpl.updateConfigs();
            }

            @Override // com.kwad.components.core.k.e.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                updateConfigs();
            }

            @Override // com.kwad.components.core.k.e.a
            public final void no() {
                updateConfigs();
            }
        });
        return true;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        return d.isLogObiwanEnableNow();
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nk() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nl() {
        return "3.3.24.3";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nm() {
        return "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.24.3.apk";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nn() {
        return "ed7ce6364c3cbfa6c08587ab840e51a2";
    }
}
