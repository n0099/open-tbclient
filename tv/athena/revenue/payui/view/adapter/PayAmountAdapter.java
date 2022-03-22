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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagTagInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import h.a.a.e.e.d;
import h.a.a.e.f.c;
import h.a.a.e.h.m;
import h.a.a.e.h.n;
import h.a.a.e.h.o;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes8.dex */
public class PayAmountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;

    /* renamed from: b  reason: collision with root package name */
    public int f45890b;

    /* renamed from: c  reason: collision with root package name */
    public int f45891c;

    /* renamed from: d  reason: collision with root package name */
    public int f45892d;

    /* renamed from: e  reason: collision with root package name */
    public d f45893e;

    /* renamed from: f  reason: collision with root package name */
    public List<c> f45894f;

    /* renamed from: g  reason: collision with root package name */
    public String f45895g;

    /* renamed from: h  reason: collision with root package name */
    public PayUIKitConfig f45896h;
    public b i;

    /* loaded from: classes8.dex */
    public class AmountViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45897b;

        /* renamed from: c  reason: collision with root package name */
        public View f45898c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f45899d;

        /* renamed from: e  reason: collision with root package name */
        public View f45900e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f45901f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f45902g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f45903h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AmountViewHolder(PayAmountAdapter payAmountAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountAdapter, view};
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
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921a0);
            this.f45897b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09217f);
            this.f45898c = view.findViewById(R.id.obfuscated_res_0x7f090267);
            this.f45899d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090266);
            this.f45900e = view.findViewById(R.id.obfuscated_res_0x7f0912ef);
            this.f45901f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921e5);
            this.f45902g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092175);
            this.f45903h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092215);
        }
    }

    /* loaded from: classes8.dex */
    public class CampaignViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f45904b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f45905c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f45906d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f45907e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f45908f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CampaignViewHolder(PayAmountAdapter payAmountAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountAdapter, view};
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
            this.a = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f0912ec);
            this.f45904b = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090edd);
            this.f45905c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ea1);
            this.f45906d = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ea4);
            this.f45907e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09218f);
            this.f45908f = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ea5);
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AmountViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PayAmountAdapter f45909b;

        public a(PayAmountAdapter payAmountAdapter, AmountViewHolder amountViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountAdapter, amountViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45909b = payAmountAdapter;
            this.a = amountViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = this.f45909b.i) == null) {
                return;
            }
            AmountViewHolder amountViewHolder = this.a;
            bVar.a(amountViewHolder.itemView, amountViewHolder.getAdapterPosition());
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(View view, int i);
    }

    public PayAmountAdapter(Activity activity, d dVar, List<c> list, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dVar, list, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45891c = -1;
        this.f45895g = "Y币";
        this.i = null;
        this.a = activity;
        this.f45894f = list;
        this.f45896h = payUIKitConfig;
        this.f45893e = dVar;
    }

    public List<c> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45894f : (List) invokeV.objValue;
    }

    public c e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<c> list = this.f45894f;
            if (list == null || list.isEmpty() || i < 0 || i >= this.f45894f.size()) {
                return null;
            }
            return this.f45894f.get(i);
        }
        return (c) invokeI.objValue;
    }

    public c f() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f45890b >= getCount() || (i = this.f45890b) < 0) {
                return null;
            }
            return e(i);
        }
        return (c) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45890b : invokeV.intValue;
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45894f.size() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f45894f.size() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            c e2 = e(i);
            return (e2 == null || !e2.f45205d) ? 1 : 2;
        }
        return invokeI.intValue;
    }

    public final void h(CampaignViewHolder campaignViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, campaignViewHolder) == null) {
            campaignViewHolder.f45905c.setVisibility(8);
            campaignViewHolder.f45904b.setVisibility(8);
            campaignViewHolder.itemView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            campaignViewHolder.itemView.setVisibility(8);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f45891c = i;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f45895g = str;
        }
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f45890b = i;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f45892d = i;
        }
    }

    public final void n(CampaignViewHolder campaignViewHolder, c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048590, this, campaignViewHolder, cVar, i) == null) {
            q(campaignViewHolder, cVar, i);
            r(campaignViewHolder, cVar, i);
        }
    }

    public void o(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || d() == null || d().isEmpty() || (i2 = this.f45891c) < 0 || i2 >= d().size() || !d().get(this.f45891c).f45205d) {
            return;
        }
        d().get(this.f45891c).f45206e = i;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, viewHolder, i) == null) {
            if (viewHolder instanceof AmountViewHolder) {
                p((AmountViewHolder) viewHolder, i);
            } else if (viewHolder instanceof CampaignViewHolder) {
                s((CampaignViewHolder) viewHolder, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, viewGroup, i)) == null) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.a, o.a.a(this.f45896h));
            if (i == 2) {
                return new CampaignViewHolder(this, LayoutInflater.from(contextThemeWrapper).inflate(R.layout.obfuscated_res_0x7f0d0661, viewGroup, false));
            }
            return new AmountViewHolder(this, LayoutInflater.from(contextThemeWrapper).inflate(R.layout.obfuscated_res_0x7f0d0663, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public final void p(AmountViewHolder amountViewHolder, int i) {
        c e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, amountViewHolder, i) == null) || (e2 = e(i)) == null) {
            return;
        }
        t(amountViewHolder, e2, i);
        u(amountViewHolder, e2);
        v(amountViewHolder, e2);
        amountViewHolder.itemView.setOnClickListener(new a(this, amountViewHolder));
    }

    public final void q(CampaignViewHolder campaignViewHolder, c cVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, campaignViewHolder, cVar, i) == null) {
            int i3 = -1;
            campaignViewHolder.itemView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            campaignViewHolder.itemView.setVisibility(0);
            int b2 = (m.b(this.a) - h.a.a.e.h.c.a(((this.f45892d - 1) * 10) + 30)) / this.f45892d;
            int a2 = h.a.a.e.h.c.a(11.0f);
            int i4 = this.f45892d == 2 ? 4 : 6;
            int i5 = cVar.f45206e;
            if (i5 <= this.f45891c) {
                campaignViewHolder.f45905c.setVisibility(8);
                campaignViewHolder.f45904b.setVisibility(0);
                i3 = cVar.f45206e;
                int a3 = ((b2 / 2) - a2) + ((h.a.a.e.h.c.a(10.0f) + b2) * i3);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) campaignViewHolder.f45904b.getLayoutParams();
                layoutParams.leftMargin = a3;
                campaignViewHolder.f45904b.setLayoutParams(layoutParams);
                this.f45893e.c(campaignViewHolder.a, this.a);
            } else if (i5 <= i4) {
                campaignViewHolder.f45905c.setVisibility(0);
                campaignViewHolder.f45904b.setVisibility(8);
                int i6 = this.f45891c;
                if (i6 == 2) {
                    i2 = cVar.f45206e - 3;
                } else {
                    if (i6 == 3) {
                        i2 = cVar.f45206e - 4;
                    }
                    int a4 = ((b2 / 2) - a2) + ((h.a.a.e.h.c.a(10.0f) + b2) * i3);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) campaignViewHolder.f45905c.getLayoutParams();
                    layoutParams2.leftMargin = a4;
                    campaignViewHolder.f45905c.setLayoutParams(layoutParams2);
                    this.f45893e.c(campaignViewHolder.a, this.a);
                }
                i3 = i2;
                int a42 = ((b2 / 2) - a2) + ((h.a.a.e.h.c.a(10.0f) + b2) * i3);
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) campaignViewHolder.f45905c.getLayoutParams();
                layoutParams22.leftMargin = a42;
                campaignViewHolder.f45905c.setLayoutParams(layoutParams22);
                this.f45893e.c(campaignViewHolder.a, this.a);
            } else {
                RLog.error("PayAmountAdapter", "updateCampaignItemIndexView error config", new Object[0]);
                h(campaignViewHolder);
            }
            RLog.info("PayAmountAdapter", "updateCampaignItemIndexView position:" + i + " selectCampaignIndex:" + cVar.f45206e + " itemWidth:" + b2 + " mCampaignItemPosition:" + this.f45891c + " startIndexOfLine:" + i3 + " maxValidSelectCampaignIndex:" + i4);
        }
    }

    public final void r(CampaignViewHolder campaignViewHolder, c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048596, this, campaignViewHolder, cVar, i) == null) {
            int i2 = o.a.b(this.f45896h) ? R.drawable.obfuscated_res_0x7f080e83 : R.drawable.obfuscated_res_0x7f080e84;
            int i3 = o.a.b(this.f45896h) ? R.drawable.obfuscated_res_0x7f080e81 : R.drawable.obfuscated_res_0x7f080e82;
            int i4 = o.a.b(this.f45896h) ? R.drawable.obfuscated_res_0x7f080e85 : R.drawable.obfuscated_res_0x7f080e86;
            int i5 = o.a.b(this.f45896h) ? R.drawable.obfuscated_res_0x7f080e7f : R.drawable.obfuscated_res_0x7f080e80;
            campaignViewHolder.f45904b.setBackgroundResource(i4);
            campaignViewHolder.f45905c.setBackgroundResource(i5);
            campaignViewHolder.f45906d.setImageResource(i2);
            campaignViewHolder.f45908f.setImageResource(i3);
            GiftBagsInfo a2 = this.f45893e.a();
            if (a2 == null) {
                campaignViewHolder.f45907e.setVisibility(4);
                return;
            }
            String str = a2.giftbagTitle;
            if (TextUtils.isEmpty(str)) {
                campaignViewHolder.f45907e.setVisibility(4);
                return;
            }
            campaignViewHolder.f45907e.setVisibility(0);
            campaignViewHolder.f45907e.setText(str);
        }
    }

    public final void s(CampaignViewHolder campaignViewHolder, int i) {
        c e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048597, this, campaignViewHolder, i) == null) || (e2 = e(i)) == null) {
            return;
        }
        if (this.f45891c >= 0 && e2.f45206e >= 0) {
            n(campaignViewHolder, e2, i);
        } else {
            h(campaignViewHolder);
        }
    }

    public final void t(AmountViewHolder amountViewHolder, c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048598, this, amountViewHolder, cVar, i) == null) {
            if (cVar.f45204c) {
                amountViewHolder.f45901f.setVisibility(0);
                amountViewHolder.f45900e.setVisibility(8);
                amountViewHolder.f45899d.setVisibility(8);
                return;
            }
            amountViewHolder.f45901f.setVisibility(8);
            amountViewHolder.f45900e.setVisibility(0);
            amountViewHolder.f45899d.setVisibility(0);
            amountViewHolder.a.setText(n.b(cVar.a()));
            amountViewHolder.f45897b.setText(this.f45895g);
            amountViewHolder.f45899d.setVisibility(0);
            Double valueOf = Double.valueOf(cVar.b());
            if (valueOf == null) {
                amountViewHolder.f45899d.setText("");
            } else {
                amountViewHolder.f45899d.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d4e), n.a(valueOf.doubleValue())));
            }
            if (this.f45890b == i) {
                amountViewHolder.f45898c.setSelected(true);
                amountViewHolder.a.setSelected(true);
                amountViewHolder.f45897b.setSelected(true);
                return;
            }
            amountViewHolder.f45898c.setSelected(false);
            amountViewHolder.a.setSelected(false);
            amountViewHolder.f45897b.setSelected(false);
        }
    }

    public final void u(AmountViewHolder amountViewHolder, c cVar) {
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, amountViewHolder, cVar) == null) {
            ProductInfo productInfo = cVar.a;
            if (productInfo != null && (list = productInfo.giftbags) != null && !list.isEmpty()) {
                String str = cVar.a.giftbags.get(0).offersTips;
                if (TextUtils.isEmpty(str)) {
                    amountViewHolder.f45902g.setVisibility(8);
                    return;
                }
                amountViewHolder.f45902g.setVisibility(0);
                amountViewHolder.f45902g.setText(str);
                return;
            }
            amountViewHolder.f45902g.setVisibility(8);
        }
    }

    public final void v(AmountViewHolder amountViewHolder, c cVar) {
        List<GiftBagTagInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, amountViewHolder, cVar) == null) {
            ProductInfo productInfo = cVar.a;
            if (productInfo != null && (list = productInfo.giftBagTagInfos) != null && !list.isEmpty()) {
                String str = cVar.a.giftBagTagInfos.get(0).tag;
                if (TextUtils.isEmpty(str)) {
                    amountViewHolder.f45903h.setVisibility(8);
                    return;
                }
                amountViewHolder.f45903h.setVisibility(0);
                amountViewHolder.f45903h.setText(str);
                return;
            }
            amountViewHolder.f45903h.setVisibility(8);
        }
    }
}
