package com.kwad.sdk.api.core;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
@KsAdSdkDynamicApi
/* loaded from: classes7.dex */
public class RemoteViewBuilder {

    /* loaded from: classes7.dex */
    public class CompletedRemoteViewImpl implements ICompletedRemoteView {
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
        public void setIcon(int i) {
            setIcon(RemoteViewBuilder.getBitmap(this.mContext, i));
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

    /* loaded from: classes7.dex */
    public class ProgressRemoteViewImpl implements IProgressRemoteView {
        public static final String ACTION_CLICK_CONTROL_BTN = "com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN";
        public static final String KEY_TASKID = "taskId";
        public int btnControlId;
        public int btnTextColorChecked;
        public int btnTextColorUnchecked;
        public int downloadTaskId;
        public final Context mContext;
        public final Context mOriginContext;
        public final RemoteViews mRemoteViews;

        public ProgressRemoteViewImpl(Context context, int i, boolean z) {
            this.btnControlId = -1;
            this.btnTextColorChecked = Color.parseColor("#FFFFFFFF");
            this.btnTextColorUnchecked = Color.parseColor("#FF222222");
            this.downloadTaskId = 0;
            this.mContext = context;
            this.downloadTaskId = i;
            this.mOriginContext = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : context;
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), ResUtil.getLayoutId(this.mOriginContext, z ? "ksad_notification_download_progress_with_control" : "ksad_notification_download_progress_without_control"));
            this.btnControlId = ResUtil.getId(this.mOriginContext, "ksad_download_control_btn");
            initViews();
            setControlBtnPaused(false);
        }

        private void initViews() {
            Intent intent = new Intent(ACTION_CLICK_CONTROL_BTN);
            intent.putExtra("taskId", this.downloadTaskId);
            this.mRemoteViews.setOnClickPendingIntent(this.btnControlId, PendingIntent.getBroadcast(this.mContext, this.downloadTaskId, intent, 0));
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public RemoteViews build() {
            return this.mRemoteViews;
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setControlBtnPaused(boolean z) {
            Context context;
            String str;
            if (this.mRemoteViews == null) {
                return;
            }
            this.mRemoteViews.setTextViewText(this.btnControlId, z ? "继续" : "暂停");
            this.mRemoteViews.setTextColor(this.btnControlId, z ? this.btnTextColorChecked : this.btnTextColorUnchecked);
            if (z) {
                context = this.mOriginContext;
                str = "ksad_notification_control_btn_bg_checked";
            } else {
                context = this.mOriginContext;
                str = "ksad_notification_control_btn_bg_unchecked";
            }
            this.mRemoteViews.setImageViewResource(ResUtil.getId(this.mOriginContext, "ksad_download_control_bg_image"), ResUtil.getDrawableId(context, str));
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(int i) {
            setIcon(RemoteViewBuilder.getBitmap(this.mContext, i));
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
        public void setProgress(int i, int i2, boolean z) {
            this.mRemoteViews.setProgressBar(ResUtil.getId(this.mOriginContext, "ksad_download_progress"), i, i2, z);
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
    public static ICompletedRemoteView createCompletedView(Context context) {
        return new CompletedRemoteViewImpl(context);
    }

    @KsAdSdkDynamicApi
    @Deprecated
    public static IProgressRemoteView createProgressView(Context context) {
        return new ProgressRemoteViewImpl(context, 0, false);
    }

    @KsAdSdkDynamicApi
    public static IProgressRemoteView createProgressView(Context context, int i, boolean z) {
        return new ProgressRemoteViewImpl(context, i, z);
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

    public static Bitmap getBitmap(Context context, int i) {
        return drawableToBitmap(context.getResources().getDrawable(i));
    }
}
