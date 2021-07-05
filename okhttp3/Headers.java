package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
/* loaded from: classes10.dex */
public final class Headers {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] namesAndValues;

    public Headers(Builder builder) {
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
        List<String> list = builder.namesAndValues;
        this.namesAndValues = (String[]) list.toArray(new String[list.size()]);
    }

    public static Headers of(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, strArr)) == null) {
            if (strArr != null) {
                if (strArr.length % 2 == 0) {
                    String[] strArr2 = (String[]) strArr.clone();
                    for (int i2 = 0; i2 < strArr2.length; i2++) {
                        if (strArr2[i2] != null) {
                            strArr2[i2] = strArr2[i2].trim();
                        } else {
                            throw new IllegalArgumentException("Headers cannot be null");
                        }
                    }
                    for (int i3 = 0; i3 < strArr2.length; i3 += 2) {
                        String str = strArr2[i3];
                        String str2 = strArr2[i3 + 1];
                        if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                            throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
                        }
                    }
                    return new Headers(strArr2);
                }
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            throw new NullPointerException("namesAndValues == null");
        }
        return (Headers) invokeL.objValue;
    }

    public long byteCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String[] strArr = this.namesAndValues;
            long length = strArr.length * 2;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                length += this.namesAndValues[i2].length();
            }
            return length;
        }
        return invokeV.longValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? (obj instanceof Headers) && Arrays.equals(((Headers) obj).namesAndValues, this.namesAndValues) : invokeL.booleanValue;
    }

    @Nullable
    public String get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? get(this.namesAndValues, str) : (String) invokeL.objValue;
    }

    @Nullable
    public Date getDate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String str2 = get(str);
            if (str2 != null) {
                return HttpDate.parse(str2);
            }
            return null;
        }
        return (Date) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Arrays.hashCode(this.namesAndValues) : invokeV.intValue;
    }

    public String name(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.namesAndValues[i2 * 2] : (String) invokeI.objValue;
    }

    public Set<String> names() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                treeSet.add(name(i2));
            }
            return Collections.unmodifiableSet(treeSet);
        }
        return (Set) invokeV.objValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Builder builder = new Builder();
            Collections.addAll(builder.namesAndValues, this.namesAndValues);
            return builder;
        }
        return (Builder) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.namesAndValues.length / 2 : invokeV.intValue;
    }

    public Map<String, List<String>> toMultimap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                String lowerCase = name(i2).toLowerCase(Locale.US);
                List list = (List) treeMap.get(lowerCase);
                if (list == null) {
                    list = new ArrayList(2);
                    treeMap.put(lowerCase, list);
                }
                list.add(value(i2));
            }
            return treeMap;
        }
        return (Map) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(name(i2));
                sb.append(": ");
                sb.append(value(i2));
                sb.append("\n");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String value(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this.namesAndValues[(i2 * 2) + 1] : (String) invokeI.objValue;
    }

    public List<String> values(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            int size = size();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                if (str.equalsIgnoreCase(name(i2))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(2);
                    }
                    arrayList.add(value(i2));
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        }
        return (List) invokeL.objValue;
    }

    public static String get(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, strArr, str)) == null) {
            for (int length = strArr.length - 2; length >= 0; length -= 2) {
                if (str.equalsIgnoreCase(strArr[length])) {
                    return strArr[length + 1];
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    /* loaded from: classes10.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<String> namesAndValues;

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
            this.namesAndValues = new ArrayList(20);
        }

        private void checkNameAndValue(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, str, str2) == null) {
                if (str != null) {
                    if (!str.isEmpty()) {
                        int length = str.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            char charAt = str.charAt(i2);
                            if (charAt <= ' ' || charAt >= 127) {
                                throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                            }
                        }
                        if (str2 != null) {
                            int length2 = str2.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                char charAt2 = str2.charAt(i3);
                                if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i3), str, str2));
                                }
                            }
                            return;
                        }
                        throw new NullPointerException("value for name " + str + " == null");
                    }
                    throw new IllegalArgumentException("name is empty");
                }
                throw new NullPointerException("name == null");
            }
        }

        public Builder add(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int indexOf = str.indexOf(":");
                if (indexOf != -1) {
                    return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
                }
                throw new IllegalArgumentException("Unexpected header: " + str);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addAll(Headers headers) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, headers)) == null) {
                int size = headers.size();
                for (int i2 = 0; i2 < size; i2++) {
                    addLenient(headers.name(i2), headers.value(i2));
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addLenient(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                int indexOf = str.indexOf(":", 1);
                if (indexOf != -1) {
                    return addLenient(str.substring(0, indexOf), str.substring(indexOf + 1));
                }
                if (str.startsWith(":")) {
                    return addLenient("", str.substring(1));
                }
                return addLenient("", str);
            }
            return (Builder) invokeL.objValue;
        }

        public Headers build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new Headers(this) : (Headers) invokeV.objValue;
        }

        public String get(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                    if (str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                        return this.namesAndValues.get(size + 1);
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public Builder removeAll(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                int i2 = 0;
                while (i2 < this.namesAndValues.size()) {
                    if (str.equalsIgnoreCase(this.namesAndValues.get(i2))) {
                        this.namesAndValues.remove(i2);
                        this.namesAndValues.remove(i2);
                        i2 -= 2;
                    }
                    i2 += 2;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder set(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                checkNameAndValue(str, str2);
                removeAll(str);
                addLenient(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder add(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                checkNameAndValue(str, str2);
                return addLenient(str, str2);
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder addLenient(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                this.namesAndValues.add(str);
                this.namesAndValues.add(str2.trim());
                return this;
            }
            return (Builder) invokeLL.objValue;
        }
    }

    public Headers(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.namesAndValues = strArr;
    }

    public static Headers of(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            if (map != null) {
                String[] strArr = new String[map.size() * 2];
                int i2 = 0;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        String trim = entry.getKey().trim();
                        String trim2 = entry.getValue().trim();
                        if (trim.length() != 0 && trim.indexOf(0) == -1 && trim2.indexOf(0) == -1) {
                            strArr[i2] = trim;
                            strArr[i2 + 1] = trim2;
                            i2 += 2;
                        } else {
                            throw new IllegalArgumentException("Unexpected header: " + trim + ": " + trim2);
                        }
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                return new Headers(strArr);
            }
            throw new NullPointerException("headers == null");
        }
        return (Headers) invokeL.objValue;
    }
}
