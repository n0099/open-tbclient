package com.google.ar.core;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class AugmentedFace extends TrackableBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class RegionType {
        public static final /* synthetic */ RegionType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RegionType FOREHEAD_LEFT;
        public static final RegionType FOREHEAD_RIGHT;
        public static final RegionType NOSE_TIP;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1023977640, "Lcom/google/ar/core/AugmentedFace$RegionType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1023977640, "Lcom/google/ar/core/AugmentedFace$RegionType;");
                    return;
                }
            }
            NOSE_TIP = new RegionType("NOSE_TIP", 0, 0);
            FOREHEAD_LEFT = new RegionType("FOREHEAD_LEFT", 1, 1);
            RegionType regionType = new RegionType("FOREHEAD_RIGHT", 2, 2);
            FOREHEAD_RIGHT = regionType;
            $VALUES = new RegionType[]{NOSE_TIP, FOREHEAD_LEFT, regionType};
        }

        public RegionType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeCode = i3;
        }

        public static RegionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RegionType) Enum.valueOf(RegionType.class, str) : (RegionType) invokeL.objValue;
        }

        public static RegionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RegionType[]) $VALUES.clone() : (RegionType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AugmentedFace(long j2, Session session) {
        super(j2, session);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), session};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Long) objArr2[0]).longValue(), (Session) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }

    private native Pose nativeGetCenterPose(long j2, long j3);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j2, long j3);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j2, long j3);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j2, long j3);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j2, long j3);

    private native Pose nativeGetRegionPose(long j2, long j3, int i2);

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Session.a(nativeGetMeshVerticesByteBuffer(this.f52963b.a, this.a)).asFloatBuffer().asReadOnlyBuffer();
            Session.a(nativeGetMeshNormalsByteBuffer(this.f52963b.a, this.a)).asFloatBuffer().asReadOnlyBuffer();
            Session.a(nativeGetMeshTextureCoordinatesByteBuffer(this.f52963b.a, this.a)).asFloatBuffer().asReadOnlyBuffer();
            Session.a(nativeGetMeshTriangleIndicesByteBuffer(this.f52963b.a, this.a)).asCharBuffer().asReadOnlyBuffer();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AugmentedFace() {
        super(0L, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Long) objArr[0]).longValue(), (Session) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
