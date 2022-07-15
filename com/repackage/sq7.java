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
import com.repackage.cr4;
import java.text.MessageFormat;
/* loaded from: classes7.dex */
public class sq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbChosenActivity a;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sq7 a;

        public a(sq7 sq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sq7Var;
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

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ sq7 b;

        public b(sq7 sq7Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq7Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sq7Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ShareItem shareItem = this.a;
                shareItem.w = jz4.v(shareItem.w, shareItem.N, UtilHelper.isVideoThread(shareItem.P));
                ei.a(this.a.w);
                pi.O(this.b.a.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0446));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public c(vq7 vq7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            vq7 vq7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) || (vq7Var = this.a) == null || vq7Var.getThreadInfo() == null) {
                return;
            }
            pi.x(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
            Activity pageActivity = this.b.getPageContext().getPageActivity();
            long j = this.d;
            String str = this.e;
            String str2 = this.f;
            String str3 = this.g;
            String leaveMsg = this.c.getLeaveMsg();
            vq7 vq7Var2 = this.a;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, sq7.c(vq7Var2, vq7Var2.getThreadInfo().excid.longValue(), this.h).toChatMessageContent())));
            cr4Var.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                pi.x(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;
        public final /* synthetic */ String g;

        public e(vq7 vq7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, Long.valueOf(j2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = j2;
            this.g = str2;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            vq7 vq7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) || (vq7Var = this.a) == null || vq7Var.getThreadInfo() == null) {
                return;
            }
            pi.x(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
            Activity pageActivity = this.b.getPageContext().getPageActivity();
            long j = this.d;
            String str = this.e;
            long j2 = this.f;
            String leaveMsg = this.c.getLeaveMsg();
            vq7 vq7Var2 = this.a;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j, str, j2, "from_share", leaveMsg, sq7.c(vq7Var2, vq7Var2.getThreadInfo().excid.longValue(), this.g).toChatMessageContent())));
            cr4Var.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                pi.x(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                cr4Var.dismiss();
            }
        }
    }

    public sq7(PbChosenActivity pbChosenActivity) {
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

    public static ShareFromPBMsgData c(vq7 vq7Var, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{vq7Var, Long.valueOf(j), str})) == null) {
            if (vq7Var == null || vq7Var.getThreadInfo() == null) {
                return null;
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setContent(vq7Var.getThreadInfo()._abstract);
            shareFromPBMsgData.setImageUrl(str);
            shareFromPBMsgData.setForumName(vq7Var.getThreadInfo().forum.forum_name);
            shareFromPBMsgData.setPostId(null);
            shareFromPBMsgData.setThreadId(vq7Var.getThreadInfo().thread_id + "");
            shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
            shareFromPBMsgData.setTitle(vq7Var.getThreadInfo().title);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeCommon.objValue;
    }

    public static void d(PbChosenActivity pbChosenActivity, vq7 vq7Var, long j, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, vq7Var, Long.valueOf(j), str, Long.valueOf(j2), str2}) == null) || vq7Var == null || vq7Var.getThreadInfo() == null) {
            return;
        }
        cr4 cr4Var = new cr4(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.c(str2, false);
        shareThreadView.setTitle(vq7Var.getThreadInfo().title);
        shareThreadView.setDesc(vq7Var.getThreadInfo()._abstract);
        cr4Var.setContentView(shareThreadView);
        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f113c, new e(vq7Var, pbChosenActivity, shareThreadView, j, str, j2, str2));
        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new f(pbChosenActivity, shareThreadView));
        cr4Var.setCanceledOnTouchOutside(false);
        cr4Var.create(pbChosenActivity.getPageContext()).show();
    }

    public static void e(PbChosenActivity pbChosenActivity, vq7 vq7Var, long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbChosenActivity, vq7Var, Long.valueOf(j), str, str2, str3, str4}) == null) || vq7Var == null || vq7Var.getThreadInfo() == null) {
            return;
        }
        cr4 cr4Var = new cr4(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.setTitle(vq7Var.getThreadInfo().title);
        shareThreadView.setDesc(vq7Var.getThreadInfo()._abstract);
        shareThreadView.c(str4, false);
        cr4Var.setContentView(shareThreadView);
        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f113c, new c(vq7Var, pbChosenActivity, shareThreadView, j, str, str2, str3, str4));
        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new d(pbChosenActivity, shareThreadView));
        cr4Var.setCanceledOnTouchOutside(false);
        cr4Var.create(pbChosenActivity.getPageContext()).show();
    }

    public void f(vq7 vq7Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, vq7Var, str) == null) || vq7Var == null || vq7Var.getThreadInfo() == null || vq7Var.getThreadInfo().excid == null) {
            return;
        }
        String str2 = vq7Var.getThreadInfo().forum.forum_name;
        String str3 = vq7Var.getThreadInfo().title;
        String str4 = vq7Var.getThreadInfo()._abstract;
        Resources resources = this.a.getPageContext().getPageActivity().getResources();
        String format = MessageFormat.format(resources.getString(R.string.obfuscated_res_0x7f0f1144), str3, str4);
        resources.getString(R.string.obfuscated_res_0x7f0f03ce, str3);
        ShareItem shareItem = new ShareItem();
        shareItem.u = str3;
        shareItem.v = format;
        shareItem.w = "https://tieba.baidu.com/mo/q/recommendpb?ftid=" + vq7Var.getThreadInfo().excid;
        shareItem.G = str4;
        shareItem.F = Long.toString(vq7Var.getThreadInfo().excid.longValue());
        shareItem.N = Long.toString(vq7Var.getThreadInfo().thread_id.longValue());
        shareItem.a = true;
        if (!StringUtils.isNull(str)) {
            shareItem.y = Uri.parse(str);
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a.getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.addOutsideTextView(R.string.obfuscated_res_0x7f0f066e, R.drawable.icon_share_friends_n, new a(this));
        shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
        this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
