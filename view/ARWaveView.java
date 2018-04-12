package view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class ARWaveView extends View {
    private boolean A;
    private boolean B;
    private int I;
    private boolean L;
    private float a;
    private float b;
    private long c;
    private Paint d;
    private Paint e;
    private Paint f;
    private Paint g;
    private Path hIK;
    private Path hIL;
    private float hIM;
    private ViewGroup hIN;
    private c hIO;
    private b hIP;
    private a hIQ;
    private Bitmap hIR;
    private Canvas hIS;
    private PorterDuffXfermode hIT;
    private LinearInterpolator hIU;
    private Path i;
    private int k;
    private int l;
    private float m;
    private float n;
    private float o;
    private int p;
    private int q;
    private int r;
    private float s;
    private float u;
    private float v;
    private float w;
    private float x;
    private long y;
    private long z;

    /* loaded from: classes3.dex */
    private static class a extends Handler {
        private WeakReference<ARWaveView> a;

        public a(ARWaveView aRWaveView) {
            this.a = new WeakReference<>(aRWaveView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ARWaveView aRWaveView;
            if (message.what != 4097 || (aRWaveView = this.a.get()) == null) {
                return;
            }
            aRWaveView.d();
            aRWaveView.invalidate();
            aRWaveView.c();
        }
    }

    /* loaded from: classes3.dex */
    private static class b extends Thread {
        private boolean a;
        private WeakReference<ARWaveView> b;

        public synchronized void a(boolean z) {
            this.a = z;
        }

        public synchronized boolean a() {
            return this.a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!a()) {
                ARWaveView aRWaveView = this.b.get();
                if (aRWaveView != null) {
                    aRWaveView.hIQ.sendEmptyMessage(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    try {
                        Thread.sleep(16L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    public ARWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0L;
        this.k = 2;
        this.l = 2;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0.5f;
        this.p = 2;
        this.s = 2.0f;
        this.hIM = 1.6f;
        this.u = -0.2f;
        this.v = -0.1994f;
        this.w = 0.0f;
        this.x = 3.5f;
        this.y = 200L;
        this.z = 250L;
        this.A = false;
        this.B = false;
        this.I = 0;
        this.L = true;
        this.hIQ = new a(this);
        a();
    }

    private float a(int i, float f, float f2, float f3, float f4, float f5, float f6) {
        return ((1.0f - ((float) Math.pow(((i * 2) / f) - 1.0f, 2.0d))) * f3 * f4 * ((float) Math.sin((6.283185307179586d * (i / f) * f5) + f6))) + (0.5f * f2);
    }

    private void a() {
        if (getContext().getResources().getDisplayMetrics().density <= 2.0f) {
            this.k = 1;
            this.l = 1;
        }
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(this.k);
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(this.l);
        this.e.setAlpha((int) (this.o * 255.0f));
        this.f = new Paint();
        this.g = new Paint();
        this.hIK = new Path();
        this.i = new Path();
        this.hIL = new Path();
        this.hIT = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.hIU = new LinearInterpolator();
    }

    private void b() {
        if (this.r <= 0 || this.q <= 0) {
            return;
        }
        this.m = (this.r - 4.0f) * 0.5f;
        this.d.setShader(new LinearGradient(0.0f, 0.0f, this.q, 0.0f, 50943, 47871, Shader.TileMode.MIRROR));
        this.e.setShader(new LinearGradient(0.0f, 0.0f, this.q, 0.0f, 50943, 47871, Shader.TileMode.MIRROR));
        this.f.setShader(new LinearGradient(0.0f, (this.r / 2) - this.m, 0.0f, this.m + (this.r / 2), 845567, 845567, Shader.TileMode.MIRROR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.w += this.u;
        this.x += this.v;
        if (this.w < -3.4028235E38f) {
            this.w = 0.0f;
            this.x = 3.5f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.L) {
            return;
        }
        this.n = (this.b / 100.0f) * 0.8f;
        this.n = Math.max(0.05f, this.n);
        this.hIK.rewind();
        this.i.rewind();
        this.hIL.rewind();
        this.hIK.moveTo(0.0f, a(0, this.q, this.r, this.m, this.n, this.s, this.w));
        int i = 1;
        while (i <= this.q) {
            this.hIK.lineTo(i, a(i, this.q, this.r, this.m, this.n, this.s, this.w));
            i = (int) (i + h(getContext(), this.p));
        }
        this.hIK.lineTo(this.q, a(this.q, this.q, this.r, this.m, this.n, this.s, this.w));
        this.i.moveTo(this.q, a(this.q, this.q, this.r, this.m, this.n * 0.8f, this.hIM, this.x));
        int i2 = this.q - 1;
        while (i2 >= 0) {
            this.i.lineTo(i2, a(i2, this.q, this.r, this.m, this.n * 0.8f, this.hIM, this.x));
            i2 = (int) (i2 - h(getContext(), this.p));
        }
        this.i.lineTo(0.0f, a(0, this.q, this.r, this.m, this.n * 0.8f, this.hIM, this.x));
        this.hIL.addPath(this.hIK);
        this.hIL.addPath(this.i);
    }

    private void e() {
        this.b = 0.0f;
        this.a = 0.0f;
        this.c = 0L;
        this.w = 0.0f;
        this.x = 3.5f;
        this.A = false;
        this.B = false;
        this.L = true;
        this.I = 0;
        if (this.hIR != null) {
            this.hIR.recycle();
            this.hIR = null;
            this.hIS = null;
        }
    }

    private float h(Context context, float f) {
        return (context.getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.hIP != null) {
            this.hIP.a(true);
        }
        if (this.hIQ != null) {
            this.hIQ.removeMessages(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
        e();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.L) {
            if (this.hIN != null) {
                this.q = this.hIN.getWidth();
                this.r = this.hIN.getHeight();
            }
            if (this.q <= 0 || this.r <= 0) {
                return;
            }
            if (this.hIR == null) {
                this.hIR = Bitmap.createBitmap(this.q, this.r, Bitmap.Config.ARGB_8888);
                this.hIS = new Canvas(this.hIR);
            }
            b();
            this.L = false;
        }
        if (this.A) {
            canvas.drawColor(0);
            canvas.drawPath(this.hIL, this.f);
            canvas.drawPath(this.i, this.e);
            canvas.drawPath(this.hIK, this.d);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, this.q, this.r, null, 31);
        canvas.drawRect(this.I, 0.0f, this.q - this.I, this.r, this.g);
        this.g.setXfermode(this.hIT);
        if (this.hIR != null) {
            this.hIS.drawColor(0, PorterDuff.Mode.CLEAR);
            this.hIS.drawPath(this.hIL, this.f);
            this.hIS.drawPath(this.i, this.e);
            this.hIS.drawPath(this.hIK, this.d);
            canvas.drawBitmap(this.hIR, 0.0f, 0.0f, this.g);
        }
        this.g.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    public void setCallBack(c cVar) {
        this.hIO = cVar;
    }
}
