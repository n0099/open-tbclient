package d.a.r0.r.f0.n.c;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.j;
import d.a.s0.h3.w;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f55664e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f55665f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.r.f0.n.b f55666g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.r0.r.f0.n.c.b f55667h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f55668i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public e l;

    /* renamed from: d.a.r0.r.f0.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1254a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f55669a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1254a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f55669a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.s0.h3.q0.e)) {
                d.a.s0.h3.q0.e eVar = (d.a.s0.h3.q0.e) customResponsedMessage.getData();
                String l = Long.toString(eVar.f61442a);
                if (this.f55669a.f55667h != null && l.equals(this.f55669a.f55667h.i()) && eVar.f61443b) {
                    this.f55669a.f55667h.setIsLike(true);
                    this.f55669a.f55667h.j(true);
                    this.f55669a.f55666g.c(true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f55670a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f55670a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.s0.h3.q0.e)) {
                d.a.s0.h3.q0.e eVar = (d.a.s0.h3.q0.e) customResponsedMessage.getData();
                String l = Long.toString(eVar.f61442a);
                if (this.f55670a.f55667h != null && l.equals(this.f55670a.f55667h.i()) && eVar.f61443b) {
                    this.f55670a.f55667h.setIsLike(false);
                    this.f55670a.f55667h.j(false);
                    this.f55670a.f55666g.c(false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f55671a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55671a = aVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof w) && ((w) obj).d() != 0) {
                if (AntiHelper.m(this.f55671a.f55665f.getErrorCode(), this.f55671a.f55665f.getErrorString())) {
                    AntiHelper.u(this.f55671a.f55664e.getPageActivity(), this.f55671a.f55665f.getErrorString());
                } else {
                    this.f55671a.f55664e.showToast(this.f55671a.f55665f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, d.a.r0.r.f0.n.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new C1254a(this, 2001437);
        this.k = new b(this, 2001438);
        this.l = new c(this);
        this.f55664e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f55665f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f55666g = bVar;
        bVar.b(this);
        tbPageContext.registerListener(this.j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f55668i = onClickListener;
        }
    }

    public void f(d.a.r0.r.f0.n.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f55667h = bVar;
        this.f55666g.c(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.j.setTag(bdUniqueId);
            this.k.setTag(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            d.a.r0.r.f0.n.b bVar = this.f55666g;
            if (bVar != null) {
                bVar.a(view);
            }
            if (!j.z()) {
                this.f55664e.showToast(R.string.neterror);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.f55664e.getPageActivity())) {
                d.a.r0.r.f0.n.c.b bVar2 = this.f55667h;
                if (bVar2 == null) {
                    return;
                }
                this.f55665f.L(bVar2.h(), this.f55667h.i());
            }
            View.OnClickListener onClickListener = this.f55668i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
