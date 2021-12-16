package org.aspectj.runtime.reflect;

import androidx.core.view.InputDeviceCompat;
import androidx.webkit.ProxyConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.AdviceSignature;
import org.aspectj.lang.reflect.CatchClauseSignature;
import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.FieldSignature;
import org.aspectj.lang.reflect.InitializerSignature;
import org.aspectj.lang.reflect.LockSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.lang.reflect.UnlockSignature;
import org.aspectj.runtime.reflect.JoinPointImpl;
/* loaded from: classes4.dex */
public final class Factory {
    public static /* synthetic */ Interceptable $ic;
    public static Object[] NO_ARGS;
    public static /* synthetic */ Class class$java$lang$ClassNotFoundException;
    public static Hashtable prims;
    public transient /* synthetic */ FieldHolder $fh;
    public int count;
    public String filename;
    public Class lexicalClass;
    public ClassLoader lookupClassLoader;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(925315438, "Lorg/aspectj/runtime/reflect/Factory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(925315438, "Lorg/aspectj/runtime/reflect/Factory;");
                return;
            }
        }
        Hashtable hashtable = new Hashtable();
        prims = hashtable;
        hashtable.put("void", Void.TYPE);
        prims.put("boolean", Boolean.TYPE);
        prims.put("byte", Byte.TYPE);
        prims.put("char", Character.TYPE);
        prims.put("short", Short.TYPE);
        prims.put("int", Integer.TYPE);
        prims.put("long", Long.TYPE);
        prims.put(ShaderParams.VALUE_TYPE_FLOAT, Float.TYPE);
        prims.put("double", Double.TYPE);
        NO_ARGS = new Object[0];
    }

    public Factory(String str, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.filename = str;
        this.lexicalClass = cls;
        this.count = 0;
        this.lookupClassLoader = cls.getClassLoader();
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static Class makeClass(String str, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, classLoader)) == null) {
            if (str.equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
                return null;
            }
            Class cls = (Class) prims.get(str);
            if (cls != null) {
                return cls;
            }
            try {
                if (classLoader == null) {
                    return Class.forName(str);
                }
                return Class.forName(str, false, classLoader);
            } catch (ClassNotFoundException unused) {
                Class cls2 = class$java$lang$ClassNotFoundException;
                if (cls2 == null) {
                    Class class$ = class$("java.lang.ClassNotFoundException");
                    class$java$lang$ClassNotFoundException = class$;
                    return class$;
                }
                return cls2;
            }
        }
        return (Class) invokeLL.objValue;
    }

    public static JoinPoint.StaticPart makeEncSJP(Member member) {
        InterceptResult invokeL;
        Signature constructorSignatureImpl;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, member)) == null) {
            if (member instanceof Method) {
                Method method = (Method) member;
                constructorSignatureImpl = new MethodSignatureImpl(method.getModifiers(), method.getName(), method.getDeclaringClass(), method.getParameterTypes(), new String[method.getParameterTypes().length], method.getExceptionTypes(), method.getReturnType());
                str = JoinPoint.METHOD_EXECUTION;
            } else if (member instanceof Constructor) {
                Constructor constructor = (Constructor) member;
                constructorSignatureImpl = new ConstructorSignatureImpl(constructor.getModifiers(), constructor.getDeclaringClass(), constructor.getParameterTypes(), new String[constructor.getParameterTypes().length], constructor.getExceptionTypes());
                str = JoinPoint.CONSTRUCTOR_EXECUTION;
            } else {
                throw new IllegalArgumentException("member must be either a method or constructor");
            }
            return new JoinPointImpl.EnclosingStaticPartImpl(-1, str, constructorSignatureImpl, null);
        }
        return (JoinPoint.StaticPart) invokeL.objValue;
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, staticPart, obj, obj2)) == null) ? new JoinPointImpl(staticPart, obj, obj2, NO_ARGS) : (JoinPoint) invokeLLL.objValue;
    }

    public AdviceSignature makeAdviceSig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(str);
            adviceSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return adviceSignatureImpl;
        }
        return (AdviceSignature) invokeL.objValue;
    }

    public CatchClauseSignature makeCatchClauseSig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(str);
            catchClauseSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return catchClauseSignatureImpl;
        }
        return (CatchClauseSignature) invokeL.objValue;
    }

    public ConstructorSignature makeConstructorSig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(str);
            constructorSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return constructorSignatureImpl;
        }
        return (ConstructorSignature) invokeL.objValue;
    }

    public JoinPoint.EnclosingStaticPart makeESJP(String str, Signature signature, SourceLocation sourceLocation) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, signature, sourceLocation)) == null) {
            int i2 = this.count;
            this.count = i2 + 1;
            return new JoinPointImpl.EnclosingStaticPartImpl(i2, str, signature, sourceLocation);
        }
        return (JoinPoint.EnclosingStaticPart) invokeLLL.objValue;
    }

    public FieldSignature makeFieldSig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(str);
            fieldSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return fieldSignatureImpl;
        }
        return (FieldSignature) invokeL.objValue;
    }

    public InitializerSignature makeInitializerSig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(str);
            initializerSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return initializerSignatureImpl;
        }
        return (InitializerSignature) invokeL.objValue;
    }

    public LockSignature makeLockSig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            LockSignatureImpl lockSignatureImpl = new LockSignatureImpl(str);
            lockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return lockSignatureImpl;
        }
        return (LockSignature) invokeL.objValue;
    }

    public MethodSignature makeMethodSig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            MethodSignatureImpl methodSignatureImpl = new MethodSignatureImpl(str);
            methodSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return methodSignatureImpl;
        }
        return (MethodSignature) invokeL.objValue;
    }

    public JoinPoint.StaticPart makeSJP(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i2)})) == null) {
            MethodSignature makeMethodSig = makeMethodSig(str2, str3, str4, str5, str6, str7, str8);
            int i3 = this.count;
            this.count = i3 + 1;
            return new JoinPointImpl.StaticPartImpl(i3, str, makeMethodSig, makeSourceLoc(i2, -1));
        }
        return (JoinPoint.StaticPart) invokeCommon.objValue;
    }

    public SourceLocation makeSourceLoc(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048605, this, i2, i3)) == null) ? new SourceLocationImpl(this.lexicalClass, this.filename, i2) : (SourceLocation) invokeII.objValue;
    }

    public UnlockSignature makeUnlockSig(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl(str);
            unlockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return unlockSignatureImpl;
        }
        return (UnlockSignature) invokeL.objValue;
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object obj3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, staticPart, obj, obj2, obj3)) == null) ? new JoinPointImpl(staticPart, obj, obj2, new Object[]{obj3}) : (JoinPoint) invokeLLLL.objValue;
    }

    public JoinPoint.EnclosingStaticPart makeESJP(String str, Signature signature, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048586, this, str, signature, i2, i3)) == null) {
            int i4 = this.count;
            this.count = i4 + 1;
            return new JoinPointImpl.EnclosingStaticPartImpl(i4, str, signature, makeSourceLoc(i2, i3));
        }
        return (JoinPoint.EnclosingStaticPart) invokeLLII.objValue;
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object obj3, Object obj4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, null, staticPart, obj, obj2, obj3, obj4)) == null) ? new JoinPointImpl(staticPart, obj, obj2, new Object[]{obj3, obj4}) : (JoinPoint) invokeLLLLL.objValue;
    }

    public AdviceSignature makeAdviceSig(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, str5, str6, str7})) == null) {
            int parseInt = Integer.parseInt(str, 16);
            Class makeClass = makeClass(str3, this.lookupClassLoader);
            StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
            int countTokens = stringTokenizer.countTokens();
            Class[] clsArr = new Class[countTokens];
            for (int i2 = 0; i2 < countTokens; i2++) {
                clsArr[i2] = makeClass(stringTokenizer.nextToken(), this.lookupClassLoader);
            }
            StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
            int countTokens2 = stringTokenizer2.countTokens();
            String[] strArr = new String[countTokens2];
            for (int i3 = 0; i3 < countTokens2; i3++) {
                strArr[i3] = stringTokenizer2.nextToken();
            }
            StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
            int countTokens3 = stringTokenizer3.countTokens();
            Class[] clsArr2 = new Class[countTokens3];
            for (int i4 = 0; i4 < countTokens3; i4++) {
                clsArr2[i4] = makeClass(stringTokenizer3.nextToken(), this.lookupClassLoader);
            }
            AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(parseInt, str2, makeClass, clsArr, strArr, clsArr2, makeClass(str7, this.lookupClassLoader));
            adviceSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return adviceSignatureImpl;
        }
        return (AdviceSignature) invokeCommon.objValue;
    }

    public CatchClauseSignature makeCatchClauseSig(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, str3)) == null) {
            CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(makeClass(str, this.lookupClassLoader), makeClass(new StringTokenizer(str2, ":").nextToken(), this.lookupClassLoader), new StringTokenizer(str3, ":").nextToken());
            catchClauseSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return catchClauseSignatureImpl;
        }
        return (CatchClauseSignature) invokeLLL.objValue;
    }

    public ConstructorSignature makeConstructorSig(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4, str5)) == null) {
            int parseInt = Integer.parseInt(str, 16);
            Class makeClass = makeClass(str2, this.lookupClassLoader);
            StringTokenizer stringTokenizer = new StringTokenizer(str3, ":");
            int countTokens = stringTokenizer.countTokens();
            Class[] clsArr = new Class[countTokens];
            for (int i2 = 0; i2 < countTokens; i2++) {
                clsArr[i2] = makeClass(stringTokenizer.nextToken(), this.lookupClassLoader);
            }
            StringTokenizer stringTokenizer2 = new StringTokenizer(str4, ":");
            int countTokens2 = stringTokenizer2.countTokens();
            String[] strArr = new String[countTokens2];
            for (int i3 = 0; i3 < countTokens2; i3++) {
                strArr[i3] = stringTokenizer2.nextToken();
            }
            StringTokenizer stringTokenizer3 = new StringTokenizer(str5, ":");
            int countTokens3 = stringTokenizer3.countTokens();
            Class[] clsArr2 = new Class[countTokens3];
            for (int i4 = 0; i4 < countTokens3; i4++) {
                clsArr2[i4] = makeClass(stringTokenizer3.nextToken(), this.lookupClassLoader);
            }
            ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(parseInt, makeClass, clsArr, strArr, clsArr2);
            constructorSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return constructorSignatureImpl;
        }
        return (ConstructorSignature) invokeLLLLL.objValue;
    }

    public JoinPoint.EnclosingStaticPart makeESJP(String str, Signature signature, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, str, signature, i2)) == null) {
            int i3 = this.count;
            this.count = i3 + 1;
            return new JoinPointImpl.EnclosingStaticPartImpl(i3, str, signature, makeSourceLoc(i2, -1));
        }
        return (JoinPoint.EnclosingStaticPart) invokeLLI.objValue;
    }

    public FieldSignature makeFieldSig(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, str, str2, str3, str4)) == null) {
            FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(Integer.parseInt(str, 16), str2, makeClass(str3, this.lookupClassLoader), makeClass(str4, this.lookupClassLoader));
            fieldSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return fieldSignatureImpl;
        }
        return (FieldSignature) invokeLLLL.objValue;
    }

    public InitializerSignature makeInitializerSig(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(Integer.parseInt(str, 16), makeClass(str2, this.lookupClassLoader));
            initializerSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return initializerSignatureImpl;
        }
        return (InitializerSignature) invokeLL.objValue;
    }

    public LockSignature makeLockSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            LockSignatureImpl lockSignatureImpl = new LockSignatureImpl(makeClass("Ljava/lang/Object;", this.lookupClassLoader));
            lockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return lockSignatureImpl;
        }
        return (LockSignature) invokeV.objValue;
    }

    public MethodSignature makeMethodSig(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{str, str2, str3, str4, str5, str6, str7})) == null) {
            int parseInt = Integer.parseInt(str, 16);
            Class makeClass = makeClass(str3, this.lookupClassLoader);
            StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
            int countTokens = stringTokenizer.countTokens();
            Class[] clsArr = new Class[countTokens];
            for (int i2 = 0; i2 < countTokens; i2++) {
                clsArr[i2] = makeClass(stringTokenizer.nextToken(), this.lookupClassLoader);
            }
            StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
            int countTokens2 = stringTokenizer2.countTokens();
            String[] strArr = new String[countTokens2];
            for (int i3 = 0; i3 < countTokens2; i3++) {
                strArr[i3] = stringTokenizer2.nextToken();
            }
            StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
            int countTokens3 = stringTokenizer3.countTokens();
            Class[] clsArr2 = new Class[countTokens3];
            for (int i4 = 0; i4 < countTokens3; i4++) {
                clsArr2[i4] = makeClass(stringTokenizer3.nextToken(), this.lookupClassLoader);
            }
            return new MethodSignatureImpl(parseInt, str2, makeClass, clsArr, strArr, clsArr2, makeClass(str7, this.lookupClassLoader));
        }
        return (MethodSignature) invokeCommon.objValue;
    }

    public JoinPoint.StaticPart makeSJP(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i2)})) == null) {
            MethodSignature makeMethodSig = makeMethodSig(str2, str3, str4, str5, str6, "", str7);
            int i3 = this.count;
            this.count = i3 + 1;
            return new JoinPointImpl.StaticPartImpl(i3, str, makeMethodSig, makeSourceLoc(i2, -1));
        }
        return (JoinPoint.StaticPart) invokeCommon.objValue;
    }

    public UnlockSignature makeUnlockSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl(makeClass("Ljava/lang/Object;", this.lookupClassLoader));
            unlockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return unlockSignatureImpl;
        }
        return (UnlockSignature) invokeV.objValue;
    }

    public static JoinPoint makeJP(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object[] objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, staticPart, obj, obj2, objArr)) == null) ? new JoinPointImpl(staticPart, obj, obj2, objArr) : (JoinPoint) invokeLLLL.objValue;
    }

    public JoinPoint.StaticPart makeSJP(String str, Signature signature, SourceLocation sourceLocation) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, str, signature, sourceLocation)) == null) {
            int i2 = this.count;
            this.count = i2 + 1;
            return new JoinPointImpl.StaticPartImpl(i2, str, signature, sourceLocation);
        }
        return (JoinPoint.StaticPart) invokeLLL.objValue;
    }

    public LockSignature makeLockSig(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, cls)) == null) {
            LockSignatureImpl lockSignatureImpl = new LockSignatureImpl(cls);
            lockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return lockSignatureImpl;
        }
        return (LockSignature) invokeL.objValue;
    }

    public JoinPoint.StaticPart makeSJP(String str, Signature signature, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048603, this, str, signature, i2, i3)) == null) {
            int i4 = this.count;
            this.count = i4 + 1;
            return new JoinPointImpl.StaticPartImpl(i4, str, signature, makeSourceLoc(i2, i3));
        }
        return (JoinPoint.StaticPart) invokeLLII.objValue;
    }

    public UnlockSignature makeUnlockSig(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, cls)) == null) {
            UnlockSignatureImpl unlockSignatureImpl = new UnlockSignatureImpl(cls);
            unlockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return unlockSignatureImpl;
        }
        return (UnlockSignature) invokeL.objValue;
    }

    public InitializerSignature makeInitializerSig(int i2, Class cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i2, cls)) == null) {
            InitializerSignatureImpl initializerSignatureImpl = new InitializerSignatureImpl(i2, cls);
            initializerSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return initializerSignatureImpl;
        }
        return (InitializerSignature) invokeIL.objValue;
    }

    public JoinPoint.StaticPart makeSJP(String str, Signature signature, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048602, this, str, signature, i2)) == null) {
            int i3 = this.count;
            this.count = i3 + 1;
            return new JoinPointImpl.StaticPartImpl(i3, str, signature, makeSourceLoc(i2, -1));
        }
        return (JoinPoint.StaticPart) invokeLLI.objValue;
    }

    public FieldSignature makeFieldSig(int i2, String str, Class cls, Class cls2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), str, cls, cls2})) == null) {
            FieldSignatureImpl fieldSignatureImpl = new FieldSignatureImpl(i2, str, cls, cls2);
            fieldSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return fieldSignatureImpl;
        }
        return (FieldSignature) invokeCommon.objValue;
    }

    public CatchClauseSignature makeCatchClauseSig(Class cls, Class cls2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, cls, cls2, str)) == null) {
            CatchClauseSignatureImpl catchClauseSignatureImpl = new CatchClauseSignatureImpl(cls, cls2, str);
            catchClauseSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return catchClauseSignatureImpl;
        }
        return (CatchClauseSignature) invokeLLL.objValue;
    }

    public ConstructorSignature makeConstructorSig(int i2, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), cls, clsArr, strArr, clsArr2})) == null) {
            ConstructorSignatureImpl constructorSignatureImpl = new ConstructorSignatureImpl(i2, cls, clsArr, strArr, clsArr2);
            constructorSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return constructorSignatureImpl;
        }
        return (ConstructorSignature) invokeCommon.objValue;
    }

    public MethodSignature makeMethodSig(int i2, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), str, cls, clsArr, strArr, clsArr2, cls2})) == null) {
            MethodSignatureImpl methodSignatureImpl = new MethodSignatureImpl(i2, str, cls, clsArr, strArr, clsArr2, cls2);
            methodSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return methodSignatureImpl;
        }
        return (MethodSignature) invokeCommon.objValue;
    }

    public AdviceSignature makeAdviceSig(int i2, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, cls, clsArr, strArr, clsArr2, cls2})) == null) {
            AdviceSignatureImpl adviceSignatureImpl = new AdviceSignatureImpl(i2, str, cls, clsArr, strArr, clsArr2, cls2);
            adviceSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
            return adviceSignatureImpl;
        }
        return (AdviceSignature) invokeCommon.objValue;
    }
}
