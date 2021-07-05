package d.a.s0.h3;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(TbPageContextSupport tbPageContextSupport, Animatable animatable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, tbPageContextSupport, animatable) == null) || tbPageContextSupport == null) {
            return;
        }
        tbPageContextSupport.getPageContext().startAnimatable(animatable);
    }

    public static final void b(TbPageContextSupport tbPageContextSupport, View view, Animation animation, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, tbPageContextSupport, view, animation, animationListener) == null) || tbPageContextSupport == null) {
            return;
        }
        tbPageContextSupport.getPageContext().startAnimation(view, animation, animationListener);
    }
}
