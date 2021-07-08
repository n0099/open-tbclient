package d.a.p0.j1.b.f;

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
import d.a.o0.r.s.h;
import d.a.o0.r.s.j;
import d.a.o0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j f58991a;

    /* renamed from: b  reason: collision with root package name */
    public l f58992b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f58993c;

    /* renamed from: d  reason: collision with root package name */
    public h f58994d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.j1.b.f.a f58995e;

    /* renamed from: f  reason: collision with root package name */
    public c f58996f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f58997g;

    /* loaded from: classes8.dex */
    public class a implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f58998a;

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
            this.f58998a = bVar;
        }

        @Override // d.a.o0.r.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58998a.d();
            }
        }
    }

    /* renamed from: d.a.p0.j1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1497b implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f58999a;

        public C1497b(b bVar) {
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
            this.f58999a = bVar;
        }

        @Override // d.a.o0.r.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58999a.c();
                if (this.f58999a.f58996f != null) {
                    this.f58999a.f58996f.a();
                }
                this.f58999a.d();
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f58997g = new C1497b(this);
        this.f58992b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f58992b);
        this.f58994d = hVar;
        hVar.m(this.f58997g);
        ArrayList arrayList = new ArrayList();
        this.f58993c = arrayList;
        arrayList.add(this.f58994d);
        this.f58992b.m(new a(this));
        this.f58992b.k(this.f58993c);
        this.f58991a = new j(fVar, this.f58992b);
        e();
        f();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58995e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f58995e.f58987a);
        httpMessage.addParam("thread_id", this.f58995e.f58988b);
        httpMessage.addParam("post_id", this.f58995e.f58989c);
        httpMessage.addParam("ori_ugc_nid", this.f58995e.f58990d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (jVar = this.f58991a) != null && jVar.isShowing()) {
            this.f58991a.dismiss();
        }
    }

    public void e() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (lVar = this.f58992b) == null) {
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

    public void g(d.a.p0.j1.b.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f58995e = aVar;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f58996f = cVar;
        }
    }

    public void i() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (jVar = this.f58991a) == null) {
            return;
        }
        jVar.show();
    }
}
