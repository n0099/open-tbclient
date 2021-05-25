package d.a.n0.g1.a.c;

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
    public IMBlackListActivity f54938e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<BlackListItemData> f54939f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f54940g = new View$OnClickListenerC1341a();

    /* renamed from: d.a.n0.g1.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1341a implements View.OnClickListener {
        public View$OnClickListenerC1341a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof BlackListItemData)) {
                return;
            }
            a.this.f54938e.handler(view, (BlackListItemData) tag);
        }
    }

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f54942a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f54943b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54944c;

        /* renamed from: d  reason: collision with root package name */
        public Button f54945d;

        public b(a aVar) {
        }

        public /* synthetic */ b(a aVar, View$OnClickListenerC1341a view$OnClickListenerC1341a) {
            this(aVar);
        }
    }

    public a(IMBlackListActivity iMBlackListActivity) {
        this.f54938e = iMBlackListActivity;
    }

    public final b b(Object obj, BlackListItemData blackListItemData) {
        b bVar;
        if (obj == null) {
            bVar = c();
        } else {
            bVar = (b) obj;
        }
        d(bVar, blackListItemData.s());
        bVar.f54944c.setText(blackListItemData.t());
        bVar.f54945d.setTag(blackListItemData);
        this.f54938e.getLayoutMode().j(bVar.f54942a);
        return bVar;
    }

    public final b c() {
        b bVar = new b(this, null);
        View inflate = LayoutInflater.from(this.f54938e.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        bVar.f54942a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.header_view);
        bVar.f54943b = headImageView;
        headImageView.setIsRound(true);
        bVar.f54944c = (TextView) bVar.f54942a.findViewById(R.id.user_name);
        bVar.f54945d = (Button) bVar.f54942a.findViewById(R.id.remove_button);
        bVar.f54942a.setTag(bVar);
        bVar.f54945d.setOnClickListener(this.f54940g);
        return bVar;
    }

    public final void d(b bVar, String str) {
        if (str != null) {
            bVar.f54943b.setTag(str);
            bVar.f54943b.V(str, 12, false);
        }
    }

    public void e(BlackListItemData blackListItemData) {
        ArrayList<BlackListItemData> arrayList = this.f54939f;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(blackListItemData);
    }

    public void f(ArrayList<BlackListItemData> arrayList) {
        this.f54939f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<BlackListItemData> arrayList = this.f54939f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<BlackListItemData> arrayList = this.f54939f;
        if (arrayList != null) {
            return arrayList.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        BlackListItemData blackListItemData = (BlackListItemData) getItem(i2);
        if (blackListItemData != null) {
            bVar = b(view != null ? view.getTag() : null, blackListItemData);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.f54942a;
        }
        return null;
    }
}
