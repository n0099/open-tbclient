package org.aspectj.internal.lang.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.dash.manifest.UrlTemplate;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.aspectj.internal.lang.annotation.ajcDeclareEoW;
import org.aspectj.internal.lang.annotation.ajcDeclareParents;
import org.aspectj.internal.lang.annotation.ajcDeclarePrecedence;
import org.aspectj.internal.lang.annotation.ajcDeclareSoft;
import org.aspectj.internal.lang.annotation.ajcITD;
import org.aspectj.internal.lang.annotation.ajcPrivileged;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareError;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.DeclareWarning;
import org.aspectj.lang.reflect.Advice;
import org.aspectj.lang.reflect.AdviceKind;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.DeclareAnnotation;
import org.aspectj.lang.reflect.DeclareErrorOrWarning;
import org.aspectj.lang.reflect.DeclarePrecedence;
import org.aspectj.lang.reflect.DeclareSoft;
import org.aspectj.lang.reflect.InterTypeConstructorDeclaration;
import org.aspectj.lang.reflect.InterTypeFieldDeclaration;
import org.aspectj.lang.reflect.InterTypeMethodDeclaration;
import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.aspectj.lang.reflect.NoSuchPointcutException;
import org.aspectj.lang.reflect.PerClause;
import org.aspectj.lang.reflect.PerClauseKind;
import org.aspectj.lang.reflect.Pointcut;
/* loaded from: classes8.dex */
public class AjTypeImpl implements AjType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ajcMagic = "ajc$";
    public transient /* synthetic */ FieldHolder $fh;
    public Advice[] advice;
    public Class clazz;
    public Advice[] declaredAdvice;
    public InterTypeConstructorDeclaration[] declaredITDCons;
    public InterTypeFieldDeclaration[] declaredITDFields;
    public InterTypeMethodDeclaration[] declaredITDMethods;
    public Pointcut[] declaredPointcuts;
    public InterTypeConstructorDeclaration[] itdCons;
    public InterTypeFieldDeclaration[] itdFields;
    public InterTypeMethodDeclaration[] itdMethods;
    public Pointcut[] pointcuts;

    private void addAnnotationStyleITDFields(List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, this, list, z) == null) {
        }
    }

    public AjTypeImpl(Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.declaredPointcuts = null;
        this.pointcuts = null;
        this.declaredAdvice = null;
        this.advice = null;
        this.declaredITDMethods = null;
        this.itdMethods = null;
        this.declaredITDFields = null;
        this.itdFields = null;
        this.itdCons = null;
        this.declaredITDCons = null;
        this.clazz = cls;
    }

    private Advice[] getAdvice(Set set) {
        InterceptResult invokeL;
        Advice[] adviceArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, set)) == null) {
            if (this.advice == null) {
                initAdvice();
            }
            ArrayList arrayList = new ArrayList();
            for (Advice advice : this.advice) {
                if (set.contains(advice.getKind())) {
                    arrayList.add(advice);
                }
            }
            Advice[] adviceArr2 = new Advice[arrayList.size()];
            arrayList.toArray(adviceArr2);
            return adviceArr2;
        }
        return (Advice[]) invokeL.objValue;
    }

    private Advice[] getDeclaredAdvice(Set set) {
        InterceptResult invokeL;
        Advice[] adviceArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, set)) == null) {
            if (this.declaredAdvice == null) {
                initDeclaredAdvice();
            }
            ArrayList arrayList = new ArrayList();
            for (Advice advice : this.declaredAdvice) {
                if (set.contains(advice.getKind())) {
                    arrayList.add(advice);
                }
            }
            Advice[] adviceArr2 = new Advice[arrayList.size()];
            arrayList.toArray(adviceArr2);
            return adviceArr2;
        }
        return (Advice[]) invokeL.objValue;
    }

    private void addAnnotationStyleDeclareParents(List list) {
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, list) == null) {
            for (Field field : this.clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(DeclareParents.class) && field.getType().isInterface()) {
                    list.add(new DeclareParentsImpl(((DeclareParents) field.getAnnotation(DeclareParents.class)).value(), field.getType().getName(), false, this));
                }
            }
        }
    }

    private Pointcut asPointcut(Method method) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, method)) == null) {
            org.aspectj.lang.annotation.Pointcut pointcut = (org.aspectj.lang.annotation.Pointcut) method.getAnnotation(org.aspectj.lang.annotation.Pointcut.class);
            if (pointcut != null) {
                String name = method.getName();
                if (name.startsWith(ajcMagic) && (indexOf = (name = name.substring(name.indexOf(UrlTemplate.ESCAPED_DOLLAR) + 2, name.length())).indexOf("$")) != -1) {
                    name = name.substring(0, indexOf);
                }
                return new PointcutImpl(name, pointcut.value(), method, AjTypeSystem.getAjType(method.getDeclaringClass()), pointcut.argNames());
            }
            return null;
        }
        return (Pointcut) invokeL.objValue;
    }

    private boolean isReallyAMethod(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, method)) == null) {
            if (method.getName().startsWith(ajcMagic)) {
                return false;
            }
            if (method.getAnnotations().length == 0) {
                return true;
            }
            if (method.isAnnotationPresent(org.aspectj.lang.annotation.Pointcut.class) || method.isAnnotationPresent(Before.class) || method.isAnnotationPresent(After.class) || method.isAnnotationPresent(AfterReturning.class) || method.isAnnotationPresent(AfterThrowing.class) || method.isAnnotationPresent(Around.class)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void addAnnotationStyleITDMethods(List list, boolean z) {
        Field[] declaredFields;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65539, this, list, z) == null) && isAspect()) {
            for (Field field : this.clazz.getDeclaredFields()) {
                if (field.getType().isInterface() && field.isAnnotationPresent(DeclareParents.class) && ((DeclareParents) field.getAnnotation(DeclareParents.class)).defaultImpl() != DeclareParents.class) {
                    for (Method method : field.getType().getDeclaredMethods()) {
                        if (Modifier.isPublic(method.getModifiers()) || !z) {
                            list.add(new InterTypeMethodDeclarationImpl(this, AjTypeSystem.getAjType(field.getType()), method, 1));
                        }
                    }
                }
            }
        }
    }

    private Advice asAdvice(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, method)) == null) {
            if (method.getAnnotations().length == 0) {
                return null;
            }
            Before before = (Before) method.getAnnotation(Before.class);
            if (before != null) {
                return new AdviceImpl(method, before.value(), AdviceKind.BEFORE);
            }
            After after = (After) method.getAnnotation(After.class);
            if (after != null) {
                return new AdviceImpl(method, after.value(), AdviceKind.AFTER);
            }
            AfterReturning afterReturning = (AfterReturning) method.getAnnotation(AfterReturning.class);
            if (afterReturning != null) {
                String pointcut = afterReturning.pointcut();
                if (pointcut.equals("")) {
                    pointcut = afterReturning.value();
                }
                return new AdviceImpl(method, pointcut, AdviceKind.AFTER_RETURNING, afterReturning.returning());
            }
            AfterThrowing afterThrowing = (AfterThrowing) method.getAnnotation(AfterThrowing.class);
            if (afterThrowing != null) {
                String pointcut2 = afterThrowing.pointcut();
                if (pointcut2 == null) {
                    pointcut2 = afterThrowing.value();
                }
                return new AdviceImpl(method, pointcut2, AdviceKind.AFTER_THROWING, afterThrowing.throwing());
            }
            Around around = (Around) method.getAnnotation(Around.class);
            if (around == null) {
                return null;
            }
            return new AdviceImpl(method, around.value(), AdviceKind.AROUND);
        }
        return (Advice) invokeL.objValue;
    }

    private void initAdvice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Method[] methods = this.clazz.getMethods();
            ArrayList arrayList = new ArrayList();
            for (Method method : methods) {
                Advice asAdvice = asAdvice(method);
                if (asAdvice != null) {
                    arrayList.add(asAdvice);
                }
            }
            Advice[] adviceArr = new Advice[arrayList.size()];
            this.advice = adviceArr;
            arrayList.toArray(adviceArr);
        }
    }

    private void initDeclaredAdvice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            Method[] declaredMethods = this.clazz.getDeclaredMethods();
            ArrayList arrayList = new ArrayList();
            for (Method method : declaredMethods) {
                Advice asAdvice = asAdvice(method);
                if (asAdvice != null) {
                    arrayList.add(asAdvice);
                }
            }
            Advice[] adviceArr = new Advice[arrayList.size()];
            this.declaredAdvice = adviceArr;
            arrayList.toArray(adviceArr);
        }
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Method[] getDeclaredMethods() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Method[] declaredMethods = this.clazz.getDeclaredMethods();
            ArrayList arrayList = new ArrayList();
            for (Method method : declaredMethods) {
                if (isReallyAMethod(method)) {
                    arrayList.add(method);
                }
            }
            Method[] methodArr = new Method[arrayList.size()];
            arrayList.toArray(methodArr);
            return methodArr;
        }
        return (Method[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Pointcut[] getDeclaredPointcuts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            Pointcut[] pointcutArr = this.declaredPointcuts;
            if (pointcutArr != null) {
                return pointcutArr;
            }
            ArrayList arrayList = new ArrayList();
            for (Method method : this.clazz.getDeclaredMethods()) {
                Pointcut asPointcut = asPointcut(method);
                if (asPointcut != null) {
                    arrayList.add(asPointcut);
                }
            }
            Pointcut[] pointcutArr2 = new Pointcut[arrayList.size()];
            arrayList.toArray(pointcutArr2);
            this.declaredPointcuts = pointcutArr2;
            return pointcutArr2;
        }
        return (Pointcut[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Method[] getMethods() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            Method[] methods = this.clazz.getMethods();
            ArrayList arrayList = new ArrayList();
            for (Method method : methods) {
                if (isReallyAMethod(method)) {
                    arrayList.add(method);
                }
            }
            Method[] methodArr = new Method[arrayList.size()];
            arrayList.toArray(methodArr);
            return methodArr;
        }
        return (Method[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Pointcut[] getPointcuts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            Pointcut[] pointcutArr = this.pointcuts;
            if (pointcutArr != null) {
                return pointcutArr;
            }
            ArrayList arrayList = new ArrayList();
            for (Method method : this.clazz.getMethods()) {
                Pointcut asPointcut = asPointcut(method);
                if (asPointcut != null) {
                    arrayList.add(asPointcut);
                }
            }
            Pointcut[] pointcutArr2 = new Pointcut[arrayList.size()];
            arrayList.toArray(pointcutArr2);
            this.pointcuts = pointcutArr2;
            return pointcutArr2;
        }
        return (Pointcut[]) invokeV.objValue;
    }

    private AjType[] toAjTypeArray(Class[] clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, clsArr)) == null) {
            int length = clsArr.length;
            AjType[] ajTypeArr = new AjType[length];
            for (int i = 0; i < length; i++) {
                ajTypeArr[i] = AjTypeSystem.getAjType(clsArr[i]);
            }
            return ajTypeArr;
        }
        return (AjType[]) invokeL.objValue;
    }

    private Class[] toClassArray(AjType[] ajTypeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, ajTypeArr)) == null) {
            int length = ajTypeArr.length;
            Class[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = ajTypeArr[i].getJavaClass();
            }
            return clsArr;
        }
        return (Class[]) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof AjTypeImpl)) {
                return false;
            }
            return ((AjTypeImpl) obj).clazz.equals(this.clazz);
        }
        return invokeL.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Advice[] getAdvice(AdviceKind... adviceKindArr) {
        InterceptResult invokeL;
        EnumSet enumSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adviceKindArr)) == null) {
            if (adviceKindArr.length == 0) {
                enumSet = EnumSet.allOf(AdviceKind.class);
            } else {
                EnumSet noneOf = EnumSet.noneOf(AdviceKind.class);
                noneOf.addAll(Arrays.asList(adviceKindArr));
                enumSet = noneOf;
            }
            return getAdvice(enumSet);
        }
        return (Advice[]) invokeL.objValue;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation getAnnotation(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) {
            return this.clazz.getAnnotation(cls);
        }
        return (Annotation) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Constructor getConstructor(AjType... ajTypeArr) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ajTypeArr)) == null) {
            return this.clazz.getConstructor(toClassArray(ajTypeArr));
        }
        return (Constructor) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Advice[] getDeclaredAdvice(AdviceKind... adviceKindArr) {
        InterceptResult invokeL;
        EnumSet enumSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, adviceKindArr)) == null) {
            if (adviceKindArr.length == 0) {
                enumSet = EnumSet.allOf(AdviceKind.class);
            } else {
                EnumSet noneOf = EnumSet.noneOf(AdviceKind.class);
                noneOf.addAll(Arrays.asList(adviceKindArr));
                enumSet = noneOf;
            }
            return getDeclaredAdvice(enumSet);
        }
        return (Advice[]) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Constructor getDeclaredConstructor(AjType... ajTypeArr) throws NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, ajTypeArr)) == null) {
            return this.clazz.getDeclaredConstructor(toClassArray(ajTypeArr));
        }
        return (Constructor) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Field getDeclaredField(String str) throws NoSuchFieldException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            Field declaredField = this.clazz.getDeclaredField(str);
            if (!declaredField.getName().startsWith(ajcMagic)) {
                return declaredField;
            }
            throw new NoSuchFieldException(str);
        }
        return (Field) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Pointcut getDeclaredPointcut(String str) throws NoSuchPointcutException {
        InterceptResult invokeL;
        Pointcut[] declaredPointcuts;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            for (Pointcut pointcut : getDeclaredPointcuts()) {
                if (pointcut.getName().equals(str)) {
                    return pointcut;
                }
            }
            throw new NoSuchPointcutException(str);
        }
        return (Pointcut) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Field getField(String str) throws NoSuchFieldException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            Field field = this.clazz.getField(str);
            if (!field.getName().startsWith(ajcMagic)) {
                return field;
            }
            throw new NoSuchFieldException(str);
        }
        return (Field) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Pointcut getPointcut(String str) throws NoSuchPointcutException {
        InterceptResult invokeL;
        Pointcut[] pointcuts;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            for (Pointcut pointcut : getPointcuts()) {
                if (pointcut.getName().equals(str)) {
                    return pointcut;
                }
            }
            throw new NoSuchPointcutException(str);
        }
        return (Pointcut) invokeL.objValue;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, cls)) == null) {
            return this.clazz.isAnnotationPresent(cls);
        }
        return invokeL.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public boolean isInstance(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, obj)) == null) {
            return this.clazz.isInstance(obj);
        }
        return invokeL.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Advice getAdvice(String str) throws NoSuchAdviceException {
        InterceptResult invokeL;
        Advice[] adviceArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!str.equals("")) {
                if (this.advice == null) {
                    initAdvice();
                }
                for (Advice advice : this.advice) {
                    if (advice.getName().equals(str)) {
                        return advice;
                    }
                }
                throw new NoSuchAdviceException(str);
            }
            throw new IllegalArgumentException("use getAdvice(AdviceType...) instead for un-named advice");
        }
        return (Advice) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Advice getDeclaredAdvice(String str) throws NoSuchAdviceException {
        InterceptResult invokeL;
        Advice[] adviceArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (!str.equals("")) {
                if (this.declaredAdvice == null) {
                    initDeclaredAdvice();
                }
                for (Advice advice : this.declaredAdvice) {
                    if (advice.getName().equals(str)) {
                        return advice;
                    }
                }
                throw new NoSuchAdviceException(str);
            }
            throw new IllegalArgumentException("use getAdvice(AdviceType...) instead for un-named advice");
        }
        return (Advice) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public AjType[] getAjTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return toAjTypeArray(this.clazz.getClasses());
        }
        return (AjType[]) invokeV.objValue;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.clazz.getAnnotations();
        }
        return (Annotation[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Constructor[] getConstructors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.clazz.getConstructors();
        }
        return (Constructor[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public AjType[] getDeclaredAjTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return toAjTypeArray(this.clazz.getDeclaredClasses());
        }
        return (AjType[]) invokeV.objValue;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.clazz.getDeclaredAnnotations();
        }
        return (Annotation[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Constructor[] getDeclaredConstructors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.clazz.getDeclaredConstructors();
        }
        return (Constructor[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public AjType getDeclaringType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            Class<?> declaringClass = this.clazz.getDeclaringClass();
            if (declaringClass != null) {
                return new AjTypeImpl(declaringClass);
            }
            return null;
        }
        return (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Constructor getEnclosingConstructor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.clazz.getEnclosingConstructor();
        }
        return (Constructor) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Method getEnclosingMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.clazz.getEnclosingMethod();
        }
        return (Method) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public AjType getEnclosingType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            Class<?> enclosingClass = this.clazz.getEnclosingClass();
            if (enclosingClass != null) {
                return new AjTypeImpl(enclosingClass);
            }
            return null;
        }
        return (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Object[] getEnumConstants() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.clazz.getEnumConstants();
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Type getGenericSupertype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.clazz.getGenericSuperclass();
        }
        return (Type) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public AjType[] getInterfaces() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return toAjTypeArray(this.clazz.getInterfaces());
        }
        return (AjType[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Class getJavaClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.clazz;
        }
        return (Class) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public int getModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.clazz.getModifiers();
        }
        return invokeV.intValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.clazz.getName();
        }
        return (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Package getPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.clazz.getPackage();
        }
        return (Package) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public AjType getSupertype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            Class superclass = this.clazz.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return new AjTypeImpl(superclass);
        }
        return (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public TypeVariable[] getTypeParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.clazz.getTypeParameters();
        }
        return (TypeVariable[]) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.clazz.hashCode();
        }
        return invokeV.intValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public boolean isArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.clazz.isArray();
        }
        return invokeV.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public boolean isAspect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.clazz.getAnnotation(Aspect.class) != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public boolean isEnum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.clazz.isEnum();
        }
        return invokeV.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public boolean isInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.clazz.isInterface();
        }
        return invokeV.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public boolean isLocalClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.clazz.isLocalClass() && !isAspect()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public boolean isMemberAspect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (this.clazz.isMemberClass() && isAspect()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public boolean isMemberClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (this.clazz.isMemberClass() && !isAspect()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public boolean isPrimitive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.clazz.isPrimitive();
        }
        return invokeV.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public boolean isPrivileged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (isAspect() && this.clazz.isAnnotationPresent(ajcPrivileged.class)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return getName();
        }
        return (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public DeclareAnnotation[] getDeclareAnnotations() {
        InterceptResult invokeV;
        Method[] declaredMethods;
        Annotation annotation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ajcDeclareAnnotation.class)) {
                    ajcDeclareAnnotation ajcdeclareannotation = (ajcDeclareAnnotation) method.getAnnotation(ajcDeclareAnnotation.class);
                    Annotation[] annotations = method.getAnnotations();
                    int length = annotations.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            Annotation annotation2 = annotations[i];
                            if (annotation2.annotationType() != ajcDeclareAnnotation.class) {
                                annotation = annotation2;
                                break;
                            }
                            i++;
                        } else {
                            annotation = null;
                            break;
                        }
                    }
                    arrayList.add(new DeclareAnnotationImpl(this, ajcdeclareannotation.kind(), ajcdeclareannotation.pattern(), annotation, ajcdeclareannotation.annotation()));
                }
            }
            if (getSupertype().isAspect()) {
                arrayList.addAll(Arrays.asList(getSupertype().getDeclareAnnotations()));
            }
            DeclareAnnotation[] declareAnnotationArr = new DeclareAnnotation[arrayList.size()];
            arrayList.toArray(declareAnnotationArr);
            return declareAnnotationArr;
        }
        return (DeclareAnnotation[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public org.aspectj.lang.reflect.DeclareParents[] getDeclareParents() {
        InterceptResult invokeV;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ajcDeclareParents.class)) {
                    ajcDeclareParents ajcdeclareparents = (ajcDeclareParents) method.getAnnotation(ajcDeclareParents.class);
                    arrayList.add(new DeclareParentsImpl(ajcdeclareparents.targetTypePattern(), ajcdeclareparents.parentTypes(), ajcdeclareparents.isExtends(), this));
                }
            }
            addAnnotationStyleDeclareParents(arrayList);
            if (getSupertype().isAspect()) {
                arrayList.addAll(Arrays.asList(getSupertype().getDeclareParents()));
            }
            org.aspectj.lang.reflect.DeclareParents[] declareParentsArr = new org.aspectj.lang.reflect.DeclareParents[arrayList.size()];
            arrayList.toArray(declareParentsArr);
            return declareParentsArr;
        }
        return (org.aspectj.lang.reflect.DeclareParents[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public DeclarePrecedence[] getDeclarePrecedence() {
        InterceptResult invokeV;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.clazz.isAnnotationPresent(org.aspectj.lang.annotation.DeclarePrecedence.class)) {
                arrayList.add(new DeclarePrecedenceImpl(((org.aspectj.lang.annotation.DeclarePrecedence) this.clazz.getAnnotation(org.aspectj.lang.annotation.DeclarePrecedence.class)).value(), this));
            }
            for (Method method : this.clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ajcDeclarePrecedence.class)) {
                    arrayList.add(new DeclarePrecedenceImpl(((ajcDeclarePrecedence) method.getAnnotation(ajcDeclarePrecedence.class)).value(), this));
                }
            }
            if (getSupertype().isAspect()) {
                arrayList.addAll(Arrays.asList(getSupertype().getDeclarePrecedence()));
            }
            DeclarePrecedence[] declarePrecedenceArr = new DeclarePrecedence[arrayList.size()];
            arrayList.toArray(declarePrecedenceArr);
            return declarePrecedenceArr;
        }
        return (DeclarePrecedence[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public DeclareSoft[] getDeclareSofts() {
        InterceptResult invokeV;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Method method : this.clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ajcDeclareSoft.class)) {
                    ajcDeclareSoft ajcdeclaresoft = (ajcDeclareSoft) method.getAnnotation(ajcDeclareSoft.class);
                    arrayList.add(new DeclareSoftImpl(this, ajcdeclaresoft.pointcut(), ajcdeclaresoft.exceptionType()));
                }
            }
            if (getSupertype().isAspect()) {
                arrayList.addAll(Arrays.asList(getSupertype().getDeclareSofts()));
            }
            DeclareSoft[] declareSoftArr = new DeclareSoft[arrayList.size()];
            arrayList.toArray(declareSoftArr);
            return declareSoftArr;
        }
        return (DeclareSoft[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeConstructorDeclaration[] getDeclaredITDConstructors() {
        InterceptResult invokeV;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.declaredITDCons == null) {
                ArrayList arrayList = new ArrayList();
                for (Method method : this.clazz.getDeclaredMethods()) {
                    if (method.getName().contains("ajc$postInterConstructor") && method.isAnnotationPresent(ajcITD.class)) {
                        ajcITD ajcitd = (ajcITD) method.getAnnotation(ajcITD.class);
                        arrayList.add(new InterTypeConstructorDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), method));
                    }
                }
                InterTypeConstructorDeclaration[] interTypeConstructorDeclarationArr = new InterTypeConstructorDeclaration[arrayList.size()];
                this.declaredITDCons = interTypeConstructorDeclarationArr;
                arrayList.toArray(interTypeConstructorDeclarationArr);
            }
            return this.declaredITDCons;
        }
        return (InterTypeConstructorDeclaration[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeMethodDeclaration[] getDeclaredITDMethods() {
        InterceptResult invokeV;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.declaredITDMethods == null) {
                ArrayList arrayList = new ArrayList();
                for (Method method : this.clazz.getDeclaredMethods()) {
                    if (method.getName().contains("ajc$interMethodDispatch1$") && method.isAnnotationPresent(ajcITD.class)) {
                        ajcITD ajcitd = (ajcITD) method.getAnnotation(ajcITD.class);
                        arrayList.add(new InterTypeMethodDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), ajcitd.name(), method));
                    }
                }
                addAnnotationStyleITDMethods(arrayList, false);
                InterTypeMethodDeclaration[] interTypeMethodDeclarationArr = new InterTypeMethodDeclaration[arrayList.size()];
                this.declaredITDMethods = interTypeMethodDeclarationArr;
                arrayList.toArray(interTypeMethodDeclarationArr);
            }
            return this.declaredITDMethods;
        }
        return (InterTypeMethodDeclaration[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeConstructorDeclaration[] getITDConstructors() {
        InterceptResult invokeV;
        Method[] methods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.itdCons == null) {
                ArrayList arrayList = new ArrayList();
                for (Method method : this.clazz.getMethods()) {
                    if (method.getName().contains("ajc$postInterConstructor") && method.isAnnotationPresent(ajcITD.class)) {
                        ajcITD ajcitd = (ajcITD) method.getAnnotation(ajcITD.class);
                        if (Modifier.isPublic(ajcitd.modifiers())) {
                            arrayList.add(new InterTypeConstructorDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), method));
                        }
                    }
                }
                InterTypeConstructorDeclaration[] interTypeConstructorDeclarationArr = new InterTypeConstructorDeclaration[arrayList.size()];
                this.itdCons = interTypeConstructorDeclarationArr;
                arrayList.toArray(interTypeConstructorDeclarationArr);
            }
            return this.itdCons;
        }
        return (InterTypeConstructorDeclaration[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeMethodDeclaration[] getITDMethods() {
        InterceptResult invokeV;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.itdMethods == null) {
                ArrayList arrayList = new ArrayList();
                for (Method method : this.clazz.getDeclaredMethods()) {
                    if (method.getName().contains("ajc$interMethod$") && method.isAnnotationPresent(ajcITD.class)) {
                        ajcITD ajcitd = (ajcITD) method.getAnnotation(ajcITD.class);
                        if (Modifier.isPublic(ajcitd.modifiers())) {
                            arrayList.add(new InterTypeMethodDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), ajcitd.name(), method));
                        }
                    }
                }
                addAnnotationStyleITDMethods(arrayList, true);
                InterTypeMethodDeclaration[] interTypeMethodDeclarationArr = new InterTypeMethodDeclaration[arrayList.size()];
                this.itdMethods = interTypeMethodDeclarationArr;
                arrayList.toArray(interTypeMethodDeclarationArr);
            }
            return this.itdMethods;
        }
        return (InterTypeMethodDeclaration[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public DeclareErrorOrWarning[] getDeclareErrorOrWarnings() {
        InterceptResult invokeV;
        Field[] declaredFields;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Field field : this.clazz.getDeclaredFields()) {
                try {
                    if (field.isAnnotationPresent(DeclareWarning.class)) {
                        DeclareWarning declareWarning = (DeclareWarning) field.getAnnotation(DeclareWarning.class);
                        if (Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers())) {
                            arrayList.add(new DeclareErrorOrWarningImpl(declareWarning.value(), (String) field.get(null), false, this));
                        }
                    } else if (field.isAnnotationPresent(DeclareError.class)) {
                        DeclareError declareError = (DeclareError) field.getAnnotation(DeclareError.class);
                        if (Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers())) {
                            arrayList.add(new DeclareErrorOrWarningImpl(declareError.value(), (String) field.get(null), true, this));
                        }
                    }
                } catch (IllegalAccessException | IllegalArgumentException unused) {
                }
            }
            for (Method method : this.clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ajcDeclareEoW.class)) {
                    ajcDeclareEoW ajcdeclareeow = (ajcDeclareEoW) method.getAnnotation(ajcDeclareEoW.class);
                    arrayList.add(new DeclareErrorOrWarningImpl(ajcdeclareeow.pointcut(), ajcdeclareeow.message(), ajcdeclareeow.isError(), this));
                }
            }
            DeclareErrorOrWarning[] declareErrorOrWarningArr = new DeclareErrorOrWarning[arrayList.size()];
            arrayList.toArray(declareErrorOrWarningArr);
            return declareErrorOrWarningArr;
        }
        return (DeclareErrorOrWarning[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public PerClause getPerClause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (isAspect()) {
                String value = ((Aspect) this.clazz.getAnnotation(Aspect.class)).value();
                if (value.equals("")) {
                    if (getSupertype().isAspect()) {
                        return getSupertype().getPerClause();
                    }
                    return new PerClauseImpl(PerClauseKind.SINGLETON);
                } else if (value.startsWith("perthis(")) {
                    return new PointcutBasedPerClauseImpl(PerClauseKind.PERTHIS, value.substring(8, value.length() - 1));
                } else {
                    if (value.startsWith("pertarget(")) {
                        return new PointcutBasedPerClauseImpl(PerClauseKind.PERTARGET, value.substring(10, value.length() - 1));
                    }
                    if (value.startsWith("percflow(")) {
                        return new PointcutBasedPerClauseImpl(PerClauseKind.PERCFLOW, value.substring(9, value.length() - 1));
                    }
                    if (value.startsWith("percflowbelow(")) {
                        return new PointcutBasedPerClauseImpl(PerClauseKind.PERCFLOWBELOW, value.substring(14, value.length() - 1));
                    }
                    if (value.startsWith("pertypewithin")) {
                        return new TypePatternBasedPerClauseImpl(PerClauseKind.PERTYPEWITHIN, value.substring(14, value.length() - 1));
                    }
                    throw new IllegalStateException("Per-clause not recognized: " + value);
                }
            }
            return null;
        }
        return (PerClause) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Field[] getDeclaredFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Field[] declaredFields = this.clazz.getDeclaredFields();
            ArrayList arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (!field.getName().startsWith(ajcMagic) && !field.isAnnotationPresent(DeclareWarning.class) && !field.isAnnotationPresent(DeclareError.class)) {
                    arrayList.add(field);
                }
            }
            Field[] fieldArr = new Field[arrayList.size()];
            arrayList.toArray(fieldArr);
            return fieldArr;
        }
        return (Field[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Field[] getFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            Field[] fields = this.clazz.getFields();
            ArrayList arrayList = new ArrayList();
            for (Field field : fields) {
                if (!field.getName().startsWith(ajcMagic) && !field.isAnnotationPresent(DeclareWarning.class) && !field.isAnnotationPresent(DeclareError.class)) {
                    arrayList.add(field);
                }
            }
            Field[] fieldArr = new Field[arrayList.size()];
            arrayList.toArray(fieldArr);
            return fieldArr;
        }
        return (Field[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeConstructorDeclaration getDeclaredITDConstructor(AjType ajType, AjType... ajTypeArr) throws NoSuchMethodException {
        InterceptResult invokeLL;
        InterTypeConstructorDeclaration[] declaredITDConstructors;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, ajType, ajTypeArr)) == null) {
            for (InterTypeConstructorDeclaration interTypeConstructorDeclaration : getDeclaredITDConstructors()) {
                try {
                    if (interTypeConstructorDeclaration.getTargetType().equals(ajType)) {
                        AjType[] parameterTypes = interTypeConstructorDeclaration.getParameterTypes();
                        if (parameterTypes.length == ajTypeArr.length) {
                            for (int i = 0; i < parameterTypes.length; i++) {
                                if (!parameterTypes[i].equals(ajTypeArr[i])) {
                                    break;
                                }
                            }
                            return interTypeConstructorDeclaration;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            throw new NoSuchMethodException();
        }
        return (InterTypeConstructorDeclaration) invokeLL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeConstructorDeclaration getITDConstructor(AjType ajType, AjType... ajTypeArr) throws NoSuchMethodException {
        InterceptResult invokeLL;
        InterTypeConstructorDeclaration[] iTDConstructors;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, ajType, ajTypeArr)) == null) {
            for (InterTypeConstructorDeclaration interTypeConstructorDeclaration : getITDConstructors()) {
                try {
                    if (interTypeConstructorDeclaration.getTargetType().equals(ajType)) {
                        AjType[] parameterTypes = interTypeConstructorDeclaration.getParameterTypes();
                        if (parameterTypes.length == ajTypeArr.length) {
                            for (int i = 0; i < parameterTypes.length; i++) {
                                if (!parameterTypes[i].equals(ajTypeArr[i])) {
                                    break;
                                }
                            }
                            return interTypeConstructorDeclaration;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            throw new NoSuchMethodException();
        }
        return (InterTypeConstructorDeclaration) invokeLL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeFieldDeclaration getDeclaredITDField(String str, AjType ajType) throws NoSuchFieldException {
        InterceptResult invokeLL;
        InterTypeFieldDeclaration[] declaredITDFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, ajType)) == null) {
            for (InterTypeFieldDeclaration interTypeFieldDeclaration : getDeclaredITDFields()) {
                if (interTypeFieldDeclaration.getName().equals(str)) {
                    try {
                        if (interTypeFieldDeclaration.getTargetType().equals(ajType)) {
                            return interTypeFieldDeclaration;
                        }
                    } catch (ClassNotFoundException unused) {
                        continue;
                    }
                }
            }
            throw new NoSuchFieldException(str);
        }
        return (InterTypeFieldDeclaration) invokeLL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeFieldDeclaration getITDField(String str, AjType ajType) throws NoSuchFieldException {
        InterceptResult invokeLL;
        InterTypeFieldDeclaration[] iTDFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, str, ajType)) == null) {
            for (InterTypeFieldDeclaration interTypeFieldDeclaration : getITDFields()) {
                if (interTypeFieldDeclaration.getName().equals(str)) {
                    try {
                        if (interTypeFieldDeclaration.getTargetType().equals(ajType)) {
                            return interTypeFieldDeclaration;
                        }
                    } catch (ClassNotFoundException unused) {
                        continue;
                    }
                }
            }
            throw new NoSuchFieldException(str);
        }
        return (InterTypeFieldDeclaration) invokeLL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeFieldDeclaration[] getDeclaredITDFields() {
        InterceptResult invokeV;
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.declaredITDFields == null) {
                for (Method method : this.clazz.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(ajcITD.class) && method.getName().contains("ajc$interFieldInit")) {
                        ajcITD ajcitd = (ajcITD) method.getAnnotation(ajcITD.class);
                        try {
                            Method declaredMethod = this.clazz.getDeclaredMethod(method.getName().replace("FieldInit", "FieldGetDispatch"), method.getParameterTypes());
                            arrayList.add(new InterTypeFieldDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), ajcitd.name(), AjTypeSystem.getAjType(declaredMethod.getReturnType()), declaredMethod.getGenericReturnType()));
                        } catch (NoSuchMethodException unused) {
                            throw new IllegalStateException("Can't find field get dispatch method for " + method.getName());
                        }
                    }
                }
                addAnnotationStyleITDFields(arrayList, false);
                InterTypeFieldDeclaration[] interTypeFieldDeclarationArr = new InterTypeFieldDeclaration[arrayList.size()];
                this.declaredITDFields = interTypeFieldDeclarationArr;
                arrayList.toArray(interTypeFieldDeclarationArr);
            }
            return this.declaredITDFields;
        }
        return (InterTypeFieldDeclaration[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeFieldDeclaration[] getITDFields() {
        InterceptResult invokeV;
        Method[] methods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.itdFields == null) {
                for (Method method : this.clazz.getMethods()) {
                    if (method.isAnnotationPresent(ajcITD.class)) {
                        ajcITD ajcitd = (ajcITD) method.getAnnotation(ajcITD.class);
                        if (method.getName().contains("ajc$interFieldInit") && Modifier.isPublic(ajcitd.modifiers())) {
                            try {
                                Method declaredMethod = method.getDeclaringClass().getDeclaredMethod(method.getName().replace("FieldInit", "FieldGetDispatch"), method.getParameterTypes());
                                arrayList.add(new InterTypeFieldDeclarationImpl(this, ajcitd.targetType(), ajcitd.modifiers(), ajcitd.name(), AjTypeSystem.getAjType(declaredMethod.getReturnType()), declaredMethod.getGenericReturnType()));
                            } catch (NoSuchMethodException unused) {
                                throw new IllegalStateException("Can't find field get dispatch method for " + method.getName());
                            }
                        }
                    }
                }
                addAnnotationStyleITDFields(arrayList, true);
                InterTypeFieldDeclaration[] interTypeFieldDeclarationArr = new InterTypeFieldDeclaration[arrayList.size()];
                this.itdFields = interTypeFieldDeclarationArr;
                arrayList.toArray(interTypeFieldDeclarationArr);
            }
            return this.itdFields;
        }
        return (InterTypeFieldDeclaration[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeMethodDeclaration getDeclaredITDMethod(String str, AjType ajType, AjType... ajTypeArr) throws NoSuchMethodException {
        InterceptResult invokeLLL;
        InterTypeMethodDeclaration[] declaredITDMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, ajType, ajTypeArr)) == null) {
            for (InterTypeMethodDeclaration interTypeMethodDeclaration : getDeclaredITDMethods()) {
                try {
                    if (interTypeMethodDeclaration.getName().equals(str) && interTypeMethodDeclaration.getTargetType().equals(ajType)) {
                        AjType[] parameterTypes = interTypeMethodDeclaration.getParameterTypes();
                        if (parameterTypes.length == ajTypeArr.length) {
                            for (int i = 0; i < parameterTypes.length; i++) {
                                if (!parameterTypes[i].equals(ajTypeArr[i])) {
                                    break;
                                }
                            }
                            return interTypeMethodDeclaration;
                        }
                        continue;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            throw new NoSuchMethodException(str);
        }
        return (InterTypeMethodDeclaration) invokeLLL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public InterTypeMethodDeclaration getITDMethod(String str, AjType ajType, AjType... ajTypeArr) throws NoSuchMethodException {
        InterceptResult invokeLLL;
        InterTypeMethodDeclaration[] iTDMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048619, this, str, ajType, ajTypeArr)) == null) {
            for (InterTypeMethodDeclaration interTypeMethodDeclaration : getITDMethods()) {
                try {
                    if (interTypeMethodDeclaration.getName().equals(str) && interTypeMethodDeclaration.getTargetType().equals(ajType)) {
                        AjType[] parameterTypes = interTypeMethodDeclaration.getParameterTypes();
                        if (parameterTypes.length == ajTypeArr.length) {
                            for (int i = 0; i < parameterTypes.length; i++) {
                                if (!parameterTypes[i].equals(ajTypeArr[i])) {
                                    break;
                                }
                            }
                            return interTypeMethodDeclaration;
                        }
                        continue;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            throw new NoSuchMethodException(str);
        }
        return (InterTypeMethodDeclaration) invokeLLL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Method getDeclaredMethod(String str, AjType... ajTypeArr) throws NoSuchMethodException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, ajTypeArr)) == null) {
            Method declaredMethod = this.clazz.getDeclaredMethod(str, toClassArray(ajTypeArr));
            if (isReallyAMethod(declaredMethod)) {
                return declaredMethod;
            }
            throw new NoSuchMethodException(str);
        }
        return (Method) invokeLL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AjType
    public Method getMethod(String str, AjType... ajTypeArr) throws NoSuchMethodException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048623, this, str, ajTypeArr)) == null) {
            Method method = this.clazz.getMethod(str, toClassArray(ajTypeArr));
            if (isReallyAMethod(method)) {
                return method;
            }
            throw new NoSuchMethodException(str);
        }
        return (Method) invokeLL.objValue;
    }
}
