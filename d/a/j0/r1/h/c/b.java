package d.a.j0.r1.h.c;

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
    public View f59799a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59800b;

    /* renamed from: c  reason: collision with root package name */
    public Context f59801c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59802d;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f59799a);
    }

    public View b(Context context) {
        this.f59801c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
        this.f59799a = inflate;
        inflate.setTag(this);
        this.f59802d = (TextView) this.f59799a.findViewById(R.id.tail_management_new_text);
        this.f59800b = (ImageView) this.f59799a.findViewById(R.id.tail_management_new_button);
        return this.f59799a;
    }

    public void c(View.OnClickListener onClickListener) {
        this.f59800b.setOnClickListener(onClickListener);
    }

    public void d(int i2) {
        this.f59802d.setText(String.format(this.f59801c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
    }
}
