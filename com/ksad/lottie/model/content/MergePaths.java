package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.ActLog;
/* loaded from: classes7.dex */
public class MergePaths implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f33876a;

    /* renamed from: b  reason: collision with root package name */
    public final MergePathsMode f33877b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class MergePathsMode {
        public static final /* synthetic */ MergePathsMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MergePathsMode Add;
        public static final MergePathsMode ExcludeIntersections;
        public static final MergePathsMode Intersect;
        public static final MergePathsMode Merge;
        public static final MergePathsMode Subtract;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1545221642, "Lcom/ksad/lottie/model/content/MergePaths$MergePathsMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1545221642, "Lcom/ksad/lottie/model/content/MergePaths$MergePathsMode;");
                    return;
                }
            }
            Merge = new MergePathsMode("Merge", 0);
            Add = new MergePathsMode(ActLog.TYPE_ADD, 1);
            Subtract = new MergePathsMode("Subtract", 2);
            Intersect = new MergePathsMode("Intersect", 3);
            MergePathsMode mergePathsMode = new MergePathsMode("ExcludeIntersections", 4);
            ExcludeIntersections = mergePathsMode;
            $VALUES = new MergePathsMode[]{Merge, Add, Subtract, Intersect, mergePathsMode};
        }

        public MergePathsMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MergePathsMode forId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? Merge : ExcludeIntersections : Intersect : Subtract : Add : Merge : (MergePathsMode) invokeI.objValue;
        }

        public static MergePathsMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (MergePathsMode) Enum.valueOf(MergePathsMode.class, str) : (MergePathsMode) invokeL.objValue;
        }

        public static MergePathsMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (MergePathsMode[]) $VALUES.clone() : (MergePathsMode[]) invokeV.objValue;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, mergePathsMode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33876a = str;
        this.f33877b = mergePathsMode;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
            if (fVar.a()) {
                return new com.ksad.lottie.a.a.k(this);
            }
            com.ksad.lottie.c.b("Animation contains merge paths but they are disabled.");
            return null;
        }
        return (com.ksad.lottie.a.a.b) invokeLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33876a : (String) invokeV.objValue;
    }

    public MergePathsMode b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33877b : (MergePathsMode) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "MergePaths{mode=" + this.f33877b + '}';
        }
        return (String) invokeV.objValue;
    }
}
