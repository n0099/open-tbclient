package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.bytedance.sdk.openadsdk.preload.b.d<List<String>, List<Pair<String, Long>>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public File f68738d;

    /* renamed from: e  reason: collision with root package name */
    public String f68739e;

    public d() {
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

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
            super.a(objArr);
            this.f68738d = (File) objArr[0];
            this.f68739e = (String) objArr[1];
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<List<Pair<String, Long>>> bVar, List<String> list) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "get local channel version:", list);
            File file = new File(this.f68738d, this.f68739e);
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                Long a2 = k.a(new File(file, str));
                arrayList.add(new Pair<>(str, Long.valueOf(a2 == null ? 0L : a2.longValue())));
            }
            return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<List<Pair<String, Long>>>) arrayList);
        }
        return invokeLL.objValue;
    }
}
