package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.IProgressRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
/* loaded from: classes7.dex */
public class c {
    public IProgressRemoteView a;

    public c(IProgressRemoteView iProgressRemoteView) {
        this.a = iProgressRemoteView;
    }

    public static c a(Context context, int i2, boolean z) {
        c cVar;
        int sDKType = KsAdSDKImpl.get().getSDKType();
        int apiVersionCode = KsAdSDKImpl.get().getApiVersionCode();
        boolean z2 = true;
        if ((sDKType != 1 || apiVersionCode < 3031000) && (sDKType != 2 || apiVersionCode < 3031800)) {
            z2 = false;
        }
        if (z2) {
            try {
                cVar = new c(RemoteViewBuilder.createProgressView(context, i2, z));
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
                cVar = null;
            }
        } else {
            cVar = new c(RemoteViewBuilder.createProgressView(context));
        }
        if (cVar == null) {
            try {
                return new c(RemoteViewBuilder.createProgressView(context));
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.a.b(th2);
                return cVar;
            }
        }
        return cVar;
    }

    public RemoteViews a() {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            return iProgressRemoteView.build();
        }
        return null;
    }

    public void a(int i2, int i3, boolean z) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setProgress(i2, i3, z);
        }
    }

    public void a(Bitmap bitmap) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setIcon(bitmap);
        }
    }

    public void a(String str) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setName(str);
        }
    }

    public void a(boolean z) {
        try {
            if (this.a != null) {
                this.a.setControlBtnPaused(z);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    public void b(String str) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setStatus(str);
        }
    }

    public void c(String str) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setSize(str);
        }
    }

    public void d(String str) {
        IProgressRemoteView iProgressRemoteView = this.a;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setPercentNum(str);
        }
    }
}
