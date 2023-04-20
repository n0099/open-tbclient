package tv.athena.revenue.payui.view.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.fab;
import com.baidu.tieba.g9b;
import com.baidu.tieba.gab;
import com.baidu.tieba.hab;
import com.baidu.tieba.n7b;
import com.baidu.tieba.r9b;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagTagInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes9.dex */
public class PayAmountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Activity a;
    public int b;
    public int d;
    public n7b e;
    public List<g9b> f;
    public PayUIKitConfig h;
    public int c = -1;
    public String g = "Y币";
    public b i = null;

    /* loaded from: classes9.dex */
    public interface b {
        void a(View view2, int i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* loaded from: classes9.dex */
    public class AmountViewHolder extends RecyclerView.ViewHolder {
        public TextView a;
        public TextView b;
        public View c;
        public TextView d;
        public View e;
        public TextView f;
        public TextView g;
        public TextView h;

        public AmountViewHolder(PayAmountAdapter payAmountAdapter, View view2) {
            super(view2);
            this.a = (TextView) view2.findViewById(R.id.tv_dest_amount);
            this.b = (TextView) view2.findViewById(R.id.tv_amount_unit);
            this.c = view2.findViewById(R.id.amount_new_rl);
            this.d = (TextView) view2.findViewById(R.id.amount_new);
            this.e = view2.findViewById(R.id.ll_dest_amount_container);
            this.f = (TextView) view2.findViewById(R.id.tv_other_amount);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092540);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092601);
        }
    }

    /* loaded from: classes9.dex */
    public class CampaignViewHolder extends RecyclerView.ViewHolder {
        public ViewGroup a;
        public ImageView b;
        public ImageView c;
        public ImageView d;
        public TextView e;
        public ImageView f;

        public CampaignViewHolder(PayAmountAdapter payAmountAdapter, View view2) {
            super(view2);
            this.a = (ViewGroup) view2.findViewById(R.id.ll_container);
            this.b = (ImageView) view2.findViewById(R.id.img_top_index);
            this.c = (ImageView) view2.findViewById(R.id.img_bottom_index);
            this.d = (ImageView) view2.findViewById(R.id.img_center_left_log);
            this.e = (TextView) view2.findViewById(R.id.tv_center_top_title);
            this.f = (ImageView) view2.findViewById(R.id.img_center_right_log);
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ AmountViewHolder a;

        public a(AmountViewHolder amountViewHolder) {
            this.a = amountViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b bVar = PayAmountAdapter.this.i;
            if (bVar != null) {
                AmountViewHolder amountViewHolder = this.a;
                bVar.a(amountViewHolder.itemView, amountViewHolder.getAdapterPosition());
            }
        }
    }

    public PayAmountAdapter(Activity activity, n7b n7bVar, List<g9b> list, PayUIKitConfig payUIKitConfig) {
        this.a = activity;
        this.f = list;
        this.h = payUIKitConfig;
        this.e = n7bVar;
    }

    public final void A(CampaignViewHolder campaignViewHolder, int i) {
        boolean z;
        g9b k = k(i);
        if (k == null) {
            return;
        }
        if (this.c >= 0 && k.e >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            t(campaignViewHolder, k, i);
        } else {
            n(campaignViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof AmountViewHolder) {
            x((AmountViewHolder) viewHolder, i);
        } else if (viewHolder instanceof CampaignViewHolder) {
            A((CampaignViewHolder) viewHolder, i);
        }
    }

    public final void x(AmountViewHolder amountViewHolder, int i) {
        g9b k = k(i);
        if (k == null) {
            return;
        }
        B(amountViewHolder, k, i);
        C(amountViewHolder, k);
        D(amountViewHolder, k);
        amountViewHolder.itemView.setOnClickListener(new a(amountViewHolder));
    }

    public final void B(AmountViewHolder amountViewHolder, g9b g9bVar, int i) {
        if (g9bVar.c) {
            amountViewHolder.f.setVisibility(0);
            amountViewHolder.e.setVisibility(8);
            amountViewHolder.d.setVisibility(8);
            return;
        }
        amountViewHolder.f.setVisibility(8);
        amountViewHolder.e.setVisibility(0);
        amountViewHolder.d.setVisibility(0);
        amountViewHolder.a.setText(gab.b(g9bVar.a()));
        amountViewHolder.b.setText(this.g);
        amountViewHolder.d.setVisibility(0);
        Double valueOf = Double.valueOf(g9bVar.c());
        if (valueOf == null) {
            amountViewHolder.d.setText("");
        } else {
            amountViewHolder.d.setText(String.format(this.a.getResources().getString(R.string.pay_ui_str_pay_amount_text_yuan), gab.a(valueOf.doubleValue())));
        }
        if (this.b == i) {
            amountViewHolder.c.setSelected(true);
            amountViewHolder.a.setSelected(true);
            amountViewHolder.b.setSelected(true);
            return;
        }
        amountViewHolder.c.setSelected(false);
        amountViewHolder.a.setSelected(false);
        amountViewHolder.b.setSelected(false);
    }

    public final void C(AmountViewHolder amountViewHolder, g9b g9bVar) {
        List<GiftBagsInfo> list;
        ProductInfo productInfo = g9bVar.a;
        if (productInfo != null && (list = productInfo.giftbags) != null && !list.isEmpty()) {
            String str = g9bVar.a.giftbags.get(0).offersTips;
            if (TextUtils.isEmpty(str)) {
                amountViewHolder.g.setVisibility(8);
                return;
            }
            amountViewHolder.g.setVisibility(0);
            amountViewHolder.g.setText(str);
            return;
        }
        amountViewHolder.g.setVisibility(8);
    }

    public final void D(AmountViewHolder amountViewHolder, g9b g9bVar) {
        List<GiftBagTagInfo> list;
        ProductInfo productInfo = g9bVar.a;
        if (productInfo != null && (list = productInfo.giftBagTagInfos) != null && !list.isEmpty()) {
            String str = g9bVar.a.giftBagTagInfos.get(0).tag;
            if (TextUtils.isEmpty(str)) {
                amountViewHolder.h.setVisibility(8);
                return;
            }
            amountViewHolder.h.setVisibility(0);
            amountViewHolder.h.setText(str);
            return;
        }
        amountViewHolder.h.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.a, hab.a.a(this.h));
        if (i == 2) {
            return new CampaignViewHolder(this, LayoutInflater.from(contextThemeWrapper).inflate(R.layout.pay_ui_item_pay_amount_campaign_item_layout, viewGroup, false));
        }
        return new AmountViewHolder(this, LayoutInflater.from(contextThemeWrapper).inflate(R.layout.pay_ui_item_pay_amount_choose_item_layout, viewGroup, false));
    }

    public int getCount() {
        return this.f.size();
    }

    public List<g9b> getData() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f.size();
    }

    public g9b l() {
        int i;
        if (this.b < getCount() && (i = this.b) >= 0) {
            return k(i);
        }
        return null;
    }

    public int m() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        g9b k = k(i);
        if (k != null && k.d) {
            return 2;
        }
        return 1;
    }

    public g9b k(int i) {
        List<g9b> list = this.f;
        if (list != null && !list.isEmpty() && i >= 0 && i < this.f.size()) {
            return this.f.get(i);
        }
        return null;
    }

    public final void n(CampaignViewHolder campaignViewHolder) {
        campaignViewHolder.c.setVisibility(8);
        campaignViewHolder.b.setVisibility(8);
        campaignViewHolder.itemView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        campaignViewHolder.itemView.setVisibility(8);
    }

    public void o(int i) {
        this.c = i;
    }

    public void p(String str) {
        this.g = str;
    }

    public void q(b bVar) {
        this.i = bVar;
    }

    public void r(int i) {
        this.b = i;
    }

    public void s(int i) {
        this.d = i;
    }

    public final void t(CampaignViewHolder campaignViewHolder, g9b g9bVar, int i) {
        y(campaignViewHolder, g9bVar, i);
        z(campaignViewHolder, g9bVar, i);
    }

    public void u(int i) {
        int i2;
        if (getData() != null && !getData().isEmpty() && (i2 = this.c) >= 0 && i2 < getData().size() && getData().get(this.c).d) {
            getData().get(this.c).e = i;
            notifyDataSetChanged();
        }
    }

    public final void y(CampaignViewHolder campaignViewHolder, g9b g9bVar, int i) {
        int i2;
        int i3;
        int i4 = -1;
        campaignViewHolder.itemView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        campaignViewHolder.itemView.setVisibility(0);
        int b2 = (fab.b(this.a) - r9b.a(((this.d - 1) * 10) + 30)) / this.d;
        int a2 = r9b.a(11.0f);
        if (this.d == 2) {
            i2 = 4;
        } else {
            i2 = 6;
        }
        int i5 = g9bVar.e;
        if (i5 <= this.c) {
            campaignViewHolder.c.setVisibility(8);
            campaignViewHolder.b.setVisibility(0);
            i4 = g9bVar.e;
            int a3 = ((b2 / 2) - a2) + ((r9b.a(10.0f) + b2) * i4);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) campaignViewHolder.b.getLayoutParams();
            layoutParams.leftMargin = a3;
            campaignViewHolder.b.setLayoutParams(layoutParams);
            this.e.c(campaignViewHolder.a, this.a);
        } else if (i5 <= i2) {
            campaignViewHolder.c.setVisibility(0);
            campaignViewHolder.b.setVisibility(8);
            int i6 = this.c;
            if (i6 == 2) {
                i3 = g9bVar.e - 3;
            } else {
                if (i6 == 3) {
                    i3 = g9bVar.e - 4;
                }
                int a4 = ((b2 / 2) - a2) + ((r9b.a(10.0f) + b2) * i4);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) campaignViewHolder.c.getLayoutParams();
                layoutParams2.leftMargin = a4;
                campaignViewHolder.c.setLayoutParams(layoutParams2);
                this.e.c(campaignViewHolder.a, this.a);
            }
            i4 = i3;
            int a42 = ((b2 / 2) - a2) + ((r9b.a(10.0f) + b2) * i4);
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) campaignViewHolder.c.getLayoutParams();
            layoutParams22.leftMargin = a42;
            campaignViewHolder.c.setLayoutParams(layoutParams22);
            this.e.c(campaignViewHolder.a, this.a);
        } else {
            RLog.error("PayAmountAdapter", "updateCampaignItemIndexView error config", new Object[0]);
            n(campaignViewHolder);
        }
        RLog.info("PayAmountAdapter", "updateCampaignItemIndexView position:" + i + " selectCampaignIndex:" + g9bVar.e + " itemWidth:" + b2 + " mCampaignItemPosition:" + this.c + " startIndexOfLine:" + i4 + " maxValidSelectCampaignIndex:" + i2);
    }

    public final void z(CampaignViewHolder campaignViewHolder, g9b g9bVar, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (hab.a.b(this.h)) {
            i2 = R.drawable.pay_ui_item_pay_amount_campaign_item_center_top_red_icon;
        } else {
            i2 = R.drawable.pay_ui_item_pay_amount_campaign_item_center_top_yellow_icon;
        }
        if (hab.a.b(this.h)) {
            i3 = R.drawable.pay_ui_item_pay_amount_campaign_item_center_right_red_icon;
        } else {
            i3 = R.drawable.pay_ui_item_pay_amount_campaign_item_center_right_yellow_icon;
        }
        if (hab.a.b(this.h)) {
            i4 = R.drawable.pay_ui_item_pay_amount_campaign_item_top_index_red_icon;
        } else {
            i4 = R.drawable.pay_ui_item_pay_amount_campaign_item_top_index_yellow_icon;
        }
        if (hab.a.b(this.h)) {
            i5 = R.drawable.pay_ui_item_pay_amount_campaign_item_bottom_index_red_icon;
        } else {
            i5 = R.drawable.pay_ui_item_pay_amount_campaign_item_bottom_index_yellow_icon;
        }
        campaignViewHolder.b.setBackgroundResource(i4);
        campaignViewHolder.c.setBackgroundResource(i5);
        campaignViewHolder.d.setImageResource(i2);
        campaignViewHolder.f.setImageResource(i3);
        GiftBagsInfo a2 = this.e.a();
        if (a2 == null) {
            campaignViewHolder.e.setVisibility(4);
            return;
        }
        String str = a2.giftbagTitle;
        if (TextUtils.isEmpty(str)) {
            campaignViewHolder.e.setVisibility(4);
            return;
        }
        campaignViewHolder.e.setVisibility(0);
        campaignViewHolder.e.setText(str);
    }
}
