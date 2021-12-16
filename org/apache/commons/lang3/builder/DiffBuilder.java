package org.apache.commons.lang3.builder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
/* loaded from: classes4.dex */
public class DiffBuilder implements Builder<DiffResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Diff<?>> diffs;
    public final Object left;
    public final boolean objectsTriviallyEqual;
    public final Object right;
    public final ToStringStyle style;

    public DiffBuilder(Object obj, Object obj2, ToStringStyle toStringStyle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, obj2, toStringStyle, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (obj == null) {
            throw new IllegalArgumentException("lhs cannot be null");
        }
        if (obj2 != null) {
            this.diffs = new ArrayList();
            this.left = obj;
            this.right = obj2;
            this.style = toStringStyle;
            this.objectsTriviallyEqual = z && (obj == obj2 || obj.equals(obj2));
            return;
        }
        throw new IllegalArgumentException("rhs cannot be null");
    }

    public DiffBuilder append(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && z != z2) {
                    this.diffs.add(new Diff<Boolean>(this, str, z, z2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.1
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ boolean val$lhs;
                        public final /* synthetic */ boolean val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = z;
                            this.val$rhs = z2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Boolean getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.valueOf(this.val$lhs) : (Boolean) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Boolean getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Boolean.valueOf(this.val$rhs) : (Boolean) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.builder.Builder
    public DiffResult build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? new DiffResult(this.left, this.right, this.diffs, this.style) : (DiffResult) invokeV.objValue;
    }

    public DiffBuilder append(String str, boolean[] zArr, boolean[] zArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, zArr, zArr2)) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && !Arrays.equals(zArr, zArr2)) {
                    this.diffs.add(new Diff<Boolean[]>(this, str, zArr, zArr2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.2
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ boolean[] val$lhs;
                        public final /* synthetic */ boolean[] val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, zArr, zArr2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = zArr;
                            this.val$rhs = zArr2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Boolean[] getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ArrayUtils.toObject(this.val$lhs) : (Boolean[]) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Boolean[] getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? ArrayUtils.toObject(this.val$rhs) : (Boolean[]) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLLL.objValue;
    }

    public DiffBuilder append(String str, byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && b2 != b3) {
                    this.diffs.add(new Diff<Byte>(this, str, b2, b3) { // from class: org.apache.commons.lang3.builder.DiffBuilder.3
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ byte val$lhs;
                        public final /* synthetic */ byte val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, Byte.valueOf(b2), Byte.valueOf(b3)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = b2;
                            this.val$rhs = b3;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Byte getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Byte.valueOf(this.val$lhs) : (Byte) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Byte getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Byte.valueOf(this.val$rhs) : (Byte) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeCommon.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiffBuilder(Object obj, Object obj2, ToStringStyle toStringStyle) {
        this(obj, obj2, toStringStyle, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, obj2, toStringStyle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(objArr2[0], objArr2[1], (ToStringStyle) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public DiffBuilder append(String str, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, bArr, bArr2)) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && !Arrays.equals(bArr, bArr2)) {
                    this.diffs.add(new Diff<Byte[]>(this, str, bArr, bArr2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.4
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ byte[] val$lhs;
                        public final /* synthetic */ byte[] val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, bArr, bArr2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = bArr;
                            this.val$rhs = bArr2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Byte[] getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ArrayUtils.toObject(this.val$lhs) : (Byte[]) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Byte[] getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? ArrayUtils.toObject(this.val$rhs) : (Byte[]) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLLL.objValue;
    }

    public DiffBuilder append(String str, char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Character.valueOf(c2), Character.valueOf(c3)})) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && c2 != c3) {
                    this.diffs.add(new Diff<Character>(this, str, c2, c3) { // from class: org.apache.commons.lang3.builder.DiffBuilder.5
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ char val$lhs;
                        public final /* synthetic */ char val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, Character.valueOf(c2), Character.valueOf(c3)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = c2;
                            this.val$rhs = c3;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Character getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Character.valueOf(this.val$lhs) : (Character) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Character getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Character.valueOf(this.val$rhs) : (Character) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeCommon.objValue;
    }

    public DiffBuilder append(String str, char[] cArr, char[] cArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, cArr, cArr2)) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && !Arrays.equals(cArr, cArr2)) {
                    this.diffs.add(new Diff<Character[]>(this, str, cArr, cArr2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.6
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ char[] val$lhs;
                        public final /* synthetic */ char[] val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, cArr, cArr2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = cArr;
                            this.val$rhs = cArr2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Character[] getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ArrayUtils.toObject(this.val$lhs) : (Character[]) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Character[] getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? ArrayUtils.toObject(this.val$rhs) : (Character[]) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLLL.objValue;
    }

    public DiffBuilder append(String str, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && Double.doubleToLongBits(d2) != Double.doubleToLongBits(d3)) {
                    this.diffs.add(new Diff<Double>(this, str, d2, d3) { // from class: org.apache.commons.lang3.builder.DiffBuilder.7
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ double val$lhs;
                        public final /* synthetic */ double val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, Double.valueOf(d2), Double.valueOf(d3)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = d2;
                            this.val$rhs = d3;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Double getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Double.valueOf(this.val$lhs) : (Double) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Double getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Double.valueOf(this.val$rhs) : (Double) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeCommon.objValue;
    }

    public DiffBuilder append(String str, double[] dArr, double[] dArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, str, dArr, dArr2)) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && !Arrays.equals(dArr, dArr2)) {
                    this.diffs.add(new Diff<Double[]>(this, str, dArr, dArr2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.8
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ double[] val$lhs;
                        public final /* synthetic */ double[] val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, dArr, dArr2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = dArr;
                            this.val$rhs = dArr2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Double[] getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ArrayUtils.toObject(this.val$lhs) : (Double[]) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Double[] getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? ArrayUtils.toObject(this.val$rhs) : (Double[]) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLLL.objValue;
    }

    public DiffBuilder append(String str, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && Float.floatToIntBits(f2) != Float.floatToIntBits(f3)) {
                    this.diffs.add(new Diff<Float>(this, str, f2, f3) { // from class: org.apache.commons.lang3.builder.DiffBuilder.9
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ float val$lhs;
                        public final /* synthetic */ float val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, Float.valueOf(f2), Float.valueOf(f3)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = f2;
                            this.val$rhs = f3;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Float getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Float.valueOf(this.val$lhs) : (Float) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Float getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Float.valueOf(this.val$rhs) : (Float) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeCommon.objValue;
    }

    public DiffBuilder append(String str, float[] fArr, float[] fArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, str, fArr, fArr2)) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && !Arrays.equals(fArr, fArr2)) {
                    this.diffs.add(new Diff<Float[]>(this, str, fArr, fArr2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.10
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ float[] val$lhs;
                        public final /* synthetic */ float[] val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, fArr, fArr2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = fArr;
                            this.val$rhs = fArr2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Float[] getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ArrayUtils.toObject(this.val$lhs) : (Float[]) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Float[] getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? ArrayUtils.toObject(this.val$rhs) : (Float[]) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLLL.objValue;
    }

    public DiffBuilder append(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, str, i2, i3)) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && i2 != i3) {
                    this.diffs.add(new Diff<Integer>(this, str, i2, i3) { // from class: org.apache.commons.lang3.builder.DiffBuilder.11
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ int val$lhs;
                        public final /* synthetic */ int val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, Integer.valueOf(i2), Integer.valueOf(i3)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = i2;
                            this.val$rhs = i3;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Integer getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Integer.valueOf(this.val$lhs) : (Integer) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Integer getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Integer.valueOf(this.val$rhs) : (Integer) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLII.objValue;
    }

    public DiffBuilder append(String str, int[] iArr, int[] iArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, str, iArr, iArr2)) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && !Arrays.equals(iArr, iArr2)) {
                    this.diffs.add(new Diff<Integer[]>(this, str, iArr, iArr2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.12
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ int[] val$lhs;
                        public final /* synthetic */ int[] val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, iArr, iArr2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = iArr;
                            this.val$rhs = iArr2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Integer[] getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ArrayUtils.toObject(this.val$lhs) : (Integer[]) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Integer[] getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? ArrayUtils.toObject(this.val$rhs) : (Integer[]) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLLL.objValue;
    }

    public DiffBuilder append(String str, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && j2 != j3) {
                    this.diffs.add(new Diff<Long>(this, str, j2, j3) { // from class: org.apache.commons.lang3.builder.DiffBuilder.13
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ long val$lhs;
                        public final /* synthetic */ long val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, Long.valueOf(j2), Long.valueOf(j3)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = j2;
                            this.val$rhs = j3;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Long getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Long.valueOf(this.val$lhs) : (Long) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Long getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Long.valueOf(this.val$rhs) : (Long) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeCommon.objValue;
    }

    public DiffBuilder append(String str, long[] jArr, long[] jArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, jArr, jArr2)) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && !Arrays.equals(jArr, jArr2)) {
                    this.diffs.add(new Diff<Long[]>(this, str, jArr, jArr2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.14
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ long[] val$lhs;
                        public final /* synthetic */ long[] val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, jArr, jArr2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = jArr;
                            this.val$rhs = jArr2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Long[] getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ArrayUtils.toObject(this.val$lhs) : (Long[]) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Long[] getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? ArrayUtils.toObject(this.val$rhs) : (Long[]) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLLL.objValue;
    }

    public DiffBuilder append(String str, short s, short s2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Short.valueOf(s), Short.valueOf(s2)})) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && s != s2) {
                    this.diffs.add(new Diff<Short>(this, str, s, s2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.15
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ short val$lhs;
                        public final /* synthetic */ short val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, Short.valueOf(s), Short.valueOf(s2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = s;
                            this.val$rhs = s2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Short getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Short.valueOf(this.val$lhs) : (Short) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Short getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? Short.valueOf(this.val$rhs) : (Short) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeCommon.objValue;
    }

    public DiffBuilder append(String str, short[] sArr, short[] sArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, sArr, sArr2)) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && !Arrays.equals(sArr, sArr2)) {
                    this.diffs.add(new Diff<Short[]>(this, str, sArr, sArr2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.16
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ short[] val$lhs;
                        public final /* synthetic */ short[] val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, sArr, sArr2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = sArr;
                            this.val$rhs = sArr2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Short[] getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ArrayUtils.toObject(this.val$lhs) : (Short[]) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Short[] getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? ArrayUtils.toObject(this.val$rhs) : (Short[]) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLLL.objValue;
    }

    public DiffBuilder append(String str, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, obj, obj2)) == null) {
            if (str != null) {
                if (this.objectsTriviallyEqual || obj == obj2) {
                    return this;
                }
                Object obj3 = obj != null ? obj : obj2;
                if (obj3.getClass().isArray()) {
                    if (obj3 instanceof boolean[]) {
                        return append(str, (boolean[]) obj, (boolean[]) obj2);
                    }
                    if (obj3 instanceof byte[]) {
                        return append(str, (byte[]) obj, (byte[]) obj2);
                    }
                    if (obj3 instanceof char[]) {
                        return append(str, (char[]) obj, (char[]) obj2);
                    }
                    if (obj3 instanceof double[]) {
                        return append(str, (double[]) obj, (double[]) obj2);
                    }
                    if (obj3 instanceof float[]) {
                        return append(str, (float[]) obj, (float[]) obj2);
                    }
                    if (obj3 instanceof int[]) {
                        return append(str, (int[]) obj, (int[]) obj2);
                    }
                    if (obj3 instanceof long[]) {
                        return append(str, (long[]) obj, (long[]) obj2);
                    }
                    if (obj3 instanceof short[]) {
                        return append(str, (short[]) obj, (short[]) obj2);
                    }
                    return append(str, (Object[]) obj, (Object[]) obj2);
                } else if (obj == null || !obj.equals(obj2)) {
                    this.diffs.add(new Diff<Object>(this, str, obj, obj2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.17
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ Object val$lhs;
                        public final /* synthetic */ Object val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, obj, obj2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = obj;
                            this.val$rhs = obj2;
                        }

                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Object getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$lhs : invokeV.objValue;
                        }

                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Object getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$rhs : invokeV.objValue;
                        }
                    });
                    return this;
                } else {
                    return this;
                }
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLLL.objValue;
    }

    public DiffBuilder append(String str, Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, str, objArr, objArr2)) == null) {
            if (str != null) {
                if (!this.objectsTriviallyEqual && !Arrays.equals(objArr, objArr2)) {
                    this.diffs.add(new Diff<Object[]>(this, str, objArr, objArr2) { // from class: org.apache.commons.lang3.builder.DiffBuilder.18
                        public static /* synthetic */ Interceptable $ic = null;
                        public static final long serialVersionUID = 1;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DiffBuilder this$0;
                        public final /* synthetic */ Object[] val$lhs;
                        public final /* synthetic */ Object[] val$rhs;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr3 = {this, str, objArr, objArr2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$lhs = objArr;
                            this.val$rhs = objArr2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Object[] getLeft() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$lhs : (Object[]) invokeV.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // org.apache.commons.lang3.tuple.Pair
                        public Object[] getRight() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.val$rhs : (Object[]) invokeV.objValue;
                        }
                    });
                }
                return this;
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLLL.objValue;
    }

    public DiffBuilder append(String str, DiffResult diffResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, diffResult)) == null) {
            if (str != null) {
                if (diffResult != null) {
                    if (this.objectsTriviallyEqual) {
                        return this;
                    }
                    for (Diff<?> diff : diffResult.getDiffs()) {
                        append(str + "." + diff.getFieldName(), diff.getLeft(), diff.getRight());
                    }
                    return this;
                }
                throw new IllegalArgumentException("Diff result cannot be null");
            }
            throw new IllegalArgumentException("Field name cannot be null");
        }
        return (DiffBuilder) invokeLL.objValue;
    }
}
