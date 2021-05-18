package d.a.i0.j.n;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import d.a.i0.a.h1.c.f;
import d.a.i0.a.h1.c.h.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f47704h = Boolean.TRUE;

    /* renamed from: a  reason: collision with root package name */
    public d f47705a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f47706b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f47707c;

    /* renamed from: d  reason: collision with root package name */
    public View f47708d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f47709e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f47710f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f47711g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f47712e = false;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f47713f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1058b f47714g;

        public a(c cVar, InterfaceC1058b interfaceC1058b) {
            this.f47713f = cVar;
            this.f47714g = interfaceC1058b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            b.this.a(this.f47713f, (LatLng) valueAnimator.getAnimatedValue());
            if (this.f47712e || animatedFraction <= 0.99d) {
                return;
            }
            this.f47712e = true;
            InterfaceC1058b interfaceC1058b = this.f47714g;
            if (interfaceC1058b != null) {
                interfaceC1058b.onAnimationEnd();
            }
        }
    }

    /* renamed from: d.a.i0.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1058b {
        void onAnimationEnd();
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker = this.f47706b;
        if (marker == null) {
            return;
        }
        marker.setPosition(latLng);
        d.a.i0.a.h1.c.h.c cVar2 = this.f47705a.f42502f;
        cVar2.f42499e = latLng.latitude;
        cVar2.f42500f = latLng.longitude;
        Marker marker2 = this.f47710f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f47704h.booleanValue()) {
            Marker marker3 = this.f47707c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f47709e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f47709e, builder.build());
                this.f47709e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d.b bVar;
        d dVar = this.f47705a;
        if (dVar == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f47705a;
        if (dVar2.o == null || this.f47708d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f47709e);
        this.f47709e.removeView(this.f47708d);
        View a2 = d.a.i0.j.k.f.a.a(cVar, this.f47705a);
        this.f47708d = a2;
        this.f47709e.addView(a2, 0);
        this.f47709e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f47706b.getPosition());
        Bitmap bitmap = this.f47706b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f47705a.o.f42507f)) + 0.0d));
        cVar.l.addView(this.f47709e, builder.build());
        this.f47709e.setAlpha(0.0f);
        Marker marker = this.f47710f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f47709e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f47705a.o.f42506e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f47705a.o.f42507f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        d.a.i0.a.h1.c.h.c cVar2 = this.f47705a.f42502f;
        this.f47710f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f42499e, cVar2.f42500f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC1058b interfaceC1058b) {
        Marker marker;
        ValueAnimator valueAnimator = this.f47711g;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f47706b) != null) {
            float f2 = 360.0f - ((float) fVar.F);
            if (f2 >= 0.0f && f2 <= 360.0f) {
                marker.setRotate(f2);
            }
            int i2 = fVar.G;
            if (i2 < 0) {
                i2 = -i2;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new d.a.i0.j.k.e.h.a(), this.f47706b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.f47711g = ofObject;
            ofObject.setDuration(i2);
            this.f47711g.addUpdateListener(new a(cVar, interfaceC1058b));
            this.f47711g.start();
        }
    }
}
