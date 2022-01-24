package org.aspectj.runtime.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
import org.aspectj.lang.Signature;
/* loaded from: classes5.dex */
public abstract class SignatureImpl implements Signature {
    public static /* synthetic */ Interceptable $ic = null;
    public static Class[] EMPTY_CLASS_ARRAY = null;
    public static String[] EMPTY_STRING_ARRAY = null;
    public static final String INNER_SEP = ":";
    public static final char SEP = '-';
    public static boolean useCache = true;
    public transient /* synthetic */ FieldHolder $fh;
    public Class declaringType;
    public String declaringTypeName;
    public ClassLoader lookupClassLoader;
    public int modifiers;
    public String name;
    public Cache stringCache;
    public String stringRep;

    /* loaded from: classes5.dex */
    public interface Cache {
        String get(int i2);

        void set(int i2, String str);
    }

    /* loaded from: classes5.dex */
    public static final class CacheImpl implements Cache {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SoftReference toStringCacheRef;

        public CacheImpl() {
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
            makeCache();
        }

        private String[] array() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? (String[]) this.toStringCacheRef.get() : (String[]) invokeV.objValue;
        }

        private String[] makeCache() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                String[] strArr = new String[3];
                this.toStringCacheRef = new SoftReference(strArr);
                return strArr;
            }
            return (String[]) invokeV.objValue;
        }

        @Override // org.aspectj.runtime.reflect.SignatureImpl.Cache
        public String get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                String[] array = array();
                if (array == null) {
                    return null;
                }
                return array[i2];
            }
            return (String) invokeI.objValue;
        }

        @Override // org.aspectj.runtime.reflect.SignatureImpl.Cache
        public void set(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                String[] array = array();
                if (array == null) {
                    array = makeCache();
                }
                array[i2] = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1829119104, "Lorg/aspectj/runtime/reflect/SignatureImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1829119104, "Lorg/aspectj/runtime/reflect/SignatureImpl;");
                return;
            }
        }
        EMPTY_STRING_ARRAY = new String[0];
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    public SignatureImpl(int i2, String str, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.modifiers = -1;
        this.lookupClassLoader = null;
        this.modifiers = i2;
        this.name = str;
        this.declaringType = cls;
    }

    private ClassLoader getLookupClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.lookupClassLoader == null) {
                this.lookupClassLoader = getClass().getClassLoader();
            }
            return this.lookupClassLoader;
        }
        return (ClassLoader) invokeV.objValue;
    }

    public static boolean getUseCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? useCache : invokeV.booleanValue;
    }

    public static void setUseCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            useCache = z;
        }
    }

    public void addFullTypeNames(StringBuffer stringBuffer, Class[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, stringBuffer, clsArr) == null) {
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                stringBuffer.append(fullTypeName(clsArr[i2]));
            }
        }
    }

    public void addShortTypeNames(StringBuffer stringBuffer, Class[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stringBuffer, clsArr) == null) {
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                stringBuffer.append(shortTypeName(clsArr[i2]));
            }
        }
    }

    public void addTypeArray(StringBuffer stringBuffer, Class[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, stringBuffer, clsArr) == null) {
            addFullTypeNames(stringBuffer, clsArr);
        }
    }

    public abstract String createToString(StringMaker stringMaker);

    public int extractInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? Integer.parseInt(extractString(i2), 16) : invokeI.intValue;
    }

    public String extractString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int indexOf = this.stringRep.indexOf(45);
            int i3 = 0;
            while (true) {
                int i4 = i2 - 1;
                if (i2 <= 0) {
                    break;
                }
                i3 = indexOf + 1;
                indexOf = this.stringRep.indexOf(45, i3);
                i2 = i4;
            }
            if (indexOf == -1) {
                indexOf = this.stringRep.length();
            }
            return this.stringRep.substring(i3, indexOf);
        }
        return (String) invokeI.objValue;
    }

    public String[] extractStrings(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            StringTokenizer stringTokenizer = new StringTokenizer(extractString(i2), ":");
            int countTokens = stringTokenizer.countTokens();
            String[] strArr = new String[countTokens];
            for (int i3 = 0; i3 < countTokens; i3++) {
                strArr[i3] = stringTokenizer.nextToken();
            }
            return strArr;
        }
        return (String[]) invokeI.objValue;
    }

    public Class extractType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? Factory.makeClass(extractString(i2), getLookupClassLoader()) : (Class) invokeI.objValue;
    }

    public Class[] extractTypes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            StringTokenizer stringTokenizer = new StringTokenizer(extractString(i2), ":");
            int countTokens = stringTokenizer.countTokens();
            Class[] clsArr = new Class[countTokens];
            for (int i3 = 0; i3 < countTokens; i3++) {
                clsArr[i3] = Factory.makeClass(stringTokenizer.nextToken(), getLookupClassLoader());
            }
            return clsArr;
        }
        return (Class[]) invokeI.objValue;
    }

    public String fullTypeName(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cls)) == null) {
            if (cls == null) {
                return "ANONYMOUS";
            }
            if (cls.isArray()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(fullTypeName(cls.getComponentType()));
                stringBuffer.append("[]");
                return stringBuffer.toString();
            }
            return cls.getName().replace('$', '.');
        }
        return (String) invokeL.objValue;
    }

    @Override // org.aspectj.lang.Signature
    public Class getDeclaringType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.declaringType == null) {
                this.declaringType = extractType(2);
            }
            return this.declaringType;
        }
        return (Class) invokeV.objValue;
    }

    @Override // org.aspectj.lang.Signature
    public String getDeclaringTypeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.declaringTypeName == null) {
                this.declaringTypeName = getDeclaringType().getName();
            }
            return this.declaringTypeName;
        }
        return (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.Signature
    public int getModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.modifiers == -1) {
                this.modifiers = extractInt(0);
            }
            return this.modifiers;
        }
        return invokeV.intValue;
    }

    @Override // org.aspectj.lang.Signature
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.name == null) {
                this.name = extractString(1);
            }
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public void setLookupClassLoader(ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, classLoader) == null) {
            this.lookupClassLoader = classLoader;
        }
    }

    public String shortTypeName(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cls)) == null) {
            if (cls == null) {
                return "ANONYMOUS";
            }
            if (cls.isArray()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(shortTypeName(cls.getComponentType()));
                stringBuffer.append("[]");
                return stringBuffer.toString();
            }
            return stripPackageName(cls.getName()).replace('$', '.');
        }
        return (String) invokeL.objValue;
    }

    public String stripPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    @Override // org.aspectj.lang.Signature
    public final String toLongString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? toString(StringMaker.longStringMaker) : (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.Signature
    public final String toShortString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? toString(StringMaker.shortStringMaker) : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString(StringMaker stringMaker) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, stringMaker)) == null) {
            if (useCache) {
                Cache cache = this.stringCache;
                if (cache == null) {
                    try {
                        this.stringCache = new CacheImpl();
                    } catch (Throwable unused) {
                        useCache = false;
                    }
                } else {
                    str = cache.get(stringMaker.cacheOffset);
                    if (str == null) {
                        str = createToString(stringMaker);
                    }
                    if (useCache) {
                        this.stringCache.set(stringMaker.cacheOffset, str);
                    }
                    return str;
                }
            }
            str = null;
            if (str == null) {
            }
            if (useCache) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public SignatureImpl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.modifiers = -1;
        this.lookupClassLoader = null;
        this.stringRep = str;
    }

    @Override // org.aspectj.lang.Signature
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? toString(StringMaker.middleStringMaker) : (String) invokeV.objValue;
    }
}
