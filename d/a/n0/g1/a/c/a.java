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
    public IMBlackListActivity f58627e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<BlackListItemData> f58628f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f58629g = new View$OnClickListenerC1397a();

    /* renamed from: d.a.n0.g1.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1397a implements View.OnClickListener {
        public View$OnClickListenerC1397a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof BlackListItemData)) {
                return;
            }
            a.this.f58627e.handler(view, (BlackListItemData) tag);
        }
    }

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f58631a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f58632b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58633c;

        /* renamed from: d  reason: collision with root package name */
        public Button f58634d;

        public b(a aVar) {
        }

        public /* synthetic */ b(a aVar, View$OnClickListenerC1397a view$OnClickListenerC1397a) {
            this(aVar);
        }
    }

    public a(IMBlackListActivity iMBlackListActivity) {
        this.f58627e = iMBlackListActivity;
    }

    public final b b(Object obj, BlackListItemData blackListItemData) {
        b bVar;
        if (obj == null) {
            bVar = c();
        } else {
            bVar = (b) obj;
        }
        d(bVar, blackListItemData.w());
        bVar.f58633c.setText(blackListItemData.x());
        bVar.f58634d.setTag(blackListItemData);
        this.f58627e.getLayoutMode().j(bVar.f58631a);
        return bVar;
    }

    public final b c() {
        b bVar = new b(this, null);
        View inflate = LayoutInflater.from(this.f58627e.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        bVar.f58631a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.header_view);
        bVar.f58632b = headImageView;
        headImageView.setIsRound(true);
        bVar.f58633c = (TextView) bVar.f58631a.findViewById(R.id.user_name);
        bVar.f58634d = (Button) bVar.f58631a.findViewById(R.id.remove_button);
        bVar.f58631a.setTag(bVar);
        bVar.f58634d.setOnClickListener(this.f58629g);
        return bVar;
    }

    public final void d(b bVar, String str) {
        if (str != null) {
            bVar.f58632b.setTag(str);
            bVar.f58632b.U(str, 12, false);
        }
    }

    public void e(BlackListItemData blackListItemData) {
        ArrayList<BlackListItemData> arrayList = this.f58628f;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(blackListItemData);
    }

    public void f(ArrayList<BlackListItemData> arrayList) {
        this.f58628f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<BlackListItemData> arrayList = this.f58628f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<BlackListItemData> arrayList = this.f58628f;
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
            return bVar.f58631a;
        }
        return null;
    }
}
