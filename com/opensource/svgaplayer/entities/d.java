package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] nlA;
    public static final /* synthetic */ int[] nlB;
    public static final /* synthetic */ int[] nlz = new int[ShapeEntity.ShapeType.values().length];

    static {
        nlz[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        nlz[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        nlz[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        nlz[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        nlA = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        nlA[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        nlA[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        nlA[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        nlB = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        nlB[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        nlB[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        nlB[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
