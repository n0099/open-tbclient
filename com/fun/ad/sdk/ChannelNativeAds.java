package com.fun.ad.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ChannelNativeAds {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GdtADStatusChangeListener a;
    public final Object baiduNative;
    public final Object baiduNative2;
    public final Object cjNative;
    public final Object csjNative;
    public final Object gdtNative;
    public final Object hwNative;
    public final Object jyNative;
    public final Object kdsNative;
    public final Object ksNative;
    public final Object maxNative;
    public final Object mhNative;
    public final Object mmNative;
    public final Object oppoNative;
    public final Object owNative;
    public final Object vivoNative;

    /* renamed from: com.fun.ad.sdk.ChannelNativeAds$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public interface GdtADStatusChangeListener {
        void onADStatusChanged();
    }

    public ChannelNativeAds(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.baiduNative = builder.a;
        this.baiduNative2 = builder.b;
        this.csjNative = builder.c;
        this.gdtNative = builder.d;
        this.jyNative = builder.e;
        this.ksNative = builder.f;
        this.kdsNative = builder.g;
        this.cjNative = builder.h;
        this.hwNative = builder.i;
        this.mmNative = builder.j;
        this.owNative = builder.k;
        this.mhNative = builder.l;
        this.maxNative = builder.m;
        this.oppoNative = builder.n;
        this.vivoNative = builder.o;
    }

    public static ChannelNativeAds createBdFeed(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) ? new Builder().setBdFeed(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createBdNaive(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) ? new Builder().setBdNative(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createCj(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) ? new Builder().setCj(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createCsj(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) ? new Builder().setCsj(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createGdt(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? new Builder().setGdt(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createHw(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) ? new Builder().setHw(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createJy(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? new Builder().setJy(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createKds(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) ? new Builder().setKds(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createKs(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) ? new Builder().setKs(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createMm(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) ? new Builder().setMm(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createOw(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, obj)) == null) ? new Builder().setOw(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public static ChannelNativeAds createVivo(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, obj)) == null) ? new Builder().setVivo(obj).build() : (ChannelNativeAds) invokeL.objValue;
    }

    public GdtADStatusChangeListener getGdtADStatusChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (GdtADStatusChangeListener) invokeV.objValue;
    }

    public void setGdtADStatusChangeListener(GdtADStatusChangeListener gdtADStatusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gdtADStatusChangeListener) == null) {
            this.a = gdtADStatusChangeListener;
        }
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public Object k;
        public Object l;
        public Object m;
        public Object n;
        public Object o;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public Builder setBdFeed(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                this.b = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBdNative(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                this.a = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCj(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                this.h = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCsj(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                this.c = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setGdt(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                this.d = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setHw(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                this.i = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setJy(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                this.e = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setKds(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                this.g = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setKs(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                this.f = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMax(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
                this.m = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMh(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
                this.l = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMm(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
                this.j = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOppo(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
                this.n = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOw(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
                this.k = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVivo(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
                this.o = obj;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public ChannelNativeAds build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new ChannelNativeAds(this);
            }
            return (ChannelNativeAds) invokeV.objValue;
        }
    }
}
