package tv.athena.revenue.payui.view.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SpinnerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.ica;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001b\u0010\u001eJ\u001d\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR0\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Ltv/athena/revenue/payui/view/banner/PluginCenterBannerGallery;", "Ltv/athena/revenue/payui/view/banner/AdGallery;", "", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/BannerConfigItem$BannerInfo;", "data", "", "addData", "(Ljava/util/List;)V", "", CriusAttrConstants.POSITION, "getItemInfo", "(I)Lcom/yy/mobile/framework/revenuesdk/payapi/bean/BannerConfigItem$BannerInfo;", "Ltv/athena/revenue/payui/model/ImageLoaderSupplier;", "supplier", "setImageLoaderSupplier", "(Ltv/athena/revenue/payui/model/ImageLoaderSupplier;)V", "getData", "()Ljava/util/List;", "setData", "Ltv/athena/revenue/payui/view/banner/PluginCenterBannerAdapter;", "mAdapter", "Ltv/athena/revenue/payui/view/banner/PluginCenterBannerAdapter;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "payui-main_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class PluginCenterBannerGallery extends AdGallery {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ica j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2109212953, "Ltv/athena/revenue/payui/view/banner/PluginCenterBannerGallery;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2109212953, "Ltv/athena/revenue/payui/view/banner/PluginCenterBannerGallery;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginCenterBannerGallery(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new ica(context);
    }

    public final void setData(List<? extends BannerConfigItem.BannerInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            f();
            this.j.b(list);
            setAdapter((SpinnerAdapter) this.j);
            RLog.debug("PluginCenterBannerGallery", "set data size = " + list.size());
            i();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginCenterBannerGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = new ica(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginCenterBannerGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.j = new ica(context);
    }

    public final List<BannerConfigItem.BannerInfo> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<BannerConfigItem.BannerInfo> a = this.j.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "mAdapter.data");
            return a;
        }
        return (List) invokeV.objValue;
    }

    public final void setImageLoaderSupplier(ImageLoaderSupplier imageLoaderSupplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageLoaderSupplier) == null) {
            this.j.g(imageLoaderSupplier);
        }
    }
}
