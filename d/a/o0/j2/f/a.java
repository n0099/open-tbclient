package d.a.o0.j2.f;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import d.a.o0.v3.f;
/* loaded from: classes5.dex */
public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60256a;

    /* renamed from: b  reason: collision with root package name */
    public int f60257b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f60258c = 2;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60259d = false;

    public a(TbPageContext tbPageContext) {
        this.f60256a = tbPageContext;
    }

    @Override // d.a.o0.v3.f
    public void a(View view, d.a.o0.k0.a aVar) {
        if (aVar == null) {
            return;
        }
        UserData userData = null;
        Bundle bundle = aVar.f60401b;
        if (bundle != null && (userData = (UserData) bundle.getSerializable(UserData.TYPE_USER)) != null) {
            this.f60257b = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
            this.f60258c = userData.isGod() ? 1 : 2;
            this.f60259d = this.f60257b == 1;
        }
        switch (aVar.f60400a) {
            case 2:
                if (ViewHelper.checkUpIsLogin(this.f60256a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.f60256a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            case 3:
                if (userData == null) {
                    return;
                }
                d.a.n0.l.a.o(this.f60256a.getPageActivity(), this.f60256a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                return;
            case 4:
                if (userData == null) {
                    return;
                }
                if (aVar instanceof d.a.o0.h2.f.a) {
                    TiebaStatic.log(new StatisticItem("c11586"));
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", this.f60257b).param("obj_source", this.f60258c));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f60256a.getPageActivity(), true, userData.getUserId(), userData.getSex()).updateFollowNum(userData.getConcernNum(), userData.getPortrait())));
                return;
            case 5:
                d.a.o0.u2.a.v().L(2, false, this.f60259d);
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", this.f60257b).param("obj_source", this.f60258c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f60256a.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                return;
            case 6:
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 1).param("obj_type", this.f60257b).param("obj_source", this.f60258c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.f60256a.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                return;
            case 7:
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", this.f60257b).param("obj_source", this.f60258c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f60256a.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                return;
            default:
                return;
        }
    }
}
