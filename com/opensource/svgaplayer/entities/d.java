package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.ShapeEntity;
@kotlin.e
/* loaded from: classes5.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] pPN = new int[ShapeEntity.ShapeType.values().length];
    public static final /* synthetic */ int[] pPO;
    public static final /* synthetic */ int[] pPP;

    static {
        pPN[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        pPN[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        pPN[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        pPN[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        pPO = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        pPO[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        pPO[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        pPO[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        pPP = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        pPP[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        pPP[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        pPP[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
