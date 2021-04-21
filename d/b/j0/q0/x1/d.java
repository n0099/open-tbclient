package d.b.j0.q0.x1;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.i0.r.s.a;
/* loaded from: classes4.dex */
public class d {

    /* loaded from: classes4.dex */
    public static class a implements a.e {
        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            if (aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f60837e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f60838f;

        public b(TbPageContext tbPageContext, BlockPopInfoData blockPopInfoData) {
            this.f60837e = tbPageContext;
            this.f60838f = blockPopInfoData;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            UrlManager.getInstance().dealOneLink(this.f60837e, new String[]{this.f60838f.ahead_url});
            if (aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    public static boolean a(TbPageContext<?> tbPageContext, FrsViewData frsViewData) {
        String fixedText;
        if (tbPageContext != null && frsViewData != null) {
            if (!ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
                return true;
            }
            AntiData anti = frsViewData.getAnti();
            if (anti != null) {
                if (b(tbPageContext, anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                    String forbid_info = anti.getForbid_info();
                    if (StringHelper.getRealSize(forbid_info) > 14) {
                        forbid_info = StringHelper.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast i = BdToast.i(tbPageContext.getPageActivity(), forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                    i.k(1.25f);
                    i.q();
                }
            }
        }
        return false;
    }

    public static boolean b(TbPageContext<?> tbPageContext, int i, BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? tbPageContext.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast i2 = BdToast.i(tbPageContext.getPageActivity(), string, R.drawable.icon_pure_toast_mistake40_svg, true);
            i2.k(1.25f);
            i2.q();
            return false;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(tbPageContext.getPageActivity());
        aVar.setMessage(StringHelper.getFixedText(string, 50, true));
        aVar.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? tbPageContext.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a());
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new b(tbPageContext, blockPopInfoData));
        }
        aVar.create(tbPageContext).show();
        return true;
    }
}
