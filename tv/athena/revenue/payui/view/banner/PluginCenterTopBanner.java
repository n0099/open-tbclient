package tv.athena.revenue.payui.view.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.fia;
import com.baidu.tieba.zla;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.BannerItemSelectListener;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\bI\u0010JB\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bI\u0010KB#\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\bI\u0010\u0017J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b \u0010\u0007J\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010(¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020+¢\u0006\u0004\b,\u0010-J\u0015\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0005H\u0002¢\u0006\u0004\b2\u0010\tR\u0013\u00103\u001a\u00020.8F@\u0006¢\u0006\u0006\u001a\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u0003078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006M"}, d2 = {"Ltv/athena/revenue/payui/view/banner/PluginCenterTopBanner;", "Landroid/widget/RelativeLayout;", "", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/BannerConfigItem$BannerInfo;", "data", "", "addRadios", "(Ljava/util/List;)V", "endAutoScroll", "()V", "Landroid/widget/RadioGroup$LayoutParams;", "generateCheckedParam", "()Landroid/widget/RadioGroup$LayoutParams;", "generateDefaultParam", "getData", "()Ljava/util/List;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "init", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Ltv/athena/revenue/payui/model/BannerItemSelectListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBannerItemSelectListener", "(Ltv/athena/revenue/payui/model/BannerItemSelectListener;)V", "setData", "time", "setFlipInterval", "(I)V", "Ltv/athena/revenue/payui/model/ImageLoaderSupplier;", "supplier", "setImageLoaderSupplier", "(Ltv/athena/revenue/payui/model/ImageLoaderSupplier;)V", "Landroid/widget/AdapterView$OnItemClickListener;", "setOnItemClickListener", "(Landroid/widget/AdapterView$OnItemClickListener;)V", "Landroid/view/View$OnClickListener;", "setOnPlaceHolderClickListener", "(Landroid/view/View$OnClickListener;)V", "", "isVisible", "setPlaceHolderVisible", "(Z)V", "startAutoScroll", "isFlipping", "()Z", "mBannerItemSelectListener", "Ltv/athena/revenue/payui/model/BannerItemSelectListener;", "", "mData", "Ljava/util/List;", "Ltv/athena/revenue/payui/view/banner/PluginCenterBannerGallery;", "mGallery", "Ltv/athena/revenue/payui/view/banner/PluginCenterBannerGallery;", "", "mLayoutAspectRatio", "F", "Landroid/widget/AdapterView$OnItemSelectedListener;", "mListener", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/view/View;", "mPlaceholderView", "Landroid/view/View;", "Landroid/widget/RadioGroup;", "mRadios", "Landroid/widget/RadioGroup;", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "payui-main_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class PluginCenterTopBanner extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PluginCenterBannerGallery a;
    public RadioGroup b;
    public final List<BannerConfigItem.BannerInfo> c;
    public View d;
    public float e;
    public BannerItemSelectListener f;
    public final AdapterView.OnItemSelectedListener g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1145595668, "Ltv/athena/revenue/payui/view/banner/PluginCenterTopBanner;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1145595668, "Ltv/athena/revenue/payui/view/banner/PluginCenterTopBanner;");
        }
    }

    /* loaded from: classes9.dex */
    public static final class a implements RadioGroup.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginCenterTopBanner a;

        public a(PluginCenterTopBanner pluginCenterTopBanner) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenterTopBanner};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginCenterTopBanner;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, radioGroup, i) == null) {
                int size = this.a.c.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View childAt = radioGroup.getChildAt(i2);
                    if (childAt != null) {
                        RadioButton radioButton = (RadioButton) childAt;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.RadioButton");
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements AdapterView.OnItemSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PluginCenterTopBanner a;

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adapterView) == null) {
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(PluginCenterTopBanner pluginCenterTopBanner) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginCenterTopBanner};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pluginCenterTopBanner;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || i >= zla.a.a(PluginCenterTopBanner.c(this.a).getData())) {
                return;
            }
            RadioGroup radioGroup = this.a.b;
            if (radioGroup == null) {
                Intrinsics.throwNpe();
            }
            List<BannerConfigItem.BannerInfo> data = PluginCenterTopBanner.c(this.a).getData();
            if (data == null) {
                Intrinsics.throwNpe();
            }
            View childAt = radioGroup.getChildAt(i % data.size());
            if (childAt != null) {
                RadioGroup radioGroup2 = this.a.b;
                if (radioGroup2 == null) {
                    Intrinsics.throwNpe();
                }
                radioGroup2.check(childAt.getId());
            }
            BannerItemSelectListener bannerItemSelectListener = this.a.f;
            if (bannerItemSelectListener != null) {
                bannerItemSelectListener.onItemSelected(i);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PluginCenterTopBanner(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PluginCenterTopBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginCenterTopBanner(Context context, AttributeSet attributeSet, int i) {
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
        this.c = new ArrayList();
        this.g = new b(this);
        g(context, attributeSet, i);
    }

    public static final /* synthetic */ PluginCenterBannerGallery c(PluginCenterTopBanner pluginCenterTopBanner) {
        PluginCenterBannerGallery pluginCenterBannerGallery = pluginCenterTopBanner.a;
        if (pluginCenterBannerGallery == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGallery");
        }
        return pluginCenterBannerGallery;
    }

    public final void setBannerItemSelectListener(BannerItemSelectListener bannerItemSelectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bannerItemSelectListener) == null) {
            this.f = bannerItemSelectListener;
        }
    }

    public final void setFlipInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            PluginCenterBannerGallery pluginCenterBannerGallery = this.a;
            if (pluginCenterBannerGallery == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGallery");
            }
            pluginCenterBannerGallery.setFlipInterval(i);
        }
    }

    public final void setImageLoaderSupplier(ImageLoaderSupplier imageLoaderSupplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageLoaderSupplier) == null) {
            PluginCenterBannerGallery pluginCenterBannerGallery = this.a;
            if (pluginCenterBannerGallery == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGallery");
            }
            pluginCenterBannerGallery.setImageLoaderSupplier(imageLoaderSupplier);
        }
    }

    public final void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onItemClickListener) == null) {
            PluginCenterBannerGallery pluginCenterBannerGallery = this.a;
            if (pluginCenterBannerGallery == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGallery");
            }
            pluginCenterBannerGallery.setOnItemClickListener(onItemClickListener);
        }
    }

    public final void setOnPlaceHolderClickListener(View.OnClickListener onClickListener) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) && (view2 = this.d) != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public final void setPlaceHolderVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                View view2 = this.d;
                if (view2 != null) {
                    view2.setVisibility(0);
                    return;
                }
                return;
            }
            View view3 = this.d;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
    }

    public final void e(List<? extends BannerConfigItem.BannerInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            RadioGroup radioGroup = this.b;
            if (radioGroup == null) {
                Intrinsics.throwNpe();
            }
            radioGroup.removeAllViews();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                RadioButton radioButton = new RadioButton(getContext());
                radioButton.setId(i + 4660);
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                radioButton.setButtonDrawable(context.getResources().getDrawable(R.drawable.pay_ui_hp_top_banner_selector_newstyle));
                RadioGroup radioGroup2 = this.b;
                if (radioGroup2 == null) {
                    Intrinsics.throwNpe();
                }
                radioGroup2.addView(radioButton, f());
            }
            RadioGroup radioGroup3 = this.b;
            if (radioGroup3 == null) {
                Intrinsics.throwNpe();
            }
            radioGroup3.setOnCheckedChangeListener(new a(this));
        }
    }

    public final void setData(List<? extends BannerConfigItem.BannerInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, list) == null) && !Intrinsics.areEqual(this.c, list) && list != null) {
            this.c.clear();
            this.c.addAll(list);
            if (this.b != null) {
                if (this.c.size() <= 1) {
                    RadioGroup radioGroup = this.b;
                    if (radioGroup == null) {
                        Intrinsics.throwNpe();
                    }
                    radioGroup.setVisibility(8);
                } else {
                    RadioGroup radioGroup2 = this.b;
                    if (radioGroup2 == null) {
                        Intrinsics.throwNpe();
                    }
                    radioGroup2.setVisibility(0);
                }
            }
            PluginCenterBannerGallery pluginCenterBannerGallery = this.a;
            if (pluginCenterBannerGallery == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGallery");
            }
            pluginCenterBannerGallery.setData(list);
            e(list);
            RadioGroup radioGroup3 = this.b;
            if (radioGroup3 == null) {
                Intrinsics.throwNpe();
            }
            RadioGroup radioGroup4 = this.b;
            if (radioGroup4 == null) {
                Intrinsics.throwNpe();
            }
            View childAt = radioGroup4.getChildAt(0);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "mRadios!!.getChildAt(0)");
            radioGroup3.check(childAt.getId());
        }
    }

    public final RadioGroup.LayoutParams f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int dimension = (int) getResources().getDimension(R.dimen.pay_ui_home_top_banner_dot_homepage);
            return new RadioGroup.LayoutParams(dimension + 12, dimension);
        }
        return (RadioGroup.LayoutParams) invokeV.objValue;
    }

    public final List<BannerConfigItem.BannerInfo> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final void g(Context context, AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet, i) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, fia.Pay_Ui_Banner, i, 0);
            this.e = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
            LayoutInflater.from(context).inflate(R.layout.pay_ui_layout_plugincenter_top_banner, (ViewGroup) this, true);
            View findViewById = findViewById(R.id.lbb_top_banner_gallery);
            if (findViewById != null) {
                this.a = (PluginCenterBannerGallery) findViewById;
                View findViewById2 = findViewById(R.id.lbb_radio_top_banner);
                if (findViewById2 != null) {
                    this.b = (RadioGroup) findViewById2;
                    this.d = findViewById(R.id.banner_placeholder);
                    PluginCenterBannerGallery pluginCenterBannerGallery = this.a;
                    if (pluginCenterBannerGallery == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGallery");
                    }
                    pluginCenterBannerGallery.setOnItemSelectedListener(this.g);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RadioGroup");
            }
            throw new TypeCastException("null cannot be cast to non-null type tv.athena.revenue.payui.view.banner.PluginCenterBannerGallery");
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            if (this.e > 0) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) / this.e), 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
