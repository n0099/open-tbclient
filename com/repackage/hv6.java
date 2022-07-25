package com.repackage;

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
import com.baidu.tbadk.core.BaseFragment;
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
import com.repackage.gu4;
import com.repackage.ny;
import com.repackage.v36;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class hv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public BdUniqueId B;
    public v36 C;
    public NEGFeedBackView.b D;
    public iu6 E;
    public gu4.h F;
    public gu4.f G;
    public CustomMessageListener H;
    public View.OnTouchListener I;
    public v36.b J;
    public CustomMessageListener K;
    public RecyclerView.RecyclerListener L;
    public RecyclerView.OnScrollListener M;
    public BaseFragment a;
    public TbPageContext b;
    public View c;
    public BdTypeRecyclerView d;
    public BigdaySwipeRefreshLayout e;
    public ky6 f;
    public PbListView g;
    public k55 h;
    public ImageView i;
    public TextView j;
    public tu6 k;
    public View l;
    public FrameLayout m;
    public l55 n;
    public GameVideoTitleBar o;
    public AlphaAnimation p;
    public AlphaAnimation q;
    public boolean r;
    public RotateAnimation s;
    public RotateAnimation t;
    public boolean u;
    public boolean v;
    public i68 w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        public a(hv6 hv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.i == null) {
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.i, R.drawable.obfuscated_res_0x7f080936, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.a.u = false;
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

    /* loaded from: classes6.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        public b(hv6 hv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.i == null) {
                return;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.i, R.drawable.obfuscated_res_0x7f080936, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.a.u = false;
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

    /* loaded from: classes6.dex */
    public class c implements gu4.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        public c(hv6 hv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        @Override // com.repackage.gu4.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.o0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements gu4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        public d(hv6 hv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        @Override // com.repackage.gu4.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                this.a.Z(true);
                if (this.a.w == null || this.a.z || !this.a.A) {
                    return;
                }
                this.a.w.n(this.a.x, this.a.y, this.a.v, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.k.c();
                    this.a.a.I();
                    if (this.a.a.z || !this.a.a.A) {
                        return;
                    }
                    this.a.a.w.n(this.a.a.x, this.a.a.y, this.a.a.v, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(hv6 hv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                qg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        public f(hv6 hv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.C != null) {
                    this.a.C.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements v36.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        public g(hv6 hv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        @Override // com.repackage.v36.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.v = false;
            }
        }

        @Override // com.repackage.v36.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.v = true;
            }
        }

        @Override // com.repackage.v36.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.v36.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(hv6 hv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder w;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (w = this.a.w()) == null || w.b() == null) {
                    return;
                }
                w.b().o(new ny.a(3));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        public i(hv6 hv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.w != null) {
                this.a.w.k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).b().stopPlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        public j(hv6 hv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.x = i;
                this.a.y = (i + i2) - 1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (i == 1) {
                    this.a.m0();
                    return;
                }
                hv6 hv6Var = this.a;
                if (hv6Var.O(hv6Var.d)) {
                    this.a.v();
                }
                if (i == 0 && this.a.w != null && this.a.A) {
                    this.a.w.m(this.a.x, this.a.y, this.a.v, 1);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i, i2) == null) {
                int i4 = 0;
                if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                    i3 = 0;
                } else {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i4 = bdRecyclerView.getFirstVisiblePosition();
                    i3 = bdRecyclerView.getLastVisiblePosition();
                }
                a(i4, (i3 - i4) + 1);
                if (this.a.E != null) {
                    this.a.E.j();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv6 a;

        public k(hv6 hv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv6Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.l.setVisibility(8);
                this.a.r = false;
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

    public hv6(BaseFragment baseFragment, TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tbPageContext, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.v = false;
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.A = true;
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e(this, 2921420);
        this.I = new f(this);
        this.J = new g(this);
        this.K = new h(this, 2921381);
        this.L = new i(this);
        this.M = new j(this);
        this.a = baseFragment;
        this.b = tbPageContext;
        this.B = bdUniqueId;
        this.D = bVar;
        E();
    }

    public final List<Integer> A(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                nn B = bdTypeRecyclerView.B(i4);
                if (B instanceof ny5) {
                    ny5 ny5Var = (ny5) B;
                    if (ny5Var.getThreadData() != null && ny5Var.getThreadData().getTid().equals(str)) {
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

    public void B() {
        k55 k55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (k55Var = this.h) == null) {
            return;
        }
        k55Var.dettachView(this.c);
    }

    public void C() {
        l55 l55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (l55Var = this.n) == null) {
            return;
        }
        l55Var.dettachView(this.m);
        this.n = null;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.addOnScrollListener(this.M);
            this.d.setOnTouchListener(this.I);
            this.d.setRecyclerListener(this.L);
            this.C.d(this.J);
            this.f.g(this.F);
            this.f.m(this.G);
            this.f.b0(this.b.getUniqueId());
            Q();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0374, (ViewGroup) null);
            this.c = inflate;
            inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.o = (GameVideoTitleBar) this.c.findViewById(R.id.obfuscated_res_0x7f090c2f);
            this.m = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090c2a);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f090c2c);
            this.d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.b.getPageActivity()));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.d.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.E = new iu6(this.m, this.d);
            if (this.a.getArguments() != null) {
                this.E.p(this.a.getArguments().getString("tab_name"));
            }
            this.E.o(this.b);
            this.C = new v36();
            i68 i68Var = new i68(this.b, this.d);
            this.w = i68Var;
            i68Var.v(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.w.u(this.B);
            this.e = (BigdaySwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090c2d);
            ky6 ky6Var = new ky6(this.b);
            this.f = ky6Var;
            this.e.setProgressView(ky6Var);
            int i2 = (int) (this.b.getResources().getDisplayMetrics().density * 86.0f);
            this.e.setCustomDistances(i2, i2, i2 * 2);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.g = pbListView;
            pbListView.a();
            this.g.p(R.color.transparent);
            this.g.t(pi.f(this.b.getPageActivity(), R.dimen.tbds178));
            this.g.x();
            this.g.G(R.dimen.tbfontsize36);
            this.g.E(SkinManager.getColor(R.color.CAM_X0109));
            this.g.A(R.color.CAM_X0110);
            this.g.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            tu6 tu6Var = new tu6(this.b, this.d);
            this.k = tu6Var;
            tu6Var.h(this.D);
            this.k.i(this.B);
            this.l = this.c.findViewById(R.id.obfuscated_res_0x7f090c29);
            this.i = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090c2e);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090c2b);
            this.j = textView;
            textView.setText(yt4.k().q("key_game_video_tab_has_choosed_sub_class_name", ""));
            s();
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            k55 k55Var = this.h;
            if (k55Var == null) {
                return false;
            }
            return k55Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public void H() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
        v();
    }

    public void I() {
        iu6 iu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (iu6Var = this.E) == null) {
            return;
        }
        iu6Var.f();
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.z = z;
            i68 i68Var = this.w;
            if (i68Var == null) {
                return;
            }
            i68Var.r(!z);
            ThreadCardViewHolder w = w();
            boolean z2 = false;
            if (w != null && w.b() != null) {
                z2 = w.b().o(new ny.a(8, Boolean.valueOf(z)));
            }
            if (z2) {
                return;
            }
            if (z) {
                this.w.x();
            } else if (this.A) {
                this.w.n(this.x, this.y, this.v, true);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            k55 k55Var = this.h;
            if (k55Var != null) {
                k55Var.n();
            }
            AlphaAnimation alphaAnimation = this.p;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = this.q;
            if (alphaAnimation2 != null) {
                alphaAnimation2.cancel();
            }
            p0(null);
            ky6 ky6Var = this.f;
            if (ky6Var != null) {
                ky6Var.Z();
            }
            tu6 tu6Var = this.k;
            if (tu6Var != null) {
                tu6Var.d();
            }
            RotateAnimation rotateAnimation = this.s;
            if (rotateAnimation != null) {
                rotateAnimation.cancel();
            }
            RotateAnimation rotateAnimation2 = this.t;
            if (rotateAnimation2 != null) {
                rotateAnimation2.cancel();
            }
            i68 i68Var = this.w;
            if (i68Var != null) {
                i68Var.h();
            }
            u();
            MessageManager.getInstance().unRegisterListener(this.K);
            MessageManager.getInstance().unRegisterListener(this.H);
        }
    }

    public void L() {
        tu6 tu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tu6Var = this.k) == null) {
            return;
        }
        tu6Var.e();
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            J(true);
        }
    }

    public void N() {
        i68 i68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (i68Var = this.w) != null && this.A) {
            i68Var.n(this.x, this.y, this.v, true);
        }
    }

    public final boolean O(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            tu6 tu6Var = this.k;
            if (tu6Var != null) {
                tu6Var.c();
            }
            I();
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.H.setTag(this.B);
            MessageManager.getInstance().registerListener(this.H);
            this.K.setTag(this.B);
            MessageManager.getInstance().registerListener(this.K);
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            List<Integer> A = A(str, this.d);
            int intValue = A.get(0).intValue();
            int intValue2 = A.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.d.E(intValue, intValue2);
        }
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.u = z;
        }
    }

    public void T(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (imageView = this.i) == null) {
            return;
        }
        imageView.setVisibility(0);
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f080936, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0201);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f080936, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundResource(this.o, R.color.CAM_X0207);
    }

    public void U(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            tu6 tu6Var = this.k;
            if (tu6Var != null) {
                tu6Var.f(list);
            }
            N();
        }
    }

    public void V(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || StringUtils.isNull(str) || (textView = this.j) == null) {
            return;
        }
        textView.setVisibility(0);
        this.j.setText(str);
    }

    public void W(int i2) {
        tu6 tu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (tu6Var = this.k) == null) {
            return;
        }
        tu6Var.g(i2);
    }

    public void X(gu4.g gVar) {
        ky6 ky6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, gVar) == null) || (ky6Var = this.f) == null) {
            return;
        }
        ky6Var.f(gVar);
    }

    public void Y(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) || (imageView = this.i) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.A = z;
        }
    }

    public void a0(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, pVar) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.z = z;
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            J(false);
        }
    }

    public void d0(View.OnClickListener onClickListener) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) || (pbListView = this.g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.d.setNextPage(this.g);
        }
        this.g.t(pi.f(this.b.getPageActivity(), R.dimen.tbds178));
        this.g.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0798));
        this.g.B(onClickListener);
        this.g.f();
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.t == null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
                this.t = rotateAnimation;
                rotateAnimation.setDuration(300L);
                this.t.setInterpolator(new AccelerateInterpolator());
                this.t.setFillAfter(true);
                this.t.setAnimationListener(new b(this));
            }
            this.i.startAnimation(this.t);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.s == null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
                this.s = rotateAnimation;
                rotateAnimation.setDuration(300L);
                this.s.setInterpolator(new AccelerateInterpolator());
                this.s.setFillAfter(true);
                this.s.setAnimationListener(new a(this));
            }
            this.i.startAnimation(this.s);
        }
    }

    public void g0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public void h0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (pbListView = this.g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.d.setNextPage(this.g);
        }
        this.g.t(pi.f(this.b.getPageActivity(), R.dimen.tbds178));
        this.g.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0a18));
        this.g.B(null);
        this.g.Q();
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || G()) {
            return;
        }
        if (this.h == null) {
            k55 k55Var = new k55(this.b.getPageActivity());
            this.h = k55Var;
            k55Var.i();
            this.h.s((((this.c.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - pi.f(this.b.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
            this.h.onChangeSkinType();
        }
        this.h.attachView(this.c, false);
    }

    public void j0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onClickListener) == null) {
            if (this.n == null) {
                this.n = new l55(this.b.getPageActivity(), onClickListener);
            }
            this.n.p();
            this.n.m(null);
            this.n.n(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0f84));
            this.n.i(R.drawable.new_pic_emotion_08);
            this.n.l(0);
            this.n.attachView(this.m, false);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.n == null) {
                this.n = new l55(this.b.getPageActivity(), null);
            }
            this.n.e();
            this.n.i(R.drawable.new_pic_emotion_03);
            this.n.o(this.b.getString(R.string.obfuscated_res_0x7f0f0c30));
            this.n.attachView(this.m, false);
        }
    }

    public void l0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (pbListView = this.g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.d.setNextPage(this.g);
        }
        this.g.t(pi.f(this.b.getPageActivity(), R.dimen.tbds178));
        this.g.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0799));
        this.g.B(null);
        this.g.f();
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || this.r) {
            return;
        }
        this.r = true;
        this.l.setVisibility(0);
        if (this.p == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.p = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.p.setDuration(300L);
        }
        this.l.startAnimation(this.p);
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.e.setRefreshing(true);
        }
    }

    public void o0() {
        i68 i68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (i68Var = this.w) == null) {
            return;
        }
        i68Var.x();
    }

    public void p0(gu4.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, iVar) == null) {
            this.e.z(iVar);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.i != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f080936, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            }
            k55 k55Var = this.h;
            if (k55Var != null) {
                k55Var.r(TbadkCoreApplication.getInst().getSkinType());
                this.h.onChangeSkinType();
            }
            l55 l55Var = this.n;
            if (l55Var != null) {
                l55Var.onChangeSkinType();
            }
            TextView textView = this.j;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            ky6 ky6Var = this.f;
            if (ky6Var != null) {
                ky6Var.H(skinType);
            }
            tu6 tu6Var = this.k;
            if (tu6Var != null) {
                tu6Var.c();
            }
            I();
            iu6 iu6Var = this.E;
            if (iu6Var != null) {
                iu6Var.n();
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            U(new LinkedList());
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.M);
                this.d.setOnTouchListener(null);
                this.d.setRecyclerListener(null);
            }
            v36 v36Var = this.C;
            if (v36Var != null) {
                v36Var.d(null);
            }
            ky6 ky6Var = this.f;
            if (ky6Var != null) {
                ky6Var.g(null);
                this.f.m(null);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && this.r) {
            if (this.q == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.q = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.q.setDuration(300L);
                this.q.setAnimationListener(new k(this));
            }
            this.l.startAnimation(this.q);
        }
    }

    public ThreadCardViewHolder w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            i68 i68Var = this.w;
            if (i68Var == null || i68Var.j() == null || !(this.w.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.w.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public List<nn> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            tu6 tu6Var = this.k;
            if (tu6Var != null) {
                return tu6Var.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.c.findViewById(R.id.obfuscated_res_0x7f090c2f) : (View) invokeV.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.c : (View) invokeV.objValue;
    }
}
