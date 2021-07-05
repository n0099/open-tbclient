package d.a.s0.s1.i;

import android.content.Intent;
import android.net.http.SslError;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.s0;
import d.a.r0.z0.e0;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import d.a.r0.z0.p0;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes9.dex */
public class e implements d.a.s0.s1.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f65399a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.s1.i.d f65400b;

    /* renamed from: c  reason: collision with root package name */
    public View f65401c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65402d;

    /* renamed from: e  reason: collision with root package name */
    public HotSearchInfoData f65403e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65404f;

    /* renamed from: g  reason: collision with root package name */
    public String f65405g;

    /* renamed from: h  reason: collision with root package name */
    public Stack<String> f65406h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.s1.i.c f65407i;
    public CustomMessageListener j;

    /* loaded from: classes9.dex */
    public class a implements BaseWebView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) || sslError == null) {
                return;
            }
            d.a.r0.r.z.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f65408e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65408e = eVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                d.a.r0.r.z.a.a("search", -1L, 0, "OverrideUrl", 0, "", "requesturl", str);
                if (!TbadkCoreApplication.isLogin() && str != null && e0.e(str) && e0.a()) {
                    s0 s0Var = new s0(this.f65408e.f65399a, "sousuo_dianji");
                    s0Var.f(str);
                    DialogLoginHelper.checkUpIsLogin(s0Var);
                    return true;
                } else if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f65408e.f65399a.getPageContext(), new String[]{str}) != 3) {
                    return true;
                } else {
                    if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                        Intent parseIntentFromUrl = BaseWebViewActivity.parseIntentFromUrl(this.f65408e.f65399a.getApplicationContext(), str);
                        if (parseIntentFromUrl != null) {
                            try {
                                this.f65408e.f65399a.startActivity(parseIntentFromUrl);
                            } catch (Throwable th) {
                                BdLog.detailException(th);
                            }
                            return true;
                        }
                        return false;
                    }
                    UrlManager.getInstance().dealOneLink(this.f65408e.f65399a.getPageContext(), new String[]{str}, true);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f65409a;

        public c(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65409a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.s0.h3.n0.a.o(this.f65409a);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f65410a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65410a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.f65410a.f65400b.L(!((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* renamed from: d.a.s0.s1.i.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnFocusChangeListenerC1675e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f65411e;

        public View$OnFocusChangeListenerC1675e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65411e = eVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (!z) {
                    d.a.c.e.p.l.x(this.f65411e.f65399a.getPageContext().getPageActivity(), view);
                } else {
                    this.f65411e.o();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f65412a;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65412a = eVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 3) {
                    if (StringUtils.isNull(this.f65412a.f65405g)) {
                        d.a.c.e.p.l.x(this.f65412a.f65399a.getPageContext().getPageActivity(), textView);
                        this.f65412a.x();
                    } else {
                        e eVar = this.f65412a;
                        eVar.a(eVar.f65405g, false, 1);
                        TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", this.f65412a.f65405g).param("obj_source", "1").param("obj_type", "1"));
                    }
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f65413e;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65413e = eVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            if (this.f65413e.f65404f) {
                this.f65413e.f65405g = editable.toString();
                this.f65413e.D();
            }
            this.f65413e.f65400b.r(!StringUtils.isNull(editable.toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f65414e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f65415e;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65415e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f65415e.f65414e.f65399a.finish();
                }
            }
        }

        public h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65414e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view != this.f65414e.f65400b.g() || this.f65414e.f65400b.g().getText() == null) {
                    if (view == this.f65414e.f65400b.d()) {
                        d.a.c.e.p.l.x(this.f65414e.f65399a.getPageContext().getPageActivity(), this.f65414e.f65400b.g());
                        d.a.c.e.m.e.a().postDelayed(new a(this), 1000L);
                        return;
                    }
                    return;
                }
                e eVar = this.f65414e;
                eVar.f65405g = eVar.f65400b.g().getText().toString();
                if (StringUtils.isNull(this.f65414e.f65405g)) {
                    this.f65414e.C();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f65416e;

        public i(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65416e = eVar;
        }

        /* JADX WARN: Type inference failed for: r6v1, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            ?? adapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (adapter = adapterView.getAdapter()) == 0 || i2 >= adapter.getCount()) {
                return;
            }
            Object item = adapter.getItem(i2);
            if (item instanceof String) {
                String str = (String) item;
                this.f65416e.a(str, true, 3);
                TiebaStatic.eventStat(this.f65416e.f65399a.getPageContext().getPageActivity(), "search_bar_result_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "2").param("obj_type", "1").param("obj_locate", i2 + 1).param("obj_param1", this.f65416e.f65405g));
            } else if (item instanceof ForumInfo) {
                ForumInfo forumInfo = (ForumInfo) item;
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f65416e.f65399a.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTER_FORUM_SUG_SHOW).param("obj_type", forumInfo.has_concerned.intValue() <= 0 ? "2" : "1").param("fid", forumInfo.forum_id.intValue()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f65417e;

        public j(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65417e = eVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 == 2 || i2 == 1) {
                    d.a.c.e.p.l.x(this.f65417e.f65399a.getPageContext().getPageActivity(), absListView);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                d.a.r0.r.z.a.a("search", -1L, 0, "PageFinished", 0, "", "requesturl", str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                d.a.r0.r.z.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i2), "description", str);
            }
        }
    }

    public e(BaseActivity baseActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65404f = true;
        this.f65406h = new Stack<>();
        this.j = new d(this, 2921444);
        this.f65399a = baseActivity;
        this.f65402d = z;
        r();
    }

    public void A(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f65400b.E(list, this.f65405g);
        }
    }

    public void B(List<ForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f65400b.F(list, this.f65405g);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f65407i.q();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!StringUtils.isNull(this.f65405g)) {
                w();
            } else {
                C();
            }
        }
    }

    @Override // d.a.s0.s1.i.b
    public void a(String str, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (!d.a.c.e.p.j.z()) {
                this.f65399a.showToast(R.string.neterror);
            } else if (StringUtils.isNull(str)) {
            } else {
                Matcher matcher = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2).matcher(str);
                if (matcher != null && matcher.find() && !TextUtils.isEmpty(matcher.group(2))) {
                    str = matcher.group(2);
                }
                if (z) {
                    this.f65404f = false;
                    this.f65400b.C(str);
                    this.f65404f = true;
                }
                d.a.c.e.p.l.x(this.f65399a.getPageContext().getPageActivity(), this.f65400b.g());
                this.f65400b.y();
                String str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + str + "&sub_type=" + i2;
                try {
                    str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + URLEncoder.encode(str, "utf-8");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f65400b.f().loadUrl(str2);
                this.f65406h.push(str);
                i0.b(new c(this, str), null);
                this.f65407i.j(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f65400b.f().h(new UegTbJsBridge(this.f65399a.getPageContext()));
            this.f65400b.f().h(new SearchJsBridge());
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k kVar = new k(this);
            l lVar = new l(this);
            a aVar = new a(this);
            b bVar = new b(this);
            this.f65400b.I(kVar);
            this.f65400b.K(lVar);
            this.f65400b.J(aVar);
            this.f65400b.H(bVar);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = new i(this);
            j jVar = new j(this);
            this.f65400b.t(iVar);
            this.f65400b.u(jVar);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View$OnFocusChangeListenerC1675e view$OnFocusChangeListenerC1675e = new View$OnFocusChangeListenerC1675e(this);
            f fVar = new f(this);
            g gVar = new g(this);
            h hVar = new h(this);
            this.f65400b.A(view$OnFocusChangeListenerC1675e);
            this.f65400b.z(fVar);
            this.f65400b.D(gVar);
            this.f65400b.x(hVar);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f65400b.n()) {
            return;
        }
        w();
    }

    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f65400b.g() : (View) invokeV.objValue;
    }

    public BaseWebView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f65400b.f() : (BaseWebView) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                View inflate = LayoutInflater.from(this.f65399a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                this.f65401c = inflate;
                this.f65399a.setContentView(inflate);
            } catch (Exception e2) {
                e2.printStackTrace();
                Map<String, String> a2 = d.a.s0.s1.i.a.a();
                if (a2 != null) {
                    int size = a2.size();
                    int i2 = 0;
                    for (String str : a2.keySet()) {
                        d.a.s0.s1.i.a.b(str);
                        try {
                            View inflate2 = LayoutInflater.from(this.f65399a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                            this.f65401c = inflate2;
                            this.f65399a.setContentView(inflate2);
                            break;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            i2++;
                        }
                    }
                    if (i2 == size) {
                        this.f65399a.finish();
                        return;
                    }
                } else {
                    this.f65399a.finish();
                    return;
                }
            }
            View view = this.f65401c;
            if (view == null) {
                this.f65399a.finish();
                return;
            }
            d.a.s0.s1.i.d dVar = new d.a.s0.s1.i.d(view, this.f65399a.getPageContext().getPageActivity());
            this.f65400b = dVar;
            this.f65407i = new d.a.s0.s1.i.c(this.f65399a, this, dVar);
            n();
            m();
            l();
            k();
            y();
            D();
            p0.g(this.f65400b.f(), this.f65399a.getUniqueId());
            p0.g(this.f65400b.e(), this.f65399a.getUniqueId());
            this.f65399a.registerListener(this.j);
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f65400b.o(this.f65399a.getPageContext(), i2);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.a.s0.s1.i.d dVar = this.f65400b;
            if (dVar != null) {
                dVar.p();
            }
            d.a.s0.s1.i.c cVar = this.f65407i;
            if (cVar != null) {
                cVar.r();
            }
        }
    }

    public void u() {
        d.a.s0.s1.i.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (dVar = this.f65400b) == null) {
            return;
        }
        dVar.q();
    }

    public void v() {
        d.a.s0.s1.i.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f65406h.size() > 1) {
                this.f65406h.pop();
                String peek = this.f65406h.peek();
                if (TextUtils.isEmpty(peek) || (dVar = this.f65400b) == null) {
                    return;
                }
                boolean z = this.f65404f;
                this.f65404f = false;
                dVar.C(peek);
                this.f65404f = z;
                this.f65400b.y();
                return;
            }
            this.f65406h.clear();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (StringUtils.isNull(this.f65405g)) {
                C();
                return;
            }
            SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
            searchListNetMessage.mKey = this.f65405g.trim();
            searchListNetMessage.isForum = Integer.valueOf(this.f65402d ? 1 : 0);
            this.f65399a.sendMessage(searchListNetMessage);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            HotSearchInfoData hotSearchInfoData = this.f65403e;
            if (hotSearchInfoData == null) {
                BaseActivity baseActivity = this.f65399a;
                baseActivity.showToast(baseActivity.getResources().getString(R.string.write_keyword));
                return;
            }
            if (hotSearchInfoData.x() != 0 && this.f65403e.x() != 2) {
                if (this.f65403e.x() == 1 && !d.a.r0.p0.b.b(this.f65399a.getPageContext())) {
                    this.f65399a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f65399a.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.f65403e.getId()), this.f65403e.getName(), "4")));
                }
            } else {
                a(this.f65403e.getName(), true, 1);
            }
            TiebaStatic.log(new StatisticItem("c10355").param("obj_name", this.f65403e.getName()).param("obj_type", this.f65403e.x() == 0 ? 2 : 1));
        }
    }

    public final void y() {
        d.a.s0.s1.i.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (dVar = this.f65400b) == null) {
            return;
        }
        HotSearchInfoData hotSearchInfoData = this.f65403e;
        if (hotSearchInfoData == null) {
            dVar.B(this.f65399a.getResources().getString(R.string.search_bar));
        } else {
            dVar.B(hotSearchInfoData.w());
        }
    }

    public void z(HotSearchInfoData hotSearchInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hotSearchInfoData) == null) {
            this.f65403e = hotSearchInfoData;
            y();
        }
    }
}
