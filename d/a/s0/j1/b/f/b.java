package d.a.s0.j1.b.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.r0.r.s.h;
import d.a.r0.r.s.j;
import d.a.r0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j f62226a;

    /* renamed from: b  reason: collision with root package name */
    public l f62227b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f62228c;

    /* renamed from: d  reason: collision with root package name */
    public h f62229d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.j1.b.f.a f62230e;

    /* renamed from: f  reason: collision with root package name */
    public c f62231f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f62232g;

    /* loaded from: classes9.dex */
    public class a implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62233a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62233a = bVar;
        }

        @Override // d.a.r0.r.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62233a.d();
            }
        }
    }

    /* renamed from: d.a.s0.j1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1541b implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62234a;

        public C1541b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62234a = bVar;
        }

        @Override // d.a.r0.r.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62234a.c();
                if (this.f62234a.f62231f != null) {
                    this.f62234a.f62231f.a();
                }
                this.f62234a.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a();
    }

    public b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62232g = new C1541b(this);
        this.f62227b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f62227b);
        this.f62229d = hVar;
        hVar.m(this.f62232g);
        ArrayList arrayList = new ArrayList();
        this.f62228c = arrayList;
        arrayList.add(this.f62229d);
        this.f62227b.m(new a(this));
        this.f62227b.k(this.f62228c);
        this.f62226a = new j(fVar, this.f62227b);
        e();
        f();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62230e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f62230e.f62222a);
        httpMessage.addParam("thread_id", this.f62230e.f62223b);
        httpMessage.addParam("post_id", this.f62230e.f62224c);
        httpMessage.addParam("ori_ugc_nid", this.f62230e.f62225d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (jVar = this.f62226a) != null && jVar.isShowing()) {
            this.f62226a.dismiss();
        }
    }

    public void e() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (lVar = this.f62227b) == null) {
            return;
        }
        lVar.j();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
            tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void g(d.a.s0.j1.b.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f62230e = aVar;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f62231f = cVar;
        }
    }

    public void i() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (jVar = this.f62226a) == null) {
            return;
        }
        jVar.show();
    }
}
