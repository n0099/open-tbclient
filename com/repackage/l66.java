package com.repackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b96;
import com.repackage.e76;
import com.repackage.em8;
import com.repackage.ur4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class l66 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public b96 c;
    public e76 d;
    public EnterForumModel e;
    public List<dp4> f;
    public boolean g;
    public r66 h;
    public v86 i;
    public HashSet<Long> j;
    public em8.c k;

    /* loaded from: classes6.dex */
    public class a implements b96.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v86 a;
        public final /* synthetic */ l66 b;

        public a(l66 l66Var, v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var, v86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l66Var;
            this.a = v86Var;
        }

        @Override // com.repackage.b96.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.s());
                this.a.z0(this.b.c.t());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements e76.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l66 a;

        public b(l66 l66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l66Var;
        }

        @Override // com.repackage.e76.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.L(true, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l66 a;

        public c(l66 l66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l66Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dispatchMvcEvent(new w85(6, null, null, null));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l66 a;

        public d(l66 l66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l66Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dispatchMvcEvent(new w85(6, null, null, null));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l66 a;

        /* loaded from: classes6.dex */
        public class a implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    em8.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements ur4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
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
                    }
                }
            }

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements ur4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(e eVar) {
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
                    }
                }
            }

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                }
            }
        }

        public e(l66 l66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l66Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.B()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new w85(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.D().b();
                if (b2 != null) {
                    int A = b2.A();
                    if (A == 220012) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        blockPopInfoData.block_info = pi.isEmpty(b2.z()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0471) : b2.z();
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0473);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09a1);
                        blockPopInfoData.ahead_url = "https://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    } else if (A == 2121002) {
                        g05.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0475), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1425), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f13bd), new a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0472);
                if (b2 != null) {
                    string = pi.isEmpty(b2.z()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0472) : b2.z();
                }
                g05.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09a1), null, new c(this), null).show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends em8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(l66 l66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.em8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.repackage.em8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.repackage.em8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.repackage.em8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public g(l66 l66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(l66 l66Var, a aVar) {
            this(l66Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ImageView b;
        public TextView c;
        public TBSpecificationBtn d;

        public h(l66 l66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(l66 l66Var, a aVar) {
            this(l66Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public i(l66 l66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(l66 l66Var, a aVar) {
            this(l66Var);
        }
    }

    public l66(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, v86 v86Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, v86Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.g = true;
        this.k = new f(this);
        this.a = tbPageContext;
        this.b = viewEventCenter;
        this.j = new HashSet<>();
        this.i = v86Var;
        b96 b96Var = new b96(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = b96Var;
        b96Var.E(new a(this, v86Var));
        this.e = enterForumModel;
        e76 e76Var = new e76(this.a.getPageActivity(), Integer.valueOf(k66.a(1)).intValue(), 0, this.c);
        this.d = e76Var;
        e76Var.u(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b96 b96Var = this.c;
            if (b96Var == null) {
                return false;
            }
            return b96Var.k();
        }
        return invokeV.booleanValue;
    }

    public List<dp4> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.f.size();
            if (size <= 0 || i2 >= size) {
                return null;
            }
            return this.f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<dp4> list = this.f;
            if (list == null || (i2 < list.size() && i2 >= 0)) {
                return i2;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 >= this.f.size() || i2 < 0) {
                return 6;
            }
            return this.f.get(i2).c();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        y86 y86Var;
        dp4 dp4Var;
        g gVar;
        h hVar;
        c96 c96Var;
        g96 g96Var;
        h96 h96Var;
        f96 f96Var;
        d96 d96Var;
        e96 e96Var;
        x86 x86Var;
        v66 v66Var;
        w86 w86Var;
        p66 p66Var;
        x76 x76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view2, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view2 != null && (view2.getTag() instanceof i)) {
                        iVar = (i) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d026e, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ba);
                        iVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ec4);
                        iVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906bd);
                        view2.setTag(iVar);
                    }
                    if (this.f.get(i2) instanceof t66) {
                        t66 t66Var = (t66) this.f.get(i2);
                        this.d.v(iVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (t66Var != null) {
                            iVar.a.setText(t66Var.d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            r66 r66Var = this.h;
                            if ((r66Var != null && r66Var.a) || t66Var.f) {
                                SkinManager.setBackgroundResource(iVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.b;
                            if (textView != null) {
                                if (t66Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.c.getLayoutParams();
                            if (t66Var.g != -1) {
                                layoutParams.setMargins(qi.f(viewGroup.getContext(), t66Var.g), 0, qi.f(viewGroup.getContext(), t66Var.g), 0);
                            }
                            if (t66Var.i != -1) {
                                ms4.d(iVar.a).z(t66Var.i);
                            }
                            if (t66Var.h != -1) {
                                layoutParams.height = qi.f(viewGroup.getContext(), t66Var.h);
                            }
                            iVar.c.setLayoutParams(layoutParams);
                            if (t66Var.j != -1) {
                                iVar.c.setPadding(qi.f(viewGroup.getContext(), t66Var.j), 0, qi.f(viewGroup.getContext(), t66Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof y86)) {
                        y86Var = (y86) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d038b, viewGroup, false);
                        y86Var = new y86(this.a, view2, this.b);
                        view2.setTag(y86Var);
                    }
                    if ((this.f.get(i2) instanceof dp4) && (dp4Var = this.f.get(i2)) != null) {
                        y86Var.f(dp4Var);
                    }
                    y86Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d026d, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a22);
                        gVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0906bd);
                        view2.setTag(gVar);
                    }
                    View view3 = gVar.b;
                    if (view3 != null) {
                        view3.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(gVar.a, (int) R.color.CAM_X0304);
                    return view2;
                case 3:
                    if (view2 != null && (view2.getTag() instanceof h)) {
                        hVar = (h) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d026b, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091c1a);
                        hVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e78);
                        hVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d4b);
                        hVar.d = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090a22);
                        ov4 ov4Var = new ov4();
                        hVar.d.setTextSize(R.dimen.tbds42);
                        hVar.d.setConfig(ov4Var);
                        view2.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f0579);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03e7));
                        hVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f06c9);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03e5));
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(hVar.c, (int) R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(hVar.a, R.color.CAM_X0205);
                    hVar.d.k();
                    TBSpecificationBtn tBSpecificationBtn = hVar.d;
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setOnClickListener(new d(this));
                        return view2;
                    }
                    return view2;
                case 4:
                    if (view2 == null) {
                        View o = this.c.o();
                        this.c.z();
                        return o;
                    }
                    return view2;
                case 5:
                    o();
                    if (view2 != null && (view2.getTag() instanceof c96)) {
                        c96Var = (c96) view2.getTag();
                    } else {
                        c96Var = new c96(this.a);
                        view2 = c96Var.b();
                        view2.setTag(c96Var);
                    }
                    c96Var.a();
                    c96Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof g96)) {
                        g96Var = (g96) view2.getTag();
                    } else {
                        g96Var = new g96(this.a);
                        view2 = g96Var.d();
                        view2.setTag(g96Var);
                    }
                    if (this.f.get(i2) instanceof wq4) {
                        g96Var.c((wq4) this.f.get(i2));
                    }
                    if (this.e.D() == null || this.e.D().e() == null || this.e.D().e().b() == null) {
                        return view2;
                    }
                    g96Var.e(this.e.D().e().b().size() > 0);
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof h96)) {
                        h96Var = (h96) view2.getTag();
                    } else {
                        h96Var = new h96(this.a);
                        view2 = h96Var.k();
                        view2.setTag(h96Var);
                    }
                    if (this.f.get(i2) instanceof uq4) {
                        uq4 uq4Var = (uq4) this.f.get(i2);
                        h96Var.g(uq4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(uq4Var.j()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", uq4Var.j());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                                boolean z = this.e.D().e().b().size() > 0;
                                statisticItem.param("obj_type", z ? 3 : 1);
                                h96Var.m(z);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(uq4Var.j()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof f96)) {
                        f96Var = (f96) view2.getTag();
                    } else {
                        f96Var = new f96(this.a);
                        view2 = f96Var.c();
                        view2.setTag(f96Var);
                    }
                    if (this.f.get(i2) instanceof vq4) {
                        f96Var.b((vq4) this.f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof d96)) {
                        d96Var = (d96) view2.getTag();
                    } else {
                        d96Var = new d96(this.a);
                        view2 = d96Var.d();
                        view2.setTag(d96Var);
                    }
                    if (this.f.get(i2) instanceof n66) {
                        d96Var.c((n66) this.f.get(i2));
                    }
                    if (this.e.D() == null || this.e.D().e() == null || this.e.D().e().b() == null) {
                        return view2;
                    }
                    d96Var.e(this.e.D().e().b().size() > 0);
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof e96)) {
                        e96Var = (e96) view2.getTag();
                    } else {
                        e96Var = new e96(this.a);
                        view2 = e96Var.b();
                        view2.setTag(e96Var);
                    }
                    e96Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof x86)) {
                        x86Var = (x86) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d050b, viewGroup, false);
                        x86Var = new x86(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(x86Var);
                    }
                    if ((this.f.get(i2) instanceof v66) && (v66Var = (v66) this.f.get(i2)) != null) {
                        x86Var.f(v66Var);
                    }
                    x86Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof w86)) {
                        w86Var = (w86) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01da, viewGroup, false);
                        w86Var = new w86(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(w86Var);
                    }
                    if (!(this.f.get(i2) instanceof p66) || (p66Var = (p66) this.f.get(i2)) == null || ListUtils.isEmpty(p66Var.j())) {
                        return view2;
                    }
                    w86Var.f(p66Var);
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof x76)) {
                        x76Var = (x76) view2.getTag();
                    } else {
                        x76Var = new x76(this.a);
                        view2 = x76Var.a();
                        view2.setTag(x76Var);
                    }
                    if (this.f.get(i2) instanceof t76) {
                        t76 t76Var = (t76) this.f.get(i2);
                        x76Var.a().setData(t76Var);
                        TiebaStatic.log(new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", t76Var != null ? t76Var.j() : "").param("obj_source", t76Var != null ? t76Var.getFrom() : ""));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? dp4.c.length : invokeV.intValue;
    }

    public void h(int i2) {
        b96 b96Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (b96Var = this.c) == null) {
            return;
        }
        b96Var.w(i2);
    }

    public void i() {
        b96 b96Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (b96Var = this.c) == null) {
            return;
        }
        b96Var.x();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = true;
            this.j.clear();
        }
    }

    public void k(int i2) {
        e76 e76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (e76Var = this.d) == null) {
            return;
        }
        e76Var.t(i2);
    }

    public void l(r66 r66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, r66Var) == null) {
            if (r66Var != this.h) {
                this.h = r66Var;
                notifyDataSetChanged();
            }
            b96 b96Var = this.c;
            if (b96Var != null) {
                b96Var.C(r66Var);
            }
        }
    }

    public void m(List<dp4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            e76 e76Var = this.d;
            if (e76Var != null) {
                e76Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        b96 b96Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) || (b96Var = this.c) == null) {
            return;
        }
        b96Var.F(bdUniqueId);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g) {
            TiebaStatic.log("c13378");
            this.g = false;
        }
    }
}
