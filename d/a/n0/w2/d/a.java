package d.a.n0.w2.d;

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
import d.a.c.e.p.k;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter implements BdSwitchView.b {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f66355e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f66356f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwitchView.b f66357g;

    /* renamed from: d.a.n0.w2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1759a {

        /* renamed from: a  reason: collision with root package name */
        public MsgSettingItemView f66358a;

        public C1759a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f66355e = tbPageContext;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        BdSwitchView.b bVar = this.f66357g;
        if (bVar != null) {
            bVar.OnSwitchStateChange(view, switchState);
        }
    }

    public void a(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f66356f = arrayList;
    }

    public void b(BdSwitchView.b bVar) {
        this.f66357g = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<OfficialAccountPushInfo> arrayList = this.f66356f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<OfficialAccountPushInfo> arrayList = this.f66356f;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f66356f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        if (getItem(i2) != null) {
            return i2;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1759a c1759a;
        if (view == null) {
            view = LayoutInflater.from(this.f66355e.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c1759a = new C1759a(this);
            c1759a.f66358a = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c1759a);
        } else {
            c1759a = (C1759a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i2);
        if (k.isEmpty(officialAccountPushInfo.name)) {
            c1759a.f66358a.setVisibility(8);
        } else {
            c1759a.f66358a.setVisibility(0);
            c1759a.f66358a.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c1759a.f66358a.getSwitchView().k();
            } else {
                c1759a.f66358a.getSwitchView().h();
            }
            c1759a.f66358a.setLineVisibility(true);
            c1759a.f66358a.c(this.f66355e, TbadkCoreApplication.getInst().getSkinType());
            c1759a.f66358a.getSwitchView().setOnSwitchStateChangeListener(this);
            c1759a.f66358a.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }
}
