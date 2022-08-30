package com.google.gson.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Excluder DEFAULT;
    public static final double IGNORE_VERSIONS = -1.0d;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ExclusionStrategy> deserializationStrategies;
    public int modifiers;
    public boolean requireExpose;
    public List<ExclusionStrategy> serializationStrategies;
    public boolean serializeInnerClasses;
    public double version;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-406126855, "Lcom/google/gson/internal/Excluder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-406126855, "Lcom/google/gson/internal/Excluder;");
                return;
            }
        }
        DEFAULT = new Excluder();
    }

    public Excluder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.version = -1.0d;
        this.modifiers = 136;
        this.serializeInnerClasses = true;
        this.serializationStrategies = Collections.emptyList();
        this.deserializationStrategies = Collections.emptyList();
    }

    private boolean excludeClassChecks(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, cls)) == null) {
            if (this.version == -1.0d || isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
                return (!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean excludeClassInStrategy(Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, this, cls, z)) == null) {
            for (ExclusionStrategy exclusionStrategy : z ? this.serializationStrategies : this.deserializationStrategies) {
                if (exclusionStrategy.shouldSkipClass(cls)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    private boolean isAnonymousOrLocal(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cls)) == null) ? !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass()) : invokeL.booleanValue;
    }

    private boolean isInnerClass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, cls)) == null) ? cls.isMemberClass() && !isStatic(cls) : invokeL.booleanValue;
    }

    private boolean isStatic(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, this, cls)) == null) ? (cls.getModifiers() & 8) != 0 : invokeL.booleanValue;
    }

    private boolean isValidSince(Since since) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, since)) == null) ? since == null || since.value() <= this.version : invokeL.booleanValue;
    }

    private boolean isValidUntil(Until until) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, until)) == null) ? until == null || until.value() > this.version : invokeL.booleanValue;
    }

    private boolean isValidVersion(Since since, Until until) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, since, until)) == null) ? isValidSince(since) && isValidUntil(until) : invokeLL.booleanValue;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gson, typeToken)) == null) {
            Class<? super T> rawType = typeToken.getRawType();
            boolean excludeClassChecks = excludeClassChecks(rawType);
            boolean z = excludeClassChecks || excludeClassInStrategy(rawType, true);
            boolean z2 = excludeClassChecks || excludeClassInStrategy(rawType, false);
            if (z || z2) {
                return new TypeAdapter<T>(this, z2, z, gson, typeToken) { // from class: com.google.gson.internal.Excluder.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public TypeAdapter<T> delegate;
                    public final /* synthetic */ Excluder this$0;
                    public final /* synthetic */ Gson val$gson;
                    public final /* synthetic */ boolean val$skipDeserialize;
                    public final /* synthetic */ boolean val$skipSerialize;
                    public final /* synthetic */ TypeToken val$type;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z2), Boolean.valueOf(z), gson, typeToken};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$skipDeserialize = z2;
                        this.val$skipSerialize = z;
                        this.val$gson = gson;
                        this.val$type = typeToken;
                    }

                    private TypeAdapter<T> delegate() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) {
                            TypeAdapter<T> typeAdapter = this.delegate;
                            if (typeAdapter != 0) {
                                return typeAdapter;
                            }
                            TypeAdapter<T> delegateAdapter = this.val$gson.getDelegateAdapter(this.this$0, this.val$type);
                            this.delegate = delegateAdapter;
                            return delegateAdapter;
                        }
                        return (TypeAdapter) invokeV.objValue;
                    }

                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
                    @Override // com.google.gson.TypeAdapter
                    public T read(JsonReader jsonReader) throws IOException {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jsonReader)) == null) {
                            if (this.val$skipDeserialize) {
                                jsonReader.skipValue();
                                return null;
                            }
                            return delegate().read(jsonReader);
                        }
                        return invokeL.objValue;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public void write(JsonWriter jsonWriter, T t) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonWriter, t) == null) {
                            if (this.val$skipSerialize) {
                                jsonWriter.nullValue();
                            } else {
                                delegate().write(jsonWriter, t);
                            }
                        }
                    }
                };
            }
            return null;
        }
        return (TypeAdapter) invokeLL.objValue;
    }

    public Excluder disableInnerClassSerialization() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Excluder m77clone = m77clone();
            m77clone.serializeInnerClasses = false;
            return m77clone;
        }
        return (Excluder) invokeV.objValue;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, cls, z)) == null) ? excludeClassChecks(cls) || excludeClassInStrategy(cls, z) : invokeLZ.booleanValue;
    }

    public boolean excludeField(Field field, boolean z) {
        InterceptResult invokeLZ;
        Expose expose;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, field, z)) == null) {
            if ((this.modifiers & field.getModifiers()) != 0) {
                return true;
            }
            if ((this.version == -1.0d || isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) && !field.isSynthetic()) {
                if (!this.requireExpose || ((expose = (Expose) field.getAnnotation(Expose.class)) != null && (!z ? !expose.deserialize() : !expose.serialize()))) {
                    if ((this.serializeInnerClasses || !isInnerClass(field.getType())) && !isAnonymousOrLocal(field.getType())) {
                        List<ExclusionStrategy> list = z ? this.serializationStrategies : this.deserializationStrategies;
                        if (list.isEmpty()) {
                            return false;
                        }
                        FieldAttributes fieldAttributes = new FieldAttributes(field);
                        for (ExclusionStrategy exclusionStrategy : list) {
                            if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Excluder m77clone = m77clone();
            m77clone.requireExpose = true;
            return m77clone;
        }
        return (Excluder) invokeV.objValue;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{exclusionStrategy, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Excluder m77clone = m77clone();
            if (z) {
                ArrayList arrayList = new ArrayList(this.serializationStrategies);
                m77clone.serializationStrategies = arrayList;
                arrayList.add(exclusionStrategy);
            }
            if (z2) {
                ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
                m77clone.deserializationStrategies = arrayList2;
                arrayList2.add(exclusionStrategy);
            }
            return m77clone;
        }
        return (Excluder) invokeCommon.objValue;
    }

    public Excluder withModifiers(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr)) == null) {
            Excluder m77clone = m77clone();
            m77clone.modifiers = 0;
            for (int i : iArr) {
                m77clone.modifiers = i | m77clone.modifiers;
            }
            return m77clone;
        }
        return (Excluder) invokeL.objValue;
    }

    public Excluder withVersion(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d)})) == null) {
            Excluder m77clone = m77clone();
            m77clone.version = d;
            return m77clone;
        }
        return (Excluder) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public Excluder m77clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (Excluder) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
        return (Excluder) invokeV.objValue;
    }
}
