package d.b.i0.t.h.a;

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
    public TbPageContext f60767e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AlaSquareTabInfo> f60768f;

    /* renamed from: d.b.i0.t.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1561a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60769a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60770b;

        public C1561a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f60767e = tbPageContext;
    }

    public ArrayList<AlaSquareTabInfo> a() {
        return this.f60768f;
    }

    public void b(ArrayList<AlaSquareTabInfo> arrayList) {
        this.f60768f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f60768f)) {
            return 0;
        }
        return this.f60768f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (ListUtils.isEmpty(this.f60768f)) {
            return null;
        }
        return this.f60768f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1561a c1561a;
        if (view == null) {
            c1561a = new C1561a(this);
            view2 = LayoutInflater.from(this.f60767e.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.cover);
            c1561a.f60769a = tbImageView;
            tbImageView.setDrawerType(1);
            c1561a.f60769a.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c1561a.f60769a.setDefaultBgResource(R.color.transparent);
            c1561a.f60769a.setRadius(this.f60767e.getResources().getDimensionPixelSize(R.dimen.ds20));
            TextView textView = (TextView) view2.findViewById(R.id.title);
            c1561a.f60770b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            view2.setTag(c1561a);
        } else {
            view2 = view;
            c1561a = (C1561a) view.getTag();
        }
        c1561a.f60769a.W(this.f60768f.get(i).iconUrl, 10, false);
        c1561a.f60770b.setText(this.f60768f.get(i).name);
        return view2;
    }
}
