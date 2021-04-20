package d.b.i0.j3.f.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.b.i0.j3.b;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f57755a;

    /* renamed from: b  reason: collision with root package name */
    public int f57756b;

    public a(TbPageContext<?> tbPageContext) {
        this.f57755a = tbPageContext;
    }

    public final boolean a(DressItemData dressItemData) {
        return TbadkCoreApplication.getCurrentMemberType() == 1 && dressItemData.getFreeUserLevel() == 1;
    }

    public void b(DressItemData dressItemData, boolean z) {
        String string;
        String str;
        int i;
        if (dressItemData == null) {
            return;
        }
        boolean a2 = b.a(dressItemData);
        if (!a2) {
            a2 = a(dressItemData);
        }
        if (a2) {
            this.f57756b = dressItemData.getPropsId();
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_BUBBLE_SET);
            httpMessage.setExtra(Integer.valueOf(this.f57756b));
            httpMessage.addParam("bcode", String.valueOf(this.f57756b));
            MessageManager.getInstance().sendMessage(httpMessage);
        } else if (dressItemData.getFreeUserLevel() == 100) {
            if (dressItemData.getActivityFinish() == 0) {
                b.b(this.f57755a, 5, dressItemData.getActivityUrl());
            }
        } else {
            if (dressItemData.getFreeUserLevel() == 101) {
                str = this.f57755a.getString(R.string.become_annual_can_use_bubble);
                i = 9;
            } else {
                if (dressItemData.getFreeUserLevel() > 1) {
                    string = String.format(this.f57755a.getString(R.string.become_vip_can_use_bubble), Integer.valueOf(dressItemData.getFreeUserLevel()));
                } else {
                    string = this.f57755a.getString(R.string.become_member_can_use_bubble);
                }
                str = string;
                i = 0;
            }
            b.d(this.f57755a, 5, str, i, z ? MemberPayStatistic.REFER_PAGE_POST_BUBBLE : MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
        }
    }
}
