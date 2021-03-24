package d.b.i0.d2.c;

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
    public PraiseListActivity f54130e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f54131f = null;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f54132g;

    public c(PraiseListActivity praiseListActivity) {
        this.f54130e = null;
        this.f54130e = praiseListActivity;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        b b2 = b.b(this.f54130e.getPageContext().getPageActivity(), view);
        a item = getItem(i);
        b2.c(StringUtils.isNull(item.b()) ? item.d() : item.b(), item.a(), item.e(), this.f54132g);
        this.f54130e.changSkinType(b2.a());
        return b2.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a getItem(int i) {
        List<a> list = this.f54131f;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public void c(List<a> list) {
        this.f54131f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a> list = this.f54131f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.f54132g = false;
            notifyDataSetChanged();
            return;
        }
        this.f54132g = true;
    }
}
