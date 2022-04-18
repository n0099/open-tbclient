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
import com.repackage.e56;
import com.repackage.hm8;
import com.repackage.r76;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class i46 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public r76 c;
    public e56 d;
    public EnterForumModel e;
    public List<no4> f;
    public boolean g;
    public o46 h;
    public l76 i;
    public HashSet<Long> j;
    public hm8.c k;

    /* loaded from: classes6.dex */
    public class a implements r76.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l76 a;
        public final /* synthetic */ i46 b;

        public a(i46 i46Var, l76 l76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i46Var, l76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i46Var;
            this.a = l76Var;
        }

        @Override // com.repackage.r76.j
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
    public class b implements e56.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i46 a;

        public b(i46 i46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i46Var;
        }

        @Override // com.repackage.e56.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.K(true, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i46 a;

        public c(i46 i46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dispatchMvcEvent(new s65(6, null, null, null));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i46 a;

        public d(i46 i46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dispatchMvcEvent(new s65(6, null, null, null));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i46 a;

        /* loaded from: classes6.dex */
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
                    hm8.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    cr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
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

        /* loaded from: classes6.dex */
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

        public e(i46 i46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.A()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new s65(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.C().b();
                if (b2 != null) {
                    int z2 = b2.z();
                    if (z2 == 220012) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        blockPopInfoData.block_info = ni.isEmpty(b2.y()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f045f) : b2.y();
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0461);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0984);
                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    } else if (z2 == 2121002) {
                        sy4.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0463), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f13f6), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1393), new a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0460);
                if (b2 != null) {
                    string = ni.isEmpty(b2.y()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0460) : b2.y();
                }
                sy4.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0984), null, new c(this), null).show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends hm8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(i46 i46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.hm8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.repackage.hm8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.repackage.hm8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.repackage.hm8.c
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

        public g(i46 i46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(i46 i46Var, a aVar) {
            this(i46Var);
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

        public h(i46 i46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(i46 i46Var, a aVar) {
            this(i46Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public i(i46 i46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(i46 i46Var, a aVar) {
            this(i46Var);
        }
    }

    public i46(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, l76 l76Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, l76Var};
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
        this.i = l76Var;
        r76 r76Var = new r76(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = r76Var;
        r76Var.E(new a(this, l76Var));
        this.e = enterForumModel;
        e56 e56Var = new e56(this.a.getPageActivity(), Integer.valueOf(h46.a(1)).intValue(), 0, this.c);
        this.d = e56Var;
        e56Var.v(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            r76 r76Var = this.c;
            if (r76Var == null) {
                return false;
            }
            return r76Var.k();
        }
        return invokeV.booleanValue;
    }

    public List<no4> g() {
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
            List<no4> list = this.f;
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
            return this.f.get(i2).e();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        o76 o76Var;
        no4 no4Var;
        g gVar;
        h hVar;
        s76 s76Var;
        w76 w76Var;
        x76 x76Var;
        v76 v76Var;
        t76 t76Var;
        u76 u76Var;
        n76 n76Var;
        s46 s46Var;
        m76 m76Var;
        m46 m46Var;
        y56 y56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view2, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view2 != null && (view2.getTag() instanceof i)) {
                        iVar = (i) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d027c, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092013);
                        iVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d30);
                        iVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906d2);
                        view2.setTag(iVar);
                    }
                    if (this.f.get(i2) instanceof q46) {
                        q46 q46Var = (q46) this.f.get(i2);
                        this.d.w(iVar.b);
                        this.d.s();
                        this.d.r(TbadkCoreApplication.getInst().getSkinType());
                        if (q46Var != null) {
                            iVar.a.setText(q46Var.d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            o46 o46Var = this.h;
                            if ((o46Var != null && o46Var.a) || q46Var.f) {
                                SkinManager.setBackgroundResource(iVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.b;
                            if (textView != null) {
                                if (q46Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.c.getLayoutParams();
                            if (q46Var.g != -1) {
                                layoutParams.setMargins(oi.f(viewGroup.getContext(), q46Var.g), 0, oi.f(viewGroup.getContext(), q46Var.g), 0);
                            }
                            if (q46Var.i != -1) {
                                vr4.d(iVar.a).z(q46Var.i);
                            }
                            if (q46Var.h != -1) {
                                layoutParams.height = oi.f(viewGroup.getContext(), q46Var.h);
                            }
                            iVar.c.setLayoutParams(layoutParams);
                            if (q46Var.j != -1) {
                                iVar.c.setPadding(oi.f(viewGroup.getContext(), q46Var.j), 0, oi.f(viewGroup.getContext(), q46Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof o76)) {
                        o76Var = (o76) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0399, viewGroup, false);
                        o76Var = new o76(this.a, view2, this.b);
                        view2.setTag(o76Var);
                    }
                    if ((this.f.get(i2) instanceof no4) && (no4Var = this.f.get(i2)) != null) {
                        o76Var.i(no4Var);
                    }
                    o76Var.k(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d027b, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a14);
                        gVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0906d2);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0279, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091ac8);
                        hVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e68);
                        hVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d5e);
                        hVar.d = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090a14);
                        ku4 ku4Var = new ku4();
                        hVar.d.setTextSize(R.dimen.tbds42);
                        hVar.d.setConfig(ku4Var);
                        view2.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f0564);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03dc));
                        hVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f06b0);
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
                    if (view2 != null && (view2.getTag() instanceof s76)) {
                        s76Var = (s76) view2.getTag();
                    } else {
                        s76Var = new s76(this.a);
                        view2 = s76Var.b();
                        view2.setTag(s76Var);
                    }
                    s76Var.a();
                    s76Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof w76)) {
                        w76Var = (w76) view2.getTag();
                    } else {
                        w76Var = new w76(this.a);
                        view2 = w76Var.d();
                        view2.setTag(w76Var);
                    }
                    if (this.f.get(i2) instanceof fq4) {
                        w76Var.c((fq4) this.f.get(i2));
                    }
                    if (this.e.C() == null || this.e.C().e() == null || this.e.C().e().b() == null) {
                        return view2;
                    }
                    w76Var.e(this.e.C().e().b().size() > 0);
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof x76)) {
                        x76Var = (x76) view2.getTag();
                    } else {
                        x76Var = new x76(this.a);
                        view2 = x76Var.k();
                        view2.setTag(x76Var);
                    }
                    if (this.f.get(i2) instanceof dq4) {
                        dq4 dq4Var = (dq4) this.f.get(i2);
                        x76Var.g(dq4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(dq4Var.k()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", dq4Var.k());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.C() != null && this.e.C().e() != null && this.e.C().e().b() != null) {
                                boolean z = this.e.C().e().b().size() > 0;
                                statisticItem.param("obj_type", z ? 3 : 1);
                                x76Var.m(z);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(dq4Var.k()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof v76)) {
                        v76Var = (v76) view2.getTag();
                    } else {
                        v76Var = new v76(this.a);
                        view2 = v76Var.c();
                        view2.setTag(v76Var);
                    }
                    if (this.f.get(i2) instanceof eq4) {
                        v76Var.b((eq4) this.f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof t76)) {
                        t76Var = (t76) view2.getTag();
                    } else {
                        t76Var = new t76(this.a);
                        view2 = t76Var.d();
                        view2.setTag(t76Var);
                    }
                    if (this.f.get(i2) instanceof k46) {
                        t76Var.c((k46) this.f.get(i2));
                    }
                    if (this.e.C() == null || this.e.C().e() == null || this.e.C().e().b() == null) {
                        return view2;
                    }
                    t76Var.e(this.e.C().e().b().size() > 0);
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof u76)) {
                        u76Var = (u76) view2.getTag();
                    } else {
                        u76Var = new u76(this.a);
                        view2 = u76Var.b();
                        view2.setTag(u76Var);
                    }
                    u76Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof n76)) {
                        n76Var = (n76) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d04f4, viewGroup, false);
                        n76Var = new n76(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(n76Var);
                    }
                    if ((this.f.get(i2) instanceof s46) && (s46Var = (s46) this.f.get(i2)) != null) {
                        n76Var.i(s46Var);
                    }
                    n76Var.k(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof m76)) {
                        m76Var = (m76) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01ea, viewGroup, false);
                        m76Var = new m76(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(m76Var);
                    }
                    if (!(this.f.get(i2) instanceof m46) || (m46Var = (m46) this.f.get(i2)) == null || ListUtils.isEmpty(m46Var.k())) {
                        return view2;
                    }
                    m76Var.i(m46Var);
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof y56)) {
                        y56Var = (y56) view2.getTag();
                    } else {
                        y56Var = new y56(this.a);
                        view2 = y56Var.a();
                        view2.setTag(y56Var);
                    }
                    if (this.f.get(i2) instanceof u56) {
                        u56 u56Var = (u56) this.f.get(i2);
                        y56Var.a().setData(u56Var);
                        TiebaStatic.log(new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", u56Var != null ? u56Var.k() : "").param("obj_source", u56Var != null ? u56Var.getFrom() : ""));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? no4.c.length : invokeV.intValue;
    }

    public void h(int i2) {
        r76 r76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (r76Var = this.c) == null) {
            return;
        }
        r76Var.w(i2);
    }

    public void i() {
        r76 r76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (r76Var = this.c) == null) {
            return;
        }
        r76Var.x();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = true;
            this.j.clear();
        }
    }

    public void k(int i2) {
        e56 e56Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (e56Var = this.d) == null) {
            return;
        }
        e56Var.u(i2);
    }

    public void l(o46 o46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, o46Var) == null) {
            if (o46Var != this.h) {
                this.h = o46Var;
                notifyDataSetChanged();
            }
            r76 r76Var = this.c;
            if (r76Var != null) {
                r76Var.C(o46Var);
            }
        }
    }

    public void m(List<no4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            e56 e56Var = this.d;
            if (e56Var != null) {
                e56Var.q();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        r76 r76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) || (r76Var = this.c) == null) {
            return;
        }
        r76Var.F(bdUniqueId);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g) {
            TiebaStatic.log("c13378");
            this.g = false;
        }
    }
}
