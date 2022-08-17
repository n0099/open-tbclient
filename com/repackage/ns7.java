package com.repackage;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.view.ShareThreadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur4;
import java.text.MessageFormat;
/* loaded from: classes6.dex */
public class ns7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbChosenActivity a;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ns7 a;

        public a(ns7 ns7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ns7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ns7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.sendMessage(new CustomMessage(2001277));
                TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ ns7 b;

        public b(ns7 ns7Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ns7Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ns7Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ShareItem shareItem = this.a;
                shareItem.w = f05.u(shareItem.w, shareItem.N, UtilHelper.isVideoThread(shareItem.P));
                fi.a(this.a.w);
                qi.N(this.b.a.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0450));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public c(qs7 qs7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            qs7 qs7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) || (qs7Var = this.a) == null || qs7Var.getThreadInfo() == null) {
                return;
            }
            qi.x(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
            Activity pageActivity = this.b.getPageContext().getPageActivity();
            long j = this.d;
            String str = this.e;
            String str2 = this.f;
            String str3 = this.g;
            String leaveMsg = this.c.getLeaveMsg();
            qs7 qs7Var2 = this.a;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, ns7.c(qs7Var2, qs7Var2.getThreadInfo().excid.longValue(), this.h).toChatMessageContent())));
            ur4Var.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;
        public final /* synthetic */ ShareThreadView b;

        public d(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, shareThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
            this.b = shareThreadView;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                qi.x(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;
        public final /* synthetic */ String g;

        public e(qs7 qs7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, Long.valueOf(j2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = j2;
            this.g = str2;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            qs7 qs7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) || (qs7Var = this.a) == null || qs7Var.getThreadInfo() == null) {
                return;
            }
            qi.x(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
            Activity pageActivity = this.b.getPageContext().getPageActivity();
            long j = this.d;
            String str = this.e;
            long j2 = this.f;
            String leaveMsg = this.c.getLeaveMsg();
            qs7 qs7Var2 = this.a;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j, str, j2, "from_share", leaveMsg, ns7.c(qs7Var2, qs7Var2.getThreadInfo().excid.longValue(), this.g).toChatMessageContent())));
            ur4Var.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;
        public final /* synthetic */ ShareThreadView b;

        public f(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, shareThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
            this.b = shareThreadView;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                qi.x(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                ur4Var.dismiss();
            }
        }
    }

    public ns7(PbChosenActivity pbChosenActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbChosenActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pbChosenActivity;
    }

    public static ShareFromPBMsgData c(qs7 qs7Var, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{qs7Var, Long.valueOf(j), str})) == null) {
            if (qs7Var == null || qs7Var.getThreadInfo() == null) {
                return null;
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setContent(qs7Var.getThreadInfo()._abstract);
            shareFromPBMsgData.setImageUrl(str);
            shareFromPBMsgData.setForumName(qs7Var.getThreadInfo().forum.forum_name);
            shareFromPBMsgData.setPostId(null);
            shareFromPBMsgData.setThreadId(qs7Var.getThreadInfo().thread_id + "");
            shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
            shareFromPBMsgData.setTitle(qs7Var.getThreadInfo().title);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeCommon.objValue;
    }

    public static void d(PbChosenActivity pbChosenActivity, qs7 qs7Var, long j, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, qs7Var, Long.valueOf(j), str, Long.valueOf(j2), str2}) == null) || qs7Var == null || qs7Var.getThreadInfo() == null) {
            return;
        }
        ur4 ur4Var = new ur4(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.c(str2, false);
        shareThreadView.setTitle(qs7Var.getThreadInfo().title);
        shareThreadView.setDesc(qs7Var.getThreadInfo()._abstract);
        ur4Var.setContentView(shareThreadView);
        ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1126, new e(qs7Var, pbChosenActivity, shareThreadView, j, str, j2, str2));
        ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new f(pbChosenActivity, shareThreadView));
        ur4Var.setCanceledOnTouchOutside(false);
        ur4Var.create(pbChosenActivity.getPageContext()).show();
    }

    public static void e(PbChosenActivity pbChosenActivity, qs7 qs7Var, long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbChosenActivity, qs7Var, Long.valueOf(j), str, str2, str3, str4}) == null) || qs7Var == null || qs7Var.getThreadInfo() == null) {
            return;
        }
        ur4 ur4Var = new ur4(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.setTitle(qs7Var.getThreadInfo().title);
        shareThreadView.setDesc(qs7Var.getThreadInfo()._abstract);
        shareThreadView.c(str4, false);
        ur4Var.setContentView(shareThreadView);
        ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1126, new c(qs7Var, pbChosenActivity, shareThreadView, j, str, str2, str3, str4));
        ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new d(pbChosenActivity, shareThreadView));
        ur4Var.setCanceledOnTouchOutside(false);
        ur4Var.create(pbChosenActivity.getPageContext()).show();
    }

    public void f(qs7 qs7Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, qs7Var, str) == null) || qs7Var == null || qs7Var.getThreadInfo() == null || qs7Var.getThreadInfo().excid == null) {
            return;
        }
        String str2 = qs7Var.getThreadInfo().forum.forum_name;
        String str3 = qs7Var.getThreadInfo().title;
        String str4 = qs7Var.getThreadInfo()._abstract;
        Resources resources = this.a.getPageContext().getPageActivity().getResources();
        String format = MessageFormat.format(resources.getString(R.string.obfuscated_res_0x7f0f112e), str3, str4);
        resources.getString(R.string.obfuscated_res_0x7f0f03d9, str3);
        ShareItem shareItem = new ShareItem();
        shareItem.u = str3;
        shareItem.v = format;
        shareItem.w = "https://tieba.baidu.com/mo/q/recommendpb?ftid=" + qs7Var.getThreadInfo().excid;
        shareItem.G = str4;
        shareItem.F = Long.toString(qs7Var.getThreadInfo().excid.longValue());
        shareItem.N = Long.toString(qs7Var.getThreadInfo().thread_id.longValue());
        shareItem.a = true;
        if (!StringUtils.isNull(str)) {
            shareItem.y = Uri.parse(str);
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a.getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.addOutsideTextView(R.string.obfuscated_res_0x7f0f0678, R.drawable.icon_share_friends_n, new a(this));
        shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
        this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
