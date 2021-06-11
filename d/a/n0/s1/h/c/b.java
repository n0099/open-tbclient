package d.a.n0.s1.h.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f64358a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f64359b;

    /* renamed from: c  reason: collision with root package name */
    public Context f64360c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f64361d;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f64358a);
    }

    public View b(Context context) {
        this.f64360c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
        this.f64358a = inflate;
        inflate.setTag(this);
        this.f64361d = (TextView) this.f64358a.findViewById(R.id.tail_management_new_text);
        this.f64359b = (ImageView) this.f64358a.findViewById(R.id.tail_management_new_button);
        return this.f64358a;
    }

    public void c(View.OnClickListener onClickListener) {
        this.f64359b.setOnClickListener(onClickListener);
    }

    public void d(int i2) {
        this.f64361d.setText(String.format(this.f64360c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
    }
}
