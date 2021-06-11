package i.a.a.e.o.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import i.a.a.e.d;
import i.a.a.e.e;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
/* loaded from: classes8.dex */
public final class c extends i.a.a.e.o.c.a<BannerConfigItem.BannerInfo> {

    /* renamed from: g  reason: collision with root package name */
    public ImageLoaderSupplier f72191g;

    /* loaded from: classes8.dex */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f72192a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final ImageView a() {
            return this.f72192a;
        }

        public final void b(BannerConfigItem.BannerInfo bannerInfo, int i2, Context context) {
            ImageLoaderSupplier e2;
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
            ImageView imageView = this.f72192a;
            if (imageView == null || (e2 = c.this.e()) == null) {
                return;
            }
            e2.onLoad(context, imageView, new ImageLoaderSupplier.ImageParam(bannerInfo != null ? bannerInfo.imageUrl : null, -1, -1));
        }

        public final void c(ImageView imageView) {
            this.f72192a = imageView;
        }
    }

    public c(Context context) {
        super(context);
        RLog.info("PluginCenterBannerAdapter", "constructor");
    }

    @NonNull
    public final a d(View view) {
        a aVar = new a();
        aVar.c((ImageView) view.findViewById(d.top_banner_image));
        ImageView a2 = aVar.a();
        if (a2 == null) {
            Intrinsics.throwNpe();
        }
        a2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setTag(aVar);
        return aVar;
    }

    public final ImageLoaderSupplier e() {
        return this.f72191g;
    }

    public final void f(BannerConfigItem.BannerInfo bannerInfo, a aVar, int i2) {
        if (bannerInfo != null) {
            RLog.debug("PluginCenterBannerAdapter", "bind view holder position = " + i2);
            Context mContext = this.f72189f;
            Intrinsics.checkExpressionValueIsNotNull(mContext, "mContext");
            aVar.b(bannerInfo, i2, mContext);
        }
    }

    public final void g(ImageLoaderSupplier imageLoaderSupplier) {
        this.f72191g = imageLoaderSupplier;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f72189f).inflate(e.pay_ui_layout_plugincenter_banner_item, (ViewGroup) null);
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
}
