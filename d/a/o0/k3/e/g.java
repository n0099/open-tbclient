package d.a.o0.k3.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f60837e;

    /* renamed from: f  reason: collision with root package name */
    public h f60838f;

    /* renamed from: g  reason: collision with root package name */
    public DressItemData f60839g;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.f60837e = tbPageContext;
        this.f60839g = dressItemData;
        this.f60838f = new h(tbPageContext);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        this.f60838f.d(this.f60839g);
        this.f60837e.getLayoutMode().j(this.f60838f.a());
        return this.f60838f.a();
    }
}
