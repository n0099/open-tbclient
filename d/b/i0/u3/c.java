package d.b.i0.u3;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes5.dex */
public class c extends LinkMovementMethod {

    /* renamed from: f  reason: collision with root package name */
    public static c f62838f;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.b1.m.f f62839a;

    /* renamed from: b  reason: collision with root package name */
    public int f62840b;

    /* renamed from: c  reason: collision with root package name */
    public int f62841c;

    /* renamed from: d  reason: collision with root package name */
    public long f62842d;

    /* renamed from: e  reason: collision with root package name */
    public int f62843e = -1;

    public static c a() {
        if (f62838f == null) {
            f62838f = new c();
        }
        return f62838f;
    }

    public static boolean c(float f2, float f3, float f4, float f5, long j, long j2, long j3) {
        return Math.abs(f4 - f2) <= 100.0f && Math.abs(f5 - f3) <= 100.0f && j2 - j >= j3;
    }

    public final d.b.h0.b1.m.f b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() != 3) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            try {
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                d.b.h0.b1.m.f[] fVarArr = (d.b.h0.b1.m.f[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, d.b.h0.b1.m.f.class);
                if (fVarArr == null || fVarArr.length <= 0 || fVarArr[0] == null) {
                    return null;
                }
                return fVarArr[0];
            } catch (Exception e2) {
                BdLog.e(e2);
                return this.f62839a;
            }
        }
        return this.f62839a;
    }

    public void d(int i) {
        this.f62843e = i;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        d.b.h0.b1.m.f b2 = b(textView, spannable, motionEvent);
        if (b2 == null && motionEvent.getAction() == 0) {
            try {
                return super.onTouchEvent(textView, spannable, motionEvent);
            } catch (Exception e2) {
                BdLog.e(e2);
                return true;
            }
        }
        if (b2 != null) {
            this.f62839a = b2;
        }
        int i = this.f62843e;
        if (i > -1) {
            this.f62839a.g(i);
        }
        if (motionEvent.getAction() == 0) {
            this.f62840b = (int) motionEvent.getX();
            this.f62841c = (int) motionEvent.getY();
            this.f62842d = System.currentTimeMillis();
            d.b.h0.b1.m.f fVar = this.f62839a;
            if (fVar != null) {
                fVar.h(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.f62839a), spannable.getSpanEnd(this.f62839a));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.f62839a != null && (Math.abs(this.f62840b - motionEvent.getX()) > 20.0f || Math.abs(this.f62841c - motionEvent.getY()) > 20.0f)) {
                this.f62839a.h(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            d.b.h0.b1.m.f fVar2 = this.f62839a;
            if (fVar2 != null) {
                fVar2.h(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
            if (c(this.f62840b, this.f62841c, motionEvent.getX(), motionEvent.getY(), this.f62842d, System.currentTimeMillis(), 500L)) {
                return true;
            }
        }
        try {
            return super.onTouchEvent(textView, spannable, motionEvent);
        } catch (Exception e3) {
            BdLog.e(e3);
            return true;
        }
    }
}
