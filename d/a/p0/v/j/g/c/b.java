package d.a.p0.v.j.g.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f64897e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.p0.v.j.g.c.c.a> f64898f;

    /* renamed from: g  reason: collision with root package name */
    public d f64899g;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.v.j.g.c.c.a f64900e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f64901f;

        public a(b bVar, d.a.p0.v.j.g.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64901f = bVar;
            this.f64900e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64901f.f64899g == null) {
                return;
            }
            this.f64901f.f64899g.a(this.f64900e.b(0));
        }
    }

    /* renamed from: d.a.p0.v.j.g.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1783b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.v.j.g.c.c.a f64902e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f64903f;

        public View$OnClickListenerC1783b(b bVar, d.a.p0.v.j.g.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64903f = bVar;
            this.f64902e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64903f.f64899g == null) {
                return;
            }
            this.f64903f.f64899g.a(this.f64902e.b(1));
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.v.j.g.c.c.a f64904e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f64905f;

        public c(b bVar, d.a.p0.v.j.g.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64905f = bVar;
            this.f64904e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64905f.f64899g == null) {
                return;
            }
            this.f64905f.f64899g.a(this.f64904e.b(2));
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(d.a.p0.v.j.g.c.c.b bVar);
    }

    /* loaded from: classes8.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f64906a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f64907b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f64908c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f64909d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f64910e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f64911f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f64912g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f64913h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f64914i;
        public TextView j;
        public TextView k;
        public TbImageView l;
        public TextView m;
        public RelativeLayout n;
        public TextView o;
        public View p;
        public TextView q;

        public e(b bVar) {
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
                }
            }
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(TbPageContext<?> tbPageContext, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64897e = null;
        this.f64897e = tbPageContext;
        this.f64899g = dVar;
    }

    public final List<d.a.p0.v.j.g.c.c.a> b(List<d.a.p0.v.j.g.c.c.c> list) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                List<d.a.p0.v.j.g.c.c.b> a2 = list.get(i3).a();
                int size = a2.size();
                if (size % 3 == 0) {
                    i2 = size / 3;
                } else {
                    i2 = (size / 3) + 1;
                }
                d.a.p0.v.j.g.c.c.b[][] bVarArr = (d.a.p0.v.j.g.c.c.b[][]) Array.newInstance(d.a.p0.v.j.g.c.c.b.class, i2, 3);
                for (int i4 = 0; i4 < size; i4++) {
                    int i5 = i4 / 3;
                    int i6 = i4 % 3;
                    bVarArr[i5][i6] = a2.get(i4);
                    bVarArr[i5][i6].o(list.get(i3).b());
                }
                arrayList2.add(bVarArr);
            }
            for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                for (int i8 = 0; i8 < ((d.a.p0.v.j.g.c.c.b[][]) arrayList2.get(i7)).length; i8++) {
                    d.a.p0.v.j.g.c.c.a aVar = new d.a.p0.v.j.g.c.c.a();
                    if (((d.a.p0.v.j.g.c.c.b[][]) arrayList2.get(i7)).length == 1) {
                        aVar.f(1);
                    } else if (((d.a.p0.v.j.g.c.c.b[][]) arrayList2.get(i7)).length > 1 && i8 == 0) {
                        aVar.f(2);
                    } else if (((d.a.p0.v.j.g.c.c.b[][]) arrayList2.get(i7)).length > 1 && i8 == ((d.a.p0.v.j.g.c.c.b[][]) arrayList2.get(i7)).length - 1) {
                        aVar.f(3);
                    } else {
                        aVar.f(4);
                    }
                    if (i7 == arrayList2.size() - 1) {
                        if (aVar.d() == 1) {
                            aVar.f(2);
                        } else if (aVar.d() == 3) {
                            aVar.f(4);
                        }
                    }
                    for (int i9 = 0; i9 < 3; i9++) {
                        if (((d.a.p0.v.j.g.c.c.b[][]) arrayList2.get(i7))[i8][i9] != null) {
                            aVar.a(((d.a.p0.v.j.g.c.c.b[][]) arrayList2.get(i7))[i8][i9]);
                        }
                    }
                    if (((d.a.p0.v.j.g.c.c.b[][]) arrayList2.get(i7))[0][0] != null) {
                        aVar.e(((d.a.p0.v.j.g.c.c.b[][]) arrayList2.get(i7))[0][0].h());
                    }
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        SkinManager.setViewTextColor(eVar.q, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f64906a, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f64911f, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.k, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f64910e, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.j, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.o, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        if (TbadkApplication.getInst().getSkinType() == 1) {
            eVar.f64907b.setDefaultResource(R.drawable.pic_live_honor_1);
            eVar.f64912g.setDefaultResource(R.drawable.pic_live_honor_1);
            eVar.l.setDefaultResource(R.drawable.pic_live_honor_1);
        } else {
            eVar.f64907b.setDefaultResource(R.drawable.pic_live_honor);
            eVar.f64912g.setDefaultResource(R.drawable.pic_live_honor);
            eVar.l.setDefaultResource(R.drawable.pic_live_honor);
        }
        SkinManager.setBackgroundColor(eVar.p, R.color.CAM_X0204);
    }

    public void d(List<d.a.p0.v.j.g.c.c.c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
            return;
        }
        List<d.a.p0.v.j.g.c.c.a> list2 = this.f64898f;
        if (list2 != null && list2.size() > 0) {
            this.f64898f.clear();
        }
        this.f64898f = b(list);
        notifyDataSetChanged();
    }

    public final void e(TbImageView tbImageView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbImageView, i2) == null) || tbImageView == null) {
            return;
        }
        if (i2 == 0) {
            tbImageView.setAlpha(0.5f);
        } else if (i2 == 3) {
            tbImageView.setAlpha(0.2f);
        } else {
            tbImageView.setAlpha(1);
        }
    }

    public final void f(TextView textView, boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{textView, Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            if (z) {
                textView.setVisibility(0);
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.f64897e.getResources().getDimensionPixelSize(R.dimen.ds24);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                textView.setCompoundDrawablePadding(this.f64897e.getResources().getDimensionPixelSize(R.dimen.ds4));
                textView.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                textView.setText(AlaStringHelper.formatLowercasekDou((float) j));
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void g(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, textView, i2) == null) || textView == null) {
            return;
        }
        if (i2 == 0) {
            textView.setText(R.string.ala_achievement_mark_status_unlock);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else if (i2 == 1) {
            textView.setText(R.string.ala_achievement_mark_status_wear);
            SkinManager.setViewTextColor(textView, R.color.live_cp_other_b);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
        } else if (i2 == 2) {
            textView.setText(R.string.ala_achievement_mark_status_lock);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
        } else if (i2 == 3) {
            textView.setText(R.string.ala_achievement_mark_status_expired);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else {
            textView.setVisibility(4);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<d.a.p0.v.j.g.c.c.a> list = this.f64898f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            List<d.a.p0.v.j.g.c.c.a> list = this.f64898f;
            if (list == null || i2 >= list.size()) {
                return null;
            }
            return this.f64898f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            d.a.p0.v.j.g.c.c.a aVar = this.f64898f.get(i2);
            if (view == null) {
                view = LayoutInflater.from(this.f64897e.getPageActivity()).inflate(R.layout.ala_achievement_mark_list_item_line_layout, viewGroup, false);
                eVar = new e(this, null);
                eVar.f64906a = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv0);
                eVar.f64907b = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv0);
                eVar.f64908c = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv0);
                eVar.f64909d = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper0);
                eVar.f64910e = (TextView) view.findViewById(R.id.ala_achievement_mark_price0);
                eVar.f64911f = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv1);
                eVar.f64912g = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv1);
                eVar.f64913h = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv1);
                eVar.f64914i = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper1);
                eVar.j = (TextView) view.findViewById(R.id.ala_achievement_mark_price1);
                eVar.k = (TextView) view.findViewById(R.id.ala_achievement_mark_item_name_tv2);
                eVar.l = (TbImageView) view.findViewById(R.id.ala_achievement_mark_item_iv2);
                eVar.m = (TextView) view.findViewById(R.id.ala_achievement_mark_item_status_tv2);
                eVar.n = (RelativeLayout) view.findViewById(R.id.ala_achievement_mark_item_wrapper2);
                eVar.o = (TextView) view.findViewById(R.id.ala_achievement_mark_price2);
                eVar.p = view.findViewById(R.id.ala_achievement_mark_item_line);
                eVar.q = (TextView) view.findViewById(R.id.ala_achievement_mark_item_main_title_tv);
            } else {
                eVar = (e) view.getTag();
            }
            c(eVar);
            if (aVar != null) {
                if (aVar.b(0) != null) {
                    d.a.p0.v.j.g.c.c.b b2 = aVar.b(0);
                    eVar.f64909d.setVisibility(0);
                    eVar.f64906a.setText(b2.e() == null ? "" : b2.e());
                    if (b2.f() != null) {
                        eVar.f64907b.setDefaultBgResource(R.color.transparent);
                        eVar.f64907b.M(b2.f(), 10, false);
                    }
                    g(eVar.f64908c, b2.j());
                    e(eVar.f64907b, b2.j());
                    f(eVar.f64910e, b2.m(), b2.n);
                    eVar.f64909d.setOnClickListener(new a(this, aVar));
                } else {
                    eVar.f64909d.setVisibility(4);
                    eVar.f64909d.setOnClickListener(null);
                }
                if (aVar.b(1) != null) {
                    d.a.p0.v.j.g.c.c.b b3 = aVar.b(1);
                    eVar.f64914i.setVisibility(0);
                    eVar.f64911f.setText(b3.e() == null ? "" : b3.e());
                    if (b3.f() != null) {
                        eVar.f64912g.setDefaultBgResource(R.color.transparent);
                        eVar.f64912g.M(b3.f(), 10, false);
                    }
                    g(eVar.f64913h, b3.j());
                    e(eVar.f64912g, b3.j());
                    f(eVar.j, b3.m(), b3.n);
                    eVar.f64914i.setOnClickListener(new View$OnClickListenerC1783b(this, aVar));
                } else {
                    eVar.f64914i.setVisibility(4);
                    eVar.f64914i.setOnClickListener(null);
                }
                if (aVar.b(2) != null) {
                    d.a.p0.v.j.g.c.c.b b4 = aVar.b(2);
                    eVar.n.setVisibility(0);
                    eVar.k.setText(b4.e() != null ? b4.e() : "");
                    if (b4.f() != null) {
                        eVar.l.setDefaultBgResource(R.color.transparent);
                        eVar.l.M(b4.f(), 10, false);
                    }
                    g(eVar.m, b4.j());
                    e(eVar.l, b4.j());
                    f(eVar.o, b4.m(), b4.n);
                    eVar.n.setOnClickListener(new c(this, aVar));
                } else {
                    eVar.n.setVisibility(4);
                    eVar.n.setOnClickListener(null);
                }
                if (aVar.d() != 3 && aVar.d() != 1) {
                    eVar.p.setVisibility(8);
                } else {
                    eVar.p.setVisibility(0);
                }
                if ((aVar.d() == 1 || aVar.d() == 2) && aVar.c() != null) {
                    eVar.q.setVisibility(0);
                    eVar.q.setText(aVar.c());
                } else {
                    eVar.q.setVisibility(8);
                }
            }
            view.setTag(eVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
