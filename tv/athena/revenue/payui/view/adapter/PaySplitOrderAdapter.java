package tv.athena.revenue.payui.view.adapter;

import android.app.Activity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.wba;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes9.dex */
public class PaySplitOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public List<SplitRecordItem> b;
    public PayUIKitConfig c;
    public c d;

    /* loaded from: classes9.dex */
    public interface c {
        void a(SplitRecordItem splitRecordItem);

        void b(SplitRecordItem splitRecordItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes9.dex */
    public class SplitOrderItemViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public TextView c;
        public View d;
        public View e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SplitOrderItemViewHolder(PaySplitOrderAdapter paySplitOrderAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paySplitOrderAdapter, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view2.findViewById(R.id.tv_num);
            this.b = (TextView) view2.findViewById(R.id.btn_pay);
            this.c = (TextView) view2.findViewById(R.id.tv_link);
            this.d = view2.findViewById(R.id.rl_amount);
            this.e = view2.findViewById(R.id.rl_link);
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SplitRecordItem a;
        public final /* synthetic */ PaySplitOrderAdapter b;

        public a(PaySplitOrderAdapter paySplitOrderAdapter, SplitRecordItem splitRecordItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paySplitOrderAdapter, splitRecordItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = paySplitOrderAdapter;
            this.a = splitRecordItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (cVar = this.b.d) != null) {
                cVar.a(this.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SplitRecordItem a;
        public final /* synthetic */ PaySplitOrderAdapter b;

        public b(PaySplitOrderAdapter paySplitOrderAdapter, SplitRecordItem splitRecordItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paySplitOrderAdapter, splitRecordItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = paySplitOrderAdapter;
            this.a = splitRecordItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (cVar = this.b.d) != null) {
                cVar.b(this.a);
            }
        }
    }

    public PaySplitOrderAdapter(Activity activity, List<SplitRecordItem> list, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, list, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.a = activity;
        this.b = list;
        this.c = payUIKitConfig;
    }

    public SplitRecordItem d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<SplitRecordItem> list = this.b;
            if (list != null && !list.isEmpty() && i >= 0 && i < this.b.size()) {
                return this.b.get(i);
            }
            return null;
        }
        return (SplitRecordItem) invokeI.objValue;
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.d = cVar;
        }
    }

    public final void f(SplitOrderItemViewHolder splitOrderItemViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, splitOrderItemViewHolder, i) == null) {
            SplitRecordItem d = d(i);
            if (d == null) {
                RLog.error("PaySplitOrderAdapter", "updateSplitOrderItemHolder error splitRecordItem null", new Object[0]);
                return;
            }
            int i2 = d.type;
            if (i2 == 2) {
                splitOrderItemViewHolder.e.setVisibility(0);
                splitOrderItemViewHolder.d.setVisibility(8);
                splitOrderItemViewHolder.c.setText(d.name);
                splitOrderItemViewHolder.itemView.setOnClickListener(new a(this, d));
            } else if (i2 == 1) {
                splitOrderItemViewHolder.e.setVisibility(8);
                splitOrderItemViewHolder.d.setVisibility(0);
                TextView textView = splitOrderItemViewHolder.a;
                textView.setText("¥ " + d.value);
                splitOrderItemViewHolder.itemView.setOnClickListener(null);
                splitOrderItemViewHolder.b.setOnClickListener(new b(this, d));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i) == null) && (viewHolder instanceof SplitOrderItemViewHolder)) {
            f((SplitOrderItemViewHolder) viewHolder, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            return new SplitOrderItemViewHolder(this, LayoutInflater.from(new ContextThemeWrapper(this.a, wba.a.a(this.c))).inflate(R.layout.pay_ui_item_pay_split_order_item_layout, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
