package d.a.n0.e2.g;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
import d.a.m0.s.g.g;
import java.text.MessageFormat;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbChosenActivity f52827a;

    /* renamed from: d.a.n0.e2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1251a implements View.OnClickListener {
        public View$OnClickListenerC1251a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f52827a.sendMessage(new CustomMessage(2001277));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(a.this.f52827a.getPageContext().getPageActivity(), 23007)));
            TiebaStatic.eventStat(a.this.f52827a.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f52829e;

        public b(ShareItem shareItem) {
            this.f52829e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareItem shareItem = this.f52829e;
            shareItem.t = g.o(shareItem.t, shareItem.K);
            d.a.c.e.p.a.a(this.f52829e.t);
            l.M(a.this.f52827a.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.e2.g.c.a f52831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f52832f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f52833g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f52834h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f52835i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public c(d.a.n0.e2.g.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            this.f52831e = aVar;
            this.f52832f = pbChosenActivity;
            this.f52833g = shareThreadView;
            this.f52834h = j;
            this.f52835i = str;
            this.j = str2;
            this.k = str3;
            this.l = str4;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            d.a.n0.e2.g.c.a aVar2 = this.f52831e;
            if (aVar2 == null || aVar2.getThreadInfo() == null) {
                return;
            }
            l.x(this.f52832f.getPageContext().getPageActivity(), this.f52833g.getChatMsgView());
            Activity pageActivity = this.f52832f.getPageContext().getPageActivity();
            long j = this.f52834h;
            String str = this.f52835i;
            String str2 = this.j;
            String str3 = this.k;
            String leaveMsg = this.f52833g.getLeaveMsg();
            d.a.n0.e2.g.c.a aVar3 = this.f52831e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.l).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f52836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f52837f;

        public d(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            this.f52836e = pbChosenActivity;
            this.f52837f = shareThreadView;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            l.x(this.f52836e.getPageContext().getPageActivity(), this.f52837f.getChatMsgView());
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.e2.g.c.a f52838e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f52839f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f52840g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f52841h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f52842i;
        public final /* synthetic */ long j;
        public final /* synthetic */ String k;

        public e(d.a.n0.e2.g.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, long j2, String str2) {
            this.f52838e = aVar;
            this.f52839f = pbChosenActivity;
            this.f52840g = shareThreadView;
            this.f52841h = j;
            this.f52842i = str;
            this.j = j2;
            this.k = str2;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            d.a.n0.e2.g.c.a aVar2 = this.f52838e;
            if (aVar2 == null || aVar2.getThreadInfo() == null) {
                return;
            }
            l.x(this.f52839f.getPageContext().getPageActivity(), this.f52840g.getChatMsgView());
            Activity pageActivity = this.f52839f.getPageContext().getPageActivity();
            long j = this.f52841h;
            String str = this.f52842i;
            long j2 = this.j;
            String leaveMsg = this.f52840g.getLeaveMsg();
            d.a.n0.e2.g.c.a aVar3 = this.f52838e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j, str, j2, "from_share", leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.k).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f52843e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f52844f;

        public f(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            this.f52843e = pbChosenActivity;
            this.f52844f = shareThreadView;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            l.x(this.f52843e.getPageContext().getPageActivity(), this.f52844f.getChatMsgView());
            aVar.dismiss();
        }
    }

    public a(PbChosenActivity pbChosenActivity) {
        this.f52827a = pbChosenActivity;
    }

    public static ShareFromPBMsgData c(d.a.n0.e2.g.c.a aVar, long j, String str) {
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

    public static void d(PbChosenActivity pbChosenActivity, d.a.n0.e2.g.c.a aVar, long j, String str, long j2, String str2) {
        if (aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        d.a.m0.r.s.a aVar2 = new d.a.m0.r.s.a(pbChosenActivity.getPageContext().getPageActivity());
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

    public static void e(PbChosenActivity pbChosenActivity, d.a.n0.e2.g.c.a aVar, long j, String str, String str2, String str3, String str4) {
        if (aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        d.a.m0.r.s.a aVar2 = new d.a.m0.r.s.a(pbChosenActivity.getPageContext().getPageActivity());
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

    public void f(d.a.n0.e2.g.c.a aVar, String str) {
        if (aVar == null || aVar.getThreadInfo() == null || aVar.getThreadInfo().excid == null) {
            return;
        }
        String str2 = aVar.getThreadInfo().forum.forum_name;
        String str3 = aVar.getThreadInfo().title;
        String str4 = aVar.getThreadInfo()._abstract;
        Resources resources = this.f52827a.getPageContext().getPageActivity().getResources();
        String format = MessageFormat.format(resources.getString(R.string.share_content_tpl), str3, str4);
        resources.getString(R.string.chosen_pb_share_content, str3);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        shareItem.t = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getThreadInfo().excid;
        shareItem.D = str4;
        shareItem.C = Long.toString(aVar.getThreadInfo().excid.longValue());
        shareItem.K = Long.toString(aVar.getThreadInfo().thread_id.longValue());
        shareItem.f12595a = true;
        if (!StringUtils.isNull(str)) {
            shareItem.v = Uri.parse(str);
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f52827a.getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_share_friends_n, new View$OnClickListenerC1251a());
        shareDialogConfig.setCopyLinkListener(new b(shareItem));
        this.f52827a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
