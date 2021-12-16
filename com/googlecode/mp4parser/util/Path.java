package com.googlecode.mp4parser.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.AbstractContainerBox;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class Path {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static Pattern component;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1132483543, "Lcom/googlecode/mp4parser/util/Path;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1132483543, "Lcom/googlecode/mp4parser/util/Path;");
                return;
            }
        }
        component = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");
    }

    public Path() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String createPath(Box box) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, box)) == null) ? createPath(box, "") : (String) invokeL.objValue;
    }

    public static Box getPath(Box box, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, box, str)) == null) {
            List<Box> paths = getPaths(box, str, true);
            if (paths.isEmpty()) {
                return null;
            }
            return paths.get(0);
        }
        return (Box) invokeLL.objValue;
    }

    public static List<Box> getPaths(AbstractContainerBox abstractContainerBox, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, abstractContainerBox, str)) == null) ? getPaths(abstractContainerBox, str, false) : (List) invokeLL.objValue;
    }

    public static boolean isContained(Box box, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, box, str)) == null) ? getPaths(box, str).contains(box) : invokeLL.booleanValue;
    }

    public static String createPath(Box box, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, box, str)) == null) {
            Container parent = box.getParent();
            int i2 = 0;
            for (Box box2 : parent.getBoxes()) {
                if (box2.getType().equals(box.getType())) {
                    if (box2 == box) {
                        break;
                    }
                    i2++;
                }
            }
            String str2 = String.valueOf(String.format("/%s[%d]", box.getType(), Integer.valueOf(i2))) + str;
            return parent instanceof Box ? createPath((Box) parent, str2) : str2;
        }
        return (String) invokeLL.objValue;
    }

    public static List<Box> getPaths(Box box, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, box, str)) == null) ? getPaths(box, str, false) : (List) invokeLL.objValue;
    }

    public static Box getPath(Container container, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, container, str)) == null) {
            List<Box> paths = getPaths(container, str, true);
            if (paths.isEmpty()) {
                return null;
            }
            return paths.get(0);
        }
        return (Box) invokeLL.objValue;
    }

    public static List<Box> getPaths(Container container, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, container, str)) == null) ? getPaths(container, str, false) : (List) invokeLL.objValue;
    }

    public static List<Box> getPaths(AbstractContainerBox abstractContainerBox, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65548, null, abstractContainerBox, str, z)) == null) ? getPaths((Object) abstractContainerBox, str, z) : (List) invokeLLZ.objValue;
    }

    public static Box getPath(AbstractContainerBox abstractContainerBox, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, abstractContainerBox, str)) == null) {
            List<Box> paths = getPaths(abstractContainerBox, str, true);
            if (paths.isEmpty()) {
                return null;
            }
            return paths.get(0);
        }
        return (Box) invokeLL.objValue;
    }

    public static List<Box> getPaths(Container container, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, null, container, str, z)) == null) ? getPaths((Object) container, str, z) : (List) invokeLLZ.objValue;
    }

    public static List<Box> getPaths(Box box, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, box, str, z)) == null) ? getPaths((Object) box, str, z) : (List) invokeLLZ.objValue;
    }

    public static List<Box> getPaths(Object obj, String str, boolean z) {
        InterceptResult invokeLLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65549, null, obj, str, z)) == null) {
            if (str.startsWith("/")) {
                String substring = str.substring(1);
                while (obj instanceof Box) {
                    obj = ((Box) obj).getParent();
                }
                str = substring;
            }
            if (str.length() == 0) {
                if (obj instanceof Box) {
                    return Collections.singletonList((Box) obj);
                }
                throw new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
            }
            int i2 = 0;
            if (str.contains("/")) {
                str2 = str.substring(str.indexOf(47) + 1);
                str = str.substring(0, str.indexOf(47));
            } else {
                str2 = "";
            }
            Matcher matcher = component.matcher(str);
            if (matcher.matches()) {
                String group = matcher.group(1);
                if (IStringUtil.TOP_PATH.equals(group)) {
                    if (obj instanceof Box) {
                        return getPaths(((Box) obj).getParent(), str2, z);
                    }
                    return Collections.emptyList();
                } else if (obj instanceof Container) {
                    int parseInt = matcher.group(2) != null ? Integer.parseInt(matcher.group(3)) : -1;
                    LinkedList linkedList = new LinkedList();
                    for (Box box : ((Container) obj).getBoxes()) {
                        if (box.getType().matches(group)) {
                            if (parseInt == -1 || parseInt == i2) {
                                linkedList.addAll(getPaths(box, str2, z));
                            }
                            i2++;
                        }
                        if (z || parseInt >= 0) {
                            if (!linkedList.isEmpty()) {
                                return linkedList;
                            }
                        }
                    }
                    return linkedList;
                } else {
                    return Collections.emptyList();
                }
            }
            throw new RuntimeException(String.valueOf(str) + " is invalid path.");
        }
        return (List) invokeLLZ.objValue;
    }
}
