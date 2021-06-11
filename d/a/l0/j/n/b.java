package d.a.l0.j.n;

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
import d.a.l0.a.h1.c.f;
import d.a.l0.a.h1.c.h.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f51554h = Boolean.TRUE;

    /* renamed from: a  reason: collision with root package name */
    public d f51555a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f51556b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f51557c;

    /* renamed from: d  reason: collision with root package name */
    public View f51558d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f51559e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f51560f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f51561g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f51562e = false;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f51563f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1125b f51564g;

        public a(c cVar, InterfaceC1125b interfaceC1125b) {
            this.f51563f = cVar;
            this.f51564g = interfaceC1125b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            b.this.a(this.f51563f, (LatLng) valueAnimator.getAnimatedValue());
            if (this.f51562e || animatedFraction <= 0.99d) {
                return;
            }
            this.f51562e = true;
            InterfaceC1125b interfaceC1125b = this.f51564g;
            if (interfaceC1125b != null) {
                interfaceC1125b.onAnimationEnd();
            }
        }
    }

    /* renamed from: d.a.l0.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1125b {
        void onAnimationEnd();
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker = this.f51556b;
        if (marker == null) {
            return;
        }
        marker.setPosition(latLng);
        d.a.l0.a.h1.c.h.c cVar2 = this.f51555a.f46352f;
        cVar2.f46349e = latLng.latitude;
        cVar2.f46350f = latLng.longitude;
        Marker marker2 = this.f51560f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f51554h.booleanValue()) {
            Marker marker3 = this.f51557c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f51559e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f51559e, builder.build());
                this.f51559e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d.b bVar;
        d dVar = this.f51555a;
        if (dVar == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f51555a;
        if (dVar2.o == null || this.f51558d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f51559e);
        this.f51559e.removeView(this.f51558d);
        View a2 = d.a.l0.j.k.f.a.a(cVar, this.f51555a);
        this.f51558d = a2;
        this.f51559e.addView(a2, 0);
        this.f51559e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f51556b.getPosition());
        Bitmap bitmap = this.f51556b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f51555a.o.f46357f)) + 0.0d));
        cVar.l.addView(this.f51559e, builder.build());
        this.f51559e.setAlpha(0.0f);
        Marker marker = this.f51560f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f51559e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f51555a.o.f46356e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f51555a.o.f46357f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        d.a.l0.a.h1.c.h.c cVar2 = this.f51555a.f46352f;
        this.f51560f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f46349e, cVar2.f46350f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC1125b interfaceC1125b) {
        Marker marker;
        ValueAnimator valueAnimator = this.f51561g;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f51556b) != null) {
            float f2 = 360.0f - ((float) fVar.F);
            if (f2 >= 0.0f && f2 <= 360.0f) {
                marker.setRotate(f2);
            }
            int i2 = fVar.G;
            if (i2 < 0) {
                i2 = -i2;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new d.a.l0.j.k.e.h.a(), this.f51556b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.f51561g = ofObject;
            ofObject.setDuration(i2);
            this.f51561g.addUpdateListener(new a(cVar, interfaceC1125b));
            this.f51561g.start();
        }
    }
}
