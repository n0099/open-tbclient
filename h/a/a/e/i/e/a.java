package h.a.a.e.i.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
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
import h.a.a.e.h.o;
import java.util.List;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<GiftBagItemInfo> f45215b;

    /* renamed from: c  reason: collision with root package name */
    public PayUIKitConfig f45216c;

    /* renamed from: h.a.a.e.i.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C2153a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f45217b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f45218c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f45219d;

        public C2153a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

    public a(Context context, List<GiftBagItemInfo> list, PayUIKitConfig payUIKitConfig) {
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
        this.a = context;
        this.f45215b = list;
        this.f45216c = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftBagItemInfo getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<GiftBagItemInfo> list = this.f45215b;
            if (list == null || list.isEmpty() || i < 0 || i >= this.f45215b.size()) {
                return null;
            }
            return this.f45215b.get(i);
        }
        return (GiftBagItemInfo) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45215b.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C2153a c2153a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.a, o.a.a(this.f45216c))).inflate(getCount() <= 2 ? R.layout.obfuscated_res_0x7f0d0664 : R.layout.obfuscated_res_0x7f0d0665, (ViewGroup) null);
                c2153a = new C2153a(this);
                c2153a.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921ba);
                c2153a.f45218c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090eb6);
                c2153a.f45217b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921e1);
                c2153a.f45219d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092224);
                view.setTag(c2153a);
            } else {
                c2153a = (C2153a) view.getTag();
            }
            GiftBagItemInfo item = getItem(i);
            if (TextUtils.isEmpty(item.name)) {
                c2153a.a.setVisibility(4);
            } else {
                c2153a.a.setVisibility(0);
                c2153a.a.setText(item.name);
            }
            if (!TextUtils.isEmpty(item.countDisplay) && !StringUtil.NULL_STRING.equals(item.countDisplay)) {
                c2153a.f45217b.setVisibility(0);
                c2153a.f45217b.setText(item.countDisplay);
            } else {
                c2153a.f45217b.setVisibility(4);
            }
            if (!TextUtils.isEmpty(item.typeName) && !StringUtil.NULL_STRING.equals(item.typeName)) {
                c2153a.f45219d.setVisibility(0);
                c2153a.f45219d.setText(item.typeName);
            } else {
                c2153a.f45219d.setVisibility(4);
            }
            PayUIKitConfig payUIKitConfig = this.f45216c;
            if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
                this.f45216c.imageLoaderSupplier.onLoad(this.a, c2153a.f45218c, new ImageLoaderSupplier.ImageParam(item.imgUrl, -1, -1));
            } else {
                RLog.error("PayGiftListAdapter", "getView error mPayUIKitConfig null", new Object[0]);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
