package com.facebook.common.file;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes12.dex */
public class FileTree {
    public static /* synthetic */ Interceptable $ic;
    public static String sMaxLengthFileName;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(36593923, "Lcom/facebook/common/file/FileTree;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(36593923, "Lcom/facebook/common/file/FileTree;");
        }
    }

    public FileTree() {
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

    public static boolean deleteContents(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            File[] listFiles = file.listFiles();
            boolean z = true;
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    z &= deleteRecursively(file2);
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean deleteRecursively(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (file.isDirectory()) {
                deleteContents(file);
            }
            return file.delete();
        }
        return invokeL.booleanValue;
    }

    public static File[] filenamesToFiles(File file, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, strArr)) == null) {
            String path = file.getPath();
            int length = strArr.length;
            File[] fileArr = new File[length];
            for (int i2 = 0; i2 < length; i2++) {
                fileArr[i2] = new File(getSubFilePath(path, strArr[i2]));
            }
            return fileArr;
        }
        return (File[]) invokeLL.objValue;
    }

    public static String getSubFilePath(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) ? str.isEmpty() ? str2 : str2.isEmpty() ? str : join(str, str2) : (String) invokeLL.objValue;
    }

    public static String join(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            int length = str.length();
            boolean z = false;
            boolean z2 = length > 0 && str.charAt(length - 1) == File.separatorChar;
            if (!z2) {
                if (str2.length() > 0 && str2.charAt(0) == File.separatorChar) {
                    z = true;
                }
                z2 = z;
            }
            if (z2) {
                StringBuilder sb = new StringBuilder(str.length() + str2.length());
                sb.append(str);
                sb.append(str2);
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder(str.length() + str2.length() + 1);
            sb2.append(str);
            sb2.append(File.separatorChar);
            sb2.append(str2);
            return sb2.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static File[] listFiles(File file, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, file, strArr)) == null) {
            if (file == null || strArr == null || strArr.length == 0) {
                return null;
            }
            return filenamesToFiles(file, strArr);
        }
        return (File[]) invokeLL.objValue;
    }

    public static void walkFileTree(File file, FileTreeVisitor fileTreeVisitor) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, file, fileTreeVisitor) == null) {
            fileTreeVisitor.preVisitDirectory(file);
            try {
                listFiles = file.listFiles();
            } catch (OutOfMemoryError unused) {
                System.gc();
                listFiles = listFiles(file, file.list());
            }
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        walkFileTree(file2, fileTreeVisitor);
                    } else {
                        fileTreeVisitor.visitFile(file2);
                        String path = file2.getPath();
                        if (path != null) {
                            if (sMaxLengthFileName == null) {
                                sMaxLengthFileName = path;
                            } else if (path.length() > sMaxLengthFileName.length()) {
                                sMaxLengthFileName = path;
                            }
                        }
                    }
                }
            }
            fileTreeVisitor.postVisitDirectory(file);
        }
    }
}
