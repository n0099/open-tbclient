package d.a.s0.v.j.g.d.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f68189a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f68190b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f68191c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f68192d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f68193e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f68194f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f68195g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f68196h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f68197i;
    public b j;
    public AlaEnterEffectData k;
    public Context l;

    /* renamed from: d.a.s0.v.j.g.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1830a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68198e;

        public View$OnClickListenerC1830a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68198e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f68198e.j == null) {
                return;
            }
            this.f68198e.j.a();
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, alaEnterEffectData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (alaEnterEffectData == null || context == null) {
            return;
        }
        this.l = context;
        this.k = alaEnterEffectData;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
        this.f68189a = relativeLayout;
        this.f68190b = (TextView) relativeLayout.findViewById(R.id.effet_name_tv);
        this.f68191c = (TextView) this.f68189a.findViewById(R.id.left_time_tv);
        this.f68192d = (TextView) this.f68189a.findViewById(R.id.live_room_tv);
        this.f68193e = (TextView) this.f68189a.findViewById(R.id.confirm_button_tv);
        this.f68194f = (TextView) this.f68189a.findViewById(R.id.t_dou_price);
        this.f68195g = (LinearLayout) this.f68189a.findViewById(R.id.t_dou_price_layout);
        this.f68196h = (LinearLayout) this.f68189a.findViewById(R.id.cur_t_dou_layout);
        this.f68197i = (TextView) this.f68189a.findViewById(R.id.cur_t_dou);
        c(alaEnterEffectData);
    }

    public RelativeLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68189a : (RelativeLayout) invokeV.objValue;
    }

    public void c(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaEnterEffectData) == null) || alaEnterEffectData == null) {
            return;
        }
        this.k = alaEnterEffectData;
        this.f68193e.setEnabled(true);
        int i2 = this.k.categoryType;
        if (3 != i2) {
            if (2 == i2) {
                this.f68193e.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                this.f68193e.setTextColor(this.l.getResources().getColor(R.color.CAM_X0201));
                this.f68195g.setVisibility(0);
                this.f68194f.setText(AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price));
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.l.getResources().getDimensionPixelSize(R.dimen.ds36);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.f68194f.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds12));
                this.f68194f.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.f68196h.setVisibility(0);
                this.f68197i.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.l.getResources().getDimensionPixelSize(R.dimen.ds24);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f68197i.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds4));
                this.f68197i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
            } else {
                this.f68192d.setVisibility(0);
                this.f68193e.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                this.f68193e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
            }
        }
        AlaEnterEffectData alaEnterEffectData2 = this.k;
        if (alaEnterEffectData2.isOwn) {
            if (alaEnterEffectData2.isUsing()) {
                this.f68193e.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                this.f68193e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                this.f68193e.setText(R.string.ala_stop_use);
                if (2 == this.k.categoryType) {
                    this.f68196h.setVisibility(8);
                }
            } else {
                this.f68193e.setText(R.string.ala_immediate_use);
            }
        } else {
            int i3 = alaEnterEffectData2.categoryType;
            if (3 == i3) {
                this.f68193e.setText(R.string.ala_nobility_open);
                this.f68191c.setText(this.l.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == i3) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.k.price) {
                    this.f68193e.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.f68193e.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.f68193e.setBackgroundDrawable(null);
                this.f68193e.setTextColor(this.l.getResources().getColor(R.color.white_alpha60));
                this.f68193e.setText(R.string.ala_enter_effect_not_own);
                this.f68193e.setEnabled(false);
            }
        }
        this.f68193e.setOnClickListener(new View$OnClickListenerC1830a(this));
        if (!StringUtils.isNull(alaEnterEffectData.name)) {
            this.f68190b.setText(alaEnterEffectData.name);
        }
        long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            this.f68191c.setText(this.l.getResources().getString(R.string.ala_left_time, StringHelper.formatDayOrHourTime(currentTimeMillis)));
        }
        if (StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
            return;
        }
        this.f68192d.setText(alaEnterEffectData.effect_range_name);
    }

    public void d(String str) {
        AlaEnterEffectData alaEnterEffectData;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (alaEnterEffectData = this.k) == null || 2 != alaEnterEffectData.categoryType || (textView = this.f68193e) == null) {
            return;
        }
        textView.setText(str);
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.j = bVar;
        }
    }
}
