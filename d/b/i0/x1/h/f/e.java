package d.b.i0.x1.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public View f62506a;

    /* renamed from: b  reason: collision with root package name */
    public View f62507b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62508c;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Integer f62509e;

        public a(Integer num) {
            this.f62509e = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            Integer num = this.f62509e;
            if (num == null || num.intValue() == 0) {
                return;
            }
            e.this.f62506a.setVisibility(0);
        }
    }

    public e(TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_simple_header, (ViewGroup) null);
        this.f62507b = inflate;
        View findViewById = inflate.findViewById(R.id.emotion_manage_item_header);
        this.f62506a = findViewById;
        findViewById.setVisibility(8);
        this.f62508c = (TextView) this.f62507b.findViewById(R.id.emotion_manage_total_title);
    }

    public View b() {
        return this.f62507b;
    }

    public void c(int i) {
        View view = this.f62507b;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i);
        }
        View view2 = this.f62506a;
        if (view2 != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i);
        }
        TextView textView = this.f62508c;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i);
        }
    }

    public void d(Integer num) {
        d.b.b.e.m.e.a().post(new a(num));
    }
}
