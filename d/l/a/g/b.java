package d.l.a.g;

import android.graphics.Path;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Set;
import java.util.StringTokenizer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f66251a;

    /* renamed from: b  reason: collision with root package name */
    public Path f66252b;

    public b(String str) {
        this.f66251a = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ",", false, 2, (Object) null) ? StringsKt__StringsJVMKt.replace$default(str, ",", " ", false, 4, (Object) null) : str;
    }

    public final void a(Path path) {
        Set set;
        Path path2 = this.f66252b;
        if (path2 != null) {
            path.set(path2);
            return;
        }
        Path path3 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.f66251a, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String segment = stringTokenizer.nextToken();
            Intrinsics.checkExpressionValueIsNotNull(segment, "segment");
            if (!(segment.length() == 0)) {
                set = c.f66253a;
                if (set.contains(segment)) {
                    if (Intrinsics.areEqual(segment, "Z") || Intrinsics.areEqual(segment, "z")) {
                        b(path3, segment, new StringTokenizer("", ""));
                    }
                    str = segment;
                } else {
                    b(path3, str, new StringTokenizer(segment, " "));
                }
            }
        }
        this.f66252b = path3;
        path.set(path3);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Path path, String str, StringTokenizer stringTokenizer) {
        d.l.a.h.a aVar;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            try {
                String s = stringTokenizer.nextToken();
                Intrinsics.checkExpressionValueIsNotNull(s, "s");
                if (!(s.length() == 0)) {
                    if (i == 0) {
                        f2 = Float.parseFloat(s);
                    }
                    if (i == 1) {
                        f3 = Float.parseFloat(s);
                    }
                    if (i == 2) {
                        f4 = Float.parseFloat(s);
                    }
                    if (i == 3) {
                        f5 = Float.parseFloat(s);
                    }
                    if (i == 4) {
                        f6 = Float.parseFloat(s);
                    }
                    if (i == 5) {
                        f7 = Float.parseFloat(s);
                    }
                    i++;
                }
            } catch (Exception unused) {
            }
        }
        float f8 = f2;
        float f9 = f3;
        float f10 = f4;
        float f11 = f5;
        d.l.a.h.a aVar2 = new d.l.a.h.a(0.0f, 0.0f, 0.0f);
        if (Intrinsics.areEqual(str, "M")) {
            path.moveTo(f8, f9);
            aVar2 = new d.l.a.h.a(f8, f9, 0.0f);
        } else if (Intrinsics.areEqual(str, "m")) {
            path.rMoveTo(f8, f9);
            aVar = new d.l.a.h.a(aVar2.a() + f8, aVar2.b() + f9, 0.0f);
            if (!Intrinsics.areEqual(str, "L")) {
                path.lineTo(f8, f9);
            } else if (Intrinsics.areEqual(str, "l")) {
                path.rLineTo(f8, f9);
            }
            if (!Intrinsics.areEqual(str, "C")) {
                path.cubicTo(f8, f9, f10, f11, f6, f7);
            } else if (Intrinsics.areEqual(str, "c")) {
                path.rCubicTo(f8, f9, f10, f11, f6, f7);
            }
            if (!Intrinsics.areEqual(str, "Q")) {
                path.quadTo(f8, f9, f10, f11);
            } else if (Intrinsics.areEqual(str, IXAdRequestInfo.COST_NAME)) {
                path.rQuadTo(f8, f9, f10, f11);
            }
            if (!Intrinsics.areEqual(str, "H")) {
                path.lineTo(f8, aVar.b());
            } else if (Intrinsics.areEqual(str, "h")) {
                path.rLineTo(f8, 0.0f);
            }
            if (!Intrinsics.areEqual(str, ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                path.lineTo(aVar.a(), f8);
            } else if (Intrinsics.areEqual(str, "v")) {
                path.rLineTo(0.0f, f8);
            }
            if (!Intrinsics.areEqual(str, "Z")) {
                path.close();
                return;
            } else if (Intrinsics.areEqual(str, "z")) {
                path.close();
                return;
            } else {
                return;
            }
        }
        aVar = aVar2;
        if (!Intrinsics.areEqual(str, "L")) {
        }
        if (!Intrinsics.areEqual(str, "C")) {
        }
        if (!Intrinsics.areEqual(str, "Q")) {
        }
        if (!Intrinsics.areEqual(str, "H")) {
        }
        if (!Intrinsics.areEqual(str, ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
        }
        if (!Intrinsics.areEqual(str, "Z")) {
        }
    }
}
