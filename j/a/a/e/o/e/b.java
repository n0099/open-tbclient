package j.a.a.e.o.e;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import j.a.a.e.d;
import j.a.a.e.e;
import j.a.a.e.n.l;
import java.util.List;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f64217e;

    /* renamed from: f  reason: collision with root package name */
    public List<GiftBagItemInfo> f64218f;

    /* renamed from: g  reason: collision with root package name */
    public PayUIKitConfig f64219g;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64220b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f64221c;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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

    public b(Context context, List<GiftBagItemInfo> list, PayUIKitConfig payUIKitConfig) {
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
        this.f64217e = context;
        this.f64218f = list;
        this.f64219g = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftBagItemInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<GiftBagItemInfo> list = this.f64218f;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f64218f.size()) {
                return null;
            }
            return this.f64218f.get(i2);
        }
        return (GiftBagItemInfo) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64218f.size() : invokeV.intValue;
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
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.f64217e, l.a.a(this.f64219g))).inflate(getCount() <= 2 ? e.pay_ui_item_pay_gift_bag_big : e.pay_ui_item_pay_gift_bag_small, (ViewGroup) null);
                aVar = new a(this);
                aVar.a = (TextView) view.findViewById(d.tv_gift_name);
                aVar.f64221c = (ImageView) view.findViewById(d.img_gift);
                aVar.f64220b = (TextView) view.findViewById(d.tv_num);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            GiftBagItemInfo item = getItem(i2);
            aVar.a.setText(item.name);
            if (item.count == 0) {
                aVar.f64220b.setVisibility(4);
            } else {
                aVar.f64220b.setVisibility(0);
                TextView textView = aVar.f64220b;
                textView.setText("x" + item.count);
            }
            PayUIKitConfig payUIKitConfig = this.f64219g;
            if (payUIKitConfig == null && payUIKitConfig.imageLoaderSupplier == null) {
                RLog.error("PayGiftBagAdapter", "getView error mPayUIKitConfig null", new Object[0]);
            } else {
                this.f64219g.imageLoaderSupplier.onLoad(this.f64217e, aVar.f64221c, new ImageLoaderSupplier.ImageParam(item.imgUrl, -1, -1));
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
