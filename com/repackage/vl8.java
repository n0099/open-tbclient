package com.repackage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
/* loaded from: classes7.dex */
public class vl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final al8 b;

    /* loaded from: classes7.dex */
    public class a implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl8 a;

        /* renamed from: com.repackage.vl8$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0749a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ a b;

            public RunnableC0749a(a aVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    os7.a(this.b.a.a.getPageContext(), this.a).show();
                }
            }
        }

        public a(vl8 vl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl8Var;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                qg.a().postDelayed(new RunnableC0749a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ShareFromPBMsgData f;
        public final /* synthetic */ vl8 g;

        public b(vl8 vl8Var, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl8Var, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vl8Var;
            this.a = thread2GroupShareView;
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = shareFromPBMsgData;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.g.a.HidenSoftKeyPad((InputMethodManager) this.g.a.getSystemService("input_method"), this.a.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.g.a.getPageContext().getPageActivity(), this.b, this.c, this.d, this.e, 0, this.a.getLeaveMsg(), this.f.toChatMessageContent())));
                cr4Var.dismiss();
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem == null || shareItem.e() == null) {
                    return;
                }
                Bundle e = shareItem.e();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", e.getInt("obj_type")).param("obj_param1", 3).param("fid", e.getString("fid")).param("tid", e.getString("tid")).param("obj_locate", 5));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread2GroupShareView a;
        public final /* synthetic */ vl8 b;

        public c(vl8 vl8Var, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl8Var, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vl8Var;
            this.a = thread2GroupShareView;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.b.a.HidenSoftKeyPad((InputMethodManager) this.b.a.getSystemService("input_method"), this.a.getChatMsgView());
                cr4Var.dismiss();
            }
        }
    }

    public vl8(MainTabActivity mainTabActivity, al8 al8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, al8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = al8Var;
    }

    public final void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        PostWriteCallBackData postWriteCallBackData = null;
        try {
            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        } catch (Exception e) {
            BdLog.e(e);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921030, postWriteCallBackData));
        al8 al8Var = this.b;
        if (al8Var == null || al8Var.w(postWriteCallBackData)) {
            return;
        }
        this.b.T(postWriteCallBackData);
    }

    public final ShareFromPBMsgData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData.getIfpost() == 0) {
                pi.O(this.a.getPageContext().getPageActivity(), antiData.getForbid_info());
            } else if (WriteActivityConfig.isAsyncWriting()) {
            } else {
                antiData.setIfVoice(false);
                WriteActivityConfig.newInstance(this.a).setType(0).setFrom(this.a.d).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setFeedBack(true).setAntiData(antiData).send();
            }
        }
    }

    public final void e(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            g(c(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    public void f(int i, int i2, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) {
            if (i2 != -1) {
                if (i == 25059) {
                    wj5.d();
                } else if (i == 25060) {
                    wj5.d();
                }
            }
            if (ve5.c(i, i2, intent)) {
                return;
            }
            if (i2 != -1) {
                al8 al8Var = this.b;
                if (al8Var == null || al8Var.B() == null || this.b.B().getCurrentFragment() == null) {
                    return;
                }
                this.b.B().getCurrentFragment().onActivityResult(i, i2, intent);
            } else if (i == 25046) {
                if (TbadkCoreApplication.isLogin()) {
                    zi4.f().k(this.a.getPageContext());
                }
            } else if (i == 11001) {
                d();
            } else if (i == 25066) {
                MainTabActivity mainTabActivity = this.a;
                mainTabActivity.c = true;
                mainTabActivity.b = mainTabActivity.getCurrentTabType();
                TbSingleton.getInstance().setVideoChannelRelogin(true);
            } else if (i == 13003 || i == 25048) {
                b(intent);
            } else if (i == 23007) {
                e(intent);
            } else if (i == 13011) {
                v88.g().m(this.a.getPageContext());
            } else if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    v88.g().m(this.a.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (shareItem != null) {
                        int i3 = shareItem.L;
                        if (i3 == 0) {
                            statisticItem.param("obj_locate", 15);
                        } else {
                            statisticItem.param("obj_locate", i3);
                        }
                    }
                    if (shareItem != null) {
                        statisticItem.param("tid", shareItem.N);
                    }
                    statisticItem.param("pid", intent.getStringExtra("pid"));
                    TiebaStatic.log(statisticItem);
                    if (shareItem == null || (str = shareItem.w) == null || (shareSuccessReplyToServerModel = this.a.v) == null) {
                        return;
                    }
                    shareSuccessReplyToServerModel.A(str, intExtra2, new a(this));
                }
            } else if (i == 25059) {
                if (UbsABTestHelper.isFirstLoginTestA()) {
                    if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkCoreApplication.isLogin()) {
                        InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(this.a, 4);
                        interestGuideActivityConfig.setRequestCode(25060);
                        interestGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
                        return;
                    }
                    return;
                }
                wj5.d();
            } else if (i == 25060) {
                if (UbsABTestHelper.isFirstLoginTestB()) {
                    if (TbadkCoreApplication.isLogin()) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921535, this));
                    return;
                }
                wj5.d();
            } else if (i == 25064) {
                MainTabActivity mainTabActivity2 = this.a;
                pw8 pw8Var = mainTabActivity2.r;
                if (pw8Var != null) {
                    pw8Var.o(mainTabActivity2.getPageContext());
                }
            } else if (i == 25071) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra(LoginDialogActivityConfig.HOME_OPERATE_JUMP_URL);
                    if (TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a, null, stringExtra, true)));
                }
            } else {
                al8 al8Var2 = this.b;
                if (al8Var2 == null || al8Var2.B() == null || this.b.B().getCurrentFragment() == null) {
                    return;
                }
                this.b.B().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
    }

    public final void g(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{shareFromPBMsgData, Long.valueOf(j), str, str2, str3}) == null) || shareFromPBMsgData == null) {
            return;
        }
        cr4 cr4Var = new cr4(this.a.getPageContext().getPageActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.a.getPageContext().getPageActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        cr4Var.setContentViewSize(1);
        cr4Var.setContentView(thread2GroupShareView);
        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f113c, new b(this, thread2GroupShareView, j, str, str2, str3, shareFromPBMsgData));
        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new c(this, thread2GroupShareView));
        cr4Var.setCanceledOnTouchOutside(true);
        cr4Var.create(this.a.getPageContext()).show();
        if (oi.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
    }
}
