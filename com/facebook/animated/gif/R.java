package com.facebook.animated.gif;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static final class attr {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int actualImageResource = 0x7f040024;
        public static final int actualImageScaleType = 0x7f040025;
        public static final int actualImageUri = 0x7f040026;
        public static final int backgroundImage = 0x7f04005c;
        public static final int fadeDuration = 0x7f04015b;
        public static final int failureImage = 0x7f04015f;
        public static final int failureImageScaleType = 0x7f040160;
        public static final int overlayImage = 0x7f0402a8;
        public static final int placeholderImage = 0x7f0402c6;
        public static final int placeholderImageScaleType = 0x7f0402c7;
        public static final int pressedStateOverlayImage = 0x7f0402cf;
        public static final int progressBarAutoRotateInterval = 0x7f0402d1;
        public static final int progressBarImage = 0x7f0402d2;
        public static final int progressBarImageScaleType = 0x7f0402d3;
        public static final int retryImage = 0x7f040332;
        public static final int retryImageScaleType = 0x7f040333;
        public static final int roundAsCircle = 0x7f04034b;
        public static final int roundBottomEnd = 0x7f04034c;
        public static final int roundBottomLeft = 0x7f04034d;
        public static final int roundBottomRight = 0x7f04034e;
        public static final int roundBottomStart = 0x7f04034f;
        public static final int roundTopEnd = 0x7f040357;
        public static final int roundTopLeft = 0x7f040358;
        public static final int roundTopRight = 0x7f040359;
        public static final int roundTopStart = 0x7f04035a;
        public static final int roundWithOverlayColor = 0x7f04035c;
        public static final int roundedCornerRadius = 0x7f04035e;
        public static final int roundingBorderColor = 0x7f04035f;
        public static final int roundingBorderPadding = 0x7f040360;
        public static final int roundingBorderWidth = 0x7f040361;
        public static final int svgImage = 0x7f0405bf;
        public static final int viewAspectRatio = 0x7f040489;
        public transient /* synthetic */ FieldHolder $fh;

        public attr() {
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
    }

    /* loaded from: classes12.dex */
    public static final class id {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int center = 0x7f090668;
        public static final int centerCrop = 0x7f09066c;
        public static final int centerInside = 0x7f09066d;
        public static final int fitBottomStart = 0x7f090b5c;
        public static final int fitCenter = 0x7f090b5d;
        public static final int fitEnd = 0x7f090b5e;
        public static final int fitStart = 0x7f090b5f;
        public static final int fitXY = 0x7f090b61;
        public static final int focusCrop = 0x7f090b94;
        public static final int none = 0x7f0917bd;
        public transient /* synthetic */ FieldHolder $fh;

        public id() {
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
    }

    /* loaded from: classes12.dex */
    public static final class styleable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int[] GenericDraweeHierarchy;
        public static final int GenericDraweeHierarchy_actualImageScaleType = 0x00000000;
        public static final int GenericDraweeHierarchy_backgroundImage = 0x00000001;
        public static final int GenericDraweeHierarchy_fadeDuration = 0x00000002;
        public static final int GenericDraweeHierarchy_failureImage = 0x00000003;
        public static final int GenericDraweeHierarchy_failureImageScaleType = 0x00000004;
        public static final int GenericDraweeHierarchy_overlayImage = 0x00000005;
        public static final int GenericDraweeHierarchy_placeholderImage = 0x00000006;
        public static final int GenericDraweeHierarchy_placeholderImageScaleType = 0x00000007;
        public static final int GenericDraweeHierarchy_pressedStateOverlayImage = 0x00000008;
        public static final int GenericDraweeHierarchy_progressBarAutoRotateInterval = 0x00000009;
        public static final int GenericDraweeHierarchy_progressBarImage = 0x0000000a;
        public static final int GenericDraweeHierarchy_progressBarImageScaleType = 0x0000000b;
        public static final int GenericDraweeHierarchy_retryImage = 0x0000000c;
        public static final int GenericDraweeHierarchy_retryImageScaleType = 0x0000000d;
        public static final int GenericDraweeHierarchy_roundAsCircle = 0x0000000e;
        public static final int GenericDraweeHierarchy_roundBottomEnd = 0x0000000f;
        public static final int GenericDraweeHierarchy_roundBottomLeft = 0x00000010;
        public static final int GenericDraweeHierarchy_roundBottomRight = 0x00000011;
        public static final int GenericDraweeHierarchy_roundBottomStart = 0x00000012;
        public static final int GenericDraweeHierarchy_roundTopEnd = 0x00000013;
        public static final int GenericDraweeHierarchy_roundTopLeft = 0x00000014;
        public static final int GenericDraweeHierarchy_roundTopRight = 0x00000015;
        public static final int GenericDraweeHierarchy_roundTopStart = 0x00000016;
        public static final int GenericDraweeHierarchy_roundWithOverlayColor = 0x00000017;
        public static final int GenericDraweeHierarchy_roundedCornerRadius = 0x00000018;
        public static final int GenericDraweeHierarchy_roundingBorderColor = 0x00000019;
        public static final int GenericDraweeHierarchy_roundingBorderPadding = 0x0000001a;
        public static final int GenericDraweeHierarchy_roundingBorderWidth = 0x0000001b;
        public static final int GenericDraweeHierarchy_viewAspectRatio = 0x0000001c;
        public static final int[] SimpleDraweeView;
        public static final int SimpleDraweeView_actualImageResource = 0x00000000;
        public static final int SimpleDraweeView_actualImageScaleType = 0x00000001;
        public static final int SimpleDraweeView_actualImageUri = 0x00000002;
        public static final int SimpleDraweeView_backgroundImage = 0x00000003;
        public static final int SimpleDraweeView_fadeDuration = 0x00000004;
        public static final int SimpleDraweeView_failureImage = 0x00000005;
        public static final int SimpleDraweeView_failureImageScaleType = 0x00000006;
        public static final int SimpleDraweeView_overlayImage = 0x00000007;
        public static final int SimpleDraweeView_placeholderImage = 0x00000008;
        public static final int SimpleDraweeView_placeholderImageScaleType = 0x00000009;
        public static final int SimpleDraweeView_pressedStateOverlayImage = 0x0000000a;
        public static final int SimpleDraweeView_progressBarAutoRotateInterval = 0x0000000b;
        public static final int SimpleDraweeView_progressBarImage = 0x0000000c;
        public static final int SimpleDraweeView_progressBarImageScaleType = 0x0000000d;
        public static final int SimpleDraweeView_retryImage = 0x0000000e;
        public static final int SimpleDraweeView_retryImageScaleType = 0x0000000f;
        public static final int SimpleDraweeView_roundAsCircle = 0x00000010;
        public static final int SimpleDraweeView_roundBottomEnd = 0x00000011;
        public static final int SimpleDraweeView_roundBottomLeft = 0x00000012;
        public static final int SimpleDraweeView_roundBottomRight = 0x00000013;
        public static final int SimpleDraweeView_roundBottomStart = 0x00000014;
        public static final int SimpleDraweeView_roundTopEnd = 0x00000015;
        public static final int SimpleDraweeView_roundTopLeft = 0x00000016;
        public static final int SimpleDraweeView_roundTopRight = 0x00000017;
        public static final int SimpleDraweeView_roundTopStart = 0x00000018;
        public static final int SimpleDraweeView_roundWithOverlayColor = 0x00000019;
        public static final int SimpleDraweeView_roundedCornerRadius = 0x0000001a;
        public static final int SimpleDraweeView_roundingBorderColor = 0x0000001b;
        public static final int SimpleDraweeView_roundingBorderPadding = 0x0000001c;
        public static final int SimpleDraweeView_roundingBorderWidth = 0x0000001d;
        public static final int SimpleDraweeView_svgImage = 0x0000001f;
        public static final int SimpleDraweeView_viewAspectRatio = 0x0000001e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1817068170, "Lcom/facebook/animated/gif/R$styleable;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1817068170, "Lcom/facebook/animated/gif/R$styleable;");
                    return;
                }
            }
            GenericDraweeHierarchy = new int[]{com.baidu.tieba.R.attr.actualImageScaleType, com.baidu.tieba.R.attr.backgroundImage, com.baidu.tieba.R.attr.fadeDuration, com.baidu.tieba.R.attr.failureImage, com.baidu.tieba.R.attr.failureImageScaleType, com.baidu.tieba.R.attr.overlayImage, com.baidu.tieba.R.attr.placeholderImage, com.baidu.tieba.R.attr.placeholderImageScaleType, com.baidu.tieba.R.attr.pressedStateOverlayImage, com.baidu.tieba.R.attr.progressBarAutoRotateInterval, com.baidu.tieba.R.attr.progressBarImage, com.baidu.tieba.R.attr.progressBarImageScaleType, com.baidu.tieba.R.attr.retryImage, com.baidu.tieba.R.attr.retryImageScaleType, com.baidu.tieba.R.attr.roundAsCircle, com.baidu.tieba.R.attr.roundBottomEnd, com.baidu.tieba.R.attr.roundBottomLeft, com.baidu.tieba.R.attr.roundBottomRight, com.baidu.tieba.R.attr.roundBottomStart, com.baidu.tieba.R.attr.roundTopEnd, com.baidu.tieba.R.attr.roundTopLeft, com.baidu.tieba.R.attr.roundTopRight, com.baidu.tieba.R.attr.roundTopStart, com.baidu.tieba.R.attr.roundWithOverlayColor, com.baidu.tieba.R.attr.roundedCornerRadius, com.baidu.tieba.R.attr.roundingBorderColor, com.baidu.tieba.R.attr.roundingBorderPadding, com.baidu.tieba.R.attr.roundingBorderWidth, com.baidu.tieba.R.attr.viewAspectRatio};
            SimpleDraweeView = new int[]{com.baidu.tieba.R.attr.actualImageResource, com.baidu.tieba.R.attr.actualImageScaleType, com.baidu.tieba.R.attr.actualImageUri, com.baidu.tieba.R.attr.backgroundImage, com.baidu.tieba.R.attr.fadeDuration, com.baidu.tieba.R.attr.failureImage, com.baidu.tieba.R.attr.failureImageScaleType, com.baidu.tieba.R.attr.overlayImage, com.baidu.tieba.R.attr.placeholderImage, com.baidu.tieba.R.attr.placeholderImageScaleType, com.baidu.tieba.R.attr.pressedStateOverlayImage, com.baidu.tieba.R.attr.progressBarAutoRotateInterval, com.baidu.tieba.R.attr.progressBarImage, com.baidu.tieba.R.attr.progressBarImageScaleType, com.baidu.tieba.R.attr.retryImage, com.baidu.tieba.R.attr.retryImageScaleType, com.baidu.tieba.R.attr.roundAsCircle, com.baidu.tieba.R.attr.roundBottomEnd, com.baidu.tieba.R.attr.roundBottomLeft, com.baidu.tieba.R.attr.roundBottomRight, com.baidu.tieba.R.attr.roundBottomStart, com.baidu.tieba.R.attr.roundTopEnd, com.baidu.tieba.R.attr.roundTopLeft, com.baidu.tieba.R.attr.roundTopRight, com.baidu.tieba.R.attr.roundTopStart, com.baidu.tieba.R.attr.roundWithOverlayColor, com.baidu.tieba.R.attr.roundedCornerRadius, com.baidu.tieba.R.attr.roundingBorderColor, com.baidu.tieba.R.attr.roundingBorderPadding, com.baidu.tieba.R.attr.roundingBorderWidth, com.baidu.tieba.R.attr.viewAspectRatio, com.baidu.tieba.R.attr.svgImage};
        }

        public styleable() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public R() {
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
}
