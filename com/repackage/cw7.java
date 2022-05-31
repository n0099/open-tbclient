package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class cw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final zv7 a(TbPageContext<?> tbPageContext, ExcContent excContent) {
        InterceptResult invokeLL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, excContent)) == null) {
            if (excContent == null || (l = excContent.type) == null) {
                return null;
            }
            if (l.longValue() == 2) {
                return new xv7(excContent);
            }
            if (excContent.type.longValue() == 0) {
                return new dw7(tbPageContext.getPageActivity(), excContent);
            }
            if (excContent.type.longValue() == 1) {
                return new yv7(tbPageContext, excContent);
            }
            return null;
        }
        return (zv7) invokeLL.objValue;
    }

    public static final aw7 b(ExcContent excContent) {
        InterceptResult invokeL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, excContent)) == null) {
            if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
                return null;
            }
            return new bw7(excContent);
        }
        return (aw7) invokeL.objValue;
    }
}
