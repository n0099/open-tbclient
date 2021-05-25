package d.a.n0.e2.k.e;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53191a;

    public c(TbPageContext tbPageContext) {
        this.f53191a = tbPageContext;
    }

    public final void a(PbModel pbModel, int i2) {
        if (pbModel == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13719");
        statisticItem.param("fid", pbModel.I.m());
        statisticItem.param("tid", pbModel.I.N());
        statisticItem.param("obj_type", i2);
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
        d.a.n0.e2.h.e eVar;
        String str;
        String str2;
        int i2 = 0;
        if (this.f53191a.getPageActivity() != null && pbModel != null && (eVar = pbModel.I) != null) {
            if ("3".equals(eVar.e0)) {
                MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.f53191a.getPageActivity()).createNormalCfg(2);
                createNormalCfg.setSubTabName(this.f53191a.getString(R.string.tab_name_topic_rank));
                this.f53191a.sendMessage(new CustomMessage(2015002, createNormalCfg));
                return true;
            }
            String p = d.a.m0.r.d0.b.j().p("key_pb_back_sid1", "");
            String p2 = d.a.m0.r.d0.b.j().p("key_pb_back_sid2", "");
            if (TextUtils.isEmpty(p) || d.a.m0.b.c.d().b(p) == null) {
                str = (TextUtils.isEmpty(p2) || d.a.m0.b.c.d().b(p2) == null) ? null : "2";
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
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.f53191a.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.f53191a.sendMessage(new CustomMessage(2015002, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.f53191a.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.I.e0);
                this.f53191a.sendMessage(new CustomMessage(2015002, createNormalCfg3));
                if ("游戏".equals(pbModel.I.e0)) {
                    i2 = 2;
                } else if ("数码".equals(pbModel.I.e0)) {
                    i2 = 3;
                }
                a(pbModel, i2);
                return true;
            }
        }
        return false;
    }
}
