package d.a.j0.j3.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f56136e;

    /* renamed from: f  reason: collision with root package name */
    public h f56137f;

    /* renamed from: g  reason: collision with root package name */
    public DressItemData f56138g;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.f56136e = tbPageContext;
        this.f56138g = dressItemData;
        this.f56137f = new h(tbPageContext);
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
        this.f56137f.d(this.f56138g);
        this.f56136e.getLayoutMode().j(this.f56137f.a());
        return this.f56137f.a();
    }
}
