package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes11.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] oeD = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] oeE;
    public static final /* synthetic */ int[] oeF;

    static {
        oeD[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        oeD[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        oeD[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        oeD[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        oeE = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        oeE[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        oeE[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        oeE[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        oeF = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        oeF[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        oeF[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        oeF[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
