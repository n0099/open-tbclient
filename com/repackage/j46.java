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
import com.repackage.a76;
import com.repackage.c56;
import com.repackage.el8;
import com.repackage.nr4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class j46 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public a76 c;
    public c56 d;
    public EnterForumModel e;
    public List<xo4> f;
    public boolean g;
    public p46 h;
    public u66 i;
    public HashSet<Long> j;
    public el8.c k;

    /* loaded from: classes6.dex */
    public class a implements a76.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u66 a;
        public final /* synthetic */ j46 b;

        public a(j46 j46Var, u66 u66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j46Var, u66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j46Var;
            this.a = u66Var;
        }

        @Override // com.repackage.a76.k
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
    public class b implements c56.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j46 a;

        public b(j46 j46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j46Var;
        }

        @Override // com.repackage.c56.d
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
        public final /* synthetic */ j46 a;

        public c(j46 j46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dispatchMvcEvent(new i75(6, null, null, null));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j46 a;

        public d(j46 j46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dispatchMvcEvent(new i75(6, null, null, null));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j46 a;

        /* loaded from: classes6.dex */
        public class a implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    el8.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    nr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                }
            }
        }

        public e(j46 j46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.A()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new i75(14, null, null, null));
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
                        blockPopInfoData.block_info = li.isEmpty(b2.y()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0467) : b2.y();
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0469);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0988);
                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    } else if (z2 == 2121002) {
                        gz4.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f046b), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f141e), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f13b7), new a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0468);
                if (b2 != null) {
                    string = li.isEmpty(b2.y()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0468) : b2.y();
                }
                gz4.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0988), null, new c(this), null).show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends el8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(j46 j46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.el8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.repackage.el8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.repackage.el8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.repackage.el8.c
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

        public g(j46 j46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(j46 j46Var, a aVar) {
            this(j46Var);
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

        public h(j46 j46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(j46 j46Var, a aVar) {
            this(j46Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public i(j46 j46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(j46 j46Var, a aVar) {
            this(j46Var);
        }
    }

    public j46(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, u66 u66Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, u66Var};
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
        this.i = u66Var;
        a76 a76Var = new a76(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = a76Var;
        a76Var.E(new a(this, u66Var));
        this.e = enterForumModel;
        c56 c56Var = new c56(this.a.getPageActivity(), Integer.valueOf(i46.a(1)).intValue(), 0, this.c);
        this.d = c56Var;
        c56Var.v(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a76 a76Var = this.c;
            if (a76Var == null) {
                return false;
            }
            return a76Var.k();
        }
        return invokeV.booleanValue;
    }

    public List<xo4> g() {
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
            List<xo4> list = this.f;
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
        x66 x66Var;
        xo4 xo4Var;
        g gVar;
        h hVar;
        b76 b76Var;
        f76 f76Var;
        g76 g76Var;
        e76 e76Var;
        c76 c76Var;
        d76 d76Var;
        w66 w66Var;
        t46 t46Var;
        v66 v66Var;
        n46 n46Var;
        w56 w56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view2, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view2 != null && (view2.getTag() instanceof i)) {
                        iVar = (i) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0274, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092071);
                        iVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d89);
                        iVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906cd);
                        view2.setTag(iVar);
                    }
                    if (this.f.get(i2) instanceof r46) {
                        r46 r46Var = (r46) this.f.get(i2);
                        this.d.w(iVar.b);
                        this.d.s();
                        this.d.r(TbadkCoreApplication.getInst().getSkinType());
                        if (r46Var != null) {
                            iVar.a.setText(r46Var.d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            p46 p46Var = this.h;
                            if ((p46Var != null && p46Var.a) || r46Var.f) {
                                SkinManager.setBackgroundResource(iVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.b;
                            if (textView != null) {
                                if (r46Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.c.getLayoutParams();
                            if (r46Var.g != -1) {
                                layoutParams.setMargins(mi.f(viewGroup.getContext(), r46Var.g), 0, mi.f(viewGroup.getContext(), r46Var.g), 0);
                            }
                            if (r46Var.i != -1) {
                                gs4.d(iVar.a).z(r46Var.i);
                            }
                            if (r46Var.h != -1) {
                                layoutParams.height = mi.f(viewGroup.getContext(), r46Var.h);
                            }
                            iVar.c.setLayoutParams(layoutParams);
                            if (r46Var.j != -1) {
                                iVar.c.setPadding(mi.f(viewGroup.getContext(), r46Var.j), 0, mi.f(viewGroup.getContext(), r46Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof x66)) {
                        x66Var = (x66) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0390, viewGroup, false);
                        x66Var = new x66(this.a, view2, this.b);
                        view2.setTag(x66Var);
                    }
                    if ((this.f.get(i2) instanceof xo4) && (xo4Var = this.f.get(i2)) != null) {
                        x66Var.i(xo4Var);
                    }
                    x66Var.k(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0273, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a0d);
                        gVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0906cd);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0271, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091b16);
                        hVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e6f);
                        hVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d4b);
                        hVar.d = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090a0d);
                        xu4 xu4Var = new xu4();
                        hVar.d.setTextSize(R.dimen.tbds42);
                        hVar.d.setConfig(xu4Var);
                        view2.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f056a);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03e1));
                        hVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f06b9);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03df));
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
                    if (view2 != null && (view2.getTag() instanceof b76)) {
                        b76Var = (b76) view2.getTag();
                    } else {
                        b76Var = new b76(this.a);
                        view2 = b76Var.b();
                        view2.setTag(b76Var);
                    }
                    b76Var.a();
                    b76Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof f76)) {
                        f76Var = (f76) view2.getTag();
                    } else {
                        f76Var = new f76(this.a);
                        view2 = f76Var.d();
                        view2.setTag(f76Var);
                    }
                    if (this.f.get(i2) instanceof qq4) {
                        f76Var.c((qq4) this.f.get(i2));
                    }
                    if (this.e.C() == null || this.e.C().e() == null || this.e.C().e().b() == null) {
                        return view2;
                    }
                    f76Var.e(this.e.C().e().b().size() > 0);
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof g76)) {
                        g76Var = (g76) view2.getTag();
                    } else {
                        g76Var = new g76(this.a);
                        view2 = g76Var.k();
                        view2.setTag(g76Var);
                    }
                    if (this.f.get(i2) instanceof oq4) {
                        oq4 oq4Var = (oq4) this.f.get(i2);
                        g76Var.g(oq4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(oq4Var.k()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", oq4Var.k());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.C() != null && this.e.C().e() != null && this.e.C().e().b() != null) {
                                boolean z = this.e.C().e().b().size() > 0;
                                statisticItem.param("obj_type", z ? 3 : 1);
                                g76Var.m(z);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(oq4Var.k()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof e76)) {
                        e76Var = (e76) view2.getTag();
                    } else {
                        e76Var = new e76(this.a);
                        view2 = e76Var.c();
                        view2.setTag(e76Var);
                    }
                    if (this.f.get(i2) instanceof pq4) {
                        e76Var.b((pq4) this.f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof c76)) {
                        c76Var = (c76) view2.getTag();
                    } else {
                        c76Var = new c76(this.a);
                        view2 = c76Var.d();
                        view2.setTag(c76Var);
                    }
                    if (this.f.get(i2) instanceof l46) {
                        c76Var.c((l46) this.f.get(i2));
                    }
                    if (this.e.C() == null || this.e.C().e() == null || this.e.C().e().b() == null) {
                        return view2;
                    }
                    c76Var.e(this.e.C().e().b().size() > 0);
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof d76)) {
                        d76Var = (d76) view2.getTag();
                    } else {
                        d76Var = new d76(this.a);
                        view2 = d76Var.b();
                        view2.setTag(d76Var);
                    }
                    d76Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof w66)) {
                        w66Var = (w66) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d04e9, viewGroup, false);
                        w66Var = new w66(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(w66Var);
                    }
                    if ((this.f.get(i2) instanceof t46) && (t46Var = (t46) this.f.get(i2)) != null) {
                        w66Var.i(t46Var);
                    }
                    w66Var.k(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof v66)) {
                        v66Var = (v66) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01e3, viewGroup, false);
                        v66Var = new v66(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(v66Var);
                    }
                    if (!(this.f.get(i2) instanceof n46) || (n46Var = (n46) this.f.get(i2)) == null || ListUtils.isEmpty(n46Var.k())) {
                        return view2;
                    }
                    v66Var.i(n46Var);
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof w56)) {
                        w56Var = (w56) view2.getTag();
                    } else {
                        w56Var = new w56(this.a);
                        view2 = w56Var.a();
                        view2.setTag(w56Var);
                    }
                    if (this.f.get(i2) instanceof s56) {
                        s56 s56Var = (s56) this.f.get(i2);
                        w56Var.a().setData(s56Var);
                        TiebaStatic.log(new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", s56Var != null ? s56Var.k() : "").param("obj_source", s56Var != null ? s56Var.getFrom() : ""));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? xo4.c.length : invokeV.intValue;
    }

    public void h(int i2) {
        a76 a76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (a76Var = this.c) == null) {
            return;
        }
        a76Var.w(i2);
    }

    public void i() {
        a76 a76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (a76Var = this.c) == null) {
            return;
        }
        a76Var.x();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = true;
            this.j.clear();
        }
    }

    public void k(int i2) {
        c56 c56Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (c56Var = this.d) == null) {
            return;
        }
        c56Var.u(i2);
    }

    public void l(p46 p46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, p46Var) == null) {
            if (p46Var != this.h) {
                this.h = p46Var;
                notifyDataSetChanged();
            }
            a76 a76Var = this.c;
            if (a76Var != null) {
                a76Var.C(p46Var);
            }
        }
    }

    public void m(List<xo4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            c56 c56Var = this.d;
            if (c56Var != null) {
                c56Var.q();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        a76 a76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) || (a76Var = this.c) == null) {
            return;
        }
        a76Var.F(bdUniqueId);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g) {
            TiebaStatic.log("c13378");
            this.g = false;
        }
    }
}
