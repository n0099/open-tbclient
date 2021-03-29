package d.b.i0.i3.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f56281e;

    /* renamed from: f  reason: collision with root package name */
    public h f56282f;

    /* renamed from: g  reason: collision with root package name */
    public DressItemData f56283g;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.f56281e = tbPageContext;
        this.f56283g = dressItemData;
        this.f56282f = new h(tbPageContext);
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
        this.f56282f.d(this.f56283g);
        this.f56281e.getLayoutMode().j(this.f56282f.a());
        return this.f56282f.a();
    }
}
