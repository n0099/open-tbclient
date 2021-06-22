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
    public static a f33060a = new a(40);

    /* renamed from: b  reason: collision with root package name */
    public String f33061b;

    /* renamed from: c  reason: collision with root package name */
    public float f33062c;

    /* renamed from: d  reason: collision with root package name */
    public int f33063d;

    /* renamed from: e  reason: collision with root package name */
    public float f33064e;

    /* renamed from: f  reason: collision with root package name */
    public int f33065f;

    /* renamed from: g  reason: collision with root package name */
    public float f33066g;

    /* renamed from: h  reason: collision with root package name */
    public float f33067h;

    /* renamed from: i  reason: collision with root package name */
    public int f33068i;
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
        public HandlerThread f33070a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f33071b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f33072c = new Object();

        /* renamed from: d  reason: collision with root package name */
        public List<WeakReference<b>> f33073d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public long f33074e;

        public a(long j) {
            this.f33074e = j;
            HandlerThread handlerThread = new HandlerThread("marquee");
            this.f33070a = handlerThread;
            handlerThread.start();
            this.f33071b = new Handler(this.f33070a.getLooper(), this);
        }

        private void c() {
            synchronized (this.f33072c) {
                for (WeakReference<b> weakReference : this.f33073d) {
                    b bVar = weakReference.get();
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            }
        }

        public void a() {
            this.f33071b.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.f33074e);
        }

        public void a(b bVar) {
            synchronized (this.f33072c) {
                if (this.f33073d.size() == 0) {
                    a();
                }
                boolean z = false;
                Iterator<WeakReference<b>> it = this.f33073d.iterator();
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
                    this.f33073d.add(new WeakReference<>(bVar));
                }
            }
        }

        public void b() {
            this.f33071b.removeMessages(0);
        }

        public void b(b bVar) {
            synchronized (this.f33072c) {
                Iterator<WeakReference<b>> it = this.f33073d.iterator();
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
                if (this.f33073d.size() == 0) {
                    b();
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 0) {
                if (this.f33073d.size() > 0) {
                    try {
                        c();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                this.f33071b.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.f33074e);
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
        this.f33062c = 1.0f;
        this.f33063d = -16777216;
        this.f33064e = 12.0f;
        this.f33065f = 1;
        this.f33066g = 1.0f;
        this.f33067h = 0.0f;
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
                MarqueeView.this.f33067h -= MarqueeView.this.f33062c;
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
        this.k.setColor(this.f33063d);
        this.k.setTextSize(ao.a(getContext(), this.f33064e));
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
        f33060a.a(this.r);
        this.j = true;
    }

    public void b() {
        this.j = false;
        f33060a.b(this.r);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.o) {
            float f2 = this.f33066g;
            if (f2 < 0.0f) {
                this.f33066g = 0.0f;
            } else if (f2 > 1.0f) {
                this.f33066g = 1.0f;
            }
            this.f33067h = getWidth() * this.f33066g;
            this.o = false;
        }
        int i2 = this.f33065f;
        if (i2 != 1) {
            if (i2 == 2) {
                float f3 = this.f33067h;
                if (f3 < 0.0f) {
                    int i3 = (int) ((-f3) / this.f33068i);
                    int i4 = this.n;
                    if (i3 >= i4) {
                        this.n = i4 + 1;
                        this.f33061b += this.p;
                    }
                }
            } else if (this.f33068i < (-this.f33067h)) {
                b();
            }
        } else if (this.f33068i <= (-this.f33067h)) {
            this.f33067h = getWidth();
        }
        String str = this.f33061b;
        if (str != null) {
            canvas.drawText(str, this.f33067h, (getHeight() / 2.0f) + (this.q / 2.0f), this.k);
        }
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f33067h = getWidth() * this.f33066g;
        if (!str.endsWith("")) {
            str = str + "";
        }
        this.p = str;
        int i2 = this.f33065f;
        if (i2 == 2) {
            this.f33068i = (int) (a(str) + this.m);
            this.n = 0;
            int width = (getWidth() / this.f33068i) + 2;
            this.f33061b = "";
            StringBuilder sb = new StringBuilder("");
            for (int i3 = 0; i3 <= width; i3++) {
                sb.append(this.p);
            }
            str = sb.toString();
        } else {
            float f2 = this.f33067h;
            if (f2 < 0.0f && i2 == 0 && (-f2) > this.f33068i) {
                this.f33067h = getWidth() * this.f33066g;
            }
            this.f33068i = (int) a(this.p);
        }
        this.f33061b = str;
    }

    public void setRepetType(int i2) {
        this.f33065f = i2;
        this.o = true;
        setContent(this.p);
    }

    public void setStartLocationDistance(float f2) {
        this.f33066g = f2;
    }

    public void setTextColor(int i2) {
        if (i2 != 0) {
            this.f33063d = i2;
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
            this.f33064e = f2;
            this.k.setTextSize(ao.a(getContext(), f2));
            this.f33068i = (int) (a(this.p) + this.m);
        }
    }

    public void setTextSpeed(float f2) {
        this.f33062c = f2;
    }
}
