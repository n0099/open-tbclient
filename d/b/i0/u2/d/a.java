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
    public TbPageContext f61404e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f61405f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwitchView.b f61406g;

    /* renamed from: d.b.i0.u2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1600a {

        /* renamed from: a  reason: collision with root package name */
        public MsgSettingItemView f61407a;

        public C1600a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f61404e = tbPageContext;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        BdSwitchView.b bVar = this.f61406g;
        if (bVar != null) {
            bVar.OnSwitchStateChange(view, switchState);
        }
    }

    public void a(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f61405f = arrayList;
    }

    public void b(BdSwitchView.b bVar) {
        this.f61406g = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<OfficialAccountPushInfo> arrayList = this.f61405f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<OfficialAccountPushInfo> arrayList = this.f61405f;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f61405f.get(i);
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
        C1600a c1600a;
        if (view == null) {
            view = LayoutInflater.from(this.f61404e.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c1600a = new C1600a(this);
            c1600a.f61407a = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c1600a);
        } else {
            c1600a = (C1600a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (k.isEmpty(officialAccountPushInfo.name)) {
            c1600a.f61407a.setVisibility(8);
        } else {
            c1600a.f61407a.setVisibility(0);
            c1600a.f61407a.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c1600a.f61407a.getSwitchView().k();
            } else {
                c1600a.f61407a.getSwitchView().h();
            }
            c1600a.f61407a.setLineVisibility(true);
            c1600a.f61407a.c(this.f61404e, TbadkCoreApplication.getInst().getSkinType());
            c1600a.f61407a.getSwitchView().setOnSwitchStateChangeListener(this);
            c1600a.f61407a.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }
}
