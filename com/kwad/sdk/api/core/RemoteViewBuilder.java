package com.kwad.sdk.api.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.Keep;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes6.dex */
public class RemoteViewBuilder {

    /* loaded from: classes6.dex */
    public static class CompletedRemoteViewImpl implements ICompletedRemoteView {
        public final Context mContext;
        public final Context mOriginContext;
        public final RemoteViews mRemoteViews;

        public CompletedRemoteViewImpl(Context context) {
            this.mContext = context;
            this.mOriginContext = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : context;
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), ResUtil.getLayoutId(this.mOriginContext, "ksad_notification_download_completed"));
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public RemoteViews build() {
            return this.mRemoteViews;
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setIcon(int i2) {
            setIcon(RemoteViewBuilder.getBitmap(this.mContext, i2));
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setIcon(Bitmap bitmap) {
            this.mRemoteViews.setImageViewBitmap(ResUtil.getId(this.mOriginContext, "ksad_download_icon"), bitmap);
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setInstallText(String str) {
            this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_install"), str);
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setName(String str) {
            this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_name"), str);
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setSize(String str) {
            this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_size"), str);
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setStatus(String str) {
            this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_status"), str);
        }
    }

    /* loaded from: classes6.dex */
    public static class ProgressRemoteViewImpl implements IProgressRemoteView {
        public final Context mContext;
        public final Context mOriginContext;
        public final RemoteViews mRemoteViews;

        public ProgressRemoteViewImpl(Context context) {
            this.mContext = context;
            this.mOriginContext = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : context;
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), ResUtil.getLayoutId(this.mOriginContext, "ksad_notification_download_progress"));
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public RemoteViews build() {
            return this.mRemoteViews;
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(int i2) {
            setIcon(RemoteViewBuilder.getBitmap(this.mContext, i2));
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(Bitmap bitmap) {
            this.mRemoteViews.setImageViewBitmap(ResUtil.getId(this.mOriginContext, "ksad_download_icon"), bitmap);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setName(String str) {
            this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_name"), str);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setPercentNum(String str) {
            this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_percent_num"), str);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setProgress(int i2, int i3, boolean z) {
            this.mRemoteViews.setProgressBar(ResUtil.getId(this.mOriginContext, "ksad_download_progress"), i2, i3, z);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setSize(String str) {
            this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_size"), str);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setStatus(String str) {
            this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_status"), str);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public static ICompletedRemoteView createCompletedView(Context context) {
        return new CompletedRemoteViewImpl(context);
    }

    @KsAdSdkDynamicApi
    @Keep
    public static IProgressRemoteView createProgressView(Context context) {
        return new ProgressRemoteViewImpl(context);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = !drawable.getBounds().isEmpty() ? drawable.getBounds().width() : drawable.getIntrinsicWidth();
        int height = !drawable.getBounds().isEmpty() ? drawable.getBounds().height() : drawable.getIntrinsicHeight();
        if (width <= 0) {
            width = 1;
        }
        if (height <= 0) {
            height = 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap getBitmap(Context context, int i2) {
        return drawableToBitmap(context.getResources().getDrawable(i2));
    }
}
