package com.facebook.animated.giflite.draw;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MovieScaleHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mLeft;
    public final int mMovieHeight;
    public final int mMovieWidth;
    public float mScale;
    public float mTop;
    public int mViewPortHeight;
    public int mViewPortWidth;

    public MovieScaleHolder(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mScale = 1.0f;
        this.mLeft = 0.0f;
        this.mTop = 0.0f;
        this.mMovieWidth = i;
        this.mMovieHeight = i2;
    }

    private synchronized void determineScaleAndPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                float f = this.mMovieWidth / this.mMovieHeight;
                float f2 = this.mViewPortWidth / this.mViewPortHeight;
                int i = this.mViewPortWidth;
                int i2 = this.mViewPortHeight;
                if (f2 > f) {
                    i = (int) (this.mViewPortHeight * f);
                } else if (f2 < f) {
                    i2 = (int) (this.mViewPortWidth / f);
                }
                if (this.mViewPortWidth > this.mMovieWidth) {
                    this.mScale = this.mMovieWidth / this.mViewPortWidth;
                } else if (this.mMovieWidth > this.mViewPortWidth) {
                    this.mScale = this.mViewPortWidth / this.mMovieWidth;
                } else {
                    this.mScale = 1.0f;
                }
                this.mLeft = ((this.mViewPortWidth - i) / 2.0f) / this.mScale;
                this.mTop = ((this.mViewPortHeight - i2) / 2.0f) / this.mScale;
            }
        }
    }

    public synchronized float getLeft() {
        InterceptResult invokeV;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                f = this.mLeft;
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public synchronized float getScale() {
        InterceptResult invokeV;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                f = this.mScale;
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public synchronized float getTop() {
        InterceptResult invokeV;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                f = this.mTop;
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public synchronized void updateViewPort(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            synchronized (this) {
                if (this.mViewPortWidth == i && this.mViewPortHeight == i2) {
                    return;
                }
                this.mViewPortWidth = i;
                this.mViewPortHeight = i2;
                determineScaleAndPosition();
            }
        }
    }
}
