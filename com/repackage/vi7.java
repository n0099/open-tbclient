package com.repackage;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper$PayForm;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zi7;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class vi7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String F = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public static String G = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public Boolean C;
    public AdapterView.d D;
    public View.OnClickListener E;
    public TbPageContext a;
    public View b;
    public RelativeLayout c;
    public HListView d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public GridView h;
    public LinearLayout i;
    public TextView j;
    public NoNetworkView k;
    public TextView l;
    public wi7 m;
    public yi7 n;
    public zi7 o;
    public zi7.g p;
    public zi7.b q;
    public zi7.c r;
    public zi7.a s;
    public String t;
    public String u;
    public String v;
    public String w;
    public int x;
    public long y;
    public String z;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public a(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            zi7.d item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.m.getItem(i)) == null) {
                return;
            }
            item.i = true;
            this.a.m.g(item);
            this.a.u(item.j);
            this.a.x(item.f);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi7 a;

        public b(vi7 vi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = 0;
                if (view2 == this.a.j) {
                    this.a.l();
                    int i2 = 2;
                    if (this.a.x != 1) {
                        int unused = this.a.x;
                        i2 = 1;
                    }
                    zi7.d b = this.a.m.b();
                    if (b != null && b.j != 1) {
                        long j = b.h;
                        if (j == 1) {
                            i = 1;
                        } else if (j == 3) {
                            i = 3;
                        } else if (j == 6) {
                            i = 6;
                        } else if (j == 12) {
                            i = 12;
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c13200").param("obj_type", i2).param("obj_locate", i));
                } else if (view2 != this.a.e) {
                    if (view2 == this.a.g) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, true);
                        UrlManager.getInstance().dealOneLink(this.a.a, new String[]{vi7.F}, false, bundle);
                    }
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{vi7.G});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755230131, "Lcom/repackage/vi7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755230131, "Lcom/repackage/vi7;");
        }
    }

    public vi7(TbPageContext tbPageContext, View view2, int i, String str, String str2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Integer.valueOf(i), str, str2, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = 2;
        this.C = Boolean.FALSE;
        this.D = new a(this);
        this.E = new b(this);
        this.b = view2;
        this.a = tbPageContext;
        this.x = i;
        this.C = Boolean.valueOf(z);
        this.z = str;
        this.A = str2;
        this.B = i2;
        o();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            zi7.d b2 = this.m.b();
            if (b2 == null) {
                pi.N(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f13ad);
            } else if (b2.j == 1 && b2.k) {
                pi.N(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f142a);
            } else {
                t(b2.e, b2.f / 100, b2.h, b2.j);
                if (this.B == 26) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW_PAY_CLICK).param("obj_source", 1));
                }
            }
        }
    }

    public final void m() {
        zi7 zi7Var;
        zi7.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (zi7Var = this.o) == null) {
            return;
        }
        zi7.b bVar = zi7Var.b;
        this.q = bVar;
        zi7.g gVar = zi7Var.a;
        this.p = gVar;
        if (bVar == null || gVar == null || (eVar = gVar.a) == null) {
            return;
        }
        this.y = eVar.a;
        zi7.a aVar = bVar.b;
        this.s = aVar;
        if (aVar != null) {
            this.t = aVar.c;
        }
        zi7.c cVar = this.q.a;
        this.r = cVar;
        if (cVar != null) {
            this.u = cVar.c;
        }
    }

    public final ArrayList<xi7> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<xi7> arrayList = new ArrayList<>();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = this.x;
            Integer valueOf = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08060a);
            Integer valueOf2 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080608);
            Integer valueOf3 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080609);
            Integer valueOf4 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080605);
            Integer valueOf5 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080607);
            if (i == 1) {
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ac1), valueOf5);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abf), valueOf4);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abd), valueOf3);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ac2), valueOf2);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ac0), valueOf);
            } else if (i == 2) {
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ac1), valueOf5);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abf), valueOf4);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aba), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080602));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ab9), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080601));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abc), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080604));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abe), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080603));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abd), valueOf3);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ac2), valueOf2);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ac0), valueOf);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abb), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080606));
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                xi7 xi7Var = new xi7();
                xi7Var.b = (String) entry.getKey();
                xi7Var.a = ((Integer) entry.getValue()).intValue();
                arrayList.add(xi7Var);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091abd);
            this.d = (HListView) this.b.findViewById(R.id.obfuscated_res_0x7f0918dd);
            this.i = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091a29);
            this.e = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091a2a);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091908);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091901);
            this.h = (GridView) this.b.findViewById(R.id.obfuscated_res_0x7f0918f7);
            this.k = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f092391);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0913a4);
            this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0921af);
            this.d.setBackgroundResource(R.drawable.obfuscated_res_0x7f081224);
            this.d.setOnItemClickListener(this.D);
            this.d.setSelector(this.a.getPageActivity().getResources().getDrawable(R.drawable.obfuscated_res_0x7f081224));
            this.h.setVerticalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
            this.h.setHorizontalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds108));
            this.j.setOnClickListener(this.E);
            this.e.setOnClickListener(this.E);
            this.g.setOnClickListener(this.E);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.k.d(this.a, i);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0107);
            this.g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_tbvip_arrow_right), (Drawable) null);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.j, R.drawable.member_price_btn_bg);
            SkinManager.setImageResource(this.e, R.drawable.icon_tbvip_attention);
        }
    }

    public void q(boolean z) {
        zi7.c cVar;
        List<zi7.d> list;
        zi7.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.o == null) {
            return;
        }
        List<zi7.d> list2 = null;
        if (2 != this.x ? !((cVar = this.r) == null || (list = cVar.a) == null) : !((aVar = this.s) == null || (list = aVar.a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            zi7.d dVar = list2.get(i);
            if (dVar != null && dVar.f >= 0 && dVar.j == 1) {
                dVar.k = z;
                return;
            }
        }
    }

    public final void r() {
        zi7.g gVar;
        zi7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.o == null) {
                this.c.setVisibility(8);
            } else if (this.q != null && (gVar = this.p) != null) {
                if (gVar.a == null) {
                    this.c.setVisibility(8);
                } else if (this.s == null && this.r == null) {
                    this.c.setVisibility(8);
                } else if (this.x == 2 && ((aVar = this.s) == null || ListUtils.isEmpty(aVar.a))) {
                    this.c.setVisibility(8);
                } else {
                    this.c.setVisibility(0);
                    v();
                    w();
                    y();
                }
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void s(zi7 zi7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zi7Var) == null) {
            if (zi7Var == null) {
                this.c.setVisibility(8);
                return;
            }
            this.o = zi7Var;
            m();
            r();
        }
    }

    public final void t(long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.C.booleanValue(), PageDialogHelper$PayForm.NOT_SET, this.z, this.A);
            payConfig.setTitle(this.v);
            payConfig.setOrderName(this.w + this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0ab8, new Object[]{String.valueOf(j3)}));
            payConfig.setAutoPay(i);
            if (this.B == 23) {
                payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
            }
            c85.c().a(payConfig, this.a.getPageActivity());
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i == 1) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
    }

    public final void v() {
        zi7.c cVar;
        List<zi7.d> list;
        zi7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (2 != this.x ? (cVar = this.r) == null || (list = cVar.a) == null : (aVar = this.s) == null || (list = aVar.a) == null) {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (zi7.d dVar : list) {
                if (dVar.i) {
                    u(dVar.j);
                    x(dVar.f);
                }
            }
            if (this.m == null) {
                wi7 wi7Var = new wi7(this.a);
                this.m = wi7Var;
                wi7Var.d(list);
                this.d.setAdapter((ListAdapter) this.m);
            }
            this.m.d(list);
            this.m.notifyDataSetChanged();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.n == null) {
            ArrayList<xi7> n = n();
            yi7 yi7Var = new yi7(this.a.getPageActivity());
            this.n = yi7Var;
            yi7Var.c(n);
            this.h.setAdapter((ListAdapter) this.n);
        }
    }

    public final void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.j.setText(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f13ab, "" + (j / 100)));
        }
    }

    public final void y() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = this.x;
            if (2 == i) {
                if (this.y == 2) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0435, new Object[]{this.t});
                } else {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0508, new Object[]{this.t});
                }
                this.w = this.t;
            } else if (1 == i) {
                long j = this.y;
                if (j == 1) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0435, new Object[]{this.u});
                } else {
                    string = j == 0 ? this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0508, new Object[]{this.u}) : null;
                }
                this.w = this.u;
            } else {
                string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0508, new Object[]{this.u});
                this.w = this.u;
            }
            this.v = string;
        }
    }
}
