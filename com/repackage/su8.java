package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.RecordVideoActivity;
import com.baidu.tieba.video.record.StickerItem;
import com.baidu.tieba.video.record.VideoPreviewView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.repackage.cr4;
import com.repackage.ru8;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes7.dex */
public class su8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecordVideoActivity a;
    public Bitmap b;
    public j c;
    public Camera d;
    public int e;
    public int f;
    public FrameLayout g;
    public int h;
    public int i;
    public List<String> j;
    public boolean k;
    public int l;
    public int m;
    public Camera.Parameters n;
    public ru8 o;
    public SurfaceView p;
    public List<String> q;
    public String r;
    public k s;
    public nu8 t;
    public zl7 u;
    public Handler v;
    public GLVideoPreviewView.b w;
    public GLVideoPreviewView.b x;
    public l y;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su8 a;

        public a(su8 su8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su8Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 1) {
                    this.a.K();
                } else if (i != 2) {
                    if (i == 3 && this.a.a != null) {
                        oi.M(this.a.a, R.string.obfuscated_res_0x7f0f04df);
                        if (this.a.u != null) {
                            this.a.u.b(2, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f04df));
                        }
                        this.a.a.finish();
                    }
                } else if (this.a.a != null) {
                    if (!"OD103".equals(Build.MODEL)) {
                        oi.M(this.a.a, R.string.obfuscated_res_0x7f0f04e0);
                        if (this.a.u != null) {
                            Object obj = message.obj;
                            if (!(obj instanceof String)) {
                                string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f04e0);
                            } else {
                                string = (String) obj;
                            }
                            this.a.u.b(1, string);
                        }
                        this.a.a.finish();
                        return;
                    }
                    su8 su8Var = this.a;
                    su8Var.x(su8Var.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public b(su8 su8Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su8Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public c(su8 su8Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su8Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                Intent intent = new Intent();
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
                this.a.startActivity(intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements GLVideoPreviewView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su8 a;

        /* loaded from: classes7.dex */
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
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.w.onFaceIdentifyState(this.a);
                }
            }
        }

        public d(su8 su8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su8Var;
        }

        @Override // com.baidu.tieba.video.record.GLVideoPreviewView.b
        public void onFaceIdentifyState(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.w == null) {
                return;
            }
            pg.a().post(new a(this, z));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su8 a;

        public e(su8 su8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su8 a;

        public f(su8 su8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su8 a;

        public g(su8 su8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su8Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                if (this.a.a != null) {
                    this.a.a.finish();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(su8 su8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru8.a a;
        public final /* synthetic */ su8 b;

        public i(su8 su8Var, ru8.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su8Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = su8Var;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.o == null) {
                return;
            }
            this.b.o.c(this.a);
        }
    }

    /* loaded from: classes7.dex */
    public class j extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public Bitmap c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(su8 su8Var, Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su8Var, context, Integer.valueOf(i), Integer.valueOf(i2), bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = bitmap;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                canvas.drawBitmap(this.c, this.a, this.b, (Paint) null);
                super.onDraw(canvas);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface k {
        void a();
    }

    /* loaded from: classes7.dex */
    public interface l {
        void onSurfaceViewLayoutChange(int i, int i2);
    }

    public su8(RecordVideoActivity recordVideoActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recordVideoActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = -1;
        this.m = 0;
        this.n = null;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, dm7.class);
        dm7 dm7Var = runTask != null ? (dm7) runTask.getData() : null;
        if (dm7Var != null) {
            this.u = dm7Var.get();
        }
        this.v = new a(this);
        this.x = new d(this);
        this.a = recordVideoActivity;
        s();
        this.b = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.obfuscated_res_0x7f08032f);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.e = displayMetrics.widthPixels;
        this.f = displayMetrics.heightPixels;
        this.g = this.a.getSurfaceContainer();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.p = gLVideoPreviewView;
            this.o = gLVideoPreviewView;
            gLVideoPreviewView.setFaceIdentifyStateListener(this.x);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.p = videoPreviewView;
            this.o = videoPreviewView;
        }
        if (recordVideoActivity == null || recordVideoActivity.getSurfaceContainer() == null) {
            return;
        }
        recordVideoActivity.getSurfaceContainer().addView(this.p, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void A() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.g == null || (jVar = this.c) == null || jVar.getParent() == null) {
            return;
        }
        this.g.removeView(this.c);
    }

    public void B(ts8 ts8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ts8Var) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView instanceof GLVideoPreviewView) {
                ((GLVideoPreviewView) surfaceView).setBeautyLevel(ts8Var);
            }
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            try {
                if (!mu8.f(z)) {
                    z = !z;
                    if (!mu8.f(z)) {
                        J();
                        return;
                    }
                }
                int c2 = mu8.c(z);
                this.l = c2;
                if (-1 != c2) {
                    t();
                    this.t = new nu8(this.d);
                    this.k = z;
                    return;
                }
                J();
            } catch (Exception e2) {
                e2.printStackTrace();
                J();
                zl7 zl7Var = this.u;
                if (zl7Var != null) {
                    zl7Var.b(8, tl7.a(e2));
                }
            }
        }
    }

    public void D(GLVideoPreviewView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null) {
            return;
        }
        this.w = bVar;
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView instanceof GLVideoPreviewView) {
                ((GLVideoPreviewView) surfaceView).setFilter(str);
            }
        }
    }

    public void F(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            this.s = kVar;
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = Integer.MAX_VALUE;
            int[] iArr = null;
            int i3 = Integer.MAX_VALUE;
            for (int[] iArr2 : this.n.getSupportedPreviewFpsRange()) {
                if (Math.abs(20000 - iArr2[1]) <= i2 && Math.abs(15000 - iArr2[0]) <= i3) {
                    i2 = Math.abs(20000 - iArr2[1]);
                    i3 = Math.abs(15000 - iArr2[0]);
                    iArr = iArr2;
                }
            }
            this.n.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    public void H(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, stickerItem) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView instanceof GLVideoPreviewView) {
                ((GLVideoPreviewView) surfaceView).setSticker(stickerItem);
            }
        }
    }

    public void I(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lVar) == null) || lVar == null) {
            return;
        }
        this.y = lVar;
    }

    public final void J() {
        RecordVideoActivity recordVideoActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (recordVideoActivity = this.a) == null) {
            return;
        }
        cr4 cr4Var = new cr4(recordVideoActivity.getPageContext().getPageActivity());
        cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f14f0);
        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04dd, new g(this));
        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f04d8, new h(this));
        cr4Var.setCancelable(true);
        cr4Var.create(this.a.getPageContext());
        cr4Var.show();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.a(this.d);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o.d(this.d);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.o.e(this.d);
        }
    }

    public void N(ru8.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            ru8 ru8Var = this.o;
            if (ru8Var instanceof GLSurfaceView) {
                this.v.postDelayed(new i(this, aVar), 500L);
            } else {
                ru8Var.c(aVar);
            }
        }
    }

    public final void O(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            try {
                this.d.cancelAutoFocus();
                if (this.j.contains("auto")) {
                    Camera.Parameters parameters = this.d.getParameters();
                    this.n = parameters;
                    parameters.setFocusMode("auto");
                }
                this.d.setParameters(this.n);
                this.d.autoFocus(null);
            } catch (Exception e2) {
                e2.printStackTrace();
                zl7 zl7Var = this.u;
                if (zl7Var != null) {
                    zl7Var.b(9, tl7.a(e2));
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView != null && (surfaceView instanceof GLVideoPreviewView)) {
                GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) surfaceView;
                gLVideoPreviewView.setIsChangingCamera(true);
                z();
                gLVideoPreviewView.t();
                int i2 = this.m == 0 ? 1 : 0;
                this.m = i2;
                C(i2 == 1);
                gLVideoPreviewView.u();
                gLVideoPreviewView.setIsChangingCamera(false);
                return;
            }
            SurfaceView surfaceView2 = this.p;
            if (surfaceView2 == null || !(surfaceView2 instanceof VideoPreviewView)) {
                return;
            }
            ((VideoPreviewView) surfaceView2).b(this.d);
            z();
            int i3 = this.m == 0 ? 1 : 0;
            this.m = i3;
            C(i3 == 1);
            K();
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            File file = new File(vs8.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = vs8.f + "f_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
            this.r = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void h() {
        List<String> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (list = this.q) == null || list.size() == 0) {
            return;
        }
        List<String> list2 = this.q;
        String remove = list2.remove(list2.size() - 1);
        if (TextUtils.isEmpty(remove)) {
            return;
        }
        File file = new File(remove);
        if (file.exists()) {
            file.delete();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                if (this.d == null) {
                    return;
                }
                if (this.n == null) {
                    this.n = this.d.getParameters();
                }
                if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(this.n.getFlashMode())) {
                    this.n.setFlashMode("torch");
                } else {
                    this.n.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                }
                this.d.setParameters(this.n);
            } catch (Exception e2) {
                e2.printStackTrace();
                zl7 zl7Var = this.u;
                if (zl7Var != null) {
                    zl7Var.b(7, tl7.a(e2));
                }
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l == 0 : invokeV.booleanValue;
    }

    public nu8 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.t : (nu8) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            try {
                if (this.d == null) {
                    return false;
                }
                if (this.n == null) {
                    this.n = this.d.getParameters();
                }
                return !DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(this.n.getFlashMode());
            } catch (Exception e2) {
                e2.printStackTrace();
                zl7 zl7Var = this.u;
                if (zl7Var != null) {
                    zl7Var.b(7, tl7.a(e2));
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.m == 1 : invokeV.booleanValue;
    }

    public Handler n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.v : (Handler) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.q == null) {
                this.q = new ArrayList();
            }
            File file = new File(vs8.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = vs8.f + "rec_tmp_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
            this.q.add(str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    public int p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, context)) == null) {
            int i2 = 0;
            if (context == null) {
                return 0;
            }
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                i2 = displayMetrics.heightPixels;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return i2 == 0 ? oi.i(context) : i2;
        }
        return invokeL.intValue;
    }

    public ru8 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.o : (ru8) invokeV.objValue;
    }

    public boolean r(MotionEvent motionEvent, ViewParent viewParent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, motionEvent, viewParent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y > this.f || x < oi.f(this.a, R.dimen.obfuscated_res_0x7f070253)) {
                    return true;
                }
                int width = this.b.getWidth();
                int height = this.b.getHeight();
                int i2 = width / 2;
                int a2 = mu8.a(x, i2, this.e - i2);
                int i3 = height / 2;
                int a3 = mu8.a(y, i3, this.f - i3);
                if (viewParent != null && (viewParent instanceof FrameLayout)) {
                    if (this.g == null) {
                        this.g = (FrameLayout) viewParent;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.g.getChildCount()) {
                            break;
                        } else if (this.c == this.g.getChildAt(i4)) {
                            this.g.removeViewAt(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    j jVar = new j(this, this.a, a2 - i2, a3 - i3, this.b);
                    this.c = jVar;
                    this.g.addView(jVar, new ViewGroup.LayoutParams(-2, -2));
                    O(a2, a3);
                }
            } else if (action == 1) {
                this.v.postDelayed(new f(this), 800L);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.h = 720;
            this.i = 960;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            try {
                Camera open = Camera.open(this.l);
                this.d = open;
                this.n = open.getParameters();
                y();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                Message obtainMessage = this.v.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.obj = tl7.a(e2);
                this.v.sendMessageDelayed(obtainMessage, 1000L);
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            z();
            this.o.b(this.d);
            SurfaceView surfaceView = this.p;
            if (surfaceView == null || !(surfaceView instanceof GLVideoPreviewView)) {
                return;
            }
            ((GLVideoPreviewView) surfaceView).onPause();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            C(this.m == 1);
            SurfaceView surfaceView = this.p;
            if (surfaceView != null && (surfaceView instanceof GLVideoPreviewView)) {
                ((GLVideoPreviewView) surfaceView).onResume();
            }
            SurfaceView surfaceView2 = this.p;
            if (surfaceView2 == null || !(surfaceView2 instanceof VideoPreviewView)) {
                return;
            }
            ((VideoPreviewView) surfaceView2).h();
        }
    }

    public boolean w(MotionEvent motionEvent, ViewParent viewParent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, motionEvent, viewParent)) == null) {
            if (this.s != null && motionEvent.getAction() == 0) {
                this.s.a();
            }
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount == 1) {
                return r(motionEvent, viewParent);
            }
            if (pointerCount >= 2) {
                this.v.postDelayed(new e(this), 100L);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void x(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, activity) == null) {
            cr4 cr4Var = new cr4(activity);
            cr4Var.setCanceledOnTouchOutside(false);
            cr4Var.setTitle(R.string.obfuscated_res_0x7f0f0faf);
            cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0fab);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0964, new c(this, activity)).setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new b(this, activity)).create(f9.a(activity));
            cr4Var.show();
        }
    }

    public void y() {
        RecordVideoActivity recordVideoActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.d == null && (recordVideoActivity = this.a) != null) {
                recordVideoActivity.finish();
                return;
            }
            int k2 = oi.k(this.a.getPageContext().getPageActivity());
            int p = p(this.a.getPageContext().getPageActivity());
            if (DeviceInfoUtil.isHuaWeiP40()) {
                p = this.f;
            }
            float f2 = p;
            float f3 = k2;
            Camera.Size d2 = mu8.d(this.d, 720, (int) (720 * ((f2 * 1.0f) / f3)));
            if (d2 != null) {
                int i2 = d2.width;
                this.h = i2;
                int i3 = d2.height;
                this.i = i3;
                this.n.setPreviewSize(i2, i3);
                ru8 ru8Var = this.o;
                if (ru8Var != null) {
                    ru8Var.setPreviewSize(this.h, this.i);
                }
            }
            this.n.setPreviewFormat(17);
            G();
            this.d.setDisplayOrientation(mu8.b(this.a, this.l));
            List<String> supportedFocusModes = this.n.getSupportedFocusModes();
            this.j = supportedFocusModes;
            if (supportedFocusModes != null) {
                if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.j.contains("continuous-picture")) {
                    this.n.setFocusMode("continuous-picture");
                } else if (this.j.contains("continuous-video")) {
                    this.n.setFocusMode("continuous-video");
                }
            }
            this.d.setParameters(this.n);
            RecordVideoActivity recordVideoActivity2 = this.a;
            if (recordVideoActivity2 == null || recordVideoActivity2.getSurfaceContainer() == null) {
                return;
            }
            float f4 = (this.i * 1.0f) / this.h;
            if ((f3 * 1.0f) / f2 > f4) {
                p = (int) (f3 / f4);
            } else {
                k2 = (int) (f2 * f4);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams.width = k2;
            layoutParams.height = p;
            this.p.setLayoutParams(layoutParams);
            this.p.invalidate();
            l lVar = this.y;
            if (lVar != null) {
                lVar.onSurfaceViewLayoutChange(layoutParams.width, layoutParams.height);
            }
        }
    }

    public final void z() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (camera = this.d) == null) {
            return;
        }
        try {
            camera.stopPreview();
            this.d.setPreviewCallback(null);
            this.d.setPreviewTexture(null);
            this.d.release();
        } catch (Exception e2) {
            e2.printStackTrace();
            zl7 zl7Var = this.u;
            if (zl7Var != null) {
                zl7Var.b(6, tl7.a(e2));
            }
        }
        this.d = null;
    }
}
