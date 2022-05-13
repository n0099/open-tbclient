package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class im9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final List<jm9> b;

    public im9(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = jSONObject.optString("imageKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    jm9 jm9Var = new jm9(optJSONObject);
                    if ((!jm9Var.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.first((List<? extends Object>) jm9Var.d())).e() && arrayList.size() > 0) {
                        jm9Var.f(((jm9) CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList)).d());
                    }
                    arrayList.add(jm9Var);
                }
            }
        }
        this.b = CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public final List<jm9> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public im9(SpriteEntity spriteEntity) {
        List<jm9> emptyList;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spriteEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = spriteEntity.imageKey;
        List<FrameEntity> list = spriteEntity.frames;
        if (list != null) {
            emptyList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            jm9 jm9Var = null;
            for (FrameEntity it : list) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                jm9 jm9Var2 = new jm9(it);
                if ((!jm9Var2.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.first((List<? extends Object>) jm9Var2.d())).e() && jm9Var != null) {
                    jm9Var2.f(jm9Var.d());
                }
                emptyList.add(jm9Var2);
                jm9Var = jm9Var2;
            }
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.b = emptyList;
    }
}
