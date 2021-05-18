package d.a.k0.j3.e;

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
    public TbPageContext<?> f56823a;

    /* renamed from: b  reason: collision with root package name */
    public int f56824b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f56825c;

    /* renamed from: d  reason: collision with root package name */
    public int f56826d = -1;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.f56825c = null;
        this.f56823a = tbPageContext;
        this.f56825c = bdUniqueId;
    }

    public int a() {
        return this.f56824b;
    }

    public void b(DressItemData dressItemData) {
        if (dressItemData == null || dressItemData.getPropsId() == 0) {
            return;
        }
        PersonalBackgroundPreviewActivityConfig personalBackgroundPreviewActivityConfig = new PersonalBackgroundPreviewActivityConfig(this.f56823a.getPageActivity(), dressItemData.getPropsId(), dressItemData.getInUse() ? 1 : 0);
        personalBackgroundPreviewActivityConfig.setFrom(this.f56826d);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personalBackgroundPreviewActivityConfig));
    }

    public void c(int i2) {
        this.f56826d = i2;
    }

    public void d(int i2, String str, DressItemData dressItemData, boolean z) {
        int i3 = dressItemData.getFreeUserLevel() == 101 ? 9 : 0;
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i2 == d.a.k0.j3.c.f56777a) {
            int i4 = this.f56826d;
            d.a.k0.j3.b.d(this.f56823a, z ? 4 : 2, str, i3, i4 == 1 ? MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND_TRY : i4 == 0 ? MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND_TRY : "", MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
        } else if (i2 == d.a.k0.j3.c.f56778b) {
            d.a.k0.j3.b.c(this.f56823a, z ? 4 : 2, str, i3);
        }
    }

    public void e(DressItemData dressItemData, boolean z) {
        if (dressItemData == null) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.f56823a.getPageActivity());
            return;
        }
        this.f56824b = dressItemData.getPropsId();
        BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
        backgroundSetRequestMessage.setFromDetail(z);
        backgroundSetRequestMessage.setRequestUniqueId(this.f56825c);
        backgroundSetRequestMessage.setPropId(this.f56824b);
        MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921004));
    }
}
