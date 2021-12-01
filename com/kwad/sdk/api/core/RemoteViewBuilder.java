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
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes2.dex */
public class RemoteViewBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.api.core.RemoteViewBuilder$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class CompletedRemoteViewImpl implements ICompletedRemoteView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mContext;
        public final Context mOriginContext;
        public final RemoteViews mRemoteViews;

        public CompletedRemoteViewImpl(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
            this.mOriginContext = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : context;
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), ResUtil.getLayoutId(this.mOriginContext, "ksad_notification_download_completed"));
        }

        public /* synthetic */ CompletedRemoteViewImpl(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public RemoteViews build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRemoteViews : (RemoteViews) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setIcon(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                setIcon(RemoteViewBuilder.getBitmap(this.mContext, i2));
            }
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setIcon(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                this.mRemoteViews.setImageViewBitmap(ResUtil.getId(this.mOriginContext, "ksad_download_icon"), bitmap);
            }
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setInstallText(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_install"), str);
            }
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_name"), str);
            }
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setSize(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_size"), str);
            }
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setStatus(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_status"), str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ProgressRemoteViewImpl implements IProgressRemoteView {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ACTION_CLICK_CONTROL_BTN = "com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN";
        public static final String KEY_TASKID = "taskId";
        public transient /* synthetic */ FieldHolder $fh;
        public int btnControlId;
        public int btnTextColorChecked;
        public int btnTextColorUnchecked;
        public int downloadTaskId;
        public final Context mContext;
        public final Context mOriginContext;
        public final RemoteViews mRemoteViews;

        public ProgressRemoteViewImpl(Context context, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.btnControlId = -1;
            this.btnTextColorChecked = Color.parseColor("#FFFFFFFF");
            this.btnTextColorUnchecked = Color.parseColor("#FF222222");
            this.downloadTaskId = 0;
            this.mContext = context;
            this.downloadTaskId = i2;
            if (context instanceof ResContext) {
                this.mOriginContext = ((ResContext) context).getDelegatedContext();
            } else {
                this.mOriginContext = context;
            }
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), ResUtil.getLayoutId(this.mOriginContext, z ? "ksad_notification_download_progress_with_control" : "ksad_notification_download_progress_without_control"));
            this.btnControlId = ResUtil.getId(context, "ksad_download_control_btn");
            initViews();
            setControlBtnPaused(false);
        }

        public /* synthetic */ ProgressRemoteViewImpl(Context context, int i2, boolean z, AnonymousClass1 anonymousClass1) {
            this(context, i2, z);
        }

        private void initViews() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                Intent intent = new Intent(ACTION_CLICK_CONTROL_BTN);
                intent.putExtra(KEY_TASKID, this.downloadTaskId);
                this.mRemoteViews.setOnClickPendingIntent(this.btnControlId, PendingIntent.getBroadcast(this.mContext, this.downloadTaskId, intent, 0));
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public RemoteViews build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRemoteViews : (RemoteViews) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setControlBtnPaused(boolean z) {
            Context context;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.mRemoteViews == null) {
                return;
            }
            this.mRemoteViews.setTextViewText(this.btnControlId, z ? "继续" : "暂停");
            this.mRemoteViews.setTextColor(this.btnControlId, z ? this.btnTextColorChecked : this.btnTextColorUnchecked);
            if (z) {
                context = this.mContext;
                str = "ksad_notification_control_btn_bg_checked";
            } else {
                context = this.mContext;
                str = "ksad_notification_control_btn_bg_unchecked";
            }
            this.mRemoteViews.setImageViewResource(ResUtil.getId(this.mContext, "ksad_download_control_bg_image"), ResUtil.getDrawableId(context, str));
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                setIcon(RemoteViewBuilder.getBitmap(this.mContext, i2));
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                this.mRemoteViews.setImageViewBitmap(ResUtil.getId(this.mOriginContext, "ksad_download_icon"), bitmap);
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_name"), str);
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setPercentNum(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_percent_num"), str);
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setProgress(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
                this.mRemoteViews.setProgressBar(ResUtil.getId(this.mOriginContext, "ksad_download_progress"), i2, i3, z);
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setSize(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_size"), str);
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setStatus(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.mRemoteViews.setTextViewText(ResUtil.getId(this.mOriginContext, "ksad_download_status"), str);
            }
        }
    }

    public RemoteViewBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public static ICompletedRemoteView createCompletedView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new CompletedRemoteViewImpl(context, null) : (ICompletedRemoteView) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public static IProgressRemoteView createProgressView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? new ProgressRemoteViewImpl(context, 0, false, null) : (IProgressRemoteView) invokeL.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public static IProgressRemoteView createProgressView(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? new ProgressRemoteViewImpl(context, i2, z, null) : (IProgressRemoteView) invokeCommon.objValue;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, drawable)) == null) {
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
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap getBitmap(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i2)) == null) ? drawableToBitmap(context.getResources().getDrawable(i2)) : (Bitmap) invokeLI.objValue;
    }
}
