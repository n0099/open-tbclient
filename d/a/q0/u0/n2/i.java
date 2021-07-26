package d.a.q0.u0.n2;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.s.a;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f63991e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f63992f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f63993g;

        public a(ShareItem shareItem, TbPageContext tbPageContext, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareItem, tbPageContext, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63991e = shareItem;
            this.f63992f = tbPageContext;
            this.f63993g = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.f63991e.q).param("obj_type", 18).param("obj_source", 10));
                FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(this.f63992f.getPageActivity());
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f63992f.getPageActivity());
                if (frsPrivateShareDialogView.d(this.f63993g, this.f63992f, aVar)) {
                    aVar.setContentViewSize(2);
                    aVar.setContentView(frsPrivateShareDialogView);
                    aVar.create(this.f63992f).show();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f63995f;

        public b(String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63994e = str;
            this.f63995f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.d.e.p.a.a(this.f63994e);
                d.a.d.e.p.l.M(this.f63995f.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f63996e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsShareCardView f63997f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f63998g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f63999h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f64000i;
        public final /* synthetic */ ShareFromFrsMsgData j;

        public c(FrsFragment frsFragment, FrsShareCardView frsShareCardView, long j, String str, long j2, ShareFromFrsMsgData shareFromFrsMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsShareCardView, Long.valueOf(j), str, Long.valueOf(j2), shareFromFrsMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63996e = frsFragment;
            this.f63997f = frsShareCardView;
            this.f63998g = j;
            this.f63999h = str;
            this.f64000i = j2;
            this.j = shareFromFrsMsgData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f63996e.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.f63997f.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f63996e.m().getPageActivity(), this.f63998g, this.f63999h, this.f64000i, "from_share", this.f63997f.getLeaveMsg(), this.j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f64001e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsShareCardView f64002f;

        public d(FrsFragment frsFragment, FrsShareCardView frsShareCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsShareCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64001e = frsFragment;
            this.f64002f = frsShareCardView;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f64001e.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.f64002f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    public static ShareFromFrsMsgData a(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsViewData)) == null) {
            ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
            shareFromFrsMsgData.setImageUrl(frsViewData.getForum().getImage_url());
            shareFromFrsMsgData.setName(frsViewData.getForum().getName());
            shareFromFrsMsgData.setMemberNum(frsViewData.getForum().getMember_num());
            shareFromFrsMsgData.setPostNum(frsViewData.getForum().getPost_num());
            shareFromFrsMsgData.setContent(frsViewData.getForum().getSlogan());
            return shareFromFrsMsgData;
        }
        return (ShareFromFrsMsgData) invokeL.objValue;
    }

    public static void b(FrsFragment frsFragment, FrsViewData frsViewData, long j, String str, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{frsFragment, frsViewData, Long.valueOf(j), str, Long.valueOf(j2)}) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        ShareFromFrsMsgData a2 = a(frsViewData);
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(frsFragment.getPageContext().getPageActivity());
        FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
        frsShareCardView.setPageId(frsFragment.getUniqueId());
        frsShareCardView.setData(a2);
        aVar.setContentViewSize(1);
        aVar.setContentView(frsShareCardView);
        aVar.setPositiveButton(R.string.share, new c(frsFragment, frsShareCardView, j, str, j2, a2));
        aVar.setNegativeButton(R.string.cancel, new d(frsFragment, frsShareCardView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(frsFragment.getPageContext()).show();
        if (d.a.d.e.p.k.isEmpty(a2.getImageUrl())) {
            return;
        }
        frsShareCardView.d(a2.getImageUrl(), false);
    }

    public static void c(TbPageContext tbPageContext, FrsViewData frsViewData, String str) {
        String str2;
        Uri parse;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, frsViewData, str) == null) || tbPageContext == null || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        if (frsViewData.getForum().getName() != null && frsViewData.getForum().getId() != null) {
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String name = frsViewData.getForum().getName();
            ForumData forum = frsViewData.getForum();
            String encode = URLEncoder.encode(name);
            if (!TextUtils.isEmpty(forum.forum_share_link)) {
                str2 = forum.forum_share_link + "?kw=" + encode + "&fr=sharewise";
            } else {
                str2 = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=sharewise";
            }
            Uri parse2 = frsViewData.getForum().getImage_url() == null ? null : Uri.parse(frsViewData.getForum().getImage_url());
            String slogan = frsViewData.getForum().getSlogan();
            ShareItem shareItem = new ShareItem();
            shareItem.r = name + tbPageContext.getString(R.string.forum);
            shareItem.s = slogan;
            shareItem.t = str2;
            shareItem.f12888b = true;
            shareItem.E = 10;
            shareItem.q = str;
            if (parse2 != null) {
                shareItem.v = parse2;
            }
            ShareItem shareItem2 = new ShareItem();
            shareItem2.r = name + tbPageContext.getString(R.string.forum);
            shareItem2.s = slogan;
            shareItem2.t = str2;
            shareItem2.f12888b = true;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, tbPageContext, frsViewData) == null) {
            FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(tbPageContext.getPageActivity());
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(tbPageContext.getPageActivity());
            if (frsPrivateShareDialogView.d(frsViewData, tbPageContext, aVar)) {
                aVar.setContentViewSize(2);
                aVar.setContentView(frsPrivateShareDialogView);
                aVar.create(tbPageContext).show();
            }
        }
    }
}
