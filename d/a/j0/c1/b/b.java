package d.a.j0.c1.b;

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
import d.a.i0.r.s.a;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<?> f51638a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f51639b = null;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f51640e;

        public a(ShareItem shareItem) {
            this.f51640e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f51640e.t);
            l.M(b.this.f51638a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.a.j0.c1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1149b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f51642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f51643f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f51644g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f51645h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f51646i;

        public C1149b(ShareCardView shareCardView, long j, String str, long j2, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f51642e = shareCardView;
            this.f51643f = j;
            this.f51644g = str;
            this.f51645h = j2;
            this.f51646i = shareFromTopicMsgData;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            ((InputMethodManager) b.this.f51638a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f51642e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(b.this.f51638a.getActivity(), this.f51643f, this.f51644g, this.f51645h, "from_share", this.f51642e.getLeaveMsg(), this.f51646i.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f51647e;

        public c(ShareCardView shareCardView) {
            this.f51647e = shareCardView;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            ((InputMethodManager) b.this.f51638a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f51647e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f51649e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f51650f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f51651g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f51652h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f51653i;
        public final /* synthetic */ ShareFromTopicMsgData j;

        public d(ShareCardView shareCardView, long j, String str, String str2, String str3, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f51649e = shareCardView;
            this.f51650f = j;
            this.f51651g = str;
            this.f51652h = str2;
            this.f51653i = str3;
            this.j = shareFromTopicMsgData;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            ((InputMethodManager) b.this.f51638a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f51649e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(b.this.f51638a.getActivity(), this.f51650f, this.f51651g, this.f51652h, this.f51653i, 0, this.f51649e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f51654e;

        public e(ShareCardView shareCardView) {
            this.f51654e = shareCardView;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            ((InputMethodManager) b.this.f51638a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f51654e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    public b(BaseActivity<?> baseActivity) {
        this.f51638a = baseActivity;
    }

    public final SparseArray<String> b() {
        if (this.f51639b == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            this.f51639b = sparseArray;
            sparseArray.put(2, "topic_wx_timeline");
            this.f51639b.put(3, "topic_wx_friend");
            this.f51639b.put(4, "topic_qq_zone");
            this.f51639b.put(5, "topic_tencent_weibo");
            this.f51639b.put(6, "topic_sina_weibo");
        }
        return this.f51639b;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, long j2, d.a.j0.c1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f51638a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f51638a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new C1149b(shareCardView, j, str, j2, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(shareCardView));
        aVar.create(this.f51638a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, String str3, d.a.j0.c1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f51638a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f51638a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new d(shareCardView, j, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new e(shareCardView));
        aVar.create(this.f51638a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (TextUtils.isEmpty(str) && z) {
            BaseActivity<?> baseActivity = this.f51638a;
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
        shareItem.f13352b = true;
        shareItem.q = str;
        shareItem.v = parse;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f51638a.getActivity(), shareItem, true, b());
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setIsCopyLink(true);
        this.f51638a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
