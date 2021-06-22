package d.a.o0.v.d.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.n0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f65505e;

    /* renamed from: f  reason: collision with root package name */
    public Context f65506f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.o0.v.d.e.b.b> f65507g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f65508h;

    public a(TbPageContext tbPageContext) {
        this.f65505e = tbPageContext;
        this.f65506f = tbPageContext.getPageActivity();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.o0.v.d.e.b.b getItem(int i2) {
        return this.f65507g.get(i2);
    }

    public void b(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.s1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = a2Var.T().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.s1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
    }

    public void c(List<d.a.o0.v.d.e.b.b> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f65507g.clear();
        this.f65507g.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f65507g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }
}
