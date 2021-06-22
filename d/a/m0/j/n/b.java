package d.a.m0.j.n;

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
import d.a.m0.a.h1.c.f;
import d.a.m0.a.h1.c.h.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f51662h = Boolean.TRUE;

    /* renamed from: a  reason: collision with root package name */
    public d f51663a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f51664b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f51665c;

    /* renamed from: d  reason: collision with root package name */
    public View f51666d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f51667e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f51668f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f51669g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f51670e = false;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f51671f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1128b f51672g;

        public a(c cVar, InterfaceC1128b interfaceC1128b) {
            this.f51671f = cVar;
            this.f51672g = interfaceC1128b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            b.this.a(this.f51671f, (LatLng) valueAnimator.getAnimatedValue());
            if (this.f51670e || animatedFraction <= 0.99d) {
                return;
            }
            this.f51670e = true;
            InterfaceC1128b interfaceC1128b = this.f51672g;
            if (interfaceC1128b != null) {
                interfaceC1128b.onAnimationEnd();
            }
        }
    }

    /* renamed from: d.a.m0.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1128b {
        void onAnimationEnd();
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker = this.f51664b;
        if (marker == null) {
            return;
        }
        marker.setPosition(latLng);
        d.a.m0.a.h1.c.h.c cVar2 = this.f51663a.f46460f;
        cVar2.f46457e = latLng.latitude;
        cVar2.f46458f = latLng.longitude;
        Marker marker2 = this.f51668f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f51662h.booleanValue()) {
            Marker marker3 = this.f51665c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f51667e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f51667e, builder.build());
                this.f51667e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d.b bVar;
        d dVar = this.f51663a;
        if (dVar == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f51663a;
        if (dVar2.o == null || this.f51666d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f51667e);
        this.f51667e.removeView(this.f51666d);
        View a2 = d.a.m0.j.k.f.a.a(cVar, this.f51663a);
        this.f51666d = a2;
        this.f51667e.addView(a2, 0);
        this.f51667e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f51664b.getPosition());
        Bitmap bitmap = this.f51664b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f51663a.o.f46465f)) + 0.0d));
        cVar.l.addView(this.f51667e, builder.build());
        this.f51667e.setAlpha(0.0f);
        Marker marker = this.f51668f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f51667e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f51663a.o.f46464e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f51663a.o.f46465f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        d.a.m0.a.h1.c.h.c cVar2 = this.f51663a.f46460f;
        this.f51668f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f46457e, cVar2.f46458f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC1128b interfaceC1128b) {
        Marker marker;
        ValueAnimator valueAnimator = this.f51669g;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f51664b) != null) {
            float f2 = 360.0f - ((float) fVar.F);
            if (f2 >= 0.0f && f2 <= 360.0f) {
                marker.setRotate(f2);
            }
            int i2 = fVar.G;
            if (i2 < 0) {
                i2 = -i2;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new d.a.m0.j.k.e.h.a(), this.f51664b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.f51669g = ofObject;
            ofObject.setDuration(i2);
            this.f51669g.addUpdateListener(new a(cVar, interfaceC1128b));
            this.f51669g.start();
        }
    }
}
