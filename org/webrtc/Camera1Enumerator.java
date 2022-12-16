package org.webrtc;

import android.hardware.Camera;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.widget.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraVideoCapturer;
/* loaded from: classes9.dex */
public class Camera1Enumerator implements CameraEnumerator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Camera1Enumerator";
    public static List<List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean captureToTexture;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Camera1Enumerator() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public Camera1Enumerator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.captureToTexture = z;
    }

    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(List<int[]> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int[] iArr : list) {
                arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(iArr[0], iArr[1]));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<Size> convertSizes(List<Camera.Size> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Camera.Size size : list) {
                arrayList.add(new Size(size.width, size.height));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public static Camera.CameraInfo getCameraInfo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            try {
                Camera.getCameraInfo(i, cameraInfo);
                return cameraInfo;
            } catch (Exception e) {
                Logging.e(TAG, "getCameraInfo failed on index " + i, e);
                return null;
            }
        }
        return (Camera.CameraInfo) invokeI.objValue;
    }

    public static synchronized List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int i) {
        InterceptResult invokeI;
        List<CameraEnumerationAndroid.CaptureFormat> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            synchronized (Camera1Enumerator.class) {
                if (cachedSupportedFormats == null) {
                    cachedSupportedFormats = new ArrayList();
                    for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                        cachedSupportedFormats.add(enumerateFormats(i2));
                    }
                }
                list = cachedSupportedFormats.get(i);
            }
            return list;
        }
        return (List) invokeI.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static List<CameraEnumerationAndroid.CaptureFormat> enumerateFormats(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            Logging.d(TAG, "Get supported formats for camera index " + i + ".");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Camera camera = null;
            try {
                try {
                    Logging.d(TAG, "Opening camera with index " + i);
                    camera = Camera.open(i);
                    Camera.Parameters parameters = camera.getParameters();
                    if (camera != null) {
                        camera.release();
                    }
                    ArrayList arrayList = new ArrayList();
                    try {
                        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                        int i3 = 0;
                        if (supportedPreviewFpsRange != null) {
                            int[] iArr = supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
                            i3 = iArr[0];
                            i2 = iArr[1];
                        } else {
                            i2 = 0;
                        }
                        for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
                            arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, i3, i2));
                        }
                    } catch (Exception e) {
                        Logging.e(TAG, "getSupportedFormats() failed on camera index " + i, e);
                    }
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    Logging.d(TAG, "Get supported formats for camera index " + i + " done. Time spent: " + (elapsedRealtime2 - elapsedRealtime) + " ms.");
                    return arrayList;
                } catch (RuntimeException e2) {
                    Logging.e(TAG, "Open camera failed on camera index " + i, e2);
                    ArrayList arrayList2 = new ArrayList();
                    if (camera != null) {
                        camera.release();
                    }
                    return arrayList2;
                }
            } catch (Throwable th) {
                if (camera != null) {
                    camera.release();
                }
                throw th;
            }
        }
        return (List) invokeI.objValue;
    }

    public static int getCameraIndex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            Logging.d(TAG, "getCameraIndex: " + str);
            for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                if (str.equals(getDeviceName(i))) {
                    return i;
                }
            }
            throw new IllegalArgumentException("No such camera: " + str);
        }
        return invokeL.intValue;
    }

    @Nullable
    public static String getDeviceName(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            Camera.CameraInfo cameraInfo = getCameraInfo(i);
            if (cameraInfo == null) {
                return null;
            }
            if (cameraInfo.facing == 1) {
                str = "front";
            } else {
                str = d.u;
            }
            return "Camera " + i + ", Facing " + str + ", Orientation " + cameraInfo.orientation;
        }
        return (String) invokeI.objValue;
    }

    @Override // org.webrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, cameraEventsHandler)) == null) {
            return new Camera1Capturer(str, cameraEventsHandler, this.captureToTexture);
        }
        return (CameraVideoCapturer) invokeLL.objValue;
    }

    @Override // org.webrtc.CameraEnumerator
    public String[] getDeviceNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                String deviceName = getDeviceName(i);
                if (deviceName != null) {
                    arrayList.add(deviceName);
                    Logging.d(TAG, "Index: " + i + ". " + deviceName);
                } else {
                    Logging.e(TAG, "Index: " + i + ". Failed to query camera name.");
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeV.objValue;
    }

    @Override // org.webrtc.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return getSupportedFormats(getCameraIndex(str));
        }
        return (List) invokeL.objValue;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isBackFacing(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(str));
            if (cameraInfo != null && cameraInfo.facing == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isFrontFacing(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(str));
            if (cameraInfo != null && cameraInfo.facing == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
