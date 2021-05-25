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
    public View f60667a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60668b;

    /* renamed from: c  reason: collision with root package name */
    public Context f60669c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60670d;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f60667a);
    }

    public View b(Context context) {
        this.f60669c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
        this.f60667a = inflate;
        inflate.setTag(this);
        this.f60670d = (TextView) this.f60667a.findViewById(R.id.tail_management_new_text);
        this.f60668b = (ImageView) this.f60667a.findViewById(R.id.tail_management_new_button);
        return this.f60667a;
    }

    public void c(View.OnClickListener onClickListener) {
        this.f60668b.setOnClickListener(onClickListener);
    }

    public void d(int i2) {
        this.f60670d.setText(String.format(this.f60669c.getString(R.string.tail_management_available), Integer.valueOf(i2)));
    }
}
