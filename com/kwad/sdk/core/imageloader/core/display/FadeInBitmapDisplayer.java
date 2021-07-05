package com.kwad.sdk.core.imageloader.core.display;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
/* loaded from: classes7.dex */
public class FadeInBitmapDisplayer implements BitmapDisplayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean animateFromDisk;
    public final boolean animateFromMemory;
    public final boolean animateFromNetwork;
    public final int durationMillis;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FadeInBitmapDisplayer(int i2) {
        this(i2, true, true, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public FadeInBitmapDisplayer(int i2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.durationMillis = i2;
        this.animateFromNetwork = z;
        this.animateFromDisk = z2;
        this.animateFromMemory = z3;
    }

    public static void animate(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, view, i2) == null) || view == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(i2);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        view.startAnimation(alphaAnimation);
    }

    @Override // com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer
    public void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, decodedResult, imageAware, loadedFrom) == null) {
            imageAware.setImageBitmap(decodedResult.mBitmap);
            if ((this.animateFromNetwork && loadedFrom == LoadedFrom.NETWORK) || ((this.animateFromDisk && loadedFrom == LoadedFrom.DISC_CACHE) || (this.animateFromMemory && loadedFrom == LoadedFrom.MEMORY_CACHE))) {
                animate(imageAware.getWrappedView(), this.durationMillis);
            }
        }
    }
}
