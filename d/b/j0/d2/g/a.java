package d.b.j0.d2.g;

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
import d.b.c.e.p.l;
import d.b.i0.r.s.a;
import d.b.i0.s.g.g;
import java.text.MessageFormat;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PbChosenActivity f54148a;

    /* renamed from: d.b.j0.d2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1222a implements View.OnClickListener {
        public View$OnClickListenerC1222a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f54148a.sendMessage(new CustomMessage(2001277));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(a.this.f54148a.getPageContext().getPageActivity(), 23007)));
            TiebaStatic.eventStat(a.this.f54148a.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f54150e;

        public b(ShareItem shareItem) {
            this.f54150e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareItem shareItem = this.f54150e;
            shareItem.t = g.o(shareItem.t, shareItem.J);
            d.b.c.e.p.a.a(this.f54150e.t);
            l.L(a.this.f54148a.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.d2.g.c.a f54152e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54153f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f54154g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f54155h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public c(d.b.j0.d2.g.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            this.f54152e = aVar;
            this.f54153f = pbChosenActivity;
            this.f54154g = shareThreadView;
            this.f54155h = j;
            this.i = str;
            this.j = str2;
            this.k = str3;
            this.l = str4;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            d.b.j0.d2.g.c.a aVar2 = this.f54152e;
            if (aVar2 == null || aVar2.getThreadInfo() == null) {
                return;
            }
            l.w(this.f54153f.getPageContext().getPageActivity(), this.f54154g.getChatMsgView());
            Activity pageActivity = this.f54153f.getPageContext().getPageActivity();
            long j = this.f54155h;
            String str = this.i;
            String str2 = this.j;
            String str3 = this.k;
            String leaveMsg = this.f54154g.getLeaveMsg();
            d.b.j0.d2.g.c.a aVar3 = this.f54152e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.l).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54156e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f54157f;

        public d(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            this.f54156e = pbChosenActivity;
            this.f54157f = shareThreadView;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            l.w(this.f54156e.getPageContext().getPageActivity(), this.f54157f.getChatMsgView());
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.d2.g.c.a f54158e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54159f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f54160g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f54161h;
        public final /* synthetic */ String i;
        public final /* synthetic */ long j;
        public final /* synthetic */ String k;

        public e(d.b.j0.d2.g.c.a aVar, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, long j2, String str2) {
            this.f54158e = aVar;
            this.f54159f = pbChosenActivity;
            this.f54160g = shareThreadView;
            this.f54161h = j;
            this.i = str;
            this.j = j2;
            this.k = str2;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            d.b.j0.d2.g.c.a aVar2 = this.f54158e;
            if (aVar2 == null || aVar2.getThreadInfo() == null) {
                return;
            }
            l.w(this.f54159f.getPageContext().getPageActivity(), this.f54160g.getChatMsgView());
            Activity pageActivity = this.f54159f.getPageContext().getPageActivity();
            long j = this.f54161h;
            String str = this.i;
            long j2 = this.j;
            String leaveMsg = this.f54160g.getLeaveMsg();
            d.b.j0.d2.g.c.a aVar3 = this.f54158e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j, str, j2, "from_share", leaveMsg, a.c(aVar3, aVar3.getThreadInfo().excid.longValue(), this.k).toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54162e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareThreadView f54163f;

        public f(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            this.f54162e = pbChosenActivity;
            this.f54163f = shareThreadView;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            l.w(this.f54162e.getPageContext().getPageActivity(), this.f54163f.getChatMsgView());
            aVar.dismiss();
        }
    }

    public a(PbChosenActivity pbChosenActivity) {
        this.f54148a = pbChosenActivity;
    }

    public static ShareFromPBMsgData c(d.b.j0.d2.g.c.a aVar, long j, String str) {
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

    public static void d(PbChosenActivity pbChosenActivity, d.b.j0.d2.g.c.a aVar, long j, String str, long j2, String str2) {
        if (aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        d.b.i0.r.s.a aVar2 = new d.b.i0.r.s.a(pbChosenActivity.getPageContext().getPageActivity());
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

    public static void e(PbChosenActivity pbChosenActivity, d.b.j0.d2.g.c.a aVar, long j, String str, String str2, String str3, String str4) {
        if (aVar == null || aVar.getThreadInfo() == null) {
            return;
        }
        d.b.i0.r.s.a aVar2 = new d.b.i0.r.s.a(pbChosenActivity.getPageContext().getPageActivity());
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

    public void f(d.b.j0.d2.g.c.a aVar, String str) {
        if (aVar == null || aVar.getThreadInfo() == null || aVar.getThreadInfo().excid == null) {
            return;
        }
        String str2 = aVar.getThreadInfo().forum.forum_name;
        String str3 = aVar.getThreadInfo().title;
        String str4 = aVar.getThreadInfo()._abstract;
        Resources resources = this.f54148a.getPageContext().getPageActivity().getResources();
        String format = MessageFormat.format(resources.getString(R.string.share_content_tpl), str3, str4);
        resources.getString(R.string.chosen_pb_share_content, str3);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        shareItem.t = "http://tieba.baidu.com/mo/q/recommendpb?ftid=" + aVar.getThreadInfo().excid;
        shareItem.C = str4;
        shareItem.B = Long.toString(aVar.getThreadInfo().excid.longValue());
        shareItem.J = Long.toString(aVar.getThreadInfo().thread_id.longValue());
        shareItem.f13381a = true;
        if (!StringUtils.isNull(str)) {
            shareItem.v = Uri.parse(str);
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f54148a.getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_share_friends_n, new View$OnClickListenerC1222a());
        shareDialogConfig.setCopyLinkListener(new b(shareItem));
        this.f54148a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
