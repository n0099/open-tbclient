package d.a.j0.t.h.a;

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
    public TbPageContext f60949e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AlaSquareTabInfo> f60950f;

    /* renamed from: d.a.j0.t.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1578a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60951a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60952b;

        public C1578a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f60949e = tbPageContext;
    }

    public ArrayList<AlaSquareTabInfo> a() {
        return this.f60950f;
    }

    public void b(ArrayList<AlaSquareTabInfo> arrayList) {
        this.f60950f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f60950f)) {
            return 0;
        }
        return this.f60950f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (ListUtils.isEmpty(this.f60950f)) {
            return null;
        }
        return this.f60950f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1578a c1578a;
        if (view == null) {
            c1578a = new C1578a(this);
            view2 = LayoutInflater.from(this.f60949e.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.cover);
            c1578a.f60951a = tbImageView;
            tbImageView.setDrawerType(1);
            c1578a.f60951a.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c1578a.f60951a.setDefaultBgResource(R.color.transparent);
            c1578a.f60951a.setRadius(this.f60949e.getResources().getDimensionPixelSize(R.dimen.ds20));
            TextView textView = (TextView) view2.findViewById(R.id.title);
            c1578a.f60952b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            view2.setTag(c1578a);
        } else {
            view2 = view;
            c1578a = (C1578a) view.getTag();
        }
        c1578a.f60951a.V(this.f60950f.get(i2).iconUrl, 10, false);
        c1578a.f60952b.setText(this.f60950f.get(i2).name);
        return view2;
    }
}
