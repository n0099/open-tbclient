package d.a.k0.e2.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pbextra.praise.PraiseListActivity;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BaseAdapter implements AbsListView.OnScrollListener {

    /* renamed from: e  reason: collision with root package name */
    public PraiseListActivity f54653e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f54654f = null;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f54655g;

    public c(PraiseListActivity praiseListActivity) {
        this.f54653e = null;
        this.f54653e = praiseListActivity;
    }

    public final View a(int i2, View view, ViewGroup viewGroup) {
        b b2 = b.b(this.f54653e.getPageContext().getPageActivity(), view);
        a item = getItem(i2);
        b2.c(StringUtils.isNull(item.b()) ? item.d() : item.b(), item.a(), item.e(), this.f54655g);
        this.f54653e.changSkinType(b2.a());
        return b2.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a getItem(int i2) {
        List<a> list = this.f54654f;
        if (list != null) {
            return list.get(i2);
        }
        return null;
    }

    public void c(List<a> list) {
        this.f54654f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a> list = this.f54654f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        return a(i2, view, viewGroup);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0) {
            this.f54655g = false;
            notifyDataSetChanged();
            return;
        }
        this.f54655g = true;
    }
}
