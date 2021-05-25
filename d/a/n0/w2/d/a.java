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
    public TbPageContext f62640e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f62641f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwitchView.b f62642g;

    /* renamed from: d.a.n0.w2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1702a {

        /* renamed from: a  reason: collision with root package name */
        public MsgSettingItemView f62643a;

        public C1702a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f62640e = tbPageContext;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        BdSwitchView.b bVar = this.f62642g;
        if (bVar != null) {
            bVar.OnSwitchStateChange(view, switchState);
        }
    }

    public void a(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f62641f = arrayList;
    }

    public void b(BdSwitchView.b bVar) {
        this.f62642g = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<OfficialAccountPushInfo> arrayList = this.f62641f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<OfficialAccountPushInfo> arrayList = this.f62641f;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return null;
        }
        return this.f62641f.get(i2);
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
        C1702a c1702a;
        if (view == null) {
            view = LayoutInflater.from(this.f62640e.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c1702a = new C1702a(this);
            c1702a.f62643a = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c1702a);
        } else {
            c1702a = (C1702a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i2);
        if (k.isEmpty(officialAccountPushInfo.name)) {
            c1702a.f62643a.setVisibility(8);
        } else {
            c1702a.f62643a.setVisibility(0);
            c1702a.f62643a.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c1702a.f62643a.getSwitchView().k();
            } else {
                c1702a.f62643a.getSwitchView().h();
            }
            c1702a.f62643a.setLineVisibility(true);
            c1702a.f62643a.c(this.f62640e, TbadkCoreApplication.getInst().getSkinType());
            c1702a.f62643a.getSwitchView().setOnSwitchStateChangeListener(this);
            c1702a.f62643a.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }
}
