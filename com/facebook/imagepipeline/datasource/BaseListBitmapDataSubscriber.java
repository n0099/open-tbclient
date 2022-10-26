package com.facebook.imagepipeline.datasource;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void onNewResultListImpl(List list);

    public BaseListBitmapDataSubscriber() {
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
        if ((interceptable != null && interceptable.invokeL(1048576, this, dataSource) != null) || !dataSource.isFinished()) {
            return;
        }
        List<CloseableReference> list = (List) dataSource.getResult();
        if (list == null) {
            onNewResultListImpl(null);
            return;
        }
        try {
            ArrayList arrayList = new ArrayList(list.size());
            for (CloseableReference closeableReference : list) {
                if (closeableReference != null && (closeableReference.get() instanceof CloseableBitmap)) {
                    arrayList.add(((CloseableBitmap) closeableReference.get()).getUnderlyingBitmap());
                } else {
                    arrayList.add(null);
                }
            }
            onNewResultListImpl(arrayList);
        } finally {
            for (CloseableReference closeableReference2 : list) {
                CloseableReference.closeSafely(closeableReference2);
            }
        }
    }
}
