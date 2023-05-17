package tv.athena.revenue.payui.model;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b'\u0018\u0000:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Ltv/athena/revenue/payui/model/ImageLoaderSupplier;", "Landroid/content/Context;", "lifeContext", "Landroid/widget/ImageView;", "targetView", "Ltv/athena/revenue/payui/model/ImageLoaderSupplier$ImageParam;", "param", "", "onLoad", "(Landroid/content/Context;Landroid/widget/ImageView;Ltv/athena/revenue/payui/model/ImageLoaderSupplier$ImageParam;)V", "<init>", "()V", "ImageParam", "payui-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class ImageLoaderSupplier {
    public abstract void onLoad(Context context, ImageView imageView, ImageParam imageParam);

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000B%\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J0\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0003R\u0019\u0010\n\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0003R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001b"}, d2 = {"Ltv/athena/revenue/payui/model/ImageLoaderSupplier$ImageParam;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "imageUrl", "placeHolderResId", "errorHolderResId", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;II)Ltv/athena/revenue/payui/model/ImageLoaderSupplier$ImageParam;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "toString", "I", "getErrorHolderResId", "Ljava/lang/String;", "getImageUrl", "getPlaceHolderResId", "<init>", "(Ljava/lang/String;II)V", "payui-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class ImageParam {
        public final int errorHolderResId;
        public final String imageUrl;
        public final int placeHolderResId;

        public static /* synthetic */ ImageParam copy$default(ImageParam imageParam, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = imageParam.imageUrl;
            }
            if ((i3 & 2) != 0) {
                i = imageParam.placeHolderResId;
            }
            if ((i3 & 4) != 0) {
                i2 = imageParam.errorHolderResId;
            }
            return imageParam.copy(str, i, i2);
        }

        public final String component1() {
            return this.imageUrl;
        }

        public final int component2() {
            return this.placeHolderResId;
        }

        public final int component3() {
            return this.errorHolderResId;
        }

        public final ImageParam copy(String str, int i, int i2) {
            return new ImageParam(str, i, i2);
        }

        public boolean equals(Object obj) {
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

        public int hashCode() {
            String str = this.imageUrl;
            return ((((str != null ? str.hashCode() : 0) * 31) + this.placeHolderResId) * 31) + this.errorHolderResId;
        }

        public String toString() {
            return "ImageParam(imageUrl=" + this.imageUrl + ", placeHolderResId=" + this.placeHolderResId + ", errorHolderResId=" + this.errorHolderResId + SmallTailInfo.EMOTION_SUFFIX;
        }

        public ImageParam(String str, int i, int i2) {
            this.imageUrl = str;
            this.placeHolderResId = i;
            this.errorHolderResId = i2;
        }

        public /* synthetic */ ImageParam(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
        }

        public final int getErrorHolderResId() {
            return this.errorHolderResId;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final int getPlaceHolderResId() {
            return this.placeHolderResId;
        }
    }
}
