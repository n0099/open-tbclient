package com.dxmpay.wallet.base.camera;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.imagemanager.ImageProcessor;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.permission.PermissionManager;
import com.dxmpay.apollon.statusbar.ImmersiveStatusBarManager;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.camera.internal.CameraCtrl;
import com.dxmpay.wallet.base.camera.util.ThreadPool;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public abstract class CameraBaseActivity extends BaseActivity implements SurfaceHolder.Callback, c.f.b.a.a.a.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_BANK_CARD_DETECTION = 2;
    public static final int FROM_OCR_BANK_CARD_DETECTION = 3;
    public static final int FROM_OCR_IDCARD_DETECTION = 1;
    public static final int MSG_PROBE_OPEN_STATE = 1;
    public static int REQUEST_PERMISSION_CAMERA = 0;
    public static final int RequestCode = 132;
    public static final int ResultCodeExit = 1243;
    public static final int ResultCodeStay = 1244;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_RAW = 0;
    public static final String Tag;
    public transient /* synthetic */ FieldHolder $fh;
    public Camera.AutoFocusCallback autoFocusCallback;
    public int cameraId;
    public c.f.b.a.a.a.a mAutoFocusCb;
    public final Handler mAutoFocusHandler;
    public Rect mBmpDataRect;
    public boolean mCanRequestCameraPermission;
    public ViewGroup mContentView;
    public final AtomicInteger mDetectorState;
    public i[] mDetectors;
    public final AtomicBoolean mDone;
    public j mFlashController;
    public float mFocusDataYXRatial;
    public Rect mFocusViewRect;
    public IImageProcess mImageProcessor;
    public int[] mImageSize;
    public boolean mInCaptureProgresses;
    public AtomicBoolean mInCaptureTimeOut;
    public AtomicBoolean mIsCameraMalfunctioned;
    public Handler mMiscEvtHandler;
    public OnCameraChangeListener mOnCameraChange;
    public c.f.b.a.a.a.d mPreviewCb;
    public SurfaceView mPreviewView;
    public int mRotation;
    public float mScaleCoefficient;
    public int[] mScreeSize;
    public boolean mShowDialog;
    public ArrayList<String> mStatisticList;
    public SurfaceHolder mSurfaceHolder;
    public ThreadPool mThreadPool;
    public CountDownTimer mTimer;
    public View mTitleBarMargin;
    public RelativeLayout mTitle_bar;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraBaseActivity f53760e;

        public a(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53760e = cameraBaseActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53760e.mDetectorState.set(this.f53760e.mImageProcessor.initProcessor() ? 1 : 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraBaseActivity f53761e;

        public b(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53761e = cameraBaseActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                WalletGlobalUtils.showStr = "";
                CameraCtrl cameraCtrl = CameraCtrl.getInstance();
                if (cameraCtrl != null) {
                    cameraCtrl.reset();
                }
                this.f53761e.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraBaseActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CameraBaseActivity cameraBaseActivity, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraBaseActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int id = ResUtils.id(this.a.getActivity(), "dxm_wallet_auto_focus");
                if (id == message.what) {
                    if (this.a.mPreviewCb != null) {
                        this.a.mAutoFocusCb.b(this, id);
                        c.f.b.a.a.a.b h2 = this.a.mPreviewCb.h();
                        if (h2 != null) {
                            try {
                                h2.b(this.a.mAutoFocusCb);
                                return;
                            } catch (Exception unused) {
                                String unused2 = CameraBaseActivity.Tag;
                                return;
                            }
                        }
                        return;
                    }
                    this.a.mAutoFocusCb.b(null, id);
                    return;
                }
                super.handleMessage(message);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BaiduWalletUtils.IRequestPermissionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraBaseActivity a;

        public d(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraBaseActivity;
        }

        @Override // com.dxmpay.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
        public void isAllAgree(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    this.a.mCanRequestCameraPermission = false;
                    if (!PermissionManager.checkCallingOrSelfPermission(this.a.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, CameraBaseActivity.REQUEST_PERMISSION_CAMERA)) {
                        this.a.handleNoCamaraPermission();
                        return;
                    }
                    StatisticManager.onEventWithValues(StatServiceEvent.CONTINUE_APPLY_CAMERA_PERMISSION, this.a.mStatisticList);
                    this.a.isAllowCameraPermisssion(false);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    this.a.onRequestPermissionsResult(1, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
                }
            }
        }

        @Override // com.dxmpay.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
        public void isShow(String str, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bool) == null) {
            }
        }

        @Override // com.dxmpay.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
        public void requestResult(String str, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bool) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraBaseActivity a;

        public e(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraBaseActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && 1 == message.what && this.a.mIsCameraMalfunctioned.get()) {
                this.a.showBaseDialog(3, ResUtils.getString(this.a.getActivity(), "dxm_wallet_camera_error"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Camera.PictureCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CameraBaseActivity f53762b;

        public f(CameraBaseActivity cameraBaseActivity, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53762b = cameraBaseActivity;
            this.a = j2;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            CameraBaseActivity cameraBaseActivity;
            IImageProcess iImageProcess;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) {
                String unused = CameraBaseActivity.Tag;
                String str = "takepic callback Timeout = " + this.f53762b.mInCaptureTimeOut;
                StatisticManager.onEventWithValue(StatServiceEvent.SDK_SELF_DEFINE_TAKEPIC_CALLBACK_INTERVAL, String.valueOf(System.currentTimeMillis() - this.a));
                if (!this.f53762b.mInCaptureTimeOut.get() && (iImageProcess = (cameraBaseActivity = this.f53762b).mImageProcessor) != null) {
                    int[] iArr = cameraBaseActivity.mImageSize;
                    Object[] processImageJpegData = iImageProcess.processImageJpegData(bArr, iArr[0], iArr[1]);
                    if (processImageJpegData != null && this.f53762b.mDone.compareAndSet(false, true)) {
                        this.f53762b.pauseCamera();
                        this.f53762b.onProcessImageOk(processImageJpegData);
                    }
                } else {
                    this.f53762b.pauseCamera();
                    this.f53762b.restartScan();
                }
                this.f53762b.mInCaptureProgresses = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Camera.AutoFocusCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CameraBaseActivity f53763b;

        public g(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53763b = cameraBaseActivity;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, camera) == null) || this.f53763b.mPreviewCb == null || this.f53763b.mPreviewCb.h() == null) {
                return;
            }
            CameraBaseActivity cameraBaseActivity = this.f53763b;
            if (cameraBaseActivity.mInCaptureProgresses) {
                return;
            }
            c.f.b.a.a.a.b h2 = cameraBaseActivity.mPreviewCb.h();
            if (z) {
                this.a = 0;
                this.f53763b.takePictureWithoutAutoFocus(h2);
                return;
            }
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 <= 1) {
                h2.c(this.f53763b.autoFocusCallback, "auto");
            } else {
                this.f53763b.takePictureWithoutAutoFocus(h2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraBaseActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(CameraBaseActivity cameraBaseActivity, long j2, long j3) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraBaseActivity;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mTimer == null) {
                return;
            }
            this.a.mTimer.cancel();
            this.a.mInCaptureTimeOut.set(true);
            this.a.mInCaptureProgresses = false;
            String unused = CameraBaseActivity.Tag;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f53764e;

        /* renamed from: f  reason: collision with root package name */
        public byte[] f53765f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f53766g;

        /* renamed from: h  reason: collision with root package name */
        public int f53767h;

        /* renamed from: i  reason: collision with root package name */
        public int f53768i;

        /* renamed from: j  reason: collision with root package name */
        public Rect f53769j;
        public final AtomicBoolean k;
        public final /* synthetic */ CameraBaseActivity l;

        public i(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = cameraBaseActivity;
            this.f53764e = i.class.getSimpleName();
            this.f53766g = null;
            this.k = new AtomicBoolean(false);
        }

        public void a(byte[] bArr, int i2, int i3, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect}) == null) {
                this.f53765f = bArr;
                this.f53767h = i2;
                this.f53768i = i3;
                this.f53769j = rect;
                int recycledBufSize = this.l.mImageProcessor.getRecycledBufSize(rect.width(), rect.height());
                byte[] bArr2 = this.f53766g;
                if (bArr2 == null || bArr2.length != recycledBufSize) {
                    this.f53766g = new byte[recycledBufSize];
                }
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k.get() : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.l.mDone.get()) {
                    this.k.set(false);
                } else if (!this.k.compareAndSet(false, true)) {
                    LogUtil.e(this.f53764e, "internal error", null);
                } else {
                    Object[] processImage = this.l.mImageProcessor.processImage(this.f53765f, this.f53767h, this.f53768i, this.f53769j, this.f53766g);
                    if (processImage != null && this.l.mDone.compareAndSet(false, true)) {
                        this.l.pauseCamera();
                        this.l.onProcessImageOk(processImage);
                    }
                    this.k.set(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f53770e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CameraBaseActivity f53771f;

        public j(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53771f = cameraBaseActivity;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f53770e = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f53771f.updateFlashLightUi(this.f53770e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<CameraBaseActivity> f53772e;

        public k(CameraBaseActivity cameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53772e = new WeakReference<>(cameraBaseActivity);
        }

        public final boolean a() {
            InterceptResult invokeV;
            i[] iVarArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                CameraBaseActivity cameraBaseActivity = this.f53772e.get();
                if (cameraBaseActivity == null) {
                    return false;
                }
                if (cameraBaseActivity.mDetectors != null && cameraBaseActivity.mDetectors.length != 0) {
                    for (i iVar : cameraBaseActivity.mDetectors) {
                        if (iVar != null && iVar.b()) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            CameraBaseActivity cameraBaseActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cameraBaseActivity = this.f53772e.get()) == null) {
                return;
            }
            while (!a()) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            cameraBaseActivity.mImageProcessor.destroyProcessor();
            cameraBaseActivity.mDetectors = null;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1257036154, "Lcom/dxmpay/wallet/base/camera/CameraBaseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1257036154, "Lcom/dxmpay/wallet/base/camera/CameraBaseActivity;");
                return;
            }
        }
        Tag = CameraBaseActivity.class.getSimpleName();
        REQUEST_PERMISSION_CAMERA = 1;
    }

    public CameraBaseActivity() {
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
        this.mSurfaceHolder = null;
        this.mDone = new AtomicBoolean(false);
        this.mScaleCoefficient = 1.0f;
        this.mFocusDataYXRatial = 1.0f;
        this.mBmpDataRect = new Rect();
        this.mFocusViewRect = new Rect();
        this.mScreeSize = new int[2];
        this.mImageSize = new int[2];
        this.mDetectors = null;
        this.mDetectorState = new AtomicInteger(0);
        this.mMiscEvtHandler = null;
        this.mIsCameraMalfunctioned = new AtomicBoolean(false);
        this.mCanRequestCameraPermission = true;
        this.mInCaptureProgresses = false;
        this.mInCaptureTimeOut = new AtomicBoolean(false);
        this.mShowDialog = false;
        this.mStatisticList = new ArrayList<>();
        this.mAutoFocusHandler = new c(this, Looper.myLooper());
        this.mFlashController = new j(this);
        this.cameraId = 0;
        this.autoFocusCallback = new g(this);
    }

    private synchronized i getAvailableDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            synchronized (this) {
                if (this.mDetectors == null) {
                    i[] iVarArr = new i[c.f.b.a.a.b.a.a()];
                    this.mDetectors = iVarArr;
                    iVarArr[0] = new i(this);
                    return this.mDetectors[0];
                }
                for (int i2 = 0; i2 < this.mDetectors.length; i2++) {
                    if (this.mDetectors[i2] == null) {
                        this.mDetectors[i2] = new i(this);
                        return this.mDetectors[i2];
                    } else if (!this.mDetectors[i2].b()) {
                        return this.mDetectors[i2];
                    }
                }
                return null;
            }
        }
        return (i) invokeV.objValue;
    }

    public static String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? SecurePay.getInstance().getToken() : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNoCamaraPermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            StatisticManager.onEventWithValues(StatServiceEvent.REFUSE_CAMERA_PERMISSION, this.mStatisticList);
            onPermissionDenied();
            showBaseDialog(3, ResUtils.getString(getActivity(), "dxm_wallet_camera_error"));
        }
    }

    private boolean isFlashOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            if (this.mPreviewCb != null) {
                return CameraCtrl.getInstance().isFlashOn();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void setFlashLightOn(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65556, this, z) == null) || this.mPreviewCb == null) {
            return;
        }
        CameraCtrl cameraCtrl = CameraCtrl.getInstance();
        if (cameraCtrl.isFlashOn() != z) {
            cameraCtrl.setFlashOn(z);
        }
        switchFlashOnMainThread(cameraCtrl.isFlashOn());
    }

    private void startCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            stopCountDown();
            CountDownTimer countDownTimer = this.mTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.mTimer = null;
            }
            h hVar = new h(this, SdkInitResponse.getInstance().getTakePicWaitTime(), SdkInitResponse.getInstance().getTakePicWaitTime());
            this.mTimer = hVar;
            hVar.start();
        }
    }

    private boolean startScan() {
        InterceptResult invokeV;
        c.f.b.a.a.a.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            if (this.mPreviewCb == null) {
                int b2 = c.f.b.a.a.a.d.b(getActivity(), this.cameraId);
                this.mRotation = b2;
                int i2 = this.cameraId;
                int[] iArr = this.mScreeSize;
                c.f.b.a.a.a.d c2 = c.f.b.a.a.a.d.c(i2, iArr[0], iArr[1], b2, 17, 10, this);
                this.mPreviewCb = c2;
                if (c2 == null) {
                    handleNoCamaraPermission();
                    return false;
                }
            }
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null && (dVar = this.mPreviewCb) != null) {
                dVar.g(surfaceHolder);
                c.f.b.a.a.a.a aVar = new c.f.b.a.a.a.a();
                this.mAutoFocusCb = aVar;
                aVar.a(getAutoFocusDelay());
                this.mAutoFocusCb.c(getFirstFocusDelay());
                this.mAutoFocusHandler.obtainMessage(ResUtils.id(getActivity(), "dxm_wallet_auto_focus")).sendToTarget();
                try {
                    Camera.Size previewSize = this.mPreviewCb.h().k().getPreviewSize();
                    this.mImageSize[0] = previewSize.width;
                    this.mImageSize[1] = previewSize.height;
                    int[] iArr2 = this.mScreeSize;
                    int[] iArr3 = this.mImageSize;
                    this.mScaleCoefficient = ((iArr2[1] * iArr3[1]) / iArr2[0]) / iArr3[0];
                    String str = "ratio:" + this.mScaleCoefficient;
                    relayoutUi();
                    setFocusRectValue(this.mFocusViewRect);
                    mapViewDataBoundary(this.mBmpDataRect);
                } catch (Throwable unused) {
                    showBaseDialog(3, ResUtils.getString(getActivity(), "dxm_wallet_camera_error"));
                    return false;
                }
            }
            this.mDone.set(false);
            this.mIsCameraMalfunctioned.set(true);
            Handler handler = this.mMiscEvtHandler;
            if (handler == null) {
                this.mMiscEvtHandler = new e(this);
            } else {
                handler.removeMessages(1);
            }
            this.mMiscEvtHandler.sendEmptyMessageDelayed(1, 3000L);
            return true;
        }
        return invokeV.booleanValue;
    }

    private void switchFlashOnMainThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, this, z) == null) {
            this.mFlashController.a(z);
            getActivity().runOnUiThread(this.mFlashController);
        }
    }

    public void autoFoucus() {
        c.f.b.a.a.a.d dVar;
        c.f.b.a.a.a.b h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.mPreviewCb) == null || (h2 = dVar.h()) == null) {
            return;
        }
        try {
            h2.b(this.mAutoFocusCb);
        } catch (Throwable unused) {
        }
    }

    @Override // c.f.b.a.a.a.c
    public void destroyCamera() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        OnCameraChangeListener onCameraChangeListener = this.mOnCameraChange;
        if (onCameraChangeListener != null) {
            onCameraChangeListener.onCameraClose();
        }
        if (this.mDetectors == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            i[] iVarArr = this.mDetectors;
            if (i2 < iVarArr.length) {
                iVarArr[i2] = null;
                i2++;
            } else {
                this.mDetectors = null;
                return;
            }
        }
    }

    public String getApplicationName() {
        InterceptResult invokeV;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ApplicationInfo applicationInfo = null;
            try {
                packageManager = getApplicationContext().getPackageManager();
                try {
                    applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                packageManager = null;
            }
            return (String) packageManager.getApplicationLabel(applicationInfo);
        }
        return (String) invokeV.objValue;
    }

    public long getAutoFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 500L;
        }
        return invokeV.longValue;
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    public abstract View getCustomizedView();

    public long getFirstFocusDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 500L;
        }
        return invokeV.longValue;
    }

    public abstract float getFocusDataYXRatioal();

    public abstract int getFromBusiness();

    public abstract IImageProcess getImageProcessor();

    @Override // c.f.b.a.a.a.c
    public boolean initCamera(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048586, this, i2, i3, i4, i5)) == null) {
            String str = "initCamera(" + i2 + "|" + i3 + "|" + i4 + "|" + i5 + SmallTailInfo.EMOTION_SUFFIX;
            OnCameraChangeListener onCameraChangeListener = this.mOnCameraChange;
            if (onCameraChangeListener != null) {
                onCameraChangeListener.onCameraOpen();
                return true;
            }
            return true;
        }
        return invokeIIII.booleanValue;
    }

    public abstract void isAllowCameraPermisssion(boolean z);

    @Override // com.dxmpay.wallet.core.BaseActivity
    public boolean isStatusbarTextColorBlack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void mapViewDataBoundary(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rect) == null) {
            float focusDataYXRatioal = getFocusDataYXRatioal();
            this.mFocusDataYXRatial = focusDataYXRatioal;
            if (0.0f >= focusDataYXRatioal) {
                this.mFocusDataYXRatial = 1.0f;
            }
            int round = Math.round(this.mImageSize[1] * (this.mFocusViewRect.left / this.mScreeSize[0]));
            rect.top = round;
            int[] iArr = this.mImageSize;
            rect.bottom = iArr[1] - round;
            rect.left = Math.round(iArr[0] * (this.mFocusViewRect.top / this.mScreeSize[1]));
            rect.right = Math.round((rect.height() * this.mFocusDataYXRatial) + rect.left);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i2, i3, intent) == null) {
            if (132 != i2 || i3 == 1244) {
                restartScan();
            } else if (i3 == 1243) {
                finish();
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "dxm_wallet_camera_detection"), null);
            this.mContentView = viewGroup;
            setContentView(viewGroup);
            IImageProcess imageProcessor = getImageProcessor();
            this.mImageProcessor = imageProcessor;
            if (imageProcessor == null) {
                LogUtil.e(Tag, "onCreate() failed to get ImageProcessor", null);
                finish();
            }
            this.mContentView.addView(getCustomizedView(), 1);
            View findViewById = findViewById(ResUtils.id(getActivity(), "title_bar_margin"));
            this.mTitleBarMargin = findViewById;
            setTop(findViewById);
            setIsShowMultiWindowTips(true);
            setIsMultiWindowAvailable(false);
            setMultiWindowTipsId("dxm_wallet_base_multi_window_close");
            SurfaceView surfaceView = (SurfaceView) findViewById(ResUtils.id(getActivity(), "surfaceview"));
            this.mPreviewView = surfaceView;
            SurfaceHolder holder = surfaceView.getHolder();
            holder.setKeepScreenOn(true);
            holder.setType(3);
            holder.addCallback(this);
            if (this.mThreadPool == null) {
                this.mThreadPool = ThreadPool.create(c.f.b.a.a.b.a.a(), ImageProcessor.a);
            }
            this.mThreadPool.executeTask(new a(this));
            this.mStatisticList.add(StatHelper.getProcesssId());
            ArrayList<String> arrayList = this.mStatisticList;
            arrayList.add(getFromBusiness() + "");
            WalletGlobalUtils.showStr = "";
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mDone.set(true);
            Handler handler = this.mMiscEvtHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.mMiscEvtHandler = null;
            }
            stopCamera();
            if (this.mImageProcessor != null) {
                new k(this).start();
            }
            ThreadPool threadPool = this.mThreadPool;
            if (threadPool != null) {
                threadPool.destroy();
                this.mThreadPool = null;
            }
            updateFlashLightUi(false);
            this.mShowDialog = false;
            this.mStatisticList.clear();
            super.onDestroy();
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
        }
    }

    public abstract void onPermissionDenied();

    @Override // com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i2, dialog) == null) {
            super.onPrepareDialog(i2, dialog);
            if (i2 == 3) {
                dialog.setOnDismissListener(new b(this));
            }
        }
    }

    public abstract void onProcessImageOk(Object[] objArr);

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048597, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (i2 == REQUEST_PERMISSION_CAMERA) {
                this.mCanRequestCameraPermission = true;
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equalsIgnoreCase(strArr[i3]) && iArr != null && iArr.length > i3) {
                            if (iArr[i3] == 0) {
                                relayoutUi();
                                setFocusRectValue(this.mFocusViewRect);
                                startScan();
                                StatisticManager.onEventWithValues(StatServiceEvent.OBTAINED_CAMERA_PERMISSION, this.mStatisticList);
                                isAllowCameraPermisssion(true);
                            } else if (-1 == iArr[i3]) {
                                handleNoCamaraPermission();
                            }
                        }
                    }
                    return;
                }
                handleNoCamaraPermission();
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
        }
    }

    public void pauseCamera() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.mAutoFocusCb != null) {
                this.mAutoFocusCb.b(null, ResUtils.id(getActivity(), "dxm_wallet_auto_focus"));
            }
            c.f.b.a.a.a.d dVar = this.mPreviewCb;
            if (dVar != null) {
                dVar.d();
                setFlashLightOn(false);
            }
        }
    }

    @Override // c.f.b.a.a.a.c
    public void processImage(byte[] bArr) {
        i availableDetector;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, bArr) == null) || this.mDone.get() || 1 != this.mDetectorState.get() || (availableDetector = getAvailableDetector()) == null || this.mPreviewCb == null || this.mDone.get()) {
            return;
        }
        int[] iArr = this.mImageSize;
        availableDetector.a(bArr, iArr[0], iArr[1], this.mBmpDataRect);
        this.mThreadPool.executeTask(availableDetector);
        if (this.mIsCameraMalfunctioned.get()) {
            for (byte b2 : bArr) {
                if (b2 != 0) {
                    this.mIsCameraMalfunctioned.compareAndSet(true, false);
                    Handler handler = this.mMiscEvtHandler;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public abstract void relayoutUi();

    public void restartScan() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.mDone.set(false);
            c.f.b.a.a.a.d dVar = this.mPreviewCb;
            if (dVar != null) {
                dVar.g(this.mPreviewView.getHolder());
                this.mAutoFocusHandler.obtainMessage(ResUtils.id(getActivity(), "dxm_wallet_auto_focus")).sendToTarget();
                return;
            }
            startScan();
        }
    }

    public abstract void setFocusRectValue(Rect rect);

    public void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onCameraChangeListener) == null) {
            this.mOnCameraChange = onCameraChangeListener;
        }
    }

    public void setTop(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, view) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(getActivity())));
        ImmersiveStatusBarManager.setTopBar(getActivity(), view, isStatusbarTextColorBlack());
    }

    public void stopCamera() {
        c.f.b.a.a.a.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (dVar = this.mPreviewCb) == null) {
            return;
        }
        dVar.f(false);
        this.mPreviewCb = null;
    }

    public void stopCountDown() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (countDownTimer = this.mTimer) == null) {
            return;
        }
        countDownTimer.cancel();
        this.mTimer = null;
        this.mInCaptureTimeOut.set(false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048608, this, surfaceHolder, i2, i3, i4) == null) {
            int[] iArr = this.mScreeSize;
            iArr[0] = i3;
            iArr[1] = i4;
            this.mSurfaceHolder = surfaceHolder;
            if (this.mShowDialog) {
                pauseCamera();
            } else if (PermissionManager.checkCallingPermission(getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                startScan();
                isAllowCameraPermisssion(true);
            } else if (this.mCanRequestCameraPermission) {
                StatisticManager.onEventWithValues(StatServiceEvent.APPLY_CAMERA_PERMISSION, this.mStatisticList);
                BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new d(this));
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, surfaceHolder) == null) {
            String str = "surfaceCreated()" + surfaceHolder;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, surfaceHolder) == null) {
            switchFlashOnMainThread(false);
            this.mSurfaceHolder = null;
            stopCamera();
        }
    }

    public void switchCamera() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && CameraCtrl.getInstance().isSupportMultiCamera()) {
            int i2 = this.cameraId;
            if (i2 == 0) {
                this.cameraId = 1;
            } else if (i2 == 1) {
                this.cameraId = 0;
            }
            restartScan();
        }
    }

    public void takePicture() {
        c.f.b.a.a.a.b h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            startCountDown();
            c.f.b.a.a.a.d dVar = this.mPreviewCb;
            if (dVar == null || (h2 = dVar.h()) == null) {
                return;
            }
            h2.b(this.autoFocusCallback);
        }
    }

    public void takePictureWithoutAutoFocus(c.f.b.a.a.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, bVar) == null) || bVar == null) {
            return;
        }
        this.mInCaptureProgresses = true;
        try {
            bVar.f(null, null, null, new f(this, System.currentTimeMillis()));
        } catch (Throwable th) {
            this.mInCaptureTimeOut.set(true);
            this.mInCaptureProgresses = false;
            StatisticManager.onEventWithValue("sdk_self_define_take_picture_failed", th.getMessage());
        }
    }

    public void triggerFlash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            setFlashLightOn(!isFlashOn());
        }
    }

    public abstract void updateFlashLightUi(boolean z);
}
