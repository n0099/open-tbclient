package com.opensource.svgaplayer.entities;

import android.graphics.Path;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.Set;
import java.util.StringTokenizer;
import kotlin.jvm.internal.p;
import kotlin.text.l;
@kotlin.e
/* loaded from: classes5.dex */
public final class b {
    private final String pPA;
    private Path pPB;

    public b(String str) {
        p.o(str, "originValue");
        this.pPA = l.a((CharSequence) str, (CharSequence) ",", false, 2, (Object) null) ? l.a(str, ",", " ", false, 4, (Object) null) : str;
    }

    public final void a(Path path) {
        Set set;
        p.o(path, "toPath");
        Path path2 = this.pPB;
        if (path2 != null) {
            path.set(path2);
            return;
        }
        Path path3 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.pPA, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            p.n(nextToken, "segment");
            if (!(nextToken.length() == 0)) {
                set = c.pPC;
                if (set.contains(nextToken)) {
                    if (p.l(nextToken, "Z") || p.l(nextToken, "z")) {
                        a(path3, nextToken, new StringTokenizer("", ""));
                    }
                } else {
                    a(path3, str, new StringTokenizer(nextToken, " "));
                    nextToken = str;
                }
                str = nextToken;
            }
        }
        this.pPB = path3;
        path.set(path3);
    }

    private final void a(Path path, String str, StringTokenizer stringTokenizer) {
        float f;
        int i = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (stringTokenizer.hasMoreTokens()) {
            try {
                String nextToken = stringTokenizer.nextToken();
                p.n(nextToken, "s");
                if (!(nextToken.length() == 0)) {
                    if (i == 0) {
                        f7 = Float.parseFloat(nextToken);
                    }
                    if (i == 1) {
                        f6 = Float.parseFloat(nextToken);
                    }
                    if (i == 2) {
                        f5 = Float.parseFloat(nextToken);
                    }
                    if (i == 3) {
                        f4 = Float.parseFloat(nextToken);
                    }
                    if (i == 4) {
                        f3 = Float.parseFloat(nextToken);
                    }
                    if (i == 5) {
                        f2 = Float.parseFloat(nextToken);
                    }
                    i++;
                }
            } catch (Exception e) {
                f = f7;
            }
        }
        f = f7;
        com.opensource.svgaplayer.b.a aVar = new com.opensource.svgaplayer.b.a(0.0f, 0.0f, 0.0f);
        if (p.l(str, "M")) {
            path.moveTo(f, f6);
            aVar = new com.opensource.svgaplayer.b.a(f, f6, 0.0f);
        } else if (p.l(str, "m")) {
            path.rMoveTo(f, f6);
            aVar = new com.opensource.svgaplayer.b.a(aVar.getX() + f, aVar.getY() + f6, 0.0f);
        }
        if (p.l(str, "L")) {
            path.lineTo(f, f6);
        } else if (p.l(str, "l")) {
            path.rLineTo(f, f6);
        }
        if (p.l(str, "C")) {
            path.cubicTo(f, f6, f5, f4, f3, f2);
        } else if (p.l(str, "c")) {
            path.rCubicTo(f, f6, f5, f4, f3, f2);
        }
        if (p.l(str, "Q")) {
            path.quadTo(f, f6, f5, f4);
        } else if (p.l(str, IXAdRequestInfo.COST_NAME)) {
            path.rQuadTo(f, f6, f5, f4);
        }
        if (p.l(str, "H")) {
            path.lineTo(f, aVar.getY());
        } else if (p.l(str, "h")) {
            path.rLineTo(f, 0.0f);
        }
        if (p.l(str, "V")) {
            path.lineTo(aVar.getX(), f);
        } else if (p.l(str, "v")) {
            path.rLineTo(0.0f, f);
        }
        if (p.l(str, "Z")) {
            path.close();
        } else if (p.l(str, "z")) {
            path.close();
        }
    }
}
