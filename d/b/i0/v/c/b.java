package d.b.i0.v.c;

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
import d.b.i0.v.c.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class b implements d.b.i0.v.c.d {

    /* renamed from: c  reason: collision with root package name */
    public int f62942c;

    /* renamed from: f  reason: collision with root package name */
    public Context f62945f;

    /* renamed from: g  reason: collision with root package name */
    public Camera f62946g;

    /* renamed from: h  reason: collision with root package name */
    public Camera.Parameters f62947h;
    public d.b.i0.v.c.e i;
    public f k;
    public View l;
    public d.a n;
    public Camera.Size p;
    public SurfaceTexture r;

    /* renamed from: a  reason: collision with root package name */
    public int f62940a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f62941b = 0;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f62943d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f62944e = new AtomicBoolean(false);
    public Rect j = new Rect();
    public int m = 0;
    public int o = 0;
    public int q = 0;
    public byte[] s = null;
    public Camera.PreviewCallback t = new C1655b();
    public TextureView.SurfaceTextureListener u = new c();
    public Comparator<Camera.Size> v = new e(this);

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b f62948e;

        /* renamed from: d.b.i0.v.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1654a implements Camera.PictureCallback {
            public C1654a() {
            }

            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                b.this.J(false);
                b.this.f62943d.set(false);
                d.b bVar = a.this.f62948e;
                if (bVar != null) {
                    bVar.a(bArr);
                }
            }
        }

        public a(d.b bVar) {
            this.f62948e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.f62946g.takePicture(null, null, new C1654a());
            } catch (Exception e2) {
                e2.printStackTrace();
                b.this.J(false);
                b.this.f62943d.set(false);
            }
        }
    }

    /* renamed from: d.b.i0.v.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1655b implements Camera.PreviewCallback {

        /* renamed from: d.b.i0.v.c.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f62952e;

            public a(byte[] bArr) {
                this.f62952e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.D(this.f62952e);
            }
        }

        public C1655b() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (!b.this.f62944e.get() && b.s(b.this) % 5 == 0 && bArr.length == b.this.f62947h.getPreviewSize().width * b.this.f62947h.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.s);
                d.b.i0.v.c.c.c(new a(bArr));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TextureView.SurfaceTextureListener {
        public c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.r = surfaceTexture;
            b.this.C();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
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
                if (b.this.f62946g != null && !b.this.f62943d.get()) {
                    try {
                        b.this.f62946g.autoFocus(new a(this));
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
        public TextureView f62956e;

        /* renamed from: f  reason: collision with root package name */
        public float f62957f;

        public f(Context context) {
            super(context);
            this.f62957f = 0.75f;
        }

        public final void d(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.f62957f);
            } else {
                i = (int) (i2 * this.f62957f);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.j.left = width;
            b.this.j.top = height;
            b.this.j.right = width + i;
            b.this.j.bottom = height + i2;
        }

        public void e(float f2) {
            this.f62957f = f2;
            requestLayout();
            d(getWidth(), getHeight());
        }

        public void f(TextureView textureView) {
            this.f62956e = textureView;
            removeAllViews();
            addView(textureView);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.f62956e.layout(b.this.j.left, b.this.j.top, b.this.j.right, b.this.j.bottom);
        }

        @Override // android.view.View
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            d(i, i2);
        }
    }

    public b(Context context) {
        this.f62945f = context;
        this.k = new f(context);
        F();
    }

    public static /* synthetic */ int s(b bVar) {
        int i = bVar.o;
        bVar.o = i + 1;
        return i;
    }

    public final Camera.Size A(List<Camera.Size> list) {
        int i;
        int i2;
        int width = this.k.f62956e.getWidth();
        int height = this.k.f62956e.getHeight();
        float f2 = this.k.f62957f;
        Camera.Size size = list.get(0);
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size2 : list) {
            int i3 = size2.width;
            if (i3 >= width && (i2 = size2.height) >= height && i3 * height == i2 * width) {
                arrayList.add(size2);
            } else {
                int i4 = size2.height;
                if (i4 >= width && (i = size2.width) >= height && i * width == i4 * height) {
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
        int i = this.f62940a;
        if (i != 90) {
            return i != 270 ? 90 : 180;
        }
        return 0;
    }

    public final void C() {
        try {
            if (this.f62946g == null) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        this.f62941b = i;
                    }
                }
                this.f62946g = Camera.open(this.f62941b);
            }
            if (this.f62947h == null) {
                Camera.Parameters parameters = this.f62946g.getParameters();
                this.f62947h = parameters;
                parameters.setPreviewFormat(17);
            }
            E(this.k.getWidth(), this.k.getHeight());
            this.f62946g.setPreviewTexture(this.r);
            G();
            J(false);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0064 -> B:34:0x0067). Please submit an issue!!! */
    public final void D(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (this.f62946g == null || bArr == null || this.p == null) {
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

    public final void E(int i, int i2) {
        Camera camera;
        if (this.f62947h == null || (camera = this.f62946g) == null || i <= 0) {
            return;
        }
        try {
            Camera.Size A = A(camera.getParameters().getSupportedPreviewSizes());
            this.p = A;
            this.f62947h.setPreviewSize(A.width, A.height);
            this.k.e((this.p.width * 1.0f) / this.p.height);
            this.f62946g.setDisplayOrientation(B());
            K();
            this.f62946g.setParameters(this.f62947h);
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
        Camera camera = this.f62946g;
        if (camera == null || this.q != 1) {
            return;
        }
        camera.addCallbackBuffer(this.s);
        this.f62946g.setPreviewCallback(this.t);
    }

    public final void H() {
        TextureView textureView = new TextureView(this.f62945f);
        this.k.f62956e = textureView;
        this.k.f(textureView);
        this.l = this.k;
        textureView.setSurfaceTextureListener(this.u);
    }

    public final void I() {
        d.b.i0.v.c.c.b(new d());
    }

    public final void J(boolean z) {
        d.b.i0.v.c.e eVar;
        if (ContextCompat.checkSelfPermission(this.f62945f, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (!z || (eVar = this.i) == null) {
                return;
            }
            eVar.a();
            return;
        }
        Camera camera = this.f62946g;
        if (camera == null) {
            C();
            return;
        }
        camera.startPreview();
        I();
    }

    public final void K() {
        Camera camera = this.f62946g;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    public final void L(int i) {
        if (i == 0) {
            this.f62947h.setFlashMode("off");
        } else if (i == 1) {
            this.f62947h.setFlashMode("torch");
        } else if (i != 2) {
            this.f62947h.setFlashMode("auto");
        } else {
            this.f62947h.setFlashMode("auto");
        }
        this.f62946g.setParameters(this.f62947h);
    }

    @Override // d.b.i0.v.c.d
    public void a() {
        J(true);
    }

    @Override // d.b.i0.v.c.d
    public void b(int i) {
        if (this.f62942c == i) {
            return;
        }
        this.f62942c = i;
        L(i);
    }

    @Override // d.b.i0.v.c.d
    public void c(d.b.i0.v.c.e eVar) {
        this.i = eVar;
    }

    @Override // d.b.i0.v.c.d
    public View d() {
        return this.l;
    }

    @Override // d.b.i0.v.c.d
    public void e(d.b bVar) {
        if (this.f62943d.get()) {
            return;
        }
        int i = this.f62940a;
        if (i == 0) {
            this.f62947h.setRotation(90);
        } else if (i == 90) {
            this.f62947h.setRotation(0);
        } else if (i == 270) {
            this.f62947h.setRotation(180);
        }
        try {
            Camera.Size A = A(this.f62946g.getParameters().getSupportedPictureSizes());
            this.f62947h.setPictureSize(A.width, A.height);
            this.f62946g.setParameters(this.f62947h);
            this.f62943d.set(true);
            x();
            d.b.i0.v.c.c.c(new a(bVar));
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            J(false);
            this.f62943d.set(false);
        }
    }

    @Override // d.b.i0.v.c.d
    public void f(int i) {
        this.f62940a = i;
        if (i == 0) {
            this.m = 90;
        } else if (i == 90) {
            this.m = 0;
        } else if (i != 270) {
            this.m = 0;
        } else {
            this.m = 180;
        }
        this.k.requestLayout();
    }

    @Override // d.b.i0.v.c.d
    public int g() {
        return this.f62942c;
    }

    @Override // d.b.i0.v.c.d
    public void h() {
        this.f62943d.set(false);
    }

    @Override // d.b.i0.v.c.d
    public Rect i() {
        return this.j;
    }

    @Override // d.b.i0.v.c.d
    public void pause() {
        if (this.f62946g != null) {
            K();
        }
        b(0);
    }

    @Override // d.b.i0.v.c.d
    public void resume() {
        this.f62943d.set(false);
        if (this.f62946g != null) {
            this.k.f62956e.setSurfaceTextureListener(this.u);
            if (this.k.f62956e.isAvailable()) {
                J(false);
                return;
            }
            return;
        }
        F();
    }

    @Override // d.b.i0.v.c.d
    public void start() {
        J(false);
    }

    @Override // d.b.i0.v.c.d
    public void stop() {
        Camera camera = this.f62946g;
        if (camera != null) {
            camera.setPreviewCallback(null);
            K();
            Camera camera2 = this.f62946g;
            this.f62946g = null;
            camera2.release();
            this.f62946g = null;
            this.s = null;
        }
    }

    public final void x() {
        this.f62946g.cancelAutoFocus();
        d.b.i0.v.c.c.a();
    }

    public final void y() {
        Camera camera = this.f62946g;
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
