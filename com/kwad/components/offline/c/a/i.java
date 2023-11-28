package com.kwad.components.offline.c.a;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.IOfflineTKView;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.n;
import com.kwad.sdk.components.o;
import com.kwad.sdk.components.p;
import com.kwad.sdk.utils.ap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class i implements p {
    public final IOfflineCompoTachikomaContext adf;

    public i(@NonNull IOfflineCompoTachikomaContext iOfflineCompoTachikomaContext) {
        ap.checkNotNull(iOfflineCompoTachikomaContext);
        this.adf = iOfflineCompoTachikomaContext;
    }

    @Override // com.kwad.sdk.components.p
    public final void a(com.kwad.sdk.components.i iVar) {
        if (iVar != null) {
            this.adf.registerApkLoadCreator(new e(iVar));
        }
    }

    @Override // com.kwad.sdk.components.p
    public final l aR(String str) {
        final IOfflineTKView tKView = this.adf.getTKView(str, new Object[0]);
        return new l() { // from class: com.kwad.components.offline.c.a.i.1
            @Override // com.kwad.sdk.components.l
            public final void bindActivity(Activity activity) {
                tKView.bindActivity(activity);
            }

            @Override // com.kwad.sdk.components.l
            public final View getView() {
                return tKView.getView();
            }

            @Override // com.kwad.sdk.components.l
            public final boolean onBackPressed() {
                return tKView.onBackPressed();
            }

            @Override // com.kwad.sdk.components.l
            public final void render() {
                tKView.render();
            }
        };
    }

    @Override // com.kwad.sdk.components.p
    public final void b(com.kwad.sdk.core.webview.c.g gVar) {
        if (gVar == null) {
            return;
        }
        this.adf.registerTKBridge(new f(gVar));
    }

    @Override // com.kwad.sdk.components.p
    public final void c(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar == null) {
            return;
        }
        this.adf.registerJsBridge(new b(aVar));
    }

    @Override // com.kwad.sdk.components.p
    public final Object execute(String str) {
        return this.adf.execute(str);
    }

    @Override // com.kwad.sdk.components.p
    public final void setCustomEnv(Map<String, Object> map) {
        this.adf.setCustomEnv(map);
    }

    @Override // com.kwad.sdk.components.p
    public final void a(n nVar) {
        if (nVar != null) {
            this.adf.registerHostActionHandler(new c(nVar));
        }
    }

    @Override // com.kwad.sdk.components.p
    public final void a(String str, String str2, o oVar) {
        this.adf.execute(str, str2, new h(oVar));
    }

    @Override // com.kwad.sdk.components.p
    public final int getUniqId() {
        return this.adf.getUniqId();
    }

    @Override // com.kwad.sdk.components.p
    public final View getView() {
        return this.adf.getView();
    }

    @Override // com.kwad.sdk.components.p
    public final void onDestroy() {
        this.adf.onDestroy();
    }
}
