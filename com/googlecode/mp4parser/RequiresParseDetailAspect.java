package com.googlecode.mp4parser;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
/* loaded from: classes7.dex */
public class RequiresParseDetailAspect {
    public static /* synthetic */ Interceptable $ic;
    public static /* synthetic */ Throwable ajc$initFailureCause;
    public static final /* synthetic */ RequiresParseDetailAspect ajc$perSingletonInstance = null;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1222822235, "Lcom/googlecode/mp4parser/RequiresParseDetailAspect;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1222822235, "Lcom/googlecode/mp4parser/RequiresParseDetailAspect;");
                return;
            }
        }
        try {
            ajc$postClinit();
        } catch (Throwable th) {
            ajc$initFailureCause = th;
        }
    }

    public RequiresParseDetailAspect() {
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

    public static /* synthetic */ void ajc$postClinit() {
        ajc$perSingletonInstance = new RequiresParseDetailAspect();
    }

    public static RequiresParseDetailAspect aspectOf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            RequiresParseDetailAspect requiresParseDetailAspect = ajc$perSingletonInstance;
            if (requiresParseDetailAspect != null) {
                return requiresParseDetailAspect;
            }
            throw new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", ajc$initFailureCause);
        }
        return (RequiresParseDetailAspect) invokeV.objValue;
    }

    public static boolean hasAspect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? ajc$perSingletonInstance != null : invokeV.booleanValue;
    }

    @Before("this(com.googlecode.mp4parser.AbstractBox) && ((execution(public * * (..)) && !( execution(* parseDetails()) || execution(* getNumOfBytesToFirstChild()) || execution(* getType()) || execution(* isParsed()) || execution(* getHeader(*)) || execution(* parse()) || execution(* getBox(*)) || execution(* getSize()) || execution(* getOffset()) || execution(* parseDetails()) || execution(* _parseDetails(*)) || execution(* parse(*,*,*,*)) || execution(* getIsoFile()) || execution(* getParent()) || execution(* setParent(*)) || execution(* getUserType()) || execution(* setUserType(*))) && !@annotation(com.googlecode.mp4parser.annotations.DoNotParseDetail)) || @annotation(com.googlecode.mp4parser.annotations.ParseDetail))")
    public void before(JoinPoint joinPoint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, joinPoint) == null) {
            if (joinPoint.getTarget() instanceof AbstractBox) {
                if (((AbstractBox) joinPoint.getTarget()).isParsed()) {
                    return;
                }
                ((AbstractBox) joinPoint.getTarget()).parseDetails();
                return;
            }
            throw new RuntimeException("Only methods in subclasses of " + AbstractBox.class.getName() + " can  be annotated with ParseDetail");
        }
    }
}
