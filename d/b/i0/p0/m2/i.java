package d.b.i0.p0.m2;

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
import d.b.h0.r.s.a;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class i {

    /* loaded from: classes4.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f57918e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f57919f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f57920g;

        public a(ShareItem shareItem, TbPageContext tbPageContext, FrsViewData frsViewData) {
            this.f57918e = shareItem;
            this.f57919f = tbPageContext;
            this.f57920g = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f57918e.q).param("obj_type", 18).param("obj_source", 10));
            FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(this.f57919f.getPageActivity());
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57919f.getPageActivity());
            if (frsPrivateShareDialogView.d(this.f57920g, this.f57919f, aVar)) {
                aVar.setContentViewSize(2);
                aVar.setContentView(frsPrivateShareDialogView);
                aVar.create(this.f57919f).show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f57922f;

        public b(String str, TbPageContext tbPageContext) {
            this.f57921e = str;
            this.f57922f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.p.a.a(this.f57921e);
            d.b.b.e.p.l.L(this.f57922f.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f57923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsShareCardView f57924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f57925g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f57926h;
        public final /* synthetic */ long i;
        public final /* synthetic */ ShareFromFrsMsgData j;

        public c(FrsFragment frsFragment, FrsShareCardView frsShareCardView, long j, String str, long j2, ShareFromFrsMsgData shareFromFrsMsgData) {
            this.f57923e = frsFragment;
            this.f57924f = frsShareCardView;
            this.f57925g = j;
            this.f57926h = str;
            this.i = j2;
            this.j = shareFromFrsMsgData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f57923e.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.f57924f.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f57923e.q().getPageActivity(), this.f57925g, this.f57926h, this.i, "from_share", this.f57924f.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f57927e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsShareCardView f57928f;

        public d(FrsFragment frsFragment, FrsShareCardView frsShareCardView) {
            this.f57927e = frsFragment;
            this.f57928f = frsShareCardView;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f57927e.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.f57928f.getChatMsgView());
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
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(frsFragment.getPageContext().getPageActivity());
        FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
        frsShareCardView.setPageId(frsFragment.getUniqueId());
        frsShareCardView.setData(a2);
        aVar.setContentViewSize(1);
        aVar.setContentView(frsShareCardView);
        aVar.setPositiveButton(R.string.share, new c(frsFragment, frsShareCardView, j, str, j2, a2));
        aVar.setNegativeButton(R.string.cancel, new d(frsFragment, frsShareCardView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(frsFragment.getPageContext()).show();
        if (d.b.b.e.p.k.isEmpty(a2.getImageUrl())) {
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
            shareItem.f13712b = true;
            shareItem.D = 10;
            shareItem.q = str;
            if (parse2 != null) {
                shareItem.v = parse2;
            }
            ShareItem shareItem2 = new ShareItem();
            shareItem2.r = name + tbPageContext.getString(R.string.forum);
            shareItem2.s = slogan;
            shareItem2.t = str2;
            shareItem2.f13712b = true;
            shareItem2.D = 10;
            shareItem2.q = str;
            shareItem2.p = frsViewData.getForum().getName();
            String str3 = frsViewData.getForum().getfShareImage();
            if (StringUtils.isNull(str3)) {
                shareItem2.y = 4;
                shareItem2.I = frsViewData.getForum().getId();
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
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
        if (frsPrivateShareDialogView.d(frsViewData, tbPageContext, aVar)) {
            aVar.setContentViewSize(2);
            aVar.setContentView(frsPrivateShareDialogView);
            aVar.create(tbPageContext).show();
        }
    }
}
