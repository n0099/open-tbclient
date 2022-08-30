package com.facebook.animated.giflite.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class MovieDrawer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Canvas mCanvas;
    public final Movie mMovie;
    @Nullable
    public Bitmap mPreviousBitmap;
    public final MovieScaleHolder mScaleHolder;

    public MovieDrawer(Movie movie) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {movie};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMovie = movie;
        this.mScaleHolder = new MovieScaleHolder(movie.width(), movie.height());
        this.mCanvas = new Canvas();
    }

    public synchronized void drawFrame(int i, int i2, int i3, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bitmap}) == null) {
            synchronized (this) {
                this.mMovie.setTime(i);
                if (this.mPreviousBitmap != null && this.mPreviousBitmap.isRecycled()) {
                    this.mPreviousBitmap = null;
                }
                if (this.mPreviousBitmap != bitmap) {
                    this.mPreviousBitmap = bitmap;
                    this.mCanvas.setBitmap(bitmap);
                }
                this.mScaleHolder.updateViewPort(i2, i3);
                this.mCanvas.save();
                this.mCanvas.scale(this.mScaleHolder.getScale(), this.mScaleHolder.getScale());
                this.mMovie.draw(this.mCanvas, this.mScaleHolder.getLeft(), this.mScaleHolder.getTop());
                this.mCanvas.restore();
            }
        }
    }
}
