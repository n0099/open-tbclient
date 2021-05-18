package d.a.k0.j3.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f56843e;

    /* renamed from: f  reason: collision with root package name */
    public h f56844f;

    /* renamed from: g  reason: collision with root package name */
    public DressItemData f56845g;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.f56843e = tbPageContext;
        this.f56845g = dressItemData;
        this.f56844f = new h(tbPageContext);
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
        this.f56844f.d(this.f56845g);
        this.f56843e.getLayoutMode().j(this.f56844f.a());
        return this.f56844f.a();
    }
}
