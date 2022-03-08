package j.a.a.e.h;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, view, imageView) == null) || view == null || imageView == null) {
            return;
        }
        view.setVisibility(8);
        ObjectAnimator objectAnimator = imageView.getTag() != null ? (ObjectAnimator) imageView.getTag() : null;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            imageView.setTag(null);
            RLog.debug("ObjectAnimatorUtils", "hideDialogLoading->oldRotateAnimator.cancel()");
        }
    }

    public static void b(View view, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, view, imageView) == null) || view == null || imageView == null) {
            return;
        }
        ObjectAnimator objectAnimator = imageView.getTag() != null ? (ObjectAnimator) imageView.getTag() : null;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            imageView.setTag(null);
            RLog.debug("ObjectAnimatorUtils", "showDialogLoading->oldRotateAnimator.cancel()");
        }
        view.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        imageView.setTag(ofFloat);
    }
}
