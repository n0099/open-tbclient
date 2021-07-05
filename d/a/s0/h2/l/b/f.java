package d.a.s0.h2.l.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final c a(TbPageContext<?> tbPageContext, ExcContent excContent) {
        InterceptResult invokeLL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, excContent)) == null) {
            if (excContent == null || (l = excContent.type) == null) {
                return null;
            }
            if (l.longValue() == 2) {
                return new a(excContent);
            }
            if (excContent.type.longValue() == 0) {
                return new g(tbPageContext.getPageActivity(), excContent);
            }
            if (excContent.type.longValue() == 1) {
                return new b(tbPageContext, excContent);
            }
            return null;
        }
        return (c) invokeLL.objValue;
    }

    public static final d b(ExcContent excContent) {
        InterceptResult invokeL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, excContent)) == null) {
            if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
                return null;
            }
            return new e(excContent);
        }
        return (d) invokeL.objValue;
    }
}
