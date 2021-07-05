package d.a.s0.d0;

import android.content.ClipboardManager;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.b1.d;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.s0.d0.a> f58127e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f58128f;

    /* renamed from: g  reason: collision with root package name */
    public int f58129g;

    /* loaded from: classes9.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.d0.a f58130e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f58131f;

        public a(c cVar, d.a.s0.d0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58131f = cVar;
            this.f58130e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                String h2 = this.f58130e.h();
                if (StringUtils.isNull(h2)) {
                    return false;
                }
                ClipboardManager clipboardManager = (ClipboardManager) this.f58131f.f58128f.getPageActivity().getSystemService("clipboard");
                clipboardManager.setText(h2);
                if (clipboardManager.getText() != null) {
                    l.L(this.f58131f.f58128f.getPageActivity(), R.string.copy_to_clip);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.d0.a f58132e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f58133f;

        public b(c cVar, d.a.s0.d0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58133f = cVar;
            this.f58132e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f58133f.f58128f, new String[]{this.f58132e.c()});
            }
        }
    }

    /* renamed from: d.a.s0.d0.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1361c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f58134a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f58135b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58136c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58137d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58138e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f58139f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f58140g;

        /* renamed from: h  reason: collision with root package name */
        public View f58141h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f58142i;
        public TextView j;

        public C1361c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58128f = tbPageContext;
        this.f58129g = i2;
    }

    public final SpannableString b(int i2, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2, AbsoluteSizeSpan absoluteSizeSpan, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, Integer.valueOf(i3)})) == null) {
            String string = this.f58128f.getString(i2);
            String formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i3, j);
            String str = string + "    [icon]" + formatOverBaiwanNum;
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
            Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon(i3);
            int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
            moneyIcon.setBounds(0, 0, g2, g2);
            d dVar = new d(moneyIcon);
            dVar.b(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString c(int i2, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), foregroundColorSpan, foregroundColorSpan2})) == null) {
            String string = this.f58128f.getString(i2);
            String long2String = StringHelper.long2String(j, "yyyy-MM-dd HH:mm");
            String str = string + "    " + long2String;
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, str, long2String, foregroundColorSpan2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString d(int i2, String str, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, foregroundColorSpan, foregroundColorSpan2})) == null) {
            String str2 = this.f58128f.getString(i2) + "    " + str;
            SpannableString spannableString = new SpannableString(str2);
            UtilHelper.setSpan(spannableString, str2, str2, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, str2, str, foregroundColorSpan2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final void e(C1361c c1361c, d.a.s0.d0.a aVar) {
        SpannableString spannableString;
        SpannableString spannableString2;
        SpannableString spannableString3;
        SpannableString spannableString4;
        String l;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, c1361c, aVar) == null) || c1361c == null || aVar == null) {
            return;
        }
        c1361c.f58140g.setText(this.f58128f.getString(R.string.order_id) + "    ");
        c1361c.f58134a.setText(aVar.h());
        c1361c.f58134a.setOnLongClickListener(new a(this, aVar));
        if (aVar.k() == 1) {
            c1361c.f58135b.M(String.valueOf(R.drawable.icon_payment_success), 24, false);
            SkinManager.setViewTextColor(c1361c.f58135b, R.color.CAM_X0305, 1);
        } else {
            c1361c.f58135b.M(String.valueOf(R.drawable.icon_payment_fail), 24, false);
            SkinManager.setViewTextColor(c1361c.f58135b, R.color.CAM_X0109, 1);
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105));
        new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(24, true);
        int i4 = this.f58129g;
        if (i4 == 1) {
            SpannableString d2 = d(R.string.buy_product, aVar.l(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(R.string.consumption_t_bean, aVar.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, aVar.e());
            spannableString = c(R.string.buy_time, aVar.d(), foregroundColorSpan, foregroundColorSpan2);
            spannableString4 = d2;
            spannableString2 = null;
        } else if (i4 == 2) {
            SpannableString d3 = d(R.string.get_with_product, aVar.l(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(CurrencySwitchUtil.isYyIsConvert(aVar.e()) ? R.string.get_y_bean : R.string.get_t_bean, aVar.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, aVar.e());
            spannableString = c(R.string.buy_time, aVar.d(), foregroundColorSpan, foregroundColorSpan2);
            String str = "" + aVar.j();
            String str2 = this.f58128f.getString(R.string.alternative_account) + "    " + str;
            SpannableString spannableString5 = new SpannableString(str2);
            UtilHelper.setSpan(spannableString5, str2, str2, foregroundColorSpan);
            UtilHelper.setSpan(spannableString5, str2, str, foregroundColorSpan2);
            spannableString2 = spannableString5;
            spannableString4 = d3;
        } else if (i4 == 3) {
            String string = this.f58128f.getString(R.string.recharge_product);
            if (CurrencySwitchUtil.isYyIsConvert(aVar.e())) {
                l = String.format(this.f58128f.getString(R.string.ydou_rmb), g(Double.valueOf(aVar.i())));
            } else {
                l = aVar.l();
            }
            String str3 = string + "    " + l;
            spannableString4 = new SpannableString(str3);
            UtilHelper.setSpan(spannableString4, str3, str3, foregroundColorSpan);
            UtilHelper.setSpan(spannableString4, str3, l, foregroundColorSpan2);
            String str4 = ("" + aVar.g()) + this.f58128f.getString(R.string.recharge_use_money);
            String str5 = this.f58128f.getString(R.string.recharge_money) + "    " + str4;
            SpannableString spannableString6 = new SpannableString(str5);
            UtilHelper.setSpan(spannableString6, str5, str5, foregroundColorSpan);
            UtilHelper.setSpan(spannableString6, str5, str4, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString6, str5, str4, absoluteSizeSpan);
            spannableString3 = spannableString6;
            SpannableString c2 = c(R.string.recharge_time, aVar.f(), foregroundColorSpan, foregroundColorSpan2);
            String str6 = "" + aVar.j();
            String str7 = this.f58128f.getString(R.string.recharge_account) + "    " + str6;
            spannableString2 = new SpannableString(str7);
            UtilHelper.setSpan(spannableString2, str7, str7, foregroundColorSpan);
            UtilHelper.setSpan(spannableString2, str7, str6, foregroundColorSpan2);
            spannableString = c2;
        } else {
            spannableString = null;
            spannableString2 = null;
            spannableString3 = null;
            spannableString4 = null;
        }
        c1361c.f58136c.setText(spannableString4);
        c1361c.f58137d.setText(spannableString3);
        c1361c.f58138e.setText(spannableString);
        if (!StringUtils.isNull(aVar.j()) && ((i3 = this.f58129g) == 3 || i3 == 2)) {
            c1361c.f58139f.setVisibility(0);
            c1361c.f58139f.setText(spannableString2);
        } else {
            c1361c.f58139f.setVisibility(8);
        }
        if (!StringUtils.isNull(aVar.b())) {
            c1361c.f58142i.setText(aVar.b());
            if (!StringUtils.isNull(aVar.a())) {
                c1361c.j.setText(aVar.a());
                i2 = 0;
                c1361c.j.setVisibility(0);
            } else {
                i2 = 0;
                c1361c.j.setVisibility(8);
            }
            c1361c.j.setOnClickListener(new b(this, aVar));
            c1361c.f58141h.setVisibility(i2);
            return;
        }
        c1361c.f58141h.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public d.a.s0.d0.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<d.a.s0.d0.a> arrayList = this.f58127e;
            if (arrayList == null || arrayList.size() <= 0 || i2 < 0 || i2 >= getCount()) {
                return null;
            }
            return this.f58127e.get(i2);
        }
        return (d.a.s0.d0.a) invokeI.objValue;
    }

    public final String g(Double d2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d2)) == null) {
            if (d2.doubleValue() == d2.intValue()) {
                return d2.intValue() + "";
            }
            return d2 + "";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<d.a.s0.d0.a> arrayList = this.f58127e;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
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
        C1361c c1361c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            d.a.s0.d0.a item = getItem(i2);
            if (view != null) {
                c1361c = (C1361c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f58128f.getPageActivity()).inflate(R.layout.records_item_layout, viewGroup, false);
                c1361c = new C1361c();
                c1361c.f58134a = (TextView) view.findViewById(R.id.order_id_textview);
                c1361c.f58135b = (TbImageView) view.findViewById(R.id.order_status_textview);
                c1361c.f58136c = (TextView) view.findViewById(R.id.order_title_textview);
                c1361c.f58137d = (TextView) view.findViewById(R.id.order_price_textview);
                c1361c.f58140g = (TextView) view.findViewById(R.id.order_id_tip);
                c1361c.f58139f = (TextView) view.findViewById(R.id.order_account_textview);
                c1361c.f58138e = (TextView) view.findViewById(R.id.order_time_textview);
                c1361c.f58141h = view.findViewById(R.id.order_activity_content);
                c1361c.f58142i = (TextView) view.findViewById(R.id.activity_desc_textview);
                c1361c.j = (TextView) view.findViewById(R.id.activity_button_textview);
                view.setTag(c1361c);
            }
            e(c1361c, item);
            this.f58128f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(ArrayList<d.a.s0.d0.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.f58127e = arrayList;
        }
    }
}
