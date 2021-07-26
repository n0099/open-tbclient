package d.a.o0.j.n;

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
import d.a.o0.a.h1.c.f;
import d.a.o0.a.h1.c.h.d;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f51008h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f51009a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f51010b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f51011c;

    /* renamed from: d  reason: collision with root package name */
    public View f51012d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f51013e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f51014f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f51015g;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51016e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f51017f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1146b f51018g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f51019h;

        public a(b bVar, c cVar, InterfaceC1146b interfaceC1146b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, interfaceC1146b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51019h = bVar;
            this.f51017f = cVar;
            this.f51018g = interfaceC1146b;
            this.f51016e = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                this.f51019h.a(this.f51017f, (LatLng) valueAnimator.getAnimatedValue());
                if (this.f51016e || animatedFraction <= 0.99d) {
                    return;
                }
                this.f51016e = true;
                InterfaceC1146b interfaceC1146b = this.f51018g;
                if (interfaceC1146b != null) {
                    interfaceC1146b.onAnimationEnd();
                }
            }
        }
    }

    /* renamed from: d.a.o0.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1146b {
        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(412839400, "Ld/a/o0/j/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(412839400, "Ld/a/o0/j/n/b;");
                return;
            }
        }
        f51008h = Boolean.TRUE;
    }

    public b() {
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

    public void a(c cVar, LatLng latLng) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, latLng) == null) || (marker = this.f51010b) == null) {
            return;
        }
        marker.setPosition(latLng);
        d.a.o0.a.h1.c.h.c cVar2 = this.f51009a.f45812f;
        cVar2.f45809e = latLng.latitude;
        cVar2.f45810f = latLng.longitude;
        Marker marker2 = this.f51014f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f51008h.booleanValue()) {
            Marker marker3 = this.f51011c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f51013e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f51013e, builder.build());
                this.f51013e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d dVar;
        d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (dVar = this.f51009a) == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f51009a;
        if (dVar2.o == null || this.f51012d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f51013e);
        this.f51013e.removeView(this.f51012d);
        View a2 = d.a.o0.j.k.f.a.a(cVar, this.f51009a);
        this.f51012d = a2;
        this.f51013e.addView(a2, 0);
        this.f51013e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f51010b.getPosition());
        Bitmap bitmap = this.f51010b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f51009a.o.f45817f)) + 0.0d));
        cVar.l.addView(this.f51013e, builder.build());
        this.f51013e.setAlpha(0.0f);
        Marker marker = this.f51014f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f51013e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f51009a.o.f45816e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f51009a.o.f45817f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        d.a.o0.a.h1.c.h.c cVar2 = this.f51009a.f45812f;
        this.f51014f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f45809e, cVar2.f45810f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC1146b interfaceC1146b) {
        Marker marker;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, latLng, fVar, interfaceC1146b) == null) {
            ValueAnimator valueAnimator = this.f51015g;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f51010b) != null) {
                float f2 = 360.0f - ((float) fVar.F);
                if (f2 >= 0.0f && f2 <= 360.0f) {
                    marker.setRotate(f2);
                }
                int i2 = fVar.G;
                if (i2 < 0) {
                    i2 = -i2;
                }
                ValueAnimator ofObject = ValueAnimator.ofObject(new d.a.o0.j.k.e.h.a(), this.f51010b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
                this.f51015g = ofObject;
                ofObject.setDuration(i2);
                this.f51015g.addUpdateListener(new a(this, cVar, interfaceC1146b));
                this.f51015g.start();
            }
        }
    }
}
