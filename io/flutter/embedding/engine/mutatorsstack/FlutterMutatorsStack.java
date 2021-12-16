package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@Keep
/* loaded from: classes4.dex */
public class FlutterMutatorsStack {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Path> finalClippingPaths;
    public Matrix finalMatrix;
    @NonNull
    public List<FlutterMutator> mutators;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class FlutterMutatorType {
        public static final /* synthetic */ FlutterMutatorType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FlutterMutatorType CLIP_PATH;
        public static final FlutterMutatorType CLIP_RECT;
        public static final FlutterMutatorType CLIP_RRECT;
        public static final FlutterMutatorType OPACITY;
        public static final FlutterMutatorType TRANSFORM;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1667008431, "Lio/flutter/embedding/engine/mutatorsstack/FlutterMutatorsStack$FlutterMutatorType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1667008431, "Lio/flutter/embedding/engine/mutatorsstack/FlutterMutatorsStack$FlutterMutatorType;");
                    return;
                }
            }
            CLIP_RECT = new FlutterMutatorType("CLIP_RECT", 0);
            CLIP_RRECT = new FlutterMutatorType("CLIP_RRECT", 1);
            CLIP_PATH = new FlutterMutatorType("CLIP_PATH", 2);
            TRANSFORM = new FlutterMutatorType("TRANSFORM", 3);
            FlutterMutatorType flutterMutatorType = new FlutterMutatorType("OPACITY", 4);
            OPACITY = flutterMutatorType;
            $VALUES = new FlutterMutatorType[]{CLIP_RECT, CLIP_RRECT, CLIP_PATH, TRANSFORM, flutterMutatorType};
        }

        public FlutterMutatorType(String str, int i2) {
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

        public static FlutterMutatorType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FlutterMutatorType) Enum.valueOf(FlutterMutatorType.class, str) : (FlutterMutatorType) invokeL.objValue;
        }

        public static FlutterMutatorType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FlutterMutatorType[]) $VALUES.clone() : (FlutterMutatorType[]) invokeV.objValue;
        }
    }

    public FlutterMutatorsStack() {
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
        this.mutators = new ArrayList();
        this.finalMatrix = new Matrix();
        this.finalClippingPaths = new ArrayList();
    }

    public List<Path> getFinalClippingPaths() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.finalClippingPaths : (List) invokeV.objValue;
    }

    public Matrix getFinalMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.finalMatrix : (Matrix) invokeV.objValue;
    }

    public List<FlutterMutator> getMutators() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mutators : (List) invokeV.objValue;
    }

    public void pushClipRRect(int i2, int i3, int i4, int i5, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), fArr}) == null) {
            Rect rect = new Rect(i2, i3, i4, i5);
            this.mutators.add(new FlutterMutator(this, rect, fArr));
            Path path = new Path();
            path.addRoundRect(new RectF(rect), fArr, Path.Direction.CCW);
            path.transform(this.finalMatrix);
            this.finalClippingPaths.add(path);
        }
    }

    public void pushClipRect(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            Rect rect = new Rect(i2, i3, i4, i5);
            this.mutators.add(new FlutterMutator(this, rect));
            Path path = new Path();
            path.addRect(new RectF(rect), Path.Direction.CCW);
            path.transform(this.finalMatrix);
            this.finalClippingPaths.add(path);
        }
    }

    public void pushTransform(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fArr) == null) {
            Matrix matrix = new Matrix();
            matrix.setValues(fArr);
            FlutterMutator flutterMutator = new FlutterMutator(this, matrix);
            this.mutators.add(flutterMutator);
            this.finalMatrix.preConcat(flutterMutator.getMatrix());
        }
    }

    /* loaded from: classes4.dex */
    public class FlutterMutator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public Matrix matrix;
        @Nullable
        public Path path;
        @Nullable
        public float[] radiis;
        @Nullable
        public Rect rect;
        public final /* synthetic */ FlutterMutatorsStack this$0;
        public FlutterMutatorType type;

        public FlutterMutator(FlutterMutatorsStack flutterMutatorsStack, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterMutatorsStack, rect};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.this$0 = flutterMutatorsStack;
            this.type = FlutterMutatorType.CLIP_RECT;
            this.rect = rect;
        }

        public Matrix getMatrix() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.matrix : (Matrix) invokeV.objValue;
        }

        public Path getPath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.path : (Path) invokeV.objValue;
        }

        public Rect getRect() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.rect : (Rect) invokeV.objValue;
        }

        public FlutterMutatorType getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.type : (FlutterMutatorType) invokeV.objValue;
        }

        public FlutterMutator(FlutterMutatorsStack flutterMutatorsStack, Rect rect, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterMutatorsStack, rect, fArr};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.this$0 = flutterMutatorsStack;
            this.type = FlutterMutatorType.CLIP_RRECT;
            this.rect = rect;
            this.radiis = fArr;
        }

        public FlutterMutator(FlutterMutatorsStack flutterMutatorsStack, Path path) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterMutatorsStack, path};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = flutterMutatorsStack;
            this.type = FlutterMutatorType.CLIP_PATH;
            this.path = path;
        }

        public FlutterMutator(FlutterMutatorsStack flutterMutatorsStack, Matrix matrix) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterMutatorsStack, matrix};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flutterMutatorsStack;
            this.type = FlutterMutatorType.TRANSFORM;
            this.matrix = matrix;
        }
    }
}
