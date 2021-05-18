package d.a.k0.p2.b.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f58139e = Pattern.compile(",");

    /* renamed from: a  reason: collision with root package name */
    public final Context f58140a;

    /* renamed from: b  reason: collision with root package name */
    public Point f58141b;

    /* renamed from: c  reason: collision with root package name */
    public Point f58142c;

    /* renamed from: d  reason: collision with root package name */
    public Point f58143d;

    public b(Context context) {
        this.f58140a = context;
    }

    public static boolean a(Camera camera) {
        return d(camera.getParameters().getSupportedFocusModes(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO) != null;
    }

    public static int b(CharSequence charSequence, int i2) {
        int i3 = 0;
        for (String str : f58139e.split(charSequence)) {
            try {
                double parseDouble = Double.parseDouble(str.trim());
                int i4 = (int) (10.0d * parseDouble);
                if (Math.abs(i2 - parseDouble) < Math.abs(i2 - i3)) {
                    i3 = i4;
                }
            } catch (NumberFormatException unused) {
                return i2;
            }
        }
        return i3;
    }

    public static Point c(List<Camera.Size> list, Point point) {
        Iterator<Camera.Size> it = list.iterator();
        int i2 = 0;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            int i5 = next.width;
            int i6 = next.height;
            int abs = Math.abs(i5 - point.x) + Math.abs(i6 - point.y);
            if (abs == 0) {
                i3 = i6;
                i2 = i5;
                break;
            } else if (abs < i4) {
                i3 = i6;
                i2 = i5;
                i4 = abs;
            }
        }
        if (i2 <= 0 || i3 <= 0) {
            return null;
        }
        return new Point(i2, i3);
    }

    public static String d(Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    public static Point g(Camera.Parameters parameters, Point point) {
        Point c2 = c(parameters.getSupportedPreviewSizes(), point);
        return c2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : c2;
    }

    public Point e() {
        return this.f58142c;
    }

    public int f() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        Camera.getCameraInfo(0, cameraInfo);
        int rotation = ((WindowManager) this.f58140a.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i2) + 360) % 360;
    }

    public void h(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        if (a(camera)) {
            parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        }
        this.f58141b = a.d(this.f58140a);
        Point point = new Point();
        Point point2 = this.f58141b;
        point.x = point2.x;
        point.y = point2.y;
        int c2 = a.c(this.f58140a);
        if (c2 == 0) {
            Point point3 = this.f58141b;
            point.x = point3.y;
            point.y = point3.x;
        }
        Point g2 = g(parameters, point);
        this.f58143d = g2;
        if (c2 == 0) {
            Point point4 = this.f58143d;
            this.f58142c = new Point(point4.y, point4.x);
            return;
        }
        this.f58142c = g2;
    }

    public void i(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Point point = this.f58143d;
        parameters.setPreviewSize(point.x, point.y);
        j(parameters);
        camera.setDisplayOrientation(f());
        camera.setParameters(parameters);
    }

    public final void j(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i2 = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i2 = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i2 > parseInt) {
                        i2 = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i2 = b(str4, i2);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i2 -= i2 % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", String.valueOf(i2 / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i2);
            }
        }
    }
}
