package d.b.j0.f1.a.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public IMBlackListActivity f56166e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<BlackListItemData> f56167f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f56168g = new View$OnClickListenerC1312a();

    /* renamed from: d.b.j0.f1.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1312a implements View.OnClickListener {
        public View$OnClickListenerC1312a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof BlackListItemData)) {
                return;
            }
            a.this.f56166e.handler(view, (BlackListItemData) tag);
        }
    }

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f56170a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f56171b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f56172c;

        /* renamed from: d  reason: collision with root package name */
        public Button f56173d;

        public b(a aVar) {
        }

        public /* synthetic */ b(a aVar, View$OnClickListenerC1312a view$OnClickListenerC1312a) {
            this(aVar);
        }
    }

    public a(IMBlackListActivity iMBlackListActivity) {
        this.f56166e = iMBlackListActivity;
    }

    public final b b(Object obj, BlackListItemData blackListItemData) {
        b bVar;
        if (obj == null) {
            bVar = c();
        } else {
            bVar = (b) obj;
        }
        d(bVar, blackListItemData.s());
        bVar.f56172c.setText(blackListItemData.t());
        bVar.f56173d.setTag(blackListItemData);
        this.f56166e.getLayoutMode().j(bVar.f56170a);
        return bVar;
    }

    public final b c() {
        b bVar = new b(this, null);
        View inflate = LayoutInflater.from(this.f56166e.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        bVar.f56170a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.header_view);
        bVar.f56171b = headImageView;
        headImageView.setIsRound(true);
        bVar.f56172c = (TextView) bVar.f56170a.findViewById(R.id.user_name);
        bVar.f56173d = (Button) bVar.f56170a.findViewById(R.id.remove_button);
        bVar.f56170a.setTag(bVar);
        bVar.f56173d.setOnClickListener(this.f56168g);
        return bVar;
    }

    public final void d(b bVar, String str) {
        if (str != null) {
            bVar.f56171b.setTag(str);
            bVar.f56171b.W(str, 12, false);
        }
    }

    public void e(BlackListItemData blackListItemData) {
        ArrayList<BlackListItemData> arrayList = this.f56167f;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(blackListItemData);
    }

    public void f(ArrayList<BlackListItemData> arrayList) {
        this.f56167f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<BlackListItemData> arrayList = this.f56167f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<BlackListItemData> arrayList = this.f56167f;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i);
        if (blackListItemData != null) {
            bVar = b(view != null ? view.getTag() : null, blackListItemData);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.f56170a;
        }
        return null;
    }
}
