package d.a.k0.r1.h.c;

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
    public View f60544a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60545b;

    /* renamed from: c  reason: collision with root package name */
    public Context f60546c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60547d;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f60544a);
    }

    public View b(Context context) {
        this.f60546c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
        this.f60544a = inflate;
        inflate.setTag(this);
        this.f60547d = (TextView) this.f60544a.findViewById(R.id.tail_management_new_text);
        this.f60545b = (ImageView) this.f60544a.findViewById(R.id.tail_management_new_button);
        return this.f60544a;
    }

    public void c(View.OnClickListener onClickListener) {
        this.f60545b.setOnClickListener(onClickListener);
    }

    public void d(int i2) {
        this.f60547d.setText(String.format(this.f60546c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
    }
}
