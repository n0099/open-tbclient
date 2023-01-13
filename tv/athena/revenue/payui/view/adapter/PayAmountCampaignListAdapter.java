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
    public PayUIKitConfig b;
    public Context c;
    public b d;

    /* loaded from: classes9.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ PayAmountCampaignListAdapter b;

        public a(PayAmountCampaignListAdapter payAmountCampaignListAdapter, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountCampaignListAdapter, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = payAmountCampaignListAdapter;
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.d != null) {
                this.b.d.a(this.a.getAdapterPosition());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public ImageView c;
        public TextView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PayAmountCampaignListAdapter payAmountCampaignListAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountCampaignListAdapter, view2};
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
            this.a = (TextView) view2.findViewById(R.id.tv_name);
            this.b = (TextView) view2.findViewById(R.id.tv_num);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f52);
            this.d = (TextView) view2.findViewById(R.id.tv_type);
        }
    }

    public PayAmountCampaignListAdapter(Context context, List list, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.c = context;
        this.b = payUIKitConfig;
    }

    public GiftBagItemInfo e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<GiftBagItemInfo> list = this.a;
            if (list != null && !list.isEmpty() && i >= 0 && i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (GiftBagItemInfo) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, i) == null) {
            cVar.itemView.setOnClickListener(new a(this, cVar));
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
            return new c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pay_ui_item_pay_amount_campaign_list_item, viewGroup, false));
        }
        return (c) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }
}
