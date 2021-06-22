package d.a.o0.v.j.g.d.e;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f66011a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f66012b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66013c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66014d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66015e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66016f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f66017g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f66018h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f66019i;
    public b j;
    public AlaEnterEffectData k;
    public Context l;

    /* renamed from: d.a.o0.v.j.g.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1739a implements View.OnClickListener {
        public View$OnClickListenerC1739a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.j != null) {
                a.this.j.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData == null || context == null) {
            return;
        }
        this.l = context;
        this.k = alaEnterEffectData;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
        this.f66011a = relativeLayout;
        this.f66012b = (TextView) relativeLayout.findViewById(R.id.effet_name_tv);
        this.f66013c = (TextView) this.f66011a.findViewById(R.id.left_time_tv);
        this.f66014d = (TextView) this.f66011a.findViewById(R.id.live_room_tv);
        this.f66015e = (TextView) this.f66011a.findViewById(R.id.confirm_button_tv);
        this.f66016f = (TextView) this.f66011a.findViewById(R.id.t_dou_price);
        this.f66017g = (LinearLayout) this.f66011a.findViewById(R.id.t_dou_price_layout);
        this.f66018h = (LinearLayout) this.f66011a.findViewById(R.id.cur_t_dou_layout);
        this.f66019i = (TextView) this.f66011a.findViewById(R.id.cur_t_dou);
        c(alaEnterEffectData);
    }

    public RelativeLayout b() {
        return this.f66011a;
    }

    public void c(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData == null) {
            return;
        }
        this.k = alaEnterEffectData;
        this.f66015e.setEnabled(true);
        int i2 = this.k.categoryType;
        if (3 != i2) {
            if (2 == i2) {
                this.f66015e.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                this.f66015e.setTextColor(this.l.getResources().getColor(R.color.CAM_X0201));
                this.f66017g.setVisibility(0);
                this.f66016f.setText(AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price));
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.l.getResources().getDimensionPixelSize(R.dimen.ds36);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.f66016f.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds12));
                this.f66016f.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.f66018h.setVisibility(0);
                this.f66019i.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.l.getResources().getDimensionPixelSize(R.dimen.ds24);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f66019i.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds4));
                this.f66019i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
            } else {
                this.f66014d.setVisibility(0);
                this.f66015e.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                this.f66015e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
            }
        }
        AlaEnterEffectData alaEnterEffectData2 = this.k;
        if (alaEnterEffectData2.isOwn) {
            if (alaEnterEffectData2.isUsing()) {
                this.f66015e.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                this.f66015e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                this.f66015e.setText(R.string.ala_stop_use);
                if (2 == this.k.categoryType) {
                    this.f66018h.setVisibility(8);
                }
            } else {
                this.f66015e.setText(R.string.ala_immediate_use);
            }
        } else {
            int i3 = alaEnterEffectData2.categoryType;
            if (3 == i3) {
                this.f66015e.setText(R.string.ala_nobility_open);
                this.f66013c.setText(this.l.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == i3) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.k.price) {
                    this.f66015e.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.f66015e.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.f66015e.setBackgroundDrawable(null);
                this.f66015e.setTextColor(this.l.getResources().getColor(R.color.white_alpha60));
                this.f66015e.setText(R.string.ala_enter_effect_not_own);
                this.f66015e.setEnabled(false);
            }
        }
        this.f66015e.setOnClickListener(new View$OnClickListenerC1739a());
        if (!StringUtils.isNull(alaEnterEffectData.name)) {
            this.f66012b.setText(alaEnterEffectData.name);
        }
        long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            this.f66013c.setText(this.l.getResources().getString(R.string.ala_left_time, StringHelper.formatDayOrHourTime(currentTimeMillis)));
        }
        if (StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
            return;
        }
        this.f66014d.setText(alaEnterEffectData.effect_range_name);
    }

    public void d(String str) {
        TextView textView;
        AlaEnterEffectData alaEnterEffectData = this.k;
        if (alaEnterEffectData == null || 2 != alaEnterEffectData.categoryType || (textView = this.f66015e) == null) {
            return;
        }
        textView.setText(str);
    }

    public void e(b bVar) {
        this.j = bVar;
    }
}
