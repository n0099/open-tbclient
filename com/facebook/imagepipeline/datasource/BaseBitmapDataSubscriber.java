package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void onNewResultImpl(@Nullable Bitmap bitmap);

    public BaseBitmapDataSubscriber() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource dataSource) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) != null) || !dataSource.isFinished()) {
            return;
        }
        CloseableReference closeableReference = (CloseableReference) dataSource.getResult();
        Bitmap bitmap = null;
        if (closeableReference != null && (closeableReference.get() instanceof CloseableBitmap)) {
            bitmap = ((CloseableBitmap) closeableReference.get()).getUnderlyingBitmap();
        }
        try {
            onNewResultImpl(bitmap);
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }
}
