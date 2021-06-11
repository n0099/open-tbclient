package d.a.l0.a.c0.a.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.storage.PathType;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.l0.a.a2.e;
import d.a.l0.a.c0.a.b.b;
import d.a.l0.a.e0.d;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.p.d.h0;
import d.a.l0.a.v2.d0;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class a<V extends SimpleDraweeView, M extends b> extends d.a.l0.a.c0.a.d.a<V, M> {

    /* renamed from: d.a.l0.a.c0.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0625a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44502a;

        static {
            int[] iArr = new int[PathType.values().length];
            f44502a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44502a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44502a[PathType.NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44502a[PathType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
    }

    public static Uri Y(@NonNull String str) {
        String str2;
        String str3;
        PathType s = d.a.l0.a.k2.b.s(str);
        e i2 = e.i();
        if (i2 != null) {
            str2 = i2.f44425f;
            str3 = i2.Z();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        int i3 = C0625a.f44502a[s.ordinal()];
        if (i3 == 1) {
            String M = d.a.l0.a.k2.b.M(str, str2);
            if (TextUtils.isEmpty(M)) {
                return null;
            }
            return Uri.fromFile(new File(M));
        } else if (i3 != 2) {
            if (i3 != 3) {
                return null;
            }
            return Uri.parse(str);
        } else {
            File file = new File(str);
            if (file.exists()) {
                return Uri.fromFile(file);
            }
            String L = d.a.l0.a.k2.b.L(str, i2, str3);
            if (TextUtils.isEmpty(L)) {
                return null;
            }
            return Uri.fromFile(new File(L));
        }
    }

    @NonNull
    public d.a.l0.a.c0.f.b U(@NonNull M m, @NonNull M m2) {
        d.a.l0.a.c0.f.b k = super.k(m, m2);
        if (!TextUtils.equals(m.x, m2.x)) {
            k.b(9);
        }
        return k;
    }

    public void V(@NonNull V v, @NonNull M m, @NonNull d.a.l0.a.c0.f.b bVar) {
        super.D(v, m, bVar);
        if (bVar.a(9)) {
            W(v, m);
        }
    }

    public abstract void W(@NonNull V v, @NonNull M m);

    public final void X(@NonNull V v, @NonNull M m, @Nullable BaseControllerListener<ImageInfo> baseControllerListener) {
        Uri Y;
        if (m.n == null) {
            return;
        }
        if (d.a.l0.a.c0.b.a.f44508h) {
            Log.d("Component-SimpleDrawee", "renderImageStyle");
        }
        String str = m.x;
        if (TextUtils.isEmpty(str) || (Y = Y(str)) == null) {
            return;
        }
        d.g("Component-SimpleDrawee", "Image Uri:" + Y);
        PipelineDraweeControllerBuilder oldController = Fresco.newDraweeControllerBuilder().setOldController(v.getController());
        if (baseControllerListener != null) {
            oldController.setControllerListener(baseControllerListener);
        }
        HashMap hashMap = new HashMap();
        String Y2 = g.N().Y();
        if (!TextUtils.isEmpty(Y2)) {
            hashMap.put("User-Agent", Y2);
        }
        String b2 = d0.b();
        if (!TextUtils.isEmpty(b2) && d0.c(Y.toString())) {
            hashMap.put("Referer", b2);
        }
        h0 y = d.a.l0.a.c1.a.y();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Y);
        y.e(newBuilderWithSource, hashMap);
        oldController.setImageRequest(newBuilderWithSource.build());
        AbstractDraweeController build = oldController.build();
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setCornersRadius(m.r);
        GenericDraweeHierarchy build2 = new GenericDraweeHierarchyBuilder(v.getResources()).build();
        build2.setRoundingParams(roundingParams);
        build2.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        v.setHierarchy(build2);
        v.setController(build);
    }
}
