package d.b.j0.t.h.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f62753e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AlaSquareTabInfo> f62754f;

    /* renamed from: d.b.j0.t.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1638a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62755a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62756b;

        public C1638a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f62753e = tbPageContext;
    }

    public ArrayList<AlaSquareTabInfo> a() {
        return this.f62754f;
    }

    public void b(ArrayList<AlaSquareTabInfo> arrayList) {
        this.f62754f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f62754f)) {
            return 0;
        }
        return this.f62754f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (ListUtils.isEmpty(this.f62754f)) {
            return null;
        }
        return this.f62754f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1638a c1638a;
        if (view == null) {
            c1638a = new C1638a(this);
            view2 = LayoutInflater.from(this.f62753e.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.cover);
            c1638a.f62755a = tbImageView;
            tbImageView.setDrawerType(1);
            c1638a.f62755a.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c1638a.f62755a.setDefaultBgResource(R.color.transparent);
            c1638a.f62755a.setRadius(this.f62753e.getResources().getDimensionPixelSize(R.dimen.ds20));
            TextView textView = (TextView) view2.findViewById(R.id.title);
            c1638a.f62756b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            view2.setTag(c1638a);
        } else {
            view2 = view;
            c1638a = (C1638a) view.getTag();
        }
        c1638a.f62755a.W(this.f62754f.get(i).iconUrl, 10, false);
        c1638a.f62756b.setText(this.f62754f.get(i).name);
        return view2;
    }
}
