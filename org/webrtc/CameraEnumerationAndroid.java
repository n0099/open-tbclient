package org.webrtc;

import android.graphics.ImageFormat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.view.DisplayCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.wallet.qrcodescanner.beans.QRCodeScannerBeanFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes9.dex */
public class CameraEnumerationAndroid {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ArrayList<Size> COMMON_RESOLUTIONS;
    public static final String TAG = "CameraEnumerationAndroid";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class CaptureFormat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final FramerateRange framerate;
        public final int height;
        public final int imageFormat;
        public final int width;

        /* loaded from: classes9.dex */
        public static class FramerateRange {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int max;
            public int min;

            public FramerateRange(int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.min = i2;
                this.max = i3;
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (obj instanceof FramerateRange) {
                        FramerateRange framerateRange = (FramerateRange) obj;
                        return this.min == framerateRange.min && this.max == framerateRange.max;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public int hashCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.min * 65537) + 1 + this.max : invokeV.intValue;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return PreferencesUtil.LEFT_MOUNT + (this.min / 1000.0f) + ":" + (this.max / 1000.0f) + PreferencesUtil.RIGHT_MOUNT;
                }
                return (String) invokeV.objValue;
            }
        }

        public CaptureFormat(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.imageFormat = 17;
            this.width = i2;
            this.height = i3;
            this.framerate = new FramerateRange(i4, i5);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof CaptureFormat) {
                    CaptureFormat captureFormat = (CaptureFormat) obj;
                    return this.width == captureFormat.width && this.height == captureFormat.height && this.framerate.equals(captureFormat.framerate);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int frameSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? frameSize(this.width, this.height, 17) : invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (((this.width * 65497) + this.height) * 251) + 1 + this.framerate.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.width + "x" + this.height + "@" + this.framerate;
            }
            return (String) invokeV.objValue;
        }

        public static int frameSize(int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) {
                if (i4 == 17) {
                    return ((i2 * i3) * ImageFormat.getBitsPerPixel(i4)) / 8;
                }
                throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
            }
            return invokeIII.intValue;
        }

        public CaptureFormat(int i2, int i3, FramerateRange framerateRange) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), framerateRange};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.imageFormat = 17;
            this.width = i2;
            this.height = i3;
            this.framerate = framerateRange;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ClosestComparator<T> implements Comparator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ClosestComparator() {
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

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, t2)) == null) ? diff(t) - diff(t2) : invokeLL.intValue;
        }

        public abstract int diff(T t);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-474835293, "Lorg/webrtc/CameraEnumerationAndroid;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-474835293, "Lorg/webrtc/CameraEnumerationAndroid;");
                return;
            }
        }
        COMMON_RESOLUTIONS = new ArrayList<>(Arrays.asList(new Size(160, 120), new Size(240, 160), new Size(MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 240), new Size(400, 240), new Size(480, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP), new Size(640, 360), new Size(640, 480), new Size(768, 480), new Size(854, 480), new Size(800, 600), new Size(960, RecordConstants.DEFAULT_PREVIEW_WIDTH), new Size(960, 640), new Size(1024, 576), new Size(1024, 600), new Size(1280, 720), new Size(1280, 1024), new Size(1920, 1080), new Size(1920, 1440), new Size(QRCodeScannerBeanFactory.QRCODE_WHITE_LIST, 1440), new Size(3840, DisplayCompat.DISPLAY_SIZE_4K_HEIGHT)));
    }

    public CameraEnumerationAndroid() {
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

    public static CaptureFormat.FramerateRange getClosestSupportedFramerateRange(List<CaptureFormat.FramerateRange> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, list, i2)) == null) ? (CaptureFormat.FramerateRange) Collections.min(list, new ClosestComparator<CaptureFormat.FramerateRange>(i2) { // from class: org.webrtc.CameraEnumerationAndroid.1
            public static /* synthetic */ Interceptable $ic = null;
            public static final int MAX_FPS_DIFF_THRESHOLD = 5000;
            public static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
            public static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
            public static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
            public static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
            public static final int MIN_FPS_THRESHOLD = 8000;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int val$requestedFps;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super();
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$requestedFps = i2;
            }

            private int progressivePenalty(int i3, int i4, int i5, int i6) {
                InterceptResult invokeIIII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeIIII = interceptable2.invokeIIII(65537, this, i3, i4, i5, i6)) == null) ? i3 < i4 ? i3 * i5 : ((i3 - i4) * i6) + (i5 * i4) : invokeIIII.intValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // org.webrtc.CameraEnumerationAndroid.ClosestComparator
            public int diff(CaptureFormat.FramerateRange framerateRange) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, framerateRange)) == null) ? progressivePenalty(framerateRange.min, 8000, 1, 4) + progressivePenalty(Math.abs((this.val$requestedFps * 1000) - framerateRange.max), 5000, 1, 3) : invokeL.intValue;
            }
        }) : (CaptureFormat.FramerateRange) invokeLI.objValue;
    }

    public static Size getClosestSupportedSize(List<Size> list, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, list, i2, i3)) == null) ? (Size) Collections.min(list, new ClosestComparator<Size>(i2, i3) { // from class: org.webrtc.CameraEnumerationAndroid.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int val$requestedHeight;
            public final /* synthetic */ int val$requestedWidth;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super();
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$requestedWidth = i2;
                this.val$requestedHeight = i3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // org.webrtc.CameraEnumerationAndroid.ClosestComparator
            public int diff(Size size) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, size)) == null) ? Math.abs(this.val$requestedWidth - size.width) + Math.abs(this.val$requestedHeight - size.height) : invokeL.intValue;
            }
        }) : (Size) invokeLII.objValue;
    }

    public static void reportCameraResolution(Histogram histogram, Size size) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, histogram, size) == null) {
            histogram.addSample(COMMON_RESOLUTIONS.indexOf(size) + 1);
        }
    }
}
