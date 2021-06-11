package com.kwad.sdk.contentalliance.detail.photo.newui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.utils.ao;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class MarqueeView extends View {

    /* renamed from: a  reason: collision with root package name */
    public static a f32962a = new a(40);

    /* renamed from: b  reason: collision with root package name */
    public String f32963b;

    /* renamed from: c  reason: collision with root package name */
    public float f32964c;

    /* renamed from: d  reason: collision with root package name */
    public int f32965d;

    /* renamed from: e  reason: collision with root package name */
    public float f32966e;

    /* renamed from: f  reason: collision with root package name */
    public int f32967f;

    /* renamed from: g  reason: collision with root package name */
    public float f32968g;

    /* renamed from: h  reason: collision with root package name */
    public float f32969h;

    /* renamed from: i  reason: collision with root package name */
    public int f32970i;
    public boolean j;
    public TextPaint k;
    public Rect l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public float q;
    public b r;

    /* loaded from: classes6.dex */
    public static class a implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        public HandlerThread f32972a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f32973b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f32974c = new Object();

        /* renamed from: d  reason: collision with root package name */
        public List<WeakReference<b>> f32975d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public long f32976e;

        public a(long j) {
            this.f32976e = j;
            HandlerThread handlerThread = new HandlerThread("marquee");
            this.f32972a = handlerThread;
            handlerThread.start();
            this.f32973b = new Handler(this.f32972a.getLooper(), this);
        }

        private void c() {
            synchronized (this.f32974c) {
                for (WeakReference<b> weakReference : this.f32975d) {
                    b bVar = weakReference.get();
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            }
        }

        public void a() {
            this.f32973b.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.f32976e);
        }

        public void a(b bVar) {
            synchronized (this.f32974c) {
                if (this.f32975d.size() == 0) {
                    a();
                }
                boolean z = false;
                Iterator<WeakReference<b>> it = this.f32975d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<b> next = it.next();
                    if (next.get() == null) {
                        it.remove();
                    } else if (next.get() == bVar) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f32975d.add(new WeakReference<>(bVar));
                }
            }
        }

        public void b() {
            this.f32973b.removeMessages(0);
        }

        public void b(b bVar) {
            synchronized (this.f32974c) {
                Iterator<WeakReference<b>> it = this.f32975d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<b> next = it.next();
                    if (next.get() == null) {
                        it.remove();
                    } else if (next.get().equals(bVar)) {
                        it.remove();
                        break;
                    }
                }
                if (this.f32975d.size() == 0) {
                    b();
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 0) {
                if (this.f32975d.size() > 0) {
                    try {
                        c();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                this.f32973b.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.f32976e);
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f32964c = 1.0f;
        this.f32965d = -16777216;
        this.f32966e = 12.0f;
        this.f32967f = 1;
        this.f32968g = 1.0f;
        this.f32969h = 0.0f;
        this.j = false;
        this.n = 0;
        this.o = true;
        this.p = "";
        this.r = new b() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.MarqueeView.1
            @Override // com.kwad.sdk.contentalliance.detail.photo.newui.MarqueeView.b
            public void a() {
                if (!MarqueeView.this.j || TextUtils.isEmpty(MarqueeView.this.p)) {
                    return;
                }
                MarqueeView.this.f32969h -= MarqueeView.this.f32964c;
                MarqueeView.this.postInvalidate();
            }
        };
        c();
    }

    private float a(String str) {
        if (str == null || str.equals("")) {
            return 0.0f;
        }
        if (this.l == null) {
            this.l = new Rect();
        }
        this.k.getTextBounds(str, 0, str.length(), this.l);
        this.q = getContentHeight();
        return this.l.width();
    }

    private void c() {
        this.l = new Rect();
        TextPaint textPaint = new TextPaint(1);
        this.k = textPaint;
        textPaint.setStyle(Paint.Style.FILL);
        this.k.setColor(this.f32965d);
        this.k.setTextSize(ao.a(getContext(), this.f32966e));
    }

    private float getBlacktWidth() {
        return a("en en") - a("enen");
    }

    private float getContentHeight() {
        Paint.FontMetrics fontMetrics = this.k.getFontMetrics();
        return Math.abs(fontMetrics.bottom - fontMetrics.top) / 2.0f;
    }

    public void a() {
        if (this.j) {
            return;
        }
        f32962a.a(this.r);
        this.j = true;
    }

    public void b() {
        this.j = false;
        f32962a.b(this.r);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.o) {
            float f2 = this.f32968g;
            if (f2 < 0.0f) {
                this.f32968g = 0.0f;
            } else if (f2 > 1.0f) {
                this.f32968g = 1.0f;
            }
            this.f32969h = getWidth() * this.f32968g;
            this.o = false;
        }
        int i2 = this.f32967f;
        if (i2 != 1) {
            if (i2 == 2) {
                float f3 = this.f32969h;
                if (f3 < 0.0f) {
                    int i3 = (int) ((-f3) / this.f32970i);
                    int i4 = this.n;
                    if (i3 >= i4) {
                        this.n = i4 + 1;
                        this.f32963b += this.p;
                    }
                }
            } else if (this.f32970i < (-this.f32969h)) {
                b();
            }
        } else if (this.f32970i <= (-this.f32969h)) {
            this.f32969h = getWidth();
        }
        String str = this.f32963b;
        if (str != null) {
            canvas.drawText(str, this.f32969h, (getHeight() / 2.0f) + (this.q / 2.0f), this.k);
        }
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f32969h = getWidth() * this.f32968g;
        if (!str.endsWith("")) {
            str = str + "";
        }
        this.p = str;
        int i2 = this.f32967f;
        if (i2 == 2) {
            this.f32970i = (int) (a(str) + this.m);
            this.n = 0;
            int width = (getWidth() / this.f32970i) + 2;
            this.f32963b = "";
            StringBuilder sb = new StringBuilder("");
            for (int i3 = 0; i3 <= width; i3++) {
                sb.append(this.p);
            }
            str = sb.toString();
        } else {
            float f2 = this.f32969h;
            if (f2 < 0.0f && i2 == 0 && (-f2) > this.f32970i) {
                this.f32969h = getWidth() * this.f32968g;
            }
            this.f32970i = (int) a(this.p);
        }
        this.f32963b = str;
    }

    public void setRepetType(int i2) {
        this.f32967f = i2;
        this.o = true;
        setContent(this.p);
    }

    public void setStartLocationDistance(float f2) {
        this.f32968g = f2;
    }

    public void setTextColor(int i2) {
        if (i2 != 0) {
            this.f32965d = i2;
            this.k.setColor(i2);
        }
    }

    public void setTextDistance(int i2) {
        float blacktWidth = getBlacktWidth();
        int a2 = (int) (ao.a(getContext(), i2) / blacktWidth);
        if (a2 == 0) {
            a2 = 1;
        }
        this.m = (int) (blacktWidth * a2);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 <= a2; i3++) {
            sb.append(" ");
        }
        setContent(sb.toString());
    }

    public void setTextSize(float f2) {
        if (f2 > 0.0f) {
            this.f32966e = f2;
            this.k.setTextSize(ao.a(getContext(), f2));
            this.f32970i = (int) (a(this.p) + this.m);
        }
    }

    public void setTextSpeed(float f2) {
        this.f32964c = f2;
    }
}
