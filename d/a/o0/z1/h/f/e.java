package d.a.o0.z1.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public View f67626a;

    /* renamed from: b  reason: collision with root package name */
    public View f67627b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67628c;

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Integer f67629e;

        public a(Integer num) {
            this.f67629e = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            Integer num = this.f67629e;
            if (num == null || num.intValue() == 0) {
                return;
            }
            e.this.f67626a.setVisibility(0);
        }
    }

    public e(TbPageContext tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_simple_header, (ViewGroup) null);
        this.f67627b = inflate;
        View findViewById = inflate.findViewById(R.id.emotion_manage_item_header);
        this.f67626a = findViewById;
        findViewById.setVisibility(8);
        this.f67628c = (TextView) this.f67627b.findViewById(R.id.emotion_manage_total_title);
    }

    public View b() {
        return this.f67627b;
    }

    public void c(int i2) {
        View view = this.f67627b;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i2);
        }
        View view2 = this.f67626a;
        if (view2 != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204, i2);
        }
        TextView textView = this.f67628c;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i2);
        }
    }

    public void d(Integer num) {
        d.a.c.e.m.e.a().post(new a(num));
    }
}
