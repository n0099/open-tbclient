package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
@kotlin.e
/* loaded from: classes18.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] pzX = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] pzY;
    public static final /* synthetic */ int[] pzZ;

    static {
        pzX[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        pzX[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        pzX[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        pzX[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        pzY = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        pzY[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        pzY[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        pzY[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        pzZ = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        pzZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        pzZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        pzZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
