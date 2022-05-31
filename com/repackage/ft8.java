package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.ImageReader;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.math.MathUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.repackage.p69;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class ft8 extends et8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ft8 X;
    public static kt8 Y;
    public static kt8 Z;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageReader A;
    public kt8 B;
    public Range<Integer> C;
    public String D;
    public String E;
    public MediaRecorder F;
    public File G;
    public boolean H;
    public p69.a I;
    public Rect J;
    public float K;
    public int L;
    public boolean M;
    public MeteringRectangle[] N;
    public MeteringRectangle[] O;
    public MeteringRectangle[] P;
    public jt8 Q;
    public int R;
    public boolean S;
    public CameraConstrainedHighSpeedCaptureSession T;
    public CameraCaptureSession.StateCallback U;
    public CameraDevice.StateCallback V;
    public CameraCaptureSession.CaptureCallback W;
    public boolean r;
    public CameraManager s;
    public CameraDevice t;
    public CameraCaptureSession u;
    public Semaphore v;
    public CaptureRequest.Builder w;
    public HandlerThread x;
    public Handler y;
    public CameraCharacteristics z;

    /* loaded from: classes5.dex */
    public class a extends CameraCaptureSession.StateCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft8 a;

        /* renamed from: com.repackage.ft8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0427a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0427a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }
        }

        public a(ft8 ft8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft8Var;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cameraCaptureSession) == null) {
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        @RequiresApi(api = 23)
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraCaptureSession) == null) {
                this.a.u = cameraCaptureSession;
                this.a.T = (CameraConstrainedHighSpeedCaptureSession) cameraCaptureSession;
                this.a.N();
                h89.a().post(new RunnableC0427a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ft8 ft8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(ft8.Z != null);
                sb.append("|");
                sb.append(ft8.Y != null);
                x39.b("camera_hfps", sb.toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CameraDevice.StateCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft8 a;

        public c(ft8 ft8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft8Var;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cameraDevice) == null) {
                this.a.v.release();
                cameraDevice.close();
                this.a.t = null;
                if (this.a.I != null) {
                    this.a.I.a("StateCallback onDisconnected");
                }
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraDevice, i) == null) {
                this.a.v.release();
                cameraDevice.close();
                this.a.t = null;
                if (this.a.I != null) {
                    p69.a aVar = this.a.I;
                    aVar.a("StateCallback onError error = " + i);
                }
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cameraDevice) == null) {
                this.a.t = cameraDevice;
                boolean m0 = this.a.m0();
                this.a.v.release();
                if (m0 || this.a.I == null) {
                    return;
                }
                this.a.I.a("StateCallback nOpened startPreviewSession fail");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CameraCaptureSession.StateCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft8 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ d b;

            public a(d dVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a || this.b.a.I == null) {
                    return;
                }
                this.b.a.I.a("CameraCaptureSession.StateCallback onConfigured fail");
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.I == null) {
                    return;
                }
                this.a.a.I.a("CameraCaptureSession.StateCallback onConfigureFailed");
            }
        }

        public d(ft8 ft8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft8Var;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cameraCaptureSession) == null) {
                h89.a().post(new b(this));
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraCaptureSession) == null) {
                this.a.u = cameraCaptureSession;
                h89.a().post(new a(this, this.a.N()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CameraCaptureSession.CaptureCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft8 a;

        public e(ft8 ft8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft8Var;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, cameraCaptureSession, captureRequest, totalCaptureResult) == null) {
                super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                this.a.p0(totalCaptureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cameraCaptureSession, captureRequest, captureResult) == null) {
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                this.a.p0(captureResult);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755696185, "Lcom/repackage/ft8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755696185, "Lcom/repackage/ft8;");
        }
    }

    public ft8(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = true;
        this.v = new Semaphore(1);
        this.H = false;
        this.P = new MeteringRectangle[]{new MeteringRectangle(0, 0, 0, 0, 0)};
        this.R = -1;
        this.S = false;
        this.U = new a(this);
        this.V = new c(this);
        this.W = new e(this);
        this.a = tbPageContext;
        a0();
        l0();
    }

    public static ft8 U(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) {
            if (X == null) {
                synchronized (ft8.class) {
                    if (X == null) {
                        X = new ft8(tbPageContext);
                    } else if (tbPageContext != null) {
                        X.a = tbPageContext;
                    }
                }
            }
            return X;
        }
        return (ft8) invokeL.objValue;
    }

    public final Rect I(int i, int i2, float f, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            int i7 = (int) (i * f);
            int i8 = (int) (i2 * f);
            int a2 = lt8.a(Math.abs(i3 - i7) / 2, 0, Math.abs(i5 - i7));
            int a3 = lt8.a(Math.abs(i4 - i8) / 2, 0, Math.abs(i6 - i8));
            RectF rectF = new RectF(a2, a3, a2 + i7, a3 + i8);
            this.Q.c(rectF);
            Rect rect = new Rect();
            lt8.f(rectF, rect);
            return rect;
        }
        return (Rect) invokeCommon.objValue;
    }

    public final void J(Range<Integer>[] rangeArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rangeArr) == null) {
            Range<Integer> range = null;
            this.C = null;
            if (rangeArr != null) {
                int i = Integer.MAX_VALUE;
                int length = rangeArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Range<Integer> range2 = rangeArr[i2];
                    if (range2 != null) {
                        if (this.k >= range2.getLower().intValue() && this.k <= range2.getUpper().intValue()) {
                            range = range2;
                            break;
                        }
                        int abs = Math.abs(range2.getLower().intValue() - this.k);
                        int abs2 = Math.abs(range2.getUpper().intValue() - this.k);
                        if (abs <= abs2 && abs < i) {
                            range = range2;
                            i = abs;
                        } else if (abs2 <= abs && abs2 < i) {
                            range = range2;
                            i = abs2;
                        }
                    }
                    i2++;
                }
                this.C = range;
            }
            if (this.C == null) {
                this.C = new Range<>(30, 30);
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                try {
                    this.v.acquire();
                    M();
                    if (this.t != null) {
                        this.t.close();
                        this.t = null;
                    }
                    L();
                } catch (InterruptedException unused) {
                    throw new RuntimeException("Interrupted while trying to lock camera closing.");
                }
            } finally {
                this.v.release();
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaRecorder mediaRecorder = this.F;
            if (mediaRecorder != null) {
                mediaRecorder.release();
                this.F = null;
            }
            File file = this.G;
            if (file == null || !file.exists()) {
                return;
            }
            FileUtils.delete(this.G);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ImageReader imageReader = this.A;
            if (imageReader != null) {
                imageReader.close();
                this.A = null;
            }
            CameraCaptureSession cameraCaptureSession = this.u;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.u = null;
            }
            this.H = false;
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048581, this)) != null) {
            return invokeV.booleanValue;
        }
        boolean z = false;
        if (!c0()) {
            return false;
        }
        try {
            i0(this.w);
            if (this.S && Build.VERSION.SDK_INT >= 23) {
                this.T.setRepeatingBurst(this.T.createHighSpeedRequestList(this.w.build()), null, this.y);
            } else {
                this.u.setRepeatingRequest(this.w.build(), this.W, this.y);
            }
            this.H = true;
            try {
                gt8.b.k(2);
                return true;
            } catch (Exception e2) {
                e = e2;
                z = true;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final void O(MeteringRectangle meteringRectangle, MeteringRectangle meteringRectangle2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, meteringRectangle, meteringRectangle2, z) == null) {
            try {
                CameraCaptureSession cameraCaptureSession = this.u;
                CaptureRequest.Builder builder = this.w;
                if (z && !this.n) {
                    meteringRectangle2 = null;
                }
                cameraCaptureSession.setRepeatingRequest(W(builder, meteringRectangle, meteringRectangle2), this.W, this.y);
                this.w.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                this.u.capture(this.w.build(), this.W, this.y);
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final kt8 P(CameraCharacteristics cameraCharacteristics) {
        InterceptResult invokeL;
        Range<Integer>[] highSpeedVideoFpsRanges;
        Size[] highSpeedVideoSizesFor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cameraCharacteristics)) == null) {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Range<Integer> range : streamConfigurationMap.getHighSpeedVideoFpsRanges()) {
                if (range.getLower().equals(range.getUpper())) {
                    for (Size size : streamConfigurationMap.getHighSpeedVideoSizesFor(range)) {
                        kt8 kt8Var = new kt8(size.getWidth(), size.getHeight());
                        kt8Var.h(range.getUpper().intValue());
                        if (kt8Var.f(0)) {
                            arrayList.add(kt8Var);
                        } else if (kt8Var.f(1)) {
                            arrayList.add(kt8Var);
                        } else if (kt8Var.f(2)) {
                            arrayList.add(kt8Var);
                        }
                    }
                }
            }
            if (u79.e(arrayList)) {
                return null;
            }
            Collections.sort(arrayList);
            return (kt8) arrayList.get(arrayList.size() - 1);
        }
        return (kt8) invokeL.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && c0()) {
            try {
                this.w.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(X(1)));
                this.w.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                this.u.setRepeatingRequest(this.w.build(), this.W, this.y);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.b && et8.o) {
                return 0;
            }
            return (this.b || !et8.p) ? -1 : 1;
        }
        return invokeV.intValue;
    }

    public final String S(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (i == 0) {
                return this.D;
            }
            if (1 == i) {
                return this.E;
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public final kt8 T(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (i == 0) {
                return Z;
            }
            if (1 == i) {
                return Y;
            }
            return null;
        }
        return (kt8) invokeI.objValue;
    }

    public final Size V(Size[] sizeArr, int i, int i2) {
        InterceptResult invokeLII;
        Size size;
        Size size2;
        Size size3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048588, this, sizeArr, i, i2)) == null) {
            Size[] sizeArr2 = sizeArr;
            int i3 = i;
            if (sizeArr2 != null) {
                int i4 = i3 * i2;
                int i5 = Integer.MAX_VALUE;
                float f = i3 / i2;
                float f2 = 2.1474836E9f;
                float f3 = Float.MAX_VALUE;
                int length = sizeArr2.length;
                int i6 = 0;
                size = null;
                size2 = null;
                while (i6 < length) {
                    size3 = sizeArr2[i6];
                    if (size3 != null) {
                        if (size3.getWidth() == i3 && size3.getHeight() == i2) {
                            break;
                        }
                        int abs = Math.abs(i4 - (size3.getWidth() * size3.getHeight()));
                        if (abs < i5) {
                            size = size3;
                            i5 = abs;
                        }
                        float abs2 = Math.abs((size3.getWidth() / size3.getHeight()) - f);
                        if (abs2 - f3 <= 0.001d) {
                            float f4 = abs;
                            if (f4 < f2) {
                                f2 = f4;
                                f3 = abs2;
                                size2 = size3;
                            }
                        }
                    }
                    i6++;
                    sizeArr2 = sizeArr;
                    i3 = i;
                }
            } else {
                size = null;
                size2 = null;
            }
            size3 = null;
            if (size3 != null) {
                return size3;
            }
            if (size2 != null) {
                return size2;
            }
            if (size != null) {
                return size;
            }
            return null;
        }
        return (Size) invokeLII.objValue;
    }

    public final CaptureRequest W(CaptureRequest.Builder builder, MeteringRectangle meteringRectangle, MeteringRectangle meteringRectangle2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, builder, meteringRectangle, meteringRectangle2)) == null) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(X(1)));
            builder.set(CaptureRequest.CONTROL_MODE, 1);
            MeteringRectangle[] meteringRectangleArr = this.N;
            if (meteringRectangleArr == null) {
                this.N = new MeteringRectangle[]{meteringRectangle};
            } else {
                meteringRectangleArr[0] = meteringRectangle;
            }
            if (meteringRectangle2 != null) {
                MeteringRectangle[] meteringRectangleArr2 = this.O;
                if (meteringRectangleArr2 == null) {
                    this.O = new MeteringRectangle[]{meteringRectangle2};
                } else {
                    meteringRectangleArr2[0] = meteringRectangle2;
                }
            }
            if (f0(true)) {
                builder.set(CaptureRequest.CONTROL_AF_REGIONS, this.N);
            }
            if (meteringRectangle2 != null && f0(false)) {
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, this.O);
            }
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            return builder.build();
        }
        return (CaptureRequest) invokeLLL.objValue;
    }

    public final int X(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            int[] iArr = (int[]) this.z.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
            for (int i2 : iArr) {
                if (i2 == i) {
                    return i;
                }
            }
            return iArr[0];
        }
        return invokeI.intValue;
    }

    public final File Y() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            File CreateFileIfNotFoundInCache = FileHelper.CreateFileIfNotFoundInCache("miniHighSpeed");
            if (!CreateFileIfNotFoundInCache.exists()) {
                CreateFileIfNotFoundInCache.mkdirs();
            }
            return new File(CreateFileIfNotFoundInCache, "/HIGH_SPEED_VIDEO_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION);
        }
        return (File) invokeV.objValue;
    }

    public final Rect Z(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048592, this, f)) == null) {
            try {
                this.L = (int) MathUtils.clamp(f, 1.0f, this.K);
                int width = this.J.width() / 2;
                int height = this.J.height() / 2;
                int width2 = (int) ((this.J.width() * 0.5f) / this.L);
                int height2 = (int) ((this.J.height() * 0.5f) / this.L);
                return new Rect(width - width2, height - height2, width + width2, height + height2);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Rect) invokeF.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
        r8.r = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a0() {
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (pageActivity = this.a.getPageActivity()) == null || pageActivity.isFinishing()) {
            return;
        }
        CameraManager cameraManager = (CameraManager) pageActivity.getSystemService("camera");
        this.s = cameraManager;
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            int length = cameraIdList.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str = cameraIdList[i];
                CameraCharacteristics cameraCharacteristics = this.s.getCameraCharacteristics(str);
                if (d0(cameraCharacteristics) < 0) {
                    break;
                }
                int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
                if (intValue == 0) {
                    et8.o = true;
                    this.D = str;
                } else if (intValue == 1 && TextUtils.isEmpty(this.E)) {
                    et8.p = true;
                    this.E = str;
                }
                i++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.r = false;
        }
        boolean z = (!et8.o || DeviceInfoUtil.isHuaweiMateX() || DeviceInfoUtil.isOppN5207()) ? false : true;
        et8.o = z;
        if (!z && !et8.p) {
            this.r = false;
        }
        String S = S(1);
        if (!TextUtils.isEmpty(S)) {
            try {
                Y = P(this.s.getCameraCharacteristics(S));
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
            }
        }
        String S2 = S(0);
        if (!TextUtils.isEmpty(S2)) {
            try {
                Z = P(this.s.getCameraCharacteristics(S2));
            } catch (CameraAccessException e3) {
                e3.printStackTrace();
            }
        }
        if (Z == null && Y == null) {
            return;
        }
        h89.a().postDelayed(new b(this), 2000L);
    }

    @Override // com.repackage.p69.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 35;
        }
        return invokeV.intValue;
    }

    public final void b0(CameraCharacteristics cameraCharacteristics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cameraCharacteristics) == null) {
            this.z = cameraCharacteristics;
            Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
            if (bool != null) {
                bool.booleanValue();
            }
            Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            this.J = rect;
            if (rect == null) {
                this.K = 1.0f;
                this.M = false;
                return;
            }
            Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            float floatValue = (f == null || f.floatValue() < 1.0f) ? 1.0f : f.floatValue();
            this.K = floatValue;
            this.M = Float.compare(floatValue, 1.0f) > 0;
        }
    }

    @Override // com.repackage.p69.b
    public void c(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048596, this, i, i2, i3, i4) == null) && c0()) {
            O(new MeteringRectangle(I(i, i2, 1.0f, i3, i4, i89.e(), i89.d()), 1000), new MeteringRectangle(I(i, i2, 1.5f, i3, i4, i89.e(), i89.d()), 1000), false);
        }
    }

    public final boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.w == null || this.u == null || this.t == null) ? false : true : invokeV.booleanValue;
    }

    @Override // com.repackage.p69.b
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bArr) == null) {
        }
    }

    public final int d0(CameraCharacteristics cameraCharacteristics) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, cameraCharacteristics)) == null) {
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    @Override // com.repackage.p69.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? et8.q : (String) invokeV.objValue;
    }

    public final boolean e0() {
        InterceptResult invokeV;
        kt8 kt8Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.S && (kt8Var = this.B) != null && kt8Var.c() >= 60 : invokeV.booleanValue;
    }

    @Override // com.repackage.p69.b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public final boolean f0(boolean z) {
        InterceptResult invokeZ;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            if (z) {
                intValue = ((Integer) this.z.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
            } else {
                intValue = ((Integer) this.z.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue();
            }
            return intValue > 0;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.repackage.p69.b
    public void g(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.f = Math.max(i, i2);
            this.g = Math.min(i, i2);
            this.c = i > i2;
            this.k = i3;
            i(z);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if ((this.c && this.d < this.e) || (!this.c && this.d > this.e)) {
                this.h = this.e;
                this.i = this.d;
            } else {
                this.h = this.d;
                this.i = this.e;
            }
            j0();
        }
    }

    @Override // com.repackage.p69.b
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            int R = R();
            this.j = R;
            String S = S(R);
            if (S != null) {
                try {
                    if (this.v.tryAcquire(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                        CameraCharacteristics cameraCharacteristics = this.s.getCameraCharacteristics(S);
                        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                        if (streamConfigurationMap != null) {
                            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                            b0(cameraCharacteristics);
                            this.B = null;
                            if (this.S) {
                                kt8 T = T(this.j);
                                this.B = T;
                                if (T != null) {
                                    k0(T);
                                    this.C = new Range<>(Integer.valueOf(this.B.c()), Integer.valueOf(this.B.c()));
                                }
                            }
                            if (this.B == null) {
                                this.S = false;
                                J((Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
                                Size V = V(streamConfigurationMap.getOutputSizes(SurfaceTexture.class), this.f, this.g);
                                this.B = new kt8(V.getWidth(), V.getHeight(), this.C.getUpper().intValue());
                            }
                            this.d = this.B.e();
                            this.e = this.B.d();
                            g0();
                            this.s.openCamera(S, this.V, this.y);
                            return true;
                        }
                        throw new RuntimeException("Cannot get available preview/video sizes");
                    }
                    throw new RuntimeException("Time out waiting to lock camera opening.");
                } catch (CameraAccessException | InterruptedException | NullPointerException | Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.p69.b
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.b = (z && x()) || !(z || w());
        }
    }

    public final void i0(CaptureRequest.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, builder) == null) {
            builder.set(CaptureRequest.CONTROL_MODE, 1);
            builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.C);
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.Q = new jt8(this.z, new RectF(new Rect(0, 0, this.d, this.e)));
        }
    }

    @Override // com.repackage.p69.b
    public boolean k(SurfaceTexture surfaceTexture, p69.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, surfaceTexture, fVar)) == null) {
            if (this.r) {
                this.l = surfaceTexture;
                if (this.x == null) {
                    l0();
                }
                K();
                return h0();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void k0(kt8 kt8Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, kt8Var) == null) {
            if (DeviceInfoUtil.isXiaomi10()) {
                this.F = new MediaRecorder();
            }
            MediaRecorder mediaRecorder = this.F;
            if (mediaRecorder == null) {
                return;
            }
            mediaRecorder.reset();
            CamcorderProfile b2 = kt8Var.b();
            this.F.setAudioSource(1);
            this.F.setVideoSource(2);
            this.F.setProfile(b2);
            File Y2 = Y();
            this.G = Y2;
            if (Y2 != null) {
                this.F.setOutputFile(Y2.getAbsolutePath());
            }
            this.F.setOrientationHint(0);
            this.F.prepare();
        }
    }

    @Override // com.repackage.p69.b
    public void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i) == null) && c0() && this.M) {
            if (i >= 1 || i <= -1) {
                float f = this.K;
                if (f <= 1.0f) {
                    return;
                }
                float f2 = this.L + i;
                if (f2 <= f) {
                    f = f2 < 0.0f ? 0.0f : f2;
                }
                Rect Z2 = Z(f);
                if (Z2 != null) {
                    try {
                        this.w.set(CaptureRequest.SCALER_CROP_REGION, Z2);
                        this.u.setRepeatingRequest(this.w.build(), this.W, this.y);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            HandlerThread handlerThread = new HandlerThread("CameraBackground");
            this.x = handlerThread;
            handlerThread.start();
            this.y = new Handler(this.x.getLooper());
        }
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.t == null || this.l == null || this.B == null) {
                return false;
            }
            try {
                M();
                SurfaceTexture surfaceTexture = this.l;
                surfaceTexture.setDefaultBufferSize(this.B.e(), this.B.d());
                this.w = this.t.createCaptureRequest(1);
                Surface surface = new Surface(surfaceTexture);
                this.w.addTarget(surface);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(surface);
                if (this.A != null) {
                    Surface surface2 = this.A.getSurface();
                    this.w.addTarget(surface2);
                    arrayList.add(surface2);
                }
                if (this.F != null) {
                    arrayList.add(this.F.getSurface());
                    this.w.addTarget(this.F.getSurface());
                }
                if (this.S && Build.VERSION.SDK_INT >= 23) {
                    this.t.createConstrainedHighSpeedCaptureSession(arrayList, this.U, this.y);
                } else {
                    this.t.createCaptureSession(arrayList, new d(this), this.y);
                }
                return true;
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.p69.b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            HandlerThread handlerThread = this.x;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            try {
                if (this.x != null) {
                    this.x.join();
                }
                this.x = null;
                this.y = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.repackage.p69.b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public final void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            if (i == 2) {
                Q();
            } else if (i != 4) {
            } else {
                Q();
            }
        }
    }

    public final void p0(CaptureResult captureResult) {
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, captureResult) == null) || (num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE)) == null || this.R == num.intValue()) {
            return;
        }
        this.R = num.intValue();
        o0(num.intValue());
    }

    @Override // com.repackage.p69.b
    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || this.t == null) {
            return;
        }
        K();
        this.t = null;
        this.K = 0.0f;
        this.L = 0;
    }

    @Override // com.repackage.p69.b
    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            synchronized (this) {
                X = null;
                this.a = null;
                this.l = null;
                this.I = null;
                n0();
            }
        }
    }

    @Override // com.repackage.p69.b
    public void s(p69.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, aVar) == null) {
            this.I = aVar;
        }
    }

    @Override // com.repackage.p69.b
    public void t(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIII(1048624, this, i, i2, i3, i4) != null) || !c0()) {
        }
    }

    @Override // com.repackage.p69.b
    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
        }
    }

    @Override // com.repackage.et8
    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (e0()) {
                return Y != null;
            }
            return super.w();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.et8
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (e0()) {
                return Z != null;
            }
            return super.x();
        }
        return invokeV.booleanValue;
    }
}
