package tv.athena.revenue.payui.model;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b'\u0018\u0000:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Ltv/athena/revenue/payui/model/ImageLoaderSupplier;", "Landroid/content/Context;", "lifeContext", "Landroid/widget/ImageView;", "targetView", "Ltv/athena/revenue/payui/model/ImageLoaderSupplier$ImageParam;", "param", "", "onLoad", "(Landroid/content/Context;Landroid/widget/ImageView;Ltv/athena/revenue/payui/model/ImageLoaderSupplier$ImageParam;)V", "<init>", "()V", "ImageParam", "payui_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public abstract class ImageLoaderSupplier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000B%\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J0\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0003R\u0019\u0010\n\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0003R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001b"}, d2 = {"Ltv/athena/revenue/payui/model/ImageLoaderSupplier$ImageParam;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "imageUrl", "placeHolderResId", "errorHolderResId", "copy", "(Ljava/lang/String;II)Ltv/athena/revenue/payui/model/ImageLoaderSupplier$ImageParam;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "I", "getErrorHolderResId", "Ljava/lang/String;", "getImageUrl", "getPlaceHolderResId", "<init>", "(Ljava/lang/String;II)V", "payui_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class ImageParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int errorHolderResId;
        public final String imageUrl;
        public final int placeHolderResId;

        public ImageParam(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.imageUrl = str;
            this.placeHolderResId = i2;
            this.errorHolderResId = i3;
        }

        public static /* synthetic */ ImageParam copy$default(ImageParam imageParam, String str, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = imageParam.imageUrl;
            }
            if ((i4 & 2) != 0) {
                i2 = imageParam.placeHolderResId;
            }
            if ((i4 & 4) != 0) {
                i3 = imageParam.errorHolderResId;
            }
            return imageParam.copy(str, i2, i3);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.imageUrl : (String) invokeV.objValue;
        }

        public final int component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.placeHolderResId : invokeV.intValue;
        }

        public final int component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.errorHolderResId : invokeV.intValue;
        }

        public final ImageParam copy(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, str, i2, i3)) == null) ? new ImageParam(str, i2, i3) : (ImageParam) invokeLII.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this != obj) {
                    if (obj instanceof ImageParam) {
                        ImageParam imageParam = (ImageParam) obj;
                        if (Intrinsics.areEqual(this.imageUrl, imageParam.imageUrl)) {
                            if (this.placeHolderResId == imageParam.placeHolderResId) {
                                if (this.errorHolderResId == imageParam.errorHolderResId) {
                                }
                            }
                        }
                    }
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final int getErrorHolderResId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.errorHolderResId : invokeV.intValue;
        }

        public final String getImageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.imageUrl : (String) invokeV.objValue;
        }

        public final int getPlaceHolderResId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.placeHolderResId : invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                String str = this.imageUrl;
                return ((((str != null ? str.hashCode() : 0) * 31) + this.placeHolderResId) * 31) + this.errorHolderResId;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return "ImageParam(imageUrl=" + this.imageUrl + ", placeHolderResId=" + this.placeHolderResId + ", errorHolderResId=" + this.errorHolderResId + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public /* synthetic */ ImageParam(String str, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
        }
    }

    public ImageLoaderSupplier() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void onLoad(Context context, ImageView imageView, ImageParam imageParam);
}
