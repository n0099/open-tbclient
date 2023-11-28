package com.kwad.components.core.webview.tachikoma;

import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
/* loaded from: classes10.dex */
public interface j {
    void a(a.C0664a c0664a);

    void a(aw awVar);

    void a(TKRenderFailReason tKRenderFailReason);

    void a(o oVar);

    void a(p pVar);

    void a(m mVar);

    void a(t tVar);

    void a(WebCloseStatus webCloseStatus);

    void a(com.kwad.sdk.components.p pVar, com.kwad.sdk.core.webview.b bVar);

    void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar);

    void b(ac.a aVar);

    @MainThread
    void bF();

    void bG();

    FrameLayout getTKContainer();

    String getTKReaderScene();

    String getTkTemplateId();

    com.kwad.sdk.widget.e getTouchCoordsView();
}
