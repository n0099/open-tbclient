package d.a.k0.t.j.g.d.e;

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
    public RelativeLayout f61883a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f61884b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61885c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61886d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61887e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61888f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f61889g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f61890h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f61891i;
    public b j;
    public AlaEnterEffectData k;
    public Context l;

    /* renamed from: d.a.k0.t.j.g.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1658a implements View.OnClickListener {
        public View$OnClickListenerC1658a() {
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
        this.f61883a = relativeLayout;
        this.f61884b = (TextView) relativeLayout.findViewById(R.id.effet_name_tv);
        this.f61885c = (TextView) this.f61883a.findViewById(R.id.left_time_tv);
        this.f61886d = (TextView) this.f61883a.findViewById(R.id.live_room_tv);
        this.f61887e = (TextView) this.f61883a.findViewById(R.id.confirm_button_tv);
        this.f61888f = (TextView) this.f61883a.findViewById(R.id.t_dou_price);
        this.f61889g = (LinearLayout) this.f61883a.findViewById(R.id.t_dou_price_layout);
        this.f61890h = (LinearLayout) this.f61883a.findViewById(R.id.cur_t_dou_layout);
        this.f61891i = (TextView) this.f61883a.findViewById(R.id.cur_t_dou);
        c(alaEnterEffectData);
    }

    public RelativeLayout b() {
        return this.f61883a;
    }

    public void c(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData == null) {
            return;
        }
        this.k = alaEnterEffectData;
        this.f61887e.setEnabled(true);
        int i2 = this.k.categoryType;
        if (3 != i2) {
            if (2 == i2) {
                this.f61887e.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                this.f61887e.setTextColor(this.l.getResources().getColor(R.color.CAM_X0201));
                this.f61889g.setVisibility(0);
                this.f61888f.setText(AlaStringHelper.formatLowercasekDou((float) alaEnterEffectData.price));
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.l.getResources().getDimensionPixelSize(R.dimen.ds36);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.f61888f.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds12));
                this.f61888f.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                this.f61890h.setVisibility(0);
                this.f61891i.setText(AlaStringHelper.formatLowercasekDou((float) TbadkCoreApplication.getInst().currentAccountTdouNum));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.l.getResources().getDimensionPixelSize(R.dimen.ds24);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f61891i.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds4));
                this.f61891i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
            } else {
                this.f61886d.setVisibility(0);
                this.f61887e.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                this.f61887e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
            }
        }
        AlaEnterEffectData alaEnterEffectData2 = this.k;
        if (alaEnterEffectData2.isOwn) {
            if (alaEnterEffectData2.isUsing()) {
                this.f61887e.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                this.f61887e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                this.f61887e.setText(R.string.ala_stop_use);
                if (2 == this.k.categoryType) {
                    this.f61890h.setVisibility(8);
                }
            } else {
                this.f61887e.setText(R.string.ala_immediate_use);
            }
        } else {
            int i3 = alaEnterEffectData2.categoryType;
            if (3 == i3) {
                this.f61887e.setText(R.string.ala_nobility_open);
                this.f61885c.setText(this.l.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == i3) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.k.price) {
                    this.f61887e.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.f61887e.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.f61887e.setBackgroundDrawable(null);
                this.f61887e.setTextColor(this.l.getResources().getColor(R.color.white_alpha60));
                this.f61887e.setText(R.string.ala_enter_effect_not_own);
                this.f61887e.setEnabled(false);
            }
        }
        this.f61887e.setOnClickListener(new View$OnClickListenerC1658a());
        if (!StringUtils.isNull(alaEnterEffectData.name)) {
            this.f61884b.setText(alaEnterEffectData.name);
        }
        long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            this.f61885c.setText(this.l.getResources().getString(R.string.ala_left_time, StringHelper.formatDayOrHourTime(currentTimeMillis)));
        }
        if (StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
            return;
        }
        this.f61886d.setText(alaEnterEffectData.effect_range_name);
    }

    public void d(String str) {
        TextView textView;
        AlaEnterEffectData alaEnterEffectData = this.k;
        if (alaEnterEffectData == null || 2 != alaEnterEffectData.categoryType || (textView = this.f61887e) == null) {
            return;
        }
        textView.setText(str);
    }

    public void e(b bVar) {
        this.j = bVar;
    }
}
