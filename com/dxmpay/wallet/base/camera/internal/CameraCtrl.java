package com.dxmpay.wallet.base.camera.internal;

import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
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
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes11.dex */
public class CameraCtrl implements Camera.ErrorCallback, NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_RAW = 0;
    public static final int TO_STATE_DESTROIED = 8;
    public static final int TO_STATE_INIT = 1;
    public static final int TO_STATE_PAUSED = 4;
    public static final int TO_STATE_STARTED = 2;
    public static final String Tag;
    public transient /* synthetic */ FieldHolder $fh;
    public int _cameraCnt;
    public int _cameraId;
    public b.e.b.a.a.a.b _cameraProxy;
    public int _height;
    public final Method[] _newVersionMethods;
    public Camera.PreviewCallback _previewCb;
    public SurfaceHolder _previewView;
    public int _rotation;
    public int _state;
    public boolean _supportAutoFocus;
    public int _width;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class MethodIndex {
        public static final /* synthetic */ MethodIndex[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MethodIndex getNumberOfCameras;
        public static final MethodIndex open;
        public static final MethodIndex setDisplayOrientation;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(728177288, "Lcom/dxmpay/wallet/base/camera/internal/CameraCtrl$MethodIndex;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(728177288, "Lcom/dxmpay/wallet/base/camera/internal/CameraCtrl$MethodIndex;");
                    return;
                }
            }
            open = new MethodIndex("open", 0);
            getNumberOfCameras = new MethodIndex("getNumberOfCameras", 1);
            MethodIndex methodIndex = new MethodIndex("setDisplayOrientation", 2);
            setDisplayOrientation = methodIndex;
            $VALUES = new MethodIndex[]{open, getNumberOfCameras, methodIndex};
        }

        public MethodIndex(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MethodIndex valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MethodIndex) Enum.valueOf(MethodIndex.class, str) : (MethodIndex) invokeL.objValue;
        }

        public static MethodIndex[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MethodIndex[]) $VALUES.clone() : (MethodIndex[]) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class a implements Comparator<Camera.Size> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(CameraCtrl cameraCtrl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraCtrl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, size, size2)) == null) {
                int i2 = size.width;
                int i3 = size2.width;
                if (i2 > i3) {
                    return 1;
                }
                if (i2 < i3) {
                    return -1;
                }
                if (i2 == i3) {
                    int i4 = size.height;
                    int i5 = size2.height;
                    if (i4 > i5) {
                        return 1;
                    }
                    return i4 < i5 ? -1 : 0;
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static CameraCtrl f63225a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-131140073, "Lcom/dxmpay/wallet/base/camera/internal/CameraCtrl$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-131140073, "Lcom/dxmpay/wallet/base/camera/internal/CameraCtrl$b;");
                    return;
                }
            }
            f63225a = new CameraCtrl(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1841475179, "Lcom/dxmpay/wallet/base/camera/internal/CameraCtrl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1841475179, "Lcom/dxmpay/wallet/base/camera/internal/CameraCtrl;");
                return;
            }
        }
        Tag = CameraCtrl.class.getSimpleName();
    }

    public /* synthetic */ CameraCtrl(a aVar) {
        this();
    }

    private void doDestroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this._cameraProxy == null) {
            return;
        }
        this._cameraProxy.e(null);
        this._cameraProxy.j();
        this._cameraProxy.m();
        reset();
    }

    private void doStart(Camera.PreviewCallback previewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, previewCallback) == null) {
            if (this._previewCb == null) {
                if (this._cameraProxy.k() == null) {
                    return;
                }
                int bitsPerPixel = ((this._width * this._height) * ImageFormat.getBitsPerPixel(this._cameraProxy.k().getPreviewFormat())) / 8;
                byte[][] bArr = new byte[4];
                for (int i2 = 0; i2 < 4; i2++) {
                    bArr[i2] = new byte[bitsPerPixel];
                    this._cameraProxy.h(bArr[i2]);
                }
            }
            this._previewCb = previewCallback;
            this._cameraProxy.e(previewCallback);
            try {
                if (this._previewView != null) {
                    this._cameraProxy.g(this._previewView);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                this._cameraProxy.l();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static CameraCtrl getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? b.f63225a : (CameraCtrl) invokeV.objValue;
    }

    private Camera.Size getSimilarRatioSize(int i2, int i3, List<Camera.Size> list, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, Integer.valueOf(i4)})) == null) {
            int i5 = i2;
            int i6 = i3;
            if (i5 >= i6) {
                i6 = i5;
                i5 = i6;
            }
            float f2 = i5 / i6;
            double d2 = Double.MAX_VALUE;
            Camera.Size size = null;
            sortSize(list);
            ListIterator<Camera.Size> listIterator = list.listIterator();
            String str = "sorted getSimilarRatioSize(" + i6 + i5 + ") ; expectRatio = " + f2;
            while (true) {
                if (!listIterator.hasNext()) {
                    break;
                }
                Camera.Size next = listIterator.next();
                String.format("supported picture size:(%d,%d)", Integer.valueOf(next.width), Integer.valueOf(next.height));
                if (next.width == i6 && next.height == i5) {
                    size = next;
                    break;
                }
                int i7 = next.width;
                double d3 = next.height / i7;
                String.format("supported picture size:(%d,%d);ratio:%f", Integer.valueOf(i7), Integer.valueOf(next.height), Double.valueOf(d3));
                double abs = Math.abs(f2 - d3);
                if (d2 >= abs && 400 < next.height) {
                    size = next;
                    d2 = abs;
                }
            }
            if (size == null) {
                Camera.Size size2 = list.get(list.size() - 1);
                String valueOf = String.valueOf(i4);
                StringBuilder sb = new StringBuilder(size2.width);
                sb.append(",");
                sb.append(size2.height);
                StatisticManager.onEventWithValue("sdk_self_define_camera_get_size", valueOf, sb.toString());
                return size2;
            }
            return size;
        }
        return (Camera.Size) invokeCommon.objValue;
    }

    public static boolean isSupprtFlashLight(PackageManager packageManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, packageManager)) == null) {
            FeatureInfo[] systemAvailableFeatures = packageManager.getSystemAvailableFeatures();
            if (systemAvailableFeatures == null) {
                return false;
            }
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                if ("android.hardware.camera.flash".equals(featureInfo.name)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049 A[Catch: all -> 0x015d, TRY_ENTER, TryCatch #4 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x0014, B:13:0x001b, B:15:0x003f, B:19:0x0049, B:21:0x0055, B:26:0x0061, B:28:0x006d, B:31:0x009a, B:33:0x00cb, B:34:0x00ee, B:36:0x00f3, B:38:0x00f7, B:39:0x00fa, B:40:0x00ff, B:42:0x010b, B:46:0x0125, B:45:0x011e, B:50:0x012a, B:54:0x0136, B:14:0x003a, B:61:0x0149, B:63:0x014d, B:65:0x0151, B:67:0x0155, B:58:0x0140), top: B:87:0x0005, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d A[Catch: all -> 0x015d, TRY_LEAVE, TryCatch #4 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x0014, B:13:0x001b, B:15:0x003f, B:19:0x0049, B:21:0x0055, B:26:0x0061, B:28:0x006d, B:31:0x009a, B:33:0x00cb, B:34:0x00ee, B:36:0x00f3, B:38:0x00f7, B:39:0x00fa, B:40:0x00ff, B:42:0x010b, B:46:0x0125, B:45:0x011e, B:50:0x012a, B:54:0x0136, B:14:0x003a, B:61:0x0149, B:63:0x014d, B:65:0x0151, B:67:0x0155, B:58:0x0140), top: B:87:0x0005, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a A[Catch: all -> 0x015d, TRY_ENTER, TryCatch #4 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x0014, B:13:0x001b, B:15:0x003f, B:19:0x0049, B:21:0x0055, B:26:0x0061, B:28:0x006d, B:31:0x009a, B:33:0x00cb, B:34:0x00ee, B:36:0x00f3, B:38:0x00f7, B:39:0x00fa, B:40:0x00ff, B:42:0x010b, B:46:0x0125, B:45:0x011e, B:50:0x012a, B:54:0x0136, B:14:0x003a, B:61:0x0149, B:63:0x014d, B:65:0x0151, B:67:0x0155, B:58:0x0140), top: B:87:0x0005, inners: #0, #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean openCamera(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Camera.Parameters k;
        boolean z;
        Camera.Size similarRatioSize;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65544, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) != null) {
            return invokeCommon.booleanValue;
        }
        synchronized (this) {
            boolean z2 = true;
            if (this._cameraProxy == null) {
                try {
                    this._cameraProxy = b.e.b.a.a.a.b.a();
                    if (-1 != i2 && isSupportMultiCamera()) {
                        this._cameraProxy.f31602a = (Camera) this._newVersionMethods[MethodIndex.open.ordinal()].invoke(Camera.class, Integer.valueOf(i2));
                        k = this._cameraProxy.k();
                        if (k != null) {
                            return false;
                        }
                        String focusMode = k.getFocusMode();
                        if (!focusMode.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO) && !focusMode.equals("macro")) {
                            z = false;
                            this._supportAutoFocus = z;
                            similarRatioSize = getSimilarRatioSize(i3, i4, k.getSupportedPreviewSizes(), 0);
                            if (similarRatioSize != null) {
                                this._cameraProxy.m();
                                this._cameraProxy = null;
                                LogUtil.e(Tag, "fail to get a proximate preivew size(" + i3 + "," + i4 + ").", null);
                                return false;
                            }
                            String str = "set preview size to widht = " + similarRatioSize.width + " , height = " + similarRatioSize.height;
                            int i8 = similarRatioSize.width;
                            this._width = i8;
                            int i9 = similarRatioSize.height;
                            this._height = i9;
                            k.setPreviewSize(i8, i9);
                            Camera.Size similarRatioSize2 = getSimilarRatioSize(i3, i4, k.getSupportedPictureSizes(), 1);
                            if (similarRatioSize2 != null) {
                                k.setPictureSize(similarRatioSize2.width, similarRatioSize2.height);
                                String str2 = "set picture size to width = " + similarRatioSize2.width + " , height = " + similarRatioSize2.height;
                            }
                            try {
                                k.setPreviewFormat(i6);
                                if (9 > Build.VERSION.SDK_INT) {
                                    k.setPreviewFrameRate(i7);
                                }
                                try {
                                    this._cameraProxy.d(k);
                                    Method method = this._newVersionMethods[MethodIndex.setDisplayOrientation.ordinal()];
                                    if (method != null) {
                                        try {
                                            method.invoke(this._cameraProxy.f31602a, Integer.valueOf(i5));
                                            this._rotation = i5;
                                        } catch (Exception e2) {
                                            LogUtil.e(Tag, "", e2);
                                        }
                                    }
                                    this._cameraId = i2;
                                    return true;
                                } catch (Exception e3) {
                                    LogUtil.e(Tag, k.toString(), e3);
                                    return false;
                                }
                            } catch (IllegalArgumentException e4) {
                                LogUtil.e(Tag, "failed to openCamera:", e4);
                                return false;
                            }
                        }
                        z = true;
                        this._supportAutoFocus = z;
                        similarRatioSize = getSimilarRatioSize(i3, i4, k.getSupportedPreviewSizes(), 0);
                        if (similarRatioSize != null) {
                        }
                    }
                    this._cameraProxy.i();
                    k = this._cameraProxy.k();
                    if (k != null) {
                    }
                } catch (Exception e5) {
                    LogUtil.e(Tag, "The camera is in use", e5);
                    return false;
                }
            } else {
                return (i2 == this._cameraId && i3 == this._width && i5 == this._rotation && i4 == this._height) ? false : false;
            }
        }
    }

    private boolean setState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) {
            if (2 == i2) {
                if ((this._state & 7) == 0) {
                    return false;
                }
            } else if (4 == i2) {
                if ((this._state & 6) == 0) {
                    return false;
                }
            } else if (1 == i2) {
                int i3 = this._state;
                if (i3 != 0 && 8 != i3) {
                    return false;
                }
            } else if (8 != i2) {
                return false;
            }
            this._state = i2;
            String str = "setState(" + this._state + ") succeed.";
            return true;
        }
        return invokeI.booleanValue;
    }

    private void sortSize(List<Camera.Size> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, list) == null) {
            Collections.sort(list, new a(this));
        }
    }

    public b.e.b.a.a.a.b camera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this._cameraProxy : (b.e.b.a.a.a.b) invokeV.objValue;
    }

    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                String str = "destroy:stat=" + this._state;
                if (setState(8)) {
                    doDestroy();
                }
            }
        }
    }

    public int getCameraCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this._cameraCnt;
            if (-1 == i2) {
                if (this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()] == null) {
                    return 1;
                }
                try {
                    int intValue = ((Integer) this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()].invoke(Camera.class, new Object[0])).intValue();
                    this._cameraCnt = intValue;
                    i2 = intValue;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
                if (-1 == i2) {
                    return 0;
                }
                return i2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int getCurrentZoom() {
        InterceptResult invokeV;
        b.e.b.a.a.a.b bVar;
        Camera.Parameters k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!isSupportZoom() || (bVar = this._cameraProxy) == null || (k = bVar.k()) == null) {
                return 0;
            }
            return k.getZoom();
        }
        return invokeV.intValue;
    }

    public int getMaxZoom() {
        InterceptResult invokeV;
        b.e.b.a.a.a.b bVar;
        Camera.Parameters k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!isSupportZoom() || (bVar = this._cameraProxy) == null || (k = bVar.k()) == null) {
                return 0;
            }
            return k.getMaxZoom();
        }
        return invokeV.intValue;
    }

    public synchronized int getPreviewHeight() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                i2 = this._height;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int getPreviewWidht() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i2 = this._width;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized boolean init(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            synchronized (this) {
                String str = "init:state=" + this._state;
                if (setState(1)) {
                    this._previewCb = null;
                    return openCamera(i2, i3, i4, i5, i6, i7);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public boolean isFlashOn() {
        InterceptResult invokeV;
        Camera.Parameters k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if ((this._state & 6) == 0 || (k = this._cameraProxy.k()) == null) {
                return false;
            }
            return "torch".equals(k.getFlashMode());
        }
        return invokeV.booleanValue;
    }

    public boolean isSupportAutoFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this._supportAutoFocus : invokeV.booleanValue;
    }

    public boolean isSupportMultiCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? 9 <= Build.VERSION.SDK_INT && this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()] != null && getCameraCount() > 1 : invokeV.booleanValue;
    }

    public boolean isSupportZoom() {
        InterceptResult invokeV;
        Camera.Parameters k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            b.e.b.a.a.a.b bVar = this._cameraProxy;
            if (bVar == null || (k = bVar.k()) == null) {
                return false;
            }
            return k.isZoomSupported();
        }
        return invokeV.booleanValue;
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i2, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, camera) == null) {
            String str = Tag;
            LogUtil.e(str, "camera error: " + i2, null);
        }
    }

    public synchronized void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (setState(4)) {
                    this._cameraProxy.j();
                }
            }
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this._cameraProxy = null;
            this._previewCb = null;
            this._previewView = null;
            this._rotation = -1;
            this._height = -1;
            this._width = -1;
            this._cameraId = -1;
            this._state = 0;
        }
    }

    public boolean setFlashOn(boolean z) {
        InterceptResult invokeZ;
        Camera.Parameters k;
        String flashMode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if ((this._state & 6) == 0 || (k = this._cameraProxy.k()) == null || (flashMode = k.getFlashMode()) == null) {
                return false;
            }
            String str = z ? "torch" : DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            if (str.equals(flashMode)) {
                return true;
            }
            k.setFlashMode(str);
            try {
                this._cameraProxy.d(k);
                return true;
            } catch (Exception e2) {
                LogUtil.e(Tag, "setFlashOn()", e2);
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public void setPreviewDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, surfaceHolder) == null) && this._previewView == null && surfaceHolder != null) {
            try {
                this._cameraProxy.g(surfaceHolder);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setZoom(int i2) {
        b.e.b.a.a.a.b bVar;
        Camera.Parameters k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (bVar = this._cameraProxy) == null || (k = bVar.k()) == null || !isSupportZoom() || k.getZoom() == i2) {
            return;
        }
        k.setZoom(i2);
        this._cameraProxy.d(k);
    }

    public synchronized void start(Camera.PreviewCallback previewCallback, SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, previewCallback, surfaceHolder) == null) {
            synchronized (this) {
                String str = "start:stat=" + this._state;
                if (previewCallback == null) {
                    return;
                }
                if (previewCallback == this._previewCb && surfaceHolder == this._previewView && 2 == this._state) {
                    return;
                }
                if (setState(2)) {
                    this._previewView = surfaceHolder;
                    doStart(previewCallback);
                }
            }
        }
    }

    public boolean trigerFlash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if ((this._state & 6) == 0) {
                return false;
            }
            this._cameraProxy.j();
            Camera.Parameters k = this._cameraProxy.k();
            if (k == null) {
                return false;
            }
            if ("torch".equals(k.getFlashMode())) {
                k.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                k.setFlashMode("torch");
            }
            try {
                this._cameraProxy.d(k);
                this._cameraProxy.l();
                return true;
            } catch (Exception unused) {
                this._cameraProxy.l();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public CameraCtrl() {
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
        this._cameraProxy = null;
        this._cameraCnt = -1;
        this._supportAutoFocus = false;
        this._previewView = null;
        this._state = 0;
        reset();
        this._newVersionMethods = new Method[MethodIndex.values().length];
        int i4 = 0;
        while (true) {
            Method[] methodArr = this._newVersionMethods;
            if (i4 < methodArr.length) {
                methodArr[i4] = null;
                i4++;
            } else {
                try {
                    Class[] clsArr = {Integer.TYPE};
                    methodArr[MethodIndex.open.ordinal()] = Camera.class.getMethod("open", clsArr);
                    this._newVersionMethods[MethodIndex.setDisplayOrientation.ordinal()] = Camera.class.getMethod("setDisplayOrientation", clsArr);
                    this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()] = Camera.class.getMethod("getNumberOfCameras", null);
                    return;
                } catch (NoSuchMethodException e2) {
                    LogUtil.e(Tag, "determine method: ", e2);
                    return;
                }
            }
        }
    }
}
