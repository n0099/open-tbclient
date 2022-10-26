package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.kwad.sdk.api.core.IProgressRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
/* loaded from: classes7.dex */
public final class c {
    public IProgressRemoteView Xn;

    public c(IProgressRemoteView iProgressRemoteView) {
        this.Xn = iProgressRemoteView;
    }

    public static c a(Context context, int i, boolean z) {
        c cVar;
        try {
            cVar = ((d) ServiceProvider.get(d.class)).getApiVersionCode() >= 3031000 ? new c(RemoteViewBuilder.createProgressView(context, i, z)) : new c(RemoteViewBuilder.createProgressView(context));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            cVar = null;
        }
        if (cVar == null) {
            try {
                return new c(RemoteViewBuilder.createProgressView(context));
            } catch (Throwable th2) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th2);
                return cVar;
            }
        }
        return cVar;
    }

    public final RemoteViews build() {
        IProgressRemoteView iProgressRemoteView = this.Xn;
        if (iProgressRemoteView != null) {
            return iProgressRemoteView.build();
        }
        return null;
    }

    public final void setControlBtnPaused(boolean z) {
        try {
            if (this.Xn != null) {
                this.Xn.setControlBtnPaused(z);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    public final void setIcon(Bitmap bitmap) {
        IProgressRemoteView iProgressRemoteView = this.Xn;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setIcon(bitmap);
        }
    }

    public final void setName(String str) {
        IProgressRemoteView iProgressRemoteView = this.Xn;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setName(str);
        }
    }

    public final void setPercentNum(String str) {
        IProgressRemoteView iProgressRemoteView = this.Xn;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setPercentNum(str);
        }
    }

    public final void setProgress(int i, int i2, boolean z) {
        IProgressRemoteView iProgressRemoteView = this.Xn;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setProgress(100, i2, false);
        }
    }

    public final void setSize(String str) {
        IProgressRemoteView iProgressRemoteView = this.Xn;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setSize(str);
        }
    }

    public final void setStatus(String str) {
        IProgressRemoteView iProgressRemoteView = this.Xn;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setStatus(str);
        }
    }
}
