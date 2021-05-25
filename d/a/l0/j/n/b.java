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
    public static final Boolean f47880h = Boolean.TRUE;

    /* renamed from: a  reason: collision with root package name */
    public d f47881a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f47882b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f47883c;

    /* renamed from: d  reason: collision with root package name */
    public View f47884d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f47885e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f47886f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f47887g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f47888e = false;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f47889f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1069b f47890g;

        public a(c cVar, InterfaceC1069b interfaceC1069b) {
            this.f47889f = cVar;
            this.f47890g = interfaceC1069b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            b.this.a(this.f47889f, (LatLng) valueAnimator.getAnimatedValue());
            if (this.f47888e || animatedFraction <= 0.99d) {
                return;
            }
            this.f47888e = true;
            InterfaceC1069b interfaceC1069b = this.f47890g;
            if (interfaceC1069b != null) {
                interfaceC1069b.onAnimationEnd();
            }
        }
    }

    /* renamed from: d.a.l0.j.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1069b {
        void onAnimationEnd();
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker = this.f47882b;
        if (marker == null) {
            return;
        }
        marker.setPosition(latLng);
        d.a.l0.a.h1.c.h.c cVar2 = this.f47881a.f42676f;
        cVar2.f42673e = latLng.latitude;
        cVar2.f42674f = latLng.longitude;
        Marker marker2 = this.f47886f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f47880h.booleanValue()) {
            Marker marker3 = this.f47883c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f47885e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f47885e, builder.build());
                this.f47885e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d.b bVar;
        d dVar = this.f47881a;
        if (dVar == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f47881a;
        if (dVar2.o == null || this.f47884d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f47885e);
        this.f47885e.removeView(this.f47884d);
        View a2 = d.a.l0.j.k.f.a.a(cVar, this.f47881a);
        this.f47884d = a2;
        this.f47885e.addView(a2, 0);
        this.f47885e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f47882b.getPosition());
        Bitmap bitmap = this.f47882b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f47881a.o.f42681f)) + 0.0d));
        cVar.l.addView(this.f47885e, builder.build());
        this.f47885e.setAlpha(0.0f);
        Marker marker = this.f47886f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f47885e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f47881a.o.f42680e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f47881a.o.f42681f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        d.a.l0.a.h1.c.h.c cVar2 = this.f47881a.f42676f;
        this.f47886f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f42673e, cVar2.f42674f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, f fVar, InterfaceC1069b interfaceC1069b) {
        Marker marker;
        ValueAnimator valueAnimator = this.f47887g;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && (marker = this.f47882b) != null) {
            float f2 = 360.0f - ((float) fVar.F);
            if (f2 >= 0.0f && f2 <= 360.0f) {
                marker.setRotate(f2);
            }
            int i2 = fVar.G;
            if (i2 < 0) {
                i2 = -i2;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new d.a.l0.j.k.e.h.a(), this.f47882b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.f47887g = ofObject;
            ofObject.setDuration(i2);
            this.f47887g.addUpdateListener(new a(cVar, interfaceC1069b));
            this.f47887g.start();
        }
    }
}
