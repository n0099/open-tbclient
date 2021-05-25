package d.a.n0.v3;

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
    public static c f62362f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.b1.m.f f62363a;

    /* renamed from: b  reason: collision with root package name */
    public int f62364b;

    /* renamed from: c  reason: collision with root package name */
    public int f62365c;

    /* renamed from: d  reason: collision with root package name */
    public long f62366d;

    /* renamed from: e  reason: collision with root package name */
    public int f62367e = -1;

    public static c a() {
        if (f62362f == null) {
            f62362f = new c();
        }
        return f62362f;
    }

    public static boolean c(float f2, float f3, float f4, float f5, long j, long j2, long j3) {
        return Math.abs(f4 - f2) <= 100.0f && Math.abs(f5 - f3) <= 100.0f && j2 - j >= j3;
    }

    public final d.a.m0.b1.m.f b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() != 3) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            try {
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                d.a.m0.b1.m.f[] fVarArr = (d.a.m0.b1.m.f[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, d.a.m0.b1.m.f.class);
                if (fVarArr == null || fVarArr.length <= 0 || fVarArr[0] == null) {
                    return null;
                }
                return fVarArr[0];
            } catch (Exception e2) {
                BdLog.e(e2);
                return this.f62363a;
            }
        }
        return this.f62363a;
    }

    public void d(int i2) {
        this.f62367e = i2;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        d.a.m0.b1.m.f b2 = b(textView, spannable, motionEvent);
        if (b2 == null && motionEvent.getAction() == 0) {
            try {
                return super.onTouchEvent(textView, spannable, motionEvent);
            } catch (Exception e2) {
                BdLog.e(e2);
                return true;
            }
        }
        if (b2 != null) {
            this.f62363a = b2;
        }
        int i2 = this.f62367e;
        if (i2 > -1) {
            this.f62363a.g(i2);
        }
        if (motionEvent.getAction() == 0) {
            this.f62364b = (int) motionEvent.getX();
            this.f62365c = (int) motionEvent.getY();
            this.f62366d = System.currentTimeMillis();
            d.a.m0.b1.m.f fVar = this.f62363a;
            if (fVar != null) {
                fVar.h(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.f62363a), spannable.getSpanEnd(this.f62363a));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.f62363a != null && (Math.abs(this.f62364b - motionEvent.getX()) > 20.0f || Math.abs(this.f62365c - motionEvent.getY()) > 20.0f)) {
                this.f62363a.h(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            d.a.m0.b1.m.f fVar2 = this.f62363a;
            if (fVar2 != null) {
                fVar2.h(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
            if (c(this.f62364b, this.f62365c, motionEvent.getX(), motionEvent.getY(), this.f62366d, System.currentTimeMillis(), 500L)) {
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
