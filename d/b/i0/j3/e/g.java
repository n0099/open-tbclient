package d.b.i0.j3.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f57728e;

    /* renamed from: f  reason: collision with root package name */
    public h f57729f;

    /* renamed from: g  reason: collision with root package name */
    public DressItemData f57730g;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.f57728e = tbPageContext;
        this.f57730g = dressItemData;
        this.f57729f = new h(tbPageContext);
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
        this.f57729f.d(this.f57730g);
        this.f57728e.getLayoutMode().j(this.f57729f.a());
        return this.f57729f.a();
    }
}
