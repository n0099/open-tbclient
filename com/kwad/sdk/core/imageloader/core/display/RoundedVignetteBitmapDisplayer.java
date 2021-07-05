package com.kwad.sdk.core.imageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageViewAware;
/* loaded from: classes7.dex */
public class RoundedVignetteBitmapDisplayer extends RoundedBitmapDisplayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class RoundedVignetteDrawable extends RoundedBitmapDisplayer.RoundedDrawable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoundedVignetteDrawable(Bitmap bitmap, int i2, int i3) {
            super(bitmap, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Bitmap) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer.RoundedDrawable, android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rect) == null) {
                super.onBoundsChange(rect);
                RadialGradient radialGradient = new RadialGradient(this.mRect.centerX(), (this.mRect.centerY() * 1.0f) / 0.7f, 1.3f * this.mRect.centerX(), new int[]{0, 0, 2130706432}, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
                Matrix matrix = new Matrix();
                matrix.setScale(1.0f, 0.7f);
                radialGradient.setLocalMatrix(matrix);
                this.paint.setShader(new ComposeShader(this.bitmapShader, radialGradient, PorterDuff.Mode.SRC_OVER));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedVignetteBitmapDisplayer(int i2, int i3) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer, com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer
    public void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, decodedResult, imageAware, loadedFrom) == null) {
            if (!(imageAware instanceof ImageViewAware)) {
                throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
            }
            imageAware.setImageDrawable(new RoundedVignetteDrawable(decodedResult.mBitmap, this.cornerRadius, this.margin));
        }
    }
}
