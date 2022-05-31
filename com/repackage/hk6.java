package com.repackage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.h5.FrsTabWebFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dq4;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class hk6 extends qk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kk6 h;
    public gd6 i;
    public final CustomMessageListener j;
    public final CustomMessageListener k;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hk6 hk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                if (this.a.h != null) {
                    this.a.h.j(postWriteCallBackData);
                }
                if (!this.a.l(postWriteCallBackData)) {
                    this.a.e(postWriteCallBackData);
                } else {
                    dy4.c(this.a.b.i(), postWriteCallBackData, 1);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(hk6 hk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof id6)) {
                this.a.i.B(((id6) customResponsedMessage.getData()).a());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ShareFromPBMsgData f;
        public final /* synthetic */ hk6 g;

        public c(hk6 hk6Var, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk6Var, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = hk6Var;
            this.a = thread2GroupShareView;
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = shareFromPBMsgData;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.g.b.getActivity().getSystemService("input_method");
                li.x(this.g.b.getActivity(), this.a.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.g.b.getActivity(), this.b, this.c, this.d, this.e, 0, this.a.getLeaveMsg(), this.f.toChatMessageContent())));
                dq4Var.dismiss();
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem == null || shareItem.e() == null) {
                    return;
                }
                Bundle e = shareItem.e();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", e.getInt("obj_type")).param("obj_param1", 3).param("fid", e.getString("fid")).param("tid", e.getString("tid")));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ hk6 b;

        public d(hk6 hk6Var, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk6Var, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hk6Var;
            this.a = thread2GroupShareView;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                li.x(this.b.b.getActivity(), this.a.getChatMsgView());
                dq4Var.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hk6(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this, 2001383);
        this.k = new b(this, 2921662);
        this.h = this.b.C2();
        this.j.setTag(this.b.getPageContext().getUniqueId());
        this.j.setSelfListener(true);
        this.b.registerListener(this.j);
        this.k.setTag(this.b.getUniqueId());
        this.k.setSelfListener(true);
        this.b.registerListener(this.k);
        this.i = new gd6(this.b);
    }

    public static void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11959");
        statisticItem.param("tid", str);
        statisticItem.param("fid", str2);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
    }

    public final boolean e(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ki.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (ys4.k().h(ys4.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.b.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.h == null) {
            this.h = this.b.C2();
        }
    }

    public final ShareFromPBMsgData g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            if (shareItem == null) {
                return null;
            }
            Uri uri = shareItem.y;
            String uri2 = uri == null ? "https://tb5.bdstatic.com/yunying/tieba_logo.jpg" : uri.toString();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setTitle(shareItem.u);
            shareFromPBMsgData.setContent(shareItem.G);
            shareFromPBMsgData.setImageUrl(uri2);
            shareFromPBMsgData.setForumName(shareItem.s);
            shareFromPBMsgData.setThreadId(shareItem.N);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeV.objValue;
    }

    public final void h(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<jn> e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, frsViewData, intent, str) == null) || frsViewData == null || intent == null || TextUtils.isEmpty(str) || this.e == null) {
            return;
        }
        int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        if (this.e.v0()) {
            Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
            if (!(serializableExtra instanceof CardHListViewData) || (e = this.g.e()) == null) {
                return;
            }
            CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
            cardHListViewData.threadId = str;
            if (im6.a(e, str, cardHListViewData, intExtra)) {
                frsViewData.setThreadList(e);
                this.a.D1(e, frsViewData);
                q(str, this.b.b());
            }
        }
    }

    public final void i(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, intent) == null) && i == 18003) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public final void j(int i, Intent intent) {
        ThreadData threadDataById;
        ShareItem shareItem;
        jo6 jo6Var;
        fo6 Y;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, intent) == null) {
            FrsViewData h0 = this.b.h0();
            switch (i) {
                case 11001:
                    this.b.p4(0);
                    return;
                case 11002:
                    this.d.w0(true);
                    return;
                case 11011:
                    FrsFragment frsFragment = this.b;
                    String O2 = frsFragment.O2();
                    FrsFragment frsFragment2 = this.b;
                    zn6.g(frsFragment, O2, frsFragment2.x, frsFragment2.Y2());
                    return;
                case 11012:
                    FrsFragment frsFragment3 = this.b;
                    String O22 = frsFragment3.O2();
                    FrsFragment frsFragment4 = this.b;
                    zn6.h(frsFragment3, O22, frsFragment4.x, frsFragment4.Y2());
                    return;
                case 11014:
                    this.d.x0();
                    return;
                case 11016:
                    this.a.P1();
                    return;
                case 11036:
                    this.d.y0();
                    return;
                case 18003:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                    this.a.W().notifyDataSetChanged();
                    jo6 jo6Var2 = this.d;
                    if (jo6Var2 != null) {
                        jo6Var2.Z();
                    }
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 4) {
                        this.b.q3(6);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra == null || (threadDataById = h0.getThreadDataById(stringExtra)) == null) {
                        return;
                    }
                    if (intExtra == 2) {
                        threadDataById.setIs_good(intent.getIntExtra("good_data", 0));
                        threadDataById.parser_title();
                    }
                    h(h0, intent, stringExtra);
                    return;
                case 18004:
                    zn6.e(this.b.getPageContext(), h0);
                    return;
                case 23003:
                    if (intent == null || h0 == null) {
                        return;
                    }
                    vn6.e(this.b, h0, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                case 23007:
                    k(intent);
                    return;
                case 24002:
                    if (intent == null) {
                        return;
                    }
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == jg.e(this.b.b(), 0)) {
                        this.d.z0(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                case 24007:
                    int intExtra6 = intent.getIntExtra("extra_share_status", 2);
                    if (intExtra6 == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null) {
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", shareItem.N);
                        statisticItem.param("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(statisticItem);
                    }
                    if (intExtra6 == 1) {
                        this.b.n3(intent.getStringExtra("tid"));
                        return;
                    }
                    return;
                case 25041:
                    this.c.b(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                    return;
                case 25050:
                    this.b.refresh();
                    return;
                case 25052:
                    String stringExtra2 = intent.getStringExtra("group_name");
                    boolean booleanExtra = intent.getBooleanExtra("from", true);
                    this.b.j4(stringExtra2);
                    if (booleanExtra || (jo6Var = this.d) == null) {
                        return;
                    }
                    jo6Var.R();
                    return;
                case 25054:
                    lb6 y0 = this.b.y0();
                    if (y0 == null || (Y = y0.Y()) == null) {
                        return;
                    }
                    Y.C();
                    return;
                default:
                    return;
            }
        }
    }

    public final void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            p(g(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    public final boolean l(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, postWriteCallBackData)) == null) ? (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) ? false : true : invokeL.booleanValue;
    }

    public void m(int i) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (frsFragment = this.b) == null || frsFragment.M2() == null) {
            return;
        }
        if (i > 0) {
            FrsTabViewController.p J = this.b.M2().J(i);
            if (J != null) {
                Fragment fragment = J.b;
                if ((fragment instanceof FrsCommonTabFragment) || (fragment instanceof FrsTabWebFragment)) {
                    this.c.b(i);
                    return;
                }
                return;
            }
            return;
        }
        int F = this.b.M2().F();
        if (this.b.M2().J(F) != null) {
            this.c.b(F);
        }
    }

    public void n(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, intent) == null) {
            f();
            if (dd5.c(i, i2, intent)) {
                return;
            }
            if (i2 == -1) {
                j(i, intent);
            } else if (i2 == 0) {
                i(i, intent);
            }
            gd6 gd6Var = this.i;
            if (gd6Var == null || gd6Var.r() == null) {
                return;
            }
            this.i.r().a(i, i2, intent);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            gd6 gd6Var = this.i;
            if (gd6Var != null) {
                gd6Var.p();
            }
        }
    }

    public final void p(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{shareFromPBMsgData, Long.valueOf(j), str, str2, str3}) == null) || shareFromPBMsgData == null) {
            return;
        }
        dq4 dq4Var = new dq4(this.b.getActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.b.getActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        dq4Var.setContentViewSize(1);
        dq4Var.setContentView(thread2GroupShareView);
        dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f113a, new c(this, thread2GroupShareView, j, str, str2, str3, shareFromPBMsgData));
        dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new d(this, thread2GroupShareView));
        dq4Var.setCanceledOnTouchOutside(true);
        dq4Var.create(this.b.getPageContext()).show();
        if (ki.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
    }
}
