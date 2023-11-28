package com.kwad.components.offline.c.a;

import android.content.Intent;
import com.kwad.components.offline.api.tk.IOfflineHostActionHandler;
import com.kwad.components.offline.api.tk.IOfflineTKDialog;
import com.kwad.components.offline.api.tk.IOfflineTKNativeIntent;
import com.kwad.sdk.components.j;
import com.kwad.sdk.components.k;
import com.kwad.sdk.components.m;
import com.kwad.sdk.components.n;
/* loaded from: classes10.dex */
public final class c implements IOfflineHostActionHandler {
    public final n YV;

    public c(n nVar) {
        this.YV = nVar;
    }

    private j a(final IOfflineTKDialog iOfflineTKDialog) {
        return new j() { // from class: com.kwad.components.offline.c.a.c.2
            @Override // com.kwad.sdk.components.j
            public final void callbackPageStatus(boolean z, String str) {
                iOfflineTKDialog.callbackPageStatus(z, str);
            }

            @Override // com.kwad.sdk.components.j
            public final void a(m mVar) {
                iOfflineTKDialog.registerJSCallHandler(new g(mVar));
            }

            @Override // com.kwad.sdk.components.j
            public final void callTKBridge(String str) {
                iOfflineTKDialog.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.j
            public final void callbackDialogDismiss() {
                iOfflineTKDialog.callbackDialogDismiss();
            }

            @Override // com.kwad.sdk.components.j
            public final int getDialogId() {
                return iOfflineTKDialog.getDialogId();
            }

            @Override // com.kwad.sdk.components.j
            public final String getStyleTemplate() {
                return iOfflineTKDialog.getStyleTemplate();
            }

            @Override // com.kwad.sdk.components.j
            public final String getViewKey() {
                return iOfflineTKDialog.getViewKey();
            }
        };
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void dismissDialog(IOfflineTKDialog iOfflineTKDialog) {
        n nVar = this.YV;
        if (nVar != null) {
            nVar.b(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void showDialog(IOfflineTKDialog iOfflineTKDialog) {
        n nVar = this.YV;
        if (nVar != null) {
            nVar.a(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void startActivity(IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        n nVar = this.YV;
        if (nVar != null) {
            nVar.a(a(iOfflineTKNativeIntent));
        }
    }

    private k a(final IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        return new k() { // from class: com.kwad.components.offline.c.a.c.1
            @Override // com.kwad.sdk.components.k
            public final void callbackPageStatus(boolean z, String str) {
                iOfflineTKNativeIntent.callbackPageStatus(z, str);
            }

            @Override // com.kwad.sdk.components.k
            public final void a(m mVar) {
                iOfflineTKNativeIntent.registerJSCallHandler(new g(mVar));
            }

            @Override // com.kwad.sdk.components.k
            public final void callTKBridge(String str) {
                iOfflineTKNativeIntent.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.k
            public final void callbackDismiss() {
                iOfflineTKNativeIntent.callbackDismiss();
            }

            @Override // com.kwad.sdk.components.k
            public final String getClassName() {
                return iOfflineTKNativeIntent.getClassName();
            }

            @Override // com.kwad.sdk.components.k
            public final Intent getIntent() {
                return iOfflineTKNativeIntent.getIntent();
            }

            @Override // com.kwad.sdk.components.k
            public final String getTemplateString() {
                return iOfflineTKNativeIntent.getTemplateString();
            }

            @Override // com.kwad.sdk.components.k
            public final String getUrl() {
                return iOfflineTKNativeIntent.getUrl();
            }

            @Override // com.kwad.sdk.components.k
            public final String getViewKey() {
                return iOfflineTKNativeIntent.getViewKey();
            }
        };
    }
}
