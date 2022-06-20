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
import com.repackage.e2a;
import com.repackage.o2a;
import com.repackage.p2a;
import com.repackage.q2a;
import com.repackage.r0a;
import com.repackage.t1a;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagTagInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes9.dex */
public class PayAmountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public int b;
    public int c;
    public int d;
    public r0a e;
    public List<t1a> f;
    public String g;
    public PayUIKitConfig h;
    public b i;

    /* loaded from: classes9.dex */
    public class AmountViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public View c;
        public TextView d;
        public View e;
        public TextView f;
        public TextView g;
        public TextView h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AmountViewHolder(PayAmountAdapter payAmountAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountAdapter, view2};
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09217e);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09215d);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f090262);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090261);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f0912ad);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921c2);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092154);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921f2);
        }
    }

    /* loaded from: classes9.dex */
    public class CampaignViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;
        public ImageView b;
        public ImageView c;
        public ImageView d;
        public TextView e;
        public ImageView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CampaignViewHolder(PayAmountAdapter payAmountAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payAmountAdapter, view2};
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
            this.a = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0912aa);
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e9f);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e5e);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e61);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09216c);
            this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e62);
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AmountViewHolder a;
        public final /* synthetic */ PayAmountAdapter b;

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
            this.b = payAmountAdapter;
            this.a = amountViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (bVar = this.b.i) == null) {
                return;
            }
            AmountViewHolder amountViewHolder = this.a;
            bVar.a(amountViewHolder.itemView, amountViewHolder.getAdapterPosition());
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(View view2, int i);
    }

    public PayAmountAdapter(Activity activity, r0a r0aVar, List<t1a> list, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, r0aVar, list, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.g = "Y币";
        this.i = null;
        this.a = activity;
        this.f = list;
        this.h = payUIKitConfig;
        this.e = r0aVar;
    }

    public List<t1a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public t1a e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<t1a> list = this.f;
            if (list == null || list.isEmpty() || i < 0 || i >= this.f.size()) {
                return null;
            }
            return this.f.get(i);
        }
        return (t1a) invokeI.objValue;
    }

    public t1a f() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b >= getCount() || (i = this.b) < 0) {
                return null;
            }
            return e(i);
        }
        return (t1a) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : invokeV.intValue;
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f.size() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f.size() : invokeV.intValue;
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
            t1a e = e(i);
            return (e == null || !e.d) ? 1 : 2;
        }
        return invokeI.intValue;
    }

    public final void h(CampaignViewHolder campaignViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, campaignViewHolder) == null) {
            campaignViewHolder.c.setVisibility(8);
            campaignViewHolder.b.setVisibility(8);
            campaignViewHolder.itemView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            campaignViewHolder.itemView.setVisibility(8);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c = i;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.g = str;
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
            this.b = i;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.d = i;
        }
    }

    public final void n(CampaignViewHolder campaignViewHolder, t1a t1aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048590, this, campaignViewHolder, t1aVar, i) == null) {
            q(campaignViewHolder, t1aVar, i);
            r(campaignViewHolder, t1aVar, i);
        }
    }

    public void o(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || d() == null || d().isEmpty() || (i2 = this.c) < 0 || i2 >= d().size() || !d().get(this.c).d) {
            return;
        }
        d().get(this.c).e = i;
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
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.a, q2a.a.a(this.h));
            if (i == 2) {
                return new CampaignViewHolder(this, LayoutInflater.from(contextThemeWrapper).inflate(R.layout.obfuscated_res_0x7f0d0642, viewGroup, false));
            }
            return new AmountViewHolder(this, LayoutInflater.from(contextThemeWrapper).inflate(R.layout.obfuscated_res_0x7f0d0644, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public final void p(AmountViewHolder amountViewHolder, int i) {
        t1a e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, amountViewHolder, i) == null) || (e = e(i)) == null) {
            return;
        }
        t(amountViewHolder, e, i);
        u(amountViewHolder, e);
        v(amountViewHolder, e);
        amountViewHolder.itemView.setOnClickListener(new a(this, amountViewHolder));
    }

    public final void q(CampaignViewHolder campaignViewHolder, t1a t1aVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, campaignViewHolder, t1aVar, i) == null) {
            int i3 = -1;
            campaignViewHolder.itemView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            campaignViewHolder.itemView.setVisibility(0);
            int b2 = (o2a.b(this.a) - e2a.a(((this.d - 1) * 10) + 30)) / this.d;
            int a2 = e2a.a(11.0f);
            int i4 = this.d == 2 ? 4 : 6;
            int i5 = t1aVar.e;
            if (i5 <= this.c) {
                campaignViewHolder.c.setVisibility(8);
                campaignViewHolder.b.setVisibility(0);
                i3 = t1aVar.e;
                int a3 = ((b2 / 2) - a2) + ((e2a.a(10.0f) + b2) * i3);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) campaignViewHolder.b.getLayoutParams();
                layoutParams.leftMargin = a3;
                campaignViewHolder.b.setLayoutParams(layoutParams);
                this.e.c(campaignViewHolder.a, this.a);
            } else if (i5 <= i4) {
                campaignViewHolder.c.setVisibility(0);
                campaignViewHolder.b.setVisibility(8);
                int i6 = this.c;
                if (i6 == 2) {
                    i2 = t1aVar.e - 3;
                } else {
                    if (i6 == 3) {
                        i2 = t1aVar.e - 4;
                    }
                    int a4 = ((b2 / 2) - a2) + ((e2a.a(10.0f) + b2) * i3);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) campaignViewHolder.c.getLayoutParams();
                    layoutParams2.leftMargin = a4;
                    campaignViewHolder.c.setLayoutParams(layoutParams2);
                    this.e.c(campaignViewHolder.a, this.a);
                }
                i3 = i2;
                int a42 = ((b2 / 2) - a2) + ((e2a.a(10.0f) + b2) * i3);
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) campaignViewHolder.c.getLayoutParams();
                layoutParams22.leftMargin = a42;
                campaignViewHolder.c.setLayoutParams(layoutParams22);
                this.e.c(campaignViewHolder.a, this.a);
            } else {
                RLog.error("PayAmountAdapter", "updateCampaignItemIndexView error config", new Object[0]);
                h(campaignViewHolder);
            }
            RLog.info("PayAmountAdapter", "updateCampaignItemIndexView position:" + i + " selectCampaignIndex:" + t1aVar.e + " itemWidth:" + b2 + " mCampaignItemPosition:" + this.c + " startIndexOfLine:" + i3 + " maxValidSelectCampaignIndex:" + i4);
        }
    }

    public final void r(CampaignViewHolder campaignViewHolder, t1a t1aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048596, this, campaignViewHolder, t1aVar, i) == null) {
            int i2 = q2a.a.b(this.h) ? R.drawable.obfuscated_res_0x7f080ead : R.drawable.obfuscated_res_0x7f080eae;
            int i3 = q2a.a.b(this.h) ? R.drawable.obfuscated_res_0x7f080eab : R.drawable.obfuscated_res_0x7f080eac;
            int i4 = q2a.a.b(this.h) ? R.drawable.obfuscated_res_0x7f080eaf : R.drawable.obfuscated_res_0x7f080eb0;
            int i5 = q2a.a.b(this.h) ? R.drawable.obfuscated_res_0x7f080ea9 : R.drawable.obfuscated_res_0x7f080eaa;
            campaignViewHolder.b.setBackgroundResource(i4);
            campaignViewHolder.c.setBackgroundResource(i5);
            campaignViewHolder.d.setImageResource(i2);
            campaignViewHolder.f.setImageResource(i3);
            GiftBagsInfo a2 = this.e.a();
            if (a2 == null) {
                campaignViewHolder.e.setVisibility(4);
                return;
            }
            String str = a2.giftbagTitle;
            if (TextUtils.isEmpty(str)) {
                campaignViewHolder.e.setVisibility(4);
                return;
            }
            campaignViewHolder.e.setVisibility(0);
            campaignViewHolder.e.setText(str);
        }
    }

    public final void s(CampaignViewHolder campaignViewHolder, int i) {
        t1a e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048597, this, campaignViewHolder, i) == null) || (e = e(i)) == null) {
            return;
        }
        if (this.c >= 0 && e.e >= 0) {
            n(campaignViewHolder, e, i);
        } else {
            h(campaignViewHolder);
        }
    }

    public final void t(AmountViewHolder amountViewHolder, t1a t1aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048598, this, amountViewHolder, t1aVar, i) == null) {
            if (t1aVar.c) {
                amountViewHolder.f.setVisibility(0);
                amountViewHolder.e.setVisibility(8);
                amountViewHolder.d.setVisibility(8);
                return;
            }
            amountViewHolder.f.setVisibility(8);
            amountViewHolder.e.setVisibility(0);
            amountViewHolder.d.setVisibility(0);
            amountViewHolder.a.setText(p2a.b(t1aVar.a()));
            amountViewHolder.b.setText(this.g);
            amountViewHolder.d.setVisibility(0);
            Double valueOf = Double.valueOf(t1aVar.b());
            if (valueOf == null) {
                amountViewHolder.d.setText("");
            } else {
                amountViewHolder.d.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d74), p2a.a(valueOf.doubleValue())));
            }
            if (this.b == i) {
                amountViewHolder.c.setSelected(true);
                amountViewHolder.a.setSelected(true);
                amountViewHolder.b.setSelected(true);
                return;
            }
            amountViewHolder.c.setSelected(false);
            amountViewHolder.a.setSelected(false);
            amountViewHolder.b.setSelected(false);
        }
    }

    public final void u(AmountViewHolder amountViewHolder, t1a t1aVar) {
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, amountViewHolder, t1aVar) == null) {
            ProductInfo productInfo = t1aVar.a;
            if (productInfo != null && (list = productInfo.giftbags) != null && !list.isEmpty()) {
                String str = t1aVar.a.giftbags.get(0).offersTips;
                if (TextUtils.isEmpty(str)) {
                    amountViewHolder.g.setVisibility(8);
                    return;
                }
                amountViewHolder.g.setVisibility(0);
                amountViewHolder.g.setText(str);
                return;
            }
            amountViewHolder.g.setVisibility(8);
        }
    }

    public final void v(AmountViewHolder amountViewHolder, t1a t1aVar) {
        List<GiftBagTagInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, amountViewHolder, t1aVar) == null) {
            ProductInfo productInfo = t1aVar.a;
            if (productInfo != null && (list = productInfo.giftBagTagInfos) != null && !list.isEmpty()) {
                String str = t1aVar.a.giftBagTagInfos.get(0).tag;
                if (TextUtils.isEmpty(str)) {
                    amountViewHolder.h.setVisibility(8);
                    return;
                }
                amountViewHolder.h.setVisibility(0);
                amountViewHolder.h.setText(str);
                return;
            }
            amountViewHolder.h.setVisibility(8);
        }
    }
}
