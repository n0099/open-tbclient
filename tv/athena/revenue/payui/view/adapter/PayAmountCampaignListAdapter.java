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
/* loaded from: classes9.dex */
public class PayAmountCampaignListAdapter extends RecyclerView.Adapter<c> {
    public List<GiftBagItemInfo> a;
    public PayUIKitConfig b;
    public Context c;
    public b d;

    /* loaded from: classes9.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ c a;

        public a(c cVar) {
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (PayAmountCampaignListAdapter.this.d != null) {
                PayAmountCampaignListAdapter.this.d.a(this.a.getAdapterPosition());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends RecyclerView.ViewHolder {
        public TextView a;
        public TextView b;
        public ImageView c;
        public TextView d;

        public c(PayAmountCampaignListAdapter payAmountCampaignListAdapter, View view2) {
            super(view2);
            this.a = (TextView) view2.findViewById(R.id.tv_name);
            this.b = (TextView) view2.findViewById(R.id.tv_num);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09101a);
            this.d = (TextView) view2.findViewById(R.id.tv_type);
        }
    }

    public PayAmountCampaignListAdapter(Context context, List list, PayUIKitConfig payUIKitConfig) {
        this.a = list;
        this.c = context;
        this.b = payUIKitConfig;
    }

    public GiftBagItemInfo e(int i) {
        List<GiftBagItemInfo> list = this.a;
        if (list != null && !list.isEmpty() && i >= 0 && i < this.a.size()) {
            return this.a.get(i);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(c cVar, int i) {
        cVar.itemView.setOnClickListener(new a(cVar));
        GiftBagItemInfo e = e(cVar.getAdapterPosition());
        if (TextUtils.isEmpty(e.name)) {
            cVar.a.setVisibility(4);
        } else {
            cVar.a.setVisibility(0);
            cVar.a.setText(e.name);
        }
        if (!TextUtils.isEmpty(e.countDisplay) && !StringUtil.NULL_STRING.equals(e.countDisplay)) {
            cVar.b.setVisibility(0);
            cVar.b.setText(e.countDisplay);
        } else {
            cVar.b.setVisibility(4);
        }
        if (!TextUtils.isEmpty(e.typeName) && !StringUtil.NULL_STRING.equals(e.typeName)) {
            cVar.d.setVisibility(0);
            cVar.d.setText(e.typeName);
        } else {
            cVar.d.setVisibility(4);
        }
        PayUIKitConfig payUIKitConfig = this.b;
        if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
            this.b.imageLoaderSupplier.onLoad(this.c, cVar.c, new ImageLoaderSupplier.ImageParam(e.imgUrl, -1, -1));
            return;
        }
        RLog.error("PayAmountCampaignListAdapter", "onBindViewHolder error mPayUIKitConfig null", new Object[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pay_ui_item_pay_amount_campaign_list_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }
}
