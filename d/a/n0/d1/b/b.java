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
    public BaseActivity<?> f52517a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f52518b = null;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f52519e;

        public a(ShareItem shareItem) {
            this.f52519e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f52519e.t);
            l.M(b.this.f52517a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.a.n0.d1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1238b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52521e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f52522f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f52523g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f52524h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f52525i;

        public C1238b(ShareCardView shareCardView, long j, String str, long j2, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f52521e = shareCardView;
            this.f52522f = j;
            this.f52523g = str;
            this.f52524h = j2;
            this.f52525i = shareFromTopicMsgData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52517a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52521e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(b.this.f52517a.getActivity(), this.f52522f, this.f52523g, this.f52524h, "from_share", this.f52521e.getLeaveMsg(), this.f52525i.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52526e;

        public c(ShareCardView shareCardView) {
            this.f52526e = shareCardView;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52517a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52526e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52528e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f52529f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f52530g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f52531h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f52532i;
        public final /* synthetic */ ShareFromTopicMsgData j;

        public d(ShareCardView shareCardView, long j, String str, String str2, String str3, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f52528e = shareCardView;
            this.f52529f = j;
            this.f52530g = str;
            this.f52531h = str2;
            this.f52532i = str3;
            this.j = shareFromTopicMsgData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52517a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52528e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(b.this.f52517a.getActivity(), this.f52529f, this.f52530g, this.f52531h, this.f52532i, 0, this.f52528e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52533e;

        public e(ShareCardView shareCardView) {
            this.f52533e = shareCardView;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52517a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52533e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    public b(BaseActivity<?> baseActivity) {
        this.f52517a = baseActivity;
    }

    public final SparseArray<String> b() {
        if (this.f52518b == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            this.f52518b = sparseArray;
            sparseArray.put(2, "topic_wx_timeline");
            this.f52518b.put(3, "topic_wx_friend");
            this.f52518b.put(4, "topic_qq_zone");
            this.f52518b.put(5, "topic_tencent_weibo");
            this.f52518b.put(6, "topic_sina_weibo");
        }
        return this.f52518b;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, long j2, d.a.n0.d1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f52517a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f52517a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new C1238b(shareCardView, j, str, j2, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(shareCardView));
        aVar.create(this.f52517a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, String str3, d.a.n0.d1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f52517a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f52517a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new d(shareCardView, j, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new e(shareCardView));
        aVar.create(this.f52517a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (TextUtils.isEmpty(str) && z) {
            BaseActivity<?> baseActivity = this.f52517a;
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
        shareItem.f12596b = true;
        shareItem.q = str;
        shareItem.v = parse;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f52517a.getActivity(), shareItem, true, b());
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setIsCopyLink(true);
        this.f52517a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
