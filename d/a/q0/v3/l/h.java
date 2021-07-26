package d.a.q0.v3.l;

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
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.RecordVideoActivity;
import com.baidu.tieba.video.record.StickerItem;
import com.baidu.tieba.video.record.VideoPreviewView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.s.a;
import d.a.q0.v3.l.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RecordVideoActivity f66257a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f66258b;

    /* renamed from: c  reason: collision with root package name */
    public j f66259c;

    /* renamed from: d  reason: collision with root package name */
    public Camera f66260d;

    /* renamed from: e  reason: collision with root package name */
    public int f66261e;

    /* renamed from: f  reason: collision with root package name */
    public int f66262f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f66263g;

    /* renamed from: h  reason: collision with root package name */
    public int f66264h;

    /* renamed from: i  reason: collision with root package name */
    public int f66265i;
    public List<String> j;
    public boolean k;
    public int l;
    public int m;
    public Camera.Parameters n;
    public d.a.q0.v3.l.g o;
    public SurfaceView p;
    public List<String> q;
    public String r;
    public k s;
    public d.a.q0.v3.l.b t;
    public d.a.q0.x1.g u;
    public Handler v;
    public GLVideoPreviewView.b w;
    public GLVideoPreviewView.b x;
    public l y;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f66266a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66266a = hVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 1) {
                    this.f66266a.K();
                } else if (i2 != 2) {
                    if (i2 == 3 && this.f66266a.f66257a != null) {
                        d.a.d.e.p.l.L(this.f66266a.f66257a, R.string.disallow_audio_record_permission);
                        if (this.f66266a.u != null) {
                            this.f66266a.u.b(2, this.f66266a.f66257a.getResources().getString(R.string.disallow_audio_record_permission));
                        }
                        this.f66266a.f66257a.finish();
                    }
                } else if (this.f66266a.f66257a != null) {
                    if (!"OD103".equals(Build.MODEL)) {
                        d.a.d.e.p.l.L(this.f66266a.f66257a, R.string.disallow_camera_permission);
                        if (this.f66266a.u != null) {
                            Object obj = message.obj;
                            if (!(obj instanceof String)) {
                                string = this.f66266a.f66257a.getResources().getString(R.string.disallow_camera_permission);
                            } else {
                                string = (String) obj;
                            }
                            this.f66266a.u.b(1, string);
                        }
                        this.f66266a.f66257a.finish();
                        return;
                    }
                    h hVar = this.f66266a;
                    hVar.x(hVar.f66257a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f66267e;

        public b(h hVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66267e = activity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f66267e.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f66268e;

        public c(h hVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66268e = activity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, this.f66268e.getPackageName(), null));
                this.f66268e.startActivity(intent);
                this.f66268e.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements GLVideoPreviewView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f66269e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f66270e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f66271f;

            public a(d dVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66271f = dVar;
                this.f66270e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f66271f.f66269e.w.onFaceIdentifyState(this.f66270e);
                }
            }
        }

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66269e = hVar;
        }

        @Override // com.baidu.tieba.video.record.GLVideoPreviewView.b
        public void onFaceIdentifyState(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f66269e.w == null) {
                return;
            }
            d.a.d.e.m.e.a().post(new a(this, z));
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f66272e;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66272e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66272e.A();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f66273e;

        public f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66273e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66273e.A();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f66274e;

        public g(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66274e = hVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f66274e.f66257a != null) {
                    this.f66274e.f66257a.finish();
                }
            }
        }
    }

    /* renamed from: d.a.q0.v3.l.h$h  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1819h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1819h(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.a f66275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f66276f;

        public i(h hVar, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66276f = hVar;
            this.f66275e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f66276f.o == null) {
                return;
            }
            this.f66276f.o.c(this.f66275e);
        }
    }

    /* loaded from: classes8.dex */
    public class j extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f66277e;

        /* renamed from: f  reason: collision with root package name */
        public int f66278f;

        /* renamed from: g  reason: collision with root package name */
        public Bitmap f66279g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(h hVar, Context context, int i2, int i3, Bitmap bitmap) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, context, Integer.valueOf(i2), Integer.valueOf(i3), bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66277e = i2;
            this.f66278f = i3;
            this.f66279g = bitmap;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                canvas.drawBitmap(this.f66279g, this.f66277e, this.f66278f, (Paint) null);
                super.onDraw(canvas);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface k {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface l {
        void onSurfaceViewLayoutChange(int i2, int i3);
    }

    public h(RecordVideoActivity recordVideoActivity) {
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.a.q0.x1.k.class);
        d.a.q0.x1.k kVar = runTask != null ? (d.a.q0.x1.k) runTask.getData() : null;
        if (kVar != null) {
            this.u = kVar.get();
        }
        this.v = new a(this);
        this.x = new d(this);
        this.f66257a = recordVideoActivity;
        s();
        this.f66258b = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f66261e = displayMetrics.widthPixels;
        this.f66262f = displayMetrics.heightPixels;
        this.f66263g = this.f66257a.getSurfaceContainer();
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f66263g == null || (jVar = this.f66259c) == null || jVar.getParent() == null) {
            return;
        }
        this.f66263g.removeView(this.f66259c);
    }

    public void B(d.a.q0.v3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView instanceof GLVideoPreviewView) {
                ((GLVideoPreviewView) surfaceView).setBeautyLevel(aVar);
            }
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            try {
                if (!d.a.q0.v3.l.a.f(z)) {
                    z = !z;
                    if (!d.a.q0.v3.l.a.f(z)) {
                        J();
                        return;
                    }
                }
                int c2 = d.a.q0.v3.l.a.c(z);
                this.l = c2;
                if (-1 != c2) {
                    t();
                    this.t = new d.a.q0.v3.l.b(this.f66260d);
                    this.k = z;
                    return;
                }
                J();
            } catch (Exception e2) {
                e2.printStackTrace();
                J();
                d.a.q0.x1.g gVar = this.u;
                if (gVar != null) {
                    gVar.b(8, d.a.q0.x1.a.a(e2));
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (recordVideoActivity = this.f66257a) == null) {
            return;
        }
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(recordVideoActivity.getPageContext().getPageActivity());
        aVar.setMessageId(R.string.video_quit_confirm);
        aVar.setPositiveButton(R.string.dialog_ok, new g(this));
        aVar.setNegativeButton(R.string.dialog_cancel, new C1819h(this));
        aVar.setCancelable(true);
        aVar.create(this.f66257a.getPageContext());
        aVar.show();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.a(this.f66260d);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o.d(this.f66260d);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.o.e(this.f66260d);
        }
    }

    public void N(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            d.a.q0.v3.l.g gVar = this.o;
            if (gVar instanceof GLSurfaceView) {
                this.v.postDelayed(new i(this, aVar), 500L);
            } else {
                gVar.c(aVar);
            }
        }
    }

    public final void O(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            try {
                this.f66260d.cancelAutoFocus();
                if (this.j.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    Camera.Parameters parameters = this.f66260d.getParameters();
                    this.n = parameters;
                    parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                }
                this.f66260d.setParameters(this.n);
                this.f66260d.autoFocus(null);
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.q0.x1.g gVar = this.u;
                if (gVar != null) {
                    gVar.b(9, d.a.q0.x1.a.a(e2));
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
            ((VideoPreviewView) surfaceView2).b(this.f66260d);
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
            File file = new File(d.a.q0.v3.c.f66023f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = d.a.q0.v3.c.f66023f + "f_" + System.currentTimeMillis() + ".mp4";
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
                if (this.f66260d == null) {
                    return;
                }
                if (this.n == null) {
                    this.n = this.f66260d.getParameters();
                }
                if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(this.n.getFlashMode())) {
                    this.n.setFlashMode("torch");
                } else {
                    this.n.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                }
                this.f66260d.setParameters(this.n);
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.q0.x1.g gVar = this.u;
                if (gVar != null) {
                    gVar.b(7, d.a.q0.x1.a.a(e2));
                }
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l == 0 : invokeV.booleanValue;
    }

    public d.a.q0.v3.l.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.t : (d.a.q0.v3.l.b) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            try {
                if (this.f66260d == null) {
                    return false;
                }
                if (this.n == null) {
                    this.n = this.f66260d.getParameters();
                }
                return !DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(this.n.getFlashMode());
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.q0.x1.g gVar = this.u;
                if (gVar != null) {
                    gVar.b(7, d.a.q0.x1.a.a(e2));
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
            File file = new File(d.a.q0.v3.c.f66023f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = d.a.q0.v3.c.f66023f + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
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
            return i2 == 0 ? d.a.d.e.p.l.i(context) : i2;
        }
        return invokeL.intValue;
    }

    public d.a.q0.v3.l.g q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.o : (d.a.q0.v3.l.g) invokeV.objValue;
    }

    public boolean r(MotionEvent motionEvent, ViewParent viewParent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, motionEvent, viewParent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y > this.f66262f || x < d.a.d.e.p.l.g(this.f66257a, R.dimen.ds60)) {
                    return true;
                }
                int width = this.f66258b.getWidth();
                int height = this.f66258b.getHeight();
                int i2 = width / 2;
                int a2 = d.a.q0.v3.l.a.a(x, i2, this.f66261e - i2);
                int i3 = height / 2;
                int a3 = d.a.q0.v3.l.a.a(y, i3, this.f66262f - i3);
                if (viewParent != null && (viewParent instanceof FrameLayout)) {
                    if (this.f66263g == null) {
                        this.f66263g = (FrameLayout) viewParent;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.f66263g.getChildCount()) {
                            break;
                        } else if (this.f66259c == this.f66263g.getChildAt(i4)) {
                            this.f66263g.removeViewAt(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    j jVar = new j(this, this.f66257a, a2 - i2, a3 - i3, this.f66258b);
                    this.f66259c = jVar;
                    this.f66263g.addView(jVar, new ViewGroup.LayoutParams(-2, -2));
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
            this.f66264h = 720;
            this.f66265i = 960;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            try {
                Camera open = Camera.open(this.l);
                this.f66260d = open;
                this.n = open.getParameters();
                y();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                Message obtainMessage = this.v.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.obj = d.a.q0.x1.a.a(e2);
                this.v.sendMessageDelayed(obtainMessage, 1000L);
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            z();
            this.o.b(this.f66260d);
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
            if (surfaceView2 != null && (surfaceView2 instanceof VideoPreviewView)) {
                ((VideoPreviewView) surfaceView2).h();
            }
            if (d.a.q0.v3.l.c.b()) {
                return;
            }
            this.v.sendEmptyMessageDelayed(3, 1000L);
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
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(activity);
            aVar.setCanceledOnTouchOutside(false);
            aVar.setTitle(R.string.request_permission_default_title);
            aVar.setMessageId(R.string.request_permission_camera);
            aVar.setPositiveButton(R.string.isopen, new c(this, activity)).setNegativeButton(R.string.cancel, new b(this, activity)).create(d.a.d.a.j.a(activity));
            aVar.show();
        }
    }

    public void y() {
        RecordVideoActivity recordVideoActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.f66260d == null && (recordVideoActivity = this.f66257a) != null) {
                recordVideoActivity.finish();
                return;
            }
            int k2 = d.a.d.e.p.l.k(this.f66257a.getPageContext().getPageActivity());
            int p = p(this.f66257a.getPageContext().getPageActivity());
            if (DeviceInfoUtil.isHuaWeiP40()) {
                p = this.f66262f;
            }
            float f2 = p;
            float f3 = k2;
            Camera.Size d2 = d.a.q0.v3.l.a.d(this.f66260d, 720, (int) (720 * ((f2 * 1.0f) / f3)));
            if (d2 != null) {
                int i2 = d2.width;
                this.f66264h = i2;
                int i3 = d2.height;
                this.f66265i = i3;
                this.n.setPreviewSize(i2, i3);
                d.a.q0.v3.l.g gVar = this.o;
                if (gVar != null) {
                    gVar.setPreviewSize(this.f66264h, this.f66265i);
                }
            }
            this.n.setPreviewFormat(17);
            G();
            this.f66260d.setDisplayOrientation(d.a.q0.v3.l.a.b(this.f66257a, this.l));
            List<String> supportedFocusModes = this.n.getSupportedFocusModes();
            this.j = supportedFocusModes;
            if (supportedFocusModes != null) {
                if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.j.contains("continuous-picture")) {
                    this.n.setFocusMode("continuous-picture");
                } else if (this.j.contains("continuous-video")) {
                    this.n.setFocusMode("continuous-video");
                }
            }
            this.f66260d.setParameters(this.n);
            RecordVideoActivity recordVideoActivity2 = this.f66257a;
            if (recordVideoActivity2 == null || recordVideoActivity2.getSurfaceContainer() == null) {
                return;
            }
            float f4 = (this.f66265i * 1.0f) / this.f66264h;
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
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (camera = this.f66260d) == null) {
            return;
        }
        try {
            camera.stopPreview();
            this.f66260d.setPreviewCallback(null);
            this.f66260d.setPreviewTexture(null);
            this.f66260d.release();
        } catch (Exception e2) {
            e2.printStackTrace();
            d.a.q0.x1.g gVar = this.u;
            if (gVar != null) {
                gVar.b(6, d.a.q0.x1.a.a(e2));
            }
        }
        this.f66260d = null;
    }
}
