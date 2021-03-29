package d.b.i0.o2.b.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.WindowManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f57293e = Pattern.compile(",");

    /* renamed from: a  reason: collision with root package name */
    public final Context f57294a;

    /* renamed from: b  reason: collision with root package name */
    public Point f57295b;

    /* renamed from: c  reason: collision with root package name */
    public Point f57296c;

    /* renamed from: d  reason: collision with root package name */
    public Point f57297d;

    public b(Context context) {
        this.f57294a = context;
    }

    public static boolean a(Camera camera) {
        return d(camera.getParameters().getSupportedFocusModes(), "auto") != null;
    }

    public static int b(CharSequence charSequence, int i) {
        int i2 = 0;
        for (String str : f57293e.split(charSequence)) {
            try {
                double parseDouble = Double.parseDouble(str.trim());
                int i3 = (int) (10.0d * parseDouble);
                if (Math.abs(i - parseDouble) < Math.abs(i - i2)) {
                    i2 = i3;
                }
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i2;
    }

    public static Point c(List<Camera.Size> list, Point point) {
        Iterator<Camera.Size> it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            int i4 = next.width;
            int i5 = next.height;
            int abs = Math.abs(i4 - point.x) + Math.abs(i5 - point.y);
            if (abs == 0) {
                i2 = i5;
                i = i4;
                break;
            } else if (abs < i3) {
                i2 = i5;
                i = i4;
                i3 = abs;
            }
        }
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        return new Point(i, i2);
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
        return this.f57296c;
    }

    public int f() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i = 0;
        Camera.getCameraInfo(0, cameraInfo);
        int rotation = ((WindowManager) this.f57294a.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    public void h(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        if (a(camera)) {
            parameters.setFocusMode("auto");
        }
        this.f57295b = a.d(this.f57294a);
        Point point = new Point();
        Point point2 = this.f57295b;
        point.x = point2.x;
        point.y = point2.y;
        int c2 = a.c(this.f57294a);
        if (c2 == 0) {
            Point point3 = this.f57295b;
            point.x = point3.y;
            point.y = point3.x;
        }
        Point g2 = g(parameters, point);
        this.f57297d = g2;
        if (c2 == 0) {
            Point point4 = this.f57297d;
            this.f57296c = new Point(point4.y, point4.x);
            return;
        }
        this.f57296c = g2;
    }

    public void i(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Point point = this.f57297d;
        parameters.setPreviewSize(point.x, point.y);
        j(parameters);
        camera.setDisplayOrientation(f());
        camera.setParameters(parameters);
    }

    public final void j(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i = b(str4, i);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", String.valueOf(i / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }
}
