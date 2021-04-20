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
    public static final Boolean f49149h = Boolean.TRUE;

    /* renamed from: a  reason: collision with root package name */
    public d f49150a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f49151b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f49152c;

    /* renamed from: d  reason: collision with root package name */
    public View f49153d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f49154e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f49155f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f49156g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f49157e = false;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f49158f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1020b f49159g;

        public a(c cVar, InterfaceC1020b interfaceC1020b) {
            this.f49158f = cVar;
            this.f49159g = interfaceC1020b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            b.this.a(this.f49158f, (LatLng) valueAnimator.getAnimatedValue());
            if (this.f49157e || animatedFraction <= 0.99d) {
                return;
            }
            this.f49157e = true;
            InterfaceC1020b interfaceC1020b = this.f49159g;
            if (interfaceC1020b != null) {
                interfaceC1020b.onAnimationEnd();
            }
        }
    }

    /* renamed from: d.b.g0.h.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1020b {
        void onAnimationEnd();
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker = this.f49151b;
        if (marker == null) {
            return;
        }
        marker.setPosition(latLng);
        d.b.g0.a.a1.c.h.c cVar2 = this.f49150a.f43586f;
        cVar2.f43583e = latLng.latitude;
        cVar2.f43584f = latLng.longitude;
        Marker marker2 = this.f49155f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f49149h.booleanValue()) {
            Marker marker3 = this.f49152c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f49154e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f49154e, builder.build());
                this.f49154e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d.b bVar;
        d dVar = this.f49150a;
        if (dVar == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f49150a;
        if (dVar2.o == null || this.f49153d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f49154e);
        this.f49154e.removeView(this.f49153d);
        View a2 = d.b.g0.h.a.f.f.a.a(cVar, this.f49150a);
        this.f49153d = a2;
        this.f49154e.addView(a2, 0);
        this.f49154e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f49151b.getPosition());
        Bitmap bitmap = this.f49151b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f49150a.o.f43590f)) + 0.0d));
        cVar.l.addView(this.f49154e, builder.build());
        this.f49154e.setAlpha(0.0f);
        Marker marker = this.f49155f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f49154e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f49150a.o.f43589e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f49150a.o.f43590f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        d.b.g0.a.a1.c.h.c cVar2 = this.f49150a.f43586f;
        this.f49155f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f43583e, cVar2.f43584f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, long j, InterfaceC1020b interfaceC1020b) {
        ValueAnimator valueAnimator = this.f49156g;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && this.f49151b != null) {
            if (j < 0) {
                j = -j;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new d.b.g0.h.a.f.e.h.a(), this.f49151b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.f49156g = ofObject;
            ofObject.setDuration(j);
            this.f49156g.addUpdateListener(new a(cVar, interfaceC1020b));
            this.f49156g.start();
        }
    }
}
