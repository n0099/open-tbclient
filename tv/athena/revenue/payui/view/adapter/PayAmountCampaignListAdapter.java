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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import java.util.List;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes9.dex */
public class PayAmountCampaignListAdapter extends RecyclerView.Adapter<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<GiftBagItemInfo> a;

    /* renamed from: b  reason: collision with root package name */
    public PayUIKitConfig f61566b;

    /* renamed from: c  reason: collision with root package name */
    public Context f61567c;

    /* renamed from: d  reason: collision with root package name */
    public b f61568d;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61569e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PayAmountCampaignListAdapter f61570f;

        public a(PayAmountCampaignListAdapter payAmountCampaignListAdapter, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountCampaignListAdapter, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61570f = payAmountCampaignListAdapter;
            this.f61569e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f61570f.f61568d == null) {
                return;
            }
            this.f61570f.f61568d.onClick(this.f61569e.getAdapterPosition());
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onClick(int i2);
    }

    /* loaded from: classes9.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61571b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f61572c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61573d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PayAmountCampaignListAdapter payAmountCampaignListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountCampaignListAdapter, view};
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
            this.a = (TextView) view.findViewById(R.id.tv_name);
            this.f61571b = (TextView) view.findViewById(R.id.tv_num);
            this.f61572c = (ImageView) view.findViewById(R.id.img);
            this.f61573d = (TextView) view.findViewById(R.id.tv_type);
        }
    }

    public PayAmountCampaignListAdapter(Context context, List list, PayUIKitConfig payUIKitConfig) {
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
        this.a = list;
        this.f61567c = context;
        this.f61566b = payUIKitConfig;
    }

    public GiftBagItemInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<GiftBagItemInfo> list = this.a;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.a.size()) {
                return null;
            }
            return this.a.get(i2);
        }
        return (GiftBagItemInfo) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    public void setOnItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f61568d = bVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, cVar, i2) == null) {
            cVar.itemView.setOnClickListener(new a(this, cVar));
            GiftBagItemInfo item = getItem(cVar.getAdapterPosition());
            if (TextUtils.isEmpty(item.name)) {
                cVar.a.setVisibility(4);
            } else {
                cVar.a.setVisibility(0);
                cVar.a.setText(item.name);
            }
            if (!TextUtils.isEmpty(item.countDisplay) && !StringUtil.NULL_STRING.equals(item.countDisplay)) {
                cVar.f61571b.setVisibility(0);
                cVar.f61571b.setText(item.countDisplay);
            } else {
                cVar.f61571b.setVisibility(4);
            }
            if (!TextUtils.isEmpty(item.typeName) && !StringUtil.NULL_STRING.equals(item.typeName)) {
                cVar.f61573d.setVisibility(0);
                cVar.f61573d.setText(item.typeName);
            } else {
                cVar.f61573d.setVisibility(4);
            }
            PayUIKitConfig payUIKitConfig = this.f61566b;
            if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
                this.f61566b.imageLoaderSupplier.onLoad(this.f61567c, cVar.f61572c, new ImageLoaderSupplier.ImageParam(item.imgUrl, -1, -1));
                return;
            }
            RLog.error("PayAmountCampaignListAdapter", "onBindViewHolder error mPayUIKitConfig null", new Object[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) ? new c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pay_ui_item_pay_amount_campaign_list_item, viewGroup, false)) : (c) invokeLI.objValue;
    }
}
