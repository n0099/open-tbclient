package d.b.i0.b1.b;

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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.s.a;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<?> f52061a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f52062b = null;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f52063e;

        public a(ShareItem shareItem) {
            this.f52063e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.p.a.a(this.f52063e.t);
            l.L(b.this.f52061a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.b.i0.b1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1128b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52065e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f52066f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f52067g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f52068h;
        public final /* synthetic */ ShareFromTopicMsgData i;

        public C1128b(ShareCardView shareCardView, long j, String str, long j2, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f52065e = shareCardView;
            this.f52066f = j;
            this.f52067g = str;
            this.f52068h = j2;
            this.i = shareFromTopicMsgData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52061a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52065e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(b.this.f52061a.getActivity(), this.f52066f, this.f52067g, this.f52068h, "from_share", this.f52065e.getLeaveMsg(), this.i.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52069e;

        public c(ShareCardView shareCardView) {
            this.f52069e = shareCardView;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52061a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52069e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52071e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f52072f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f52073g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f52074h;
        public final /* synthetic */ String i;
        public final /* synthetic */ ShareFromTopicMsgData j;

        public d(ShareCardView shareCardView, long j, String str, String str2, String str3, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f52071e = shareCardView;
            this.f52072f = j;
            this.f52073g = str;
            this.f52074h = str2;
            this.i = str3;
            this.j = shareFromTopicMsgData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52061a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52071e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(b.this.f52061a.getActivity(), this.f52072f, this.f52073g, this.f52074h, this.i, 0, this.f52071e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f52075e;

        public e(ShareCardView shareCardView) {
            this.f52075e = shareCardView;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            ((InputMethodManager) b.this.f52061a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f52075e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    public b(BaseActivity<?> baseActivity) {
        this.f52061a = baseActivity;
    }

    public final SparseArray<String> b() {
        if (this.f52062b == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            this.f52062b = sparseArray;
            sparseArray.put(2, "topic_wx_timeline");
            this.f52062b.put(3, "topic_wx_friend");
            this.f52062b.put(4, "topic_qq_zone");
            this.f52062b.put(5, "topic_tencent_weibo");
            this.f52062b.put(6, "topic_sina_weibo");
        }
        return this.f52062b;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, long j2, d.b.i0.b1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f52061a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f52061a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new C1128b(shareCardView, j, str, j2, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(shareCardView));
        aVar.create(this.f52061a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, String str3, d.b.i0.b1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f52061a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f52061a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new d(shareCardView, j, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new e(shareCardView));
        aVar.create(this.f52061a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (TextUtils.isEmpty(str) && z) {
            BaseActivity<?> baseActivity = this.f52061a;
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
        shareItem.f13713b = true;
        shareItem.q = str;
        shareItem.v = parse;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f52061a.getActivity(), shareItem, true, b());
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setIsCopyLink(true);
        this.f52061a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
