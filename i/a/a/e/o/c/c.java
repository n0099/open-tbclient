package i.a.a.e.o.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import i.a.a.e.d;
import i.a.a.e.e;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
/* loaded from: classes10.dex */
public final class c extends i.a.a.e.o.c.a<BannerConfigItem.BannerInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public ImageLoaderSupplier f75887g;

    /* loaded from: classes10.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f75888a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f75889b;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75889b = cVar;
        }

        public final ImageView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f75888a : (ImageView) invokeV.objValue;
        }

        public final void b(BannerConfigItem.BannerInfo bannerInfo, int i2, Context context) {
            ImageLoaderSupplier e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bannerInfo, i2, context) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("setData position = ");
                sb.append(i2);
                sb.append(" info jumpType = ");
                sb.append(bannerInfo != null ? Integer.valueOf(bannerInfo.jumpType) : null);
                sb.append(" imageUrl = ");
                sb.append(bannerInfo != null ? bannerInfo.imageUrl : null);
                sb.append(" jumpUrl = ");
                sb.append(bannerInfo != null ? bannerInfo.jumpData : null);
                RLog.debug("PluginCenterBannerAdapter", sb.toString());
                ImageView imageView = this.f75888a;
                if (imageView == null || (e2 = this.f75889b.e()) == null) {
                    return;
                }
                e2.onLoad(context, imageView, new ImageLoaderSupplier.ImageParam(bannerInfo != null ? bannerInfo.imageUrl : null, -1, -1));
            }
        }

        public final void c(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageView) == null) {
                this.f75888a = imageView;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1776044164, "Li/a/a/e/o/c/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1776044164, "Li/a/a/e/o/c/c;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        RLog.info("PluginCenterBannerAdapter", "constructor");
    }

    @NonNull
    public final a d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            a aVar = new a(this);
            aVar.c((ImageView) view.findViewById(d.top_banner_image));
            ImageView a2 = aVar.a();
            if (a2 == null) {
                Intrinsics.throwNpe();
            }
            a2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setTag(aVar);
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final ImageLoaderSupplier e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f75887g : (ImageLoaderSupplier) invokeV.objValue;
    }

    public final void f(BannerConfigItem.BannerInfo bannerInfo, a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, bannerInfo, aVar, i2) == null) || bannerInfo == null) {
            return;
        }
        RLog.debug("PluginCenterBannerAdapter", "bind view holder position = " + i2);
        Context mContext = this.f75885f;
        Intrinsics.checkExpressionValueIsNotNull(mContext, "mContext");
        aVar.b(bannerInfo, i2, mContext);
    }

    public final void g(ImageLoaderSupplier imageLoaderSupplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, imageLoaderSupplier) == null) {
            this.f75887g = imageLoaderSupplier;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f75885f).inflate(e.pay_ui_layout_plugincenter_banner_item, (ViewGroup) null);
                if (view == null) {
                    Intrinsics.throwNpe();
                }
                view.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                aVar = d(view);
            } else {
                Object tag = view != null ? view.getTag() : null;
                if (tag == null) {
                    throw new TypeCastException("null cannot be cast to non-null type tv.athena.revenue.payui.view.banner.PluginCenterBannerAdapter.ViewHolder");
                }
                aVar = (a) tag;
            }
            BannerConfigItem.BannerInfo item = getItem(i2);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(position)");
            f(item, aVar, i2);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
