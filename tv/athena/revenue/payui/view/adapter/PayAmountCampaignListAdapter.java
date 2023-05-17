package tv.athena.revenue.payui.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.R;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import java.util.List;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes2.dex */
public class PayAmountCampaignListAdapter extends RecyclerView.Adapter<c> {
    public List<GiftBagItemInfo> a;
    public PayUIKitConfig b;
    public Context c;
    public b d;

    /* loaded from: classes2.dex */
    public interface b {
        void onClick(int i);
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ c a;

        public a(c cVar) {
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (PayAmountCampaignListAdapter.this.d != null) {
                PayAmountCampaignListAdapter.this.d.onClick(this.a.getAdapterPosition());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends RecyclerView.ViewHolder {
        public TextView a;
        public TextView b;
        public ImageView c;
        public TextView d;

        public c(PayAmountCampaignListAdapter payAmountCampaignListAdapter, View view2) {
            super(view2);
            this.a = (TextView) view2.findViewById(R.id.tv_name);
            this.b = (TextView) view2.findViewById(R.id.tv_num);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091066);
            this.d = (TextView) view2.findViewById(R.id.tv_type);
        }
    }

    public PayAmountCampaignListAdapter(Context context, List list, PayUIKitConfig payUIKitConfig) {
        this.a = list;
        this.c = context;
        this.b = payUIKitConfig;
    }

    public GiftBagItemInfo l(int i) {
        List<GiftBagItemInfo> list = this.a;
        if (list != null && !list.isEmpty() && i >= 0 && i < this.a.size()) {
            return this.a.get(i);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(c cVar, int i) {
        cVar.itemView.setOnClickListener(new a(cVar));
        GiftBagItemInfo l = l(cVar.getAdapterPosition());
        if (TextUtils.isEmpty(l.name)) {
            cVar.a.setVisibility(4);
        } else {
            cVar.a.setVisibility(0);
            cVar.a.setText(l.name);
        }
        if (!TextUtils.isEmpty(l.countDisplay) && !StringUtil.NULL_STRING.equals(l.countDisplay)) {
            cVar.b.setVisibility(0);
            cVar.b.setText(l.countDisplay);
        } else {
            cVar.b.setVisibility(4);
        }
        if (!TextUtils.isEmpty(l.typeName) && !StringUtil.NULL_STRING.equals(l.typeName)) {
            cVar.d.setVisibility(0);
            cVar.d.setText(l.typeName);
        } else {
            cVar.d.setVisibility(4);
        }
        PayUIKitConfig payUIKitConfig = this.b;
        if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
            this.b.imageLoaderSupplier.onLoad(this.c, cVar.c, new ImageLoaderSupplier.ImageParam(l.imgUrl, -1, -1));
            return;
        }
        RLog.error("PayAmountCampaignListAdapter", "onBindViewHolder error mPayUIKitConfig null", new Object[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pay_ui_item_pay_amount_campaign_list_item, viewGroup, false));
    }
}
