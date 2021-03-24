package d.b.i0.c2.k.e;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52562a;

    public a(TbPageContext tbPageContext) {
        this.f52562a = tbPageContext;
    }

    public final void a(PbModel pbModel, int i) {
        if (pbModel == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13719");
        statisticItem.param("fid", pbModel.I.m());
        statisticItem.param("tid", pbModel.I.N());
        statisticItem.param("obj_type", i);
        if (pbModel.x0() == 5) {
            statisticItem.param("obj_source", 1);
        } else if (pbModel.x0() == 7) {
            statisticItem.param("obj_source", 2);
        } else {
            statisticItem.param("obj_source", 3);
        }
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
    }

    public boolean b(PbModel pbModel) {
        d.b.i0.c2.h.e eVar;
        String str;
        String str2;
        int i = 0;
        if (this.f52562a.getPageActivity() != null && pbModel != null && (eVar = pbModel.I) != null) {
            if ("3".equals(eVar.e0)) {
                MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.f52562a.getPageActivity()).createNormalCfg(2);
                createNormalCfg.setSubTabName(this.f52562a.getString(R.string.tab_name_topic_rank));
                this.f52562a.sendMessage(new CustomMessage(2015002, createNormalCfg));
                return true;
            }
            String o = d.b.h0.r.d0.b.i().o("key_pb_back_sid1", "");
            String o2 = d.b.h0.r.d0.b.i().o("key_pb_back_sid2", "");
            if (TextUtils.isEmpty(o) || d.b.h0.b.c.d().b(o) == null) {
                str = (TextUtils.isEmpty(o2) || d.b.h0.b.c.d().b(o2) == null) ? null : "2";
            } else {
                str = "1";
            }
            if (str == null && (str2 = pbModel.I.d0) != null) {
                str = str2;
            }
            if (str == null) {
                return false;
            }
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.f52562a.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.f52562a.sendMessage(new CustomMessage(2015002, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.f52562a.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.I.e0);
                this.f52562a.sendMessage(new CustomMessage(2015002, createNormalCfg3));
                if ("游戏".equals(pbModel.I.e0)) {
                    i = 2;
                } else if ("数码".equals(pbModel.I.e0)) {
                    i = 3;
                }
                a(pbModel, i);
                return true;
            }
        }
        return false;
    }
}
