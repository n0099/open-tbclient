package org.apache.commons.lang3.builder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;
/* loaded from: classes3.dex */
public abstract class ToStringStyle implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ToStringStyle DEFAULT_STYLE;
    public static final ToStringStyle JSON_STYLE;
    public static final ToStringStyle MULTI_LINE_STYLE;
    public static final ToStringStyle NO_CLASS_NAME_STYLE;
    public static final ToStringStyle NO_FIELD_NAMES_STYLE;
    public static final ThreadLocal<WeakHashMap<Object, Object>> REGISTRY;
    public static final ToStringStyle SHORT_PREFIX_STYLE;
    public static final ToStringStyle SIMPLE_STYLE;
    public static final long serialVersionUID = -2587890625525655916L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean arrayContentDetail;
    public String arrayEnd;
    public String arraySeparator;
    public String arrayStart;
    public String contentEnd;
    public String contentStart;
    public boolean defaultFullDetail;
    public String fieldNameValueSeparator;
    public String fieldSeparator;
    public boolean fieldSeparatorAtEnd;
    public boolean fieldSeparatorAtStart;
    public String nullText;
    public String sizeEndText;
    public String sizeStartText;
    public String summaryObjectEndText;
    public String summaryObjectStartText;
    public boolean useClassName;
    public boolean useFieldNames;
    public boolean useIdentityHashCode;
    public boolean useShortClassName;

    /* loaded from: classes3.dex */
    public static final class DefaultToStringStyle extends ToStringStyle {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultToStringStyle() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? ToStringStyle.DEFAULT_STYLE : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonToStringStyle extends ToStringStyle {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String FIELD_NAME_PREFIX;

        public JsonToStringStyle() {
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
            this.FIELD_NAME_PREFIX = "\"";
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setContentStart(StringUtil.ARRAY_START);
            setContentEnd("}");
            setArrayStart(PreferencesUtil.LEFT_MOUNT);
            setArrayEnd(PreferencesUtil.RIGHT_MOUNT);
            setFieldSeparator(",");
            setFieldNameValueSeparator(":");
            setNullText(StringUtil.NULL_STRING);
            setSummaryObjectStartText("\"<");
            setSummaryObjectEndText(">\"");
            setSizeStartText("\"<size=");
            setSizeEndText(">\"");
        }

        private void appendValueAsString(StringBuffer stringBuffer, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, stringBuffer, str) == null) {
                stringBuffer.append("\"" + str + "\"");
            }
        }

        private boolean isJsonArray(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? str.startsWith(getArrayStart()) && str.startsWith(getArrayEnd()) : invokeL.booleanValue;
        }

        private boolean isJsonObject(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? str.startsWith(getContentStart()) && str.endsWith(getContentEnd()) : invokeL.booleanValue;
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? ToStringStyle.JSON_STYLE : invokeV.objValue;
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, Object[] objArr, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048583, this, stringBuffer, str, objArr, bool) == null) {
                if (str != null) {
                    if (isFullDetail(bool)) {
                        super.append(stringBuffer, str, objArr, bool);
                        return;
                    }
                    throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void appendDetail(StringBuffer stringBuffer, String str, char c2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{stringBuffer, str, Character.valueOf(c2)}) == null) {
                appendValueAsString(stringBuffer, String.valueOf(c2));
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void appendFieldStart(StringBuffer stringBuffer, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, stringBuffer, str) == null) {
                if (str != null) {
                    super.appendFieldStart(stringBuffer, this.FIELD_NAME_PREFIX + str + this.FIELD_NAME_PREFIX);
                    return;
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048587, this, stringBuffer, str, obj) == null) {
                if (obj == null) {
                    appendNullText(stringBuffer, str);
                } else if (!(obj instanceof String) && !(obj instanceof Character)) {
                    if (!(obj instanceof Number) && !(obj instanceof Boolean)) {
                        String obj2 = obj.toString();
                        if (!isJsonObject(obj2) && !isJsonArray(obj2)) {
                            appendDetail(stringBuffer, str, obj2);
                            return;
                        } else {
                            stringBuffer.append(obj);
                            return;
                        }
                    }
                    stringBuffer.append(obj);
                } else {
                    appendValueAsString(stringBuffer, obj.toString());
                }
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, long[] jArr, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048582, this, stringBuffer, str, jArr, bool) == null) {
                if (str != null) {
                    if (isFullDetail(bool)) {
                        super.append(stringBuffer, str, jArr, bool);
                        return;
                    }
                    throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, int[] iArr, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048581, this, stringBuffer, str, iArr, bool) == null) {
                if (str != null) {
                    if (isFullDetail(bool)) {
                        super.append(stringBuffer, str, iArr, bool);
                        return;
                    }
                    throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, short[] sArr, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, stringBuffer, str, sArr, bool) == null) {
                if (str != null) {
                    if (isFullDetail(bool)) {
                        super.append(stringBuffer, str, sArr, bool);
                        return;
                    }
                    throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, byte[] bArr, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stringBuffer, str, bArr, bool) == null) {
                if (str != null) {
                    if (isFullDetail(bool)) {
                        super.append(stringBuffer, str, bArr, bool);
                        return;
                    }
                    throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, char[] cArr, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, stringBuffer, str, cArr, bool) == null) {
                if (str != null) {
                    if (isFullDetail(bool)) {
                        super.append(stringBuffer, str, cArr, bool);
                        return;
                    }
                    throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, double[] dArr, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, stringBuffer, str, dArr, bool) == null) {
                if (str != null) {
                    if (isFullDetail(bool)) {
                        super.append(stringBuffer, str, dArr, bool);
                        return;
                    }
                    throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, float[] fArr, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048580, this, stringBuffer, str, fArr, bool) == null) {
                if (str != null) {
                    if (isFullDetail(bool)) {
                        super.append(stringBuffer, str, fArr, bool);
                        return;
                    }
                    throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, boolean[] zArr, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048585, this, stringBuffer, str, zArr, bool) == null) {
                if (str != null) {
                    if (isFullDetail(bool)) {
                        super.append(stringBuffer, str, zArr, bool);
                        return;
                    }
                    throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, stringBuffer, str, obj, bool) == null) {
                if (str != null) {
                    if (isFullDetail(bool)) {
                        super.append(stringBuffer, str, obj, bool);
                        return;
                    }
                    throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
                }
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class MultiLineToStringStyle extends ToStringStyle {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public MultiLineToStringStyle() {
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
            setContentStart(PreferencesUtil.LEFT_MOUNT);
            setFieldSeparator(SystemUtils.LINE_SEPARATOR + GlideException.IndentedAppendable.INDENT);
            setFieldSeparatorAtStart(true);
            setContentEnd(SystemUtils.LINE_SEPARATOR + PreferencesUtil.RIGHT_MOUNT);
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? ToStringStyle.MULTI_LINE_STYLE : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class NoClassNameToStringStyle extends ToStringStyle {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public NoClassNameToStringStyle() {
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
            setUseClassName(false);
            setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? ToStringStyle.NO_CLASS_NAME_STYLE : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class NoFieldNameToStringStyle extends ToStringStyle {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public NoFieldNameToStringStyle() {
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
            setUseFieldNames(false);
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? ToStringStyle.NO_FIELD_NAMES_STYLE : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ShortPrefixToStringStyle extends ToStringStyle {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public ShortPrefixToStringStyle() {
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
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? ToStringStyle.SHORT_PREFIX_STYLE : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class SimpleToStringStyle extends ToStringStyle {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public SimpleToStringStyle() {
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
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setUseFieldNames(false);
            setContentStart("");
            setContentEnd("");
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? ToStringStyle.SIMPLE_STYLE : invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-914146043, "Lorg/apache/commons/lang3/builder/ToStringStyle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-914146043, "Lorg/apache/commons/lang3/builder/ToStringStyle;");
                return;
            }
        }
        DEFAULT_STYLE = new DefaultToStringStyle();
        MULTI_LINE_STYLE = new MultiLineToStringStyle();
        NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
        SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
        SIMPLE_STYLE = new SimpleToStringStyle();
        NO_CLASS_NAME_STYLE = new NoClassNameToStringStyle();
        JSON_STYLE = new JsonToStringStyle();
        REGISTRY = new ThreadLocal<>();
    }

    public ToStringStyle() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.useFieldNames = true;
        this.useClassName = true;
        this.useShortClassName = false;
        this.useIdentityHashCode = true;
        this.contentStart = PreferencesUtil.LEFT_MOUNT;
        this.contentEnd = PreferencesUtil.RIGHT_MOUNT;
        this.fieldNameValueSeparator = "=";
        this.fieldSeparatorAtStart = false;
        this.fieldSeparatorAtEnd = false;
        this.fieldSeparator = ",";
        this.arrayStart = StringUtil.ARRAY_START;
        this.arraySeparator = ",";
        this.arrayContentDetail = true;
        this.arrayEnd = "}";
        this.defaultFullDetail = true;
        this.nullText = "<null>";
        this.sizeStartText = "<size=";
        this.sizeEndText = ">";
        this.summaryObjectStartText = "<";
        this.summaryObjectEndText = ">";
    }

    public static Map<Object, Object> getRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? REGISTRY.get() : (Map) invokeV.objValue;
    }

    public static boolean isRegistered(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            Map<Object, Object> registry = getRegistry();
            return registry != null && registry.containsKey(obj);
        }
        return invokeL.booleanValue;
    }

    public static void register(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj) == null) || obj == null) {
            return;
        }
        if (getRegistry() == null) {
            REGISTRY.set(new WeakHashMap<>());
        }
        getRegistry().put(obj, null);
    }

    public static void unregister(Object obj) {
        Map<Object, Object> registry;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, obj) == null) || obj == null || (registry = getRegistry()) == null) {
            return;
        }
        registry.remove(obj);
        if (registry.isEmpty()) {
            REGISTRY.remove();
        }
    }

    public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, stringBuffer, str, obj, bool) == null) {
            appendFieldStart(stringBuffer, str);
            if (obj == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj, isFullDetail(bool));
            }
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendClassName(StringBuffer stringBuffer, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, stringBuffer, obj) == null) && this.useClassName && obj != null) {
            register(obj);
            if (this.useShortClassName) {
                stringBuffer.append(getShortClassName(obj.getClass()));
            } else {
                stringBuffer.append(obj.getClass().getName());
            }
        }
    }

    public void appendContentEnd(StringBuffer stringBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, stringBuffer) == null) {
            stringBuffer.append(this.contentEnd);
        }
    }

    public void appendContentStart(StringBuffer stringBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, stringBuffer) == null) {
            stringBuffer.append(this.contentStart);
        }
    }

    public void appendCyclicObject(StringBuffer stringBuffer, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, stringBuffer, str, obj) == null) {
            ObjectUtils.identityToString(stringBuffer, obj);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, stringBuffer, str, obj) == null) {
            stringBuffer.append(obj);
        }
    }

    public void appendEnd(StringBuffer stringBuffer, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, stringBuffer, obj) == null) {
            if (!this.fieldSeparatorAtEnd) {
                removeLastFieldSeparator(stringBuffer);
            }
            appendContentEnd(stringBuffer);
            unregister(obj);
        }
    }

    public void appendFieldEnd(StringBuffer stringBuffer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, stringBuffer, str) == null) {
            appendFieldSeparator(stringBuffer);
        }
    }

    public void appendFieldSeparator(StringBuffer stringBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, stringBuffer) == null) {
            stringBuffer.append(this.fieldSeparator);
        }
    }

    public void appendFieldStart(StringBuffer stringBuffer, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048621, this, stringBuffer, str) == null) && this.useFieldNames && str != null) {
            stringBuffer.append(str);
            stringBuffer.append(this.fieldNameValueSeparator);
        }
    }

    public void appendIdentityHashCode(StringBuffer stringBuffer, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048622, this, stringBuffer, obj) == null) && isUseIdentityHashCode() && obj != null) {
            register(obj);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    public void appendInternal(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{stringBuffer, str, obj, Boolean.valueOf(z)}) == null) {
            if (isRegistered(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character)) {
                appendCyclicObject(stringBuffer, str, obj);
                return;
            }
            register(obj);
            try {
                if (obj instanceof Collection) {
                    if (z) {
                        appendDetail(stringBuffer, str, (Collection) obj);
                    } else {
                        appendSummarySize(stringBuffer, str, ((Collection) obj).size());
                    }
                } else if (obj instanceof Map) {
                    if (z) {
                        appendDetail(stringBuffer, str, (Map) obj);
                    } else {
                        appendSummarySize(stringBuffer, str, ((Map) obj).size());
                    }
                } else if (obj instanceof long[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (long[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (long[]) obj);
                    }
                } else if (obj instanceof int[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (int[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (int[]) obj);
                    }
                } else if (obj instanceof short[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (short[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (short[]) obj);
                    }
                } else if (obj instanceof byte[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (byte[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (byte[]) obj);
                    }
                } else if (obj instanceof char[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (char[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (char[]) obj);
                    }
                } else if (obj instanceof double[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (double[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (double[]) obj);
                    }
                } else if (obj instanceof float[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (float[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (float[]) obj);
                    }
                } else if (obj instanceof boolean[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (boolean[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (boolean[]) obj);
                    }
                } else if (obj.getClass().isArray()) {
                    if (z) {
                        appendDetail(stringBuffer, str, (Object[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (Object[]) obj);
                    }
                } else if (z) {
                    appendDetail(stringBuffer, str, obj);
                } else {
                    appendSummary(stringBuffer, str, obj);
                }
            } finally {
                unregister(obj);
            }
        }
    }

    public void appendNullText(StringBuffer stringBuffer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, stringBuffer, str) == null) {
            stringBuffer.append(this.nullText);
        }
    }

    public void appendStart(StringBuffer stringBuffer, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048625, this, stringBuffer, obj) == null) || obj == null) {
            return;
        }
        appendClassName(stringBuffer, obj);
        appendIdentityHashCode(stringBuffer, obj);
        appendContentStart(stringBuffer);
        if (this.fieldSeparatorAtStart) {
            appendFieldSeparator(stringBuffer);
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048626, this, stringBuffer, str, obj) == null) {
            stringBuffer.append(this.summaryObjectStartText);
            stringBuffer.append(getShortClassName(obj.getClass()));
            stringBuffer.append(this.summaryObjectEndText);
        }
    }

    public void appendSummarySize(StringBuffer stringBuffer, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048636, this, stringBuffer, str, i2) == null) {
            stringBuffer.append(this.sizeStartText);
            stringBuffer.append(i2);
            stringBuffer.append(this.sizeEndText);
        }
    }

    public void appendSuper(StringBuffer stringBuffer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, stringBuffer, str) == null) {
            appendToString(stringBuffer, str);
        }
    }

    public void appendToString(StringBuffer stringBuffer, String str) {
        int indexOf;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048638, this, stringBuffer, str) == null) || str == null || (indexOf = str.indexOf(this.contentStart) + this.contentStart.length()) == (lastIndexOf = str.lastIndexOf(this.contentEnd)) || indexOf < 0 || lastIndexOf < 0) {
            return;
        }
        String substring = str.substring(indexOf, lastIndexOf);
        if (this.fieldSeparatorAtStart) {
            removeLastFieldSeparator(stringBuffer);
        }
        stringBuffer.append(substring);
        appendFieldSeparator(stringBuffer);
    }

    public String getArrayEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.arrayEnd : (String) invokeV.objValue;
    }

    public String getArraySeparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.arraySeparator : (String) invokeV.objValue;
    }

    public String getArrayStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.arrayStart : (String) invokeV.objValue;
    }

    public String getContentEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.contentEnd : (String) invokeV.objValue;
    }

    public String getContentStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.contentStart : (String) invokeV.objValue;
    }

    public String getFieldNameValueSeparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.fieldNameValueSeparator : (String) invokeV.objValue;
    }

    public String getFieldSeparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.fieldSeparator : (String) invokeV.objValue;
    }

    public String getNullText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.nullText : (String) invokeV.objValue;
    }

    public String getShortClassName(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, cls)) == null) ? ClassUtils.getShortClassName(cls) : (String) invokeL.objValue;
    }

    public String getSizeEndText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.sizeEndText : (String) invokeV.objValue;
    }

    public String getSizeStartText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.sizeStartText : (String) invokeV.objValue;
    }

    public String getSummaryObjectEndText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.summaryObjectEndText : (String) invokeV.objValue;
    }

    public String getSummaryObjectStartText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.summaryObjectStartText : (String) invokeV.objValue;
    }

    public boolean isArrayContentDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.arrayContentDetail : invokeV.booleanValue;
    }

    public boolean isDefaultFullDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.defaultFullDetail : invokeV.booleanValue;
    }

    public boolean isFieldSeparatorAtEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.fieldSeparatorAtEnd : invokeV.booleanValue;
    }

    public boolean isFieldSeparatorAtStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.fieldSeparatorAtStart : invokeV.booleanValue;
    }

    public boolean isFullDetail(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, bool)) == null) {
            if (bool == null) {
                return this.defaultFullDetail;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public boolean isUseClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.useClassName : invokeV.booleanValue;
    }

    public boolean isUseFieldNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.useFieldNames : invokeV.booleanValue;
    }

    public boolean isUseIdentityHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.useIdentityHashCode : invokeV.booleanValue;
    }

    public boolean isUseShortClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.useShortClassName : invokeV.booleanValue;
    }

    public void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048661, this, stringBuffer, str, obj) == null) {
            stringBuffer.append(this.arrayStart);
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj2 = Array.get(obj, i2);
                if (i2 > 0) {
                    stringBuffer.append(this.arraySeparator);
                }
                if (obj2 == null) {
                    appendNullText(stringBuffer, str);
                } else {
                    appendInternal(stringBuffer, str, obj2, this.arrayContentDetail);
                }
            }
            stringBuffer.append(this.arrayEnd);
        }
    }

    public void removeLastFieldSeparator(StringBuffer stringBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, stringBuffer) == null) {
            int length = stringBuffer.length();
            int length2 = this.fieldSeparator.length();
            if (length <= 0 || length2 <= 0 || length < length2) {
                return;
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = true;
                    break;
                } else if (stringBuffer.charAt((length - 1) - i2) != this.fieldSeparator.charAt((length2 - 1) - i2)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                stringBuffer.setLength(length - length2);
            }
        }
    }

    public void setArrayContentDetail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048663, this, z) == null) {
            this.arrayContentDetail = z;
        }
    }

    public void setArrayEnd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.arrayEnd = str;
        }
    }

    public void setArraySeparator(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.arraySeparator = str;
        }
    }

    public void setArrayStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.arrayStart = str;
        }
    }

    public void setContentEnd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.contentEnd = str;
        }
    }

    public void setContentStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.contentStart = str;
        }
    }

    public void setDefaultFullDetail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            this.defaultFullDetail = z;
        }
    }

    public void setFieldNameValueSeparator(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.fieldNameValueSeparator = str;
        }
    }

    public void setFieldSeparator(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.fieldSeparator = str;
        }
    }

    public void setFieldSeparatorAtEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z) == null) {
            this.fieldSeparatorAtEnd = z;
        }
    }

    public void setFieldSeparatorAtStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            this.fieldSeparatorAtStart = z;
        }
    }

    public void setNullText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.nullText = str;
        }
    }

    public void setSizeEndText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.sizeEndText = str;
        }
    }

    public void setSizeStartText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.sizeStartText = str;
        }
    }

    public void setSummaryObjectEndText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.summaryObjectEndText = str;
        }
    }

    public void setSummaryObjectStartText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.summaryObjectStartText = str;
        }
    }

    public void setUseClassName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.useClassName = z;
        }
    }

    public void setUseFieldNames(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048680, this, z) == null) {
            this.useFieldNames = z;
        }
    }

    public void setUseIdentityHashCode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048681, this, z) == null) {
            this.useIdentityHashCode = z;
        }
    }

    public void setUseShortClassName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048682, this, z) == null) {
            this.useShortClassName = z;
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Collection<?> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, stringBuffer, str, collection) == null) {
            stringBuffer.append(collection);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Map<?, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048606, this, stringBuffer, str, map) == null) {
            stringBuffer.append(map);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{stringBuffer, str, Long.valueOf(j)}) == null) {
            stringBuffer.append(j);
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048633, this, stringBuffer, str, objArr) == null) {
            appendSummarySize(stringBuffer, str, objArr.length);
        }
    }

    public void append(StringBuffer stringBuffer, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{stringBuffer, str, Long.valueOf(j)}) == null) {
            appendFieldStart(stringBuffer, str);
            appendDetail(stringBuffer, str, j);
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048602, this, stringBuffer, str, i2) == null) {
            stringBuffer.append(i2);
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048632, this, stringBuffer, str, jArr) == null) {
            appendSummarySize(stringBuffer, str, jArr.length);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{stringBuffer, str, Short.valueOf(s)}) == null) {
            stringBuffer.append((int) s);
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048631, this, stringBuffer, str, iArr) == null) {
            appendSummarySize(stringBuffer, str, iArr.length);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{stringBuffer, str, Byte.valueOf(b2)}) == null) {
            stringBuffer.append((int) b2);
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048634, this, stringBuffer, str, sArr) == null) {
            appendSummarySize(stringBuffer, str, sArr.length);
        }
    }

    public void append(StringBuffer stringBuffer, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, stringBuffer, str, i2) == null) {
            appendFieldStart(stringBuffer, str);
            appendDetail(stringBuffer, str, i2);
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{stringBuffer, str, Character.valueOf(c2)}) == null) {
            stringBuffer.append(c2);
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048627, this, stringBuffer, str, bArr) == null) {
            appendSummarySize(stringBuffer, str, bArr.length);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{stringBuffer, str, Double.valueOf(d2)}) == null) {
            stringBuffer.append(d2);
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048628, this, stringBuffer, str, cArr) == null) {
            appendSummarySize(stringBuffer, str, cArr.length);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{stringBuffer, str, Float.valueOf(f2)}) == null) {
            stringBuffer.append(f2);
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048629, this, stringBuffer, str, dArr) == null) {
            appendSummarySize(stringBuffer, str, dArr.length);
        }
    }

    public void append(StringBuffer stringBuffer, String str, short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{stringBuffer, str, Short.valueOf(s)}) == null) {
            appendFieldStart(stringBuffer, str);
            appendDetail(stringBuffer, str, s);
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048608, this, stringBuffer, str, z) == null) {
            stringBuffer.append(z);
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048630, this, stringBuffer, str, fArr) == null) {
            appendSummarySize(stringBuffer, str, fArr.length);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048615, this, stringBuffer, str, objArr) == null) {
            stringBuffer.append(this.arrayStart);
            for (int i2 = 0; i2 < objArr.length; i2++) {
                Object obj = objArr[i2];
                if (i2 > 0) {
                    stringBuffer.append(this.arraySeparator);
                }
                if (obj == null) {
                    appendNullText(stringBuffer, str);
                } else {
                    appendInternal(stringBuffer, str, obj, this.arrayContentDetail);
                }
            }
            stringBuffer.append(this.arrayEnd);
        }
    }

    public void appendSummary(StringBuffer stringBuffer, String str, boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048635, this, stringBuffer, str, zArr) == null) {
            appendSummarySize(stringBuffer, str, zArr.length);
        }
    }

    public void append(StringBuffer stringBuffer, String str, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{stringBuffer, str, Byte.valueOf(b2)}) == null) {
            appendFieldStart(stringBuffer, str);
            appendDetail(stringBuffer, str, b2);
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void append(StringBuffer stringBuffer, String str, char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{stringBuffer, str, Character.valueOf(c2)}) == null) {
            appendFieldStart(stringBuffer, str);
            appendDetail(stringBuffer, str, c2);
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048614, this, stringBuffer, str, jArr) == null) {
            stringBuffer.append(this.arrayStart);
            for (int i2 = 0; i2 < jArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(this.arraySeparator);
                }
                appendDetail(stringBuffer, str, jArr[i2]);
            }
            stringBuffer.append(this.arrayEnd);
        }
    }

    public void append(StringBuffer stringBuffer, String str, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{stringBuffer, str, Double.valueOf(d2)}) == null) {
            appendFieldStart(stringBuffer, str);
            appendDetail(stringBuffer, str, d2);
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void append(StringBuffer stringBuffer, String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{stringBuffer, str, Float.valueOf(f2)}) == null) {
            appendFieldStart(stringBuffer, str);
            appendDetail(stringBuffer, str, f2);
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048613, this, stringBuffer, str, iArr) == null) {
            stringBuffer.append(this.arrayStart);
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(this.arraySeparator);
                }
                appendDetail(stringBuffer, str, iArr[i2]);
            }
            stringBuffer.append(this.arrayEnd);
        }
    }

    public void append(StringBuffer stringBuffer, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, stringBuffer, str, z) == null) {
            appendFieldStart(stringBuffer, str);
            appendDetail(stringBuffer, str, z);
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void append(StringBuffer stringBuffer, String str, Object[] objArr, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048591, this, stringBuffer, str, objArr, bool) == null) {
            appendFieldStart(stringBuffer, str);
            if (objArr == null) {
                appendNullText(stringBuffer, str);
            } else if (isFullDetail(bool)) {
                appendDetail(stringBuffer, str, objArr);
            } else {
                appendSummary(stringBuffer, str, objArr);
            }
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048616, this, stringBuffer, str, sArr) == null) {
            stringBuffer.append(this.arrayStart);
            for (int i2 = 0; i2 < sArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(this.arraySeparator);
                }
                appendDetail(stringBuffer, str, sArr[i2]);
            }
            stringBuffer.append(this.arrayEnd);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048609, this, stringBuffer, str, bArr) == null) {
            stringBuffer.append(this.arrayStart);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(this.arraySeparator);
                }
                appendDetail(stringBuffer, str, bArr[i2]);
            }
            stringBuffer.append(this.arrayEnd);
        }
    }

    public void append(StringBuffer stringBuffer, String str, long[] jArr, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, stringBuffer, str, jArr, bool) == null) {
            appendFieldStart(stringBuffer, str);
            if (jArr == null) {
                appendNullText(stringBuffer, str);
            } else if (isFullDetail(bool)) {
                appendDetail(stringBuffer, str, jArr);
            } else {
                appendSummary(stringBuffer, str, jArr);
            }
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048610, this, stringBuffer, str, cArr) == null) {
            stringBuffer.append(this.arrayStart);
            for (int i2 = 0; i2 < cArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(this.arraySeparator);
                }
                appendDetail(stringBuffer, str, cArr[i2]);
            }
            stringBuffer.append(this.arrayEnd);
        }
    }

    public void append(StringBuffer stringBuffer, String str, int[] iArr, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, stringBuffer, str, iArr, bool) == null) {
            appendFieldStart(stringBuffer, str);
            if (iArr == null) {
                appendNullText(stringBuffer, str);
            } else if (isFullDetail(bool)) {
                appendDetail(stringBuffer, str, iArr);
            } else {
                appendSummary(stringBuffer, str, iArr);
            }
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, stringBuffer, str, dArr) == null) {
            stringBuffer.append(this.arrayStart);
            for (int i2 = 0; i2 < dArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(this.arraySeparator);
                }
                appendDetail(stringBuffer, str, dArr[i2]);
            }
            stringBuffer.append(this.arrayEnd);
        }
    }

    public void append(StringBuffer stringBuffer, String str, short[] sArr, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, stringBuffer, str, sArr, bool) == null) {
            appendFieldStart(stringBuffer, str);
            if (sArr == null) {
                appendNullText(stringBuffer, str);
            } else if (isFullDetail(bool)) {
                appendDetail(stringBuffer, str, sArr);
            } else {
                appendSummary(stringBuffer, str, sArr);
            }
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, stringBuffer, str, fArr) == null) {
            stringBuffer.append(this.arrayStart);
            for (int i2 = 0; i2 < fArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(this.arraySeparator);
                }
                appendDetail(stringBuffer, str, fArr[i2]);
            }
            stringBuffer.append(this.arrayEnd);
        }
    }

    public void append(StringBuffer stringBuffer, String str, byte[] bArr, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, stringBuffer, str, bArr, bool) == null) {
            appendFieldStart(stringBuffer, str);
            if (bArr == null) {
                appendNullText(stringBuffer, str);
            } else if (isFullDetail(bool)) {
                appendDetail(stringBuffer, str, bArr);
            } else {
                appendSummary(stringBuffer, str, bArr);
            }
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048617, this, stringBuffer, str, zArr) == null) {
            stringBuffer.append(this.arrayStart);
            for (int i2 = 0; i2 < zArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(this.arraySeparator);
                }
                appendDetail(stringBuffer, str, zArr[i2]);
            }
            stringBuffer.append(this.arrayEnd);
        }
    }

    public void append(StringBuffer stringBuffer, String str, char[] cArr, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, stringBuffer, str, cArr, bool) == null) {
            appendFieldStart(stringBuffer, str);
            if (cArr == null) {
                appendNullText(stringBuffer, str);
            } else if (isFullDetail(bool)) {
                appendDetail(stringBuffer, str, cArr);
            } else {
                appendSummary(stringBuffer, str, cArr);
            }
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void append(StringBuffer stringBuffer, String str, double[] dArr, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, stringBuffer, str, dArr, bool) == null) {
            appendFieldStart(stringBuffer, str);
            if (dArr == null) {
                appendNullText(stringBuffer, str);
            } else if (isFullDetail(bool)) {
                appendDetail(stringBuffer, str, dArr);
            } else {
                appendSummary(stringBuffer, str, dArr);
            }
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void append(StringBuffer stringBuffer, String str, float[] fArr, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, stringBuffer, str, fArr, bool) == null) {
            appendFieldStart(stringBuffer, str);
            if (fArr == null) {
                appendNullText(stringBuffer, str);
            } else if (isFullDetail(bool)) {
                appendDetail(stringBuffer, str, fArr);
            } else {
                appendSummary(stringBuffer, str, fArr);
            }
            appendFieldEnd(stringBuffer, str);
        }
    }

    public void append(StringBuffer stringBuffer, String str, boolean[] zArr, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048593, this, stringBuffer, str, zArr, bool) == null) {
            appendFieldStart(stringBuffer, str);
            if (zArr == null) {
                appendNullText(stringBuffer, str);
            } else if (isFullDetail(bool)) {
                appendDetail(stringBuffer, str, zArr);
            } else {
                appendSummary(stringBuffer, str, zArr);
            }
            appendFieldEnd(stringBuffer, str);
        }
    }
}
