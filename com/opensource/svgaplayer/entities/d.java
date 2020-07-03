package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] nBX = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] nBY;
    public static final /* synthetic */ int[] nBZ;

    static {
        nBX[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        nBX[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        nBX[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        nBX[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        nBY = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        nBY[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        nBY[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        nBY[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        nBZ = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        nBZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        nBZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        nBZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
