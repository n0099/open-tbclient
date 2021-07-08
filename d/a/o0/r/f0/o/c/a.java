package d.a.o0.r.f0.o.c;

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
import d.a.p0.h3.w;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f52370e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f52371f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.r.f0.o.b f52372g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.r.f0.o.c.b f52373h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f52374i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public e l;

    /* renamed from: d.a.o0.r.f0.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1203a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f52375a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1203a(a aVar, int i2) {
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
            this.f52375a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.p0.h3.q0.e)) {
                d.a.p0.h3.q0.e eVar = (d.a.p0.h3.q0.e) customResponsedMessage.getData();
                String l = Long.toString(eVar.f58204a);
                if (this.f52375a.f52373h != null && l.equals(this.f52375a.f52373h.h()) && eVar.f58205b) {
                    this.f52375a.f52373h.setIsLike(true);
                    this.f52375a.f52373h.i(true);
                    this.f52375a.f52372g.c(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f52376a;

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
            this.f52376a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.p0.h3.q0.e)) {
                d.a.p0.h3.q0.e eVar = (d.a.p0.h3.q0.e) customResponsedMessage.getData();
                String l = Long.toString(eVar.f58204a);
                if (this.f52376a.f52373h != null && l.equals(this.f52376a.f52373h.h()) && eVar.f58205b) {
                    this.f52376a.f52373h.setIsLike(false);
                    this.f52376a.f52373h.i(false);
                    this.f52376a.f52372g.c(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f52377a;

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
            this.f52377a = aVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof w) && ((w) obj).d() != 0) {
                if (AntiHelper.m(this.f52377a.f52371f.getErrorCode(), this.f52377a.f52371f.getErrorString())) {
                    AntiHelper.u(this.f52377a.f52370e.getPageActivity(), this.f52377a.f52371f.getErrorString());
                } else {
                    this.f52377a.f52370e.showToast(this.f52377a.f52371f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, d.a.o0.r.f0.o.b bVar) {
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
        this.j = new C1203a(this, 2001437);
        this.k = new b(this, 2001438);
        this.l = new c(this);
        this.f52370e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f52371f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f52372g = bVar;
        bVar.b(this);
        tbPageContext.registerListener(this.j);
        tbPageContext.registerListener(this.k);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f52374i = onClickListener;
        }
    }

    public void f(d.a.o0.r.f0.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f52373h = bVar;
        this.f52372g.c(bVar.getIsLike());
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
            d.a.o0.r.f0.o.b bVar = this.f52372g;
            if (bVar != null) {
                bVar.a(view);
            }
            if (!j.z()) {
                this.f52370e.showToast(R.string.neterror);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.f52370e.getPageActivity())) {
                d.a.o0.r.f0.o.c.b bVar2 = this.f52373h;
                if (bVar2 == null) {
                    return;
                }
                this.f52371f.L(bVar2.g(), this.f52373h.h());
            }
            View.OnClickListener onClickListener = this.f52374i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
