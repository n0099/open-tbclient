package d.b.j0.j3.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f58149e;

    /* renamed from: f  reason: collision with root package name */
    public h f58150f;

    /* renamed from: g  reason: collision with root package name */
    public DressItemData f58151g;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.f58149e = tbPageContext;
        this.f58151g = dressItemData;
        this.f58150f = new h(tbPageContext);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        this.f58150f.d(this.f58151g);
        this.f58149e.getLayoutMode().j(this.f58150f.a());
        return this.f58150f.a();
    }
}
