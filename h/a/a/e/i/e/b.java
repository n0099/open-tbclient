package h.a.a.e.i.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import h.a.a.e.f.f;
import h.a.a.e.h.o;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f45220b;

    /* renamed from: c  reason: collision with root package name */
    public List<f> f45221c;

    /* renamed from: d  reason: collision with root package name */
    public PayUIKitConfig f45222d;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f45223b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f45224c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f45225d;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public b(Context context, PayUIKitConfig payUIKitConfig, List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, payUIKitConfig, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45221c = new ArrayList();
        this.a = context;
        this.f45221c = list;
        this.f45222d = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.f45221c.get(i) : (f) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45220b : invokeV.intValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f45220b = i;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45221c.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0666, viewGroup, false);
                aVar = new a(this);
                aVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092444);
                aVar.f45224c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ed3);
                aVar.f45223b = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0919e4);
                aVar.f45225d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09221d);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            f item = getItem(i);
            aVar.a.setText(item.a());
            PayType payType = item.a;
            if (PayType.ALI_PAY.equals(payType)) {
                aVar.f45223b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e93);
            } else if (PayType.WECHAT_PAY.equals(payType)) {
                aVar.f45223b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e92);
            } else if (PayType.DXM_PAY.equals(payType)) {
                aVar.f45223b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e8e);
            } else if (PayType.DXM_PAY_KJ.equals(payType)) {
                aVar.f45223b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e8f);
            } else if (PayType.UNION_PAY.equals(payType)) {
                aVar.f45223b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e91);
            } else if (PayType.QQ_PAY.equals(payType)) {
                aVar.f45223b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e90);
            }
            aVar.a.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608a3));
            if (this.f45220b == i) {
                aVar.f45224c.setBackgroundResource(o.a.b(this.f45222d) ? R.drawable.obfuscated_res_0x7f080e9b : R.drawable.obfuscated_res_0x7f080e9c);
            } else {
                aVar.f45224c.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e9d);
            }
            if (TextUtils.isEmpty(item.f45211c)) {
                aVar.f45225d.setVisibility(8);
            } else {
                aVar.f45225d.setVisibility(0);
                aVar.f45225d.setText(item.f45211c);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
