package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IProgressRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
/* loaded from: classes10.dex */
public final class c {
    public IProgressRemoteView asF;

    public c(IProgressRemoteView iProgressRemoteView) {
        this.asF = iProgressRemoteView;
    }

    public final void setControlBtnPaused(boolean z) {
        try {
            if (this.asF != null) {
                this.asF.setControlBtnPaused(z);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public final void setIcon(Bitmap bitmap) {
        IProgressRemoteView iProgressRemoteView = this.asF;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setIcon(bitmap);
        }
    }

    public final void setName(String str) {
        IProgressRemoteView iProgressRemoteView = this.asF;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setName(str);
        }
    }

    public final void setPercentNum(String str) {
        IProgressRemoteView iProgressRemoteView = this.asF;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setPercentNum(str);
        }
    }

    public final void setSize(String str) {
        IProgressRemoteView iProgressRemoteView = this.asF;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setSize(str);
        }
    }

    public final void setStatus(String str) {
        IProgressRemoteView iProgressRemoteView = this.asF;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setStatus(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(Context context, int i, boolean z) {
        boolean z2;
        c cVar;
        if (((f) ServiceProvider.get(f.class)).getApiVersionCode() >= 3031000) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            try {
                cVar = new c(RemoteViewBuilder.createProgressView(context, i, z));
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                cVar = null;
                if (cVar == null) {
                }
            }
        } else {
            try {
                cVar = new c(RemoteViewBuilder.createProgressView(context));
            } catch (Throwable th2) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th2);
                cVar = null;
                if (cVar == null) {
                }
            }
        }
        if (cVar == null) {
            try {
                return new c(RemoteViewBuilder.createProgressView(context));
            } catch (Throwable th3) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th3);
                return cVar;
            }
        }
        return cVar;
    }

    public final RemoteViews build() {
        IProgressRemoteView iProgressRemoteView = this.asF;
        if (iProgressRemoteView != null) {
            return iProgressRemoteView.build();
        }
        return null;
    }

    public final void setProgress(int i, int i2, boolean z) {
        IProgressRemoteView iProgressRemoteView = this.asF;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setProgress(100, i2, false);
        }
    }
}
