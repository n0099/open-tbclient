package d.b.i0.p3.m;

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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.RecordVideoActivity;
import com.baidu.tieba.video.record.StickerItem;
import com.baidu.tieba.video.record.VideoPreviewView;
import d.b.h0.r.s.a;
import d.b.i0.p3.m.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public RecordVideoActivity f59139a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f59140b;

    /* renamed from: c  reason: collision with root package name */
    public j f59141c;

    /* renamed from: d  reason: collision with root package name */
    public Camera f59142d;

    /* renamed from: e  reason: collision with root package name */
    public int f59143e;

    /* renamed from: f  reason: collision with root package name */
    public int f59144f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f59145g;

    /* renamed from: h  reason: collision with root package name */
    public int f59146h;
    public int i;
    public List<String> j;
    public boolean k;
    public int l = -1;
    public int m = 0;
    public Camera.Parameters n = null;
    public d.b.i0.p3.m.g o;
    public SurfaceView p;
    public List<String> q;
    public String r;
    public k s;
    public d.b.i0.p3.m.b t;
    public d.b.i0.s1.g u;
    public Handler v;
    public GLVideoPreviewView.b w;
    public GLVideoPreviewView.b x;
    public l y;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String string;
            int i = message.what;
            if (i == 1) {
                h.this.K();
            } else if (i != 2) {
                if (i == 3 && h.this.f59139a != null) {
                    d.b.b.e.p.l.K(h.this.f59139a, R.string.disallow_audio_record_permission);
                    if (h.this.u != null) {
                        h.this.u.c(2, h.this.f59139a.getResources().getString(R.string.disallow_audio_record_permission));
                    }
                    h.this.f59139a.finish();
                }
            } else if (h.this.f59139a != null) {
                if (!"OD103".equals(Build.MODEL)) {
                    d.b.b.e.p.l.K(h.this.f59139a, R.string.disallow_camera_permission);
                    if (h.this.u != null) {
                        Object obj = message.obj;
                        if (!(obj instanceof String)) {
                            string = h.this.f59139a.getResources().getString(R.string.disallow_camera_permission);
                        } else {
                            string = (String) obj;
                        }
                        h.this.u.c(1, string);
                    }
                    h.this.f59139a.finish();
                    return;
                }
                h hVar = h.this;
                hVar.x(hVar.f59139a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f59148e;

        public b(h hVar, Activity activity) {
            this.f59148e = activity;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            this.f59148e.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f59149e;

        public c(h hVar, Activity activity) {
            this.f59149e = activity;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.f59149e.getPackageName(), null));
            this.f59149e.startActivity(intent);
            this.f59149e.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements GLVideoPreviewView.b {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f59151e;

            public a(boolean z) {
                this.f59151e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.w.onFaceIdentifyState(this.f59151e);
            }
        }

        public d() {
        }

        @Override // com.baidu.tieba.video.record.GLVideoPreviewView.b
        public void onFaceIdentifyState(boolean z) {
            if (h.this.w != null) {
                d.b.b.e.m.e.a().post(new a(z));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.A();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.A();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            if (h.this.f59139a != null) {
                h.this.f59139a.finish();
            }
        }
    }

    /* renamed from: d.b.i0.p3.m.h$h  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1469h implements a.e {
        public C1469h(h hVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.a f59156e;

        public i(g.a aVar) {
            this.f59156e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.o != null) {
                h.this.o.e(this.f59156e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends View {

        /* renamed from: e  reason: collision with root package name */
        public int f59158e;

        /* renamed from: f  reason: collision with root package name */
        public int f59159f;

        /* renamed from: g  reason: collision with root package name */
        public Bitmap f59160g;

        public j(h hVar, Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            this.f59158e = i;
            this.f59159f = i2;
            this.f59160g = bitmap;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            canvas.drawBitmap(this.f59160g, this.f59158e, this.f59159f, (Paint) null);
            super.onDraw(canvas);
        }
    }

    /* loaded from: classes5.dex */
    public interface k {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface l {
        void onSurfaceViewLayoutChange(int i, int i2);
    }

    public h(RecordVideoActivity recordVideoActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.b.i0.s1.k.class);
        d.b.i0.s1.k kVar = runTask != null ? (d.b.i0.s1.k) runTask.getData() : null;
        if (kVar != null) {
            this.u = kVar.get();
        }
        this.v = new a();
        this.x = new d();
        this.f59139a = recordVideoActivity;
        s();
        this.f59140b = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f59143e = displayMetrics.widthPixels;
        this.f59144f = displayMetrics.heightPixels;
        this.f59145g = this.f59139a.getSurfaceContainer();
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
        if (this.f59145g == null || (jVar = this.f59141c) == null || jVar.getParent() == null) {
            return;
        }
        this.f59145g.removeView(this.f59141c);
    }

    public void B(d.b.i0.p3.a aVar) {
        SurfaceView surfaceView = this.p;
        if (surfaceView instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) surfaceView).setBeautyLevel(aVar);
        }
    }

    public void C(boolean z) {
        try {
            if (!d.b.i0.p3.m.a.f(z)) {
                z = !z;
                if (!d.b.i0.p3.m.a.f(z)) {
                    J();
                    return;
                }
            }
            int c2 = d.b.i0.p3.m.a.c(z);
            this.l = c2;
            if (-1 != c2) {
                t();
                this.t = new d.b.i0.p3.m.b(this.f59142d);
                this.k = z;
                return;
            }
            J();
        } catch (Exception e2) {
            e2.printStackTrace();
            J();
            d.b.i0.s1.g gVar = this.u;
            if (gVar != null) {
                gVar.c(8, d.b.i0.s1.a.a(e2));
            }
        }
    }

    public void D(GLVideoPreviewView.b bVar) {
        if (bVar != null) {
            this.w = bVar;
        }
    }

    public void E(String str) {
        SurfaceView surfaceView = this.p;
        if (surfaceView instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) surfaceView).setFilter(str);
        }
    }

    public void F(k kVar) {
        this.s = kVar;
    }

    public final void G() {
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

    public void H(StickerItem stickerItem) {
        SurfaceView surfaceView = this.p;
        if (surfaceView instanceof GLVideoPreviewView) {
            ((GLVideoPreviewView) surfaceView).setSticker(stickerItem);
        }
    }

    public void I(l lVar) {
        if (lVar != null) {
            this.y = lVar;
        }
    }

    public final void J() {
        RecordVideoActivity recordVideoActivity = this.f59139a;
        if (recordVideoActivity == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(recordVideoActivity.getPageContext().getPageActivity());
        aVar.setMessageId(R.string.video_quit_confirm);
        aVar.setPositiveButton(R.string.dialog_ok, new g());
        aVar.setNegativeButton(R.string.dialog_cancel, new C1469h(this));
        aVar.setCancelable(true);
        aVar.create(this.f59139a.getPageContext());
        aVar.show();
    }

    public void K() {
        this.o.a(this.f59142d);
    }

    public void L() {
        this.o.b(this.f59142d);
    }

    public void M() {
        this.o.d(this.f59142d);
    }

    public void N(g.a aVar) {
        d.b.i0.p3.m.g gVar = this.o;
        if (gVar instanceof GLSurfaceView) {
            this.v.postDelayed(new i(aVar), 500L);
        } else {
            gVar.e(aVar);
        }
    }

    public final void O(int i2, int i3) {
        try {
            this.f59142d.cancelAutoFocus();
            if (this.j.contains("auto")) {
                Camera.Parameters parameters = this.f59142d.getParameters();
                this.n = parameters;
                parameters.setFocusMode("auto");
            }
            this.f59142d.setParameters(this.n);
            this.f59142d.autoFocus(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.b.i0.s1.g gVar = this.u;
            if (gVar != null) {
                gVar.c(9, d.b.i0.s1.a.a(e2));
            }
        }
    }

    public void f() {
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
        ((VideoPreviewView) surfaceView2).c(this.f59142d);
        z();
        int i3 = this.m == 0 ? 1 : 0;
        this.m = i3;
        C(i3 == 1);
        K();
    }

    public String g() {
        File file = new File(d.b.i0.p3.c.f58889c);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = d.b.i0.p3.c.f58889c + "f_" + System.currentTimeMillis() + ".mp4";
        this.r = str;
        return str;
    }

    public void h() {
        List<String> list = this.q;
        if (list == null || list.size() == 0) {
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
        try {
            if (this.f59142d == null) {
                return;
            }
            if (this.n == null) {
                this.n = this.f59142d.getParameters();
            }
            if ("off".equals(this.n.getFlashMode())) {
                this.n.setFlashMode("torch");
            } else {
                this.n.setFlashMode("off");
            }
            this.f59142d.setParameters(this.n);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.b.i0.s1.g gVar = this.u;
            if (gVar != null) {
                gVar.c(7, d.b.i0.s1.a.a(e2));
            }
        }
    }

    public boolean j() {
        return this.l == 0;
    }

    public d.b.i0.p3.m.b k() {
        return this.t;
    }

    public boolean l() {
        try {
            if (this.f59142d == null) {
                return false;
            }
            if (this.n == null) {
                this.n = this.f59142d.getParameters();
            }
            return !"off".equals(this.n.getFlashMode());
        } catch (Exception e2) {
            e2.printStackTrace();
            d.b.i0.s1.g gVar = this.u;
            if (gVar != null) {
                gVar.c(7, d.b.i0.s1.a.a(e2));
            }
            return false;
        }
    }

    public boolean m() {
        return this.m == 1;
    }

    public Handler n() {
        return this.v;
    }

    public String o() {
        if (this.q == null) {
            this.q = new ArrayList();
        }
        File file = new File(d.b.i0.p3.c.f58889c);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = d.b.i0.p3.c.f58889c + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
        this.q.add(str);
        return str;
    }

    public int p(Context context) {
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
        return i2 == 0 ? d.b.b.e.p.l.i(context) : i2;
    }

    public d.b.i0.p3.m.g q() {
        return this.o;
    }

    public boolean r(MotionEvent motionEvent, ViewParent viewParent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (y > this.f59144f || x < d.b.b.e.p.l.g(this.f59139a, R.dimen.ds60)) {
                return true;
            }
            int width = this.f59140b.getWidth();
            int height = this.f59140b.getHeight();
            int i2 = width / 2;
            int a2 = d.b.i0.p3.m.a.a(x, i2, this.f59143e - i2);
            int i3 = height / 2;
            int a3 = d.b.i0.p3.m.a.a(y, i3, this.f59144f - i3);
            if (viewParent != null && (viewParent instanceof FrameLayout)) {
                if (this.f59145g == null) {
                    this.f59145g = (FrameLayout) viewParent;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= this.f59145g.getChildCount()) {
                        break;
                    } else if (this.f59141c == this.f59145g.getChildAt(i4)) {
                        this.f59145g.removeViewAt(i4);
                        break;
                    } else {
                        i4++;
                    }
                }
                j jVar = new j(this, this.f59139a, a2 - i2, a3 - i3, this.f59140b);
                this.f59141c = jVar;
                this.f59145g.addView(jVar, new ViewGroup.LayoutParams(-2, -2));
                O(a2, a3);
            }
        } else if (action == 1) {
            this.v.postDelayed(new f(), 800L);
        }
        return true;
    }

    public final void s() {
        this.f59146h = PeerConnectionClient.HD_VIDEO_HEIGHT;
        this.i = TbConfig.HEAD_IMG_SIZE;
    }

    public final void t() {
        try {
            Camera open = Camera.open(this.l);
            this.f59142d = open;
            this.n = open.getParameters();
            y();
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            Message obtainMessage = this.v.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = d.b.i0.s1.a.a(e2);
            this.v.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    public void u() {
        z();
        this.o.c(this.f59142d);
        SurfaceView surfaceView = this.p;
        if (surfaceView == null || !(surfaceView instanceof GLVideoPreviewView)) {
            return;
        }
        ((GLVideoPreviewView) surfaceView).onPause();
    }

    public void v() {
        C(this.m == 1);
        SurfaceView surfaceView = this.p;
        if (surfaceView != null && (surfaceView instanceof GLVideoPreviewView)) {
            ((GLVideoPreviewView) surfaceView).onResume();
        }
        SurfaceView surfaceView2 = this.p;
        if (surfaceView2 != null && (surfaceView2 instanceof VideoPreviewView)) {
            ((VideoPreviewView) surfaceView2).h();
        }
        if (d.b.i0.p3.m.c.b()) {
            return;
        }
        this.v.sendEmptyMessageDelayed(3, 1000L);
    }

    public boolean w(MotionEvent motionEvent, ViewParent viewParent) {
        if (this.s != null && motionEvent.getAction() == 0) {
            this.s.a();
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 1) {
            return r(motionEvent, viewParent);
        }
        if (pointerCount >= 2) {
            this.v.postDelayed(new e(), 100L);
        }
        return true;
    }

    public void x(Activity activity) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(activity);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setTitle(R.string.request_permission_default_title);
        aVar.setMessageId(R.string.request_permission_camera);
        aVar.setPositiveButton(R.string.isopen, new c(this, activity)).setNegativeButton(R.string.cancel, new b(this, activity)).create(d.b.b.a.j.a(activity));
        aVar.show();
    }

    public void y() {
        RecordVideoActivity recordVideoActivity;
        if (this.f59142d == null && (recordVideoActivity = this.f59139a) != null) {
            recordVideoActivity.finish();
            return;
        }
        int k2 = d.b.b.e.p.l.k(this.f59139a.getPageContext().getPageActivity());
        int p = p(this.f59139a.getPageContext().getPageActivity());
        if (DeviceInfoUtil.isHuaWeiP40()) {
            p = this.f59144f;
        }
        float f2 = p;
        float f3 = k2;
        Camera.Size d2 = d.b.i0.p3.m.a.d(this.f59142d, PeerConnectionClient.HD_VIDEO_HEIGHT, (int) (((float) PeerConnectionClient.HD_VIDEO_HEIGHT) * ((f2 * 1.0f) / f3)));
        if (d2 != null) {
            int i2 = d2.width;
            this.f59146h = i2;
            int i3 = d2.height;
            this.i = i3;
            this.n.setPreviewSize(i2, i3);
            d.b.i0.p3.m.g gVar = this.o;
            if (gVar != null) {
                gVar.setPreviewSize(this.f59146h, this.i);
            }
        }
        this.n.setPreviewFormat(17);
        G();
        this.f59142d.setDisplayOrientation(d.b.i0.p3.m.a.b(this.f59139a, this.l));
        List<String> supportedFocusModes = this.n.getSupportedFocusModes();
        this.j = supportedFocusModes;
        if (supportedFocusModes != null) {
            if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.j.contains("continuous-picture")) {
                this.n.setFocusMode("continuous-picture");
            } else if (this.j.contains("continuous-video")) {
                this.n.setFocusMode("continuous-video");
            }
        }
        this.f59142d.setParameters(this.n);
        RecordVideoActivity recordVideoActivity2 = this.f59139a;
        if (recordVideoActivity2 == null || recordVideoActivity2.getSurfaceContainer() == null) {
            return;
        }
        float f4 = (this.i * 1.0f) / this.f59146h;
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

    public final void z() {
        Camera camera = this.f59142d;
        if (camera != null) {
            try {
                camera.stopPreview();
                this.f59142d.setPreviewCallback(null);
                this.f59142d.setPreviewTexture(null);
                this.f59142d.release();
            } catch (Exception e2) {
                e2.printStackTrace();
                d.b.i0.s1.g gVar = this.u;
                if (gVar != null) {
                    gVar.c(6, d.b.i0.s1.a.a(e2));
                }
            }
            this.f59142d = null;
        }
    }
}
