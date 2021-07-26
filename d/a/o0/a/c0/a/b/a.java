package d.a.o0.a.c0.a.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import d.a.o0.a.a2.e;
import d.a.o0.a.c0.a.b.b;
import d.a.o0.a.e0.d;
import d.a.o0.a.h0.u.g;
import d.a.o0.a.p.d.h0;
import d.a.o0.a.v2.d0;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public abstract class a<V extends SimpleDraweeView, M extends b> extends d.a.o0.a.c0.a.d.a<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.c0.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C0646a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43962a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2061993245, "Ld/a/o0/a/c0/a/b/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2061993245, "Ld/a/o0/a/c0/a/b/a$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            f43962a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43962a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43962a[PathType.NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43962a[PathType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (d.a.o0.a.c0.a.d.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static Uri Y(@NonNull String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            PathType s = d.a.o0.a.k2.b.s(str);
            e i2 = e.i();
            if (i2 != null) {
                str2 = i2.f43885f;
                str3 = i2.Z();
            } else {
                str2 = null;
                str3 = null;
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return null;
            }
            int i3 = C0646a.f43962a[s.ordinal()];
            if (i3 == 1) {
                String M = d.a.o0.a.k2.b.M(str, str2);
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
                String L = d.a.o0.a.k2.b.L(str, i2, str3);
                if (TextUtils.isEmpty(L)) {
                    return null;
                }
                return Uri.fromFile(new File(L));
            }
        }
        return (Uri) invokeL.objValue;
    }

    @NonNull
    public d.a.o0.a.c0.f.b U(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, m, m2)) == null) {
            d.a.o0.a.c0.f.b k = super.k(m, m2);
            if (!TextUtils.equals(m.x, m2.x)) {
                k.b(9);
            }
            return k;
        }
        return (d.a.o0.a.c0.f.b) invokeLL.objValue;
    }

    public void V(@NonNull V v, @NonNull M m, @NonNull d.a.o0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v, m, bVar) == null) {
            super.D(v, m, bVar);
            if (bVar.a(9)) {
                W(v, m);
            }
        }
    }

    public abstract void W(@NonNull V v, @NonNull M m);

    public final void X(@NonNull V v, @NonNull M m, @Nullable BaseControllerListener<ImageInfo> baseControllerListener) {
        Uri Y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, v, m, baseControllerListener) == null) || m.n == null) {
            return;
        }
        if (d.a.o0.a.c0.b.a.f43968h) {
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
        h0 y = d.a.o0.a.c1.a.y();
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
