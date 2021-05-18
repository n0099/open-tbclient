package d.a.k0.v3.u;

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
    public final Context f62877e;

    /* renamed from: f  reason: collision with root package name */
    public AtListActivity f62878f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<MetaData> f62879g;

    /* renamed from: h  reason: collision with root package name */
    public TbCheckBox.b f62880h;

    /* renamed from: i  reason: collision with root package name */
    public c f62881i = null;
    public ViewGroup j = null;
    public boolean k;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f62882a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f62883b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62884c;

        /* renamed from: d  reason: collision with root package name */
        public TbCheckBox f62885d;

        public b(a aVar) {
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void handlerItem(View view, MetaData metaData);
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.k = true;
        this.f62878f = atListActivity;
        this.f62877e = atListActivity.getPageContext().getContext();
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
        c cVar = this.f62881i;
        if (cVar != null) {
            cVar.handlerItem(bVar.f62882a, metaData);
        }
        String avater = metaData.getAvater();
        bVar.f62884c.setText(metaData.getName_show());
        bVar.f62885d.setTagData(metaData);
        bVar.f62883b.setTag(avater);
        if (this.k) {
            bVar.f62885d.setVisibility(0);
        } else {
            bVar.f62885d.setVisibility(8);
        }
        bVar.f62883b.V(avater, 12, false);
        this.f62878f.getPageContext().getLayoutMode().k(skinType == 1);
        this.f62878f.getPageContext().getLayoutMode().j(bVar.f62882a);
        return bVar;
    }

    public final b b() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.f62877e).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        bVar.f62882a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.photo);
        bVar.f62883b = headImageView;
        headImageView.setIsRound(false);
        bVar.f62884c = (TextView) bVar.f62882a.findViewById(R.id.txt_user_name);
        TbCheckBox tbCheckBox = (TbCheckBox) bVar.f62882a.findViewById(R.id.ckb_select);
        bVar.f62885d = tbCheckBox;
        tbCheckBox.setBackgroundDrawableIdIsWebP(true);
        bVar.f62885d.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        TbCheckBox.b bVar2 = this.f62880h;
        if (bVar2 != null) {
            bVar.f62885d.setStatedChangedListener(bVar2);
        }
        bVar.f62882a.setTag(bVar);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public MetaData getItem(int i2) {
        ArrayList<MetaData> arrayList = this.f62879g;
        if (arrayList != null && i2 < arrayList.size()) {
            return this.f62879g.get(i2);
        }
        return null;
    }

    public void d(TbCheckBox.b bVar) {
        this.f62880h = bVar;
    }

    public void e(ArrayList<MetaData> arrayList) {
        this.f62879g = arrayList;
    }

    public void f(c cVar) {
        this.f62881i = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MetaData> arrayList = this.f62879g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (this.j == null) {
            this.j = viewGroup;
        }
        MetaData item = getItem(i2);
        if (item != null) {
            bVar = a(view != null ? view.getTag() : null, item);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.f62882a;
        }
        return null;
    }
}
