package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ICompletedRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
/* loaded from: classes10.dex */
public final class b {
    public ICompletedRemoteView asE;

    public b(ICompletedRemoteView iCompletedRemoteView) {
        this.asE = iCompletedRemoteView;
    }

    @Nullable
    public static b aY(Context context) {
        try {
            return new b(RemoteViewBuilder.createCompletedView(context));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    public final void setIcon(Bitmap bitmap) {
        ICompletedRemoteView iCompletedRemoteView = this.asE;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setIcon(bitmap);
        }
    }

    public final void setInstallText(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.asE;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setInstallText(str);
        }
    }

    public final void setName(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.asE;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setName(str);
        }
    }

    public final void setSize(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.asE;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setSize(str);
        }
    }

    public final void setStatus(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.asE;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setStatus(str);
        }
    }

    public final RemoteViews build() {
        ICompletedRemoteView iCompletedRemoteView = this.asE;
        if (iCompletedRemoteView != null) {
            return iCompletedRemoteView.build();
        }
        return null;
    }
}
