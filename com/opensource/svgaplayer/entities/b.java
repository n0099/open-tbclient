package com.opensource.svgaplayer.entities;

import android.graphics.Path;
import android.support.media.ExifInterface;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Set;
import java.util.StringTokenizer;
import kotlin.h;
import kotlin.jvm.internal.q;
import kotlin.text.l;
@h
/* loaded from: classes.dex */
public final class b {
    private final String mKD;
    private Path mKE;

    public b(String str) {
        q.j(str, "originValue");
        this.mKD = l.a((CharSequence) str, (CharSequence) Constants.ACCEPT_TIME_SEPARATOR_SP, false, 2, (Object) null) ? l.a(str, Constants.ACCEPT_TIME_SEPARATOR_SP, " ", false, 4, (Object) null) : str;
    }

    public final void a(Path path) {
        Set set;
        q.j(path, "toPath");
        Path path2 = this.mKE;
        if (path2 != null) {
            path.set(path2);
            return;
        }
        Path path3 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.mKD, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            q.i(nextToken, "segment");
            if (!(nextToken.length() == 0)) {
                set = c.mKF;
                if (set.contains(nextToken)) {
                    if (q.k(nextToken, "Z") || q.k(nextToken, "z")) {
                        a(path3, nextToken, new StringTokenizer("", ""));
                    }
                } else {
                    a(path3, str, new StringTokenizer(nextToken, " "));
                    nextToken = str;
                }
                str = nextToken;
            }
        }
        this.mKE = path3;
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
                q.i(nextToken, "s");
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
        if (q.k(str, "M")) {
            path.moveTo(f, f6);
            aVar = new com.opensource.svgaplayer.b.a(f, f6, 0.0f);
        } else if (q.k(str, "m")) {
            path.rMoveTo(f, f6);
            aVar = new com.opensource.svgaplayer.b.a(aVar.getX() + f, aVar.getY() + f6, 0.0f);
        }
        if (q.k(str, "L")) {
            path.lineTo(f, f6);
        } else if (q.k(str, "l")) {
            path.rLineTo(f, f6);
        }
        if (q.k(str, "C")) {
            path.cubicTo(f, f6, f5, f4, f3, f2);
        } else if (q.k(str, "c")) {
            path.rCubicTo(f, f6, f5, f4, f3, f2);
        }
        if (q.k(str, "Q")) {
            path.quadTo(f, f6, f5, f4);
        } else if (q.k(str, IXAdRequestInfo.COST_NAME)) {
            path.rQuadTo(f, f6, f5, f4);
        }
        if (q.k(str, IEruptionStrategyGroup.STRATEGY_MODIFIER_H)) {
            path.lineTo(f, aVar.getY());
        } else if (q.k(str, "h")) {
            path.rLineTo(f, 0.0f);
        }
        if (q.k(str, ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            path.lineTo(aVar.getX(), f);
        } else if (q.k(str, "v")) {
            path.rLineTo(0.0f, f);
        }
        if (q.k(str, "Z")) {
            path.close();
        } else if (q.k(str, "z")) {
            path.close();
        }
    }
}
