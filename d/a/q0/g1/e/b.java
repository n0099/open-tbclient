package d.a.q0.g1.e;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b2 b2Var, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65536, null, b2Var, str, str2, i2) == null) || b2Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13022").param("obj_name", str).param("tid", b2Var.o1()).param("fid", b2Var.R()).param("obj_source", b2Var.T0).param("obj_locate", str2).param("obj_type", i2).param("ab_tag", b2Var.V0));
    }
}
