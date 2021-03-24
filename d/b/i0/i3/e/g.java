package d.b.i0.i3.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f56280e;

    /* renamed from: f  reason: collision with root package name */
    public h f56281f;

    /* renamed from: g  reason: collision with root package name */
    public DressItemData f56282g;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.f56280e = tbPageContext;
        this.f56282g = dressItemData;
        this.f56281f = new h(tbPageContext);
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
        this.f56281f.d(this.f56282g);
        this.f56280e.getLayoutMode().j(this.f56281f.a());
        return this.f56281f.a();
    }
}
