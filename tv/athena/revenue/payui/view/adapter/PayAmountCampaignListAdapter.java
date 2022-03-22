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
/* loaded from: classes8.dex */
public class PayAmountCampaignListAdapter extends RecyclerView.Adapter<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<GiftBagItemInfo> a;

    /* renamed from: b  reason: collision with root package name */
    public PayUIKitConfig f45910b;

    /* renamed from: c  reason: collision with root package name */
    public Context f45911c;

    /* renamed from: d  reason: collision with root package name */
    public b f45912d;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PayAmountCampaignListAdapter f45913b;

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
            this.f45913b = payAmountCampaignListAdapter;
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45913b.f45912d == null) {
                return;
            }
            this.f45913b.f45912d.onClick(this.a.getAdapterPosition());
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onClick(int i);
    }

    /* loaded from: classes8.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45914b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f45915c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f45916d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PayAmountCampaignListAdapter payAmountCampaignListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountCampaignListAdapter, view};
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
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921db);
            this.f45914b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921e1);
            this.f45915c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090e94);
            this.f45916d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092224);
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
        this.f45911c = context;
        this.f45910b = payUIKitConfig;
    }

    public GiftBagItemInfo e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<GiftBagItemInfo> list = this.a;
            if (list == null || list.isEmpty() || i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
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
            GiftBagItemInfo e2 = e(cVar.getAdapterPosition());
            if (TextUtils.isEmpty(e2.name)) {
                cVar.a.setVisibility(4);
            } else {
                cVar.a.setVisibility(0);
                cVar.a.setText(e2.name);
            }
            if (!TextUtils.isEmpty(e2.countDisplay) && !StringUtil.NULL_STRING.equals(e2.countDisplay)) {
                cVar.f45914b.setVisibility(0);
                cVar.f45914b.setText(e2.countDisplay);
            } else {
                cVar.f45914b.setVisibility(4);
            }
            if (!TextUtils.isEmpty(e2.typeName) && !StringUtil.NULL_STRING.equals(e2.typeName)) {
                cVar.f45916d.setVisibility(0);
                cVar.f45916d.setText(e2.typeName);
            } else {
                cVar.f45916d.setVisibility(4);
            }
            PayUIKitConfig payUIKitConfig = this.f45910b;
            if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
                this.f45910b.imageLoaderSupplier.onLoad(this.f45911c, cVar.f45915c, new ImageLoaderSupplier.ImageParam(e2.imgUrl, -1, -1));
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
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) ? new c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0662, viewGroup, false)) : (c) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.size() : invokeV.intValue;
    }
}
