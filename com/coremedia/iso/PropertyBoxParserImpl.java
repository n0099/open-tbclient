package com.coremedia.iso;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.api.Constants;
import com.coremedia.iso.boxes.Box;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class PropertyBoxParserImpl extends AbstractBoxParser {
    public static String[] EMPTY_STRING_ARRAY = new String[0];
    public String clazzName;
    public Properties mapping;
    public String[] param;
    public Pattern constuctorPattern = Pattern.compile("(.*)\\((.*?)\\)");
    public StringBuilder buildLookupStrings = new StringBuilder();

    public PropertyBoxParserImpl(String... strArr) {
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
        invoke(str, bArr, str2);
        try {
            Class<?> cls = Class.forName(this.clazzName);
            if (this.param.length > 0) {
                Class<?>[] clsArr = new Class[this.param.length];
                Object[] objArr = new Object[this.param.length];
                for (int i = 0; i < this.param.length; i++) {
                    if (Constants.USER_TYPE_KEY.equals(this.param[i])) {
                        objArr[i] = bArr;
                        clsArr[i] = byte[].class;
                    } else if ("type".equals(this.param[i])) {
                        objArr[i] = str;
                        clsArr[i] = String.class;
                    } else if ("parent".equals(this.param[i])) {
                        objArr[i] = str2;
                        clsArr[i] = String.class;
                    } else {
                        throw new InternalError("No such param: " + this.param[i]);
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

    public void invoke(String str, byte[] bArr, String str2) {
        String property;
        if (bArr != null) {
            if ("uuid".equals(str)) {
                Properties properties = this.mapping;
                property = properties.getProperty("uuid[" + Hex.encodeHex(bArr).toUpperCase() + "]");
                if (property == null) {
                    Properties properties2 = this.mapping;
                    property = properties2.getProperty(String.valueOf(str2) + "-uuid[" + Hex.encodeHex(bArr).toUpperCase() + "]");
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
                sb.append('-');
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

    public PropertyBoxParserImpl(Properties properties) {
        this.mapping = properties;
    }
}
