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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagTagInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import j.a.a.e.e;
import j.a.a.e.f;
import j.a.a.e.g;
import j.a.a.e.h;
import j.a.a.e.m.d;
import j.a.a.e.n.c;
import j.a.a.e.p.m;
import j.a.a.e.p.n;
import j.a.a.e.p.o;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes5.dex */
public class PayAmountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_AMOUNT = 1;
    public static final int TYPE_CAMPAIGN = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;

    /* renamed from: b  reason: collision with root package name */
    public int f65448b;

    /* renamed from: c  reason: collision with root package name */
    public int f65449c;

    /* renamed from: d  reason: collision with root package name */
    public int f65450d;

    /* renamed from: e  reason: collision with root package name */
    public d f65451e;

    /* renamed from: f  reason: collision with root package name */
    public List<c> f65452f;

    /* renamed from: g  reason: collision with root package name */
    public String f65453g;

    /* renamed from: h  reason: collision with root package name */
    public PayUIKitConfig f65454h;
    public b mOnItemClickListener;

    /* loaded from: classes5.dex */
    public class AmountViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView amountText;
        public View amoutNewLayout;
        public TextView destAmount;
        public View destAmountContainer;
        public TextView destUnit;
        public TextView tvOtherAmount;
        public TextView tvTags;
        public TextView tvTips;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AmountViewHolder(PayAmountAdapter payAmountAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountAdapter, view};
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
            this.destAmount = (TextView) view.findViewById(f.tv_dest_amount);
            this.destUnit = (TextView) view.findViewById(f.tv_amount_unit);
            this.amoutNewLayout = view.findViewById(f.amount_new_rl);
            this.amountText = (TextView) view.findViewById(f.amount_new);
            this.destAmountContainer = view.findViewById(f.ll_dest_amount_container);
            this.tvOtherAmount = (TextView) view.findViewById(f.tv_other_amount);
            this.tvTips = (TextView) view.findViewById(f.tvTips);
            this.tvTags = (TextView) view.findViewById(f.tv_tag);
        }
    }

    /* loaded from: classes5.dex */
    public class CampaignViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView imgBottomIndex;
        public ImageView imgCenterLeftLog;
        public ImageView imgCenterRightLog;
        public ImageView imgTopIndex;
        public ViewGroup ll_container;
        public TextView tvCenterTopTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CampaignViewHolder(PayAmountAdapter payAmountAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountAdapter, view};
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
            this.ll_container = (ViewGroup) view.findViewById(f.ll_container);
            this.imgTopIndex = (ImageView) view.findViewById(f.img_top_index);
            this.imgBottomIndex = (ImageView) view.findViewById(f.img_bottom_index);
            this.imgCenterLeftLog = (ImageView) view.findViewById(f.img_center_left_log);
            this.tvCenterTopTitle = (TextView) view.findViewById(f.tv_center_top_title);
            this.imgCenterRightLog = (ImageView) view.findViewById(f.img_center_right_log);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AmountViewHolder f65455e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PayAmountAdapter f65456f;

        public a(PayAmountAdapter payAmountAdapter, AmountViewHolder amountViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountAdapter, amountViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65456f = payAmountAdapter;
            this.f65455e = amountViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = this.f65456f.mOnItemClickListener) == null) {
                return;
            }
            AmountViewHolder amountViewHolder = this.f65455e;
            bVar.a(amountViewHolder.itemView, amountViewHolder.getAdapterPosition());
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, int i2);
    }

    public PayAmountAdapter(Activity activity, d dVar, List<c> list, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dVar, list, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65449c = -1;
        this.f65453g = "Y币";
        this.mOnItemClickListener = null;
        this.a = activity;
        this.f65452f = list;
        this.f65454h = payUIKitConfig;
        this.f65451e = dVar;
    }

    public final void a(CampaignViewHolder campaignViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, campaignViewHolder) == null) {
            campaignViewHolder.imgBottomIndex.setVisibility(8);
            campaignViewHolder.imgTopIndex.setVisibility(8);
            campaignViewHolder.itemView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            campaignViewHolder.itemView.setVisibility(8);
        }
    }

    public final void b(CampaignViewHolder campaignViewHolder, c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, campaignViewHolder, cVar, i2) == null) {
            d(campaignViewHolder, cVar, i2);
            e(campaignViewHolder, cVar, i2);
        }
    }

    public final void c(AmountViewHolder amountViewHolder, int i2) {
        c item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, amountViewHolder, i2) == null) || (item = getItem(i2)) == null) {
            return;
        }
        g(amountViewHolder, item, i2);
        h(amountViewHolder, item);
        i(amountViewHolder, item);
        amountViewHolder.itemView.setOnClickListener(new a(this, amountViewHolder));
    }

    public final void d(CampaignViewHolder campaignViewHolder, c cVar, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, campaignViewHolder, cVar, i2) == null) {
            int i4 = -1;
            campaignViewHolder.itemView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            campaignViewHolder.itemView.setVisibility(0);
            int b2 = (m.b(this.a) - j.a.a.e.p.c.a(((this.f65450d - 1) * 10) + 30)) / this.f65450d;
            int a2 = j.a.a.e.p.c.a(11.0f);
            int i5 = this.f65450d == 2 ? 4 : 6;
            int i6 = cVar.f64779e;
            if (i6 <= this.f65449c) {
                campaignViewHolder.imgBottomIndex.setVisibility(8);
                campaignViewHolder.imgTopIndex.setVisibility(0);
                i4 = cVar.f64779e;
                int a3 = ((b2 / 2) - a2) + ((j.a.a.e.p.c.a(10.0f) + b2) * i4);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) campaignViewHolder.imgTopIndex.getLayoutParams();
                layoutParams.leftMargin = a3;
                campaignViewHolder.imgTopIndex.setLayoutParams(layoutParams);
                this.f65451e.c(campaignViewHolder.ll_container, this.a);
            } else if (i6 <= i5) {
                campaignViewHolder.imgBottomIndex.setVisibility(0);
                campaignViewHolder.imgTopIndex.setVisibility(8);
                int i7 = this.f65449c;
                if (i7 == 2) {
                    i3 = cVar.f64779e - 3;
                } else {
                    if (i7 == 3) {
                        i3 = cVar.f64779e - 4;
                    }
                    int a4 = ((b2 / 2) - a2) + ((j.a.a.e.p.c.a(10.0f) + b2) * i4);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) campaignViewHolder.imgBottomIndex.getLayoutParams();
                    layoutParams2.leftMargin = a4;
                    campaignViewHolder.imgBottomIndex.setLayoutParams(layoutParams2);
                    this.f65451e.c(campaignViewHolder.ll_container, this.a);
                }
                i4 = i3;
                int a42 = ((b2 / 2) - a2) + ((j.a.a.e.p.c.a(10.0f) + b2) * i4);
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) campaignViewHolder.imgBottomIndex.getLayoutParams();
                layoutParams22.leftMargin = a42;
                campaignViewHolder.imgBottomIndex.setLayoutParams(layoutParams22);
                this.f65451e.c(campaignViewHolder.ll_container, this.a);
            } else {
                RLog.error("PayAmountAdapter", "updateCampaignItemIndexView error config", new Object[0]);
                a(campaignViewHolder);
            }
            RLog.info("PayAmountAdapter", "updateCampaignItemIndexView position:" + i2 + " selectCampaignIndex:" + cVar.f64779e + " itemWidth:" + b2 + " mCampaignItemPosition:" + this.f65449c + " startIndexOfLine:" + i4 + " maxValidSelectCampaignIndex:" + i5);
        }
    }

    public final void e(CampaignViewHolder campaignViewHolder, c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, campaignViewHolder, cVar, i2) == null) {
            int i3 = o.a.b(this.f65454h) ? e.pay_ui_item_pay_amount_campaign_item_center_top_red_icon : e.pay_ui_item_pay_amount_campaign_item_center_top_yellow_icon;
            int i4 = o.a.b(this.f65454h) ? e.pay_ui_item_pay_amount_campaign_item_center_right_red_icon : e.pay_ui_item_pay_amount_campaign_item_center_right_yellow_icon;
            int i5 = o.a.b(this.f65454h) ? e.pay_ui_item_pay_amount_campaign_item_top_index_red_icon : e.pay_ui_item_pay_amount_campaign_item_top_index_yellow_icon;
            int i6 = o.a.b(this.f65454h) ? e.pay_ui_item_pay_amount_campaign_item_bottom_index_red_icon : e.pay_ui_item_pay_amount_campaign_item_bottom_index_yellow_icon;
            campaignViewHolder.imgTopIndex.setBackgroundResource(i5);
            campaignViewHolder.imgBottomIndex.setBackgroundResource(i6);
            campaignViewHolder.imgCenterLeftLog.setImageResource(i3);
            campaignViewHolder.imgCenterRightLog.setImageResource(i4);
            GiftBagsInfo a2 = this.f65451e.a();
            if (a2 == null) {
                campaignViewHolder.tvCenterTopTitle.setVisibility(4);
                return;
            }
            String str = a2.giftbagTitle;
            if (TextUtils.isEmpty(str)) {
                campaignViewHolder.tvCenterTopTitle.setVisibility(4);
                return;
            }
            campaignViewHolder.tvCenterTopTitle.setVisibility(0);
            campaignViewHolder.tvCenterTopTitle.setText(str);
        }
    }

    public final void f(CampaignViewHolder campaignViewHolder, int i2) {
        c item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, campaignViewHolder, i2) == null) || (item = getItem(i2)) == null) {
            return;
        }
        if (this.f65449c >= 0 && item.f64779e >= 0) {
            b(campaignViewHolder, item, i2);
        } else {
            a(campaignViewHolder);
        }
    }

    public final void g(AmountViewHolder amountViewHolder, c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, amountViewHolder, cVar, i2) == null) {
            if (cVar.f64777c) {
                amountViewHolder.tvOtherAmount.setVisibility(0);
                amountViewHolder.destAmountContainer.setVisibility(8);
                amountViewHolder.amountText.setVisibility(8);
                return;
            }
            amountViewHolder.tvOtherAmount.setVisibility(8);
            amountViewHolder.destAmountContainer.setVisibility(0);
            amountViewHolder.amountText.setVisibility(0);
            amountViewHolder.destAmount.setText(n.b(cVar.a()));
            amountViewHolder.destUnit.setText(this.f65453g);
            amountViewHolder.amountText.setVisibility(0);
            Double valueOf = Double.valueOf(cVar.b());
            if (valueOf == null) {
                amountViewHolder.amountText.setText("");
            } else {
                amountViewHolder.amountText.setText(String.format(this.a.getResources().getString(h.pay_ui_str_pay_amount_text_yuan), n.a(valueOf.doubleValue())));
            }
            if (this.f65448b == i2) {
                amountViewHolder.amoutNewLayout.setSelected(true);
                amountViewHolder.destAmount.setSelected(true);
                amountViewHolder.destUnit.setSelected(true);
                return;
            }
            amountViewHolder.amoutNewLayout.setSelected(false);
            amountViewHolder.destAmount.setSelected(false);
            amountViewHolder.destUnit.setSelected(false);
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f65452f.size() : invokeV.intValue;
    }

    public List<c> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f65452f : (List) invokeV.objValue;
    }

    public c getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            List<c> list = this.f65452f;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f65452f.size()) {
                return null;
            }
            return this.f65452f.get(i2);
        }
        return (c) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f65452f.size() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            c item = getItem(i2);
            return (item == null || !item.f64778d) ? 1 : 2;
        }
        return invokeI.intValue;
    }

    public c getSelectedItem() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f65448b >= getCount() || (i2 = this.f65448b) < 0) {
                return null;
            }
            return getItem(i2);
        }
        return (c) invokeV.objValue;
    }

    public int getSelectedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f65448b : invokeV.intValue;
    }

    public final void h(AmountViewHolder amountViewHolder, c cVar) {
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, amountViewHolder, cVar) == null) {
            ProductInfo productInfo = cVar.a;
            if (productInfo != null && (list = productInfo.giftbags) != null && !list.isEmpty()) {
                String str = cVar.a.giftbags.get(0).offersTips;
                if (TextUtils.isEmpty(str)) {
                    amountViewHolder.tvTips.setVisibility(8);
                    return;
                }
                amountViewHolder.tvTips.setVisibility(0);
                amountViewHolder.tvTips.setText(str);
                return;
            }
            amountViewHolder.tvTips.setVisibility(8);
        }
    }

    public final void i(AmountViewHolder amountViewHolder, c cVar) {
        List<GiftBagTagInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, amountViewHolder, cVar) == null) {
            ProductInfo productInfo = cVar.a;
            if (productInfo != null && (list = productInfo.giftBagTagInfos) != null && !list.isEmpty()) {
                String str = cVar.a.giftBagTagInfos.get(0).tag;
                if (TextUtils.isEmpty(str)) {
                    amountViewHolder.tvTags.setVisibility(8);
                    return;
                }
                amountViewHolder.tvTags.setVisibility(0);
                amountViewHolder.tvTags.setText(str);
                return;
            }
            amountViewHolder.tvTags.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, viewHolder, i2) == null) {
            if (viewHolder instanceof AmountViewHolder) {
                c((AmountViewHolder) viewHolder, i2);
            } else if (viewHolder instanceof CampaignViewHolder) {
                f((CampaignViewHolder) viewHolder, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, viewGroup, i2)) == null) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.a, o.a.a(this.f65454h));
            if (i2 == 2) {
                return new CampaignViewHolder(this, LayoutInflater.from(contextThemeWrapper).inflate(g.pay_ui_item_pay_amount_campaign_item_layout, viewGroup, false));
            }
            return new AmountViewHolder(this, LayoutInflater.from(contextThemeWrapper).inflate(g.pay_ui_item_pay_amount_choose_item_layout, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setCampaignItemPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f65449c = i2;
        }
    }

    public void setCurrencyName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f65453g = str;
        }
    }

    public void setOnItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.mOnItemClickListener = bVar;
        }
    }

    public void setSelectedPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f65448b = i2;
        }
    }

    public void setSpanCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f65450d = i2;
        }
    }

    public void uopdateCampaignSelectIndex(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || getData() == null || getData().isEmpty() || (i3 = this.f65449c) < 0 || i3 >= getData().size() || !getData().get(this.f65449c).f64778d) {
            return;
        }
        getData().get(this.f65449c).f64779e = i2;
        notifyDataSetChanged();
    }
}
