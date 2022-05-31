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
import com.repackage.oh7;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class kh7 {
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
    public lh7 m;
    public nh7 n;
    public oh7 o;
    public oh7.g p;
    public oh7.b q;
    public oh7.c r;
    public oh7.a s;
    public String t;
    public String u;
    public String v;
    public String w;
    public int x;
    public long y;
    public String z;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh7 a;

        public a(kh7 kh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kh7Var;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            oh7.d item;
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

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh7 a;

        public b(kh7 kh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kh7Var;
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
                    oh7.d b = this.a.m.b();
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
                        UrlManager.getInstance().dealOneLink(this.a.a, new String[]{kh7.F}, false, bundle);
                    }
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{kh7.G});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755558793, "Lcom/repackage/kh7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755558793, "Lcom/repackage/kh7;");
        }
    }

    public kh7(TbPageContext tbPageContext, View view2, int i, String str, String str2, boolean z, int i2) {
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
            oh7.d b2 = this.m.b();
            if (b2 == null) {
                li.N(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f13a0);
            } else if (b2.j == 1 && b2.k) {
                li.N(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f141d);
            } else {
                t(b2.e, b2.f / 100, b2.h, b2.j);
                if (this.B == 26) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW_PAY_CLICK).param("obj_source", 1));
                }
            }
        }
    }

    public final void m() {
        oh7 oh7Var;
        oh7.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (oh7Var = this.o) == null) {
            return;
        }
        oh7.b bVar = oh7Var.b;
        this.q = bVar;
        oh7.g gVar = oh7Var.a;
        this.p = gVar;
        if (bVar == null || gVar == null || (eVar = gVar.a) == null) {
            return;
        }
        this.y = eVar.a;
        oh7.a aVar = bVar.b;
        this.s = aVar;
        if (aVar != null) {
            this.t = aVar.c;
        }
        oh7.c cVar = this.q.a;
        this.r = cVar;
        if (cVar != null) {
            this.u = cVar.c;
        }
    }

    public final ArrayList<mh7> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<mh7> arrayList = new ArrayList<>();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = this.x;
            Integer valueOf = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08060c);
            Integer valueOf2 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08060a);
            Integer valueOf3 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08060b);
            Integer valueOf4 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080607);
            Integer valueOf5 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080609);
            if (i == 1) {
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abd), valueOf5);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abb), valueOf4);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ab9), valueOf3);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abe), valueOf2);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abc), valueOf);
            } else if (i == 2) {
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abd), valueOf5);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abb), valueOf4);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ab6), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080604));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ab5), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080603));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ab8), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080606));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aba), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080605));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ab9), valueOf3);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abe), valueOf2);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0abc), valueOf);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0ab7), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080608));
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                mh7 mh7Var = new mh7();
                mh7Var.b = (String) entry.getKey();
                mh7Var.a = ((Integer) entry.getValue()).intValue();
                arrayList.add(mh7Var);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091ac5);
            this.d = (HListView) this.b.findViewById(R.id.obfuscated_res_0x7f0918e6);
            this.i = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091a32);
            this.e = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091a33);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091911);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09190a);
            this.h = (GridView) this.b.findViewById(R.id.obfuscated_res_0x7f091900);
            this.k = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f0923a4);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0913ac);
            this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0921b3);
            this.d.setBackgroundResource(R.drawable.obfuscated_res_0x7f081233);
            this.d.setOnItemClickListener(this.D);
            this.d.setSelector(this.a.getPageActivity().getResources().getDrawable(R.drawable.obfuscated_res_0x7f081233));
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
            this.k.c(this.a, i);
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
        oh7.c cVar;
        List<oh7.d> list;
        oh7.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.o == null) {
            return;
        }
        List<oh7.d> list2 = null;
        if (2 != this.x ? !((cVar = this.r) == null || (list = cVar.a) == null) : !((aVar = this.s) == null || (list = aVar.a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            oh7.d dVar = list2.get(i);
            if (dVar != null && dVar.f >= 0 && dVar.j == 1) {
                dVar.k = z;
                return;
            }
        }
    }

    public final void r() {
        oh7.g gVar;
        oh7.a aVar;
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

    public void s(oh7 oh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, oh7Var) == null) {
            if (oh7Var == null) {
                this.c.setVisibility(8);
                return;
            }
            this.o = oh7Var;
            m();
            r();
        }
    }

    public final void t(long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.C.booleanValue(), PageDialogHelper$PayForm.NOT_SET, this.z, this.A);
            payConfig.setTitle(this.v);
            payConfig.setOrderName(this.w + this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0ab4, new Object[]{String.valueOf(j3)}));
            payConfig.setAutoPay(i);
            if (this.B == 23) {
                payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
            }
            p75.c().a(payConfig, this.a.getPageActivity());
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
        oh7.c cVar;
        List<oh7.d> list;
        oh7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (2 != this.x ? (cVar = this.r) == null || (list = cVar.a) == null : (aVar = this.s) == null || (list = aVar.a) == null) {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (oh7.d dVar : list) {
                if (dVar.i) {
                    u(dVar.j);
                    x(dVar.f);
                }
            }
            if (this.m == null) {
                lh7 lh7Var = new lh7(this.a);
                this.m = lh7Var;
                lh7Var.d(list);
                this.d.setAdapter((ListAdapter) this.m);
            }
            this.m.d(list);
            this.m.notifyDataSetChanged();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.n == null) {
            ArrayList<mh7> n = n();
            nh7 nh7Var = new nh7(this.a.getPageActivity());
            this.n = nh7Var;
            nh7Var.c(n);
            this.h.setAdapter((ListAdapter) this.n);
        }
    }

    public final void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.j.setText(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f139e, "" + (j / 100)));
        }
    }

    public final void y() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = this.x;
            if (2 == i) {
                if (this.y == 2) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0444, new Object[]{this.t});
                } else {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0516, new Object[]{this.t});
                }
                this.w = this.t;
            } else if (1 == i) {
                long j = this.y;
                if (j == 1) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0444, new Object[]{this.u});
                } else {
                    string = j == 0 ? this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0516, new Object[]{this.u}) : null;
                }
                this.w = this.u;
            } else {
                string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0516, new Object[]{this.u});
                this.w = this.u;
            }
            this.v = string;
        }
    }
}
