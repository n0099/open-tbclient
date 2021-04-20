package d.b.i0.r1.h.c;

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
    public View f61222a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f61223b;

    /* renamed from: c  reason: collision with root package name */
    public Context f61224c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61225d;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f61222a);
    }

    public View b(Context context) {
        this.f61224c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
        this.f61222a = inflate;
        inflate.setTag(this);
        this.f61225d = (TextView) this.f61222a.findViewById(R.id.tail_management_new_text);
        this.f61223b = (ImageView) this.f61222a.findViewById(R.id.tail_management_new_button);
        return this.f61222a;
    }

    public void c(View.OnClickListener onClickListener) {
        this.f61223b.setOnClickListener(onClickListener);
    }

    public void d(int i) {
        this.f61225d.setText(String.format(this.f61224c.getString(R.string.tail_management_available), Integer.valueOf(i)));
    }
}
