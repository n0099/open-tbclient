package d.a.n0.d1.b;

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
import d.a.m0.r.s.a;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<?> f56206a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f56207b = null;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f56208e;

        public a(ShareItem shareItem) {
            this.f56208e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f56208e.t);
            l.M(b.this.f56206a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.a.n0.d1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1294b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56210e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f56211f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f56212g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f56213h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f56214i;

        public C1294b(ShareCardView shareCardView, long j, String str, long j2, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f56210e = shareCardView;
            this.f56211f = j;
            this.f56212g = str;
            this.f56213h = j2;
            this.f56214i = shareFromTopicMsgData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            ((InputMethodManager) b.this.f56206a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56210e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(b.this.f56206a.getActivity(), this.f56211f, this.f56212g, this.f56213h, "from_share", this.f56210e.getLeaveMsg(), this.f56214i.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56215e;

        public c(ShareCardView shareCardView) {
            this.f56215e = shareCardView;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            ((InputMethodManager) b.this.f56206a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56215e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56217e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f56218f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f56219g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f56220h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f56221i;
        public final /* synthetic */ ShareFromTopicMsgData j;

        public d(ShareCardView shareCardView, long j, String str, String str2, String str3, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f56217e = shareCardView;
            this.f56218f = j;
            this.f56219g = str;
            this.f56220h = str2;
            this.f56221i = str3;
            this.j = shareFromTopicMsgData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            ((InputMethodManager) b.this.f56206a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56217e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(b.this.f56206a.getActivity(), this.f56218f, this.f56219g, this.f56220h, this.f56221i, 0, this.f56217e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56222e;

        public e(ShareCardView shareCardView) {
            this.f56222e = shareCardView;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            ((InputMethodManager) b.this.f56206a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56222e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    public b(BaseActivity<?> baseActivity) {
        this.f56206a = baseActivity;
    }

    public final SparseArray<String> b() {
        if (this.f56207b == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            this.f56207b = sparseArray;
            sparseArray.put(2, "topic_wx_timeline");
            this.f56207b.put(3, "topic_wx_friend");
            this.f56207b.put(4, "topic_qq_zone");
            this.f56207b.put(5, "topic_tencent_weibo");
            this.f56207b.put(6, "topic_sina_weibo");
        }
        return this.f56207b;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, long j2, d.a.n0.d1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f56206a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f56206a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new C1294b(shareCardView, j, str, j2, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(shareCardView));
        aVar.create(this.f56206a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, String str3, d.a.n0.d1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f56206a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f56206a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new d(shareCardView, j, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new e(shareCardView));
        aVar.create(this.f56206a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (TextUtils.isEmpty(str) && z) {
            BaseActivity<?> baseActivity = this.f56206a;
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
        shareItem.f12658b = true;
        shareItem.q = str;
        shareItem.v = parse;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f56206a.getActivity(), shareItem, true, b());
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setIsCopyLink(true);
        this.f56206a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
