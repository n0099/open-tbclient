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
    public TbPageContext f60768e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AlaSquareTabInfo> f60769f;

    /* renamed from: d.b.i0.t.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1562a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60770a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60771b;

        public C1562a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f60768e = tbPageContext;
    }

    public ArrayList<AlaSquareTabInfo> a() {
        return this.f60769f;
    }

    public void b(ArrayList<AlaSquareTabInfo> arrayList) {
        this.f60769f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f60769f)) {
            return 0;
        }
        return this.f60769f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (ListUtils.isEmpty(this.f60769f)) {
            return null;
        }
        return this.f60769f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1562a c1562a;
        if (view == null) {
            c1562a = new C1562a(this);
            view2 = LayoutInflater.from(this.f60768e.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.cover);
            c1562a.f60770a = tbImageView;
            tbImageView.setDrawerType(1);
            c1562a.f60770a.setDefaultResource(R.drawable.ala_all_game_default_icon);
            c1562a.f60770a.setDefaultBgResource(R.color.transparent);
            c1562a.f60770a.setRadius(this.f60768e.getResources().getDimensionPixelSize(R.dimen.ds20));
            TextView textView = (TextView) view2.findViewById(R.id.title);
            c1562a.f60771b = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            view2.setTag(c1562a);
        } else {
            view2 = view;
            c1562a = (C1562a) view.getTag();
        }
        c1562a.f60770a.W(this.f60769f.get(i).iconUrl, 10, false);
        c1562a.f60771b.setText(this.f60769f.get(i).name);
        return view2;
    }
}
