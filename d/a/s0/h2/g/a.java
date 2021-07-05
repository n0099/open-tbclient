package d.a.s0.h2.g;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import d.a.c.e.p.l;
import d.a.r0.r.s.a;
import d.a.r0.s.g.g;
import java.text.MessageFormat;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbChosenActivity f60045a;

    /* renamed from: d.a.s0.h2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1449a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f60046e;

        public View$OnClickListenerC1449a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60046e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60046e.f60045a.sendMessage(new CustomMessage(2001277));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.f60046e.f60045a.getPageContext().getPageActivity(), 23007)));
                TiebaStatic.eventStat(this.f60046e.f60045a.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f60047e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f60048f;

        public b(a aVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60048f = aVar;
            this.f60047e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ShareItem shareItem = this.f60047e;
                shareItem.t = g.o(shareItem.t, shareItem.K);
                d.a.c.e.p.a.a(this.f60047e.t);
                l.M(this.f60048f.f60045a.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.h2.g.c.a f60049e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f60050f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f60051g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f60052h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f60053i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public c(d.a.s0.h2.g.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, pbChosenActivity, shareThreadView, Long.valueOf(j), str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60049e = aVar;
            this.f60050f = pbChosenActivity;
            this.f60051g = shareThreadView;
            this.f60052h = j;
            this.f60053i = str;
            this.j = str2;
            this.k = str3;
            this.l = str4;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            d.a.s0.h2.g.c.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f60049e) == null || aVar2.getThreadInfo() == null) {
                return;
            }
            l.x(this.f60050f.getPageContext().getPageActivity(), this.f60051g.getChatMsgView());
            Activity pageActivity = this.f60050f.getPageContext().getPageActivity();
            long j = this.f60052h;
            String str = this.f60053i;
            String str2 = this.j;
            String str3 = this.k;
            String leaveMsg = this.f60051g.getLeaveMsg();
            d.a.s0.h2.g.c.a aVar3 = this.f60049e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.l).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f60054e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f60055f;

        public d(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, shareThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60054e = pbChosenActivity;
            this.f60055f = shareThreadView;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                l.x(this.f60054e.getPageContext().getPageActivity(), this.f60055f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.h2.g.c.a f60056e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f60057f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f60058g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f60059h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f60060i;
        public final /* synthetic */ long j;
        public final /* synthetic */ String k;

        public e(d.a.s0.h2.g.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, pbChosenActivity, shareThreadView, Long.valueOf(j), str, Long.valueOf(j2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60056e = aVar;
            this.f60057f = pbChosenActivity;
            this.f60058g = shareThreadView;
            this.f60059h = j;
            this.f60060i = str;
            this.j = j2;
            this.k = str2;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            d.a.s0.h2.g.c.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f60056e) == null || aVar2.getThreadInfo() == null) {
                return;
            }
            l.x(this.f60057f.getPageContext().getPageActivity(), this.f60058g.getChatMsgView());
            Activity pageActivity = this.f60057f.getPageContext().getPageActivity();
            long j = this.f60059h;
            String str = this.f60060i;
            long j2 = this.j;
            String leaveMsg = this.f60058g.getLeaveMsg();
            d.a.s0.h2.g.c.a aVar3 = this.f60056e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j, str, j2, "from_share", leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.k).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public static class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f60061e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f60062f;

        public f(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, shareThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60061e = pbChosenActivity;
            this.f60062f = shareThreadView;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                l.x(this.f60061e.getPageContext().getPageActivity(), this.f60062f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    public a(PbChosenActivity pbChosenActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbChosenActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60045a = pbChosenActivity;
    }

    public static ShareFromPBMsgData c(d.a.s0.h2.g.c.a aVar, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{aVar, Long.valueOf(j), str})) == null) {
            if (aVar == null || aVar.getThreadInfo() == null) {
                return null;
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setContent(aVar.getThreadInfo()._abstract);
            shareFromPBMsgData.setImageUrl(str);
            shareFromPBMsgData.setForumName(aVar.getThreadInfo().forum.forum_name);
            shareFromPBMsgData.setPostId(null);
            shareFromPBMsgData.setThreadId(aVar.getThreadInfo().thread_id + "");
            shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
            shareFromPBMsgData.setTitle(aVar.getThreadInfo().title);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeCommon.objValue;
    }

    public static void d(PbChosenActivity pbChosenActivity, d.a.s0.h2.g.c.a aVar, long j, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{pbChosenActivity, aVar, Long.valueOf(j), str, Long.valueOf(j2), str2}) == null) || aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        d.a.r0.r.s.a aVar2 = new d.a.r0.r.s.a(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.c(str2, false);
        shareThreadView.setTitle(aVar.getThreadInfo().title);
        shareThreadView.setDesc(aVar.getThreadInfo()._abstract);
        aVar2.setContentView(shareThreadView);
        aVar2.setPositiveButton(R.string.share, new e(aVar, pbChosenActivity, shareThreadView, j, str, j2, str2));
        aVar2.setNegativeButton(R.string.cancel, new f(pbChosenActivity, shareThreadView));
        aVar2.setCanceledOnTouchOutside(false);
        aVar2.create(pbChosenActivity.getPageContext()).show();
    }

    public static void e(PbChosenActivity pbChosenActivity, d.a.s0.h2.g.c.a aVar, long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{pbChosenActivity, aVar, Long.valueOf(j), str, str2, str3, str4}) == null) || aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        d.a.r0.r.s.a aVar2 = new d.a.r0.r.s.a(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.setTitle(aVar.getThreadInfo().title);
        shareThreadView.setDesc(aVar.getThreadInfo()._abstract);
        shareThreadView.c(str4, false);
        aVar2.setContentView(shareThreadView);
        aVar2.setPositiveButton(R.string.share, new c(aVar, pbChosenActivity, shareThreadView, j, str, str2, str3, str4));
        aVar2.setNegativeButton(R.string.cancel, new d(pbChosenActivity, shareThreadView));
        aVar2.setCanceledOnTouchOutside(false);
        aVar2.create(pbChosenActivity.getPageContext()).show();
    }

    public void f(d.a.s0.h2.g.c.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) || aVar == null || aVar.getThreadInfo() == null || aVar.getThreadInfo().excid == null) {
            return;
        }
        String str2 = aVar.getThreadInfo().forum.forum_name;
        String str3 = aVar.getThreadInfo().title;
        String str4 = aVar.getThreadInfo()._abstract;
        Resources resources = this.f60045a.getPageContext().getPageActivity().getResources();
        String format = MessageFormat.format(resources.getString(R.string.share_content_tpl), str3, str4);
        resources.getString(R.string.chosen_pb_share_content, str3);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        shareItem.t = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getThreadInfo().excid;
        shareItem.D = str4;
        shareItem.C = Long.toString(aVar.getThreadInfo().excid.longValue());
        shareItem.K = Long.toString(aVar.getThreadInfo().thread_id.longValue());
        shareItem.f12821a = true;
        if (!StringUtils.isNull(str)) {
            shareItem.v = Uri.parse(str);
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f60045a.getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_share_friends_n, new View$OnClickListenerC1449a(this));
        shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
        this.f60045a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
