package d.a.n0.x.c;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.n0.x.c.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes4.dex */
public class b implements d.a.n0.x.c.d {

    /* renamed from: c  reason: collision with root package name */
    public int f63178c;

    /* renamed from: f  reason: collision with root package name */
    public Context f63181f;

    /* renamed from: g  reason: collision with root package name */
    public Camera f63182g;

    /* renamed from: h  reason: collision with root package name */
    public Camera.Parameters f63183h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.x.c.e f63184i;
    public f k;
    public View l;
    public d.a n;
    public Camera.Size p;
    public SurfaceTexture r;

    /* renamed from: a  reason: collision with root package name */
    public int f63176a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f63177b = 0;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f63179d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f63180e = new AtomicBoolean(false);
    public Rect j = new Rect();
    public int m = 0;
    public int o = 0;
    public int q = 0;
    public byte[] s = null;
    public Camera.PreviewCallback t = new C1734b();
    public TextureView.SurfaceTextureListener u = new c();
    public Comparator<Camera.Size> v = new e(this);

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b f63185e;

        /* renamed from: d.a.n0.x.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1733a implements Camera.PictureCallback {
            public C1733a() {
            }

            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                b.this.J(false);
                b.this.f63179d.set(false);
                d.b bVar = a.this.f63185e;
                if (bVar != null) {
                    bVar.a(bArr);
                }
            }
        }

        public a(d.b bVar) {
            this.f63185e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.f63182g.takePicture(null, null, new C1733a());
            } catch (Exception e2) {
                e2.printStackTrace();
                b.this.J(false);
                b.this.f63179d.set(false);
            }
        }
    }

    /* renamed from: d.a.n0.x.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1734b implements Camera.PreviewCallback {

        /* renamed from: d.a.n0.x.c.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f63189e;

            public a(byte[] bArr) {
                this.f63189e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.D(this.f63189e);
            }
        }

        public C1734b() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (!b.this.f63180e.get() && b.s(b.this) % 5 == 0 && bArr.length == b.this.f63183h.getPreviewSize().width * b.this.f63183h.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.s);
                d.a.n0.x.c.c.c(new a(bArr));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TextureView.SurfaceTextureListener {
        public c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            b.this.r = surfaceTexture;
            b.this.C();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            b bVar = b.this;
            bVar.E(bVar.k.getWidth(), b.this.k.getHeight());
            b.this.J(false);
            b.this.G();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.G();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* loaded from: classes4.dex */
        public class a implements Camera.AutoFocusCallback {
            public a(d dVar) {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this) {
                if (b.this.f63182g != null && !b.this.f63179d.get()) {
                    try {
                        b.this.f63182g.autoFocus(new a(this));
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Comparator<Camera.Size> {
        public e(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    }

    /* loaded from: classes4.dex */
    public class f extends FrameLayout {

        /* renamed from: e  reason: collision with root package name */
        public TextureView f63193e;

        /* renamed from: f  reason: collision with root package name */
        public float f63194f;

        public f(Context context) {
            super(context);
            this.f63194f = 0.75f;
        }

        public final void d(int i2, int i3) {
            if (i2 < i3) {
                i3 = (int) (i2 * this.f63194f);
            } else {
                i2 = (int) (i3 * this.f63194f);
            }
            int width = (getWidth() - i2) / 2;
            int height = (getHeight() - i3) / 2;
            b.this.j.left = width;
            b.this.j.top = height;
            b.this.j.right = width + i2;
            b.this.j.bottom = height + i3;
        }

        public void e(float f2) {
            this.f63194f = f2;
            requestLayout();
            d(getWidth(), getHeight());
        }

        public void f(TextureView textureView) {
            this.f63193e = textureView;
            removeAllViews();
            addView(textureView);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            this.f63193e.layout(b.this.j.left, b.this.j.top, b.this.j.right, b.this.j.bottom);
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            d(i2, i3);
        }
    }

    public b(Context context) {
        this.f63181f = context;
        this.k = new f(context);
        F();
    }

    public static /* synthetic */ int s(b bVar) {
        int i2 = bVar.o;
        bVar.o = i2 + 1;
        return i2;
    }

    public final Camera.Size A(List<Camera.Size> list) {
        int i2;
        int i3;
        int width = this.k.f63193e.getWidth();
        int height = this.k.f63193e.getHeight();
        float f2 = this.k.f63194f;
        Camera.Size size = list.get(0);
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size2 : list) {
            int i4 = size2.width;
            if (i4 >= width && (i3 = size2.height) >= height && i4 * height == i3 * width) {
                arrayList.add(size2);
            } else {
                int i5 = size2.height;
                if (i5 >= width && (i2 = size2.width) >= height && i2 * width == i5 * height) {
                    arrayList.add(size2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return (Camera.Size) Collections.min(arrayList, this.v);
        }
        float f3 = f2;
        for (Camera.Size size3 : list) {
            if (size3 != null) {
                float abs = Math.abs(f2 - ((size3.width * 1.0f) / size3.height));
                if (abs < f3) {
                    size = size3;
                    f3 = abs;
                }
            }
        }
        return size;
    }

    public final int B() {
        int i2 = this.f63176a;
        if (i2 != 90) {
            return i2 != 270 ? 90 : 180;
        }
        return 0;
    }

    public final void C() {
        try {
            if (this.f63182g == null) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                    Camera.getCameraInfo(i2, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        this.f63177b = i2;
                    }
                }
                this.f63182g = Camera.open(this.f63177b);
            }
            if (this.f63183h == null) {
                Camera.Parameters parameters = this.f63182g.getParameters();
                this.f63183h = parameters;
                parameters.setPreviewFormat(17);
            }
            E(this.k.getWidth(), this.k.getHeight());
            this.f63182g.setPreviewTexture(this.r);
            G();
            J(false);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0064 -> B:34:0x0067). Please submit an issue!!! */
    public final void D(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (this.f63182g == null || bArr == null || this.p == null) {
            return;
        }
        Camera.Size size = this.p;
        YuvImage yuvImage = new YuvImage(bArr, 17, size.width, size.height, null);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (OutOfMemoryError unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            yuvImage.compressToJpeg(new Rect(0, 0, this.p.width, this.p.height), 80, byteArrayOutputStream);
            if (this.n.a(byteArrayOutputStream.toByteArray(), z()) == 0) {
                y();
            }
            byteArrayOutputStream.close();
        } catch (OutOfMemoryError unused2) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public final void E(int i2, int i3) {
        Camera camera;
        if (this.f63183h == null || (camera = this.f63182g) == null || i2 <= 0) {
            return;
        }
        try {
            Camera.Size A = A(camera.getParameters().getSupportedPreviewSizes());
            this.p = A;
            this.f63183h.setPreviewSize(A.width, A.height);
            this.k.e((this.p.width * 1.0f) / this.p.height);
            this.f63182g.setDisplayOrientation(B());
            K();
            this.f63182g.setParameters(this.f63183h);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void F() {
        H();
    }

    public final void G() {
        if (this.s == null) {
            this.s = new byte[((this.l.getWidth() * this.l.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        Camera camera = this.f63182g;
        if (camera == null || this.q != 1) {
            return;
        }
        camera.addCallbackBuffer(this.s);
        this.f63182g.setPreviewCallback(this.t);
    }

    public final void H() {
        TextureView textureView = new TextureView(this.f63181f);
        this.k.f63193e = textureView;
        this.k.f(textureView);
        this.l = this.k;
        textureView.setSurfaceTextureListener(this.u);
    }

    public final void I() {
        d.a.n0.x.c.c.b(new d());
    }

    public final void J(boolean z) {
        d.a.n0.x.c.e eVar;
        if (ContextCompat.checkSelfPermission(this.f63181f, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (!z || (eVar = this.f63184i) == null) {
                return;
            }
            eVar.a();
            return;
        }
        Camera camera = this.f63182g;
        if (camera == null) {
            C();
            return;
        }
        camera.startPreview();
        I();
    }

    public final void K() {
        Camera camera = this.f63182g;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    public final void L(int i2) {
        if (i2 == 0) {
            this.f63183h.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        } else if (i2 == 1) {
            this.f63183h.setFlashMode("torch");
        } else if (i2 != 2) {
            this.f63183h.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        } else {
            this.f63183h.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        }
        this.f63182g.setParameters(this.f63183h);
    }

    @Override // d.a.n0.x.c.d
    public View a() {
        return this.l;
    }

    @Override // d.a.n0.x.c.d
    public void b(d.b bVar) {
        if (this.f63179d.get()) {
            return;
        }
        int i2 = this.f63176a;
        if (i2 == 0) {
            this.f63183h.setRotation(90);
        } else if (i2 == 90) {
            this.f63183h.setRotation(0);
        } else if (i2 == 270) {
            this.f63183h.setRotation(180);
        }
        try {
            Camera.Size A = A(this.f63182g.getParameters().getSupportedPictureSizes());
            this.f63183h.setPictureSize(A.width, A.height);
            this.f63182g.setParameters(this.f63183h);
            this.f63179d.set(true);
            x();
            d.a.n0.x.c.c.c(new a(bVar));
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            J(false);
            this.f63179d.set(false);
        }
    }

    @Override // d.a.n0.x.c.d
    public void c(int i2) {
        this.f63176a = i2;
        if (i2 == 0) {
            this.m = 90;
        } else if (i2 == 90) {
            this.m = 0;
        } else if (i2 != 270) {
            this.m = 0;
        } else {
            this.m = 180;
        }
        this.k.requestLayout();
    }

    @Override // d.a.n0.x.c.d
    public int d() {
        return this.f63178c;
    }

    @Override // d.a.n0.x.c.d
    public void e() {
        this.f63179d.set(false);
    }

    @Override // d.a.n0.x.c.d
    public Rect f() {
        return this.j;
    }

    @Override // d.a.n0.x.c.d
    public void g() {
        J(true);
    }

    @Override // d.a.n0.x.c.d
    public void h(int i2) {
        if (this.f63178c == i2) {
            return;
        }
        this.f63178c = i2;
        L(i2);
    }

    @Override // d.a.n0.x.c.d
    public void i(d.a.n0.x.c.e eVar) {
        this.f63184i = eVar;
    }

    @Override // d.a.n0.x.c.d
    public void pause() {
        if (this.f63182g != null) {
            K();
        }
        h(0);
    }

    @Override // d.a.n0.x.c.d
    public void resume() {
        this.f63179d.set(false);
        if (this.f63182g != null) {
            this.k.f63193e.setSurfaceTextureListener(this.u);
            if (this.k.f63193e.isAvailable()) {
                J(false);
                return;
            }
            return;
        }
        F();
    }

    @Override // d.a.n0.x.c.d
    public void start() {
        J(false);
    }

    @Override // d.a.n0.x.c.d
    public void stop() {
        Camera camera = this.f63182g;
        if (camera != null) {
            camera.setPreviewCallback(null);
            K();
            Camera camera2 = this.f63182g;
            this.f63182g = null;
            camera2.release();
            this.f63182g = null;
            this.s = null;
        }
    }

    public final void x() {
        this.f63182g.cancelAutoFocus();
        d.a.n0.x.c.c.a();
    }

    public final void y() {
        Camera camera = this.f63182g;
        if (camera == null || this.q != 1) {
            return;
        }
        camera.setPreviewCallback(null);
        K();
    }

    public int z() {
        return this.m;
    }
}
