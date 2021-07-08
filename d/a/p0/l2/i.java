package d.a.p0.l2;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.j;
import d.a.o0.r.s.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60032a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60033b;

    /* renamed from: c  reason: collision with root package name */
    public j f60034c;

    /* renamed from: d  reason: collision with root package name */
    public l f60035d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.o0.r.s.h> f60036e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.r.s.h f60037f;

    /* renamed from: g  reason: collision with root package name */
    public b f60038g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f60039h;

    /* renamed from: i  reason: collision with root package name */
    public l.d f60040i;

    /* loaded from: classes8.dex */
    public class a implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f60041a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60041a = iVar;
        }

        @Override // d.a.o0.r.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60041a.f60039h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", this.f60041a.f60039h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.f60041a.f60038g != null) {
                this.f60041a.f60038g.a(this.f60041a.f60039h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", this.f60041a.f60039h.swan_app_id.longValue());
            statisticItem.param("obj_name", this.f60041a.f60039h.name);
            TiebaStatic.log(statisticItem);
            if (this.f60041a.f60034c != null) {
                this.f60041a.f60034c.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1567130607, "Ld/a/p0/l2/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1567130607, "Ld/a/p0/l2/i;");
                return;
            }
        }
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60040i = new a(this);
        this.f60032a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f60033b = pageActivity;
        this.f60035d = new l(pageActivity);
        this.f60036e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, smartApp) == null) {
            this.f60039h = smartApp;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f60034c == null) {
            d.a.o0.r.s.h hVar = new d.a.o0.r.s.h(this.f60033b.getString(R.string.delete), this.f60035d);
            this.f60037f = hVar;
            hVar.m(this.f60040i);
            this.f60036e.add(this.f60037f);
            this.f60035d.k(this.f60036e);
            this.f60034c = new j(this.f60032a, this.f60035d);
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f60038g = bVar;
        }
    }

    public void g() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f60034c) == null) {
            return;
        }
        jVar.l();
    }
}
