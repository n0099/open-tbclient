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
    public static final Boolean f48757h = Boolean.TRUE;

    /* renamed from: a  reason: collision with root package name */
    public d f48758a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f48759b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f48760c;

    /* renamed from: d  reason: collision with root package name */
    public View f48761d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f48762e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f48763f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f48764g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f48765e = false;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f48766f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1008b f48767g;

        public a(c cVar, InterfaceC1008b interfaceC1008b) {
            this.f48766f = cVar;
            this.f48767g = interfaceC1008b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            b.this.a(this.f48766f, (LatLng) valueAnimator.getAnimatedValue());
            if (this.f48765e || animatedFraction <= 0.99d) {
                return;
            }
            this.f48765e = true;
            InterfaceC1008b interfaceC1008b = this.f48767g;
            if (interfaceC1008b != null) {
                interfaceC1008b.onAnimationEnd();
            }
        }
    }

    /* renamed from: d.b.g0.h.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1008b {
        void onAnimationEnd();
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker = this.f48759b;
        if (marker == null) {
            return;
        }
        marker.setPosition(latLng);
        d.b.g0.a.a1.c.h.c cVar2 = this.f48758a.f43194f;
        cVar2.f43191e = latLng.latitude;
        cVar2.f43192f = latLng.longitude;
        Marker marker2 = this.f48763f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f48757h.booleanValue()) {
            Marker marker3 = this.f48760c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f48762e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f48762e, builder.build());
                this.f48762e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d.b bVar;
        d dVar = this.f48758a;
        if (dVar == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f48758a;
        if (dVar2.o == null || this.f48761d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f48762e);
        this.f48762e.removeView(this.f48761d);
        View a2 = d.b.g0.h.a.f.f.a.a(cVar, this.f48758a);
        this.f48761d = a2;
        this.f48762e.addView(a2, 0);
        this.f48762e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f48759b.getPosition());
        Bitmap bitmap = this.f48759b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f48758a.o.f43198f)) + 0.0d));
        cVar.l.addView(this.f48762e, builder.build());
        this.f48762e.setAlpha(0.0f);
        Marker marker = this.f48763f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f48762e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f48758a.o.f43197e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f48758a.o.f43198f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        d.b.g0.a.a1.c.h.c cVar2 = this.f48758a.f43194f;
        this.f48763f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f43191e, cVar2.f43192f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, long j, InterfaceC1008b interfaceC1008b) {
        ValueAnimator valueAnimator = this.f48764g;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && this.f48759b != null) {
            if (j < 0) {
                j = -j;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new d.b.g0.h.a.f.e.h.a(), this.f48759b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.f48764g = ofObject;
            ofObject.setDuration(j);
            this.f48764g.addUpdateListener(new a(cVar, interfaceC1008b));
            this.f48764g.start();
        }
    }
}
