package com.repackage;

import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigdayImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.FlutterLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.ImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileDrawableLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc2;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalPicDrawableLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalVideoThumbLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.MemeLoaderProc2;
import com.baidu.tbadk.core.util.resourceLoaderProc.NinePatchLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.PortraitBlurLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.PortraitLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleBlurLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleForeverLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleForeverMemoryLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleLoaderProc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            fg.h().o(10, new SimpleLoaderProc(true, true, false, 10));
            fg.h().o(11, new SimpleLoaderProc(false, true, false, 10));
            fg.h().o(42, new SimpleLoaderProc(true, false, false, 10));
            fg.h().o(13, new SimpleLoaderProc(true, true, false, 13));
            fg.h().o(14, new SimpleLoaderProc(false, true, false, 13));
            fg.h().o(17, new SimpleLoaderProc(true, true, false, 17));
            fg.h().o(18, new SimpleLoaderProc(false, true, false, 17));
            fg.h().o(39, new SimpleBlurLoaderProc(true, 39));
            fg.h().o(12, new PortraitLoaderProc(false, false, 12));
            fg.h().o(26, new PortraitLoaderProc(true, false, 26));
            fg.h().o(28, new PortraitLoaderProc(false, false, 26));
            fg.h().o(40, new PortraitBlurLoaderProc(false, false, 40));
            fg.h().o(19, new NinePatchLoaderProc(19));
            fg.h().o(24, new LocalPicDrawableLoaderProc(24));
            fg.h().o(25, new PortraitLoaderProc(false, true, 26));
            fg.h().o(27, new BigImageLoaderProc(27));
            fg.h().o(29, new SimpleForeverLoaderProc(true, 29));
            fg.h().o(32, new LocalFileDrawableLoaderProc(32));
            fg.h().o(23, new zu4());
            fg.h().o(33, new MemeLoaderProc2());
            fg.h().o(34, new EmotionShareLoaderProc());
            fg.h().o(35, new LocalFileImageLoaderProc(160, 160));
            fg.h().o(36, new LocalFileImageLoaderProc());
            fg.h().o(43, new LocalFileImageLoaderProc2());
            fg.h().o(37, new LocalVideoThumbLoaderProc());
            fg.h().o(38, new ImageLoaderProc());
            fg.h().o(41, new BigdayImageLoaderProc());
            fg.h().o(44, new FlutterLoaderProc(true, 44, false));
            fg.h().o(15, new SimpleLoaderProc(false, true, true, 15));
            fg.h().o(16, new SimpleLoaderProc(false, true, true, 16));
            fg.h().o(21, new SimpleLoaderProc(false, true, true, 21));
            fg.h().o(30, new SimpleLoaderProc(true, true, false, 30));
            fg.h().o(31, new SimpleLoaderProc(false, true, false, 30));
            fg.h().o(45, new SimpleForeverMemoryLoaderProc(true, true, true, 45));
            fg.h().o(46, new SimpleLoaderProc(true, true, false, 46));
            fg.h().o(47, new SimpleLoaderProc(false, true, false, 46));
        }
    }
}
