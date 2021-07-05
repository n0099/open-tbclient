package d.a.s0.m2.f;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.z3.f;
/* loaded from: classes9.dex */
public class a implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63523a;

    /* renamed from: b  reason: collision with root package name */
    public int f63524b;

    /* renamed from: c  reason: collision with root package name */
    public int f63525c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63526d;

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63524b = 1;
        this.f63525c = 2;
        this.f63526d = false;
        this.f63523a = tbPageContext;
    }

    @Override // d.a.s0.z3.f
    public void a(View view, d.a.s0.m0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || aVar == null) {
            return;
        }
        UserData userData = null;
        Bundle bundle = aVar.f63325b;
        if (bundle != null && (userData = (UserData) bundle.getSerializable(UserData.TYPE_USER)) != null) {
            this.f63524b = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
            this.f63525c = userData.isGod() ? 1 : 2;
            this.f63526d = this.f63524b == 1;
        }
        switch (aVar.f63324a) {
            case 2:
                if (ViewHelper.checkUpIsLogin(this.f63523a.getPageActivity())) {
                    UrlManager.getInstance().dealOneLink(this.f63523a, new String[]{TbConfig.URL_MEMBER_BUY});
                    return;
                }
                return;
            case 3:
                if (userData == null) {
                    return;
                }
                d.a.r0.l.a.o(this.f63523a.getPageActivity(), this.f63523a.getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                return;
            case 4:
                if (userData == null) {
                    return;
                }
                if (aVar instanceof d.a.s0.k2.f.a) {
                    TiebaStatic.log(new StatisticItem("c11586"));
                } else {
                    TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 2).param("obj_type", this.f63524b).param("obj_source", this.f63525c));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f63523a.getPageActivity(), true, userData.getUserId(), userData.getSex()).updateFollowNum(userData.getConcernNum(), userData.getPortrait())));
                return;
            case 5:
                d.a.s0.x2.a.v().L(2, false, this.f63526d);
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 3).param("obj_type", this.f63524b).param("obj_source", this.f63525c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f63523a.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                return;
            case 6:
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 1).param("obj_type", this.f63524b).param("obj_source", this.f63525c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.f63523a.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                return;
            case 7:
                if (userData == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11597").param("obj_locate", 4).param("obj_type", this.f63524b).param("obj_source", this.f63525c));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f63523a.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                return;
            default:
                return;
        }
    }
}
