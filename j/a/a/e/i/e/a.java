package j.a.a.e.i.e;

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
import j.a.a.e.h.o;
import java.util.List;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f60915e;

    /* renamed from: f  reason: collision with root package name */
    public List<GiftBagItemInfo> f60916f;

    /* renamed from: g  reason: collision with root package name */
    public PayUIKitConfig f60917g;

    /* renamed from: j.a.a.e.i.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C2304a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60918b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f60919c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60920d;

        public C2304a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60915e = context;
        this.f60916f = list;
        this.f60917g = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftBagItemInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<GiftBagItemInfo> list = this.f60916f;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f60916f.size()) {
                return null;
            }
            return this.f60916f.get(i2);
        }
        return (GiftBagItemInfo) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60916f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C2304a c2304a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.f60915e, o.a.a(this.f60917g))).inflate(getCount() <= 2 ? R.layout.pay_ui_item_pay_gift_bag_big : R.layout.pay_ui_item_pay_gift_bag_small, (ViewGroup) null);
                c2304a = new C2304a(this);
                c2304a.a = (TextView) view.findViewById(R.id.tv_gift_name);
                c2304a.f60919c = (ImageView) view.findViewById(R.id.img_gift);
                c2304a.f60918b = (TextView) view.findViewById(R.id.tv_num);
                c2304a.f60920d = (TextView) view.findViewById(R.id.tv_type);
                view.setTag(c2304a);
            } else {
                c2304a = (C2304a) view.getTag();
            }
            GiftBagItemInfo item = getItem(i2);
            if (TextUtils.isEmpty(item.name)) {
                c2304a.a.setVisibility(4);
            } else {
                c2304a.a.setVisibility(0);
                c2304a.a.setText(item.name);
            }
            if (!TextUtils.isEmpty(item.countDisplay) && !StringUtil.NULL_STRING.equals(item.countDisplay)) {
                c2304a.f60918b.setVisibility(0);
                c2304a.f60918b.setText(item.countDisplay);
            } else {
                c2304a.f60918b.setVisibility(4);
            }
            if (!TextUtils.isEmpty(item.typeName) && !StringUtil.NULL_STRING.equals(item.typeName)) {
                c2304a.f60920d.setVisibility(0);
                c2304a.f60920d.setText(item.typeName);
            } else {
                c2304a.f60920d.setVisibility(4);
            }
            PayUIKitConfig payUIKitConfig = this.f60917g;
            if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
                this.f60917g.imageLoaderSupplier.onLoad(this.f60915e, c2304a.f60919c, new ImageLoaderSupplier.ImageParam(item.imgUrl, -1, -1));
            } else {
                RLog.error("PayGiftListAdapter", "getView error mPayUIKitConfig null", new Object[0]);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
