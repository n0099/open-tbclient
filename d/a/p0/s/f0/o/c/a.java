package d.a.p0.s.f0.o.c;

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
import d.a.d.a.e;
import d.a.d.e.p.j;
import d.a.q0.h3.q0.k;
import d.a.q0.h3.w;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f53026e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f53027f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.s.f0.o.b f53028g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.s.f0.o.c.b f53029h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f53030i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public e l;

    /* renamed from: d.a.p0.s.f0.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1213a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53031a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1213a(a aVar, int i2) {
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
            this.f53031a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.f58818a);
                if (this.f53031a.f53029h != null && l.equals(this.f53031a.f53029h.h()) && kVar.f58819b) {
                    this.f53031a.f53029h.setIsLike(true);
                    this.f53031a.f53029h.i(true);
                    this.f53031a.f53028g.c(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53032a;

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
            this.f53032a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.f58818a);
                if (this.f53032a.f53029h != null && l.equals(this.f53032a.f53029h.h()) && kVar.f58819b) {
                    this.f53032a.f53029h.setIsLike(false);
                    this.f53032a.f53029h.i(false);
                    this.f53032a.f53028g.c(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f53033a;

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
            this.f53033a = aVar;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof w) && ((w) obj).d() != 0) {
                if (AntiHelper.m(this.f53033a.f53027f.getErrorCode(), this.f53033a.f53027f.getErrorString())) {
                    AntiHelper.u(this.f53033a.f53026e.getPageActivity(), this.f53033a.f53027f.getErrorString());
                } else {
                    this.f53033a.f53026e.showToast(this.f53033a.f53027f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, d.a.p0.s.f0.o.b bVar) {
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
        this.j = new C1213a(this, 2001437);
        this.k = new b(this, 2001438);
        this.l = new c(this);
        this.f53026e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f53027f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f53028g = bVar;
        bVar.b(this);
        tbPageContext.registerListener(this.j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f53030i = onClickListener;
        }
    }

    public void f(d.a.p0.s.f0.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f53029h = bVar;
        this.f53028g.c(bVar.getIsLike());
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
            d.a.p0.s.f0.o.b bVar = this.f53028g;
            if (bVar != null) {
                bVar.a(view);
            }
            if (!j.z()) {
                this.f53026e.showToast(R.string.neterror);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.f53026e.getPageActivity())) {
                d.a.p0.s.f0.o.c.b bVar2 = this.f53029h;
                if (bVar2 == null) {
                    return;
                }
                this.f53027f.L(bVar2.g(), this.f53029h.h());
            }
            View.OnClickListener onClickListener = this.f53030i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
