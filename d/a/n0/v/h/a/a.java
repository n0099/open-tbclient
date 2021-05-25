package d.a.n0.v.h.a;

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
    public TbPageContext f61961e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AlaSquareTabInfo> f61962f;

    /* renamed from: d.a.n0.v.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1663a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61963a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61964b;

        public C1663a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f61961e = tbPageContext;
    }

    public ArrayList<AlaSquareTabInfo> a() {
        return this.f61962f;
    }

    public void b(ArrayList<AlaSquareTabInfo> arrayList) {
        this.f61962f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f61962f)) {
            return 0;
        }
        return this.f61962f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (ListUtils.isEmpty(this.f61962f)) {
            return null;
        }
        return this.f61962f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1663a c1663a;
        if (view == null) {
            c1663a = new C1663a(this);
            view2 = LayoutInflater.from(this.f61961e.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.cover);
            c1663a.f61963a = tbImageView;
            tbImageView.setDrawerType(1);
            c1663a.f61963a.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c1663a.f61963a.setDefaultBgResource(R.color.transparent);
            c1663a.f61963a.setRadius(this.f61961e.getResources().getDimensionPixelSize(R.dimen.ds20));
            TextView textView = (TextView) view2.findViewById(R.id.title);
            c1663a.f61964b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            view2.setTag(c1663a);
        } else {
            view2 = view;
            c1663a = (C1663a) view.getTag();
        }
        c1663a.f61963a.V(this.f61962f.get(i2).iconUrl, 10, false);
        c1663a.f61964b.setText(this.f61962f.get(i2).name);
        return view2;
    }
}
