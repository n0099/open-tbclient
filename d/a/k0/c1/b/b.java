package d.a.k0.c1.b;

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
import d.a.j0.r.s.a;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<?> f52337a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f52338b = null;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f52339e;

        public a(ShareItem shareItem) {
            this.f52339e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f52339e.t);
            l.M(b.this.f52337a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.a.k0.c1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1221b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52341e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f52342f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f52343g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f52344h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f52345i;

        public C1221b(ShareCardView shareCardView, long j, String str, long j2, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f52341e = shareCardView;
            this.f52342f = j;
            this.f52343g = str;
            this.f52344h = j2;
            this.f52345i = shareFromTopicMsgData;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52337a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52341e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(b.this.f52337a.getActivity(), this.f52342f, this.f52343g, this.f52344h, "from_share", this.f52341e.getLeaveMsg(), this.f52345i.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52346e;

        public c(ShareCardView shareCardView) {
            this.f52346e = shareCardView;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52337a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52346e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52348e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f52349f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f52350g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f52351h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f52352i;
        public final /* synthetic */ ShareFromTopicMsgData j;

        public d(ShareCardView shareCardView, long j, String str, String str2, String str3, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f52348e = shareCardView;
            this.f52349f = j;
            this.f52350g = str;
            this.f52351h = str2;
            this.f52352i = str3;
            this.j = shareFromTopicMsgData;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52337a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52348e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(b.this.f52337a.getActivity(), this.f52349f, this.f52350g, this.f52351h, this.f52352i, 0, this.f52348e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52353e;

        public e(ShareCardView shareCardView) {
            this.f52353e = shareCardView;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52337a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52353e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    public b(BaseActivity<?> baseActivity) {
        this.f52337a = baseActivity;
    }

    public final SparseArray<String> b() {
        if (this.f52338b == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            this.f52338b = sparseArray;
            sparseArray.put(2, "topic_wx_timeline");
            this.f52338b.put(3, "topic_wx_friend");
            this.f52338b.put(4, "topic_qq_zone");
            this.f52338b.put(5, "topic_tencent_weibo");
            this.f52338b.put(6, "topic_sina_weibo");
        }
        return this.f52338b;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, long j2, d.a.k0.c1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f52337a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f52337a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new C1221b(shareCardView, j, str, j2, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(shareCardView));
        aVar.create(this.f52337a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, String str3, d.a.k0.c1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f52337a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f52337a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new d(shareCardView, j, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new e(shareCardView));
        aVar.create(this.f52337a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (TextUtils.isEmpty(str) && z) {
            BaseActivity<?> baseActivity = this.f52337a;
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
        shareItem.f12688b = true;
        shareItem.q = str;
        shareItem.v = parse;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f52337a.getActivity(), shareItem, true, b());
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setIsCopyLink(true);
        this.f52337a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
