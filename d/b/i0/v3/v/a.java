package d.b.i0.v3.v;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtListActivity;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Context f63490e;

    /* renamed from: f  reason: collision with root package name */
    public AtListActivity f63491f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<MetaData> f63492g;

    /* renamed from: h  reason: collision with root package name */
    public TbCheckBox.b f63493h;
    public c i = null;
    public ViewGroup j = null;
    public boolean k;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f63494a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f63495b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63496c;

        /* renamed from: d  reason: collision with root package name */
        public TbCheckBox f63497d;

        public b(a aVar) {
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void handlerItem(View view, MetaData metaData);
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.k = true;
        this.f63491f = atListActivity;
        this.f63490e = atListActivity.getPageContext().getContext();
        this.k = z;
    }

    public final b a(Object obj, MetaData metaData) {
        b bVar;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (obj == null) {
            bVar = b();
        } else {
            bVar = (b) obj;
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.handlerItem(bVar.f63494a, metaData);
        }
        String avater = metaData.getAvater();
        bVar.f63496c.setText(metaData.getName_show());
        bVar.f63497d.setTagData(metaData);
        bVar.f63495b.setTag(avater);
        if (this.k) {
            bVar.f63497d.setVisibility(0);
        } else {
            bVar.f63497d.setVisibility(8);
        }
        bVar.f63495b.W(avater, 12, false);
        this.f63491f.getPageContext().getLayoutMode().k(skinType == 1);
        this.f63491f.getPageContext().getLayoutMode().j(bVar.f63494a);
        return bVar;
    }

    public final b b() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.f63490e).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        bVar.f63494a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.photo);
        bVar.f63495b = headImageView;
        headImageView.setIsRound(false);
        bVar.f63496c = (TextView) bVar.f63494a.findViewById(R.id.txt_user_name);
        TbCheckBox tbCheckBox = (TbCheckBox) bVar.f63494a.findViewById(R.id.ckb_select);
        bVar.f63497d = tbCheckBox;
        tbCheckBox.setBackgroundDrawableIdIsWebP(true);
        bVar.f63497d.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        TbCheckBox.b bVar2 = this.f63493h;
        if (bVar2 != null) {
            bVar.f63497d.setStatedChangedListener(bVar2);
        }
        bVar.f63494a.setTag(bVar);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public MetaData getItem(int i) {
        ArrayList<MetaData> arrayList = this.f63492g;
        if (arrayList != null && i < arrayList.size()) {
            return this.f63492g.get(i);
        }
        return null;
    }

    public void d(TbCheckBox.b bVar) {
        this.f63493h = bVar;
    }

    public void e(ArrayList<MetaData> arrayList) {
        this.f63492g = arrayList;
    }

    public void f(c cVar) {
        this.i = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MetaData> arrayList = this.f63492g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (this.j == null) {
            this.j = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            bVar = a(view != null ? view.getTag() : null, item);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.f63494a;
        }
        return null;
    }
}
