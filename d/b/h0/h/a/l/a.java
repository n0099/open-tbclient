package d.b.h0.h.a.l;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.tieba.R;
import d.b.h0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends c {
    public static final boolean i = k.f45772a;
    public static final int j = Color.argb(178, 0, 78, 255);

    /* renamed from: h  reason: collision with root package name */
    public DrivingRouteLine f49560h;

    public a(BaiduMap baiduMap) {
        super(baiduMap);
        this.f49560h = null;
    }

    @Override // d.b.h0.h.a.l.c
    public final List<OverlayOptions> b() {
        if (this.f49560h == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<DrivingRouteLine.DrivingStep> allStep = this.f49560h.getAllStep();
        if (allStep != null && allStep.size() > 0) {
            for (DrivingRouteLine.DrivingStep drivingStep : allStep) {
                Bundle bundle = new Bundle();
                bundle.putInt("index", allStep.indexOf(drivingStep));
                if (drivingStep.getEntrance() != null) {
                    arrayList.add(new MarkerOptions().position(drivingStep.getEntrance().getLocation()).anchor(0.5f, 0.5f).zIndex(10).rotate(360 - drivingStep.getDirection()).extraInfo(bundle).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_icon_line_node)));
                }
                if (allStep.indexOf(drivingStep) == allStep.size() - 1 && drivingStep.getExit() != null) {
                    arrayList.add(new MarkerOptions().position(drivingStep.getExit().getLocation()).anchor(0.5f, 0.5f).zIndex(10).icon(BitmapDescriptorFactory.fromResource(R.drawable.aiapps_icon_line_node)));
                }
            }
        }
        if (allStep != null && allStep.size() > 0) {
            int size = allStep.size();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                List<LatLng> wayPoints = allStep.get(i2).getWayPoints();
                if (i2 == size - 1) {
                    arrayList2.addAll(wayPoints);
                } else {
                    arrayList2.addAll(wayPoints.subList(0, wayPoints.size() - 1));
                }
                wayPoints.size();
                int[] trafficList = allStep.get(i2).getTrafficList();
                if (trafficList != null && trafficList.length > 0) {
                    for (int i3 : trafficList) {
                        arrayList3.add(Integer.valueOf(i3));
                    }
                }
            }
            boolean z = arrayList3.size() > 0;
            PolylineOptions zIndex = new PolylineOptions().points(arrayList2).textureIndex(arrayList3).width(14).dottedLine(z).focus(true).color(f() != 0 ? f() : j).zIndex(0);
            if (z) {
                zIndex.customTextureList(e());
            }
            arrayList.add(zIndex);
        }
        return arrayList;
    }

    public List<BitmapDescriptor> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_blue_arrow.png"));
        arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_green_arrow.png"));
        arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_yellow_arrow.png"));
        arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_red_arrow.png"));
        arrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_nofocus.png"));
        return arrayList;
    }

    public abstract int f();

    public boolean g(int i2) {
        if (this.f49560h.getAllStep() == null || this.f49560h.getAllStep().get(i2) == null || !i) {
            return false;
        }
        Log.i("baidumapsdk", "DrivingRouteOverlay onRouteNodeClick");
        return false;
    }

    public void h(DrivingRouteLine drivingRouteLine) {
        this.f49560h = drivingRouteLine;
    }

    public void i(boolean z) {
        for (Overlay overlay : this.f49563g) {
            if (overlay instanceof Polyline) {
                ((Polyline) overlay).setFocus(z);
                return;
            }
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public final boolean onMarkerClick(Marker marker) {
        for (Overlay overlay : this.f49563g) {
            if ((overlay instanceof Marker) && overlay.equals(marker) && marker.getExtraInfo() != null) {
                g(marker.getExtraInfo().getInt("index"));
            }
        }
        return true;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnPolylineClickListener
    public boolean onPolylineClick(Polyline polyline) {
        boolean z;
        Iterator<Overlay> it = this.f49563g.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Overlay next = it.next();
            if ((next instanceof Polyline) && next.equals(polyline)) {
                z = true;
                break;
            }
        }
        i(z);
        return true;
    }
}
