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
    public static c f66077f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.b1.m.f f66078a;

    /* renamed from: b  reason: collision with root package name */
    public int f66079b;

    /* renamed from: c  reason: collision with root package name */
    public int f66080c;

    /* renamed from: d  reason: collision with root package name */
    public long f66081d;

    /* renamed from: e  reason: collision with root package name */
    public int f66082e = -1;

    public static c a() {
        if (f66077f == null) {
            f66077f = new c();
        }
        return f66077f;
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
                return this.f66078a;
            }
        }
        return this.f66078a;
    }

    public void d(int i2) {
        this.f66082e = i2;
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
            this.f66078a = b2;
        }
        int i2 = this.f66082e;
        if (i2 > -1) {
            this.f66078a.g(i2);
        }
        if (motionEvent.getAction() == 0) {
            this.f66079b = (int) motionEvent.getX();
            this.f66080c = (int) motionEvent.getY();
            this.f66081d = System.currentTimeMillis();
            d.a.m0.b1.m.f fVar = this.f66078a;
            if (fVar != null) {
                fVar.h(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.f66078a), spannable.getSpanEnd(this.f66078a));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.f66078a != null && (Math.abs(this.f66079b - motionEvent.getX()) > 20.0f || Math.abs(this.f66080c - motionEvent.getY()) > 20.0f)) {
                this.f66078a.h(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            d.a.m0.b1.m.f fVar2 = this.f66078a;
            if (fVar2 != null) {
                fVar2.h(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
            if (c(this.f66079b, this.f66080c, motionEvent.getX(), motionEvent.getY(), this.f66081d, System.currentTimeMillis(), 500L)) {
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
