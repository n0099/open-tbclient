package com.repackage;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes6.dex */
public class o42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public final /* synthetic */ int b;

        public a(b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.b = i;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                super.onCancellation(dataSource);
                o42.b(this.b, this.a, "download icon fail: onCancellation");
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                o42.b(this.b, this.a, "download icon fail: onFailureImpl");
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                if (bitmap == null || bitmap.isRecycled()) {
                    o42.b(this.b, this.a, "download icon fail: bitmap is null or is recycled");
                    return;
                }
                try {
                    if (bitmap.getConfig() == null) {
                        copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        copy = bitmap.copy(bitmap.getConfig(), true);
                    }
                    if (this.a != null) {
                        this.a.a(copy);
                    }
                } catch (Exception e) {
                    int i = this.b;
                    b bVar = this.a;
                    o42.b(i, bVar, "download icon fail: " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(Bitmap bitmap);
    }

    public static void b(int i, b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65537, null, i, bVar, str) == null) {
            nc3 nc3Var = new nc3();
            nc3Var.k(4L);
            nc3Var.i(10L);
            nc3Var.f(str);
            rc3.a().f(nc3Var);
            v73 v73Var = new v73();
            v73Var.p(nc3Var);
            v73Var.q(n73.n(i));
            n73.R(v73Var);
            if (bVar != null) {
                bVar.a(null);
            }
        }
    }

    public static void c(String str, int i, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, str, i, bVar) == null) {
            Uri C = oe3.C(str);
            if (C == null) {
                b(i, bVar, "download icon fail: icon url is null");
                return;
            }
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(C).build(), AppRuntime.getAppContext()).subscribe(new a(bVar, i), UiThreadImmediateExecutorService.getInstance());
        }
    }
}
