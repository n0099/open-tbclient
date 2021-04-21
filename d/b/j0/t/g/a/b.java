package d.b.j0.t.g.a;

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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.z0.n0;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f62734a;

    /* renamed from: b  reason: collision with root package name */
    public View f62735b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62736c;

    /* renamed from: d  reason: collision with root package name */
    public ScrollBridgeWebview f62737d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.d0.g f62738e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.d0.h f62739f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62740g;

    /* renamed from: h  reason: collision with root package name */
    public String f62741h;
    public int i = 0;
    public boolean j;
    public boolean k;
    public ShareFromPBMsgData l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f62742e;

        public a(ShareItem shareItem) {
            this.f62742e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.c.e.p.a.a(this.f62742e.t);
            l.L(b.this.f62734a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* renamed from: d.b.j0.t.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1637b implements CustomMessageTask.CustomRunnable<String> {
        public C1637b() {
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
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, b.this.f62734a.getPageContext().getUniqueId()));
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
                UrlManager.getInstance().dealOneLink(b.this.f62734a.getPageContext(), new String[]{str});
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
            if (d.b.c.e.p.j.z()) {
                b.this.H();
                b.this.f62740g = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements BaseWebView.h {
        public i() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i, String str, String str2) {
            b.this.G();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(b.this.f62734a.getActivity(), 23007, 1)));
        }
    }

    public b(boolean z) {
        this.k = false;
        CustomMessageTask customMessageTask = new CustomMessageTask(2921015, new C1637b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.k = z;
    }

    public void A(int i2) {
        NavigationBar navigationBar = this.f62736c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f62734a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f62736c.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
    }

    public View B(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.ala_frs_live_video_fragment, (ViewGroup) null);
        this.f62735b = inflate;
        inflate.setDrawingCacheEnabled(false);
        return this.f62735b;
    }

    public void C() {
        MessageManager.getInstance().unRegisterTask(2921015);
        NavigationBar navigationBar = this.f62736c;
        if (navigationBar != null) {
            navigationBar.release();
        }
    }

    public void D() {
        if (this.f62740g) {
            this.f62737d.loadUrl("javascript:window.reload_page()");
        } else {
            this.f62737d.loadUrl(this.f62741h);
        }
    }

    public final void E(boolean z, boolean z2) {
        if (z) {
            CustomMessage customMessage = new CustomMessage(2001617);
            customMessage.setTag(this.f62734a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        CustomMessage customMessage2 = new CustomMessage(2001618);
        customMessage2.setTag(this.f62734a.getBaseFragmentActivity().getUniqueId());
        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
        customResponsedMessage2.setOrginalMessage(customMessage2);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
    }

    public void F() {
        BaseFragment baseFragment = this.f62734a;
        if (baseFragment == null || this.f62735b == null || !baseFragment.isAdded()) {
            return;
        }
        this.j = true;
        d.b.i0.d0.g gVar = new d.b.i0.d0.g(this.f62734a.getActivity(), this.f62734a.getResources().getDimensionPixelSize(R.dimen.ds270));
        this.f62738e = gVar;
        gVar.attachView(this.f62735b, false);
        this.f62738e.onChangeSkinType();
    }

    public void G() {
        BaseFragment baseFragment = this.f62734a;
        if (baseFragment == null || !baseFragment.isAdded()) {
            return;
        }
        String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
        if (this.f62739f == null) {
            d.b.i0.d0.h hVar = new d.b.i0.d0.h(this.f62734a.getActivity(), new e());
            this.f62739f = hVar;
            hVar.onChangeSkinType();
        }
        this.f62737d.setVisibility(8);
        this.f62739f.l(string);
        this.f62739f.attachView(this.f62735b, false);
        this.f62739f.o();
    }

    public void H() {
        m();
        this.f62737d.setVisibility(0);
    }

    public void i() {
        if (this.j || !d.b.c.e.p.j.z()) {
            return;
        }
        this.f62737d.loadUrl(this.f62741h);
    }

    public NavigationBar j() {
        return this.f62736c;
    }

    public BaseWebView k() {
        return this.f62737d;
    }

    public void l() {
        this.j = false;
        d.b.i0.d0.g gVar = this.f62738e;
        if (gVar != null) {
            gVar.dettachView(this.f62735b);
            this.f62738e = null;
        }
    }

    public void m() {
        d.b.i0.d0.h hVar = this.f62739f;
        if (hVar != null) {
            hVar.dettachView(this.f62735b);
            this.f62739f = null;
        }
    }

    public final void n() {
        ScrollBridgeWebview scrollBridgeWebview = this.f62737d;
        if (scrollBridgeWebview == null) {
            return;
        }
        scrollBridgeWebview.setOnLoadUrlListener(new f());
        this.f62737d.setOnPageStartedListener(new g());
        this.f62737d.setOnPageFinishedListener(new h());
        this.f62737d.setOnReceivedErrorListener(new i());
    }

    public void o(BaseFragment baseFragment) {
        this.f62734a = baseFragment;
        NavigationBar navigationBar = (NavigationBar) this.f62735b.findViewById(R.id.view_navigation_bar);
        this.f62736c = navigationBar;
        navigationBar.setVisibility(this.k ? 0 : 8);
        if (this.k) {
            this.f62736c.onChangeSkinType(this.f62734a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f62736c.showBottomLine(true);
            this.f62736c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
            this.f62736c.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        ScrollBridgeWebview scrollBridgeWebview = (ScrollBridgeWebview) this.f62735b.findViewById(R.id.webview);
        this.f62737d = scrollBridgeWebview;
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
                ImageViewerConfig v = bVar.v(this.f62734a.getActivity());
                v.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                this.f62734a.sendMessage(new CustomMessage(2010000, v));
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
                l.K(this.f62734a.getActivity(), R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.f62734a.getPageContext(), new String[]{str});
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
            l.K(this.f62734a.getActivity(), R.string.plugin_install_fail);
        } else {
            UrlManager.getInstance().dealOneLink(this.f62734a.getPageContext(), new String[]{str});
        }
        return true;
    }

    public final boolean s(String str) {
        if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_FORUM_LIST)) {
            return false;
        }
        if (MessageManager.getInstance().findTask(2902025) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.f62734a.getActivity(), n0.c(str, "menuname="), n0.c(str, "menutype="), n0.c(str, "menuid="))));
        }
        return true;
    }

    public final boolean t(String str) {
        if (!str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") && !str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            if ((str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
                new HotRanklistActivityConfig(this.f62734a.getActivity()).createNormalConfig("discover", "all").start();
                return true;
            }
            return false;
        }
        String c2 = n0.c(str, "topic_id=");
        String c3 = n0.c(str, "topic_name=");
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
        if (!StringUtils.isNull(c2) && !StringUtils.isNull(c3, true)) {
            if (appResponseToIntentClass) {
                this.f62734a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f62734a.getActivity()).createNormalConfig(c2, c3, null)));
            } else {
                d.b.i0.l.a.m(this.f62734a.getActivity(), c3, str);
            }
        }
        return true;
    }

    public final boolean u(String str) {
        if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_LEGO)) {
            if (!(MessageManager.getInstance().findTask(2016447) != null)) {
                l.K(this.f62734a.getActivity(), R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.f62734a.getPageContext(), new String[]{str});
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
            l.K(this.f62734a.getActivity(), R.string.plugin_install_fail);
        } else {
            UrlManager.getInstance().dealOneLink(this.f62734a.getPageContext(), new String[]{str});
        }
        return true;
    }

    public final boolean w(String str) {
        if (this.f62734a.isAdded() && str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE)) {
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
                if (ViewHelper.checkUpIsLogin(this.f62734a.getActivity())) {
                    ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                    this.l = shareFromPBMsgData;
                    shareFromPBMsgData.setContent(optString2);
                    if (!TextUtils.isEmpty(optString6)) {
                        this.l.setImageUrl(optString6);
                    }
                    this.l.setForumName(optString5);
                    this.l.setThreadId(optString4);
                    this.l.setTitle(optString);
                    String format = MessageFormat.format(this.f62734a.getResources().getString(R.string.share_content_tpl), optString, optString2);
                    ShareItem shareItem = new ShareItem();
                    shareItem.r = optString;
                    shareItem.s = format;
                    shareItem.t = optString3;
                    shareItem.q = optString4;
                    if (!TextUtils.isEmpty(optString6)) {
                        shareItem.v = Uri.parse(optString6);
                    }
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f62734a.getActivity(), shareItem, true);
                    shareDialogConfig.setIsCopyLink(true);
                    shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_unite_share_baf, new j());
                    shareDialogConfig.setCopyLinkListener(new a(shareItem));
                    this.f62734a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
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
        this.f62741h = str;
        this.f62737d.loadUrl(str);
    }

    public final boolean z(String str) {
        return u(str) || q(str) || t(str) || s(str) || v(str) || r(str) || p(str) || w(str);
    }
}
