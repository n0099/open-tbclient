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
    public TbPageContext f65676e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AlaSquareTabInfo> f65677f;

    /* renamed from: d.a.n0.v.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1720a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f65678a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65679b;

        public C1720a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f65676e = tbPageContext;
    }

    public ArrayList<AlaSquareTabInfo> a() {
        return this.f65677f;
    }

    public void b(ArrayList<AlaSquareTabInfo> arrayList) {
        this.f65677f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f65677f)) {
            return 0;
        }
        return this.f65677f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (ListUtils.isEmpty(this.f65677f)) {
            return null;
        }
        return this.f65677f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1720a c1720a;
        if (view == null) {
            c1720a = new C1720a(this);
            view2 = LayoutInflater.from(this.f65676e.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.cover);
            c1720a.f65678a = tbImageView;
            tbImageView.setDrawerType(1);
            c1720a.f65678a.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c1720a.f65678a.setDefaultBgResource(R.color.transparent);
            c1720a.f65678a.setRadius(this.f65676e.getResources().getDimensionPixelSize(R.dimen.ds20));
            TextView textView = (TextView) view2.findViewById(R.id.title);
            c1720a.f65679b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            view2.setTag(c1720a);
        } else {
            view2 = view;
            c1720a = (C1720a) view.getTag();
        }
        c1720a.f65678a.U(this.f65677f.get(i2).iconUrl, 10, false);
        c1720a.f65679b.setText(this.f65677f.get(i2).name);
        return view2;
    }
}
