package com.spap.wrapper;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class camera implements Camera.PreviewCallback, SurfaceTexture.OnFrameAvailableListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int back_id = -1;
    public static int cam_scanned = 0;
    public static int front_id = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCameraId;
    public float mCompensationStep;
    public int mIsTexValid;
    public int mLastCompensationIndex;
    public int mMaxCompensationIndex;
    public int mMinCompensationIndex;
    public Camera mMyCamera;
    public Camera.Size mMyCameraSize;
    public int mNeedUp;
    public SurfaceTexture mSurfaceTexture;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2100505711, "Lcom/spap/wrapper/camera;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2100505711, "Lcom/spap/wrapper/camera;");
        }
    }

    public camera() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCompensationStep = 0.0f;
        this.mLastCompensationIndex = 0;
    }

    public static final int get_back_camera_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            scan_cameras();
            return back_id;
        }
        return invokeV.intValue;
    }

    public static final int get_front_camera_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            scan_cameras();
            return front_id;
        }
        return invokeV.intValue;
    }

    public static final void scan_cameras() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && cam_scanned == 0) {
            cam_scanned = 1;
            int numberOfCameras = Camera.getNumberOfCameras();
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (front_id < 0 && cameraInfo.facing == 1) {
                    front_id = i2;
                }
                if (back_id < 0 && cameraInfo.facing == 0) {
                    back_id = i2;
                }
            }
        }
    }

    public static native void sendresult(int i2, byte[] bArr, int i3, int i4);

    public int callUpdateTexImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mNeedUp > 0) {
                try {
                    this.mSurfaceTexture.updateTexImage();
                } catch (Exception unused) {
                }
                this.mNeedUp = 0;
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture) == null) {
            this.mNeedUp = 1;
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, camera) == null) {
            if (this.mIsTexValid == 0 && this.mNeedUp > 0) {
                try {
                    this.mSurfaceTexture.updateTexImage();
                } catch (Exception unused) {
                }
                this.mNeedUp = 0;
            }
            int i2 = this.mCameraId;
            Camera.Size size = this.mMyCameraSize;
            sendresult(i2, bArr, size.width, size.height);
        }
    }

    public int set_compensation(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 == 0.0d) {
                return 0;
            }
            int exposureCompensation = ((int) (d2 / this.mCompensationStep)) + this.mMyCamera.getParameters().getExposureCompensation();
            int i2 = this.mMaxCompensationIndex;
            if (exposureCompensation > i2) {
                exposureCompensation = i2;
            }
            int i3 = this.mMinCompensationIndex;
            if (exposureCompensation < i3) {
                exposureCompensation = i3;
            }
            Camera.Parameters parameters = this.mMyCamera.getParameters();
            parameters.setExposureCompensation(exposureCompensation);
            this.mMyCamera.setParameters(parameters);
            return exposureCompensation;
        }
        return invokeCommon.intValue;
    }

    public int turn_off() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Camera camera = this.mMyCamera;
            if (camera == null) {
                return 0;
            }
            camera.stopPreview();
            this.mMyCamera.release();
            this.mMyCamera = null;
            return 1;
        }
        return invokeV.intValue;
    }

    public int turn_on(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            if (this.mMyCamera == null) {
                this.mMyCamera = Camera.open(i2);
                this.mCameraId = i2;
            }
            if (this.mMyCamera == null) {
                return 0;
            }
            try {
                if (this.mSurfaceTexture == null) {
                    this.mSurfaceTexture = new SurfaceTexture(i6);
                }
                this.mMyCamera.setPreviewCallback(this);
                this.mSurfaceTexture.setOnFrameAvailableListener(this);
                this.mMyCamera.setPreviewTexture(this.mSurfaceTexture);
                Camera.Parameters parameters = this.mMyCamera.getParameters();
                parameters.setPreviewFormat(17);
                if (i3 != 0 && i4 != 0) {
                    parameters.setPreviewSize(i3, i4);
                }
                if (i5 != 0) {
                    parameters.setPreviewFrameRate(i5);
                }
                this.mMyCamera.setParameters(parameters);
                this.mMyCamera.startPreview();
                this.mMyCameraSize = this.mMyCamera.getParameters().getPreviewSize();
                this.mIsTexValid = i7;
                this.mCompensationStep = this.mMyCamera.getParameters().getExposureCompensationStep();
                this.mMinCompensationIndex = this.mMyCamera.getParameters().getMinExposureCompensation();
                this.mMaxCompensationIndex = this.mMyCamera.getParameters().getMaxExposureCompensation();
                return 1;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeCommon.intValue;
    }
}
