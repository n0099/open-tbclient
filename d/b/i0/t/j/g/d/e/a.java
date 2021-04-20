package d.b.i0.t.j.g.d.e;

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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f62535a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62536b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62537c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62538d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62539e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62540f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f62541g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f62542h;
    public TextView i;
    public b j;
    public AlaEnterEffectData k;
    public Context l;

    /* renamed from: d.b.i0.t.j.g.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1630a implements View.OnClickListener {
        public View$OnClickListenerC1630a() {
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
        this.f62535a = relativeLayout;
        this.f62536b = (TextView) relativeLayout.findViewById(R.id.effet_name_tv);
        this.f62537c = (TextView) this.f62535a.findViewById(R.id.left_time_tv);
        this.f62538d = (TextView) this.f62535a.findViewById(R.id.live_room_tv);
        this.f62539e = (TextView) this.f62535a.findViewById(R.id.confirm_button_tv);
        this.f62540f = (TextView) this.f62535a.findViewById(R.id.t_dou_price);
        this.f62541g = (LinearLayout) this.f62535a.findViewById(R.id.t_dou_price_layout);
        this.f62542h = (LinearLayout) this.f62535a.findViewById(R.id.cur_t_dou_layout);
        this.i = (TextView) this.f62535a.findViewById(R.id.cur_t_dou);
        c(alaEnterEffectData);
    }

    public RelativeLayout b() {
        return this.f62535a;
    }

    public void c(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData == null) {
            return;
        }
        this.k = alaEnterEffectData;
        this.f62539e.setEnabled(true);
        int i = this.k.categoryType;
        if (3 != i) {
            if (2 == i) {
                this.f62539e.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                this.f62539e.setTextColor(this.l.getResources().getColor(R.color.CAM_X0201));
                this.f62541g.setVisibility(0);
                this.f62540f.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                Drawable drawable = this.l.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                int dimensionPixelSize = this.l.getResources().getDimensionPixelSize(R.dimen.ds36);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.f62540f.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds12));
                this.f62540f.setCompoundDrawables(drawable, null, null, null);
                this.f62542h.setVisibility(0);
                this.i.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                Drawable drawable2 = this.l.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                int dimensionPixelSize2 = this.l.getResources().getDimensionPixelSize(R.dimen.ds24);
                drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.i.setCompoundDrawablePadding(this.l.getResources().getDimensionPixelSize(R.dimen.ds4));
                this.i.setCompoundDrawables(drawable2, null, null, null);
            } else {
                this.f62538d.setVisibility(0);
                this.f62539e.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                this.f62539e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
            }
        }
        AlaEnterEffectData alaEnterEffectData2 = this.k;
        if (alaEnterEffectData2.isOwn) {
            if (alaEnterEffectData2.isUsing()) {
                this.f62539e.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                this.f62539e.setTextColor(this.l.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                this.f62539e.setText(R.string.ala_stop_use);
                if (2 == this.k.categoryType) {
                    this.f62542h.setVisibility(8);
                }
            } else {
                this.f62539e.setText(R.string.ala_immediate_use);
            }
        } else {
            int i2 = alaEnterEffectData2.categoryType;
            if (3 == i2) {
                this.f62539e.setText(R.string.ala_nobility_open);
                this.f62537c.setText(this.l.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == i2) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.k.price) {
                    this.f62539e.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.f62539e.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.f62539e.setBackgroundDrawable(null);
                this.f62539e.setTextColor(this.l.getResources().getColor(R.color.white_alpha60));
                this.f62539e.setText(R.string.ala_enter_effect_not_own);
                this.f62539e.setEnabled(false);
            }
        }
        this.f62539e.setOnClickListener(new View$OnClickListenerC1630a());
        if (!StringUtils.isNull(alaEnterEffectData.name)) {
            this.f62536b.setText(alaEnterEffectData.name);
        }
        long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            this.f62537c.setText(this.l.getResources().getString(R.string.ala_left_time, StringHelper.formatDayOrHourTime(currentTimeMillis)));
        }
        if (StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
            return;
        }
        this.f62538d.setText(alaEnterEffectData.effect_range_name);
    }

    public void d(String str) {
        TextView textView;
        AlaEnterEffectData alaEnterEffectData = this.k;
        if (alaEnterEffectData == null || 2 != alaEnterEffectData.categoryType || (textView = this.f62539e) == null) {
            return;
        }
        textView.setText(str);
    }

    public void e(b bVar) {
        this.j = bVar;
    }
}
