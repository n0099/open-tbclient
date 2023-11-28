package com.kwad.sdk.api.core;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.Keep;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.searchbox.ui.SystemBarTintManager;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes10.dex */
public class RemoteViewBuilder {

    /* loaded from: classes10.dex */
    public static class CompletedRemoteViewImpl implements ICompletedRemoteView {
        public final Context mContext;
        public final Context mOriginContext;
        public final RemoteViews mRemoteViews;

        public CompletedRemoteViewImpl(Context context) {
            this.mContext = context;
            if (context instanceof ResContext) {
                this.mOriginContext = ((ResContext) context).getDelegatedContext();
            } else {
                this.mOriginContext = context;
            }
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), ResUtil.getLayoutId(this.mOriginContext, "ksad_notification_download_completed"));
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setIcon(int i) {
            setIcon(RemoteViewBuilder.getBitmap(this.mContext, i));
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

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public RemoteViews build() {
            return this.mRemoteViews;
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setIcon(Bitmap bitmap) {
            this.mRemoteViews.setImageViewBitmap(ResUtil.getId(this.mOriginContext, "ksad_download_icon"), bitmap);
        }
    }

    /* loaded from: classes10.dex */
    public static class ProgressRemoteViewImpl implements IProgressRemoteView {
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
            String str;
            this.btnControlId = -1;
            this.btnTextColorChecked = Color.parseColor("#FFFFFFFF");
            this.btnTextColorUnchecked = Color.parseColor("#FF222222");
            this.downloadTaskId = 0;
            this.mContext = context;
            this.downloadTaskId = i;
            if (context instanceof ResContext) {
                this.mOriginContext = ((ResContext) context).getDelegatedContext();
            } else {
                this.mOriginContext = context;
            }
            if (z) {
                str = "ksad_notification_download_progress_with_control";
            } else {
                str = "ksad_notification_download_progress_without_control";
            }
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), ResUtil.getLayoutId(this.mOriginContext, str));
            this.btnControlId = ResUtil.getId(this.mOriginContext, "ksad_download_control_btn");
            initViews();
            setControlBtnPaused(false);
        }

        private void initViews() {
            PendingIntent broadcast;
            Intent intent = new Intent(ACTION_CLICK_CONTROL_BTN);
            intent.putExtra("taskId", this.downloadTaskId);
            if (Build.VERSION.SDK_INT >= 31) {
                broadcast = PendingIntent.getBroadcast(this.mContext, this.downloadTaskId, intent, BDImageView.DEFAULT_BORDER_COLOR);
            } else {
                broadcast = PendingIntent.getBroadcast(this.mContext, this.downloadTaskId, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
            }
            this.mRemoteViews.setOnClickPendingIntent(this.btnControlId, broadcast);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public RemoteViews build() {
            return this.mRemoteViews;
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setControlBtnPaused(boolean z) {
            String str;
            int i;
            int drawableId;
            if (this.mRemoteViews == null) {
                return;
            }
            if (z) {
                str = "继续";
            } else {
                str = "暂停";
            }
            this.mRemoteViews.setTextViewText(this.btnControlId, str);
            if (z) {
                i = this.btnTextColorChecked;
            } else {
                i = this.btnTextColorUnchecked;
            }
            this.mRemoteViews.setTextColor(this.btnControlId, i);
            if (z) {
                drawableId = ResUtil.getDrawableId(this.mOriginContext, "ksad_notification_control_btn_bg_checked");
            } else {
                drawableId = ResUtil.getDrawableId(this.mOriginContext, "ksad_notification_control_btn_bg_unchecked");
            }
            this.mRemoteViews.setImageViewResource(ResUtil.getId(this.mOriginContext, "ksad_download_control_bg_image"), drawableId);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(int i) {
            setIcon(RemoteViewBuilder.getBitmap(this.mContext, i));
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
        public void setSize(String str) {
            this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_size"), str);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setStatus(String str) {
            this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_status"), str);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(Bitmap bitmap) {
            this.mRemoteViews.setImageViewBitmap(ResUtil.getId(this.mOriginContext, "ksad_download_icon"), bitmap);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setProgress(int i, int i2, boolean z) {
            this.mRemoteViews.setProgressBar(ResUtil.getId(this.mOriginContext, "ksad_download_progress"), i, i2, z);
        }
    }

    public static Bitmap getBitmap(Context context, int i) {
        return drawableToBitmap(context.getResources().getDrawable(i));
    }

    @KsAdSdkDynamicApi
    @Keep
    public static ICompletedRemoteView createCompletedView(Context context) {
        return new CompletedRemoteViewImpl(context);
    }

    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public static IProgressRemoteView createProgressView(Context context) {
        return new ProgressRemoteViewImpl(context, 0, false);
    }

    @KsAdSdkDynamicApi
    @Keep
    public static IProgressRemoteView createProgressView(Context context, int i, boolean z) {
        return new ProgressRemoteViewImpl(context, i, z);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!drawable.getBounds().isEmpty()) {
            intrinsicWidth = drawable.getBounds().width();
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        if (!drawable.getBounds().isEmpty()) {
            intrinsicHeight = drawable.getBounds().height();
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }
}
