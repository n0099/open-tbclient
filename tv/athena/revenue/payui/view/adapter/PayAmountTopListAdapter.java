package tv.athena.revenue.payui.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import i.a.a.e.d;
import i.a.a.e.e;
import java.util.List;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes3.dex */
public class PayAmountTopListAdapter extends RecyclerView.Adapter<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<GiftBagItemInfo> f73188a;

    /* renamed from: b  reason: collision with root package name */
    public PayUIKitConfig f73189b;

    /* renamed from: c  reason: collision with root package name */
    public Context f73190c;

    /* renamed from: d  reason: collision with root package name */
    public b f73191d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f73192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PayAmountTopListAdapter f73193f;

        public a(PayAmountTopListAdapter payAmountTopListAdapter, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountTopListAdapter, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73193f = payAmountTopListAdapter;
            this.f73192e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f73193f.f73191d == null) {
                return;
            }
            this.f73193f.f73191d.onClick(this.f73192e.getAdapterPosition());
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onClick(int i2);
    }

    /* loaded from: classes3.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f73194a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f73195b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f73196c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PayAmountTopListAdapter payAmountTopListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountTopListAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73194a = (TextView) view.findViewById(d.tv_name);
            this.f73195b = (TextView) view.findViewById(d.tv_num);
            this.f73196c = (ImageView) view.findViewById(d.img);
        }
    }

    public PayAmountTopListAdapter(Context context, List list, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73188a = list;
        this.f73190c = context;
        this.f73189b = payUIKitConfig;
    }

    public GiftBagItemInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<GiftBagItemInfo> list = this.f73188a;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f73188a.size()) {
                return null;
            }
            return this.f73188a.get(i2);
        }
        return (GiftBagItemInfo) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f73188a.size() : invokeV.intValue;
    }

    public void setOnItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f73191d = bVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, cVar, i2) == null) {
            cVar.itemView.setOnClickListener(new a(this, cVar));
            GiftBagItemInfo item = getItem(cVar.getAdapterPosition());
            cVar.f73194a.setText(item.name);
            if (item.count == 0) {
                cVar.f73195b.setVisibility(4);
            } else {
                cVar.f73195b.setVisibility(0);
                TextView textView = cVar.f73195b;
                textView.setText("x" + item.count);
            }
            PayUIKitConfig payUIKitConfig = this.f73189b;
            if (payUIKitConfig == null && payUIKitConfig.imageLoaderSupplier == null) {
                RLog.error("PayAmountTopListAdapter", "onBindViewHolder error mPayUIKitConfig null", new Object[0]);
                return;
            }
            this.f73189b.imageLoaderSupplier.onLoad(this.f73190c, cVar.f73196c, new ImageLoaderSupplier.ImageParam(item.imgUrl, -1, -1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) ? new c(this, LayoutInflater.from(viewGroup.getContext()).inflate(e.pay_ui_item_pay_amount_top_list, viewGroup, false)) : (c) invokeLI.objValue;
    }
}
