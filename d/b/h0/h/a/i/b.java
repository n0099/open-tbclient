package d.b.h0.h.a.i;

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
import d.b.h0.a.a1.c.h.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f49478h = Boolean.TRUE;

    /* renamed from: a  reason: collision with root package name */
    public d f49479a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f49480b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f49481c;

    /* renamed from: d  reason: collision with root package name */
    public View f49482d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f49483e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f49484f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f49485g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f49486e = false;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f49487f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1040b f49488g;

        public a(c cVar, InterfaceC1040b interfaceC1040b) {
            this.f49487f = cVar;
            this.f49488g = interfaceC1040b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            b.this.a(this.f49487f, (LatLng) valueAnimator.getAnimatedValue());
            if (this.f49486e || animatedFraction <= 0.99d) {
                return;
            }
            this.f49486e = true;
            InterfaceC1040b interfaceC1040b = this.f49488g;
            if (interfaceC1040b != null) {
                interfaceC1040b.onAnimationEnd();
            }
        }
    }

    /* renamed from: d.b.h0.h.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1040b {
        void onAnimationEnd();
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker = this.f49480b;
        if (marker == null) {
            return;
        }
        marker.setPosition(latLng);
        d.b.h0.a.a1.c.h.c cVar2 = this.f49479a.f43915f;
        cVar2.f43912e = latLng.latitude;
        cVar2.f43913f = latLng.longitude;
        Marker marker2 = this.f49484f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f49478h.booleanValue()) {
            Marker marker3 = this.f49481c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f49483e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f49483e, builder.build());
                this.f49483e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d.b bVar;
        d dVar = this.f49479a;
        if (dVar == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f49479a;
        if (dVar2.o == null || this.f49482d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f49483e);
        this.f49483e.removeView(this.f49482d);
        View a2 = d.b.h0.h.a.f.f.a.a(cVar, this.f49479a);
        this.f49482d = a2;
        this.f49483e.addView(a2, 0);
        this.f49483e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f49480b.getPosition());
        Bitmap bitmap = this.f49480b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f49479a.o.f43919f)) + 0.0d));
        cVar.l.addView(this.f49483e, builder.build());
        this.f49483e.setAlpha(0.0f);
        Marker marker = this.f49484f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f49483e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f49479a.o.f43918e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f49479a.o.f43919f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        d.b.h0.a.a1.c.h.c cVar2 = this.f49479a.f43915f;
        this.f49484f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f43912e, cVar2.f43913f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, long j, InterfaceC1040b interfaceC1040b) {
        ValueAnimator valueAnimator = this.f49485g;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && this.f49480b != null) {
            if (j < 0) {
                j = -j;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new d.b.h0.h.a.f.e.h.a(), this.f49480b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.f49485g = ofObject;
            ofObject.setDuration(j);
            this.f49485g.addUpdateListener(new a(cVar, interfaceC1040b));
            this.f49485g.start();
        }
    }
}
