package com.kwad.sdk.core.imageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.process.BitmapProcessor;
/* loaded from: classes7.dex */
public final class DisplayImageOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean cacheInMemory;
    public final boolean cacheOnDisk;
    public final boolean considerExifParams;
    public final BitmapFactory.Options decodingOptions;
    public final int delayBeforeLoading;
    public final BitmapDisplayer displayer;
    public final Object extraForDownloader;
    public final Handler handler;
    public final Drawable imageForEmptyUri;
    public final Drawable imageOnFail;
    public final Drawable imageOnLoading;
    public final int imageResForEmptyUri;
    public final int imageResOnFail;
    public final int imageResOnLoading;
    public final ImageScaleType imageScaleType;
    public final boolean isSyncLoading;
    public final BitmapProcessor postProcessor;
    public final BitmapProcessor preProcessor;
    public final boolean resetViewBeforeLoading;

    /* renamed from: com.kwad.sdk.core.imageloader.core.DisplayImageOptions$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean cacheInMemory;
        public boolean cacheOnDisk;
        public boolean considerExifParams;
        public BitmapFactory.Options decodingOptions;
        public int delayBeforeLoading;
        public BitmapDisplayer displayer;
        public Object extraForDownloader;
        public Handler handler;
        public Drawable imageForEmptyUri;
        public Drawable imageOnFail;
        public Drawable imageOnLoading;
        public int imageResForEmptyUri;
        public int imageResOnFail;
        public int imageResOnLoading;
        public ImageScaleType imageScaleType;
        public boolean isSyncLoading;
        public BitmapProcessor postProcessor;
        public BitmapProcessor preProcessor;
        public boolean resetViewBeforeLoading;

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
            this.imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
            this.decodingOptions = new BitmapFactory.Options();
            this.delayBeforeLoading = 0;
            this.considerExifParams = false;
            this.extraForDownloader = null;
            this.preProcessor = null;
            this.postProcessor = null;
            this.displayer = DefaultConfigurationFactory.createBitmapDisplayer();
            this.handler = null;
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

        public DisplayImageOptions build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new DisplayImageOptions(this, null) : (DisplayImageOptions) invokeV.objValue;
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

        public Builder cloneFrom(DisplayImageOptions displayImageOptions) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, displayImageOptions)) == null) {
                this.imageResOnLoading = displayImageOptions.imageResOnLoading;
                this.imageResForEmptyUri = displayImageOptions.imageResForEmptyUri;
                this.imageResOnFail = displayImageOptions.imageResOnFail;
                this.imageOnLoading = displayImageOptions.imageOnLoading;
                this.imageForEmptyUri = displayImageOptions.imageForEmptyUri;
                this.imageOnFail = displayImageOptions.imageOnFail;
                this.resetViewBeforeLoading = displayImageOptions.resetViewBeforeLoading;
                this.cacheInMemory = displayImageOptions.cacheInMemory;
                this.cacheOnDisk = displayImageOptions.cacheOnDisk;
                this.imageScaleType = displayImageOptions.imageScaleType;
                this.decodingOptions = displayImageOptions.decodingOptions;
                this.delayBeforeLoading = displayImageOptions.delayBeforeLoading;
                this.considerExifParams = displayImageOptions.considerExifParams;
                this.extraForDownloader = displayImageOptions.extraForDownloader;
                this.preProcessor = displayImageOptions.preProcessor;
                this.postProcessor = displayImageOptions.postProcessor;
                this.displayer = displayImageOptions.displayer;
                this.handler = displayImageOptions.handler;
                this.isSyncLoading = displayImageOptions.isSyncLoading;
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

        public Builder decodingOptions(BitmapFactory.Options options) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, options)) == null) {
                if (options != null) {
                    this.decodingOptions = options;
                    return this;
                }
                throw new IllegalArgumentException("decodingOptions can't be null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder delayBeforeLoading(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.delayBeforeLoading = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder displayer(BitmapDisplayer bitmapDisplayer) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bitmapDisplayer)) == null) {
                if (bitmapDisplayer != null) {
                    this.displayer = bitmapDisplayer;
                    return this;
                }
                throw new IllegalArgumentException("displayer can't be null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder extraForDownloader(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
                this.extraForDownloader = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder handler(Handler handler) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, handler)) == null) {
                this.handler = handler;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder imageScaleType(ImageScaleType imageScaleType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, imageScaleType)) == null) {
                this.imageScaleType = imageScaleType;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder postProcessor(BitmapProcessor bitmapProcessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bitmapProcessor)) == null) {
                this.postProcessor = bitmapProcessor;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder preProcessor(BitmapProcessor bitmapProcessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bitmapProcessor)) == null) {
                this.preProcessor = bitmapProcessor;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder resetViewBeforeLoading() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                this.resetViewBeforeLoading = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder resetViewBeforeLoading(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
                this.resetViewBeforeLoading = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder showImageForEmptyUri(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
                this.imageResForEmptyUri = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder showImageForEmptyUri(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, drawable)) == null) {
                this.imageForEmptyUri = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder showImageOnFail(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
                this.imageResOnFail = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder showImageOnFail(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, drawable)) == null) {
                this.imageOnFail = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder showImageOnLoading(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
                this.imageResOnLoading = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder showImageOnLoading(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, drawable)) == null) {
                this.imageOnLoading = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder showStubImage(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
                this.imageResOnLoading = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder syncLoading(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
                this.isSyncLoading = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    public DisplayImageOptions(Builder builder) {
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
        this.imageScaleType = builder.imageScaleType;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.extraForDownloader = builder.extraForDownloader;
        this.preProcessor = builder.preProcessor;
        this.postProcessor = builder.postProcessor;
        this.displayer = builder.displayer;
        this.handler = builder.handler;
        this.isSyncLoading = builder.isSyncLoading;
    }

    public /* synthetic */ DisplayImageOptions(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static DisplayImageOptions createSimple() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? new Builder().build() : (DisplayImageOptions) invokeV.objValue;
    }

    public BitmapFactory.Options getDecodingOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.decodingOptions : (BitmapFactory.Options) invokeV.objValue;
    }

    public int getDelayBeforeLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.delayBeforeLoading : invokeV.intValue;
    }

    public BitmapDisplayer getDisplayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.displayer : (BitmapDisplayer) invokeV.objValue;
    }

    public Object getExtraForDownloader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.extraForDownloader : invokeV.objValue;
    }

    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.handler : (Handler) invokeV.objValue;
    }

    public Drawable getImageForEmptyUri(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, resources)) == null) {
            int i2 = this.imageResForEmptyUri;
            return i2 != 0 ? resources.getDrawable(i2) : this.imageForEmptyUri;
        }
        return (Drawable) invokeL.objValue;
    }

    public Drawable getImageOnFail(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, resources)) == null) {
            int i2 = this.imageResOnFail;
            return i2 != 0 ? resources.getDrawable(i2) : this.imageOnFail;
        }
        return (Drawable) invokeL.objValue;
    }

    public Drawable getImageOnLoading(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, resources)) == null) {
            int i2 = this.imageResOnLoading;
            return i2 != 0 ? resources.getDrawable(i2) : this.imageOnLoading;
        }
        return (Drawable) invokeL.objValue;
    }

    public ImageScaleType getImageScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.imageScaleType : (ImageScaleType) invokeV.objValue;
    }

    public BitmapProcessor getPostProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.postProcessor : (BitmapProcessor) invokeV.objValue;
    }

    public BitmapProcessor getPreProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.preProcessor : (BitmapProcessor) invokeV.objValue;
    }

    public boolean isCacheInMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.cacheInMemory : invokeV.booleanValue;
    }

    public boolean isCacheOnDisk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.cacheOnDisk : invokeV.booleanValue;
    }

    public boolean isConsiderExifParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.considerExifParams : invokeV.booleanValue;
    }

    public boolean isResetViewBeforeLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.resetViewBeforeLoading : invokeV.booleanValue;
    }

    public boolean isSyncLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.isSyncLoading : invokeV.booleanValue;
    }

    public boolean shouldDelayBeforeLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.delayBeforeLoading > 0 : invokeV.booleanValue;
    }

    public boolean shouldPostProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.postProcessor != null : invokeV.booleanValue;
    }

    public boolean shouldPreProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.preProcessor != null : invokeV.booleanValue;
    }

    public boolean shouldShowImageForEmptyUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true : invokeV.booleanValue;
    }

    public boolean shouldShowImageOnFail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true : invokeV.booleanValue;
    }

    public boolean shouldShowImageOnLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true : invokeV.booleanValue;
    }
}
