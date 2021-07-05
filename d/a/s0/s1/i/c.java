package d.a.s0.s1.i;

import android.content.Intent;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import d.a.r0.z0.n;
import d.a.r0.z0.p0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65372a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.s1.i.b f65373b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.s1.i.d f65374c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f65375d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65376e;

    /* renamed from: f  reason: collision with root package name */
    public SearchJsBridge f65377f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f65378g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f65379h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f65380i;
    public CustomMessageListener j;

    /* loaded from: classes9.dex */
    public class a implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
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
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65381a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65381a = cVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) && webView == this.f65381a.f65374c.e()) {
                this.f65381a.p(false);
            }
        }
    }

    /* renamed from: d.a.s0.s1.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1674c implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f65382e;

        public C1674c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65382e = cVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                if (this.f65382e.o(str)) {
                    return true;
                }
                if (this.f65382e.f65372a != null && this.f65382e.f65372a.getPageActivity() != null) {
                    if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f65382e.f65372a, new String[]{str}) != 3) {
                        return true;
                    }
                    if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                        Intent parseIntentFromUrl = BaseWebViewActivity.parseIntentFromUrl(this.f65382e.f65372a.getPageActivity(), str);
                        if (parseIntentFromUrl != null) {
                            try {
                                this.f65382e.f65372a.getPageActivity().startActivity(parseIntentFromUrl);
                            } catch (Throwable th) {
                                BdLog.detailException(th);
                            }
                            return true;
                        }
                    } else {
                        UrlManager.getInstance().dealOneLink(this.f65382e.f65372a, new String[]{str}, true);
                        return true;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends f0<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public List<String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.s0.h3.n0.a.k() : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements n<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65383a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65383a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f65383a.f65375d = list;
            this.f65383a.f65377f.setHistoryDatas(this.f65383a.f65375d);
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65384a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f65384a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.f65384a.f65376e = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65385a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f65385a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f65385a.f65375d.remove((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65386a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f65386a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f65386a.f65375d == null) {
                return;
            }
            this.f65386a.f65375d.clear();
        }
    }

    /* loaded from: classes9.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65387a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f65387a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                try {
                    JSONObject jSONObject = new JSONObject((String) customResponsedMessage.getData());
                    String optString = jSONObject.optString("query");
                    int optInt = jSONObject.optInt("subType");
                    if (this.f65387a.f65373b != null) {
                        this.f65387a.f65373b.a(optString, true, optInt);
                        TiebaStatic.log(new StatisticItem("c12034"));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public c(BaseActivity baseActivity, d.a.s0.s1.i.b bVar, d.a.s0.s1.i.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, bVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65375d = new ArrayList();
        this.f65372a = baseActivity.getPageContext();
        this.f65373b = bVar;
        this.f65374c = dVar;
        m();
        n();
        k();
    }

    public void j(String str) {
        List<String> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNull(str) || (list = this.f65375d) == null) {
            return;
        }
        list.remove(str);
        this.f65375d.add(0, str);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i0.b(new d(this), new e(this));
        }
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int count = ListUtils.getCount(this.f65375d);
            if (count == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < count; i2++) {
                jSONArray.put(this.f65375d.get(i2));
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f65378g = new f(this, 2921556);
            this.f65379h = new g(this, 2921557);
            this.f65380i = new h(this, 2921558);
            this.j = new i(this, 2921559);
            MessageManager.getInstance().registerListener(this.f65378g);
            MessageManager.getInstance().registerListener(this.f65379h);
            MessageManager.getInstance().registerListener(this.f65380i);
            MessageManager.getInstance().registerListener(this.j);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a aVar = new a(this);
            b bVar = new b(this);
            C1674c c1674c = new C1674c(this);
            QuickWebView e2 = this.f65374c.e();
            if (e2 != null) {
                SearchJsBridge searchJsBridge = new SearchJsBridge(this.f65375d);
                this.f65377f = searchJsBridge;
                e2.h(searchJsBridge);
                e2.setOnPageFinishedListener(aVar);
                e2.setOnReceivedErrorListener(bVar);
                e2.setOnLoadUrlListener(c1674c);
            }
        }
    }

    public final boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") && !str.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC2) && !str.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW) || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) {
                    if (!d.a.r0.p0.b.b(this.f65372a)) {
                        new HotRanklistActivityConfig(this.f65372a.getPageActivity()).createNormalConfig("hotforum", "all").start();
                    }
                    return true;
                }
                return false;
            }
            String c2 = p0.c(str, "topic_id=");
            String c3 = p0.c(str, "topic_name=");
            if (!d.a.r0.p0.b.b(this.f65372a) && !StringUtils.isNull(c2) && !StringUtils.isNull(c3, true)) {
                this.f65372a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f65372a.getPageActivity()).createNormalConfig(c2, c3, "4")));
            }
            TiebaStatic.log(new StatisticItem("c10363").param("obj_name", c3));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p(boolean z) {
        NoDataViewFactory.e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z) {
                this.f65374c.w();
                if (j.z()) {
                    a2 = NoDataViewFactory.e.a(R.string.text_no_search_record);
                } else {
                    a2 = NoDataViewFactory.e.a(R.string.neterror);
                }
                this.f65374c.v(a2);
                return;
            }
            this.f65374c.s();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f65374c.s();
            if (this.f65376e) {
                String l = l();
                if (StringUtils.isNull(l)) {
                    return;
                }
                QuickWebView e2 = this.f65374c.e();
                e2.loadUrl("javascript:setSearchHistory('" + l + "')");
                return;
            }
            QuickWebView e3 = this.f65374c.e();
            e3.loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/searchHistory");
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f65378g);
            MessageManager.getInstance().unRegisterListener(this.f65379h);
            MessageManager.getInstance().unRegisterListener(this.f65380i);
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }
}
