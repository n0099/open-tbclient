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
import androidx.core.view.ViewCompat;
import com.kwad.sdk.utils.ao;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class MarqueeView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static a f8528a = new a(40);

    /* renamed from: b  reason: collision with root package name */
    private String f8529b;
    private float c;
    private int d;
    private float e;
    private int f;
    private float g;
    private float h;
    private int i;
    private boolean j;
    private TextPaint k;
    private Rect l;
    private int m;
    private int n;
    private boolean o;
    private String p;
    private float q;
    private b r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        private Handler f8532b;
        private long e;
        private final Object c = new Object();
        private List<WeakReference<b>> d = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        private HandlerThread f8531a = new HandlerThread("marquee");

        a(long j) {
            this.e = j;
            this.f8531a.start();
            this.f8532b = new Handler(this.f8531a.getLooper(), this);
        }

        private void c() {
            synchronized (this.c) {
                for (WeakReference<b> weakReference : this.d) {
                    b bVar = weakReference.get();
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            }
        }

        public void a() {
            this.f8532b.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.e);
        }

        void a(b bVar) {
            boolean z;
            synchronized (this.c) {
                if (this.d.size() == 0) {
                    a();
                }
                Iterator<WeakReference<b>> it = this.d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
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
                    this.d.add(new WeakReference<>(bVar));
                }
            }
        }

        public void b() {
            this.f8532b.removeMessages(0);
        }

        void b(b bVar) {
            synchronized (this.c) {
                Iterator<WeakReference<b>> it = this.d.iterator();
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
                if (this.d.size() == 0) {
                    b();
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 0) {
                if (this.d.size() > 0) {
                    try {
                        c();
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
                this.f8532b.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.e);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
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
        this.c = 1.0f;
        this.d = ViewCompat.MEASURED_STATE_MASK;
        this.e = 12.0f;
        this.f = 1;
        this.g = 1.0f;
        this.h = 0.0f;
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
                MarqueeView.this.h -= MarqueeView.this.c;
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
        this.k = new TextPaint(1);
        this.k.setStyle(Paint.Style.FILL);
        this.k.setColor(this.d);
        this.k.setTextSize(ao.a(getContext(), this.e));
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
        f8528a.a(this.r);
        this.j = true;
    }

    public void b() {
        this.j = false;
        f8528a.b(this.r);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.o) {
            if (this.g < 0.0f) {
                this.g = 0.0f;
            } else if (this.g > 1.0f) {
                this.g = 1.0f;
            }
            this.h = getWidth() * this.g;
            this.o = false;
        }
        switch (this.f) {
            case 1:
                if (this.i <= (-this.h)) {
                    this.h = getWidth();
                    break;
                }
                break;
            case 2:
                if (this.h < 0.0f && ((int) ((-this.h) / this.i)) >= this.n) {
                    this.n++;
                    this.f8529b += this.p;
                    break;
                }
                break;
            default:
                if (this.i < (-this.h)) {
                    b();
                    break;
                }
                break;
        }
        if (this.f8529b != null) {
            canvas.drawText(this.f8529b, this.h, (getHeight() / 2.0f) + (this.q / 2.0f), this.k);
        }
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.h = getWidth() * this.g;
        if (!str.endsWith("")) {
            str = str + "";
        }
        this.p = str;
        if (this.f != 2) {
            if (this.h < 0.0f && this.f == 0 && (-this.h) > this.i) {
                this.h = getWidth() * this.g;
            }
            this.i = (int) a(this.p);
            this.f8529b = str;
            return;
        }
        this.i = (int) (a(this.p) + this.m);
        this.n = 0;
        int width = (getWidth() / this.i) + 2;
        this.f8529b = "";
        StringBuilder sb = new StringBuilder(this.f8529b);
        for (int i = 0; i <= width; i++) {
            sb.append(this.p);
        }
        this.f8529b = sb.toString();
    }

    public void setRepetType(int i) {
        this.f = i;
        this.o = true;
        setContent(this.p);
    }

    public void setStartLocationDistance(float f) {
        this.g = f;
    }

    public void setTextColor(int i) {
        if (i != 0) {
            this.d = i;
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

    public void setTextSize(float f) {
        if (f > 0.0f) {
            this.e = f;
            this.k.setTextSize(ao.a(getContext(), f));
            this.i = (int) (a(this.p) + this.m);
        }
    }

    public void setTextSpeed(float f) {
        this.c = f;
    }
}
