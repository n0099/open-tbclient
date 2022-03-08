package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.kwad.sdk.api.core.ICompletedRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
/* loaded from: classes7.dex */
public class b {
    public ICompletedRemoteView a;

    public b(ICompletedRemoteView iCompletedRemoteView) {
        this.a = iCompletedRemoteView;
    }

    public static b a(Context context) {
        return new b(RemoteViewBuilder.createCompletedView(context));
    }

    public RemoteViews a() {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            return iCompletedRemoteView.build();
        }
        return null;
    }

    public void a(Bitmap bitmap) {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setIcon(bitmap);
        }
    }

    public void a(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setName(str);
        }
    }

    public void b(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setStatus(str);
        }
    }

    public void c(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setSize(str);
        }
    }

    public void d(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.a;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setInstallText(str);
        }
    }
}
