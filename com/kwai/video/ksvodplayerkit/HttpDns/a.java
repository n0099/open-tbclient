package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class a implements Comparable<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f39825a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final String f39826b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final f f39827c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f39828d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public String f39829e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NonNull String str, @NonNull String str2, @Nullable f fVar) {
        this(str, str2, fVar, (Map<String, String>) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (f) objArr2[2], (Map) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable f fVar, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, fVar, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39825a = str;
        this.f39826b = str2;
        this.f39827c = fVar;
        this.f39828d = map;
    }

    public a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, fVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f39825a = str;
        this.f39826b = str3;
        this.f39827c = fVar;
        this.f39829e = str2;
        this.f39828d = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            f fVar2 = this.f39827c;
            if (fVar2 == null || (fVar = aVar.f39827c) == null) {
                return 0;
            }
            return (int) (fVar2.f39846e - fVar.f39846e);
        }
        return invokeL.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                String str = this.f39826b;
                String str2 = ((a) obj).f39826b;
                return str != null ? str.equals(str2) : str2 == null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
