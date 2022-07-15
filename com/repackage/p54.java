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
import com.repackage.bn2;
/* loaded from: classes6.dex */
public class p54 {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public bn2 a;
    public Marker b;
    public Marker c;
    public View d;
    public ViewGroup e;
    public Marker f;
    public ValueAnimator g;

    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ q54 b;
        public final /* synthetic */ b c;
        public final /* synthetic */ p54 d;

        public a(p54 p54Var, q54 q54Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p54Var, q54Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = p54Var;
            this.b = q54Var;
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

    /* loaded from: classes6.dex */
    public interface b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755458942, "Lcom/repackage/p54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755458942, "Lcom/repackage/p54;");
                return;
            }
        }
        h = Boolean.TRUE;
    }

    public p54() {
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

    public void a(q54 q54Var, LatLng latLng) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, q54Var, latLng) == null) || (marker = this.b) == null) {
            return;
        }
        marker.setPosition(latLng);
        an2 an2Var = this.a.b;
        an2Var.a = latLng.latitude;
        an2Var.b = latLng.longitude;
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
                q54Var.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                q54Var.l.addView(this.e, builder.build());
                this.e.setAlpha(0.0f);
            }
        }
    }

    public void b(q54 q54Var) {
        bn2 bn2Var;
        bn2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q54Var) == null) || (bn2Var = this.a) == null || (bVar = bn2Var.i) == null || !bVar.isValid()) {
            return;
        }
        bn2 bn2Var2 = this.a;
        if (bn2Var2.k == null || this.d != null || TextUtils.equals(bn2Var2.i.g, "ALWAYS")) {
            return;
        }
        q54Var.l.removeView(this.e);
        this.e.removeView(this.d);
        View a2 = e54.a(q54Var, this.a);
        this.d = a2;
        this.e.addView(a2, 0);
        this.e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.b.getPosition());
        Bitmap bitmap = this.b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.a.k.b)) + 0.0d));
        q54Var.l.addView(this.e, builder.build());
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
        an2 an2Var = this.a.b;
        this.f = (Marker) q54Var.l.getMap().addOverlay(markerOptions.position(new LatLng(an2Var.a, an2Var.b)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(q54 q54Var, LatLng latLng, wm2 wm2Var, b bVar) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, q54Var, latLng, wm2Var, bVar) == null) {
            ValueAnimator valueAnimator = this.g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.b) != null) {
                float f = 360.0f - ((float) wm2Var.B);
                if (f >= 0.0f && f <= 360.0f) {
                    marker.setRotate(f);
                }
                int i = wm2Var.C;
                if (i < 0) {
                    i = -i;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new d54(), this.b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.g = ofObject;
                ofObject.setDuration(i);
                this.g.addUpdateListener(new a(this, q54Var, bVar));
                this.g.start();
            }
        }
    }
}
