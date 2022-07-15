package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.kwad.sdk.api.core.ICompletedRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
/* loaded from: classes5.dex */
public final class b {
    public ICompletedRemoteView a;

    public b(ICompletedRemoteView iCompletedRemoteView) {
        this.a = iCompletedRemoteView;
    }

    public static b a(Context context) {
        return new b(RemoteViewBuilder.createCompletedView(context));
    }

    public final RemoteViews a() {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            return iCompletedRemoteView.build();
        }
        return null;
    }

    public final void a(Bitmap bitmap) {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setIcon(bitmap);
        }
    }

    public final void a(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setName(str);
        }
    }

    public final void b(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setStatus(str);
        }
    }

    public final void c(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setSize(str);
        }
    }

    public final void d(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setInstallText(str);
        }
    }
}
