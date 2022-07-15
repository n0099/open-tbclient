package com.repackage;

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
import java.util.List;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes7.dex */
public class uz9 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<GiftBagItemInfo> b;
    public PayUIKitConfig c;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public ImageView c;
        public TextView d;

        public a(uz9 uz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz9Var};
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

    public uz9(Context context, List<GiftBagItemInfo> list, PayUIKitConfig payUIKitConfig) {
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
        this.b = list;
        this.c = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftBagItemInfo getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<GiftBagItemInfo> list = this.b;
            if (list == null || list.isEmpty() || i < 0 || i >= this.b.size()) {
                return null;
            }
            return this.b.get(i);
        }
        return (GiftBagItemInfo) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(new ContextThemeWrapper(this.a, nz9.a.a(this.c))).inflate(getCount() <= 2 ? R.layout.obfuscated_res_0x7f0d0661 : R.layout.obfuscated_res_0x7f0d0662, (ViewGroup) null);
                aVar = new a(this);
                aVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09223a);
                aVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e84);
                aVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092263);
                aVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922a7);
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            GiftBagItemInfo item = getItem(i);
            if (TextUtils.isEmpty(item.name)) {
                aVar.a.setVisibility(4);
            } else {
                aVar.a.setVisibility(0);
                aVar.a.setText(item.name);
            }
            if (!TextUtils.isEmpty(item.countDisplay) && !StringUtil.NULL_STRING.equals(item.countDisplay)) {
                aVar.b.setVisibility(0);
                aVar.b.setText(item.countDisplay);
            } else {
                aVar.b.setVisibility(4);
            }
            if (!TextUtils.isEmpty(item.typeName) && !StringUtil.NULL_STRING.equals(item.typeName)) {
                aVar.d.setVisibility(0);
                aVar.d.setText(item.typeName);
            } else {
                aVar.d.setVisibility(4);
            }
            PayUIKitConfig payUIKitConfig = this.c;
            if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
                this.c.imageLoaderSupplier.onLoad(this.a, aVar.c, new ImageLoaderSupplier.ImageParam(item.imgUrl, -1, -1));
            } else {
                RLog.error("PayGiftListAdapter", "getView error mPayUIKitConfig null", new Object[0]);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
