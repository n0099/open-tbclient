package com.kwad.sdk.core.imageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class DisplayImageOptionsCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int blurRadius;
    public final boolean cacheInMemory;
    public final boolean cacheOnDisk;
    public final boolean considerExifParams;
    public final int cornerRound;
    public final BitmapFactory.Options decodingOptions;
    public final int delayBeforeLoading;
    public final Drawable imageForEmptyUri;
    public final Drawable imageOnFail;
    public final Drawable imageOnLoading;
    public final int imageResForEmptyUri;
    public final int imageResOnFail;
    public final int imageResOnLoading;
    public final boolean isCircle;
    public final boolean isFrameSequence;
    public final boolean isSyncLoading;
    public final boolean resetViewBeforeLoading;
    public final int strokeColor;
    public final float strokeWidth;

    /* renamed from: com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int blurRadius;
        public boolean cacheInMemory;
        public boolean cacheOnDisk;
        public boolean considerExifParams;
        public int cornerRound;
        public BitmapFactory.Options decodingOptions;
        public int delayBeforeLoading;
        public Drawable imageForEmptyUri;
        public Drawable imageOnFail;
        public Drawable imageOnLoading;
        public int imageResForEmptyUri;
        public int imageResOnFail;
        public int imageResOnLoading;
        public boolean isCircle;
        public boolean isFrameSequence;
        public boolean isSyncLoading;
        public boolean resetViewBeforeLoading;
        public int strokeColor;
        public float strokeWidth;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.imageResOnLoading = 0;
            this.imageResForEmptyUri = 0;
            this.imageResOnFail = 0;
            this.imageOnLoading = null;
            this.imageForEmptyUri = null;
            this.imageOnFail = null;
            this.resetViewBeforeLoading = false;
            this.cacheInMemory = false;
            this.cacheOnDisk = false;
            this.decodingOptions = new BitmapFactory.Options();
            this.delayBeforeLoading = 0;
            this.considerExifParams = false;
            this.isSyncLoading = false;
        }

        public Builder bitmapConfig(Bitmap.Config config) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, config)) == null) {
                if (config != null) {
                    this.decodingOptions.inPreferredConfig = config;
                    return this;
                }
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            return (Builder) invokeL.objValue;
        }

        public DisplayImageOptionsCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new DisplayImageOptionsCompat(this, null) : (DisplayImageOptionsCompat) invokeV.objValue;
        }

        @Deprecated
        public Builder cacheInMemory() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.cacheInMemory = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder cacheInMemory(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.cacheInMemory = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @Deprecated
        public Builder cacheOnDisc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? cacheOnDisk(true) : (Builder) invokeV.objValue;
        }

        @Deprecated
        public Builder cacheOnDisc(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) ? cacheOnDisk(z) : (Builder) invokeZ.objValue;
        }

        public Builder cacheOnDisk(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.cacheOnDisk = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder cloneFrom(DisplayImageOptionsCompat displayImageOptionsCompat) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, displayImageOptionsCompat)) == null) {
                this.imageResOnLoading = displayImageOptionsCompat.imageResOnLoading;
                this.imageResForEmptyUri = displayImageOptionsCompat.imageResForEmptyUri;
                this.imageResOnFail = displayImageOptionsCompat.imageResOnFail;
                this.imageOnLoading = displayImageOptionsCompat.imageOnLoading;
                this.imageForEmptyUri = displayImageOptionsCompat.imageForEmptyUri;
                this.imageOnFail = displayImageOptionsCompat.imageOnFail;
                this.resetViewBeforeLoading = displayImageOptionsCompat.resetViewBeforeLoading;
                this.cacheInMemory = displayImageOptionsCompat.cacheInMemory;
                this.cacheOnDisk = displayImageOptionsCompat.cacheOnDisk;
                this.decodingOptions = displayImageOptionsCompat.decodingOptions;
                this.delayBeforeLoading = displayImageOptionsCompat.delayBeforeLoading;
                this.considerExifParams = displayImageOptionsCompat.considerExifParams;
                this.isSyncLoading = displayImageOptionsCompat.isSyncLoading;
                this.blurRadius = displayImageOptionsCompat.blurRadius;
                this.isFrameSequence = displayImageOptionsCompat.isFrameSequence;
                this.cornerRound = displayImageOptionsCompat.cornerRound;
                this.isCircle = displayImageOptionsCompat.isCircle;
                this.strokeColor = displayImageOptionsCompat.strokeColor;
                this.strokeWidth = displayImageOptionsCompat.strokeWidth;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder considerExifParams(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.considerExifParams = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setBlurRadius(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.blurRadius = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setCircle(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.isCircle = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setCornerRound(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.cornerRound = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFrameSequence(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.isFrameSequence = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setStrokeColor(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                this.strokeColor = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setStrokeWidth(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048590, this, f2)) == null) {
                if (f2 > 0.0f) {
                    this.strokeWidth = f2;
                    this.isCircle = true;
                }
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder showImageForEmptyUri(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
                this.imageResForEmptyUri = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder showImageForEmptyUri(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, drawable)) == null) {
                this.imageForEmptyUri = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder showImageOnFail(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                this.imageResOnFail = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder showImageOnFail(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, drawable)) == null) {
                this.imageOnFail = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder showImageOnLoading(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
                this.imageResOnLoading = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder showImageOnLoading(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, drawable)) == null) {
                this.imageOnLoading = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder showStubImage(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
                this.imageResOnLoading = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    public DisplayImageOptionsCompat(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.imageResOnLoading = builder.imageResOnLoading;
        this.imageResForEmptyUri = builder.imageResForEmptyUri;
        this.imageResOnFail = builder.imageResOnFail;
        this.imageOnLoading = builder.imageOnLoading;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisk = builder.cacheOnDisk;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.isSyncLoading = builder.isSyncLoading;
        this.blurRadius = builder.blurRadius;
        this.isFrameSequence = builder.isFrameSequence;
        this.cornerRound = builder.cornerRound;
        this.isCircle = builder.isCircle;
        this.strokeColor = builder.strokeColor;
        this.strokeWidth = builder.strokeWidth;
    }

    public /* synthetic */ DisplayImageOptionsCompat(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static DisplayImageOptionsCompat createSimple() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? new Builder().build() : (DisplayImageOptionsCompat) invokeV.objValue;
    }

    public int getBlurRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.blurRadius : invokeV.intValue;
    }

    public int getCornerRound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cornerRound : invokeV.intValue;
    }

    public BitmapFactory.Options getDecodingOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.decodingOptions : (BitmapFactory.Options) invokeV.objValue;
    }

    public int getDelayBeforeLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.delayBeforeLoading : invokeV.intValue;
    }

    public Drawable getImageForEmptyUri(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, resources)) == null) {
            int i2 = this.imageResForEmptyUri;
            return i2 != 0 ? resources.getDrawable(i2) : this.imageForEmptyUri;
        }
        return (Drawable) invokeL.objValue;
    }

    public Drawable getImageOnFail(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, resources)) == null) {
            int i2 = this.imageResOnFail;
            return i2 != 0 ? resources.getDrawable(i2) : this.imageOnFail;
        }
        return (Drawable) invokeL.objValue;
    }

    public Drawable getImageOnLoading(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, resources)) == null) {
            int i2 = this.imageResOnLoading;
            return i2 != 0 ? resources.getDrawable(i2) : this.imageOnLoading;
        }
        return (Drawable) invokeL.objValue;
    }

    public int getStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.strokeColor : invokeV.intValue;
    }

    public float getStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.strokeWidth : invokeV.floatValue;
    }

    public boolean isCacheInMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.cacheInMemory : invokeV.booleanValue;
    }

    public boolean isCacheOnDisk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.cacheOnDisk : invokeV.booleanValue;
    }

    public boolean isCircle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isCircle : invokeV.booleanValue;
    }

    public boolean isConsiderExifParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.considerExifParams : invokeV.booleanValue;
    }

    public boolean isFrameSequence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.isFrameSequence : invokeV.booleanValue;
    }

    public boolean isResetViewBeforeLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.resetViewBeforeLoading : invokeV.booleanValue;
    }

    public boolean shouldDelayBeforeLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.delayBeforeLoading > 0 : invokeV.booleanValue;
    }

    public boolean shouldShowImageForEmptyUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true : invokeV.booleanValue;
    }

    public boolean shouldShowImageOnFail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true : invokeV.booleanValue;
    }

    public boolean shouldShowImageOnLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true : invokeV.booleanValue;
    }
}
