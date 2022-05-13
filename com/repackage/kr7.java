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
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
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
import com.repackage.nr4;
import java.text.MessageFormat;
/* loaded from: classes6.dex */
public class kr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbChosenActivity a;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kr7 a;

        public a(kr7 kr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kr7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.sendMessage(new CustomMessage(2001277));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.a.a.getPageContext().getPageActivity(), 23007)));
                TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ kr7 b;

        public b(kr7 kr7Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr7Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kr7Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ShareItem shareItem = this.a;
                shareItem.v = fz4.v(shareItem.v, shareItem.M, UtilHelper.isVideoThread(shareItem.O));
                bi.a(this.a.v);
                mi.N(this.b.a.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0447));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public c(nr7 nr7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nr7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nr7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            nr7 nr7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) || (nr7Var = this.a) == null || nr7Var.getThreadInfo() == null) {
                return;
            }
            mi.w(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
            Activity pageActivity = this.b.getPageContext().getPageActivity();
            long j = this.d;
            String str = this.e;
            String str2 = this.f;
            String str3 = this.g;
            String leaveMsg = this.c.getLeaveMsg();
            nr7 nr7Var2 = this.a;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, kr7.c(nr7Var2, nr7Var2.getThreadInfo().excid.longValue(), this.h).toChatMessageContent())));
            nr4Var.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                mi.w(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;
        public final /* synthetic */ String g;

        public e(nr7 nr7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nr7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, Long.valueOf(j2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nr7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = j2;
            this.g = str2;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            nr7 nr7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) || (nr7Var = this.a) == null || nr7Var.getThreadInfo() == null) {
                return;
            }
            mi.w(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
            Activity pageActivity = this.b.getPageContext().getPageActivity();
            long j = this.d;
            String str = this.e;
            long j2 = this.f;
            String leaveMsg = this.c.getLeaveMsg();
            nr7 nr7Var2 = this.a;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j, str, j2, "from_share", leaveMsg, kr7.c(nr7Var2, nr7Var2.getThreadInfo().excid.longValue(), this.g).toChatMessageContent())));
            nr4Var.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                mi.w(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                nr4Var.dismiss();
            }
        }
    }

    public kr7(PbChosenActivity pbChosenActivity) {
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

    public static ShareFromPBMsgData c(nr7 nr7Var, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{nr7Var, Long.valueOf(j), str})) == null) {
            if (nr7Var == null || nr7Var.getThreadInfo() == null) {
                return null;
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setContent(nr7Var.getThreadInfo()._abstract);
            shareFromPBMsgData.setImageUrl(str);
            shareFromPBMsgData.setForumName(nr7Var.getThreadInfo().forum.forum_name);
            shareFromPBMsgData.setPostId(null);
            shareFromPBMsgData.setThreadId(nr7Var.getThreadInfo().thread_id + "");
            shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
            shareFromPBMsgData.setTitle(nr7Var.getThreadInfo().title);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeCommon.objValue;
    }

    public static void d(PbChosenActivity pbChosenActivity, nr7 nr7Var, long j, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, nr7Var, Long.valueOf(j), str, Long.valueOf(j2), str2}) == null) || nr7Var == null || nr7Var.getThreadInfo() == null) {
            return;
        }
        nr4 nr4Var = new nr4(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.c(str2, false);
        shareThreadView.setTitle(nr7Var.getThreadInfo().title);
        shareThreadView.setDesc(nr7Var.getThreadInfo()._abstract);
        nr4Var.setContentView(shareThreadView);
        nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1129, new e(nr7Var, pbChosenActivity, shareThreadView, j, str, j2, str2));
        nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new f(pbChosenActivity, shareThreadView));
        nr4Var.setCanceledOnTouchOutside(false);
        nr4Var.create(pbChosenActivity.getPageContext()).show();
    }

    public static void e(PbChosenActivity pbChosenActivity, nr7 nr7Var, long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbChosenActivity, nr7Var, Long.valueOf(j), str, str2, str3, str4}) == null) || nr7Var == null || nr7Var.getThreadInfo() == null) {
            return;
        }
        nr4 nr4Var = new nr4(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.setTitle(nr7Var.getThreadInfo().title);
        shareThreadView.setDesc(nr7Var.getThreadInfo()._abstract);
        shareThreadView.c(str4, false);
        nr4Var.setContentView(shareThreadView);
        nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1129, new c(nr7Var, pbChosenActivity, shareThreadView, j, str, str2, str3, str4));
        nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new d(pbChosenActivity, shareThreadView));
        nr4Var.setCanceledOnTouchOutside(false);
        nr4Var.create(pbChosenActivity.getPageContext()).show();
    }

    public void f(nr7 nr7Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, nr7Var, str) == null) || nr7Var == null || nr7Var.getThreadInfo() == null || nr7Var.getThreadInfo().excid == null) {
            return;
        }
        String str2 = nr7Var.getThreadInfo().forum.forum_name;
        String str3 = nr7Var.getThreadInfo().title;
        String str4 = nr7Var.getThreadInfo()._abstract;
        Resources resources = this.a.getPageContext().getPageActivity().getResources();
        String format = MessageFormat.format(resources.getString(R.string.obfuscated_res_0x7f0f1131), str3, str4);
        resources.getString(R.string.obfuscated_res_0x7f0f03d3, str3);
        ShareItem shareItem = new ShareItem();
        shareItem.t = str3;
        shareItem.u = format;
        shareItem.v = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + nr7Var.getThreadInfo().excid;
        shareItem.F = str4;
        shareItem.E = Long.toString(nr7Var.getThreadInfo().excid.longValue());
        shareItem.M = Long.toString(nr7Var.getThreadInfo().thread_id.longValue());
        shareItem.a = true;
        if (!StringUtils.isNull(str)) {
            shareItem.x = Uri.parse(str);
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a.getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.addOutsideTextView(R.string.obfuscated_res_0x7f0f0669, R.drawable.icon_share_friends_n, new a(this));
        shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
        this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
