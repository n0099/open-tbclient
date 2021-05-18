package d.a.k0.t.h.a;

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
    public TbPageContext f61673e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AlaSquareTabInfo> f61674f;

    /* renamed from: d.a.k0.t.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1643a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61675a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61676b;

        public C1643a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f61673e = tbPageContext;
    }

    public ArrayList<AlaSquareTabInfo> a() {
        return this.f61674f;
    }

    public void b(ArrayList<AlaSquareTabInfo> arrayList) {
        this.f61674f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f61674f)) {
            return 0;
        }
        return this.f61674f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (ListUtils.isEmpty(this.f61674f)) {
            return null;
        }
        return this.f61674f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1643a c1643a;
        if (view == null) {
            c1643a = new C1643a(this);
            view2 = LayoutInflater.from(this.f61673e.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.cover);
            c1643a.f61675a = tbImageView;
            tbImageView.setDrawerType(1);
            c1643a.f61675a.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c1643a.f61675a.setDefaultBgResource(R.color.transparent);
            c1643a.f61675a.setRadius(this.f61673e.getResources().getDimensionPixelSize(R.dimen.ds20));
            TextView textView = (TextView) view2.findViewById(R.id.title);
            c1643a.f61676b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            view2.setTag(c1643a);
        } else {
            view2 = view;
            c1643a = (C1643a) view.getTag();
        }
        c1643a.f61675a.V(this.f61674f.get(i2).iconUrl, 10, false);
        c1643a.f61676b.setText(this.f61674f.get(i2).name);
        return view2;
    }
}
