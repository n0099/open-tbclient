package d.b.j0.v2.d;

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
import d.b.c.e.p.k;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter implements BdSwitchView.b {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f63564e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f63565f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwitchView.b f63566g;

    /* renamed from: d.b.j0.v2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1684a {

        /* renamed from: a  reason: collision with root package name */
        public MsgSettingItemView f63567a;

        public C1684a(a aVar) {
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f63564e = tbPageContext;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        BdSwitchView.b bVar = this.f63566g;
        if (bVar != null) {
            bVar.OnSwitchStateChange(view, switchState);
        }
    }

    public void a(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f63565f = arrayList;
    }

    public void b(BdSwitchView.b bVar) {
        this.f63566g = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<OfficialAccountPushInfo> arrayList = this.f63565f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<OfficialAccountPushInfo> arrayList = this.f63565f;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f63565f.get(i);
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
        C1684a c1684a;
        if (view == null) {
            view = LayoutInflater.from(this.f63564e.getPageActivity()).inflate(R.layout.official_account_push_item, viewGroup, false);
            c1684a = new C1684a(this);
            c1684a.f63567a = (MsgSettingItemView) view.findViewById(R.id.item_official_account_push);
            view.setTag(c1684a);
        } else {
            c1684a = (C1684a) view.getTag();
        }
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) getItem(i);
        if (k.isEmpty(officialAccountPushInfo.name)) {
            c1684a.f63567a.setVisibility(8);
        } else {
            c1684a.f63567a.setVisibility(0);
            c1684a.f63567a.setText(officialAccountPushInfo.name);
            if (officialAccountPushInfo.is_on == 1) {
                c1684a.f63567a.getSwitchView().k();
            } else {
                c1684a.f63567a.getSwitchView().h();
            }
            c1684a.f63567a.setLineVisibility(true);
            c1684a.f63567a.c(this.f63564e, TbadkCoreApplication.getInst().getSkinType());
            c1684a.f63567a.getSwitchView().setOnSwitchStateChangeListener(this);
            c1684a.f63567a.getSwitchView().setTag(officialAccountPushInfo);
        }
        return view;
    }
}
