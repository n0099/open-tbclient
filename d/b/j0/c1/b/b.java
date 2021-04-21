package d.b.j0.c1.b;

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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.s.a;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<?> f53883a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f53884b = null;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f53885e;

        public a(ShareItem shareItem) {
            this.f53885e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.c.e.p.a.a(this.f53885e.t);
            l.L(b.this.f53883a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.b.j0.c1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1210b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f53887e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f53888f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f53889g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f53890h;
        public final /* synthetic */ ShareFromTopicMsgData i;

        public C1210b(ShareCardView shareCardView, long j, String str, long j2, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f53887e = shareCardView;
            this.f53888f = j;
            this.f53889g = str;
            this.f53890h = j2;
            this.i = shareFromTopicMsgData;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            ((InputMethodManager) b.this.f53883a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f53887e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(b.this.f53883a.getActivity(), this.f53888f, this.f53889g, this.f53890h, "from_share", this.f53887e.getLeaveMsg(), this.i.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f53891e;

        public c(ShareCardView shareCardView) {
            this.f53891e = shareCardView;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            ((InputMethodManager) b.this.f53883a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f53891e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f53893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f53894f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f53895g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f53896h;
        public final /* synthetic */ String i;
        public final /* synthetic */ ShareFromTopicMsgData j;

        public d(ShareCardView shareCardView, long j, String str, String str2, String str3, ShareFromTopicMsgData shareFromTopicMsgData) {
            this.f53893e = shareCardView;
            this.f53894f = j;
            this.f53895g = str;
            this.f53896h = str2;
            this.i = str3;
            this.j = shareFromTopicMsgData;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            ((InputMethodManager) b.this.f53883a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f53893e.getChatMsgView().getWindowToken(), 2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(b.this.f53883a.getActivity(), this.f53894f, this.f53895g, this.f53896h, this.i, 0, this.f53893e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f53897e;

        public e(ShareCardView shareCardView) {
            this.f53897e = shareCardView;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            ((InputMethodManager) b.this.f53883a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f53897e.getChatMsgView().getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    public b(BaseActivity<?> baseActivity) {
        this.f53883a = baseActivity;
    }

    public final SparseArray<String> b() {
        if (this.f53884b == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            this.f53884b = sparseArray;
            sparseArray.put(2, "topic_wx_timeline");
            this.f53884b.put(3, "topic_wx_friend");
            this.f53884b.put(4, "topic_qq_zone");
            this.f53884b.put(5, "topic_tencent_weibo");
            this.f53884b.put(6, "topic_sina_weibo");
        }
        return this.f53884b;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, long j2, d.b.j0.c1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f53883a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f53883a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new C1210b(shareCardView, j, str, j2, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(shareCardView));
        aVar.create(this.f53883a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, String str3, d.b.j0.c1.c.e eVar) {
        if (eVar == null || eVar.h() == null) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f53883a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f53883a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new d(shareCardView, j, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new e(shareCardView));
        aVar.create(this.f53883a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (TextUtils.isEmpty(str) && z) {
            BaseActivity<?> baseActivity = this.f53883a;
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
        shareItem.f13382b = true;
        shareItem.q = str;
        shareItem.v = parse;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f53883a.getActivity(), shareItem, true, b());
        shareDialogConfig.setCopyLinkListener(new a(shareItem));
        shareDialogConfig.setIsCopyLink(true);
        this.f53883a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
