package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class AdaptationSet {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ID_UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final List accessibilityDescriptors;
    public final int id;
    public final List representations;
    public final List supplementalProperties;
    public final int type;

    public AdaptationSet(int i, int i2, List list, List list2, List list3) {
        List unmodifiableList;
        List unmodifiableList2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), list, list2, list3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.id = i;
        this.type = i2;
        this.representations = Collections.unmodifiableList(list);
        if (list2 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list2);
        }
        this.accessibilityDescriptors = unmodifiableList;
        if (list3 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            unmodifiableList2 = Collections.unmodifiableList(list3);
        }
        this.supplementalProperties = unmodifiableList2;
    }
}
