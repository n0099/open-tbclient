package com.google.gson;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class GsonBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean complexMapKeySerialization;
    public String datePattern;
    public int dateStyle;
    public boolean escapeHtmlChars;
    public Excluder excluder;
    public final List<TypeAdapterFactory> factories;
    public FieldNamingStrategy fieldNamingPolicy;
    public boolean generateNonExecutableJson;
    public final List<TypeAdapterFactory> hierarchyFactories;
    public final Map<Type, InstanceCreator<?>> instanceCreators;
    public boolean lenient;
    public LongSerializationPolicy longSerializationPolicy;
    public boolean prettyPrinting;
    public boolean serializeNulls;
    public boolean serializeSpecialFloatingPointValues;
    public int timeStyle;

    public GsonBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
    }

    private void addTypeAdaptersForDate(String str, int i, int i2, List<TypeAdapterFactory> list) {
        DefaultDateTypeAdapter defaultDateTypeAdapter;
        DefaultDateTypeAdapter defaultDateTypeAdapter2;
        DefaultDateTypeAdapter defaultDateTypeAdapter3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), list}) == null) {
            if (str != null && !"".equals(str.trim())) {
                defaultDateTypeAdapter = new DefaultDateTypeAdapter(Date.class, str);
                defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Timestamp.class, str);
                defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, str);
            } else if (i == 2 || i2 == 2) {
                return;
            } else {
                DefaultDateTypeAdapter defaultDateTypeAdapter4 = new DefaultDateTypeAdapter(Date.class, i, i2);
                DefaultDateTypeAdapter defaultDateTypeAdapter5 = new DefaultDateTypeAdapter(Timestamp.class, i, i2);
                DefaultDateTypeAdapter defaultDateTypeAdapter6 = new DefaultDateTypeAdapter(java.sql.Date.class, i, i2);
                defaultDateTypeAdapter = defaultDateTypeAdapter4;
                defaultDateTypeAdapter2 = defaultDateTypeAdapter5;
                defaultDateTypeAdapter3 = defaultDateTypeAdapter6;
            }
            list.add(TypeAdapters.newFactory(Date.class, defaultDateTypeAdapter));
            list.add(TypeAdapters.newFactory(Timestamp.class, defaultDateTypeAdapter2));
            list.add(TypeAdapters.newFactory(java.sql.Date.class, defaultDateTypeAdapter3));
        }
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, exclusionStrategy)) == null) {
            this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, false, true);
            return this;
        }
        return (GsonBuilder) invokeL.objValue;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exclusionStrategy)) == null) {
            this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, false);
            return this;
        }
        return (GsonBuilder) invokeL.objValue;
    }

    public Gson create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<TypeAdapterFactory> arrayList = new ArrayList<>(this.factories.size() + this.hierarchyFactories.size() + 3);
            arrayList.addAll(this.factories);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList(this.hierarchyFactories);
            Collections.reverse(arrayList2);
            arrayList.addAll(arrayList2);
            addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList);
            return new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, this.factories, this.hierarchyFactories, arrayList);
        }
        return (Gson) invokeV.objValue;
    }

    public GsonBuilder disableHtmlEscaping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.escapeHtmlChars = false;
            return this;
        }
        return (GsonBuilder) invokeV.objValue;
    }

    public GsonBuilder disableInnerClassSerialization() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.excluder = this.excluder.disableInnerClassSerialization();
            return this;
        }
        return (GsonBuilder) invokeV.objValue;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.complexMapKeySerialization = true;
            return this;
        }
        return (GsonBuilder) invokeV.objValue;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iArr)) == null) {
            this.excluder = this.excluder.withModifiers(iArr);
            return this;
        }
        return (GsonBuilder) invokeL.objValue;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
            return this;
        }
        return (GsonBuilder) invokeV.objValue;
    }

    public GsonBuilder generateNonExecutableJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.generateNonExecutableJson = true;
            return this;
        }
        return (GsonBuilder) invokeV.objValue;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, type, obj)) == null) {
            boolean z = obj instanceof JsonSerializer;
            C$Gson$Preconditions.checkArgument(z || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter));
            if (obj instanceof InstanceCreator) {
                this.instanceCreators.put(type, (InstanceCreator) obj);
            }
            if (z || (obj instanceof JsonDeserializer)) {
                this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), obj));
            }
            if (obj instanceof TypeAdapter) {
                this.factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) obj));
            }
            return this;
        }
        return (GsonBuilder) invokeLL.objValue;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, typeAdapterFactory)) == null) {
            this.factories.add(typeAdapterFactory);
            return this;
        }
        return (GsonBuilder) invokeL.objValue;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, cls, obj)) == null) {
            boolean z = obj instanceof JsonSerializer;
            C$Gson$Preconditions.checkArgument(z || (obj instanceof JsonDeserializer) || (obj instanceof TypeAdapter));
            if ((obj instanceof JsonDeserializer) || z) {
                this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(cls, obj));
            }
            if (obj instanceof TypeAdapter) {
                this.factories.add(TypeAdapters.newTypeHierarchyFactory(cls, (TypeAdapter) obj));
            }
            return this;
        }
        return (GsonBuilder) invokeLL.objValue;
    }

    public GsonBuilder serializeNulls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.serializeNulls = true;
            return this;
        }
        return (GsonBuilder) invokeV.objValue;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.serializeSpecialFloatingPointValues = true;
            return this;
        }
        return (GsonBuilder) invokeV.objValue;
    }

    public GsonBuilder setDateFormat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.datePattern = str;
            return this;
        }
        return (GsonBuilder) invokeL.objValue;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... exclusionStrategyArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, exclusionStrategyArr)) == null) {
            for (ExclusionStrategy exclusionStrategy : exclusionStrategyArr) {
                this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, true);
            }
            return this;
        }
        return (GsonBuilder) invokeL.objValue;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fieldNamingPolicy)) == null) {
            this.fieldNamingPolicy = fieldNamingPolicy;
            return this;
        }
        return (GsonBuilder) invokeL.objValue;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, fieldNamingStrategy)) == null) {
            this.fieldNamingPolicy = fieldNamingStrategy;
            return this;
        }
        return (GsonBuilder) invokeL.objValue;
    }

    public GsonBuilder setLenient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.lenient = true;
            return this;
        }
        return (GsonBuilder) invokeV.objValue;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, longSerializationPolicy)) == null) {
            this.longSerializationPolicy = longSerializationPolicy;
            return this;
        }
        return (GsonBuilder) invokeL.objValue;
    }

    public GsonBuilder setPrettyPrinting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            this.prettyPrinting = true;
            return this;
        }
        return (GsonBuilder) invokeV.objValue;
    }

    public GsonBuilder setVersion(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Double.valueOf(d)})) == null) {
            this.excluder = this.excluder.withVersion(d);
            return this;
        }
        return (GsonBuilder) invokeCommon.objValue;
    }

    public GsonBuilder setDateFormat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            this.dateStyle = i;
            this.datePattern = null;
            return this;
        }
        return (GsonBuilder) invokeI.objValue;
    }

    public GsonBuilder setDateFormat(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i, i2)) == null) {
            this.dateStyle = i;
            this.timeStyle = i2;
            this.datePattern = null;
            return this;
        }
        return (GsonBuilder) invokeII.objValue;
    }

    public GsonBuilder(Gson gson) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gson};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.excluder = gson.excluder;
        this.fieldNamingPolicy = gson.fieldNamingStrategy;
        this.instanceCreators.putAll(gson.instanceCreators);
        this.serializeNulls = gson.serializeNulls;
        this.complexMapKeySerialization = gson.complexMapKeySerialization;
        this.generateNonExecutableJson = gson.generateNonExecutableJson;
        this.escapeHtmlChars = gson.htmlSafe;
        this.prettyPrinting = gson.prettyPrinting;
        this.lenient = gson.lenient;
        this.serializeSpecialFloatingPointValues = gson.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = gson.longSerializationPolicy;
        this.datePattern = gson.datePattern;
        this.dateStyle = gson.dateStyle;
        this.timeStyle = gson.timeStyle;
        this.factories.addAll(gson.builderFactories);
        this.hierarchyFactories.addAll(gson.builderHierarchyFactories);
    }
}
