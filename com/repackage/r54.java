package com.repackage;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dn2;
/* loaded from: classes7.dex */
public class r54 {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public dn2 a;
    public Marker b;
    public Marker c;
    public View d;
    public ViewGroup e;
    public Marker f;
    public ValueAnimator g;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ s54 b;
        public final /* synthetic */ b c;
        public final /* synthetic */ r54 d;

        public a(r54 r54Var, s54 s54Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r54Var, s54Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = r54Var;
            this.b = s54Var;
            this.c = bVar;
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.d.a(this.b, (LatLng) valueAnimator.getAnimatedValue());
                if (this.a || animatedFraction <= 0.99d) {
                    return;
                }
                this.a = true;
                b bVar = this.c;
                if (bVar != null) {
                    bVar.onAnimationEnd();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755399360, "Lcom/repackage/r54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755399360, "Lcom/repackage/r54;");
                return;
            }
        }
        h = Boolean.TRUE;
    }

    public r54() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(s54 s54Var, LatLng latLng) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, s54Var, latLng) == null) || (marker = this.b) == null) {
            return;
        }
        marker.setPosition(latLng);
        cn2 cn2Var = this.a.b;
        cn2Var.a = latLng.latitude;
        cn2Var.b = latLng.longitude;
        Marker marker2 = this.f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (h.booleanValue()) {
            Marker marker3 = this.c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                s54Var.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                s54Var.l.addView(this.e, builder.build());
                this.e.setAlpha(0.0f);
            }
        }
    }

    public void b(s54 s54Var) {
        dn2 dn2Var;
        dn2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s54Var) == null) || (dn2Var = this.a) == null || (bVar = dn2Var.i) == null || !bVar.isValid()) {
            return;
        }
        dn2 dn2Var2 = this.a;
        if (dn2Var2.k == null || this.d != null || TextUtils.equals(dn2Var2.i.g, "ALWAYS")) {
            return;
        }
        s54Var.l.removeView(this.e);
        this.e.removeView(this.d);
        View a2 = g54.a(s54Var, this.a);
        this.d = a2;
        this.e.addView(a2, 0);
        this.e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.b.getPosition());
        Bitmap bitmap = this.b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.a.k.b)) + 0.0d));
        s54Var.l.addView(this.e, builder.build());
        this.e.setAlpha(0.0f);
        Marker marker = this.f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.a.k.a * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.a.k.b * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        cn2 cn2Var = this.a.b;
        this.f = (Marker) s54Var.l.getMap().addOverlay(markerOptions.position(new LatLng(cn2Var.a, cn2Var.b)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(s54 s54Var, LatLng latLng, ym2 ym2Var, b bVar) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, s54Var, latLng, ym2Var, bVar) == null) {
            ValueAnimator valueAnimator = this.g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.b) != null) {
                float f = 360.0f - ((float) ym2Var.B);
                if (f >= 0.0f && f <= 360.0f) {
                    marker.setRotate(f);
                }
                int i = ym2Var.C;
                if (i < 0) {
                    i = -i;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new f54(), this.b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.g = ofObject;
                ofObject.setDuration(i);
                this.g.addUpdateListener(new a(this, s54Var, bVar));
                this.g.start();
            }
        }
    }
}
