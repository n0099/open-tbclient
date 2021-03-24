package d.b.i0.q1.h.c;

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
    public View f59527a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59528b;

    /* renamed from: c  reason: collision with root package name */
    public Context f59529c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59530d;

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f59527a);
    }

    public View b(Context context) {
        this.f59529c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.tail_management_add_item, (ViewGroup) null);
        this.f59527a = inflate;
        inflate.setTag(this);
        this.f59530d = (TextView) this.f59527a.findViewById(R.id.tail_management_new_text);
        this.f59528b = (ImageView) this.f59527a.findViewById(R.id.tail_management_new_button);
        return this.f59527a;
    }

    public void c(View.OnClickListener onClickListener) {
        this.f59528b.setOnClickListener(onClickListener);
    }

    public void d(int i) {
        this.f59530d.setText(String.format(this.f59529c.getString(R.string.tail_management_available), Integer.valueOf(i)));
    }
}
