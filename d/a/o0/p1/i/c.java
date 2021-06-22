package d.a.o0.p1.i;

import android.content.Intent;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.quickWebView.QuickWebView;
import d.a.c.e.p.j;
import d.a.n0.z0.f0;
import d.a.n0.z0.h0;
import d.a.n0.z0.n;
import d.a.n0.z0.n0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61911a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.p1.i.b f61912b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.p1.i.d f61913c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f61914d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f61915e;

    /* renamed from: f  reason: collision with root package name */
    public SearchJsBridge f61916f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f61917g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f61918h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f61919i;
    public CustomMessageListener j;

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.e {
        public a(c cVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.h {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            if (webView == c.this.f61913c.e()) {
                c.this.p(false);
            }
        }
    }

    /* renamed from: d.a.o0.p1.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1528c implements BaseWebView.d {
        public C1528c() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (c.this.o(str)) {
                return true;
            }
            if (c.this.f61911a != null && c.this.f61911a.getPageActivity() != null) {
                if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(c.this.f61911a, new String[]{str}) != 3) {
                    return true;
                }
                if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    Intent parseIntentFromUrl = BaseWebViewActivity.parseIntentFromUrl(c.this.f61911a.getPageActivity(), str);
                    if (parseIntentFromUrl != null) {
                        try {
                            c.this.f61911a.getPageActivity().startActivity(parseIntentFromUrl);
                        } catch (Throwable th) {
                            BdLog.detailException(th);
                        }
                        return true;
                    }
                } else {
                    UrlManager.getInstance().dealOneLink(c.this.f61911a, new String[]{str}, true);
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends f0<List<String>> {
        public d(c cVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.f0
        /* renamed from: a */
        public List<String> doInBackground() {
            return d.a.o0.e3.n0.a.k();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements n<List<String>> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(List<String> list) {
            if (ListUtils.isEmpty(list)) {
                return;
            }
            c.this.f61914d = list;
            c.this.f61916f.setHistoryDatas(c.this.f61914d);
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            c.this.f61915e = ((Boolean) customResponsedMessage.getData()).booleanValue();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            c.this.f61914d.remove((String) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.f61914d != null) {
                c.this.f61914d.clear();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject((String) customResponsedMessage.getData());
                String optString = jSONObject.optString("query");
                int optInt = jSONObject.optInt("subType");
                if (c.this.f61912b != null) {
                    c.this.f61912b.a(optString, true, optInt);
                    TiebaStatic.log(new StatisticItem("c12034"));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public c(BaseActivity baseActivity, d.a.o0.p1.i.b bVar, d.a.o0.p1.i.d dVar) {
        this.f61911a = baseActivity.getPageContext();
        this.f61912b = bVar;
        this.f61913c = dVar;
        m();
        n();
        k();
    }

    public void j(String str) {
        List<String> list;
        if (StringUtils.isNull(str) || (list = this.f61914d) == null) {
            return;
        }
        list.remove(str);
        this.f61914d.add(0, str);
    }

    public final void k() {
        h0.b(new d(this), new e());
    }

    public final String l() {
        int count = ListUtils.getCount(this.f61914d);
        if (count == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < count; i2++) {
            jSONArray.put(this.f61914d.get(i2));
        }
        return jSONArray.toString();
    }

    public final void m() {
        this.f61917g = new f(2921556);
        this.f61918h = new g(2921557);
        this.f61919i = new h(2921558);
        this.j = new i(2921559);
        MessageManager.getInstance().registerListener(this.f61917g);
        MessageManager.getInstance().registerListener(this.f61918h);
        MessageManager.getInstance().registerListener(this.f61919i);
        MessageManager.getInstance().registerListener(this.j);
    }

    public final void n() {
        a aVar = new a(this);
        b bVar = new b();
        C1528c c1528c = new C1528c();
        QuickWebView e2 = this.f61913c.e();
        if (e2 != null) {
            SearchJsBridge searchJsBridge = new SearchJsBridge(this.f61914d);
            this.f61916f = searchJsBridge;
            e2.h(searchJsBridge);
            e2.setOnPageFinishedListener(aVar);
            e2.setOnReceivedErrorListener(bVar);
            e2.setOnLoadUrlListener(c1528c);
        }
    }

    public final boolean o(String str) {
        if (!str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") && !str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
            if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) {
                if (!d.a.n0.p0.b.b(this.f61911a)) {
                    new HotRanklistActivityConfig(this.f61911a.getPageActivity()).createNormalConfig("hotforum", "all").start();
                }
                return true;
            }
            return false;
        }
        String c2 = n0.c(str, "topic_id=");
        String c3 = n0.c(str, "topic_name=");
        if (!d.a.n0.p0.b.b(this.f61911a) && !StringUtils.isNull(c2) && !StringUtils.isNull(c3, true)) {
            this.f61911a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f61911a.getPageActivity()).createNormalConfig(c2, c3, "4")));
        }
        TiebaStatic.log(new StatisticItem("c10363").param("obj_name", c3));
        return true;
    }

    public final void p(boolean z) {
        NoDataViewFactory.e a2;
        if (!z) {
            this.f61913c.w();
            if (j.z()) {
                a2 = NoDataViewFactory.e.a(R.string.text_no_search_record);
            } else {
                a2 = NoDataViewFactory.e.a(R.string.neterror);
            }
            this.f61913c.v(a2);
            return;
        }
        this.f61913c.s();
    }

    public void q() {
        this.f61913c.s();
        if (this.f61915e) {
            String l = l();
            if (StringUtils.isNull(l)) {
                return;
            }
            QuickWebView e2 = this.f61913c.e();
            e2.loadUrl("javascript:setSearchHistory('" + l + "')");
            return;
        }
        QuickWebView e3 = this.f61913c.e();
        e3.loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/searchHistory");
    }

    public void r() {
        MessageManager.getInstance().unRegisterListener(this.f61917g);
        MessageManager.getInstance().unRegisterListener(this.f61918h);
        MessageManager.getInstance().unRegisterListener(this.f61919i);
        MessageManager.getInstance().unRegisterListener(this.j);
    }
}
