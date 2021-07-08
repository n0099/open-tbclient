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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class e extends com.bytedance.sdk.openadsdk.preload.b.d<String, Map<String, List<Pair<String, Long>>>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public File f32198d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f32199e;

    public e() {
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
            this.f32198d = (File) objArr[0];
            this.f32199e = (List) objArr[1];
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Map<String, List<Pair<String, Long>>>> bVar, String str) throws Exception {
        InterceptResult invokeLL;
        Long a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, str)) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "get local channel version:", str);
            HashMap hashMap = new HashMap();
            for (String str2 : this.f32199e) {
                File file = new File(this.f32198d, str2);
                String[] list = file.list();
                ArrayList arrayList = new ArrayList();
                if (list != null && list.length > 0) {
                    for (String str3 : list) {
                        File file2 = new File(file, str3);
                        if (file2.isDirectory() && (a2 = k.a(file2)) != null) {
                            arrayList.add(new Pair<>(str3, a2));
                        }
                    }
                }
                hashMap.put(str2, arrayList);
            }
            return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Map<String, List<Pair<String, Long>>>>) hashMap);
        }
        return invokeLL.objValue;
    }
}
