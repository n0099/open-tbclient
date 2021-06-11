package d.a.m0.r.f0.p;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
/* loaded from: classes3.dex */
public class c implements SpanWatcher {

    /* renamed from: e  reason: collision with root package name */
    public SpanGroupManager f53450e;

    /* renamed from: f  reason: collision with root package name */
    public int f53451f;

    /* renamed from: g  reason: collision with root package name */
    public int f53452g;

    public c(@NonNull SpanGroupManager spanGroupManager) {
        this.f53450e = spanGroupManager;
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
        SpanGroupManager spanGroupManager = this.f53450e;
        if (spanGroupManager == null) {
            return;
        }
        if (obj == Selection.SELECTION_END && this.f53452g != i4) {
            this.f53452g = i4;
            a q = spanGroupManager.q(i4);
            if (q instanceof TbLinkSpanGroup) {
                int f2 = q.f();
                int c2 = q.c();
                if (Math.abs(this.f53452g - c2) <= Math.abs(this.f53452g - f2)) {
                    f2 = c2;
                }
                int selectionStart = Selection.getSelectionStart(spannable);
                if (selectionStart > spannable.length()) {
                    selectionStart = spannable.length();
                }
                if (f2 > spannable.length()) {
                    f2 = spannable.length();
                }
                Selection.setSelection(spannable, selectionStart, f2);
            }
        }
        if (obj != Selection.SELECTION_START || this.f53451f == i4) {
            return;
        }
        this.f53451f = i4;
        a q2 = this.f53450e.q(i4);
        if (q2 instanceof TbLinkSpanGroup) {
            int f3 = q2.f();
            int c3 = q2.c();
            if (Math.abs(this.f53451f - c3) <= Math.abs(this.f53451f - f3)) {
                f3 = c3;
            }
            int selectionEnd = Selection.getSelectionEnd(spannable);
            if (selectionEnd > spannable.length()) {
                selectionEnd = spannable.length();
            }
            if (f3 > spannable.length()) {
                f3 = spannable.length();
            }
            Selection.setSelection(spannable, f3, selectionEnd);
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
    }
}
