package j.a.a.e.q.e;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import j.a.a.e.f;
import j.a.a.e.g;
import j.a.a.e.p.o;
import java.util.List;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f62398e;

    /* renamed from: f  reason: collision with root package name */
    public List<GiftBagItemInfo> f62399f;

    /* renamed from: g  reason: collision with root package name */
    public PayUIKitConfig f62400g;

    /* renamed from: j.a.a.e.q.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C2315a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62401b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62402c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62403d;

        public C2315a(a aVar) {
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
        this.f62398e = context;
        this.f62399f = list;
        this.f62400g = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftBagItemInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<GiftBagItemInfo> list = this.f62399f;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f62399f.size()) {
                return null;
            }
            return this.f62399f.get(i2);
        }
        return (GiftBagItemInfo) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62399f.size() : invokeV.intValue;
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
        C2315a c2315a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.f62398e, o.a.a(this.f62400g))).inflate(getCount() <= 2 ? g.pay_ui_item_pay_gift_bag_big : g.pay_ui_item_pay_gift_bag_small, (ViewGroup) null);
                c2315a = new C2315a(this);
                c2315a.a = (TextView) view.findViewById(f.tv_gift_name);
                c2315a.f62402c = (ImageView) view.findViewById(f.img_gift);
                c2315a.f62401b = (TextView) view.findViewById(f.tv_num);
                c2315a.f62403d = (TextView) view.findViewById(f.tv_type);
                view.setTag(c2315a);
            } else {
                c2315a = (C2315a) view.getTag();
            }
            GiftBagItemInfo item = getItem(i2);
            if (TextUtils.isEmpty(item.name)) {
                c2315a.a.setVisibility(4);
            } else {
                c2315a.a.setVisibility(0);
                c2315a.a.setText(item.name);
            }
            if (!TextUtils.isEmpty(item.countDisplay) && !StringUtil.NULL_STRING.equals(item.countDisplay)) {
                c2315a.f62401b.setVisibility(0);
                c2315a.f62401b.setText(item.countDisplay);
            } else {
                c2315a.f62401b.setVisibility(4);
            }
            if (!TextUtils.isEmpty(item.typeName) && !StringUtil.NULL_STRING.equals(item.typeName)) {
                c2315a.f62403d.setVisibility(0);
                c2315a.f62403d.setText(item.typeName);
            } else {
                c2315a.f62403d.setVisibility(4);
            }
            PayUIKitConfig payUIKitConfig = this.f62400g;
            if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
                this.f62400g.imageLoaderSupplier.onLoad(this.f62398e, c2315a.f62402c, new ImageLoaderSupplier.ImageParam(item.imgUrl, -1, -1));
            } else {
                RLog.error("PayGiftListAdapter", "getView error mPayUIKitConfig null", new Object[0]);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
