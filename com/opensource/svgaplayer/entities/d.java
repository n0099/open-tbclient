package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
@kotlin.e
/* loaded from: classes18.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] pzV = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] pzW;
    public static final /* synthetic */ int[] pzX;

    static {
        pzV[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        pzV[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        pzV[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        pzV[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        pzW = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        pzW[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        pzW[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        pzW[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        pzX = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        pzX[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        pzX[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        pzX[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
