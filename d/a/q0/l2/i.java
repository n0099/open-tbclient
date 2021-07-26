package d.a.q0.l2;

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
import d.a.p0.s.s.j;
import d.a.p0.s.s.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60646a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60647b;

    /* renamed from: c  reason: collision with root package name */
    public j f60648c;

    /* renamed from: d  reason: collision with root package name */
    public l f60649d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.p0.s.s.h> f60650e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.s.s.h f60651f;

    /* renamed from: g  reason: collision with root package name */
    public b f60652g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f60653h;

    /* renamed from: i  reason: collision with root package name */
    public l.d f60654i;

    /* loaded from: classes8.dex */
    public class a implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f60655a;

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
            this.f60655a = iVar;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60655a.f60653h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", this.f60655a.f60653h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.f60655a.f60652g != null) {
                this.f60655a.f60652g.a(this.f60655a.f60653h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", this.f60655a.f60653h.swan_app_id.longValue());
            statisticItem.param("obj_name", this.f60655a.f60653h.name);
            TiebaStatic.log(statisticItem);
            if (this.f60655a.f60648c != null) {
                this.f60655a.f60648c.dismiss();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(175679728, "Ld/a/q0/l2/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(175679728, "Ld/a/q0/l2/i;");
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
        this.f60654i = new a(this);
        this.f60646a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f60647b = pageActivity;
        this.f60649d = new l(pageActivity);
        this.f60650e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, smartApp) == null) {
            this.f60653h = smartApp;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f60648c == null) {
            d.a.p0.s.s.h hVar = new d.a.p0.s.s.h(this.f60647b.getString(R.string.delete), this.f60649d);
            this.f60651f = hVar;
            hVar.m(this.f60654i);
            this.f60650e.add(this.f60651f);
            this.f60649d.k(this.f60650e);
            this.f60648c = new j(this.f60646a, this.f60649d);
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f60652g = bVar;
        }
    }

    public void g() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.f60648c) == null) {
            return;
        }
        jVar.l();
    }
}
