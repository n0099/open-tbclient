package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
@kotlin.e
/* loaded from: classes6.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] pSE = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] pSF;
    public static final /* synthetic */ int[] pSG;

    static {
        pSE[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        pSE[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        pSE[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        pSE[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        pSF = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        pSF[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        pSF[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        pSF[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        pSG = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        pSG[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        pSG[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        pSG[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
