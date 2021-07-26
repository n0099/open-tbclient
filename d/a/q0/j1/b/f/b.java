package d.a.q0.j1.b.f;

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
import d.a.d.a.f;
import d.a.p0.s.s.h;
import d.a.p0.s.s.j;
import d.a.p0.s.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j f59605a;

    /* renamed from: b  reason: collision with root package name */
    public l f59606b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f59607c;

    /* renamed from: d  reason: collision with root package name */
    public h f59608d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.j1.b.f.a f59609e;

    /* renamed from: f  reason: collision with root package name */
    public c f59610f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f59611g;

    /* loaded from: classes8.dex */
    public class a implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59612a;

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
            this.f59612a = bVar;
        }

        @Override // d.a.p0.s.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59612a.d();
            }
        }
    }

    /* renamed from: d.a.q0.j1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1502b implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59613a;

        public C1502b(b bVar) {
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
            this.f59613a = bVar;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59613a.c();
                if (this.f59613a.f59610f != null) {
                    this.f59613a.f59610f.a();
                }
                this.f59613a.d();
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
        this.f59611g = new C1502b(this);
        this.f59606b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f59606b);
        this.f59608d = hVar;
        hVar.m(this.f59611g);
        ArrayList arrayList = new ArrayList();
        this.f59607c = arrayList;
        arrayList.add(this.f59608d);
        this.f59606b.m(new a(this));
        this.f59606b.k(this.f59607c);
        this.f59605a = new j(fVar, this.f59606b);
        e();
        f();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59609e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f59609e.f59601a);
        httpMessage.addParam("thread_id", this.f59609e.f59602b);
        httpMessage.addParam("post_id", this.f59609e.f59603c);
        httpMessage.addParam("ori_ugc_nid", this.f59609e.f59604d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (jVar = this.f59605a) != null && jVar.isShowing()) {
            this.f59605a.dismiss();
        }
    }

    public void e() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (lVar = this.f59606b) == null) {
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

    public void g(d.a.q0.j1.b.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f59609e = aVar;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f59610f = cVar;
        }
    }

    public void i() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (jVar = this.f59605a) == null) {
            return;
        }
        jVar.show();
    }
}
