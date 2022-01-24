package com.facebook.common.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.infer.annotation.Functional;
import javax.annotation.Nullable;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class TriState {
    public static final /* synthetic */ TriState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TriState NO;
    public static final TriState UNSET;
    public static final TriState YES;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.facebook.common.util.TriState$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$common$util$TriState;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1427894192, "Lcom/facebook/common/util/TriState$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1427894192, "Lcom/facebook/common/util/TriState$1;");
                    return;
                }
            }
            int[] iArr = new int[TriState.values().length];
            $SwitchMap$com$facebook$common$util$TriState = iArr;
            try {
                iArr[TriState.YES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$common$util$TriState[TriState.NO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$common$util$TriState[TriState.UNSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2146734877, "Lcom/facebook/common/util/TriState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2146734877, "Lcom/facebook/common/util/TriState;");
                return;
            }
        }
        YES = new TriState("YES", 0);
        NO = new TriState("NO", 1);
        TriState triState = new TriState("UNSET", 2);
        UNSET = triState;
        $VALUES = new TriState[]{YES, NO, triState};
    }

    public TriState(String str, int i2) {
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

    @Functional
    public static TriState fromDbValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return UNSET;
                }
                return NO;
            }
            return YES;
        }
        return (TriState) invokeI.objValue;
    }

    public static TriState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (TriState) Enum.valueOf(TriState.class, str) : (TriState) invokeL.objValue;
    }

    public static TriState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? (TriState[]) $VALUES.clone() : (TriState[]) invokeV.objValue;
    }

    @Functional
    public boolean asBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("Unrecognized TriState value: " + this);
                    }
                    throw new IllegalStateException("No boolean equivalent for UNSET");
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    @Functional
    public Boolean asBooleanObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized TriState value: " + this);
                }
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        return (Boolean) invokeV.objValue;
    }

    @Functional
    public int getDbValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
            int i3 = 1;
            if (i2 != 1) {
                i3 = 2;
                if (i2 != 2) {
                    return 3;
                }
            }
            return i3;
        }
        return invokeV.intValue;
    }

    @Functional
    public boolean isSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this != UNSET : invokeV.booleanValue;
    }

    @Functional
    public static TriState valueOf(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) ? z ? YES : NO : (TriState) invokeZ.objValue;
    }

    @Functional
    public static TriState valueOf(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bool)) == null) ? bool != null ? valueOf(bool.booleanValue()) : UNSET : (TriState) invokeL.objValue;
    }

    @Functional
    public boolean asBoolean(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return z;
                    }
                    throw new IllegalStateException("Unrecognized TriState value: " + this);
                }
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }
}
