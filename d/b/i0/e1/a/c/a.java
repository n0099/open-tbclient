package d.b.i0.e1.a.c;

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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public IMBlackListActivity f54304e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<BlackListItemData> f54305f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f54306g = new View$OnClickListenerC1230a();

    /* renamed from: d.b.i0.e1.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1230a implements View.OnClickListener {
        public View$OnClickListenerC1230a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof BlackListItemData)) {
                return;
            }
            a.this.f54304e.handler(view, (BlackListItemData) tag);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f54308a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f54309b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54310c;

        /* renamed from: d  reason: collision with root package name */
        public Button f54311d;

        public b(a aVar) {
        }

        public /* synthetic */ b(a aVar, View$OnClickListenerC1230a view$OnClickListenerC1230a) {
            this(aVar);
        }
    }

    public a(IMBlackListActivity iMBlackListActivity) {
        this.f54304e = iMBlackListActivity;
    }

    public final b b(Object obj, BlackListItemData blackListItemData) {
        b bVar;
        if (obj == null) {
            bVar = c();
        } else {
            bVar = (b) obj;
        }
        d(bVar, blackListItemData.s());
        bVar.f54310c.setText(blackListItemData.t());
        bVar.f54311d.setTag(blackListItemData);
        this.f54304e.getLayoutMode().j(bVar.f54308a);
        return bVar;
    }

    public final b c() {
        b bVar = new b(this, null);
        View inflate = LayoutInflater.from(this.f54304e.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        bVar.f54308a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.header_view);
        bVar.f54309b = headImageView;
        headImageView.setIsRound(true);
        bVar.f54310c = (TextView) bVar.f54308a.findViewById(R.id.user_name);
        bVar.f54311d = (Button) bVar.f54308a.findViewById(R.id.remove_button);
        bVar.f54308a.setTag(bVar);
        bVar.f54311d.setOnClickListener(this.f54306g);
        return bVar;
    }

    public final void d(b bVar, String str) {
        if (str != null) {
            bVar.f54309b.setTag(str);
            bVar.f54309b.W(str, 12, false);
        }
    }

    public void e(BlackListItemData blackListItemData) {
        ArrayList<BlackListItemData> arrayList = this.f54305f;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(blackListItemData);
    }

    public void f(ArrayList<BlackListItemData> arrayList) {
        this.f54305f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<BlackListItemData> arrayList = this.f54305f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<BlackListItemData> arrayList = this.f54305f;
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
            return bVar.f54308a;
        }
        return null;
    }
}
