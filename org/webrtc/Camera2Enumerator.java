package org.webrtc;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.SystemClock;
import android.util.AndroidException;
import android.util.Range;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraVideoCapturer;
/* loaded from: classes2.dex */
public class Camera2Enumerator implements CameraEnumerator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double NANO_SECONDS_PER_SECOND = 1.0E9d;
    public static final String TAG = "Camera2Enumerator";
    public static final Map<String, List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
    public static boolean disableExtraCamera;
    public transient /* synthetic */ FieldHolder $fh;
    public final CameraManager cameraManager;
    public final Context context;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1377805387, "Lorg/webrtc/Camera2Enumerator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1377805387, "Lorg/webrtc/Camera2Enumerator;");
                return;
            }
        }
        cachedSupportedFormats = new HashMap();
        disableExtraCamera = false;
    }

    public Camera2Enumerator(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.context = context;
        this.cameraManager = (CameraManager) context.getSystemService("camera");
    }

    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(Range<Integer>[] rangeArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, rangeArr, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Range<Integer> range : rangeArr) {
                arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(range.getLower().intValue() * i2, range.getUpper().intValue() * i2));
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }

    public static List<Size> convertSizes(android.util.Size[] sizeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sizeArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (android.util.Size size : sizeArr) {
                arrayList.add(new Size(size.getWidth(), size.getHeight()));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void disableExtraCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            disableExtraCamera = z;
        }
    }

    private CameraCharacteristics getCameraCharacteristics(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            try {
                return this.cameraManager.getCameraCharacteristics(str);
            } catch (AndroidException e2) {
                Logging.e(TAG, "Camera access exception: " + e2);
                return null;
            }
        }
        return (CameraCharacteristics) invokeL.objValue;
    }

    public static int getFpsUnitFactor(Range<Integer>[] rangeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, rangeArr)) == null) ? (rangeArr.length != 0 && rangeArr[0].getUpper().intValue() >= 1000) ? 1 : 1000 : invokeL.intValue;
    }

    public static List<Size> getSupportedSizes(CameraCharacteristics cameraCharacteristics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cameraCharacteristics)) == null) {
            int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
            List<Size> convertSizes = convertSizes(((StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class));
            if (Build.VERSION.SDK_INT >= 22 || intValue != 2) {
                return convertSizes;
            }
            Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            ArrayList arrayList = new ArrayList();
            for (Size size : convertSizes) {
                if (rect.width() * size.height == rect.height() * size.width) {
                    arrayList.add(size);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean isSupported(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return false;
            }
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            try {
                for (String str : cameraManager.getCameraIdList()) {
                    if (((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                        return false;
                    }
                }
                return true;
            } catch (AndroidException e2) {
                Logging.e(TAG, "Camera access exception: " + e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // org.webrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, cameraEventsHandler)) == null) ? new Camera2Capturer(this.context, str, cameraEventsHandler) : (CameraVideoCapturer) invokeLL.objValue;
    }

    @Override // org.webrtc.CameraEnumerator
    public String[] getDeviceNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                String[] cameraIdList = this.cameraManager.getCameraIdList();
                return (cameraIdList.length <= 2 || !disableExtraCamera) ? cameraIdList : new String[]{cameraIdList[0], cameraIdList[1]};
            } catch (AndroidException e2) {
                Logging.e(TAG, "Camera access exception: " + e2);
                return new String[0];
            }
        }
        return (String[]) invokeV.objValue;
    }

    @Override // org.webrtc.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? getSupportedFormats(this.context, str) : (List) invokeL.objValue;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isBackFacing(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(str);
            return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1;
        }
        return invokeL.booleanValue;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isFrontFacing(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(str);
            return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        }
        return invokeL.booleanValue;
    }

    public static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? getSupportedFormats((CameraManager) context.getSystemService("camera"), str) : (List) invokeLL.objValue;
    }

    public static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(CameraManager cameraManager, String str) {
        InterceptResult invokeLL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, cameraManager, str)) == null) {
            synchronized (cachedSupportedFormats) {
                if (cachedSupportedFormats.containsKey(str)) {
                    return cachedSupportedFormats.get(str);
                }
                Logging.d(TAG, "Get supported formats for camera index " + str + ".");
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                    List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates = convertFramerates(rangeArr, getFpsUnitFactor(rangeArr));
                    List<Size> supportedSizes = getSupportedSizes(cameraCharacteristics);
                    int i2 = 0;
                    for (CameraEnumerationAndroid.CaptureFormat.FramerateRange framerateRange : convertFramerates) {
                        i2 = Math.max(i2, framerateRange.max);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Size size : supportedSizes) {
                        try {
                            j2 = streamConfigurationMap.getOutputMinFrameDuration(SurfaceTexture.class, new android.util.Size(size.width, size.height));
                        } catch (Exception unused) {
                            j2 = 0;
                        }
                        int round = j2 == 0 ? i2 : ((int) Math.round(1.0E9d / j2)) * 1000;
                        arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, 0, round));
                        Logging.d(TAG, "Format: " + size.width + "x" + size.height + TNCManager.TNC_PROBE_HEADER_SECEPTOR + round);
                    }
                    cachedSupportedFormats.put(str, arrayList);
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    Logging.d(TAG, "Get supported formats for camera index " + str + " done. Time spent: " + (elapsedRealtime2 - elapsedRealtime) + " ms.");
                    return arrayList;
                } catch (Exception e2) {
                    Logging.e(TAG, "getCameraCharacteristics(): " + e2);
                    return new ArrayList();
                }
            }
        }
        return (List) invokeLL.objValue;
    }
}
