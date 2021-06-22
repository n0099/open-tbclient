package d.a.o0.d1.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.hottopic.view.ShareCardView;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.r.s.a;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<?> f56331a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f56332b = null;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f56333e;

        public a(ShareItem shareItem) {
            this.f56333e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f56333e.t);
            l.M(b.this.f56331a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.a.o0.d1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1298b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56335e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f56336f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f56337g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f56338h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f56339i;

        public C1298b(ShareCardView shareCardView, long j, String str, long j2, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f56335e = shareCardView;
            this.f56336f = j;
            this.f56337g = str;
            this.f56338h = j2;
            this.f56339i = shareFromTopicMsgData;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            ((InputMethodManager) b.this.f56331a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56335e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(b.this.f56331a.getActivity(), this.f56336f, this.f56337g, this.f56338h, "from_share", this.f56335e.getLeaveMsg(), this.f56339i.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56340e;

        public c(ShareCardView shareCardView) {
            this.f56340e = shareCardView;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            ((InputMethodManager) b.this.f56331a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56340e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56342e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f56343f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f56344g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f56345h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f56346i;
        public final /* synthetic */ ShareFromTopicMsgData j;

        public d(ShareCardView shareCardView, long j, String str, String str2, String str3, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f56342e = shareCardView;
            this.f56343f = j;
            this.f56344g = str;
            this.f56345h = str2;
            this.f56346i = str3;
            this.j = shareFromTopicMsgData;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            ((InputMethodManager) b.this.f56331a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56342e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(b.this.f56331a.getActivity(), this.f56343f, this.f56344g, this.f56345h, this.f56346i, 0, this.f56342e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56347e;

        public e(ShareCardView shareCardView) {
            this.f56347e = shareCardView;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            ((InputMethodManager) b.this.f56331a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56347e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    public b(BaseActivity<?> baseActivity) {
        this.f56331a = baseActivity;
    }

    public final SparseArray<String> b() {
        if (this.f56332b == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            this.f56332b = sparseArray;
            sparseArray.put(2, "topic_wx_timeline");
            this.f56332b.put(3, "topic_wx_friend");
            this.f56332b.put(4, "topic_qq_zone");
            this.f56332b.put(5, "topic_tencent_weibo");
            this.f56332b.put(6, "topic_sina_weibo");
        }
        return this.f56332b;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, long j2, d.a.o0.d1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f56331a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f56331a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new C1298b(shareCardView, j, str, j2, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(shareCardView));
        aVar.create(this.f56331a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, String str3, d.a.o0.d1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f56331a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f56331a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new d(shareCardView, j, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new e(shareCardView));
        aVar.create(this.f56331a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (TextUtils.isEmpty(str) && z) {
            BaseActivity<?> baseActivity = this.f56331a;
            baseActivity.showToast(baseActivity.getActivity().getString(R.string.no_hot_topic_data));
            return;
        }
        if (StringUtils.isNull(str3)) {
            str3 = "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + str + "&topic_name=" + URLEncoder.encode(str2);
        }
        Uri parse = StringUtils.isNull(str4) ? null : Uri.parse(str4);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str2;
        shareItem.s = str5;
        shareItem.t = str3;
        shareItem.f12740b = true;
        shareItem.q = str;
        shareItem.v = parse;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f56331a.getActivity(), shareItem, true, b());
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setIsCopyLink(true);
        this.f56331a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
