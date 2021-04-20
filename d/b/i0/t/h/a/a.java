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
    public TbPageContext f62332e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AlaSquareTabInfo> f62333f;

    /* renamed from: d.b.i0.t.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1615a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62334a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62335b;

        public C1615a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f62332e = tbPageContext;
    }

    public ArrayList<AlaSquareTabInfo> a() {
        return this.f62333f;
    }

    public void b(ArrayList<AlaSquareTabInfo> arrayList) {
        this.f62333f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f62333f)) {
            return 0;
        }
        return this.f62333f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (ListUtils.isEmpty(this.f62333f)) {
            return null;
        }
        return this.f62333f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1615a c1615a;
        if (view == null) {
            c1615a = new C1615a(this);
            view2 = LayoutInflater.from(this.f62332e.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.cover);
            c1615a.f62334a = tbImageView;
            tbImageView.setDrawerType(1);
            c1615a.f62334a.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c1615a.f62334a.setDefaultBgResource(R.color.transparent);
            c1615a.f62334a.setRadius(this.f62332e.getResources().getDimensionPixelSize(R.dimen.ds20));
            TextView textView = (TextView) view2.findViewById(R.id.title);
            c1615a.f62335b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            view2.setTag(c1615a);
        } else {
            view2 = view;
            c1615a = (C1615a) view.getTag();
        }
        c1615a.f62334a.W(this.f62333f.get(i).iconUrl, 10, false);
        c1615a.f62335b.setText(this.f62333f.get(i).name);
        return view2;
    }
}
