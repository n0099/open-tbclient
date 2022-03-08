package com.facebook.imageformat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableList;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class DefaultImageFormats {
    public static /* synthetic */ Interceptable $ic;
    public static final ImageFormat BMP;
    public static final ImageFormat GIF;
    public static final ImageFormat HEIF;
    public static final ImageFormat ICO;
    public static final ImageFormat JPEG;
    public static final ImageFormat PNG;
    public static final ImageFormat WEBP_ANIMATED;
    public static final ImageFormat WEBP_EXTENDED;
    public static final ImageFormat WEBP_EXTENDED_WITH_ALPHA;
    public static final ImageFormat WEBP_LOSSLESS;
    public static final ImageFormat WEBP_SIMPLE;
    public static ImmutableList<ImageFormat> sAllDefaultFormats;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(152993125, "Lcom/facebook/imageformat/DefaultImageFormats;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(152993125, "Lcom/facebook/imageformat/DefaultImageFormats;");
                return;
            }
        }
        JPEG = new ImageFormat("JPEG", "jpeg");
        PNG = new ImageFormat("PNG", "png");
        GIF = new ImageFormat("GIF", "gif");
        BMP = new ImageFormat("BMP", "bmp");
        ICO = new ImageFormat("ICO", "ico");
        WEBP_SIMPLE = new ImageFormat("WEBP_SIMPLE", OvalActionButton.WEBP);
        WEBP_LOSSLESS = new ImageFormat("WEBP_LOSSLESS", OvalActionButton.WEBP);
        WEBP_EXTENDED = new ImageFormat("WEBP_EXTENDED", OvalActionButton.WEBP);
        WEBP_EXTENDED_WITH_ALPHA = new ImageFormat("WEBP_EXTENDED_WITH_ALPHA", OvalActionButton.WEBP);
        WEBP_ANIMATED = new ImageFormat("WEBP_ANIMATED", OvalActionButton.WEBP);
        HEIF = new ImageFormat("HEIF", "heif");
    }

    public DefaultImageFormats() {
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

    public static List<ImageFormat> getDefaultFormats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sAllDefaultFormats == null) {
                ArrayList arrayList = new ArrayList(9);
                arrayList.add(JPEG);
                arrayList.add(PNG);
                arrayList.add(GIF);
                arrayList.add(BMP);
                arrayList.add(ICO);
                arrayList.add(WEBP_SIMPLE);
                arrayList.add(WEBP_LOSSLESS);
                arrayList.add(WEBP_EXTENDED);
                arrayList.add(WEBP_EXTENDED_WITH_ALPHA);
                arrayList.add(WEBP_ANIMATED);
                arrayList.add(HEIF);
                sAllDefaultFormats = ImmutableList.copyOf((List) arrayList);
            }
            return sAllDefaultFormats;
        }
        return (List) invokeV.objValue;
    }

    public static boolean isStaticWebpFormat(ImageFormat imageFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, imageFormat)) == null) ? imageFormat == WEBP_SIMPLE || imageFormat == WEBP_LOSSLESS || imageFormat == WEBP_EXTENDED || imageFormat == WEBP_EXTENDED_WITH_ALPHA : invokeL.booleanValue;
    }

    public static boolean isWebpFormat(ImageFormat imageFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, imageFormat)) == null) ? isStaticWebpFormat(imageFormat) || imageFormat == WEBP_ANIMATED : invokeL.booleanValue;
    }
}
