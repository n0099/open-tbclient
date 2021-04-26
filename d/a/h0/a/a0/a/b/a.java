package d.a.h0.a.a0.a.b;

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
import d.a.h0.a.a0.a.b.b;
import d.a.h0.a.c0.c;
import d.a.h0.a.r1.e;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class a<V extends SimpleDraweeView, M extends b> extends d.a.h0.a.a0.a.d.a<V, M> {

    /* renamed from: d.a.h0.a.a0.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0559a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41075a;

        static {
            int[] iArr = new int[PathType.values().length];
            f41075a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41075a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41075a[PathType.NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41075a[PathType.ERROR.ordinal()] = 4;
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
        PathType c2 = d.a.h0.a.a2.b.c(str);
        e h2 = e.h();
        if (h2 != null) {
            str2 = h2.f43823f;
            str3 = h2.W();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        int i2 = C0559a.f41075a[c2.ordinal()];
        if (i2 == 1) {
            String u = d.a.h0.a.a2.b.u(str, str2);
            if (TextUtils.isEmpty(u)) {
                return null;
            }
            return Uri.fromFile(new File(u));
        } else if (i2 != 2) {
            if (i2 != 3) {
                return null;
            }
            return Uri.parse(str);
        } else {
            File file = new File(str);
            if (file.exists()) {
                return Uri.fromFile(file);
            }
            String t = d.a.h0.a.a2.b.t(str, h2, str3);
            if (TextUtils.isEmpty(t)) {
                return null;
            }
            return Uri.fromFile(new File(t));
        }
    }

    @NonNull
    public d.a.h0.a.a0.f.b U(@NonNull M m, @NonNull M m2) {
        d.a.h0.a.a0.f.b k = super.k(m, m2);
        if (!TextUtils.equals(m.x, m2.x)) {
            k.b(9);
        }
        return k;
    }

    public void V(@NonNull V v, @NonNull M m, @NonNull d.a.h0.a.a0.f.b bVar) {
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
        if (d.a.h0.a.a0.b.a.f41079h) {
            Log.d("Component-SimpleDrawee", "renderImageStyle");
        }
        String str = m.x;
        if (TextUtils.isEmpty(str) || (Y = Y(str)) == null) {
            return;
        }
        c.g("Component-SimpleDrawee", "Image Uri:" + Y);
        PipelineDraweeControllerBuilder oldController = Fresco.newDraweeControllerBuilder().setOldController(v.getController());
        if (baseControllerListener != null) {
            oldController.setControllerListener(baseControllerListener);
        }
        oldController.setUri(Y);
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
