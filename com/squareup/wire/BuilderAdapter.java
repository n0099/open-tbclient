package com.squareup.wire;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes4.dex */
public final class BuilderAdapter<B extends Message.Builder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Comparator<Field> ORDER_BY_FIELD_NAME;
    public static final int SUFFIX_LENGTH = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Field> requiredFields;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1932548038, "Lcom/squareup/wire/BuilderAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1932548038, "Lcom/squareup/wire/BuilderAdapter;");
                return;
            }
        }
        ORDER_BY_FIELD_NAME = new Comparator<Field>() { // from class: com.squareup.wire.BuilderAdapter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Field field, Field field2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, field, field2)) == null) ? field.getName().compareTo(field2.getName()) : invokeLL.intValue;
            }
        };
    }

    public BuilderAdapter(Class<B> cls) {
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.requiredFields = new ArrayList();
        String name = cls.getName();
        try {
            for (Field field : Class.forName(name.substring(0, name.length() - SUFFIX_LENGTH)).getDeclaredFields()) {
                ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
                if (protoField != null && protoField.label() == Message.Label.REQUIRED) {
                    try {
                        this.requiredFields.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException unused) {
                        throw new AssertionError("No builder field found for message field " + field.getName());
                    }
                }
            }
            Collections.sort(this.requiredFields, ORDER_BY_FIELD_NAME);
        } catch (ClassNotFoundException unused2) {
            throw new AssertionError("No message class found for builder type " + name);
        }
    }

    public <B extends Message.Builder> void checkRequiredFields(B b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b2) == null) {
            try {
                int size = this.requiredFields.size();
                StringBuilder sb = null;
                String str = "";
                for (int i2 = 0; i2 < size; i2++) {
                    Field field = this.requiredFields.get(i2);
                    if (field.get(b2) == null) {
                        if (sb == null) {
                            sb = new StringBuilder();
                        } else {
                            str = "s";
                        }
                        sb.append("\n  ");
                        sb.append(field.getName());
                    }
                }
                if (sb == null) {
                    return;
                }
                throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
            } catch (IllegalAccessException unused) {
                throw new AssertionError("Unable to access required fields");
            }
        }
    }
}
