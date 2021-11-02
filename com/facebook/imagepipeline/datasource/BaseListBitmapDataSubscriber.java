package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseListBitmapDataSubscriber() {
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

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<List<CloseableReference<CloseableImage>>> dataSource) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) && dataSource.isFinished()) {
            List<CloseableReference<CloseableImage>> result = dataSource.getResult();
            if (result == null) {
                onNewResultListImpl(null);
                return;
            }
            try {
                ArrayList arrayList = new ArrayList(result.size());
                for (CloseableReference<CloseableImage> closeableReference : result) {
                    if (closeableReference != null && (closeableReference.get() instanceof CloseableBitmap)) {
                        arrayList.add(((CloseableBitmap) closeableReference.get()).getUnderlyingBitmap());
                    } else {
                        arrayList.add(null);
                    }
                }
                onNewResultListImpl(arrayList);
            } finally {
                for (CloseableReference<CloseableImage> next : result) {
                    CloseableReference.closeSafely(next);
                }
            }
        }
    }

    public abstract void onNewResultListImpl(List<Bitmap> list);
}
