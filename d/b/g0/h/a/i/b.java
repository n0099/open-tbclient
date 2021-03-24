package d.b.g0.h.a.i;

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
import d.b.g0.a.a1.c.h.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f48756h = Boolean.TRUE;

    /* renamed from: a  reason: collision with root package name */
    public d f48757a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f48758b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f48759c;

    /* renamed from: d  reason: collision with root package name */
    public View f48760d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f48761e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f48762f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f48763g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f48764e = false;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f48765f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1007b f48766g;

        public a(c cVar, InterfaceC1007b interfaceC1007b) {
            this.f48765f = cVar;
            this.f48766g = interfaceC1007b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            b.this.a(this.f48765f, (LatLng) valueAnimator.getAnimatedValue());
            if (this.f48764e || animatedFraction <= 0.99d) {
                return;
            }
            this.f48764e = true;
            InterfaceC1007b interfaceC1007b = this.f48766g;
            if (interfaceC1007b != null) {
                interfaceC1007b.onAnimationEnd();
            }
        }
    }

    /* renamed from: d.b.g0.h.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1007b {
        void onAnimationEnd();
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker = this.f48758b;
        if (marker == null) {
            return;
        }
        marker.setPosition(latLng);
        d.b.g0.a.a1.c.h.c cVar2 = this.f48757a.f43193f;
        cVar2.f43190e = latLng.latitude;
        cVar2.f43191f = latLng.longitude;
        Marker marker2 = this.f48762f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f48756h.booleanValue()) {
            Marker marker3 = this.f48759c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f48761e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f48761e, builder.build());
                this.f48761e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d.b bVar;
        d dVar = this.f48757a;
        if (dVar == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f48757a;
        if (dVar2.o == null || this.f48760d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f48761e);
        this.f48761e.removeView(this.f48760d);
        View a2 = d.b.g0.h.a.f.f.a.a(cVar, this.f48757a);
        this.f48760d = a2;
        this.f48761e.addView(a2, 0);
        this.f48761e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f48758b.getPosition());
        Bitmap bitmap = this.f48758b.getIcon().getBitmap();
        double height = bitmap.getHeight();
        Double.isNaN(height);
        builder.yOffset((int) ((height * (1.0d - this.f48757a.o.f43197f)) + 0.0d));
        cVar.l.addView(this.f48761e, builder.build());
        this.f48761e.setAlpha(0.0f);
        Marker marker = this.f48762f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f48761e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        double width = (bitmap2.getWidth() - bitmap.getWidth()) / 2.0f;
        double d2 = this.f48757a.o.f43196e;
        double width2 = bitmap.getWidth();
        Double.isNaN(width2);
        Double.isNaN(width);
        double height2 = bitmap2.getHeight();
        Double.isNaN(height2);
        double height3 = bitmap.getHeight();
        Double.isNaN(height3);
        double d3 = (float) ((height2 - 0.0d) - height3);
        double d4 = this.f48757a.o.f43197f;
        double height4 = bitmap.getHeight();
        Double.isNaN(height4);
        Double.isNaN(d3);
        MarkerOptions markerOptions = new MarkerOptions();
        d.b.g0.a.a1.c.h.c cVar2 = this.f48757a.f43193f;
        this.f48762f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f43190e, cVar2.f43191f)).icon(fromView).zIndex(66).anchor(((float) (width + (d2 * width2))) / bitmap2.getWidth(), ((float) (d3 + (d4 * height4))) / fromView.getBitmap().getHeight()));
    }

    public void c(c cVar, LatLng latLng, long j, InterfaceC1007b interfaceC1007b) {
        ValueAnimator valueAnimator = this.f48763g;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && this.f48758b != null) {
            if (j < 0) {
                j = -j;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new d.b.g0.h.a.f.e.h.a(), this.f48758b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.f48763g = ofObject;
            ofObject.setDuration(j);
            this.f48763g.addUpdateListener(new a(cVar, interfaceC1007b));
            this.f48763g.start();
        }
    }
}
