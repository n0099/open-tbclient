package tv.athena.revenue.payui.view.adapter;

import android.app.Activity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.qlc;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes2.dex */
public class PaySplitOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Activity a;
    public List<SplitRecordItem> b;
    public PayUIKitConfig c;
    public c d = null;

    /* loaded from: classes2.dex */
    public interface c {
        void a(SplitRecordItem splitRecordItem);

        void b(SplitRecordItem splitRecordItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* loaded from: classes2.dex */
    public class SplitOrderItemViewHolder extends RecyclerView.ViewHolder {
        public TextView a;
        public TextView b;
        public TextView c;
        public View d;
        public View e;

        public SplitOrderItemViewHolder(PaySplitOrderAdapter paySplitOrderAdapter, View view2) {
            super(view2);
            this.a = (TextView) view2.findViewById(R.id.tv_num);
            this.b = (TextView) view2.findViewById(R.id.btn_pay);
            this.c = (TextView) view2.findViewById(R.id.tv_link);
            this.d = view2.findViewById(R.id.rl_amount);
            this.e = view2.findViewById(R.id.rl_link);
        }
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ SplitRecordItem a;

        public a(SplitRecordItem splitRecordItem) {
            this.a = splitRecordItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c cVar = PaySplitOrderAdapter.this.d;
            if (cVar != null) {
                cVar.a(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ SplitRecordItem a;

        public b(SplitRecordItem splitRecordItem) {
            this.a = splitRecordItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c cVar = PaySplitOrderAdapter.this.d;
            if (cVar != null) {
                cVar.b(this.a);
            }
        }
    }

    public PaySplitOrderAdapter(Activity activity, List<SplitRecordItem> list, PayUIKitConfig payUIKitConfig) {
        this.a = activity;
        this.b = list;
        this.c = payUIKitConfig;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    public SplitRecordItem l(int i) {
        List<SplitRecordItem> list = this.b;
        if (list != null && !list.isEmpty() && i >= 0 && i < this.b.size()) {
            return this.b.get(i);
        }
        return null;
    }

    public void m(c cVar) {
        this.d = cVar;
    }

    public final void n(SplitOrderItemViewHolder splitOrderItemViewHolder, int i) {
        SplitRecordItem l = l(i);
        if (l == null) {
            RLog.error("PaySplitOrderAdapter", "updateSplitOrderItemHolder error splitRecordItem null", new Object[0]);
            return;
        }
        int i2 = l.type;
        if (i2 == 2) {
            splitOrderItemViewHolder.e.setVisibility(0);
            splitOrderItemViewHolder.d.setVisibility(8);
            splitOrderItemViewHolder.c.setText(l.name);
            splitOrderItemViewHolder.itemView.setOnClickListener(new a(l));
        } else if (i2 == 1) {
            splitOrderItemViewHolder.e.setVisibility(8);
            splitOrderItemViewHolder.d.setVisibility(0);
            TextView textView = splitOrderItemViewHolder.a;
            textView.setText("¥ " + l.value);
            splitOrderItemViewHolder.itemView.setOnClickListener(null);
            splitOrderItemViewHolder.b.setOnClickListener(new b(l));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof SplitOrderItemViewHolder) {
            n((SplitOrderItemViewHolder) viewHolder, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SplitOrderItemViewHolder(this, LayoutInflater.from(new ContextThemeWrapper(this.a, qlc.a.a(this.c))).inflate(R.layout.pay_ui_item_pay_split_order_item_layout, viewGroup, false));
    }
}
