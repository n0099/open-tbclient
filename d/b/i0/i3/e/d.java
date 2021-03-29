package d.b.i0.i3.e;

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
    public TbPageContext<?> f56262a;

    /* renamed from: b  reason: collision with root package name */
    public int f56263b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f56264c;

    /* renamed from: d  reason: collision with root package name */
    public int f56265d = -1;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.f56264c = null;
        this.f56262a = tbPageContext;
        this.f56264c = bdUniqueId;
    }

    public int a() {
        return this.f56263b;
    }

    public void b(DressItemData dressItemData) {
        if (dressItemData == null || dressItemData.getPropsId() == 0) {
            return;
        }
        PersonalBackgroundPreviewActivityConfig personalBackgroundPreviewActivityConfig = new PersonalBackgroundPreviewActivityConfig(this.f56262a.getPageActivity(), dressItemData.getPropsId(), dressItemData.getInUse() ? 1 : 0);
        personalBackgroundPreviewActivityConfig.setFrom(this.f56265d);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalBackgroundPreviewActivityConfig));
    }

    public void c(int i) {
        this.f56265d = i;
    }

    public void d(int i, String str, DressItemData dressItemData, boolean z) {
        int i2 = dressItemData.getFreeUserLevel() == 101 ? 9 : 0;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i == d.b.i0.i3.c.f56219a) {
            int i3 = this.f56265d;
            d.b.i0.i3.b.d(this.f56262a, z ? 4 : 2, str, i2, i3 == 1 ? MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND_TRY : i3 == 0 ? MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND_TRY : "", MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
        } else if (i == d.b.i0.i3.c.f56220b) {
            d.b.i0.i3.b.c(this.f56262a, z ? 4 : 2, str, i2);
        }
    }

    public void e(DressItemData dressItemData, boolean z) {
        if (dressItemData == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.f56262a.getPageActivity());
            return;
        }
        this.f56263b = dressItemData.getPropsId();
        BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
        backgroundSetRequestMessage.setFromDetail(z);
        backgroundSetRequestMessage.setRequestUniqueId(this.f56264c);
        backgroundSetRequestMessage.setPropId(this.f56263b);
        MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921004));
    }
}
