package com.kwad.sdk.lib.desigin;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes7.dex */
public class CustomAppBarBehaviorParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mEnableNestedFling;
    public final boolean mEnableRebound;
    public final int mExtraFixedSize;
    public final int mFlingConsumeViewId;
    public final int mReboundMaxOffset;
    public final int mReboundViewId;

    /* renamed from: com.kwad.sdk.lib.desigin.CustomAppBarBehaviorParams$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mEnableNestedFling;
        public boolean mEnableRebound;
        public int mExtraFixedSize;
        public int mFlingConsumeViewId;
        public int mReboundMaxOffset;
        public int mReboundViewId;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mEnableRebound = true;
        }

        public CustomAppBarBehaviorParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new CustomAppBarBehaviorParams(this, null) : (CustomAppBarBehaviorParams) invokeV.objValue;
        }

        public Builder setEnableNestedFling(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.mEnableNestedFling = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEnableRebound(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.mEnableRebound = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setExtraFixedSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.mExtraFixedSize = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setFlingConsumeViewId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.mFlingConsumeViewId = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setReboundMaxOffset(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.mReboundMaxOffset = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setReboundViewId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.mReboundViewId = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    public CustomAppBarBehaviorParams(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFlingConsumeViewId = builder.mFlingConsumeViewId;
        this.mExtraFixedSize = builder.mExtraFixedSize;
        this.mEnableNestedFling = builder.mEnableNestedFling;
        this.mReboundMaxOffset = builder.mReboundMaxOffset;
        this.mReboundViewId = builder.mReboundViewId;
        this.mEnableRebound = builder.mEnableRebound;
    }

    public /* synthetic */ CustomAppBarBehaviorParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
