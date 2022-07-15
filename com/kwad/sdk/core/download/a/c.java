package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IProgressRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
/* loaded from: classes5.dex */
public final class c {
    public IProgressRemoteView a;

    public c(IProgressRemoteView iProgressRemoteView) {
        this.a = iProgressRemoteView;
    }

    @Nullable
    public static c a(Context context, int i, boolean z) {
        c cVar;
        try {
            cVar = ((d) ServiceProvider.a(d.class)).f() >= 3031000 ? new c(RemoteViewBuilder.createProgressView(context, i, z)) : new c(RemoteViewBuilder.createProgressView(context));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.b(th);
            cVar = null;
        }
        if (cVar == null) {
            try {
                return new c(RemoteViewBuilder.createProgressView(context));
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.b.b(th2);
                return cVar;
            }
        }
        return cVar;
    }

    public final RemoteViews a() {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            return iProgressRemoteView.build();
        }
        return null;
    }

    public final void a(int i, int i2, boolean z) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setProgress(100, i2, false);
        }
    }

    public final void a(Bitmap bitmap) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setIcon(bitmap);
        }
    }

    public final void a(String str) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setName(str);
        }
    }

    public final void a(boolean z) {
        try {
            if (this.a != null) {
                this.a.setControlBtnPaused(z);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.b(th);
        }
    }

    public final void b(String str) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setStatus(str);
        }
    }

    public final void c(String str) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setSize(str);
        }
    }

    public final void d(String str) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setPercentNum(str);
        }
    }
}
