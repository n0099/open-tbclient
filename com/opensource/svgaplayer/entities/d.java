package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
/* loaded from: classes4.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] mLX = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] mLY;
    public static final /* synthetic */ int[] mLZ;

    static {
        mLX[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        mLX[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        mLX[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        mLX[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        mLY = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        mLY[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        mLY[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        mLY[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        mLZ = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        mLZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        mLZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        mLZ[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
