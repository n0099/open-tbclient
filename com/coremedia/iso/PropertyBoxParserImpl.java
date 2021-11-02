package com.coremedia.iso;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.Box;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes11.dex */
public class PropertyBoxParserImpl extends AbstractBoxParser {
    public static /* synthetic */ Interceptable $ic;
    public static String[] EMPTY_STRING_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;
    public StringBuilder buildLookupStrings;
    public String clazzName;
    public Pattern constuctorPattern;
    public Properties mapping;
    public String[] param;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(854281556, "Lcom/coremedia/iso/PropertyBoxParserImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(854281556, "Lcom/coremedia/iso/PropertyBoxParserImpl;");
                return;
            }
        }
        EMPTY_STRING_ARRAY = new String[0];
    }

    public PropertyBoxParserImpl(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.constuctorPattern = Pattern.compile("(.*)\\((.*?)\\)");
        this.buildLookupStrings = new StringBuilder();
        InputStream resourceAsStream = PropertyBoxParserImpl.class.getResourceAsStream("/isoparser-default.properties");
        try {
            Properties properties = new Properties();
            this.mapping = properties;
            try {
                properties.load(resourceAsStream);
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                Enumeration<URL> resources = (contextClassLoader == null ? ClassLoader.getSystemClassLoader() : contextClassLoader).getResources("isoparser-custom.properties");
                while (resources.hasMoreElements()) {
                    InputStream openStream = resources.nextElement().openStream();
                    try {
                        this.mapping.load(openStream);
                        openStream.close();
                    } catch (Throwable th) {
                        openStream.close();
                        throw th;
                    }
                }
                for (String str : strArr) {
                    this.mapping.load(getClass().getResourceAsStream(str));
                }
                try {
                    resourceAsStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        } catch (Throwable th2) {
            try {
                resourceAsStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th2;
        }
    }

    @Override // com.coremedia.iso.AbstractBoxParser
    public Box createBox(String str, byte[] bArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, bArr, str2)) == null) {
            invoke(str, bArr, str2);
            try {
                Class<?> cls = Class.forName(this.clazzName);
                if (this.param.length > 0) {
                    Class<?>[] clsArr = new Class[this.param.length];
                    Object[] objArr = new Object[this.param.length];
                    for (int i2 = 0; i2 < this.param.length; i2++) {
                        if ("userType".equals(this.param[i2])) {
                            objArr[i2] = bArr;
                            clsArr[i2] = byte[].class;
                        } else if ("type".equals(this.param[i2])) {
                            objArr[i2] = str;
                            clsArr[i2] = String.class;
                        } else if ("parent".equals(this.param[i2])) {
                            objArr[i2] = str2;
                            clsArr[i2] = String.class;
                        } else {
                            throw new InternalError("No such param: " + this.param[i2]);
                        }
                    }
                    return (Box) cls.getConstructor(clsArr).newInstance(objArr);
                }
                return (Box) cls.newInstance();
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException(e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException(e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException(e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException(e6);
            }
        }
        return (Box) invokeLLL.objValue;
    }

    public void invoke(String str, byte[] bArr, String str2) {
        String property;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr, str2) == null) {
            if (bArr != null) {
                if ("uuid".equals(str)) {
                    Properties properties = this.mapping;
                    property = properties.getProperty("uuid[" + Hex.encodeHex(bArr).toUpperCase() + PreferencesUtil.RIGHT_MOUNT);
                    if (property == null) {
                        Properties properties2 = this.mapping;
                        property = properties2.getProperty(String.valueOf(str2) + "-uuid[" + Hex.encodeHex(bArr).toUpperCase() + PreferencesUtil.RIGHT_MOUNT);
                    }
                    if (property == null) {
                        property = this.mapping.getProperty("uuid");
                    }
                } else {
                    throw new RuntimeException("we have a userType but no uuid box type. Something's wrong");
                }
            } else {
                property = this.mapping.getProperty(str);
                if (property == null) {
                    StringBuilder sb = this.buildLookupStrings;
                    sb.append(str2);
                    sb.append(SignatureImpl.SEP);
                    sb.append(str);
                    String sb2 = sb.toString();
                    this.buildLookupStrings.setLength(0);
                    property = this.mapping.getProperty(sb2);
                }
            }
            if (property == null) {
                property = this.mapping.getProperty("default");
            }
            if (property != null) {
                if (!property.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                    this.param = EMPTY_STRING_ARRAY;
                    this.clazzName = property;
                    return;
                }
                Matcher matcher = this.constuctorPattern.matcher(property);
                if (matcher.matches()) {
                    this.clazzName = matcher.group(1);
                    if (matcher.group(2).length() == 0) {
                        this.param = EMPTY_STRING_ARRAY;
                        return;
                    } else {
                        this.param = matcher.group(2).length() > 0 ? matcher.group(2).split(",") : new String[0];
                        return;
                    }
                }
                throw new RuntimeException("Cannot work with that constructor: " + property);
            }
            throw new RuntimeException("No box object found for " + str);
        }
    }

    public PropertyBoxParserImpl(Properties properties) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {properties};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.constuctorPattern = Pattern.compile("(.*)\\((.*?)\\)");
        this.buildLookupStrings = new StringBuilder();
        this.mapping = properties;
    }
}
