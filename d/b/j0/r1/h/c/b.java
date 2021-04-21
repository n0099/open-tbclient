package d.b.j0.r1.h.c;

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
    public View f61643a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f61644b;

    /* renamed from: c  reason: collision with root package name */
    public Context f61645c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61646d;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f61643a);
    }

    public View b(Context context) {
        this.f61645c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
        this.f61643a = inflate;
        inflate.setTag(this);
        this.f61646d = (TextView) this.f61643a.findViewById(R.id.tail_management_new_text);
        this.f61644b = (ImageView) this.f61643a.findViewById(R.id.tail_management_new_button);
        return this.f61643a;
    }

    public void c(View.OnClickListener onClickListener) {
        this.f61644b.setOnClickListener(onClickListener);
    }

    public void d(int i) {
        this.f61646d.setText(String.format(this.f61645c.getString(R.string.tail_management_available), Integer.valueOf(i)));
    }
}
