package d.b.i0.t.g.a;

import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.ScrollBridgeWebview;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.z0.n0;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f60749a;

    /* renamed from: b  reason: collision with root package name */
    public View f60750b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60751c;

    /* renamed from: d  reason: collision with root package name */
    public ScrollBridgeWebview f60752d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.d0.g f60753e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.d0.h f60754f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60755g;

    /* renamed from: h  reason: collision with root package name */
    public String f60756h;
    public int i = 0;
    public boolean j;
    public boolean k;
    public ShareFromPBMsgData l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f60757e;

        public a(ShareItem shareItem) {
            this.f60757e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.p.a.a(this.f60757e.t);
            l.L(b.this.f60749a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.b.i0.t.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1561b implements CustomMessageTask.CustomRunnable<String> {
        public C1561b() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            if (customMessage == null) {
                return null;
            }
            return new CustomResponsedMessage<>(2921015, b.this.l);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, b.this.f60749a.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ScrollBridgeWebview.a {
        public d() {
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void a(int i, int i2, int i3, int i4) {
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void b(int i, int i2, int i3, int i4) {
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            if (Math.abs(i2 - b.this.i) > 50) {
                b.this.i = i2;
                if (i2 > i4) {
                    b.this.E(false, true);
                } else {
                    b.this.E(true, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.D();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BaseWebView.d {
        public f() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            b.this.x(str);
            if (StringUtils.isNull(str) || str.contains(UrlSchemaHelper.REDIRECT_JUMP_KEY)) {
                return false;
            }
            if (!b.this.z(str)) {
                UrlManager.getInstance().dealOneLink(b.this.f60749a.getPageContext(), new String[]{str});
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements BaseWebView.f {
        public g() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
        public void a(WebView webView, String str) {
            b.this.F();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements BaseWebView.e {
        public h() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            b.this.l();
            if (d.b.b.e.p.j.z()) {
                b.this.H();
                b.this.f60755g = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements BaseWebView.h {
        public i() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            b.this.G();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(b.this.f60749a.getActivity(), 23007, 1)));
        }
    }

    public b(boolean z) {
        this.k = false;
        CustomMessageTask customMessageTask = new CustomMessageTask(2921015, new C1561b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.k = z;
    }

    public void A(int i2) {
        NavigationBar navigationBar = this.f60751c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60749a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f60751c.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
    }

    public View B(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.ala_frs_live_video_fragment, (ViewGroup) null);
        this.f60750b = inflate;
        inflate.setDrawingCacheEnabled(false);
        return this.f60750b;
    }

    public void C() {
        MessageManager.getInstance().unRegisterTask(2921015);
        NavigationBar navigationBar = this.f60751c;
        if (navigationBar != null) {
            navigationBar.release();
        }
    }

    public void D() {
        if (this.f60755g) {
            this.f60752d.loadUrl("javascript:window.reload_page()");
        } else {
            this.f60752d.loadUrl(this.f60756h);
        }
    }

    public final void E(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(2001617);
            customMessage.setTag(this.f60749a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(2001618);
        customMessage2.setTag(this.f60749a.getBaseFragmentActivity().getUniqueId());
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }

    public void F() {
        BaseFragment baseFragment = this.f60749a;
        if (baseFragment == null || this.f60750b == null || !baseFragment.isAdded()) {
            return;
        }
        this.j = true;
        d.b.h0.d0.g gVar = new d.b.h0.d0.g(this.f60749a.getActivity(), this.f60749a.getResources().getDimensionPixelSize(R.dimen.ds270));
        this.f60753e = gVar;
        gVar.attachView(this.f60750b, false);
        this.f60753e.onChangeSkinType();
    }

    public void G() {
        BaseFragment baseFragment = this.f60749a;
        if (baseFragment == null || !baseFragment.isAdded()) {
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
        if (this.f60754f == null) {
            d.b.h0.d0.h hVar = new d.b.h0.d0.h(this.f60749a.getActivity(), new e());
            this.f60754f = hVar;
            hVar.onChangeSkinType();
        }
        this.f60752d.setVisibility(8);
        this.f60754f.l(string);
        this.f60754f.attachView(this.f60750b, false);
        this.f60754f.o();
    }

    public void H() {
        m();
        this.f60752d.setVisibility(0);
    }

    public void i() {
        if (this.j || !d.b.b.e.p.j.z()) {
            return;
        }
        this.f60752d.loadUrl(this.f60756h);
    }

    public NavigationBar j() {
        return this.f60751c;
    }

    public BaseWebView k() {
        return this.f60752d;
    }

    public void l() {
        this.j = false;
        d.b.h0.d0.g gVar = this.f60753e;
        if (gVar != null) {
            gVar.dettachView(this.f60750b);
            this.f60753e = null;
        }
    }

    public void m() {
        d.b.h0.d0.h hVar = this.f60754f;
        if (hVar != null) {
            hVar.dettachView(this.f60750b);
            this.f60754f = null;
        }
    }

    public final void n() {
        ScrollBridgeWebview scrollBridgeWebview = this.f60752d;
        if (scrollBridgeWebview == null) {
            return;
        }
        scrollBridgeWebview.setOnLoadUrlListener(new f());
        this.f60752d.setOnPageStartedListener(new g());
        this.f60752d.setOnPageFinishedListener(new h());
        this.f60752d.setOnReceivedErrorListener(new i());
    }

    public void o(BaseFragment baseFragment) {
        this.f60749a = baseFragment;
        NavigationBar navigationBar = (NavigationBar) this.f60750b.findViewById(R.id.view_navigation_bar);
        this.f60751c = navigationBar;
        navigationBar.setVisibility(this.k ? 0 : 8);
        if (this.k) {
            this.f60751c.onChangeSkinType(this.f60749a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f60751c.showBottomLine(true);
            this.f60751c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
            this.f60751c.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ScrollBridgeWebview scrollBridgeWebview = (ScrollBridgeWebview) this.f60750b.findViewById(R.id.webview);
        this.f60752d = scrollBridgeWebview;
        scrollBridgeWebview.setOnScrollChangeListener(new d());
        n();
    }

    public final boolean p(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_BEAUTY_PIC) && str.contains("data=")) {
            String substring = str.substring(str.indexOf("data=") + 5);
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                JSONArray optJSONArray = new JSONObject(substring).optJSONArray("pic");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(optJSONArray.getString(i2));
                }
                if (arrayList.size() <= 0) {
                    return false;
                }
                ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                bVar.x(arrayList);
                bVar.C(true);
                bVar.K(arrayList.get(0));
                bVar.G(true);
                ImageViewerConfig v = bVar.v(this.f60749a.getActivity());
                v.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                this.f60749a.sendMessage(new CustomMessage(2010000, v));
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return false;
    }

    public final boolean q(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                l.K(this.f60749a.getActivity(), R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.f60749a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return false;
    }

    public final boolean r(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER)) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            l.K(this.f60749a.getActivity(), R.string.plugin_install_fail);
        } else {
            UrlManager.getInstance().dealOneLink(this.f60749a.getPageContext(), new String[]{str});
        }
        return true;
    }

    public final boolean s(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_FORUM_LIST)) {
            return false;
        }
        if (MessageManager.getInstance().findTask(2902025) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.f60749a.getActivity(), n0.c(str, "menuname="), n0.c(str, "menutype="), n0.c(str, "menuid="))));
        }
        return true;
    }

    public final boolean t(String str) {
        if (!str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") && !str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            if ((str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
                new HotRanklistActivityConfig(this.f60749a.getActivity()).createNormalConfig("discover", "all").start();
                return true;
            }
            return false;
        }
        String c2 = n0.c(str, "topic_id=");
        String c3 = n0.c(str, "topic_name=");
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
        if (!StringUtils.isNull(c2) && !StringUtils.isNull(c3, true)) {
            if (appResponseToIntentClass) {
                this.f60749a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f60749a.getActivity()).createNormalConfig(c2, c3, null)));
            } else {
                d.b.h0.l.a.m(this.f60749a.getActivity(), c3, str);
            }
        }
        return true;
    }

    public final boolean u(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_LEGO)) {
            if (!(MessageManager.getInstance().findTask(2016447) != null)) {
                l.K(this.f60749a.getActivity(), R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.f60749a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return false;
    }

    public final boolean v(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER)) {
            return false;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            l.K(this.f60749a.getActivity(), R.string.plugin_install_fail);
        } else {
            UrlManager.getInstance().dealOneLink(this.f60749a.getPageContext(), new String[]{str});
        }
        return true;
    }

    public final boolean w(String str) {
        if (this.f60749a.isAdded() && str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE)) {
            String urlDecode = k.getUrlDecode(str);
            if (!urlDecode.contains("data=")) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(urlDecode.substring(urlDecode.indexOf("data=") + 5));
                String optString = jSONObject.optString("title");
                String optString2 = jSONObject.optString("content");
                String optString3 = jSONObject.optString("link_url");
                String optString4 = jSONObject.optString("thread_id");
                String optString5 = jSONObject.optString("forum_name");
                String optString6 = jSONObject.optString("pic");
                if (TextUtils.isEmpty(optString3)) {
                    return false;
                }
                if (ViewHelper.checkUpIsLogin(this.f60749a.getActivity())) {
                    ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                    this.l = shareFromPBMsgData;
                    shareFromPBMsgData.setContent(optString2);
                    if (!TextUtils.isEmpty(optString6)) {
                        this.l.setImageUrl(optString6);
                    }
                    this.l.setForumName(optString5);
                    this.l.setThreadId(optString4);
                    this.l.setTitle(optString);
                    String format = MessageFormat.format(this.f60749a.getResources().getString(R.string.share_content_tpl), optString, optString2);
                    ShareItem shareItem = new ShareItem();
                    shareItem.r = optString;
                    shareItem.s = format;
                    shareItem.t = optString3;
                    shareItem.q = optString4;
                    if (!TextUtils.isEmpty(optString6)) {
                        shareItem.v = Uri.parse(optString6);
                    }
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f60749a.getActivity(), shareItem, true);
                    shareDialogConfig.setIsCopyLink(true);
                    shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_unite_share_baf, new j());
                    shareDialogConfig.setCopyLinkListener(new a(shareItem));
                    this.f60749a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
                }
                return true;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    public final void x(String str) {
        if (StringUtils.isNull(str)) {
        }
    }

    public void y(String str) {
        this.f60756h = str;
        this.f60752d.loadUrl(str);
    }

    public final boolean z(String str) {
        return u(str) || q(str) || t(str) || s(str) || v(str) || r(str) || p(str) || w(str);
    }
}
