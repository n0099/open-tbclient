package com.kwad.sdk.api.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.R;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes7.dex */
public class RemoteViewBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.api.core.RemoteViewBuilder$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
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
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), R.layout.ksad_notification_download_completed);
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
                this.mRemoteViews.setImageViewBitmap(R.id.ksad_download_icon, bitmap);
            }
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setInstallText(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.mRemoteViews.setTextViewText(R.id.ksad_download_install, str);
            }
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mRemoteViews.setTextViewText(R.id.ksad_download_name, str);
            }
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setSize(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.mRemoteViews.setTextViewText(R.id.ksad_download_size, str);
            }
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setStatus(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.mRemoteViews.setTextViewText(R.id.ksad_download_status, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class ProgressRemoteViewImpl implements IProgressRemoteView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mContext;
        public final Context mOriginContext;
        public final RemoteViews mRemoteViews;

        public ProgressRemoteViewImpl(Context context) {
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
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), R.layout.ksad_notification_download_progress);
        }

        public /* synthetic */ ProgressRemoteViewImpl(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public RemoteViews build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRemoteViews : (RemoteViews) invokeV.objValue;
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                setIcon(RemoteViewBuilder.getBitmap(this.mContext, i2));
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                this.mRemoteViews.setImageViewBitmap(R.id.ksad_download_icon, bitmap);
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.mRemoteViews.setTextViewText(R.id.ksad_download_name, str);
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setPercentNum(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mRemoteViews.setTextViewText(R.id.ksad_download_percent_num, str);
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setProgress(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
                this.mRemoteViews.setProgressBar(R.id.ksad_download_progress, i2, i3, z);
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setSize(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.mRemoteViews.setTextViewText(R.id.ksad_download_size, str);
            }
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setStatus(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.mRemoteViews.setTextViewText(R.id.ksad_download_status, str);
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
    public static IProgressRemoteView createProgressView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? new ProgressRemoteViewImpl(context, null) : (IProgressRemoteView) invokeL.objValue;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, drawable)) == null) {
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
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, context, i2)) == null) ? drawableToBitmap(context.getResources().getDrawable(i2)) : (Bitmap) invokeLI.objValue;
    }
}
