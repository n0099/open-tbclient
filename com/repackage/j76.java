package com.repackage;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k56;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class j76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public int b;
    public View c;
    public View d;
    public View e;
    public RecentlyVisitedForumModel f;
    public Vibrator g;
    public TextView h;
    public ImageView i;
    public TextView j;
    public RecyclerView k;
    public View l;
    public RecentlyVisitedForumListAdapter m;
    public boolean n;
    public boolean o;
    public ViewEventCenter p;
    public p56 q;
    public ln r;
    public z46 s;
    public j t;
    public CustomMessageListener u;
    public CustomMessageListener v;
    public CustomMessageListener w;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j76 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j76 j76Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var, Integer.valueOf(i)};
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
            this.a = j76Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.r == null) {
                        this.a.r = new ln(new jn());
                    }
                    this.a.r.q(this.a.k, 1);
                } else if (this.a.r != null) {
                    this.a.r.w();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j76 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j76 j76Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var, Integer.valueOf(i)};
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
            this.a = j76Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j76 a;

        public c(j76 j76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.B();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j76 a;

        public d(j76 j76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements RecentlyVisitedForumListAdapter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j76 a;

        public e(j76 j76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j76Var;
        }

        @Override // com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.a
        public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, forumViewHolder) == null) || this.a.o || forumViewHolder == null || (view2 = forumViewHolder.itemView) == null || !(view2.getTag() instanceof VisitedForumData)) {
                return;
            }
            VisitedForumData visitedForumData = (VisitedForumData) forumViewHolder.itemView.getTag();
            FrsActivityConfig callFrom = new FrsActivityConfig(this.a.a.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
            this.a.l(forumViewHolder, callFrom.getIntent(), visitedForumData.getNeedTrans(), visitedForumData);
            this.a.a.sendMessage(new CustomMessage(2003000, callFrom));
            TiebaStatic.log(new StatisticItem("c13002").param("fid", visitedForumData.getForumId()));
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j76 a;

        public f(j76 j76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j76Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.D(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j76 a;

        public g(j76 j76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f == null || view2.getTag() == null || !(view2.getTag() instanceof VisitedForumData)) {
                return;
            }
            VisitedForumData visitedForumData = (VisitedForumData) view2.getTag();
            this.a.f.A(visitedForumData);
            TiebaStatic.log(new StatisticItem("c13005").param("fid", visitedForumData.getForumId()));
        }
    }

    /* loaded from: classes6.dex */
    public class h implements k56.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j76 a;

        public h(j76 j76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j76Var;
        }

        @Override // com.repackage.k56.f
        public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, linkedList, z) == null) {
                this.a.y(linkedList);
                if (z || this.a.q == null) {
                    return;
                }
                this.a.q.c(linkedList, this.a.a.getResources().getDimensionPixelSize(R.dimen.tbds678) + this.a.a.getResources().getDimensionPixelSize(R.dimen.tbds10));
            }
        }

        @Override // com.repackage.k56.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.v(i);
            }
        }

        @Override // com.repackage.k56.f
        public void onNotify() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j76 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(j76 j76Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var, Integer.valueOf(i)};
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
            this.a = j76Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.m(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface j {
        void a();
    }

    /* loaded from: classes6.dex */
    public class k extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;

        public k(j76 j76Var, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j76Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager.getOrientation() == 1) {
                    if (recyclerView.getChildAdapterPosition(view2) == 0) {
                        rect.top = this.a;
                    } else {
                        rect.top = this.b;
                    }
                    if (recyclerView.getChildAdapterPosition(view2) == linearLayoutManager.getItemCount() - 1) {
                        rect.bottom = this.c;
                        return;
                    }
                    return;
                }
                if (recyclerView.getChildAdapterPosition(view2) == 0) {
                    rect.left = this.a;
                } else {
                    rect.left = this.b;
                }
                if (recyclerView.getChildAdapterPosition(view2) == linearLayoutManager.getItemCount() - 1) {
                    rect.right = this.c;
                }
            }
        }
    }

    public j76(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, recentlyVisitedForumModel, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.n = true;
        this.o = false;
        this.u = new a(this, 2156674);
        this.v = new b(this, 2001011);
        this.w = new i(this, 2921347);
        this.a = tbPageContext;
        this.f = recentlyVisitedForumModel;
        this.p = viewEventCenter;
        this.g = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.q = new p56(tbPageContext);
        MessageManager.getInstance().registerListener(this.u);
        MessageManager.getInstance().registerListener(this.v);
        p();
        q();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            z46 z46Var = this.s;
            if (z46Var != null && z46Var.a) {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColorSelector(this.j, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0804cb);
            } else {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
                ur4 d2 = ur4.d(this.d);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0302);
                this.j.setBackgroundResource(R.drawable.obfuscated_res_0x7f0804cb);
            }
            G();
            u();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.n = !this.n;
            xt4.k().u("key_recently_visited_forum_extend_state", this.n);
            if (this.n) {
                TiebaStatic.log(new StatisticItem("c13003"));
            } else {
                TiebaStatic.log(new StatisticItem("c13004"));
            }
            G();
        }
    }

    public void C(z46 z46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z46Var) == null) {
            this.s = z46Var;
            A();
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.o == z || this.m == null) {
            return;
        }
        this.o = z;
        if (z) {
            this.j.setVisibility(0);
            this.i.setVisibility(8);
            Vibrator vibrator = this.g;
            if (vibrator != null) {
                vibrator.vibrate(10L);
            }
            ViewEventCenter viewEventCenter = this.p;
            if (viewEventCenter != null) {
                viewEventCenter.dispatchMvcEvent(new x75(10, null, null, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
        } else {
            this.j.setVisibility(8);
            this.i.setVisibility(0);
            ViewEventCenter viewEventCenter2 = this.p;
            if (viewEventCenter2 != null) {
                viewEventCenter2.dispatchMvcEvent(new x75(11, null, null, null));
            }
        }
        this.m.k(this.o);
    }

    public void E(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jVar) == null) {
            this.t = jVar;
        }
    }

    public void F(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.w.setTag(bdUniqueId);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            boolean z = this.n;
            int i2 = R.color.white_alpha100;
            if (z) {
                this.k.setVisibility(0);
                this.l.setVisibility(8);
                z46 z46Var = this.s;
                if (z46Var == null || !z46Var.a) {
                    i2 = R.color.CAM_X0107;
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f0808ef, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                this.k.setVisibility(8);
                this.l.setVisibility(0);
                z46 z46Var2 = this.s;
                if (z46Var2 == null || !z46Var2.a) {
                    i2 = R.color.CAM_X0107;
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f0808ee, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            j jVar = this.t;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.o) {
                D(false);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder, Intent intent, boolean z, VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{forumViewHolder, intent, Boolean.valueOf(z), visitedForumData}) == null) || forumViewHolder == null || intent == null) {
            return;
        }
        if (UbsABTestHelper.isEnterFrsNoAnmi()) {
            intent.putExtra("transition_type", 0);
        } else if (z && TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
            intent.putExtra("transition_type", 1);
            Rect rect = new Rect();
            BarImageView barImageView = forumViewHolder.d;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = forumViewHolder.b;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            intent.putExtra("info_forum_head_background_rect", new Rect());
            intent.putExtra("info_forum_head_background_color", visitedForumData.getThemeColorArrayList());
        } else {
            intent.putExtra("transition_type", 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(1048585, this, z) != null) {
            return;
        }
        if (z) {
            xt4 k2 = xt4.k();
            if (!k2.h("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
                this.e.setVisibility(0);
                G();
                jVar = this.t;
                if (jVar == null) {
                    jVar.a();
                    return;
                }
                return;
            }
        }
        this.e.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        jVar = this.t;
        if (jVar == null) {
        }
    }

    public z46 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : (z46) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.n = xt4.k().h("key_recently_visited_forum_extend_state", true);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            View inflate = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d071c, (ViewGroup) null);
            this.c = inflate;
            this.d = inflate.findViewById(R.id.obfuscated_res_0x7f091a7b);
            this.e = this.c.findViewById(R.id.obfuscated_res_0x7f0920cc);
            this.h = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0920bc);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09091d);
            this.i = imageView;
            imageView.setOnClickListener(new c(this));
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0907e5);
            this.j = textView;
            textView.setOnClickListener(new d(this));
            this.l = this.c.findViewById(R.id.obfuscated_res_0x7f090c3c);
            this.k = (RecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f0912d2);
            RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter = new RecentlyVisitedForumListAdapter(this.a);
            this.m = recentlyVisitedForumListAdapter;
            this.k.setAdapter(recentlyVisitedForumListAdapter);
            this.k.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                ln lnVar = new ln(new jn());
                this.r = lnVar;
                lnVar.q(this.k, 1);
            }
            this.k.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity(), 0, false));
            this.k.setItemAnimator(new DefaultItemAnimator());
            this.k.addItemDecoration(new k(this, pi.f(this.a.getPageActivity(), R.dimen.tbds44), 0, pi.f(this.a.getPageActivity(), R.dimen.tbds44)));
            this.m.l(new e(this));
            this.m.m(new f(this));
            this.m.j(new g(this));
            this.f.D(new h(this));
            w(TbadkCoreApplication.getInst().getSkinType());
            this.a.registerListener(this.w);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.e.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void u() {
        RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (recentlyVisitedForumListAdapter = this.m) == null) {
            return;
        }
        recentlyVisitedForumListAdapter.notifyDataSetChanged();
        if (this.m.getItemCount() > 0) {
            m(true);
        } else {
            m(false);
        }
    }

    public void v(int i2) {
        RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (recentlyVisitedForumListAdapter = this.m) == null) {
            return;
        }
        recentlyVisitedForumListAdapter.notifyItemRemoved(i2);
        if (this.m.getItemCount() == 0) {
            D(false);
            m(false);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || this.b == i2) {
            return;
        }
        this.b = i2;
        A();
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.v);
            p56 p56Var = this.q;
            if (p56Var != null) {
                p56Var.f();
            }
        }
    }

    public void y(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, linkedList) == null) || this.m == null || linkedList == null) {
            return;
        }
        G();
        this.m.i(linkedList);
        u();
        w(TbadkCoreApplication.getInst().getSkinType());
    }

    public void z() {
        RecentlyVisitedForumModel recentlyVisitedForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (recentlyVisitedForumModel = this.f) == null) {
            return;
        }
        recentlyVisitedForumModel.refresh();
    }
}
