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
    public static a f32390a = new a(40);

    /* renamed from: b  reason: collision with root package name */
    public String f32391b;

    /* renamed from: c  reason: collision with root package name */
    public float f32392c;

    /* renamed from: d  reason: collision with root package name */
    public int f32393d;

    /* renamed from: e  reason: collision with root package name */
    public float f32394e;

    /* renamed from: f  reason: collision with root package name */
    public int f32395f;

    /* renamed from: g  reason: collision with root package name */
    public float f32396g;

    /* renamed from: h  reason: collision with root package name */
    public float f32397h;
    public int i;
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
        public HandlerThread f32399a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f32400b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f32401c = new Object();

        /* renamed from: d  reason: collision with root package name */
        public List<WeakReference<b>> f32402d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public long f32403e;

        public a(long j) {
            this.f32403e = j;
            HandlerThread handlerThread = new HandlerThread("marquee");
            this.f32399a = handlerThread;
            handlerThread.start();
            this.f32400b = new Handler(this.f32399a.getLooper(), this);
        }

        private void c() {
            synchronized (this.f32401c) {
                for (WeakReference<b> weakReference : this.f32402d) {
                    b bVar = weakReference.get();
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            }
        }

        public void a() {
            this.f32400b.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.f32403e);
        }

        public void a(b bVar) {
            synchronized (this.f32401c) {
                if (this.f32402d.size() == 0) {
                    a();
                }
                boolean z = false;
                Iterator<WeakReference<b>> it = this.f32402d.iterator();
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
                    this.f32402d.add(new WeakReference<>(bVar));
                }
            }
        }

        public void b() {
            this.f32400b.removeMessages(0);
        }

        public void b(b bVar) {
            synchronized (this.f32401c) {
                Iterator<WeakReference<b>> it = this.f32402d.iterator();
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
                if (this.f32402d.size() == 0) {
                    b();
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 0) {
                if (this.f32402d.size() > 0) {
                    try {
                        c();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                this.f32400b.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.f32403e);
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

    public MarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32392c = 1.0f;
        this.f32393d = -16777216;
        this.f32394e = 12.0f;
        this.f32395f = 1;
        this.f32396g = 1.0f;
        this.f32397h = 0.0f;
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
                MarqueeView.this.f32397h -= MarqueeView.this.f32392c;
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
        this.k.setColor(this.f32393d);
        this.k.setTextSize(ao.a(getContext(), this.f32394e));
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
        f32390a.a(this.r);
        this.j = true;
    }

    public void b() {
        this.j = false;
        f32390a.b(this.r);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.o) {
            float f2 = this.f32396g;
            if (f2 < 0.0f) {
                this.f32396g = 0.0f;
            } else if (f2 > 1.0f) {
                this.f32396g = 1.0f;
            }
            this.f32397h = getWidth() * this.f32396g;
            this.o = false;
        }
        int i = this.f32395f;
        if (i != 1) {
            if (i == 2) {
                float f3 = this.f32397h;
                if (f3 < 0.0f) {
                    int i2 = (int) ((-f3) / this.i);
                    int i3 = this.n;
                    if (i2 >= i3) {
                        this.n = i3 + 1;
                        this.f32391b += this.p;
                    }
                }
            } else if (this.i < (-this.f32397h)) {
                b();
            }
        } else if (this.i <= (-this.f32397h)) {
            this.f32397h = getWidth();
        }
        String str = this.f32391b;
        if (str != null) {
            canvas.drawText(str, this.f32397h, (getHeight() / 2.0f) + (this.q / 2.0f), this.k);
        }
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f32397h = getWidth() * this.f32396g;
        if (!str.endsWith("")) {
            str = str + "";
        }
        this.p = str;
        int i = this.f32395f;
        if (i == 2) {
            this.i = (int) (a(str) + this.m);
            this.n = 0;
            int width = (getWidth() / this.i) + 2;
            this.f32391b = "";
            StringBuilder sb = new StringBuilder("");
            for (int i2 = 0; i2 <= width; i2++) {
                sb.append(this.p);
            }
            str = sb.toString();
        } else {
            float f2 = this.f32397h;
            if (f2 < 0.0f && i == 0 && (-f2) > this.i) {
                this.f32397h = getWidth() * this.f32396g;
            }
            this.i = (int) a(this.p);
        }
        this.f32391b = str;
    }

    public void setRepetType(int i) {
        this.f32395f = i;
        this.o = true;
        setContent(this.p);
    }

    public void setStartLocationDistance(float f2) {
        this.f32396g = f2;
    }

    public void setTextColor(int i) {
        if (i != 0) {
            this.f32393d = i;
            this.k.setColor(i);
        }
    }

    public void setTextDistance(int i) {
        float blacktWidth = getBlacktWidth();
        int a2 = (int) (ao.a(getContext(), i) / blacktWidth);
        if (a2 == 0) {
            a2 = 1;
        }
        this.m = (int) (blacktWidth * a2);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 <= a2; i2++) {
            sb.append(" ");
        }
        setContent(sb.toString());
    }

    public void setTextSize(float f2) {
        if (f2 > 0.0f) {
            this.f32394e = f2;
            this.k.setTextSize(ao.a(getContext(), f2));
            this.i = (int) (a(this.p) + this.m);
        }
    }

    public void setTextSpeed(float f2) {
        this.f32392c = f2;
    }
}
