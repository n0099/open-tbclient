package d.b.i0.u2.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import d.b.b.e.p.k;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter implements BdSwitchView.b {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f61405e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f61406f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwitchView.b f61407g;

    /* renamed from: d.b.i0.u2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1601a {

        /* renamed from: a  reason: collision with root package name */
        public MsgSettingItemView f61408a;

        public C1601a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f61405e = tbPageContext;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        BdSwitchView.b bVar = this.f61407g;
        if (bVar != null) {
            bVar.OnSwitchStateChange(view, switchState);
        }
    }

    public void a(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f61406f = arrayList;
    }

    public void b(BdSwitchView.b bVar) {
        this.f61407g = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<OfficialAccountPushInfo> arrayList = this.f61406f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<OfficialAccountPushInfo> arrayList = this.f61406f;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f61406f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1601a c1601a;
        if (view == null) {
            view = LayoutInflater.from(this.f61405e.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c1601a = new C1601a(this);
            c1601a.f61408a = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c1601a);
        } else {
            c1601a = (C1601a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (k.isEmpty(officialAccountPushInfo.name)) {
            c1601a.f61408a.setVisibility(8);
        } else {
            c1601a.f61408a.setVisibility(0);
            c1601a.f61408a.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c1601a.f61408a.getSwitchView().k();
            } else {
                c1601a.f61408a.getSwitchView().h();
            }
            c1601a.f61408a.setLineVisibility(true);
            c1601a.f61408a.c(this.f61405e, TbadkCoreApplication.getInst().getSkinType());
            c1601a.f61408a.getSwitchView().setOnSwitchStateChangeListener(this);
            c1601a.f61408a.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }
}
