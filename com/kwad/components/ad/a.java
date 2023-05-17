package com.kwad.components.ad;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.ad.g.b;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.d;
/* loaded from: classes9.dex */
public class a extends d implements com.kwad.components.ad.a.a {
    @Override // com.kwad.components.ad.a.a
    public final String getBidRequestToken(KsScene ksScene) {
        return c.getBidRequestToken(ksScene);
    }

    @Override // com.kwad.components.ad.a.a
    public final String getBidRequestTokenV2(KsScene ksScene) {
        return c.getBidRequestTokenV2(ksScene);
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return com.kwad.components.ad.a.a.class;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
        b.kO().init();
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public int priority() {
        return -100;
    }

    @Override // com.kwad.components.ad.a.a
    public final boolean showInstallDialog(Activity activity, final KsExitInstallListener ksExitInstallListener) {
        return com.kwad.sdk.kwai.kwai.a.a(activity, new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                KsExitInstallListener ksExitInstallListener2 = ksExitInstallListener;
                if (ksExitInstallListener2 != null) {
                    ksExitInstallListener2.onDialogClose();
                }
            }
        }, new DialogInterface.OnClickListener() { // from class: com.kwad.components.ad.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                KsExitInstallListener ksExitInstallListener2 = ksExitInstallListener;
                if (ksExitInstallListener2 == null || i != -1) {
                    return;
                }
                ksExitInstallListener2.onInstallClick();
            }
        });
    }
}
