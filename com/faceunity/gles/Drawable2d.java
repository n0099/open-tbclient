package com.faceunity.gles;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class Drawable2d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final FloatBuffer FULL_RECTANGLE_BUF;
    public static final float[] FULL_RECTANGLE_COORDS;
    public static final FloatBuffer FULL_RECTANGLE_TEX_BUF;
    public static final float[] FULL_RECTANGLE_TEX_COORDS;
    public static final FloatBuffer RECTANGLE_BUF;
    public static final float[] RECTANGLE_COORDS;
    public static final FloatBuffer RECTANGLE_TEX_BUF;
    public static final float[] RECTANGLE_TEX_COORDS;
    public static final int SIZEOF_FLOAT = 4;
    public static final FloatBuffer TRIANGLE_BUF;
    public static final float[] TRIANGLE_COORDS;
    public static final FloatBuffer TRIANGLE_TEX_BUF;
    public static final float[] TRIANGLE_TEX_COORDS;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCoordsPerVertex;
    public Prefab mPrefab;
    public FloatBuffer mTexCoordArray;
    public int mTexCoordStride;
    public FloatBuffer mVertexArray;
    public int mVertexCount;
    public int mVertexStride;

    /* renamed from: com.faceunity.gles.Drawable2d$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$faceunity$gles$Drawable2d$Prefab;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1397901619, "Lcom/faceunity/gles/Drawable2d$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1397901619, "Lcom/faceunity/gles/Drawable2d$1;");
                    return;
                }
            }
            int[] iArr = new int[Prefab.values().length];
            $SwitchMap$com$faceunity$gles$Drawable2d$Prefab = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$faceunity$gles$Drawable2d$Prefab[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$faceunity$gles$Drawable2d$Prefab[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class Prefab {
        public static final /* synthetic */ Prefab[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Prefab FULL_RECTANGLE;
        public static final Prefab RECTANGLE;
        public static final Prefab TRIANGLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1540009554, "Lcom/faceunity/gles/Drawable2d$Prefab;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1540009554, "Lcom/faceunity/gles/Drawable2d$Prefab;");
                    return;
                }
            }
            TRIANGLE = new Prefab("TRIANGLE", 0);
            RECTANGLE = new Prefab("RECTANGLE", 1);
            Prefab prefab = new Prefab("FULL_RECTANGLE", 2);
            FULL_RECTANGLE = prefab;
            $VALUES = new Prefab[]{TRIANGLE, RECTANGLE, prefab};
        }

        public Prefab(String str, int i2) {
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

        public static Prefab valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Prefab) Enum.valueOf(Prefab.class, str) : (Prefab) invokeL.objValue;
        }

        public static Prefab[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Prefab[]) $VALUES.clone() : (Prefab[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1477873312, "Lcom/faceunity/gles/Drawable2d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1477873312, "Lcom/faceunity/gles/Drawable2d;");
                return;
            }
        }
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        TRIANGLE_COORDS = fArr;
        TRIANGLE_TEX_COORDS = new float[]{0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TRIANGLE_BUF = GlUtil.createFloatBuffer(fArr);
        TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(TRIANGLE_TEX_COORDS);
        float[] fArr2 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        RECTANGLE_COORDS = fArr2;
        RECTANGLE_TEX_COORDS = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr2);
        RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(RECTANGLE_TEX_COORDS);
        float[] fArr3 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_COORDS = fArr3;
        FULL_RECTANGLE_TEX_COORDS = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr3);
        FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
    }

    public Drawable2d(Prefab prefab) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {prefab};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int i4 = AnonymousClass1.$SwitchMap$com$faceunity$gles$Drawable2d$Prefab[prefab.ordinal()];
        if (i4 == 1) {
            this.mVertexArray = TRIANGLE_BUF;
            this.mTexCoordArray = TRIANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = TRIANGLE_COORDS.length / 2;
        } else if (i4 == 2) {
            this.mVertexArray = RECTANGLE_BUF;
            this.mTexCoordArray = RECTANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = RECTANGLE_COORDS.length / 2;
        } else if (i4 == 3) {
            this.mVertexArray = FULL_RECTANGLE_BUF;
            this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = FULL_RECTANGLE_COORDS.length / 2;
        } else {
            throw new RuntimeException("Unknown shape " + prefab);
        }
        this.mTexCoordStride = 8;
        this.mPrefab = prefab;
    }

    public int getCoordsPerVertex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCoordsPerVertex : invokeV.intValue;
    }

    public FloatBuffer getTexCoordArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTexCoordArray : (FloatBuffer) invokeV.objValue;
    }

    public int getTexCoordStride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTexCoordStride : invokeV.intValue;
    }

    public FloatBuffer getVertexArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVertexArray : (FloatBuffer) invokeV.objValue;
    }

    public int getVertexCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVertexCount : invokeV.intValue;
    }

    public int getVertexStride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mVertexStride : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mPrefab != null) {
                return "[Drawable2d: " + this.mPrefab + PreferencesUtil.RIGHT_MOUNT;
            }
            return "[Drawable2d: ...]";
        }
        return (String) invokeV.objValue;
    }
}
