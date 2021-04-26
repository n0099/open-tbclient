package d.a.j0.q0.n2;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsPrivateShareDialogView;
import com.baidu.tieba.frs.view.FrsShareCardView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.i0.r.s.a;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class i {

    /* loaded from: classes4.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f58270e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f58271f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f58272g;

        public a(ShareItem shareItem, TbPageContext tbPageContext, FrsViewData frsViewData) {
            this.f58270e = shareItem;
            this.f58271f = tbPageContext;
            this.f58272g = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f58270e.q).param("obj_type", 18).param("obj_source", 10));
            FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(this.f58271f.getPageActivity());
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f58271f.getPageActivity());
            if (frsPrivateShareDialogView.d(this.f58272g, this.f58271f, aVar)) {
                aVar.setContentViewSize(2);
                aVar.setContentView(frsPrivateShareDialogView);
                aVar.create(this.f58271f).show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f58273e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f58274f;

        public b(String str, TbPageContext tbPageContext) {
            this.f58273e = str;
            this.f58274f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f58273e);
            d.a.c.e.p.l.M(this.f58274f.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f58275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsShareCardView f58276f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f58277g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f58278h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f58279i;
        public final /* synthetic */ ShareFromFrsMsgData j;

        public c(FrsFragment frsFragment, FrsShareCardView frsShareCardView, long j, String str, long j2, ShareFromFrsMsgData shareFromFrsMsgData) {
            this.f58275e = frsFragment;
            this.f58276f = frsShareCardView;
            this.f58277g = j;
            this.f58278h = str;
            this.f58279i = j2;
            this.j = shareFromFrsMsgData;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f58275e.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.f58276f.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f58275e.o().getPageActivity(), this.f58277g, this.f58278h, this.f58279i, "from_share", this.f58276f.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f58280e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsShareCardView f58281f;

        public d(FrsFragment frsFragment, FrsShareCardView frsShareCardView) {
            this.f58280e = frsFragment;
            this.f58281f = frsShareCardView;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f58280e.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.f58281f.getChatMsgView());
            aVar.dismiss();
        }
    }

    public static ShareFromFrsMsgData a(FrsViewData frsViewData) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(frsViewData.getForum().getImage_url());
        shareFromFrsMsgData.setName(frsViewData.getForum().getName());
        shareFromFrsMsgData.setMemberNum(frsViewData.getForum().getMember_num());
        shareFromFrsMsgData.setPostNum(frsViewData.getForum().getPost_num());
        shareFromFrsMsgData.setContent(frsViewData.getForum().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void b(FrsFragment frsFragment, FrsViewData frsViewData, long j, String str, long j2) {
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        ShareFromFrsMsgData a2 = a(frsViewData);
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(frsFragment.getPageContext().getPageActivity());
        FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
        frsShareCardView.setPageId(frsFragment.getUniqueId());
        frsShareCardView.setData(a2);
        aVar.setContentViewSize(1);
        aVar.setContentView(frsShareCardView);
        aVar.setPositiveButton(R.string.share, new c(frsFragment, frsShareCardView, j, str, j2, a2));
        aVar.setNegativeButton(R.string.cancel, new d(frsFragment, frsShareCardView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(frsFragment.getPageContext()).show();
        if (d.a.c.e.p.k.isEmpty(a2.getImageUrl())) {
            return;
        }
        frsShareCardView.d(a2.getImageUrl(), false);
    }

    public static void c(TbPageContext tbPageContext, FrsViewData frsViewData, String str) {
        String str2;
        Uri parse;
        if (tbPageContext == null || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        if (frsViewData.getForum().getName() != null && frsViewData.getForum().getId() != null) {
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String name = frsViewData.getForum().getName();
            ForumData forum = frsViewData.getForum();
            String encode = URLEncoder.encode(name);
            if (!TextUtils.isEmpty(forum.forum_share_link)) {
                str2 = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
            } else {
                str2 = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
            }
            Uri parse2 = frsViewData.getForum().getImage_url() == null ? null : Uri.parse(frsViewData.getForum().getImage_url());
            String slogan = frsViewData.getForum().getSlogan();
            ShareItem shareItem = new ShareItem();
            shareItem.r = name + tbPageContext.getString(R.string.forum);
            shareItem.s = slogan;
            shareItem.t = str2;
            shareItem.f13352b = true;
            shareItem.E = 10;
            shareItem.q = str;
            if (parse2 != null) {
                shareItem.v = parse2;
            }
            ShareItem shareItem2 = new ShareItem();
            shareItem2.r = name + tbPageContext.getString(R.string.forum);
            shareItem2.s = slogan;
            shareItem2.t = str2;
            shareItem2.f13352b = true;
            shareItem2.E = 10;
            shareItem2.q = str;
            shareItem2.p = frsViewData.getForum().getName();
            String str3 = frsViewData.getForum().getfShareImage();
            if (StringUtils.isNull(str3)) {
                shareItem2.y = 4;
                shareItem2.J = frsViewData.getForum().getId();
                parse = parse2;
            } else {
                parse = Uri.parse(str3);
                shareItem2.y = 2;
            }
            if (parse2 != null) {
                shareItem2.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), shareItem, true);
            shareDialogConfig.setHasSpecialItem(true);
            shareDialogConfig.setSpecialShareItems(3, shareItem2);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCustomCopyTitle(R.string.copy_link);
            shareDialogConfig.addOutsideTextView(R.string.poster_share, R.drawable.icon_pure_share_poster40, new a(shareItem, tbPageContext, frsViewData));
            shareDialogConfig.setCopyLinkListener(new b(str2, tbPageContext));
            tbPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            return;
        }
        tbPageContext.showToast(tbPageContext.getString(R.string.no_forum_data));
    }

    public static void d(TbPageContext tbPageContext, FrsViewData frsViewData) {
        FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(tbPageContext.getPageActivity());
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(tbPageContext.getPageActivity());
        if (frsPrivateShareDialogView.d(frsViewData, tbPageContext, aVar)) {
            aVar.setContentViewSize(2);
            aVar.setContentView(frsPrivateShareDialogView);
            aVar.create(tbPageContext).show();
        }
    }
}
