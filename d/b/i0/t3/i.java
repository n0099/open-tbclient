package d.b.i0.t3;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class i implements View.OnTouchListener {

    /* renamed from: e  reason: collision with root package name */
    public final Spannable f61189e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.b1.m.f f61190f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f61191g = 0;

    public i(Spannable spannable) {
        this.f61189e = spannable;
    }

    public void a(int i) {
        this.f61191g = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        d.b.h0.b1.m.f fVar;
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && (fVar = this.f61190f) != null) {
                fVar.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                view.invalidate();
                this.f61190f = null;
                return false;
            }
            if (action == 1 || action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                Layout layout = textView.getLayout();
                if (layout == null) {
                    return false;
                }
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - textView.getTotalPaddingTop()) + textView.getScrollY()), (x - textView.getTotalPaddingLeft()) + textView.getScrollX());
                Spannable spannable = this.f61189e;
                if (spannable == null) {
                    return false;
                }
                d.b.h0.b1.m.f[] fVarArr = (d.b.h0.b1.m.f[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, d.b.h0.b1.m.f.class);
                if (fVarArr != null && fVarArr.length != 0 && fVarArr[0] != null) {
                    if (action == 1) {
                        fVarArr[0].g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        fVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        d.b.h0.b1.m.f fVar2 = fVarArr[0];
                        this.f61190f = fVar2;
                        if (fVar2.e()) {
                            int i = this.f61191g;
                            if (i != 0) {
                                fVarArr[0].g(SkinManager.getColor(i));
                            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                fVarArr[0].g(SkinManager.getColor(R.color.CAM_X0204));
                            } else {
                                fVarArr[0].g(SkinManager.getColor(R.color.cp_bg_line_z));
                            }
                        }
                        Spannable spannable2 = this.f61189e;
                        Selection.setSelection(spannable2, spannable2.getSpanStart(fVarArr[0]), this.f61189e.getSpanEnd(fVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                d.b.h0.b1.m.f fVar3 = this.f61190f;
                if (fVar3 != null) {
                    fVar3.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view.invalidate();
                }
                Selection.removeSelection(this.f61189e);
            }
            return false;
        }
        return false;
    }
}
