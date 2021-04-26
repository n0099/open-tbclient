package d.a.j0.v3.u;

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
    public final Context f62153e;

    /* renamed from: f  reason: collision with root package name */
    public AtListActivity f62154f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<MetaData> f62155g;

    /* renamed from: h  reason: collision with root package name */
    public TbCheckBox.b f62156h;

    /* renamed from: i  reason: collision with root package name */
    public c f62157i = null;
    public ViewGroup j = null;
    public boolean k;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f62158a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f62159b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62160c;

        /* renamed from: d  reason: collision with root package name */
        public TbCheckBox f62161d;

        public b(a aVar) {
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void handlerItem(View view, MetaData metaData);
    }

    public a(AtListActivity atListActivity, boolean z) {
        this.k = true;
        this.f62154f = atListActivity;
        this.f62153e = atListActivity.getPageContext().getContext();
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
        c cVar = this.f62157i;
        if (cVar != null) {
            cVar.handlerItem(bVar.f62158a, metaData);
        }
        String avater = metaData.getAvater();
        bVar.f62160c.setText(metaData.getName_show());
        bVar.f62161d.setTagData(metaData);
        bVar.f62159b.setTag(avater);
        if (this.k) {
            bVar.f62161d.setVisibility(0);
        } else {
            bVar.f62161d.setVisibility(8);
        }
        bVar.f62159b.V(avater, 12, false);
        this.f62154f.getPageContext().getLayoutMode().k(skinType == 1);
        this.f62154f.getPageContext().getLayoutMode().j(bVar.f62158a);
        return bVar;
    }

    public final b b() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.f62153e).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        bVar.f62158a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.photo);
        bVar.f62159b = headImageView;
        headImageView.setIsRound(false);
        bVar.f62160c = (TextView) bVar.f62158a.findViewById(R.id.txt_user_name);
        TbCheckBox tbCheckBox = (TbCheckBox) bVar.f62158a.findViewById(R.id.ckb_select);
        bVar.f62161d = tbCheckBox;
        tbCheckBox.setBackgroundDrawableIdIsWebP(true);
        bVar.f62161d.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
        TbCheckBox.b bVar2 = this.f62156h;
        if (bVar2 != null) {
            bVar.f62161d.setStatedChangedListener(bVar2);
        }
        bVar.f62158a.setTag(bVar);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public MetaData getItem(int i2) {
        ArrayList<MetaData> arrayList = this.f62155g;
        if (arrayList != null && i2 < arrayList.size()) {
            return this.f62155g.get(i2);
        }
        return null;
    }

    public void d(TbCheckBox.b bVar) {
        this.f62156h = bVar;
    }

    public void e(ArrayList<MetaData> arrayList) {
        this.f62155g = arrayList;
    }

    public void f(c cVar) {
        this.f62157i = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MetaData> arrayList = this.f62155g;
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
            return bVar.f62158a;
        }
        return null;
    }
}
