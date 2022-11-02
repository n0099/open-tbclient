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

            public FramerateRange(int i, int i2) {
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
                this.min = i;
                this.max = i2;
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (!(obj instanceof FramerateRange)) {
                        return false;
                    }
                    FramerateRange framerateRange = (FramerateRange) obj;
                    if (this.min != framerateRange.min || this.max != framerateRange.max) {
                        return false;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }

            public int hashCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return (this.min * 65537) + 1 + this.max;
                }
                return invokeV.intValue;
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

        public CaptureFormat(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.imageFormat = 17;
            this.width = i;
            this.height = i2;
            this.framerate = new FramerateRange(i3, i4);
        }

        public CaptureFormat(int i, int i2, FramerateRange framerateRange) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), framerateRange};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.imageFormat = 17;
            this.width = i;
            this.height = i2;
            this.framerate = framerateRange;
        }

        public static int frameSize(int i, int i2, int i3) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i, i2, i3)) == null) {
                if (i3 == 17) {
                    return ((i * i2) * ImageFormat.getBitsPerPixel(i3)) / 8;
                }
                throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
            }
            return invokeIII.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (!(obj instanceof CaptureFormat)) {
                    return false;
                }
                CaptureFormat captureFormat = (CaptureFormat) obj;
                if (this.width != captureFormat.width || this.height != captureFormat.height || !this.framerate.equals(captureFormat.framerate)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public int frameSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return frameSize(this.width, this.height, 17);
            }
            return invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return (((this.width * 65497) + this.height) * 251) + 1 + this.framerate.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.width + "x" + this.height + "@" + this.framerate;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ClosestComparator<T> implements Comparator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract int diff(T t);

        public ClosestComparator() {
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

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, t2)) == null) {
                return diff(t) - diff(t2);
            }
            return invokeLL.intValue;
        }
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
        COMMON_RESOLUTIONS = new ArrayList<>(Arrays.asList(new Size(160, 120), new Size(240, 160), new Size(MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 240), new Size(400, 240), new Size(480, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP), new Size(640, 360), new Size(640, 480), new Size(768, 480), new Size(854, 480), new Size(800, 600), new Size(960, 540), new Size(960, 640), new Size(1024, 576), new Size(1024, 600), new Size(1280, 720), new Size(1280, 1024), new Size(1920, 1080), new Size(1920, 1440), new Size(2560, 1440), new Size(3840, DisplayCompat.DISPLAY_SIZE_4K_HEIGHT)));
    }

    public CameraEnumerationAndroid() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static CaptureFormat.FramerateRange getClosestSupportedFramerateRange(List<CaptureFormat.FramerateRange> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, list, i)) == null) {
            return (CaptureFormat.FramerateRange) Collections.min(list, new ClosestComparator<CaptureFormat.FramerateRange>(i) { // from class: org.webrtc.CameraEnumerationAndroid.1
                public static /* synthetic */ Interceptable $ic = null;
                public static final int MAX_FPS_DIFF_THRESHOLD = 5000;
                public static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
                public static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
                public static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
                public static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
                public static final int MIN_FPS_THRESHOLD = 8000;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int val$requestedFps;

                private int progressivePenalty(int i2, int i3, int i4, int i5) {
                    InterceptResult invokeIIII;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeIIII = interceptable2.invokeIIII(65537, this, i2, i3, i4, i5)) == null) ? i2 < i3 ? i2 * i4 : ((i2 - i3) * i5) + (i4 * i3) : invokeIIII.intValue;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super();
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$requestedFps = i;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // org.webrtc.CameraEnumerationAndroid.ClosestComparator
                public int diff(CaptureFormat.FramerateRange framerateRange) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, framerateRange)) == null) {
                        return progressivePenalty(framerateRange.min, 8000, 1, 4) + progressivePenalty(Math.abs((this.val$requestedFps * 1000) - framerateRange.max), 5000, 1, 3);
                    }
                    return invokeL.intValue;
                }
            });
        }
        return (CaptureFormat.FramerateRange) invokeLI.objValue;
    }

    public static void reportCameraResolution(Histogram histogram, Size size) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, histogram, size) == null) {
            histogram.addSample(COMMON_RESOLUTIONS.indexOf(size) + 1);
        }
    }

    public static Size getClosestSupportedSize(List<Size> list, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, list, i, i2)) == null) {
            return (Size) Collections.min(list, new ClosestComparator<Size>(i, i2) { // from class: org.webrtc.CameraEnumerationAndroid.2
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
                        Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
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
                    this.val$requestedWidth = i;
                    this.val$requestedHeight = i2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // org.webrtc.CameraEnumerationAndroid.ClosestComparator
                public int diff(Size size) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, size)) == null) {
                        return Math.abs(this.val$requestedWidth - size.width) + Math.abs(this.val$requestedHeight - size.height);
                    }
                    return invokeL.intValue;
                }
            });
        }
        return (Size) invokeLII.objValue;
    }
}
