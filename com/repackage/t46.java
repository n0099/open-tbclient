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
import com.repackage.cr4;
import com.repackage.j76;
import com.repackage.m56;
import com.repackage.tj8;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public class t46 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public j76 c;
    public m56 d;
    public EnterForumModel e;
    public List<lo4> f;
    public boolean g;
    public z46 h;
    public d76 i;
    public HashSet<Long> j;
    public tj8.c k;

    /* loaded from: classes7.dex */
    public class a implements j76.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d76 a;
        public final /* synthetic */ t46 b;

        public a(t46 t46Var, d76 d76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t46Var, d76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t46Var;
            this.a = d76Var;
        }

        @Override // com.repackage.j76.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.s());
                this.a.z0(this.b.c.t());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements m56.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t46 a;

        public b(t46 t46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t46Var;
        }

        @Override // com.repackage.m56.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.M(true, i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t46 a;

        public c(t46 t46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dispatchMvcEvent(new x75(6, null, null, null));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t46 a;

        public d(t46 t46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dispatchMvcEvent(new x75(6, null, null, null));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t46 a;

        /* loaded from: classes7.dex */
        public class a implements cr4.e {
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

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    tj8.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    cr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements cr4.e {
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

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements cr4.e {
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

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    cr4Var.dismiss();
                }
            }
        }

        public e(t46 t46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.C()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new x75(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.E().b();
                if (b2 != null) {
                    int B = b2.B();
                    if (B == 220012) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        blockPopInfoData.block_info = oi.isEmpty(b2.A()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0467) : b2.A();
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0469);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f099e);
                        blockPopInfoData.ahead_url = "https://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    } else if (B == 2121002) {
                        kz4.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f046b), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1436), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f13cf), new a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0468);
                if (b2 != null) {
                    string = oi.isEmpty(b2.A()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0468) : b2.A();
                }
                kz4.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f099e), null, new c(this), null).show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends tj8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(t46 t46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.tj8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.repackage.tj8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.repackage.tj8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.repackage.tj8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public g(t46 t46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(t46 t46Var, a aVar) {
            this(t46Var);
        }
    }

    /* loaded from: classes7.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ImageView b;
        public TextView c;
        public TBSpecificationBtn d;

        public h(t46 t46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(t46 t46Var, a aVar) {
            this(t46Var);
        }
    }

    /* loaded from: classes7.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public i(t46 t46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(t46 t46Var, a aVar) {
            this(t46Var);
        }
    }

    public t46(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, d76 d76Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, d76Var};
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
        this.i = d76Var;
        j76 j76Var = new j76(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = j76Var;
        j76Var.E(new a(this, d76Var));
        this.e = enterForumModel;
        m56 m56Var = new m56(this.a.getPageActivity(), Integer.valueOf(s46.a(1)).intValue(), 0, this.c);
        this.d = m56Var;
        m56Var.u(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j76 j76Var = this.c;
            if (j76Var == null) {
                return false;
            }
            return j76Var.k();
        }
        return invokeV.booleanValue;
    }

    public List<lo4> g() {
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
            List<lo4> list = this.f;
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
        g76 g76Var;
        lo4 lo4Var;
        g gVar;
        h hVar;
        k76 k76Var;
        o76 o76Var;
        p76 p76Var;
        n76 n76Var;
        l76 l76Var;
        m76 m76Var;
        f76 f76Var;
        d56 d56Var;
        e76 e76Var;
        x46 x46Var;
        f66 f66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view2, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view2 != null && (view2.getTag() instanceof i)) {
                        iVar = (i) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d026c, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920bc);
                        iVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091dce);
                        iVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906a0);
                        view2.setTag(iVar);
                    }
                    if (this.f.get(i2) instanceof b56) {
                        b56 b56Var = (b56) this.f.get(i2);
                        this.d.v(iVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (b56Var != null) {
                            iVar.a.setText(b56Var.d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            z46 z46Var = this.h;
                            if ((z46Var != null && z46Var.a) || b56Var.f) {
                                SkinManager.setBackgroundResource(iVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.b;
                            if (textView != null) {
                                if (b56Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.c.getLayoutParams();
                            if (b56Var.g != -1) {
                                layoutParams.setMargins(pi.f(viewGroup.getContext(), b56Var.g), 0, pi.f(viewGroup.getContext(), b56Var.g), 0);
                            }
                            if (b56Var.i != -1) {
                                ur4.d(iVar.a).z(b56Var.i);
                            }
                            if (b56Var.h != -1) {
                                layoutParams.height = pi.f(viewGroup.getContext(), b56Var.h);
                            }
                            iVar.c.setLayoutParams(layoutParams);
                            if (b56Var.j != -1) {
                                iVar.c.setPadding(pi.f(viewGroup.getContext(), b56Var.j), 0, pi.f(viewGroup.getContext(), b56Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof g76)) {
                        g76Var = (g76) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0389, viewGroup, false);
                        g76Var = new g76(this.a, view2, this.b);
                        view2.setTag(g76Var);
                    }
                    if ((this.f.get(i2) instanceof lo4) && (lo4Var = this.f.get(i2)) != null) {
                        g76Var.f(lo4Var);
                    }
                    g76Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d026b, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909ee);
                        gVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0906a0);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0269, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091b5c);
                        hVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e33);
                        hVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d0d);
                        hVar.d = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f0909ee);
                        tu4 tu4Var = new tu4();
                        hVar.d.setTextSize(R.dimen.tbds42);
                        hVar.d.setConfig(tu4Var);
                        view2.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f056f);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03dc));
                        hVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f06bf);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03da));
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
                    if (view2 != null && (view2.getTag() instanceof k76)) {
                        k76Var = (k76) view2.getTag();
                    } else {
                        k76Var = new k76(this.a);
                        view2 = k76Var.b();
                        view2.setTag(k76Var);
                    }
                    k76Var.a();
                    k76Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof o76)) {
                        o76Var = (o76) view2.getTag();
                    } else {
                        o76Var = new o76(this.a);
                        view2 = o76Var.d();
                        view2.setTag(o76Var);
                    }
                    if (this.f.get(i2) instanceof eq4) {
                        o76Var.c((eq4) this.f.get(i2));
                    }
                    if (this.e.E() == null || this.e.E().e() == null || this.e.E().e().b() == null) {
                        return view2;
                    }
                    o76Var.e(this.e.E().e().b().size() > 0);
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof p76)) {
                        p76Var = (p76) view2.getTag();
                    } else {
                        p76Var = new p76(this.a);
                        view2 = p76Var.k();
                        view2.setTag(p76Var);
                    }
                    if (this.f.get(i2) instanceof cq4) {
                        cq4 cq4Var = (cq4) this.f.get(i2);
                        p76Var.g(cq4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(cq4Var.i()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", cq4Var.i());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.E() != null && this.e.E().e() != null && this.e.E().e().b() != null) {
                                boolean z = this.e.E().e().b().size() > 0;
                                statisticItem.param("obj_type", z ? 3 : 1);
                                p76Var.m(z);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(cq4Var.i()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof n76)) {
                        n76Var = (n76) view2.getTag();
                    } else {
                        n76Var = new n76(this.a);
                        view2 = n76Var.c();
                        view2.setTag(n76Var);
                    }
                    if (this.f.get(i2) instanceof dq4) {
                        n76Var.b((dq4) this.f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof l76)) {
                        l76Var = (l76) view2.getTag();
                    } else {
                        l76Var = new l76(this.a);
                        view2 = l76Var.d();
                        view2.setTag(l76Var);
                    }
                    if (this.f.get(i2) instanceof v46) {
                        l76Var.c((v46) this.f.get(i2));
                    }
                    if (this.e.E() == null || this.e.E().e() == null || this.e.E().e().b() == null) {
                        return view2;
                    }
                    l76Var.e(this.e.E().e().b().size() > 0);
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof m76)) {
                        m76Var = (m76) view2.getTag();
                    } else {
                        m76Var = new m76(this.a);
                        view2 = m76Var.b();
                        view2.setTag(m76Var);
                    }
                    m76Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof f76)) {
                        f76Var = (f76) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d04f8, viewGroup, false);
                        f76Var = new f76(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(f76Var);
                    }
                    if ((this.f.get(i2) instanceof d56) && (d56Var = (d56) this.f.get(i2)) != null) {
                        f76Var.f(d56Var);
                    }
                    f76Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof e76)) {
                        e76Var = (e76) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01d9, viewGroup, false);
                        e76Var = new e76(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(e76Var);
                    }
                    if (!(this.f.get(i2) instanceof x46) || (x46Var = (x46) this.f.get(i2)) == null || ListUtils.isEmpty(x46Var.i())) {
                        return view2;
                    }
                    e76Var.f(x46Var);
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof f66)) {
                        f66Var = (f66) view2.getTag();
                    } else {
                        f66Var = new f66(this.a);
                        view2 = f66Var.a();
                        view2.setTag(f66Var);
                    }
                    if (this.f.get(i2) instanceof b66) {
                        b66 b66Var = (b66) this.f.get(i2);
                        f66Var.a().setData(b66Var);
                        TiebaStatic.log(new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", b66Var != null ? b66Var.i() : "").param("obj_source", b66Var != null ? b66Var.getFrom() : ""));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? lo4.c.length : invokeV.intValue;
    }

    public void h(int i2) {
        j76 j76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (j76Var = this.c) == null) {
            return;
        }
        j76Var.w(i2);
    }

    public void i() {
        j76 j76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (j76Var = this.c) == null) {
            return;
        }
        j76Var.x();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = true;
            this.j.clear();
        }
    }

    public void k(int i2) {
        m56 m56Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (m56Var = this.d) == null) {
            return;
        }
        m56Var.t(i2);
    }

    public void l(z46 z46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, z46Var) == null) {
            if (z46Var != this.h) {
                this.h = z46Var;
                notifyDataSetChanged();
            }
            j76 j76Var = this.c;
            if (j76Var != null) {
                j76Var.C(z46Var);
            }
        }
    }

    public void m(List<lo4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            m56 m56Var = this.d;
            if (m56Var != null) {
                m56Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        j76 j76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) || (j76Var = this.c) == null) {
            return;
        }
        j76Var.F(bdUniqueId);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g) {
            TiebaStatic.log("c13378");
            this.g = false;
        }
    }
}
