package d.a.p0.e1.e.f;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoTitleBar;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.j.v0.a;
import d.a.o0.r.f0.f;
import d.a.p0.i0.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId A;
    public d.a.p0.i0.a B;
    public NEGFeedBackView.b C;
    public f.h D;
    public f.InterfaceC1202f E;
    public CustomMessageListener F;
    public View.OnTouchListener G;
    public a.b H;
    public CustomMessageListener I;
    public RecyclerView.RecyclerListener J;
    public RecyclerView.OnScrollListener K;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55334a;

    /* renamed from: b  reason: collision with root package name */
    public View f55335b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f55336c;

    /* renamed from: d  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f55337d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.e1.h.i.a f55338e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f55339f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.d0.g f55340g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55341h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55342i;
    public d.a.p0.e1.e.a.a j;
    public View k;
    public FrameLayout l;
    public d.a.o0.d0.h m;
    public GameVideoTitleBar n;
    public AlphaAnimation o;
    public AlphaAnimation p;
    public boolean q;
    public RotateAnimation r;
    public RotateAnimation s;
    public boolean t;
    public boolean u;
    public d.a.p0.n2.i v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55343a;

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
            this.f55343a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f55343a.f55341h == null) {
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55343a.f55341h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.f55343a.t = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* renamed from: d.a.p0.e1.e.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class animation.Animation$AnimationListenerC1337b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55344a;

        public animation.Animation$AnimationListenerC1337b(b bVar) {
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
            this.f55344a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f55344a.f55341h == null) {
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55344a.f55341h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.f55344a.t = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements f.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55345a;

        public c(b bVar) {
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
            this.f55345a = bVar;
        }

        @Override // d.a.o0.r.f0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f55345a.m0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements f.InterfaceC1202f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55346a;

        public d(b bVar) {
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
            this.f55346a = bVar;
        }

        @Override // d.a.o0.r.f0.f.InterfaceC1202f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.f55346a.X(true);
                if (this.f55346a.v == null || this.f55346a.y || !this.f55346a.z) {
                    return;
                }
                this.f55346a.v.n(this.f55346a.w, this.f55346a.x, this.f55346a.u, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55347a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f55348e;

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
                        return;
                    }
                }
                this.f55348e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f55348e.f55347a.j.c();
                    if (this.f55348e.f55347a.y || !this.f55348e.f55347a.z) {
                        return;
                    }
                    this.f55348e.f55347a.v.n(this.f55348e.f55347a.w, this.f55348e.f55347a.x, this.f55348e.f55347a.u, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.f55347a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                d.a.c.e.m.e.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f55349e;

        public f(b bVar) {
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
            this.f55349e = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f55349e.B != null) {
                    this.f55349e.B.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55350a;

        public g(b bVar) {
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
            this.f55350a = bVar;
        }

        @Override // d.a.p0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f55350a.u = false;
            }
        }

        @Override // d.a.p0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f55350a.u = true;
            }
        }

        @Override // d.a.p0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // d.a.p0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55351a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.f55351a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder v;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (v = this.f55351a.v()) == null || v.b() == null) {
                    return;
                }
                v.b().o(new a.C0611a(3));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55352a;

        public i(b bVar) {
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
            this.f55352a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (this.f55352a.v != null) {
                this.f55352a.v.k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).b().stopPlay();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55353a;

        public j(b bVar) {
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
            this.f55353a = bVar;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f55353a.w = i2;
                this.f55353a.x = (i2 + i3) - 1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) {
                if (i2 == 1) {
                    this.f55353a.k0();
                    return;
                }
                b bVar = this.f55353a;
                if (bVar.M(bVar.f55336c)) {
                    this.f55353a.u();
                }
                if (i2 == 0 && this.f55353a.v != null && this.f55353a.z) {
                    this.f55353a.v.m(this.f55353a.w, this.f55353a.x, this.f55353a.u, 1);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i2, i3) == null) {
                int i5 = 0;
                if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                    i4 = 0;
                } else {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i5 = bdRecyclerView.getFirstVisiblePosition();
                    i4 = bdRecyclerView.getLastVisiblePosition();
                }
                a(i5, (i4 - i5) + 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f55354a;

        public k(b bVar) {
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
            this.f55354a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f55354a.k.setVisibility(8);
                this.f55354a.q = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = false;
        this.u = false;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.z = true;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new e(this, 2921420);
        this.G = new f(this);
        this.H = new g(this);
        this.I = new h(this, 2921381);
        this.J = new i(this);
        this.K = new j(this);
        this.f55334a = tbPageContext;
        this.A = bdUniqueId;
        this.C = bVar;
        D();
    }

    public void A() {
        d.a.o0.d0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f55340g) == null) {
            return;
        }
        gVar.dettachView(this.f55335b);
    }

    public void B() {
        d.a.o0.d0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.m) == null) {
            return;
        }
        hVar.dettachView(this.l);
        this.m = null;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f55336c.addOnScrollListener(this.K);
            this.f55336c.setOnTouchListener(this.G);
            this.f55336c.setRecyclerListener(this.J);
            this.B.d(this.H);
            this.f55338e.b(this.D);
            this.f55338e.l(this.E);
            this.f55338e.a0(this.f55334a.getUniqueId());
            O();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f55334a.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
            this.f55335b = inflate;
            inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.n = (GameVideoTitleBar) this.f55335b.findViewById(R.id.game_video_title_bar);
            this.l = (FrameLayout) this.f55335b.findViewById(R.id.game_video_framelayout);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f55335b.findViewById(R.id.game_video_recycle_view);
            this.f55336c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f55334a.getPageActivity()));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f55336c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.B = new d.a.p0.i0.a();
            d.a.p0.n2.i iVar = new d.a.p0.n2.i(this.f55334a, this.f55336c);
            this.v = iVar;
            iVar.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.v.t(this.A);
            this.f55337d = (BigdaySwipeRefreshLayout) this.f55335b.findViewById(R.id.game_video_refresh_layout);
            d.a.p0.e1.h.i.a aVar = new d.a.p0.e1.h.i.a(this.f55334a);
            this.f55338e = aVar;
            this.f55337d.setProgressView(aVar);
            int i2 = (int) (this.f55334a.getResources().getDisplayMetrics().density * 86.0f);
            this.f55337d.setCustomDistances(i2, i2, i2 * 2);
            PbListView pbListView = new PbListView(this.f55334a.getPageActivity());
            this.f55339f = pbListView;
            pbListView.a();
            this.f55339f.o(R.color.transparent);
            this.f55339f.r(l.g(this.f55334a.getPageActivity(), R.dimen.tbds178));
            this.f55339f.v();
            this.f55339f.E(R.dimen.tbfontsize36);
            this.f55339f.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f55339f.y(R.color.CAM_X0110);
            this.f55339f.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            d.a.p0.e1.e.a.a aVar2 = new d.a.p0.e1.e.a.a(this.f55334a, this.f55336c);
            this.j = aVar2;
            aVar2.h(this.C);
            this.j.i(this.A);
            this.k = this.f55335b.findViewById(R.id.game_video_divider_shadow);
            this.f55341h = (ImageView) this.f55335b.findViewById(R.id.game_video_select_icon);
            TextView textView = (TextView) this.f55335b.findViewById(R.id.game_video_game_title);
            this.f55342i = textView;
            textView.setText(d.a.o0.r.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""));
            r();
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.o0.d0.g gVar = this.f55340g;
            if (gVar == null) {
                return false;
            }
            return gVar.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public void G() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdTypeRecyclerView = this.f55336c) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
        u();
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.y = z;
            d.a.p0.n2.i iVar = this.v;
            if (iVar == null) {
                return;
            }
            iVar.q(!z);
            ThreadCardViewHolder v = v();
            boolean z2 = false;
            if (v != null && v.b() != null) {
                z2 = v.b().o(new a.C0611a(8, Boolean.valueOf(z)));
            }
            if (z2) {
                return;
            }
            if (z) {
                this.v.w();
            } else if (this.z) {
                this.v.n(this.w, this.x, this.u, true);
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.o0.d0.g gVar = this.f55340g;
            if (gVar != null) {
                gVar.m();
            }
            AlphaAnimation alphaAnimation = this.o;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = this.p;
            if (alphaAnimation2 != null) {
                alphaAnimation2.cancel();
            }
            n0(null);
            d.a.p0.e1.h.i.a aVar = this.f55338e;
            if (aVar != null) {
                aVar.Y();
            }
            d.a.p0.e1.e.a.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.d();
            }
            RotateAnimation rotateAnimation = this.r;
            if (rotateAnimation != null) {
                rotateAnimation.cancel();
            }
            RotateAnimation rotateAnimation2 = this.s;
            if (rotateAnimation2 != null) {
                rotateAnimation2.cancel();
            }
            d.a.p0.n2.i iVar = this.v;
            if (iVar != null) {
                iVar.h();
            }
            t();
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.F);
        }
    }

    public void J() {
        d.a.p0.e1.e.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.e();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            H(true);
        }
    }

    public void L() {
        d.a.p0.n2.i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (iVar = this.v) != null && this.z) {
            iVar.n(this.w, this.x, this.u, true);
        }
    }

    public final boolean M(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void N() {
        d.a.p0.e1.e.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.c();
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.F.setTag(this.A);
            MessageManager.getInstance().registerListener(this.F);
            this.I.setTag(this.A);
            MessageManager.getInstance().registerListener(this.I);
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            List<Integer> z = z(str, this.f55336c);
            int intValue = z.get(0).intValue();
            int intValue2 = z.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.f55336c.E(intValue, intValue2);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.t = z;
        }
    }

    public void R(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (imageView = this.f55341h) == null) {
            return;
        }
        imageView.setVisibility(0);
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55341h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundResource(this.n, R.color.CAM_X0201);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55341h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundResource(this.n, R.color.CAM_X0207);
    }

    public void S(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            d.a.p0.e1.e.a.a aVar = this.j;
            if (aVar != null) {
                aVar.f(list);
            }
            L();
        }
    }

    public void T(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || StringUtils.isNull(str) || (textView = this.f55342i) == null) {
            return;
        }
        textView.setVisibility(0);
        this.f55342i.setText(str);
    }

    public void U(int i2) {
        d.a.p0.e1.e.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.g(i2);
    }

    public void V(f.g gVar) {
        d.a.p0.e1.h.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, gVar) == null) || (aVar = this.f55338e) == null) {
            return;
        }
        aVar.a(gVar);
    }

    public void W(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) || (imageView = this.f55341h) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.z = z;
        }
    }

    public void Y(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, pVar) == null) || (bdTypeRecyclerView = this.f55336c) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.y = z;
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            H(false);
        }
    }

    public void b0(View.OnClickListener onClickListener) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) || (pbListView = this.f55339f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f55336c.setNextPage(this.f55339f);
        }
        this.f55339f.r(l.g(this.f55334a.getPageActivity(), R.dimen.tbds178));
        this.f55339f.A(this.f55334a.getResources().getString(R.string.game_video_click_load));
        this.f55339f.z(onClickListener);
        this.f55339f.f();
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.s == null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
                this.s = rotateAnimation;
                rotateAnimation.setDuration(300L);
                this.s.setInterpolator(new AccelerateInterpolator());
                this.s.setFillAfter(true);
                this.s.setAnimationListener(new animation.Animation$AnimationListenerC1337b(this));
            }
            this.f55341h.startAnimation(this.s);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.r == null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
                this.r = rotateAnimation;
                rotateAnimation.setDuration(300L);
                this.r.setInterpolator(new AccelerateInterpolator());
                this.r.setFillAfter(true);
                this.r.setAnimationListener(new a(this));
            }
            this.f55341h.startAnimation(this.r);
        }
    }

    public void e0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (textView = this.f55342i) == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public void f0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (pbListView = this.f55339f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f55336c.setNextPage(this.f55339f);
        }
        this.f55339f.r(l.g(this.f55334a.getPageActivity(), R.dimen.tbds178));
        this.f55339f.A(this.f55334a.getResources().getString(R.string.loading));
        this.f55339f.z(null);
        this.f55339f.O();
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || F()) {
            return;
        }
        if (this.f55340g == null) {
            d.a.o0.d0.g gVar = new d.a.o0.d0.g(this.f55334a.getPageActivity());
            this.f55340g = gVar;
            gVar.h();
            this.f55340g.q((((this.f55335b.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(this.f55334a.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
            this.f55340g.onChangeSkinType();
        }
        this.f55340g.attachView(this.f55335b, false);
    }

    public void h0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            if (this.m == null) {
                this.m = new d.a.o0.d0.h(this.f55334a.getPageActivity(), onClickListener);
            }
            this.m.o();
            this.m.l(null);
            this.m.m(this.f55334a.getResources().getString(R.string.refresh_view_title_text));
            this.m.i(R.drawable.new_pic_emotion_08);
            this.m.k(0);
            this.m.attachView(this.l, false);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.m == null) {
                this.m = new d.a.o0.d0.h(this.f55334a.getPageActivity(), null);
            }
            this.m.e();
            this.m.i(R.drawable.new_pic_emotion_03);
            this.m.n(this.f55334a.getString(R.string.no_data_common_txt));
            this.m.attachView(this.l, false);
        }
    }

    public void j0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (pbListView = this.f55339f) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f55336c.setNextPage(this.f55339f);
        }
        this.f55339f.r(l.g(this.f55334a.getPageActivity(), R.dimen.tbds178));
        this.f55339f.A(this.f55334a.getResources().getString(R.string.game_video_no_more));
        this.f55339f.z(null);
        this.f55339f.f();
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || this.q) {
            return;
        }
        this.q = true;
        this.k.setVisibility(0);
        if (this.o == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.o = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.o.setDuration(300L);
        }
        this.k.startAnimation(this.o);
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.f55337d.setRefreshing(true);
        }
    }

    public void m0() {
        d.a.p0.n2.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (iVar = this.v) == null) {
            return;
        }
        iVar.w();
    }

    public void n0(f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, iVar) == null) {
            this.f55337d.z(iVar);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.f55341h != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55341h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            }
            d.a.o0.d0.g gVar = this.f55340g;
            if (gVar != null) {
                gVar.p(TbadkCoreApplication.getInst().getSkinType());
                this.f55340g.onChangeSkinType();
            }
            d.a.o0.d0.h hVar = this.m;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            TextView textView = this.f55342i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            d.a.p0.e1.h.i.a aVar = this.f55338e;
            if (aVar != null) {
                aVar.I(skinType);
            }
            d.a.p0.e1.e.a.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.c();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            S(new LinkedList());
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f55336c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.K);
                this.f55336c.setOnTouchListener(null);
                this.f55336c.setRecyclerListener(null);
            }
            d.a.p0.i0.a aVar = this.B;
            if (aVar != null) {
                aVar.d(null);
            }
            d.a.p0.e1.h.i.a aVar2 = this.f55338e;
            if (aVar2 != null) {
                aVar2.b(null);
                this.f55338e.l(null);
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.q) {
            if (this.p == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.p = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.p.setDuration(300L);
                this.p.setAnimationListener(new k(this));
            }
            this.k.startAnimation(this.p);
        }
    }

    public ThreadCardViewHolder v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            d.a.p0.n2.i iVar = this.v;
            if (iVar == null || iVar.j() == null || !(this.v.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.v.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public List<n> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            d.a.p0.e1.e.a.a aVar = this.j;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f55335b.findViewById(R.id.game_video_title_bar) : (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f55335b : (View) invokeV.objValue;
    }

    public final List<Integer> z(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048624, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                n B = bdTypeRecyclerView.B(i4);
                if (B instanceof d.a.p0.a0.e0.b) {
                    d.a.p0.a0.e0.b bVar = (d.a.p0.a0.e0.b) B;
                    if (bVar.getThreadData() != null && bVar.getThreadData().n1().equals(str)) {
                        if (!z) {
                            i2 = i4;
                        }
                        z = true;
                        i3 = i4;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
