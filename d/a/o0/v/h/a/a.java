package d.a.o0.v.h.a;

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
    public TbPageContext f65801e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AlaSquareTabInfo> f65802f;

    /* renamed from: d.a.o0.v.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1724a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f65803a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65804b;

        public C1724a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f65801e = tbPageContext;
    }

    public ArrayList<AlaSquareTabInfo> a() {
        return this.f65802f;
    }

    public void b(ArrayList<AlaSquareTabInfo> arrayList) {
        this.f65802f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f65802f)) {
            return 0;
        }
        return this.f65802f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (ListUtils.isEmpty(this.f65802f)) {
            return null;
        }
        return this.f65802f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1724a c1724a;
        if (view == null) {
            c1724a = new C1724a(this);
            view2 = LayoutInflater.from(this.f65801e.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.cover);
            c1724a.f65803a = tbImageView;
            tbImageView.setDrawerType(1);
            c1724a.f65803a.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c1724a.f65803a.setDefaultBgResource(R.color.transparent);
            c1724a.f65803a.setRadius(this.f65801e.getResources().getDimensionPixelSize(R.dimen.ds20));
            TextView textView = (TextView) view2.findViewById(R.id.title);
            c1724a.f65804b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            view2.setTag(c1724a);
        } else {
            view2 = view;
            c1724a = (C1724a) view.getTag();
        }
        c1724a.f65803a.U(this.f65802f.get(i2).iconUrl, 10, false);
        c1724a.f65804b.setText(this.f65802f.get(i2).name);
        return view2;
    }
}
