package d.a.o0.s1.h.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public View f64483a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f64484b;

    /* renamed from: c  reason: collision with root package name */
    public Context f64485c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f64486d;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f64483a);
    }

    public View b(Context context) {
        this.f64485c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
        this.f64483a = inflate;
        inflate.setTag(this);
        this.f64486d = (TextView) this.f64483a.findViewById(R.id.tail_management_new_text);
        this.f64484b = (ImageView) this.f64483a.findViewById(R.id.tail_management_new_button);
        return this.f64483a;
    }

    public void c(View.OnClickListener onClickListener) {
        this.f64484b.setOnClickListener(onClickListener);
    }

    public void d(int i2) {
        this.f64486d.setText(String.format(this.f64485c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
    }
}
