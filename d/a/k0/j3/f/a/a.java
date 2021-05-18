package d.a.k0.j3.f.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.k0.j3.b;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f56872a;

    /* renamed from: b  reason: collision with root package name */
    public int f56873b;

    public a(TbPageContext<?> tbPageContext) {
        this.f56872a = tbPageContext;
    }

    public final boolean a(DressItemData dressItemData) {
        return TbadkCoreApplication.getCurrentMemberType() == 1 && dressItemData.getFreeUserLevel() == 1;
    }

    public void b(DressItemData dressItemData, boolean z) {
        String string;
        String str;
        int i2;
        if (dressItemData == null) {
            return;
        }
        boolean a2 = b.a(dressItemData);
        if (!a2) {
            a2 = a(dressItemData);
        }
        if (a2) {
            this.f56873b = dressItemData.getPropsId();
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_BUBBLE_SET);
            httpMessage.setExtra(Integer.valueOf(this.f56873b));
            httpMessage.addParam("bcode", String.valueOf(this.f56873b));
            MessageManager.getInstance().sendMessage(httpMessage);
        } else if (dressItemData.getFreeUserLevel() == 100) {
            if (dressItemData.getActivityFinish() == 0) {
                b.b(this.f56872a, 5, dressItemData.getActivityUrl());
            }
        } else {
            if (dressItemData.getFreeUserLevel() == 101) {
                str = this.f56872a.getString(R.string.become_annual_can_use_bubble);
                i2 = 9;
            } else {
                if (dressItemData.getFreeUserLevel() > 1) {
                    string = String.format(this.f56872a.getString(R.string.become_vip_can_use_bubble), Integer.valueOf(dressItemData.getFreeUserLevel()));
                } else {
                    string = this.f56872a.getString(R.string.become_member_can_use_bubble);
                }
                str = string;
                i2 = 0;
            }
            b.d(this.f56872a, 5, str, i2, z ? MemberPayStatistic.REFER_PAGE_POST_BUBBLE : MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
        }
    }
}
