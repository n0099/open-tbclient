package d.a.n0.k3.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.themeCenter.background.BackgroundSetRequestMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60692a;

    /* renamed from: b  reason: collision with root package name */
    public int f60693b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f60694c;

    /* renamed from: d  reason: collision with root package name */
    public int f60695d = -1;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.f60694c = null;
        this.f60692a = tbPageContext;
        this.f60694c = bdUniqueId;
    }

    public int a() {
        return this.f60693b;
    }

    public void b(DressItemData dressItemData) {
        if (dressItemData == null || dressItemData.getPropsId() == 0) {
            return;
        }
        PersonalBackgroundPreviewActivityConfig personalBackgroundPreviewActivityConfig = new PersonalBackgroundPreviewActivityConfig(this.f60692a.getPageActivity(), dressItemData.getPropsId(), dressItemData.getInUse() ? 1 : 0);
        personalBackgroundPreviewActivityConfig.setFrom(this.f60695d);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalBackgroundPreviewActivityConfig));
    }

    public void c(int i2) {
        this.f60695d = i2;
    }

    public void d(int i2, String str, DressItemData dressItemData, boolean z) {
        int i3 = dressItemData.getFreeUserLevel() == 101 ? 9 : 0;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i2 == d.a.n0.k3.c.f60646a) {
            int i4 = this.f60695d;
            d.a.n0.k3.b.d(this.f60692a, z ? 4 : 2, str, i3, i4 == 1 ? MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND_TRY : i4 == 0 ? MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND_TRY : "", MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
        } else if (i2 == d.a.n0.k3.c.f60647b) {
            d.a.n0.k3.b.c(this.f60692a, z ? 4 : 2, str, i3);
        }
    }

    public void e(DressItemData dressItemData, boolean z) {
        if (dressItemData == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.f60692a.getPageActivity());
            return;
        }
        this.f60693b = dressItemData.getPropsId();
        BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
        backgroundSetRequestMessage.setFromDetail(z);
        backgroundSetRequestMessage.setRequestUniqueId(this.f60694c);
        backgroundSetRequestMessage.setPropId(this.f60693b);
        MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921004));
    }
}
