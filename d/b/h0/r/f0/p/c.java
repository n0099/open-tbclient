package d.b.h0.r.f0.p;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
/* loaded from: classes3.dex */
public class c implements SpanWatcher {

    /* renamed from: e  reason: collision with root package name */
    public SpanGroupManager f50546e;

    /* renamed from: f  reason: collision with root package name */
    public int f50547f;

    /* renamed from: g  reason: collision with root package name */
    public int f50548g;

    public c(@NonNull SpanGroupManager spanGroupManager) {
        this.f50546e = spanGroupManager;
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        SpanGroupManager spanGroupManager = this.f50546e;
        if (spanGroupManager == null) {
            return;
        }
        if (obj == Selection.SELECTION_END && this.f50548g != i3) {
            this.f50548g = i3;
            a q = spanGroupManager.q(i3);
            if (q instanceof TbLinkSpanGroup) {
                int f2 = q.f();
                int c2 = q.c();
                if (Math.abs(this.f50548g - c2) <= Math.abs(this.f50548g - f2)) {
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
        if (obj != Selection.SELECTION_START || this.f50547f == i3) {
            return;
        }
        this.f50547f = i3;
        a q2 = this.f50546e.q(i3);
        if (q2 instanceof TbLinkSpanGroup) {
            int f3 = q2.f();
            int c3 = q2.c();
            if (Math.abs(this.f50547f - c3) <= Math.abs(this.f50547f - f3)) {
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
    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
    }
}
