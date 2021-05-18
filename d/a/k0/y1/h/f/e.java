package d.a.k0.y1.h.f;

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
    public View f63619a;

    /* renamed from: b  reason: collision with root package name */
    public View f63620b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63621c;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Integer f63622e;

        public a(Integer num) {
            this.f63622e = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            Integer num = this.f63622e;
            if (num == null || num.intValue() == 0) {
                return;
            }
            e.this.f63619a.setVisibility(0);
        }
    }

    public e(TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_simple_header, (ViewGroup) null);
        this.f63620b = inflate;
        View findViewById = inflate.findViewById(R.id.emotion_manage_item_header);
        this.f63619a = findViewById;
        findViewById.setVisibility(8);
        this.f63621c = (TextView) this.f63620b.findViewById(R.id.emotion_manage_total_title);
    }

    public View b() {
        return this.f63620b;
    }

    public void c(int i2) {
        View view = this.f63620b;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i2);
        }
        View view2 = this.f63619a;
        if (view2 != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i2);
        }
        TextView textView = this.f63621c;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
        }
    }

    public void d(Integer num) {
        d.a.c.e.m.e.a().post(new a(num));
    }
}
