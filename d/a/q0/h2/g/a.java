package d.a.q0.h2.g;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.l;
import d.a.p0.s.s.a;
import d.a.p0.t.g.g;
import java.text.MessageFormat;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbChosenActivity f57345a;

    /* renamed from: d.a.q0.h2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1413a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57346e;

        public View$OnClickListenerC1413a(a aVar) {
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
            this.f57346e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57346e.f57345a.sendMessage(new CustomMessage(2001277));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.f57346e.f57345a.getPageContext().getPageActivity(), 23007)));
                TiebaStatic.eventStat(this.f57346e.f57345a.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f57347e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f57348f;

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
            this.f57348f = aVar;
            this.f57347e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ShareItem shareItem = this.f57347e;
                shareItem.t = g.o(shareItem.t, shareItem.K);
                d.a.d.e.p.a.a(this.f57347e.t);
                l.M(this.f57348f.f57345a.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h2.g.c.a f57349e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f57350f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f57351g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f57352h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f57353i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public c(d.a.q0.h2.g.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
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
            this.f57349e = aVar;
            this.f57350f = pbChosenActivity;
            this.f57351g = shareThreadView;
            this.f57352h = j;
            this.f57353i = str;
            this.j = str2;
            this.k = str3;
            this.l = str4;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            d.a.q0.h2.g.c.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f57349e) == null || aVar2.getThreadInfo() == null) {
                return;
            }
            l.x(this.f57350f.getPageContext().getPageActivity(), this.f57351g.getChatMsgView());
            Activity pageActivity = this.f57350f.getPageContext().getPageActivity();
            long j = this.f57352h;
            String str = this.f57353i;
            String str2 = this.j;
            String str3 = this.k;
            String leaveMsg = this.f57351g.getLeaveMsg();
            d.a.q0.h2.g.c.a aVar3 = this.f57349e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.l).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f57354e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f57355f;

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
            this.f57354e = pbChosenActivity;
            this.f57355f = shareThreadView;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                l.x(this.f57354e.getPageContext().getPageActivity(), this.f57355f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h2.g.c.a f57356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f57357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f57358g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f57359h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f57360i;
        public final /* synthetic */ long j;
        public final /* synthetic */ String k;

        public e(d.a.q0.h2.g.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, long j2, String str2) {
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
            this.f57356e = aVar;
            this.f57357f = pbChosenActivity;
            this.f57358g = shareThreadView;
            this.f57359h = j;
            this.f57360i = str;
            this.j = j2;
            this.k = str2;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            d.a.q0.h2.g.c.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f57356e) == null || aVar2.getThreadInfo() == null) {
                return;
            }
            l.x(this.f57357f.getPageContext().getPageActivity(), this.f57358g.getChatMsgView());
            Activity pageActivity = this.f57357f.getPageContext().getPageActivity();
            long j = this.f57359h;
            String str = this.f57360i;
            long j2 = this.j;
            String leaveMsg = this.f57358g.getLeaveMsg();
            d.a.q0.h2.g.c.a aVar3 = this.f57356e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j, str, j2, "from_share", leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.k).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public static class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f57361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f57362f;

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
            this.f57361e = pbChosenActivity;
            this.f57362f = shareThreadView;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                l.x(this.f57361e.getPageContext().getPageActivity(), this.f57362f.getChatMsgView());
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
        this.f57345a = pbChosenActivity;
    }

    public static ShareFromPBMsgData c(d.a.q0.h2.g.c.a aVar, long j, String str) {
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

    public static void d(PbChosenActivity pbChosenActivity, d.a.q0.h2.g.c.a aVar, long j, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, aVar, Long.valueOf(j), str, Long.valueOf(j2), str2}) == null) || aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        d.a.p0.s.s.a aVar2 = new d.a.p0.s.s.a(pbChosenActivity.getPageContext().getPageActivity());
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

    public static void e(PbChosenActivity pbChosenActivity, d.a.q0.h2.g.c.a aVar, long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{pbChosenActivity, aVar, Long.valueOf(j), str, str2, str3, str4}) == null) || aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        d.a.p0.s.s.a aVar2 = new d.a.p0.s.s.a(pbChosenActivity.getPageContext().getPageActivity());
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

    public void f(d.a.q0.h2.g.c.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) || aVar == null || aVar.getThreadInfo() == null || aVar.getThreadInfo().excid == null) {
            return;
        }
        String str2 = aVar.getThreadInfo().forum.forum_name;
        String str3 = aVar.getThreadInfo().title;
        String str4 = aVar.getThreadInfo()._abstract;
        Resources resources = this.f57345a.getPageContext().getPageActivity().getResources();
        String format = MessageFormat.format(resources.getString(R.string.share_content_tpl), str3, str4);
        resources.getString(R.string.chosen_pb_share_content, str3);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        shareItem.t = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getThreadInfo().excid;
        shareItem.D = str4;
        shareItem.C = Long.toString(aVar.getThreadInfo().excid.longValue());
        shareItem.K = Long.toString(aVar.getThreadInfo().thread_id.longValue());
        shareItem.f12887a = true;
        if (!StringUtils.isNull(str)) {
            shareItem.v = Uri.parse(str);
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f57345a.getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_share_friends_n, new View$OnClickListenerC1413a(this));
        shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
        this.f57345a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
